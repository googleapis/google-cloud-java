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

package com.google.cloud.storage.spi.v1;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.cloud.NoCredentials;
import com.google.cloud.TransportOptions;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.BaseEncoding;
import com.google.common.primitives.Ints;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import org.junit.Test;

public final class HttpStorageRpcChecksumTest {

  private static final String BUCKET = "test-bucket";
  private static final String BLOB = "test-blob";
  private static final byte[] CONTENT =
      "hello world checksum test".getBytes(StandardCharsets.UTF_8);

  private static final int CONTENT_CRC32C_VAL =
      com.google.common.hash.Hashing.crc32c().hashBytes(CONTENT).asInt();
  private static final String CONTENT_CRC32C_BASE64 =
      BaseEncoding.base64().encode(Ints.toByteArray(CONTENT_CRC32C_VAL));

  private static final String BAD_CRC32C_BASE64 =
      BaseEncoding.base64().encode(Ints.toByteArray(999999));

  @Test
  public void testReadAllBytes_successfulCrc32cValidation() throws Exception {
    MockLowLevelHttpResponse response =
        new MockLowLevelHttpResponse()
            .setContentType("application/octet-stream")
            .setHeaderNames(ImmutableList.of("x-goog-hash"))
            .setHeaderValues(ImmutableList.of("crc32c=" + CONTENT_CRC32C_BASE64))
            .setContent(new String(CONTENT, StandardCharsets.UTF_8))
            .setStatusCode(200);

    try (Storage storage = createMockStorage(response)) {
      byte[] bytes = storage.readAllBytes(BlobId.of(BUCKET, BLOB));
      assertThat(bytes).isEqualTo(CONTENT);
    }
  }

  @Test
  public void testReadAllBytes_failedCrc32cValidation() throws Exception {
    MockLowLevelHttpResponse response =
        new MockLowLevelHttpResponse()
            .setContentType("application/octet-stream")
            .setHeaderNames(ImmutableList.of("x-goog-hash"))
            .setHeaderValues(ImmutableList.of("crc32c=" + BAD_CRC32C_BASE64))
            .setContent(new String(CONTENT, StandardCharsets.UTF_8))
            .setStatusCode(200);

    try (Storage storage = createMockStorage(response)) {
      StorageException ex =
          assertThrows(
              StorageException.class,
              () -> {
                storage.readAllBytes(BlobId.of(BUCKET, BLOB));
              });
      assertThat(ex.getMessage()).contains("Mismatch checksum value");
      assertThat(ex.getCause().getMessage()).contains("Mismatch checksum value");
    }
  }

  @Test
  public void testDownloadTo_successfulCrc32cValidation() throws Exception {
    MockLowLevelHttpResponse response =
        new MockLowLevelHttpResponse()
            .setContentType("application/octet-stream")
            .setHeaderNames(ImmutableList.of("x-goog-hash"))
            .setHeaderValues(ImmutableList.of("crc32c=" + CONTENT_CRC32C_BASE64))
            .setContent(new String(CONTENT, StandardCharsets.UTF_8))
            .setStatusCode(200);

    try (Storage storage = createMockStorage(response)) {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      storage.downloadTo(BlobId.of(BUCKET, BLOB), out);
      assertThat(out.toByteArray()).isEqualTo(CONTENT);
    }
  }

  @Test
  public void testDownloadTo_failedCrc32cValidation() throws Exception {
    MockLowLevelHttpResponse response =
        new MockLowLevelHttpResponse()
            .setContentType("application/octet-stream")
            .setHeaderNames(ImmutableList.of("x-goog-hash"))
            .setHeaderValues(ImmutableList.of("crc32c=" + BAD_CRC32C_BASE64))
            .setContent(new String(CONTENT, StandardCharsets.UTF_8))
            .setStatusCode(200);

    try (Storage storage = createMockStorage(response)) {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      StorageException ex =
          assertThrows(
              StorageException.class,
              () -> {
                storage.downloadTo(BlobId.of(BUCKET, BLOB), out);
              });
      assertThat(ex.getMessage()).contains("Mismatch checksum value");
      assertThat(ex.getCause().getMessage()).contains("Mismatch checksum value");
    }
  }

