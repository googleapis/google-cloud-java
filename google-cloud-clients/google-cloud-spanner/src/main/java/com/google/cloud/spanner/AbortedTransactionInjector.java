/*
 * Copyright 2019 Google LLC
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
 * Interface for simulating an aborted read/write transaction in test code. You should only use this
 * class in test cases to verify that your code handles aborted exceptions correctly.
 *
 * <p>DO NOT USE IN PRODUCTION CODE.
 */
public interface AbortedTransactionInjector {
  /**
   * @return <code>true</code> if the client library should simulate that the current transaction
   *     was aborted by Cloud Spanner. Use this method to simulate an aborted transaction in your
   *     test code to ensure that your code can handle aborted transaction correctly.
   */
  boolean shouldAbort();

  /** Instructs the injector to simulate an aborted transaction once on the next database call. */
  public void injectAbortOnce();
}
