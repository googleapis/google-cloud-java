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

import static com.google.common.truth.Truth.assertThat;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.CopyWriter;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobField;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.it.runner.registry.KmsFixture;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.BaseEncoding;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP, Transport.GRPC},
    backends = Backend.PROD)
public class ITKmsTest {

  private static final byte[] BLOB_BYTE_CONTENT = {0xD, 0xE, 0xA, 0xD};
  private static final String BLOB_STRING_CONTENT = "Hello Google Cloud Storage!";
  private static final String BASE64_KEY = "JVzfVl8NLD9FjedFuStegjRfES5ll5zc59CIXw572OA=";
  private static final Key KEY =
      new SecretKeySpec(BaseEncoding.base64().decode(BASE64_KEY), "AES256");
  private static final String CONTENT_TYPE = "text/plain";

  @Inject public Storage storage;
  @Inject public BucketInfo bucket;
  @Inject public Generator generator;
  @Inject public KmsFixture kms;

  @Test
  public void testClearBucketDefaultKmsKeyName() {
    String bucketName = generator.randomBucketName();
    Bucket remoteBucket =
        storage.create(
            BucketInfo.newBuilder(bucketName)
                .setDefaultKmsKeyName(kms.getKey1().getName())
                .setLocation(kms.getKeyRingLocation())
                .build());
    try {
      assertEquals(kms.getKey1().getName(), remoteBucket.getDefaultKmsKeyName());
      Bucket updatedBucket = remoteBucket.toBuilder().setDefaultKmsKeyName(null).build().update();
      assertNull(updatedBucket.getDefaultKmsKeyName());
    } finally {
      BucketCleaner.doCleanup(bucketName, storage);
    }
  }

  @Test
  public void testUpdateBucketDefaultKmsKeyName() {
    String bucketName = generator.randomBucketName();
    Bucket remoteBucket =
        storage.create(
            BucketInfo.newBuilder(bucketName)
                .setDefaultKmsKeyName(kms.getKey1().getName())
                .setLocation(kms.getKeyRingLocation())
                .build());
    try {
      assertEquals(kms.getKey1().getName(), remoteBucket.getDefaultKmsKeyName());
      Bucket updatedBucket =
          remoteBucket.toBuilder().setDefaultKmsKeyName(kms.getKey2().getName()).build().update();
      assertEquals(kms.getKey2().getName(), updatedBucket.getDefaultKmsKeyName());
    } finally {
      BucketCleaner.doCleanup(bucketName, storage);
    }
  }

  @Test
  public void testCreateBlobWithKmsKeyName() {
    String blobName = generator.randomObjectName();
    String bucketName = bucket.getName();
    BlobInfo blob = BlobInfo.newBuilder(bucketName, blobName).build();
    Blob remoteBlob =
        storage.create(
            blob, BLOB_BYTE_CONTENT, Storage.BlobTargetOption.kmsKeyName(kms.getKey1().getName()));
    assertNotNull(remoteBlob);
    assertEquals(blob.getBucket(), remoteBlob.getBucket());
    assertEquals(blob.getName(), remoteBlob.getName());
    assertNotNull(remoteBlob.getKmsKeyName());
    assertTrue(remoteBlob.getKmsKeyName().startsWith(kms.getKey1().getName()));
    byte[] readBytes = storage.readAllBytes(bucketName, blobName);
    assertArrayEquals(BLOB_BYTE_CONTENT, readBytes);
  }

  @Test(expected = StorageException.class)
  public void testCreateBlobWithKmsKeyNameAndCustomerSuppliedKeyFails() {
    String blobName = generator.randomObjectName();
    BlobInfo blob = BlobInfo.newBuilder(bucket, blobName).build();
    storage.create(
        blob,
        BLOB_BYTE_CONTENT,
        Storage.BlobTargetOption.encryptionKey(KEY),
        Storage.BlobTargetOption.kmsKeyName(kms.getKey1().getName()));
  }

  @Test
  public void testCreateBlobWithDefaultKmsKeyName() {
    String bucketName = generator.randomBucketName();
    Bucket bucket =
        storage.create(
            BucketInfo.newBuilder(bucketName)
                .setDefaultKmsKeyName(kms.getKey1().getName())
                .setLocation(kms.getKeyRingLocation())
                .build());
    assertEquals(bucket.getDefaultKmsKeyName(), kms.getKey1().getName());

    try {
      String blobName = generator.randomObjectName();
      BlobInfo blob = BlobInfo.newBuilder(bucket, blobName).build();
      Blob remoteBlob = storage.create(blob, BLOB_BYTE_CONTENT);
      assertNotNull(remoteBlob);
      assertEquals(blob.getBucket(), remoteBlob.getBucket());
      assertEquals(blob.getName(), remoteBlob.getName());
      assertNotNull(remoteBlob.getKmsKeyName());
      assertTrue(remoteBlob.getKmsKeyName().startsWith(kms.getKey1().getName()));
      byte[] readBytes = storage.readAllBytes(bucketName, blobName);
      assertArrayEquals(BLOB_BYTE_CONTENT, readBytes);
    } finally {
      BucketCleaner.doCleanup(bucketName, storage);
    }
  }

