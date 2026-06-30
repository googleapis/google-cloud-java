/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.benchmarking;

import com.google.cloud.spanner.benchmarking.BenchmarkValidator.BaselineResult.BenchmarkResult;
import com.google.cloud.spanner.benchmarking.BenchmarkValidator.BaselineResult.BenchmarkResult.Percentile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BenchmarkValidator {

  private final BaselineResult expectedResults;
  private final List<ActualBenchmarkResult> actualResults;

  public BenchmarkValidator(String baselineFile, String actualFile) {
    Gson gson = new Gson();
    // Load expected result JSON from resource folder
    this.expectedResults = gson.fromJson(loadJsonFromResources(baselineFile), BaselineResult.class);
    // Load the actual result from current benchmarking run
    this.actualResults =
        gson.fromJson(
            loadJsonFromFile(actualFile),
            new TypeToken<ArrayList<ActualBenchmarkResult>>() {}.getType());
  }

  void validate() {
    // Validating the resultant percentile against expected percentile with allowed threshold
    for (ActualBenchmarkResult actualResult : actualResults) {
      BenchmarkResult expectResult = expectedResults.benchmarkResultMap.get(actualResult.benchmark);
      if (expectResult == null) {
        throw new ValidationException(
            "Missing expected benchmark configuration for actual benchmarking");
      }
      Map<String, Double> actualPercentilesMap = actualResult.primaryMetric.scorePercentiles;
      // We will only be comparing the percentiles(p50, p90, p90) which are configured in the
      // expected percentiles. This allows some checks to be disabled if required.
      for (Percentile expectedPercentile : expectResult.scorePercentiles) {
        String percentile = expectedPercentile.percentile;
        double difference =
            calculatePercentageDifference(
                expectedPercentile.baseline, actualPercentilesMap.get(percentile));
        // if an absolute different in percentage is greater than allowed difference
        // Then we are throwing validation error
        if (Math.abs(Math.ceil(difference)) > expectedPercentile.difference) {
          throw new ValidationException(
              String.format(
                  "[%s][%s] Expected percentile %s[+/-%s] but got %s",
                  actualResult.benchmark,
                  percentile,
                  expectedPercentile.baseline,
                  expectedPercentile.difference,
                  actualPercentilesMap.get(percentile)));
        }
      }
    }
  }

  public static double calculatePercentageDifference(double base, double compareWith) {
    if (base == 0) {
      return 0.0;
    }
    return ((compareWith - base) / base) * 100;
  }

  private String loadJsonFromFile(String file) {
    try {
      return new String(Files.readAllBytes(Paths.get(file)));
    } catch (IOException e) {
      throw new ValidationException("Failed to read file: " + file, e);
    }
  }

  private String loadJsonFromResources(String baselineFile) {
    URL resourceUrl = getClass().getClassLoader().getResource(baselineFile);
    if (resourceUrl == null) {
      throw new ValidationException("File not found: " + baselineFile);
    }
    File file = new File(resourceUrl.getFile());
    return loadJsonFromFile(file.getAbsolutePath());
  }

  static class ActualBenchmarkResult {
    String benchmark;
    PrimaryMetric primaryMetric;

    static class PrimaryMetric {
      Map<String, Double> scorePercentiles;
    }
  }

  static class BaselineResult {
    Map<String, BenchmarkResult> benchmarkResultMap;

    static class BenchmarkResult {
      List<Percentile> scorePercentiles;

      static class Percentile {
        String percentile;
        Double baseline;
        Double difference;
      }
    }
  }

  static class ValidationException extends RuntimeException {
    ValidationException(String message) {
      super(message);
    }

    ValidationException(String message, Throwable cause) {
      super(message, cause);
    }
  }

  private static String parseCommandLineArgs(String[] args, String key) {
    if (args == null) {
      return "";
    }
    for (String arg : args) {
      if (arg.startsWith("--" + key)) {
        String[] splits = arg.split("=");
        if (splits.length == 2) {
          return splits[1].trim();
        }
      }
    }
    return "";
  }

  public static void main(String[] args) {
    String actualFile = parseCommandLineArgs(args, "file");
    new BenchmarkValidator("com/google/cloud/spanner/jmh/jmh-baseline.json", actualFile).validate();
  }
}
