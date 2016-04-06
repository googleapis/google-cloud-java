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

package com.google.gcloud;

/**
 * This class holds a single result of a batch call.
 */
public abstract class BatchResult<T, E extends BaseServiceException> {

  private T result;
  private boolean submitted = false;
  private E error;

  /**
   * Returns {@code true} if the batch has been submitted and the result is available; {@code false}
   * otherwise.
   */
  public boolean submitted() {
    return submitted;
  }

  /**
   * Returns result of this call.
   *
   * @throws IllegalStateException if the batch has not been submitted yet
   * @throws E if an error occurred when processing this request
   */
  public T get() throws E {
    if (!submitted()) {
      throw new IllegalStateException("Batch has not been submitted yet");
    }
    if (error != null) {
      throw error;
    }
    return result;
  }

  /**
   * Registers a callback for the batch operation.
   */
  public void notify(Callback<T, E> callback) {
    // todo(mderka) implement
    throw new UnsupportedOperationException("Not implemented yet");
  }

  /**
   * Sets an error and makes this submitted.
   */
  protected void error(E error) {
    this.error = error;
    this.submitted = true;
  }

  /**
   * Sets a result and makes this submitted.
   */
  protected void success(T result) {
    this.result = result;
    this.submitted = true;
  }

  /**
   * An interface for the batch callbacks.
   */
  public interface Callback<T, E> {
    /**
     * The method to be called when the batched operation succeeds.
     */
    void success(T result);

    /**
     * The method to be called when the batched operation fails.
     */
    void error(E exception);
  }
}
