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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;

/** Unit tests for AccessToken */
class AccessTokenTest extends BaseSerializationTest {

  private static final String TOKEN = "AccessToken";
  private static final Date EXPIRATION_DATE = new Date();
  private static final List<String> SCOPES = Arrays.asList("scope1", "scope2");
  private static final String SCOPES_STRING = "scope1 scope2";

  @Test
  void constructor() {
    AccessToken accessToken = new AccessToken(TOKEN, EXPIRATION_DATE);
    assertEquals(TOKEN, accessToken.getTokenValue());
    assertEquals(EXPIRATION_DATE, accessToken.getExpirationTime());
    assertEquals(EXPIRATION_DATE.getTime(), (long) accessToken.getExpirationTimeMillis());
    assertEquals(new ArrayList<>(), accessToken.getScopes());
  }

  @Test
  void builder() {
    AccessToken accessToken =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue(TOKEN)
            .setScopes(SCOPES_STRING)
            .build();
    assertEquals(TOKEN, accessToken.getTokenValue());
    assertEquals(EXPIRATION_DATE, accessToken.getExpirationTime());
    assertEquals(EXPIRATION_DATE.getTime(), (long) accessToken.getExpirationTimeMillis());
    assertEquals(SCOPES, accessToken.getScopes());
    assertNotSame(SCOPES, accessToken.getScopes());

    // scopes list
    accessToken =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue(TOKEN)
            .setScopes(SCOPES)
            .build();
    assertEquals(SCOPES, accessToken.getScopes());
    assertSame(SCOPES, accessToken.getScopes());

    // single scope
    accessToken =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue(TOKEN)
            .setScopes("dummy")
            .build();
    assertEquals(Collections.singletonList("dummy"), accessToken.getScopes());

    // empty scope
    accessToken =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue(TOKEN)
            .setScopes("  ")
            .build();
    assertEquals(new ArrayList<>(), accessToken.getScopes());
  }

  @Test
  void equals_true() {
    AccessToken accessToken =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue(TOKEN)
            .setScopes(SCOPES)
            .build();

    AccessToken otherAccessToken =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue(TOKEN)
            .setTokenValue(TOKEN)
            .setScopes(SCOPES)
            .build();

    assertEquals(accessToken, otherAccessToken);
    assertEquals(otherAccessToken, accessToken);
  }

  @Test
  void equals_false_scopes() {
    AccessToken accessToken =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue(TOKEN)
            .setScopes(SCOPES)
            .build();

    AccessToken otherAccessToken =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue(TOKEN)
            .setScopes(Collections.singletonList("scope1"))
            .build();

    assertNotEquals(accessToken, otherAccessToken);
    assertNotEquals(otherAccessToken, accessToken);
  }

  @Test
  void equals_false_token() {
    AccessToken accessToken =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue(TOKEN)
            .setScopes(SCOPES)
            .build();

    AccessToken otherAccessToken =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue("otherToken")
            .setScopes(SCOPES)
            .build();

    assertNotEquals(accessToken, otherAccessToken);
    assertNotEquals(otherAccessToken, accessToken);
  }

  @Test
  void equals_false_expirationDate() {
    AccessToken accessToken =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue(TOKEN)
            .setScopes(SCOPES)
            .build();

    AccessToken otherAccessToken =
        AccessToken.newBuilder()
            .setExpirationTime(new Date(EXPIRATION_DATE.getTime() + 42))
            .setTokenValue(TOKEN)
            .setScopes(SCOPES)
            .build();

    assertNotEquals(accessToken, otherAccessToken);
    assertNotEquals(otherAccessToken, accessToken);
  }

  @Test
  void toString_containsFields() {
    AccessToken accessToken =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue(TOKEN)
            .setScopes(SCOPES)
            .build();
    String expectedToString =
        String.format(
            "AccessToken{tokenValue=%s, expirationTimeMillis=%d, scopes=%s}",
            TOKEN, EXPIRATION_DATE.getTime(), SCOPES);
    assertEquals(expectedToString, accessToken.toString());
  }

  @Test
  void hashCode_equals() {
    AccessToken accessToken =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue(TOKEN)
            .setScopes(SCOPES)
            .build();

    AccessToken otherAccessToken =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue(TOKEN)
            .setScopes(SCOPES)
            .build();

    assertEquals(accessToken.hashCode(), otherAccessToken.hashCode());
  }

  @Test
  void serialize() throws IOException, ClassNotFoundException {
    AccessToken emptyScopes =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue(TOKEN)
            .setScopes("")
            .build();

    AccessToken deserializedAccessToken = serializeAndDeserialize(emptyScopes);
    assertEquals(emptyScopes, deserializedAccessToken);
    assertEquals(emptyScopes.hashCode(), deserializedAccessToken.hashCode());
    assertEquals(emptyScopes.toString(), deserializedAccessToken.toString());
    assertEquals(new ArrayList<>(), deserializedAccessToken.getScopes());

    AccessToken accessToken =
        AccessToken.newBuilder()
            .setExpirationTime(EXPIRATION_DATE)
            .setTokenValue(TOKEN)
            .setScopes(SCOPES)
            .build();

    deserializedAccessToken = serializeAndDeserialize(accessToken);
    assertEquals(accessToken, deserializedAccessToken);
    assertEquals(accessToken.hashCode(), deserializedAccessToken.hashCode());
    assertEquals(accessToken.toString(), deserializedAccessToken.toString());
  }
}
