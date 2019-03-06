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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import org.junit.Test;

public class LoggingLevelTest {

  @Test
  public void testDebug() {
    LoggingLevel debug = LoggingLevel.DEBUG;
    assertEquals(Severity.DEBUG, debug.getSeverity());
    assertEquals("DEBUG", debug.getName());
    assertTrue(debug.intValue() < Level.FINEST.intValue());
    assertTrue(debug.intValue() > Level.ALL.intValue());
  }

  @Test
  public void testNotice() {
    LoggingLevel notice = LoggingLevel.NOTICE;
    assertEquals(Severity.NOTICE, notice.getSeverity());
    assertEquals("NOTICE", notice.getName());
    assertTrue(notice.intValue() > Level.INFO.intValue());
    assertTrue(notice.intValue() < Level.WARNING.intValue());
  }

  @Test
  public void testError() {
    LoggingLevel error = LoggingLevel.ERROR;
    assertEquals(Severity.ERROR, error.getSeverity());
    assertEquals("ERROR", error.getName());
    assertTrue(error.intValue() > Level.WARNING.intValue());
    assertTrue(error.intValue() < Level.SEVERE.intValue());
  }

  @Test
  public void testCritical() {
    LoggingLevel critical = LoggingLevel.CRITICAL;
    assertEquals(Severity.CRITICAL, critical.getSeverity());
    assertEquals("CRITICAL", critical.getName());
    assertTrue(critical.intValue() > LoggingLevel.SEVERE.intValue());
    assertTrue(critical.intValue() < Level.OFF.intValue());
  }

  @Test
  public void testAlert() {
    LoggingLevel alert = LoggingLevel.ALERT;
    assertEquals(Severity.ALERT, alert.getSeverity());
    assertEquals("ALERT", alert.getName());
    assertTrue(alert.intValue() > LoggingLevel.CRITICAL.intValue());
    assertTrue(alert.intValue() < Level.OFF.intValue());
  }

  @Test
  public void testEmergency() {
    LoggingLevel emergency = LoggingLevel.EMERGENCY;
    assertEquals(Severity.EMERGENCY, emergency.getSeverity());
    assertEquals("EMERGENCY", emergency.getName());
    assertTrue(emergency.intValue() > LoggingLevel.ALERT.intValue());
    assertTrue(emergency.intValue() < Level.OFF.intValue());
  }
}
