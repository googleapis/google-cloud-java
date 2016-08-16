/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.logging.HttpRequest.RequestMethod;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HttpRequestTest {

  private static final RequestMethod REQUEST_METHOD = RequestMethod.GET;
  private static final String REQUEST_URL = "http://www.example.com";
  private static final Long REQUEST_SIZE = 1L;
  private static final Integer STATUS = 200;
  private static final Long REPONSE_SIZE = 2L;
  private static final String USER_AGENT =
      "Mozilla/4.0 (compatible; MSIE 6.0; Windows 98; Q312461; .NET CLR 1.0.3705)";
  private static final String REMOTE_IP = "192.168.1.1";
  private static final String SERVER_IP = "192.168.1.2";
  private static final String REFERER = "Referer: http://www.example.com";
  private static final boolean CACHE_LOOKUP = true;
  private static final boolean CACHE_HIT = true;
  private static final boolean CACHE_VALIDATED_WITH_ORIGIN_SERVER = false;
  private static final Long CACHE_FILL_BYTES = 3L;
  private static final HttpRequest HTTP_REQUEST = HttpRequest.builder()
      .requestMethod(REQUEST_METHOD)
      .requestUrl(REQUEST_URL)
      .requestSize(REQUEST_SIZE)
      .status(STATUS)
      .responseSize(REPONSE_SIZE)
      .userAgent(USER_AGENT)
      .remoteIp(REMOTE_IP)
      .serverIp(SERVER_IP)
      .referer(REFERER)
      .cacheLookup(CACHE_LOOKUP)
      .cacheHit(CACHE_HIT)
      .cacheValidatedWithOriginServer(CACHE_VALIDATED_WITH_ORIGIN_SERVER)
      .cacheFillBytes(CACHE_FILL_BYTES)
      .build();

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testBuilder() {
    assertEquals(REQUEST_METHOD, HTTP_REQUEST.requestMethod());
    assertEquals(REQUEST_URL, HTTP_REQUEST.requestUrl());
    assertEquals(REQUEST_SIZE, HTTP_REQUEST.requestSize());
    assertEquals(STATUS, HTTP_REQUEST.status());
    assertEquals(REPONSE_SIZE, HTTP_REQUEST.responseSize());
    assertEquals(USER_AGENT, HTTP_REQUEST.userAgent());
    assertEquals(REMOTE_IP, HTTP_REQUEST.remoteIp());
    assertEquals(SERVER_IP, HTTP_REQUEST.serverIp());
    assertEquals(REFERER, HTTP_REQUEST.referer());
    assertEquals(CACHE_LOOKUP, HTTP_REQUEST.cacheLookup());
    assertEquals(CACHE_HIT, HTTP_REQUEST.cacheHit());
    assertEquals(CACHE_VALIDATED_WITH_ORIGIN_SERVER, HTTP_REQUEST.cacheValidatedWithOriginServer());
    assertEquals(CACHE_FILL_BYTES, HTTP_REQUEST.cacheFillBytes());
  }

  @Test
  public void testBuilderDefaultValues() {
    HttpRequest httpRequest = HttpRequest.builder().build();
    assertNull(httpRequest.requestMethod());
    assertNull(httpRequest.requestUrl());
    assertNull(httpRequest.requestSize());
    assertNull(httpRequest.status());
    assertNull(httpRequest.responseSize());
    assertNull(httpRequest.userAgent());
    assertNull(httpRequest.remoteIp());
    assertNull(httpRequest.serverIp());
    assertNull(httpRequest.referer());
    assertFalse(httpRequest.cacheLookup());
    assertFalse(httpRequest.cacheHit());
    assertFalse(httpRequest.cacheValidatedWithOriginServer());
    assertNull(httpRequest.cacheFillBytes());
  }

  @Test
  public void testToBuilder() {
    compareHttpRequest(HTTP_REQUEST, HTTP_REQUEST.toBuilder().build());
    HttpRequest httpRequest = HTTP_REQUEST.toBuilder()
        .requestMethod(RequestMethod.POST)
        .requestUrl("http://www.other-example.com")
        .requestSize(4)
        .status(201)
        .responseSize(5)
        .userAgent("otherUserAgent")
        .remoteIp("192.168.1.3")
        .serverIp("192.168.1.4")
        .referer("Referer: http://www.other-example.com")
        .cacheLookup(true)
        .cacheHit(true)
        .cacheValidatedWithOriginServer(true)
        .cacheFillBytes(6)
        .build();
    assertEquals(RequestMethod.POST, httpRequest.requestMethod());
    assertEquals("http://www.other-example.com", httpRequest.requestUrl());
    assertEquals(4, (long) httpRequest.requestSize());
    assertEquals(201, (int) httpRequest.status());
    assertEquals(5, (long) httpRequest.responseSize());
    assertEquals("otherUserAgent", httpRequest.userAgent());
    assertEquals("192.168.1.3", httpRequest.remoteIp());
    assertEquals("192.168.1.4", httpRequest.serverIp());
    assertEquals("Referer: http://www.other-example.com", httpRequest.referer());
    assertTrue(httpRequest.cacheLookup());
    assertTrue(httpRequest.cacheHit());
    assertTrue(httpRequest.cacheValidatedWithOriginServer());
    assertEquals(6, (long) httpRequest.cacheFillBytes());
  }

  @Test
  public void testToAndFromPb() {
    HttpRequest httpRequest = HttpRequest.fromPb(HTTP_REQUEST.toPb());
    compareHttpRequest(HTTP_REQUEST, httpRequest);
    assertEquals(REQUEST_METHOD, httpRequest.requestMethod());
    assertEquals(REQUEST_URL, httpRequest.requestUrl());
    assertEquals(REQUEST_SIZE, httpRequest.requestSize());
    assertEquals(STATUS, httpRequest.status());
    assertEquals(REPONSE_SIZE, httpRequest.responseSize());
    assertEquals(USER_AGENT, httpRequest.userAgent());
    assertEquals(REMOTE_IP, httpRequest.remoteIp());
    assertEquals(SERVER_IP, httpRequest.serverIp());
    assertEquals(REFERER, httpRequest.referer());
    assertEquals(CACHE_LOOKUP, httpRequest.cacheLookup());
    assertEquals(CACHE_HIT, httpRequest.cacheHit());
    assertEquals(CACHE_VALIDATED_WITH_ORIGIN_SERVER, httpRequest.cacheValidatedWithOriginServer());
    assertEquals(CACHE_FILL_BYTES, httpRequest.cacheFillBytes());
    HttpRequest incompleteHttpRequest = HttpRequest.builder().build();
    httpRequest = HttpRequest.fromPb(incompleteHttpRequest.toPb());
    compareHttpRequest(incompleteHttpRequest, httpRequest);
    assertNull(httpRequest.requestMethod());
    assertNull(httpRequest.requestUrl());
    assertNull(httpRequest.requestSize());
    assertNull(httpRequest.status());
    assertNull(httpRequest.responseSize());
    assertNull(httpRequest.userAgent());
    assertNull(httpRequest.remoteIp());
    assertNull(httpRequest.serverIp());
    assertNull(httpRequest.referer());
    assertFalse(httpRequest.cacheLookup());
    assertFalse(httpRequest.cacheHit());
    assertFalse(httpRequest.cacheValidatedWithOriginServer());
    assertNull(httpRequest.cacheFillBytes());
  }

  private void compareHttpRequest(HttpRequest expected, HttpRequest value) {
    assertEquals(expected, value);
    assertEquals(expected.requestMethod(), value.requestMethod());
    assertEquals(expected.requestUrl(), value.requestUrl());
    assertEquals(expected.requestSize(), value.requestSize());
    assertEquals(expected.status(), value.status());
    assertEquals(expected.responseSize(), value.responseSize());
    assertEquals(expected.userAgent(), value.userAgent());
    assertEquals(expected.remoteIp(), value.remoteIp());
    assertEquals(expected.serverIp(), value.serverIp());
    assertEquals(expected.referer(), value.referer());
    assertEquals(expected.cacheLookup(), value.cacheLookup());
    assertEquals(expected.cacheHit(), value.cacheHit());
    assertEquals(expected.cacheValidatedWithOriginServer(), value.cacheValidatedWithOriginServer());
    assertEquals(expected.cacheFillBytes(), value.cacheFillBytes());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
