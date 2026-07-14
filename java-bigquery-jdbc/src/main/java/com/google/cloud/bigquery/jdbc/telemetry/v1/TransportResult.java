/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.telemetry.v1;

import java.util.Objects;

/** Represents the immutable result of a Clearcut telemetry payload transmission attempt. */
final class TransportResult {
  private static final TransportResult DISABLED = new TransportResult(false, -1);

  private final boolean success;
  private final long nextRequestWaitMillis;

  TransportResult(boolean success, long nextRequestWaitMillis) {
    this.success = success;
    this.nextRequestWaitMillis = nextRequestWaitMillis;
  }

  static TransportResult disabled() {
    return DISABLED;
  }

  boolean isSuccess() {
    return success;
  }

  long getNextRequestWaitMillis() {
    return nextRequestWaitMillis;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransportResult that = (TransportResult) o;
    return success == that.success && nextRequestWaitMillis == that.nextRequestWaitMillis;
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, nextRequestWaitMillis);
  }

  @Override
  public String toString() {
    return "TransportResult{"
        + "success="
        + success
        + ", nextRequestWaitMillis="
        + nextRequestWaitMillis
        + '}';
  }
}
