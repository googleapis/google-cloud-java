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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.core.SettableApiFuture;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.ApiaryUnbufferedReadableByteChannel.ApiaryReadRequest;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.common.collect.ImmutableMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import org.junit.Test;

public class ApiaryUnbufferedReadableByteChannelTest {

  private static final byte[] CONTENT_BYTES = "Hello, World!".getBytes();
  private static final String CORRECT_CRC32C_BASE64 = "TVUQaA==";
  private static final String WRONG_CRC32C_BASE64 = "AAAAAA==";

  private Storage createMockStorageClient(String googHashHeader) {
    HttpTransport transport =
        new HttpTransport() {
          @Override
          protected com.google.api.client.http.LowLevelHttpRequest buildRequest(
              String method, String url) throws IOException {
            return new com.google.api.client.testing.http.MockLowLevelHttpRequest() {
              @Override
              public com.google.api.client.http.LowLevelHttpResponse execute() throws IOException {
                MockLowLevelHttpResponse lowLevelResponse =
                    new MockLowLevelHttpResponse()
                        .setContent(CONTENT_BYTES)
                        .setContentLength(CONTENT_BYTES.length)
                        .addHeader("Content-Length", String.valueOf(CONTENT_BYTES.length))
                        .addHeader("x-goog-generation", "12345");
                if (googHashHeader != null) {
                  lowLevelResponse.addHeader("x-goog-hash", googHashHeader);
                }
                return lowLevelResponse;
              }
            };
          }
        };
    return new Storage.Builder(transport, GsonFactory.getDefaultInstance(), null)
        .setApplicationName("test")
        .build();
  }

  @Test
  public void testRead_successfulCrc32cValidation() throws IOException {
    Storage storageClient = createMockStorageClient("crc32c=" + CORRECT_CRC32C_BASE64);

    StorageObject from = new StorageObject().setBucket("bucket").setName("blob");
    ApiaryReadRequest apiaryReadRequest =
        new ApiaryReadRequest(from, ImmutableMap.of(), ByteRangeSpec.nullRange());

    SettableApiFuture<StorageObject> resultFuture = SettableApiFuture.create();
    try (ApiaryUnbufferedReadableByteChannel channel =
        new ApiaryUnbufferedReadableByteChannel(
            apiaryReadRequest,
            storageClient,
            resultFuture,
            RetrierWithAlg.attemptOnce(),
            Retrying.neverRetry(),
            Hasher.defaultHasher()); ) {

      ByteArrayOutputStream out = new ByteArrayOutputStream();
      try (WritableByteChannel w = Channels.newChannel(out)) {
        ByteBuffer buf = ByteBuffer.allocate(4096);
        while (channel.read(new ByteBuffer[] {buf}, 0, 1) != -1) {
          buf.flip();
          w.write(buf);
          buf.clear();
        }
      }

      assertArrayEquals(CONTENT_BYTES, out.toByteArray());
    }
  }

  @Test
  public void testRead_mismatchedCrc32cValidation_throwsChecksumMismatch() throws IOException {
    Storage storageClient = createMockStorageClient("crc32c=" + WRONG_CRC32C_BASE64);

    StorageObject from = new StorageObject().setBucket("bucket").setName("blob");
    ApiaryReadRequest apiaryReadRequest =
        new ApiaryReadRequest(from, ImmutableMap.of(), ByteRangeSpec.nullRange());

    SettableApiFuture<StorageObject> resultFuture = SettableApiFuture.create();
    try (ApiaryUnbufferedReadableByteChannel channel =
        new ApiaryUnbufferedReadableByteChannel(
            apiaryReadRequest,
            storageClient,
            resultFuture,
            RetrierWithAlg.attemptOnce(),
            Retrying.neverRetry(),
            Hasher.defaultHasher()); ) {

      ByteBuffer buf = ByteBuffer.allocate(4096);
      IOException expected =
          assertThrows(
              IOException.class,
              () -> {
                while (channel.read(new ByteBuffer[] {buf}, 0, 1) != -1) {
                  buf.clear();
                }
              });

      assertTrue(expected instanceof Hasher.ChecksumMismatchException);
      assertTrue(expected.getMessage().contains("Mismatch checksum value"));
    }
  }
}
