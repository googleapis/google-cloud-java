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
import com.google.common.io.BaseEncoding;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Internal utility class to perform client-side CRC32C checksum validation on downloaded data
 * specifically for the {@code HttpStorageRpc} transport layer.
 *
 * <p>Since this class resides in the {@code com.google.cloud.storage} package, it has full,
 * package-private compile-time access to internal components (like {@link Hasher} and {@link
 * Crc32cValue}) without leaking GCS internal types into public client API surfaces.
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
  public OutputStream wrap(OutputStream out, boolean isChecksumValidationEnabled) {
    boolean isHasherEnabled = !(hasher instanceof Hasher.NoOpHasher);
    return (isChecksumValidationEnabled && isHasherEnabled)
        ? new Crc32cHashingOutputStream(out)
        : out;
  }

  /**
   * Validates a raw byte array against GCS's expected base64-encoded value in response headers.
   *
   * @throws IOException if the checksums do not match.
   */
  public void validate(HttpResponse response, byte[] content) throws IOException {
    Map<String, String> hashes = extractHashesFromHeader(response);
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
  public void validate(HttpResponse response, OutputStream activeStream) throws IOException {
    if (activeStream instanceof Crc32cHashingOutputStream) {
      Crc32cHashingOutputStream targetStream = (Crc32cHashingOutputStream) activeStream;
      Map<String, String> hashes = extractHashesFromHeader(response);
      String expectedCrc32cBase64 = hashes.get("crc32c");
      if (expectedCrc32cBase64 != null) {
        validateCrc32c(expectedCrc32cBase64, targetStream.hash());
      }
    }
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

  @SuppressWarnings("UnstableApiUsage")
  private static class Crc32cHashingOutputStream extends java.io.FilterOutputStream {
    private final com.google.common.hash.Hasher hasher;

    Crc32cHashingOutputStream(OutputStream out) {
      super(out);
      this.hasher = com.google.common.hash.Hashing.crc32c().newHasher();
    }

    @Override
    public void write(int b) throws IOException {
      out.write(b);
      hasher.putByte((byte) b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
      out.write(b, off, len);
      hasher.putBytes(b, off, len);
    }

    int hash() {
      return hasher.hash().asInt();
    }
  }

  private static Map<String, String> extractHashesFromHeader(HttpResponse response) {
    List<String> hashHeaders = response.getHeaders().getHeaderStringValues("x-goog-hash");
    if (hashHeaders == null || hashHeaders.isEmpty()) {
      return java.util.Collections.emptyMap();
    }

    return hashHeaders.stream()
        .flatMap(h -> java.util.Arrays.stream(h.split(",")))
        .map(String::trim)
        .filter(s -> !s.isEmpty())
        .map(s -> s.split("=", 2))
        .filter(a -> a.length == 2)
        .filter(a -> "crc32c".equalsIgnoreCase(a[0]) || "md5".equalsIgnoreCase(a[0]))
        .collect(
            java.util.stream.Collectors.toMap(a -> a[0].toLowerCase(), a -> a[1], (v1, v2) -> v1));
  }
}
