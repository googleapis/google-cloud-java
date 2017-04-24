/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.http;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpResponseException;
import com.google.cloud.BaseServiceException;
import com.google.common.base.MoreObjects;
import java.io.IOException;
import java.util.Set;

/**
 * Base class for all exceptions from http-based services.
 */
public class BaseHttpServiceException extends BaseServiceException {

  private static final long serialVersionUID = -5793034110344127954L;
  public static final int UNKNOWN_CODE = 0;

  public BaseHttpServiceException(IOException exception, boolean idempotent,
      Set<BaseServiceException.Error> retryableErrors) {
    super(makeExceptionData(exception, idempotent, retryableErrors));
  }

  private static ExceptionData makeExceptionData(IOException exception, boolean idempotent,
      Set<BaseServiceException.Error> retryableErrors) {
    int code = UNKNOWN_CODE;
    String reason = null;
    String location = null;
    String debugInfo = null;
    Boolean retryable = null;
    if (exception instanceof HttpResponseException) {
      if (exception instanceof GoogleJsonResponseException) {
        GoogleJsonError jsonError = ((GoogleJsonResponseException) exception).getDetails();
        if (jsonError != null) {
          BaseServiceException.Error error = new BaseServiceException.Error(jsonError.getCode(),
              reason(jsonError));
          code = error.getCode();
          reason = error.getReason();
          retryable = error.isRetryable(idempotent, retryableErrors);
          if (reason != null) {
            GoogleJsonError.ErrorInfo errorInfo = jsonError.getErrors().get(0);
            location = errorInfo.getLocation();
            debugInfo = (String) errorInfo.get("debugInfo");
          }
        } else {
          code = ((GoogleJsonResponseException) exception).getStatusCode();
        }
      } else {
        // In cases where an exception is an instance of HttpResponseException but not
        // an instance of GoogleJsonResponseException, check the status code to determine whether it's retryable
        code = ((HttpResponseException) exception).getStatusCode();
        retryable = BaseServiceException.isRetryable(code, null, idempotent, retryableErrors);
      }
    }
    return ExceptionData.newBuilder()
        .setMessage(message(exception))
        .setCause(exception)
        .setRetryable(MoreObjects
            .firstNonNull(retryable, BaseServiceException.isRetryable(idempotent, exception)))
        .setCode(code)
        .setReason(reason)
        .setLocation(location)
        .setDebugInfo(debugInfo)
        .build();
  }

  public BaseHttpServiceException(GoogleJsonError googleJsonError, boolean idempotent,
      Set<BaseServiceException.Error> retryableErrors) {
    super(makeExceptionData(googleJsonError, idempotent, retryableErrors));
  }

  private static ExceptionData makeExceptionData(GoogleJsonError googleJsonError, boolean idempotent,
      Set<BaseServiceException.Error> retryableErrors) {
    int code = googleJsonError.getCode();
    String reason = reason(googleJsonError);

    ExceptionData.Builder exceptionData = ExceptionData.newBuilder();
    exceptionData
        .setMessage(googleJsonError.getMessage())
        .setCause(null)
        .setRetryable(BaseServiceException.isRetryable(code, reason, idempotent, retryableErrors))
        .setCode(code)
        .setReason(reason);
    if (reason != null) {
      GoogleJsonError.ErrorInfo errorInfo = googleJsonError.getErrors().get(0);
      exceptionData.setLocation(errorInfo.getLocation());
      exceptionData.setDebugInfo((String) errorInfo.get("debugInfo"));
    } else {
      exceptionData.setLocation(null);
      exceptionData.setDebugInfo(null);
    }
    return exceptionData.build();
  }

  public BaseHttpServiceException(int code, String message, String reason, boolean idempotent,
      Set<BaseServiceException.Error> retryableErrors) {
    this(code, message, reason, idempotent, retryableErrors, null);
  }

  public BaseHttpServiceException(int code, String message, String reason, boolean idempotent,
      Set<BaseServiceException.Error> retryableErrors, Throwable cause) {
    super(ExceptionData.newBuilder()
        .setMessage(message)
        .setCause(cause)
        .setRetryable(BaseServiceException.isRetryable(code, reason, idempotent, retryableErrors))
        .setCode(code)
        .setReason(reason)
        .setLocation(null)
        .setDebugInfo(null)
        .build());
  }

  private static String reason(GoogleJsonError error) {
    if (error.getErrors() != null && !error.getErrors().isEmpty()) {
      return error.getErrors().get(0).getReason();
    }
    return null;
  }

  private static String message(IOException exception) {
    if (exception instanceof GoogleJsonResponseException) {
      GoogleJsonError details = ((GoogleJsonResponseException) exception).getDetails();
      if (details != null) {
        return details.getMessage();
      }
    }
    return exception.getMessage();
  }

}
