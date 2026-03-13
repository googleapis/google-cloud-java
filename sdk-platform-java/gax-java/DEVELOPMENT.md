# Development of gax-java

## Building

To build GAX:

```sh
# Go to the repository root
cd gapic-generator-java

# Install dependency modules to local Maven repository. Note that
# gapic-generator-java module is not a dependency of gax-java
mvn -pl '!gapic-generator-java,!gax-java' install -DskipTests

# Build and install gax-java
mvn clean install -f gax-java
```

## How to see the effect of GAX change in code generation by gapic-generator-java

To see the effect of GAX changes in local gapic-generator-java invocation, see
"Running the Plugin under googleapis with local gapic-generator-java" in
[gapic-generator-java/DEVELOPMENT.md](../gapic-generator-java/DEVELOPMENT.md)
