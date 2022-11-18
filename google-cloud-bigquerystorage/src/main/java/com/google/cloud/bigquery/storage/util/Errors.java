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

import com.google.rpc.RetryInfo;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.protobuf.ProtoUtils;
import org.threeten.bp.Duration;

/** Static utility methods for working with Errors returned from the service. */
public class Errors {
  private Errors() {}

  public static class IsRetryableStatusResult {
    public boolean isRetryable = false;
    public Duration retryDelay = null;
  }

  private static final Metadata.Key<RetryInfo> KEY_RETRY_INFO =
      ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());

  /**
   * Returns true iff the Status indicates an error that is retryable.
   *
   * <p>Generally, internal errors are not considered retryable, however there are certain transient
   * network issues that appear as internal but are in fact retryable.
   *
   * <p>Resource exhausted errors are only considered retryable if metadata contains a serialized
   * RetryInfo object.
   */
  public static IsRetryableStatusResult isRetryableStatus(Status status, Metadata metadata) {
    IsRetryableStatusResult result = new IsRetryableStatusResult();

    result.isRetryable = isRetryableInternalStatus(status);
    if (!result.isRetryable
        && status.getCode() == Status.Code.RESOURCE_EXHAUSTED
        && metadata != null
        && metadata.containsKey(KEY_RETRY_INFO)) {
      RetryInfo retryInfo = metadata.get(KEY_RETRY_INFO);
      if (retryInfo.hasRetryDelay()) {
        result.isRetryable = true;
        result.retryDelay =
            Duration.ofSeconds(
                retryInfo.getRetryDelay().getSeconds(), retryInfo.getRetryDelay().getNanos());
      }
    }

    return result;
  }

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
            || description.contains("Rst Stream")
            || description.contains("RST_STREAM")
            || description.contains(
                "INTERNAL: A retriable error could not be retried due to Extensible Stubs memory limits for streams")
            || description.contains("Connection closed with unknown cause")
            || description.contains("HTTP/2 error code: INTERNAL_ERROR"));
  }
}