  @Test
  public void testGetBlobKmsKeyNameField() {
    String blobName = generator.randomObjectName();
    BlobInfo blob = BlobInfo.newBuilder(bucket, blobName).setContentType(CONTENT_TYPE).build();
    assertNotNull(
        storage.create(blob, Storage.BlobTargetOption.kmsKeyName(kms.getKey1().getName())));
    Blob remoteBlob =
        storage.get(blob.getBlobId(), Storage.BlobGetOption.fields(BlobField.KMS_KEY_NAME));
    assertEquals(blob.getBlobId(), remoteBlob.getBlobId());
    assertTrue(remoteBlob.getKmsKeyName().startsWith(kms.getKey1().getName()));
    assertNull(remoteBlob.getContentType());
  }

  @Test
  public void testRotateFromCustomerEncryptionToKmsKey() {
    String sourceBlobName = generator.randomObjectName();
    BlobId source = BlobId.of(bucket.getName(), sourceBlobName);
    ImmutableMap<String, String> metadata = ImmutableMap.of("k", "v");
    Blob remoteBlob =
        storage.create(
            BlobInfo.newBuilder(source).build(),
            BLOB_BYTE_CONTENT,
            Storage.BlobTargetOption.encryptionKey(KEY));
    assertNotNull(remoteBlob);
    String targetBlobName = generator.randomObjectName();
    BlobInfo target =
        BlobInfo.newBuilder(bucket, targetBlobName)
            .setContentType(CONTENT_TYPE)
            .setMetadata(metadata)
            .build();
    Storage.CopyRequest req =
        Storage.CopyRequest.newBuilder()
            .setSource(source)
            .setSourceOptions(Storage.BlobSourceOption.decryptionKey(BASE64_KEY))
            .setTarget(target, Storage.BlobTargetOption.kmsKeyName(kms.getKey1().getName()))
            .build();
    CopyWriter copyWriter = storage.copy(req);
    assertEquals(bucket.getName(), copyWriter.getResult().getBucket());
    assertEquals(targetBlobName, copyWriter.getResult().getName());
    assertEquals(CONTENT_TYPE, copyWriter.getResult().getContentType());
    assertNotNull(copyWriter.getResult().getKmsKeyName());
    assertTrue(copyWriter.getResult().getKmsKeyName().startsWith(kms.getKey1().getName()));
    assertArrayEquals(BLOB_BYTE_CONTENT, copyWriter.getResult().getContent());
    assertEquals(metadata, copyWriter.getResult().getMetadata());
    assertTrue(copyWriter.isDone());
    assertTrue(storage.delete(bucket.getName(), targetBlobName));
  }

  @Test(expected = StorageException.class)
  public void testRotateFromCustomerEncryptionToKmsKeyWithCustomerEncryption() {
    String sourceBlobName = generator.randomObjectName();
    BlobId source = BlobId.of(bucket.getName(), sourceBlobName);
    ImmutableMap<String, String> metadata = ImmutableMap.of("k", "v");
    Blob remoteBlob =
        storage.create(
            BlobInfo.newBuilder(source).build(),
            BLOB_BYTE_CONTENT,
            Storage.BlobTargetOption.encryptionKey(KEY));
    assertNotNull(remoteBlob);
    String targetBlobName = generator.randomObjectName();
    BlobInfo target =
        BlobInfo.newBuilder(bucket, targetBlobName)
            .setContentType(CONTENT_TYPE)
            .setMetadata(metadata)
            .build();
    Storage.CopyRequest req =
        Storage.CopyRequest.newBuilder()
            .setSource(source)
            .setSourceOptions(Storage.BlobSourceOption.decryptionKey(BASE64_KEY))
            .setTarget(
                target,
                Storage.BlobTargetOption.encryptionKey(KEY),
                Storage.BlobTargetOption.kmsKeyName(kms.getKey1().getName()))
            .build();
    storage.copy(req);
  }

  @Test
  public void testWriterWithKmsKeyName() throws IOException {
    // Write an empty object with a kmsKeyName.
    String blobName = generator.randomObjectName();
    BlobInfo blobInfo = BlobInfo.newBuilder(bucket, blobName).build();
    Blob blob =
        storage.create(blobInfo, Storage.BlobTargetOption.kmsKeyName(kms.getKey1().getName()));

    // Create a writer using blob that already has metadata received from Storage API.
    int numberOfBytes;
    byte[] content = BLOB_STRING_CONTENT.getBytes(UTF_8);
    try (WriteChannel writer = blob.writer()) {
      numberOfBytes = writer.write(ByteBuffer.wrap(content, 0, content.length));
    }
    assertThat(numberOfBytes).isEqualTo(content.length);
    assertThat(blob.getKmsKeyName()).isNotNull();
    assertThat(storage.delete(bucket.getName(), blobName)).isTrue();
  }
}
