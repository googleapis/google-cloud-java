/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Level;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@Fork(value = 1)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1)
@Measurement(iterations = 3)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ConnImplBenchmark {
  @Param({"500000", "1000000", "10000000", "50000000", "100000000"}) // 500K, 1M, 10M, 50M and 100M
  public int rowLimit;

  private ConnectionSettings connectionSettingsReadAPIEnabled, connectionSettingsReadAPIDisabled;
  private final String QUERY =
      "SELECT * FROM bigquery-public-data.new_york_taxi_trips.tlc_yellow_trips_2017 LIMIT %s";

  @Setup
  public void setUp() throws IOException {
    java.util.logging.Logger.getGlobal().setLevel(Level.ALL);

    connectionSettingsReadAPIEnabled = ConnectionSettings.newBuilder()
            .setUseReadAPI(true)
            .setMaxResults(500L)
            .setJobTimeoutMs(Long.MAX_VALUE)
            .build();
    connectionSettingsReadAPIDisabled = ConnectionSettings.newBuilder()
            .setUseReadAPI(false)
            .build();
  }

  @Benchmark
  public void iterateRecordsWithBigQuery_Query(Blackhole blackhole) throws InterruptedException {
    String selectQuery = String.format(QUERY, rowLimit);
    BigQuery bigQuery = BigQueryOptions.getDefaultInstance().getService();
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(selectQuery).setUseLegacySql(false).build();
    TableResult result = bigQuery.query(config);
    long hash = 0L;
    int cnt = 0;
    long lastTime = System.currentTimeMillis();
    System.out.println("\n Running");
    for (FieldValueList row : result.iterateAll()) {
      hash += computeHash(row.get("vendor_id"), FieldValue::getStringValue);
      hash += computeHash(row.get("pickup_datetime"), FieldValue::getStringValue);
      hash += computeHash(row.get("dropoff_datetime"), FieldValue::getStringValue);
      hash += computeHash(row.get("passenger_count"), FieldValue::getLongValue);
      hash += computeHash(row.get("trip_distance"), FieldValue::getDoubleValue);
      hash += computeHash(row.get("rate_code"), FieldValue::getStringValue);
      hash += computeHash(row.get("store_and_fwd_flag"), FieldValue::getStringValue);
      hash += computeHash(row.get("payment_type"), FieldValue::getStringValue);
      hash += computeHash(row.get("fare_amount"), FieldValue::getDoubleValue);
      hash += computeHash(row.get("extra"), FieldValue::getDoubleValue);
      hash += computeHash(row.get("mta_tax"), FieldValue::getDoubleValue);
      hash += computeHash(row.get("tip_amount"), FieldValue::getDoubleValue);
      hash += computeHash(row.get("tolls_amount"), FieldValue::getDoubleValue);
      hash += computeHash(row.get("imp_surcharge"), FieldValue::getDoubleValue);
      hash += computeHash(row.get("airport_fee"), FieldValue::getDoubleValue);
      hash += computeHash(row.get("total_amount"), FieldValue::getDoubleValue);
      hash += computeHash(row.get("pickup_location_id"), FieldValue::getStringValue);
      hash += computeHash(row.get("dropoff_location_id"), FieldValue::getStringValue);
      hash += computeHash(row.get("data_file_year"), FieldValue::getLongValue);
      hash += computeHash(row.get("data_file_month"), FieldValue::getLongValue);

      if (++cnt % 100_000 == 0) {
        long now = System.currentTimeMillis();
        long duration = now - lastTime;
        System.out.println("ROW " + cnt + " Time: " + duration + " ms");
        lastTime = now;
      }
    }
    System.out.println(cnt + " records processed using bigquery.query");
    blackhole.consume(hash);
  }

  @Benchmark
  public void iterateRecordsUsingReadAPI(Blackhole blackhole)
      throws InterruptedException, BigQuerySQLException {
    Connection connectionReadAPIEnabled =
        BigQueryOptions.getDefaultInstance()
            .getService()
            .createConnection(connectionSettingsReadAPIEnabled);
    String selectQuery = String.format(QUERY, rowLimit);
    long hash = 0L;
    try {
      BigQueryResult bigQueryResultSet = connectionReadAPIEnabled.executeSelect(selectQuery);
      hash = getResultHash(bigQueryResultSet);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      connectionReadAPIEnabled.close(); // IMP to kill the bg workers
    }
    blackhole.consume(hash);
  }

  @Benchmark
  public void iterateRecordsWithoutUsingReadAPI(Blackhole blackhole)
      throws InterruptedException, BigQuerySQLException {
    Connection connectionReadAPIDisabled =
        BigQueryOptions.getDefaultInstance()
            .getService()
            .createConnection(connectionSettingsReadAPIDisabled);
    String selectQuery = String.format(QUERY, rowLimit);
    long hash = 0L;
    try {
      BigQueryResult bigQueryResultSet = connectionReadAPIDisabled.executeSelect(selectQuery);
      hash = getResultHash(bigQueryResultSet);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      connectionReadAPIDisabled.close(); // IMP to kill the bg workers
    }
    blackhole.consume(hash);
  }

  private long getResultHash(BigQueryResult bigQueryResultSet) throws SQLException {
    ResultSet rs = bigQueryResultSet.getResultSet();
    long hash = 0L;
    int cnt = 0;
    long lastTime = System.currentTimeMillis();
    System.out.println("\n Running");
    while (rs.next()) {
      hash += computeHash(rs, "vendor_id", ResultSet::getString);
      hash += computeHash(rs, "pickup_datetime", ResultSet::getLong);
      hash += computeHash(rs, "dropoff_datetime", ResultSet::getLong);
      hash += computeHash(rs, "passenger_count", ResultSet::getLong);
      hash += computeHash(rs, "trip_distance", ResultSet::getDouble);
      hash += computeHash(rs, "rate_code", ResultSet::getString);
      hash += computeHash(rs, "store_and_fwd_flag", ResultSet::getString);
      hash += computeHash(rs, "payment_type", ResultSet::getString);
      hash += computeHash(rs, "fare_amount", ResultSet::getDouble);
      hash += computeHash(rs, "extra", ResultSet::getDouble);
      hash += computeHash(rs, "mta_tax", ResultSet::getDouble);
      hash += computeHash(rs, "tip_amount", ResultSet::getDouble);
      hash += computeHash(rs, "tolls_amount", ResultSet::getDouble);
      hash += computeHash(rs, "imp_surcharge", ResultSet::getDouble);
      hash += computeHash(rs, "airport_fee", ResultSet::getDouble);
      hash += computeHash(rs, "total_amount", ResultSet::getDouble);
      hash += computeHash(rs, "pickup_location_id", ResultSet::getString);
      hash += computeHash(rs, "dropoff_location_id", ResultSet::getString);
      hash += computeHash(rs, "data_file_year", ResultSet::getLong);
      hash += computeHash(rs, "data_file_month", ResultSet::getLong);

      if (++cnt % 100_000 == 0) {
        long now = System.currentTimeMillis();
        long duration = now - lastTime;
        System.out.println("ROW " + cnt + " Time: " + duration + " ms");
        lastTime = now;
      }
    }
    return hash;
  }

  private <T> long computeHash(
      ResultSet rs, String columnName, SQLFunction<ResultSet, T> extractor) {
    try {
      T value = extractor.apply(rs, columnName);
      return (value == null) ? 0 : value.hashCode();
    } catch (SQLException e) {
      return 0;
    }
  }

  @FunctionalInterface
  private interface SQLFunction<T, R> {
    R apply(T t, String columnName) throws SQLException;
  }

  private <T> long computeHash(FieldValue fieldValue, Function<FieldValue, T> extractor) {
    if (fieldValue == null || fieldValue.isNull()) {
      return 0;
    }
    T value = extractor.apply(fieldValue);
    return (value == null) ? 0 : value.hashCode();
  }

  public static void main(String[] args) throws Exception {
    Options opt = new OptionsBuilder().include(ConnImplBenchmark.class.getSimpleName()).build();
    new Runner(opt).run();
  }
}
