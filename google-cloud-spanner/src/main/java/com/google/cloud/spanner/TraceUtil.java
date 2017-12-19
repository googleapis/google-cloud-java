/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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
import com.google.common.collect.ImmutableMap;
import com.google.spanner.v1.Transaction;

import io.opencensus.contrib.grpc.util.StatusConverter;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Status;
import io.opencensus.trace.Tracing;
import io.opencensus.trace.export.SampledSpanStore;

import java.util.Arrays;
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

  static void endSpanWithFailure(Span span, Exception e) {
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

  static void exportSpans(String... spans) {
    SampledSpanStore store = Tracing.getExportComponent().getSampledSpanStore();
    if (store != null) {
      store.registerSpanNamesForCollection(Arrays.asList(spans));
    }
  }
}
