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

import io.grpc.Status;
import io.grpc.StatusRuntimeException;

/** Utilities for handling gRPC {@link Status}. */
final class StatusUtil {
  private StatusUtil() {
    // Static class, not instantiable.
  }

  public static boolean isRetryable(Throwable error) {
    if (!(error instanceof StatusRuntimeException)) {
      return true;
    }
    StatusRuntimeException statusRuntimeException = (StatusRuntimeException) error;
    switch (statusRuntimeException.getStatus().getCode()) {
      case DEADLINE_EXCEEDED:
      case INTERNAL:
      case CANCELLED:
      case RESOURCE_EXHAUSTED:
      case ABORTED:
        return true;
      case UNAVAILABLE:
        if (statusRuntimeException.getMessage().contains("Server shutdownNow invoked")) {
          return false;
        } else {
          return true;
        }
      default:
        return false;
    }
  }
}
