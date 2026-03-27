/*
 * Copyright 2025 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.auth.oauth2.Slf4jUtils.LoggerFactoryProvider;
import java.util.logging.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.helpers.NOPLogger;

class Slf4jUtilsTest {

  private TestEnvironmentProvider testEnvironmentProvider;

  @BeforeEach
  void setup() {
    testEnvironmentProvider = new TestEnvironmentProvider();
  }

  // This test mimics GOOGLE_SDK_JAVA_LOGGING != true
  @Test
  void testGetLogger_loggingDisabled_shouldGetNOPLogger() {
    testEnvironmentProvider.setEnv(LoggingUtils.GOOGLE_SDK_JAVA_LOGGING, "false");
    LoggingUtils.setEnvironmentProvider(testEnvironmentProvider);
    Logger logger = Slf4jUtils.getLogger(Slf4jUtilsTest.class);

    assertEquals(NOPLogger.class, logger.getClass());
    assertFalse(logger.isInfoEnabled());
    assertFalse(logger.isDebugEnabled());
  }

  // This test require binding (e.g. logback) be present
  @Test
  void testGetLogger_loggingEnabled_slf4jBindingPresent() {
    testEnvironmentProvider.setEnv(LoggingUtils.GOOGLE_SDK_JAVA_LOGGING, "true");
    LoggingUtils.setEnvironmentProvider(testEnvironmentProvider);
    Logger logger = Slf4jUtils.getLogger(LoggingUtilsTest.class);
    assertNotNull(logger);
    assertNotEquals(NOPLogger.class, logger.getClass());
  }

  @Test
  void testGetLogger_loggingEnabled_noBinding() {
    testEnvironmentProvider.setEnv(LoggingUtils.GOOGLE_SDK_JAVA_LOGGING, "true");
    LoggingUtils.setEnvironmentProvider(testEnvironmentProvider);
    // Create a mock LoggerFactoryProvider
    LoggerFactoryProvider mockLoggerFactoryProvider = mock(LoggerFactoryProvider.class);
    ILoggerFactory mockLoggerFactory = mock(ILoggerFactory.class);
    when(mockLoggerFactoryProvider.getLoggerFactory()).thenReturn(mockLoggerFactory);
    when(mockLoggerFactory.getLogger(anyString()))
        .thenReturn(org.slf4j.helpers.NOPLogger.NOP_LOGGER);

    // Use the mock LoggerFactoryProvider in getLogger()
    Logger logger = Slf4jUtils.getLogger(LoggingUtilsTest.class, mockLoggerFactoryProvider);

    // Assert that the returned logger is a NOPLogger
    assertTrue(logger instanceof org.slf4j.helpers.NOPLogger);
  }

  @Test
  void testCheckIfClazzAvailable() {
    assertFalse(Slf4jUtils.checkIfClazzAvailable("fake.class.should.not.be.in.classpath"));
    assertTrue(Slf4jUtils.checkIfClazzAvailable("org.slf4j.event.KeyValuePair"));
  }

  @Test
  void testMatchLevelSevere() {
    assertEquals(
        org.slf4j.event.Level.ERROR, Slf4jLoggingHelpers.matchUtilLevelToSLF4JLevel(Level.SEVERE));
    assertEquals(
        org.slf4j.event.Level.WARN, Slf4jLoggingHelpers.matchUtilLevelToSLF4JLevel(Level.WARNING));
    assertEquals(
        org.slf4j.event.Level.INFO, Slf4jLoggingHelpers.matchUtilLevelToSLF4JLevel(Level.INFO));
    assertEquals(
        org.slf4j.event.Level.DEBUG, Slf4jLoggingHelpers.matchUtilLevelToSLF4JLevel(Level.FINE));
    assertEquals(
        org.slf4j.event.Level.TRACE, Slf4jLoggingHelpers.matchUtilLevelToSLF4JLevel(Level.FINER));
  }
}
