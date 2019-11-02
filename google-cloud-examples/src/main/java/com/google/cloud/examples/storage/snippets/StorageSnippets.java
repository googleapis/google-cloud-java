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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in Storage's javadoc. Any change to this file should be reflected in
 * Storage's javadoc.
 */

package com.google.cloud.examples.storage.snippets;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.api.gax.paging.Page;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.BatchResult;
import com.google.cloud.ReadChannel;
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
import com.google.cloud.storage.HmacKey;
import com.google.cloud.storage.HmacKey.HmacKeyMetadata;
import com.google.cloud.storage.HmacKey.HmacKeyState;
import com.google.cloud.storage.HttpMethod;
import com.google.cloud.storage.ServiceAccount;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobGetOption;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BucketField;
import com.google.cloud.storage.Storage.BucketGetOption;
import com.google.cloud.storage.Storage.BucketListOption;
import com.google.cloud.storage.Storage.BucketSourceOption;
import com.google.cloud.storage.Storage.ComposeRequest;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.cloud.storage.Storage.ListHmacKeysOption;
import com.google.cloud.storage.Storage.SignUrlOption;
import com.google.cloud.storage.StorageBatch;
import com.google.cloud.storage.StorageBatchResult;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/** This class contains a number of snippets for the {@link Storage} interface. */
public class StorageSnippets {

  private final Storage storage;

  public StorageSnippets(Storage storage) {
    this.storage = storage;
  }

  /** Example of creating a bucket. */
  // [TARGET create(BucketInfo, BucketTargetOption...)]
  // [VARIABLE "my_unique_bucket"]
  public Bucket createBucket(String bucketName) {
    // [START createBucket]
    Bucket bucket = storage.create(BucketInfo.of(bucketName));
    // [END createBucket]
    return bucket;
  }

  /** Example of creating a bucket with storage class and location. */
  // [TARGET create(BucketInfo, BucketTargetOption...)]
  // [VARIABLE "my_unique_bucket"]
  public Bucket createBucketWithStorageClassAndLocation(String bucketName) {
    // [START createBucketWithStorageClassAndLocation]
    Bucket bucket =
        storage.create(
            BucketInfo.newBuilder(bucketName)
                // See here for possible values: http://g.co/cloud/storage/docs/storage-classes
                .setStorageClass(StorageClass.COLDLINE)
                // Possible values: http://g.co/cloud/storage/docs/bucket-locations#location-mr
                .setLocation("asia")
                .build());
    // [END createBucketWithStorageClassAndLocation]
    return bucket;
  }

  /** Example of creating a blob with no content. */
  // [TARGET create(BlobInfo, BlobTargetOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  public Blob createBlob(String bucketName, String blobName) {
    // [START createBlob]
    BlobId blobId = BlobId.of(bucketName, blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
    Blob blob = storage.create(blobInfo);
    // [END createBlob]
    return blob;
  }

  /** Example of creating a blob from a byte array. */
  // [TARGET create(BlobInfo, byte[], BlobTargetOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  public Blob createBlobFromByteArray(String bucketName, String blobName) {
    // [START createBlobFromByteArray]
    BlobId blobId = BlobId.of(bucketName, blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
    Blob blob = storage.create(blobInfo, "Hello, World!".getBytes(UTF_8));
    // [END createBlobFromByteArray]
    return blob;
  }

