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

package com.google.cloud.storage;

import java.time.Duration;

final class Durations {

  /* {@code PT2562047H47M16.854775807S} ~ 106,751 days ~ 292.4 years */
  static final Duration EFFECTIVE_INFINITY = Duration.ofNanos(Long.MAX_VALUE);

  private Durations() {}

  static boolean eq(Duration lhs, Duration rhs) {
    return lhs.equals(rhs);
  }

  static boolean ltEq(Duration lhs, Duration rhs) {
    return lhs.compareTo(rhs) <= 0;
  }

  static boolean gtEq(Duration lhs, Duration rhs) {
    return lhs.compareTo(rhs) >= 0;
  }

  static boolean gt(Duration lhs, Duration rhs) {
    return lhs.compareTo(rhs) > 0;
  }

  static Duration min(Duration d1, Duration d2) {
    if (d1.compareTo(d2) < 0) {
      return d1;
    } else {
      return d2;
    }
  }

  static Duration min(Duration d1, Duration d2, Duration d3) {
    return min(min(d1, d2), d3);
  }
}
