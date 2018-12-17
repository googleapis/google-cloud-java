To generate libraries from the .proto:
$ export OUTPUT_FILE= {your-directory}/grpc-gcp/src/main/java
$ mkdir -p $OUTPUT_FILE
$ cd ~/Documents/jenny/grpc-gcp/src/proto/google
$ protoc -I=. --java_out=$OUTPUT_FILE grpc_gcp.proto