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
 * this class holds a single result of a batch call.
 */
public interface BatchResult<T, E extends BaseServiceException> {

  /**
   * Returns {@code true} if the batch has been submitted and the result is available, and {@code
   * false} otherwise.
   */
  boolean submitted();

  /**
   * Returns result of this call.
   *
   * @throws IllegalArgumentException if the batch has not been submitted yet
   * @throws E if an error occured when processing this request
   */
  T get() throws E;

  /**
   * Registers a callback for the batch operation.
   */
  void notify(Callback<T,E> callback);

  /**
   * An interface for the batch callbacks.
   */
  interface Callback<T,E> {
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
