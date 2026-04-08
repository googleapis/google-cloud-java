/*
 * Copyright 2015, Google Inc. All rights reserved.
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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.auth.http.AuthHttpConstants;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/** Utilities for test code under com.google.auth. */
public class TestUtils {

  public static final URI WORKFORCE_IDENTITY_FEDERATION_AUTH_URI =
      URI.create("https://auth.cloud.google/authorize");
  public static final URI WORKFORCE_IDENTITY_FEDERATION_TOKEN_SERVER_URI =
      URI.create("https://sts.googleapis.com/v1/oauthtoken");

  private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

  public static void assertContainsBearerToken(Map<String, List<String>> metadata, String token) {
    assertNotNull(metadata);
    assertNotNull(token);
    assertTrue(hasBearerToken(metadata, token), "Bearer token not found");
  }

  public static void assertNotContainsBearerToken(
      Map<String, List<String>> metadata, String token) {
    assertNotNull(metadata);
    assertNotNull(token);
    assertFalse(hasBearerToken(metadata, token), "Bearer token found");
  }

  private static boolean hasBearerToken(Map<String, List<String>> metadata, String token) {
    String expectedValue = AuthHttpConstants.BEARER + " " + token;
    List<String> authorizations = metadata.get(AuthHttpConstants.AUTHORIZATION);
    assertNotNull(authorizations, "Authorization headers not found");
    return authorizations.contains(expectedValue);
  }

  public static InputStream jsonToInputStream(GenericJson json) throws IOException {
    json.setFactory(JSON_FACTORY);
    String text = json.toPrettyString();
    return new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
  }

  public static InputStream stringToInputStream(String text) {
    return new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
  }

  public static Map<String, String> parseQuery(String query) throws IOException {
    Map<String, String> map = new HashMap<>();
    Iterable<String> entries = Splitter.on('&').split(query);
    for (String entry : entries) {
      List<String> sides = Lists.newArrayList(Splitter.on('=').split(entry));
      if (sides.size() != 2) {
        throw new IOException("Invalid Query String");
      }
      String key = URLDecoder.decode(sides.get(0), "UTF-8");
      String value = URLDecoder.decode(sides.get(1), "UTF-8");
      map.put(key, value);
    }
    return map;
  }

  public static String errorJson(String message) throws IOException {
    GenericJson errorResponse = new GenericJson();
    errorResponse.setFactory(JSON_FACTORY);
    GenericJson errorObject = new GenericJson();
    errorObject.put("message", message);
    errorResponse.put("error", errorObject);
    return errorResponse.toPrettyString();
  }

  public static HttpResponseException buildHttpResponseException(
      String error, @Nullable String errorDescription, @Nullable String errorUri)
      throws IOException {
    GenericJson json = new GenericJson();
    json.setFactory(GsonFactory.getDefaultInstance());
    json.set("error", error);
    if (errorDescription != null) {
      json.set("error_description", errorDescription);
    }
    if (errorUri != null) {
      json.set("error_uri", errorUri);
    }
    return new HttpResponseException.Builder(
            /* statusCode= */ 400, /* statusMessage= */ "statusMessage", new HttpHeaders())
        .setContent(json.toPrettyString())
        .build();
  }

  public static String getDefaultExpireTime() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.add(Calendar.SECOND, 300);
    return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(calendar.getTime());
  }

  private TestUtils() {}
}
