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

package com.google.cloud.spanner.connection;

/** Simple util class for repeating (test) functions. */
class Repeat {

  /** Repeat the given {@link Runnable} twice. */
  static void twice(Runnable runnable) {
    repeat(runnable, 2);
  }

  /** Repeat the given {@link Runnable} n times. */
  static void repeat(Runnable runnable, int n) {
    for (int ignore = 0; ignore < n; ignore++) {
      runnable.run();
    }
  }
}
