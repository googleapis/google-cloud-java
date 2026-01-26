/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.v1.client;

import com.google.api.client.http.HttpResponse;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

/** This class provides End-to-End Checksum API for http protocol. */
class EndToEndChecksumHandler {
  /** The checksum http header on http requests */
  static final String HTTP_REQUEST_CHECKSUM_HEADER = "x-request-checksum-348659783";

  /** The checksum http header on http responses */
  static final String HTTP_RESPONSE_CHECKSUM_HEADER = "x-response-checksum-348659783";

  final Hasher hasher = EndToEndChecksumHandler.getNewCrc32cHasher();

  /**
   * Create and return checksum as a string value for the input 'bytes'.
   *
   * @param bytes raw message for which the checksum is being computed
   * @return computed checksum as a hex string
   */
  static String computeChecksum(byte[] bytes) {
    if (bytes == null || (bytes.length == 0)) {
      return null;
    }
    HashCode hc = getNewCrc32cHasher().putBytes(bytes).hash();
    return hashToString(hc);
  }

  private static String hashToString(HashCode hc) {
    return String.valueOf(Integer.toUnsignedLong(hc.asInt()));
  }

  private static Hasher getNewCrc32cHasher() {
    return Hashing.crc32c().newHasher();
  }

  /**
   * Validates the checksum for the given input 'bytes' and returns true if valid, false otherwise.
   *
   * @param checksum the checksum as a hex string
   * @param bytes the raw message for which the checksum was sent
   * @return {@code true} if input checksum is valid for the input bytes; {@code false} otherwise
   */
  static boolean validateChecksum(String checksum, byte[] bytes) {
    return checksum != null
        && !checksum.isEmpty()
        && bytes != null
        && bytes.length > 0
        && checksum.equals(computeChecksum(bytes));
  }

  static boolean hasChecksumHeader(HttpResponse response) {
    String checksum = getChecksumHeader(response);
    return checksum != null && !checksum.isEmpty();
  }

  static String getChecksumHeader(HttpResponse response) {
    return response.getHeaders().getFirstHeaderStringValue(HTTP_RESPONSE_CHECKSUM_HEADER);
  }

  void update(byte[] bytes, int off, int len) {
    hasher.putBytes(bytes, off, len);
  }

  String hash() {
    return hashToString(hasher.hash());
  }
}
