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

package com.google.cloud.jdbc.quickperf.config;

import java.util.List;
import java.util.Random;

public class Config {
  public static String DEFAULT_TAG = "perftest_" + (new Random()).nextInt(300);

  private String project;
  private String instance;
  private String database;
  private int threads;
  private int iterations;
  private String query;
  private String samplingQuery;
  private boolean writeMetricToFile;
  private int batchSize;
  private boolean isEmulator;
  private List<QueryParam> queryParams;

  public String paramsToString() {
    StringBuilder retVal = new StringBuilder();

    if (queryParams != null) {

      for (QueryParam param : queryParams) {
        retVal.append(String.format("%s:%s ", param.getOrder(), param.getValue()));
      }
    }

    return retVal.toString();
  }

  public int getBatchSize() {
    return this.batchSize;
  }

  public void setBatchSize(int batchSize) {
    this.batchSize = batchSize;
  }

  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }

  public String getInstance() {
    return instance;
  }

  public void setInstance(String instance) {
    this.instance = instance;
  }

  public String getDatabase() {
    return database;
  }

  public void setDatabase(String database) {
    this.database = database;
  }

  public int getThreads() {
    return threads;
  }

  public void setThreads(int threads) {
    this.threads = threads;
  }

  public int getIterations() {
    return iterations;
  }

  public void setIterations(int iterations) {
    this.iterations = iterations;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public boolean isWriteMetricToFile() {
    return writeMetricToFile;
  }

  public void setWriteMetricToFile(boolean writeMetricToFile) {
    this.writeMetricToFile = writeMetricToFile;
  }

  public List<QueryParam> getQueryParams() {
    return queryParams;
  }

  public void setQueryParams(List<QueryParam> queryParams) {
    this.queryParams = queryParams;
  }

  public String getSamplingQuery() {
    return this.samplingQuery;
  }

  public void setSamplingQuery(String samplingQuery) {
    this.samplingQuery = samplingQuery;
  }

  public boolean getWriteMetricToFile() {
    return this.writeMetricToFile;
  }

  public boolean isIsEmulator() {
    return this.isEmulator;
  }

  public boolean getIsEmulator() {
    return this.isEmulator;
  }

  public void setIsEmulator(boolean isEmulator) {
    this.isEmulator = isEmulator;
  }
}
