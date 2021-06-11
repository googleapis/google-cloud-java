/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.storage.util;

import io.grpc.Status;

/** Static utility methods for working with Errors returned from the service. */
public class Errors {
  private Errors() {};

  /**
   * Returns true iff the Status indicates and internal error that is retryable.
   *
   * <p>Generally, internal errors are not considered retryable, however there are certain transient
   * network issues that appear as internal but are in fact retryable.
   */
  public static boolean isRetryableInternalStatus(Status status) {
    String description = status.getDescription();
    return status.getCode() == Status.Code.INTERNAL
        && description != null
        && (description.contains("Received unexpected EOS ")
            || description.contains(" Rst ")
            || description.contains("RST_STREAM")
            || description.contains("Connection closed with unknown cause")
            || description.contains("HTTP/2 error code: INTERNAL_ERROR"));
  }
}
