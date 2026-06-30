#### To generate SingerProto.java and descriptors.pb file from singer.proto using `protoc`
```shell
cd samples/snippets/src/main/resources/
protoc --proto_path=com/example/spanner/jdbc/ \
  --include_imports --descriptor_set_out=com/example/spanner/jdbc/descriptors.pb \
  --java_out=../java com/example/spanner/jdbc/singer.proto
```
