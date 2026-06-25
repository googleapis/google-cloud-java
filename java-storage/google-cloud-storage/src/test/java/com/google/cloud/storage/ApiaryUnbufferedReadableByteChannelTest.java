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

import static com.google.common.truth.Truth.assertThat;
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
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.UnbufferedReadableByteChannelSession.UnbufferedReadableByteChannel;
import com.google.cloud.storage.spi.v1.AuditingHttpTransport;
import com.google.common.collect.ImmutableMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.junit.Test;

public final class ApiaryUnbufferedReadableByteChannelTest {

  private static final byte[] CONTENT_BYTES = "Hello, World!".getBytes();
  private static final String CORRECT_CRC32C_BASE64 = "TVUQaA==";
  private static final String WRONG_CRC32C_BASE64 = "AAAAAA==";

  private Storage createMockStorageClient(String googHashHeader) {
    return createMockStorageClient(200, googHashHeader, null);
  }

  private Storage createMockStorageClient(
      int statusCode, String googHashHeader, Map<String, String> extraHeaders) {
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
                        .setStatusCode(statusCode)
                        .setContent(CONTENT_BYTES)
                        .setContentLength(CONTENT_BYTES.length)
                        .addHeader("Content-Length", String.valueOf(CONTENT_BYTES.length))
                        .addHeader("x-goog-generation", "12345");
                if (googHashHeader != null) {
                  lowLevelResponse.addHeader("x-goog-hash", googHashHeader);
                }
                if (extraHeaders != null) {
                  for (Map.Entry<String, String> entry : extraHeaders.entrySet()) {
                    lowLevelResponse.addHeader(entry.getKey(), entry.getValue());
                  }
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
      Hasher.ChecksumMismatchException expected =
          assertThrows(
              Hasher.ChecksumMismatchException.class,
              () -> {
                while (channel.read(new ByteBuffer[] {buf}, 0, 1) != -1) {
                  buf.clear();
                }
              });

      assertTrue(expected.getMessage().contains("Mismatch checksum value"));
    }
  }

  @Test
  public void testRead_suffixRangeFullObjectCrc32cValidation() throws IOException {
    // Suffix range request resulting in content-range: bytes 0-12/13
    Map<String, String> extraHeaders = ImmutableMap.of("Content-Range", "bytes 0-12/13");
    Storage storageClient =
        createMockStorageClient(206, "crc32c=" + CORRECT_CRC32C_BASE64, extraHeaders);

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
  public void testRead_partialRangeNoCrc32cValidation() throws IOException {
    // Partial range request resulting in content-range: bytes 1-12/13
    Map<String, String> extraHeaders = ImmutableMap.of("Content-Range", "bytes 1-12/13");
    // Even if checksum is wrong, it shouldn't throw ChecksumMismatchException because validation is
    // skipped for partial downloads.
    Storage storageClient =
        createMockStorageClient(206, "crc32c=" + WRONG_CRC32C_BASE64, extraHeaders);

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

      // We read the entire response content successfully (no exception thrown)
      assertArrayEquals(CONTENT_BYTES, out.toByteArray());
    }
  }

  @Test
  public void logsWarning_whenReceivingMoreBytesThanRequested() throws IOException {
    byte[] content = "0123456789extra_bytes".getBytes();
    MockLowLevelHttpResponse response =
        new MockLowLevelHttpResponse()
            .setContentType("application/octet-stream")
            .setContent(content)
            .setStatusCode(200);

    AuditingHttpTransport transport = new AuditingHttpTransport(response);
    Storage storage =
        new Storage.Builder(transport, GsonFactory.getDefaultInstance(), null).build();

    StorageObject storageObject = new StorageObject().setBucket("bucket").setName("object");
    // Explicit range request for 10 bytes
    ByteRangeSpec byteRangeSpec = ByteRangeSpec.relativeLength(0L, 10L);
    ApiaryReadRequest apiaryReadRequest =
        new ApiaryReadRequest(storageObject, ImmutableMap.of(), byteRangeSpec);

    Logger logger = Logger.getLogger(ApiaryUnbufferedReadableByteChannel.class.getName());
    List<LogRecord> records = new ArrayList<>();
    Handler handler =
        new Handler() {
          @Override
          public void publish(LogRecord record) {
            records.add(record);
          }

          @Override
          public void flush() {}

          @Override
          public void close() throws SecurityException {}
        };
    logger.addHandler(handler);

    try {
      try (UnbufferedReadableByteChannel c =
          new ApiaryUnbufferedReadableByteChannel(
              apiaryReadRequest,
              storage,
              SettableApiFuture.<StorageObject>create(),
              Retrier.attemptOnce(),
              Retrying.neverRetry(),
              Hasher.defaultHasher())) {
        ByteBuffer dst = ByteBuffer.allocate(25);
        c.read(dst);
      }

      boolean warningLogged =
          records.stream().anyMatch(r -> r.getMessage().contains("more bytes than requested"));
      assertThat(warningLogged).isTrue();
    } finally {
      logger.removeHandler(handler);
    }
  }
}
