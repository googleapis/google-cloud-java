---
name: java-development
description: General guidance on Java development practices, building, testing, and style in the monorepo. Use this skill when working on Java code across the repository.
---

# Java Development Guide

This skill provides general guidelines for Java development inside the monorepo. It covers building, formatting, testing, and style conventions to ensure consistency across modules.

## Workflow

### 1. Building the Project

The repository uses Maven as its primary build system.

*   **Build All Modules**: To build all modules from the root of the repository, run:
    ```bash
    mvn install -T 1C -P quick-build
    ```
    > [!TIP]
    > Use `-T 1C` to build modules in parallel (one thread per CPU core) and `-P quick-build` to skip unnecessary plugins for faster builds.
*   **Build a Specific Module**: You can also run Maven commands within a specific module directory (e.g., `java-bigquery`) to build only that module.

### 2. Code Formatting

Code formatting is enforced using the `fmt-maven-plugin`.

*   **Check Formatting**: To check for formatting issues without modifying files, run:
    ```bash
    mvn fmt:check -T 1C
    ```
*   **Apply Formatting**: To automatically format the code according to the project style, run:
    ```bash
    mvn fmt:format -T 1C
    ```
    > [!TIP]
    > To save time, run `mvn fmt:format` within the specific module directory you are working on, rather than at the root.
    > [!NOTE]
    > Always run `mvn fmt:format` before committing changes to avoid build failures due to formatting.

### 3. Testing Strategy

*   **Unit Tests**: Traditional unit tests should be added for individual classes and methods. Run them using:
    ```bash
    mvn test -T 1C
    ```
*   **Integration Tests**: Many modules have integration tests that run against live services or emulators. These may require specific profiles or environment variables. Refer to the specific module's README for details.

### 4. Style Guide

Follow these general rules to maintain code quality and consistency:

1.  **Minimize Visibility**: Default to the most restrictive access level possible. Avoid using `public` unless the class or method is intended to be part of the public API.
2.  Avoid Fully Qualified Names: Use imports to keep class names short and readable, rather than using fully qualified names in the code.
3.  **Avoid Obsolete APIs**: Do not call methods marked with `@ObsoleteApi` or `@Deprecated` unless there are no viable alternatives.
4.  **Clean Diffs**: Avoid unnecessary formatting changes or whitespace modifications to keep diffs clean and easy to review.

### 5. Dependency Management

*   **Version Bumps**: Try not to bump any external dependency versions unless there is a known security vulnerability (CVE) or a critical bug fix.
*   **New Dependencies**: Avoid introducing new external dependencies. If a new dependency is required, provide a strong justification in the pull request.
*   **Standard Library First**: Prefer to use features from the Java standard library, followed by existing dependencies in the project (preferably Google-managed dependencies).

### 6. Contribution Guidelines

*   **Commit Messages**: Follow the [Conventional Commits](https://www.conventionalcommits.org/) specification. Include the module as the scope (e.g., `feat(spanner): ...`, `fix(bigquery): ...`).
*   **Pull Requests**: All code changes must be submitted via a pull request and require review. Ensure you pull the latest changes from `main` and resolve any conflicts before submitting.
