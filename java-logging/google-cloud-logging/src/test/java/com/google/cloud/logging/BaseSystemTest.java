/*
 * Copyright 2016 Google LLC
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

import static java.time.ZoneOffset.UTC;

import com.google.api.gax.paging.Page;
import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.testing.RemoteLoggingHelper;
import com.google.common.collect.Iterables;
import com.google.logging.v2.LogName;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Iterator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 * A base class for system tests. This class can be extended to run system tests in different
 * environments (e.g. local emulator or remote Logging service).
 */
public class BaseSystemTest {

  @Rule public Timeout globalTimeout = Timeout.seconds(600);

  private static final DateTimeFormatter RFC_3339 =
      DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

  protected static Logging logging;

  @BeforeClass
  public static void beforeClass() {
    RemoteLoggingHelper helper = RemoteLoggingHelper.create();
    logging = helper.getOptions().getService();
  }

  @AfterClass
  public static void afterClass() throws Exception {
    logging.close();
  }

  /**
   * Creates an equality expression for logging filter.
   *
   * @see <a href= "https://cloud.google.com/logging/docs/view/advanced_filters">Advanced Logs
   *     Filters Documentation</a>
   */
  protected static <V> String createEqualityFilter(String name, V value) {
    return name + "=" + "\"" + value + "\"";
  }

  protected static boolean cleanupLog(String logName) throws InterruptedException {
    int deleteAttempts = 0;
    int allowedDeleteAttempts = 5;
    boolean deleted = false;
    while (!deleted && deleteAttempts < allowedDeleteAttempts) {
      Thread.sleep(5000);
      deleted = logging.deleteLog(logName);
      deleteAttempts++;
    }
    return deleted;
  }

  /**
   * Creates an equality expression for logging filter.
   *
   * @see <a href= "https://cloud.google.com/logging/docs/view/advanced_filters">Advanced Logs
   *     Filters Documentation</a>
   */
  protected static String createTimestampFilter(int hoursAgo) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.HOUR, -1 * hoursAgo);
    return "timestamp>=\""
        + calendar.getTime().toInstant().atZone(UTC).toLocalDateTime().format(RFC_3339)
        + "\"";
  }

  protected static String appendResourceTypeFilter(
      String currentFilter, MonitoredResource[] monitoredResources) {
    StringBuilder filter = new StringBuilder(currentFilter);
    if (monitoredResources != null && monitoredResources.length > 0) {
      if (monitoredResources.length == 1) {
        filter.append(" AND resource.type=");
        filter.append(monitoredResources[0].getType());
      } else {
        filter.append(" AND resource.type=(");
        filter.append(monitoredResources[0].getType());

        // OR between all monitored resources we search
        for (int i = 1; i < monitoredResources.length; i++) {
          filter.append(" OR ");
          filter.append(monitoredResources[i].getType());
        }
        filter.append(")");
      }
    }

    return filter.toString();
  }

  /** Helper to poll for logs until they are returned by the backend. */
  protected static Iterator<LogEntry> waitForLogs(
      LogName logName, MonitoredResource[] monitoredResources, int minLogs)
      throws InterruptedException {
    StringBuilder filter = new StringBuilder();
    filter.append(createTimestampFilter(1));
    filter.append(" AND ");
    filter.append(createEqualityFilter("logName", logName));

    String monitoredResourceFilter =
        appendResourceTypeFilter(filter.toString(), monitoredResources);

    Logging.EntryListOption[] options = {Logging.EntryListOption.filter(monitoredResourceFilter)};
    return waitForLogs(options, minLogs);
  }

  protected static Iterator<LogEntry> waitForLogs(LogName logName) throws InterruptedException {
    return waitForLogs(logName, null, 1);
  }

  protected static Iterator<LogEntry> waitForLogs(Logging.EntryListOption[] options, int minLogs)
      throws InterruptedException {
    Page<LogEntry> page = logging.listLogEntries(options);
    while (Iterables.size(page.iterateAll()) < minLogs) {
      Thread.sleep(500);
      page = logging.listLogEntries(options);
    }
    return page.iterateAll().iterator();
  }
}
