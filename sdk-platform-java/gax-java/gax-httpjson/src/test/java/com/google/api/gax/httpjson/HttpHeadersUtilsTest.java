/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
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
package com.google.api.gax.httpjson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.google.api.client.http.HttpHeaders;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class HttpHeadersUtilsTest {

  @Test
  void testSetHeader() {
    HttpHeaders headers = new HttpHeaders();

    assertEquals(headers, HttpHeadersUtils.setHeader(headers, "Custom-Header", "CustomHeader"));
    HttpHeadersUtils.setHeader(headers, "accept", "Accept");
    HttpHeadersUtils.setHeader(headers, "accept-encoding", "AcceptEncoding");
    HttpHeadersUtils.setHeader(headers, "Authorization", "Authorization");
    HttpHeadersUtils.setHeader(headers, "cache-Control", "CacheControl");
    HttpHeadersUtils.setHeader(headers, "Content-Encoding", "ContentEncoding");
    HttpHeadersUtils.setHeader(headers, "Content-Length", "123");
    HttpHeadersUtils.setHeader(headers, "Content-MD5", "ContentMD5");
    HttpHeadersUtils.setHeader(headers, "Content-Range", "ContentRange");
    HttpHeadersUtils.setHeader(headers, "Content-Type", "ContentType");
    HttpHeadersUtils.setHeader(headers, "Cookie", "Cookie");
    HttpHeadersUtils.setHeader(headers, "Date", "Date");
    HttpHeadersUtils.setHeader(headers, "ETag", "ETag");
    HttpHeadersUtils.setHeader(headers, "Expires", "Expires");
    HttpHeadersUtils.setHeader(headers, "If-Modified-Since", "IfModifiedSince");
    HttpHeadersUtils.setHeader(headers, "If-Match", "IfMatch");
    HttpHeadersUtils.setHeader(headers, "If-None-Match", "IfNoneMatch");
    HttpHeadersUtils.setHeader(headers, "If-Unmodified-Since", "IfUnmodifiedSince");
    HttpHeadersUtils.setHeader(headers, "If-Range", "IfRange");
    HttpHeadersUtils.setHeader(headers, "Last-Modified", "LastModified");
    HttpHeadersUtils.setHeader(headers, "Location", "Location");
    HttpHeadersUtils.setHeader(headers, "Mime-Version", "MimeVersion");
    HttpHeadersUtils.setHeader(headers, "Range", "Range");
    HttpHeadersUtils.setHeader(headers, "Retry-After", "RetryAfter");
    HttpHeadersUtils.setHeader(headers, "User-Agent", "UserAgent");
    HttpHeadersUtils.setHeader(headers, "WWW-Authenticate", "Authenticate");
    HttpHeadersUtils.setHeader(headers, "Age", "456");

    assertEquals("CustomHeader", headers.get("Custom-Header"));
    assertEquals("CustomHeader", headers.get("custom-header"));
    assertEquals("Accept", headers.getAccept());
    assertEquals("AcceptEncoding", headers.getAcceptEncoding());
    assertEquals("Authorization", headers.getAuthorization());
    assertEquals("CacheControl", headers.getCacheControl());
    assertEquals("ContentEncoding", headers.getContentEncoding());
    assertEquals(Long.valueOf(123L), headers.getContentLength());
    assertEquals("ContentMD5", headers.getContentMD5());
    assertEquals("ContentRange", headers.getContentRange());
    assertEquals("ContentType", headers.getContentType());
    assertEquals("Cookie", headers.getCookie());
    assertEquals("Date", headers.getDate());
    assertEquals("ETag", headers.getETag());
    assertEquals("Expires", headers.getExpires());
    assertEquals("IfModifiedSince", headers.getIfModifiedSince());
    assertEquals("IfMatch", headers.getIfMatch());
    assertEquals("IfNoneMatch", headers.getIfNoneMatch());
    assertEquals("IfUnmodifiedSince", headers.getIfUnmodifiedSince());
    assertEquals("IfRange", headers.getIfRange());
    assertEquals("LastModified", headers.getLastModified());
    assertEquals("Location", headers.getLocation());
    assertEquals("MimeVersion", headers.getMimeVersion());
    assertEquals("Range", headers.getRange());
    assertEquals("RetryAfter", headers.getRetryAfter());
    assertEquals("UserAgent", headers.getUserAgent());
    assertEquals(ImmutableList.of("UserAgent"), headers.get("User-Agent"));
    assertEquals(ImmutableList.of("UserAgent"), headers.get("user-agent"));
    assertEquals("Authenticate", headers.getAuthenticate());
    assertEquals(Long.valueOf(456L), headers.getAge());
  }

  @Test
  void testSetHeaders() {
    HttpHeaders headers = new HttpHeaders();

    Map<String, String> headersMap =
        ImmutableMap.of(
            "Custom-Header", "CustomHeader", "accept", "Accept", "Content-Length", "123");

    assertEquals(headers, HttpHeadersUtils.setHeaders(headers, headersMap));

    assertEquals("CustomHeader", headers.get("Custom-Header"));
    assertEquals("Accept", headers.getAccept());
    assertEquals(Long.valueOf(123L), headers.getContentLength());
  }

  @Test
  void testGetUserAgentValue() {
    Map<String, String> headersMap =
        ImmutableMap.of(
            "Custom-Header", "CustomHeader", "User-Agent", "this is me", "accept", "Accept");

    assertEquals("this is me", HttpHeadersUtils.getUserAgentValue(headersMap));

    headersMap = ImmutableMap.of("Custom-Header", "CustomHeader", "accept", "Accept");
    assertNull(HttpHeadersUtils.getUserAgentValue(headersMap));
  }
}
