/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage.it;

import static com.google.cloud.storage.PackagePrivateMethodWorkarounds.getBlobInfoFromReadChannelFunction;
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.TestUtils.gzipBytes;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.cloud.ReadChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.it.runner.registry.ObjectsFixture;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = Backend.PROD,
    transports = {Transport.HTTP, Transport.GRPC})
public final class ITStorageReadChannelTest {

  @Inject public Storage storage;

  @Inject public BucketInfo bucket;

  @Inject public Generator generator;

  @Inject public ObjectsFixture objectsFixture;

  @Test
  public void storageReadChannel_getObject_returns() throws Exception {
    int _512KiB = 512 * 1024;
    int _1MiB = 1024 * 1024;

    final BlobInfo info;
    ChecksummedTestContent content;
    {
      byte[] uncompressedBytes = DataGenerator.base64Characters().genBytes(_512KiB);
      byte[] gzipBytes = gzipBytes(uncompressedBytes);
      content = ChecksummedTestContent.of(gzipBytes);
      BlobInfo tmp =
          BlobInfo.newBuilder(bucket, generator.randomObjectName())
              // define an object with explicit content type and encoding.
              // JSON and gRPC have differing default behavior returning these values if they are
              // either undefined, or match HTTP defaults.
              .setContentType("text/plain")
              .setContentEncoding("gzip")
              .build();

      Blob gen1 = storage.create(tmp, content.getBytes(), BlobTargetOption.doesNotExist());
      info = gen1.asBlobInfo();
    }

    try (ReadChannel c =
        storage.reader(info.getBlobId(), BlobSourceOption.shouldReturnRawInputStream(true))) {

      ApiFuture<BlobInfo> infoFuture = getBlobInfoFromReadChannelFunction(c);

      ByteBuffer buf = ByteBuffer.allocate(_1MiB);
      c.read(buf);
      String actual = xxd(buf);
      String expected = xxd(content.getBytes());
      assertThat(actual).isEqualTo(expected);

      BlobInfo blobInfo = infoFuture.get(3, TimeUnit.SECONDS);
      assertAll(
          () -> equalForField(blobInfo, info, BlobInfo::getName),
          () -> equalForField(blobInfo, info, BlobInfo::getBucket),
          () -> equalForField(blobInfo, info, BlobInfo::getGeneration),
          () -> equalForField(blobInfo, info, BlobInfo::getMetageneration),
          () -> equalForField(blobInfo, info, BlobInfo::getSize),
          () -> equalForField(blobInfo, info, BlobInfo::getContentType),
          () -> equalForField(blobInfo, info, BlobInfo::getContentEncoding));
    }
  }

  @Test
  public void storageReadChannel_shouldAllowDisablingBufferingBySettingChunkSize_lteq0()
      throws Exception {
    int _512KiB = 512 * 1024;
    int _1MiB = 1024 * 1024;

    final BlobInfo info;
    byte[] uncompressedBytes = DataGenerator.base64Characters().genBytes(_512KiB);
    {
      BlobInfo tmp = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
      Blob gen1 = storage.create(tmp, uncompressedBytes, BlobTargetOption.doesNotExist());
      info = gen1.asBlobInfo();
    }

    try (ReadChannel c = storage.reader(info.getBlobId())) {
      ApiFuture<BlobInfo> infoFuture = getBlobInfoFromReadChannelFunction(c);
      c.setChunkSize(0);

      ByteBuffer buf = ByteBuffer.allocate(_1MiB);
      // Because this is unbuffered, the underlying channel will not necessarily fill up the buf
      // in a single read call. Repeatedly read until full or EOF.
      int read = fillFrom(buf, c);
      assertThat(read).isEqualTo(_512KiB);
      String actual = xxd(buf);
      String expected = xxd(uncompressedBytes);
      assertThat(actual).isEqualTo(expected);
      BlobInfo blobInfo = infoFuture.get(3, TimeUnit.SECONDS);
      assertThat(blobInfo.getBlobId()).isEqualTo(info.getBlobId());
    }
  }

  @Test
  public void storageReadChannel_attemptToReadZeroBytes() throws IOException {
    BlobInfo info1 = objectsFixture.getInfo1();
    try (ReadChannel r = storage.reader(info1.getBlobId());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel w = Channels.newChannel(baos)) {
      r.setChunkSize(10);
      r.seek(10);
      r.limit(10);

      ByteStreams.copy(r, w);
      assertThat(baos.toByteArray()).isEmpty();
    }
  }

  @Test
  public void storageReadChannel_getObject_404() {
    BlobId id = BlobId.of(bucket.getName(), generator.randomObjectName());

    try (ReadChannel c = storage.reader(id)) {
      ApiFuture<BlobInfo> infoFuture = getBlobInfoFromReadChannelFunction(c);
      IOException ioException =
          assertThrows(IOException.class, () -> c.read(ByteBuffer.allocate(10)));
      assertThat(ioException).hasCauseThat().isInstanceOf(StorageException.class);
      ExecutionException ee =
          assertThrows(ExecutionException.class, () -> infoFuture.get(3, TimeUnit.SECONDS));
      assertThat(ee).hasCauseThat().isInstanceOf(StorageException.class);
      StorageException cause = (StorageException) ee.getCause();
      assertThat(cause.getCode()).isEqualTo(404);
    }
  }

  private static <T, F> void equalForField(T actual, T expected, Function<T, F> f) {
    F aF = f.apply(actual);
    F eF = f.apply(expected);
    assertThat(aF).isEqualTo(eF);
  }

  static int fillFrom(ByteBuffer buf, ReadableByteChannel c) throws IOException {
    int total = 0;
    while (buf.hasRemaining()) {
      int read = c.read(buf);
      if (read != -1) {
        total += read;
      } else {
        break;
      }
    }
    return total;
  }
}
