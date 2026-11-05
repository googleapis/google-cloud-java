# BigQuery JDBC Driver Release Notes

All notable customer-facing changes to the Google Cloud BigQuery JDBC driver (`google-cloud-bigquery-jdbc`) are documented below.

---

## 1.7.0 (Unreleased)

### Breaking changes
* Public JDBC methods (`execute*`, `next`, `commit`, `rollback`, `close`, and getters) now consistently throw checked `SQLException` instead of unchecked `RuntimeException` or `IllegalStateException` to comply with the JDBC specification.
* `ResultSet.getString()` and `getObject(..., String.class)` now format `TIMESTAMP` values (including nested values in `ARRAY` and `STRUCT`) in UTC rather than the local JVM timezone.

### Features
* Enabled Post-Quantum Cryptography (PQC) TLS cipher suites (`X25519MLKEM768` and `MLKEM1024`) by default across direct and proxied connections.
* Exposed `QueryStatistics` on `BigQueryResultSet` for fast-path (jobless) queries.
* Added opt-in Clearcut client telemetry support for driver usage and diagnostics.

### Bugs
* Preserved exact UTC instants when binding `Timestamp`, `Instant`, `OffsetDateTime`, and `ZonedDateTime` parameters (including `Calendar` overloads), and bound `LocalDateTime` as `STRING` for compatibility with `DATETIME` columns.
* Honored `Calendar` timezones and fixed `ClassCastException` errors in `ResultSet` temporal getters (`getDate`, `getTime`, `getTimestamp`).
* Corrected the timezone offset direction in `PreparedStatement.setTime(..., Calendar)`.
* Preserved microsecond precision for `TIME` values (including inside `ARRAY` and `STRUCT`) when calling `getString()` or converting to `LocalTime`.
* Formatted nested `ARRAY` fields inside `STRUCT` values as valid JSON strings in `Struct.toString()` and `ResultSet.getString()`.
* Stopped background producer threads, cancelled active gRPC streams, and released Arrow buffer memory immediately when `ResultSet.close()` is called.
* Fixed memory leaks in `ResultSet` GC finalizer queues and per-connection logger registrations during long-running sessions.
* Preserved default BigQuery SDK HTTP connect and read timeouts when custom timeout properties are not specified.

### Performance
* Capped the Storage Read API Arrow batch queue at 32 batches per `ResultSet` to bound heap memory usage on large result sets.

---

## 1.6.0 (2026-09-30)

### Features
* Added pre-execution parameter type and count inference via dry-run in `PreparedStatement`, populating `getParameterMetaData()` and `getMetaData()` prior to execution while ignoring `?` characters inside string literals.

### Bugs
* Automatically terminated active BigQuery sessions when closing the JDBC `Connection`.

---

## 1.5.0 (2026-09-23)

*(Includes changes from interim version 1.4.1)*

### Features
* Added end-to-end support for picosecond-precision timestamps (`TIMESTAMP(12)`) via the `EnableTimestampPicos` connection property across REST JSON, Storage Read API (Arrow), nested `ARRAY`/`STRUCT`/`RANGE` types, `PreparedStatement` parameters, and metadata APIs.
* Added support for colon-delimited project qualifiers (`project:dataset` and `project:warehouse.namespace`) in the `DefaultDataset` connection property for Lakehouse and multi-catalog environments.

### Bugs
* Fixed SQL `NULL` handling in `ResultSet` primitive getters (`getInt`, `getLong`, `getBoolean`, etc.) and `getBlob`/`getClob` to return JDBC-compliant defaults (`0`, `false`, `null`) instead of throwing `NullPointerException`.
* Handled `null` parameter bindings properly during Storage Write API bulk inserts.
* Fixed automatic fallback from the Storage Read API to the REST API when permission errors occur.

---

## 1.4.0 (2026-09-04)

### Bugs
* Preserved local wall-clock time without unintended UTC shifts when reading `DATETIME` values inside `ARRAY` and `RANGE` columns.
* Enforced strict numeric overflow and underflow bounds checking and rejected invalid cross-temporal coercions (`Date` to `Time` and vice versa) in `ResultSet` getters.
* Resolved statement types via `getJob` fallback to avoid unnecessary post-execution dry-run queries for DDL statements.

### Performance
* Eliminated redundant synchronous `jobs.get` RPC calls on the fast query execution path.

---

## 1.3.0 (2026-08-24)

### Features
* Unified SQL and Java type mapping and coercion across read, write, and metadata paths through a centralized type registry.

