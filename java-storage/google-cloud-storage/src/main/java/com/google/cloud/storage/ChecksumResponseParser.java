/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storage;

import com.google.api.client.http.HttpResponse;
import com.google.cloud.storage.multipartupload.model.CompleteMultipartUploadResponse;
import com.google.cloud.storage.multipartupload.model.UploadPartResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** A utility class to parse checksums from an {@link HttpResponse}. */
final class ChecksumResponseParser {

  private static final String X_GOOG_HASH = "x-goog-hash";

  private ChecksumResponseParser() {}

  static UploadPartResponse parseUploadResponse(HttpResponse response) {
    String eTag = response.getHeaders().getETag();
    Map<String, String> hashes = extractHashesFromHeader(response);
    return UploadPartResponse.builder()
        .eTag(eTag)
        .md5(hashes.get("md5"))
        .crc32c(hashes.get("crc32c"))
        .build();
  }

  static CompleteMultipartUploadResponse parseCompleteResponse(HttpResponse response)
      throws IOException {
    Map<String, String> hashes = extractHashesFromHeader(response);
    CompleteMultipartUploadResponse completeMpuResponse =
        response.parseAs(CompleteMultipartUploadResponse.class);
    return CompleteMultipartUploadResponse.builder()
        .location(completeMpuResponse.location())
        .bucket(completeMpuResponse.bucket())
        .key(completeMpuResponse.key())
        .etag(completeMpuResponse.etag())
        .crc32c(hashes.get("crc32c"))
        .build();
  }

  static Map<String, String> extractHashesFromHeader(HttpResponse response) {
    List<String> hashHeaders = response.getHeaders().getHeaderStringValues(X_GOOG_HASH);
    if (hashHeaders == null || hashHeaders.isEmpty()) {
      return Collections.emptyMap();
    }

    return hashHeaders.stream()
        .flatMap(h -> Arrays.stream(h.split(",")))
        .map(String::trim)
        .filter(s -> !s.isEmpty())
        .map(s -> s.split("=", 2))
        .filter(a -> a.length == 2)
        .filter(a -> "crc32c".equalsIgnoreCase(a[0]) || "md5".equalsIgnoreCase(a[0]))
        .collect(Collectors.toMap(a -> a[0].toLowerCase(), a -> a[1], (v1, v2) -> v1));
  }
}
