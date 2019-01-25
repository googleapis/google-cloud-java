/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.grpc.gcp.testing;

import java.util.logging.Logger;

/** SpannerBenchmark. */
public final class SpannerBenchmark {

  private static final Logger logger = Logger.getLogger(SpannerBenchmark.class.getName());

  private SpannerBenchmark() {}

  private static int[] parseArgs(String[] args) {
    // {number of rpcs, number of threads, payload bytes, isGrpcgcp}
    int[] vars = new int[] {100, 1, 4096000, 1};
    boolean usage = false;
    for (String arg : args) {
      if (!arg.startsWith("--")) {
        System.err.println("All arguments must start with '--': " + arg);
        usage = true;
        break;
      }
      String[] parts = arg.substring(2).split("=", 2);
      String key = parts[0];
      if (key.equals("help")) {
        usage = true;
        break;
      }
      if (parts.length != 2) {
        System.err.println("All arguments must be of the form --arg=value");
        usage = true;
        break;
      }
      if (key.equals("gcp")) {
        if (parts[1].equals("false")) {
          vars[3] = 0;
        }
      } else {
        int value = Integer.parseInt(parts[1]);
        switch (key) {
          case "thread":
            vars[1] = value;
            break;
          case "rpc":
            vars[0] = value;
            break;
          case "payload_bytes":
            vars[2] = value;
            break;
        }
      }
    }
    if (usage) {
      System.out.println(
          "Example usage:\n"
              + "--thread=100\n "
              + "--gcp=true\n"
              + "--payload_bytes=4096000\n"
              + "--gcp=true\n"
              + "--rpc=100");
      System.exit(1);
    }
    return vars;
  }

  public static void main(String[] args) throws InterruptedException {
    int[] vars = parseArgs(args);
    logger.info(
        String.format(
            "Start Benchmark..\n"
                + "Number of Rpcs: %d\n"
                + "Number of thhreads:%d\n"
                + "Payload bytes:%d\n"
                + "GcpManagedChannel:%b",
            vars[0], vars[1], vars[2], vars[3] == 1));
    SpannerProbers.prepareTestData(vars[3] == 1, vars[2]);
    SpannerProbers.testListSessions(vars[3] == 1, vars[0], vars[1]);
    SpannerProbers.testListSessionsAsync(vars[3] == 1, vars[0], vars[1]);
    SpannerProbers.testExecuteSql(vars[3] == 1, vars[0], vars[1]);
    SpannerProbers.testExecuteSqlAsync(vars[3] == 1, vars[0], vars[1]);
    SpannerProbers.testPartitionQuery(vars[3] == 1, vars[0], vars[1]);
    SpannerProbers.testPartitionQueryAsync(vars[3] == 1, vars[0], vars[1]);
    SpannerProbers.testRead(vars[3] == 1, vars[0], vars[1]);
    SpannerProbers.testReadAsync(vars[3] == 1, vars[0], vars[1]);
    SpannerProbers.testMaxConcurrentStream(vars[3] == 1, vars[0]);
  }
}
