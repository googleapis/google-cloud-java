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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.sdk.trace.data.SpanData;
import java.util.List;
import java.util.Optional;

public class OpenTelemetryTestUtility {

  /**
   * Asserts that a span with the given name exists in the provided list and returns it.
   *
   * @param spans The list of exported spans.
   * @param spanName The name of the span to find.
   * @return The found SpanData.
   * @throws AssertionError if the span is not found.
   */
  public static SpanData findSpanByName(List<SpanData> spans, String spanName) {
    Optional<SpanData> span = spans.stream().filter(s -> s.getName().equals(spanName)).findFirst();
    assertTrue(span.isPresent(), "Span with name '" + spanName + "' not found");
    return span.get();
  }

  /**
   * Asserts that a span exists in the list.
   *
   * @param spans The list of exported spans.
   * @param spanName The name of the span to find.
   */
  public static void assertSpanExists(List<SpanData> spans, String spanName) {
    findSpanByName(spans, spanName);
  }

  /**
   * Asserts that a span has a specific attribute key and value.
   *
   * @param span The span to check.
   * @param key The attribute key.
   * @param expectedValue The expected value of the attribute.
   * @param <T> The type of the attribute value.
   */
  public static <T> void assertSpanHasAttribute(
      SpanData span, AttributeKey<T> key, T expectedValue) {
    T actualValue = span.getAttributes().get(key);
    assertNotNull(
        actualValue, "Attribute '" + key.getKey() + "' not found on span '" + span.getName() + "'");
    assertEquals(
        expectedValue,
        actualValue,
        "Attribute '" + key.getKey() + "' value mismatch on span '" + span.getName() + "'");
  }

  /**
   * Asserts the status of a span.
   *
   * @param span The span to check.
   * @param expectedStatus The expected StatusCode.
   */
  public static void assertSpanStatus(SpanData span, StatusCode expectedStatus) {
    assertEquals(
        expectedStatus,
        span.getStatus().getStatusCode(),
        "Status code mismatch on span '" + span.getName() + "'");
  }

  /**
   * Asserts that an exception of a specific type was recorded on the span.
   *
   * @param span The span to check.
   * @param exceptionClass The class of the expected exception.
   */
  public static void assertSpanHasException(
      SpanData span, Class<? extends Throwable> exceptionClass) {
    boolean found =
        span.getEvents().stream()
            .anyMatch(
                event ->
                    event.getName().equals("exception")
                        && exceptionClass
                            .getName()
                            .equals(
                                event
                                    .getAttributes()
                                    .get(AttributeKey.stringKey("exception.type"))));
    assertTrue(
        found,
        "Exception of type "
            + exceptionClass.getName()
            + " not found in events of span '"
            + span.getName()
            + "'");
  }

  /**
   * Asserts that a span is linked to a parent span.
   *
   * @param spans The list of exported spans.
   * @param spanName The name of the span that should have the link.
   * @param parentSpan The parent span it should be linked to.
   */
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
