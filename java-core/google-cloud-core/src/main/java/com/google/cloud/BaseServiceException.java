/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.cloud;

import com.google.api.core.InternalApi;
import com.google.common.base.MoreObjects;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;

/**
 * Base class for all service exceptions.
 */
public class BaseServiceException extends RuntimeException {

  private static final long serialVersionUID = 759921776378760835L;
  public static final int UNKNOWN_CODE = 0;

  private final int code;
  private final boolean retryable;
  private final String reason;
  private final String location;
  private final String debugInfo;

  @InternalApi
  public static final class ExceptionData implements Serializable {
    private static final long serialVersionUID = 2222230861338426753L;

    private final String message;
    private final Throwable cause;
    private final int code;
    private final boolean retryable;
    private final String reason;
    private final String location;
    private final String debugInfo;

    private ExceptionData(String message, Throwable cause, int code, boolean retryable,
        String reason, String location, String debugInfo) {
      this.message = message;
      this.cause = cause;
      this.code = code;
      this.retryable = retryable;
      this.reason = reason;
      this.location = location;
      this.debugInfo = debugInfo;
    }

    public String getMessage() {
      return message;
    }

    public Throwable getCause() {
      return cause;
    }

    public int getCode() {
      return code;
    }

    public boolean isRetryable() {
      return retryable;
    }

    public String getReason() {
      return reason;
    }

    public String getLocation() {
      return location;
    }

    public String getDebugInfo() {
      return debugInfo;
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public static ExceptionData from(int code, String message, String reason, boolean retryable) {
      return from(code, message, reason, retryable, null);
    }

    public static ExceptionData from(int code, String message, String reason, boolean retryable,
        Throwable cause) {
      return newBuilder().setCode(code).setMessage(message).setReason(reason)
          .setRetryable(retryable).setCause(cause).build();
    }

    @InternalApi
    public static final class Builder {

      private String message;
      private Throwable cause;
      private int code;
      private boolean retryable;
      private String reason;
      private String location;
      private String debugInfo;

      private Builder() {}

      public Builder setMessage(String message) {
        this.message = message;
        return this;
      }

      public Builder setCause(Throwable cause) {
        this.cause = cause;
        return this;
      }

      public Builder setCode(int code) {
        this.code = code;
        return this;
      }

      public Builder setRetryable(boolean retryable) {
        this.retryable = retryable;
        return this;
      }

      public Builder setReason(String reason) {
        this.reason = reason;
        return this;
      }

      public Builder setLocation(String location) {
        this.location = location;
        return this;
      }

      public Builder setDebugInfo(String debugInfo) {
        this.debugInfo = debugInfo;
        return this;
      }

      public ExceptionData build() {
        return new ExceptionData(message, cause, code, retryable, reason, location,
            debugInfo);
      }
    }
  }

  @InternalApi
  public static final class Error implements Serializable {

    private static final long serialVersionUID = -4019600198652965721L;

    private final Integer code;
    private final String reason;
    private final boolean rejected;

    public Error(Integer code, String reason) {
      this(code, reason, false);
    }

    public Error(Integer code, String reason, boolean rejected) {
      this.code = code;
      this.reason = reason;
      this.rejected = rejected;
    }


    /**
     * Returns the code associated with this exception.
     */
    public Integer getCode() {
      return code;
    }


    /**
     * Returns true if the error indicates that the API call was certainly not accepted by the
     * server. For instance, if the server returns a rate limit exceeded error, it certainly did not
     * process the request and this method will return {@code true}.
     */
    public boolean isRejected() {
      return rejected;
    }


    /**
     * Returns the reason that caused the exception.
     */
    public String getReason() {
      return reason;
    }

    @InternalApi
    public boolean isRetryable(boolean idempotent, Set<Error> retryableErrors) {
      return BaseServiceException.isRetryable(code, reason, idempotent, retryableErrors);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("code", code).add("reason", reason).toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(code, reason);
    }
  }


  @InternalApi
  public static boolean isRetryable(Integer code, String reason, boolean idempotent,
      Set<Error> retryableErrors) {
    for (Error retryableError : retryableErrors) {
      if ((retryableError.getCode() == null || retryableError.getCode().equals(code))
          && (retryableError.getReason() == null
          || retryableError.getReason().equals(reason))) {
        return idempotent || retryableError.isRejected();
      }
    }
    return false;
  }

  @InternalApi
  public static boolean isRetryable(boolean idempotent, IOException exception) {
    boolean exceptionIsRetryable = exception instanceof SocketTimeoutException
        || exception instanceof SocketException
        || (exception instanceof SSLHandshakeException
        && !(exception.getCause() instanceof CertificateException))
        || "insufficient data written".equals(exception.getMessage());
    return idempotent && exceptionIsRetryable;
  }

  @InternalApi
  public static void translate(RetryHelper.RetryHelperException ex) {
    if (ex.getCause() instanceof BaseServiceException) {
      throw (BaseServiceException) ex.getCause();
    }
  }

  public BaseServiceException(ExceptionData exceptionData) {
    super(exceptionData.getMessage(), exceptionData.getCause());
    this.code = exceptionData.getCode();
    this.reason = exceptionData.getReason();
    this.retryable = exceptionData.isRetryable();
    this.location = exceptionData.getLocation();
    this.debugInfo = exceptionData.getDebugInfo();
  }

  /**
   * Returns the code associated with this exception.
   */
  public int getCode() {
    return code;
  }


  /**
   * Returns the reason that caused the exception.
   */
  public String getReason() {
    return reason;
  }


  /**
   * Returns {@code true} when it is safe to retry the operation that caused this exception.
   */
  public boolean isRetryable() {
    return retryable;
  }


  /**
   * Returns the service location where the error causing the exception occurred. Returns {@code
   * null} if not available.
   */
  public String getLocation() {
    return location;
  }

  @InternalApi
  public String getDebugInfo() {
    return debugInfo;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof BaseServiceException)) {
      return false;
    }
    BaseServiceException other = (BaseServiceException) obj;
    return Objects.equals(getCause(), other.getCause())
        && Objects.equals(getMessage(), other.getMessage())
        && code == other.code
        && retryable == other.retryable
        && Objects.equals(reason, other.reason)
        && Objects.equals(location, other.location)
        && Objects.equals(debugInfo, other.debugInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCause(), getMessage(), code, retryable, reason, location, debugInfo);
  }
}
