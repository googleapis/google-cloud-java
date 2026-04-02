Code under `cab-token-generator/java/com/google/auth/credentialaccessboundary/protobuf` are generated manually.
To re-generate, follow steps below:

Determine the protoc version to use for generate, this guide will use v33.2 as example.
Steps to generate the java code using protoc 33.2.
1. Download these files from https://github.com/protocolbuffers/protobuf/releases/tag/v33.2
```
src/google/protobuf/duration.proto
src/google/protobuf/struct.proto
src/google/protobuf/timestamp.proto
```
2. Create a workspace in g3, copy the above files in `google/protobuf` directory.
3. Run the following command to generate java code:
```sh
# in google3 directory
~/.local/bin/protoc --java_out ~/Downloads/java-output -I. cloud/identity/unifiedauth/proto/client_side_access_boundary.proto
```
