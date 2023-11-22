FROM ubuntu:23.04

# Install Tools
RUN apt-get update && apt-get install -y software-properties-common && add-apt-repository ppa:longsleep/golang-backports
RUN apt-get update && apt-get install -y \
  git \
  curl wget unzip \
  golang-go \
  jq gawk \
  npm

RUN curl -L https://github.com/google/protobuf/releases/download/v3.19.5/protoc-3.19.5-linux-$(uname -m | sed 's/aarch64/aarch_64/').zip -o protoc.zip \
 && unzip -o protoc.zip -d /usr \
 && rm protoc.zip

ENV GOPATH=/go
ENV PATH=/go/bin:$PATH

ENV GO111MODULE=on
ENV GOPRIVATE=github.com

RUN go version

RUN go install google.golang.org/protobuf/cmd/protoc-gen-go@v1.28.1
RUN go install google.golang.org/grpc/cmd/protoc-gen-go-grpc@v1.2.0

# Setup codegen folders
RUN mkdir -p /tmp/go
RUN mkdir -p /packages/go
RUN mkdir -p /packages/java

# Copy protos into the container
RUN mkdir -p /base
WORKDIR /base
COPY . /base
RUN rm -rf /base/packages

# Golang
RUN for file in /base/**/*.proto; do protoc -I /base --go-grpc_out=paths=source_relative:/tmp/go --go_out=paths=source_relative:/tmp/go $file; done
RUN for file in /base/**/**/*.proto; do protoc -I /base --go-grpc_out=paths=source_relative:/tmp/go --go_out=paths=source_relative:/tmp/go $file; done
RUN mv /tmp/go/* /packages/go
RUN gofmt -s -w /packages/go/*/*.go
RUN gofmt -s -w /packages/go/*/*/*.go

# Java