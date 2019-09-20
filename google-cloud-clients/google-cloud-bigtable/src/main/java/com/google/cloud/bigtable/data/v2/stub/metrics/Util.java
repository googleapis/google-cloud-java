/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StatusCode.Code;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.opencensus.tags.TagValue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

/** Utilities to help integrating with OpenCensus. */
class Util {
  private static final TagValue OK_STATUS = TagValue.create(StatusCode.Code.OK.toString());

  /** Convert an exception into a value that can be used as an OpenCensus tag value. */
  static TagValue extractStatus(@Nullable Throwable error) {
    final String statusString;

    if (error == null) {
      return OK_STATUS;
    } else if (error instanceof CancellationException) {
      statusString = Status.Code.CANCELLED.toString();
    } else if (error instanceof ApiException) {
      statusString = ((ApiException) error).getStatusCode().getCode().toString();
    } else if (error instanceof StatusRuntimeException) {
      statusString = ((StatusRuntimeException) error).getStatus().getCode().toString();
    } else if (error instanceof StatusException) {
      statusString = ((StatusException) error).getStatus().getCode().toString();
    } else {
      statusString = Code.UNKNOWN.toString();
    }

    return TagValue.create(statusString);
  }

  /**
   * Await the result of the future and convert it into a value that can be used as an OpenCensus
   * tag value.
   */
  static TagValue extractStatus(Future<?> future) {
    Throwable error = null;

    try {
      future.get();
    } catch (InterruptedException e) {
      error = e;
      Thread.currentThread().interrupt();
    } catch (ExecutionException e) {
      error = e.getCause();
    } catch (RuntimeException e) {
      error = e;
    }
    return extractStatus(error);
  }
}
