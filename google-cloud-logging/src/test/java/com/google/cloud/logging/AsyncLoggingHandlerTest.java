/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.logging;

import static com.google.cloud.logging.LoggingHandlerTest.TestFormatter;

import com.google.api.gax.core.ApiFuture;
import com.google.api.gax.core.ApiFutures;
import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AsyncLoggingHandlerTest {

  private static final String LOG_NAME = "java.log";
  private static final String MESSAGE = "message";
  private static final String PROJECT = "project";
  private static final MonitoredResource DEFAULT_RESOURCE =
      MonitoredResource.of("global", ImmutableMap.of("project_id", PROJECT));
  private static final ApiFuture<Void> FUTURE = ApiFutures.immediateFuture(null);

  private Logging logging;
  private LoggingOptions options;

  @Before
  public void setUp() {
    logging = EasyMock.createStrictMock(Logging.class);
    options = EasyMock.createStrictMock(LoggingOptions.class);
  }

  @After
  public void afterClass() {
    EasyMock.verify(logging, options);
  }

  @Test
  public void testPublish() {
    EasyMock.expect(options.getProjectId()).andReturn(PROJECT).anyTimes();
    EasyMock.expect(options.getService()).andReturn(logging);
    LogEntry entry = LogEntry.newBuilder(Payload.StringPayload.of(MESSAGE))
        .setSeverity(Severity.DEBUG)
        .addLabel("levelName", "FINEST")
        .addLabel("levelValue", String.valueOf(Level.FINEST.intValue()))
        .setTimestamp(123456789L)
        .build();
    EasyMock.expect(logging.writeAsync(ImmutableList.of(entry), WriteOption.logName(LOG_NAME),
        WriteOption.resource(DEFAULT_RESOURCE))).andReturn(FUTURE);
    EasyMock.replay(options, logging);
    Handler handler = new AsyncLoggingHandler(LOG_NAME, options);
    handler.setLevel(Level.ALL);
    handler.setFormatter(new TestFormatter());
    LogRecord record = new LogRecord(Level.FINEST, MESSAGE);
    record.setMillis(123456789L);
    handler.publish(record);
  }
}
