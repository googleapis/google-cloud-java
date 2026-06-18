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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.common.hash.Hashing;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
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

  private static HttpResponse createHttpResponse(
      int statusCode, Map<String, String> headers, boolean returnRawInputStream)
      throws IOException {
    MockLowLevelHttpResponse lowLevelResponse = new MockLowLevelHttpResponse();
    lowLevelResponse.setStatusCode(statusCode);
    if (headers != null) {
      for (Map.Entry<String, String> entry : headers.entrySet()) {
        lowLevelResponse.addHeader(entry.getKey(), entry.getValue());
      }
    }
    HttpTransport transport =
        new MockHttpTransport.Builder().setLowLevelHttpResponse(lowLevelResponse).build();
    HttpRequest request =
        transport.createRequestFactory().buildGetRequest(new GenericUrl("http://example.com"));
    request.setResponseReturnRawInputStream(returnRawInputStream);
    return request.execute();
  }

  @Test
  public void testShouldValidate_successStatus200() throws IOException {
    HttpResponse response = createHttpResponse(200, null, true);
    assertTrue(HttpStorageRpcHasherHelper.INSTANCE.shouldValidate(response));
  }

  @Test
  public void testShouldValidate_successStatus206_fullContentRange() throws IOException {
    Map<String, String> headers = new HashMap<>();
    headers.put("Content-Range", "bytes 0-499/500");
    HttpResponse response = createHttpResponse(206, headers, true);

    assertTrue(HttpStorageRpcHasherHelper.INSTANCE.shouldValidate(response));
  }

  @Test
  public void testShouldValidate_successStatus206_partialContentRange() throws IOException {
    Map<String, String> headers = new HashMap<>();
    headers.put("Content-Range", "bytes 100-499/500");
    HttpResponse response = createHttpResponse(206, headers, true);

    assertFalse(HttpStorageRpcHasherHelper.INSTANCE.shouldValidate(response));
  }

  @Test
  public void testShouldValidate_transcoded_storedEncoding() throws IOException {
    Map<String, String> headers = new HashMap<>();
    headers.put("x-goog-stored-content-encoding", "gzip");
    HttpResponse response = createHttpResponse(200, headers, true);

    assertFalse(HttpStorageRpcHasherHelper.INSTANCE.shouldValidate(response));
  }

  @Test
  public void testShouldValidate_transcoded_storedLength() throws IOException {
    Map<String, String> headers = new HashMap<>();
    headers.put("x-goog-stored-content-length", "123");
    HttpResponse response = createHttpResponse(200, headers, true);

    assertFalse(HttpStorageRpcHasherHelper.INSTANCE.shouldValidate(response));
  }

  @Test
  public void testShouldValidate_decompressedByClient() throws IOException {
    Map<String, String> headers = new HashMap<>();
    headers.put("Content-Encoding", "gzip");
    HttpResponse response = createHttpResponse(200, headers, false);

    assertFalse(HttpStorageRpcHasherHelper.INSTANCE.shouldValidate(response));
  }
}
