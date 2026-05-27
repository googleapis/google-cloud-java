# Development Setup

You need Java 11 or higher to run the build. The build produces Java 8-compatible
bytecode.

Install [`bazelisk`](https://github.com/bazelbuild/bazelisk) in your `PATH`
for gapic-generator-java's Bazel build.

## Set Up

1. Clone this repo.

2. (OPTIONAL) Copy the Git pre-commit hooks. This will automatically check the build, run
   tests, and perform linting before each commit. (Symlinks don't seem to work,
   but if you find a way, please add it here!)

    ```sh
    cp .githooks/pre-commit .git/hooks/pre-commit
    ```

## Run Tests for All Modules

- Run all unit tests in all modules.

    ```sh
    mvn install
    ```

## Code Formatting

- Run linter checks without actually doing the formatting.

    ```sh
    mvn fmt:check
    ```

- Format files.

    ```sh
    mvn fmt:format
    ```

## Testing guide
There are 4 layers of testing in this repo:
1. Traditional unit tests. These tests usually focus on testing one very specific test case at a time. For example, [MethodTest](https://github.com/googleapis/google-cloud-java/blob/main/sdk-platform-java/gapic-generator-java/src/test/java/com/google/api/generator/gapic/model/MethodTest.java) 
2. Golden unit tests. These tests start with a test proto, we create different test cases in the proto, load the proto in unit tests and save the generated file as golden files. For example, [routing header proto](https://github.com/googleapis/google-cloud-java/blob/main/sdk-platform-java/gapic-generator-java/src/test/proto/explicit_dynamic_routing_header_testing.proto) -> Load in the [unit test](https://github.com/googleapis/google-cloud-java/blob/main/sdk-platform-java/gapic-generator-java/src/test/java/com/google/api/generator/gapic/composer/grpc/GrpcServiceStubClassComposerTest.java#L56-L64) -> Saved as [golden](https://github.com/googleapis/google-cloud-java/blob/main/sdk-platform-java/gapic-generator-java/src/test/java/com/google/api/generator/gapic/composer/grpc/goldens/GrpcRoutingHeadersStub.golden)    
3. Showcase integration tests. They test the generated library's behavior against a mock server, see [README.md](https://github.com/googleapis/google-cloud-java/blob/main/sdk-platform-java/java-showcase/README.md) of showcase module for details.
4. Golden integration tests. These tests generate a full client library with real protos from googleapis, for example, golden integration tests for [compute](https://github.com/googleapis/sdk-platform-java/tree/main/test/integration/goldens/compute). However, we _should_ stop adding new ones, and rely on golden unit tests and showcase tests.

Based on where the code changes are, we should add different tests, in general

- If the changes are in `gax` or `api-common` only, you _must_ add traditional unit tests, you _may_ add showcase integration tests if you are modifying a public setting.
- If the changes are in `gapic-generator-java` only, showcase integration tests are most likely not needed
  - If they are in the `composer` module, you _must_ add golden unit tests, you _may_ add traditional unit tests for better coverage and easier testing.  
  - If they are in the `parser` module, you _should_ add traditional unit tests with a test proto if possible, you _may_ add golden unit tests to easily see the changes. For example, [routing_rule_parser_testing](https://github.com/googleapis/google-cloud-java/blob/main/sdk-platform-java/gapic-generator-java/src/test/proto/routing_rule_parser_testing.proto) that is only used for testing [RoutingRuleParser](https://github.com/googleapis/google-cloud-java/blob/main/sdk-platform-java/gapic-generator-java/src/main/java/com/google/api/generator/gapic/protoparser/RoutingRuleParser.java). 
  - If they are in `other modules(ast, model, writer etc.)`, you _must_ add traditional unit tests, you _may_ add golden unit tests to easily see the changes.
- If the changes are in both `gax` and `gapic-generator-java`, you _must_ add all test layers, including traditional unit tests, golden unit tests and showcase integration tests. 

### How to run tests?

See the [Unit Tests](https://github.com/googleapis/google-cloud-java/blob/main/sdk-platform-java/gapic-generator-java/DEVELOPMENT.md#unit-tests) section in gapic-generator-java/DEVELOPMENT.md for how to run traditional and golden unit tests.

See [Running the Integration Tests](https://github.com/googleapis/google-cloud-java/blob/main/sdk-platform-java/java-showcase/README.md#running-the-integration-tests) and [Update the Golden Showcase Files](https://github.com/googleapis/google-cloud-java/blob/main/sdk-platform-java/java-showcase/README.md#update-the-golden-showcase-files) sections in java-showcase/README.md for how to run and update showcase integration tests.

See the [Integration Tests](https://github.com/googleapis/google-cloud-java/blob/main/sdk-platform-java/gapic-generator-java/DEVELOPMENT.md#integration-tests) section in gapic-generator-java/DEVELOPMENT.md for how to run golden integration tests.

## Client Library Generation (Librarian)

Librarian is a tool for managing client library configuration and generation. The configuration is stored in `librarian.yaml` at the root of the repository.

### Contact and Support
*   **On-Call Schedule:** You can check the current on-call rotation at `go/librarian-oncall` or by checking the rotation schedule at [Librarian Rotations](https://rotations.corp.google.com/rotation/6013581851623424).
*   **Email:** Reach out to `cloud-sdk-librarian-oncall@google.com`.

### Review Requirement for `librarian.yaml`
Any changes to `librarian.yaml` (adding APIs, updating dependencies, changing configurations, etc.) **must** be reviewed and approved by the Librarian on-call team. Please include `cloud-sdk-librarian-oncall@google.com` or an on-call engineer as a reviewer on your PR.

#### Prerequisite
Make sure you have Go installed (as Librarian is written in Go), as well as Python, Maven, and JDK 17 (use https://sdkman.io/).

#### Running the Generator with Local Changes
If you want to test changes to the generator (`gapic-generator-java`) or local changes to `librarian.yaml` (e.g., testing a protobuf major version bump or unmerged generator change):

1.  **Modify `librarian.yaml` to point to the new version.**
    - If you want to point to an experimental version of the generator, you can update `local_path` to the local path you want to test.
    - If you want to bump the protoc-gen-java_grpc, you can change its `version` property.
2.  **Ensure local tools path is in your PATH:**
    Librarian installs wrapper scripts into `$HOME/java_tools/bin` by default. You should add this directory to your shell's `PATH` environment variable:
    ```sh
    export PATH="$HOME/java_tools/bin:$PATH"
    ```
3.  **Re-install the local tools:**
    Run the following command from the root of the `google-cloud-java` repository to compile your local generator changes and update the wrappers:
    ```sh
    # Retrieve the configured librarian version
    V=$(go run github.com/googleapis/librarian/cmd/librarian@latest config get version)
    # Re-install the local tools
    go run github.com/googleapis/librarian/cmd/librarian@${V} install
    ```
4.  **Regenerate the client library:**
    To regenerate all libraries:
    ```sh
    go run github.com/googleapis/librarian/cmd/librarian@${V} generate --all
    ```
    Or to regenerate a single library (e.g., `accessapproval`):
    ```sh
    go run github.com/googleapis/librarian/cmd/librarian@${V} generate accessapproval
    ```

 