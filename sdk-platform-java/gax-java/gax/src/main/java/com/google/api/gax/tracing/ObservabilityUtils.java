/*
 * Copyright 2026 Google LLC
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
package com.google.api.gax.tracing;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import java.util.Map;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;

class ObservabilityUtils {

  static Object extractStatus(@Nullable Throwable error, ApiTracerContext.Transport transport) {
    if (transport == ApiTracerContext.Transport.HTTP) {
      return extractHttpStatus(error);
    }
    return extractGrpcStatus(error);
  }

  private static String extractGrpcStatus(@Nullable Throwable error) {
    final String statusString;
    if (error == null) {
      return StatusCode.Code.OK.toString();
    } else if (error instanceof CancellationException) {
      statusString = StatusCode.Code.CANCELLED.toString();
    } else if (error instanceof ApiException) {
      statusString = ((ApiException) error).getStatusCode().getCode().toString();
    } else {
      statusString = StatusCode.Code.UNKNOWN.toString();
    }
    return statusString;
  }

  private static Long extractHttpStatus(@Nullable Throwable error) {
    if (error == null) {
      return 200L;
    } else if (error instanceof ApiException) {
      Object transportCode = ((ApiException) error).getStatusCode().getTransportCode();
      // HttpJsonStatusCode.getTransportCode() returns an Integer (HTTP status code).
      // GrpcStatusCode returns a Status.Code enum, and FakeStatusCode (in tests) returns
      // a StatusCode.Code enum. If it's not an Integer, we fall back to the mapped
      // HTTP status code of the canonical code.
      if (transportCode instanceof Integer) {
        return ((Integer) transportCode).longValue();
      } else {
        return (long) ((ApiException) error).getStatusCode().getCode().getHttpStatusCode();
      }
    }
    StatusCode.Code code = StatusCode.Code.UNKNOWN;
    if (error instanceof CancellationException) {
      code = StatusCode.Code.CANCELLED;
    }
    return (long) code.getHttpStatusCode();
  }

  static void populateStatusAttributes(
      Map<String, Object> attributes,
      @Nullable Throwable error,
      ApiTracerContext.Transport transport) {
    if (transport == ApiTracerContext.Transport.GRPC) {
      attributes.put(
          ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE, extractStatus(error, transport));
    } else if (transport == ApiTracerContext.Transport.HTTP) {
      attributes.put(
          ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE, extractStatus(error, transport));
    }
  }

  static Attributes toOtelAttributes(Map<String, Object> attributes) {
    AttributesBuilder attributesBuilder = Attributes.builder();
    if (attributes == null) {
      return attributesBuilder.build();
    }
    attributes.forEach(
        (k, v) -> {
          if (v instanceof String) {
            attributesBuilder.put(k, (String) v);
          } else if (v instanceof Long) {
            attributesBuilder.put(k, (Long) v);
          } else if (v instanceof Integer) {
            attributesBuilder.put(k, (long) (Integer) v);
          } else if (v instanceof Long) {
            attributesBuilder.put(k, (Long) v);
          }
        });
    return attributesBuilder.build();
  }
}
