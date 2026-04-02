/*
 * Copyright 2017 Google LLC
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Canonical extension header serializer.
 *
 * @see <a href=
 *     "https://cloud.google.com/storage/docs/access-control/signed-urls#about-canonical-extension-headers">
 *     Canonical Extension Headers</a>
 */
public class CanonicalExtensionHeadersSerializer {

  private static final char HEADER_SEPARATOR = ':';
  private static final char HEADER_NAME_SEPARATOR = ';';

  private final Storage.SignUrlOption.SignatureVersion signatureVersion;

  public CanonicalExtensionHeadersSerializer(
      Storage.SignUrlOption.SignatureVersion signatureVersion) {
    this.signatureVersion = signatureVersion;
  }

  public CanonicalExtensionHeadersSerializer() {
    // TODO switch this when V4 becomes default
    this.signatureVersion = Storage.SignUrlOption.SignatureVersion.V2;
  }

  public StringBuilder serialize(Map<String, String> canonicalizedExtensionHeaders) {

    StringBuilder serializedHeaders = new StringBuilder();

    if (canonicalizedExtensionHeaders == null || canonicalizedExtensionHeaders.isEmpty()) {
      return serializedHeaders;
    }

    Map<String, String> lowercaseHeaders = getLowercaseHeaders(canonicalizedExtensionHeaders);

    // Sort all custom headers by header name using a lexicographical sort by code point value.
    List<String> sortedHeaderNames = new ArrayList<>(lowercaseHeaders.keySet());
    Collections.sort(sortedHeaderNames);

    for (String headerName : sortedHeaderNames) {
      serializedHeaders
          .append(headerName)
          .append(HEADER_SEPARATOR)
          .append(
              lowercaseHeaders
                  .get(headerName)
                  // Remove any whitespace around the colon that appears after the header name.
                  .trim()
                  // Replace any sequence of whitespace with a single space.
                  .replaceAll("\\s+", " "))
          // Append a newline (U+000A) to each custom header.
          .append(SignatureInfo.COMPONENT_SEPARATOR);
    }

    // Concatenate all custom headers
    return serializedHeaders;
  }

  public StringBuilder serializeHeaderNames(Map<String, String> canonicalizedExtensionHeaders) {
    StringBuilder serializedHeaders = new StringBuilder();

    if (canonicalizedExtensionHeaders == null || canonicalizedExtensionHeaders.isEmpty()) {
      return serializedHeaders;
    }
    Map<String, String> lowercaseHeaders = getLowercaseHeaders(canonicalizedExtensionHeaders);

    List<String> sortedHeaderNames = new ArrayList<>(lowercaseHeaders.keySet());
    Collections.sort(sortedHeaderNames);

    for (String headerName : sortedHeaderNames) {
      serializedHeaders.append(headerName).append(HEADER_NAME_SEPARATOR);
    }

    serializedHeaders.setLength(serializedHeaders.length() - 1); // remove trailing semicolon

    return serializedHeaders;
  }

  private Map<String, String> getLowercaseHeaders(
      Map<String, String> canonicalizedExtensionHeaders) {
    // Make all custom header names lowercase.
    Map<String, String> lowercaseHeaders = new HashMap<>();
    for (String headerName : new ArrayList<>(canonicalizedExtensionHeaders.keySet())) {

      String lowercaseHeaderName = headerName.toLowerCase();

      // If present and we're V2, remove the x-goog-encryption-key and x-goog-encryption-key-sha256
      // headers. (CSEK headers are allowed for V4)
      if (Storage.SignUrlOption.SignatureVersion.V2.equals(signatureVersion)
          && ("x-goog-encryption-key".equals(lowercaseHeaderName)
              || "x-goog-encryption-key-sha256".equals(lowercaseHeaderName))) {

        continue;
      }

      lowercaseHeaders.put(lowercaseHeaderName, canonicalizedExtensionHeaders.get(headerName));
    }

    return lowercaseHeaders;
  }
}
