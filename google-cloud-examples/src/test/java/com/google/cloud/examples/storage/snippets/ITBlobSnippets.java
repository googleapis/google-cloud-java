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

import com.google.cloud.examples.storage.objects.ChangeObjectCSEKtoKMS;
import com.google.cloud.examples.storage.objects.ChangeObjectStorageClass;
import com.google.cloud.examples.storage.objects.CopyObject;
import com.google.cloud.examples.storage.objects.CopyOldVersionOfObject;
import com.google.cloud.examples.storage.objects.DeleteObject;
import com.google.cloud.examples.storage.objects.DeleteOldVersionOfObject;
import com.google.cloud.examples.storage.objects.DownloadEncryptedObject;
import com.google.cloud.examples.storage.objects.DownloadObject;
import com.google.cloud.examples.storage.objects.DownloadPublicObject;
import com.google.cloud.examples.storage.objects.GenerateEncryptionKey;
import com.google.cloud.examples.storage.objects.GenerateV4GetObjectSignedUrl;
import com.google.cloud.examples.storage.objects.GenerateV4PutObjectSignedUrl;
import com.google.cloud.examples.storage.objects.GetObjectMetadata;
import com.google.cloud.examples.storage.objects.ListObjects;
import com.google.cloud.examples.storage.objects.ListObjectsWithOldVersions;
import com.google.cloud.examples.storage.objects.ListObjectsWithPrefix;
import com.google.cloud.examples.storage.objects.MakeObjectPublic;
import com.google.cloud.examples.storage.objects.MoveObject;
import com.google.cloud.examples.storage.objects.RotateObjectEncryptionKey;
import com.google.cloud.examples.storage.objects.SetObjectMetadata;
import com.google.cloud.examples.storage.objects.UploadEncryptedObject;
import com.google.cloud.examples.storage.objects.UploadObject;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ITBlobSnippets {

  private static final Logger log = Logger.getLogger(ITBlobSnippets.class.getName());
  private static final String BUCKET = RemoteStorageHelper.generateBucketName();
  private static final String BLOB = "blob";
  private static final byte[] CONTENT = "Hello, World!".getBytes(UTF_8);
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");

  private static Storage storage;

  @Rule public ExpectedException thrown = ExpectedException.none();

  @BeforeClass
  public static void beforeClass() {
    RemoteStorageHelper helper = RemoteStorageHelper.create();
    storage = helper.getOptions().getService();
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

  @After
  public void after() {
    for (BlobInfo info : storage.list(BUCKET, BlobListOption.versions(true)).getValues()) {
      storage.delete(info.getBlobId());
    }
  }

  @Test
  public void testChangeObjectStorageClass() {
    Blob blob = storage.get(BUCKET, BLOB);
    Assert.assertNotEquals(StorageClass.COLDLINE, blob.getStorageClass());
    ChangeObjectStorageClass.changeObjectStorageClass(PROJECT_ID, BUCKET, BLOB);
    assertEquals(StorageClass.COLDLINE, storage.get(BUCKET, BLOB).getStorageClass());
    assertArrayEquals(CONTENT, storage.get(BUCKET, BLOB).getContent());
  }

  @Test
  public void testCopyObject() {
    String newBucket = RemoteStorageHelper.generateBucketName();
    storage.create(BucketInfo.newBuilder(newBucket).build());
    try {
      CopyObject.copyObject(PROJECT_ID, BUCKET, BLOB, newBucket);
      assertNotNull(storage.get(newBucket, BLOB));
    } finally {
      storage.delete(newBucket, BLOB);
      storage.delete(newBucket);
    }
  }

  @Test
  public void testDeleteObject() {
    String blob = "deletethisblob";
    storage.create(BlobInfo.newBuilder(BlobId.of(BUCKET, blob)).build());
    assertNotNull(storage.get(BUCKET, blob));
    DeleteObject.deleteObject(PROJECT_ID, BUCKET, blob);
    assertNull(storage.get(BUCKET, blob));
  }

  @Test
  public void testDownloadObject() throws IOException {
    File tempFile = File.createTempFile("file", ".txt");
    try {
      DownloadObject.downloadObject(PROJECT_ID, BUCKET, BLOB, tempFile.toPath());
      assertEquals("Hello, World!", new String(Files.readAllBytes(tempFile.toPath())));
    } finally {
      tempFile.delete();
    }
  }

  @Test
  public void testDownloadPublicObject() throws IOException {
    String publicBlob = "publicblob" + System.currentTimeMillis();
    BlobId publicBlobId = BlobId.of(BUCKET, publicBlob);
    storage.create(BlobInfo.newBuilder(publicBlobId).build(), CONTENT);
    storage.createAcl(publicBlobId, Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
    File tempFile = File.createTempFile("file", ".txt");
    try {
      DownloadPublicObject.downloadPublicObject(BUCKET, publicBlob, tempFile.toPath());
      assertEquals("Hello, World!", new String(Files.readAllBytes(tempFile.toPath())));
    } finally {
      tempFile.delete();
    }
  }

  @Test
  public void testGetObjectMetadata() {
    String blobName = "test-create-empty-blob";
    BlobId blobId = BlobId.of(BUCKET, blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setMetadata(ImmutableMap.of("k", "v")).build();
    Blob remoteBlob = storage.create(blobInfo, CONTENT);
    assertNotNull(remoteBlob);
    PrintStream systemOut = System.out;
    final ByteArrayOutputStream snippetOutputCapture = new ByteArrayOutputStream();
    System.setOut(new PrintStream(snippetOutputCapture));
    GetObjectMetadata.getObjectMetadata(PROJECT_ID, BUCKET, blobName);
    String snippetOutput = snippetOutputCapture.toString();
    System.setOut(systemOut);
    assertTrue(snippetOutput.contains("Bucket: " + remoteBlob.getBucket()));
    assertTrue(snippetOutput.contains("Bucket: " + remoteBlob.getBucket()));
    assertTrue(snippetOutput.contains("CacheControl: " + remoteBlob.getCacheControl()));
    assertTrue(snippetOutput.contains("ComponentCount: " + remoteBlob.getComponentCount()));
    assertTrue(snippetOutput.contains("ContentDisposition: " + remoteBlob.getContentDisposition()));
    assertTrue(snippetOutput.contains("ContentEncoding: " + remoteBlob.getContentEncoding()));
    assertTrue(snippetOutput.contains("ContentLanguage: " + remoteBlob.getContentLanguage()));
    assertTrue(snippetOutput.contains("ContentType: " + remoteBlob.getContentType()));
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
  }

  @Test
  public void testListObjects() {
    final ByteArrayOutputStream snippetOutputCapture = new ByteArrayOutputStream();
    System.setOut(new PrintStream(snippetOutputCapture));
    ListObjects.listObjects(PROJECT_ID, BUCKET);
    String snippetOutput = snippetOutputCapture.toString();
    assertTrue(snippetOutput.contains(BLOB));
    System.setOut(System.out);
  }

  @Test
  public void testListObjectsWithPrefix() {
    PrintStream systemOutput = System.out;
    final ByteArrayOutputStream snippetOutputCapture = new ByteArrayOutputStream();
    System.setOut(new PrintStream(snippetOutputCapture));
    storage.create(BlobInfo.newBuilder(BlobId.of(BUCKET, "a/1.txt")).build());
    storage.create(BlobInfo.newBuilder(BlobId.of(BUCKET, "a/b/2.txt")).build());
    storage.create(BlobInfo.newBuilder(BlobId.of(BUCKET, "a/b/3.txt")).build());
    ListObjectsWithPrefix.listObjectsWithPrefix(PROJECT_ID, BUCKET, "a/");
    String snippetOutput = snippetOutputCapture.toString();
    assertTrue(snippetOutput.contains("a/1.txt"));
    assertTrue(snippetOutput.contains("a/b/"));
    assertFalse(snippetOutput.contains("a/b/2.txt"));
    System.setOut(systemOutput);
  }

  @Test
  public void testMoveObject() {
    String blob = "movethisblob";
    storage.create(BlobInfo.newBuilder(BlobId.of(BUCKET, blob)).build());
    assertNotNull(storage.get(BUCKET, blob));
    String newBucket = RemoteStorageHelper.generateBucketName();
    storage.create(BucketInfo.newBuilder(newBucket).build());
    try {
      MoveObject.moveObject(PROJECT_ID, BUCKET, blob, newBucket);
      assertNotNull(storage.get(newBucket, blob));
      assertNull(storage.get(BUCKET, blob));
    } finally {
      storage.delete(newBucket, blob);
      storage.delete(newBucket);
    }
  }

  @Test
  public void testSetObjectMetadata() {
    SetObjectMetadata.setObjectMetadata(PROJECT_ID, BUCKET, BLOB);
    Map<String, String> metadata = storage.get(BUCKET, BLOB).getMetadata();
    assertEquals("value", metadata.get("keyToAddOrUpdate"));
  }

  @Test
  public void testUploadObject() throws IOException {
    File tempFile = File.createTempFile("file", ".txt");
    try {
      Files.write(tempFile.toPath(), CONTENT);
      UploadObject.uploadObject(PROJECT_ID, BUCKET, "uploadobjecttest", tempFile.getPath());
      assertArrayEquals(CONTENT, storage.get(BUCKET, "uploadobjecttest").getContent());
    } finally {
      tempFile.delete();
    }
  }

  @Test
  public void testObjectCSEKOperations() throws IOException {
    PrintStream systemOut = System.out;

    final ByteArrayOutputStream snippetOutputCapture = new ByteArrayOutputStream();
    System.setOut(new PrintStream(snippetOutputCapture));
    GenerateEncryptionKey.generateEncryptionKey();
    String snippetOutput = snippetOutputCapture.toString();
    System.setOut(systemOut);
    String encryptionKey = snippetOutput.split(": ")[1].trim();

    File tempFile = File.createTempFile("file", ".txt");
    File downloadFile = File.createTempFile("dlfile", ".txt");
    String encryptedBlob = "uploadencryptedobjecttest";
    Files.write(tempFile.toPath(), CONTENT);

    UploadEncryptedObject.uploadEncryptedObject(
        PROJECT_ID, BUCKET, encryptedBlob, tempFile.getPath(), encryptionKey);
    DownloadEncryptedObject.downloadEncryptedObject(
        PROJECT_ID, BUCKET, encryptedBlob, downloadFile.toPath(), encryptionKey);
    assertArrayEquals(CONTENT, Files.readAllBytes(downloadFile.toPath()));

    byte[] key = new byte[32];
    new Random().nextBytes(key);
    String newEncryptionKey = BaseEncoding.base64().encode(key);
    RotateObjectEncryptionKey.rotateObjectEncryptionKey(
        PROJECT_ID, BUCKET, encryptedBlob, encryptionKey, newEncryptionKey);
    File newDownloadFile = File.createTempFile("newdownloadfile", ".txt");
    DownloadEncryptedObject.downloadEncryptedObject(
        PROJECT_ID, BUCKET, encryptedBlob, newDownloadFile.toPath(), newEncryptionKey);
    assertArrayEquals(CONTENT, Files.readAllBytes(newDownloadFile.toPath()));

    assertNull(storage.get(BUCKET, encryptedBlob).getKmsKeyName());
    String kmsKeyName =
        "projects/gcloud-devel/locations/global/keyRings/gcs_kms_key_ring/cryptoKeys/key";
    ChangeObjectCSEKtoKMS.changeObjectFromCSEKtoKMS(
        PROJECT_ID, BUCKET, encryptedBlob, newEncryptionKey, kmsKeyName);
    assertTrue(storage.get(BUCKET, encryptedBlob).getKmsKeyName().contains(kmsKeyName));
  }

  @Test
  public void testObjectVersioningOperations() {
    storage.get(BUCKET).toBuilder().setVersioningEnabled(true).build().update();
    String versionedBlob = "versionedblob";
    Blob originalBlob = storage.create(BlobInfo.newBuilder(BUCKET, versionedBlob).build(), CONTENT);
    byte[] content2 = "Hello, World 2".getBytes(UTF_8);
    storage.create(BlobInfo.newBuilder(BUCKET, versionedBlob).build(), content2);

    PrintStream systemOut = System.out;
    final ByteArrayOutputStream snippetOutputCapture = new ByteArrayOutputStream();
    System.setOut(new PrintStream(snippetOutputCapture));
    ListObjectsWithOldVersions.listObjectsWithOldVersions(PROJECT_ID, BUCKET);
    String snippetOutput = snippetOutputCapture.toString();
    System.setOut(systemOut);

    snippetOutput = snippetOutput.replaceFirst(versionedBlob, "");
    assertTrue(snippetOutput.contains(versionedBlob));

    CopyOldVersionOfObject.copyOldVersionOfObject(
        PROJECT_ID, BUCKET, versionedBlob, originalBlob.getGeneration(), "copiedblob");
    assertArrayEquals(CONTENT, storage.get(BUCKET, "copiedblob").getContent());

    DeleteOldVersionOfObject.deleteOldVersionOfObject(
        PROJECT_ID, BUCKET, versionedBlob, originalBlob.getGeneration());
    assertNull(storage.get(BlobId.of(BUCKET, versionedBlob, originalBlob.getGeneration())));
    assertNotNull(storage.get(BUCKET, versionedBlob));
  }

  @Test
  public void testV4SignedURLs() throws IOException {
    String tempObject = "test-upload-signed-url-object";
    PrintStream standardOut = System.out;
    final ByteArrayOutputStream snippetOutputCapture = new ByteArrayOutputStream();
    System.setOut(new PrintStream(snippetOutputCapture));
    GenerateV4PutObjectSignedUrl.generateV4GPutObjectSignedUrl(PROJECT_ID, BUCKET, tempObject);
    String snippetOutput = snippetOutputCapture.toString();
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
    GenerateV4GetObjectSignedUrl.generateV4GetObjectSignedUrl(PROJECT_ID, BUCKET, tempObject);
    snippetOutput = snippetOutputCapture.toString();
    url = snippetOutput.split("\n")[5];
    URL downloadUrl = new URL(url);
    System.setOut(standardOut);
    System.out.println(snippetOutput);
    connection = (HttpsURLConnection) downloadUrl.openConnection();
    byte[] readBytes = new byte[CONTENT.length];
    try (InputStream responseStream = connection.getInputStream()) {
      assertEquals(CONTENT.length, responseStream.read(readBytes));
      assertArrayEquals(CONTENT, readBytes);
    }
  }

  @Test
  public void testMakeObjectPublic() {
    String aclBlob = "acl-test-blob";
    assertNull(
        storage.create(BlobInfo.newBuilder(BUCKET, aclBlob).build()).getAcl(Acl.User.ofAllUsers()));
    MakeObjectPublic.makeObjectPublic(PROJECT_ID, BUCKET, aclBlob);
    assertNotNull(storage.get(BUCKET, aclBlob).getAcl(Acl.User.ofAllUsers()));
  }
}
