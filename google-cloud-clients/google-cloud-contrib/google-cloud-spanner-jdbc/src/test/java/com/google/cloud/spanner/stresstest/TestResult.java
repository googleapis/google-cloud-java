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

package com.google.cloud.spanner.stresstest;

import com.google.common.base.Strings;

class TestResult implements Comparable<TestResult> {
  private final int parallel;
  private final int numChannels;
  private final String testName;
  private final long executionTime;
  private final long executionCount;

  static void logResults(Iterable<TestResult> results) {
    System.out.println(String.format("%1$80s | %2$8s | %3$8s | %4$9s", "Method", "Count", "Time", "#/sec"));
    for(TestResult res : results) {
      System.out.println(res.toString());
    }
    System.out.println(Strings.repeat("-", 114));
    System.out.println("");
  }

  TestResult(int parallel, int numChannels, String testName, long executionTime, long executionCount) {
    this.parallel = parallel;
    this.numChannels = numChannels;
    this.testName = testName;
    this.executionTime = executionTime;
    this.executionCount = executionCount;
  }

  @Override
  public String toString() {
    return String.format("%1$80s | %2$8d | %3$6dms | %4$5.1f/s", testName, executionCount, executionTime,
        (double) executionCount / (double) executionTime * 1000D);
  }

  @Override
  public int compareTo(TestResult o) {
    if(this.testName.equals(o.testName)) {
      if(this.parallel == o.parallel) {
        return this.numChannels - o.numChannels;
      }
      return this.parallel - o.parallel;
    }
    return this.testName.compareTo(o.testName);
  }
}