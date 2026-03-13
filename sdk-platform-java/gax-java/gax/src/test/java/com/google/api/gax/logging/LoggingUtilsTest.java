/*
 * Copyright 2025 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
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

package com.google.api.gax.logging;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;

import com.google.api.gax.logging.LoggingUtils.ThrowingRunnable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoggingUtilsTest {

  @Test
  void testIsLoggingEnabled_defaultToFalse() {
    assertFalse(LoggingUtils.isLoggingEnabled());
  }

  @Test
  void testExecuteWithTryCatch_noException() {
    assertDoesNotThrow(
        () ->
            LoggingUtils.executeWithTryCatch(
                () -> {
                  // Some code that should not throw an exception
                  int x = 5;
                  int y = 10;
                  int z = x + y;
                  assertEquals(15, z);
                }));
  }

  @Test
  void testExecuteWithTryCatch_WithException() throws Throwable {
    ThrowingRunnable action = Mockito.mock(ThrowingRunnable.class);
    Mockito.doThrow(new RuntimeException("Test Exception")).when(action).run();
    assertDoesNotThrow(() -> LoggingUtils.executeWithTryCatch(action));
    // Verify that the action was executed (despite the exception)
    verify(action).run();
  }

  @Test
  void testExecuteWithTryCatch_WithNoSuchMethodError() throws Throwable {
    ThrowingRunnable action = Mockito.mock(ThrowingRunnable.class);
    Mockito.doThrow(new NoSuchMethodError("Test Error")).when(action).run();
    assertDoesNotThrow(() -> LoggingUtils.executeWithTryCatch(action));
    // Verify that the action was executed (despite the error)
    verify(action).run();
  }
}
