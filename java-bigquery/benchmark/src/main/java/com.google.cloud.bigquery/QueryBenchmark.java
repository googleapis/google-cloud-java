/*
 * Copyright 2020 Google LLC
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

import java.util.List;
import java.util.concurrent.TimeUnit;
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

@Fork(value = 1)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class QueryBenchmark {

  private static final String NYCYELLOWLIMIT1K = "SELECT * FROM `nyc-tlc.yellow.trips` LIMIT 10000";
  private static final String NYCYELLOWLIMIT10K =
      "SELECT * FROM `nyc-tlc.yellow.trips` LIMIT 100000";
  private static final String NYCYELLOWLIMIT100K =
      "SELECT * FROM `nyc-tlc.yellow.trips` LIMIT 1000000";
  private static final String WIKISAMPLESORDEREDLIMIT1K =
      "SELECT title FROM `bigquery-public-data.samples.wikipedia` ORDER BY title LIMIT 1000";
  private static final String CURRENTTIMESTAMP = "SELECT CURRENT_TIMESTAMP() as ts";
  private static final String SESSIONUSER = "SELECT SESSION_USER() as ts";
  private static final String LITERALS = "SELECT 1 as i, 3.14 as pi";
  private static final String INVALIDQUERY =
      "CREATE OR REPLACE SELECT * FROM UPDATE TABLE SET `nyc-tlc.yellow.trips`";

  private BigQuery bigquery;

  @Setup
  public void setUp() {
    this.bigquery = BigQueryOptions.getDefaultInstance().getService();
  }

  @State(Scope.Benchmark)
  public static class QueryParams {

    @Param({
      NYCYELLOWLIMIT1K,
      NYCYELLOWLIMIT10K,
      NYCYELLOWLIMIT100K,
      WIKISAMPLESORDEREDLIMIT1K,
      CURRENTTIMESTAMP,
      SESSIONUSER,
      LITERALS,
      INVALIDQUERY
    })
    public String queries;
  }

  private void queryPerform(String queries, Blackhole blackhole) throws Exception {
    TableResult result =
        bigquery.query(QueryJobConfiguration.newBuilder(queries).setUseLegacySql(false).build());
    for (List<FieldValue> row : result.iterateAll()) {
      blackhole.consume(row.size());
    }
    while (result.hasNextPage()) {
      result = result.getNextPage();
      for (List<FieldValue> row : result.iterateAll()) {
        blackhole.consume(row.size());
      }
    }
  }

  @Benchmark
  public void query(QueryParams queryParams, Blackhole blackhole) throws Exception {
    queryPerform(queryParams.queries, blackhole);
  }
}
