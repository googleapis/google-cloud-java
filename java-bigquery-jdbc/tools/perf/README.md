# JDBC Performance Testing Tools

This directory contains tools for running performance benchmarks on the BigQuery JDBC driver.

## Files

- `run_perf.py`: A Python script that orchestrates running the tests, collecting metrics, and displaying results in a table view.
- `Makefile`: A convenience wrapper to run common test configurations.

## Prerequisites

- Python 3
- Java 11 or later
- BigQuery JDBC driver JAR(s) to test.

*Note: The Java client (`JDBCClient`) is automatically compiled when using the Makefile.*

## Running Tests via Makefile

The easiest way to run tests is using the provided `Makefile`. It defines targets for REST API and High Throughput API (HTAPI) modes.

### Defaults

The Makefile uses the following defaults which can be overridden:

- `ITERATIONS`: 5
- `ROWS`: 1000
- `COLS`: 5
- `JAR1`: `../../drivers/google-cloud-bigquery-jdbc-0.9.0-all.jar`
- `PROJECT_ID`: `bigquery-devtools-drivers`
- `CREDENTIALS`: Value of `$GOOGLE_APPLICATION_CREDENTIALS`

### Examples

#### Run REST API tests with defaults

```bash
make run-rest
```

#### Run HTAPI tests with custom iterations and rows

```bash
make run-htapi ITERATIONS=3 ROWS=50000
```

#### Compare two drivers

To compare two different driver JARs, provide `JAR2` (and optionally `CLASS2` if different from default):

```bash
make run-rest JAR1=path/to/driver1.jar JAR2=path/to/driver2.jar
```

## Running Tests via Python Script

For more control, you can run `run_perf.py` directly.

### Arguments

- `--url`: (Required) JDBC connection URL.
- `--jar1`: (Required) Path to the first driver JAR.
- `--jar2`: Path to the second driver JAR (optional, for comparison).
- `--class1`: Class name for the first driver (default: `com.google.cloud.bigquery.jdbc.BigQueryDriver`).
- `--class2`: Class name for the second driver (default: `com.google.cloud.bigquery.jdbc.BigQueryDriver`).
- `-n`, `--iterations`: Number of iterations to run (default: 5).
- `--generate-rows`: Number of rows to generate via query (default: 0).
- `--generate-cols`: Number of columns to generate via query (default: 5).
- `--query`: A specific query to run (if not using generated data).
- `--output-md`: Append results as a markdown table to this file.
- `--filter-metrics`: Comma-separated list of metrics to include in the markdown table.

### Examples

#### Run a single driver with generated data

```bash
python3 run_perf.py --url "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=my-project;OAuthType=3" --jar1 path/to/driver.jar --generate-rows 1000 -n 3
```

#### Compare two drivers with a specific query

```bash
python3 run_perf.py --url "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=my-project;OAuthType=3" --jar1 path/to/driver1.jar --jar2 path/to/driver2.jar --query "SELECT * FROM my_dataset.my_table LIMIT 1000"
```
