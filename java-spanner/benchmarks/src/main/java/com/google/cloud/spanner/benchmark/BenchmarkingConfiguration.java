/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.benchmark;

import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.benchmark.BenchmarkRunner.Environment;
import com.google.cloud.spanner.benchmark.BenchmarkRunner.TransactionType;

class BenchmarkingConfiguration {

  private DatabaseId databaseId;
  private int numOfClients;
  private int staleness;
  private int warmupTime;
  private int executionTime;
  private int waitBetweenRequests;
  private boolean useMultiplexSession;
  private TransactionType transactionType;
  private Environment environment;

  int getExecutionTime() {
    return executionTime;
  }

  BenchmarkingConfiguration setExecutionTime(int executionTime) {
    this.executionTime = executionTime;
    return this;
  }

  DatabaseId getDatabaseId() {
    return databaseId;
  }

  BenchmarkingConfiguration setDatabaseId(DatabaseId databaseId) {
    this.databaseId = databaseId;
    return this;
  }

  int getNumOfClients() {
    return numOfClients;
  }

  BenchmarkingConfiguration setNumOfClients(int numOfClients) {
    this.numOfClients = numOfClients;
    return this;
  }

  int getStaleness() {
    return staleness;
  }

  BenchmarkingConfiguration setStaleness(int staleness) {
    this.staleness = staleness;
    return this;
  }

  int getWarmupTime() {
    return warmupTime;
  }

  BenchmarkingConfiguration setWarmupTime(int warmupTime) {
    this.warmupTime = warmupTime;
    return this;
  }

  int getWaitBetweenRequests() {
    return waitBetweenRequests;
  }

  BenchmarkingConfiguration setWaitBetweenRequests(int waitBetweenRequests) {
    this.waitBetweenRequests = waitBetweenRequests;
    return this;
  }

  boolean isUseMultiplexSession() {
    return useMultiplexSession;
  }

  BenchmarkingConfiguration setUseMultiplexSession(boolean useMultiplexSession) {
    this.useMultiplexSession = useMultiplexSession;
    return this;
  }

  TransactionType getTransactionType() {
    return transactionType;
  }

  BenchmarkingConfiguration setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
    return this;
  }

  Environment getEnvironment() {
    return environment;
  }

  BenchmarkingConfiguration setEnvironment(Environment environment) {
    this.environment = environment;
    return this;
  }
}
