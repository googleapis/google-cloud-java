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

package com.google.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Date;
import org.junit.jupiter.api.Test;

/** Unit tests for AccessToken */
class IdTokenTest extends BaseSerializationTest {

  private static final String TOKEN_1 =
      "eyJhbGciOiJSUzI1NiIsImtpZCI6IjM0OTRiMWU3ODZjZGFkMDkyZTQyMzc2NmJiZTM3ZjU0ZWQ4N2IyMmQiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhdWQiOiJodHRwczovL2Zvby5iYXIiLCJhenAiOiJzdmMtMi00MjlAbWluZXJhbC1taW51dGlhLTgyMC5pYW0uZ3NlcnZpY2VhY2NvdW50LmNvbSIsInN1YiI6IjEwMDE0NzEwNjk5Njc2NDQ3OTA4NSIsImVtYWlsIjoic3ZjLTItNDI5QG1pbmVyYWwtbWludXRpYS04MjAuaWFtLmdzZXJ2aWNlYWNjb3VudC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiaWF0IjoxNTY1Mzg3NTM4LCJleHAiOjE1NjUzOTExMzh9.foo";
  private static final String TOKEN_2 =
      "eyJhbGciOiJSUzI1NiIsImtpZCI6IjM0OTRiMWU3ODZjZGFkMDkyZTQyMzc2NmJiZTM3ZjU0ZWQ4N2IyMmQiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhdWQiOiJodHRwczovL2Jhci5mb28iLCJhenAiOiJzdmMtMi00MjlAbWluZXJhbC1taW51dGlhLTgyMC5pYW0uZ3NlcnZpY2VhY2NvdW50LmNvbSIsInN1YiI6IjEwMDE0NzEwNjk5Njc2NDQ3OTA4NSIsImVtYWlsIjoic3ZjLTItNDI5QG1pbmVyYWwtbWludXRpYS04MjAuaWFtLmdzZXJ2aWNlYWNjb3VudC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiaWF0IjoxNTY1Mzg4NjM0LCJleHAiOjE1NjUzOTIyMzR9.foo";
  private static final String TOKEN_WITH_0x20 =
      "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJPbmxpbmUgSldUIEJ1aWxkZXIiLCJpYXQiOjE2NjAxNjMxNjAsImV4cCI6MTY5MTY5OTE2MCwiYXVkIjoid3d3LmV4YW1wbGUuY29tIiwic3ViIjoianJvY2tldEBleGFtcGxlLmNvbSIsIkdpdmVuTmFtZSI6ImFibTHag3M0x20ifQ.foo";
  private static final Date EXPIRATION_DATE = new Date((long) 1565391138 * 1000);

  @Test
  void constructor() throws IOException {
    IdToken idToken = IdToken.create(TOKEN_1);
    assertEquals(TOKEN_1, idToken.getTokenValue());
    assertEquals(EXPIRATION_DATE, idToken.getExpirationTime());
  }

  @Test
  void equals_true() throws IOException {
    IdToken accessToken = IdToken.create(TOKEN_1);
    IdToken otherAccessToken = IdToken.create(TOKEN_1);
    assertTrue(accessToken.equals(otherAccessToken));
    assertTrue(otherAccessToken.equals(accessToken));
  }

  @Test
  void equals_false_token() throws IOException {
    IdToken accessToken = IdToken.create(TOKEN_1);
    IdToken otherAccessToken = IdToken.create(TOKEN_2);
    assertFalse(accessToken.equals(otherAccessToken));
    assertFalse(otherAccessToken.equals(accessToken));
  }

  @Test
  void toString_test() throws IOException {
    IdToken accessToken = IdToken.create(TOKEN_1);
    String expectedToString =
        String.format(
            "IdToken{tokenValue=%s, JsonWebSignature=JsonWebSignature{header={\"alg\":\"RS256\",\"kid\":\"3494b1e786cdad092e423766bbe37f54ed87b22d\",\"typ\":\"JWT\"}, payload={\"aud\":\"https://foo.bar\",\"exp\":1565391138,\"iat\":1565387538,\"iss\":\"https://accounts.google.com\",\"sub\":\"100147106996764479085\",\"azp\":\"svc-2-429@mineral-minutia-820.iam.gserviceaccount.com\",\"email\":\"svc-2-429@mineral-minutia-820.iam.gserviceaccount.com\",\"email_verified\":true}}}",
            TOKEN_1);
    assertEquals(expectedToString, accessToken.toString());
  }

  @Test
  void hashCode_equals() throws IOException {
    IdToken accessToken = IdToken.create(TOKEN_1);
    IdToken otherAccessToken = IdToken.create(TOKEN_1);
    assertEquals(accessToken.hashCode(), otherAccessToken.hashCode());
  }

  @Test
  void serialize() throws IOException, ClassNotFoundException {
    IdToken accessToken = IdToken.create(TOKEN_1);
    IdToken deserializedAccessToken = serializeAndDeserialize(accessToken);
    assertEquals(accessToken, deserializedAccessToken);
    assertEquals(accessToken.hashCode(), deserializedAccessToken.hashCode());
    assertEquals(accessToken.toString(), deserializedAccessToken.toString());
  }

  @Test
  void token_with_0x20() throws IOException {
    IdToken accessToken = IdToken.create(TOKEN_WITH_0x20);
    assertEquals(TOKEN_WITH_0x20, accessToken.getTokenValue());
  }
}
