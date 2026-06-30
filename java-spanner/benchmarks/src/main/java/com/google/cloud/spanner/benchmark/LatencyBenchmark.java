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

package com.google.cloud.spanner.benchmark;

import com.google.api.core.InternalApi;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.benchmark.BenchmarkRunner.Environment;
import com.google.cloud.spanner.benchmark.BenchmarkRunner.TransactionType;
import com.google.common.annotations.VisibleForTesting;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

@InternalApi
@VisibleForTesting
public class LatencyBenchmark {
  public static void main(String[] args) throws ParseException {
    CommandLine cmd = parseCommandLine(args);
    String project = System.getenv("SPANNER_CLIENT_BENCHMARK_GOOGLE_CLOUD_PROJECT");
    String instance = System.getenv("SPANNER_CLIENT_BENCHMARK_SPANNER_INSTANCE");
    String database = System.getenv("SPANNER_CLIENT_BENCHMARK_SPANNER_DATABASE");
    String fullyQualifiedDatabase;

    if (project != null && instance != null && database != null) {
      fullyQualifiedDatabase =
          String.format("projects/%s/instances/%s/databases/%s", project, instance, database);
    } else {
      throw new IllegalArgumentException(
          "You must either set all the environment variables"
              + " SPANNER_CLIENT_BENCHMARK_GOOGLE_CLOUD_PROJECT,"
              + " SPANNER_CLIENT_BENCHMARK_SPANNER_INSTANCE and"
              + " SPANNER_CLIENT_BENCHMARK_SPANNER_DATABASE, or specify a value for the command"
              + " line argument --database");
    }

    LatencyBenchmark benchmark = new LatencyBenchmark(DatabaseId.of(fullyQualifiedDatabase));
    benchmark.run(cmd);
  }

  private static CommandLine parseCommandLine(String[] args) throws ParseException {
    Options options = new Options();
    options.addOption("d", "database", true, "The database to use for benchmarking.");
    options.addOption(
        "c", "clients", true, "The number of clients that will be executing queries in parallel.");
    options.addOption(
        "wu",
        "warmupTime",
        true,
        "Total warm up time before running actual benchmarking. Defaults to 7 minutes.");
    options.addOption(
        "et",
        "executionTime",
        true,
        "Total execution time of the benchmarking. Defaults to 30 minutes.");
    options.addOption(
        "st", "staleness", true, "Total Staleness for Reads and Queries. Defaults to 15 seconds.");
    options.addOption(
        "w",
        "wait",
        true,
        "The wait time in milliseconds between each query that is executed by each client. Defaults"
            + " to 0. Set this to for example 1000 to have each client execute 1 query per"
            + " second.");
    options.addOption(
        "t",
        "transactionType",
        true,
        "The type of transaction to execute. Must be either READ_ONLY or READ_WRITE. Defaults to"
            + " READ_ONLY.");
    options.addOption(
        "e",
        "environment",
        true,
        "Spanner Environment. Must be either PROD or CLOUD_DEVEL. Default to CLOUD_DEVEL");
    options.addOption("m", "multiplexed", true, "Use multiplexed sessions. Defaults to true.");
    options.addOption("name", true, "Name of this test run");
    CommandLineParser parser = new DefaultParser();
    return parser.parse(options, args);
  }

  private final DatabaseId databaseId;

  LatencyBenchmark(DatabaseId databaseId) {
    this.databaseId = databaseId;
  }

  public void run(CommandLine commandLine) {
    int clients =
        commandLine.hasOption('c') ? Integer.parseInt(commandLine.getOptionValue('c')) : 1;
    int executionTime =
        commandLine.hasOption("et") ? Integer.parseInt(commandLine.getOptionValue("et")) : 30;
    int warmUpTime =
        commandLine.hasOption("wu") ? Integer.parseInt(commandLine.getOptionValue("wu")) : 7;
    int waitMillis =
        commandLine.hasOption('w') ? Integer.parseInt(commandLine.getOptionValue('w')) : 0;
    int staleness =
        commandLine.hasOption("st") ? Integer.parseInt(commandLine.getOptionValue("st")) : 15;
    TransactionType transactionType =
        commandLine.hasOption('t')
            ? TransactionType.valueOf(commandLine.getOptionValue('t').toUpperCase(Locale.ENGLISH))
            : TransactionType.READ_ONLY_SINGLE_USE_QUERY;
    boolean useMultiplexedSession =
        !commandLine.hasOption('m') || Boolean.parseBoolean(commandLine.getOptionValue('m'));
    Environment environment =
        commandLine.hasOption('e')
            ? Environment.valueOf(commandLine.getOptionValue('e').toUpperCase(Locale.ENGLISH))
            : Environment.CLOUD_DEVEL;

    BenchmarkingConfiguration configuration =
        new BenchmarkingConfiguration()
            .setDatabaseId(databaseId)
            .setNumOfClients(clients)
            .setExecutionTime(executionTime)
            .setWarmupTime(warmUpTime)
            .setStaleness(staleness)
            .setTransactionType(transactionType)
            .setUseMultiplexSession(useMultiplexedSession)
            .setWaitBetweenRequests(waitMillis)
            .setEnvironment(environment);

    System.out.println();
    System.out.println("Running benchmark with the following options");
    System.out.printf("Database: %s\n", configuration.getDatabaseId());
    System.out.printf("Clients: %d\n", configuration.getNumOfClients());
    System.out.printf("Total Warm up Time: %d mins\n", configuration.getWarmupTime());
    System.out.printf("Total Execution Time: %d mins\n", configuration.getExecutionTime());
    System.out.printf("Staleness: %d secs\n", configuration.getStaleness());
    System.out.printf("Transaction type: %s\n", configuration.getTransactionType());
    System.out.printf("Use Multiplexed Sessions: %s\n", configuration.isUseMultiplexSession());
    System.out.printf("Wait between requests: %dms\n", configuration.getWaitBetweenRequests());

    List<Duration> javaClientResults = null;
    System.out.println();
    System.out.println("Running benchmark for Java Client Library");
    JavaClientRunner javaClientRunner = new JavaClientRunner(configuration.getDatabaseId());
    javaClientResults = javaClientRunner.execute(configuration);

    printResults("Java Client Library", javaClientResults);
  }

  private void printResults(String header, List<Duration> results) {
    if (results == null) {
      return;
    }
    List<Duration> orderedResults = new ArrayList<>(results);
    Collections.sort(orderedResults);
    System.out.println();
    System.out.println(header);
    System.out.printf("Total number of queries: %d\n", orderedResults.size());
    System.out.printf("Avg: %.2fms\n", avg(results));
    System.out.printf("P50: %.2fms\n", percentile(50, orderedResults));
    System.out.printf("P95: %.2fms\n", percentile(95, orderedResults));
    System.out.printf("P99: %.2fms\n", percentile(99, orderedResults));
  }

  private double percentile(int percentile, List<Duration> orderedResults) {
    return orderedResults.get(percentile * orderedResults.size() / 100).get(ChronoUnit.NANOS)
        / 1_000_000.0f;
  }

  private double avg(List<Duration> results) {
    return results.stream()
        .collect(Collectors.averagingDouble(result -> result.get(ChronoUnit.NANOS) / 1_000_000.0f));
  }
}
