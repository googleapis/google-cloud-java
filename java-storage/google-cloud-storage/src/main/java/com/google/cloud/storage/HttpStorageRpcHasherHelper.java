/*
 * Copyright 2026 Google LLC
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
import com.google.api.core.InternalApi;
import com.google.common.hash.Hashing;
import com.google.common.hash.HashingOutputStream;
import com.google.common.io.BaseEncoding;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Internal utility class to perform client-side CRC32C checksum validation on downloaded data
 * specifically for the {@code HttpStorageRpc} transport layer.
 */
@InternalApi
public final class HttpStorageRpcHasherHelper {

  public static final HttpStorageRpcHasherHelper INSTANCE = new HttpStorageRpcHasherHelper();

  private final Hasher hasher;

  private HttpStorageRpcHasherHelper() {
    hasher = Hasher.defaultHasher();
  }

  /**
   * Returns a wrapping output stream that hashes the written content if validation is enabled, or
   * the original output stream otherwise.
   */
  @SuppressWarnings("UnstableApiUsage")
  public OutputStream wrap(OutputStream out, boolean isChecksumValidationEnabled) {
    boolean isHasherEnabled = !(hasher instanceof Hasher.NoOpHasher);
    return (isChecksumValidationEnabled && isHasherEnabled)
        ? new HashingOutputStream(Hashing.crc32c(), out)
        : out;
  }

  /**
   * Validates a raw byte array against GCS's expected base64-encoded value in response headers.
   *
   * @throws IOException if the checksums do not match.
   */
  public void validate(HttpResponse response, byte[] content) throws IOException {
    if (isTranscoded(response) || !isFullObjectResponse(response)) {
      return;
    }
    Map<String, String> hashes = ChecksumResponseParser.extractHashesFromHeader(response);
    String expectedCrc32cBase64 = hashes.get("crc32c");
    if (expectedCrc32cBase64 != null) {
      validateCrc32c(expectedCrc32cBase64, content);
    }
  }

  /**
   * Validates the downloaded output stream against GCS's expected base64-encoded value in response
   * headers.
   *
   * @throws IOException if the checksums do not match.
   */
  @SuppressWarnings("UnstableApiUsage")
  public void validate(HttpResponse response, OutputStream activeStream) throws IOException {
    if (isTranscoded(response) || !isFullObjectResponse(response)) {
      return;
    }
    if (activeStream instanceof HashingOutputStream) {
      HashingOutputStream targetStream = (HashingOutputStream) activeStream;

      Map<String, String> hashes = ChecksumResponseParser.extractHashesFromHeader(response);
      String expectedCrc32cBase64 = hashes.get("crc32c");
      if (expectedCrc32cBase64 != null) {
        validateCrc32c(expectedCrc32cBase64, targetStream.hash().asInt());
      }
    }
  }

  public static boolean isRangeZeroOrNull(String rangeHeader) {
    if (rangeHeader == null) {
      return true;
    }
    String trimmed = rangeHeader.trim();
    if (trimmed.startsWith("bytes=")) {
      String range = trimmed.substring(6).trim();
      return range.startsWith("0-");
    }
    return false;
  }

  private static boolean isFullObjectResponse(HttpResponse response) {
    int statusCode = response.getStatusCode();
    if (statusCode == 200) {
      return true;
    }
    if (statusCode == 206) {
      String contentRange = response.getHeaders().getContentRange();
      if (contentRange != null) {
        try {
          HttpContentRange parsedRange = HttpContentRange.parse(contentRange);
          if (parsedRange instanceof HttpContentRange.Total) {
            HttpContentRange.Total totalRange = (HttpContentRange.Total) parsedRange;
            return totalRange.range().beginOffset() == 0
                && totalRange.range().endOffsetInclusive() + 1 == totalRange.getSize();
          }
        } catch (Exception e) {
          // Ignore and return false
        }
      }
    }
    return false;
  }

  private boolean isTranscoded(HttpResponse response) {
    com.google.api.client.http.HttpHeaders headers = response.getHeaders();
    String storedEncoding =
        HttpClientContext.firstHeaderValue(headers, "x-goog-stored-content-encoding");
    String storedLength =
        HttpClientContext.firstHeaderValue(headers, "x-goog-stored-content-length");
    return storedEncoding != null || storedLength != null || isDecompressedByClient(response);
  }

  private boolean isDecompressedByClient(HttpResponse response) {
    boolean returnRaw = response.getRequest().getResponseReturnRawInputStream();
    if (!returnRaw) {
      String encoding = response.getHeaders().getContentEncoding();
      return encoding != null && encoding.contains("gzip");
    }
    return false;
  }

  /**
   * Validates a calculated CRC32C value against GCS's expected base64-encoded value.
   *
   * @throws IOException if the checksums do not match.
   */
  public void validateCrc32c(String expectedCrc32cBase64, int calculatedCrc32c) throws IOException {
    if (expectedCrc32cBase64 == null) {
      return;
    }
    byte[] decoded = BaseEncoding.base64().decode(expectedCrc32cBase64);
    int expectedVal = Ints.fromByteArray(decoded);

    Crc32cValue<?> expected = Crc32cValue.of(expectedVal, 0);
    Crc32cValue.Crc32cLengthKnown actual = Crc32cValue.of(calculatedCrc32c, 0);

    hasher.validate(expected, actual);
  }

  /**
   * Validates a downloaded raw byte array against GCS's expected base64-encoded value.
   *
   * @throws IOException if the checksums do not match.
   */
  public void validateCrc32c(String expectedCrc32cBase64, byte[] content) throws IOException {
    if (expectedCrc32cBase64 == null) {
      return;
    }
    byte[] decoded = BaseEncoding.base64().decode(expectedCrc32cBase64);
    int expectedVal = Ints.fromByteArray(decoded);

    Crc32cValue<?> expected = Crc32cValue.of(expectedVal, 0);
    hasher.validate(
        expected,
        new Supplier<ByteBuffer>() {
          @Override
          public ByteBuffer get() {
            return ByteBuffer.wrap(content);
          }
        });
  }
}
