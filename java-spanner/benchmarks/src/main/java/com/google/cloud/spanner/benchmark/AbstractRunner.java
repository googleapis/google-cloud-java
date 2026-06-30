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

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

abstract class AbstractRunner implements BenchmarkRunner {
  static final int TOTAL_RECORDS = 100000;
  static final String TABLE_NAME = "Employees";
  static final String SELECT_QUERY = String.format("SELECT ID FROM %s WHERE ID = @id", TABLE_NAME);
  static final String UPDATE_QUERY =
      String.format("UPDATE %s SET Name=Google WHERE ID = @id", TABLE_NAME);
  static final String ID_COLUMN_NAME = "id";
  static final Map<Environment, String> SERVER_URL_MAPPING = new HashMap<>();

  static {
    SERVER_URL_MAPPING.put(
        Environment.CLOUD_DEVEL, "https://staging-wrenchworks.sandbox.googleapis.com");
    SERVER_URL_MAPPING.put(Environment.PROD, "https://spanner.googleapis.com");
  }

  Map<Integer, TimerConfiguration> timerConfigurations = new HashMap<>();
  private final Set<Integer> completedClients = new HashSet<>();
  private final Set<Integer> finishedClients = new HashSet<>();

  protected void initiateTimer(int clientId, String message, Instant endTime) {
    TimerConfiguration timerConfiguration =
        timerConfigurations.getOrDefault(clientId, new TimerConfiguration());
    timerConfiguration.setMessage(message);
    timerConfiguration.setEndTime(endTime);
    timerConfigurations.put(clientId, timerConfiguration);
  }

  protected void setBenchmarkingCompleted(int clientId) {
    this.completedClients.add(clientId);
  }

  protected List<Duration> collectResults(
      ExecutorService service,
      List<Future<List<Duration>>> results,
      BenchmarkingConfiguration configuration)
      throws Exception {
    while (!(finishedClients.size() == configuration.getNumOfClients()))
      for (int i = 0; i < configuration.getNumOfClients(); i++) {
        TimerConfiguration timerConfiguration =
            timerConfigurations.getOrDefault(i, new TimerConfiguration());
        long totalSeconds =
            ChronoUnit.SECONDS.between(Instant.now(), timerConfiguration.getEndTime());
        if (completedClients.contains(i)) {
          if (!finishedClients.contains(i)) {
            System.out.printf("Client %s: Completed", i);
            finishedClients.add(i);
          }
        } else {
          System.out.printf(
              "Client %s: %s %s Minutes %s Seconds\r",
              i + 1, timerConfiguration.getMessage(), totalSeconds / 60, totalSeconds % 60);
        }
        //noinspection BusyWait
        Thread.sleep(1000L);
      }
    service.shutdown();
    if (!service.awaitTermination(60L, TimeUnit.MINUTES)) {
      throw new TimeoutException();
    }
    List<Duration> allResults = new ArrayList<>();
    for (Future<List<Duration>> result : results) {
      allResults.addAll(result.get());
    }
    return allResults;
  }

  protected void randomWait(int waitMillis) throws InterruptedException {
    if (waitMillis <= 0) {
      return;
    }
    int randomMillis = ThreadLocalRandom.current().nextInt(waitMillis * 2);
    Thread.sleep(randomMillis);
  }

  protected String generateRandomString() {
    byte[] bytes = new byte[64];
    ThreadLocalRandom.current().nextBytes(bytes);
    return new String(bytes, StandardCharsets.UTF_8);
  }

  static class TimerConfiguration {
    private Instant endTime = Instant.now();
    private String message = "Waiting for benchmarks to start...";

    Instant getEndTime() {
      return endTime;
    }

    void setEndTime(Instant endTime) {
      this.endTime = endTime;
    }

    String getMessage() {
      return message;
    }

    void setMessage(String message) {
      this.message = message;
    }
  }
}
