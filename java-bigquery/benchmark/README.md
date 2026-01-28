Benchmarking
============

To build all of the benchmarks:
```
# Run from benchmark directory
  cd benchmark
  mvn clean install
```

Set `GOOGLE_APPLICATION_CREDENTIALS`:
```
  export GOOGLE_APPLICATION_CREDENTIALS=path/to/service_account.json
```

To run a benchmark jar, run the following command
```
# Run from benchmark directory
  cd benchmark
  java -jar target/benchmark.jar
```

To run ConnImplBenchmark, run the following command
```
# Run from benchmark directory
  cd benchmark
  java -jar target/benchmark.jar com.google.cloud.bigquery.ConnImplBenchmark
```
