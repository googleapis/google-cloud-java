#### To generate SingerProto.java and descriptors.pb file from singer.proto using `protoc`
```shell
cd google-cloud-spanner/src/test/resources/com/google/cloud/spanner
protoc --proto_path=. --include_imports --descriptor_set_out=descriptors.pb --java_out=. singer.proto
```
