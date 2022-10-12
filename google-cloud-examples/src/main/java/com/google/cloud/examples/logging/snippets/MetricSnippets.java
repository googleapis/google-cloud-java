/*
 * Copyright 2016 Google LLC
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
 * This file is referenced in Metric's javadoc. Any change to this file should be reflected in
 * Metric's javadoc.
 */

package com.google.cloud.examples.logging.snippets;

import com.google.cloud.logging.Metric;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/** This class contains a number of snippets for the {@link Metric} class. */
public class MetricSnippets {

  private final Metric metric;

  public MetricSnippets(Metric metric) {
    this.metric = metric;
  }

  /** Example of getting the metric's latest information. */
  // [TARGET reload()]
  public Metric reload() {
    // [START reload]
    Metric latestMetric = metric.reload();
    if (latestMetric == null) {
      // the metric was not found
    }
    // [END reload]
    return latestMetric;
  }

  /** Example of asynchronously getting the metric's latest information. */
  // [TARGET reloadAsync()]
  public Metric reloadAsync() throws ExecutionException, InterruptedException {
    // [START reloadAsync]
    Future<Metric> future = metric.reloadAsync();
    // ...
    Metric latestMetric = future.get();
    if (latestMetric == null) {
      // the metric was not found
    }
    // [END reloadAsync]
    return latestMetric;
  }

  /** Example of updating the metric's information. */
  // [TARGET update()]
  public Metric update() {
    // [START update]
    Metric updatedMetric =
        metric.toBuilder().setDescription("A more detailed description").build().update();
    // [END update]
    return updatedMetric;
  }

  /** Example of asynchronously updating the metric's information. */
  // [TARGET updateAsync()]
  public Metric updateAsync() throws ExecutionException, InterruptedException {
    // [START updateAsync]
    Future<Metric> future =
        metric.toBuilder().setDescription("A more detailed description").build().updateAsync();
    // ...
    Metric updatedMetric = future.get();
    // [END updateAsync]
    return updatedMetric;
  }

  /** Example of deleting the metric. */
  // [TARGET delete()]
  public boolean delete() {
    // [START delete]
    boolean deleted = metric.delete();
    if (deleted) {
      // the metric was deleted
    } else {
      // the metric was not found
    }
    // [END delete]
    return deleted;
  }

  /** Example of asynchronously deleting the metric. */
  // [TARGET deleteAsync()]
  public boolean deleteAsync() throws ExecutionException, InterruptedException {
    // [START deleteAsync]
    Future<Boolean> future = metric.deleteAsync();
    // ...
    boolean deleted = future.get();
    if (deleted) {
      // the metric was deleted
    } else {
      // the metric was not found
    }
    // [END deleteAsync]
    return deleted;
  }
}
