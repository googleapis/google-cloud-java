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

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.paging.Page;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.Storage.BucketListOption;
import com.google.cloud.storage.StorageBatch;
import com.google.cloud.storage.StorageBatchResult;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableList;
import com.google.common.truth.IterableSubject;
import java.nio.ByteBuffer;
import java.time.Clock;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@SingleBackend(Backend.PROD)
public final class ITHttpIdempotencyTokenTest {

  private static final String X_GOOG_GCS_IDEMPOTENCY_TOKEN = "x-goog-gcs-idempotency-token";
  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  private Storage storage;
  private RequestAuditing requestAuditing;

  @Before
  public void setUp() throws Exception {
    requestAuditing = new RequestAuditing();
    storage = StorageOptions.http().setTransportOptions(requestAuditing).build().getService();
  }

  @After
  public void tearDown() throws Exception {
    if (storage != null) {
      storage.close();
    }
  }

  @Test
  public void simpleUnary() throws Exception {
    Bucket gen1 = storage.get(bucket.getName());

    IterableSubject subject = requestAuditing.assertRequestHeader(X_GOOG_GCS_IDEMPOTENCY_TOKEN);
    assertAll(() -> subject.hasSize(1));
  }

  @Test
  public void pageObjects() throws Exception {
    String baseName = generator.randomObjectName();
    Blob blob1 = storage.create(BlobInfo.newBuilder(bucket, baseName + "1").build());
    Blob blob2 = storage.create(BlobInfo.newBuilder(bucket, baseName + "2").build());

    requestAuditing.clear();
    ImmutableList<String> expectedNamess = ImmutableList.of(blob1.getName(), blob2.getName());
    Page<Blob> page =
        storage.list(bucket.getName(), BlobListOption.prefix(baseName), BlobListOption.pageSize(1));

    List<String> collect = page.streamAll().map(BlobInfo::getName).collect(Collectors.toList());
    IterableSubject subject = requestAuditing.assertRequestHeader(X_GOOG_GCS_IDEMPOTENCY_TOKEN);
    assertAll(
        () -> assertThat(collect).hasSize(2),
        () -> assertThat(collect).containsExactlyElementsIn(expectedNamess),
        () -> subject.hasSize(2));
  }

  @Test
  public void pageBucket() throws Exception {
    String baseName = generator.randomBucketName();
    BucketInfo info1 = BucketInfo.of(baseName + "1");
    BucketInfo info2 = BucketInfo.of(baseName + "2");
    try (TemporaryBucket tmp1 =
            TemporaryBucket.newBuilder().setBucketInfo(info1).setStorage(storage).build();
        TemporaryBucket tmp2 =
            TemporaryBucket.newBuilder().setBucketInfo(info2).setStorage(storage).build()) {
      requestAuditing.clear();
      Page<Bucket> page =
          storage.list(BucketListOption.prefix(baseName), BucketListOption.pageSize(1));

      List<Bucket> collect = page.streamAll().collect(Collectors.toList());
      IterableSubject subject = requestAuditing.assertRequestHeader(X_GOOG_GCS_IDEMPOTENCY_TOKEN);
      assertAll(() -> assertThat(collect).hasSize(2), () -> subject.hasSize(2));
    }
  }

  @Test
  public void readObject() throws Exception {
    byte[] expected = DataGenerator.base64Characters().genBytes(512 * 1024 + 45);
    String expectedXxd = xxd(expected);

    Blob gen1 =
        storage.create(
            BlobInfo.newBuilder(bucket, generator.randomObjectName()).build(),
            expected,
            BlobTargetOption.doesNotExist());

    requestAuditing.clear();
    byte[] actual = storage.readAllBytes(gen1.getBlobId(), BlobSourceOption.generationMatch());
    IterableSubject subject = requestAuditing.assertRequestHeader(X_GOOG_GCS_IDEMPOTENCY_TOKEN);
    String actualXxd = xxd(actual);

    assertAll(() -> subject.hasSize(1), () -> assertThat(actualXxd).isEqualTo(expectedXxd));
  }

  @Test
  public void directUpload() throws Exception {
    byte[] expected = DataGenerator.base64Characters().genBytes(512 * 1024 + 45);
    String expectedXxd = xxd(expected);

    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    requestAuditing.clear();
    Blob gen1 = storage.create(info, expected, BlobTargetOption.doesNotExist());
    IterableSubject subject = requestAuditing.assertRequestHeader(X_GOOG_GCS_IDEMPOTENCY_TOKEN);

    byte[] actual = storage.readAllBytes(gen1.getBlobId(), BlobSourceOption.generationMatch());
    String actualXxd = xxd(actual);

    assertAll(() -> subject.hasSize(1), () -> assertThat(actualXxd).isEqualTo(expectedXxd));
  }

  @Test
  public void resumableUpload() throws Exception {
    byte[] expected = DataGenerator.base64Characters().genBytes(512 * 1024 + 45);
    String expectedXxd = xxd(expected);

    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    try (WriteChannel writer = storage.writer(info, BlobWriteOption.doesNotExist())) {
      writer.setChunkSize(256 * 1024);
      writer.write(ByteBuffer.wrap(Arrays.copyOfRange(expected, 0, 256 * 1024)));
      writer.write(ByteBuffer.wrap(Arrays.copyOfRange(expected, 256 * 1024, 512 * 1024)));
      writer.write(ByteBuffer.wrap(Arrays.copyOfRange(expected, 512 * 1024, expected.length)));
    }
    IterableSubject subject = requestAuditing.assertRequestHeader(X_GOOG_GCS_IDEMPOTENCY_TOKEN);

    byte[] actual = storage.readAllBytes(info.getBlobId());
    String actualXxd = xxd(actual);

    // We expect 4 distinct requests:
    //  1. start resumable session
    //  2. PUT first 256KiB
    //  3. PUT second 256KiB
    //  4. Finalize session and put final 45B
    assertAll(() -> subject.hasSize(4), () -> assertThat(actualXxd).isEqualTo(expectedXxd));
  }

  @Test
  public void batch() throws Exception {
    BlobInfo info1 = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    BlobInfo info2 = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    BlobInfo info3 = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    storage.create(info1, BlobTargetOption.doesNotExist());
    storage.create(info2, BlobTargetOption.doesNotExist());
    storage.create(info3, BlobTargetOption.doesNotExist());

    requestAuditing.clear();
    OffsetDateTime now = Clock.systemUTC().instant().atOffset(ZoneOffset.UTC);

    StorageBatch batch = storage.batch();
    StorageBatchResult<Blob> r1 = batch.get(info1.getBlobId());
    StorageBatchResult<Blob> r2 =
        batch.update(info2.toBuilder().setCustomTimeOffsetDateTime(now).build());
    StorageBatchResult<Boolean> r3 = batch.delete(info3.getBlobId());

    batch.submit();
    assertAll(
        () -> assertThat(r1).isNotNull(),
        () ->
            assertThat(r2.get().getCustomTimeOffsetDateTime().truncatedTo(ChronoUnit.MILLIS))
                .isEqualTo(now.truncatedTo(ChronoUnit.MILLIS)),
        () -> assertThat(r3.get()).isTrue(),
        () -> {
          IterableSubject subject =
              requestAuditing.assertRequestHeader(X_GOOG_GCS_IDEMPOTENCY_TOKEN);
          subject.hasSize(3);
        });
  }
}
