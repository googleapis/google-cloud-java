/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.datastore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Calendar;

public class DateTimeTest {

  @Test
  public void testTimestampMicroseconds() throws Exception {
    Calendar cal = Calendar.getInstance();
    DateTime date = DateTime.copyFrom(cal);
    assertEquals(cal.getTimeInMillis() * 1000, date.timestampMicroseconds());
  }

  @Test
  public void testTimestampMillis() throws Exception {
    Calendar cal = Calendar.getInstance();
    DateTime date = DateTime.copyFrom(cal);
    assertEquals(cal.getTimeInMillis(), date.timestampMillis());
  }

  @Test
  public void testToDate() throws Exception {
    Calendar cal = Calendar.getInstance();
    DateTime date = DateTime.copyFrom(cal);
    assertEquals(cal.getTime(), date.toDate());
  }

  @Test
  public void testToCalendar() throws Exception {
    Calendar cal = Calendar.getInstance();
    DateTime date = DateTime.copyFrom(cal);
    assertEquals(cal, date.toCalendar());
  }

  @Test
  public void testNow() throws Exception {
    Calendar cal1 = Calendar.getInstance();
    DateTime now = DateTime.now();
    Calendar cal2 = Calendar.getInstance();
    assertTrue(now.timestampMillis() >= cal1.getTimeInMillis());
    assertTrue(now.timestampMillis() <= cal2.getTimeInMillis());
  }

  @Test
  public void testCopyFrom() throws Exception {
    Calendar cal = Calendar.getInstance();
    DateTime date1 = DateTime.copyFrom(cal);
    DateTime date2 = DateTime.copyFrom(cal.getTime());
    cal.add(Calendar.DATE, 1);
    DateTime date3 = DateTime.copyFrom(cal.getTime());
    assertEquals(date1, date2);
    assertNotEquals(date1, date3);
  }
}

