.PHONY: protos
protos:
	rm -rf mobile/app/src/main/java/com/brophy/protocol
	rm -rf server/pb
	mkdir -p mobile/app/src/main/java/com/brophy/protocol
	mkdir -p server/pb
	docker run --rm -v ${PWD}:${PWD} -w ${PWD} rvolosatovs/protoc:latest --proto_path=${PWD}/protos \
		--java_out=${PWD}/mobile/app/src/main/java --grpc-java_out=${PWD}/mobile/app/src/main/java \
		--go_out=paths=source_relative:${PWD}/server/pb --go-grpc_out=paths=source_relative:${PWD}/server/pb \
		${PWD}/protos/*.proto
	