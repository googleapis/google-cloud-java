# Agents Guide for google-cloud-java

## 1. Overview
This repository, `google-cloud-java`, contains the Java client libraries for Google Cloud Platform services, as well as core components in `sdk-platform-java`.

## 2. Project Structure
The repository is a monorepo containing both generated and handwritten libraries, as well as core platform components and parent POMs.

### Core Modules
- **`sdk-platform-java/`**: Contains foundational components for building client libraries.
    - **Note**: This directory has its own `GEMINI.md` file with detailed instructions specific to core development (GAPIC generator, GAX).
    - Includes `gapic-generator-java` (the generator) and `gax-java` (Google API Extensions).
- **`google-auth-library-java/`**: The Google Auth Library for Java. This is a **handwritten** library used for authentication and credential management across all Google Cloud clients. It is a critical dependency for all client libraries.

### Parent Modules and BOMs
- **`google-cloud-pom-parent/`**: The top-level parent POM for all modules in the repository. It manages plugin versions and common configuration.
- **`google-cloud-jar-parent/`**: The parent POM for all client library JAR modules in the repository. It inherits from `google-cloud-pom-parent` and manages shared dependencies.
- **`gapic-libraries-bom/`**: The Bill of Materials (BOM) that manages versions of all client libraries to ensure compatibility when used together.
- **`java-shared-dependencies/`** (inside `sdk-platform-java`): Manages shared Maven dependencies for all Google Cloud Java client libraries to ensure consistency and avoid conflicts.

### Client Libraries (`java-<service>/`)
Directories starting with `java-` are client libraries for specific Google Cloud services.
- **Generated Clients**: The majority of these are automatically generated from service definitions (protos) using the GAPIC generator in `sdk-platform-java`.
- **Handwritten & Split Repositories**: Some major libraries are either entirely handwritten or are maintained as "split repos" (they have their own standalone repositories in the `googleapis` GitHub organization but are also managed here). When working on these, be aware that changes may need to be synchronized with their respective split repos. Key examples include:
    - **BigQuery**: [java-bigquery](java-bigquery)
    - **BigQuery Storage**: [java-bigquerystorage](java-bigquerystorage)
    - **Spanner**: [java-spanner](java-spanner)
    - **Spanner JDBC**: [java-spanner-jdbc](java-spanner-jdbc)
    - **Storage**: [java-storage](java-storage)
    - **Storage NIO**: [java-storage-nio](java-storage-nio)
    - **Datastore**: [java-datastore](java-datastore)
    - **Logging**: [java-logging](java-logging)
    - **Logging Logback**: [java-logging-logback](java-logging-logback)

## 3. Getting Started
This is a standard Maven project.
- **Build all**: `mvn install -T 1C -P quick-build` from root (recommended).
- **Scoped build**: Run `mvn` commands within specific module directories.
- **Prerequisites**: Java 11+, Maven 3.0+, Bazelisk (for core integration tests).

## 4. Style Guide
1. Minimize visibility scopes. Default to most restrictive access level.
2. Use short names over fully qualified names.
3. Avoid calling `@ObsoleteApi` or `@Deprecated` methods and classes.
4. Avoid unnecessary formatting changes to keep diffs clean.
5. Use `mvn` for everything other than the `test/integration` folder.

## 5. Dependency Management
- Do not bump external dependency versions unless for CVE or critical bug fix.
- Avoid introducing new external dependencies if possible. Prefer Java standard library, then opt for existing dependencies.

## 6. Contribution Guidelines
- **Commits**: Conventional Commits `<type>(<scope>): <description>`.
- **Pull Requests**: Submitted via PR, require review. Pull latest from main and resolve conflicts.
- **Testing**: All new logic should be accompanied by tests.

## 7. Specialized Development Guides
For development on core components, refer to the following guides in `sdk-platform-java`:
- **GAPIC Generator**: [sdk-platform-java/gapic-generator-java/DEVELOPMENT.md](sdk-platform-java/gapic-generator-java/DEVELOPMENT.md)
- **GAX**: [sdk-platform-java/gax-java/DEVELOPMENT.md](sdk-platform-java/gax-java/DEVELOPMENT.md)
- **Hermetic Build**: [sdk-platform-java/hermetic_build/DEVELOPMENT.md](sdk-platform-java/hermetic_build/DEVELOPMENT.md)
