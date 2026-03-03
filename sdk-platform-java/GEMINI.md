# Gemini CLI Context for sdk-platform-java

## 1. Overview

This repository, `sdk-platform-java`, is a monorepo containing the foundational components for building Java client libraries for Google Cloud Platform services. It includes the GAPIC (Generated API Client) generator for Java, the GAX (Google API Extensions) runtime library, and other shared modules.

## 2. Project Structure

The repository is structured into several key modules:

*   **`gapic-generator-java`**: The core component for creating new client libraries. It is a Protobuf compiler plugin that generates Java client libraries from API definition files. The `DEVELOPMENT.md` file in this module provides detailed information on how to work with the generator.

*   **`gax-java`**: The Google API Extensions for Java (GAX) library. It provides runtime support for the generated client libraries, including features like pagination, request batching, and polling of long-running operations. It has the following submodules:
    *   `gax`: Transport-independent part of GAX for Java.
    *   `gax-grpc`: gRPC-specific logic for GAX.
    *   `gax-httpjson`: REST-specific logic for GAX.

*   **`api-common-java`**: Contains foundational types and utilities related to Google APIs. It includes the following packages:
    *   `core`: Core library containing API stability annotations and wrappers around Guava types.
    *   `pathtemplate`: Path Template library for manipulating strings that are formatted as Google API resource names.
    *   `resourcenames`: Resource Name library used by generated resource name types.

*   **`java-common-protos`**: Provides Protobuf-generated classes for common Google services that are used across multiple APIs. The code is in this module is auto-generated and should not be modified.

*   **`java-iam`**: Contains Protobuf-generated classes for Google's Identity and Access Management (IAM) service, used for managing policies. The code is in this module is auto-generated and should not be modified.

*   **`java-showcase`**: A demonstration client library for the "Showcase" API, which is a fake API used for integration testing of the GAPIC generator and GAX library.

*   **`java-shared-dependencies`**: Manages shared Maven dependencies for all Google Cloud Java client libraries. This ensures consistency and helps avoid dependency conflicts.

## 3. Getting Started

### 3.1. Prerequisites

To build and work with this project, you will need to install:

*   Java 8+
*   Maven

### 3.2. Building the Project

The project uses Maven for its primary build system. To build all modules, run the following command from the root of the repository:

```sh
mvn install
```

### 3.3. Code Formatting

Code formatting is enforced using the `fmt-maven-plugin`. To check for formatting issues, run:

```sh
mvn fmt:check
```

To format the code, run:

```sh
mvn fmt:format
```

## 4. Testing

### 4.1. Testing Strategy

The repository employs a multi-layered testing strategy to ensure the quality and correctness of the generated code:

*   **Unit Tests:** Traditional unit tests for individual classes and methods.
*   **Golden Unit Tests:** These tests generate code from test protos and compare the output to "golden" files, which are pre-approved versions of the generated code. These test cases exist inside the `gapic-generator-java` module.
*   **Showcase Integration Tests:** These tests run the generated Showcase client against a local Showcase server to verify end-to-end functionality. This is the preferred way of testing integration tests.
*   **Golden Integration Tests:** These tests generate full client libraries for real Google Cloud APIs and compare them to golden versions. This is an older test strategy and showcase testing is preferred.

Based on where the code changes are, we should add different tests, in general

*   If the changes are in `gax` or `api-common` only, you _must_ add traditional unit tests, you _may_ add showcase integration tests if you are modifying a public setting. 
*   If the changes are in `gapic-generator-java` only, showcase integration tests are most likely not needed
      * If they are in the `composer` module, you _must_ add golden unit tests, you _may_ add traditional unit tests for better coverage and easier testing.
      * If they are in the `parser` module, you _should_ add traditional unit tests with a test proto if possible, you _may_ add golden unit tests to easily see the changes. For example, [routing_rule_parser_testing](https://github.com/googleapis/sdk-platform-java/blob/main/gapic-generator-java/src/test/proto/routing_rule_parser_testing.proto) that is only used for testing [RoutingRuleParser](https://github.com/googleapis/sdk-platform-java/blob/main/gapic-generator-java/src/main/java/com/google/api/generator/gapic/protoparser/RoutingRuleParser.java).
      * If they are in `other modules(ast, model, writer etc.)`, you _must_ add traditional unit tests, you _may_ add golden unit tests to easily see the changes.
- If the changes are in both `gax` and `gapic-generator-java`, you _must_ add all test layers, including traditional unit tests, golden unit tests and showcase integration tests.

### 4.2. Running Unit Tests

Unit tests can be tested via this command:

```sh
mvn test
```

### 4.3. Running Golden Integration Tests

Golden integration tests are run using Bazel. To run all golden integration tests, use the following command from the root of the repository:

```sh
bazelisk test //...
```

Specific integration tests can be run by specifying the target, for example:

```sh
bazelisk test //test/integration:redis
```

### 4.4. Updating Golden Files

If you make changes that affect the generated code, you will need to update the golden files. This can be done using the following command:

```sh
bazelisk run //test/integration:update_asset && bazelisk run //test/integration:update_credentials && bazelisk run //test/integration:update_iam && bazelisk run //test/integration:update_kms && bazelisk run //test/integration:update_pubsub && bazelisk run //test/integration:update_logging && bazelisk run //test/integration:update_redis && bazelisk run //test/integration:update_storage && bazelisk run //test/integration:update_library && bazelisk run //test/integration:update_compute && bazelisk run //test/integration:update_bigtable && bazelisk run //test/integration:update_apigeeconnect 
```

### 4.5. Running Showcase Integration Tests

Showcase integration tests are run against a local server that implements the Showcase API. The `java-showcase/README.md` file provides detailed instructions on how to run these tests. The general steps are:

1.  **Install the Showcase server:**

    ```sh
    go install github.com/googleapis/gapic-showcase/cmd/gapic-showcase@latest
    ```

2.  **Run the Showcase server:**

    ```sh
    gapic-showcase run
    ```

3.  **Run the integration tests:**

    ```sh
    cd java-showcase
    mvn verify -P enable-integration-tests
    ```
    
## 5. Dependency Management

- Try not to bump any external dependency version unless there is a known CVE (security or vulnerability issue) or a critical bug fix.
- Try to avoid introducing new external dependencies. If a new dependency is required, please state the reason.
- Prefer to use features from the Java standard library, then try to use features from any existing dependencies (preferably from Google managed dependencies).

## 6. Contribution Guidelines

- **Commits:** Commit messages should follow the [Conventional Commits](https://www.conventionalcommits.org/)
  specification. The format is `<type>: <description>`. The type should be one of the following: fix, feat,
  build, chore, docs, test, or refactor.
- **Issues:** All significant changes should start with a GitHub issue.
- **Pull Requests:** All code changes must be submitted via a pull request and require review.
- **Testing:** All new logic should be accompanied by tests.
- For more details, see `CONTRIBUTING.md`.
