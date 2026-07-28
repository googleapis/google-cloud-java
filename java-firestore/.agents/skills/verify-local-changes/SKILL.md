---
name: Verify Local Changes
description: Verifies local Java SDK changes.
---

# Verify Local Changes

This skill documents how to verify local code changes for the Java Firestore SDK. This should be run **every time** you complete a fix or feature and are prepared to push a pull request.

## Prerequisites

Ensure you have Maven installed and are in the `java-firestore` directory before running commands.

---

## Step 0: Format the Code

Run the formatter to ensure formatting checks pass:

```bash
mvn com.spotify.fmt:fmt-maven-plugin:format
```

---

## Step 1: Unit Testing (Isolated then Suite)

1.  **Identify modified unit tests** in your changes.
2.  **Run specific units only** to test isolated logic regressions:
    ```bash
    mvn test -Dtest=MyUnitTest#testMethod
    ```
3.  **Run the entire unit test suite** that contains those modified tests if the isolated unit tests pass:
    ```bash
    mvn test -Dtest=MyUnitTest
    ```

---

## Step 2: Integration Testing (Isolated then Suite)

### 💡 Integration Test Nuances (from `ITBaseTest.java`)

When running integration tests, configure your execution using properties or environment variables:

-   **`FIRESTORE_EDITION`**: 
    -   `standard` (Default)
    -   `enterprise`
    -   *Note*: **Pipelines can only be run against `enterprise` editions**, while standard Queries run on both.
-   **`FIRESTORE_DATABASE_ID`**:
    -   Enterprise editions usually require a named database (often `enterprise`). Adjust this flag if pointing to specific instances.
-   **`FIRESTORE_TARGET_BACKEND`**:
    -   `PROD` (Default)
    -   `QA` (points to standard sandboxes)
    -   `NIGHTLY` (points to `test-firestore.sandbox.googleapis.com:443`)
    -   `EMULATOR` (points to `localhost:8080`)

1.  **Identify modified integration tests** (usually Starting in `IT`).
2.  **Run specific integration tests only** (isolated checks run quicker):
    ```bash
    mvn verify -Penable-integration-tests -DFIRESTORE_EDITION=enterprise -DFIRESTORE_DATABASE_ID=enterprise -Dtest=ITTest#testMethod -Dclirr.skip=true -Denforcer.skip=true -fae
    ```
3.  **Run the entire integration test suite** for the modified class if isolation tests pass:
    ```bash
    mvn verify -Penable-integration-tests -DFIRESTORE_EDITION=enterprise -DFIRESTORE_DATABASE_ID=enterprise -Dtest=ITTest -Dclirr.skip=true -Denforcer.skip=true -fae
    ```

---

## Step 3: Full Suite Regressions

Run the full integration regression suite once you are confident subsets pass:

```bash
mvn verify -Penable-integration-tests -DFIRESTORE_EDITION=enterprise -DFIRESTORE_DATABASE_ID=enterprise -Dclirr.skip=true -Denforcer.skip=true -fae
```

---

> [!TIP]
> Use `-Dclirr.skip=true -Denforcer.skip=true` to speed up iterations where appropriate without leaking compliance checks.

---

## 🛠️ Troubleshooting & Source of Truth

If you run into issues executing tests with the commands above, **consult the Kokoro configuration files** as the ultimate source of truth:

-   **Presubmit configurations**: See `.kokoro/presubmit/integration.cfg` (or `integration-named-db.cfg`)
-   **Nightly configurations**: See `.kokoro/nightly/integration.cfg` (or `integration-named-db.cfg`)
-   **Build shell scripts**: See `.kokoro/build.sh`

These files define the exact environment variables (e.g., specific endpoints or endpoints overrides) the CI server uses!
