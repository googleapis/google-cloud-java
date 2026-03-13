/*
 * Copyright 2022 Google LLC
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
import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@AutoValue
@InternalExtensionOnly
public abstract class HttpJsonMetadata {
  public abstract Map<String, Object> getHeaders();

  @Nullable
  public abstract String getStatusMessage();

  @Nullable
  public abstract Throwable getException();

  public abstract Builder toBuilder();

  public static HttpJsonMetadata.Builder newBuilder() {
    return new AutoValue_HttpJsonMetadata.Builder().setHeaders(Collections.emptyMap());
  }

  public HttpJsonMetadata withHeaders(Map<String, List<String>> headers) {
    Map<String, Object> extraHeaders = new HashMap<>();
    for (Map.Entry<String, List<String>> entrySet : headers.entrySet()) {
      // HeaderValueList is always non-null. Check that it contains at least one value.
      // Should only ever contain one value, but take the first one if there are multiple.
      // TODO(https://github.com/googleapis/sdk-platform-java/issues/1752):
      // Investigate how to better support extraHeaders
      List<String> headerValueList = entrySet.getValue();
      if (headerValueList.isEmpty()) {
        continue;
      }
      extraHeaders.put(entrySet.getKey(), headerValueList.get(0));
    }
    return toBuilder().setHeaders(extraHeaders).build();
  }

  @AutoValue.Builder
  abstract static class Builder {
    abstract Builder setHeaders(Map<String, Object> headers);

    public abstract Builder setStatusMessage(String value);

    public abstract Builder setException(Throwable value);

    abstract HttpJsonMetadata build();
  }
}
