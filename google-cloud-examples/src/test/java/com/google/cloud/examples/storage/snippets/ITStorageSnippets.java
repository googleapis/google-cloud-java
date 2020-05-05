/*
 * Copyright 2016 Google LLC
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

import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.collect.Sets;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class ITStorageSnippets {

  private static final Logger log = Logger.getLogger(ITStorageSnippets.class.getName());
  private static final String BUCKET = RemoteStorageHelper.generateBucketName();
  private static final byte[] BLOB_BYTE_CONTENT = {0xD, 0xE, 0xA, 0xD};
  private static final String USER_EMAIL =
      "google-cloud-java-tests@" + "java-docs-samples-tests.iam.gserviceaccount.com";

  private static final String KMS_KEY_NAME =
      "projects/gcloud-devel/locations/us/" + "keyRings/gcs_kms_key_ring_us/cryptoKeys/key";
  private static final Long RETENTION_PERIOD = 5L; // 5 seconds
  private static Storage storage;
  private static StorageSnippets storageSnippets;
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Rule public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() {
    RemoteStorageHelper helper = RemoteStorageHelper.create();
    storage = helper.getOptions().getService();
    storageSnippets = new StorageSnippets(storage);
    storageSnippets.createBucket(BUCKET);
  }

  @AfterClass
  public static void afterClass() throws ExecutionException, InterruptedException {
    if (storage != null) {
      // In beforeClass, we make buckets auto-delete blobs older than a day old.
      // Here, delete all buckets older than 2 days. They should already be empty and easy.
      long cleanTime = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(2);
      long cleanTimeout = System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1);
      RemoteStorageHelper.cleanBuckets(storage, cleanTime, cleanTimeout);

      boolean wasDeleted = RemoteStorageHelper.forceDelete(storage, BUCKET, 1, TimeUnit.MINUTES);
      if (!wasDeleted && log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, "Deletion of bucket {0} timed out, bucket is not empty", BUCKET);
      }
    }
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
    assertTrue(
        storageSnippets.deleteBlobFromIdWithGeneration(BUCKET, blobName, blob.getGeneration()));
    copiedBlob.delete();
  }

  @Test
  public void testCreateCopyAndGetBlobFromSubArray() {
    String blobName = "test-create-copy-get-blob-from-sub-array";
    Blob blob = storageSnippets.createBlobWithSubArrayFromByteArray(BUCKET, blobName, 7, 1);
    assertNotNull(blob);
    Blob copiedBlob = storageSnippets.copyBlobInChunks(BUCKET, blobName, "copy-blob");
    assertNotNull(copiedBlob);
    try {
      storageSnippets.getBlobFromIdWithMetageneration(BUCKET, blobName, -1);
      fail("Expected StorageException to be thrown");
    } catch (StorageException ex) {
      // expected
    }
    assertTrue(
        storageSnippets.deleteBlobFromIdWithGeneration(BUCKET, blobName, blob.getGeneration()));
    copiedBlob.delete();
  }

  @Test
  public void testCreateBlobFromInputStream() {
    Blob blob =
        storageSnippets.createBlobFromInputStream(BUCKET, "test-create-blob-from-input-stream");
    assertNotNull(blob);
    assertTrue(
        storageSnippets.deleteBlobFromIdWithGeneration(
            BUCKET, "test-create-blob-from-input-stream", blob.getGeneration()));
  }

  @Test
  public void testGetBucketWithMetageneration() {
    thrown.expect(StorageException.class);
    storageSnippets.getBucketWithMetageneration(BUCKET, -1);
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
    BlobInfo blobInfo1 = BlobInfo.newBuilder(BUCKET, sourceBlobName1).build();
    BlobInfo blobInfo2 = BlobInfo.newBuilder(BUCKET, sourceBlobName2).build();
    storage.create(blobInfo1);
    storage.create(blobInfo2);
    assertNotNull(storageSnippets.composeBlobs(BUCKET, blobName, sourceBlobName1, sourceBlobName2));
  }

  @Test
  public void testReadWriteAndSignUrl() throws IOException {
    String blobName = "text-read-write-sign-url";
    byte[] content = "Hello, World!".getBytes(UTF_8);
    Blob blob = storage.create(BlobInfo.newBuilder(BUCKET, blobName).build(), content);
    assertArrayEquals(
        content, storageSnippets.readBlobFromId(BUCKET, blobName, blob.getGeneration()));
    assertArrayEquals(
        content,
        storageSnippets.readBlobFromStringsWithGeneration(BUCKET, blobName, blob.getGeneration()));
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
    signedUrl =
        storageSnippets.signUrlWithSigner(
            BUCKET, blobName, System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
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
    storage.create(BlobInfo.newBuilder(BUCKET, blobName1).build());
    storage.create(BlobInfo.newBuilder(BUCKET, blobName2).build());
    List<Blob> blobs = storageSnippets.batchGet(BUCKET, blobName1, blobName2);
    assertEquals(blobName1, blobs.get(0).getName());
    assertEquals(blobName2, blobs.get(1).getName());
    blobs = storageSnippets.batchUpdate(BUCKET, blobName1, blobName2);
    assertEquals(blobName1, blobs.get(0).getName());
    assertEquals(blobName2, blobs.get(1).getName());
    assertEquals("text/plain", blobs.get(0).getContentType());
    assertEquals("text/plain", blobs.get(1).getContentType());
    assertNotNull(storageSnippets.batch(BUCKET, blobName1, blobName2));
    List<Boolean> deleted = storageSnippets.batchDelete(BUCKET, blobName1, blobName2);
    assertFalse(deleted.get(0));
    assertTrue(deleted.get(1));
  }

  @Test
  public void testBatchIterable() throws IOException {
    String blobName1 = "test-batch-iterable1";
    String blobName2 = "test-batch-iterable2";
    storage.create(BlobInfo.newBuilder(BUCKET, blobName1).build());
    storage.create(BlobInfo.newBuilder(BUCKET, blobName2).build());
    List<Blob> blobs = storageSnippets.batchGetIterable(BUCKET, blobName1, blobName2);
    assertEquals(blobName1, blobs.get(0).getName());
    assertEquals(blobName2, blobs.get(1).getName());
    blobs = storageSnippets.batchUpdateIterable(BUCKET, blobName1, blobName2);
    assertEquals(blobName1, blobs.get(0).getName());
    assertEquals(blobName2, blobs.get(1).getName());
    assertEquals("text/plain", blobs.get(0).getContentType());
    assertEquals("text/plain", blobs.get(1).getContentType());
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
    assertEquals(Acl.Role.OWNER, updatedAcl.getRole());
    Set<Acl> acls = Sets.newHashSet(storageSnippets.listBucketAcls(BUCKET));
    assertTrue(acls.contains(updatedAcl));

    assertNotNull(storageSnippets.getBucketAcl(BUCKET));
    assertNull(storageSnippets.getBucketAcl(BUCKET, USER_EMAIL));
    storage.createAcl(BUCKET, Acl.of(new User(USER_EMAIL), Role.READER));
    Acl userAcl = storageSnippets.getBucketAcl(BUCKET, USER_EMAIL);
    assertNotNull(userAcl);
    assertEquals(USER_EMAIL, ((User) userAcl.getEntity()).getEmail());

    assertTrue(storageSnippets.deleteBucketAcl(BUCKET));
    assertNull(storageSnippets.getBucketAcl(BUCKET));
  }

  @Test
  public void testDefaultBucketAcl() {
    assertNull(storageSnippets.getDefaultBucketAcl(BUCKET));
    assertFalse(storageSnippets.deleteDefaultBucketAcl(BUCKET));
    assertNotNull(storageSnippets.createDefaultBucketAcl(BUCKET));
    Acl updatedAcl = storageSnippets.updateDefaultBucketAcl(BUCKET);
    assertEquals(Acl.Role.OWNER, updatedAcl.getRole());
    Set<Acl> acls = Sets.newHashSet(storageSnippets.listDefaultBucketAcls(BUCKET));
    assertTrue(acls.contains(updatedAcl));
    assertTrue(storageSnippets.deleteDefaultBucketAcl(BUCKET));
    assertNull(storageSnippets.getDefaultBucketAcl(BUCKET));
  }

  @Test
  public void testBlobAcl() {
    String blobName = "test-blob-acl";
    BlobId blobId = BlobId.of(BUCKET, "test-blob-acl");
    BlobInfo blob = BlobInfo.newBuilder(blobId).build();
    Blob createdBlob = storage.create(blob);
    assertNull(storageSnippets.getBlobAcl(BUCKET, blobName, createdBlob.getGeneration()));
    assertNotNull(storageSnippets.createBlobAcl(BUCKET, blobName, createdBlob.getGeneration()));
    Acl updatedAcl = storageSnippets.updateBlobAcl(BUCKET, blobName, createdBlob.getGeneration());
    assertEquals(Acl.Role.OWNER, updatedAcl.getRole());
    Set<Acl> acls =
        Sets.newHashSet(
            storageSnippets.listBlobAcls(BUCKET, blobName, createdBlob.getGeneration()));
    assertTrue(acls.contains(updatedAcl));

    assertNull(storageSnippets.getBlobAcl(BUCKET, blobName, USER_EMAIL));
    storage.createAcl(BlobId.of(BUCKET, blobName), Acl.of(new User(USER_EMAIL), Role.READER));
    Acl userAcl = storageSnippets.getBlobAcl(BUCKET, blobName, USER_EMAIL);
    assertNotNull(userAcl);
    assertEquals(USER_EMAIL, ((User) userAcl.getEntity()).getEmail());

    assertNotNull(storageSnippets.getBlobAcl(BUCKET, blobName, createdBlob.getGeneration()));
    assertTrue(storageSnippets.deleteBlobAcl(BUCKET, blobName, createdBlob.getGeneration()));
    assertNull(storageSnippets.getBlobAcl(BUCKET, blobName, createdBlob.getGeneration()));
    // test non-existing blob
    String nonExistingBlob = "test-blob-acl";
    assertNull(storageSnippets.getBlobAcl(BUCKET, nonExistingBlob, 1L));
    assertFalse(storageSnippets.deleteBlobAcl(BUCKET, nonExistingBlob, 1L));
    try {
      storageSnippets.createBlobAcl(BUCKET, nonExistingBlob, 1L);
      fail("Expected StorageException");
    } catch (StorageException ex) {
      // expected
    }
    try {
      storageSnippets.updateBlobAcl(BUCKET, nonExistingBlob, 1L);
      fail("Expected StorageException");
    } catch (StorageException ex) {
      // expected
    }
    try {
      storageSnippets.listBlobAcls(BUCKET, nonExistingBlob, 1L);
      fail("Expected StorageException");
    } catch (StorageException ex) {
      // expected
    }
  }

  @Test
  public void testListBuckets() {
    ByteArrayOutputStream snippetOutputCapture = new ByteArrayOutputStream();
    System.setOut(new PrintStream(snippetOutputCapture));
    storageSnippets.listBuckets();
    String snippetOutput = snippetOutputCapture.toString();
    System.setOut(System.out);
    assertTrue(snippetOutput.contains("Buckets:"));
  }

  @Test
  public void testBucketRetention() {
    Bucket bucket = storageSnippets.setRetentionPolicy(BUCKET, RETENTION_PERIOD);
    assertEquals(bucket.getRetentionPeriod(), RETENTION_PERIOD);
    assertNotNull(bucket.getRetentionEffectiveTime());
    bucket = storageSnippets.getRetentionPolicy(BUCKET);
    assertEquals(bucket.getRetentionPeriod(), RETENTION_PERIOD);
    assertNotNull(bucket.getRetentionEffectiveTime());
    assertNull(bucket.retentionPolicyIsLocked());
    bucket = storageSnippets.enableDefaultEventBasedHold(BUCKET);
    assertTrue(bucket.getDefaultEventBasedHold());
    bucket = storageSnippets.getDefaultEventBasedHold(BUCKET);
    assertTrue(bucket.getDefaultEventBasedHold());
    String blobName = "test-create-empty-blob-retention-policy";
    Blob remoteBlob = bucket.create(blobName, BLOB_BYTE_CONTENT);
    assertTrue(remoteBlob.getEventBasedHold());
    remoteBlob = storageSnippets.setEventBasedHold(BUCKET, blobName);
    assertTrue(remoteBlob.getEventBasedHold());
    remoteBlob = storageSnippets.releaseEventBasedHold(BUCKET, blobName);
    assertFalse(remoteBlob.getEventBasedHold());
    assertNotNull(remoteBlob.getRetentionExpirationTime());
    bucket = storageSnippets.removeRetentionPolicy(BUCKET);
    assertNull(bucket.getRetentionPeriod());
    assertNull(bucket.getRetentionEffectiveTime());
    bucket = storageSnippets.disableDefaultEventBasedHold(BUCKET);
    assertFalse(bucket.getDefaultEventBasedHold());
    remoteBlob = storageSnippets.setTemporaryHold(BUCKET, blobName);
    assertTrue(remoteBlob.getTemporaryHold());
    remoteBlob = storageSnippets.releaseTemporaryHold(BUCKET, blobName);
    assertFalse(remoteBlob.getTemporaryHold());
  }

  @Test
  public void testLockRetentionPolicy() {
    String tempBucket = RemoteStorageHelper.generateBucketName();
    Bucket bucket = storageSnippets.createBucket(tempBucket);
    assertNotNull(bucket);
    bucket = storageSnippets.setRetentionPolicy(tempBucket, RETENTION_PERIOD);
    assertEquals(bucket.getRetentionPeriod(), RETENTION_PERIOD);
    bucket = storageSnippets.lockRetentionPolicy(tempBucket);
    assertTrue(bucket.retentionPolicyIsLocked());
  }

  @Test
  public void testUniformBucketLevelAccess() {
    String tempBucket = RemoteStorageHelper.generateBucketName();
    Bucket bucket = storageSnippets.createBucket(tempBucket);
    assertNotNull(bucket);
    bucket = storageSnippets.enableUniformBucketLevelAccess(tempBucket);
    assertTrue(bucket.getIamConfiguration().isUniformBucketLevelAccessEnabled());
    assertNotNull(bucket.getIamConfiguration().getUniformBucketLevelAccessLockedTime());
    bucket = storageSnippets.getUniformBucketLevelAccess(tempBucket);
    assertTrue(bucket.getIamConfiguration().isUniformBucketLevelAccessEnabled());
    assertNotNull(bucket.getIamConfiguration().getUniformBucketLevelAccessLockedTime());
    bucket = storageSnippets.disableUniformBucketLevelAccess(tempBucket);
    assertFalse(bucket.getIamConfiguration().isUniformBucketLevelAccessEnabled());
  }

  @Test
  public void testGetServiceAccount() {
    PrintStream systemOut = System.out;
    final ByteArrayOutputStream snippetOutputCapture = new ByteArrayOutputStream();
    System.setOut(new PrintStream(snippetOutputCapture));
    GetServiceAccount.getServiceAccount(PROJECT_ID);
    String snippetOutput = snippetOutputCapture.toString();
    System.setOut(systemOut);

    assertTrue(snippetOutput.contains("service"));
    assertTrue(snippetOutput.contains("@gs-project-accounts.iam.gserviceaccount.com"));
  }

  @Test
  public void testDefaultKMSKey() {
    Bucket bucket = storageSnippets.setDefaultKmsKey(BUCKET, KMS_KEY_NAME);
    assertEquals(KMS_KEY_NAME, bucket.getDefaultKmsKeyName());
    // Remove default key
    storageSnippets.setDefaultKmsKey(BUCKET, null);
  }

  @Test
  public void testCreateKMSEncryptedBlob() {
    String blobName = "kms-encrypted-blob";
    Blob blob = storageSnippets.createKmsEncrpytedBlob(BUCKET, blobName, KMS_KEY_NAME);
    assertNotNull(blob);
  }

  @Test
  public void testGenerateSignedPostPolicyV4() throws Exception {
    PrintStream systemOut = System.out;
    final ByteArrayOutputStream snippetOutputCapture = new ByteArrayOutputStream();
    System.setOut(new PrintStream(snippetOutputCapture));
    GenerateSignedPostPolicyV4.generateSignedPostPolicyV4(PROJECT_ID, BUCKET, "my-object");
    String snippetOutput = snippetOutputCapture.toString();
    System.setOut(systemOut);
    assertTrue(
        snippetOutput.contains("<form action='https://storage.googleapis.com/" + BUCKET + "/'"));
    assertTrue(snippetOutput.contains("<input name='key' value='my-object'"));
    assertTrue(snippetOutput.contains("<input name='x-goog-signature'"));
    assertTrue(snippetOutput.contains("<input name='x-goog-date'"));
    assertTrue(snippetOutput.contains("<input name='x-goog-credential'"));
    assertTrue(snippetOutput.contains("<input name='x-goog-algorithm' value='GOOG4-RSA-SHA256'"));
    assertTrue(snippetOutput.contains("<input name='policy'"));
    assertTrue(snippetOutput.contains("<input name='x-goog-meta-test' value='data'"));
    assertTrue(snippetOutput.contains("<input type='file' name='file'/>"));

    String[] output = snippetOutput.split("'");
    HttpClient client = HttpClientBuilder.create().build();
    HttpPost request = new HttpPost(output[1]);
    MultipartEntityBuilder builder = MultipartEntityBuilder.create();

    Map<String, String> policy = new HashMap<>();
    /**
     * When splitting by "'", any element in the form has its value two array elements ahead of it,
     * for example ["x-goog-algorithm", "value=", "GOOG4-RSA-SHA256"] We take advantage of this to
     * make a map which has any policy element easily accessible. The map also has a lot of noise,
     * but we just use the parts we need
     */
    for (int i = 3; i < output.length - 3; i += 2) {
      policy.put(output[i], output[i + 2]);
    }

    builder.addTextBody("x-goog-date", policy.get("x-goog-date"));
    builder.addTextBody("x-goog-meta-test", "data");
    builder.addTextBody("x-goog-algorithm", "GOOG4-RSA-SHA256");
    builder.addTextBody("x-goog-credential", policy.get("x-goog-credential"));
    builder.addTextBody("key", "my-object");
    builder.addTextBody("x-goog-signature", policy.get("x-goog-signature"));
    builder.addTextBody("policy", policy.get("policy"));

    File file = File.createTempFile("temp", "file");
    Files.write(file.toPath(), "hello world".getBytes());
    builder.addBinaryBody(
        "file", new FileInputStream(file), ContentType.APPLICATION_OCTET_STREAM, file.getName());
    request.setEntity(builder.build());

    client.execute(request);

    assertEquals("hello world", new String(storage.get(BUCKET, "my-object").getContent()));
  }
}
