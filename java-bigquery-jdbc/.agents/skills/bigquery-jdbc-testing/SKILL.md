---
name: bigquery-jdbc-testing
description: Conventions for writing and refactoring unit and integration tests in the BigQuery JDBC driver (java-bigquery-jdbc). Use this skill when adding, reviewing, or cleaning up tests under java-bigquery-jdbc/src/test, including tests for connection/credential setup, Storage Read/Write API clients, TPC/universe-domain behavior, and ITBase-derived integration tests.
---

# BigQuery JDBC Driver: Writing Tests

Applies to `java-bigquery-jdbc/src/test/java/com/google/cloud/bigquery/jdbc/**`.

- **Unit tests** live in `com.google.cloud.bigquery.jdbc` and extend
  `BigQueryJdbcBaseTest` (directly or through `BigQueryJdbcLoggingBaseTest`).
- **Integration tests** live in `com.google.cloud.bigquery.jdbc.it`, are named
  `IT*`, and extend `ITBase`.

Aim for tests that are short and read top to bottom: setup comes from shared
fixtures, the test body holds only what is specific to the case, and repeated
assertions live in one helper.

## 1. Reuse existing fixtures. Don't hand-roll them

Before writing setup code, check `BigQueryJdbcBaseTest`,
`BigQueryJdbcLoggingBaseTest`, `utils/TestUtilities`, and `utils/URIBuilder`.

| Need | Use | Avoid |
| --- | --- | --- |
| A private key / PEM string | `fake_pkcs8_key` | `KeyPairGenerator`, Base64 encoding, building `-----BEGIN PRIVATE KEY-----` by hand |
| A service-account connection URL | `getUriOAuthServiceAccount()` | Building `jdbc:bigquery://...;OAuthType=0;...` by string concatenation |
| Other auth types | `getUriOAuthUserAccount()`, `getUriOAuthToken()`, `getUriOAuthApplicationDefault()`, `getUriOAuthExternal()` | Copy-pasting URL fragments |
| Extra URL properties | `.append("Key", value)` on the `URIBuilder`, then `.toString()` | Manual `";"` handling |

Example:

```java
String url =
    getUriOAuthServiceAccount()
        .append("ProjectId", "project")
        .append("universeDomain", TPC_UNIVERSE)
        .toString();
```

If a fixture you need doesn't exist and more than one test would use it, add it
to the base class instead of keeping a private copy in one test file.

## 2. Pull repeated assertions into a helper

When a test asserts the same thing for two or more objects (for example the
Storage **Read** and **Write** clients, or the Arrow and JSON result sets), move
the assertions into one `private static` helper that takes the varying parts
(credentials, endpoint URI, expected scopes, expected universe) as parameters.
Each test then makes one call per object.

```java
assertStorageCredentialsScoped(
    readClient.getSettings().getCredentialsProvider().getCredentials(),
    TPC_UNIVERSE, TPC_READ_URI, BigQueryReadSettings.getDefaultServiceScopes());
assertStorageCredentialsScoped(
    writeClient.getSettings().getCredentialsProvider().getCredentials(),
    TPC_UNIVERSE, TPC_WRITE_URI, BigQueryWriteSettings.getDefaultServiceScopes());
```

Put repeated literals (universe domains, endpoint URIs, scope lists) in
`private static final` constants at the top of the test class.

## 3. Cover every branch of the code under test

For each conditional in the production change, write at least one test that
takes each side. In particular:

- **Credential type.** If the code special-cases `ServiceAccountCredentials` or
  `GoogleCredentials`, also test a credential that is *not* a service account,
  such as `getUriOAuthToken()` / `GoogleCredentials.create(AccessToken)`. Check
  that it passes through unchanged (`assertSame` where possible).
- **Universe domain.** If the code behaves differently for TPC
  (`universeDomain=apis-tpczero.goog`), also test the **default** universe (no
  `universeDomain` property, so `googleapis.com`).
- **Already configured input.** For example, credentials that already have
  explicit scopes must keep them.

When you are asked to *refactor* tests, keep coverage the same: every assertion
the old tests made must still be made, possibly through a helper. Don't drop
cases or weaken assertions (for example, changing `assertEquals` to
`assertNotNull`).

## 4. Integration tests: shared pieces belong in `ITBase`

- If more than one `IT*` class uses the same query template or check, define it
  once in `ITBase` as a `public static final` constant or a `protected`/`public
  static` helper. Don't redefine it per class or inline the literal. Current
  shared pieces:
  - `GENERATE_ARRAY_QUERY` = `"SELECT * FROM UNNEST(GENERATE_ARRAY(1, %s));"`,
    used with `String.format(GENERATE_ARRAY_QUERY, n)`.
  - `assertArrowResultSet(ResultSet)`, which checks that the High-Throughput
    (Storage Read) API path was taken.
  - `resultSetRowCount(ResultSet)` and `validateStatement(...)`.
- Don't shadow `ITBase` members with a same-named `private static final` field
  that means something else (for example a class-local `BASE_QUERY` that is a
  different query).
- Use try-with-resources for `Connection`, `Statement`, and `ResultSet`, or close
  them explicitly. IT suites share quotas.
- `@Tag("disable_tpc")` excludes a test from TPC runs. Remove it only when the
  feature is known to work against TPC, and in that case add an assertion that
  proves the intended path was used (for example `assertArrowResultSet`).

## 5. Style and verification

- Follow the repo `AGENTS.md`: least visibility (`private static` helpers),
  short names over fully qualified names, no `@Deprecated`/`@ObsoleteApi`
  calls, and no unrelated formatting changes.
- Remove imports that the refactor makes unused (for example `KeyPairGenerator`,
  `PrivateKey`, `Base64`).
- Run the formatter from `java-bigquery-jdbc/`:
  ```bash
  make lint   # mvn com.spotify.fmt:fmt-maven-plugin:format
  ```
  If the formatter fails with `NoSuchMethodError`, your JDK is too new for
  google-java-format. Run it under an older JDK, for example
  `JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64 make lint`.
- Run the affected unit tests:
  ```bash
  make unittest test=BigQueryConnectionTest
  make unittest test='BigQueryConnectionTest#testReadAndWrite*'
  ```
- Integration tests need real credentials (`GOOGLE_APPLICATION_CREDENTIALS`).
  If they can't run locally, at least compile them:
  ```bash
  mvn -q -Denforcer.skip=true -Dclirr.skip=true test-compile
  ```
