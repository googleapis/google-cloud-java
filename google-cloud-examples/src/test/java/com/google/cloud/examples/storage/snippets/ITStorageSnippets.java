/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.examples.storage.snippets;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.Page;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ITStorageSnippets {

  private static final Logger log = Logger.getLogger(ITStorageSnippets.class.getName());
  private static final String BUCKET = RemoteStorageHelper.generateBucketName();

  private static Storage storage;
  private static StorageSnippets storageSnippets;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() {
    RemoteStorageHelper helper = RemoteStorageHelper.create();
    storage = helper.options().service();
    storageSnippets = new StorageSnippets(storage);
    storageSnippets.createBucket(BUCKET);
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

  @Test
  public void testBlob() throws InterruptedException {
    String blobName = "directory/test-blob";
    Blob blob = storageSnippets.createBlob(BUCKET, blobName);
    assertNotNull(blob);
    blob = storageSnippets.getBlobFromId(BUCKET, blobName);
    assertNotNull(blob);
    blob = storageSnippets.updateBlob(BUCKET, blobName);
    assertNotNull(blob);
    blob = storageSnippets.updateBlobWithMetageneration(BUCKET, blobName);
    assertNotNull(blob);
    Blob copiedBlob = storageSnippets.copyBlob(BUCKET, blobName, "directory/copy-blob");
    assertNotNull(copiedBlob);
    Page<Blob> blobs = storageSnippets.listBlobsWithDirectoryAndPrefix(BUCKET, "directory/");
    while (Iterators.size(blobs.iterateAll()) < 2) {
      Thread.sleep(500);
      blobs = storageSnippets.listBlobsWithDirectoryAndPrefix(BUCKET, "directory/");
    }
    Set<String> blobNames = new HashSet<>();
    Iterator<Blob> blobIterator = blobs.iterateAll();
    while (blobIterator.hasNext()) {
      blobNames.add(blobIterator.next().name());
    }
    assertTrue(blobNames.contains(blobName));
    assertTrue(blobNames.contains("directory/copy-blob"));
    try {
      storageSnippets.getBlobFromStringsWithMetageneration(BUCKET, blobName, -1);
      fail("Expected StorageException to be thrown");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(storageSnippets.deleteBlob(BUCKET, blobName));
    copiedBlob.delete();
  }

  @Test
  public void testCreateCopyAndGetBlob() {
    String blobName = "test-create-copy-get-blob";
    Blob blob = storageSnippets.createBlobFromByteArray(BUCKET, blobName);
    assertNotNull(blob);
    Blob copiedBlob = storageSnippets.copyBlobInChunks(BUCKET, blobName, "copy-blob");
    assertNotNull(copiedBlob);
    try {
      storageSnippets.getBlobFromIdWithMetageneration(BUCKET, blobName, -1);
      fail("Expected StorageException to be thrown");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(storageSnippets.deleteBlobFromIdWithGeneration(BUCKET, blobName, blob.generation()));
    copiedBlob.delete();
  }

  @Test
  public void testCreateBlobFromInputStream() {
    Blob blob =
        storageSnippets.createBlobFromInputStream(BUCKET, "test-create-blob-from-input-stream");
    assertNotNull(blob);
    assertTrue(storageSnippets.deleteBlobFromIdWithGeneration(
        BUCKET, "test-create-blob-from-input-stream", blob.generation()));
  }

  @Test
  public void testGetBucketWithMetageneration() {
    thrown.expect(StorageException.class);
    storageSnippets.getBucketWithMetageneration(BUCKET, -1);
  }

  @Test
  public void testListBucketsWithSizeAndPrefix() throws InterruptedException {
    Page<Bucket> buckets = storageSnippets.listBucketsWithSizeAndPrefix(BUCKET);
    while (Iterators.size(buckets.iterateAll()) < 1) {
      Thread.sleep(500);
      buckets = storageSnippets.listBucketsWithSizeAndPrefix(BUCKET);
    }
    Iterator<Bucket> bucketIterator = buckets.iterateAll();
    while (bucketIterator.hasNext()) {
      assertTrue(bucketIterator.next().name().startsWith(BUCKET));
    }
  }

  @Test
  public void testUpdateBucket() {
    assertNotNull(storageSnippets.updateBucket(BUCKET));
  }

  @Test
  public void testDeleteBucketWithMetageneration() {
    thrown.expect(StorageException.class);
    storageSnippets.deleteBucketWithMetageneration(BUCKET, -1);
  }

  @Test
  public void testComposeBlobs() {
    String blobName = "my_blob_name";
    String sourceBlobName1 = "source_blob_1";
    String sourceBlobName2 = "source_blob_2";
    BlobInfo blobInfo1 = BlobInfo.builder(BUCKET, sourceBlobName1).build();
    BlobInfo blobInfo2 = BlobInfo.builder(BUCKET, sourceBlobName2).build();
    storage.create(blobInfo1);
    storage.create(blobInfo2);
    assertNotNull(storageSnippets.composeBlobs(BUCKET, blobName, sourceBlobName1, sourceBlobName2));
  }

  @Test
  public void testReadWriteAndSignUrl() throws IOException {
    String blobName = "text-read-write-sign-url";
    byte[] content = "Hello, World!".getBytes(UTF_8);
    Blob blob = storage.create(
        BlobInfo.builder(BUCKET, blobName).build(), content);
    assertArrayEquals(content, storageSnippets.readBlobFromId(BUCKET, blobName, blob.generation()));
    assertArrayEquals(content,
        storageSnippets.readBlobFromStringsWithGeneration(BUCKET, blobName, blob.generation()));
    storageSnippets.readerFromId(BUCKET, blobName);
    storageSnippets.readerFromStrings(BUCKET, blobName);
    storageSnippets.writer(BUCKET, blobName);
    URL signedUrl = storageSnippets.signUrl(BUCKET, blobName);
    URLConnection connection = signedUrl.openConnection();
    byte[] readBytes = new byte[content.length];
    try (InputStream responseStream = connection.getInputStream()) {
      assertEquals(content.length, responseStream.read(readBytes));
      assertArrayEquals(content, readBytes);
    }
    signedUrl = storageSnippets.signUrlWithSigner(BUCKET, blobName,
        System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
    connection = signedUrl.openConnection();
    try (InputStream responseStream = connection.getInputStream()) {
      assertEquals(content.length, responseStream.read(readBytes));
      assertArrayEquals(content, readBytes);
    }
    blob.delete();
  }

  @Test
  public void testBatch() throws IOException {
    String blobName1 = "test-batch1";
    String blobName2 = "test-batch2";
    storage.create(BlobInfo.builder(BUCKET, blobName1).build());
    storage.create(BlobInfo.builder(BUCKET, blobName2).build());
    List<Blob> blobs = storageSnippets.batchGet(BUCKET, blobName1, blobName2);
    assertEquals(blobName1, blobs.get(0).name());
    assertEquals(blobName2, blobs.get(1).name());
    blobs = storageSnippets.batchUpdate(BUCKET, blobName1, blobName2);
    assertEquals(blobName1, blobs.get(0).name());
    assertEquals(blobName2, blobs.get(1).name());
    assertEquals("text/plain", blobs.get(0).contentType());
    assertEquals("text/plain", blobs.get(1).contentType());
    assertNotNull(storageSnippets.batch(BUCKET, blobName1, blobName2));
    List<Boolean> deleted = storageSnippets.batchDelete(BUCKET, blobName1, blobName2);
    assertFalse(deleted.get(0));
    assertTrue(deleted.get(1));
  }

  @Test
  public void testBatchIterable() throws IOException {
    String blobName1 = "test-batch-iterable1";
    String blobName2 = "test-batch-iterable2";
    storage.create(BlobInfo.builder(BUCKET, blobName1).build());
    storage.create(BlobInfo.builder(BUCKET, blobName2).build());
    List<Blob> blobs = storageSnippets.batchGetIterable(BUCKET, blobName1, blobName2);
    assertEquals(blobName1, blobs.get(0).name());
    assertEquals(blobName2, blobs.get(1).name());
    blobs = storageSnippets.batchUpdateIterable(BUCKET, blobName1, blobName2);
    assertEquals(blobName1, blobs.get(0).name());
    assertEquals(blobName2, blobs.get(1).name());
    assertEquals("text/plain", blobs.get(0).contentType());
    assertEquals("text/plain", blobs.get(1).contentType());
    assertNotNull(storageSnippets.batch(BUCKET, blobName1, blobName2));
    List<Boolean> deleted = storageSnippets.batchDeleteIterable(BUCKET, blobName1, blobName2);
    assertFalse(deleted.get(0));
    assertTrue(deleted.get(1));
  }

  @Test
  public void testBucketAcl() {
    assertNull(storageSnippets.getBucketAcl(BUCKET));
    assertFalse(storageSnippets.deleteBucketAcl(BUCKET));
    assertNotNull(storageSnippets.createBucketAcl(BUCKET));
    Acl updatedAcl = storageSnippets.updateBucketAcl(BUCKET);
    assertEquals(Acl.Role.OWNER, updatedAcl.role());
    Set<Acl> acls = Sets.newHashSet(storageSnippets.listBucketAcls(BUCKET));
    assertTrue(acls.contains(updatedAcl));
    assertTrue(storageSnippets.deleteBucketAcl(BUCKET));
    assertNull(storageSnippets.getBucketAcl(BUCKET));
  }

  @Test
  public void testDefaultBucketAcl() {
    assertNull(storageSnippets.getDefaultBucketAcl(BUCKET));
    assertFalse(storageSnippets.deleteDefaultBucketAcl(BUCKET));
    assertNotNull(storageSnippets.createDefaultBucketAcl(BUCKET));
    Acl updatedAcl = storageSnippets.updateDefaultBucketAcl(BUCKET);
    assertEquals(Acl.Role.OWNER, updatedAcl.role());
    Set<Acl> acls = Sets.newHashSet(storageSnippets.listDefaultBucketAcls(BUCKET));
    assertTrue(acls.contains(updatedAcl));
    assertTrue(storageSnippets.deleteDefaultBucketAcl(BUCKET));
    assertNull(storageSnippets.getDefaultBucketAcl(BUCKET));
  }

  @Test
  public void testBlobAcl() {
    String blobName = "test-blob-acl";
    BlobId blobId = BlobId.of(BUCKET, "test-blob-acl");
    BlobInfo blob = BlobInfo.builder(blobId).build();
    Blob createdBlob = storage.create(blob);
    assertNull(storageSnippets.getBlobAcl(BUCKET, blobName, createdBlob.generation()));
    assertNotNull(storageSnippets.createBlobAcl(BUCKET, blobName, createdBlob.generation()));
    Acl updatedAcl = storageSnippets.updateBlobAcl(BUCKET, blobName, createdBlob.generation());
    assertEquals(Acl.Role.OWNER, updatedAcl.role());
    Set<Acl> acls =
        Sets.newHashSet(storageSnippets.listBlobAcls(BUCKET, blobName, createdBlob.generation()));
    assertTrue(acls.contains(updatedAcl));
    assertTrue(storageSnippets.deleteBlobAcl(BUCKET, blobName, createdBlob.generation()));
    assertNull(storageSnippets.getBlobAcl(BUCKET, blobName, createdBlob.generation()));
    // test non-existing blob
    String nonExistingBlob = "test-blob-acl";
    assertNull(storageSnippets.getBlobAcl(BUCKET, nonExistingBlob, -1L));
    assertFalse(storageSnippets.deleteBlobAcl(BUCKET, nonExistingBlob, -1L));
    try {
      storageSnippets.createBlobAcl(BUCKET, nonExistingBlob, -1L);
      fail("Expected StorageException");
    } catch (StorageException ex) {
      // expected
    }
    try {
      storageSnippets.updateBlobAcl(BUCKET, nonExistingBlob, -1L);
      fail("Expected StorageException");
    } catch (StorageException ex) {
      // expected
    }
    try {
      storageSnippets.listBlobAcls(BUCKET, nonExistingBlob, -1L);
      fail("Expected StorageException");
    } catch (StorageException ex) {
      // expected
    }
  }
}
