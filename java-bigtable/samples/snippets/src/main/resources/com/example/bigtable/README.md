#### To generate SingerProto.java and descriptors.pb file from singer.proto using `protoc`
```shell
cd samples/snippets/src/main/resources/
protoc --proto_path=com/example/bigtable/ --include_imports --descriptor_set_out=com/example/bigtable/descriptors.pb \
--java_out=. com/example/bigtable/singer.proto
```
