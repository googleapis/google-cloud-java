/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging;

import static org.junit.Assert.*;

import com.google.cloud.logging.ContextHandler.ContextPriority;
import com.google.cloud.logging.HttpRequest.RequestMethod;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ContextHandlerTest {
  private static final HttpRequest OLD_HTTP_REQUEST =
      HttpRequest.newBuilder()
          .setRequestMethod(RequestMethod.POST)
          .setRequestUrl("https://old.com")
          .setUserAgent("Test User Agent")
          .build();
  private static final HttpRequest HTTP_REQUEST =
      HttpRequest.newBuilder()
          .setRequestMethod(RequestMethod.GET)
          .setRequestUrl("https://example.com")
          .setUserAgent("Test User Agent")
          .build();
  private static final String OLD_TRACE_ID = "10100101010101010101010101010101";
  private static final String OLD_SPAN_ID = "0";
  private static final boolean OLD_TRACE_SAMPLED = false;
  private static final String TRACE_ID = "01010101010101010101010101010101";
  private static final String SPAN_ID = "1";
  private static final boolean TRACE_SAMPLED = true;

  @After
  public void teardown() {
    new ContextHandler().removeCurrentContext();
    new ContextHandler().removeCurrentContextPriority();
  }

  @Test
  public void testDefaultSetContext() {
    Context newContext =
        Context.newBuilder()
            .setRequest(HTTP_REQUEST)
            .setTraceId(TRACE_ID)
            .setSpanId(SPAN_ID)
            .setTraceSampled(TRACE_SAMPLED)
            .build();
    new ContextHandler().setCurrentContext(newContext);
    Context currentContext = new ContextHandler().getCurrentContext();
    assertEquals(HTTP_REQUEST, currentContext.getHttpRequest());
    assertEquals(TRACE_ID, currentContext.getTraceId());
    assertEquals(SPAN_ID, currentContext.getSpanId());
    assertEquals(TRACE_SAMPLED, currentContext.getTraceSampled());
    assertEquals(ContextPriority.NO_INPUT, new ContextHandler().getCurrentContextPriority());
  }

  @Test
  public void testSetContextWithPriorityFromNoInput() {
    Context newContext =
        Context.newBuilder()
            .setRequest(HTTP_REQUEST)
            .setTraceId(TRACE_ID)
            .setSpanId(SPAN_ID)
            .setTraceSampled(TRACE_SAMPLED)
            .build();
    new ContextHandler().setCurrentContext(newContext, ContextPriority.NO_INPUT);
    Context currentContext = new ContextHandler().getCurrentContext();
    assertEquals(ContextPriority.NO_INPUT, new ContextHandler().getCurrentContextPriority());
    assertEquals(HTTP_REQUEST, currentContext.getHttpRequest());
    assertEquals(TRACE_ID, currentContext.getTraceId());
    assertEquals(SPAN_ID, currentContext.getSpanId());
    assertEquals(TRACE_SAMPLED, currentContext.getTraceSampled());
  }

  @Test
  public void testSetContextWithPriorityFromW3CHeader() {
    Context newContext =
        Context.newBuilder()
            .setRequest(HTTP_REQUEST)
            .setTraceId(TRACE_ID)
            .setSpanId(SPAN_ID)
            .setTraceSampled(TRACE_SAMPLED)
            .build();
    new ContextHandler().setCurrentContext(newContext, ContextPriority.W3C_HEADER);
    Context currentContext = new ContextHandler().getCurrentContext();
    assertEquals(ContextPriority.W3C_HEADER, new ContextHandler().getCurrentContextPriority());
    assertEquals(HTTP_REQUEST, currentContext.getHttpRequest());
    assertEquals(TRACE_ID, currentContext.getTraceId());
    assertEquals(SPAN_ID, currentContext.getSpanId());
    assertEquals(TRACE_SAMPLED, currentContext.getTraceSampled());
  }

  @Test
  public void testSetContextFromXCloudHeader() {
    Context newContext =
        Context.newBuilder()
            .setRequest(HTTP_REQUEST)
            .setTraceId(TRACE_ID)
            .setSpanId(SPAN_ID)
            .setTraceSampled(TRACE_SAMPLED)
            .build();
    new ContextHandler().setCurrentContext(newContext, ContextPriority.XCLOUD_HEADER);
    Context currentContext = new ContextHandler().getCurrentContext();
    assertEquals(ContextPriority.XCLOUD_HEADER, new ContextHandler().getCurrentContextPriority());
    assertEquals(HTTP_REQUEST, currentContext.getHttpRequest());
    assertEquals(TRACE_ID, currentContext.getTraceId());
    assertEquals(SPAN_ID, currentContext.getSpanId());
    assertEquals(TRACE_SAMPLED, currentContext.getTraceSampled());
  }

  @Test
  public void testSetContextFromOpenTelemetry() {
    Context newContext =
        Context.newBuilder()
            .setRequest(HTTP_REQUEST)
            .setTraceId(TRACE_ID)
            .setSpanId(SPAN_ID)
            .setTraceSampled(TRACE_SAMPLED)
            .build();
    new ContextHandler().setCurrentContext(newContext, ContextPriority.OTEL_EXTRACTED);
    Context currentContext = new ContextHandler().getCurrentContext();
    assertEquals(ContextPriority.OTEL_EXTRACTED, new ContextHandler().getCurrentContextPriority());
    assertEquals(HTTP_REQUEST, currentContext.getHttpRequest());
    assertEquals(TRACE_ID, currentContext.getTraceId());
    assertEquals(SPAN_ID, currentContext.getSpanId());
    assertEquals(TRACE_SAMPLED, currentContext.getTraceSampled());
  }

  @Test
  public void testOverrideW3CContextFromOpenTelemetry() {
    Context oldContext =
        Context.newBuilder()
            .setRequest(OLD_HTTP_REQUEST)
            .setTraceId(OLD_TRACE_ID)
            .setSpanId(OLD_SPAN_ID)
            .setTraceSampled(OLD_TRACE_SAMPLED)
            .build();
    new ContextHandler().setCurrentContext(oldContext, ContextPriority.W3C_HEADER);
    Context newContext =
        Context.newBuilder()
            .setRequest(HTTP_REQUEST)
            .setTraceId(TRACE_ID)
            .setSpanId(SPAN_ID)
            .setTraceSampled(TRACE_SAMPLED)
            .build();
    new ContextHandler().setCurrentContext(newContext, ContextPriority.OTEL_EXTRACTED);
    // Expects context being overridden when context was set with higher priority.
    assertEquals(ContextPriority.OTEL_EXTRACTED, new ContextHandler().getCurrentContextPriority());
    Context currentContext = new ContextHandler().getCurrentContext();
    assertEquals(HTTP_REQUEST, currentContext.getHttpRequest());
    assertEquals(TRACE_ID, currentContext.getTraceId());
    assertEquals(SPAN_ID, currentContext.getSpanId());
    assertEquals(TRACE_SAMPLED, currentContext.getTraceSampled());
  }

  @Test
  public void testOverrideXCTCContextFromOpenTelemetry() {
    Context oldContext =
        Context.newBuilder()
            .setRequest(OLD_HTTP_REQUEST)
            .setTraceId(OLD_TRACE_ID)
            .setSpanId(OLD_SPAN_ID)
            .setTraceSampled(OLD_TRACE_SAMPLED)
            .build();
    new ContextHandler().setCurrentContext(oldContext, ContextPriority.XCLOUD_HEADER);

    Context newContext =
        Context.newBuilder()
            .setRequest(HTTP_REQUEST)
            .setTraceId(TRACE_ID)
            .setSpanId(SPAN_ID)
            .setTraceSampled(TRACE_SAMPLED)
            .build();
    new ContextHandler().setCurrentContext(newContext, ContextPriority.OTEL_EXTRACTED);
    // Expects context being overridden when context was set with higher priority.
    assertEquals(ContextPriority.OTEL_EXTRACTED, new ContextHandler().getCurrentContextPriority());
    Context currentContext = new ContextHandler().getCurrentContext();
    assertEquals(HTTP_REQUEST, currentContext.getHttpRequest());
    assertEquals(TRACE_ID, currentContext.getTraceId());
    assertEquals(SPAN_ID, currentContext.getSpanId());
    assertEquals(TRACE_SAMPLED, currentContext.getTraceSampled());
  }

  @Test
  public void testOverrideOtelContextFromDefaultSetContext() {
    Context oldContext =
        Context.newBuilder()
            .setRequest(OLD_HTTP_REQUEST)
            .setTraceId(OLD_TRACE_ID)
            .setSpanId(OLD_SPAN_ID)
            .setTraceSampled(OLD_TRACE_SAMPLED)
            .build();
    new ContextHandler().setCurrentContext(oldContext, ContextPriority.OTEL_EXTRACTED);
    Context newContext =
        Context.newBuilder()
            .setRequest(HTTP_REQUEST)
            .setTraceId(TRACE_ID)
            .setSpanId(SPAN_ID)
            .setTraceSampled(TRACE_SAMPLED)
            .build();
    new ContextHandler().setCurrentContext(newContext);
    // Expects open telemetry context not being overridden when context was set with lower priority.
    assertEquals(ContextPriority.OTEL_EXTRACTED, new ContextHandler().getCurrentContextPriority());
    Context currentContext = new ContextHandler().getCurrentContext();
    assertEquals(OLD_HTTP_REQUEST, currentContext.getHttpRequest());
    assertEquals(OLD_TRACE_ID, currentContext.getTraceId());
    assertEquals(OLD_SPAN_ID, currentContext.getSpanId());
    assertEquals(OLD_TRACE_SAMPLED, currentContext.getTraceSampled());
  }

  @Test
  public void testOverrideOtelContextFromW3C() {
    Context oldContext =
        Context.newBuilder()
            .setRequest(OLD_HTTP_REQUEST)
            .setTraceId(OLD_TRACE_ID)
            .setSpanId(OLD_SPAN_ID)
            .setTraceSampled(OLD_TRACE_SAMPLED)
            .build();
    new ContextHandler().setCurrentContext(oldContext, ContextPriority.OTEL_EXTRACTED);
    Context newContext =
        Context.newBuilder()
            .setRequest(HTTP_REQUEST)
            .setTraceId(TRACE_ID)
            .setSpanId(SPAN_ID)
            .setTraceSampled(TRACE_SAMPLED)
            .build();
    new ContextHandler().setCurrentContext(newContext, ContextPriority.W3C_HEADER);
    // Expects open telemetry context not being overridden when context was set with lower priority.
    assertEquals(ContextPriority.OTEL_EXTRACTED, new ContextHandler().getCurrentContextPriority());
    Context currentContext = new ContextHandler().getCurrentContext();
    assertEquals(OLD_HTTP_REQUEST, currentContext.getHttpRequest());
    assertEquals(OLD_TRACE_ID, currentContext.getTraceId());
    assertEquals(OLD_SPAN_ID, currentContext.getSpanId());
    assertEquals(OLD_TRACE_SAMPLED, currentContext.getTraceSampled());
  }

  @Test
  public void testOverrideOtelContextFromXCTC() {
    Context oldContext =
        Context.newBuilder()
            .setRequest(OLD_HTTP_REQUEST)
            .setTraceId(OLD_TRACE_ID)
            .setSpanId(OLD_SPAN_ID)
            .setTraceSampled(OLD_TRACE_SAMPLED)
            .build();
    new ContextHandler().setCurrentContext(oldContext, ContextPriority.OTEL_EXTRACTED);
    Context newContext =
        Context.newBuilder()
            .setRequest(HTTP_REQUEST)
            .setTraceId(TRACE_ID)
            .setSpanId(SPAN_ID)
            .setTraceSampled(TRACE_SAMPLED)
            .build();
    new ContextHandler().setCurrentContext(newContext, ContextPriority.XCLOUD_HEADER);
    // Expects open telemetry context not being overridden when context was set with lower priority.
    assertEquals(ContextPriority.OTEL_EXTRACTED, new ContextHandler().getCurrentContextPriority());
    Context currentContext = new ContextHandler().getCurrentContext();
    assertEquals(OLD_HTTP_REQUEST, currentContext.getHttpRequest());
    assertEquals(OLD_TRACE_ID, currentContext.getTraceId());
    assertEquals(OLD_SPAN_ID, currentContext.getSpanId());
    assertEquals(OLD_TRACE_SAMPLED, currentContext.getTraceSampled());
  }
}
