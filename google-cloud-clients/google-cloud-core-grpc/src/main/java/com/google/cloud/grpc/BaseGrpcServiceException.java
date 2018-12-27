/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.grpc;

import com.google.api.client.http.HttpResponseException;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.BaseServiceException;
import com.google.common.base.MoreObjects;
import java.io.IOException;
import java.util.Collections;

/** Base class for all exceptions from grpc-based services. */
public class BaseGrpcServiceException extends BaseServiceException {

  private static final long serialVersionUID = -2685197215731335549L;

  @InternalApi("This class should only be extended within google-cloud-java")
  protected BaseGrpcServiceException(String message, Throwable cause, int code, boolean retryable) {
    super(
        ExceptionData.newBuilder()
            .setMessage(message)
            .setCause(cause)
            .setCode(code)
            .setRetryable(retryable)
            .build());
  }

  @InternalApi("This class should only be extended within google-cloud-java")
  protected BaseGrpcServiceException(IOException exception, boolean idempotent) {
    super(makeExceptionData(exception, idempotent));
  }

  private static ExceptionData makeExceptionData(IOException exception, boolean idempotent) {
    int code = UNKNOWN_CODE;
    Boolean retryable = null;
    if (exception instanceof HttpResponseException) {
      // In cases where an exception is an instance of HttpResponseException,
      // check the status code to determine whether it's retryable
      code = ((HttpResponseException) exception).getStatusCode();
      retryable =
          BaseServiceException.isRetryable(code, null, idempotent, Collections.<Error>emptySet());
    }
    return ExceptionData.newBuilder()
        .setMessage(exception.getMessage())
        .setCause(exception)
        .setRetryable(
            MoreObjects.firstNonNull(
                retryable, BaseServiceException.isRetryable(idempotent, exception)))
        .setCode(code)
        .setReason(null)
        .setLocation(null)
        .setDebugInfo(null)
        .build();
  }

  @BetaApi
  public BaseGrpcServiceException(ApiException apiException) {
    super(
        ExceptionData.newBuilder()
            .setMessage(apiException.getMessage())
            .setCause(apiException)
            .setRetryable(apiException.isRetryable())
            .setCode(apiException.getStatusCode().getCode().getHttpStatusCode())
            .setReason(apiException.getStatusCode().getCode().name())
            .setLocation(null)
            .setDebugInfo(null)
            .build());
  }
}
