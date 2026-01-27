/*
 * Copyright 2021 Google LLC
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

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.newCapture;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;

import com.google.api.core.ApiFutures;
import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.HttpRequest.RequestMethod;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.spi.LoggingRpcFactory;
import com.google.cloud.logging.spi.v2.LoggingRpc;
import com.google.common.collect.ImmutableList;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import org.easymock.Capture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AutoPopulateMetadataTests {

  private static final String LOG_NAME = "test-log";
  private static final String RESOURCE_PROJECT_ID = "env-project-id";
  private static final String LOGGING_PROJECT_ID = "log-project-id";
  private static final MonitoredResource RESOURCE =
      MonitoredResource.newBuilder("global")
          .addLabel(MonitoredResourceUtil.PORJECTID_LABEL, RESOURCE_PROJECT_ID)
          .build();
  private static final LogEntry SIMPLE_LOG_ENTRY =
      LogEntry.newBuilder(Payload.StringPayload.of("hello"))
          .setLogName(LOG_NAME)
          .setDestination(LogDestinationName.project(LOGGING_PROJECT_ID))
          .build();
  private static final LogEntry SIMPLE_LOG_ENTRY_WITH_DEBUG =
      LogEntry.newBuilder(Payload.StringPayload.of("hello"))
          .setLogName(LOG_NAME)
          .setSeverity(Severity.DEBUG)
          .setDestination(LogDestinationName.project(LOGGING_PROJECT_ID))
          .build();
  private static final WriteLogEntriesResponse EMPTY_WRITE_RESPONSE =
      WriteLogEntriesResponse.getDefaultInstance();
  private static final HttpRequest HTTP_REQUEST =
      HttpRequest.newBuilder()
          .setRequestMethod(RequestMethod.GET)
          .setRequestUrl("https://example.com")
          .setUserAgent("Test User Agent")
          .build();
  private static final String TRACE_ID = "01010101010101010101010101010101";
  private static final String FORMATTED_TRACE_ID =
      String.format(LoggingImpl.RESOURCE_NAME_FORMAT, RESOURCE_PROJECT_ID, TRACE_ID);
  private static final String SPAN_ID = "1";
  private static final boolean TRACE_SAMPLED = true;

  private LoggingRpcFactory mockedRpcFactory;
  private LoggingRpc mockedRpc;
  private Logging logging;
  private final Capture<WriteLogEntriesRequest> rpcWriteArgument = newCapture();
  private ResourceTypeEnvironmentGetter mockedEnvGetter;

  @Before
  public void setup() {
    mockedEnvGetter = createMock(ResourceTypeEnvironmentGetter.class);
    mockedRpcFactory = createMock(LoggingRpcFactory.class);
    mockedRpc = createMock(LoggingRpc.class);
    expect(mockedRpcFactory.create(anyObject(LoggingOptions.class)))
        .andReturn(mockedRpc)
        .anyTimes();
    expect(mockedRpc.write(capture(rpcWriteArgument)))
        .andReturn(ApiFutures.immediateFuture(EMPTY_WRITE_RESPONSE));
    MonitoredResourceUtil.setEnvironmentGetter(mockedEnvGetter);
    // the following mocks generate MonitoredResource instance same as RESOURCE
    // constant
    expect(mockedEnvGetter.getAttribute("project/project-id")).andStubReturn(RESOURCE_PROJECT_ID);
    expect(mockedEnvGetter.getAttribute("")).andStubReturn(null);
    replay(mockedRpcFactory, mockedRpc, mockedEnvGetter);

    LoggingOptions options =
        LoggingOptions.newBuilder()
            .setProjectId(RESOURCE_PROJECT_ID)
            .setServiceRpcFactory(mockedRpcFactory)
            .build();
    logging = options.getService();
  }

  @After
  public void teardown() {
    new ContextHandler().removeCurrentContext();
  }

  private void mockCurrentContext(
      HttpRequest request, String traceId, String spanId, boolean traceSampled) {
    Context mockedContext =
        Context.newBuilder()
            .setRequest(request)
            .setTraceId(traceId)
            .setSpanId(spanId)
            .setTraceSampled(traceSampled)
            .build();
    new ContextHandler().setCurrentContext(mockedContext);
  }

  @Test
  public void testAutoPopulationEnabledInLoggingOptions() {
    mockCurrentContext(HTTP_REQUEST, TRACE_ID, SPAN_ID, TRACE_SAMPLED);

    logging.write(ImmutableList.of(SIMPLE_LOG_ENTRY));

    LogEntry actual = LogEntry.fromPb(rpcWriteArgument.getValue().getEntries(0));
    assertEquals(HTTP_REQUEST, actual.getHttpRequest());
    assertEquals(FORMATTED_TRACE_ID, actual.getTrace());
    assertEquals(SPAN_ID, actual.getSpanId());
    assertEquals(TRACE_SAMPLED, actual.getTraceSampled());
    assertEquals(RESOURCE, actual.getResource());
  }

  @Test
  public void testAutoPopulationEnabledInWriteOptionsAndDisabledInLoggingOptions() {
    // redefine logging option to opt out auto-populating
    LoggingOptions options =
        logging.getOptions().toBuilder().setAutoPopulateMetadata(false).build();
    logging = options.getService();
    mockCurrentContext(HTTP_REQUEST, TRACE_ID, SPAN_ID, TRACE_SAMPLED);

    logging.write(ImmutableList.of(SIMPLE_LOG_ENTRY), WriteOption.autoPopulateMetadata(true));

    LogEntry actual = LogEntry.fromPb(rpcWriteArgument.getValue().getEntries(0));
    assertEquals(HTTP_REQUEST, actual.getHttpRequest());
    assertEquals(FORMATTED_TRACE_ID, actual.getTrace());
    assertEquals(SPAN_ID, actual.getSpanId());
    assertEquals(TRACE_SAMPLED, actual.getTraceSampled());
    assertEquals(RESOURCE, actual.getResource());
  }

  @Test
  public void testAutoPopulationDisabledInWriteOptions() {
    mockCurrentContext(HTTP_REQUEST, TRACE_ID, SPAN_ID, TRACE_SAMPLED);

    logging.write(ImmutableList.of(SIMPLE_LOG_ENTRY), WriteOption.autoPopulateMetadata(false));

    LogEntry actual = LogEntry.fromPb(rpcWriteArgument.getValue().getEntries(0));
    assertNull(actual.getHttpRequest());
    assertNull(actual.getTrace());
    assertNull(actual.getSpanId());
    assertFalse(actual.getTraceSampled());
    assertNull(actual.getResource());
  }

  @Test
  public void testSourceLocationPopulation() {
    SourceLocation expected = SourceLocation.fromCurrentContext();
    logging.write(ImmutableList.of(SIMPLE_LOG_ENTRY_WITH_DEBUG));

    LogEntry actual = LogEntry.fromPb(rpcWriteArgument.getValue().getEntries(0));
    assertEquals(expected.getFile(), actual.getSourceLocation().getFile());
    assertEquals(expected.getClass(), actual.getSourceLocation().getClass());
    assertEquals(expected.getFunction(), actual.getSourceLocation().getFunction());
    assertEquals(Long.valueOf(expected.getLine() + 1), actual.getSourceLocation().getLine());
  }

  @Test
  public void testNotFormattedTraceId() {
    mockCurrentContext(HTTP_REQUEST, TRACE_ID, SPAN_ID, TRACE_SAMPLED);

    final MonitoredResource expectedResource = MonitoredResource.newBuilder("custom").build();

    logging.write(ImmutableList.of(SIMPLE_LOG_ENTRY), WriteOption.resource(expectedResource));

    LogEntry actual = LogEntry.fromPb(rpcWriteArgument.getValue().getEntries(0));
    assertEquals(TRACE_ID, actual.getTrace());
  }

  @Test
  public void testMonitoredResourcePopulationInWriteOptions() {
    mockCurrentContext(HTTP_REQUEST, TRACE_ID, SPAN_ID, TRACE_SAMPLED);

    final MonitoredResource expectedResource = MonitoredResource.newBuilder("custom").build();

    logging.write(ImmutableList.of(SIMPLE_LOG_ENTRY), WriteOption.resource(expectedResource));

    LogEntry actual = LogEntry.fromPb(rpcWriteArgument.getValue().getEntries(0));
    assertEquals(expectedResource, actual.getResource());
  }
}
