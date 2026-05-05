# Gemini CLI Context for sdk-platform-java

## 1. Overview

This directory, `sdk-platform-java`, contains the foundational components for building Java client libraries for Google Cloud Platform services. It includes the GAPIC (Generated API Client) generator for Java, the GAX (Google API Extensions) runtime library, and other shared modules.

For general project rules, style guides, dependency management, and contribution guidelines, please refer to the root [AGENTS.md](../AGENTS.md).

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

## 3. Testing

For detailed testing strategy and heuristics on which tests to run based on code changes, please refer to [DEVELOPMENT.md](DEVELOPMENT.md).

### 3.1. Running Unit Tests

Unit tests can be tested via this command:

```sh
mvn test
```

### 3.2. Running Golden Integration Tests

Golden integration tests are run using Bazel. To run all golden integration tests, use the following command from the root of the repository:

```sh
bazelisk test //...
```

### 3.3. Running Showcase Integration Tests

```sh
bazelisk test //test/integration:redis
```

### 3.4. Updating Golden Files

If you make changes that affect the generated code, you will need to update the golden files. This can be done using the following command:

```sh
bazelisk run //test/integration:update_asset && bazelisk run //test/integration:update_credentials && bazelisk run //test/integration:update_iam && bazelisk run //test/integration:update_kms && bazelisk run //test/integration:update_pubsub && bazelisk run //test/integration:update_logging && bazelisk run //test/integration:update_redis && bazelisk run //test/integration:update_storage && bazelisk run //test/integration:update_library && bazelisk run //test/integration:update_compute && bazelisk run //test/integration:update_bigtable && bazelisk run //test/integration:update_apigeeconnect 
```

### 3.5. Running Showcase Integration Tests

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

## 4. File Exclusions & Loading Constraints

To maintain a highly focused context window and prevent memory overload:

*   **Permanent Exclusions (Always Ignore):**
    *   Do **NOT** load, read, or search through files under the directories `java-showcase-3.21.0/` and `java-showcase-3.25.8/`. Treat these folders as completely out of scope.
*   **Conditional Exclusions (Ignore by Default):**
    *   By default, do **NOT** load, read, or search through files in the `test/` folder (which contains massive auto-generated integration golden files).
    *   **Exceptions:** You are only authorized to load or modify files under `test/` when:
        1. The user explicitly asks you to *"update the golden files"* or *"inspect test files"*.
        2. You are actively executing the Golden Integration Update commands (e.g. `bazelisk run //test/integration:update_...`).