  @Test
  public void testReadAllBytes_noChecksumHeader_expectSuccess() throws Exception {
    MockLowLevelHttpResponse response =
        new MockLowLevelHttpResponse()
            .setContentType("application/octet-stream")
            .setContent(new String(CONTENT, StandardCharsets.UTF_8))
            .setStatusCode(200);

    try (Storage storage = createMockStorage(response)) {
      byte[] bytes = storage.readAllBytes(BlobId.of(BUCKET, BLOB));
      assertThat(bytes).isEqualTo(CONTENT);
    }
  }

  @Test
  public void testDownloadTo_noChecksumHeader_expectSuccess() throws Exception {
    MockLowLevelHttpResponse response =
        new MockLowLevelHttpResponse()
            .setContentType("application/octet-stream")
            .setContent(new String(CONTENT, StandardCharsets.UTF_8))
            .setStatusCode(200);

    try (Storage storage = createMockStorage(response)) {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      storage.downloadTo(BlobId.of(BUCKET, BLOB), out);
      assertThat(out.toByteArray()).isEqualTo(CONTENT);
    }
  }

  @Test
  public void testRead_rangeZeroToFullLength_successfulCrc32cValidation() throws Exception {
    MockLowLevelHttpResponse response =
        new MockLowLevelHttpResponse()
            .setContentType("application/octet-stream")
            .setHeaderNames(ImmutableList.of("x-goog-hash", "Content-Range"))
            .setHeaderValues(
                ImmutableList.of(
                    "crc32c=" + CONTENT_CRC32C_BASE64,
                    "bytes 0-" + (CONTENT.length - 1) + "/" + CONTENT.length))
            .setContent(new String(CONTENT, StandardCharsets.UTF_8))
            .setStatusCode(206);

    HttpStorageRpc rpc = createMockRpc(response);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    com.google.api.services.storage.model.StorageObject pb =
        new com.google.api.services.storage.model.StorageObject().setBucket(BUCKET).setName(BLOB);

    ImmutableMap<StorageRpc.Option, ?> options =
        ImmutableMap.of(
            StorageRpc.Option.EXTRA_HEADERS,
            ImmutableMap.of("Range", "bytes=0-" + (CONTENT.length - 1)));

    rpc.read(pb, options, 0, out);
    assertThat(out.toByteArray()).isEqualTo(CONTENT);
  }

  @Test
  public void testRead_rangeZeroToFullLength_failedCrc32cValidation() throws Exception {
    MockLowLevelHttpResponse response =
        new MockLowLevelHttpResponse()
            .setContentType("application/octet-stream")
            .setHeaderNames(ImmutableList.of("x-goog-hash", "Content-Range"))
            .setHeaderValues(
                ImmutableList.of(
                    "crc32c=" + BAD_CRC32C_BASE64,
                    "bytes 0-" + (CONTENT.length - 1) + "/" + CONTENT.length))
            .setContent(new String(CONTENT, StandardCharsets.UTF_8))
            .setStatusCode(206);

    HttpStorageRpc rpc = createMockRpc(response);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    com.google.api.services.storage.model.StorageObject pb =
        new com.google.api.services.storage.model.StorageObject().setBucket(BUCKET).setName(BLOB);

    ImmutableMap<StorageRpc.Option, ?> options =
        ImmutableMap.of(
            StorageRpc.Option.EXTRA_HEADERS,
            ImmutableMap.of("Range", "bytes=0-" + (CONTENT.length - 1)));

    StorageException ex =
        assertThrows(
            StorageException.class,
            () -> {
              rpc.read(pb, options, 0, out);
            });
    assertThat(ex.getMessage()).contains("Mismatch checksum value");
    assertThat(ex.getCause().getMessage()).contains("Mismatch checksum value");
  }

