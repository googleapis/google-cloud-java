# Monorepo Scoped Development Guide

This document outlines highly efficient development workflows and build strategies when working with specific client libraries or modules in the `google-cloud-java` monorepo.

---

## 1. Building a Specific Service (Fast Reactor Builds)

Instead of running a full build of the entire monorepo (which contains over 250+ modules and can take up to 30 minutes), you can target a single client library and let Maven automatically resolve and build all of its upstream dependencies using the `-pl` (project list) and `-am` (also make) flags.

Run the following command from the **root directory** of the repository:

```bash
mvn compile -pl java-spanner/google-cloud-spanner -am -P quick-build -DskipTests
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
* Running `mvn compile -pl java-bigtable/google-cloud-bigtable -am` (or targeting the deps-bom directly) will **succeed without actually building the local version of `google-cloud-monitoring-bom`**. Any local changes you made to the BOM will be silently ignored because `-am` does not trace imports.

#### The Solution (Fast Targeted Build):
To resolve this without doing a full 30-minute monorepo build, you can explicitly list the imported BOMs in the `-pl` parameter. This registers them as primary targets so that `-am` builds them and their dependencies, taking **only ~1 minute**:

```bash
mvn install -pl java-monitoring/google-cloud-monitoring-bom,java-bigtable/google-cloud-bigtable-deps-bom,java-bigtable/google-cloud-bigtable -am -P quick-build -DskipTests
```

---

## 2. Building All Submodules under a Service Directory

Many services in this repository (e.g., `java-spanner`, `java-bigtable`) are structured as aggregator parents with multiple submodules (e.g., separate directories for client code, gRPC/Protobuf stubs, executors, and BOMs).

Once your upstream monorepo dependencies are installed in your local ~/.m2/repository cache, you can run standard Maven commands for a specific service from the repository root using the -pl flag:

```bash
mvn compile -pl java-spanner
```
