/*
 * Copyright 2021 Google LLC. All Rights Reserved.
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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** This class provides End-to-End Checksum API for http protocol. */
class EndToEndChecksumHandler {
  /** The checksum http header on http requests */
  static final String HTTP_REQUEST_CHECKSUM_HEADER = "x-request-checksum-348659783";
  /** The checksum http header on http responses */
  static final String HTTP_RESPONSE_CHECKSUM_HEADER = "x-response-checksum-348659783";
  /** Algorithm used for checksum */
  private static final String MD5 = "MD5";

  /**
   * Create and return checksum as a string value for the input 'bytes'.
   *
   * @param bytes raw message for which the checksum is being computed
   * @return computed checksum as a hex string
   * @throws RuntimeException if MD5 Algorithm is not found in the VM
   */
  static String computeChecksum(byte[] bytes) {
    if (bytes == null || (bytes.length == 0)) {
      return null;
    }
    return com.google.common.io.BaseEncoding.base16().encode(
        getMessageDigestInstance().digest(bytes));
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
        && checksum.equalsIgnoreCase(computeChecksum(bytes));
  }

  static MessageDigest getMessageDigestInstance() {
    try {
      return MessageDigest.getInstance(MD5);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("MD5 algorithm is not found when computing checksum!");
    }
  }

  static boolean hasChecksumHeader(HttpResponse response) {
    String checksum = getChecksumHeader(response);
    return checksum != null && !checksum.isEmpty();
  }

  static String getChecksumHeader(HttpResponse response) {
    return response.getHeaders().getFirstHeaderStringValue(HTTP_RESPONSE_CHECKSUM_HEADER);
  }
}
