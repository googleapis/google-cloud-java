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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Implements PKCE using only the Java standard library. See https://www.rfc-editor.org/rfc/rfc7636.
 *
 * <p>https://developers.google.com/identity/protocols/oauth2/native-app#step1-code-verifier.
 */
public class DefaultPKCEProvider implements PKCEProvider {
  private String codeVerifier;
  private CodeChallenge codeChallenge;
  private static final int MAX_CODE_VERIFIER_LENGTH = 127;

  private String createCodeVerifier() {
    SecureRandom sr = new SecureRandom();
    byte[] code = new byte[MAX_CODE_VERIFIER_LENGTH];
    sr.nextBytes(code);
    return Base64.getUrlEncoder().encodeToString(code);
  }

  private CodeChallenge createCodeChallenge(String codeVerifier) {
    return new DefaultPKCEProvider.CodeChallenge(codeVerifier);
  }

  public DefaultPKCEProvider() {
    this.codeVerifier = createCodeVerifier();
    this.codeChallenge = createCodeChallenge(this.codeVerifier);
  }

  @Override
  public String getCodeVerifier() {
    return codeVerifier;
  }

  @Override
  public String getCodeChallenge() {
    return codeChallenge.getCodeChallenge();
  }

  @Override
  public String getCodeChallengeMethod() {
    return codeChallenge.getCodeChallengeMethod();
  }

  /** Class representing the Code Challenge derived from a Code Verifier string. */
  private class CodeChallenge {
    private String codeChallenge;
    private String codeChallengeMethod;

    CodeChallenge(String codeVerifier) {
      try {
        byte[] bytes = codeVerifier.getBytes();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(bytes);

        byte[] digest = md.digest();

        this.codeChallenge = Base64.getUrlEncoder().encodeToString(digest).replace("=", "");
        this.codeChallengeMethod = "S256";
      } catch (NoSuchAlgorithmException e) {
        this.codeChallenge = codeVerifier;
        this.codeChallengeMethod = "plain";
      }
    }

    public String getCodeChallenge() {
      return codeChallenge;
    }

    public String getCodeChallengeMethod() {
      return codeChallengeMethod;
    }
  }
}
