/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.logging.spi.v2;

import com.google.api.MonitoredResource;
import com.google.common.collect.Iterables;
import com.google.cloud.logging.spi.v2.testing.LocalLoggingHelper;
import com.google.logging.v2.LogEntry;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoggingServiceV2ApiTest {
  private static LocalLoggingHelper loggingHelper;
  private LoggingServiceV2Api loggingApi;

  @BeforeClass
  public static void startStaticServer() {
    loggingHelper = new LocalLoggingHelper("in-process-1");
    loggingHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    loggingHelper.shutdownNow();
  }

  @Before
  public void setUp() throws IOException {
    loggingHelper.reset();
    LoggingServiceV2Settings settings = LoggingServiceV2Settings.newBuilder()
        .provideChannelWith(loggingHelper.createChannel(), true)
        .build();
    loggingApi = LoggingServiceV2Api.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    loggingApi.close();
  }

  @Test
  public void testWriteLog() {
    String logName = LoggingServiceV2Api.formatLogName("my-project", "my-log");
    MonitoredResource resource = MonitoredResource.newBuilder().build();
    List<LogEntry> entries = new ArrayList<>();
    entries.add(LogEntry.newBuilder().setLogName(logName).setTextPayload("foobar").build());
    loggingApi.writeLogEntries(logName, resource, Collections.<String, String>emptyMap(), entries);
  }

  @Test
  public void testListLog() {
    String logName = LoggingServiceV2Api.formatLogName("my-project", "my-log");
    MonitoredResource resource = MonitoredResource.newBuilder().build();
    List<LogEntry> entries = new ArrayList<>();
    entries.add(LogEntry.newBuilder().setLogName(logName).setTextPayload("foobar").build());
    loggingApi.writeLogEntries(logName, resource, Collections.<String, String>emptyMap(), entries);

    Iterable<LogEntry> gotEntries =
        loggingApi.listLogEntries(Collections.singletonList("my-project"), "", "");
    Assert.assertTrue(Iterables.elementsEqual(entries, gotEntries));
  }

  @Test
  public void testListNoLog() {
    Iterable<LogEntry> entries =
        loggingApi.listLogEntries(Collections.singletonList("my-project"), "", "");
    Assert.assertTrue(Iterables.isEmpty(entries));
  }

  @Test
  public void testDeleteLog() {
    String logName = LoggingServiceV2Api.formatLogName("my-project", "my-log");
    MonitoredResource resource = MonitoredResource.newBuilder().build();
    List<LogEntry> entries = new ArrayList<>();
    entries.add(LogEntry.newBuilder().setLogName(logName).setTextPayload("foobar").build());
    loggingApi.writeLogEntries(logName, resource, Collections.<String, String>emptyMap(), entries);

    loggingApi.deleteLog(logName);

    Iterable<LogEntry> gotEntries =
        loggingApi.listLogEntries(Collections.singletonList("my-project"), "", "");
    Assert.assertTrue(Iterables.isEmpty(gotEntries));
  }
}
