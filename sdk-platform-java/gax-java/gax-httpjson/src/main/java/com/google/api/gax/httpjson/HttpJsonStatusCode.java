/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.httpjson;

import com.google.api.core.InternalExtensionOnly;
import com.google.api.gax.rpc.StatusCode;
import java.util.Objects;

/** A failure code specific to an HTTP call. */
@InternalExtensionOnly
public class HttpJsonStatusCode implements StatusCode {
  private final int httpStatus;
  private final Code statusCode;

  /** Creates a new instance with the given status code. */
  public static HttpJsonStatusCode of(int httpStatus) {
    return new HttpJsonStatusCode(httpStatus, httpStatusToStatusCode(httpStatus));
  }

  public static HttpJsonStatusCode of(Code statusCode) {
    return new HttpJsonStatusCode(statusCode.getHttpStatusCode(), statusCode);
  }

  public static HttpJsonStatusCode of(com.google.rpc.Code rpcCode) {
    return HttpJsonStatusCode.of(rpcCodeToStatusCode(rpcCode));
  }

  static Code rpcCodeToStatusCode(com.google.rpc.Code rpcCode) {
    switch (rpcCode) {
      case OK:
        return Code.OK;
      case CANCELLED:
        return Code.CANCELLED;
      case UNKNOWN:
        return Code.UNKNOWN;
      case INVALID_ARGUMENT:
        return Code.INVALID_ARGUMENT;
      case DEADLINE_EXCEEDED:
        return Code.DEADLINE_EXCEEDED;
      case NOT_FOUND:
        return Code.NOT_FOUND;
      case ALREADY_EXISTS:
        return Code.ALREADY_EXISTS;
      case PERMISSION_DENIED:
        return Code.PERMISSION_DENIED;
      case RESOURCE_EXHAUSTED:
        return Code.RESOURCE_EXHAUSTED;
      case FAILED_PRECONDITION:
        return Code.FAILED_PRECONDITION;
      case ABORTED:
        return Code.ABORTED;
      case OUT_OF_RANGE:
        return Code.OUT_OF_RANGE;
      case UNIMPLEMENTED:
        return Code.UNIMPLEMENTED;
      case INTERNAL:
        return Code.INTERNAL;
      case UNAVAILABLE:
        return Code.UNAVAILABLE;
      case DATA_LOSS:
        return Code.DATA_LOSS;
      case UNAUTHENTICATED:
        return Code.UNAUTHENTICATED;
      default:
        throw new IllegalArgumentException("Unrecognized rpc code: " + rpcCode);
    }
  }

  static Code httpStatusToStatusCode(int httpStatus) {
    if (200 <= httpStatus && httpStatus < 300) {
      return Code.OK;
    } else if (400 <= httpStatus && httpStatus < 500) {
      switch (httpStatus) {
        case 400:
          return Code.INVALID_ARGUMENT;
        case 401:
          return Code.UNAUTHENTICATED;
        case 403:
          return Code.PERMISSION_DENIED;
        case 404:
          return Code.NOT_FOUND;
        case 409:
          return Code.ABORTED;
        case 416:
          return Code.OUT_OF_RANGE;
        case 429:
          return Code.RESOURCE_EXHAUSTED;
        case 499:
          return Code.CANCELLED;
        default:
          return Code.FAILED_PRECONDITION;
      }
    } else if (500 <= httpStatus && httpStatus < 600) {
      switch (httpStatus) {
        case 501:
          return Code.UNIMPLEMENTED;
        case 503:
          return Code.UNAVAILABLE;
        case 504:
          return Code.DEADLINE_EXCEEDED;
        default:
          return Code.INTERNAL;
      }
    }
    return Code.UNKNOWN;
  }

  @Override
  public Code getCode() {
    return statusCode;
  }

  /** Returns the status code from the http call. */
  @Override
  public Integer getTransportCode() {
    return httpStatus;
  }

  private HttpJsonStatusCode(int httpStatus, Code statusCode) {
    this.httpStatus = httpStatus;
    this.statusCode = statusCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    HttpJsonStatusCode that = (HttpJsonStatusCode) o;

    return Objects.equals(statusCode, that.statusCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode);
  }

  @Override
  public String toString() {
    return "HttpJsonStatusCode{" + "statusCode=" + statusCode + "}";
  }
}
