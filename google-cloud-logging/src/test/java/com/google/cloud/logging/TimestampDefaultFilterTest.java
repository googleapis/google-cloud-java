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

package com.google.cloud.logging;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.management.timer.Timer;
import org.junit.Test;

public class TimestampDefaultFilterTest {

  @Test
  public void DefaultTimestampFilterTest() {
    ITimestampDefaultFilter filter = new TimestampDefaultFilter();

    TimeZone timeZone = TimeZone.getTimeZone("UTC");
    Calendar calendar = Calendar.getInstance(timeZone);
    calendar.add(Calendar.DATE, -1);
    Date expected = calendar.getTime();

    // Timestamp filter exists
    String defaultFilter = filter.createDefaultTimestampFilter();
    assertTrue(defaultFilter.contains("timestamp>="));

    // Time is last 24 hours
    try {
      DateFormat rfcDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
      rfcDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
      Date actual = rfcDateFormat.parse(defaultFilter.substring(12, defaultFilter.length() - 1));
      assertTrue(Math.abs(expected.getTime() - actual.getTime()) < Timer.ONE_MINUTE);
    } catch (java.text.ParseException ex) {
      fail(); // Just fail if exception is thrown
    }
  }
}