### Bugs
* Fixed session ID propagation across sequential statements when `EnableSession=1` is enabled.
* Propagated connection proxy settings (`ProxyHost`, `ProxyPort`) to OpenTelemetry span exporters.
* Prevented OpenTelemetry log handlers from being detached when driver logger levels or handlers are reconfigured.
* Fixed exact schema name matching in `DatabaseMetaData.getExportedKeys()` catalog fallback queries.

### Performance
* Eliminated pre-execution dry-run RPCs previously used to classify statement types and DML row counts.
* Accelerated `DatabaseMetaData` queries and prevented thread-pool starvation deadlocks using a two-tier parallel execution model.

### Documentation
* Added a comprehensive `USER_GUIDE.md` detailing connection URL properties, authentication methods, and custom endpoint configuration.

---

## 1.2.0 (2026-07-30)

### Breaking changes
* `DatabaseMetaData` methods now throw a `SQLException` on `403 Forbidden` access errors and project-level `404 Not Found` errors instead of silently returning empty results.

### Features
* Added OpenTelemetry distributed tracing, metrics, and Cloud Logging support, including automatic trace and span ID injection into local log files.
* Added `SSLTrustStoreType` and `SSLTrustStoreProvider` connection properties for custom TLS trustStore configurations.
* Implemented `ParameterMetaData` with dynamic `IN`, `OUT`, and `INOUT` parameter mode support and completed `PreparedStatement` parameter setter methods.

### Bugs
* Fixed Storage Write API bulk inserts in custom endpoint and VPC-SC environments by routing `JsonStreamWriter` through the configured client settings.
* Fixed timezone coercion, `Calendar` defensive copying, and `wasNull()` state tracking across `PreparedStatement` and `CallableStatement`.

### Performance
* Accelerated `DatabaseMetaData` constraint queries (`getPrimaryKeys`, `getImportedKeys`, `getExportedKeys`, `getCrossReference`) using native BigQuery API and hybrid metadata lookups.
* Reduced memory footprint during JSON result set streaming.

---

## 1.1.0 (2026-07-07)

### Features
* Added the `EnableProjectDiscovery` connection property to allow `DatabaseMetaData` (`getCatalogs`, `getSchemas`, `getTables`) to discover datasets across all accessible Google Cloud projects.
* Respected standard JVM trustStore system properties (`javax.net.ssl.trustStore` and related properties) by default for TLS connections.
* Implemented `ResultSet` fetch size, fetch direction, and SQL warning methods (`getFetchSize`, `setFetchSize`, `getFetchDirection`, `setFetchDirection`, `getWarnings`, `clearWarnings`).

### Bugs
* Prevented unintended transaction rollbacks when closing statements in manual commit mode (`autoCommit=false`).
* Propagated connection proxy settings (`ProxyHost`, `ProxyPort`, `ProxyUid`, `ProxyPwd`) to Google Auth Library requests for OAuth token retrieval.
* Fixed large result destination table handling (`AllowLargeResults`, `LargeResultsDataset`, `LargeResultsTable`) in `PreparedStatement` and automatically matched dataset location when creating temporary datasets.
* Corrected `FilterTablesOnDefaultDataset` fallback behavior when empty strings or wildcard patterns are supplied to `DatabaseMetaData`.
* Fixed `BigQueryDriver` to report accurate major and minor driver version numbers instead of `0.0`.
* Shaded `org.slf4j` classes in the standalone uber JAR to prevent classpath conflicts with host applications.
* Preserved accurate page row counts across paginated REST `TableResult` responses.
* Propagated thread interruptions and exceptions in background metadata fetchers as `SQLException` instead of returning truncated results.

### Performance
* Isolated query and metadata thread pools per connection using daemon threads to prevent cross-connection blocking and allow clean JVM shutdown.
* Optimized `DatabaseMetaData` catalog and schema enumeration with parallel project scanning, API field masking, and cached job statistics.
* Eliminated eager stack-trace walking overhead during result set type coercion when SLF4J logging bridges are active.

---

## 1.0.0 / 0.11.0 (2026-06-04)

*(Version 0.11.0 was promoted to 1.0.0 GA with identical functionality)*

### Breaking changes
* Validated integer connection properties and `DataSource` setters at configuration time, rejecting negative values with a driver exception.

### Features
* Implemented JDBC 4.2 `ResultSet.getObject(column, Class<T>)` type conversion support.
* Added support for executing `EXPORT DATA`, `EXPORT MODEL`, and `LOAD DATA` SQL statements.
* Implemented JDBC `Wrapper` methods (`unwrap` and `isWrapperFor`) across `Connection`, `Statement`, `ResultSet`, `DataSource`, `DatabaseMetaData`, and `ResultSetMetaData`.
* Completed per-connection log isolation across background worker threads and result sets.

