# Java Bigtable Development Guidelines

When developing or modifying code within the `java-bigtable` directory, you must strictly follow these rules and perform these actions:

## 1. Source Control
- **Always** pull the latest changes from the `main` branch of `git@github.com:googleapis/google-cloud-java.git` before starting work.
- Checkout a new branch for your development instead of committing directly to `main`.

## 2. Unit Testing
- **Always write unit tests** for any new logic or modifications you implement.
- Follow **JUnit 5** conventions for writing and structuring tests (e.g., using `@Test`, `@BeforeEach`, etc., from `org.junit.jupiter.api`). 
- Do not use JUnit 4 unless modifying an existing file that hasn't been migrated yet, but for new tests default to JUnit 5.

## 3. Clean Up Imports
- After writing or updating code, **always** check that imports are properly cleaned up.
- Avoid using fully qualified class names (e.g., `x.y.z.Class`) directly inline in the code.
- Ensure all required classes are imported in the header of the Java file.
- Remove any unused imports.

## 4. Code Formatting
- Automatically format the code using the `fmt-maven-plugin`.
- Before finalizing your changes, run the following command in the terminal from the `java-bigtable` directory or the relevant module directory:
  ```bash
  mvn com.spotify.fmt:fmt-maven-plugin:format
  ```
- **Troubleshooting**: If the formatting command fails, it is usually because of an incompatible JDK version. Ensure you are running it in an environment with the correct JDK version for the project (typically 17+, depending on the project configuration).
