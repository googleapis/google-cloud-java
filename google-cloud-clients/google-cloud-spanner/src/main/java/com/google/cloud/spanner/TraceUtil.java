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

import com.google.cloud.Timestamp;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.spanner.v1.Transaction;
import io.opencensus.contrib.grpc.util.StatusConverter;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.EndSpanOptions;
import io.opencensus.trace.Span;
import io.opencensus.trace.Status;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import java.util.Map;

/** Utility methods for tracing. */
class TraceUtil {

  static Map<String, AttributeValue> getTransactionAnnotations(Transaction t) {
    return ImmutableMap.of(
        "Id",
        AttributeValue.stringAttributeValue(t.getId().toStringUtf8()),
        "Timestamp",
        AttributeValue.stringAttributeValue(Timestamp.fromProto(t.getReadTimestamp()).toString()));
  }

  static ImmutableMap<String, AttributeValue> getExceptionAnnotations(RuntimeException e) {
    if (e instanceof SpannerException) {
      return ImmutableMap.of(
          "Status",
          AttributeValue.stringAttributeValue(((SpannerException) e).getErrorCode().toString()));
    }
    return ImmutableMap.of();
  }

  static ImmutableMap<String, AttributeValue> getExceptionAnnotations(SpannerException e) {
    return ImmutableMap.of(
        "Status", AttributeValue.stringAttributeValue(e.getErrorCode().toString()));
  }

  static void endSpanWithFailure(Span span, Throwable e) {
    if (e instanceof SpannerException) {
      endSpanWithFailure(span, (SpannerException) e);
    } else {
      span.setStatus(Status.INTERNAL.withDescription(e.getMessage()));
      span.end();
    }
  }

  static void endSpanWithFailure(Span span, SpannerException e) {
    span.setStatus(
        StatusConverter.fromGrpcStatus(e.getErrorCode().getGrpcStatus())
            .withDescription(e.getMessage()));
    span.end();
  }

  /**
   * Appends the list of span names for sample collection.
   *
   * <p>If called multiple times the library keeps the list of unique span names from all the calls.
   *
   * @param spans list of span names.
   */
  static void exportSpans(String... spans) {
    Preconditions.checkNotNull(spans);
    Tracer tracer = Tracing.getTracer();
    Span span = null;
    for (String spanName : spans) {
      span = tracer.spanBuilder(spanName).setRecordEvents(true).startSpan();
      span.end(EndSpanOptions.builder().setSampleToLocalSpanStore(true).build());
    }
  }
}
