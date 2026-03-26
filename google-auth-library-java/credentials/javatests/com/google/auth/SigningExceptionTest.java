/*
 * Copyright 2016, Google Inc. All rights reserved.
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
 *    * Neither the name of Google Inc. nor the names of its
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

package com.google.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.auth.ServiceAccountSigner.SigningException;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class SigningExceptionTest {

  private static final String EXPECTED_MESSAGE = "message";
  private static final RuntimeException EXPECTED_CAUSE = new RuntimeException();

  @Test
  void constructor() {
    SigningException signingException = new SigningException(EXPECTED_MESSAGE, EXPECTED_CAUSE);
    assertEquals(EXPECTED_MESSAGE, signingException.getMessage());
    assertSame(EXPECTED_CAUSE, signingException.getCause());
  }

  @Test
  void equals_true() throws IOException {
    SigningException signingException = new SigningException(EXPECTED_MESSAGE, EXPECTED_CAUSE);
    SigningException otherSigningException = new SigningException(EXPECTED_MESSAGE, EXPECTED_CAUSE);
    assertTrue(signingException.equals(otherSigningException));
    assertTrue(otherSigningException.equals(signingException));
  }

  @Test
  void equals_false_message() throws IOException {
    SigningException signingException = new SigningException(EXPECTED_MESSAGE, EXPECTED_CAUSE);
    SigningException otherSigningException = new SigningException("otherMessage", EXPECTED_CAUSE);
    assertFalse(signingException.equals(otherSigningException));
    assertFalse(otherSigningException.equals(signingException));
  }

  @Test
  void equals_false_cause() throws IOException {
    SigningException signingException = new SigningException(EXPECTED_MESSAGE, EXPECTED_CAUSE);
    SigningException otherSigningException =
        new SigningException("otherMessage", new RuntimeException());
    assertFalse(signingException.equals(otherSigningException));
    assertFalse(otherSigningException.equals(signingException));
  }

  @Test
  void hashCode_equals() throws IOException {
    SigningException signingException = new SigningException(EXPECTED_MESSAGE, EXPECTED_CAUSE);
    SigningException otherSigningException = new SigningException(EXPECTED_MESSAGE, EXPECTED_CAUSE);
    assertEquals(signingException.hashCode(), otherSigningException.hashCode());
  }
}
