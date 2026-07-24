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
   - [Type Mapping & Coercion Engine](#type-mapping--coercion-engine)
   - [High-Throughput Storage Read & Write APIs](#high-throughput-storage-read--write-apis)
   - [Diagnostic MDC Tracing & Connection Proxying](#diagnostic-mdc-tracing--connection-proxying)
7. [Common User Journeys (CUJs) & Code Recipes](#7-common-user-journeys-cujs--code-recipes)
   - [CUJ 1: Financial & Multi-Table Transactions](#cuj-1-financial--multi-table-transactions)
   - [CUJ 2: High-Performance ETL Ingestion Pipeline](#cuj-2-high-performance-etl-ingestion-pipeline)
   - [CUJ 3: High-Throughput Result Extraction via Storage Read API](#cuj-3-high-throughput-result-extraction-via-storage-read-api)
   - [CUJ 4: Parameterized Queries with JSR-310 & Numeric Types](#cuj-4-parameterized-queries-with-jsr-310--numeric-types)
   - [CUJ 5: Nested Structs & Repeated Array Operations](#cuj-5-nested-structs--repeated-array-operations)
   - [CUJ 6: Service Account Impersonation](#cuj-6-service-account-impersonation)
   - [CUJ 7: Stored Procedure Execution & Procedural Results](#cuj-7-stored-procedure-execution--procedural-results)
8. [High-Throughput & Performance Tuning](#8-high-throughput--performance-tuning)
9. [Framework & BI Tool Integrations](#9-framework--bi-tool-integrations)
   - [Spring Boot & HikariCP](#spring-boot--hikaricp)
   - [SQL Clients (DBeaver / DataGrip)](#sql-clients-dbeaver--datagrip)
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
jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=<PROJECT_ID>;[DefaultDataset=<DATASET_ID>;][Property1=Value1;...]
```

### Basic Quickstart Example

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BigQueryQuickstart {
  public static void main(String[] args) throws Exception {
    String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443"
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

| `OAuthType` | Authentication Strategy | Required Properties |
| :---: | :--- | :--- |
| **`0`** | **Service Account Key File / Key String** | `OAuthPvtKeyPath` (path to `.json`/`.p12` key) or `OAuthPvtKey` & `OAuthServiceAcctEmail` |
| **`1`** | **User Account (Interactive 3-Legged OAuth)** | `OAuthClientId`, `OAuthClientSecret` |
| **`2`** | **Pre-generated Access Token or Refresh Token** | `OAuthAccessToken` or `OAuthRefreshToken` (`OAuthClientId`, `OAuthClientSecret`) |
| **`3`** | **Application Default Credentials (ADC)** / gcloud CLI | None (reads `GOOGLE_APPLICATION_CREDENTIALS` or `gcloud` context) |
| **`4`** | **Workload Identity Federation (BYOID)** | `BYOID_AudienceUri`, `BYOID_CredentialSource`, `BYOID_SubjectTokenType` |

### Service Account Authentication Example
```java
String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443"
    + ";ProjectId=my-gcp-project-id"
    + ";OAuthType=0"
    + ";OAuthPvtKeyPath=/path/to/service-account-key.json";
```

### Service Account Impersonation
To execute queries as an impersonated service account:
```java
String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443"
    + ";ProjectId=my-gcp-project-id"
    + ";OAuthType=3"
    + ";ServiceAccountImpersonationEmail=target-sa@my-gcp-project.iam.gserviceaccount.com";
```

---

## 4. Connection Properties Reference

### Authentication & Impersonation Properties

| Property Name | Default Value | Description |
| :--- | :---: | :--- |
| `OAuthType` | `-1` | Authentication mechanism: `0` (Service Account), `1` (User Account), `2` (Pre-generated Token / Refresh Token), `3` (ADC), `4` (Workload Identity Federation / BYOID). |
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

### Workload Identity Federation (BYOID) Properties

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
| `DefaultDataset` | `null` | Default dataset scope for unqualified table references in SQL queries. |
| `AdditionalProjects` | `null` | Comma-separated list of additional project IDs accessible for catalog discovery and querying. |
| `EnableProjectDiscovery` | `false` | Automatically discovers all accessible Google Cloud projects as catalog entries when `true`. |
| `FilterTablesOnDefaultDataset` | `false` | Filters `DatabaseMetaData.getTables()` and `.getColumns()` to `DefaultDataset` when wildcard patterns are used. |
| `Location` | *Auto-detected* | GCP location/region for dataset and job execution (e.g., `US`, `EU`, `asia-east1`). |
| `QueryDialect` | `SQL` | Query dialect: `SQL` (Standard SQL) or `LEGACY_SQL`. |
| `UseQueryCache` | `true` | Enables or disables BigQuery query result caching. |
| `MaximumBytesBilled` | `0` (unlimited) | Limits bytes billed per query; query fails without cost if estimated bytes exceed this limit. |
| `Labels` | `null` | Comma-separated `key=value` pairs attached to query jobs (e.g., `env=prod,dept=analytics`). |
| `QueryProperties` | `null` | Connection-level query configuration properties passed to BigQuery job execution. |
| `JobCreationMode` | `2` | Job creation strategy: `1` (Stateful session mode) or `2` (Fast stateless job creation). |
| `MaxResults` | `10000` | Maximum number of rows returned per page during standard REST result set iteration. |
| `AllowLargeResults` | `true` | Allows large query results (required when using legacy SQL destination tables). |
| `LargeResultTable` | `null` | User-specified destination table name for saving query result sets. |
| `LargeResultDataset` | `null` | User-specified destination dataset name for saving query result sets. |
| `LargeResultsDatasetExpirationTime` | `3600000` (1 hour) | Expiration time (in milliseconds) for temporary destination tables in user-specified datasets. |
| `KMSKeyName` | `null` | Cloud KMS key resource name used for encrypting query results and destination tables. |

### Session & Transaction Properties

| Property Name | Default Value | Description |
| :--- | :---: | :--- |
| `EnableSession` | `false` | Enables multi-statement session creation and transaction support (`BEGIN`, `COMMIT`, `ROLLBACK`). |

### High-Throughput Storage & Write API Properties

| Property Name | Default Value | Description |
| :--- | :---: | :--- |
| `EnableHighThroughputAPI` | `false` | Enables BigQuery Storage Read API (gRPC/Arrow) for fast result set retrieval. |
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
| `EndpointOverrides` | `null` | Semicolon/comma-separated custom service endpoints (e.g., `OAuth2=...`, `READ_API=...`, `BIGQUERY=...`, `STS=...`). |
| `PrivateServiceConnectUris` | `null` | Custom Private Service Connect (PSC) endpoint URIs. |
| `universeDomain` | `googleapis.com` | Domain name for Trusted Partner Cloud (TPC) or custom Google universe instances. |
| `SSLTrustStore` | `null` | Path to custom Java TrustStore file containing trusted server certificates for SSL. |
| `SSLTrustStorePwd` | `null` | Password for accessing the custom Java TrustStore file. |
| `HttpConnectTimeout` | `0` (system default) | HTTP socket connection timeout in milliseconds. |
| `HttpReadTimeout` | `0` (system default) | HTTP socket read timeout in milliseconds. |

### Driver Logging, Retries & Concurrency Tuning

| Property Name | Default Value | Description |
| :--- | :---: | :--- |
| `LogLevel` | `0` (OFF) | Logging verbosity level (`0` = OFF, higher integers increase logging detail). |
| `LogPath` | `""` | Directory path where log files are written when logging is enabled. |
| `Timeout` | `0` (unlimited) | Length of time (in seconds) the connector retries failed API calls before timing out. |
| `JobTimeout` | `0` (unlimited) | Job execution timeout (in seconds) after which BigQuery cancels the query job server-side. |
| `RetryInitialDelay` | `0` | Initial delay (in seconds) before executing the first retry attempt. |
| `RetryMaxDelay` | `0` | Maximum delay limit (in seconds) between retry attempts. |
| `MetaDataFetchThreadCount` | `32` | Thread pool size used to parallelize `DatabaseMetaData` catalog RPC calls. |
| `ConnectionPoolSize` | `10` | Maximum size of the internal connection pool when connection pooling is enabled. |
| `ListenerPoolSize` | `10` | Maximum size of the listener thread pool when connection pooling is enabled. |
| `PartnerToken` | `null` | Partner tracking token appended to request headers for telemetry. |
| `RequestReason` | `null` | Reason string passed in the `x-goog-request-reason` HTTP header for auditing. |

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
  │ setAutoCommit(false)│ ──────► Executes: BEGIN TRANSACTION; (with setCreateSession=true)
  └──────────┬──────────┘         Captures: session_id from Job statistics
             │                    Attaches session_id to Connection state
             │
  ┌──────────▼──────────┐
  │ Execute DML & SQL   │ ──────► Appends ConnectionProperty(key="session_id", value="...")
  │ Statements          │         Runs all queries within active BigQuery Session
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
(Auto-re-executes BEGIN TRANSACTION; if setAutoCommit is still false)
```

1. **Pre-requisite Check**: Calling `setAutoCommit(false)`, `commit()`, or `rollback()` requires `;EnableSession=true` in the connection URL. If disabled or invoked without an active transaction, an `IllegalStateException` is thrown by the driver.
2. **Session & Transaction Start**:
   - `setAutoCommit(false)` issues `BEGIN TRANSACTION;` with `setCreateSession(true)`.
   - BigQuery assigns a unique `session_id` in the job statistics.
   - The driver attaches `session_id` to the connection state as a `ConnectionProperty`.
3. **Statement Propagation**:
   - Every `Statement` or `PreparedStatement` created on the connection inherits `ConnectionProperty("session_id", sessionId)`.
   - DML operations (`INSERT`, `UPDATE`, `DELETE`, `MERGE`) execute inside the session block.
4. **Commit & Rollback**:
   - `commit()` executes `COMMIT TRANSACTION;` in the active session.
   - `rollback()` executes `ROLLBACK TRANSACTION;` in the active session.
   - If `autoCommit` remains `false`, the driver automatically starts the next transaction block by issuing `BEGIN TRANSACTION;`.
5. **Connection Close Safety**:
   - If an uncommitted transaction is pending when `conn.close()` is invoked, the driver automatically performs an internal `rollbackImpl()` to abort pending modifications safely.
6. **Isolation Level & Holdability**:
   - Isolation level: `Connection.TRANSACTION_SERIALIZABLE` (BigQuery multi-statement snapshot isolation).
   - Holdability: `ResultSet.CLOSE_CURSORS_AT_COMMIT`.

---

### Type Mapping & Coercion Engine

The driver handles bidirectional type mapping and object coercion:

- **Bidirectional Mapping**: Manages symmetric mapping between JDBC SQL types (`java.sql.Types`), Java types (`BigDecimal`, `byte[]`, `Date`, `Timestamp`), and BigQuery Standard SQL column types (`StandardSQLTypeName`).
- **Coercion Utilities**: Safely converts BigQuery scalar values and Arrow/JSON batch fields into target Java classes transparently during getter/setter invocations.

---

### High-Throughput Storage Read & Write APIs

For enterprise data ingestion and analytics extraction, the driver integrates with Google Cloud Storage APIs:

- **Storage Read API (`EnableHighThroughputAPI=true`)**:
  Performs high-speed result extraction over gRPC streams using Apache Arrow instead of REST JSON pagination, avoiding REST payload deserialization bottlenecks for large ResultSets.
- **Storage Write API (`EnableWriteAPI=true`)**:
  Enables high-throughput streaming appends for batch operations executed via `PreparedStatement.executeBatch()`.

---

### Diagnostic MDC Tracing & Connection Proxying

The driver manages execution context and diagnostics transparently:

- **ThreadLocal MDC Tracing**: Automatically populates `BIGQUERY_JDBC_MDC` with connection ID, catalog, dataset, and job execution metrics for application logging.
- **Automatic Resource Cleanup**: Tracks open statements and result sets to prevent unhandled memory leaks upon connection closure.

---

## 7. Common User Journeys (CUJs) & Code Recipes

### CUJ 1: Financial & Multi-Table Transactions

**Scenario**: A financial application debits one account and credits another atomically across multiple tables using JDBC transactions.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FinancialTransactionCUJ {
  public static void main(String[] args) {
    // Note: EnableSession=true is REQUIRED for transaction support
    String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443"
        + ";ProjectId=my-gcp-project"
        + ";DefaultDataset=finance"
        + ";EnableSession=true"
        + ";OAuthType=3"; // 3 = Application Default Credentials (ADC)

    try (Connection conn = DriverManager.getConnection(url)) {
      // 1. Start Transaction Session
      conn.setAutoCommit(false);
      
      String debitSql = "UPDATE `my-gcp-project.finance.accounts` SET balance = balance - ? WHERE account_id = ?";
      String creditSql = "UPDATE `my-gcp-project.finance.accounts` SET balance = balance + ? WHERE account_id = ?";
      String auditSql = "INSERT INTO `my-gcp-project.finance.audit_log` (source_id, target_id, amount, transfer_time) VALUES (?, ?, ?, CURRENT_TIMESTAMP())";

      try (PreparedStatement debitStmt = conn.prepareStatement(debitSql);
           PreparedStatement creditStmt = conn.prepareStatement(creditSql);
           PreparedStatement auditStmt = conn.prepareStatement(auditSql)) {

        double amount = 500.00;
        long sourceAccount = 1001L;
        long targetAccount = 2002L;

        // Debit source account
        debitStmt.setDouble(1, amount);
        debitStmt.setLong(2, sourceAccount);
        debitStmt.executeUpdate();

        // Credit target account
        creditStmt.setDouble(1, amount);
        creditStmt.setLong(2, targetAccount);
        creditStmt.executeUpdate();

        // Log audit record
        auditStmt.setLong(1, sourceAccount);
        auditStmt.setLong(2, targetAccount);
        auditStmt.setDouble(3, amount);
        auditStmt.executeUpdate();

        // 2. Commit transaction atomically
        conn.commit();
        System.out.println("Transaction committed successfully.");

      } catch (SQLException e) {
        // 3. Rollback transaction on failure
        System.err.println("Transaction failed. Rolling back changes: " + e.getMessage());
        conn.rollback();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
```

---

### CUJ 2: High-Performance ETL Ingestion Pipeline

**Scenario**: An ETL ingestion pipeline loads batches of records into BigQuery using `executeBatch()` with parameter binding and high-throughput write APIs.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.util.UUID;

public class EtlBatchIngestionCUJ {
  public static void main(String[] args) throws Exception {
    String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443"
        + ";ProjectId=my-gcp-project"
        + ";DefaultDataset=telemetry"
        + ";EnableWriteAPI=true" // High-throughput write streaming
        + ";OAuthType=3";

    String insertSql = "INSERT INTO `my-gcp-project.telemetry.sensor_readings` (reading_id, sensor_id, temperature, is_valid, record_time) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(url);
         PreparedStatement pstmt = conn.prepareStatement(insertSql)) {

      int batchSize = 1000;
      for (int i = 1; i <= batchSize; i++) {
        pstmt.setString(1, UUID.randomUUID().toString());
        pstmt.setInt(2, 100 + (i % 10)); // Sensor IDs 100-109
        pstmt.setDouble(3, 20.0 + (Math.random() * 15.0)); // Temp 20-35 C
        pstmt.setBoolean(4, true);
        pstmt.setObject(5, java.sql.Timestamp.from(Instant.now()));
        pstmt.addBatch();

        if (i % 500 == 0) {
          int[] results = pstmt.executeBatch();
          System.out.printf("Flushed batch of %d records.%n", results.length);
        }
      }
    }
  }
}
```

---

### CUJ 3: High-Throughput Result Extraction via Storage Read API

**Scenario**: An analytical application extracts large query result sets using standard JDBC ResultSet APIs accelerated transparently by BigQuery Storage Read API.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HighThroughputExtractionCUJ {
  public static void main(String[] args) throws Exception {
    String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443"
        + ";ProjectId=my-gcp-project"
        + ";DefaultDataset=analytics"
        + ";EnableHighThroughputAPI=true" // Stream via gRPC Storage Read API
        + ";OAuthType=3";

    try (Connection conn = DriverManager.getConnection(url);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT user_id, event_name, event_timestamp FROM `my-gcp-project.analytics.user_events` WHERE event_date >= '2026-01-01'")) {

      long rowCount = 0;
      while (rs.next()) {
        rowCount++;
        String userId = rs.getString("user_id");
        String eventName = rs.getString("event_name");
        java.sql.Timestamp eventTime = rs.getTimestamp("event_timestamp");
      }
      System.out.println("Extracted " + rowCount + " rows via Storage Read API.");
    }
  }
}
```

---

### CUJ 4: Parameterized Queries with JSR-310 & Numeric Types

**Scenario**: Binding precise decimals (`BigDecimal`), temporal types (`java.sql.Date`, `Timestamp`), and binary payloads (`byte[]`).

```java
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

public class ParameterizedTypesCUJ {
  public static void main(String[] args) throws Exception {
    String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=my-project;OAuthType=3";

    String sql = "SELECT order_id FROM `my-project.sales.orders` "
        + "WHERE order_date = ? "
        + "  AND created_timestamp <= ? "
        + "  AND total_amount >= ? "
        + "  AND security_token = ?";

    try (Connection conn = DriverManager.getConnection(url);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

      // Temporal parameter binding
      pstmt.setDate(1, Date.valueOf(LocalDate.of(2026, 7, 22)));
      pstmt.setTimestamp(2, Timestamp.from(Instant.now()));

      // High-precision numeric binding
      pstmt.setBigDecimal(3, new BigDecimal("12499.99"));

      // Binary payload binding
      byte[] tokenBytes = new byte[] {0x12, 0x34, 0x56, 0x78};
      pstmt.setBytes(4, tokenBytes);

      try (ResultSet rs = pstmt.executeQuery()) {
        while (rs.next()) {
          System.out.println("Matched Order ID: " + rs.getLong("order_id"));
        }
      }
    }
  }
}
```

---

### CUJ 5: Nested Structs & Repeated Array Operations

**Scenario**: Processing e-commerce orders containing nested address `STRUCT` objects and line-item `ARRAY` objects with null-safe guardrails.

```java
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Struct;

public class ComplexTypesCUJ {
  public static void main(String[] args) throws Exception {
    String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=my-project;OAuthType=3";

    String query = "SELECT "
        + "  1001 AS order_id, "
        + "  STRUCT('123 Main St' AS street, 'Seattle' AS city) AS shipping_address, "
        + "  [STRUCT('Item A' AS sku, 2 AS qty), STRUCT('Item B' AS sku, 1 AS qty)] AS line_items, "
        + "  ['tag1', 'tag2', 'tag3'] AS tags";

    try (Connection conn = DriverManager.getConnection(url);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

      while (rs.next()) {
        long orderId = rs.getLong("order_id");

        // 1. Reading Struct
        Struct addressStruct = (Struct) rs.getObject("shipping_address");
        if (addressStruct != null) {
          Object[] addressAttrs = addressStruct.getAttributes();
          if (addressAttrs != null && addressAttrs.length >= 2) {
            System.out.printf("Order %d Address: %s, %s%n", orderId, addressAttrs[0], addressAttrs[1]);
          }
        }

        // 2. Reading Array of Structs
        Array itemsArray = rs.getArray("line_items");
        if (itemsArray != null && itemsArray.getArray() != null) {
          Object[] itemsObj = (Object[]) itemsArray.getArray();
          for (Object itemObj : itemsObj) {
            if (itemObj instanceof Struct) {
              Struct item = (Struct) itemObj;
              Object[] itemAttrs = item.getAttributes();
              if (itemAttrs != null && itemAttrs.length >= 2) {
                System.out.printf("  Item -> SKU: %s, Qty: %s%n", itemAttrs[0], itemAttrs[1]);
              }
            }
          }
        }

        // 3. Reading Primitive Array
        Array tagsArray = rs.getArray("tags");
        if (tagsArray != null && tagsArray.getArray() != null) {
          String[] tags = (String[]) tagsArray.getArray();
          System.out.println("  Tags: " + String.join(", ", tags));
        }
      }
    }
  }
}
```

---

### CUJ 6: Service Account Impersonation

**Scenario**: An enterprise microservice running with Application Default Credentials (ADC) impersonates a central Service Account (`analytics-executor@my-gcp-project.iam.gserviceaccount.com`) to execute query jobs with elevated IAM permissions without storing or managing static private key files.

> [!NOTE]
> **IAM Roles Required for Impersonation**:
> 1. **Caller Principal (ADC)**: Must have the `roles/iam.serviceAccountTokenCreator` role on the target Service Account.
> 2. **Impersonated Service Account**: Must have `roles/bigquery.jobUser` (to submit query jobs) and `roles/bigquery.dataViewer` (to read target datasets).

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServiceAccountImpersonationCUJ {
  public static void main(String[] args) throws Exception {
    String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443"
        + ";ProjectId=my-gcp-project"
        + ";DefaultDataset=analytics"
        + ";OAuthType=3" // 3 = Application Default Credentials (ADC) context
        + ";ServiceAccountImpersonationEmail=analytics-executor@my-gcp-project.iam.gserviceaccount.com";

    try (Connection conn = DriverManager.getConnection(url);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT count(*) AS total_records FROM `my-gcp-project.analytics.user_events`")) {

      if (rs.next()) {
        System.out.println("Total events recorded via impersonated SA: " + rs.getLong("total_records"));
      }
    }
  }
}
```

---

### CUJ 7: Stored Procedure Execution & Procedural Results

**Scenario**: Calling a BigQuery stored procedure or procedural script and extracting output results.

> [!IMPORTANT]
> **BigQuery Stored Procedure OUT Parameter Support**:
> Traditional JDBC `CallableStatement.registerOutParameter(...)` and `cstmt.getXXX(index)` methods are **not supported** for capturing `OUT` parameters. Because BigQuery's REST API returns query execution results as tabular data (`TableResult`) rather than parameter bind response buffers, `cstmt.getXXX()` will return `null`.
> 
> To retrieve output variables or procedural results from BigQuery stored procedures, use one of the two supported patterns below via standard `ResultSet` extraction.

#### Pattern A: Executing a Procedure that Returns a ResultSet
If a stored procedure executes `SELECT` statements in its body, call it directly using `Statement.executeQuery()`:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StoredProcedureResultSetCUJ {
  public static void main(String[] args) throws Exception {
    String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=my-project;OAuthType=3";

    try (Connection conn = DriverManager.getConnection(url);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("CALL `my-project.my_dataset.get_top_customers`()")) {

      while (rs.next()) {
        System.out.printf("Customer: %s, Total Spent: $%.2f%n", 
            rs.getString("customer_name"), rs.getDouble("total_spent"));
      }
    }
  }
}
```

#### Pattern B: Retrieving Procedure OUT Parameters via Multi-Statement Script
To retrieve `OUT` parameters from a procedure, execute a multi-statement procedural script that declares an output variable, passes it into the `CALL` statement, and selects the variable to return it as a `ResultSet`:

```java
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StoredProcedureOutParameterCUJ {
  public static void main(String[] args) throws Exception {
    String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=my-project;OAuthType=3";

    // Multi-statement script declaring an output variable and selecting it as a ResultSet
    String scriptSql = "DECLARE tax_out NUMERIC; "
        + "CALL `my-project.my_dataset.calculate_tax`(?, tax_out); "
        + "SELECT tax_out AS calculated_tax;";

    try (Connection conn = DriverManager.getConnection(url);
         PreparedStatement pstmt = conn.prepareStatement(scriptSql)) {

      // Bind input parameter ($1 = subtotal)
      pstmt.setBigDecimal(1, new BigDecimal("1000.00"));

      // Execute script and read OUT variable from the returned ResultSet
      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          BigDecimal taxAmount = rs.getBigDecimal("calculated_tax");
          System.out.println("Calculated Tax Amount: $" + taxAmount);
        }
      }
    }
  }
}
```

---

## 8. High-Throughput & Performance Tuning

For large dataset extractions and high-concurrency ingestion, tune the following connection options:

### High-Throughput Storage Read API (HTAPI) Deep Dive

The driver can switch query result extraction from standard REST JSON pagination to high-speed gRPC streams using the **BigQuery Storage Read API** (Apache Arrow over gRPC).

#### HTAPI Property Relationship & Activation Matrix

The decision to activate the Read API for a query is governed by four interconnected connection properties:

| Property Name | Connection Parameter | Default Value | Functional Role |
| :--- | :--- | :---: | :--- |
| **`EnableHighThroughputAPI`** | `EnableHighThroughputAPI=true` | `false` | **Master Toggle**: Must be `true` to evaluate Read API switching. |
| **`HighThroughputMinTableSize`** | `HighThroughputMinTableSize=10000` | `10000` | **Minimum Row Threshold**: Minimum total rows (`totalRows`) required. |
| **`HighThroughputActivationRatio`** | `HighThroughputActivationRatio=2` | `2` | **Page Ratio Threshold**: `totalRows / pageSize` must exceed this ratio. |
| **`MaxResults`** | `MaxResults=1000` | `1000` (or server default) | **Page Size (`pageSize`)**: Controls rows per page in standard REST calls. |

#### Activation Formula & Internal Safeguards

The driver evaluates Storage Read API activation using the following rules:

$$\text{Storage Read API Active} = \text{EnableHighThroughputAPI} \land \text{meetsReadRatio}$$

Where `meetsReadRatio` requires **ALL** of the following conditions to pass:

1. `EnableHighThroughputAPI == true`
2. `totalRows >= HighThroughputMinTableSize` (default: $\ge 10,000$ rows)
3. `results.hasNextPage() == true` (**Crucial Safeguard**): If all rows fit in the first response page, the driver will **never** switch to Read API, avoiding redundant gRPC calls and memory re-allocations.
4. **Page Ratio Test**: $\frac{\text{totalRows}}{\text{pageSize}} > \text{HighThroughputActivationRatio}$

#### How to Manipulate Properties to Control Read API Activation

##### 1. Force Read API for Smaller Query Results ($\ge 100$ rows)
To trigger the Read API even for small analytical datasets:
```
jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=my-project;OAuthType=0;EnableHighThroughputAPI=true;HighThroughputMinTableSize=100;HighThroughputActivationRatio=0;MaxResults=50
```
*Why this works*: `totalRows` ($100$) $\ge$ `MinTableSize` ($100$), `pageSize` ($50$) forces `hasNextPage() = true`, and $\frac{100}{50} = 2 > 0$ (`ActivationRatio`).

##### 2. High-Volume Production Defaults ($\ge 100,000$ rows)
With standard defaults (`EnableHighThroughputAPI=true`):
- For a $100,000$ row result set with `pageSize = 1,000`: $\frac{100,000}{1,000} = 100 > 2$ (`ActivationRatio`).
- The driver transparently switches to the gRPC Storage Read API stream.

##### 3. Automatic Fallback on Permission Failure
If `EnableHighThroughputAPI=true` is set but the connecting service account lacks the `BigQuery Read Session User` IAM role, the driver catches the `PERMISSION_DENIED` status and **automatically falls back to standard REST JSON pagination** without failing the application's query.

### Storage Write API (SWA) Configuration Property Matrix

The **BigQuery Storage Write API** provides high-performance gRPC streaming ingestion for batch `PreparedStatement.executeBatch()` operations. The behavior and streaming thresholds are governed by three connection properties:

#### 1. SWA Property Reference

| Property Name | Connection Parameter | Default Value | Functional Role |
| :--- | :--- | :---: | :--- |
| **`EnableWriteAPI`** | `EnableWriteAPI=true` | `false` | **Master Toggle**: Must be set to `true` to enable gRPC Storage Write API stream ingestion. |
| **`SWA_ActivationRowCount`** | `SWA_ActivationRowCount=3` | `3` | **Activation Threshold**: Minimum number of row batches added via `addBatch()` required to trigger SWA streaming. |
| **`SWA_AppendRowCount`** | `SWA_AppendRowCount=1000` | `1000` | **Stream Chunk Size**: Maximum number of rows packed into a single gRPC append stream payload before flushing. |

#### 2. SWA Activation Formula & Fallback Safeguard

The driver evaluates Storage Write API activation during `PreparedStatement.executeBatch()` as follows:

$$\text{Storage Write API Active} = \text{EnableWriteAPI} \land (\text{batchParameters.size()} \ge \text{SWA\_ActivationRowCount})$$

- **Above Threshold ($\ge \text{SWA\_ActivationRowCount}$)**: The driver opens a gRPC Storage Write API stream, converts batch parameters to JSON rows, appends rows in chunks of `SWA_AppendRowCount`, and commits the write stream.
- **Below Threshold ($< \text{SWA\_ActivationRowCount}$)**: The driver falls back to standard REST DML query concatenation (`INSERT INTO ...; INSERT INTO ...;`), preventing unnecessary gRPC channel overhead for small batches.

#### 3. SWA Configuration Scenarios Matrix

| Workload Scenario | `EnableWriteAPI` | `SWA_ActivationRowCount` | `SWA_AppendRowCount` | Executed Ingestion Mechanism | Enterprise Use Case |
| :--- | :---: | :---: | :---: | :--- | :--- |
| **Standard DML (Default)** | `false` | `3` (ignored) | `1000` (ignored) | Concatenated REST SQL DML (`INSERT INTO ...;`) | Small transactional DML; standard SQL compatibility. |
| **Default High-Throughput ETL** | `true` | `3` | `1000` | gRPC SWA stream for batches $\ge 3$, flushes every 1,000 rows | Standard batch loader applications (Spring Batch, Spark). |
| **Real-Time Micro-Batching** | `true` | `1` | `100` | gRPC SWA stream for any batch $\ge 1$, flushes every 100 rows | High-frequency streaming events (Kafka/Flink consumers). |
| **High-Volume Bulk Ingestion** | `true` | `100` | `5000` | gRPC SWA stream for batches $\ge 100$, flushes in 5,000 row chunks | Large nightly bulk ETL loading millions of records. |
| **Small Batch Fallback** | `true` | `100` | `1000` | Concatenated REST SQL DML (for batches $< 100$ rows) | Adaptive pipelines using REST for small batches, gRPC for large ones. |

---

### Additional Performance Tuning Options

- **Metadata Thread Pooling**: For applications fetching schema catalog metadata across multiple datasets, set `;MetaDataFetchThreadCount=64` to parallelize catalog RPC calls.
- **Internal Queue Buffering**: The driver maintains an internal asynchronous row buffer (default 10,000 rows) to decouple network fetch RPCs from client `ResultSet.next()` iteration.

---

### Custom Endpoints, Private Service Connect (PSC) & Universe Domains

For enterprise environments using **VPC Service Controls**, **Private Service Connect (PSC)**, **Regional Endpoints**, or **Trusted Partner Cloud (TPC)** instances, the driver supports full endpoint overriding and universe domain configuration.

#### 1. Endpoint Overrides (`EndpointOverrides`)

The `EndpointOverrides` property allows redirecting traffic for individual Google Cloud services to private IP endpoints, regional gateways, or corporate proxy targets.

**Format**:
```
EndpointOverrides=SERVICE_KEY_1=URI_1,SERVICE_KEY_2=URI_2;
```

**Supported Service Keys**:

| Service Key | Target Service | Default Endpoint URI | Typical Override Use Case |
| :--- | :--- | :--- | :--- |
| **`BIGQUERY`** | BigQuery Core REST API | `https://www.googleapis.com/bigquery/v2/` | Regional endpoints (e.g. `us-east4`) or PSC private VIPs. |
| **`READ_API`** | Storage Read API (HTAPI) | `bigquerystorage.googleapis.com:443` | Private gRPC endpoints for high-throughput extractions. |
| **`OAUTH2`** | Google OAuth2 Token Server | `https://oauth2.googleapis.com/token` | Private OAuth token exchange gateways. |
| **`STS`** | Security Token Service | `https://sts.googleapis.com` | Workload Identity / BYOID token exchange. |

**Example - Private Service Connect (PSC) Endpoint**:
```
jdbc:bigquery://https://bigquery-privateendpoint.p.googleapis.com:443
  ;ProjectId=my-gcp-project
  ;OAuthType=0
  ;EndpointOverrides=BIGQUERY=https://bigquery-privateendpoint.p.googleapis.com,OAUTH2=https://oauth2-private.p.googleapis.com/token
```

**Example - Regional BigQuery Endpoint Override**:
```
jdbc:bigquery://https://us-east4-bigquery.googleapis.com:443
  ;ProjectId=my-gcp-project
  ;OAuthType=0
  ;EndpointOverrides=BIGQUERY=https://us-east4-bigquery.googleapis.com
```

#### 2. Custom Endpoint Requirements per Authentication Type (`OAuthType`)

The interaction between custom endpoint properties (`EndpointOverrides`, `PrivateServiceConnectUris`, `universeDomain`) and authentication flows (`OAuthType`) behaves as follows:

| Authentication Mode (`OAuthType`) | Applicable Custom Endpoint Keys | Endpoint Override Behavior & Actions | Primary Enterprise Use Case |
| :--- | :--- | :--- | :--- |
| **`OAuthType=0`<br>(Service Account)** | • `OAUTH2`<br>• `BIGQUERY`<br>• `READ_API`<br>• `universeDomain` | • Overrides OAuth token exchange server URI via `OAUTH2`<br>• Sets custom universe domain for TPC instances | Private service account key token exchange via internal proxy; regional or PSC endpoints. |
| **`OAuthType=1`<br>(User Account)** | • `OAUTH2`<br>• `BIGQUERY`<br>• `READ_API` | • Overrides 3-legged browser authorization token server via `OAUTH2` | Desktop browser 3-legged OAuth code exchange via private corporate authorization server. |
| **`OAuthType=2`<br>(Pre-generated Token)** | • `OAUTH2` (Refresh Token)<br>• `BIGQUERY`<br>• `READ_API`<br>• `universeDomain` | • Overrides token refresh endpoint via `OAUTH2` for refresh tokens<br>• Bypasses token server for static access tokens | Custom token refresh server for long-running batch jobs; direct static access token routing. |
| **`OAuthType=3`<br>(ADC)** | • `BIGQUERY`<br>• `READ_API`<br>• `PrivateServiceConnectUris` | • Routes BigQuery REST query calls and Storage Read gRPC streams via PSC VIPs or regional endpoints | On-premise or GKE workload running ADC routed strictly over Private Service Connect (PSC). |
| **`OAuthType=4`<br>(External Account / BYOID)** | • `STS`<br>• `BYOIDTokenUri`<br>• `BYOIDSAImpersonationUri`<br>• `BIGQUERY`<br>• `READ_API`<br>• `universeDomain` | • Configures Security Token Service URL (`token_url`) via `STS`/`BYOIDTokenUri`<br>• Configures custom universe domain for external account config | Multi-cloud Workload Identity Federation (AWS/Azure/OIDC) exchanging tokens via custom STS VIP. |
| **Impersonation<br>(`ServiceAccountImpersonationEmail`)** | • Applies across ALL `OAuthType` modes | • Routes IAM Credentials API impersonation calls over configured BigQuery and OAuth endpoints | Cross-project or elevated role execution via Service Account Impersonation. |

---

#### 3. Endpoint Configuration Code Recipes by `OAuthType`

##### Recipe A: Service Account (`OAuthType=0`) with Private OAuth & BigQuery PSC
```java
// Service Account authentication routed entirely over Private Service Connect (PSC) VIPs
String url = "jdbc:bigquery://https://bigquery-privateendpoint.p.googleapis.com:443"
    + ";ProjectId=my-gcp-project"
    + ";OAuthType=0"
    + ";OAuthServiceAcctEmail=sa-data-reader@my-gcp-project.iam.gserviceaccount.com"
    + ";OAuthPvtKeyPath=/var/secrets/bq-sa-key.json"
    + ";EndpointOverrides="
        + "BIGQUERY=https://bigquery-privateendpoint.p.googleapis.com,"
        + "OAUTH2=https://oauth2-private.p.googleapis.com/token,"
        + "READ_API=https://storage-privateendpoint.p.googleapis.com";

Connection conn = DriverManager.getConnection(url);
```

##### Recipe B: Pre-Generated Refresh Token (`OAuthType=2`) with Custom Token Server
```java
// Refresh token flow pointing to an internal corporate OAuth token refresh server
String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443"
    + ";ProjectId=my-gcp-project"
    + ";OAuthType=2"
    + ";OAuthRefreshToken=1//04_example_refresh_token"
    + ";OAuthClientId=my-client-id.apps.googleusercontent.com"
    + ";OAuthClientSecret=my-client-secret"
    + ";EndpointOverrides=OAUTH2=https://oauth-proxy.internal.corp.com/token";

Connection conn = DriverManager.getConnection(url);
```

##### Recipe C: Workload Identity Federation (`OAuthType=4` / BYOID) with Custom STS Endpoint
```java
// AWS / OIDC Workload Identity exchanging tokens via custom Security Token Service (STS) endpoint
String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443"
    + ";ProjectId=my-gcp-project"
    + ";OAuthType=4"
    + ";BYOID_AudienceUri=//iam.googleapis.com/projects/123456789/locations/global/workloadIdentityPools/aws-pool/providers/aws-provider"
    + ";BYOID_SubjectTokenType=urn:ietf:params:aws:token-type:aws-sigv4"
    + ";BYOID_CredentialSource={\"environment_id\":\"aws-1\",\"region_url\":\"http://169.254.169.254/latest/meta-data/placement/availability-zone\"}"
    + ";BYOID_TokenUri=https://sts-privateendpoint.p.googleapis.com/v1/token"
    + ";EndpointOverrides=STS=https://sts-privateendpoint.p.googleapis.com/v1/token";

Connection conn = DriverManager.getConnection(url);
```

##### Recipe D: Regional Endpoint Override with Application Default Credentials (`OAuthType=3`)
```java
// ADC authentication targeting a regional BigQuery REST endpoint (us-east4)
String url = "jdbc:bigquery://https://us-east4-bigquery.googleapis.com:443"
    + ";ProjectId=my-gcp-project"
    + ";OAuthType=3"
    + ";EndpointOverrides=BIGQUERY=https://us-east4-bigquery.googleapis.com";

Connection conn = DriverManager.getConnection(url);
```

---

#### 4. Private Service Connect URIs (`PrivateServiceConnectUris`)

For VPC setups using explicit Private Service Connect URI aliases:
```
jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443
  ;ProjectId=my-gcp-project
  ;OAuthType=0
  ;PrivateServiceConnectUris=BIGQUERY=https://bigquery-privateendpoint.p.googleapis.com
```

#### 5. Custom Universe Domains (`universeDomain`)

To target Google Cloud Trusted Partner Cloud (TPC) or non-default Universe Domain instances, specify `universeDomain`:

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
    url: jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=my-gcp-project;DefaultDataset=my_dataset;OAuthType=0;OAuthServiceAcctEmail=sa@my-project.iam.gserviceaccount.com;OAuthPvtKeyPath=/path/to/key.json
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
String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443"
    + ";ProjectId=my-gcp-project"
    + ";OAuthType=0"
    + ";LogLevel=5"                      // Set log level (1=SEVERE to 7=FINEST)
    + ";LogPath=/var/log/bigquery-jdbc"; // Output directory for log files
```

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
