/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.logging.logback;

import static com.google.common.truth.Truth.assertThat;

import ch.qos.logback.classic.spi.LoggingEvent;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Payload.StringPayload;
import org.junit.Before;
import org.junit.Test;

public class TraceLoggingEventEnhancerTest {
  private TraceLoggingEventEnhancer classUnderTest;

  @Before
  public void setUp() {
    classUnderTest = new TraceLoggingEventEnhancer();
  }

  @Test
  public void testEnhanceLogEntry() {
    // setup
    String traceId = "abc";
    TraceLoggingEventEnhancer.setCurrentTraceId(traceId);
    LoggingEvent loggingEvent = new LoggingEvent();
    loggingEvent.setMessage("this is a test");
    LogEntry.Builder builder = LogEntry.newBuilder(StringPayload.of("this is a test"));

    // act
    classUnderTest.enhanceLogEntry(builder, loggingEvent);
    LogEntry logEntry = builder.build();

    // assert - Trace Id should be recorded as explicit Trace field, not as a label
    assertThat(traceId.equalsIgnoreCase(logEntry.getTrace()));
  }

  @Test
  public void testGetCurrentTraceId() {
    // setup
    String traceId = "abc";
    TraceLoggingEventEnhancer.setCurrentTraceId(traceId);

    // act
    String currentTraceId = TraceLoggingEventEnhancer.getCurrentTraceId();

    // assert
    assertThat(traceId.equalsIgnoreCase(currentTraceId));
  }
}
