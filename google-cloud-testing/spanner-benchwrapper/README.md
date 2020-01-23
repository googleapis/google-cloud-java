# spanner-benchwrapper

spanner-benchwrapper is a gRPC wrapper around the spanner library for benchmarking purposes.

## Running

```
mvn clean install -DskipTests=true (one time)
cd google-cloud-testing/spanner-benchwrapper
export SPANNER_EMULATOR_HOST=localhost:8080
mvn clean install exec:java -DskipTests=true -Dport=8081
```

## Generating .proto sources

Sources are generated as part of the protobuf-maven-plugin plugin, but if you'd
like to generate them yourself to see the output you can run:

```
cd google-cloud-testing/spanner-benchwrapper
protoc \
    --plugin=protoc-gen-grpc-java=build/exe/java_plugin/protoc-gen-grpc-java \
    --java_out=src/main/java \
    --grpc-java_out=src/main/java \
    --proto_path=src/main/proto \
    src/main/proto/*.proto
```

Note that you'll need to delete these, or uncomment the plugin, since multiple
definitions of the same class are not allowed.

These should not be committed into git.

You can also `mvn compile -DskipTests=true` and see sources in
`target/generated-sources/`.

## Debugging HTTP requests

To debug HTTP requests, create `google-cloud-testing/spanner-benchwrapper/logging.properties` with the following contents:

```
# Properties file which configures the operation of the JDK logging facility.
# The system will look for this config file to be specified as a system property:
# -Djava.util.logging.config.file=${project_loc:googleplus-simple-cmdline-sample}/logging.properties

# Set up the console handler (uncomment "level" to show more fine-grained messages)
handlers = java.util.logging.ConsoleHandler
java.util.logging.ConsoleHandler.level = CONFIG

# Set up logging of HTTP requests and responses (uncomment "level" to show)
com.google.api.client.http.level = CONFIG
```

Then, when running the application, add the following flag: `-Djava.util.logging.config.file=logging.properties`.
