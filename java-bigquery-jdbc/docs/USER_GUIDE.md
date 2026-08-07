# Google BigQuery JDBC Driver User Guide

This guide provides comprehensive instructions for configuring, developing with, and optimizing the **Google BigQuery JDBC Driver** (`google-cloud-bigquery-jdbc`).

> [!NOTE]
> This guide is aligned with and references the official [Google Cloud BigQuery JDBC Documentation](https://cloud.google.com/bigquery/docs/jdbc-for-bigquery) and [Running Queries with the JDBC Driver](https://cloud.google.com/bigquery/docs/jdbc-for-bigquery#run_queries_with_the_driver).

---

## Table of Contents
1. [Overview & Prerequisites](#1-overview--prerequisites)
2. [Connection URL Syntax & Quickstart](#2-connection-url-syntax--quickstart)
3. [Authentication Modes & Configuration](#3-authentication-modes--configuration)
4. [Connection Properties Reference](#4-connection-properties-reference)
5. [Data Type Mapping Reference](#5-data-type-mapping-reference)
6. [JDBC Driver Architecture & Core Features](#6-jdbc-driver-architecture--core-features)
   - [Transaction Management & Multi-Statement Sessions](#transaction-management--multi-statement-sessions)
   - [High-Throughput Storage Read & Write APIs](#high-throughput-storage-read--write-apis)
7. [Feature Examples & Code Snippets](#7-feature-examples--code-snippets)
   - [Transactions (Manual Commit & Rollback)](#transactions-manual-commit--rollback)
   - [Prepared Statements & Parameter Binding](#prepared-statements--parameter-binding)
   - [Callable Statements & Stored Procedures](#callable-statements--stored-procedures)
   - [Batch Ingestion with Storage Write API](#batch-ingestion-with-storage-write-api)
   - [High-Throughput Storage Read API](#high-throughput-storage-read-api)
   - [Struct & Array Column Operations](#struct--array-column-operations)
   - [Service Account Impersonation](#service-account-impersonation)
8. [High-Throughput & Performance Tuning](#8-high-throughput--performance-tuning)
9. [Framework Integration & Deployment](#9-framework-integration--deployment)
   - [Spring Boot (application.yml)](#spring-boot-applicationyml)
   - [Key Deployment Guidelines](#key-deployment-guidelines)
10. [Logging, Diagnostics & Troubleshooting](#10-logging-diagnostics--troubleshooting)
11. [Official Documentation References](#11-official-documentation-references)

---

## 1. Overview & Prerequisites

The BigQuery JDBC Driver enables Java applications, BI tools, and ETL pipelines to interact with Google Cloud BigQuery using the standard Java Database Connectivity (JDBC) API (JDBC 4.2 compliant).

### Prerequisites
- **Java Runtime**: JDK 8 or higher (JDK 11, 17, or 21 recommended).
- **Google Cloud Platform**:
  - An active GCP Project with BigQuery API enabled.
  - Required IAM roles (e.g., `BigQuery Data Viewer`, `BigQuery Job User`).

### Installation Coordinates

**Maven**:
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-bigquery-jdbc</artifactId>
  <version>1.1.0</version> <!-- Replace with desired version -->
</dependency>
```

**Gradle**:
```groovy
implementation 'com.google.cloud:google-cloud-bigquery-jdbc:1.1.0'
```

---

## 2. Connection URL Syntax & Quickstart

The JDBC connection string format for BigQuery is:

```
jdbc:bigquery://https://bigquery.googleapis.com:443;ProjectId=<PROJECT_ID>;[DefaultDataset=<DATASET_ID>;][Property1=Value1;...]
```

### Basic Quickstart Example

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BigQueryQuickstart {
  public static void main(String[] args) throws Exception {
    String url = "jdbc:bigquery://https://bigquery.googleapis.com:443"
        + ";ProjectId=my-gcp-project-id"
        + ";DefaultDataset=my_dataset"
        + ";OAuthType=3"; // 3 = Application Default Credentials (ADC)

    try (Connection conn = DriverManager.getConnection(url);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT name, age FROM `my-gcp-project-id.my_dataset.users` LIMIT 10")) {
      
      while (rs.next()) {
        System.out.printf("User: %s, Age: %d%n", rs.getString("name"), rs.getInt("age"));
      }
    }
  }
}
```

---

## 3. Authentication Modes & Configuration

The driver supports multiple OAuth 2.0 and identity workflows specified via the `OAuthType` connection property.

| `OAuthType` | Authentication Strategy / Variant | Required Properties | Supported / Optional Properties | Notes |
| :---: | :--- | :--- | :--- | :--- |
| **`0`** | **Service Account Key File (JSON)** | `OAuthPvtKeyPath` | `OAuthServiceAcctEmail` | Path to service account `.json` key file. Service account email and private key are automatically extracted from the file. |
| **`0`** | **Service Account Key File (P12)** | `OAuthPvtKeyPath`, `OAuthServiceAcctEmail` | `OAuthP12Password` | Path to `.p12` key file. Requires explicit `OAuthServiceAcctEmail` as `.p12` files do not contain email metadata. `OAuthP12Password` defaults to `notasecret`. |
| **`0`** | **Service Account Key String (JSON)** | `OAuthPvtKey` | `OAuthServiceAcctEmail` | Raw JSON key file string content in URL. Service account email and private key are automatically extracted from the JSON string. |
| **`0`** | **Service Account Key String (PKCS#8 / P12 Bytes)** | `OAuthPvtKey`, `OAuthServiceAcctEmail` | `OAuthP12Password` | Raw PKCS#8 or P12 bytes key string content in URL. Requires explicit `OAuthServiceAcctEmail`. |
| **`1`** | **User Account (Interactive 3-Legged OAuth)** | None (for built-in client app) | `OAuthClientId`, `OAuthClientSecret` | Launches local browser tab for interactive user login on desktop. Built-in client ID/secret used if omitted. |
| **`2`** | **Pre-generated Access Token** | `OAuthAccessToken` | `OAuthAccessTokenReadonly` | Uses short-lived bearer token directly. `OAuthAccessTokenReadonly` defaults to `false`. |
| **`2`** | **Pre-generated Refresh Token** | `OAuthRefreshToken`, `OAuthClientId`, `OAuthClientSecret` | None | Uses refresh token with client credentials to automatically mint access tokens. |
| **`3`** | **Application Default Credentials (ADC)** | None | None | Uses GCP standard credential resolution (`GOOGLE_APPLICATION_CREDENTIALS` env var or `gcloud` CLI context). |
| **`4`** | **Workload / Workforce Identity Federation (BYOID File)** | `OAuthPvtKeyPath` | None | Path to external account credential JSON configuration file. |
| **`4`** | **Workload / Workforce Identity Federation (BYOID Content)** | `OAuthPvtKey` | None | Raw JSON string content of external account credentials. |
| **`4`** | **Workload / Workforce Identity Federation (BYOID Properties)** | `BYOID_AudienceUri`, `BYOID_CredentialSource`, `BYOID_SubjectTokenType` | `BYOID_PoolUserProject`, `BYOID_SA_Impersonation_Uri`, `BYOID_TokenUri` | Inline BYOID connection properties configured directly in connection URL string. |

> [!NOTE]
> **Global Authentication Properties**:
> The following properties are supported across **all** `OAuthType` authentication modes:
> - `universeDomain`: Custom universe domain name for Google Cloud Dedicated (GCD) or non-default Google Cloud environments (defaults to `googleapis.com`).
> - `ServiceAccountImpersonationEmail`, `ServiceAccountImpersonationChain`, `ServiceAccountImpersonationScopes`, `ServiceAccountImpersonationTokenLifetime`: Service account impersonation properties.

### Service Account Authentication Example
```java
String url = "jdbc:bigquery://https://bigquery.googleapis.com:443"
    + ";ProjectId=my-gcp-project-id"
    + ";OAuthType=0"
    + ";OAuthPvtKeyPath=/path/to/service-account-key.json";
```

### Service Account Impersonation
To execute queries as an impersonated service account:
```java
String url = "jdbc:bigquery://https://bigquery.googleapis.com:443"
    + ";ProjectId=my-gcp-project-id"
    + ";OAuthType=3"
    + ";ServiceAccountImpersonationEmail=target-sa@my-gcp-project.iam.gserviceaccount.com";
```

---

## 4. Connection Properties Reference

> [!TIP]
> **Boolean Connection Properties**:
> For boolean connection properties (such as `OAuthAccessTokenReadonly`, `RequestGoogleDriveScope`, `EnableHighThroughputAPI`, etc.), prefer using boolean values (`true` / `false`) when possible (e.g., `;OAuthAccessTokenReadonly=true`). Numeric representation (`1` / `0`) is also accepted for backwards compatibility.

### Authentication & Impersonation Properties

| Property Name | Default Value | Description |
| :--- | :---: | :--- |
| `OAuthType` | **Required** (Default: `-1`) | **Required.** Specifies the authentication mechanism: `0` (Service Account), `1` (User Account), `2` (Pre-generated Token / Refresh Token), `3` (ADC), `4` (Workload & Workforce Identity Federation / BYOID). |
| `OAuthServiceAcctEmail` | `null` | Service Account email address for Service Account authentication or token scope. |
| `OAuthPvtKeyPath` | `null` | Path to JSON or P12 private key file for Service Account authentication. |
| `OAuthPvtKey` | `null` | Raw PKCS#8 private key string content for Service Account authentication. |
| `OAuthP12Password` | `notasecret` | Password for accessing encrypted `.p12` key files. |
| `OAuthAccessToken` | `null` | Pre-generated OAuth 2.0 access token string. |
| `OAuthAccessTokenReadonly` | `false` | Indicates whether the pre-generated access token has read-only scope. |
| `OAuthRefreshToken` | `null` | Pre-generated refresh token to automatically mint access tokens. |
| `OAuthClientId` | *Google Client ID* | OAuth 2.0 Client ID for user authentication or refresh token flows. |
| `OAuthClientSecret` | *Google Secret* | OAuth 2.0 Client Secret for user authentication or refresh token flows. |
| `ServiceAccountImpersonationEmail` | `null` | Target Service Account email to impersonate for query job execution. |
| `ServiceAccountImpersonationChain` | `null` | Comma-separated list of service account emails representing the impersonation chain. |
| `ServiceAccountImpersonationScopes` | `https://www.googleapis.com/auth/bigquery` | Comma-separated OAuth 2.0 scopes for impersonated credentials. |
| `ServiceAccountImpersonationTokenLifetime` | `3600` | Lifetime (in seconds) for impersonated service account tokens. |
| `RequestGoogleDriveScope` | `0` | If `1` (or `true`), appends the Google Drive read-only scope (`https://www.googleapis.com/auth/drive.readonly`) to query external Drive tables. |

### Workload & Workforce Identity Federation (BYOID) Properties

| Property Name | Default Value | Description |
| :--- | :---: | :--- |
| `BYOID_AudienceUri` | `null` | Audience URI corresponding to the Workforce/Workload identity pool provider. |
| `BYOID_CredentialSource` | `null` | File path or JSON content defining the external subject token source. |
| `BYOID_PoolUserProject` | `null` | Google Cloud project number associated with the workforce pool. |
| `BYOID_SA_Impersonation_Uri` | `null` | Service Account impersonation URL for Workload Identity Federation. |
| `BYOID_SubjectTokenType` | `urn:ietf:params:oauth:tokentype:id_token` | Type of subject token provided (e.g., `urn:ietf:params:oauth:tokentype:jwt`). |
| `BYOID_TokenUri` | `https://sts.googleapis.com/v1/token` | Security Token Service (STS) token exchange endpoint URI. |

### Core Query & Catalog Properties

| Property Name | Default Value | Description |
| :--- | :---: | :--- |
| `ProjectId` | *Default Project* | Google Cloud Project ID for billing and query execution. |
| `DefaultDataset` | `null` | Default dataset scope for unqualified table references in SQL queries and metadata catalog filtering (when `FilterTablesOnDefaultDataset=true`). |
| `AdditionalProjects` | `null` | Comma-separated list of additional project IDs accessible for catalog discovery and querying. |
| `EnableProjectDiscovery` | `false` | Automatically discovers all accessible Google Cloud projects as catalog entries when `true`. |
| `FilterTablesOnDefaultDataset` | `false` | When `true`, restricts `DatabaseMetaData` catalog calls (such as `getTables()` and `getColumns()`) to `DefaultDataset` whenever catalog/schema parameters are omitted or set to wildcard (`%`), preventing full project scans. |
| `Location` | *Auto-detected* | GCP location/region for dataset and job execution (e.g., `US`, `EU`, `asia-east1`). |
| `QueryDialect` | `SQL` | Query dialect: `SQL` (Standard SQL) or `LEGACY_SQL`. |
| `UseQueryCache` | `true` | Enables or disables BigQuery query result caching. |
| `MaximumBytesBilled` | `0` (unlimited) | Limits bytes billed per query; query fails without cost if estimated bytes exceed this limit. |
| `Labels` | `null` | Comma-separated `key=value` pairs attached to query jobs (e.g., `env=prod,dept=analytics`). |
| `QueryProperties` | `null` | Connection-level query configuration properties passed to BigQuery job execution. |
| `JobCreationMode` | `2` | Job creation strategy: `1` (`JOB_CREATION_REQUIRED` - forces explicit query job creation for every query) or `2` (`JOB_CREATION_OPTIONAL` - default, allows queries to execute directly without creating explicit jobs when possible). |
| `MaxResults` | `10000` | Maximum number of rows returned per page during standard REST result set iteration. |
| `AllowLargeResults` | `true` | Allows large query results (required when using legacy SQL destination tables). |
| `LargeResultTable` | `null` | Destination table name for query result sets. If omitted when `LargeResultDataset` is set, the driver automatically generates a temporary table name (`_jdbc_tmp_<timestamp>`). |
| `LargeResultDataset` | `null` | Destination dataset name for query result sets. If the specified dataset does not exist, the driver automatically creates it. Under Legacy SQL mode, defaults to creating/using `_jdbc_tmp`. |
| `LargeResultsDatasetExpirationTime` | `3600000` (1 hour) | Expiration time (in milliseconds) for temporary destination tables in user-specified datasets. |
| `KMSKeyName` | `null` | Cloud KMS key resource name used for encrypting query results and destination tables. |

### Session & Transaction Properties

| Property Name | Default Value | Description |
| :--- | :---: | :--- |
| `EnableSession` | `false` | Enables multi-statement session creation and transaction support (`BEGIN`, `COMMIT`, `ROLLBACK`). |

### High-Throughput Storage & Write API Properties

| Property Name | Default Value | Description |
| :--- | :---: | :--- |
| `EnableHighThroughputAPI` | `false` | Enables BigQuery Storage Read API (gRPC/Arrow) for faster result retrieval. Requires `BigQuery Read Session User` (`roles/bigquery.readSessionUser`) IAM permission. |
| `HighThroughputMinTableSize` | `10000` | Minimum query result row count threshold required to trigger the Storage Read API. |
| `HighThroughputActivationRatio` | `2` | Minimum number of result pages required before switching to the Storage Read API. |
| `UnsupportedHTAPIFallback` | `true` | Automatically falls back to standard REST API when Storage Read API is unsupported or lacks permissions. |
| `EnableWriteAPI` | `false` | Enables BigQuery Storage Write API for high-performance batch insert streams. |
| `SWA_ActivationRowCount` | `3` | Minimum row threshold in `executeBatch()` to activate Storage Write API streaming. |
| `SWA_AppendRowCount` | `1000` | Batch row size per append stream request when using Storage Write API. |

### Network, Proxy & Endpoint Overrides

| Property Name | Default Value | Description |
| :--- | :---: | :--- |
| `ProxyHost` | `null` | Hostname or IP address of the HTTP/HTTPS proxy server. |
| `ProxyPort` | `null` | Port number of the proxy server. |
| `ProxyUid` | `null` | Username for proxy server authentication. |
| `ProxyPwd` | `null` | Password for proxy server authentication. |
| `EndpointOverrides` | `null` | Semicolon or comma-separated list of custom service endpoint overrides. Supported keys: `BIGQUERY`, `READ_API`, `OAUTH2`, `STS`, `ACCOUNTS`. |
| `PrivateServiceConnectUris` | `null` | Alias for `EndpointOverrides`. Accepts the same custom service endpoint override format and supported keys. |
| `universeDomain` | `googleapis.com` | Domain name for Google Cloud Dedicated (GCD) or custom Google universe instances. |
| `SSLTrustStore` | `null` | Path to custom Java TrustStore file containing trusted server certificates for SSL. |
| `SSLTrustStorePwd` | `null` | Password for accessing the custom Java TrustStore file. |
| `SSLTrustStoreType` | *System Default* (`JKS`/`PKCS12`) | Type of the custom Java TrustStore file. |
| `SSLTrustStoreProvider` | `null` | Security provider name for the custom Java TrustStore. |
| `HttpConnectTimeout` | `0` (system default) | HTTP socket connection timeout in milliseconds. |
| `HttpReadTimeout` | `0` (system default) | HTTP socket read timeout in milliseconds. |

### Driver Logging, Retries & Concurrency Tuning

| Property Name | Default Value | Description |
| :--- | :---: | :--- |
| `LogLevel` | `0` (OFF) | Logging verbosity level (`0` = OFF to `7` = FINEST). Controls internal `java.util.logging` detail. See [Logging, Diagnostics & Troubleshooting](#10-logging-diagnostics--troubleshooting) for level definitions and details. |
| `LogPath` | `""` | Directory path where log files are written when logging is enabled. |
| `Timeout` | `0` (unlimited) | Length of time (in seconds) the connector retries failed API calls before timing out. |
| `JobTimeout` | `0` (unlimited) | Job execution timeout (in seconds) after which BigQuery cancels the query job server-side. |
| `RetryInitialDelay` | `0` | Initial delay (in seconds) before executing the first retry attempt. |
| `RetryMaxDelay` | `0` | Maximum delay limit (in seconds) between retry attempts. |
| `MetaDataFetchThreadCount` | `32` | Thread pool size used to parallelize `DatabaseMetaData` catalog RPC calls. |
| `ConnectionPoolSize` | `10` | Maximum size of the internal connection pool when connection pooling is enabled. |
| `ListenerPoolSize` | `10` | Maximum size of the listener thread pool when connection pooling is enabled. |
| `RequestReason` | `null` | Reason string passed in the `x-goog-request-reason` HTTP header for auditing. |

### OpenTelemetry & Cloud Observability Exporters

| Property Name | Default Value | Description |
| :--- | :---: | :--- |
| `enableGcpTraceExporter` | `false` | Enables direct exporting of driver OpenTelemetry trace spans to Google Cloud Trace. |
| `enableGcpLogExporter` | `false` | Enables direct exporting of driver OpenTelemetry logs to Google Cloud Logging. |
| `gcpTelemetryProjectId` | `null` | GCP Project ID target for OpenTelemetry log and trace telemetry export. Defaults to query `ProjectId` if omitted. |
| `gcpTelemetryCredentials` | `null` | File path or raw JSON credentials string for OpenTelemetry GCP exporters. |
| `useGlobalOpenTelemetry` | `false` | Instructs the driver to register with the global OpenTelemetry instance (`GlobalOpenTelemetry`) in the JVM environment. |

---

## 5. Data Type Mapping Reference

When running queries through the JDBC driver for BigQuery, data types map as specified in the official [BigQuery JDBC Data Type Mapping](https://cloud.google.com/bigquery/docs/jdbc-for-bigquery#run_queries_with_the_driver):

| BigQuery SQL Type | Java / JDBC Type | Recommended Getter / Setter |
| :--- | :--- | :--- |
| `ARRAY` | `java.sql.Array` | `rs.getArray(col)` |
| `BIGNUMERIC` | `java.math.BigDecimal` | `rs.getBigDecimal(col)` |
| `BOOL` | `java.lang.Boolean` | `rs.getBoolean(col)` |
| `BYTES` | `byte[]` | `rs.getBytes(col)` |
| `DATE` | `java.sql.Date` / `java.time.LocalDate` | `rs.getDate(col)` or `rs.getObject(col, LocalDate.class)` |
| `DATETIME` | `java.sql.Timestamp` / `java.time.LocalDateTime` | `rs.getTimestamp(col)` or `rs.getObject(col, LocalDateTime.class)` |
| `FLOAT64` | `java.lang.Double` | `rs.getDouble(col)` |
| `GEOGRAPHY` | `java.lang.String` | `rs.getString(col)` |
| `INT64` | `java.lang.Long` | `rs.getLong(col)` |
| `INTERVAL` | `java.lang.String` | `rs.getString(col)` |
| `JSON` | `java.lang.String` | `rs.getString(col)` |
| `NUMERIC` | `java.math.BigDecimal` | `rs.getBigDecimal(col)` |
| `STRING` | `java.lang.String` | `rs.getString(col)` |
| `STRUCT` | `java.sql.Struct` | `rs.getObject(col)` (casts to `java.sql.Struct`) |
| `TIME` | `java.sql.Time` / `java.time.LocalTime` | `rs.getTime(col)` or `rs.getObject(col, LocalTime.class)` |
| `TIMESTAMP` | `java.sql.Timestamp` / `java.time.Instant` | `rs.getTimestamp(col)` or `rs.getObject(col, Instant.class)` |

---

## 6. JDBC Driver Architecture & Core Features

### Transaction Management & Multi-Statement Sessions

BigQuery supports **Multi-Statement Transactions** across tables using standard SQL primitives (`BEGIN TRANSACTION`, `COMMIT TRANSACTION`, `ROLLBACK TRANSACTION`). The driver bridges standard JDBC methods (`setAutoCommit`, `commit`, `rollback`) directly to BigQuery's underlying session engine.

#### Session Lifecycle Flow:

```
[DriverManager.getConnection()]
             │
   (EnableSession=true)
             │
  ┌──────────▼──────────┐
  │ setAutoCommit(false)│ ──────► Begins transaction block in session
  └──────────┬──────────┘
             │
  ┌──────────▼──────────┐
  │ Execute DML & SQL   │ ──────► Runs queries within active session
  │ Statements          │
  └──────────┬──────────┘
             │
     ┌───────┴───────┐
     │               │
     ▼               ▼
┌─────────┐     ┌──────────┐
│commit() │     │rollback()│
└────┬────┘     └────┬─────┘
     │               │
     ▼               ▼
Executes:        Executes:
COMMIT           ROLLBACK
TRANSACTION;     TRANSACTION;
     │               │
     └───────┬───────┘
             │
             ▼
(Auto-re-executes BEGIN TRANSACTION; if setAutoCommit remains false)
```

1. **Pre-requisite Check**: Calling `setAutoCommit(false)`, `commit()`, or `rollback()` requires `;EnableSession=true` in the connection URL. If disabled or invoked without an active transaction, an exception is thrown by the driver.
2. **Session & Transaction Start**:
   - `setAutoCommit(false)` initiates a multi-statement transaction session in BigQuery.
3. **Statement Propagation**:
   - All `Statement` or `PreparedStatement` instances created on the connection execute within the scope of the active session.
4. **Commit & Rollback**:
   - `commit()` executes `COMMIT TRANSACTION;` to commit changes.
   - `rollback()` executes `ROLLBACK TRANSACTION;` to discard changes.
   - If `autoCommit` remains `false`, the driver automatically starts the next transaction block.
5. **Connection Close Safety**:
   - If an uncommitted transaction is pending when `conn.close()` is invoked, the driver automatically rolls back the transaction to prevent uncommitted changes from persisting.
6. **Isolation Level & Holdability**:
   - Isolation level: `Connection.TRANSACTION_SERIALIZABLE` (BigQuery multi-statement snapshot isolation).
   - Holdability: `ResultSet.CLOSE_CURSORS_AT_COMMIT`.

---

### High-Throughput Storage Read & Write APIs

For enterprise data ingestion and analytics extraction, the driver integrates with BigQuery Storage APIs:

- **Storage Read API (`EnableHighThroughputAPI=true`)**:
  Performs high-speed result extraction over gRPC streams using Apache Arrow instead of REST JSON pagination for large ResultSets.
- **Storage Write API (`EnableWriteAPI=true`)**:
  Enables high-throughput streaming appends for batch operations executed via `PreparedStatement.executeBatch()`.

---

## 7. Feature Examples & Code Snippets

### Transactions (Manual Commit & Rollback)
Transactions require `;EnableSession=true` in the connection URL to enable multi-statement sessions in BigQuery.

```java
String url = "jdbc:bigquery://https://bigquery.googleapis.com:443;ProjectId=my-project;EnableSession=true;OAuthType=3";

try (Connection conn = DriverManager.getConnection(url)) {
    conn.setAutoCommit(false); // Enable manual transaction control

    try (PreparedStatement debit = conn.prepareStatement("UPDATE finance.accounts SET balance = balance - ? WHERE account_id = ?");
         PreparedStatement credit = conn.prepareStatement("UPDATE finance.accounts SET balance = balance + ? WHERE account_id = ?")) {
        
        debit.setDouble(1, 500.00);
        debit.setLong(2, 1001L);
        debit.executeUpdate();

        credit.setDouble(1, 500.00);
        credit.setLong(2, 2002L);
        credit.executeUpdate();

        conn.commit(); // Commit transaction atomically
    } catch (SQLException e) {
        conn.rollback(); // Rollback on error
        throw e;
    }
}
```

---

### Prepared Statements & Parameter Binding
Use `PreparedStatement` to safely bind parameters including primitive types, decimals (`BigDecimal`), temporal values (`Date`, `Timestamp`), and byte arrays (`byte[]`).

```java
String url = "jdbc:bigquery://https://bigquery.googleapis.com:443;ProjectId=my-project;OAuthType=3";
String sql = "SELECT order_id FROM sales.orders WHERE order_date = ? AND total_amount >= ? AND status_code = ?";

try (Connection conn = DriverManager.getConnection(url);
     PreparedStatement pstmt = conn.prepareStatement(sql)) {

    pstmt.setDate(1, java.sql.Date.valueOf(LocalDate.of(2026, 7, 22)));
    pstmt.setBigDecimal(2, new BigDecimal("12499.99"));
    pstmt.setString(3, "COMPLETED");

    try (ResultSet rs = pstmt.executeQuery()) {
        while (rs.next()) {
            long orderId = rs.getLong("order_id");
        }
    }
}
```

---

### Callable Statements & Stored Procedures
BigQuery stored procedure outputs are returned as standard result sets (`TableResult`) rather than JDBC `OUT` parameters.

#### Pattern A: Executing a Stored Procedure Returning a ResultSet
```java
String url = "jdbc:bigquery://https://bigquery.googleapis.com:443;ProjectId=my-project;OAuthType=3";

try (Connection conn = DriverManager.getConnection(url);
     Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery("CALL my_dataset.get_top_customers()")) {

    while (rs.next()) {
        String customer = rs.getString("customer_name");
        double spent = rs.getDouble("total_spent");
    }
}
```

#### Pattern B: Retrieving Procedure Output Variables via Multi-Statement Script
To retrieve `OUT` parameters from a procedure, execute a procedural script that declares an output variable, calls the procedure, and returns the variable in a final `SELECT` statement:

```java
String scriptSql = "DECLARE tax_out NUMERIC; "
                 + "CALL my_dataset.calculate_tax(?, tax_out); "
                 + "SELECT tax_out AS calculated_tax;";

try (Connection conn = DriverManager.getConnection(url);
     PreparedStatement pstmt = conn.prepareStatement(scriptSql)) {

    pstmt.setBigDecimal(1, new BigDecimal("1000.00"));

    try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
            BigDecimal taxAmount = rs.getBigDecimal("calculated_tax");
        }
    }
}
```

---

### Batch Ingestion with Storage Write API
Enable `;EnableWriteAPI=true` in the connection URL to stream bulk batches via `executeBatch()`.

```java
String url = "jdbc:bigquery://https://bigquery.googleapis.com:443;ProjectId=my-project;EnableWriteAPI=true;OAuthType=3";
String sql = "INSERT INTO telemetry.sensor_readings (sensor_id, temperature, is_valid) VALUES (?, ?, ?)";

try (Connection conn = DriverManager.getConnection(url);
     PreparedStatement pstmt = conn.prepareStatement(sql)) {

    for (int i = 0; i < 1000; i++) {
        pstmt.setInt(1, 100 + (i % 10));
        pstmt.setDouble(2, 25.5);
        pstmt.setBoolean(3, true);
        pstmt.addBatch();

        if (i % 500 == 0) {
            pstmt.executeBatch(); // Flushes batch using Storage Write API
        }
    }
    pstmt.executeBatch();
}
```

---

### High-Throughput Storage Read API
Enable `;EnableHighThroughputAPI=true` to stream large query result sets over high-speed gRPC streams using Apache Arrow format.

```java
String url = "jdbc:bigquery://https://bigquery.googleapis.com:443;ProjectId=my-project;EnableHighThroughputAPI=true;OAuthType=3";

try (Connection conn = DriverManager.getConnection(url);
     Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery("SELECT user_id, event_name FROM analytics.user_events WHERE event_date >= '2026-01-01'")) {

    while (rs.next()) {
        String userId = rs.getString("user_id");
        String event = rs.getString("event_name");
    }
}
```

---

### Struct & Array Column Operations
Extract nested BigQuery `STRUCT` columns (using `java.sql.Struct`) and `ARRAY` columns (using `java.sql.Array`).

```java
String query = "SELECT STRUCT('123 Main St' AS street, 'Seattle' AS city) AS address, ['tag1', 'tag2'] AS tags";

try (Connection conn = DriverManager.getConnection(url);
     Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery(query)) {

    if (rs.next()) {
        // Read STRUCT attributes
        Struct address = (Struct) rs.getObject("address");
        Object[] attrs = address.getAttributes(); // [123 Main St, Seattle]

        // Read ARRAY elements
        Array tagsArray = rs.getArray("tags");
        String[] tags = (String[]) tagsArray.getArray(); // [tag1, tag2]
    }
}
```

---

### Service Account Impersonation
Impersonate a service account using Application Default Credentials (ADC) without managing static service account key files.

> [!NOTE]
> **IAM Roles Required for Impersonation**:
> 1. **Caller Principal (ADC)**: Must have the `roles/iam.serviceAccountTokenCreator` role on the target Service Account.
> 2. **Impersonated Service Account**: Must have `roles/bigquery.jobUser` (to submit query jobs) and `roles/bigquery.dataViewer` (to read target datasets).

```java
String url = "jdbc:bigquery://https://bigquery.googleapis.com:443"
    + ";ProjectId=my-project"
    + ";OAuthType=3" // Application Default Credentials (ADC)
    + ";ServiceAccountImpersonationEmail=analytics-executor@my-project.iam.gserviceaccount.com";

try (Connection conn = DriverManager.getConnection(url);
     Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM analytics.user_events")) {

    if (rs.next()) {
        long count = rs.getLong(1);
    }
}
```

---

## 8. High-Throughput & Performance Tuning

For large dataset extractions and high-concurrency ingestion, tune the following connection options:

### Storage Read & Write APIs Summary

The BigQuery JDBC driver supports gRPC-accelerated streaming APIs for both reading large result sets and appending batch records:

- **Storage Read API (`EnableHighThroughputAPI=true`)**:
  Streams query result sets over high-speed gRPC channels using Apache Arrow format instead of standard REST JSON pagination. Automatically evaluates minimum table size and page count thresholds before activating.
- **Storage Write API (`EnableWriteAPI=true`)**:
  Streams bulk batch insertions (`PreparedStatement.executeBatch()`) over gRPC append streams instead of concatenated SQL DML statements.

> [!TIP]
> For complete property matrices, activation criteria, and workload tuning scenario matrices for both Storage Read and Write APIs, see the [Storage APIs Guide](STORAGE_APIS.md).

---

### Additional Performance Tuning Options

- **Metadata Thread Pooling**: For applications fetching schema catalog metadata across multiple datasets, set `;MetaDataFetchThreadCount=64` to parallelize catalog RPC calls.

---

### Custom Endpoints, Private Service Connect (PSC) & Universe Domains

For enterprise environments using **VPC Service Controls**, **Private Service Connect (PSC)**, **Regional Endpoints**, or **Google Cloud Dedicated (GCD)** instances, the driver supports full endpoint overriding and universe domain configuration.

#### 1. Endpoint Overrides (`EndpointOverrides`)

The `EndpointOverrides` property allows redirecting traffic for individual Google Cloud services to private IP endpoints, regional gateways, or corporate proxy targets.

**Format**:
```
EndpointOverrides=BIGQUERY=https://bigquery.googleapis.com,OAUTH2=https://oauth2.googleapis.com/token;
```

**Supported Service Keys**:

| Service Key | Target Service / Auth Flow | Default Endpoint URI | When to Use & Applicable Auth Modes |
| :--- | :--- | :--- | :--- |
| **`BIGQUERY`** | BigQuery Core REST API | `https://bigquery.googleapis.com` | Overrides BigQuery REST query execution endpoints for regional gateways or PSC VIPs (**Applies to all `OAuthType` modes**). |
| **`READ_API`** | Storage API (Read & Write) | `https://bigquerystorage.googleapis.com` | Overrides gRPC stream endpoints for Storage Read (HTAPI) and Storage Write (SWA) (**Applies to all `OAuthType` modes**). |
| **`OAUTH2`** | Google OAuth 2.0 Token Server | `https://oauth2.googleapis.com/token` | Overrides OAuth token exchange endpoints for **Service Account (`OAuthType=0`)**, **User Account (`OAuthType=1`)**, and **Refresh Token (`OAuthType=2`)**. |
| **`STS`** | Security Token Service | `https://sts.googleapis.com` | Overrides Security Token Service (`token_url`) endpoints for **Workload Identity / BYOID (`OAuthType=4`)**. |

> [!NOTE]
> **Credentials File Endpoint Resolution**:
> Workload credentials files (such as Workload Identity / External Account JSON files or Application Default Credentials) may define their own endpoint URLs (`token_url`, `credential_source`, or `universe_domain`). Connection parameters (such as `EndpointOverrides`, `BYOIDTokenUri`, or `universeDomain`) take precedence when explicitly specified in the JDBC URL, allowing applications to override values configured inside credential files for private routing or custom proxies.

---

#### 2. Private Service Connect URIs (`PrivateServiceConnectUris`)

For VPC setups using explicit Private Service Connect URI aliases:
```
jdbc:bigquery://https://bigquery.googleapis.com:443
  ;ProjectId=my-gcp-project
  ;OAuthType=0
  ;PrivateServiceConnectUris=BIGQUERY=https://bigquery-privateendpoint.p.googleapis.com
```

#### 3. Custom Universe Domains (`universeDomain`)

To target Google Cloud Dedicated (GCD) or non-default Universe Domain instances, specify `universeDomain`:

```
jdbc:bigquery://https://www.my-universe.cloud:443
  ;ProjectId=my-gcp-project
  ;OAuthType=0
  ;universeDomain=my-universe.cloud
```

---

## 9. Framework Integration & Deployment

### Spring Boot (`application.yml`)
```yaml
spring:
  datasource:
    url: "jdbc:bigquery://https://bigquery.googleapis.com:443;ProjectId=my-gcp-project;DefaultDataset=my_dataset;OAuthType=0;OAuthPvtKeyPath=/path/to/key.json"
    driver-class-name: com.google.cloud.bigquery.jdbc.BigQueryDriver
    hikari:
      maximum-pool-size: 10
      minimum-idle: 2
      idle-timeout: 300000
      connection-test-query: SELECT 1
```

### Key Deployment Guidelines
1. **Driver Class**: `com.google.cloud.bigquery.jdbc.BigQueryDriver`
2. **Connection Pooling**: BigQuery connection objects are lightweight wrappers around thread-safe Google API clients. Standard connection pools like HikariCP can be safely used.
3. **IAM Permissions**: Ensure the principal has `BigQuery Data Viewer` and `BigQuery Job User` roles on the target project and dataset.

---

## 10. Logging, Diagnostics & Troubleshooting

### Configuring Connection-Level Logging

The driver includes a built-in logging subsystem built on top of `java.util.logging`. Logging can be configured directly via JDBC URL connection properties or system environment variables:

#### Connection URL Parameters:
```java
String url = "jdbc:bigquery://https://bigquery.googleapis.com:443"
    + ";ProjectId=my-gcp-project"
    + ";OAuthType=0"
    + ";LogLevel=5"                      // Set log level (1=SEVERE to 7=FINEST)
    + ";LogPath=/var/log/bigquery-jdbc"; // Output directory for log files
```

#### Environment Variables for Logging:

Logging can also be configured globally across all driver connections using environment variables:

| Environment Variable | Equivalent Connection Property | Description | Example |
| :--- | :--- | :--- | :--- |
| **`BIGQUERY_JDBC_LOG_LEVEL`** | `LogLevel` | Global default log verbosity level (`0`–`7` or `OFF`–`FINEST`). Overridden by `LogLevel` URL parameter. | `export BIGQUERY_JDBC_LOG_LEVEL=5` |
| **`BIGQUERY_JDBC_LOG_PATH`** | `LogPath` | Global output directory for driver log files. Overridden by `LogPath` URL parameter. | `export BIGQUERY_JDBC_LOG_PATH=/var/log/bigquery-jdbc` |

#### Log Level Reference:

| Integer Value | String Constant | `java.util.logging` Level | Description |
| :---: | :---: | :---: | :--- |
| `0` | `OFF` | `Level.OFF` | Logging completely disabled (default). |
| `1` | `SEVERE` | `Level.SEVERE` | Critical errors, connection failures, unrecoverable exceptions. |
| `2` | `WARNING` | `Level.WARNING` | Non-fatal warnings, API fallbacks (e.g., Read API permission denied fallback to REST). |
| `3` | `INFO` | `Level.INFO` | High-level driver events, connection establishment, job submission. |
| `4` | `CONFIG` | `Level.CONFIG` | Driver configuration initialization and property resolution details. |
| `5` | `FINE` | `Level.FINE` | SQL query execution statements, parameter binding, row counts. |
| `6` | `FINER` | `Level.FINER` | Internal method entry (`++enter++`) and exit (`++exit++`) tracing. |
| `7` | `FINEST` | `Level.FINEST` | Maximum diagnostic verbosity, raw batch payloads, Arrow stream packet details. |

#### Log File Naming & Format

Log files are generated inside the specified `LogPath` directory with per-connection log isolation.

**Standard Log Record Format**:
```text
2026-07-22 14:25:10.123 [conn-bq-8f3a] INFO    12345 --- [     main      ] com.google.cloud.bigquery.jdbc.BigQueryStatement                   executeQuery                  : Executing query: SELECT COUNT(*) FROM `my-project.analytics.orders`
```

- **Timestamp**: `yyyy-MM-dd HH:mm:ss.SSS` in local time.
- **Connection ID (`MDC`)**: Unique identifier `[conn-bq-XXXX]` isolating statements per connection context.
- **Level**: Padded log level (`INFO`, `FINE`, `WARNING`, etc.).
- **Process ID & Thread**: OS Process ID and centered Thread Name.
- **Class & Method**: Fully qualified source class name and method name originating the log message.

---

### OpenTelemetry & Cloud Observability

The BigQuery JDBC driver features native OpenTelemetry (OTel) instrumentation for distributed tracing and Cloud Logging correlation across SQL query executions, prepared statement batching, and gRPC storage streams.

#### Telemetry Connection Properties:

| Connection Property | Type | Default | Description |
| :--- | :---: | :---: | :--- |
| **`enableGcpTraceExporter`** | `Boolean` | `false` | Enables automatic exporting of OpenTelemetry trace spans directly to Google Cloud Trace over OTLP gRPC (`https://telemetry.googleapis.com:443`). |
| **`enableGcpLogExporter`** | `Boolean` | `false` | Enables exporting driver log events directly to Google Cloud Logging with correlated `traceId` and `spanId` context. |
| **`useGlobalOpenTelemetry`** | `Boolean` | `false` | Directs the driver to use the application's global `GlobalOpenTelemetry` instance registered in the JVM context. |
| **`gcpTelemetryProjectId`** | `String` | `null` | Specifies a custom GCP Project ID for telemetry export when different from the main query connection project catalog. |
| **`gcpTelemetryCredentials`** | `String` | `null` | Path or raw JSON string for dedicated service account credentials used for telemetry export. |

#### OpenTelemetry Span Attributes:

Spans generated by the driver automatically capture standard OpenTelemetry database semantic conventions:
- `db.system`: Always set to `bigquery`.
- `db.connection_id`: Unique connection identifier (e.g., `conn-bq-8f3a`).
- `db.statement`: Executed SQL statement text (safely truncated at 32KB to avoid trace payload overflow).
- `db.application`: Application client name (defaults to `Google-BigQuery-JDBC-Driver` or custom partner token).

#### Enabling GCP Cloud Trace & Cloud Logging via JDBC URL:
```java
String url = "jdbc:bigquery://https://bigquery.googleapis.com:443"
    + ";ProjectId=my-gcp-project"
    + ";OAuthType=0"
    + ";OAuthPvtKeyPath=/var/secrets/bq-key.json"
    + ";enableGcpTraceExporter=true"
    + ";enableGcpLogExporter=true";

Connection conn = DriverManager.getConnection(url);
```

#### Programmatic Custom OpenTelemetry Injection:
Applications with an existing `OpenTelemetry` SDK instance can pass it programmatically via connection `Properties`:
```java
OpenTelemetry customOtel = OpenTelemetrySdk.builder()...build();

Properties props = new Properties();
props.put("customOpenTelemetry", customOtel);

Connection conn = DriverManager.getConnection("jdbc:bigquery://https://bigquery.googleapis.com:443;ProjectId=my-project;OAuthType=3", props);
```

---

### Exception Hierarchy

All driver exceptions inherit from `java.sql.SQLException`:

- **`BigQueryJdbcException`**: Base exception class wrapping underlying Google Cloud API and network RPC errors.
- **`BigQueryJdbcSqlSyntaxErrorException`**: Thrown when standard SQL query validation or parsing fails on the server.
- **`BigQueryConversionException`**: Thrown on data type coercion failures or unparseable target representations.
- **`BigQueryJdbcSqlFeatureNotSupportedException`**: Thrown when an unsupported JDBC API method is invoked.

---

## 11. Official Documentation References

- 🌐 [Official Google Cloud BigQuery JDBC Driver Overview](https://cloud.google.com/bigquery/docs/jdbc-for-bigquery)
- ⚙️ [Running Queries with the JDBC Driver](https://cloud.google.com/bigquery/docs/jdbc-for-bigquery#run_queries_with_the_driver)
- 📊 [BigQuery Quotas & Limits](https://cloud.google.com/bigquery/quotas)
