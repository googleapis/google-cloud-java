/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in Job's javadoc. Any change to this file should be reflected in
 * Job's javadoc.
 */

package com.google.cloud.examples.bigquery.snippets;

import com.google.cloud.WaitForOption;
import com.google.cloud.bigquery.Job;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JobSnippets {

  private final Job job;

  public JobSnippets(Job job) {
    this.job = job;
  }

  /**
   * Example of waiting for a job until it reports that it is done.
   */
  // [TARGET isDone()]
  public void isDone() throws InterruptedException {
    // [START isDone]
    while (!job.isDone()) {
      Thread.sleep(1000L);
    }
    // [END isDone]
  }

  /**
   * Example usage of {@code waitFor()}.
   */
  // [TARGET waitFor(WaitForOption...)]
  public boolean waitFor() throws InterruptedException {
    try {
      // [START waitFor]
      Job completedJob = job.waitFor();
      if (completedJob == null) {
        // job no longer exists
      } else if (completedJob.status().error() != null) {
        // job failed, handle error
      } else {
        // job completed successfully
      }
      // [END waitFor]
    } catch (TimeoutException e) {
      // Timeouts shouldn't happen without a timeout option.
      return false;
    }
    return true;
  }

  /**
   * Example usage of {@code waitFor()} with checking period and timeout.
   */
  // [TARGET waitFor(WaitForOption...)]
  public boolean waitForWithOptions() throws InterruptedException {
    try {
      // [START waitFor]
      Job completedJob =
          job.waitFor(
              WaitForOption.checkEvery(1, TimeUnit.SECONDS),
              WaitForOption.timeout(60, TimeUnit.SECONDS));
      if (completedJob == null) {
        // job no longer exists
      } else if (completedJob.status().error() != null) {
        // job failed, handle error
      } else {
        // job completed successfully
      }
      // [END waitFor]
    } catch (TimeoutException e) {
      return true;
    }
    return true;
  }
}
