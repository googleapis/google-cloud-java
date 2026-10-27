/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner;

/**
 * Generic {@link AbstractLazyInitializer} for any heavy-weight object that might throw an exception
 * during initialization. The underlying object is initialized at most once unless an exception is
 * thrown and {@link #shouldCacheError(Exception)} returns false.
 *
 * @param <T> Object which is to be initialized lazily
 */
public abstract class AbstractLazyInitializer<T> {
  private final Object lock = new Object();
  private volatile boolean initialized;
  private volatile T object;
  private volatile Exception error;

  /** Returns an initialized instance of T. */
  public T get() throws Exception {
    // First check without a lock to improve performance.
    if (!initialized) {
      synchronized (lock) {
        if (!initialized) {
          try {
            object = initialize();
            error = null;
            initialized = true;
          } catch (Exception e) {
            if (shouldCacheError(e)) {
              error = e;
              initialized = true;
            } else {
              throw e;
            }
          }
        }
      }
    }
    if (error != null) {
      throw error;
    }
    return object;
  }

  /**
   * Determines whether an exception thrown by {@link #initialize()} should be cached. If cached,
   * subsequent calls to {@link #get()} will immediately rethrow the cached exception. If not
   * cached, the exception is rethrown without marking this initializer as initialized, allowing
   * subsequent calls to retry {@link #initialize()}.
   *
   * <p>Defaults to {@code true} for backward compatibility. Subclasses can override this method to
   * avoid caching transient or retryable errors.
   *
   * @param e the exception thrown during initialization
   * @return {@code true} if the exception should be cached, {@code false} otherwise
   */
  protected boolean shouldCacheError(Exception e) {
    return true;
  }

  /**
   * Initializes the actual object that should be returned. Is called once the first time an
   * instance of T is required.
   */
  protected abstract T initialize() throws Exception;
}
