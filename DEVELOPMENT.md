# Monorepo Scoped Development Guide

This document outlines development workflows, build strategies, and **code generation processes** when working with or managing client libraries in the `google-cloud-java` monorepo.

---

## 1. Building a Specific Service (Fast Reactor Builds)

Instead of running a full build of the entire monorepo (which contains over 250+ modules and can take up to 30 minutes), you can target a single client library and let Maven automatically resolve and build all of its upstream dependencies using the `-pl` (project list) and `-am` (also make) flags.

Run the following command from the **root directory** of the repository:

```bash
mvn install -pl java-spanner/google-cloud-spanner -am -P quick-build -DskipTests
```

### Flag Explanations:
* **`-pl <module-path>`**: Targets only the specified project module.
* **`-am` (Also Make)**: Tells Maven to analyze the dependency tree and automatically compile any projects in the reactor that the target library depends on (e.g., `gax-java`, `google-auth-library-java`, `google-cloud-core`).
* **`-P quick-build`**: Bypasses unnecessary verification checks (like Checkstyle, Enforcer, Animal Sniffer) to significantly speed up local iteration.
* **`-DskipTests`**: Skips running unit and integration tests during compilation.

### Edge Case: Imported BOMs in `<dependencyManagement>`

> [!WARNING]
> **Maven's `-am` (Also Make) reactor analysis does not automatically build imported BOMs.**

#### The Problem:
If a module (or one of its parent dependencies/dependency BOMs) imports another BOM from within the same monorepo via `<scope>import</scope>` in a `<dependencyManagement>` block, Maven **does not** recognize it as a concrete build dependency.
* *Example:* `google-cloud-bigtable-deps-bom` imports `google-cloud-monitoring-bom` via `<dependencyManagement>`.
* Running `mvn install -pl java-bigtable/google-cloud-bigtable -am` (or targeting the deps-bom directly) will **succeed without actually building the local version of `google-cloud-monitoring-bom`**.

#### The Solution (Targeted Build):
To resolve this without doing a full 30-minute monorepo build, you can explicitly list the imported BOMs in the `-pl` parameter:

```bash
mvn install -pl java-monitoring/google-cloud-monitoring-bom,java-bigtable/google-cloud-bigtable-deps-bom,java-bigtable/google-cloud-bigtable -am -P quick-build -DskipTests
```

---

## 2. Building All Submodules under a Service Directory

Many services in this repository (e.g., `java-spanner`, `java-bigtable`) are structured as aggregator parents with multiple submodules (e.g., separate directories for client code, gRPC/Protobuf stubs, executors, and BOMs).

Once your upstream monorepo dependencies are installed in your local ~/.m2/repository cache, you can run standard Maven commands for a specific service from the repository root using the -pl flag:

```bash
cd java-spanner
mvn compile
```

Your IDE such as Intellij should also be able to import all the upstream dependencies at this moment. You can perform the same operations as you would in a normal project such as running unit tests, debugging and so on. 

---

## 3. Code Generation (Librarian)

This repository uses **[Librarian](https://github.com/googleapis/librarian)** to generate code from API specifications.

The configuration for Librarian in this repository is defined in the [librarian.yaml](librarian.yaml) file at the root.

### Documentation & Guides

For more information on how to use Librarian, configure generation, or troubleshoot issues, refer to the following guides:

*   **[Librarian GitHub Repository](https://github.com/googleapis/librarian)**: The main repository for the Librarian tool.
*   **[Librarian Command Reference](https://pkg.go.dev/github.com/googleapis/librarian/cmd/librarian)**: Detailed documentation of `librarian` CLI commands.
*   **[Librarian Configuration Schema](https://github.com/googleapis/librarian/blob/main/doc/config-schema.md)**: Guide to the structure and options available in `librarian.yaml`.
*   **[go/g3doc-sdk-librarian](https://go/g3doc-sdk-librarian)** (Internal): Internal documentation for code generation schedules and local development workflows.
