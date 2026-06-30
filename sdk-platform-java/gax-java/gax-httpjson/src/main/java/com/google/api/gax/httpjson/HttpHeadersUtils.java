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

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.FieldInfo;
import com.google.api.core.InternalApi;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Map;

/** This class is for internal use only and is public for technical reasons. */
@InternalApi
public class HttpHeadersUtils {
  public static String getUserAgentValue(Map<String, String> headersMap) {
    for (Map.Entry<String, String> entry : headersMap.entrySet()) {
      if ("user-agent".equalsIgnoreCase(entry.getKey())) {
        return entry.getValue();
      }
    }
    return null;
  }

  public static HttpHeaders setHeaders(HttpHeaders headers, Map<String, String> headersMap) {
    for (Map.Entry<String, String> entry : headersMap.entrySet()) {
      setHeader(headers, entry.getKey(), entry.getValue());
    }
    return headers;
  }

  public static HttpHeaders setHeader(HttpHeaders headers, String key, String value) {
    ClassInfo classInfo = headers.getClassInfo();
    FieldInfo fieldInfo = classInfo.getFieldInfo(key);
    Object headerValue;
    if (fieldInfo == null) {
      headerValue = value;
    } else {
      Class<?> elementyType = fieldInfo.getType();
      if (List.class.isAssignableFrom(fieldInfo.getType())) {
        elementyType =
            "Age".equalsIgnoreCase(key) || "Content-Length".equalsIgnoreCase(key)
                ? Long.class
                : String.class;
      }
      headerValue = ImmutableList.of(fromString(elementyType, value));
    }
    headers.set(key, headerValue);
    return headers;
  }

  private static Object fromString(Class<?> clazz, String stringValue) {
    if (String.class == clazz) {
      return stringValue;
    } else if (Long.class == clazz) {
      return Long.valueOf(stringValue);
    }

    // It seems only String and Long have chances of being used. Not adding other
    // classes to avoid having dead code, even though without them this looks incomplete.
    throw new IllegalArgumentException(
        "Instantiating "
            + clazz
            + " from string representation is not supported. Most likely an"
            + " incompatible version of google-http-client was used.");
  }
}
