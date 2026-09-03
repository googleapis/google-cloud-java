# BigQuery Storage APIs Deep Dive & Tuning Guide

This document provides architectural details, property matrices, activation criteria, and workload tuning scenarios for the **BigQuery Storage Read API** and **BigQuery Storage Write API** integrated into the BigQuery JDBC Driver.

---

## 1. High-Throughput Storage Read API (HTAPI)

The Storage Read API streams query result sets over high-speed gRPC channels using Apache Arrow format, bypassing standard REST JSON serialization for large datasets.

### Property Reference

| Property Name | Connection Parameter | Default Value | Functional Role |
| :--- | :--- | :---: | :--- |
| **`EnableHighThroughputAPI`** | `EnableHighThroughputAPI=true` | `false` | **Master Toggle**: Must be `true` to enable Read API evaluation. |
| **`HighThroughputMinTableSize`** | `HighThroughputMinTableSize=10000` | `10000` | **Minimum Row Threshold**: Minimum total rows (`totalRows`) required. |
| **`HighThroughputActivationRatio`** | `HighThroughputActivationRatio=2` | `2` | **Page Ratio Threshold**: `totalRows / MaxResults` ratio required. |
| **`MaxResults`** | `MaxResults=10000` | `10000` | **Page Size**: Controls rows per page in standard REST calls. |

### Activation Criteria & Fallback Mechanics

When `EnableHighThroughputAPI=true` is set, the driver transparently switches to the Storage Read API if all of the following conditions are met:

1. **Master Toggle**: `EnableHighThroughputAPI=true` is set.
2. **Minimum Row Threshold**: The query returns at least `HighThroughputMinTableSize` rows (default: $\ge 10,000$ rows).
3. **Multiple Response Pages**: The result set spans more than one page (total rows exceed `MaxResults`). If all rows fit on page 1, standard REST is used to avoid unnecessary gRPC stream setup.
4. **Activation Ratio Test**: The ratio of total rows to page size ($\frac{\text{totalRows}}{\text{MaxResults}}$) exceeds `HighThroughputActivationRatio` (default: $> 2$).

> [!NOTE]
> **Automatic Permission Fallback**: If `EnableHighThroughputAPI=true` is set but the connecting principal lacks the `BigQuery Read Session User` IAM role, the driver catches the `PERMISSION_DENIED` status and automatically falls back to standard REST JSON pagination.

### Workload Scenarios Matrix

| Workload Scenario | `EnableHighThroughputAPI` | `HighThroughputMinTableSize` | `HighThroughputActivationRatio` | `MaxResults` | Execution Mechanism | Use Case |
| :--- | :---: | :---: | :---: | :---: | :--- | :--- |
| **Standard REST (Default)** | `false` | `10000` (ignored) | `2` (ignored) | `10000` | REST JSON Pagination | Small/medium queries; standard REST security policies. |
| **Default Production Extractions** | `true` | `10000` | `2` | `10000` | gRPC Storage Read API (for results $> 20,000$ rows) | Standard analytical reports and ETL extracts. |
| **Aggressive Streaming** | `true` | `100` | `0` | `50` | gRPC Storage Read API (for results $\ge 100$ rows) | High-speed streaming for smaller analytical datasets. |
| **Bulk ETL Analytics** | `true` | `50000` | `5` | `10000` | gRPC Storage Read API (for results $> 50,000$ rows) | Large multi-gigabyte dataset extractions. |

---

## 2. Storage Write API (SWA)

The Storage Write API streams high-throughput bulk insertions over gRPC channels for `PreparedStatement.executeBatch()` calls.

### Property Reference

| Property Name | Connection Parameter | Default Value | Functional Role |
| :--- | :--- | :---: | :--- |
| **`EnableWriteAPI`** | `EnableWriteAPI=true` | `false` | **Master Toggle**: Must be `true` to enable Storage Write API streaming. |
| **`SWA_ActivationRowCount`** | `SWA_ActivationRowCount=3` | `3` | **Activation Threshold**: Minimum batch size added via `addBatch()` required to trigger SWA. |
| **`SWA_AppendRowCount`** | `SWA_AppendRowCount=1000` | `1000` | **Chunk Size**: Maximum rows per gRPC append payload before flushing. |

### Activation Criteria & Fallback Mechanics

When `EnableWriteAPI=true` is set, the driver evaluates the batch size during `PreparedStatement.executeBatch()`:

- **At or Above Threshold ($\ge \text{SWA\_ActivationRowCount}$)**: The driver opens a gRPC Storage Write stream and appends batch records in payload chunks governed by `SWA_AppendRowCount`.
- **Below Threshold ($< \text{SWA\_ActivationRowCount}$)**: The driver uses standard SQL DML (`INSERT INTO ...`) to avoid gRPC stream overhead for tiny batches.

### Workload Scenarios Matrix

| Workload Scenario | `EnableWriteAPI` | `SWA_ActivationRowCount` | `SWA_AppendRowCount` | Execution Mechanism | Use Case |
| :--- | :---: | :---: | :---: | :--- | :--- |
| **Standard SQL DML (Default)** | `false` | `3` (ignored) | `1000` (ignored) | Concatenated REST SQL DML | Small transactional DML; standard SQL compatibility. |
| **Default High-Throughput ETL** | `true` | `3` | `1000` | gRPC SWA stream (batches $\ge 3$, flushes per 1,000 rows) | Standard batch loader applications (Spring Batch, Spark). |
| **Real-Time Micro-Batching** | `true` | `1` | `100` | gRPC SWA stream (batches $\ge 1$, flushes per 100 rows) | High-frequency streaming events (Kafka/Flink consumers). |
| **High-Volume Bulk Ingestion** | `true` | `100` | `5000` | gRPC SWA stream (batches $\ge 100$, flushes per 5,000 rows) | Large nightly bulk ETL loading millions of records. |
