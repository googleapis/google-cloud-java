/*
 * Copyright 2021 Google LLC
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

import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.client.json.JsonParser;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.RestorableState;
import com.google.cloud.WriteChannel;
import com.google.cloud.conformance.storage.v1.InstructionList;
import com.google.cloud.conformance.storage.v1.Method;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.HttpStorageOptions;
import com.google.cloud.storage.PackagePrivateMethodWorkarounds;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.it.runner.annotations.StorageFixture;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.it.runner.registry.TestBench;
import com.google.cloud.storage.it.runner.registry.TestBench.RetryTestResource;
import com.google.common.collect.ImmutableMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@SingleBackend(Backend.TEST_BENCH)
public final class ITBlobWriteChannelTest {

  private static final String NOW_STRING;
  private static final String BLOB_STRING_CONTENT = "Hello Google Cloud Storage!";

  static {
    Instant now = Clock.systemUTC().instant();
    DateTimeFormatter formatter =
        DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.from(ZoneOffset.UTC));
    NOW_STRING = formatter.format(now);
  }

  @Inject public TestBench testBench;

  @Inject
  @StorageFixture(Transport.HTTP)
  public Storage storage;

  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  /**
   * Test for unexpected EOF at the beginning of trying to read the json response.
   *
   * <p>The error of this case shows up as an IllegalArgumentException rather than a json parsing
   * error which comes from {@link JsonParser}{@code #startParsing()} which fails to find a node to
   * start parsing.
   */
  @Test
  public void testJsonEOF_0B() throws IOException {
    int contentSize = 512 * 1024;
    int cappedByteCount = 0;

    doJsonUnexpectedEOFTest(contentSize, cappedByteCount);
  }

  /** Test for unexpected EOF 10 bytes into the json response */
  @Test
  public void testJsonEOF_10B() throws IOException {
    int contentSize = 512 * 1024;
    int cappedByteCount = 10;

    doJsonUnexpectedEOFTest(contentSize, cappedByteCount);
  }

  @Test
  public void testWriteChannelExistingBlob() throws IOException {
    HttpStorageOptions baseStorageOptions =
        StorageOptions.http()
            .setCredentials(NoCredentials.getInstance())
            .setHost(testBench.getBaseUri())
            .setProjectId("test-project-id")
            .build();
    Storage storage = baseStorageOptions.getService();
    Instant now = Clock.systemUTC().instant();
    DateTimeFormatter formatter =
        DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.from(ZoneOffset.UTC));
    String nowString = formatter.format(now);
    BucketInfo bucketInfo = BucketInfo.of(generator.randomBucketName());
    String blobPath =
        String.format(Locale.US, "%s/%s/blob", generator.randomObjectName(), nowString);
    BlobId blobId = BlobId.of(bucketInfo.getName(), blobPath);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
    storage.create(bucketInfo);
    storage.create(blobInfo);
    byte[] stringBytes;
    try (WriteChannel writer = storage.writer(blobInfo)) {
      stringBytes = BLOB_STRING_CONTENT.getBytes(UTF_8);
      writer.write(ByteBuffer.wrap(stringBytes));
    }
    assertArrayEquals(stringBytes, storage.readAllBytes(blobInfo.getBlobId()));
    assertTrue(storage.delete(bucketInfo.getName(), blobInfo.getName()));
  }

  @Test
  public void changeChunkSizeAfterWrite() throws IOException {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();

    int _512KiB = 512 * 1024;
    byte[] bytes = DataGenerator.base64Characters().genBytes(_512KiB + 13);
    try (WriteChannel writer = storage.writer(info, BlobWriteOption.doesNotExist())) {
      writer.setChunkSize(2 * 1024 * 1024);
      writer.write(ByteBuffer.wrap(bytes, 0, _512KiB));
      assertThrows(IllegalStateException.class, () -> writer.setChunkSize(768 * 1024));
    }
  }

  @Test
  public void restoreProperlyPlumbsBeginOffset() throws IOException {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    int _256KiB = 256 * 1024;

    byte[] bytes1 = DataGenerator.base64Characters().genBytes(_256KiB);
    byte[] bytes2 = DataGenerator.base64Characters().genBytes(73);

    int allLength = bytes1.length + bytes2.length;
    byte[] expected = Arrays.copyOf(bytes1, allLength);
    System.arraycopy(bytes2, 0, expected, bytes1.length, bytes2.length);
    String xxdExpected = xxd(expected);

    RestorableState<WriteChannel> capture;
    {
      WriteChannel writer = storage.writer(info, BlobWriteOption.doesNotExist());
      writer.setChunkSize(_256KiB);
      writer.write(ByteBuffer.wrap(bytes1));
      // explicitly do not close writer, it will finalize the session
      capture = writer.capture();
    }

    assertThat(capture).isNotNull();
    WriteChannel restored = capture.restore();
    restored.write(ByteBuffer.wrap(bytes2));
    restored.close();

    byte[] readAllBytes = storage.readAllBytes(info.getBlobId());
    assertThat(readAllBytes).hasLength(expected.length);
    String xxdActual = xxd(readAllBytes);
    assertThat(xxdActual).isEqualTo(xxdExpected);
  }

  private void doJsonUnexpectedEOFTest(int contentSize, int cappedByteCount) throws IOException {
    String blobPath =
        String.format(Locale.US, "%s/%s/blob", generator.randomObjectName(), NOW_STRING);

    BucketInfo bucketInfo = BucketInfo.of(generator.randomBucketName());
    BlobInfo blobInfoGen0 = BlobInfo.newBuilder(bucketInfo, blobPath, 0L).build();

    RetryTestResource retryTestResource =
        RetryTestResource.newRetryTestResource(
            Method.newBuilder().setName("storage.objects.insert").build(),
            InstructionList.newBuilder()
                .addInstructions(
                    String.format(
                        Locale.US, "return-broken-stream-final-chunk-after-%dB", cappedByteCount))
                .build(),
            Transport.HTTP.name());
    RetryTestResource retryTest = testBench.createRetryTest(retryTestResource);

    StorageOptions baseOptions =
        StorageOptions.http()
            .setCredentials(NoCredentials.getInstance())
            .setHost(testBench.getBaseUri())
            .setProjectId("project-id")
            .setHeaderProvider(
                FixedHeaderProvider.create(ImmutableMap.of("x-retry-test-id", retryTest.id)))
            .build();

    Storage testStorage = baseOptions.getService();

    testStorage.create(bucketInfo);

    ByteBuffer content = DataGenerator.base64Characters().genByteBuffer(contentSize);
    // create a duplicate to preserve the initial offset and limit for assertion later
    ByteBuffer expected = content.duplicate();

    WriteChannel w = testStorage.writer(blobInfoGen0, BlobWriteOption.generationMatch());
    w.write(content);
    w.close();

    RetryTestResource postRunState = testBench.getRetryTest(retryTest);
    assertTrue(postRunState.completed);

    Optional<BlobInfo> optionalStorageObject =
        PackagePrivateMethodWorkarounds.maybeGetBlobInfoFunction().apply(w);

    assertThat(optionalStorageObject.isPresent()).isTrue();
    BlobInfo internalInfo = optionalStorageObject.get();
    assertThat(internalInfo.getName()).isEqualTo(blobInfoGen0.getName());

    // construct a new blob id, without a generation, so we get the latest when we perform a get
    BlobId blobIdGen1 = BlobId.of(internalInfo.getBucket(), internalInfo.getName());
    Blob blobGen2 = testStorage.get(blobIdGen1);
    assertEquals(contentSize, (long) blobGen2.getSize());
    assertNotEquals(blobInfoGen0.getGeneration(), blobGen2.getGeneration());
    ByteArrayOutputStream actualData = new ByteArrayOutputStream();
    blobGen2.downloadTo(actualData);
    ByteBuffer actual = ByteBuffer.wrap(actualData.toByteArray());
    assertEquals(expected, actual);
  }
}
