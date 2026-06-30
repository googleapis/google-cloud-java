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

import com.google.common.collect.ImmutableMap;
import io.opencensus.contrib.grpc.util.StatusConverter;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.EndSpanOptions;
import io.opencensus.trace.Span;
import io.opencensus.trace.Status;
import java.util.HashMap;
import java.util.Map;

public class OpenCensusSpan implements ISpan {

  static final EndSpanOptions END_SPAN_OPTIONS =
      EndSpanOptions.builder().setSampleToLocalSpanStore(true).build();
  private final Span openCensusSpan;

  public OpenCensusSpan(Span openCensusSpan) {
    this.openCensusSpan = openCensusSpan;
  }

  Span getOpenCensusSpan() {
    return openCensusSpan;
  }

  private ImmutableMap<String, AttributeValue> getOpenCensusExceptionAnnotations(Throwable e) {
    if (e instanceof SpannerException) {
      return ImmutableMap.of(
          "Status",
          AttributeValue.stringAttributeValue(((SpannerException) e).getErrorCode().toString()));
    }
    return ImmutableMap.of();
  }

  @Override
  public void addAnnotation(String message, Map<String, Object> attributes) {
    Map<String, AttributeValue> ocAttributeValues = new HashMap<>();
    for (Map.Entry<String, Object> entry : attributes.entrySet()) {
      String key = entry.getKey();
      Object value = entry.getValue();
      if (value instanceof String) {
        ocAttributeValues.put(key, AttributeValue.stringAttributeValue((String) value));
      } else if (value instanceof Long) {
        ocAttributeValues.put(key, AttributeValue.longAttributeValue((Long) value));
      }
    }

    if (ocAttributeValues.size() > 0) {
      openCensusSpan.addAnnotation(message, ocAttributeValues);
    }
  }

  @Override
  public void addAnnotation(String message) {
    openCensusSpan.addAnnotation(message);
  }

  @Override
  public void addAnnotation(String message, String key, String value) {
    openCensusSpan.addAnnotation(
        message, ImmutableMap.of(key, AttributeValue.stringAttributeValue(value)));
  }

  @Override
  public void addAnnotation(String message, String key, long value) {
    openCensusSpan.addAnnotation(
        message, ImmutableMap.of(key, AttributeValue.longAttributeValue(value)));
  }

  @Override
  public void addAnnotation(String message, Throwable e) {
    openCensusSpan.addAnnotation(message, this.getOpenCensusExceptionAnnotations(e));
  }

  @Override
  public void setStatus(Throwable e) {
    if (e instanceof SpannerException) {
      openCensusSpan.setStatus(
          StatusConverter.fromGrpcStatus(((SpannerException) e).getErrorCode().getGrpcStatus())
              .withDescription(e.getMessage()));
    } else {
      openCensusSpan.setStatus(Status.INTERNAL.withDescription(e.getMessage()));
    }
  }

  @Override
  public void setStatus(ErrorCode errorCode) {
    openCensusSpan.setStatus(StatusConverter.fromGrpcStatus(errorCode.getGrpcStatus()));
  }

  @Override
  public void end() {
    openCensusSpan.end(END_SPAN_OPTIONS);
  }
}
