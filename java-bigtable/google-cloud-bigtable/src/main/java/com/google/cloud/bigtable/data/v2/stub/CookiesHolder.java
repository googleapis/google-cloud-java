/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub;

import io.grpc.CallOptions;
import io.grpc.Metadata;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/** A cookie that holds information for retry or routing */
class CookiesHolder {

  static final CallOptions.Key<CookiesHolder> COOKIES_HOLDER_KEY =
      CallOptions.Key.create("bigtable-cookies");

  /** Routing cookie key prefix. */
  static final String COOKIE_KEY_PREFIX = "x-goog-cbt-cookie";

  /** A map that stores all the routing cookies. */
  private final Map<Metadata.Key<String>, String> cookies = new HashMap<>();

  /** Returns CookiesHolder if presents in CallOptions, otherwise returns null. */
  @Nullable
  static CookiesHolder fromCallOptions(CallOptions options) {
    // CookiesHolder should be added by CookiesServerStreamingCallable and
    // CookiesUnaryCallable for most methods. However, methods like PingAndWarm
    // doesn't support routing cookie, in which case this will return null.
    return options.getOption(COOKIES_HOLDER_KEY);
  }

  /** Add all the routing cookies to headers if any. */
  Metadata injectCookiesInRequestHeaders(Metadata headers) {
    for (Metadata.Key<String> key : cookies.keySet()) {
      headers.put(key, cookies.get(key));
    }
    return headers;
  }

  /**
   * Iterate through all the keys in initial or trailing metadata, and add all the keys that match
   * COOKIE_KEY_PREFIX to cookies. Values in trailers will override the value set in initial
   * metadata for the same keys.
   */
  void extractCookiesFromMetadata(@Nullable Metadata trailers) {
    if (trailers == null) {
      return;
    }
    for (String key : trailers.keys()) {
      if (key.startsWith(COOKIE_KEY_PREFIX)) {
        Metadata.Key<String> metadataKey = Metadata.Key.of(key, Metadata.ASCII_STRING_MARSHALLER);
        String value = trailers.get(metadataKey);
        cookies.put(metadataKey, value);
      }
    }
  }
}
