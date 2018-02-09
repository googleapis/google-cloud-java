/*
 * Copyright 2015 Google LLC
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

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.paging.Page;
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.ReadChannel;
import com.google.cloud.RestorableState;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.CopyWriter;
import com.google.cloud.storage.HttpMethod;
import com.google.cloud.storage.ServiceAccount;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobField;
import com.google.cloud.storage.Storage.BucketField;
import com.google.cloud.storage.StorageBatch;
import com.google.cloud.storage.StorageBatchResult;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageRoles;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import javax.crypto.spec.SecretKeySpec;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITStorageTest {

  private static RemoteStorageHelper remoteStorageHelper;
  private static Storage storage;

  private static final Logger log = Logger.getLogger(ITStorageTest.class.getName());
  private static final String BUCKET = RemoteStorageHelper.generateBucketName();
  private static final String CONTENT_TYPE = "text/plain";
  private static final byte[] BLOB_BYTE_CONTENT = {0xD, 0xE, 0xA, 0xD};
  private static final String BLOB_STRING_CONTENT = "Hello Google Cloud Storage!";
  private static final int MAX_BATCH_SIZE = 100;
  private static final String BASE64_KEY = "JVzfVl8NLD9FjedFuStegjRfES5ll5zc59CIXw572OA=";
  private static final String OTHER_BASE64_KEY = "IcOIQGlliNr5pr3vJb63l+XMqc7NjXqjfw/deBoNxPA=";
  private static final Key KEY =
      new SecretKeySpec(BaseEncoding.base64().decode(BASE64_KEY), "AES256");
  private static final byte[] COMPRESSED_CONTENT = BaseEncoding.base64()
      .decode("H4sIAAAAAAAAAPNIzcnJV3DPz0/PSVVwzskvTVEILskvSkxPVQQA/LySchsAAAA=");
  private static final Map<String, String> BUCKET_LABELS = ImmutableMap.of("label1", "value1");
  private static final String SERVICE_ACCOUNT_EMAIL = "gcloud-devel@gs-project-accounts.iam.gserviceaccount.com";

  @BeforeClass
  public static void beforeClass() throws NoSuchAlgorithmException, InvalidKeySpecException {
    remoteStorageHelper = RemoteStorageHelper.create();
    storage = remoteStorageHelper.getOptions().getService();
    storage.create(BucketInfo.of(BUCKET));
  }

  @AfterClass
  public static void afterClass() throws ExecutionException, InterruptedException {
    if (storage != null) {
      boolean wasDeleted = RemoteStorageHelper.forceDelete(storage, BUCKET, 5, TimeUnit.SECONDS);
      if (!wasDeleted && log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, "Deletion of bucket {0} timed out, bucket is not empty", BUCKET);
      }
    }
  }

  @Test(timeout = 5000)
  public void testListBuckets() throws InterruptedException {
    Iterator<Bucket> bucketIterator = storage.list(Storage.BucketListOption.prefix(BUCKET),
        Storage.BucketListOption.fields()).iterateAll().iterator();
    while (!bucketIterator.hasNext()) {
      Thread.sleep(500);
      bucketIterator = storage.list(Storage.BucketListOption.prefix(BUCKET),
          Storage.BucketListOption.fields()).iterateAll().iterator();
    }
    while (bucketIterator.hasNext()) {
      Bucket remoteBucket = bucketIterator.next();
      assertTrue(remoteBucket.getName().startsWith(BUCKET));
      assertNull(remoteBucket.getCreateTime());
      assertNull(remoteBucket.getSelfLink());
    }
  }

  @Test
  public void testGetBucketSelectedFields() {
    Bucket remoteBucket = storage.get(BUCKET, Storage.BucketGetOption.fields(BucketField.ID));
    assertEquals(BUCKET, remoteBucket.getName());
    assertNull(remoteBucket.getCreateTime());
    assertNotNull(remoteBucket.getGeneratedId());
  }

  @Test
  public void testGetBucketAllSelectedFields() {
    Bucket remoteBucket = storage.get(BUCKET,
        Storage.BucketGetOption.fields(BucketField.values()));
    assertEquals(BUCKET, remoteBucket.getName());
    assertNotNull(remoteBucket.getCreateTime());
    assertNotNull(remoteBucket.getSelfLink());
  }

  @Test
  public void testGetBucketEmptyFields() {
    Bucket remoteBucket = storage.get(BUCKET, Storage.BucketGetOption.fields());
    assertEquals(BUCKET, remoteBucket.getName());
    assertNull(remoteBucket.getCreateTime());
    assertNull(remoteBucket.getSelfLink());
  }

  @Test
  public void testCreateBlob() {
    String blobName = "test-create-blob";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    Blob remoteBlob = storage.create(blob, BLOB_BYTE_CONTENT);
    assertNotNull(remoteBlob);
    assertEquals(blob.getBucket(), remoteBlob.getBucket());
    assertEquals(blob.getName(), remoteBlob.getName());
    byte[] readBytes = storage.readAllBytes(BUCKET, blobName);
    assertArrayEquals(BLOB_BYTE_CONTENT, readBytes);
    assertTrue(remoteBlob.delete());
  }

  @Test
  public void testCreateBlobWithEncryptionKey() {
    String blobName = "test-create-with-customer-key-blob";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    Blob remoteBlob =
        storage.create(blob, BLOB_BYTE_CONTENT, Storage.BlobTargetOption.encryptionKey(KEY));
    assertNotNull(remoteBlob);
    assertEquals(blob.getBucket(), remoteBlob.getBucket());
    assertEquals(blob.getName(), remoteBlob.getName());
    byte[] readBytes =
        storage.readAllBytes(BUCKET, blobName, Storage.BlobSourceOption.decryptionKey(BASE64_KEY));
    assertArrayEquals(BLOB_BYTE_CONTENT, readBytes);
    assertTrue(remoteBlob.delete());
  }

  @Test
  public void testCreateEmptyBlob() {
    String blobName = "test-create-empty-blob";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    assertEquals(blob.getBucket(), remoteBlob.getBucket());
    assertEquals(blob.getName(), remoteBlob.getName());
    byte[] readBytes = storage.readAllBytes(BUCKET, blobName);
    assertArrayEquals(new byte[0], readBytes);
    assertTrue(remoteBlob.delete());
  }

  @Test
  public void testCreateBlobStream() {
    String blobName = "test-create-blob-stream";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).setContentType(CONTENT_TYPE).build();
    ByteArrayInputStream stream = new ByteArrayInputStream(BLOB_STRING_CONTENT.getBytes(UTF_8));
    Blob remoteBlob = storage.create(blob, stream);
    assertNotNull(remoteBlob);
    assertEquals(blob.getBucket(), remoteBlob.getBucket());
    assertEquals(blob.getName(), remoteBlob.getName());
    assertEquals(blob.getContentType(), remoteBlob.getContentType());
    byte[] readBytes = storage.readAllBytes(BUCKET, blobName);
    assertEquals(BLOB_STRING_CONTENT, new String(readBytes, UTF_8));
    assertTrue(remoteBlob.delete());
  }

  @Test
  public void testCreateBlobFail() {
    String blobName = "test-create-blob-fail";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    BlobInfo wrongGenerationBlob = BlobInfo.newBuilder(BUCKET, blobName, -1L).build();
    try {
      storage.create(wrongGenerationBlob, BLOB_BYTE_CONTENT,
          Storage.BlobTargetOption.generationMatch());
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(remoteBlob.delete());
  }

  @Test
  public void testCreateBlobMd5Fail() {
    String blobName = "test-create-blob-md5-fail";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName)
        .setContentType(CONTENT_TYPE)
        .setMd5("O1R4G1HJSDUISJjoIYmVhQ==")
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
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).setContentType(CONTENT_TYPE).build();
    assertNotNull(storage.create(blob));
    Blob remoteBlob = storage.get(blob.getBlobId(), Storage.BlobGetOption.fields());
    assertEquals(blob.getBlobId(), remoteBlob.getBlobId());
    assertNull(remoteBlob.getContentType());
    assertTrue(remoteBlob.delete());
  }

  @Test
  public void testGetBlobSelectedFields() {
    String blobName = "test-get-selected-fields-blob";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName)
        .setContentType(CONTENT_TYPE)
        .setMetadata(ImmutableMap.of("k", "v"))
        .build();
    assertNotNull(storage.create(blob));
    Blob remoteBlob = storage.get(blob.getBlobId(), Storage.BlobGetOption.fields(
        BlobField.METADATA));
    assertEquals(blob.getBlobId(), remoteBlob.getBlobId());
    assertEquals(ImmutableMap.of("k", "v"), remoteBlob.getMetadata());
    assertNull(remoteBlob.getContentType());
    assertTrue(remoteBlob.delete());
  }

  @Test
  public void testGetBlobAllSelectedFields() {
    String blobName = "test-get-all-selected-fields-blob";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName)
        .setContentType(CONTENT_TYPE)
        .setMetadata(ImmutableMap.of("k", "v"))
        .build();
    assertNotNull(storage.create(blob));
    Blob remoteBlob = storage.get(blob.getBlobId(),
        Storage.BlobGetOption.fields(BlobField.values()));
    assertEquals(blob.getBucket(), remoteBlob.getBucket());
    assertEquals(blob.getName(), remoteBlob.getName());
    assertEquals(ImmutableMap.of("k", "v"), remoteBlob.getMetadata());
    assertNotNull(remoteBlob.getGeneratedId());
    assertNotNull(remoteBlob.getSelfLink());
    assertTrue(remoteBlob.delete());
  }

  @Test
  public void testGetBlobFail() {
    String blobName = "test-get-blob-fail";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    BlobId wrongGenerationBlob = BlobId.of(BUCKET, blobName);
    try {
      storage.get(wrongGenerationBlob, Storage.BlobGetOption.generationMatch(-1));
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(remoteBlob.delete());
  }

  @Test
  public void testGetBlobFailNonExistingGeneration() {
    String blobName = "test-get-blob-fail-non-existing-generation";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    BlobId wrongGenerationBlob = BlobId.of(BUCKET, blobName, -1L);
    try {
      assertNull(storage.get(wrongGenerationBlob));
      fail("Expected an 'Invalid argument' exception");
    } catch (StorageException e) {
      assertThat(e.getMessage()).contains("Invalid argument");
    }
    assertTrue(remoteBlob.delete());
  }

  @Test(timeout = 5000)
  public void testListBlobsSelectedFields() throws InterruptedException {
    String[] blobNames = {"test-list-blobs-selected-fields-blob1",
        "test-list-blobs-selected-fields-blob2"};
    ImmutableMap<String, String> metadata = ImmutableMap.of("k", "v");
    BlobInfo blob1 = BlobInfo.newBuilder(BUCKET, blobNames[0])
        .setContentType(CONTENT_TYPE)
        .setMetadata(metadata)
        .build();
    BlobInfo blob2 = BlobInfo.newBuilder(BUCKET, blobNames[1])
        .setContentType(CONTENT_TYPE)
        .setMetadata(metadata)
        .build();
    Blob remoteBlob1 = storage.create(blob1);
    Blob remoteBlob2 = storage.create(blob2);
    assertNotNull(remoteBlob1);
    assertNotNull(remoteBlob2);
    Page<Blob> page = storage.list(BUCKET,
        Storage.BlobListOption.prefix("test-list-blobs-selected-fields-blob"),
        Storage.BlobListOption.fields(BlobField.METADATA));
    // Listing blobs is eventually consistent, we loop until the list is of the expected size. The
    // test fails if timeout is reached.
    while (Iterators.size(page.iterateAll().iterator()) != 2) {
      Thread.sleep(500);
      page = storage.list(BUCKET,
          Storage.BlobListOption.prefix("test-list-blobs-selected-fields-blob"),
          Storage.BlobListOption.fields(BlobField.METADATA));
    }
    Set<String> blobSet = ImmutableSet.of(blobNames[0], blobNames[1]);
    Iterator<Blob> iterator = page.iterateAll().iterator();
    while (iterator.hasNext()) {
      Blob remoteBlob = iterator.next();
      assertEquals(BUCKET, remoteBlob.getBucket());
      assertTrue(blobSet.contains(remoteBlob.getName()));
      assertEquals(metadata, remoteBlob.getMetadata());
      assertNull(remoteBlob.getContentType());
    }
    assertTrue(remoteBlob1.delete());
    assertTrue(remoteBlob2.delete());
  }

  @Test(timeout = 5000)
  public void testListBlobsEmptySelectedFields() throws InterruptedException {
    String[] blobNames = {"test-list-blobs-empty-selected-fields-blob1",
        "test-list-blobs-empty-selected-fields-blob2"};
    BlobInfo blob1 = BlobInfo.newBuilder(BUCKET, blobNames[0])
        .setContentType(CONTENT_TYPE)
        .build();
    BlobInfo blob2 = BlobInfo.newBuilder(BUCKET, blobNames[1])
        .setContentType(CONTENT_TYPE)
        .build();
    Blob remoteBlob1 = storage.create(blob1);
    Blob remoteBlob2 = storage.create(blob2);
    assertNotNull(remoteBlob1);
    assertNotNull(remoteBlob2);
    Page<Blob> page = storage.list(BUCKET,
        Storage.BlobListOption.prefix("test-list-blobs-empty-selected-fields-blob"),
        Storage.BlobListOption.fields());
    // Listing blobs is eventually consistent, we loop until the list is of the expected size. The
    // test fails if timeout is reached.
    while (Iterators.size(page.iterateAll().iterator()) != 2) {
      Thread.sleep(500);
      page = storage.list(BUCKET,
          Storage.BlobListOption.prefix("test-list-blobs-empty-selected-fields-blob"),
          Storage.BlobListOption.fields());
    }
    Set<String> blobSet = ImmutableSet.of(blobNames[0], blobNames[1]);
    Iterator<Blob> iterator = page.iterateAll().iterator();
    while (iterator.hasNext()) {
      Blob remoteBlob = iterator.next();
      assertEquals(BUCKET, remoteBlob.getBucket());
      assertTrue(blobSet.contains(remoteBlob.getName()));
      assertNull(remoteBlob.getContentType());
    }
    assertTrue(remoteBlob1.delete());
    assertTrue(remoteBlob2.delete());
  }

  @Test(timeout = 5000)
  public void testListBlobRequesterPays() throws InterruptedException {
    String[] blobNames = {"test-list-blobs-empty-selected-fields-blob1",
        "test-list-blobs-empty-selected-fields-blob2"};
    BlobInfo blob1 = BlobInfo.newBuilder(BUCKET, blobNames[0])
        .setContentType(CONTENT_TYPE)
        .build();
    BlobInfo blob2 = BlobInfo.newBuilder(BUCKET, blobNames[1])
        .setContentType(CONTENT_TYPE)
        .build();
    Blob remoteBlob1 = storage.create(blob1);
    Blob remoteBlob2 = storage.create(blob2);
    assertNotNull(remoteBlob1);
    assertNotNull(remoteBlob2);

    Page<Blob> page = storage.list(BUCKET,
        Storage.BlobListOption.prefix("test-list-blobs-empty-selected-fields-blob"),
        Storage.BlobListOption.fields());

    // Test listing a Requester Pays bucket.
    Bucket remoteBucket = storage.get(BUCKET, Storage.BucketGetOption.fields(BucketField.ID));
    assertNull(remoteBucket.requesterPays());
    remoteBucket = remoteBucket.toBuilder().setRequesterPays(true).build();
    Bucket updatedBucket = storage.update(remoteBucket);
    assertTrue(updatedBucket.requesterPays());
    String projectId = remoteStorageHelper.getOptions().getProjectId();
    try {
      page = storage.list(BUCKET,
          Storage.BlobListOption.prefix("test-list-blobs-empty-selected-fields-blob"),
          Storage.BlobListOption.fields(),
          Storage.BlobListOption.userProject("fakeBillingProjectId"));
      fail("Expected bad user project error.");
    } catch (StorageException e) {
      assertTrue(e.getMessage().contains("User project specified in the request is invalid"));
    }
    while (Iterators.size(page.iterateAll().iterator()) != 2) {
      Thread.sleep(500);
      page = storage.list(BUCKET,
          Storage.BlobListOption.prefix("test-list-blobs-empty-selected-fields-blob"),
          Storage.BlobListOption.fields(),
          Storage.BlobListOption.userProject(projectId));
    }
    assertTrue(remoteBlob1.delete());
    assertTrue(remoteBlob2.delete());
  }

  @Test(timeout = 15000)
  public void testListBlobsVersioned() throws ExecutionException, InterruptedException {
    String bucketName = RemoteStorageHelper.generateBucketName();
    Bucket bucket =
        storage.create(BucketInfo.newBuilder(bucketName).setVersioningEnabled(true).build());
    try {
      String[] blobNames = {"test-list-blobs-versioned-blob1", "test-list-blobs-versioned-blob2"};
      BlobInfo blob1 = BlobInfo.newBuilder(bucket, blobNames[0])
          .setContentType(CONTENT_TYPE)
          .build();
      BlobInfo blob2 = BlobInfo.newBuilder(bucket, blobNames[1])
          .setContentType(CONTENT_TYPE)
          .build();
      Blob remoteBlob1 = storage.create(blob1);
      Blob remoteBlob2 = storage.create(blob2);
      Blob remoteBlob3 = storage.create(blob2);
      assertNotNull(remoteBlob1);
      assertNotNull(remoteBlob2);
      assertNotNull(remoteBlob3);
      Page<Blob> page = storage.list(bucketName,
          Storage.BlobListOption.prefix("test-list-blobs-versioned-blob"),
          Storage.BlobListOption.versions(true));
      // Listing blobs is eventually consistent, we loop until the list is of the expected size. The
      // test fails if timeout is reached.
      while (Iterators.size(page.iterateAll().iterator()) != 3) {
        Thread.sleep(500);
        page = storage.list(bucketName,
            Storage.BlobListOption.prefix("test-list-blobs-versioned-blob"),
            Storage.BlobListOption.versions(true));
      }
      Set<String> blobSet = ImmutableSet.of(blobNames[0], blobNames[1]);
      Iterator<Blob> iterator = page.iterateAll().iterator();
      while (iterator.hasNext()) {
        Blob remoteBlob = iterator.next();
        assertEquals(bucketName, remoteBlob.getBucket());
        assertTrue(blobSet.contains(remoteBlob.getName()));
        assertNotNull(remoteBlob.getGeneration());
      }
      assertTrue(remoteBlob1.delete());
      assertTrue(remoteBlob2.delete());
      assertTrue(remoteBlob3.delete());
    } finally {
      RemoteStorageHelper.forceDelete(storage, bucketName, 5, TimeUnit.SECONDS);
    }
  }

  @Test(timeout = 5000)
  public void testListBlobsCurrentDirectory() throws InterruptedException {
    String directoryName = "test-list-blobs-current-directory/";
    String subdirectoryName = "subdirectory/";
    String[] blobNames = {directoryName + subdirectoryName + "blob1",
        directoryName + "blob2"};
    BlobInfo blob1 = BlobInfo.newBuilder(BUCKET, blobNames[0])
        .setContentType(CONTENT_TYPE)
        .build();
    BlobInfo blob2 = BlobInfo.newBuilder(BUCKET, blobNames[1])
        .setContentType(CONTENT_TYPE)
        .build();
    Blob remoteBlob1 = storage.create(blob1, BLOB_BYTE_CONTENT);
    Blob remoteBlob2 = storage.create(blob2, BLOB_BYTE_CONTENT);
    assertNotNull(remoteBlob1);
    assertNotNull(remoteBlob2);
    Page<Blob> page = storage.list(BUCKET,
        Storage.BlobListOption.prefix("test-list-blobs-current-directory/"),
        Storage.BlobListOption.currentDirectory());
    // Listing blobs is eventually consistent, we loop until the list is of the expected size. The
    // test fails if timeout is reached.
    while (Iterators.size(page.iterateAll().iterator()) != 2) {
      Thread.sleep(500);
      page = storage.list(BUCKET,
          Storage.BlobListOption.prefix("test-list-blobs-current-directory/"),
          Storage.BlobListOption.currentDirectory());
    }
    Iterator<Blob> iterator = page.iterateAll().iterator();
    while (iterator.hasNext()) {
      Blob remoteBlob = iterator.next();
      assertEquals(BUCKET, remoteBlob.getBucket());
      if (remoteBlob.getName().equals(blobNames[1])) {
        assertEquals(CONTENT_TYPE, remoteBlob.getContentType());
        assertEquals(BLOB_BYTE_CONTENT.length, (long) remoteBlob.getSize());
        assertFalse(remoteBlob.isDirectory());
      } else if (remoteBlob.getName().equals(directoryName + subdirectoryName)) {
        assertEquals(0L, (long) remoteBlob.getSize());
        assertTrue(remoteBlob.isDirectory());
      } else {
        fail("Unexpected blob with name " + remoteBlob.getName());
      }
    }
    assertTrue(remoteBlob1.delete());
    assertTrue(remoteBlob2.delete());
  }

  @Test
  public void testUpdateBlob() {
    String blobName = "test-update-blob";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    Blob updatedBlob = remoteBlob.toBuilder().setContentType(CONTENT_TYPE).build().update();
    assertNotNull(updatedBlob);
    assertEquals(blob.getName(), updatedBlob.getName());
    assertEquals(blob.getBucket(), updatedBlob.getBucket());
    assertEquals(CONTENT_TYPE, updatedBlob.getContentType());
    assertTrue(updatedBlob.delete());
  }

  @Test
  public void testUpdateBlobReplaceMetadata() {
    String blobName = "test-update-blob-replace-metadata";
    ImmutableMap<String, String> metadata = ImmutableMap.of("k1", "a");
    ImmutableMap<String, String> newMetadata = ImmutableMap.of("k2", "b");
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName)
        .setContentType(CONTENT_TYPE)
        .setMetadata(metadata)
        .build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    Blob updatedBlob = remoteBlob.toBuilder().setMetadata(null).build().update();
    assertNotNull(updatedBlob);
    assertNull(updatedBlob.getMetadata());
    updatedBlob = remoteBlob.toBuilder().setMetadata(newMetadata).build().update();
    assertEquals(blob.getName(), updatedBlob.getName());
    assertEquals(blob.getBucket(), updatedBlob.getBucket());
    assertEquals(newMetadata, updatedBlob.getMetadata());
    assertTrue(updatedBlob.delete());
  }

  @Test
  public void testUpdateBlobMergeMetadata() {
    String blobName = "test-update-blob-merge-metadata";
    ImmutableMap<String, String> metadata = ImmutableMap.of("k1", "a");
    ImmutableMap<String, String> newMetadata = ImmutableMap.of("k2", "b");
    ImmutableMap<String, String> expectedMetadata = ImmutableMap.of("k1", "a", "k2", "b");
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName)
        .setContentType(CONTENT_TYPE)
        .setMetadata(metadata)
        .build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    Blob updatedBlob = remoteBlob.toBuilder().setMetadata(newMetadata).build().update();
    assertNotNull(updatedBlob);
    assertEquals(blob.getName(), updatedBlob.getName());
    assertEquals(blob.getBucket(), updatedBlob.getBucket());
    assertEquals(expectedMetadata, updatedBlob.getMetadata());
    assertTrue(updatedBlob.delete());
  }

  @Test
  public void testUpdateBlobUnsetMetadata() {
    String blobName = "test-update-blob-unset-metadata";
    ImmutableMap<String, String> metadata = ImmutableMap.of("k1", "a", "k2", "b");
    Map<String, String> newMetadata = new HashMap<>();
    newMetadata.put("k1", "a");
    newMetadata.put("k2", null);
    ImmutableMap<String, String> expectedMetadata = ImmutableMap.of("k1", "a");
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName)
        .setContentType(CONTENT_TYPE)
        .setMetadata(metadata)
        .build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    Blob updatedBlob = remoteBlob.toBuilder().setMetadata(newMetadata).build().update();
    assertNotNull(updatedBlob);
    assertEquals(blob.getName(), updatedBlob.getName());
    assertEquals(blob.getBucket(), updatedBlob.getBucket());
    assertEquals(expectedMetadata, updatedBlob.getMetadata());
    assertTrue(updatedBlob.delete());
  }

  @Test
  public void testUpdateBlobFail() {
    String blobName = "test-update-blob-fail";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    BlobInfo wrongGenerationBlob = BlobInfo.newBuilder(BUCKET, blobName, -1L)
        .setContentType(CONTENT_TYPE)
        .build();
    try {
      storage.update(wrongGenerationBlob, Storage.BlobTargetOption.generationMatch());
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(remoteBlob.delete());
  }

  @Test
  public void testDeleteNonExistingBlob() {
    String blobName = "test-delete-non-existing-blob";
    assertFalse(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testDeleteBlobNonExistingGeneration() {
    String blobName = "test-delete-blob-non-existing-generation";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    assertNotNull(storage.create(blob));
    try {
      assertFalse(storage.delete(BlobId.of(BUCKET, blobName, -1L)));
      fail("Expected an 'Invalid argument' exception");
    } catch (StorageException e) {
      assertThat(e.getMessage()).contains("Invalid argument");
    }
  }

  @Test
  public void testDeleteBlobFail() {
    String blobName = "test-delete-blob-fail";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    try {
      storage.delete(BUCKET, blob.getName(), Storage.BlobSourceOption.generationMatch(-1L));
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(remoteBlob.delete());
  }

  @Test
  public void testComposeBlob() {
    String sourceBlobName1 = "test-compose-blob-source-1";
    String sourceBlobName2 = "test-compose-blob-source-2";
    BlobInfo sourceBlob1 = BlobInfo.newBuilder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.newBuilder(BUCKET, sourceBlobName2).build();
    Blob remoteSourceBlob1 = storage.create(sourceBlob1, BLOB_BYTE_CONTENT);
    Blob remoteSourceBlob2 = storage.create(sourceBlob2, BLOB_BYTE_CONTENT);
    assertNotNull(remoteSourceBlob1);
    assertNotNull(remoteSourceBlob2);
    String targetBlobName = "test-compose-blob-target";
    BlobInfo targetBlob = BlobInfo.newBuilder(BUCKET, targetBlobName).build();
    Storage.ComposeRequest req =
        Storage.ComposeRequest.of(ImmutableList.of(sourceBlobName1, sourceBlobName2), targetBlob);
    Blob remoteTargetBlob = storage.compose(req);
    assertNotNull(remoteTargetBlob);
    assertEquals(targetBlob.getName(), remoteTargetBlob.getName());
    assertEquals(targetBlob.getBucket(), remoteTargetBlob.getBucket());
    assertNull(remoteTargetBlob.getContentType());
    byte[] readBytes = storage.readAllBytes(BUCKET, targetBlobName);
    byte[] composedBytes = Arrays.copyOf(BLOB_BYTE_CONTENT, BLOB_BYTE_CONTENT.length * 2);
    System.arraycopy(BLOB_BYTE_CONTENT, 0, composedBytes, BLOB_BYTE_CONTENT.length,
        BLOB_BYTE_CONTENT.length);
    assertArrayEquals(composedBytes, readBytes);
    assertTrue(remoteSourceBlob1.delete());
    assertTrue(remoteSourceBlob2.delete());
    assertTrue(remoteTargetBlob.delete());
  }

  @Test
  public void testComposeBlobWithContentType() {
    String sourceBlobName1 = "test-compose-blob-with-content-type-source-1";
    String sourceBlobName2 = "test-compose-blob-with-content-type-source-2";
    BlobInfo sourceBlob1 = BlobInfo.newBuilder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.newBuilder(BUCKET, sourceBlobName2).build();
    Blob remoteSourceBlob1 = storage.create(sourceBlob1, BLOB_BYTE_CONTENT);
    Blob remoteSourceBlob2 = storage.create(sourceBlob2, BLOB_BYTE_CONTENT);
    assertNotNull(remoteSourceBlob1);
    assertNotNull(remoteSourceBlob2);
    String targetBlobName = "test-compose-blob-with-content-type-target";
    BlobInfo targetBlob =
        BlobInfo.newBuilder(BUCKET, targetBlobName).setContentType(CONTENT_TYPE).build();
    Storage.ComposeRequest req =
        Storage.ComposeRequest.of(ImmutableList.of(sourceBlobName1, sourceBlobName2), targetBlob);
    Blob remoteTargetBlob = storage.compose(req);
    assertNotNull(remoteTargetBlob);
    assertEquals(targetBlob.getName(), remoteTargetBlob.getName());
    assertEquals(targetBlob.getBucket(), remoteTargetBlob.getBucket());
    assertEquals(CONTENT_TYPE, remoteTargetBlob.getContentType());
    byte[] readBytes = storage.readAllBytes(BUCKET, targetBlobName);
    byte[] composedBytes = Arrays.copyOf(BLOB_BYTE_CONTENT, BLOB_BYTE_CONTENT.length * 2);
    System.arraycopy(BLOB_BYTE_CONTENT, 0, composedBytes, BLOB_BYTE_CONTENT.length,
        BLOB_BYTE_CONTENT.length);
    assertArrayEquals(composedBytes, readBytes);
    assertTrue(remoteSourceBlob1.delete());
    assertTrue(remoteSourceBlob2.delete());
    assertTrue(remoteTargetBlob.delete());
  }

  @Test
  public void testComposeBlobFail() {
    String sourceBlobName1 = "test-compose-blob-fail-source-1";
    String sourceBlobName2 = "test-compose-blob-fail-source-2";
    BlobInfo sourceBlob1 = BlobInfo.newBuilder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.newBuilder(BUCKET, sourceBlobName2).build();
    Blob remoteSourceBlob1 = storage.create(sourceBlob1);
    Blob remoteSourceBlob2 = storage.create(sourceBlob2);
    assertNotNull(remoteSourceBlob1);
    assertNotNull(remoteSourceBlob2);
    String targetBlobName = "test-compose-blob-fail-target";
    BlobInfo targetBlob = BlobInfo.newBuilder(BUCKET, targetBlobName).build();
    Storage.ComposeRequest req = Storage.ComposeRequest.newBuilder()
        .addSource(sourceBlobName1, -1L)
        .addSource(sourceBlobName2, -1L)
        .setTarget(targetBlob)
        .build();
    try {
      storage.compose(req);
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(remoteSourceBlob1.delete());
    assertTrue(remoteSourceBlob2.delete());
  }

  @Test
  public void testCopyBlob() {
    String sourceBlobName = "test-copy-blob-source";
    BlobId source = BlobId.of(BUCKET, sourceBlobName);
    ImmutableMap<String, String> metadata = ImmutableMap.of("k", "v");
    BlobInfo blob = BlobInfo.newBuilder(source)
        .setContentType(CONTENT_TYPE)
        .setMetadata(metadata)
        .build();
    Blob remoteBlob = storage.create(blob, BLOB_BYTE_CONTENT);
    assertNotNull(remoteBlob);
    String targetBlobName = "test-copy-blob-target";
    Storage.CopyRequest req = Storage.CopyRequest.of(source, BlobId.of(BUCKET, targetBlobName));
    CopyWriter copyWriter = storage.copy(req);
    assertEquals(BUCKET, copyWriter.getResult().getBucket());
    assertEquals(targetBlobName, copyWriter.getResult().getName());
    assertEquals(CONTENT_TYPE, copyWriter.getResult().getContentType());
    assertEquals(metadata, copyWriter.getResult().getMetadata());
    assertTrue(copyWriter.isDone());
    assertTrue(remoteBlob.delete());
    assertTrue(storage.delete(BUCKET, targetBlobName));
  }

  @Test
  public void testCopyBlobWithEncryptionKeys() {
    String sourceBlobName = "test-copy-blob-encryption-key-source";
    BlobId source = BlobId.of(BUCKET, sourceBlobName);
    ImmutableMap<String, String> metadata = ImmutableMap.of("k", "v");
    Blob remoteBlob = storage.create(BlobInfo.newBuilder(source).build(), BLOB_BYTE_CONTENT,
        Storage.BlobTargetOption.encryptionKey(KEY));
    assertNotNull(remoteBlob);
    String targetBlobName = "test-copy-blob-encryption-key-target";
    BlobInfo target = BlobInfo.newBuilder(BUCKET, targetBlobName)
        .setContentType(CONTENT_TYPE)
        .setMetadata(metadata)
        .build();
    Storage.CopyRequest req = Storage.CopyRequest.newBuilder()
        .setSource(source)
        .setTarget(target, Storage.BlobTargetOption.encryptionKey(OTHER_BASE64_KEY))
        .setSourceOptions(Storage.BlobSourceOption.decryptionKey(BASE64_KEY))
        .build();
    CopyWriter copyWriter = storage.copy(req);
    assertEquals(BUCKET, copyWriter.getResult().getBucket());
    assertEquals(targetBlobName, copyWriter.getResult().getName());
    assertEquals(CONTENT_TYPE, copyWriter.getResult().getContentType());
    assertArrayEquals(BLOB_BYTE_CONTENT,
        copyWriter.getResult().getContent(Blob.BlobSourceOption.decryptionKey(OTHER_BASE64_KEY)));
    assertEquals(metadata, copyWriter.getResult().getMetadata());
    assertTrue(copyWriter.isDone());
    req = Storage.CopyRequest.newBuilder()
        .setSource(source)
        .setTarget(target)
        .setSourceOptions(Storage.BlobSourceOption.decryptionKey(BASE64_KEY))
        .build();
    copyWriter = storage.copy(req);
    assertEquals(BUCKET, copyWriter.getResult().getBucket());
    assertEquals(targetBlobName, copyWriter.getResult().getName());
    assertEquals(CONTENT_TYPE, copyWriter.getResult().getContentType());
    assertArrayEquals(BLOB_BYTE_CONTENT, copyWriter.getResult().getContent());
    assertEquals(metadata, copyWriter.getResult().getMetadata());
    assertTrue(copyWriter.isDone());
    assertTrue(remoteBlob.delete());
    assertTrue(storage.delete(BUCKET, targetBlobName));
  }

  @Test
  public void testCopyBlobUpdateMetadata() {
    String sourceBlobName = "test-copy-blob-update-metadata-source";
    BlobId source = BlobId.of(BUCKET, sourceBlobName);
    Blob remoteSourceBlob = storage.create(BlobInfo.newBuilder(source).build(), BLOB_BYTE_CONTENT);
    assertNotNull(remoteSourceBlob);
    String targetBlobName = "test-copy-blob-update-metadata-target";
    ImmutableMap<String, String> metadata = ImmutableMap.of("k", "v");
    BlobInfo target = BlobInfo.newBuilder(BUCKET, targetBlobName)
        .setContentType(CONTENT_TYPE)
        .setMetadata(metadata)
        .build();
    Storage.CopyRequest req = Storage.CopyRequest.of(source, target);
    CopyWriter copyWriter = storage.copy(req);
    assertEquals(BUCKET, copyWriter.getResult().getBucket());
    assertEquals(targetBlobName, copyWriter.getResult().getName());
    assertEquals(CONTENT_TYPE, copyWriter.getResult().getContentType());
    assertEquals(metadata, copyWriter.getResult().getMetadata());
    assertTrue(copyWriter.isDone());
    assertTrue(remoteSourceBlob.delete());
    assertTrue(storage.delete(BUCKET, targetBlobName));
  }

  //Re-enable this test when it stops failing
  //@Test
  public void testCopyBlobUpdateStorageClass() {
    String sourceBlobName = "test-copy-blob-update-storage-class-source";
    BlobId source = BlobId.of(BUCKET, sourceBlobName);
    BlobInfo sourceInfo =
        BlobInfo.newBuilder(source).setStorageClass(StorageClass.STANDARD).build();
    Blob remoteSourceBlob = storage.create(sourceInfo, BLOB_BYTE_CONTENT);
    assertNotNull(remoteSourceBlob);
    assertEquals(StorageClass.STANDARD, remoteSourceBlob.getStorageClass());

    String targetBlobName = "test-copy-blob-update-storage-class-target";
    BlobInfo targetInfo = BlobInfo
        .newBuilder(BUCKET, targetBlobName).setStorageClass(StorageClass.COLDLINE).build();
    Storage.CopyRequest req = Storage.CopyRequest.of(source, targetInfo);
    CopyWriter copyWriter = storage.copy(req);
    assertEquals(BUCKET, copyWriter.getResult().getBucket());
    assertEquals(targetBlobName, copyWriter.getResult().getName());
    assertEquals(StorageClass.COLDLINE, copyWriter.getResult().getStorageClass());
    assertTrue(copyWriter.isDone());
    assertTrue(remoteSourceBlob.delete());
    assertTrue(storage.delete(BUCKET, targetBlobName));
  }

  @Test
  public void testCopyBlobNoContentType() {
    String sourceBlobName = "test-copy-blob-no-content-type-source";
    BlobId source = BlobId.of(BUCKET, sourceBlobName);
    Blob remoteSourceBlob = storage.create(BlobInfo.newBuilder(source).build(), BLOB_BYTE_CONTENT);
    assertNotNull(remoteSourceBlob);
    String targetBlobName = "test-copy-blob-no-content-type-target";
    ImmutableMap<String, String> metadata = ImmutableMap.of("k", "v");
    BlobInfo target = BlobInfo.newBuilder(BUCKET, targetBlobName).setMetadata(metadata).build();
    Storage.CopyRequest req = Storage.CopyRequest.of(source, target);
    CopyWriter copyWriter = storage.copy(req);
    assertEquals(BUCKET, copyWriter.getResult().getBucket());
    assertEquals(targetBlobName, copyWriter.getResult().getName());
    assertNull(copyWriter.getResult().getContentType());
    assertEquals(metadata, copyWriter.getResult().getMetadata());
    assertTrue(copyWriter.isDone());
    assertTrue(remoteSourceBlob.delete());
    assertTrue(storage.delete(BUCKET, targetBlobName));
  }

  @Test
  public void testCopyBlobFail() {
    String sourceBlobName = "test-copy-blob-source-fail";
    BlobId source = BlobId.of(BUCKET, sourceBlobName, -1L);
    Blob remoteSourceBlob = storage.create(BlobInfo.newBuilder(source).build(), BLOB_BYTE_CONTENT);
    assertNotNull(remoteSourceBlob);
    String targetBlobName = "test-copy-blob-target-fail";
    BlobInfo target =
        BlobInfo.newBuilder(BUCKET, targetBlobName).setContentType(CONTENT_TYPE).build();
    Storage.CopyRequest req = Storage.CopyRequest.newBuilder()
        .setSource(BUCKET, sourceBlobName)
        .setSourceOptions(Storage.BlobSourceOption.generationMatch(-1L))
        .setTarget(target)
        .build();
    try {
      storage.copy(req);
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    Storage.CopyRequest req2 = Storage.CopyRequest.newBuilder()
        .setSource(source)
        .setSourceOptions(Storage.BlobSourceOption.generationMatch())
        .setTarget(target)
        .build();
    try {
      storage.copy(req2);
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(remoteSourceBlob.delete());
  }

  @Test
  public void testBatchRequest() {
    String sourceBlobName1 = "test-batch-request-blob-1";
    String sourceBlobName2 = "test-batch-request-blob-2";
    BlobInfo sourceBlob1 = BlobInfo.newBuilder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.newBuilder(BUCKET, sourceBlobName2).build();
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
    StorageBatchResult<Blob> getResult1 = getBatch.get(BUCKET, sourceBlobName1);
    StorageBatchResult<Blob> getResult2 = getBatch.get(BUCKET, sourceBlobName2);
    getBatch.submit();
    Blob remoteBlob1 = getResult1.get();
    Blob remoteBlob2 = getResult2.get();
    assertEquals(remoteUpdatedBlob1, remoteBlob1);
    assertEquals(remoteUpdatedBlob2, remoteBlob2);

    // Batch delete request
    StorageBatch deleteBatch = storage.batch();
    StorageBatchResult<Boolean> deleteResult1 = deleteBatch.delete(BUCKET, sourceBlobName1);
    StorageBatchResult<Boolean> deleteResult2 = deleteBatch.delete(BUCKET, sourceBlobName2);
    deleteBatch.submit();
    assertTrue(deleteResult1.get());
    assertTrue(deleteResult2.get());
  }

  @Test
  public void testBatchRequestManyOperations() {
    List<StorageBatchResult<Boolean>> deleteResults =
        Lists.newArrayListWithCapacity(MAX_BATCH_SIZE);
    List<StorageBatchResult<Blob>> getResults =
        Lists.newArrayListWithCapacity(MAX_BATCH_SIZE / 2);
    List<StorageBatchResult<Blob>> updateResults =
        Lists.newArrayListWithCapacity(MAX_BATCH_SIZE / 2);
    StorageBatch batch = storage.batch();
    for (int i = 0; i < MAX_BATCH_SIZE; i++) {
      BlobId blobId = BlobId.of(BUCKET, "test-batch-request-many-operations-blob-" + i);
      deleteResults.add(batch.delete(blobId));
    }
    for (int i = 0; i < MAX_BATCH_SIZE / 2; i++) {
      BlobId blobId = BlobId.of(BUCKET, "test-batch-request-many-operations-blob-" + i);
      getResults.add(batch.get(blobId));
    }
    for (int i = 0; i < MAX_BATCH_SIZE / 2; i++) {
      BlobInfo blob =
          BlobInfo.newBuilder(BlobId.of(BUCKET, "test-batch-request-many-operations-blob-" + i))
              .build();
      updateResults.add(batch.update(blob));
    }

    String sourceBlobName1 = "test-batch-request-many-operations-source-blob-1";
    String sourceBlobName2 = "test-batch-request-many-operations-source-blob-2";
    BlobInfo sourceBlob1 = BlobInfo.newBuilder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.newBuilder(BUCKET, sourceBlobName2).build();
    assertNotNull(storage.create(sourceBlob1));
    assertNotNull(storage.create(sourceBlob2));
    BlobInfo updatedBlob2 = sourceBlob2.toBuilder().setContentType(CONTENT_TYPE).build();

    StorageBatchResult<Blob> getResult = batch.get(BUCKET, sourceBlobName1);
    StorageBatchResult<Blob> updateResult = batch.update(updatedBlob2);

    batch.submit();

    // Check deletes
    for (StorageBatchResult<Boolean> failedDeleteResult : deleteResults) {
      assertFalse(failedDeleteResult.get());
    }

    // Check gets
    for (StorageBatchResult<Blob> failedGetResult : getResults) {
      assertNull(failedGetResult.get());
    }
    Blob remoteBlob1 = getResult.get();
    assertEquals(sourceBlob1.getBucket(), remoteBlob1.getBucket());
    assertEquals(sourceBlob1.getName(), remoteBlob1.getName());

    // Check updates
    for (StorageBatchResult<Blob> failedUpdateResult : updateResults) {
      try {
        failedUpdateResult.get();
        fail("Expected StorageException");
      } catch (StorageException ex) {
        // expected
      }
    }
    Blob remoteUpdatedBlob2 = updateResult.get();
    assertEquals(sourceBlob2.getBucket(), remoteUpdatedBlob2.getBucket());
    assertEquals(sourceBlob2.getName(), remoteUpdatedBlob2.getName());
    assertEquals(updatedBlob2.getContentType(), remoteUpdatedBlob2.getContentType());

    assertTrue(remoteBlob1.delete());
    assertTrue(remoteUpdatedBlob2.delete());
  }

  @Test
  public void testBatchRequestFail() {
    String blobName = "test-batch-request-blob-fail";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    BlobInfo updatedBlob = BlobInfo.newBuilder(BUCKET, blobName, -1L).build();
    StorageBatch batch = storage.batch();
    StorageBatchResult<Blob> updateResult =
        batch.update(updatedBlob, Storage.BlobTargetOption.generationMatch());
    StorageBatchResult<Boolean> deleteResult1 =
        batch.delete(BUCKET, blobName, Storage.BlobSourceOption.generationMatch(-1L));
    StorageBatchResult<Boolean> deleteResult2 = batch.delete(BlobId.of(BUCKET, blobName, -1L));
    StorageBatchResult<Blob> getResult1 =
        batch.get(BUCKET, blobName, Storage.BlobGetOption.generationMatch(-1L));
    StorageBatchResult<Blob> getResult2 = batch.get(BlobId.of(BUCKET, blobName, -1L));
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
  public void testReadAndWriteChannels() throws IOException {
    String blobName = "test-read-and-write-channels-blob";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    byte[] stringBytes;
    try (WriteChannel writer = storage.writer(blob)) {
      stringBytes = BLOB_STRING_CONTENT.getBytes(UTF_8);
      writer.write(ByteBuffer.wrap(BLOB_BYTE_CONTENT));
      writer.write(ByteBuffer.wrap(stringBytes));
    }
    ByteBuffer readBytes;
    ByteBuffer readStringBytes;
    try (ReadChannel reader = storage.reader(blob.getBlobId())) {
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
  public void testReadAndWriteChannelWithEncryptionKey() throws IOException {
    String blobName = "test-read-write-channel-with-customer-key-blob";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    byte[] stringBytes;
    try (WriteChannel writer = storage.writer(blob,
        Storage.BlobWriteOption.encryptionKey(BASE64_KEY))) {
      stringBytes = BLOB_STRING_CONTENT.getBytes(UTF_8);
      writer.write(ByteBuffer.wrap(BLOB_BYTE_CONTENT));
      writer.write(ByteBuffer.wrap(stringBytes));
    }
    ByteBuffer readBytes;
    ByteBuffer readStringBytes;
    try (ReadChannel reader =
             storage.reader(blob.getBlobId(), Storage.BlobSourceOption.decryptionKey(KEY))) {
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
  public void testReadAndWriteChannelsWithDifferentFileSize() throws IOException {
    String blobNamePrefix = "test-read-and-write-channels-blob-";
    int[] blobSizes = {0, 700, 1024 * 256, 2 * 1024 * 1024, 4 * 1024 * 1024, 4 * 1024 * 1024 + 1};
    Random rnd = new Random();
    for (int blobSize : blobSizes) {
      String blobName = blobNamePrefix + blobSize;
      BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
      byte[] bytes = new byte[blobSize];
      rnd.nextBytes(bytes);
      try (WriteChannel writer = storage.writer(blob)) {
        writer.write(ByteBuffer.wrap(bytes));
      }
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      try (ReadChannel reader = storage.reader(blob.getBlobId())) {
        ByteBuffer buffer = ByteBuffer.allocate(64 * 1024);
        while (reader.read(buffer) > 0) {
          buffer.flip();
          output.write(buffer.array(), 0, buffer.limit());
          buffer.clear();
        }
      }
      assertArrayEquals(bytes, output.toByteArray());
      assertTrue(storage.delete(BUCKET, blobName));
    }
  }

  @Test
  public void testReadAndWriteCaptureChannels() throws IOException {
    String blobName = "test-read-and-write-capture-channels-blob";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    byte[] stringBytes;
    WriteChannel writer = storage.writer(blob);
    stringBytes = BLOB_STRING_CONTENT.getBytes(UTF_8);
    writer.write(ByteBuffer.wrap(BLOB_BYTE_CONTENT));
    RestorableState<WriteChannel> writerState = writer.capture();
    WriteChannel secondWriter = writerState.restore();
    secondWriter.write(ByteBuffer.wrap(stringBytes));
    secondWriter.close();
    ByteBuffer readBytes;
    ByteBuffer readStringBytes;
    ReadChannel reader = storage.reader(blob.getBlobId());
    reader.setChunkSize(BLOB_BYTE_CONTENT.length);
    readBytes = ByteBuffer.allocate(BLOB_BYTE_CONTENT.length);
    reader.read(readBytes);
    RestorableState<ReadChannel> readerState = reader.capture();
    ReadChannel secondReader = readerState.restore();
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
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    try (ReadChannel reader =
        storage.reader(blob.getBlobId(), Storage.BlobSourceOption.metagenerationMatch(-1L))) {
      reader.read(ByteBuffer.allocate(42));
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    try (ReadChannel reader =
             storage.reader(blob.getBlobId(), Storage.BlobSourceOption.generationMatch(-1L))) {
      reader.read(ByteBuffer.allocate(42));
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    BlobId blobIdWrongGeneration = BlobId.of(BUCKET, blobName, -1L);
    try (ReadChannel reader =
             storage.reader(blobIdWrongGeneration, Storage.BlobSourceOption.generationMatch())) {
      reader.read(ByteBuffer.allocate(42));
      fail("StorageException was expected");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(remoteBlob.delete());
  }

  @Test
  public void testReadChannelFailUpdatedGeneration() throws IOException {
    String blobName = "test-read-blob-fail-updated-generation";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    Random random = new Random();
    int chunkSize = 1024;
    int blobSize = 2 * chunkSize;
    byte[] content = new byte[blobSize];
    random.nextBytes(content);
    Blob remoteBlob = storage.create(blob, content);
    assertNotNull(remoteBlob);
    assertEquals(blobSize, (long) remoteBlob.getSize());
    try (ReadChannel reader = storage.reader(blob.getBlobId())) {
      reader.setChunkSize(chunkSize);
      ByteBuffer readBytes = ByteBuffer.allocate(chunkSize);
      int numReadBytes = reader.read(readBytes);
      assertEquals(chunkSize, numReadBytes);
      assertArrayEquals(Arrays.copyOf(content, chunkSize), readBytes.array());
      try (WriteChannel writer = storage.writer(blob)) {
        byte[] newContent = new byte[blobSize];
        random.nextBytes(newContent);
        int numWrittenBytes = writer.write(ByteBuffer.wrap(newContent));
        assertEquals(blobSize, numWrittenBytes);
      }
      readBytes = ByteBuffer.allocate(chunkSize);
      reader.read(readBytes);
      fail("StorageException was expected");
    } catch (StorageException ex) {
      StringBuilder messageBuilder = new StringBuilder();
      messageBuilder.append("Blob ").append(blob.getBlobId()).append(" was updated while reading");
      assertEquals(messageBuilder.toString(), ex.getMessage());
    }
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testWriteChannelFail() throws IOException {
    String blobName = "test-write-channel-blob-fail";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName, -1L).build();
    try {
      try (WriteChannel writer = storage.writer(blob, Storage.BlobWriteOption.generationMatch())) {
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
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    storage.create(blob);
    byte[] stringBytes;
    try (WriteChannel writer = storage.writer(blob)) {
      stringBytes = BLOB_STRING_CONTENT.getBytes(UTF_8);
      writer.write(ByteBuffer.wrap(stringBytes));
    }
    assertArrayEquals(stringBytes, storage.readAllBytes(blob.getBlobId()));
    assertTrue(storage.delete(BUCKET, blobName));
  }

  @Test
  public void testGetSignedUrl() throws IOException {
    String blobName = "test-get-signed-url-blob/with/slashes/and?special=!#$&'()*+,:;=?@[]";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    Blob remoteBlob = storage.create(blob, BLOB_BYTE_CONTENT);
    assertNotNull(remoteBlob);
    URL url = storage.signUrl(blob, 1, TimeUnit.HOURS);
    URLConnection connection = url.openConnection();
    byte[] readBytes = new byte[BLOB_BYTE_CONTENT.length];
    try (InputStream responseStream = connection.getInputStream()) {
      assertEquals(BLOB_BYTE_CONTENT.length, responseStream.read(readBytes));
      assertArrayEquals(BLOB_BYTE_CONTENT, readBytes);
      assertTrue(remoteBlob.delete());
    }
  }

  @Test
  public void testPostSignedUrl() throws IOException {
    String blobName = "test-post-signed-url-blob";
    BlobInfo blob = BlobInfo.newBuilder(BUCKET, blobName).build();
    assertNotNull(storage.create(blob));
    URL url =
        storage.signUrl(blob, 1, TimeUnit.HOURS, Storage.SignUrlOption.httpMethod(HttpMethod.POST));
    URLConnection connection = url.openConnection();
    connection.setDoOutput(true);
    connection.connect();
    Blob remoteBlob = storage.get(BUCKET, blobName);
    assertNotNull(remoteBlob);
    assertEquals(blob.getBucket(), remoteBlob.getBucket());
    assertEquals(blob.getName(), remoteBlob.getName());
    assertTrue(remoteBlob.delete());
  }

  @Test
  public void testGetBlobs() {
    String sourceBlobName1 = "test-get-blobs-1";
    String sourceBlobName2 = "test-get-blobs-2";
    BlobInfo sourceBlob1 = BlobInfo.newBuilder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.newBuilder(BUCKET, sourceBlobName2).build();
    assertNotNull(storage.create(sourceBlob1));
    assertNotNull(storage.create(sourceBlob2));
    List<Blob> remoteBlobs = storage.get(sourceBlob1.getBlobId(), sourceBlob2.getBlobId());
    assertEquals(sourceBlob1.getBucket(), remoteBlobs.get(0).getBucket());
    assertEquals(sourceBlob1.getName(), remoteBlobs.get(0).getName());
    assertEquals(sourceBlob2.getBucket(), remoteBlobs.get(1).getBucket());
    assertEquals(sourceBlob2.getName(), remoteBlobs.get(1).getName());
    assertTrue(remoteBlobs.get(0).delete());
    assertTrue(remoteBlobs.get(1).delete());
  }

  @Test
  public void testDownloadPublicBlobWithoutAuthentication() {
    // create an unauthorized user
    Storage unauthorizedStorage = StorageOptions.getUnauthenticatedInstance().getService();

    // try to download blobs from a public bucket
    String landsatBucket = "gcp-public-data-landsat";
    String landsatPrefix = "LC08/PRE/044/034/LC80440342016259LGN00/";
    String landsatBlob = landsatPrefix + "LC80440342016259LGN00_MTL.txt";
    byte[] bytes = unauthorizedStorage.readAllBytes(landsatBucket, landsatBlob);
    assertThat(bytes.length).isEqualTo(7903);
    int numBlobs = 0;
    Iterator<Blob> blobIterator = unauthorizedStorage
      .list(landsatBucket, Storage.BlobListOption.prefix(landsatPrefix))
      .iterateAll().iterator();
    while (blobIterator.hasNext()) {
      numBlobs++;
      blobIterator.next();
    }
    assertThat(numBlobs).isEqualTo(13);

    // try to download blobs from a bucket that requires authentication
    // authenticated client will succeed
    // unauthenticated client will receive an exception
    String sourceBlobName = "source-blob-name";
    BlobInfo sourceBlob = BlobInfo.newBuilder(BUCKET, sourceBlobName).build();
    assertThat(storage.create(sourceBlob)).isNotNull();
    assertThat(storage.readAllBytes(BUCKET, sourceBlobName)).isNotNull();
    try {
      unauthorizedStorage.readAllBytes(BUCKET, sourceBlobName);
      fail("Expected StorageException");
    } catch (StorageException ex) {
      // expected
    }
    assertThat(storage.get(sourceBlob.getBlobId()).delete()).isTrue();

    // try to upload blobs to a bucket that requires authentication
    // authenticated client will succeed
    // unauthenticated client will receive an exception
    assertThat(storage.create(sourceBlob)).isNotNull();
    try {
      unauthorizedStorage.create(sourceBlob);
      fail("Expected StorageException");
    } catch (StorageException ex) {
      // expected
    }
    assertThat(storage.get(sourceBlob.getBlobId()).delete()).isTrue();
  }

  @Test
  public void testGetBlobsFail() {
    String sourceBlobName1 = "test-get-blobs-fail-1";
    String sourceBlobName2 = "test-get-blobs-fail-2";
    BlobInfo sourceBlob1 = BlobInfo.newBuilder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.newBuilder(BUCKET, sourceBlobName2).build();
    assertNotNull(storage.create(sourceBlob1));
    List<Blob> remoteBlobs = storage.get(sourceBlob1.getBlobId(), sourceBlob2.getBlobId());
    assertEquals(sourceBlob1.getBucket(), remoteBlobs.get(0).getBucket());
    assertEquals(sourceBlob1.getName(), remoteBlobs.get(0).getName());
    assertNull(remoteBlobs.get(1));
    assertTrue(remoteBlobs.get(0).delete());
  }

  @Test
  public void testDeleteBlobs() {
    String sourceBlobName1 = "test-delete-blobs-1";
    String sourceBlobName2 = "test-delete-blobs-2";
    BlobInfo sourceBlob1 = BlobInfo.newBuilder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.newBuilder(BUCKET, sourceBlobName2).build();
    assertNotNull(storage.create(sourceBlob1));
    assertNotNull(storage.create(sourceBlob2));
    List<Boolean> deleteStatus = storage.delete(sourceBlob1.getBlobId(), sourceBlob2.getBlobId());
    assertTrue(deleteStatus.get(0));
    assertTrue(deleteStatus.get(1));
  }

  @Test
  public void testDeleteBlobsFail() {
    String sourceBlobName1 = "test-delete-blobs-fail-1";
    String sourceBlobName2 = "test-delete-blobs-fail-2";
    BlobInfo sourceBlob1 = BlobInfo.newBuilder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.newBuilder(BUCKET, sourceBlobName2).build();
    assertNotNull(storage.create(sourceBlob1));
    List<Boolean> deleteStatus = storage.delete(sourceBlob1.getBlobId(), sourceBlob2.getBlobId());
    assertTrue(deleteStatus.get(0));
    assertFalse(deleteStatus.get(1));
  }

  @Test
  public void testUpdateBlobs() {
    String sourceBlobName1 = "test-update-blobs-1";
    String sourceBlobName2 = "test-update-blobs-2";
    BlobInfo sourceBlob1 = BlobInfo.newBuilder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.newBuilder(BUCKET, sourceBlobName2).build();
    Blob remoteBlob1 = storage.create(sourceBlob1);
    Blob remoteBlob2 = storage.create(sourceBlob2);
    assertNotNull(remoteBlob1);
    assertNotNull(remoteBlob2);
    List<Blob> updatedBlobs = storage.update(
        remoteBlob1.toBuilder().setContentType(CONTENT_TYPE).build(),
        remoteBlob2.toBuilder().setContentType(CONTENT_TYPE).build());
    assertEquals(sourceBlob1.getBucket(), updatedBlobs.get(0).getBucket());
    assertEquals(sourceBlob1.getName(), updatedBlobs.get(0).getName());
    assertEquals(CONTENT_TYPE, updatedBlobs.get(0).getContentType());
    assertEquals(sourceBlob2.getBucket(), updatedBlobs.get(1).getBucket());
    assertEquals(sourceBlob2.getName(), updatedBlobs.get(1).getName());
    assertEquals(CONTENT_TYPE, updatedBlobs.get(1).getContentType());
    assertTrue(updatedBlobs.get(0).delete());
    assertTrue(updatedBlobs.get(1).delete());
  }

  @Test
  public void testUpdateBlobsFail() {
    String sourceBlobName1 = "test-update-blobs-fail-1";
    String sourceBlobName2 = "test-update-blobs-fail-2";
    BlobInfo sourceBlob1 = BlobInfo.newBuilder(BUCKET, sourceBlobName1).build();
    BlobInfo sourceBlob2 = BlobInfo.newBuilder(BUCKET, sourceBlobName2).build();
    BlobInfo remoteBlob1 = storage.create(sourceBlob1);
    assertNotNull(remoteBlob1);
    List<Blob> updatedBlobs = storage.update(
        remoteBlob1.toBuilder().setContentType(CONTENT_TYPE).build(),
        sourceBlob2.toBuilder().setContentType(CONTENT_TYPE).build());
    assertEquals(sourceBlob1.getBucket(), updatedBlobs.get(0).getBucket());
    assertEquals(sourceBlob1.getName(), updatedBlobs.get(0).getName());
    assertEquals(CONTENT_TYPE, updatedBlobs.get(0).getContentType());
    assertNull(updatedBlobs.get(1));
    assertTrue(updatedBlobs.get(0).delete());
  }

  @Test
  public void testBucketAcl() {
    testBucketAclRequesterPays(true);
    testBucketAclRequesterPays(false);
  }

  private void testBucketAclRequesterPays(boolean requesterPays) {
    if (requesterPays) {
      Bucket remoteBucket = storage.get(BUCKET, Storage.BucketGetOption.fields(BucketField.ID));
      assertNull(remoteBucket.requesterPays());
      remoteBucket = remoteBucket.toBuilder().setRequesterPays(true).build();
      Bucket updatedBucket = storage.update(remoteBucket);
      assertTrue(updatedBucket.requesterPays());
    }

    String projectId = remoteStorageHelper.getOptions().getProjectId();

    Storage.BucketSourceOption[] bucketOptions = requesterPays
        ? new Storage.BucketSourceOption[] {Storage.BucketSourceOption.userProject(projectId)}
        : new Storage.BucketSourceOption[] {};

    assertNull(storage.getAcl(BUCKET, User.ofAllAuthenticatedUsers(), bucketOptions));
    assertFalse(storage.deleteAcl(BUCKET, User.ofAllAuthenticatedUsers(), bucketOptions));
    Acl acl = Acl.of(User.ofAllAuthenticatedUsers(), Role.READER);
    assertNotNull(storage.createAcl(BUCKET, acl, bucketOptions));
    Acl updatedAcl = storage.updateAcl(BUCKET, acl.toBuilder().setRole(Role.WRITER).build(), bucketOptions);
    assertEquals(Role.WRITER, updatedAcl.getRole());
    Set<Acl> acls = new HashSet<>();
    acls.addAll(storage.listAcls(BUCKET, bucketOptions));
    assertTrue(acls.contains(updatedAcl));
    assertTrue(storage.deleteAcl(BUCKET, User.ofAllAuthenticatedUsers(), bucketOptions));
    assertNull(storage.getAcl(BUCKET, User.ofAllAuthenticatedUsers(), bucketOptions));
  }

  @Test
  public void testBucketDefaultAcl() {
    assertNull(storage.getDefaultAcl(BUCKET, User.ofAllAuthenticatedUsers()));
    assertFalse(storage.deleteDefaultAcl(BUCKET, User.ofAllAuthenticatedUsers()));
    Acl acl = Acl.of(User.ofAllAuthenticatedUsers(), Role.READER);
    assertNotNull(storage.createDefaultAcl(BUCKET, acl));
    Acl updatedAcl = storage.updateDefaultAcl(BUCKET, acl.toBuilder().setRole(Role.OWNER).build());
    assertEquals(Role.OWNER, updatedAcl.getRole());
    Set<Acl> acls = new HashSet<>();
    acls.addAll(storage.listDefaultAcls(BUCKET));
    assertTrue(acls.contains(updatedAcl));
    assertTrue(storage.deleteDefaultAcl(BUCKET, User.ofAllAuthenticatedUsers()));
    assertNull(storage.getDefaultAcl(BUCKET, User.ofAllAuthenticatedUsers()));
  }

  @Test
  public void testBlobAcl() {
    BlobId blobId = BlobId.of(BUCKET, "test-blob-acl");
    BlobInfo blob = BlobInfo.newBuilder(blobId).build();
    storage.create(blob);
    assertNull(storage.getAcl(blobId, User.ofAllAuthenticatedUsers()));
    Acl acl = Acl.of(User.ofAllAuthenticatedUsers(), Role.READER);
    assertNotNull(storage.createAcl(blobId, acl));
    Acl updatedAcl = storage.updateAcl(blobId, acl.toBuilder().setRole(Role.OWNER).build());
    assertEquals(Role.OWNER, updatedAcl.getRole());
    Set<Acl> acls = new HashSet<>(storage.listAcls(blobId));
    assertTrue(acls.contains(updatedAcl));
    assertTrue(storage.deleteAcl(blobId, User.ofAllAuthenticatedUsers()));
    assertNull(storage.getAcl(blobId, User.ofAllAuthenticatedUsers()));
    // test non-existing blob
    BlobId otherBlobId = BlobId.of(BUCKET, "test-blob-acl", -1L);
    try {
      assertNull(storage.getAcl(otherBlobId, User.ofAllAuthenticatedUsers()));
      fail("Expected an 'Invalid argument' exception");
    } catch (StorageException e) {
      assertThat(e.getMessage()).contains("Invalid argument");
    }

    try {
      assertFalse(storage.deleteAcl(otherBlobId, User.ofAllAuthenticatedUsers()));
      fail("Expected an 'Invalid argument' exception");
    } catch (StorageException e) {
      assertThat(e.getMessage()).contains("Invalid argument");
    }

    try {
      storage.createAcl(otherBlobId, acl);
      fail("Expected StorageException");
    } catch (StorageException ex) {
      // expected
    }
    try {
      storage.updateAcl(otherBlobId, acl);
      fail("Expected StorageException");
    } catch (StorageException ex) {
      // expected
    }
    try {
      storage.listAcls(otherBlobId);
      fail("Expected StorageException");
    } catch (StorageException ex) {
      // expected
    }
  }

  @Test
  public void testReadCompressedBlob() throws IOException {
    String blobName = "test-read-compressed-blob";
    BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(BUCKET, blobName))
        .setContentType("text/plain")
        .setContentEncoding("gzip")
        .build();
    Blob blob = storage.create(blobInfo, COMPRESSED_CONTENT);
    try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
      try (ReadChannel reader = storage.reader(BlobId.of(BUCKET, blobName))) {
        reader.setChunkSize(8);
        ByteBuffer buffer = ByteBuffer.allocate(8);
        while (reader.read(buffer) != -1) {
          buffer.flip();
          output.write(buffer.array(), 0, buffer.limit());
          buffer.clear();
        }
      }
      assertArrayEquals(BLOB_STRING_CONTENT.getBytes(UTF_8),
          storage.readAllBytes(BUCKET, blobName));
      assertArrayEquals(COMPRESSED_CONTENT, output.toByteArray());
      try (GZIPInputStream zipInput =
               new GZIPInputStream(new ByteArrayInputStream(output.toByteArray()))) {
        assertArrayEquals(BLOB_STRING_CONTENT.getBytes(UTF_8), ByteStreams.toByteArray(zipInput));
      }
    }
    blob.delete();
  }

  @Test
  public void testBucketPolicy() {
    testBucketPolicyRequesterPays(true);
    testBucketPolicyRequesterPays(false);
  }

  private void testBucketPolicyRequesterPays(boolean requesterPays) {
    if (requesterPays) {
      Bucket remoteBucket = storage.get(BUCKET, Storage.BucketGetOption.fields(BucketField.ID));
      assertNull(remoteBucket.requesterPays());
      remoteBucket = remoteBucket.toBuilder().setRequesterPays(true).build();
      Bucket updatedBucket = storage.update(remoteBucket);
      assertTrue(updatedBucket.requesterPays());
    }

    String projectId = remoteStorageHelper.getOptions().getProjectId();

    Storage.BucketSourceOption[] bucketOptions = requesterPays
        ? new Storage.BucketSourceOption[] {Storage.BucketSourceOption.userProject(projectId)}
        : new Storage.BucketSourceOption[] {};
    Identity projectOwner = Identity.projectOwner(projectId);
    Identity projectEditor = Identity.projectEditor(projectId);
    Identity projectViewer = Identity.projectViewer(projectId);
    Map<com.google.cloud.Role, Set<Identity>> bindingsWithoutPublicRead =
        ImmutableMap.of(
            StorageRoles.legacyBucketOwner(),
            new HashSet<>(Arrays.asList(projectOwner, projectEditor)),
            StorageRoles.legacyBucketReader(), (Set<Identity>) new HashSet<>(Collections.singleton(projectViewer)));
    Map<com.google.cloud.Role, Set<Identity>> bindingsWithPublicRead =
        ImmutableMap.of(
            StorageRoles.legacyBucketOwner(),
            new HashSet<>(Arrays.asList(projectOwner, projectEditor)),
            StorageRoles.legacyBucketReader(), new HashSet<>(Collections.singleton(projectViewer)),
            StorageRoles.legacyObjectReader(), (Set<Identity>) new HashSet<>(Collections.singleton((Identity.allUsers()))));

    // Validate getting policy.
    Policy currentPolicy = storage.getIamPolicy(BUCKET, bucketOptions);
    assertEquals(bindingsWithoutPublicRead, currentPolicy.getBindings());

    // Validate updating policy.
    Policy updatedPolicy =
        storage.setIamPolicy(
            BUCKET,
            currentPolicy.toBuilder()
                .addIdentity(StorageRoles.legacyObjectReader(), Identity.allUsers())
                .build(),
            bucketOptions);
    assertEquals(bindingsWithPublicRead, updatedPolicy.getBindings());
    Policy revertedPolicy =
        storage.setIamPolicy(
            BUCKET,
            updatedPolicy.toBuilder()
                .removeIdentity(StorageRoles.legacyObjectReader(), Identity.allUsers())
                .build(),
            bucketOptions);
    assertEquals(bindingsWithoutPublicRead, revertedPolicy.getBindings());

    // Validate testing permissions.
    List<Boolean> expectedPermissions = ImmutableList.of(true, true);
    assertEquals(
        expectedPermissions,
        storage.testIamPermissions(
            BUCKET,
            ImmutableList.of("storage.buckets.getIamPolicy", "storage.buckets.setIamPolicy"),
            bucketOptions));
  }

  @Test
  public void testUpdateBucketLabel() {
    Bucket remoteBucket = storage.get(BUCKET, Storage.BucketGetOption.fields(BucketField.ID));
    assertNull(remoteBucket.getLabels());
    remoteBucket = remoteBucket.toBuilder().setLabels(BUCKET_LABELS).build();
    Bucket updatedBucket = storage.update(remoteBucket);
    assertEquals(BUCKET_LABELS, updatedBucket.getLabels());
  }

  @Test
  public void testUpdateBucketRequesterPays() {
    Bucket remoteBucket = storage.get(BUCKET, Storage.BucketGetOption.fields(BucketField.ID));
    assertNull(remoteBucket.requesterPays());
    remoteBucket = remoteBucket.toBuilder().setRequesterPays(true).build();
    Bucket updatedBucket = storage.update(remoteBucket);
    assertTrue(updatedBucket.requesterPays());

    String projectId = remoteStorageHelper.getOptions().getProjectId();
    Bucket.BlobTargetOption option = Bucket.BlobTargetOption.userProject(projectId);
    String blobName = "test-create-empty-blob-requester-pays";
    Blob remoteBlob = updatedBucket.create(blobName, BLOB_BYTE_CONTENT, option);
    assertNotNull(remoteBlob);
    byte[] readBytes = storage.readAllBytes(BUCKET, blobName);
    assertArrayEquals(BLOB_BYTE_CONTENT, readBytes);
    assertTrue(remoteBlob.delete());
  }

  @Test
  public void testListBucketRequesterPaysFails() throws InterruptedException {
    String projectId = remoteStorageHelper.getOptions().getProjectId();
    Iterator<Bucket> bucketIterator = storage.list(Storage.BucketListOption.prefix(BUCKET),
        Storage.BucketListOption.fields(), Storage.BucketListOption.userProject(projectId)).iterateAll().iterator();
    while (!bucketIterator.hasNext()) {
      Thread.sleep(500);
      bucketIterator = storage.list(Storage.BucketListOption.prefix(BUCKET),
          Storage.BucketListOption.fields()).iterateAll().iterator();
    }
    while (bucketIterator.hasNext()) {
      Bucket remoteBucket = bucketIterator.next();
      assertTrue(remoteBucket.getName().startsWith(BUCKET));
      assertNull(remoteBucket.getCreateTime());
      assertNull(remoteBucket.getSelfLink());
    }
  }

  @Test
  public void testGetServiceAccount() throws InterruptedException {
    String projectId = remoteStorageHelper.getOptions().getProjectId();
    ServiceAccount serviceAccount = storage.getServiceAccount(projectId);
    assertNotNull(serviceAccount);
    assertEquals(SERVICE_ACCOUNT_EMAIL, serviceAccount.getEmail());
  }
}
