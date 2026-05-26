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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.common.hash.Hashing;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.Test;

public class HttpStorageRpcHasherHelperTest {

  private static final byte[] CONTENT_BYTES = "Hello, World!".getBytes();
  private static final String CONTENT_CRC32C_BASE64 =
      "TVUQaA=="; // expected CRC32C of "Hello, World!"

  @Test
  public void testWrap_disabled_returnsOriginalStream() {
    ByteArrayOutputStream original = new ByteArrayOutputStream();
    OutputStream wrapped = HttpStorageRpcHasherHelper.INSTANCE.wrap(original, false);
    assertSame(original, wrapped);
  }

  @Test
  public void testWrap_enabled_returnsHashingStream() throws IOException {
    ByteArrayOutputStream original = new ByteArrayOutputStream();
    OutputStream wrapped = HttpStorageRpcHasherHelper.INSTANCE.wrap(original, true);
    assertNotEquals(original, wrapped);

    wrapped.write(CONTENT_BYTES);
    wrapped.flush();
    wrapped.close();

    byte[] writtenBytes = original.toByteArray();
    assertArrayEquals(CONTENT_BYTES, writtenBytes);
  }

  @Test
  public void testValidateCrc32c_int_expectSuccess() throws IOException {
    int calculatedCrc32c = Hashing.crc32c().hashBytes(CONTENT_BYTES).asInt();
    // Should complete cleanly without throwing
    HttpStorageRpcHasherHelper.INSTANCE.validateCrc32c(CONTENT_CRC32C_BASE64, calculatedCrc32c);
  }

  @Test
  public void testValidateCrc32c_int_expectMismatchFailure() {
    int calculatedCrc32c = 12345; // Incorrect hash
    Hasher.ChecksumMismatchException ex =
        assertThrows(
            Hasher.ChecksumMismatchException.class,
            () ->
                HttpStorageRpcHasherHelper.INSTANCE.validateCrc32c(
                    CONTENT_CRC32C_BASE64, calculatedCrc32c));
    assertTrue(ex.getMessage().contains("Mismatch checksum value"));
  }

  @Test
  public void testValidateCrc32c_byteArray_expectSuccess() throws IOException {
    // Should complete cleanly without throwing
    HttpStorageRpcHasherHelper.INSTANCE.validateCrc32c(CONTENT_CRC32C_BASE64, CONTENT_BYTES);
  }

  @Test
  public void testValidateCrc32c_byteArray_expectMismatchFailure() {
    byte[] wrongBytes = "Wrong bytes!".getBytes();
    Hasher.ChecksumMismatchException ex =
        assertThrows(
            Hasher.ChecksumMismatchException.class,
            () ->
                HttpStorageRpcHasherHelper.INSTANCE.validateCrc32c(
                    CONTENT_CRC32C_BASE64, wrongBytes));
    assertTrue(ex.getMessage().contains("Mismatch checksum value"));
  }
}
