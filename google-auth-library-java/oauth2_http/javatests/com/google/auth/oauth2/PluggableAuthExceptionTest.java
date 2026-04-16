/*
 * Copyright 2022 Google LLC
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
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/** Tests for {@link PluggableAuthException}. */
class PluggableAuthExceptionTest {

  @Test
  void constructor() {
    PluggableAuthException e = new PluggableAuthException("errorCode", "errorDescription");
    assertEquals("errorCode", e.getErrorCode());
    assertEquals("errorDescription", e.getErrorDescription());
  }

  @Test
  void constructor_nullErrorCode_throws() {
    assertThrows(
        NullPointerException.class,
        () -> new PluggableAuthException(/* errorCode= */ null, "errorDescription"));
  }

  @Test
  void constructor_nullErrorDescription_throws() {
    assertThrows(
        NullPointerException.class,
        () -> new PluggableAuthException("errorCode", /* errorDescription= */ null));
  }

  @Test
  void getMessage() {
    PluggableAuthException e = new PluggableAuthException("errorCode", "errorDescription");
    String expectedMessage = String.format("Error code %s: %s", "errorCode", "errorDescription");
    assertEquals(expectedMessage, e.getMessage());
  }
}
