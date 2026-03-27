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

  /** Function to extract the status of the error as a string */
  static String extractStatus(@Nullable Throwable error) {
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
          }
        });
    return attributesBuilder.build();
  }
}
