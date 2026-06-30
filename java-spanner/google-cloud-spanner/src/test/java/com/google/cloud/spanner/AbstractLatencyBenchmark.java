/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner;

import com.google.common.base.MoreObjects;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractLatencyBenchmark {

  static final String SELECT_QUERY = "SELECT ID FROM FOO WHERE ID = @id";
  static final String UPDATE_QUERY = "UPDATE FOO SET BAR=1 WHERE ID = @id";
  static final String ID_COLUMN_NAME = "id";

  /**
   * Used to determine how many concurrent requests are allowed. For ex - To simulate a low QPS
   * scenario, using 1 thread means there will be 1 request. Use a value > 1 to have concurrent
   * requests.
   */
  static final int PARALLEL_THREADS =
      Integer.valueOf(
          MoreObjects.firstNonNull(System.getenv("SPANNER_TEST_JMH_NUM_PARALLEL_THREADS"), "30"));

  static final int NUM_GRPC_CHANNELS =
      Integer.valueOf(
          MoreObjects.firstNonNull(System.getenv("SPANNER_TEST_JMH_NUM_GRPC_CHANNELS"), "4"));

  /**
   * Total number of reads per test run for 1 thread. Increasing the value here will increase the
   * duration of the benchmark. For ex - With PARALLEL_THREADS = 2, TOTAL_READS_PER_RUN = 200, there
   * will be 400 read requests (200 on each thread).
   */
  static final int TOTAL_READS_PER_RUN =
      Integer.valueOf(
          MoreObjects.firstNonNull(
              System.getenv("SPANNER_TEST_JMH_NUM_READS_PER_THREAD"), "48000"));

  /**
   * Total number of writes per test run for 1 thread. Increasing the value here will increase the
   * duration of the benchmark. For ex - With PARALLEL_THREADS = 2, TOTAL_WRITES_PER_RUN = 200,
   * there will be 400 write requests (200 on each thread).
   */
  static final int TOTAL_WRITES_PER_RUN =
      Integer.valueOf(
          MoreObjects.firstNonNull(
              System.getenv("SPANNER_TEST_JMH_NUM_WRITES_PER_THREAD"), "4000"));

  /**
   * Number of requests which are used to initialise/warmup the benchmark. The latency number of
   * these runs are ignored from the final reported results.
   */
  static final int WARMUP_REQUEST_COUNT = 1;

  /**
   * Numbers of records in the sample table used in the benchmark. This is used in this benchmark to
   * randomly choose a primary key and ensure that the reads are randomly distributed. This is done
   * to ensure we don't end up reading/writing the same table record (leading to hot-spotting).
   */
  static final int TOTAL_RECORDS = 1000000;

  /** Utility to print latency numbers. It computes metrics such as Average, P50, P95 and P99. */
  public void printResults(List<Duration> results) {
    if (results == null) {
      return;
    }
    List<Duration> orderedResults = new ArrayList<>(results);
    Collections.sort(orderedResults);
    System.out.println();
    System.out.printf("Total number of queries: %d\n", orderedResults.size());
    System.out.printf("Avg: %fms\n", avg(results));
    System.out.printf("P50: %fms\n", percentile(50, orderedResults));
    System.out.printf("P95: %fms\n", percentile(95, orderedResults));
    System.out.printf("P99: %fms\n", percentile(99, orderedResults));
  }

  private double percentile(int percentile, List<Duration> orderedResults) {
    int index = percentile * orderedResults.size() / 100;
    Duration value = orderedResults.get(index);
    Double convertedValue = convertDurationToFractionInMilliSeconds(value);
    return convertedValue;
  }

  /** Returns the average duration in seconds from a list of duration values. */
  private double avg(List<Duration> results) {
    return results.stream()
        .collect(Collectors.averagingDouble(this::convertDurationToFractionInMilliSeconds));
  }

  private double convertDurationToFractionInSeconds(Duration duration) {
    long seconds = duration.getSeconds();
    long nanos = duration.getNano();
    double fraction = (double) nanos / 1_000_000_000;
    double value = seconds + fraction;
    return value;
  }

  private double convertDurationToFractionInMilliSeconds(Duration duration) {
    long nanoseconds = duration.toNanos();
    return nanoseconds / 1000000.0;
  }
}
