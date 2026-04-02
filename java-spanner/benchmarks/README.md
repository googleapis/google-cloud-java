# Latency Tests

This directory contains a utility to compare latencies of different public methods supported by the Java Client Library.
The tests use simple statements that operate on a single row at a time.

The goal is that addition of new features should not add any latency.

## Setup Test Database

All tests in this directory use a database with a single table. Follow these steps to create a
database that you can use for these tests:

1. Set up some environment variables. These will be used by all following steps.
```shell
export SPANNER_CLIENT_BENCHMARK_GOOGLE_CLOUD_PROJECT=my-project
export SPANNER_CLIENT_BENCHMARK_SPANNER_INSTANCE=my-instance
export SPANNER_CLIENT_BENCHMARK_SPANNER_DATABASE=my-database
```

2. Create the Cloud Spanner database if it does not already exist using Pantheon UI.
3. Create the test table in the Cloud Spanner database. The tests assume the below DDL for the table.

```shell
CREATE TABLE FOO ( id INT64 NOT NULL, BAZ INT64, BAR INT64, ) PRIMARY KEY(id);
```
4. Generate some random test data that can be used for the benchmarking. This can be done 
by using the script `bulkInsertTestData` in class `BenchmarkingUtilityScripts` to bulk
load 1000000 rows into this table. A large table makes sure that the queries are well 
randomised and there is no hot-spotting.

## Running

The benchmark application includes Java Client as a dependency. Modify the dependency 
version in `pom.xml` file if you wish to benchmark a different version of Java Client.


* The below command uses only 1 thread and 1000 operations. So the total load would 
be 1000 read operations. The test also uses multiplexed sessions.
```shell
mvn clean compile exec:java -Dexec.args="--clients=1 --operations=1000 --multiplexed=true"
```

* The below command uses 10 threads, so at any point in time there would be roughly
10 concurrent requests. The total load of the benchmark would be 50000 read operations. 
```shell
mvn clean compile exec:java -Dexec.args="--clients=10 --operations=5000 --multiplexed=true"
```

* To run the same test without multiplexed sessions avoid passing `multiplexed` flag. This will 
make sure that tests uses regular sessions.
```shell
mvn clean compile exec:java -Dexec.args="--clients=10 --operations=5000"
```