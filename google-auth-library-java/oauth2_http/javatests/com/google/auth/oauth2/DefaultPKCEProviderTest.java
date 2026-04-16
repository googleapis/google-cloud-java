/*
 * Copyright 2023, Google Inc. All rights reserved.
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

package com.google.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import org.junit.jupiter.api.Test;

final class DefaultPKCEProviderTest {
  @Test
  void testPkceExpected() throws NoSuchAlgorithmException {
    PKCEProvider pkce = new DefaultPKCEProvider();

    byte[] bytes = pkce.getCodeVerifier().getBytes();
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    md.update(bytes);

    byte[] digest = md.digest();

    String expectedCodeChallenge = Base64.getUrlEncoder().encodeToString(digest).replace("=", "");
    String expectedCodeChallengeMethod = "S256";

    assertEquals(pkce.getCodeChallenge(), expectedCodeChallenge);
    assertEquals(expectedCodeChallengeMethod, pkce.getCodeChallengeMethod());
  }

  @Test
  void testNoBase64Padding() {
    PKCEProvider pkce = new DefaultPKCEProvider();
    assertFalse(pkce.getCodeChallenge().endsWith("="));
    assertFalse(pkce.getCodeChallenge().contains("="));
  }
}
