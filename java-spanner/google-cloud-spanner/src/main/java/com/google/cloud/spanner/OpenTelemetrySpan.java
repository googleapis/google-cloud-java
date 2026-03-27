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

package com.google.cloud.spanner;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import java.util.Map;

class OpenTelemetrySpan implements ISpan {

  private final io.opentelemetry.api.trace.Span openTelemetrySpan;

  OpenTelemetrySpan(Span openTelemetrySpan) {
    this.openTelemetrySpan = openTelemetrySpan;
  }

  Span getOpenTelemetrySpan() {
    return openTelemetrySpan;
  }

  @Override
  public void addAnnotation(String message, Map<String, Object> attributes) {
    AttributesBuilder otAttributesBuilder = Attributes.builder();
    for (Map.Entry<String, Object> entry : attributes.entrySet()) {
      String key = entry.getKey();
      Object value = entry.getValue();
      if (value instanceof String) {
        otAttributesBuilder.put(key, (String) value);
      } else if (value instanceof Long) {
        otAttributesBuilder.put(key, (Long) value);
      }
    }
    openTelemetrySpan.addEvent(message, otAttributesBuilder.build());
  }

  @Override
  public void addAnnotation(String message) {
    openTelemetrySpan.addEvent(message);
  }

  @Override
  public void addAnnotation(String message, String key, String value) {
    openTelemetrySpan.addEvent(message, Attributes.builder().put(key, value).build());
  }

  @Override
  public void addAnnotation(String message, String key, long value) {
    openTelemetrySpan.addEvent(message, Attributes.builder().put(key, value).build());
  }

  @Override
  public void addAnnotation(String message, Throwable e) {
    openTelemetrySpan.addEvent(message, this.createOpenTelemetryExceptionAnnotations(e));
  }

  @Override
  public void setStatus(Throwable e) {
    if (e instanceof SpannerException) {
      openTelemetrySpan.setStatus(StatusCode.ERROR, ((SpannerException) e).getErrorCode().name());
    } else {
      openTelemetrySpan.setStatus(StatusCode.ERROR, ErrorCode.INTERNAL.name());
    }
    openTelemetrySpan.recordException(e);
  }

  @Override
  public void setStatus(ErrorCode errorCode) {
    openTelemetrySpan.setStatus(StatusCode.ERROR, errorCode.name());
  }

  @Override
  public void end() {
    openTelemetrySpan.end();
  }

  private Attributes createOpenTelemetryExceptionAnnotations(Throwable e) {
    AttributesBuilder attributesBuilder = Attributes.builder();
    if (e instanceof SpannerException) {
      attributesBuilder.put("Status", ((SpannerException) e).getErrorCode().toString());
    }
    return attributesBuilder.build();
  }
}
