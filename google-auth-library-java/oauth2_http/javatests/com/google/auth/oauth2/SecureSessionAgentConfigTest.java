/*
 * Copyright 2024, Google Inc. All rights reserved.
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
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/** Test cases for {@link SecureSessionAgentConfig}. */
class SecureSessionAgentConfigTest {
  private static final String S2A_PLAINTEXT_ADDRESS = "plaintext";
  private static final String S2A_MTLS_ADDRESS = "mtls";

  @Test
  void createS2AConfig_success() {
    SecureSessionAgentConfig config =
        SecureSessionAgentConfig.createBuilder()
            .setPlaintextAddress(S2A_PLAINTEXT_ADDRESS)
            .setMtlsAddress(S2A_MTLS_ADDRESS)
            .build();
    assertEquals(S2A_PLAINTEXT_ADDRESS, config.getPlaintextAddress());
    assertEquals(S2A_MTLS_ADDRESS, config.getMtlsAddress());
  }

  @Test
  void createEmptyS2AConfig_success() {
    SecureSessionAgentConfig config = SecureSessionAgentConfig.createBuilder().build();
    assertTrue(config.getPlaintextAddress().isEmpty());
    assertTrue(config.getMtlsAddress().isEmpty());
  }
}
