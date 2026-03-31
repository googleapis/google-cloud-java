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

package com.example.storage;

import static com.example.storage.Env.GOOGLE_CLOUD_PROJECT;
import static com.google.common.truth.Truth.assertThat;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.example.storage.object.AtomicMoveObject;
import com.example.storage.object.BatchSetObjectMetadata;
import com.example.storage.object.ChangeObjectCsekToKms;
import com.example.storage.object.ChangeObjectStorageClass;
import com.example.storage.object.ComposeObject;
import com.example.storage.object.CopyDeleteObject;
import com.example.storage.object.CopyObject;
import com.example.storage.object.CopyOldVersionOfObject;
import com.example.storage.object.DeleteObject;
import com.example.storage.object.DeleteOldVersionOfObject;
import com.example.storage.object.DownloadEncryptedObject;
import com.example.storage.object.DownloadObject;
import com.example.storage.object.DownloadObjectIntoMemory;
import com.example.storage.object.DownloadPublicObject;
import com.example.storage.object.GenerateEncryptionKey;
import com.example.storage.object.GenerateV4GetObjectSignedUrl;
import com.example.storage.object.GenerateV4PutObjectSignedUrl;
import com.example.storage.object.GetObjectContexts;
import com.example.storage.object.GetObjectMetadata;
import com.example.storage.object.ListObjectContexts;
import com.example.storage.object.ListObjects;
import com.example.storage.object.ListObjectsWithOldVersions;
import com.example.storage.object.ListObjectsWithPrefix;
import com.example.storage.object.ListSoftDeletedObjects;
import com.example.storage.object.ListSoftDeletedVersionsOfObject;
import com.example.storage.object.MakeObjectPublic;
import com.example.storage.object.RestoreSoftDeletedObject;
import com.example.storage.object.RotateObjectEncryptionKey;
import com.example.storage.object.SetObjectContexts;
import com.example.storage.object.SetObjectMetadata;
import com.example.storage.object.SetObjectRetentionPolicy;
import com.example.storage.object.StreamObjectDownload;
import com.example.storage.object.StreamObjectUpload;
import com.example.storage.object.UploadEncryptedObject;
import com.example.storage.object.UploadKmsEncryptedObject;
import com.example.storage.object.UploadObject;
import com.example.storage.object.UploadObjectFromMemory;
import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobInfo.ObjectContexts;
import com.google.cloud.storage.BlobInfo.ObjectCustomContextPayload;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.IamConfiguration;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.Storage.BucketTargetOption;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.TmpFile;
import com.google.cloud.storage.it.BucketCleaner;
import com.google.cloud.storage.it.TemporaryBucket;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.KmsFixture;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.io.BaseEncoding;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import javax.net.ssl.HttpsURLConnection;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ITObjectSnippets extends TestBase {

  private static final String STRING_CONTENT = "Hello, World!";
  private static final byte[] CONTENT = STRING_CONTENT.getBytes(UTF_8);

  @Rule public final TemporaryFolder tmpDir = new TemporaryFolder();

  @Inject public KmsFixture kmsFixture;

  @Test
  public void testChangeObjectStorageClass() {
    String objectName = generator.randomObjectName();
    BlobInfo gen1 = storage.create(info(objectName), CONTENT, BlobTargetOption.doesNotExist());
    Assert.assertNotEquals(StorageClass.COLDLINE, gen1.getStorageClass());
    ChangeObjectStorageClass.changeObjectStorageClass(
        GOOGLE_CLOUD_PROJECT, bucket.getName(), objectName);
    Blob gen2 = storage.get(bucket.getName(), objectName);
    assertEquals(StorageClass.COLDLINE, gen2.getStorageClass());
    assertArrayEquals(CONTENT, gen2.getContent());
  }

  @Test
  public void testCopyObject() throws Exception {
    try (TemporaryBucket tmpBucket =
        TemporaryBucket.newBuilder()
            .setBucketInfo(BucketInfo.newBuilder(generator.randomBucketName()).build())
            .setStorage(storage)
            .build()) {

      String newBucket = tmpBucket.getBucket().getName();

      String objectName = generator.randomObjectName();
      storage.create(info(objectName));
      CopyObject.copyObject(GOOGLE_CLOUD_PROJECT, bucket.getName(), objectName, newBucket);
      assertNotNull(storage.get(newBucket, objectName));
    }
  }

  @Test
  public void testDeleteObject() {
    String blob = generator.randomObjectName();
    storage.create(BlobInfo.newBuilder(BlobId.of(bucket.getName(), blob)).build());
    assertNotNull(storage.get(bucket.getName(), blob));
    DeleteObject.deleteObject(GOOGLE_CLOUD_PROJECT, bucket.getName(), blob);
    assertNull(storage.get(bucket.getName(), blob));
  }

  @Test
  public void testDownloadObject() throws Exception {
    Path baseDir = tmpDir.getRoot().toPath();
    try (TmpFile file1 = DataGenerator.base64Characters().tempFile(baseDir, 13)) {
      String objectName = generator.randomObjectName();
      storage.createFrom(info(objectName), file1.getPath(), BlobWriteOption.doesNotExist());
      DownloadObject.downloadObject(
          GOOGLE_CLOUD_PROJECT, bucket.getName(), objectName, file1.getPath().toString());
      byte[] expected = Files.readAllBytes(file1.getPath());
      byte[] actual = storage.readAllBytes(bucket.getName(), objectName);
      assertArrayEquals(expected, actual);
    }
  }

  @Test
  public void testDownloadObjectIntoMemory() throws IOException {
    String objectName = generator.randomObjectName();
    storage.create(info(objectName), CONTENT, BlobTargetOption.doesNotExist());
    DownloadObjectIntoMemory.downloadObjectIntoMemory(
        GOOGLE_CLOUD_PROJECT, bucket.getName(), objectName);
    String snippetOutput = stdOut.getCapturedOutputAsUtf8String();
    assertThat(snippetOutput).contains("The contents of " + objectName);
  }

  @Ignore("TODO(b/456381873): Test fails in CI due to project's public access prevention policy.")
  @Test
  public void testDownloadPublicObject() throws Exception {
    try (TemporaryBucket tmpBucket =
        TemporaryBucket.newBuilder()
            .setBucketInfo(
                BucketInfo.newBuilder(generator.randomBucketName())
                    .setIamConfiguration(
                        IamConfiguration.newBuilder()
                            .setIsUniformBucketLevelAccessEnabled(false)
                            .build())
                    .build())
            .setStorage(storage)
            .build()) {
      String bucketName = tmpBucket.getBucket().getName();

      String publicBlob = generator.randomObjectName();
      BlobId publicBlobId = BlobId.of(bucketName, publicBlob);
      Blob gen1 =
          storage.create(
              BlobInfo.newBuilder(publicBlobId).build(), CONTENT, BlobTargetOption.doesNotExist());
      storage.createAcl(gen1.getBlobId(), Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
      File tempFile = tmpDir.newFile("file.txt");
      DownloadPublicObject.downloadPublicObject(bucketName, publicBlob, tempFile.toPath());
      assertEquals("Hello, World!", new String(Files.readAllBytes(tempFile.toPath())));
    }
  }

  @Test
  public void testGetObjectMetadata() {
    String blobName = generator.randomObjectName();
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setMetadata(ImmutableMap.of("k", "v")).build();
    Blob remoteBlob = storage.create(blobInfo, CONTENT);
    assertNotNull(remoteBlob);
    GetObjectMetadata.getObjectMetadata(GOOGLE_CLOUD_PROJECT, bucket.getName(), blobName);
    String snippetOutput = stdOut.getCapturedOutputAsUtf8String();
    assertTrue(snippetOutput.contains("Bucket: " + remoteBlob.getBucket()));
    assertTrue(snippetOutput.contains("Bucket: " + remoteBlob.getBucket()));
    assertTrue(snippetOutput.contains("CacheControl: " + remoteBlob.getCacheControl()));
    assertTrue(snippetOutput.contains("ComponentCount: " + remoteBlob.getComponentCount()));
    assertTrue(snippetOutput.contains("ContentDisposition: " + remoteBlob.getContentDisposition()));
    assertTrue(snippetOutput.contains("ContentEncoding: " + remoteBlob.getContentEncoding()));
    assertTrue(snippetOutput.contains("ContentLanguage: " + remoteBlob.getContentLanguage()));
    assertTrue(snippetOutput.contains("ContentType: " + remoteBlob.getContentType()));
    assertTrue(snippetOutput.contains("CustomTime: " + remoteBlob.getCustomTime()));
    assertTrue(snippetOutput.contains("Crc32c: " + remoteBlob.getCrc32c()));
    assertTrue(snippetOutput.contains("Crc32cHexString: " + remoteBlob.getCrc32cToHexString()));
    assertTrue(snippetOutput.contains("ETag: " + remoteBlob.getEtag()));
    assertTrue(snippetOutput.contains("Generation: " + remoteBlob.getGeneration()));
    assertTrue(snippetOutput.contains("Id: " + remoteBlob.getBlobId()));
    assertTrue(snippetOutput.contains("KmsKeyName: " + remoteBlob.getKmsKeyName()));
    assertTrue(snippetOutput.contains("Md5Hash: " + remoteBlob.getMd5()));
    assertTrue(snippetOutput.contains("Md5HexString: " + remoteBlob.getMd5ToHexString()));
    assertTrue(snippetOutput.contains("MediaLink: " + remoteBlob.getMediaLink()));
    assertTrue(snippetOutput.contains("Metageneration: " + remoteBlob.getMetageneration()));
    assertTrue(snippetOutput.contains("Name: " + remoteBlob.getName()));
    assertTrue(snippetOutput.contains("Size: " + remoteBlob.getSize()));
    assertTrue(snippetOutput.contains("StorageClass: " + remoteBlob.getStorageClass()));
    assertTrue(snippetOutput.contains("TimeCreated: " + new Date(remoteBlob.getCreateTime())));
    assertTrue(
        snippetOutput.contains("Last Metadata Update: " + new Date(remoteBlob.getUpdateTime())));
    assertTrue(snippetOutput.contains("temporaryHold: disabled"));
    assertTrue(snippetOutput.contains("eventBasedHold: disabled"));
    assertTrue(snippetOutput.contains("User metadata:"));
    assertTrue(snippetOutput.contains("k=v"));
    assertTrue(snippetOutput.contains("Object Retention Policy: " + remoteBlob.getRetention()));
  }

  @Test
  public void testListObjects() {
    String name1 = generator.randomObjectName();
    storage.create(info(name1), BlobTargetOption.doesNotExist());
    ListObjects.listObjects(GOOGLE_CLOUD_PROJECT, bucket.getName());
    String snippetOutput = stdOut.getCapturedOutputAsUtf8String();
    assertTrue(snippetOutput.contains(name1));
  }

  @Test
  public void testListObjectsWithPrefix() {
    String prefix = generator.randomObjectName();
    storage.create(BlobInfo.newBuilder(bucket.getName(), prefix + "a/1.txt").build());
    storage.create(BlobInfo.newBuilder(bucket.getName(), prefix + "a/b/2.txt").build());
    storage.create(BlobInfo.newBuilder(bucket.getName(), prefix + "a/b/3.txt").build());
    ListObjectsWithPrefix.listObjectsWithPrefix(
        GOOGLE_CLOUD_PROJECT, bucket.getName(), prefix + "a/");
    String snippetOutput = stdOut.getCapturedOutputAsUtf8String();
    assertTrue(snippetOutput.contains("a/1.txt"));
    assertTrue(snippetOutput.contains("a/b/"));
    assertFalse(snippetOutput.contains("a/b/2.txt"));
  }

  @Test
  public void testCopyDeleteObject() throws Exception {
    String blob = generator.randomObjectName();
    String newBlob = generator.randomObjectName();

    try (TemporaryBucket tmpBucket =
        TemporaryBucket.newBuilder()
            .setBucketInfo(BucketInfo.newBuilder(generator.randomBucketName()).build())
            .setStorage(storage)
            .build()) {

      String newBucket = tmpBucket.getBucket().getName();
      BlobInfo gen1 = storage.create(BlobInfo.newBuilder(BlobId.of(newBucket, blob)).build());
      CopyDeleteObject.copyDeleteObject(GOOGLE_CLOUD_PROJECT, newBucket, blob, newBucket, newBlob);
      assertNotNull(storage.get(newBucket, newBlob));
      assertNull(storage.get(bucket.getName(), blob));
    }
  }

  @Test
  public void testAtomicMoveObject() {
    String blob1 = generator.randomObjectName();
    String blob2 = generator.randomObjectName();

    String bucketName = bucket.getName();
    BlobInfo gen1 = storage.create(BlobInfo.newBuilder(BlobId.of(bucketName, blob1)).build());
    AtomicMoveObject.moveObject(GOOGLE_CLOUD_PROJECT, bucketName, blob1, blob2);
    assertThat(storage.get(bucketName, blob1)).isNull();
    assertThat(storage.get(bucketName, blob2)).isNotNull();
    assertThat(stdOut.getCapturedOutputAsUtf8String()).contains("Moved object");
  }

  @Test
  public void testSetObjectMetadata() {
    String bucketName = bucket.getName();
    String name1 = generator.randomObjectName();
    BlobInfo b1Gen1 = storage.create(BlobInfo.newBuilder(bucketName, name1).build());

    SetObjectMetadata.setObjectMetadata(GOOGLE_CLOUD_PROJECT, bucket.getName(), name1);
    BlobInfo b1Gen2 = storage.get(bucketName, name1);
    assertThat(b1Gen2).isNotNull();
    assertThat(b1Gen2.getMetadata()).containsAtLeast("keyToAddOrUpdate", "value");
  }

  @Test
  public void testUploadObject() throws IOException {
    Path baseDir = tmpDir.getRoot().toPath();
    try (TmpFile file1 = DataGenerator.base64Characters().tempFile(baseDir, 13)) {
      String objectName = generator.randomObjectName();
      UploadObject.uploadObject(
          GOOGLE_CLOUD_PROJECT, bucket.getName(), objectName, file1.getPath().toString());
      byte[] expected = Files.readAllBytes(file1.getPath());
      byte[] actual = storage.readAllBytes(bucket.getName(), objectName);
      assertArrayEquals(expected, actual);
    }
  }

  @Test
  public void testUploadObjectFromMemory() throws IOException {
    String objectName = "uploadobjectfrommemorytest";
    UploadObjectFromMemory.uploadObjectFromMemory(
        GOOGLE_CLOUD_PROJECT, bucket.getName(), objectName, STRING_CONTENT);
    final byte[] output = storage.get(bucket.getName(), objectName).getContent();
    assertEquals(STRING_CONTENT, new String(output, UTF_8));
  }

  @Test
  public void testObjectCSEKOperations() throws IOException {
    GenerateEncryptionKey.generateEncryptionKey();
    String snippetOutput = stdOut.getCapturedOutputAsUtf8String();
    String encryptionKey = snippetOutput.split(": ")[1].trim();

    File tempFile = tmpDir.newFile("file.txt");
    File downloadFile = tmpDir.newFile("dlfile.txt");
    String encryptedBlob = "uploadencryptedobjecttest";
    Files.write(tempFile.toPath(), CONTENT);

    UploadEncryptedObject.uploadEncryptedObject(
        GOOGLE_CLOUD_PROJECT, bucket.getName(), encryptedBlob, tempFile.getPath(), encryptionKey);
    DownloadEncryptedObject.downloadEncryptedObject(
        GOOGLE_CLOUD_PROJECT,
        bucket.getName(),
        encryptedBlob,
        downloadFile.toPath(),
        encryptionKey);
    assertArrayEquals(CONTENT, Files.readAllBytes(downloadFile.toPath()));

    byte[] key = new byte[32];
    new Random().nextBytes(key);
    String newEncryptionKey = BaseEncoding.base64().encode(key);
    RotateObjectEncryptionKey.rotateObjectEncryptionKey(
        GOOGLE_CLOUD_PROJECT, bucket.getName(), encryptedBlob, encryptionKey, newEncryptionKey);
    File newDownloadFile = tmpDir.newFile("newdownloadfile.txt");
    DownloadEncryptedObject.downloadEncryptedObject(
        GOOGLE_CLOUD_PROJECT,
        bucket.getName(),
        encryptedBlob,
        newDownloadFile.toPath(),
        newEncryptionKey);
    assertArrayEquals(CONTENT, Files.readAllBytes(newDownloadFile.toPath()));

    assertNull(storage.get(bucket.getName(), encryptedBlob).getKmsKeyName());
    CryptoKey key1 = kmsFixture.getKey1();
    ChangeObjectCsekToKms.changeObjectFromCsekToKms(
        GOOGLE_CLOUD_PROJECT, bucket.getName(), encryptedBlob, newEncryptionKey, key1.getName());
    assertTrue(
        storage.get(bucket.getName(), encryptedBlob).getKmsKeyName().contains(key1.getName()));
  }

  @Test
  public void testObjectVersioningOperations() throws Exception {
    try (TemporaryBucket tmpBucket =
        TemporaryBucket.newBuilder()
            .setBucketInfo(
                BucketInfo.newBuilder(generator.randomBucketName())
                    .setVersioningEnabled(true)
                    .build())
            .setStorage(storage)
            .build()) {
      String bucketName = tmpBucket.getBucket().getName();

      String versionedBlob = generator.randomObjectName();
      final Blob originalBlob =
          storage.create(BlobInfo.newBuilder(bucketName, versionedBlob).build(), CONTENT);
      byte[] content2 = "Hello, World 2".getBytes(UTF_8);
      storage.create(BlobInfo.newBuilder(bucketName, versionedBlob).build(), content2);

      ListObjectsWithOldVersions.listObjectsWithOldVersions(GOOGLE_CLOUD_PROJECT, bucketName);
      String snippetOutput = stdOut.getCapturedOutputAsUtf8String();

      snippetOutput = snippetOutput.replaceFirst(versionedBlob, "");
      assertTrue(snippetOutput.contains(versionedBlob));

      String copiedblob = generator.randomObjectName();
      CopyOldVersionOfObject.copyOldVersionOfObject(
          GOOGLE_CLOUD_PROJECT,
          bucketName,
          versionedBlob,
          originalBlob.getGeneration(),
          copiedblob);
      assertArrayEquals(CONTENT, storage.get(bucketName, copiedblob).getContent());

      DeleteOldVersionOfObject.deleteOldVersionOfObject(
          GOOGLE_CLOUD_PROJECT, bucketName, versionedBlob, originalBlob.getGeneration());
      assertNull(storage.get(BlobId.of(bucketName, versionedBlob, originalBlob.getGeneration())));
      assertNotNull(storage.get(bucketName, versionedBlob));
    }
  }

  @Test
  public void testV4SignedURLs() throws IOException {
    String tempObject = "test-upload-signed-url-object";
    GenerateV4PutObjectSignedUrl.generateV4PutObjectSignedUrl(
        GOOGLE_CLOUD_PROJECT, bucket.getName(), tempObject);
    String snippetOutput = stdOut.getCapturedOutputAsUtf8String();
    String url = snippetOutput.split("\n")[1];
    URL uploadUrl = new URL(url);
    HttpsURLConnection connection = (HttpsURLConnection) uploadUrl.openConnection();
    connection.setRequestMethod("PUT");
    connection.setDoOutput(true);
    connection.setRequestProperty("Content-Type", "application/octet-stream");
    try (OutputStream out = connection.getOutputStream()) {
      out.write(CONTENT);
      assertEquals(connection.getResponseCode(), 200);
    }
    GenerateV4GetObjectSignedUrl.generateV4GetObjectSignedUrl(
        GOOGLE_CLOUD_PROJECT, bucket.getName(), tempObject);
    snippetOutput = stdOut.getCapturedOutputAsUtf8String();
    url = snippetOutput.split("\n")[5];
    URL downloadUrl = new URL(url);
    connection = (HttpsURLConnection) downloadUrl.openConnection();
    byte[] readBytes = new byte[CONTENT.length];
    try (InputStream responseStream = connection.getInputStream()) {
      assertEquals(CONTENT.length, responseStream.read(readBytes));
      assertArrayEquals(CONTENT, readBytes);
    }
  }

  @Ignore("TODO(b/456381873): Test fails in CI due to project's public access prevention policy.")
  @Test
  public void testMakeObjectPublic() {
    String aclBlob = generator.randomObjectName();
    assertNull(
        storage
            .create(BlobInfo.newBuilder(bucket.getName(), aclBlob).build())
            .getAcl(Acl.User.ofAllUsers()));
    MakeObjectPublic.makeObjectPublic(GOOGLE_CLOUD_PROJECT, bucket.getName(), aclBlob);
    assertNotNull(storage.get(bucket.getName(), aclBlob).getAcl(Acl.User.ofAllUsers()));
  }

  @Test
  public void testComposeObject() {
    String firstObject = generator.randomObjectName();
    String secondObject = generator.randomObjectName();
    String targetObject = generator.randomObjectName();
    storage.create(
        BlobInfo.newBuilder(bucket.getName(), firstObject).build(), firstObject.getBytes(UTF_8));
    storage.create(
        BlobInfo.newBuilder(bucket.getName(), secondObject).build(), secondObject.getBytes(UTF_8));

    ComposeObject.composeObject(
        bucket.getName(), firstObject, secondObject, targetObject, GOOGLE_CLOUD_PROJECT);

    String got = stdOut.getCapturedOutputAsUtf8String();
    assertThat(got).contains(firstObject);
    assertThat(got).contains(secondObject);
    assertThat(got).contains(targetObject);
  }

  @Test
  public void testStreamUploadDownload() throws Exception {
    String blobName = generator.randomObjectName();
    StreamObjectUpload.streamObjectUpload(
        GOOGLE_CLOUD_PROJECT, bucket.getName(), blobName, "hello world");
    String got1 = stdOut.getCapturedOutputAsUtf8String();
    assertThat(got1).contains(blobName);
    assertThat(got1).contains("WriteChannel");

    File file = tmpDir.newFile();
    StreamObjectDownload.streamObjectDownload(
        GOOGLE_CLOUD_PROJECT, bucket.getName(), blobName, file.getAbsolutePath());
    String got2 = stdOut.getCapturedOutputAsUtf8String();
    assertThat(got2).contains(blobName);
    assertThat(got2).contains("ReadChannel");
  }

  @Test
  public void testUploadKMSEncryptedObject() {
    String blobName = generator.randomObjectName();
    UploadKmsEncryptedObject.uploadKmsEncryptedObject(
        GOOGLE_CLOUD_PROJECT, bucket.getName(), blobName, kmsFixture.getKey1().getName());
    assertNotNull(storage.get(bucket.getName(), blobName));
  }

  @Test
  public void testBatchSetObjectMetadata() {
    String prefix = generator.randomObjectName();
    String name1 = prefix + "/1.txt";
    String name2 = prefix + "/2.txt";
    String bucketName = bucket.getName();
    BlobInfo b1Gen1 = storage.create(BlobInfo.newBuilder(bucketName, name1).build());
    BlobInfo b2Gen1 = storage.create(BlobInfo.newBuilder(bucketName, name2).build());

    BatchSetObjectMetadata.batchSetObjectMetadata(GOOGLE_CLOUD_PROJECT, bucketName, prefix + "/");

    BlobInfo b1Gen2 = storage.get(bucketName, name1);
    BlobInfo b2Gen2 = storage.get(bucketName, name2);
    assertThat(b1Gen2).isNotNull();
    assertThat(b2Gen2).isNotNull();
    assertThat(b1Gen2.getMetadata()).containsAtLeast("keyToAddOrUpdate", "value");
    assertThat(b2Gen2.getMetadata()).containsAtLeast("keyToAddOrUpdate", "value");
  }

  @Test
  public void testSetObjectRetentionPolicy() {
    BucketInfo bucketInfo = BucketInfo.newBuilder(generator.randomBucketName()).build();
    Bucket tmpBucket = storage.create(bucketInfo, BucketTargetOption.enableObjectRetention(true));
    String tempBucket = tmpBucket.getName();
    try {

      String retentionBlob = generator.randomObjectName();
      BlobInfo gen1 = storage.create(BlobInfo.newBuilder(tempBucket, retentionBlob).build());
      assertNull(storage.get(tempBucket, retentionBlob).getRetention());
      try {
        SetObjectRetentionPolicy.setObjectRetentionPolicy(
            GOOGLE_CLOUD_PROJECT, tempBucket, retentionBlob);
        assertNotNull(storage.get(tempBucket, retentionBlob).getRetention());
      } finally {
        storage.update(
            gen1.toBuilder().setRetention(null).build(),
            BlobTargetOption.overrideUnlockedRetention(true));
      }
    } finally {
      BucketCleaner.doCleanup(tempBucket, storage);
    }
  }

  @Test
  public void testListSoftDeletedObjects() throws Exception {
    try (TemporaryBucket tmpBucket =
        TemporaryBucket.newBuilder()
            .setBucketInfo(
                BucketInfo.newBuilder(generator.randomBucketName())
                    // This is already the default, but we set it here in case the default ever
                    // changes
                    .setSoftDeletePolicy(
                        BucketInfo.SoftDeletePolicy.newBuilder()
                            .setRetentionDuration(Duration.ofDays(7))
                            .build())
                    .build())
            .setStorage(storage)
            .build()) {
      String bucketName = tmpBucket.getBucket().getName();

      String blob = generator.randomObjectName();
      storage.create(BlobInfo.newBuilder(BlobId.of(bucketName, blob)).build());
      storage.delete(BlobId.of(bucketName, blob));

      ListSoftDeletedObjects.listSoftDeletedObjects(GOOGLE_CLOUD_PROJECT, bucketName);

      String snippetOutput = stdOut.getCapturedOutputAsUtf8String();

      assertTrue(snippetOutput.contains(blob));
    }
  }

  @Test
  public void testListSoftDeletedVersionsOfObject() throws Exception {
    try (TemporaryBucket tmpBucket =
        TemporaryBucket.newBuilder()
            .setBucketInfo(
                BucketInfo.newBuilder(generator.randomBucketName())
                    // This is already the default, but we set it here in case the default ever
                    // changes
                    .setSoftDeletePolicy(
                        BucketInfo.SoftDeletePolicy.newBuilder()
                            .setRetentionDuration(Duration.ofDays(7))
                            .build())
                    .build())
            .setStorage(storage)
            .build()) {
      String bucketName = tmpBucket.getBucket().getName();

      System.out.println(storage.get(bucketName).getSoftDeletePolicy().toString());

      String blob = generator.randomObjectName();
      storage.create(BlobInfo.newBuilder(BlobId.of(bucketName, blob)).build());
      storage.delete(BlobId.of(bucketName, blob));

      String blob2 = generator.randomObjectName();
      storage.create(BlobInfo.newBuilder(BlobId.of(bucketName, blob2)).build());
      storage.delete(BlobId.of(bucketName, blob2));

      ListSoftDeletedVersionsOfObject.listSoftDeletedVersionOfObject(
          GOOGLE_CLOUD_PROJECT, bucketName, blob);

      String snippetOutput = stdOut.getCapturedOutputAsUtf8String();

      assertTrue(snippetOutput.contains(blob));
      assertFalse(snippetOutput.contains(blob2));
    }
  }

  @Test
  public void testRestoreSoftDeletedObject() throws Exception {
    try (TemporaryBucket tmpBucket =
        TemporaryBucket.newBuilder()
            .setBucketInfo(
                BucketInfo.newBuilder(generator.randomBucketName())
                    // This is already the default, but we set it here in case the default ever
                    // changes
                    .setSoftDeletePolicy(
                        BucketInfo.SoftDeletePolicy.newBuilder()
                            .setRetentionDuration(Duration.ofDays(7))
                            .build())
                    .build())
            .setStorage(storage)
            .build()) {
      String bucketName = tmpBucket.getBucket().getName();

      String blob = generator.randomObjectName();

      BlobInfo gen1 = storage.create(BlobInfo.newBuilder(BlobId.of(bucketName, blob)).build());
      storage.delete(BlobId.of(bucketName, blob));

      assertNull(storage.get(BlobId.of(bucketName, blob)));

      RestoreSoftDeletedObject.restoreSoftDeletedObject(
          GOOGLE_CLOUD_PROJECT, bucketName, blob, gen1.getGeneration());

      assertNotNull(storage.get(BlobId.of(bucketName, blob)));
    }
  }

  @Test
  public void testSetObjectContexts() throws Exception {
    String blobName = generator.randomObjectName();
    String key = "test-key-get";
    String value = "test-value-get";

    Blob initialBlob = storage.create(info(blobName), CONTENT, BlobTargetOption.doesNotExist());

    SetObjectContexts.setObjectContexts(
        GOOGLE_CLOUD_PROJECT, bucket.getName(), blobName, key, value);
    String setOutput = stdOut.getCapturedOutputAsUtf8String();
    assertThat(setOutput).contains("Updated custom contexts for object " + blobName);

    Blob updatedBlob = storage.get(bucket.getName(), blobName);
    assertThat(updatedBlob.getContexts().getCustom().get(key).getValue()).isEqualTo(value);
  }

  @Test
  public void testGetObjectContexts() throws Exception {
    String blobName = generator.randomObjectName();
    String key = "test-key-get";
    String value = "test-value-get";

    storage.create(info(blobName), CONTENT, BlobTargetOption.doesNotExist());

    ObjectCustomContextPayload payload =
        ObjectCustomContextPayload.newBuilder().setValue(value).build();
    Map<String, ObjectCustomContextPayload> custom = Maps.newHashMap();
    custom.put(key, payload);
    ObjectContexts contexts = ObjectContexts.newBuilder().setCustom(custom).build();
    BlobInfo pendingUpdate =
        storage.get(bucket.getName(), blobName).toBuilder().setContexts(contexts).build();
    storage.update(pendingUpdate);

    GetObjectContexts.getObjectContexts(GOOGLE_CLOUD_PROJECT, bucket.getName(), blobName);

    String getOutput = stdOut.getCapturedOutputAsUtf8String();

    assertThat(getOutput).contains("Custom Contexts:");
    assertThat(getOutput).contains(key + "=ObjectCustomContextPayload{");
    assertThat(getOutput).contains("value=" + value);
  }

  @Test
  public void testListObjectContexts() throws Exception {
    String blobName = generator.randomObjectName();
    String key = "test-key-list";
    String value = "test-value-list";

    storage.create(info(blobName), CONTENT, BlobTargetOption.doesNotExist());

    ObjectCustomContextPayload payload =
        ObjectCustomContextPayload.newBuilder().setValue(value).build();
    Map<String, ObjectCustomContextPayload> custom = Maps.newHashMap();
    custom.put(key, payload);
    ObjectContexts contexts = ObjectContexts.newBuilder().setCustom(custom).build();
    BlobInfo pendingUpdate =
        storage.get(bucket.getName(), blobName).toBuilder().setContexts(contexts).build();
    storage.update(pendingUpdate);

    ListObjectContexts.listObjectContexts(GOOGLE_CLOUD_PROJECT, bucket.getName(), key);
    String listOutput = stdOut.getCapturedOutputAsUtf8String();

    assertThat(listOutput).contains("gs://" + bucket.getName() + "/" + blobName);

    assertThat(listOutput)
        .contains("Listing objects for bucket: " + bucket.getName() + "with context key: " + key);
  }
}
