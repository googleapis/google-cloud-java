/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.api;

import com.google.bigtable.v2.FeatureFlags;
import com.google.bigtable.v2.Mutation;
import io.grpc.Metadata;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Util {
  private static final Metadata.Key<String> REQUEST_PARAMS_KEY =
      Metadata.Key.of("x-goog-request-params", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> FEATURE_FLAGS_KEY =
      Metadata.Key.of("bigtable-features", Metadata.ASCII_STRING_MARSHALLER);

  public static Metadata composeMetadata(
      FeatureFlags featureFlags, Map<String, String> headerParams) {
    Metadata metadata = new Metadata();

    // Configure FeatureFlags for RLS
    {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      try {
        featureFlags.writeTo(baos);
      } catch (IOException e) {
        throw new IllegalStateException("ByteArrayOutputStream should never throw an IOException");
      }
      String encodedFeatureFlags =
          new String(Base64.getUrlEncoder().encode(baos.toByteArray()), StandardCharsets.UTF_8);
      metadata.put(FEATURE_FLAGS_KEY, encodedFeatureFlags);
    }

    // Configure resource names for RLS
    metadata.put(
        REQUEST_PARAMS_KEY,
        headerParams.entrySet().stream()
            .map(e -> String.format("%s=%s", e.getKey(), urlEncode(e.getValue())))
            .collect(Collectors.joining("&")));

    return metadata;
  }

  public static boolean isIdempotent(List<Mutation> mutations) {
    for (Mutation mutation : mutations) {
      // aggregates are not idempotent
      if (mutation.hasAddToCell() || mutation.hasMergeToCell()) {
        return false;
      }
      // mutations with system timestamps are not idempotent
      if (mutation.hasSetCell() && mutation.getSetCell().getTimestampMicros() == -1) {
        return false;
      }
    }
    return true;
  }

  private static String urlEncode(String s) {
    try {
      return URLEncoder.encode(s, StandardCharsets.UTF_8.name());
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException("Should never happen", e);
    }
  }
}
