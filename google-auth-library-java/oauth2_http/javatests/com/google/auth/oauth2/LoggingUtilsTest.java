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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoggingUtilsTest {

  private TestEnvironmentProvider testEnvironmentProvider;

  @BeforeEach
  void setup() {
    testEnvironmentProvider = new TestEnvironmentProvider();
  }

  @Test
  void testIsLoggingEnabled_true() {
    testEnvironmentProvider.setEnv(LoggingUtils.GOOGLE_SDK_JAVA_LOGGING, "true");
    LoggingUtils.setEnvironmentProvider(testEnvironmentProvider);
    assertTrue(LoggingUtils.isLoggingEnabled());
    testEnvironmentProvider.setEnv(LoggingUtils.GOOGLE_SDK_JAVA_LOGGING, "TRUE");
    LoggingUtils.setEnvironmentProvider(testEnvironmentProvider);
    assertTrue(LoggingUtils.isLoggingEnabled());
    testEnvironmentProvider.setEnv(LoggingUtils.GOOGLE_SDK_JAVA_LOGGING, "True");
    LoggingUtils.setEnvironmentProvider(testEnvironmentProvider);
    assertTrue(LoggingUtils.isLoggingEnabled());
  }

  @Test
  void testIsLoggingEnabled_defaultToFalse() {
    LoggingUtils.setEnvironmentProvider(testEnvironmentProvider);
    assertFalse(LoggingUtils.isLoggingEnabled());
  }
}