### Bugs
* Fixed manual commit mode (`autoCommit=false`) query failures when operating on datasets in non-US regions.
* Added automatic fallback to the REST API when the Storage Read API is blocked by IAM permission errors.
* Fixed timezone shifts when converting epoch values to `java.sql.Time` and `java.sql.Timestamp` in Arrow and JSON result sets.
* Standardized precision, scale, and SQL type mappings for numeric, temporal, `STRING` (`NVARCHAR`), `GEOGRAPHY`, `JSON`, and `INTERVAL` types in `ResultSetMetaData` and `DatabaseMetaData`.
* Added support for backslash (`\`) escape characters in `DatabaseMetaData` wildcard pattern filters.
* Isolated `Statement` instances per `DatabaseMetaData` query to prevent state interference across concurrent metadata calls.
* Initialized driver logging prior to JDBC URL parsing so connection string warnings and errors are captured in logs.
* Updated standalone uber JAR shading rules to prevent dependency conflicts.

### Performance
* Tuned Storage Read API eligibility heuristics and increased the default `HighThroughputMinTableSize` threshold to 10,000 rows to avoid gRPC session overhead on small results.

---

## 0.10.0 (2026-05-05)

### Features
* Added per-connection log files using unique UUID connection identifiers so concurrent connections can write isolated diagnostic logs.
* Bypassed dry-run job creation when authenticating with read-only OAuth tokens (`bigquery.readonly` scope).

### Bugs
* Added support for Service Account Impersonation when authenticating with Application Default Credentials (ADC).
* Provided default OAuth client ID and secret values to simplify user OAuth authentication flows.
* Improved `DatabaseMetaData` compliance and implemented `Struct.getSQLTypeName()` for nested `STRUCT` values.
* Enhanced driver exception messages and logs to include full causal chains, stack traces, and originating caller context.

---

## 0.9.0 (2026-04-13)

### Bugs
* Added the Google Drive OAuth scope across all credential types to support querying Drive-backed external tables.
* Scoped `DatabaseMetaData` instances to their parent `Connection` and lazily initialized internal `Statement` resources.

---

## 0.8.0 (2026-04-10)

### Bugs
* Refined dependency bundling and shading rules in the standalone uber JAR artifact.

---

## 0.7.0 (2026-04-07)

### Bugs
* Fixed `Statement.getMoreResults()` to consistently advance past the current result cursor.
* Ignored unrecognized properties in the JDBC connection URL with a warning instead of failing the connection.

---

## 0.6.0 (2026-03-20)

### Bugs
* Unshaded `com.google.cloud.bigquery` SDK classes in the uber JAR to maintain compatibility with applications using the BigQuery client library.

---

## 0.5.0 (2026-03-12)

### Features
* Synchronized all supported connection properties across JDBC URLs, `BigQueryConnection`, and `DataSource` getters and setters.

### Performance
* Reduced connection initialization latency by optimizing credential creation and connection setup.

---

## 0.4.0 (2026-02-27)

### Breaking changes
* Enforced strict JDBC URL syntax validation, rejecting malformed connection strings instead of silently ignoring invalid segments.

### Features
* Added support for escaping special characters in JDBC URL property values.

---

## 0.3.0 (2026-02-12)

### Features
* Added automatic stream retry handling for transient failures in the BigQuery Storage Read API (Arrow).

---

## 0.2.0 (2026-01-26)

### Features
* Enabled gRPC keep-alive pings for the BigQuery Storage Read API to prevent idle stream disconnects on long-running reads.
* Added the `RequestReason` connection property to attach audit reasons to BigQuery API requests.
* Added `HttpConnectTimeout` and `HttpReadTimeout` connection properties to configure REST transport timeouts.

### Bugs
* Returned `null` from `Driver.connect()` when given a non-BigQuery JDBC URL, allowing `DriverManager` to delegate to other registered JDBC drivers.

### Performance
* Avoided eager string formatting in disabled log statements to reduce CPU and allocation overhead.

---

## 0.1.0 (2026-01-19)

### Features
* Initial preview release of the official Google Cloud BigQuery JDBC driver (`google-cloud-bigquery-jdbc`), supporting SQL query execution, `PreparedStatement` and `CallableStatement`, multi-statement transactions, Google Cloud authentication flows, the High-Throughput Storage Read API (Arrow), and the Storage Write API.
