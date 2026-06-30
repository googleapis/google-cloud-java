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
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.StorageBatch;
import com.google.cloud.storage.StorageBatchResult;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.it.runner.annotations.StorageFixture;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.time.Clock;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@SingleBackend(Backend.PROD)
public class ITBatchTest {
  private static final String CONTENT_TYPE = "text/plain";

  @Inject
  @StorageFixture(Transport.HTTP)
  public Storage storage;

  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  private String bucketName;

  @Before
  public void setUp() throws Exception {
    bucketName = bucket.getName();
  }

  @Test
  public void testBatchRequest() {
    String sourceBlobName1 = "test-batch-request-blob-1";
    String sourceBlobName2 = "test-batch-request-blob-2";
    BlobInfo sourceBlob1 = BlobInfo.newBuilder(bucketName, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.newBuilder(bucketName, sourceBlobName2).build();
    assertNotNull(storage.create(sourceBlob1));
    assertNotNull(storage.create(sourceBlob2));

    // Batch update request
    BlobInfo updatedBlob1 = sourceBlob1.toBuilder().setContentType(CONTENT_TYPE).build();
    BlobInfo updatedBlob2 = sourceBlob2.toBuilder().setContentType(CONTENT_TYPE).build();
    StorageBatch updateBatch = storage.batch();
    StorageBatchResult<Blob> updateResult1 = updateBatch.update(updatedBlob1);
    StorageBatchResult<Blob> updateResult2 = updateBatch.update(updatedBlob2);
    updateBatch.submit();
    Blob remoteUpdatedBlob1 = updateResult1.get();
    Blob remoteUpdatedBlob2 = updateResult2.get();
    assertEquals(sourceBlob1.getBucket(), remoteUpdatedBlob1.getBucket());
    assertEquals(sourceBlob1.getName(), remoteUpdatedBlob1.getName());
    assertEquals(sourceBlob2.getBucket(), remoteUpdatedBlob2.getBucket());
    assertEquals(sourceBlob2.getName(), remoteUpdatedBlob2.getName());
    assertEquals(updatedBlob1.getContentType(), remoteUpdatedBlob1.getContentType());
    assertEquals(updatedBlob2.getContentType(), remoteUpdatedBlob2.getContentType());

    // Batch get request
    StorageBatch getBatch = storage.batch();
    StorageBatchResult<Blob> getResult1 = getBatch.get(bucketName, sourceBlobName1);
    StorageBatchResult<Blob> getResult2 = getBatch.get(bucketName, sourceBlobName2);
    getBatch.submit();
    Blob remoteBlob1 = getResult1.get();
    Blob remoteBlob2 = getResult2.get();
    assertEquals(remoteUpdatedBlob1, remoteBlob1);
    assertEquals(remoteUpdatedBlob2, remoteBlob2);

    // Batch delete request
    StorageBatch deleteBatch = storage.batch();
    StorageBatchResult<Boolean> deleteResult1 = deleteBatch.delete(bucketName, sourceBlobName1);
    StorageBatchResult<Boolean> deleteResult2 = deleteBatch.delete(bucketName, sourceBlobName2);
    deleteBatch.submit();
    assertTrue(deleteResult1.get());
    assertTrue(deleteResult2.get());
  }

  @Test
  public void testBatchRequestManyOperations() throws Exception {
    // define some object ids for use in the batch operations
    BlobId id1 = BlobId.of(bucketName, generator.randomObjectName());
    BlobId id2 = BlobId.of(bucketName, generator.randomObjectName());
    BlobId id3 = BlobId.of(bucketName, generator.randomObjectName());
    BlobId id4 = BlobId.of(bucketName, generator.randomObjectName());
    BlobId id5 = BlobId.of(bucketName, generator.randomObjectName());

    ImmutableMap<String, String> ka = ImmutableMap.of("k", "a");
    ImmutableMap<String, String> kB = ImmutableMap.of("k", "B");

    // Create objects which exist before the batch operations
    BlobInfo info1 = BlobInfo.newBuilder(id1).setMetadata(ka).build();
    BlobInfo info2 = BlobInfo.newBuilder(id2).setMetadata(ka).build();
    BlobInfo info3 = BlobInfo.newBuilder(id3).setMetadata(ka).build();
    Blob obj1 = storage.create(info1, BlobTargetOption.doesNotExist());
    Blob obj2 = storage.create(info2, BlobTargetOption.doesNotExist());
    Blob obj3 = storage.create(info3, BlobTargetOption.doesNotExist());

    // Define our batch operations
    StorageBatch batch = storage.batch();

    StorageBatchResult<Blob> get1Success = batch.get(id1);
    StorageBatchResult<Blob> update2Success =
        batch.update(
            obj2.toBuilder().setMetadata(kB).build(), BlobTargetOption.metagenerationMatch());
    StorageBatchResult<Boolean> delete3Success = batch.delete(id3);
    StorageBatchResult<Blob> get4Error = batch.get(id4);
    StorageBatchResult<Boolean> delete5Error = batch.delete(id5);

    // submit the batch
    batch.submit();

    // verify our expected results
    assertAll(
        () -> {
          Blob blob = get1Success.get();
          assertThat(blob.getBucket()).isEqualTo(bucketName);
          assertThat(blob.getName()).isEqualTo(id1.getName());
          assertThat(blob.getMetadata()).isEqualTo(ka);
        },
        () -> {
          Blob blob = update2Success.get();
          assertThat(blob.getBucket()).isEqualTo(bucketName);
          assertThat(blob.getName()).isEqualTo(id2.getName());
          assertThat(blob.getMetadata()).isEqualTo(kB);
        },
        () -> assertThat(delete3Success.get()).isTrue(),
        () -> assertThat(get4Error.get()).isNull(),
        () -> assertThat(delete5Error.get()).isFalse());
  }

  @Test
  public void testBatchRequestFail() {
    String blobName = "test-batch-request-blob-fail";
    BlobInfo blob = BlobInfo.newBuilder(bucketName, blobName).build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    BlobInfo updatedBlob = BlobInfo.newBuilder(bucketName, blobName, -1L).build();
    StorageBatch batch = storage.batch();
    StorageBatchResult<Blob> updateResult =
        batch.update(updatedBlob, Storage.BlobTargetOption.generationMatch());
    StorageBatchResult<Boolean> deleteResult1 =
        batch.delete(bucketName, blobName, Storage.BlobSourceOption.generationMatch(-1L));
    StorageBatchResult<Boolean> deleteResult2 = batch.delete(BlobId.of(bucketName, blobName, -1L));
    StorageBatchResult<Blob> getResult1 =
        batch.get(bucketName, blobName, Storage.BlobGetOption.generationMatch(-1L));
    StorageBatchResult<Blob> getResult2 = batch.get(BlobId.of(bucketName, blobName, -1L));
    batch.submit();
    try {
      updateResult.get();
      fail("Expected StorageException");
    } catch (StorageException ex) {
      // expected
    }
    try {
      deleteResult1.get();
      fail("Expected StorageException");
    } catch (StorageException ex) {
      // expected
    }
    try {
      deleteResult2.get();
      fail("Expected an 'Invalid argument' exception");
    } catch (StorageException e) {
      assertThat(e.getMessage()).contains("Invalid argument");
    }
    try {
      getResult1.get();
      fail("Expected StorageException");
    } catch (StorageException ex) {
      // expected
    }
    try {
      getResult2.get();
      fail("Expected an 'Invalid argument' exception");
    } catch (StorageException e) {
      assertThat(e.getMessage()).contains("Invalid argument");
    }
  }

  @Test
  public void batchSuccessiveUpdatesWork() {
    byte[] bytes = DataGenerator.base64Characters().genBytes(137);

    List<BlobId> blobs =
        IntStream.range(0, 2)
            .mapToObj(
                i -> {
                  BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
                  try (WriteChannel writer = storage.writer(info, BlobWriteOption.doesNotExist())) {
                    writer.write(ByteBuffer.wrap(bytes));
                  } catch (IOException e) {
                    throw new RuntimeException(e);
                  }
                  return info.getBlobId();
                })
            .collect(Collectors.toList());

    OffsetDateTime now1 =
        Clock.systemUTC().instant().atOffset(ZoneOffset.UTC).truncatedTo(ChronoUnit.MILLIS);

    List<Blob> update1 =
        storage.update(
            blobs.stream()
                .map(id -> BlobInfo.newBuilder(id).setCustomTimeOffsetDateTime(now1).build())
                .collect(Collectors.toList()));

    OffsetDateTime now2 =
        Clock.systemUTC().instant().atOffset(ZoneOffset.UTC).truncatedTo(ChronoUnit.MILLIS);
    List<Blob> update2 =
        storage.update(
            blobs.stream()
                .map(id -> BlobInfo.newBuilder(id).setCustomTimeOffsetDateTime(now2).build())
                .collect(Collectors.toList()));

    assertThat(
            update2.stream()
                .filter(
                    b ->
                        !now2.equals(
                            b.getCustomTimeOffsetDateTime().truncatedTo(ChronoUnit.MILLIS)))
                .map(BlobInfo::getBlobId)
                .map(BlobId::toGsUtilUriWithGeneration)
                .collect(Collectors.toList()))
        .isEmpty();
  }
}
