[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=googleapis_gapic-generator-java&metric=coverage)](https://sonarcloud.io/summary/new_code?id=googleapis_gapic-generator-java)
# API Client Generator for Java

Generates a Java client library from protocol buffers. 
Replaces the Java parts of the 
[older monolithic generator](https://github.com/googleapis/gapic-generator).

See [DEVELOPMENT.md](DEVELOPMENT.md) for setting up development environment.

## service_config.proto

We use the `src/main/proto/service_config.proto` file to generate corresponding
Java class files.
They are needed to generate client libraries for gRPC-based Google services.

The source of `src/main/proto/service_config.proto` is the
[https://github.com/grpc/grpc-proto repository](
https://github.com/grpc/grpc-proto/blob/master/grpc/service_config/service_config.proto).
We copy the file from the repository when a new enhancement is made in the file
and the service team asks us to incorporate the enhancement into the code
generator.
