/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.sdk.trace.data.SpanData;
import java.util.List;

public class OpenTelemetryTestUtility {

  public static void assertSpanLinkedToParent(
      List<SpanData> spans, String spanName, Span parentSpan) {
    boolean found =
        spans.stream()
            .anyMatch(
                span ->
                    span.getName().equals(spanName)
                        && span.getLinks().stream()
                            .anyMatch(
                                link ->
                                    link.getSpanContext()
                                            .getTraceId()
                                            .equals(parentSpan.getSpanContext().getTraceId())
                                        && link.getSpanContext()
                                            .getSpanId()
                                            .equals(parentSpan.getSpanContext().getSpanId())));
    assertTrue(found, "Span " + spanName + " not found or not linked to parent");
  }
}
