/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.ObjectParser;
import com.google.cloud.storage.spi.v1.StorageRpc;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import java.util.List;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

final class HttpClientContext {

  private final HttpRequestFactory requestFactory;
  private final ObjectParser objectParser;
  private final Tracer tracer;

  private HttpClientContext(
      HttpRequestFactory requestFactory, ObjectParser objectParser, Tracer tracer) {
    this.requestFactory = requestFactory;
    this.objectParser = objectParser;
    this.tracer = tracer;
  }

  @SuppressWarnings({"unchecked", "SameParameterValue"})
  static @Nullable String firstHeaderValue(
      @NonNull HttpHeaders headers, @NonNull String headerName) {
    Object v = headers.get(headerName);
    // HttpHeaders doesn't type its get method, so we have to jump through hoops here
    if (v instanceof List) {
      List<String> list = (List<String>) v;
      return list.get(0);
    } else {
      return null;
    }
  }

  public HttpRequestFactory getRequestFactory() {
    return requestFactory;
  }

  public ObjectParser getObjectParser() {
    return objectParser;
  }

  public Tracer getTracer() {
    return tracer;
  }

  public Span startSpan(String name) {
    // record events is hardcoded to true in HttpStorageRpc, preserve it here
    return tracer.spanBuilder(name).setRecordEvents(true).startSpan();
  }

  static HttpClientContext from(StorageRpc storageRpc) {
    return new HttpClientContext(
        storageRpc.getStorage().getRequestFactory(),
        storageRpc.getStorage().getObjectParser(),
        Tracing.getTracer());
  }

  public static HttpClientContext of(
      HttpRequestFactory requestFactory, JsonObjectParser jsonObjectParser) {
    return new HttpClientContext(requestFactory, jsonObjectParser, Tracing.getTracer());
  }
}
