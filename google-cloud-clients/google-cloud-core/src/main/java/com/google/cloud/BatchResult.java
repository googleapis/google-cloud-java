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

package com.google.cloud;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.api.core.InternalApi;
import java.util.LinkedList;
import java.util.List;

/**
 * This class holds a single result of a batch call. The class is not thread-safe.
 *
 * @param <T> the type of the result
 * @param <E> the type of the service-dependent exception thrown when a processing error occurs
 */
public abstract class BatchResult<T, E extends BaseServiceException> {

  private T result;
  private boolean completed = false;
  private E error;
  private final List<Callback<T, E>> toBeNotified = new LinkedList<>();

  @InternalApi("This class should only be extended within google-cloud-java")
  protected BatchResult() {}

  /**
   * Returns {@code true} if the batch has been completed and the result is available; {@code false}
   * otherwise.
   */
  public boolean completed() {
    return completed;
  }

  /**
   * Returns the result of this call.
   *
   * @throws IllegalStateException if the batch has not been completed yet
   * @throws E if an error occurred when processing the batch request
   */
  public T get() throws E {
    checkState(completed(), "Batch has not been completed yet");
    if (error != null) {
      throw error;
    }
    return result;
  }

  /**
   * Adds a callback for the batch operation.
   *
   * @throws IllegalStateException if the batch has been completed already
   */
  public void notify(Callback<T, E> callback) {
    checkState(
        !completed,
        "The batch has been completed. All the calls to the notify()"
            + " method should be done prior to submitting the batch.");
    toBeNotified.add(callback);
  }

  /** Sets an error and status as completed. Notifies all callbacks. */
  protected void error(E error) {
    this.error = checkNotNull(error);
    this.completed = true;
    for (Callback<T, E> callback : toBeNotified) {
      callback.error(error);
    }
  }

  /** Sets a result and status as completed. Notifies all callbacks. */
  protected void success(T result) {
    this.result = result;
    this.completed = true;
    for (Callback<T, E> callback : toBeNotified) {
      callback.success(result);
    }
  }

  /** An interface for the batch callbacks. */
  public interface Callback<T, E> {
    /** The method to be called when the batched operation succeeds. */
    void success(T result);

    /** The method to be called when the batched operation fails. */
    void error(E exception);
  }
}
