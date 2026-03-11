# BigQuery Benchmark
This directory contains benchmarks for BigQuery client.

## Usage
From the `google-cloud-bigquery` directory, run
`mvn compile exec:java -Dexec.mainClass=com.google.cloud.bigquery.benchmark.Benchmark -Dexec.args="src/benchmark/java/com/google/cloud/bigquery/benchmark/queries.json"`

BigQuery service caches requests so the benchmark should be run
at least twice, disregarding the first result.
