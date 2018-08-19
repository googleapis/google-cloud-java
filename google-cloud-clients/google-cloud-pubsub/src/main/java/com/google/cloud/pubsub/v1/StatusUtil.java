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

package com.google.cloud.pubsub.v1;

import com.google.api.gax.rpc.ApiException;
import io.grpc.Status;

/** Utilities for handling gRPC {@link Status}. */
final class StatusUtil {
  private StatusUtil() {
    // Static class, not instantiable.
  }

  public static boolean isRetryable(Throwable error) {
    if (!(error instanceof ApiException)) {
      return true;
    }
    ApiException apiException = (ApiException) error;
    switch (apiException.getStatusCode().getCode()) {
      case DEADLINE_EXCEEDED:
      case INTERNAL:
      case CANCELLED:
      case RESOURCE_EXHAUSTED:
      case ABORTED:
        return true;
      case UNAVAILABLE:
        // TODO(pongad): check that ApiException propagate message properly.
        return !apiException.getMessage().contains("Server shutdownNow invoked");
      default:
        return false;
    }
  }
}
