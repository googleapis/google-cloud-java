/*
 * Copyright 2022 Google LLC
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

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.TestUtils.slice;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.client.http.HttpRequest;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.cloud.ReadChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.TestUtils;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.it.runner.annotations.StorageFixture;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.it.runner.registry.TestBench;
import com.google.cloud.storage.it.runner.registry.TestBench.RetryTestResource;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.ByteStreams;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Random;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@SingleBackend(Backend.TEST_BENCH)
public final class ITBlobReadChannelV2RetryTest {

  private static final int _512KiB = 512 * 1024;

  @Inject public TestBench testBench;

  @Inject
  @StorageFixture(Transport.HTTP)
  public Storage storage;

  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  @Test
  public void generationIsLockedForRetries() throws Exception {

    StorageOptions baseOptions = storage.getOptions();
    byte[] bytes = DataGenerator.base64Characters().genBytes(_512KiB);

    BlobId id = BlobId.of(bucket.getName(), generator.randomObjectName());
    Blob gen1 =
        storage.create(BlobInfo.newBuilder(id).build(), bytes, BlobTargetOption.doesNotExist());

    byte[] slice1 = slice(bytes, 0, 10);
    byte[] slice2 = slice(bytes, 10, bytes.length);

    String xxdExpected1 = xxd(slice1);
    String xxdExpected2 = xxd(slice2);

    JsonObject instructions = new JsonObject();
    JsonArray value = new JsonArray();
    value.add("return-broken-stream-after-256K");
    instructions.add("storage.objects.get", value);
    RetryTestResource retryTestResource = new RetryTestResource(instructions);
    RetryTestResource retryTest = testBench.createRetryTest(retryTestResource);

    ImmutableMap<String, String> headers = ImmutableMap.of("x-retry-test-id", retryTest.id);

    RequestAuditing requestAuditing = new RequestAuditing();
    StorageOptions testStorageOptions =
        baseOptions.toBuilder()
            .setTransportOptions(requestAuditing)
            .setHeaderProvider(FixedHeaderProvider.create(headers))
            .build();

    ByteBuffer buf1 = ByteBuffer.allocate(10);
    ByteBuffer buf2 = ByteBuffer.allocate(_512KiB);
    try (Storage testStorage = testStorageOptions.getService();
        // explicitly use id rather than gen1, we want to start the read without the generation
        // present
        ReadChannel r = testStorage.reader(id)) {
      r.setChunkSize(16);
      // perform a read to open the first socket against gen1
      // This should leave the socket open with bytes left to read since we've set our 'chunkSize'
      // to 16, we won't read far enough into the object yet to trigger the
      // 'broken-stream-after-256K'.
      r.read(buf1);
      String xxd1 = xxd(buf1);
      assertThat(xxd1).isEqualTo(xxdExpected1);
      // verify no generation was passed
      requestAuditing.assertQueryParam("generation", ImmutableList.of());

      // now that the socket is open, modify the object so that it will get a new generation
      Blob gen2 =
          storage.create(
              gen1, "A".getBytes(StandardCharsets.UTF_8), BlobTargetOption.generationMatch());

      // Now try and read the rest of the object.
      // after reaching the 256Kth byte the stream should break causing the ReadChannel to try and
      // resume the download
      r.read(buf2);
      String xxd2 = xxd(buf2);
      assertThat(xxd2).isEqualTo(xxdExpected2);
      requestAuditing.assertQueryParam("generation", gen1.getGeneration(), Long::new);
    }
  }

  @Test
  public void restartingAStreamForGzipContentIsAtTheCorrectOffset() throws Exception {

    StorageOptions baseOptions = storage.getOptions();
    Random rand = new Random(918273645);

    ChecksummedTestContent uncompressed;
    ChecksummedTestContent gzipped;
    {
      // must use random strategy, base64 characters compress too well. 512KiB uncompressed becomes
      // ~1600 bytes which is smaller than our 'return-broken-stream-after-256K' rule
      byte[] bytes = DataGenerator.rand(rand).genBytes(_512KiB);
      uncompressed = ChecksummedTestContent.of(bytes);
      gzipped = ChecksummedTestContent.of(TestUtils.gzipBytes(bytes));
    }
    BlobId id = BlobId.of(bucket.getName(), generator.randomObjectName());
    BlobInfo info =
        BlobInfo.newBuilder(id)
            .setCrc32c(gzipped.getCrc32cBase64())
            .setContentType("application/vnd.j.bytes")
            .setContentEncoding("gzip")
            .build();
    Blob gen1 = storage.create(info, gzipped.getBytes(), BlobTargetOption.doesNotExist());

    JsonObject instructions = new JsonObject();
    JsonArray value = new JsonArray();
    value.add("return-broken-stream-after-256K");
    instructions.add("storage.objects.get", value);
    RetryTestResource retryTestResource = new RetryTestResource(instructions);
    RetryTestResource retryTest = testBench.createRetryTest(retryTestResource);

    ImmutableMap<String, String> headers = ImmutableMap.of("x-retry-test-id", retryTest.id);

    RequestAuditing requestAuditing = new RequestAuditing();
    StorageOptions testStorageOptions =
        baseOptions.toBuilder()
            .setTransportOptions(requestAuditing)
            .setHeaderProvider(FixedHeaderProvider.create(headers))
            .build();

    String expected = xxd(uncompressed.getBytes());

    // explicitly set reader to decompress
    BlobSourceOption option = BlobSourceOption.shouldReturnRawInputStream(false);
    try (Storage testStorage = testStorageOptions.getService();
        ReadChannel r = testStorage.reader(gen1.getBlobId(), option);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel w = Channels.newChannel(baos)) {
      long copy = ByteStreams.copy(r, w);
      String actual = xxd(baos.toByteArray());
      ImmutableList<HttpRequest> requests = requestAuditing.getRequests();
      assertAll(
          () -> assertThat(copy).isEqualTo(uncompressed.getBytes().length),
          () -> assertThat(actual).isEqualTo(expected),
          () -> assertThat(requests.get(0).getHeaders().get("range")).isNull(),
          () ->
              assertThat(requests.get(1).getHeaders().get("range"))
                  .isEqualTo(ImmutableList.of(String.format(Locale.US, "bytes=%d-", 256 * 1024))));
    }
  }

  @Test
  public void resumeFromCorrectOffsetWhenPartialReadSuccess() throws Exception {
    StorageOptions baseOptions = storage.getOptions();
    Random rand = new Random(918273645);

    ChecksummedTestContent uncompressed;
    {
      // must use random strategy, base64 characters compress too well. 512KiB uncompressed becomes
      // ~1600 bytes which is smaller than our 'return-broken-stream-after-256K' rule
      byte[] bytes = DataGenerator.rand(rand).genBytes(_512KiB);
      // byte[] bytes = DataGenerator.base64Characters().genBytes(_512KiB);
      uncompressed = ChecksummedTestContent.of(bytes);
    }
    BlobId id = BlobId.of(bucket.getName(), generator.randomObjectName());
    BlobInfo info = BlobInfo.newBuilder(id).build();
    Blob gen1 = storage.create(info, uncompressed.getBytes(), BlobTargetOption.doesNotExist());

    JsonObject instructions = new JsonObject();
    JsonArray value = new JsonArray();
    value.add("return-broken-stream-after-256K");
    instructions.add("storage.objects.get", value);
    RetryTestResource retryTestResource = new RetryTestResource(instructions);
    RetryTestResource retryTest = testBench.createRetryTest(retryTestResource);

    ImmutableMap<String, String> headers = ImmutableMap.of("x-retry-test-id", retryTest.id);

    RequestAuditing requestAuditing = new RequestAuditing();
    StorageOptions testStorageOptions =
        baseOptions.toBuilder()
            .setTransportOptions(requestAuditing)
            .setHeaderProvider(FixedHeaderProvider.create(headers))
            .build();

    String expected = xxd(uncompressed.getBytes());

    try (Storage testStorage = testStorageOptions.getService();
        ReadChannel r = testStorage.reader(gen1.getBlobId());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel w = Channels.newChannel(baos)) {
      long copy = ByteStreams.copy(r, w);
      String actual = xxd(baos.toByteArray());
      ImmutableList<HttpRequest> requests = requestAuditing.getRequests();
      assertAll(
          () -> assertThat(copy).isEqualTo(uncompressed.getBytes().length),
          () -> assertThat(actual).isEqualTo(expected),
          () -> assertThat(requests.get(0).getHeaders().get("range")).isNull(),
          () ->
              assertThat(requests.get(1).getHeaders().get("range"))
                  .isEqualTo(ImmutableList.of(String.format(Locale.US, "bytes=%d-", 256 * 1024))));
    }
  }
}
