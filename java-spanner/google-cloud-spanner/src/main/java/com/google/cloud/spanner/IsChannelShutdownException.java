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

package com.google.cloud.spanner;

import com.google.api.gax.rpc.UnavailableException;
import com.google.common.base.Predicate;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;

/**
 * Predicate that checks whether an exception is a ChannelShutdownException. This exception is
 * thrown by gRPC if the underlying gRPC stub has been shut down and uses the UNAVAILABLE error
 * code. This means that it would normally be retried by the Spanner client, but this specific
 * UNAVAILABLE error should not be retried, as it would otherwise directly return the same error.
 */
class IsChannelShutdownException implements Predicate<Throwable> {

  @Override
  public boolean apply(Throwable input) {
    Throwable cause = input;
    do {
      if (isUnavailableError(cause)
          && (cause.getMessage().contains("Channel shutdown invoked")
              || cause.getMessage().contains("Channel shutdownNow invoked"))) {
        return true;
      }
    } while ((cause = cause.getCause()) != null);
    return false;
  }

  private boolean isUnavailableError(Throwable cause) {
    return (cause instanceof UnavailableException)
        || (cause instanceof StatusRuntimeException
            && ((StatusRuntimeException) cause).getStatus().getCode() == Code.UNAVAILABLE);
  }
}
