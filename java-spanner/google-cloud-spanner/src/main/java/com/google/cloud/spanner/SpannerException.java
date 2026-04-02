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

package com.google.cloud.spanner;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.cloud.grpc.BaseGrpcServiceException;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.protobuf.util.Durations;
import com.google.rpc.ResourceInfo;
import com.google.rpc.RetryInfo;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.protobuf.ProtoUtils;
import java.util.Map;
import javax.annotation.Nullable;

/** Base exception type for all exceptions produced by the Cloud Spanner service. */
public class SpannerException extends BaseGrpcServiceException {
  /** Base exception type for NOT_FOUND exceptions for known resource types. */
  public abstract static class ResourceNotFoundException extends SpannerException {
    private final ResourceInfo resourceInfo;

    ResourceNotFoundException(
        DoNotConstructDirectly token,
        @Nullable String message,
        ResourceInfo resourceInfo,
        @Nullable Throwable cause,
        @Nullable ApiException apiException) {
      super(token, ErrorCode.NOT_FOUND, /* retryable */ false, message, cause, apiException);
      this.resourceInfo = resourceInfo;
    }

    public String getResourceName() {
      return resourceInfo.getResourceName();
    }
  }

  private static final long serialVersionUID = 20150916L;
  private static final Metadata.Key<RetryInfo> KEY_RETRY_INFO =
      ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
  private static final String PG_ERR_CODE_KEY = "pg_sqlerrcode";

  private final ErrorCode code;
  private final ApiException apiException;
  private final XGoogSpannerRequestId requestId;
  private String statement;

  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  SpannerException(
      DoNotConstructDirectly token,
      ErrorCode code,
      boolean retryable,
      @Nullable String message,
      @Nullable Throwable cause) {
    this(token, code, retryable, message, cause, null);
  }

  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  SpannerException(
      DoNotConstructDirectly token,
      ErrorCode code,
      boolean retryable,
      @Nullable String message,
      @Nullable Throwable cause,
      @Nullable ApiException apiException) {
    super(message, cause, code.getCode(), retryable);
    if (token != DoNotConstructDirectly.ALLOWED) {
      throw new AssertionError("Do not construct directly: use SpannerExceptionFactory");
    }
    this.code = Preconditions.checkNotNull(code);
    this.apiException = apiException;
    this.requestId = extractRequestId(cause);
  }

  @Override
  public String getMessage() {
    if (this.statement == null) {
      return super.getMessage();
    }
    return String.format("%s - Statement: '%s'", super.getMessage(), this.statement);
  }

  @Override
  public String toString() {
    if (this.requestId == null) {
      return super.toString();
    }
    return super.toString() + " - RequestId: " + this.requestId;
  }

  /** Returns the error code associated with this exception. */
  public ErrorCode getErrorCode() {
    return code;
  }

  /**
   * Returns the PostgreSQL SQLState error code that is encoded in this exception, or null if this
   * {@link SpannerException} does not include a PostgreSQL error code.
   */
  public String getPostgreSQLErrorCode() {
    ErrorDetails details = getErrorDetails();
    if (details == null || details.getErrorInfo() == null) {
      return null;
    }
    return details.getErrorInfo().getMetadataOrDefault(PG_ERR_CODE_KEY, null);
  }

  public String getRequestId() {
    if (requestId == null) {
      return "";
    }
    return requestId.toString();
  }

  enum DoNotConstructDirectly {
    ALLOWED
  }

  /**
   * Return the retry delay for operation in milliseconds. Return -1 if this does not specify any
   * retry delay.
   */
  public long getRetryDelayInMillis() {
    return extractRetryDelay(this.getCause());
  }

  static long extractRetryDelay(Throwable cause) {
    if (cause != null) {
      Metadata trailers = Status.trailersFromThrowable(cause);
      if (trailers != null && trailers.containsKey(KEY_RETRY_INFO)) {
        RetryInfo retryInfo = trailers.get(KEY_RETRY_INFO);
        if (retryInfo != null && retryInfo.hasRetryDelay()) {
          return Durations.toMillis(retryInfo.getRetryDelay());
        }
      }
    }
    return -1L;
  }

  @Nullable
  static XGoogSpannerRequestId extractRequestId(Throwable cause) {
    if (cause != null) {
      Metadata trailers = Status.trailersFromThrowable(cause);
      if (trailers != null && trailers.containsKey(XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY)) {
        String requestId = trailers.get(XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY);
        if (!Strings.isNullOrEmpty(requestId)) {
          return XGoogSpannerRequestId.of(requestId);
        }
      }
    }
    return null;
  }

  /**
   * Checks the underlying reason of the exception and if it's {@link ApiException} then return the
   * reason otherwise null.
   *
   * @see <a
   *     href="https://github.com/googleapis/googleapis/blob/master/google/rpc/error_details.proto#L117">Reason</a>
   * @return the reason of an error.
   */
  public String getReason() {
    if (this.apiException != null) {
      return this.apiException.getReason();
    }
    return null;
  }

  /**
   * Checks the underlying reason of the exception and if it's {@link ApiException} then return the
   * specific domain otherwise null.
   *
   * @see <a
   *     href="https://github.com/googleapis/googleapis/blob/master/google/rpc/error_details.proto#L125">Domain</a>
   * @return the logical grouping to which the "reason" belongs.
   */
  public String getDomain() {
    if (this.apiException != null) {
      return this.apiException.getDomain();
    }
    return null;
  }

  /**
   * Checks the underlying reason of the exception and if it's {@link ApiException} then return a
   * map of key-value pairs otherwise null.
   *
   * @see <a
   *     href="https://github.com/googleapis/googleapis/blob/master/google/rpc/error_details.proto#L135">Metadata</a>
   * @return the map of additional structured details about an error.
   */
  public Map<String, String> getMetadata() {
    if (this.apiException != null) {
      return this.apiException.getMetadata();
    }
    return null;
  }

  /**
   * Checks the underlying reason of the exception and if it's {@link ApiException} then return the
   * ErrorDetails otherwise null.
   *
   * @see <a
   *     href="https://github.com/googleapis/googleapis/blob/master/google/rpc/status.proto">Status</a>
   * @see <a
   *     href="https://github.com/googleapis/googleapis/blob/master/google/rpc/error_details.proto">Error
   *     Details</a>
   * @return An object containing getters for structured objects from error_details.proto.
   */
  public ErrorDetails getErrorDetails() {
    if (this.apiException != null) {
      return this.apiException.getErrorDetails();
    }
    return null;
  }

  void setStatement(String statement) {
    this.statement = statement;
  }
}