  /** Example of creating a blob with sub array from a byte array. */
  // [TARGET create(BlobInfo, byte[], offset, length, BlobTargetOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  public Blob createBlobWithSubArrayFromByteArray(
      String bucketName, String blobName, int offset, int length) {
    // [START createBlobWithSubArrayFromByteArray]
    BlobId blobId = BlobId.of(bucketName, blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
    Blob blob = storage.create(blobInfo, "Hello, World!".getBytes(UTF_8), offset, length);
    // [END createBlobWithSubArrayFromByteArray]
    return blob;
  }

  /** Example of creating a blob from an input stream. */
  // [TARGET create(BlobInfo, InputStream, BlobWriteOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  public Blob createBlobFromInputStream(String bucketName, String blobName) {
    // [START createBlobFromInputStream]
    InputStream content = new ByteArrayInputStream("Hello, World!".getBytes(UTF_8));
    BlobId blobId = BlobId.of(bucketName, blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
    Blob blob = storage.create(blobInfo, content);
    // [END createBlobFromInputStream]
    return blob;
  }

  /** Example of uploading an encrypted blob. */
  // [TARGET create(BlobInfo, InputStream, BlobWriteOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE "my_encryption_key"]
  public Blob createEncryptedBlob(String bucketName, String blobName, String encryptionKey) {
    // [START storageUploadEncryptedFile]
    byte[] data = "Hello, World!".getBytes(UTF_8);

    BlobId blobId = BlobId.of(bucketName, blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
    Blob blob = storage.create(blobInfo, data, BlobTargetOption.encryptionKey(encryptionKey));
    // [END storageUploadEncryptedFile]
    return blob;
  }

  /** Example of uploading a blob encrypted service side with a Cloud KMS key. */
  public Blob createKmsEncrpytedBlob(String bucketName, String blobName, String kmsKeyName) {
    // [START storage_upload_with_kms_key]
    byte[] data = "Hello, World!".getBytes(UTF_8);

    // The name of the existing bucket to set a default KMS key for, e.g. "my-bucket"
    // String bucketName = "my-bucket"

    // The name of the KMS-key to use as a default
    // Key names are provided in the following format:
    // 'projects/<PROJECT>/locations/<LOCATION>/keyRings/<RING_NAME>/cryptoKeys/<KEY_NAME>'
    // String kmsKeyName = ""

    BlobId blobId = BlobId.of(bucketName, blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
    Blob blob = storage.create(blobInfo, data, BlobTargetOption.kmsKeyName(kmsKeyName));
    // [END storage_upload_with_kms_key]
    return blob;
  }

  /**
   * Example of getting information on a bucket, only if its metageneration matches a value,
   * otherwise a {@link StorageException} is thrown.
   */
  // [TARGET get(String, BucketGetOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE 42]
  public Bucket getBucketWithMetageneration(String bucketName, long bucketMetageneration) {
    // [START getBucketWithMetageneration]
    Bucket bucket =
        storage.get(bucketName, BucketGetOption.metagenerationMatch(bucketMetageneration));
    // [END getBucketWithMetageneration]
    return bucket;
  }

  /**
   * Example of getting information on a blob, only if its metageneration matches a value, otherwise
   * a {@link StorageException} is thrown.
   */
  // [TARGET get(String, String, BlobGetOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public Blob getBlobFromStringsWithMetageneration(
      String bucketName, String blobName, long blobMetageneration) {
    // [START getBlobFromStringsWithMetageneration]
    Blob blob =
        storage.get(bucketName, blobName, BlobGetOption.metagenerationMatch(blobMetageneration));
    // [END getBlobFromStringsWithMetageneration]
    return blob;
  }

  /** Example of getting information on a blob. */
  // [TARGET get(BlobId)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  public Blob getBlobFromId(String bucketName, String blobName) {
    // [START getBlobFromId]
    BlobId blobId = BlobId.of(bucketName, blobName);
    Blob blob = storage.get(blobId);
    // [END getBlobFromId]
    return blob;
  }

  /**
   * Example of getting information on a blob, only if its metageneration matches a value, otherwise
   * a {@link StorageException} is thrown.
   */
  // [TARGET get(BlobId, BlobGetOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public Blob getBlobFromIdWithMetageneration(
      String bucketName, String blobName, long blobMetageneration) {
    // [START getBlobFromIdWithMetageneration]
    BlobId blobId = BlobId.of(bucketName, blobName);
    Blob blob = storage.get(blobId, BlobGetOption.metagenerationMatch(blobMetageneration));
    // [END getBlobFromIdWithMetageneration]
    return blob;
  }

  /** Example of listing buckets, specifying the page size and a name prefix. */
  // [TARGET list(BucketListOption...)]
  // [VARIABLE "bucket_"]
  public Page<Bucket> listBucketsWithSizeAndPrefix(String prefix) {
    // [START listBucketsWithSizeAndPrefix]
    // Include a prefix of bucket-name to reduce search space.
    // For more information read https://cloud.google.com/storage/docs/json_api/v1/buckets/list
    Page<Bucket> buckets =
        storage.list(BucketListOption.pageSize(100), BucketListOption.prefix(prefix));
    for (Bucket bucket : buckets.iterateAll()) {
      // do something with the bucket
    }
    // [END listBucketsWithSizeAndPrefix]
    return buckets;
  }

  /** Example of listing blobs in a provided directory. */
  // [TARGET list(String, BlobListOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_directory/"]
  public Page<Blob> listBlobsWithDirectoryAndPrefix(String bucketName, String directory) {
    // [START listBlobsWithDirectoryAndPrefix]
    Page<Blob> blobs =
        storage.list(
            bucketName, BlobListOption.currentDirectory(), BlobListOption.prefix(directory));
    for (Blob blob : blobs.iterateAll()) {
      // do something with the blob
    }
    // [END listBlobsWithDirectoryAndPrefix]
    return blobs;
  }

  /** Example of updating bucket information. */
  // [TARGET update(BucketInfo, BucketTargetOption...)]
  // [VARIABLE "my_unique_bucket"]
  public Bucket updateBucket(String bucketName) {
    // [START updateBucket]
    BucketInfo bucketInfo = BucketInfo.newBuilder(bucketName).setVersioningEnabled(true).build();
    Bucket bucket = storage.update(bucketInfo);
    // [END updateBucket]
    return bucket;
  }

  /** Example of replacing blob's metadata. */
  // [TARGET update(BlobInfo)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  public Blob updateBlob(String bucketName, String blobName) {
    // [START updateBlob]
    Map<String, String> newMetadata = new HashMap<>();
    newMetadata.put("key", "value");
    storage.update(BlobInfo.newBuilder(bucketName, blobName).setMetadata(null).build());
    Blob blob =
        storage.update(BlobInfo.newBuilder(bucketName, blobName).setMetadata(newMetadata).build());
    // [END updateBlob]
    return blob;
  }

  /**
   * Example of udating a blob, only if the blob's metageneration matches a value, otherwise a
   * {@link StorageException} is thrown.
   */
  // [TARGET update(BlobInfo, BlobTargetOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  public Blob updateBlobWithMetageneration(String bucketName, String blobName) {
    // [START updateBlobWithMetageneration]
    Blob blob = storage.get(bucketName, blobName);
    BlobInfo updatedInfo = blob.toBuilder().setContentType("text/plain").build();
    storage.update(updatedInfo, BlobTargetOption.metagenerationMatch());
    // [END updateBlobWithMetageneration]
    return blob;
  }

  /**
   * Example of deleting a bucket, only if its metageneration matches a value, otherwise a {@link
   * StorageException} is thrown.
   */
  // [TARGET delete(String, BucketSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE 42]
  public boolean deleteBucketWithMetageneration(String bucketName, long bucketMetageneration) {
    // [START deleteBucketWithMetageneration]
    boolean deleted =
        storage.delete(bucketName, BucketSourceOption.metagenerationMatch(bucketMetageneration));
    if (deleted) {
      // the bucket was deleted
    } else {
      // the bucket was not found
    }
    // [END deleteBucketWithMetageneration]
    return deleted;
  }

  /**
   * Example of deleting a blob, only if its generation matches a value, otherwise a {@link
   * StorageException} is thrown.
   */
  // [TARGET delete(String, String, BlobSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public boolean deleteBlobFromStringsWithGeneration(
      String bucketName, String blobName, long blobGeneration) {
    // [START deleteBlobFromStringsWithGeneration]
    boolean deleted =
        storage.delete(bucketName, blobName, BlobSourceOption.generationMatch(blobGeneration));
    if (deleted) {
      // the blob was deleted
    } else {
      // the blob was not found
    }
    // [END deleteBlobFromStringsWithGeneration]
    return deleted;
  }

  /**
   * Example of deleting a blob, only if its generation matches a value, otherwise a {@link
   * StorageException} is thrown.
   */
  // [TARGET delete(BlobId, BlobSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public boolean deleteBlobFromIdWithGeneration(
      String bucketName, String blobName, long blobGeneration) {
    // [START deleteBlobFromIdWithGeneration]
    BlobId blobId = BlobId.of(bucketName, blobName);
    boolean deleted = storage.delete(blobId, BlobSourceOption.generationMatch(blobGeneration));
    if (deleted) {
      // the blob was deleted
    } else {
      // the blob was not found
    }
    // [END deleteBlobFromIdWithGeneration]
    return deleted;
  }

  /** Example of deleting a blob. */
  // [TARGET delete(BlobId)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  public boolean deleteBlob(String bucketName, String blobName) {
    // [START deleteBlob]
    BlobId blobId = BlobId.of(bucketName, blobName);
    boolean deleted = storage.delete(blobId);
    if (deleted) {
      // the blob was deleted
    } else {
      // the blob was not found
    }
    // [END deleteBlob]
    return deleted;
  }

  /** Example of composing two blobs. */
  // [TARGET compose(ComposeRequest)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE "source_blob_1"]
  // [VARIABLE "source_blob_2"]
  public Blob composeBlobs(
      String bucketName, String blobName, String sourceBlob1, String sourceBlob2) {
    // [START composeBlobs]
    BlobId blobId = BlobId.of(bucketName, blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
    ComposeRequest request =
        ComposeRequest.newBuilder()
            .setTarget(blobInfo)
            .addSource(sourceBlob1)
            .addSource(sourceBlob2)
            .build();
    Blob blob = storage.compose(request);
    // [END composeBlobs]
    return blob;
  }

  /** Example of copying a blob. */
  // [TARGET copy(CopyRequest)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE "copy_blob_name"]
  public Blob copyBlob(String bucketName, String blobName, String copyBlobName) {
    // [START copyBlob]
    CopyRequest request =
        CopyRequest.newBuilder()
            .setSource(BlobId.of(bucketName, blobName))
            .setTarget(BlobId.of(bucketName, copyBlobName))
            .build();
    Blob blob = storage.copy(request).getResult();
    // [END copyBlob]
    return blob;
  }

  /** Example of copying a blob in chunks. */
  // [TARGET copy(CopyRequest)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE "copy_blob_name"]
  public Blob copyBlobInChunks(String bucketName, String blobName, String copyBlobName) {
    // [START copyBlobInChunks]
    CopyRequest request =
        CopyRequest.newBuilder()
            .setSource(BlobId.of(bucketName, blobName))
            .setTarget(BlobId.of(bucketName, copyBlobName))
            .build();
    CopyWriter copyWriter = storage.copy(request);
    while (!copyWriter.isDone()) {
      copyWriter.copyChunk();
    }
    Blob blob = copyWriter.getResult();
    // [END copyBlobInChunks]
    return blob;
  }

  /** Example of rotating the encryption key of a blob. */
  // [TARGET copy(CopyRequest)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE "old_encryption_key"]
  // [VARIABLE "new_encryption_key"]
  public Blob rotateBlobEncryptionKey(
      String bucketName, String blobName, String oldEncryptionKey, String newEncryptionKey) {
    // [START storageRotateEncryptionKey]
    BlobId blobId = BlobId.of(bucketName, blobName);
    CopyRequest request =
        CopyRequest.newBuilder()
            .setSource(blobId)
            .setSourceOptions(BlobSourceOption.decryptionKey(oldEncryptionKey))
            .setTarget(blobId, BlobTargetOption.encryptionKey(newEncryptionKey))
            .build();
    Blob blob = storage.copy(request).getResult();
    // [END storageRotateEncryptionKey]
    return blob;
  }

  /**
   * Example of reading all bytes of a blob, if generation matches a value, otherwise a {@link
   * StorageException} is thrown.
   */
  // [TARGET readAllBytes(String, String, BlobSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42"]
  public byte[] readBlobFromStringsWithGeneration(
      String bucketName, String blobName, long blobGeneration) {
    // [START readBlobFromStringsWithGeneration]
    byte[] content =
        storage.readAllBytes(
            bucketName, blobName, BlobSourceOption.generationMatch(blobGeneration));
    // [END readBlobFromStringsWithGeneration]
    return content;
  }

  /**
   * Example of reading all bytes of a blob's specific generation, otherwise a {@link
   * StorageException} is thrown.
   */
  // [TARGET readAllBytes(BlobId, BlobSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public byte[] readBlobFromId(String bucketName, String blobName, long blobGeneration) {
    // [START readBlobFromId]
    BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
    byte[] content = storage.readAllBytes(blobId);
    // [END readBlobFromId]
    return content;
  }

  /** Example of reading all bytes of an encrypted blob. */
  // [TARGET readAllBytes(BlobId, BlobSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE "my_encryption_key"]
  public byte[] readEncryptedBlob(String bucketName, String blobName, String decryptionKey) {
    // [START readEncryptedBlob]
    byte[] content =
        storage.readAllBytes(bucketName, blobName, BlobSourceOption.decryptionKey(decryptionKey));
    // [END readEncryptedBlob]
    return content;
  }

  /** Example of using a batch request to delete, update and get a blob. */
  // [TARGET batch()]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name1"]
  // [VARIABLE "my_blob_name2"]
  public Blob batch(String bucketName, String blobName1, String blobName2) {
    // [START batch]
    StorageBatch batch = storage.batch();
    BlobId firstBlob = BlobId.of(bucketName, blobName1);
    BlobId secondBlob = BlobId.of(bucketName, blobName2);
    batch
        .delete(firstBlob)
        .notify(
            new BatchResult.Callback<Boolean, StorageException>() {
              public void success(Boolean result) {
                // deleted successfully
              }

              public void error(StorageException exception) {
                // delete failed
              }
            });
    batch.update(BlobInfo.newBuilder(secondBlob).setContentType("text/plain").build());
    StorageBatchResult<Blob> result = batch.get(secondBlob);
    batch.submit();
    Blob blob = result.get(); // returns get result or throws StorageException
    // [END batch]
    return blob;
  }

  /** Example of reading a blob's content through a reader. */
  // [TARGET reader(String, String, BlobSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  public void readerFromStrings(String bucketName, String blobName) throws IOException {
    // [START readerFromStrings]
    try (ReadChannel reader = storage.reader(bucketName, blobName)) {
      ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
      while (reader.read(bytes) > 0) {
        bytes.flip();
        // do something with bytes
        bytes.clear();
      }
    }
    // [END readerFromStrings]
  }

  /** Example of reading a blob's content through a reader. */
  // [TARGET reader(BlobId, BlobSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  public void readerFromId(String bucketName, String blobName) throws IOException {
    // [START readerFromId]
    BlobId blobId = BlobId.of(bucketName, blobName);
    try (ReadChannel reader = storage.reader(blobId)) {
      ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
      while (reader.read(bytes) > 0) {
        bytes.flip();
        // do something with bytes
        bytes.clear();
      }
    }
    // [END readerFromId]
  }

  /** Example of writing a blob's content through a writer. */
  // [TARGET writer(BlobInfo, BlobWriteOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  public void writer(String bucketName, String blobName) throws IOException {
    // [START writer]
    BlobId blobId = BlobId.of(bucketName, blobName);
    byte[] content = "Hello, World!".getBytes(UTF_8);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
    try (WriteChannel writer = storage.writer(blobInfo)) {
      try {
        writer.write(ByteBuffer.wrap(content, 0, content.length));
      } catch (Exception ex) {
        // handle exception
      }
    }
    // [END writer]
  }

  /**
   * Example of creating a signed URL that is valid for 2 weeks, using the default credentials for
   * signing the URL.
   */
  // [TARGET signUrl(BlobInfo, long, TimeUnit, SignUrlOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  public URL signUrl(String bucketName, String blobName) {
    // [START signUrl]
    URL signedUrl =
        storage.signUrl(BlobInfo.newBuilder(bucketName, blobName).build(), 14, TimeUnit.DAYS);
    // [END signUrl]
    return signedUrl;
  }

  /**
   * Example of creating a signed URL passing the {@link
   * SignUrlOption#signWith(ServiceAccountSigner)} option, that will be used for signing the URL.
   */
  // [TARGET signUrl(BlobInfo, long, TimeUnit, SignUrlOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE "/path/to/key.json"]
  public URL signUrlWithSigner(String bucketName, String blobName, String keyPath)
      throws IOException {
    // [START signUrlWithSigner]
    URL signedUrl =
        storage.signUrl(
            BlobInfo.newBuilder(bucketName, blobName).build(),
            14,
            TimeUnit.DAYS,
            SignUrlOption.signWith(
                ServiceAccountCredentials.fromStream(new FileInputStream(keyPath))));
    // [END signUrlWithSigner]
    return signedUrl;
  }

  /** Example of getting information on several blobs using a single batch request. */
  // [TARGET get(BlobId...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name1"]
  // [VARIABLE "my_blob_name2"]
  public List<Blob> batchGet(String bucketName, String blobName1, String blobName2) {
    // [START batchGet]
    BlobId firstBlob = BlobId.of(bucketName, blobName1);
    BlobId secondBlob = BlobId.of(bucketName, blobName2);
    List<Blob> blobs = storage.get(firstBlob, secondBlob);
    // [END batchGet]
    return blobs;
  }

  /** Example of getting information on several blobs using a single batch request. */
  // [TARGET get(Iterable)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name1"]
  // [VARIABLE "my_blob_name2"]
  public List<Blob> batchGetIterable(String bucketName, String blobName1, String blobName2) {
    // [START batchGetIterable]
    List<BlobId> blobIds = new LinkedList<>();
    blobIds.add(BlobId.of(bucketName, blobName1));
    blobIds.add(BlobId.of(bucketName, blobName2));
    List<Blob> blobs = storage.get(blobIds);
    // [END batchGetIterable]
    return blobs;
  }

  /** Example of updating information on several blobs using a single batch request. */
  // [TARGET update(BlobInfo...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name1"]
  // [VARIABLE "my_blob_name2"]
  public List<Blob> batchUpdate(String bucketName, String blobName1, String blobName2) {
    // [START batchUpdate]
    Blob firstBlob = storage.get(bucketName, blobName1);
    Blob secondBlob = storage.get(bucketName, blobName2);
    List<Blob> updatedBlobs =
        storage.update(
            firstBlob.toBuilder().setContentType("text/plain").build(),
            secondBlob.toBuilder().setContentType("text/plain").build());
    // [END batchUpdate]
    return updatedBlobs;
  }

  /** Example of updating information on several blobs using a single batch request. */
  // [TARGET update(Iterable)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name1"]
  // [VARIABLE "my_blob_name2"]
  public List<Blob> batchUpdateIterable(String bucketName, String blobName1, String blobName2) {
    // [START batchUpdateIterable]
    Blob firstBlob = storage.get(bucketName, blobName1);
    Blob secondBlob = storage.get(bucketName, blobName2);
    List<BlobInfo> blobs = new LinkedList<>();
    blobs.add(firstBlob.toBuilder().setContentType("text/plain").build());
    blobs.add(secondBlob.toBuilder().setContentType("text/plain").build());
    List<Blob> updatedBlobs = storage.update(blobs);
    // [END batchUpdateIterable]
    return updatedBlobs;
  }

  /** Example of deleting several blobs using a single batch request. */
  // [TARGET delete(BlobId...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name1"]
  // [VARIABLE "my_blob_name2"]
  public List<Boolean> batchDelete(String bucketName, String blobName1, String blobName2) {
    // [START batchDelete]
    BlobId firstBlob = BlobId.of(bucketName, blobName1);
    BlobId secondBlob = BlobId.of(bucketName, blobName2);
    List<Boolean> deleted = storage.delete(firstBlob, secondBlob);
    // [END batchDelete]
    return deleted;
  }

  /** Example of deleting several blobs using a single batch request. */
  // [TARGET delete(Iterable)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name1"]
  // [VARIABLE "my_blob_name2"]
  public List<Boolean> batchDeleteIterable(String bucketName, String blobName1, String blobName2) {
    // [START batchDeleteIterable]
    List<BlobId> blobIds = new LinkedList<>();
    blobIds.add(BlobId.of(bucketName, blobName1));
    blobIds.add(BlobId.of(bucketName, blobName2));
    List<Boolean> deleted = storage.delete(blobIds);
    // [END batchDeleteIterable]
    return deleted;
  }

  /** Example of getting the ACL entry for an entity on a bucket. */
  // [TARGET getAcl(String, Entity)]
  // [VARIABLE "my_unique_bucket"]
  public Acl getBucketAcl(String bucketName) {
    // [START getBucketAcl]
    Acl acl = storage.getAcl(bucketName, User.ofAllAuthenticatedUsers());
    // [END getBucketAcl]
    return acl;
  }

  /** Example of getting the ACL entry for a specific user on a bucket. */
  // [TARGET getAcl(String, Entity)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "google-cloud-java-tests@java-docs-samples-tests.iam.gserviceaccount.com"]
  public Acl getBucketAcl(String bucketName, String userEmail) {
    // [START storagePrintBucketAclForUser]
    Acl acl = storage.getAcl(bucketName, new User(userEmail));
    // [END storagePrintBucketAclForUser]
    return acl;
  }

  /** Example of deleting the ACL entry for an entity on a bucket. */
  // [TARGET deleteAcl(String, Entity)]
  // [VARIABLE "my_unique_bucket"]
  public boolean deleteBucketAcl(String bucketName) {
    // [START deleteBucketAcl]
    boolean deleted = storage.deleteAcl(bucketName, User.ofAllAuthenticatedUsers());
    if (deleted) {
      // the acl entry was deleted
    } else {
      // the acl entry was not found
    }
    // [END deleteBucketAcl]
    return deleted;
  }

  /** Example of creating a new ACL entry on a bucket. */
  // [TARGET createAcl(String, Acl)]
  // [VARIABLE "my_unique_bucket"]
  public Acl createBucketAcl(String bucketName) {
    // [START createBucketAcl]
    Acl acl = storage.createAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.READER));
    // [END createBucketAcl]
    return acl;
  }

  /** Example of updating a new ACL entry on a bucket. */
  // [TARGET updateAcl(String, Acl)]
  // [VARIABLE "my_unique_bucket"]
  public Acl updateBucketAcl(String bucketName) {
    // [START updateBucketAcl]
    Acl acl = storage.updateAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER));
    // [END updateBucketAcl]
    return acl;
  }

  /** Example of listing the ACL entries for a blob. */
  // [TARGET listAcls(String)]
  // [VARIABLE "my_unique_bucket"]
  public List<Acl> listBucketAcls(String bucketName) {
    // [START listBucketAcls]
    List<Acl> acls = storage.listAcls(bucketName);
    for (Acl acl : acls) {
      // do something with ACL entry
    }
    // [END listBucketAcls]
    return acls;
  }

  /** Example of getting the default ACL entry for an entity on a bucket. */
  // [TARGET getDefaultAcl(String, Entity)]
  // [VARIABLE "my_unique_bucket"]
  public Acl getDefaultBucketAcl(String bucketName) {
    // [START getDefaultBucketAcl]
    Acl acl = storage.getDefaultAcl(bucketName, User.ofAllAuthenticatedUsers());
    // [END getDefaultBucketAcl]
    return acl;
  }

  /** Example of deleting the default ACL entry for an entity on a bucket. */
  // [TARGET deleteDefaultAcl(String, Entity)]
  // [VARIABLE "my_unique_bucket"]
  public boolean deleteDefaultBucketAcl(String bucketName) {
    // [START deleteDefaultBucketAcl]
    boolean deleted = storage.deleteDefaultAcl(bucketName, User.ofAllAuthenticatedUsers());
    if (deleted) {
      // the acl entry was deleted
    } else {
      // the acl entry was not found
    }
    // [END deleteDefaultBucketAcl]
    return deleted;
  }

  /** Example of creating a new default ACL entry on a bucket. */
  // [TARGET createDefaultAcl(String, Acl)]
  // [VARIABLE "my_unique_bucket"]
  public Acl createDefaultBucketAcl(String bucketName) {
    // [START createDefaultBucketAcl]
    Acl acl =
        storage.createDefaultAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.READER));
    // [END createDefaultBucketAcl]
    return acl;
  }

  /** Example of updating a new default ACL entry on a bucket. */
  // [TARGET updateDefaultAcl(String, Acl)]
  // [VARIABLE "my_unique_bucket"]
  public Acl updateDefaultBucketAcl(String bucketName) {
    // [START updateDefaultBucketAcl]
    Acl acl =
        storage.updateDefaultAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER));
    // [END updateDefaultBucketAcl]
    return acl;
  }

  /** Example of listing the default ACL entries for a blob. */
  // [TARGET listDefaultAcls(String)]
  // [VARIABLE "my_unique_bucket"]
  public List<Acl> listDefaultBucketAcls(String bucketName) {
    // [START listDefaultBucketAcls]
    List<Acl> acls = storage.listDefaultAcls(bucketName);
    for (Acl acl : acls) {
      // do something with ACL entry
    }
    // [END listDefaultBucketAcls]
    return acls;
  }

  /** Example of getting the ACL entry for an entity on a blob. */
  // [TARGET getAcl(BlobId, Entity)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public Acl getBlobAcl(String bucketName, String blobName, long blobGeneration) {
    // [START getBlobAcl]
    BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
    Acl acl = storage.getAcl(blobId, User.ofAllAuthenticatedUsers());
    // [END getBlobAcl]
    return acl;
  }

  /** Example of getting the ACL entry for a specific user on a blob. */
  // [TARGET getAcl(BlobId, Entity)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE "google-cloud-java-tests@java-docs-samples-tests.iam.gserviceaccount.com"]
  public Acl getBlobAcl(String bucketName, String blobName, String userEmail) {
    // [START storagePrintFileAclForUser]
    BlobId blobId = BlobId.of(bucketName, blobName);
    Acl acl = storage.getAcl(blobId, new User(userEmail));
    // [END storagePrintFileAclForUser]
    return acl;
  }

  /** Example of deleting the ACL entry for an entity on a blob. */
  // [TARGET deleteAcl(BlobId, Entity)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public boolean deleteBlobAcl(String bucketName, String blobName, long blobGeneration) {
    // [START deleteBlobAcl]
    BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
    boolean deleted = storage.deleteAcl(blobId, User.ofAllAuthenticatedUsers());
    if (deleted) {
      // the acl entry was deleted
    } else {
      // the acl entry was not found
    }
    // [END deleteBlobAcl]
    return deleted;
  }

  /** Example of creating a new ACL entry on a blob. */
  // [TARGET createAcl(BlobId, Acl)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public Acl createBlobAcl(String bucketName, String blobName, long blobGeneration) {
    // [START createBlobAcl]
    BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
    Acl acl = storage.createAcl(blobId, Acl.of(User.ofAllAuthenticatedUsers(), Role.READER));
    // [END createBlobAcl]
    return acl;
  }

  /** Example of updating a new ACL entry on a blob. */
  // [TARGET updateAcl(BlobId, Acl)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public Acl updateBlobAcl(String bucketName, String blobName, long blobGeneration) {
    // [START updateBlobAcl]
    BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
    Acl acl = storage.updateAcl(blobId, Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER));
    // [END updateBlobAcl]
    return acl;
  }

  /** Example of updating a blob to be public-read. */
  // [TARGET createAcl(BlobId, Acl)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public Acl blobToPublicRead(String bucketName, String blobName, long blobGeneration) {
    // [START storageMakePublic]
    BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
    Acl acl = storage.createAcl(blobId, Acl.of(User.ofAllUsers(), Role.READER));
    // [END storageMakePublic]
    return acl;
  }

  /** Example of listing the ACL entries for a blob. */
  // [TARGET listAcls(BlobId)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public List<Acl> listBlobAcls(String bucketName, String blobName, long blobGeneration) {
    // [START listBlobAcls]
    BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
    List<Acl> acls = storage.listAcls(blobId);
    for (Acl acl : acls) {
      // do something with ACL entry
    }
    // [END listBlobAcls]
    return acls;
  }

  /** Example of default auth */
  public Page<Bucket> authListBuckets() {
    // [START auth_cloud_implicit]
    // If you don't specify credentials when constructing the client, the
    // client library will look for credentials in the environment.

    Storage storage = StorageOptions.getDefaultInstance().getService();

    Page<Bucket> buckets = storage.list();
    for (Bucket bucket : buckets.iterateAll()) {
      // do something with the info
    }
    // [END auth_cloud_implicit]
    return buckets;
  }

  /** Example of enabling Requester pays on a bucket. */
  public Bucket enableRequesterPays(String bucketName) throws StorageException {
    // [START enable_requester_pays]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of the existing bucket to enable requester-paying for, e.g. "my-bucket"
    // String bucketName = "my-bucket"
    BucketInfo bucketInfo = BucketInfo.newBuilder(bucketName).setRequesterPays(true).build();

    // Update the bucket, throws StorageException on failure
    Bucket bucket = storage.update(bucketInfo);

    System.out.println("Requester pay status for " + bucketName + ": " + bucket.requesterPays());
    // [END enable_requester_pays]
    return bucket;
  }

  /** Example of disabling Requester pays on a bucket. */
  public Bucket disableRequesterPays(String bucketName) {
    // [START disable_requester_pays]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of the bucket to disable requester-paying for, e.g. "my-bucket"
    // String bucketName = "my-bucket"
    BucketInfo bucketInfo = BucketInfo.newBuilder(bucketName).setRequesterPays(false).build();

    // Update the bucket, throws StorageException on failure
    Bucket bucket = storage.update(bucketInfo);

    System.out.println("Requester pays status for " + bucketName + ": " + bucket.requesterPays());
    // [END disable_requester_pays]
    return bucket;
  }

  /** Example of retrieving Requester pays status on a bucket. */
  public Bucket getRequesterPaysStatus(String bucketName) throws StorageException {
    // [START get_requester_pays_status]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of the bucket to retrieve requester-pays status, eg. "my-bucket"
    // String bucketName = "my-bucket"
    // Retrieve the bucket, throws StorageException on failure
    Bucket bucket = storage.get(bucketName, Storage.BucketGetOption.fields(BucketField.BILLING));

    System.out.println("Requester pays status : " + bucket.requesterPays());
    // [END get_requester_pays_status]
    return bucket;
  }

  /** Example of downloading a file. */
  public void downloadFile(String bucketName, String srcFilename, Path destFilePath)
      throws IOException {
    // [START storage_download_file]
    // The name of the bucket to access
    // String bucketName = "my-bucket";

    // The name of the remote file to download
    // String srcFilename = "file.txt";

    // The path to which the file should be downloaded
    // Path destFilePath = Paths.get("/local/path/to/file.txt");

    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // Get specific file from specified bucket
    Blob blob = storage.get(BlobId.of(bucketName, srcFilename));

    // Download file to specified path
    blob.downloadTo(destFilePath);
    // [END storage_download_file]
  }

  /** Example of downloading a file using Requester pay. */
  public void downloadFileUsingRequesterPays(
      String projectId, String bucketName, String srcFilename, Path destFilePath)
      throws IOException {
    // [START storage_download_file_requester_pays]
    // The project ID to bill
    // String projectId = "my-billable-project-id";

    // The name of the bucket to access
    // String bucketName = "my-bucket";

    // The name of the remote file to download
    // String srcFilename = "file.txt";

    // The path to which the file should be downloaded
    // Path destFilePath = Paths.get("/local/path/to/file.txt");

    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // Get specific file from specified bucket
    Blob blob = storage.get(BlobId.of(bucketName, srcFilename));

    // Download file to specified path
    blob.downloadTo(destFilePath, Blob.BlobSourceOption.userProject(projectId));
    // [END storage_download_file_requester_pays]
  }

  /** Example of setting a default KMS key on a bucket. */
  public Bucket setDefaultKmsKey(String bucketName, String kmsKeyName) throws StorageException {
    // [START storage_set_bucket_default_kms_key]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of the existing bucket to set a default KMS key for, e.g. "my-bucket"
    // String bucketName = "my-bucket"

    // The name of the KMS-key to use as a default
    // Key names are provided in the following format:
    // 'projects/<PROJECT>/locations/<LOCATION>/keyRings/<RING_NAME>/cryptoKeys/<KEY_NAME>'
    // String kmsKeyName = ""

    BucketInfo bucketInfo =
        BucketInfo.newBuilder(bucketName).setDefaultKmsKeyName(kmsKeyName).build();

    Bucket bucket = storage.update(bucketInfo);

    System.out.println("Default KMS Key Name: " + bucket.getDefaultKmsKeyName());
    // [END storage_set_bucket_default_kms_key]
    return bucket;
  }

  /** Example of displaying Bucket metadata */
  public void getBucketMetadata(String bucketName) throws StorageException {
    // [START storage_get_bucket_metadata]
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    // Select all fields
    // Fields can be selected individually e.g. Storage.BucketField.NAME
    Bucket bucket = storage.get(bucketName, BucketGetOption.fields(Storage.BucketField.values()));

    // Print bucket metadata
    System.out.println("BucketName: " + bucket.getName());
    System.out.println("DefaultEventBasedHold: " + bucket.getDefaultEventBasedHold());
    System.out.println("DefaultKmsKeyName: " + bucket.getDefaultKmsKeyName());
    System.out.println("Id: " + bucket.getGeneratedId());
    System.out.println("IndexPage: " + bucket.getIndexPage());
    System.out.println("Location: " + bucket.getLocation());
    System.out.println("LocationType: " + bucket.getLocationType());
    System.out.println("Metageneration: " + bucket.getMetageneration());
    System.out.println("NotFoundPage: " + bucket.getNotFoundPage());
    System.out.println("RetentionEffectiveTime: " + bucket.getRetentionEffectiveTime());
    System.out.println("RetentionPeriod: " + bucket.getRetentionPeriod());
    System.out.println("RetentionPolicyIsLocked: " + bucket.retentionPolicyIsLocked());
    System.out.println("RequesterPays: " + bucket.requesterPays());
    System.out.println("SelfLink: " + bucket.getSelfLink());
    System.out.println("StorageClass: " + bucket.getStorageClass().name());
    System.out.println("TimeCreated: " + bucket.getCreateTime());
    System.out.println("VersioningEnabled: " + bucket.versioningEnabled());
    if (bucket.getLabels() != null) {
      System.out.println("\n\n\nLabels:");
      for (Map.Entry<String, String> label : bucket.getLabels().entrySet()) {
        System.out.println(label.getKey() + "=" + label.getValue());
      }
    }
    // [END storage_get_bucket_metadata]
  }
  /** Example of displaying Blob metadata */
  public void getBlobMetadata(String bucketName, String blobName) throws StorageException {
    // [START storage_get_metadata]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    // The name of a blob, e.g. "my-blob"
    // String blobName = "my-blob";

    // Select all fields
    // Fields can be selected individually e.g. Storage.BlobField.CACHE_CONTROL
    Blob blob = storage.get(bucketName, blobName, BlobGetOption.fields(Storage.BlobField.values()));

    // Print blob metadata
    System.out.println("Bucket: " + blob.getBucket());
    System.out.println("CacheControl: " + blob.getCacheControl());
    System.out.println("ComponentCount: " + blob.getComponentCount());
    System.out.println("ContentDisposition: " + blob.getContentDisposition());
    System.out.println("ContentEncoding: " + blob.getContentEncoding());
    System.out.println("ContentLanguage: " + blob.getContentLanguage());
    System.out.println("ContentType: " + blob.getContentType());
    System.out.println("Crc32c: " + blob.getCrc32c());
    System.out.println("Crc32cHexString: " + blob.getCrc32cToHexString());
    System.out.println("ETag: " + blob.getEtag());
    System.out.println("Generation: " + blob.getGeneration());
    System.out.println("Id: " + blob.getBlobId());
    System.out.println("KmsKeyName: " + blob.getKmsKeyName());
    System.out.println("Md5Hash: " + blob.getMd5());
    System.out.println("Md5HexString: " + blob.getMd5ToHexString());
    System.out.println("MediaLink: " + blob.getMediaLink());
    System.out.println("Metageneration: " + blob.getMetageneration());
    System.out.println("Name: " + blob.getName());
    System.out.println("Size: " + blob.getSize());
    System.out.println("StorageClass: " + blob.getStorageClass());
    System.out.println("TimeCreated: " + new Date(blob.getCreateTime()));
    System.out.println("Last Metadata Update: " + new Date(blob.getUpdateTime()));
    Boolean temporaryHoldIsEnabled = (blob.getTemporaryHold() != null && blob.getTemporaryHold());
    System.out.println("temporaryHold: " + (temporaryHoldIsEnabled ? "enabled" : "disabled"));
    Boolean eventBasedHoldIsEnabled =
        (blob.getEventBasedHold() != null && blob.getEventBasedHold());
    System.out.println("eventBasedHold: " + (eventBasedHoldIsEnabled ? "enabled" : "disabled"));
    if (blob.getRetentionExpirationTime() != null) {
      System.out.println("retentionExpirationTime: " + new Date(blob.getRetentionExpirationTime()));
    }
    if (blob.getMetadata() != null) {
      System.out.println("\n\n\nUser metadata:");
      for (Map.Entry<String, String> userMetadata : blob.getMetadata().entrySet()) {
        System.out.println(userMetadata.getKey() + "=" + userMetadata.getValue());
      }
    }
    // [END storage_get_metadata]
  }

  /** Example of setting a retention policy on a bucket */
  public Bucket setRetentionPolicy(String bucketName, Long retentionPeriod)
      throws StorageException {
    // [START storage_set_retention_policy]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    // The retention period for objects in bucket
    // Long retentionPeriod = 3600L; // 1 hour in seconds

    Bucket bucketWithRetentionPolicy =
        storage.update(
            BucketInfo.newBuilder(bucketName).setRetentionPeriod(retentionPeriod).build());

    System.out.println(
        "Retention period for "
            + bucketName
            + " is now "
            + bucketWithRetentionPolicy.getRetentionPeriod());
    // [END storage_set_retention_policy]
    return bucketWithRetentionPolicy;
  }

  /** Example of removing a retention policy on a bucket */
  public Bucket removeRetentionPolicy(String bucketName)
      throws StorageException, IllegalArgumentException {
    // [START storage_remove_retention_policy]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    Bucket bucket = storage.get(bucketName, BucketGetOption.fields(BucketField.RETENTION_POLICY));
    if (bucket.retentionPolicyIsLocked() != null && bucket.retentionPolicyIsLocked()) {
      throw new IllegalArgumentException(
          "Unable to remove retention period as retention policy is locked.");
    }

    Bucket bucketWithoutRetentionPolicy =
        bucket.toBuilder().setRetentionPeriod(null).build().update();

    System.out.println("Retention period for " + bucketName + " has been removed");
    // [END storage_remove_retention_policy]
    return bucketWithoutRetentionPolicy;
  }

  /** Example of how to get a bucket's retention policy */
  public Bucket getRetentionPolicy(String bucketName) throws StorageException {
    // [START storage_get_retention_policy]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    Bucket bucket = storage.get(bucketName, BucketGetOption.fields(BucketField.RETENTION_POLICY));

    System.out.println("Retention Policy for " + bucketName);
    System.out.println("Retention Period: " + bucket.getRetentionPeriod());
    if (bucket.retentionPolicyIsLocked() != null && bucket.retentionPolicyIsLocked()) {
      System.out.println("Retention Policy is locked");
    }
    if (bucket.getRetentionEffectiveTime() != null) {
      System.out.println("Effective Time: " + new Date(bucket.getRetentionEffectiveTime()));
    }
    // [END storage_get_retention_policy]
    return bucket;
  }

  /** Example of how to lock a bucket retention policy */
  public Bucket lockRetentionPolicy(String bucketName) throws StorageException {
    // [START storage_lock_retention_policy]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    Bucket bucket =
        storage.get(bucketName, Storage.BucketGetOption.fields(BucketField.METAGENERATION));
    Bucket lockedBucket =
        bucket.lockRetentionPolicy(Storage.BucketTargetOption.metagenerationMatch());

    System.out.println("Retention period for " + bucketName + " is now locked");
    System.out.println(
        "Retention policy effective as of " + new Date(lockedBucket.getRetentionEffectiveTime()));
    // [END storage_lock_retention_policy]
    return lockedBucket;
  }

  /** Example of how to enable default event-based hold for a bucket */
  public Bucket enableDefaultEventBasedHold(String bucketName) throws StorageException {
    // [START storage_enable_default_event_based_hold]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    Bucket bucket =
        storage.update(BucketInfo.newBuilder(bucketName).setDefaultEventBasedHold(true).build());

    System.out.println("Default event-based hold was enabled for " + bucketName);
    // [END storage_enable_default_event_based_hold]
    return bucket;
  }

  /** Example of how to disable default event-based hold for a bucket */
  public Bucket disableDefaultEventBasedHold(String bucketName) throws StorageException {
    // [START storage_disable_default_event_based_hold]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    Bucket bucket =
        storage.update(BucketInfo.newBuilder(bucketName).setDefaultEventBasedHold(false).build());

    System.out.println("Default event-based hold was disabled for " + bucketName);
    // [END storage_disable_default_event_based_hold]
    return bucket;
  }

  /** Example of how to get default event-based hold for a bucket */
  public Bucket getDefaultEventBasedHold(String bucketName) throws StorageException {
    // [START storage_get_default_event_based_hold]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    Bucket bucket =
        storage.get(bucketName, BucketGetOption.fields(BucketField.DEFAULT_EVENT_BASED_HOLD));

    if (bucket.getDefaultEventBasedHold() != null && bucket.getDefaultEventBasedHold()) {
      System.out.println("Default event-based hold is enabled for " + bucketName);
    } else {
      System.out.println("Default event-based hold is not enabled for " + bucketName);
    }
    // [END storage_get_default_event_based_hold]
    return bucket;
  }

  /** Example of how to set event-based hold for a blob */
  public Blob setEventBasedHold(String bucketName, String blobName) throws StorageException {
    // [START storage_set_event_based_hold]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    // The name of a blob, e.g. "my-blob"
    // String blobName = "my-blob";

    BlobId blobId = BlobId.of(bucketName, blobName);
    Blob blob = storage.update(BlobInfo.newBuilder(blobId).setEventBasedHold(true).build());

    System.out.println("Event-based hold was set for " + blobName);
    // [END storage_set_event_based_hold]
    return blob;
  }

  /** Example of how to release event-based hold for a blob */
  public Blob releaseEventBasedHold(String bucketName, String blobName) throws StorageException {
    // [START storage_release_event_based_hold]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    // The name of a blob, e.g. "my-blob"
    // String blobName = "my-blob";

    BlobId blobId = BlobId.of(bucketName, blobName);
    Blob blob = storage.update(BlobInfo.newBuilder(blobId).setEventBasedHold(false).build());

    System.out.println("Event-based hold was released for " + blobName);
    // [END storage_release_event_based_hold]
    return blob;
  }

  /** Example of how to set a temporary hold for a blob */
  public Blob setTemporaryHold(String bucketName, String blobName) throws StorageException {
    // [START storage_set_temporary_hold]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    // The name of a blob, e.g. "my-blob"
    // String blobName = "my-blob";

    BlobId blobId = BlobId.of(bucketName, blobName);
    Blob blob = storage.update(BlobInfo.newBuilder(blobId).setTemporaryHold(true).build());

    System.out.println("Temporary hold was set for " + blobName);
    // [END storage_set_temporary_hold]
    return blob;
  }

  /** Example of how to release a temporary hold for a blob */
  public Blob releaseTemporaryHold(String bucketName, String blobName) throws StorageException {
    // [START storage_release_temporary_hold]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    // The name of a blob, e.g. "my-blob"
    // String blobName = "my-blob";

    BlobId blobId = BlobId.of(bucketName, blobName);
    Blob blob = storage.update(BlobInfo.newBuilder(blobId).setTemporaryHold(false).build());

    System.out.println("Temporary hold was released for " + blobName);
    // [END storage_release_temporary_hold]
    return blob;
  }

  /** Example of how to enable Bucket Policy Only for a bucket */
  public Bucket enableBucketPolicyOnly(String bucketName) throws StorageException {
    // [START storage_enable_bucket_policy_only]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    BucketInfo.IamConfiguration iamConfiguration =
        BucketInfo.IamConfiguration.newBuilder().setIsBucketPolicyOnlyEnabled(true).build();
    Bucket bucket =
        storage.update(
            BucketInfo.newBuilder(bucketName).setIamConfiguration(iamConfiguration).build());

    System.out.println("Bucket Policy Only was enabled for " + bucketName);
    // [END storage_enable_bucket_policy_only]
    return bucket;
  }

  /** Example of how to disable Bucket Policy Only for a bucket */
  public Bucket disableBucketPolicyOnly(String bucketName) throws StorageException {
    // [START storage_disable_bucket_policy_only]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    BucketInfo.IamConfiguration iamConfiguration =
        BucketInfo.IamConfiguration.newBuilder().setIsBucketPolicyOnlyEnabled(false).build();
    Bucket bucket =
        storage.update(
            BucketInfo.newBuilder(bucketName).setIamConfiguration(iamConfiguration).build());

    System.out.println("Bucket Policy Only was disabled for " + bucketName);
    // [END storage_disable_bucket_policy_only]
    return bucket;
  }

  /** Example of how to get Bucket Policy Only metadata for a bucket */
  public Bucket getBucketPolicyOnly(String bucketName) throws StorageException {
    // [START storage_get_bucket_policy_only]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    Bucket bucket = storage.get(bucketName, BucketGetOption.fields(BucketField.IAMCONFIGURATION));
    BucketInfo.IamConfiguration iamConfiguration = bucket.getIamConfiguration();

    Boolean enabled = iamConfiguration.isBucketPolicyOnlyEnabled();
    Date lockedTime = new Date(iamConfiguration.getBucketPolicyOnlyLockedTime());

    if (enabled != null && enabled) {
      System.out.println("Bucket Policy Only is enabled for " + bucketName);
      System.out.println("Bucket will be locked on " + lockedTime);
    } else {
      System.out.println("Bucket Policy Only is disabled for " + bucketName);
    }
    // [END storage_get_bucket_policy_only]
    return bucket;
  }

  /** Example of how to generate a GET V4 Signed URL */
  public URL generateV4GetObjectSignedUrl(String bucketName, String objectName)
      throws StorageException {
    // [START storage_generate_signed_url_v4]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    // The name of an object, e.g. "my-object"
    // String objectName = "my-object";

    // Define resource
    BlobInfo blobinfo = BlobInfo.newBuilder(BlobId.of(bucketName, objectName)).build();

    // Generate Signed URL
    URL url =
        storage.signUrl(blobinfo, 15, TimeUnit.MINUTES, Storage.SignUrlOption.withV4Signature());

    System.out.println("Generated GET signed URL:");
    System.out.println(url);
    System.out.println("You can use this URL with any user agent, for example:");
    System.out.println("curl '" + url + "'");
    // [END storage_generate_signed_url_v4]
    return url;
  }

  /** Example of how to generate a PUT V4 Signed URL */
  public URL generateV4GPutbjectSignedUrl(String bucketName, String objectName)
      throws StorageException {
    // [START storage_generate_upload_signed_url_v4]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of a bucket, e.g. "my-bucket"
    // String bucketName = "my-bucket";

    // The name of a new object to upload, e.g. "my-object"
    // String objectName = "my-object";

    // Define Resource
    BlobInfo blobinfo = BlobInfo.newBuilder(BlobId.of(bucketName, objectName)).build();

    // Generate Signed URL
    Map<String, String> extensionHeaders = new HashMap<>();
    extensionHeaders.put("Content-Type", "application/octet-stream");

    URL url =
        storage.signUrl(
            blobinfo,
            15,
            TimeUnit.MINUTES,
            Storage.SignUrlOption.httpMethod(HttpMethod.PUT),
            Storage.SignUrlOption.withExtHeaders(extensionHeaders),
            Storage.SignUrlOption.withV4Signature());

    System.out.println("Generated PUT signed URL:");
    System.out.println(url);
    System.out.println("You can use this URL with any user agent, for example:");
    System.out.println(
        "curl -X PUT -H 'Content-Type: application/octet-stream' --upload-file my-file '"
            + url
            + "'");
    // [END storage_generate_upload_signed_url_v4]
    return url;
  }

  /** Example of creating an HMAC key for a service account * */
  public HmacKey createHmacKey(String serviceAccountEmail, String projectId)
      throws StorageException {
    // [START storage_create_hmac_key]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The service account email for which the new HMAC key will be created.
    // String serviceAccountEmail = "service-account@iam.gserviceaccount.com";
    //
    // The ID of the project to which the service account belongs.
    // String projectId = "project-id";

    ServiceAccount account = ServiceAccount.of(serviceAccountEmail);
    HmacKey hmacKey =
        storage.createHmacKey(account, Storage.CreateHmacKeyOption.projectId(projectId));

    String secret = hmacKey.getSecretKey();
    HmacKeyMetadata metadata = hmacKey.getMetadata();

    System.out.println("The Base64 encoded secret is: " + secret);
    System.out.println("Do not miss that secret, there is no API to recover it.");
    System.out.println("The HMAC key metadata is:");
    System.out.println("ID: " + metadata.getId());
    System.out.println("Access ID: " + metadata.getAccessId());
    System.out.println("Project ID: " + metadata.getProjectId());
    System.out.println("Service Account Email: " + metadata.getServiceAccount().getEmail());
    System.out.println("State: " + metadata.getState().toString());
    System.out.println("Time Created: " + new Date(metadata.getCreateTime()).toString());
    System.out.println("Time Updated: " + new Date(metadata.getUpdateTime()).toString());
    System.out.println("ETag: " + metadata.getEtag());
    // [END storage_create_hmac_key]
    return hmacKey;
  }

  /** Example of retrieving the metadata of an existing HMAC key. * */
  public HmacKeyMetadata getHmacKey(String accessId, String projectId) throws StorageException {
    // [START storage_get_hmac_key]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The access ID of the HMAC key, e.g. "GOOG0234230X00"
    // String accessId = "GOOG0234230X00";
    //
    // The ID of the project to which the service account belongs.
    // String projectId = "project-id";
    HmacKeyMetadata metadata =
        storage.getHmacKey(accessId, Storage.GetHmacKeyOption.projectId(projectId));

    System.out.println("The HMAC key metadata is:");
    System.out.println("ID: " + metadata.getId());
    System.out.println("Access ID: " + metadata.getAccessId());
    System.out.println("Project ID: " + metadata.getProjectId());
    System.out.println("Service Account Email: " + metadata.getServiceAccount().getEmail());
    System.out.println("State: " + metadata.getState().toString());
    System.out.println("Time Created: " + new Date(metadata.getCreateTime()).toString());
    System.out.println("Time Updated: " + new Date(metadata.getUpdateTime()).toString());
    System.out.println("ETag: " + metadata.getEtag());
    // [END storage_get_hmac_key]
    return metadata;
  }

  /** Example of deleting an existing inactive HMAC key. * */
  public void deleteHmacKey(String accessId, String projectId) throws StorageException {
    // [START storage_delete_hmac_key]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The access ID of the HMAC key, e.g. "GOOG0234230X00"
    // String accessId = "GOOG0234230X00";
    //
    // The ID of the project to which the service account belongs.
    // String projectId = "project-id";
    HmacKeyMetadata metadata =
        storage.getHmacKey(accessId, Storage.GetHmacKeyOption.projectId(projectId));
    storage.deleteHmacKey(metadata);

    System.out.println(
        "The key is deleted, though it will still appear in getHmacKeys() results given showDeletedKey is true.");
    // [END storage_delete_hmac_key]
  }

  /** Example of activating a previously deactivated HMAC key. * */
  public HmacKeyMetadata activateHmacKey(String accessId, String projectId)
      throws StorageException {
    // [START storage_activate_hmac_key]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The access ID of the HMAC key, e.g. "GOOG0234230X00"
    // String accessId = "GOOG0234230X00";
    //
    // The ID of the project to which the service account belongs.
    // String projectId = "project-id";
    HmacKeyMetadata metadata =
        storage.getHmacKey(accessId, Storage.GetHmacKeyOption.projectId(projectId));
    HmacKeyMetadata newMetadata = storage.updateHmacKeyState(metadata, HmacKeyState.ACTIVE);

    System.out.println("The HMAC key is now active.");
    System.out.println("The HMAC key metadata is:");
    System.out.println("ID: " + newMetadata.getId());
    System.out.println("Access ID: " + newMetadata.getAccessId());
    System.out.println("Project ID: " + newMetadata.getProjectId());
    System.out.println("Service Account Email: " + newMetadata.getServiceAccount().getEmail());
    System.out.println("State: " + newMetadata.getState().toString());
    System.out.println("Time Created: " + new Date(newMetadata.getCreateTime()).toString());
    System.out.println("Time Updated: " + new Date(newMetadata.getUpdateTime()).toString());
    System.out.println("ETag: " + newMetadata.getEtag());
    // [END storage_activate_hmac_key]
    return newMetadata;
  }

  /** Example of deactivating an HMAC key. * */
  public HmacKeyMetadata deactivateHmacKey(String accessId, String projectId)
      throws StorageException {
    // [START storage_deactivate_hmac_key]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The access ID of the HMAC key, e.g. "GOOG0234230X00"
    // String accessId = "GOOG0234230X00";
    //
    // The ID of the project to which the service account belongs.
    // String projectId = "project-id";
    HmacKeyMetadata metadata =
        storage.getHmacKey(accessId, Storage.GetHmacKeyOption.projectId(projectId));
    HmacKeyMetadata newMetadata = storage.updateHmacKeyState(metadata, HmacKeyState.INACTIVE);

    System.out.println("The HMAC key is now inactive.");
    System.out.println("The HMAC key metadata is:");
    System.out.println("ID: " + newMetadata.getId());
    System.out.println("Access ID: " + newMetadata.getAccessId());
    System.out.println("Project ID: " + newMetadata.getProjectId());
    System.out.println("Service Account Email: " + newMetadata.getServiceAccount().getEmail());
    System.out.println("State: " + newMetadata.getState().toString());
    System.out.println("Time Created: " + new Date(newMetadata.getCreateTime()).toString());
    System.out.println("Time Updated: " + new Date(newMetadata.getUpdateTime()).toString());
    System.out.println("ETag: " + newMetadata.getEtag());
    // [END storage_deactivate_hmac_key]
    return newMetadata;
  }

  public Page<HmacKeyMetadata> listHmacKeys(String projectId) throws StorageException {
    // [START storage_list_hmac_keys]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The ID of the project to which the service account belongs.
    // String projectId = "project-id";
    Page<HmacKeyMetadata> page = storage.listHmacKeys(ListHmacKeysOption.projectId(projectId));

    for (HmacKeyMetadata metadata : page.iterateAll()) {
      System.out.println("Service Account Email: " + metadata.getServiceAccount().getEmail());
      System.out.println("Access ID: " + metadata.getAccessId());
    }
    // [END storage_list_hmac_keys]
    return page;
  }
}
