# Goldens Files For Integration Test

This folder contains goldens files that are expected to be generated from Java Microgenerator
against different APIs. For example `redis` folder has all the Java source files in the generated
Redis client library. They are all actual Java files, but used as goldens.

## Purpose

When running integration test for the Java Microgenerator using the below command,
the goldens files in this folder will be used to compare with the actual generated Java source
files.
If they are not identical, then the integration test will fail.

```sh
bazelisk test //test/integration:redis
```

## How To Update Goldens

If the actual generated Java source files are not identical with the goldens files, and we want to
update the goldens using source files. Run the command below to overwrite the goldens files
in `redis` folder.

```sh
# In repository's root directory
mvn clean install -DskipTests
bazelisk run //test/integration:update_redis
```

## Adding new integration tests

If you are adding a new API for integration testing, be sure to add it in the `BUILD.bazel` under
the `Integration Test Rules` and add the `java_gapic_test` rules for the new API under
the `API Library Rules` section.

You need to manually create a new directory for your new API under the `test/integration/goldens`
with the same name you've used for the `Integration Test Rules`. Then when you run the command to
update goldens (above), it will automatically create the goldens needed.
