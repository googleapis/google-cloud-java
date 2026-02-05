/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.logging.it;

import static com.google.cloud.logging.testing.RemoteLoggingHelper.formatForTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.*;
import com.google.cloud.logging.Logging.TailOption;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;

public class ITTailLogsTest extends BaseSystemTest {

  private static final String LOG_ID = formatForTest("test-tail-log-entries-log");
  private static final MonitoredResource GLOBAL_RESOURCE =
      MonitoredResource.newBuilder("global").build();

  @AfterClass
  public static void cleanUpLogs() throws InterruptedException {
    assertTrue(cleanupLog(LOG_ID));
  }

  @Ignore
  @Test(timeout = 120_000) // Note: the test should not take longer than 2 min
  public void testTailLogEntries() throws InterruptedException {
    LogEntry testLogEntry =
        LogEntry.newBuilder(Payload.StringPayload.of("stringPayload1"))
            .addLabel("key1", "value1")
            .setLogName(LOG_ID)
            .setHttpRequest(HttpRequest.newBuilder().setStatus(200).build())
            .setResource(GLOBAL_RESOURCE)
            .build();

    String filter = "logName=projects/" + logging.getOptions().getProjectId() + "/logs/" + LOG_ID;
    LogEntryServerStream stream = logging.tailLogEntries(TailOption.filter(filter));

    Runnable task =
        () -> {
          // it may take awhile for tailing session to startup on the backend
          // wait 10 sec before sending log entries
          try {
            Thread.sleep(10000);
          } catch (InterruptedException t) {
          }
          logging.write(ImmutableList.of(testLogEntry));
        };
    Thread thread = new Thread(task);
    thread.start();

    final ArrayList<LogEntry> receivedEntries = new ArrayList<>();
    for (LogEntry log : stream) {
      receivedEntries.add(log);
      if (receivedEntries.size() > 0) {
        break;
      }
    }
    stream.cancel();

    LogEntry resultEntry = receivedEntries.get(0);
    assertEquals(testLogEntry.getResource().getType(), resultEntry.getResource().getType());
    assertEquals(testLogEntry.getLogName(), resultEntry.getLogName());
    assertEquals(
        testLogEntry.getHttpRequest().getStatus(), resultEntry.getHttpRequest().getStatus());
    // assert equals for Payload objects
    assertTrue(testLogEntry.getPayload().equals(resultEntry.getPayload()));
    // assert equals for Map<String,String> objects
    assertTrue(testLogEntry.getLabels().equals(resultEntry.getLabels()));
  }
}
