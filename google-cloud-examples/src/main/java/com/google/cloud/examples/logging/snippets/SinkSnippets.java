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
 * This file is referenced in Sink's javadoc. Any change to this file should be reflected in Sink's
 * javadoc.
 */

package com.google.cloud.examples.logging.snippets;

import com.google.cloud.logging.Sink;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/** This class contains a number of snippets for the {@link Sink} class. */
public class SinkSnippets {

  private final Sink sink;

  public SinkSnippets(Sink sink) {
    this.sink = sink;
  }

  /** Example of getting the sink's latest information. */
  // [TARGET reload()]
  public Sink reload() {
    // [START reload]
    Sink latestSink = sink.reload();
    if (latestSink == null) {
      // the sink was not found
    }
    // [END reload]
    return latestSink;
  }

  /** Example of asynchronously getting the sink's latest information. */
  // [TARGET reloadAsync()]
  public Sink reloadAsync() throws ExecutionException, InterruptedException {
    // [START reloadAsync]
    Future<Sink> future = sink.reloadAsync();
    // ...
    Sink latestSink = future.get();
    if (latestSink == null) {
      // the sink was not found
    }
    // [END reloadAsync]
    return latestSink;
  }

  /** Example of updating the sink's information. */
  // [TARGET update()]
  public Sink update() {
    // [START update]
    Sink updatedSink = sink.toBuilder().setFilter("severity<=ERROR").build().update();
    // [END update]
    return updatedSink;
  }

  /** Example of asynchronously updating the sink's information. */
  // [TARGET updateAsync()]
  public Sink updateAsync() throws ExecutionException, InterruptedException {
    // [START updateAsync]
    Future<Sink> future = sink.toBuilder().setFilter("severity<=ERROR").build().updateAsync();
    // ...
    Sink updatedSink = future.get();
    // [END updateAsync]
    return updatedSink;
  }

  /** Example of deleting the sink. */
  // [TARGET delete()]
  public boolean delete() {
    // [START delete]
    boolean deleted = sink.delete();
    if (deleted) {
      // the sink was deleted
    } else {
      // the sink was not found
    }
    // [END delete]
    return deleted;
  }

  /** Example of asynchronously deleting the sink. */
  // [TARGET deleteAsync()]
  public boolean deleteAsync() throws ExecutionException, InterruptedException {
    // [START deleteAsync]
    Future<Boolean> future = sink.deleteAsync();
    // ...
    boolean deleted = future.get();
    if (deleted) {
      // the sink was deleted
    } else {
      // the sink was not found
    }
    // [END deleteAsync]
    return deleted;
  }
}
