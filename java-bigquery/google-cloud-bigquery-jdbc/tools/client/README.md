# JDBC Client Tool

This directory contains a simple Java tool to interact with BigQuery via the JDBC driver. It can be used to execute queries and inspect database metadata.

## Compilation

To compile the client, run:

```bash
make
```

This will generate `JDBCClient.class`.

## Usage

The Makefile provides convenient targets to run the client. You can override default variables on the command line.

Common variables:
- `URL`: JDBC connection URL (defaults to public BigQuery endpoint)
- `CREDENTIALS`: Path to service account JSON key (defaults to `$GOOGLE_APPLICATION_CREDENTIALS`)
- `OUTPUT`: Set to `false` to suppress query result output (defaults to `true`)
- `EXTRA_ARGS`: Extra arguments to pass to the client (e.g., `EXTRA_ARGS="--table my_table"`)

### Query Examples

#### Run a simple query

```bash
make query QUERY="SELECT 1"
```

#### Generate dummy data query

```bash
make query-generated ROWS=10 COLS=5
```

#### Run query with no output (metrics only)

Useful for performance testing.

```bash
make query QUERY="SELECT * FROM my_dataset.my_table LIMIT 1000" OUTPUT=false
```

### Metadata Examples

The tool supports calling `DatabaseMetaData` methods.

#### Get Tables (returns ResultSet)

```bash
make metadata METHOD=getTables
```

#### Get Columns (returns ResultSet)

```bash
make metadata METHOD=getColumns EXTRA_ARGS="--table my_table"
```

#### Get Database Product Name (returns String)

Methods that take no arguments can be called via reflection.

```bash
make metadata METHOD=getDatabaseProductName
```

#### Get JDBC Major Version (returns int)

```bash
make metadata METHOD=getJDBCMajorVersion
```
