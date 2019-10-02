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

package com.google.cloud.logging.logback;

import static com.google.common.truth.Truth.assertThat;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.LoggingEvent;
import com.google.cloud.Timestamp;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.Severity;
import java.util.Map;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.MDC;

@RunWith(EasyMockRunner.class)
public class MDCEventEnhancerTest {
  private final String projectId = "test-project";
  private final String filteredMVCEventEnhancerClassName =
      FilteredMVCEventEnhancer.class.getCanonicalName();
  private Logging logging;
  private LoggingAppender loggingAppender;

  class TestLoggingAppender extends LoggingAppender {
    @Override
    String getProjectId() {
      return projectId;
    }

    @Override
    Logging getLogging() {
      return logging;
    }
  }

  @Before
  public void setUp() {
    logging = EasyMock.createStrictMock(Logging.class);
    loggingAppender = new TestLoggingAppender();
  }

  @Test
  public void testDefaultMDCEventEnhancer() {
    MDC.put("mdc1", "value1");
    MDC.put("mdc2", null);
    MDC.put("mdc3", "value3");
    logging.setFlushSeverity(Severity.ERROR);
    Capture<Iterable<LogEntry>> capturedArgument = Capture.newInstance();
    logging.write(capture(capturedArgument), (WriteOption) anyObject(), (WriteOption) anyObject());
    expectLastCall().once();
    replay(logging);
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.INFO, timestamp.getSeconds());
    loggingAppender.start();
    loggingAppender.doAppend(loggingEvent);
    verify(logging);
    MDC.remove("mdc1");
    MDC.remove("mdc3");
    Map<String, String> capturedArgumentMap =
        capturedArgument.getValue().iterator().next().getLabels();
    assertThat(capturedArgumentMap.get("mdc1")).isEqualTo("value1");
    assertThat(capturedArgumentMap.get("mdc2")).isNull();
    assertThat(capturedArgumentMap.get("mdc3")).isEqualTo("value3");
  }

  @Test
  public void testCustomMDCEventEnhancer() {
    MDC.put("foo", "foo");
    MDC.put("bar", "bar");
    logging.setFlushSeverity(Severity.ERROR);
    Capture<Iterable<LogEntry>> capturedArgument = Capture.newInstance();
    logging.write(capture(capturedArgument), (WriteOption) anyObject(), (WriteOption) anyObject());
    expectLastCall().once();
    replay(logging);
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100000, 0);
    LoggingEvent loggingEvent = createLoggingEvent(Level.INFO, timestamp.getSeconds());
    loggingAppender.addLoggingEventEnhancer(filteredMVCEventEnhancerClassName);
    loggingAppender.start();
    loggingAppender.doAppend(loggingEvent);
    verify(logging);
    Map<String, String> capturedArgumentMap =
        capturedArgument.getValue().iterator().next().getLabels();
    assertThat(capturedArgumentMap.get("foo")).isEqualTo("foo");
    assertThat(capturedArgumentMap.get("bar")).isNull();
  }

  private LoggingEvent createLoggingEvent(Level level, long timestamp) {
    LoggingEvent loggingEvent = new LoggingEvent();
    loggingEvent.setMessage("this is a test");
    loggingEvent.setLevel(level);
    loggingEvent.setTimeStamp(timestamp);
    loggingEvent.setLoggerName(this.getClass().getName());
    return loggingEvent;
  }
}
