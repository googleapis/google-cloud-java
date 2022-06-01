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
  private long numBuffRows = 100000L;
  private final String DATASET = "new_york_taxi_trips";
  private final String QUERY =
      "SELECT * FROM bigquery-public-data.new_york_taxi_trips.tlc_yellow_trips_2017 LIMIT %s";
  public static final long NUM_PAGE_ROW_CNT_RATIO =
      10; // ratio of [records in the current page :: total rows] to be met to use read API
  public static final long NUM_MIN_RESULT_SIZE =
      200000; // min number of records to use to ReadAPI with

  @Setup
  public void setUp() throws IOException {
    java.util.logging.Logger.getGlobal().setLevel(Level.ALL);

    connectionSettingsReadAPIEnabled =
        ConnectionSettings.newBuilder()
            .setUseReadAPI(true) // enable read api
            .build();
    connectionSettingsReadAPIDisabled =
        ConnectionSettings.newBuilder()
            .setUseReadAPI(false) // disable read api
            .build();
  }

  @Benchmark
  // uses bigquery.query
  public void iterateRecordsWithBigQuery_Query(Blackhole blackhole) throws InterruptedException {
    String selectQuery = String.format(QUERY, rowLimit);
    BigQuery bigQuery = BigQueryOptions.getDefaultInstance().getService();
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(selectQuery).setUseLegacySql(false).build();
    TableResult result = bigQuery.query(config);
    long hash = 0L;
    int cnt = 0;
    System.out.print("\n Running");
    // iterate al the records and compute the hash
    for (FieldValueList row : result.iterateAll()) {
      hash +=
          row.get("vendor_id").getStringValue() == null
              ? 0
              : row.get("vendor_id").getStringValue().hashCode();
      hash +=
          row.get("pickup_datetime").getStringValue() == null
              ? 0
              : row.get("pickup_datetime").getStringValue().hashCode();
      hash +=
          row.get("dropoff_datetime").getStringValue() == null
              ? 0
              : row.get("dropoff_datetime").getStringValue().hashCode();
      hash +=
          row.get("passenger_count").getValue() == null
              ? 0
              : row.get("passenger_count").getLongValue();
      hash +=
          row.get("trip_distance").getValue() == null
              ? 0
              : row.get("trip_distance").getDoubleValue();
      hash +=
          row.get("pickup_longitude").getValue() == null
              ? 0
              : row.get("pickup_longitude").getDoubleValue();
      hash +=
          row.get("pickup_latitude").getValue() == null
              ? 0
              : row.get("pickup_latitude").getDoubleValue();
      hash +=
          row.get("rate_code").getStringValue() == null
              ? 0
              : row.get("rate_code").getStringValue().hashCode();
      hash +=
          row.get("store_and_fwd_flag").getStringValue() == null
              ? 0
              : row.get("store_and_fwd_flag").getStringValue().hashCode();
      hash +=
          row.get("payment_type").getStringValue() == null
              ? 0
              : row.get("payment_type").getStringValue().hashCode();
      hash +=
          row.get("pickup_location_id").getStringValue() == null
              ? 0
              : row.get("pickup_location_id").getStringValue().hashCode();
      hash +=
          row.get("dropoff_location_id").getStringValue() == null
              ? 0
              : row.get("dropoff_location_id").getStringValue().hashCode();
      hash +=
          row.get("dropoff_longitude").getValue() == null
              ? 0
              : row.get("dropoff_longitude").getDoubleValue();
      hash +=
          row.get("dropoff_latitude").getValue() == null
              ? 0
              : row.get("dropoff_latitude").getDoubleValue();
      hash +=
          row.get("fare_amount").getValue() == null ? 0 : row.get("fare_amount").getDoubleValue();
      hash += row.get("extra").getValue() == null ? 0 : row.get("extra").getDoubleValue();
      hash += row.get("mta_tax").getValue() == null ? 0 : row.get("mta_tax").getDoubleValue();
      hash += row.get("tip_amount").getValue() == null ? 0 : row.get("tip_amount").getDoubleValue();
      hash +=
          row.get("tolls_amount").getValue() == null ? 0 : row.get("tolls_amount").getDoubleValue();
      hash +=
          row.get("imp_surcharge").getValue() == null
              ? 0
              : row.get("imp_surcharge").getDoubleValue();
      hash +=
          row.get("total_amount").getValue() == null ? 0 : row.get("total_amount").getDoubleValue();

      if (++cnt % 100000 == 0) { // just to indicate the progress while long running benchmarks
        System.out.print(".");
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

  // Hashes all the 20 columns of all the rows
  private long getResultHash(BigQueryResult bigQueryResultSet) throws SQLException {
    ResultSet rs = bigQueryResultSet.getResultSet();
    long hash = 0L;
    int cnt = 0;
    System.out.print("\n Running");
    while (rs.next()) {
      hash += rs.getString("vendor_id") == null ? 0 : rs.getString("vendor_id").hashCode();
      hash +=
          rs.getString("pickup_datetime") == null ? 0 : rs.getString("pickup_datetime").hashCode();
      hash +=
          rs.getString("dropoff_datetime") == null
              ? 0
              : rs.getString("dropoff_datetime").hashCode();
      hash += rs.getLong("passenger_count");
      hash += rs.getDouble("trip_distance");
      hash += rs.getDouble("pickup_longitude");
      hash += rs.getDouble("pickup_latitude");
      hash += rs.getString("rate_code") == null ? 0 : rs.getString("rate_code").hashCode();
      hash +=
          rs.getString("store_and_fwd_flag") == null
              ? 0
              : rs.getString("store_and_fwd_flag").hashCode();
      hash += rs.getDouble("dropoff_longitude");
      hash += rs.getDouble("dropoff_latitude");
      hash += rs.getString("payment_type") == null ? 0 : rs.getString("payment_type").hashCode();
      hash += rs.getDouble("fare_amount");
      hash += rs.getDouble("extra");
      hash += rs.getDouble("mta_tax");
      hash += rs.getDouble("tip_amount");
      hash += rs.getDouble("tolls_amount");
      hash += rs.getDouble("imp_surcharge");
      hash += rs.getDouble("total_amount");
      hash +=
          rs.getString("pickup_location_id") == null
              ? 0
              : rs.getString("pickup_location_id").hashCode();
      hash +=
          rs.getString("dropoff_location_id") == null
              ? 0
              : rs.getString("dropoff_location_id").hashCode();
      if (++cnt % 100000 == 0) { // just to indicate the progress while long running benchmarks
        System.out.print(".");
      }
    }
    return hash;
  }

  public static void main(String[] args) throws Exception {
    Options opt = new OptionsBuilder().include(ConnImplBenchmark.class.getSimpleName()).build();
    new Runner(opt).run();
  }
}
