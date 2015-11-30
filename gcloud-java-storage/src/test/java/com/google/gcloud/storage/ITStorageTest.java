/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.client.util.Lists;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.Page;
import com.google.gcloud.RestorableState;
import com.google.gcloud.storage.Storage.BlobField;
import com.google.gcloud.storage.Storage.BucketField;
import com.google.gcloud.storage.testing.RemoteGcsHelper;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ITStorageTest {

  private static Storage storage;

  private static final Logger log = Logger.getLogger(ITStorageTest.class.getName());
  private static final String BUCKET = RemoteGcsHelper.generateBucketName();
  private static final String CONTENT_TYPE = "text/plain";
  private static final byte[] BLOB_BYTE_CONTENT = {0xD, 0xE, 0xA, 0xD};
  private static final String BLOB_STRING_CONTENT = "Hello Google Cloud Storage!";
  private static final int MAX_BATCH_DELETES = 100;

  @BeforeClass
  public static void beforeClass() {
    RemoteGcsHelper gcsHelper = RemoteGcsHelper.create();
    storage = gcsHelper.options().service();
    storage.create(BucketInfo.of(BUCKET));
  }

  @AfterClass
  public static void afterClass()
      throws ExecutionException, TimeoutException, InterruptedException {
    if (storage != null && !RemoteGcsHelper.forceDelete(storage, BUCKET, 5, TimeUnit.SECONDS)) {
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, "Deletion of bucket {0} timed out, bucket is not empty", BUCKET);
      }
    }
  }

  @Test(timeout = 5000)
  public void testListBuckets() throws InterruptedException {
    Iterator<BucketInfo> bucketIterator = storage.list(Storage.BucketListOption.prefix(BUCKET),
        Storage.BucketListOption.fields()).values().iterator();
    while (!bucketIterator.hasNext()) {
      Thread.sleep(500);
      bucketIterator = storage.list(Storage.BucketListOption.prefix(BUCKET),
          Storage.BucketListOption.fields()).values().iterator();
    }
    while (bucketIterator.hasNext()) {
      BucketInfo remoteBucket = bucketIterator.next();
      assertTrue(remoteBucket.name().startsWith(BUCKET));
      assertNull(remoteBucket.createTime());
      assertNull(remoteBucket.selfLink());
    }
  }

  @Test
  public void testGetBucketSelectedFields() {
    BucketInfo remoteBucket = storage.get(BUCKET, Storage.BucketGetOption.fields(BucketField.ID));
    assertEquals(BUCKET, remoteBucket.name());
    assertNull(remoteBucket.createTime());
    assertNotNull(remoteBucket.id());
  }

  @Test
  public void testGetBucketAllSelectedFields() {
    BucketInfo remoteBucket = storage.get(BUCKET,
        Storage.BucketGetOption.fields(BucketField.values()));
    assertEquals(BUCKET, remoteBucket.name());
    assertNotNull(remoteBucket.createTime());
    assertNotNull(remoteBucket.selfLink());
  }

  @Test
  public void testGetBucketEmptyFields() {
    BucketInfo remoteBucket = storage.get(BUCKET, Storage.BucketGetOption.fields());
    assertEquals(BUCKET, remoteBucket.name());
    assertNull(remoteBucket.createTime());
    assertNull(remoteBucket.selfLink());
  }

  @Test
  public void testCreateBlob() {
    String blobName = "test-create-blob";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    BlobInfo remoteBlob = storage.create(blob, BLOB_BYTE_CONTENT);
    assertNotNull(remoteBlob);
    assertEquals(blob.bucket(), remoteBlob.bucket());
    assertEquals(blob.name(), remoteBlob.name());
    byte[] readBytes = storage.readAllBytes(BUCKET, blobName);
    assertArrayEquals(BLOB_BYTE_CONTENT, readBytes);
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testCreateEmptyBlob() {
    String blobName = "test-create-empty-blob";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    BlobInfo remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    assertEquals(blob.bucket(), remoteBlob.bucket());
    assertEquals(blob.name(), remoteBlob.name());
    byte[] readBytes = storage.readAllBytes(BUCKET, blobName);
    assertArrayEquals(new byte[0], readBytes);
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testCreateBlobStream() throws UnsupportedEncodingException {
    String blobName = "test-create-blob-stream";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).contentType(CONTENT_TYPE).build();
    ByteArrayInputStream stream = new ByteArrayInputStream(BLOB_STRING_CONTENT.getBytes(UTF_8));
    BlobInfo remoteBlob = storage.create(blob, stream);
    assertNotNull(remoteBlob);
    assertEquals(blob.bucket(), remoteBlob.bucket());
    assertEquals(blob.name(), remoteBlob.name());
    assertEquals(blob.contentType(), remoteBlob.contentType());
    byte[] readBytes = storage.readAllBytes(BUCKET, blobName);
    assertEquals(BLOB_STRING_CONTENT, new String(readBytes, UTF_8));
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testCreateBlobFail() {
    String blobName = "test-create-blob-fail";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    assertNotNull(storage.create(blob));
    BlobInfo wrongGenerationBlob = BlobInfo.builder(BUCKET, blobName, -1L).build();
    try {
      storage.create(wrongGenerationBlob, BLOB_BYTE_CONTENT,
          Storage.BlobTargetOption.generationMatch());
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testCreateBlobMd5Fail() throws UnsupportedEncodingException {
    String blobName = "test-create-blob-md5-fail";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName)
        .contentType(CONTENT_TYPE)
        .md5("O1R4G1HJSDUISJjoIYmVhQ==")
        .build();
    ByteArrayInputStream stream = new ByteArrayInputStream(BLOB_STRING_CONTENT.getBytes(UTF_8));
    try {
      storage.create(blob, stream, Storage.BlobWriteOption.md5Match());
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
  }

  @Test
  public void testGetBlobEmptySelectedFields() {
    String blobName = "test-get-empty-selected-fields-blob";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).contentType(CONTENT_TYPE).build();
    assertNotNull(storage.create(blob));
    BlobInfo remoteBlob = storage.get(blob.blobId(), Storage.BlobGetOption.fields());
    assertEquals(blob.blobId(), remoteBlob.blobId());
    assertNull(remoteBlob.contentType());
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testGetBlobSelectedFields() {
    String blobName = "test-get-selected-fields-blob";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName)
        .contentType(CONTENT_TYPE)
        .metadata(ImmutableMap.of("k", "v"))
        .build();
    assertNotNull(storage.create(blob));
    BlobInfo remoteBlob = storage.get(blob.blobId(), Storage.BlobGetOption.fields(
        BlobField.METADATA));
    assertEquals(blob.blobId(), remoteBlob.blobId());
    assertEquals(ImmutableMap.of("k", "v"), remoteBlob.metadata());
    assertNull(remoteBlob.contentType());
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testGetBlobAllSelectedFields() {
    String blobName = "test-get-all-selected-fields-blob";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName)
        .contentType(CONTENT_TYPE)
        .metadata(ImmutableMap.of("k", "v"))
        .build();
    assertNotNull(storage.create(blob));
    BlobInfo remoteBlob = storage.get(blob.blobId(),
        Storage.BlobGetOption.fields(BlobField.values()));
    assertEquals(blob.bucket(), remoteBlob.bucket());
    assertEquals(blob.name(), remoteBlob.name());
    assertEquals(ImmutableMap.of("k", "v"), remoteBlob.metadata());
    assertNotNull(remoteBlob.id());
    assertNotNull(remoteBlob.selfLink());
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testGetBlobFail() {
    String blobName = "test-get-blob-fail";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    assertNotNull(storage.create(blob));
    BlobId wrongGenerationBlob = BlobId.of(BUCKET, blobName);
    try {
      storage.get(wrongGenerationBlob, Storage.BlobGetOption.generationMatch(-1));
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testGetBlobFailNonExistingGeneration() {
    String blobName = "test-get-blob-fail-non-existing-generation";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    assertNotNull(storage.create(blob));
    BlobId wrongGenerationBlob = BlobId.of(BUCKET, blobName, -1L);
    assertNull(storage.get(wrongGenerationBlob));
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testListBlobsSelectedFields() {
    String[] blobNames = {"test-list-blobs-selected-fields-blob1",
        "test-list-blobs-selected-fields-blob2"};
    ImmutableMap metadata = ImmutableMap.of("k", "v");
    BlobInfo blob1 = BlobInfo.builder(BUCKET, blobNames[0])
        .contentType(CONTENT_TYPE)
        .metadata(metadata)
        .build();
    BlobInfo blob2 = BlobInfo.builder(BUCKET, blobNames[1])
        .contentType(CONTENT_TYPE)
        .metadata(metadata)
        .build();
    assertNotNull(storage.create(blob1));
    assertNotNull(storage.create(blob2));
    Page<BlobInfo> page = storage.list(BUCKET,
        Storage.BlobListOption.prefix("test-list-blobs-selected-fields-blob"),
        Storage.BlobListOption.fields(BlobField.METADATA));
    int index = 0;
    for (BlobInfo remoteBlob : page.values()) {
      assertEquals(BUCKET, remoteBlob.bucket());
      assertEquals(blobNames[index++], remoteBlob.name());
      assertEquals(metadata, remoteBlob.metadata());
      assertNull(remoteBlob.contentType());
    }
    assertTrue(storage.delete(BUCKET, blobNames[0]));
    assertTrue(storage.delete(BUCKET, blobNames[1]));
  }

  @Test
  public void testListBlobsEmptySelectedFields() {
    String[] blobNames = {"test-list-blobs-empty-selected-fields-blob1",
        "test-list-blobs-empty-selected-fields-blob2"};
    BlobInfo blob1 = BlobInfo.builder(BUCKET, blobNames[0])
        .contentType(CONTENT_TYPE)
        .build();
    BlobInfo blob2 = BlobInfo.builder(BUCKET, blobNames[1])
        .contentType(CONTENT_TYPE)
        .build();
    assertNotNull(storage.create(blob1));
    assertNotNull(storage.create(blob2));
    Page<BlobInfo> page = storage.list(BUCKET,
        Storage.BlobListOption.prefix("test-list-blobs-empty-selected-fields-blob"),
        Storage.BlobListOption.fields());
    int index = 0;
    for (BlobInfo remoteBlob : page.values()) {
      assertEquals(BUCKET, remoteBlob.bucket());
      assertEquals(blobNames[index++], remoteBlob.name());
      assertNull(remoteBlob.contentType());
    }
    assertTrue(storage.delete(BUCKET, blobNames[0]));
    assertTrue(storage.delete(BUCKET, blobNames[1]));
  }

  @Test
  public void testUpdateBlob() {
    String blobName = "test-update-blob";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    assertNotNull(storage.create(blob));
    BlobInfo updatedBlob = storage.update(blob.toBuilder().contentType(CONTENT_TYPE).build());
    assertNotNull(updatedBlob);
    assertEquals(blob.name(), updatedBlob.name());
    assertEquals(blob.bucket(), updatedBlob.bucket());
    assertEquals(CONTENT_TYPE, updatedBlob.contentType());
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testUpdateBlobReplaceMetadata() {
    String blobName = "test-update-blob-replace-metadata";
    ImmutableMap<String, String> metadata = ImmutableMap.of("k1", "a");
    ImmutableMap<String, String> newMetadata = ImmutableMap.of("k2", "b");
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName)
        .contentType(CONTENT_TYPE)
        .metadata(metadata)
        .build();
    assertNotNull(storage.create(blob));
    BlobInfo updatedBlob = storage.update(blob.toBuilder().metadata(null).build());
    assertNotNull(updatedBlob);
    assertNull(updatedBlob.metadata());
    updatedBlob = storage.update(blob.toBuilder().metadata(newMetadata).build());
    assertEquals(blob.name(), updatedBlob.name());
    assertEquals(blob.bucket(), updatedBlob.bucket());
    assertEquals(newMetadata, updatedBlob.metadata());
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testUpdateBlobMergeMetadata() {
    String blobName = "test-update-blob-merge-metadata";
    ImmutableMap<String, String> metadata = ImmutableMap.of("k1", "a");
    ImmutableMap<String, String> newMetadata = ImmutableMap.of("k2", "b");
    ImmutableMap<String, String> expectedMetadata = ImmutableMap.of("k1", "a", "k2", "b");
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName)
        .contentType(CONTENT_TYPE)
        .metadata(metadata)
        .build();
    assertNotNull(storage.create(blob));
    BlobInfo updatedBlob = storage.update(blob.toBuilder().metadata(newMetadata).build());
    assertNotNull(updatedBlob);
    assertEquals(blob.name(), updatedBlob.name());
    assertEquals(blob.bucket(), updatedBlob.bucket());
    assertEquals(expectedMetadata, updatedBlob.metadata());
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testUpdateBlobUnsetMetadata() {
    String blobName = "test-update-blob-unset-metadata";
    ImmutableMap<String, String> metadata = ImmutableMap.of("k1", "a", "k2", "b");
    Map<String, String> newMetadata = new HashMap<>();
    newMetadata.put("k1", "a");
    newMetadata.put("k2", null);
    ImmutableMap<String, String> expectedMetadata = ImmutableMap.of("k1", "a");
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName)
        .contentType(CONTENT_TYPE)
        .metadata(metadata)
        .build();
    assertNotNull(storage.create(blob));
    BlobInfo updatedBlob = storage.update(blob.toBuilder().metadata(newMetadata).build());
    assertNotNull(updatedBlob);
    assertEquals(blob.name(), updatedBlob.name());
    assertEquals(blob.bucket(), updatedBlob.bucket());
    assertEquals(expectedMetadata, updatedBlob.metadata());
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testUpdateBlobFail() {
    String blobName = "test-update-blob-fail";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    assertNotNull(storage.create(blob));
    BlobInfo wrongGenerationBlob = BlobInfo.builder(BUCKET, blobName, -1L)
        .contentType(CONTENT_TYPE)
        .build();
    try {
      storage.update(wrongGenerationBlob, Storage.BlobTargetOption.generationMatch());
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testDeleteNonExistingBlob() {
    String blobName = "test-delete-non-existing-blob";
    assertTrue(!storage.delete(BUCKET, blobName));
  }

  @Test
  public void testDeleteBlobNonExistingGeneration() {
    String blobName = "test-delete-blob-non-existing-generation";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    assertNotNull(storage.create(blob));
    assertTrue(!storage.delete(BlobId.of(BUCKET, blobName, -1L)));
  }

  @Test
  public void testDeleteBlobFail() {
    String blobName = "test-delete-blob-fail";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    assertNotNull(storage.create(blob));
    try {
      storage.delete(BUCKET, blob.name(), Storage.BlobSourceOption.generationMatch(-1L));
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(storage.delete(BUCKET, blob.name()));
  }

  @Test
  public void testComposeBlob() {
    String sourceBlobName1 = "test-compose-blob-source-1";
    String sourceBlobName2 = "test-compose-blob-source-2";
    BlobInfo sourceBlob1 = BlobInfo.builder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.builder(BUCKET, sourceBlobName2).build();
    assertNotNull(storage.create(sourceBlob1, BLOB_BYTE_CONTENT));
    assertNotNull(storage.create(sourceBlob2, BLOB_BYTE_CONTENT));
    String targetBlobName = "test-compose-blob-target";
    BlobInfo targetBlob = BlobInfo.builder(BUCKET, targetBlobName).build();
    Storage.ComposeRequest req =
        Storage.ComposeRequest.of(ImmutableList.of(sourceBlobName1, sourceBlobName2), targetBlob);
    BlobInfo remoteBlob = storage.compose(req);
    assertNotNull(remoteBlob);
    assertEquals(targetBlob.name(), remoteBlob.name());
    assertEquals(targetBlob.bucket(), remoteBlob.bucket());
    byte[] readBytes = storage.readAllBytes(BUCKET, targetBlobName);
    byte[] composedBytes = Arrays.copyOf(BLOB_BYTE_CONTENT, BLOB_BYTE_CONTENT.length * 2);
    System.arraycopy(BLOB_BYTE_CONTENT, 0, composedBytes, BLOB_BYTE_CONTENT.length,
        BLOB_BYTE_CONTENT.length);
    assertArrayEquals(composedBytes, readBytes);
    assertTrue(storage.delete(BUCKET, sourceBlobName1));
    assertTrue(storage.delete(BUCKET, sourceBlobName2));
    assertTrue(storage.delete(BUCKET, targetBlobName));
  }

  @Test
  public void testComposeBlobFail() {
    String sourceBlobName1 = "test-compose-blob-fail-source-1";
    String sourceBlobName2 = "test-compose-blob-fail-source-2";
    BlobInfo sourceBlob1 = BlobInfo.builder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.builder(BUCKET, sourceBlobName2).build();
    assertNotNull(storage.create(sourceBlob1));
    assertNotNull(storage.create(sourceBlob2));
    String targetBlobName = "test-compose-blob-fail-target";
    BlobInfo targetBlob = BlobInfo.builder(BUCKET, targetBlobName).build();
    Storage.ComposeRequest req = Storage.ComposeRequest.builder()
        .addSource(sourceBlobName1, -1L)
        .addSource(sourceBlobName2, -1L)
        .target(targetBlob)
        .build();
    try {
      storage.compose(req);
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(storage.delete(BUCKET, sourceBlobName1));
    assertTrue(storage.delete(BUCKET, sourceBlobName2));
  }

  @Test
  public void testCopyBlob() {
    String sourceBlobName = "test-copy-blob-source";
    BlobId source = BlobId.of(BUCKET, sourceBlobName);
    ImmutableMap<String, String> metadata = ImmutableMap.of("k", "v");
    BlobInfo blob = BlobInfo.builder(source)
        .contentType(CONTENT_TYPE)
        .metadata(metadata)
        .build();
    assertNotNull(storage.create(blob, BLOB_BYTE_CONTENT));
    String targetBlobName = "test-copy-blob-target";
    Storage.CopyRequest req = Storage.CopyRequest.of(source, BlobId.of(BUCKET, targetBlobName));
    CopyWriter copyWriter = storage.copy(req);
    assertEquals(BUCKET, copyWriter.result().bucket());
    assertEquals(targetBlobName, copyWriter.result().name());
    assertEquals(CONTENT_TYPE, copyWriter.result().contentType());
    assertEquals(metadata, copyWriter.result().metadata());
    assertTrue(copyWriter.isDone());
    assertTrue(storage.delete(BUCKET, sourceBlobName));
    assertTrue(storage.delete(BUCKET, targetBlobName));
  }

  @Test
  public void testCopyBlobUpdateMetadata() {
    String sourceBlobName = "test-copy-blob-update-metadata-source";
    BlobId source = BlobId.of(BUCKET, sourceBlobName);
    assertNotNull(storage.create(BlobInfo.builder(source).build(), BLOB_BYTE_CONTENT));
    String targetBlobName = "test-copy-blob-update-metadata-target";
    ImmutableMap<String, String> metadata = ImmutableMap.of("k", "v");
    BlobInfo target = BlobInfo.builder(BUCKET, targetBlobName)
        .contentType(CONTENT_TYPE)
        .metadata(metadata)
        .build();
    Storage.CopyRequest req = Storage.CopyRequest.of(source, target);
    CopyWriter copyWriter = storage.copy(req);
    assertEquals(BUCKET, copyWriter.result().bucket());
    assertEquals(targetBlobName, copyWriter.result().name());
    assertEquals(CONTENT_TYPE, copyWriter.result().contentType());
    assertEquals(metadata, copyWriter.result().metadata());
    assertTrue(copyWriter.isDone());
    assertTrue(storage.delete(BUCKET, sourceBlobName));
    assertTrue(storage.delete(BUCKET, targetBlobName));
  }

  @Test
  public void testCopyBlobFail() {
    String sourceBlobName = "test-copy-blob-source-fail";
    BlobId source = BlobId.of(BUCKET, sourceBlobName, -1L);
    assertNotNull(storage.create(BlobInfo.builder(source).build(), BLOB_BYTE_CONTENT));
    String targetBlobName = "test-copy-blob-target-fail";
    BlobInfo target = BlobInfo.builder(BUCKET, targetBlobName).contentType(CONTENT_TYPE).build();
    Storage.CopyRequest req = Storage.CopyRequest.builder()
        .source(BUCKET, sourceBlobName)
        .sourceOptions(Storage.BlobSourceOption.generationMatch(-1L))
        .target(target)
        .build();
    try {
      storage.copy(req);
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    Storage.CopyRequest req2 = Storage.CopyRequest.builder()
        .source(source)
        .sourceOptions(Storage.BlobSourceOption.generationMatch())
        .target(target)
        .build();
    try {
      storage.copy(req2);
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(storage.delete(BUCKET, sourceBlobName));
  }

  @Test
  public void testBatchRequest() {
    String sourceBlobName1 = "test-batch-request-blob-1";
    String sourceBlobName2 = "test-batch-request-blob-2";
    BlobInfo sourceBlob1 = BlobInfo.builder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.builder(BUCKET, sourceBlobName2).build();
    assertNotNull(storage.create(sourceBlob1));
    assertNotNull(storage.create(sourceBlob2));

    // Batch update request
    BlobInfo updatedBlob1 = sourceBlob1.toBuilder().contentType(CONTENT_TYPE).build();
    BlobInfo updatedBlob2 = sourceBlob2.toBuilder().contentType(CONTENT_TYPE).build();
    BatchRequest updateRequest = BatchRequest.builder()
        .update(updatedBlob1)
        .update(updatedBlob2)
        .build();
    BatchResponse updateResponse = storage.apply(updateRequest);
    assertEquals(2, updateResponse.updates().size());
    assertEquals(0, updateResponse.deletes().size());
    assertEquals(0, updateResponse.gets().size());
    BlobInfo remoteUpdatedBlob1 = updateResponse.updates().get(0).get();
    BlobInfo remoteUpdatedBlob2 = updateResponse.updates().get(1).get();
    assertEquals(sourceBlob1.bucket(), remoteUpdatedBlob1.bucket());
    assertEquals(sourceBlob1.name(), remoteUpdatedBlob1.name());
    assertEquals(sourceBlob2.bucket(), remoteUpdatedBlob2.bucket());
    assertEquals(sourceBlob2.name(), remoteUpdatedBlob2.name());
    assertEquals(updatedBlob1.contentType(), remoteUpdatedBlob1.contentType());
    assertEquals(updatedBlob2.contentType(), remoteUpdatedBlob2.contentType());

    // Batch get request
    BatchRequest getRequest = BatchRequest.builder()
        .get(BUCKET, sourceBlobName1)
        .get(BUCKET, sourceBlobName2)
        .build();
    BatchResponse getResponse = storage.apply(getRequest);
    assertEquals(2, getResponse.gets().size());
    assertEquals(0, getResponse.deletes().size());
    assertEquals(0, getResponse.updates().size());
    BlobInfo remoteBlob1 = getResponse.gets().get(0).get();
    BlobInfo remoteBlob2 = getResponse.gets().get(1).get();
    assertEquals(remoteUpdatedBlob1, remoteBlob1);
    assertEquals(remoteUpdatedBlob2, remoteBlob2);

    // Batch delete request
    BatchRequest deleteRequest = BatchRequest.builder()
        .delete(BUCKET, sourceBlobName1)
        .delete(BUCKET, sourceBlobName2)
        .build();
    BatchResponse deleteResponse = storage.apply(deleteRequest);
    assertEquals(2, deleteResponse.deletes().size());
    assertEquals(0, deleteResponse.gets().size());
    assertEquals(0, deleteResponse.updates().size());
    assertTrue(deleteResponse.deletes().get(0).get());
    assertTrue(deleteResponse.deletes().get(1).get());
  }

  @Test
  public void testBatchRequestManyDeletes() {
    List<BlobId> blobsToDelete = Lists.newArrayListWithCapacity(2 * MAX_BATCH_DELETES);
    for (int i = 0; i < 2 * MAX_BATCH_DELETES; i++) {
      blobsToDelete.add(BlobId.of(BUCKET, "test-batch-request-many-deletes-blob-" + i));
    }
    BatchRequest.Builder builder = BatchRequest.builder();
    for (BlobId blob : blobsToDelete) {
      builder.delete(blob);
    }
    String sourceBlobName1 = "test-batch-request-many-deletes-source-blob-1";
    String sourceBlobName2 = "test-batch-request-many-deletes-source-blob-2";
    BlobInfo sourceBlob1 = BlobInfo.builder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.builder(BUCKET, sourceBlobName2).build();
    assertNotNull(storage.create(sourceBlob1));
    assertNotNull(storage.create(sourceBlob2));
    BlobInfo updatedBlob2 = sourceBlob2.toBuilder().contentType(CONTENT_TYPE).build();

    BatchRequest updateRequest = builder
        .get(BUCKET, sourceBlobName1)
        .update(updatedBlob2)
        .build();
    BatchResponse response = storage.apply(updateRequest);
    assertEquals(2 * MAX_BATCH_DELETES, response.deletes().size());
    assertEquals(1, response.updates().size());
    assertEquals(1, response.gets().size());

    // Check deletes
    for (BatchResponse.Result<Boolean> deleteResult : response.deletes()) {
      assertFalse(deleteResult.failed());
      assertFalse(deleteResult.get());
    }

    // Check updates
    BlobInfo remoteUpdatedBlob2 = response.updates().get(0).get();
    assertEquals(sourceBlob2.bucket(), remoteUpdatedBlob2.bucket());
    assertEquals(sourceBlob2.name(), remoteUpdatedBlob2.name());
    assertEquals(updatedBlob2.contentType(), remoteUpdatedBlob2.contentType());

    // Check gets
    BlobInfo remoteBlob1 = response.gets().get(0).get();
    assertEquals(sourceBlob1.bucket(), remoteBlob1.bucket());
    assertEquals(sourceBlob1.name(), remoteBlob1.name());

    assertTrue(storage.delete(BUCKET, sourceBlobName1));
    assertTrue(storage.delete(BUCKET, sourceBlobName2));
  }

  @Test
  public void testBatchRequestFail() {
    String blobName = "test-batch-request-blob-fail";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    assertNotNull(storage.create(blob));
    BlobInfo updatedBlob = BlobInfo.builder(BUCKET, blobName, -1L).build();
    BatchRequest batchRequest = BatchRequest.builder()
        .update(updatedBlob, Storage.BlobTargetOption.generationMatch())
        .delete(BUCKET, blobName, Storage.BlobSourceOption.generationMatch(-1L))
        .delete(BlobId.of(BUCKET, blobName, -1L))
        .get(BUCKET, blobName, Storage.BlobGetOption.generationMatch(-1L))
        .get(BlobId.of(BUCKET, blobName, -1L))
        .build();
    BatchResponse batchResponse = storage.apply(batchRequest);
    assertEquals(1, batchResponse.updates().size());
    assertEquals(2, batchResponse.deletes().size());
    assertEquals(2, batchResponse.gets().size());
    assertTrue(batchResponse.updates().get(0).failed());
    assertTrue(batchResponse.gets().get(0).failed());
    assertFalse(batchResponse.gets().get(1).failed());
    assertNull(batchResponse.gets().get(1).get());
    assertTrue(batchResponse.deletes().get(0).failed());
    assertFalse(batchResponse.deletes().get(1).failed());
    assertFalse(batchResponse.deletes().get(1).get());
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testReadAndWriteChannels() throws IOException {
    String blobName = "test-read-and-write-channels-blob";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    byte[] stringBytes;
    try (BlobWriteChannel writer = storage.writer(blob)) {
      stringBytes = BLOB_STRING_CONTENT.getBytes(UTF_8);
      writer.write(ByteBuffer.wrap(BLOB_BYTE_CONTENT));
      writer.write(ByteBuffer.wrap(stringBytes));
    }
    ByteBuffer readBytes;
    ByteBuffer readStringBytes;
    try (BlobReadChannel reader = storage.reader(blob.blobId())) {
      readBytes = ByteBuffer.allocate(BLOB_BYTE_CONTENT.length);
      readStringBytes = ByteBuffer.allocate(stringBytes.length);
      reader.read(readBytes);
      reader.read(readStringBytes);
    }
    assertArrayEquals(BLOB_BYTE_CONTENT, readBytes.array());
    assertEquals(BLOB_STRING_CONTENT, new String(readStringBytes.array(), UTF_8));
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testReadAndWriteCaptureChannels() throws IOException {
    String blobName = "test-read-and-write-capture-channels-blob";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    byte[] stringBytes;
    BlobWriteChannel writer = storage.writer(blob);
    stringBytes = BLOB_STRING_CONTENT.getBytes(UTF_8);
    writer.write(ByteBuffer.wrap(BLOB_BYTE_CONTENT));
    RestorableState<BlobWriteChannel> writerState = writer.capture();
    BlobWriteChannel secondWriter = writerState.restore();
    secondWriter.write(ByteBuffer.wrap(stringBytes));
    secondWriter.close();
    ByteBuffer readBytes;
    ByteBuffer readStringBytes;
    BlobReadChannel reader = storage.reader(blob.blobId());
    reader.chunkSize(BLOB_BYTE_CONTENT.length);
    readBytes = ByteBuffer.allocate(BLOB_BYTE_CONTENT.length);
    reader.read(readBytes);
    RestorableState<BlobReadChannel> readerState = reader.capture();
    BlobReadChannel secondReader = readerState.restore();
    readStringBytes = ByteBuffer.allocate(stringBytes.length);
    secondReader.read(readStringBytes);
    reader.close();
    secondReader.close();
    assertArrayEquals(BLOB_BYTE_CONTENT, readBytes.array());
    assertEquals(BLOB_STRING_CONTENT, new String(readStringBytes.array(), UTF_8));
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testReadChannelFail() throws IOException {
    String blobName = "test-read-channel-blob-fail";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    assertNotNull(storage.create(blob));
    try (BlobReadChannel reader =
        storage.reader(blob.blobId(), Storage.BlobSourceOption.metagenerationMatch(-1L))) {
      reader.read(ByteBuffer.allocate(42));
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    try (BlobReadChannel reader =
             storage.reader(blob.blobId(), Storage.BlobSourceOption.generationMatch(-1L))) {
      reader.read(ByteBuffer.allocate(42));
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    BlobId blobIdWrongGeneration = BlobId.of(BUCKET, blobName, -1L);
    try (BlobReadChannel reader =
             storage.reader(blobIdWrongGeneration, Storage.BlobSourceOption.generationMatch())) {
      reader.read(ByteBuffer.allocate(42));
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testReadChannelFailUpdatedGeneration() throws IOException {
    String blobName = "test-read-blob-fail-updated-generation";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    Random random = new Random();
    int chunkSize = 1024;
    int blobSize = 2 * chunkSize;
    byte[] content = new byte[blobSize];
    random.nextBytes(content);
    BlobInfo remoteBlob = storage.create(blob, content);
    assertNotNull(remoteBlob);
    assertEquals(blobSize, (long) remoteBlob.size());
    try (BlobReadChannel reader = storage.reader(blob.blobId())) {
      reader.chunkSize(chunkSize);
      ByteBuffer readBytes = ByteBuffer.allocate(chunkSize);
      int numReadBytes = reader.read(readBytes);
      assertEquals(chunkSize, numReadBytes);
      assertArrayEquals(Arrays.copyOf(content, chunkSize), readBytes.array());
      try (BlobWriteChannel writer = storage.writer(blob)) {
        byte[] newContent = new byte[blobSize];
        random.nextBytes(newContent);
        int numWrittenBytes = writer.write(ByteBuffer.wrap(newContent));
        assertEquals(blobSize, numWrittenBytes);
      }
      readBytes = ByteBuffer.allocate(chunkSize);
      reader.read(readBytes);
      fail("StorageException was expected");
    } catch(StorageException ex) {
      StringBuilder messageBuilder = new StringBuilder();
      messageBuilder.append("Blob ").append(blob.blobId()).append(" was updated while reading");
      assertEquals(messageBuilder.toString(), ex.getMessage());
    }
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testWriteChannelFail() throws IOException {
    String blobName = "test-write-channel-blob-fail";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName, -1L).build();
    try {
      try (BlobWriteChannel writer =
          storage.writer(blob, Storage.BlobWriteOption.generationMatch())) {
        writer.write(ByteBuffer.allocate(42));
      }
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
  }

  @Test
  public void testWriteChannelExistingBlob() throws IOException {
    String blobName = "test-write-channel-existing-blob";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    BlobInfo remoteBlob = storage.create(blob);
    byte[] stringBytes;
    try (BlobWriteChannel writer = storage.writer(remoteBlob)) {
      stringBytes = BLOB_STRING_CONTENT.getBytes(UTF_8);
      writer.write(ByteBuffer.wrap(stringBytes));
    }
    assertArrayEquals(stringBytes, storage.readAllBytes(blob.blobId()));
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testGetSignedUrl() throws IOException {
    String blobName = "test-get-signed-url-blob";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    assertNotNull(storage.create(blob, BLOB_BYTE_CONTENT));
    URL url = storage.signUrl(blob, 1, TimeUnit.HOURS);
    URLConnection connection = url.openConnection();
    byte[] readBytes = new byte[BLOB_BYTE_CONTENT.length];
    try (InputStream responseStream = connection.getInputStream()) {
      assertEquals(BLOB_BYTE_CONTENT.length, responseStream.read(readBytes));
      assertArrayEquals(BLOB_BYTE_CONTENT, readBytes);
      assertTrue(storage.delete(BUCKET, blobName));
    }
  }

  @Test
  public void testPostSignedUrl() throws IOException {
    String blobName = "test-post-signed-url-blob";
    BlobInfo blob = BlobInfo.builder(BUCKET, blobName).build();
    assertNotNull(storage.create(blob));
    URL url =
        storage.signUrl(blob, 1, TimeUnit.HOURS, Storage.SignUrlOption.httpMethod(HttpMethod.POST));
    URLConnection connection = url.openConnection();
    connection.setDoOutput(true);
    connection.connect();
    BlobInfo remoteBlob = storage.get(BUCKET, blobName);
    assertNotNull(remoteBlob);
    assertEquals(blob.bucket(), remoteBlob.bucket());
    assertEquals(blob.name(), remoteBlob.name());
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testGetBlobs() {
    String sourceBlobName1 = "test-get-blobs-1";
    String sourceBlobName2 = "test-get-blobs-2";
    BlobInfo sourceBlob1 = BlobInfo.builder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.builder(BUCKET, sourceBlobName2).build();
    assertNotNull(storage.create(sourceBlob1));
    assertNotNull(storage.create(sourceBlob2));
    List<BlobInfo> remoteBlobs = storage.get(sourceBlob1.blobId(), sourceBlob2.blobId());
    assertEquals(sourceBlob1.bucket(), remoteBlobs.get(0).bucket());
    assertEquals(sourceBlob1.name(), remoteBlobs.get(0).name());
    assertEquals(sourceBlob2.bucket(), remoteBlobs.get(1).bucket());
    assertEquals(sourceBlob2.name(), remoteBlobs.get(1).name());
    assertTrue(storage.delete(BUCKET, sourceBlobName1));
    assertTrue(storage.delete(BUCKET, sourceBlobName2));
  }

  @Test
  public void testGetBlobsFail() {
    String sourceBlobName1 = "test-get-blobs-fail-1";
    String sourceBlobName2 = "test-get-blobs-fail-2";
    BlobInfo sourceBlob1 = BlobInfo.builder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.builder(BUCKET, sourceBlobName2).build();
    assertNotNull(storage.create(sourceBlob1));
    List<BlobInfo> remoteBlobs = storage.get(sourceBlob1.blobId(), sourceBlob2.blobId());
    assertEquals(sourceBlob1.bucket(), remoteBlobs.get(0).bucket());
    assertEquals(sourceBlob1.name(), remoteBlobs.get(0).name());
    assertNull(remoteBlobs.get(1));
    assertTrue(storage.delete(BUCKET, sourceBlobName1));
  }

  @Test
  public void testDeleteBlobs() {
    String sourceBlobName1 = "test-delete-blobs-1";
    String sourceBlobName2 = "test-delete-blobs-2";
    BlobInfo sourceBlob1 = BlobInfo.builder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.builder(BUCKET, sourceBlobName2).build();
    assertNotNull(storage.create(sourceBlob1));
    assertNotNull(storage.create(sourceBlob2));
    List<Boolean> deleteStatus = storage.delete(sourceBlob1.blobId(), sourceBlob2.blobId());
    assertTrue(deleteStatus.get(0));
    assertTrue(deleteStatus.get(1));
  }

  @Test
  public void testDeleteBlobsFail() {
    String sourceBlobName1 = "test-delete-blobs-fail-1";
    String sourceBlobName2 = "test-delete-blobs-fail-2";
    BlobInfo sourceBlob1 = BlobInfo.builder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.builder(BUCKET, sourceBlobName2).build();
    assertNotNull(storage.create(sourceBlob1));
    List<Boolean> deleteStatus = storage.delete(sourceBlob1.blobId(), sourceBlob2.blobId());
    assertTrue(deleteStatus.get(0));
    assertTrue(!deleteStatus.get(1));
  }

  @Test
  public void testUpdateBlobs() {
    String sourceBlobName1 = "test-update-blobs-1";
    String sourceBlobName2 = "test-update-blobs-2";
    BlobInfo sourceBlob1 = BlobInfo.builder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.builder(BUCKET, sourceBlobName2).build();
    BlobInfo remoteBlob1 = storage.create(sourceBlob1);
    BlobInfo remoteBlob2 = storage.create(sourceBlob2);
    assertNotNull(remoteBlob1);
    assertNotNull(remoteBlob2);
    List<BlobInfo> updatedBlobs = storage.update(
        remoteBlob1.toBuilder().contentType(CONTENT_TYPE).build(),
        remoteBlob2.toBuilder().contentType(CONTENT_TYPE).build());
    assertEquals(sourceBlob1.bucket(), updatedBlobs.get(0).bucket());
    assertEquals(sourceBlob1.name(), updatedBlobs.get(0).name());
    assertEquals(CONTENT_TYPE, updatedBlobs.get(0).contentType());
    assertEquals(sourceBlob2.bucket(), updatedBlobs.get(1).bucket());
    assertEquals(sourceBlob2.name(), updatedBlobs.get(1).name());
    assertEquals(CONTENT_TYPE, updatedBlobs.get(1).contentType());
    assertTrue(storage.delete(BUCKET, sourceBlobName1));
    assertTrue(storage.delete(BUCKET, sourceBlobName2));
  }

  @Test
  public void testUpdateBlobsFail() {
    String sourceBlobName1 = "test-update-blobs-fail-1";
    String sourceBlobName2 = "test-update-blobs-fail-2";
    BlobInfo sourceBlob1 = BlobInfo.builder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.builder(BUCKET, sourceBlobName2).build();
    BlobInfo remoteBlob1 = storage.create(sourceBlob1);
    assertNotNull(remoteBlob1);
    List<BlobInfo> updatedBlobs = storage.update(
        remoteBlob1.toBuilder().contentType(CONTENT_TYPE).build(),
        sourceBlob2.toBuilder().contentType(CONTENT_TYPE).build());
    assertEquals(sourceBlob1.bucket(), updatedBlobs.get(0).bucket());
    assertEquals(sourceBlob1.name(), updatedBlobs.get(0).name());
    assertEquals(CONTENT_TYPE, updatedBlobs.get(0).contentType());
    assertNull(updatedBlobs.get(1));
    assertTrue(storage.delete(BUCKET, sourceBlobName1));
  }
}