  @Test
  public void testRead_partialRange_skipsCrc32cValidation() throws Exception {
    byte[] partialContent = "hello".getBytes(StandardCharsets.UTF_8);
    MockLowLevelHttpResponse response =
        new MockLowLevelHttpResponse()
            .setContentType("application/octet-stream")
            .setHeaderNames(ImmutableList.of("x-goog-hash", "Content-Range"))
            .setHeaderValues(
                ImmutableList.of("crc32c=" + BAD_CRC32C_BASE64, "bytes 0-4/" + CONTENT.length))
            .setContent(new String(partialContent, StandardCharsets.UTF_8))
            .setStatusCode(206);

    HttpStorageRpc rpc = createMockRpc(response);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    com.google.api.services.storage.model.StorageObject pb =
        new com.google.api.services.storage.model.StorageObject().setBucket(BUCKET).setName(BLOB);

    ImmutableMap<StorageRpc.Option, ?> options =
        ImmutableMap.of(StorageRpc.Option.EXTRA_HEADERS, ImmutableMap.of("Range", "bytes=0-4"));

    rpc.read(pb, options, 0, out);
    assertThat(out.toByteArray()).isEqualTo(partialContent);
  }

  @Test
  public void testRead_rangeSuffixFullLength_successfulCrc32cValidation() throws Exception {
    MockLowLevelHttpResponse response =
        new MockLowLevelHttpResponse()
            .setContentType("application/octet-stream")
            .setHeaderNames(ImmutableList.of("x-goog-hash", "Content-Range"))
            .setHeaderValues(
                ImmutableList.of(
                    "crc32c=" + CONTENT_CRC32C_BASE64,
                    "bytes 0-" + (CONTENT.length - 1) + "/" + CONTENT.length))
            .setContent(new String(CONTENT, StandardCharsets.UTF_8))
            .setStatusCode(206);

    HttpStorageRpc rpc = createMockRpc(response);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    com.google.api.services.storage.model.StorageObject pb =
        new com.google.api.services.storage.model.StorageObject().setBucket(BUCKET).setName(BLOB);

    ImmutableMap<StorageRpc.Option, ?> options =
        ImmutableMap.of(
            StorageRpc.Option.EXTRA_HEADERS, ImmutableMap.of("Range", "bytes=-" + CONTENT.length));

    rpc.read(pb, options, 0, out);
    assertThat(out.toByteArray()).isEqualTo(CONTENT);
  }

  @Test
  public void testRead_rangeSuffixFullLength_failedCrc32cValidation() throws Exception {
    MockLowLevelHttpResponse response =
        new MockLowLevelHttpResponse()
            .setContentType("application/octet-stream")
            .setHeaderNames(ImmutableList.of("x-goog-hash", "Content-Range"))
            .setHeaderValues(
                ImmutableList.of(
                    "crc32c=" + BAD_CRC32C_BASE64,
                    "bytes 0-" + (CONTENT.length - 1) + "/" + CONTENT.length))
            .setContent(new String(CONTENT, StandardCharsets.UTF_8))
            .setStatusCode(206);

    HttpStorageRpc rpc = createMockRpc(response);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    com.google.api.services.storage.model.StorageObject pb =
        new com.google.api.services.storage.model.StorageObject().setBucket(BUCKET).setName(BLOB);

    ImmutableMap<StorageRpc.Option, ?> options =
        ImmutableMap.of(
            StorageRpc.Option.EXTRA_HEADERS, ImmutableMap.of("Range", "bytes=-" + CONTENT.length));

    StorageException ex =
        assertThrows(
            StorageException.class,
            () -> {
              rpc.read(pb, options, 0, out);
            });
    assertThat(ex.getMessage()).contains("Mismatch checksum value");
    assertThat(ex.getCause().getMessage()).contains("Mismatch checksum value");
  }

  private HttpStorageRpc createMockRpc(MockLowLevelHttpResponse response) {
    AuditingHttpTransport transport = new AuditingHttpTransport(response);
    TransportOptions transportOptions =
        HttpTransportOptions.newBuilder().setHttpTransportFactory(() -> transport).build();
    StorageOptions options =
        StorageOptions.getDefaultInstance().toBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setTransportOptions(transportOptions)
            .build();
    return new HttpStorageRpc(options);
  }

  private Storage createMockStorage(MockLowLevelHttpResponse response) {
    AuditingHttpTransport transport = new AuditingHttpTransport(response);
    TransportOptions transportOptions =
        HttpTransportOptions.newBuilder().setHttpTransportFactory(() -> transport).build();
    return StorageOptions.getDefaultInstance().toBuilder()
        .setProjectId("test-project")
        .setCredentials(NoCredentials.getInstance())
        .setTransportOptions(transportOptions)
        .build()
        .getService();
  }
}
