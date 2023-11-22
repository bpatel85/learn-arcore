.PHONY: protos
protos:
	docker run --rm -u $(id -u) -v${PWD}:${PWD} -w${PWD} rvolosatovs/protoc:latest --proto_path=${PWD}/protos --java_out=${PWD}/packages/java --go_out=${PWD}/packages/go -I/usr/include/github.com/gogo/protobuf ${PWD}/protos/game.proto

	
	