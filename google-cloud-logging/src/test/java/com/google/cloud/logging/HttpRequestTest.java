/*
 * Copyright 2016 Google LLC
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
import org.threeten.bp.Duration;

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
  private static final HttpRequest HTTP_REQUEST =
      HttpRequest.newBuilder()
          .setRequestMethod(REQUEST_METHOD)
          .setRequestUrl(REQUEST_URL)
          .setRequestSize(REQUEST_SIZE)
          .setStatus(STATUS)
          .setResponseSize(REPONSE_SIZE)
          .setUserAgent(USER_AGENT)
          .setRemoteIp(REMOTE_IP)
          .setServerIp(SERVER_IP)
          .setReferer(REFERER)
          .setCacheLookup(CACHE_LOOKUP)
          .setCacheHit(CACHE_HIT)
          .setCacheValidatedWithOriginServer(CACHE_VALIDATED_WITH_ORIGIN_SERVER)
          .setCacheFillBytes(CACHE_FILL_BYTES)
          .setLatency(Duration.ofSeconds(123, 456))
          .build();

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testBuilder() {
    assertEquals(REQUEST_METHOD, HTTP_REQUEST.getRequestMethod());
    assertEquals(REQUEST_URL, HTTP_REQUEST.getRequestUrl());
    assertEquals(REQUEST_SIZE, HTTP_REQUEST.getRequestSize());
    assertEquals(STATUS, HTTP_REQUEST.getStatus());
    assertEquals(REPONSE_SIZE, HTTP_REQUEST.getResponseSize());
    assertEquals(USER_AGENT, HTTP_REQUEST.getUserAgent());
    assertEquals(REMOTE_IP, HTTP_REQUEST.getRemoteIp());
    assertEquals(SERVER_IP, HTTP_REQUEST.getServerIp());
    assertEquals(REFERER, HTTP_REQUEST.getReferer());
    assertEquals(CACHE_LOOKUP, HTTP_REQUEST.cacheLookup());
    assertEquals(CACHE_HIT, HTTP_REQUEST.cacheHit());
    assertEquals(CACHE_VALIDATED_WITH_ORIGIN_SERVER, HTTP_REQUEST.cacheValidatedWithOriginServer());
    assertEquals(CACHE_FILL_BYTES, HTTP_REQUEST.getCacheFillBytes());
  }


  @Test
  public void testBuilderDefaultValues() {
    HttpRequest httpRequest = HttpRequest.newBuilder().build();
    assertNull(httpRequest.getRequestMethod());
    assertNull(httpRequest.getRequestUrl());
    assertNull(httpRequest.getRequestSize());
    assertNull(httpRequest.getStatus());
    assertNull(httpRequest.getResponseSize());
    assertNull(httpRequest.getUserAgent());
    assertNull(httpRequest.getRemoteIp());
    assertNull(httpRequest.getServerIp());
    assertNull(httpRequest.getReferer());
    assertFalse(httpRequest.cacheLookup());
    assertFalse(httpRequest.cacheHit());
    assertFalse(httpRequest.cacheValidatedWithOriginServer());
    assertNull(httpRequest.getCacheFillBytes());
  }

  @Test
  public void testToBuilder() {
    compareHttpRequest(HTTP_REQUEST, HTTP_REQUEST.toBuilder().build());
    HttpRequest httpRequest = HTTP_REQUEST.toBuilder()
        .setRequestMethod(RequestMethod.POST)
        .setRequestUrl("http://www.other-example.com")
        .setRequestSize(4)
        .setStatus(201)
        .setResponseSize(5)
        .setUserAgent("otherUserAgent")
        .setRemoteIp("192.168.1.3")
        .setServerIp("192.168.1.4")
        .setReferer("Referer: http://www.other-example.com")
        .setCacheLookup(true)
        .setCacheHit(true)
        .setCacheValidatedWithOriginServer(true)
        .setCacheFillBytes(6)
        .build();
    assertEquals(RequestMethod.POST, httpRequest.getRequestMethod());
    assertEquals("http://www.other-example.com", httpRequest.getRequestUrl());
    assertEquals(4, (long) httpRequest.getRequestSize());
    assertEquals(201, (int) httpRequest.getStatus());
    assertEquals(5, (long) httpRequest.getResponseSize());
    assertEquals("otherUserAgent", httpRequest.getUserAgent());
    assertEquals("192.168.1.3", httpRequest.getRemoteIp());
    assertEquals("192.168.1.4", httpRequest.getServerIp());
    assertEquals("Referer: http://www.other-example.com", httpRequest.getReferer());
    assertTrue(httpRequest.cacheLookup());
    assertTrue(httpRequest.cacheHit());
    assertTrue(httpRequest.cacheValidatedWithOriginServer());
    assertEquals(6, (long) httpRequest.getCacheFillBytes());
  }

  @Test
  public void testToAndFromPb() {
    HttpRequest httpRequest = HttpRequest.fromPb(HTTP_REQUEST.toPb());
    compareHttpRequest(HTTP_REQUEST, httpRequest);
    assertEquals(REQUEST_METHOD, httpRequest.getRequestMethod());
    assertEquals(REQUEST_URL, httpRequest.getRequestUrl());
    assertEquals(REQUEST_SIZE, httpRequest.getRequestSize());
    assertEquals(STATUS, httpRequest.getStatus());
    assertEquals(REPONSE_SIZE, httpRequest.getResponseSize());
    assertEquals(USER_AGENT, httpRequest.getUserAgent());
    assertEquals(REMOTE_IP, httpRequest.getRemoteIp());
    assertEquals(SERVER_IP, httpRequest.getServerIp());
    assertEquals(REFERER, httpRequest.getReferer());
    assertEquals(CACHE_LOOKUP, httpRequest.cacheLookup());
    assertEquals(CACHE_HIT, httpRequest.cacheHit());
    assertEquals(CACHE_VALIDATED_WITH_ORIGIN_SERVER, httpRequest.cacheValidatedWithOriginServer());
    assertEquals(CACHE_FILL_BYTES, httpRequest.getCacheFillBytes());
    HttpRequest incompleteHttpRequest = HttpRequest.newBuilder().build();
    httpRequest = HttpRequest.fromPb(incompleteHttpRequest.toPb());
    compareHttpRequest(incompleteHttpRequest, httpRequest);
    assertNull(httpRequest.getRequestMethod());
    assertNull(httpRequest.getRequestUrl());
    assertNull(httpRequest.getRequestSize());
    assertNull(httpRequest.getStatus());
    assertNull(httpRequest.getResponseSize());
    assertNull(httpRequest.getUserAgent());
    assertNull(httpRequest.getRemoteIp());
    assertNull(httpRequest.getServerIp());
    assertNull(httpRequest.getReferer());
    assertFalse(httpRequest.cacheLookup());
    assertFalse(httpRequest.cacheHit());
    assertFalse(httpRequest.cacheValidatedWithOriginServer());
    assertNull(httpRequest.getCacheFillBytes());
  }

  private void compareHttpRequest(HttpRequest expected, HttpRequest value) {
    assertEquals(expected, value);
    assertEquals(expected.getRequestMethod(), value.getRequestMethod());
    assertEquals(expected.getRequestUrl(), value.getRequestUrl());
    assertEquals(expected.getRequestSize(), value.getRequestSize());
    assertEquals(expected.getStatus(), value.getStatus());
    assertEquals(expected.getResponseSize(), value.getResponseSize());
    assertEquals(expected.getUserAgent(), value.getUserAgent());
    assertEquals(expected.getRemoteIp(), value.getRemoteIp());
    assertEquals(expected.getServerIp(), value.getServerIp());
    assertEquals(expected.getReferer(), value.getReferer());
    assertEquals(expected.cacheLookup(), value.cacheLookup());
    assertEquals(expected.cacheHit(), value.cacheHit());
    assertEquals(expected.cacheValidatedWithOriginServer(), value.cacheValidatedWithOriginServer());
    assertEquals(expected.getCacheFillBytes(), value.getCacheFillBytes());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
