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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LoggingLevelTest {

  @Test
  public void testDebug() {
    LoggingLevel debug = LoggingLevel.DEBUG;
    assertEquals(Severity.DEBUG, debug.getSeverity());
    assertEquals("DEBUG", debug.getName());
    assertThat(debug.intValue()).isLessThan(Level.FINEST.intValue());
    assertThat(debug.intValue()).isGreaterThan(Level.ALL.intValue());
  }

  @Test
  public void testNotice() {
    LoggingLevel notice = LoggingLevel.NOTICE;
    assertEquals(Severity.NOTICE, notice.getSeverity());
    assertEquals("NOTICE", notice.getName());
    assertThat(notice.intValue()).isGreaterThan(Level.INFO.intValue());
    assertThat(notice.intValue()).isLessThan(Level.WARNING.intValue());
  }

  @Test
  public void testError() {
    LoggingLevel error = LoggingLevel.ERROR;
    assertEquals(Severity.ERROR, error.getSeverity());
    assertEquals("ERROR", error.getName());
    assertThat(error.intValue()).isGreaterThan(Level.WARNING.intValue());
    assertThat(error.intValue()).isLessThan(Level.SEVERE.intValue());
  }

  @Test
  public void testCritical() {
    LoggingLevel critical = LoggingLevel.CRITICAL;
    assertEquals(Severity.CRITICAL, critical.getSeverity());
    assertEquals("CRITICAL", critical.getName());
    assertThat(critical.intValue()).isGreaterThan(LoggingLevel.SEVERE.intValue());
    assertThat(critical.intValue()).isLessThan(Level.OFF.intValue());
  }

  @Test
  public void testAlert() {
    LoggingLevel alert = LoggingLevel.ALERT;
    assertEquals(Severity.ALERT, alert.getSeverity());
    assertEquals("ALERT", alert.getName());
    assertThat(alert.intValue()).isGreaterThan(LoggingLevel.CRITICAL.intValue());
    assertThat(alert.intValue()).isLessThan(Level.OFF.intValue());
  }

  @Test
  public void testEmergency() {
    LoggingLevel emergency = LoggingLevel.EMERGENCY;
    assertEquals(Severity.EMERGENCY, emergency.getSeverity());
    assertEquals("EMERGENCY", emergency.getName());
    assertThat(emergency.intValue()).isGreaterThan(LoggingLevel.ALERT.intValue());
    assertThat(emergency.intValue()).isLessThan(Level.OFF.intValue());
  }
}
