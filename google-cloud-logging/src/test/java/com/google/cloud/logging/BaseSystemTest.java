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

import com.google.api.gax.paging.Page;
import com.google.cloud.logging.testing.RemoteLoggingHelper;
import com.google.common.collect.Iterators;
import com.google.logging.v2.LogName;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

  private static DateFormat RFC_3339 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

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
   * @see <a href="https://cloud.google.com/logging/docs/view/advanced_filters">Advanced Logs
   *     Filters Documentation</a>
   */
  protected static <V> String createEqualityFilter(String name, V value) {
    return name + " = " + "\"" + value.toString() + "\"";
  }

  /**
   * Creates an equality expression for logging filter.
   *
   * @see <a href="https://cloud.google.com/logging/docs/view/advanced_filters">Advanced Logs
   *     Filters Documentation</a>
   */
  protected static String createTimestampFilter(int hoursAgo) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.HOUR, -1 * hoursAgo);
    return "timestamp>=\"" + RFC_3339.format(calendar.getTime()) + "\"";
  }

  /** Helper to poll for logs until they are returned by the backend. */
  protected static Iterator<LogEntry> waitForLogs(LogName logName) throws InterruptedException {
    return waitForLogs(logName, 1);
  }

  /** Helper to poll for logs until they are returned by the backend. */
  protected static Iterator<LogEntry> waitForLogs(LogName logName, int minLogs)
      throws InterruptedException {
    String filter = createEqualityFilter("logName", logName) + " AND " + createTimestampFilter(1);
    Logging.EntryListOption[] options = {Logging.EntryListOption.filter(filter)};
    return waitForLogs(options, minLogs);
  }

  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  protected static Iterator<LogEntry> waitForLogs(Logging.EntryListOption[] options, int minLogs)
      throws InterruptedException {
    Page<LogEntry> page = logging.listLogEntries(options);
    while (Iterators.size(page.iterateAll().iterator()) < minLogs) {
      Thread.sleep(500);
      page = logging.listLogEntries(options);
    }
    return page.iterateAll().iterator();
  }
}
