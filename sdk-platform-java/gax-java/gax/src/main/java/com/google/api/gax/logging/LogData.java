/*
 * Copyright 2025 Google LLC
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

package com.google.api.gax.logging;

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
@InternalApi
@AutoValue
public abstract class LogData {
  private static final Gson gson = new Gson();

  public abstract @Nullable String serviceName();

  public abstract @Nullable String rpcName();

  public abstract @Nullable String requestId();

  public abstract @Nullable Map<String, String> requestHeaders();

  public abstract @Nullable Map<String, Object> requestPayload();

  public abstract @Nullable String responseStatus();

  public abstract @Nullable Map<String, String> responseHeaders();

  public abstract @Nullable Map<String, Object> responsePayload();

  public abstract @Nullable String httpMethod();

  public abstract @Nullable String httpUrl();

  public static Builder builder() {
    return new AutoValue_LogData.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder serviceName(String serviceName);

    public abstract Builder rpcName(String rpcName);

    public abstract Builder requestId(String requestId);

    public abstract Builder requestHeaders(Map<String, String> requestHeaders);

    public abstract Builder requestPayload(Map<String, Object> requestPayload);

    public abstract Builder responseStatus(String responseStatus);

    public abstract Builder responseHeaders(Map<String, String> responseHeaders);

    public abstract Builder responsePayload(Map<String, Object> responsePayload);

    public abstract Builder httpMethod(String httpMethod);

    public abstract Builder httpUrl(String httpUrl);

    public abstract LogData build();
  }

  // helper functions to convert to map for logging
  public Map<String, Object> toMapRequest() {
    Map<String, Object> map = new HashMap<>();
    if (serviceName() != null) {
      map.put("serviceName", serviceName());
    }
    if (rpcName() != null) {
      map.put("rpcName", rpcName());
    }
    if (requestId() != null) {
      map.put("requestId", requestId());
    }
    if (requestHeaders() != null) {
      map.put("request.headers", requestHeaders());
    }
    if (requestPayload() != null) {
      map.put("request.payload", requestPayload());
    }
    if (httpMethod() != null) {
      map.put("request.method", httpMethod());
    }
    if (httpUrl() != null) {
      map.put("request.url", httpUrl());
    }
    return map;
  }

  public Map<String, Object> toMapResponse() {
    Map<String, Object> map = new HashMap<>();
    if (serviceName() != null) {
      map.put("serviceName", serviceName());
    }
    if (rpcName() != null) {
      map.put("rpcName", rpcName());
    }
    if (requestId() != null) {
      map.put("requestId", requestId());
    }
    if (responseStatus() != null) {
      map.put("response.status", responseStatus());
    }
    if (responseHeaders() != null) {
      map.put("response.headers", responseHeaders());
    }
    if (responsePayload() != null) {
      map.put("response.payload", responsePayload());
    }
    return map;
  }
}
