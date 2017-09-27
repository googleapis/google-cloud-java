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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in Storage's javadoc. Any change to this file should be reflected in
 * Storage's javadoc.
 */

package com.google.cloud.examples.storage.snippets;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.auth.ServiceAccountSigner;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.BatchResult;
import com.google.api.gax.paging.Page;
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
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobGetOption;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.Storage.BucketField;
import com.google.cloud.storage.Storage.BucketGetOption;
import com.google.cloud.storage.Storage.BucketListOption;
import com.google.cloud.storage.Storage.BucketSourceOption;
import com.google.cloud.storage.Storage.ComposeRequest;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.cloud.storage.Storage.SignUrlOption;
import com.google.cloud.storage.StorageBatch;
import com.google.cloud.storage.StorageBatchResult;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * This class contains a number of snippets for the {@link Storage} interface.
 */
public class StorageSnippets {

  private final Storage storage;

  public StorageSnippets(Storage storage) {
    this.storage = storage;
  }

  /**
   * Example of creating a bucket.
   */
  // [TARGET create(BucketInfo, BucketTargetOption...)]
  // [VARIABLE "my_unique_bucket"]
  public Bucket createBucket(String bucketName) {
    // [START createBucket]
    Bucket bucket = storage.create(BucketInfo.of(bucketName));
    // [END createBucket]
    return bucket;
  }

  /**
   * Example of creating a bucket with storage class and location.
   */
  // [TARGET create(BucketInfo, BucketTargetOption...)]
  // [VARIABLE "my_unique_bucket"]
  public Bucket createBucketWithStorageClassAndLocation(String bucketName) {
    // [START createBucketWithStorageClassAndLocation]
    Bucket bucket = storage.create(BucketInfo.newBuilder(bucketName)
        // See here for possible values: http://g.co/cloud/storage/docs/storage-classes
        .setStorageClass(StorageClass.COLDLINE)
        // Possible values: http://g.co/cloud/storage/docs/bucket-locations#location-mr
        .setLocation("asia")
        .build());
    // [END createBucketWithStorageClassAndLocation]
    return bucket;
  }

  /**
   * Example of creating a blob with no content.
   */
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

  /**
   * Example of creating a blob from a byte array.
   */
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

  /**
   * Example of creating a blob from an input stream.
   */
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

  /**
   * Example of uploading an encrypted blob.
   */
  // [TARGET create(BlobInfo, InputStream, BlobWriteOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE "my_encryption_key"]
  public Blob createEncryptedBlob(String bucketName, String blobName, String encryptionKey) {
    // [START storageUploadEncryptedFile]
    InputStream content = new ByteArrayInputStream("Hello, World!".getBytes(UTF_8));

    BlobId blobId = BlobId.of(bucketName, blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
        .setContentType("text/plain")
        .build();
    Blob blob = storage.create(blobInfo, content, BlobWriteOption.encryptionKey(encryptionKey));
    // [END storageUploadEncryptedFile]
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
    Bucket bucket = storage.get(bucketName,
        BucketGetOption.metagenerationMatch(bucketMetageneration));
    // [END getBucketWithMetageneration]
    return bucket;
  }

  /**
   * Example of getting information on a blob, only if its metageneration matches a value,
   * otherwise a {@link StorageException} is thrown.
   */
  // [TARGET get(String, String, BlobGetOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public Blob getBlobFromStringsWithMetageneration(String bucketName, String blobName,
      long blobMetageneration) {
    // [START getBlobFromStringsWithMetageneration]
    Blob blob = storage.get(bucketName, blobName,
        BlobGetOption.metagenerationMatch(blobMetageneration));
    // [END getBlobFromStringsWithMetageneration]
    return blob;
  }

  /**
   * Example of getting information on a blob.
   */
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
   * Example of getting information on a blob, only if its metageneration matches a value,
   * otherwise a {@link StorageException} is thrown.
   */
  // [TARGET get(BlobId, BlobGetOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public Blob getBlobFromIdWithMetageneration(String bucketName, String blobName,
      long blobMetageneration) {
    // [START getBlobFromIdWithMetageneration]
    BlobId blobId = BlobId.of(bucketName, blobName);
    Blob blob = storage.get(blobId, BlobGetOption.metagenerationMatch(blobMetageneration));
    // [END getBlobFromIdWithMetageneration]
    return blob;
  }

  /**
   * Example of listing buckets, specifying the page size and a name prefix.
   */
  // [TARGET list(BucketListOption...)]
  // [VARIABLE "bucket_"]
  public Page<Bucket> listBucketsWithSizeAndPrefix(String prefix) {
    // [START listBucketsWithSizeAndPrefix]
    Page<Bucket> buckets = storage.list(BucketListOption.pageSize(100),
        BucketListOption.prefix(prefix));
    for (Bucket bucket : buckets.iterateAll()) {
      // do something with the bucket
    }
    // [END listBucketsWithSizeAndPrefix]
    return buckets;
  }

  /**
   * Example of listing blobs in a provided directory.
   */
  // [TARGET list(String, BlobListOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_directory/"]
  public Page<Blob> listBlobsWithDirectoryAndPrefix(String bucketName, String directory) {
    // [START listBlobsWithDirectoryAndPrefix]
    Page<Blob> blobs = storage.list(bucketName, BlobListOption.currentDirectory(),
        BlobListOption.prefix(directory));
    for (Blob blob : blobs.iterateAll()) {
      // do something with the blob
    }
    // [END listBlobsWithDirectoryAndPrefix]
    return blobs;
  }

  /**
   * Example of updating bucket information.
   */
  // [TARGET update(BucketInfo, BucketTargetOption...)]
  // [VARIABLE "my_unique_bucket"]
  public Bucket updateBucket(String bucketName) {
    // [START updateBucket]
    BucketInfo bucketInfo = BucketInfo.newBuilder(bucketName).setVersioningEnabled(true).build();
    Bucket bucket = storage.update(bucketInfo);
    // [END updateBucket]
    return bucket;
  }

  /**
   * Example of replacing blob's metadata.
   */
  // [TARGET update(BlobInfo)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  public Blob updateBlob(String bucketName, String blobName) {
    // [START updateBlob]
    Map<String, String> newMetadata = new HashMap<>();
    newMetadata.put("key", "value");
    storage.update(BlobInfo.newBuilder(bucketName, blobName).setMetadata(null).build());
    Blob blob = storage.update(BlobInfo.newBuilder(bucketName, blobName)
        .setMetadata(newMetadata)
        .build());
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
   * Example of deleting a bucket, only if its metageneration matches a value, otherwise a
   * {@link StorageException} is thrown.
   */
  // [TARGET delete(String, BucketSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE 42]
  public boolean deleteBucketWithMetageneration(String bucketName, long bucketMetageneration) {
    // [START deleteBucketWithMetageneration]
    boolean deleted = storage.delete(bucketName,
        BucketSourceOption.metagenerationMatch(bucketMetageneration));
    if (deleted) {
      // the bucket was deleted
    } else {
      // the bucket was not found
    }
    // [END deleteBucketWithMetageneration]
    return deleted;
  }

  /**
   * Example of deleting a blob, only if its generation matches a value, otherwise a
   * {@link StorageException} is thrown.
   */
  // [TARGET delete(String, String, BlobSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public boolean deleteBlobFromStringsWithGeneration(String bucketName, String blobName,
      long blobGeneration) {
    // [START deleteBlobFromStringsWithGeneration]
    boolean deleted = storage.delete(bucketName, blobName,
        BlobSourceOption.generationMatch(blobGeneration));
    if (deleted) {
      // the blob was deleted
    } else {
      // the blob was not found
    }
    // [END deleteBlobFromStringsWithGeneration]
    return deleted;
  }

  /**
   * Example of deleting a blob, only if its generation matches a value, otherwise a
   * {@link StorageException} is thrown.
   */
  // [TARGET delete(BlobId, BlobSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public boolean deleteBlobFromIdWithGeneration(String bucketName, String blobName,
      long blobGeneration) {
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

  /**
   * Example of deleting a blob.
   */
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

  /**
   * Example of composing two blobs.
   */
  // [TARGET compose(ComposeRequest)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE "source_blob_1"]
  // [VARIABLE "source_blob_2"]
  public Blob composeBlobs(String bucketName, String blobName, String sourceBlob1,
      String sourceBlob2) {
    // [START composeBlobs]
    BlobId blobId = BlobId.of(bucketName, blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
    ComposeRequest request = ComposeRequest.newBuilder()
        .setTarget(blobInfo)
        .addSource(sourceBlob1)
        .addSource(sourceBlob2)
        .build();
    Blob blob = storage.compose(request);
    // [END composeBlobs]
    return blob;
  }

  /**
   * Example of copying a blob.
   */
  // [TARGET copy(CopyRequest)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE "copy_blob_name"]
  public Blob copyBlob(String bucketName, String blobName, String copyBlobName) {
    // [START copyBlob]
    CopyRequest request = CopyRequest.newBuilder()
        .setSource(BlobId.of(bucketName, blobName))
        .setTarget(BlobId.of(bucketName, copyBlobName))
        .build();
    Blob blob = storage.copy(request).getResult();
    // [END copyBlob]
    return blob;
  }

  /**
   * Example of copying a blob in chunks.
   */
  // [TARGET copy(CopyRequest)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE "copy_blob_name"]
  public Blob copyBlobInChunks(String bucketName, String blobName, String copyBlobName) {
    // [START copyBlobInChunks]
    CopyRequest request = CopyRequest.newBuilder()
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

  /**
   * Example of rotating the encryption key of a blob.
   */
  // [TARGET copy(CopyRequest)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE "old_encryption_key"]
  // [VARIABLE "new_encryption_key"]
  public Blob rotateBlobEncryptionKey(
      String bucketName, String blobName, String oldEncryptionKey, String newEncryptionKey) {
    // [START storageRotateEncryptionKey]
    BlobId blobId = BlobId.of(bucketName, blobName);
    CopyRequest request = CopyRequest.newBuilder()
        .setSource(blobId)
        .setSourceOptions(BlobSourceOption.decryptionKey(oldEncryptionKey))
        .setTarget(blobId, BlobTargetOption.encryptionKey(newEncryptionKey))
        .build();
    Blob blob = storage.copy(request).getResult();
    // [END storageRotateEncryptionKey]
    return blob;
  }

  /**
   * Example of reading all bytes of a blob, if generation matches a value, otherwise a
   * {@link StorageException} is thrown.
   */
  // [TARGET readAllBytes(String, String, BlobSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42"]
  public byte[] readBlobFromStringsWithGeneration(String bucketName, String blobName,
      long blobGeneration) {
    // [START readBlobFromStringsWithGeneration]
    byte[] content = storage.readAllBytes(bucketName, blobName,
        BlobSourceOption.generationMatch(blobGeneration));
    // [END readBlobFromStringsWithGeneration]
    return content;
  }

  /**
   * Example of reading all bytes of a blob's specific generation, otherwise a
   * {@link StorageException} is thrown.
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

  /**
   * Example of reading all bytes of an encrypted blob.
   */
  // [TARGET readAllBytes(BlobId, BlobSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE "my_encryption_key"]
  public byte[] readEncryptedBlob(String bucketName, String blobName, String decryptionKey) {
    // [START readEncryptedBlob]
    byte[] content = storage.readAllBytes(
        bucketName, blobName, BlobSourceOption.decryptionKey(decryptionKey));
    // [END readEncryptedBlob]
    return content;
  }

  /**
   * Example of using a batch request to delete, update and get a blob.
   */
  // [TARGET batch()]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name1"]
  // [VARIABLE "my_blob_name2"]
  public Blob batch(String bucketName, String blobName1, String blobName2) {
    // [START batch]
    StorageBatch batch = storage.batch();
    BlobId firstBlob = BlobId.of(bucketName, blobName1);
    BlobId secondBlob = BlobId.of(bucketName, blobName2);
    batch.delete(firstBlob).notify(new BatchResult.Callback<Boolean, StorageException>() {
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

  /**
   * Example of reading a blob's content through a reader.
   */
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

  /**
   * Example of reading a blob's content through a reader.
   */
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

  /**
   * Example of writing a blob's content through a writer.
   */
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
   * Example of creating a signed URL that is valid for 2 weeks, using the default credentials
   * for signing the URL.
   */
  // [TARGET signUrl(BlobInfo, long, TimeUnit, SignUrlOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  public URL signUrl(String bucketName, String blobName) {
    // [START signUrl]
    URL signedUrl = storage.signUrl(BlobInfo.newBuilder(bucketName, blobName).build(), 14,
        TimeUnit.DAYS);
    // [END signUrl]
    return signedUrl;
  }

  /**
   * Example of creating a signed URL passing the
   * {@link SignUrlOption#signWith(ServiceAccountSigner)} option, that will be used for signing the
   * URL.
   */
  // [TARGET signUrl(BlobInfo, long, TimeUnit, SignUrlOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE "/path/to/key.json"]
  public URL signUrlWithSigner(String bucketName, String blobName, String keyPath)
      throws IOException {
    // [START signUrlWithSigner]
    URL signedUrl = storage.signUrl(BlobInfo.newBuilder(bucketName, blobName).build(),
        14, TimeUnit.DAYS, SignUrlOption.signWith(
            ServiceAccountCredentials.fromStream(new FileInputStream(keyPath))));
    // [END signUrlWithSigner]
    return signedUrl;
  }

  /**
   * Example of getting information on several blobs using a single batch request.
   */
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

  /**
   * Example of getting information on several blobs using a single batch request.
   */
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

  /**
   * Example of updating information on several blobs using a single batch request.
   */
  // [TARGET update(BlobInfo...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "my_blob_name1"]
  // [VARIABLE "my_blob_name2"]
  public List<Blob> batchUpdate(String bucketName, String blobName1, String blobName2) {
    // [START batchUpdate]
    Blob firstBlob = storage.get(bucketName, blobName1);
    Blob secondBlob = storage.get(bucketName, blobName2);
    List<Blob> updatedBlobs = storage.update(
        firstBlob.toBuilder().setContentType("text/plain").build(),
        secondBlob.toBuilder().setContentType("text/plain").build());
    // [END batchUpdate]
    return updatedBlobs;
  }

  /**
   * Example of updating information on several blobs using a single batch request.
   */
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

  /**
   * Example of deleting several blobs using a single batch request.
   */
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

  /**
   * Example of deleting several blobs using a single batch request.
   */
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

  /**
   * Example of getting the ACL entry for an entity on a bucket.
   */
  // [TARGET getAcl(String, Entity)]
  // [VARIABLE "my_unique_bucket"]
  public Acl getBucketAcl(String bucketName) {
    // [START getBucketAcl]
    Acl acl = storage.getAcl(bucketName, User.ofAllAuthenticatedUsers());
    // [END getBucketAcl]
    return acl;
  }

  /**
   * Example of getting the ACL entry for a specific user on a bucket.
   */
  // [TARGET getAcl(String, Entity)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "google-cloud-java-tests@java-docs-samples-tests.iam.gserviceaccount.com"]
  public Acl getBucketAcl(String bucketName, String userEmail) {
    // [START storagePrintBucketAclForUser]
    Acl acl = storage.getAcl(bucketName, new User(userEmail));
    // [END storagePrintBucketAclForUser]
    return acl;
  }

  /**
   * Example of deleting the ACL entry for an entity on a bucket.
   */
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

  /**
   * Example of creating a new ACL entry on a bucket.
   */
  // [TARGET createAcl(String, Acl)]
  // [VARIABLE "my_unique_bucket"]
  public Acl createBucketAcl(String bucketName) {
    // [START createBucketAcl]
    Acl acl = storage.createAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.READER));
    // [END createBucketAcl]
    return acl;
  }

  /**
   * Example of updating a new ACL entry on a bucket.
   */
  // [TARGET updateAcl(String, Acl)]
  // [VARIABLE "my_unique_bucket"]
  public Acl updateBucketAcl(String bucketName) {
    // [START updateBucketAcl]
    Acl acl = storage.updateAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER));
    // [END updateBucketAcl]
    return acl;
  }

  /**
   * Example of listing the ACL entries for a blob.
   */
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

  /**
   * Example of getting the default ACL entry for an entity on a bucket.
   */
  // [TARGET getDefaultAcl(String, Entity)]
  // [VARIABLE "my_unique_bucket"]
  public Acl getDefaultBucketAcl(String bucketName) {
    // [START getDefaultBucketAcl]
    Acl acl = storage.getDefaultAcl(bucketName, User.ofAllAuthenticatedUsers());
    // [END getDefaultBucketAcl]
    return acl;
  }

  /**
   * Example of deleting the default ACL entry for an entity on a bucket.
   */
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

  /**
   * Example of creating a new default ACL entry on a bucket.
   */
  // [TARGET createDefaultAcl(String, Acl)]
  // [VARIABLE "my_unique_bucket"]
  public Acl createDefaultBucketAcl(String bucketName) {
    // [START createDefaultBucketAcl]
    Acl acl =
        storage.createDefaultAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.READER));
    // [END createDefaultBucketAcl]
    return acl;
  }

  /**
   * Example of updating a new default ACL entry on a bucket.
   */
  // [TARGET updateDefaultAcl(String, Acl)]
  // [VARIABLE "my_unique_bucket"]
  public Acl updateDefaultBucketAcl(String bucketName) {
    // [START updateDefaultBucketAcl]
    Acl acl =
        storage.updateDefaultAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER));
    // [END updateDefaultBucketAcl]
    return acl;
  }

  /**
   * Example of listing the default ACL entries for a blob.
   */
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

  /**
   * Example of getting the ACL entry for an entity on a blob.
   */
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

  /**
   * Example of getting the ACL entry for a specific user on a blob.
   */
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

  /**
   * Example of deleting the ACL entry for an entity on a blob.
   */
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

  /**
   * Example of creating a new ACL entry on a blob.
   */
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

  /**
   * Example of updating a new ACL entry on a blob.
   */
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

  /**
   * Example of updating a blob to be public-read.
   */
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

  /**
   * Example of listing the ACL entries for a blob.
   */
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

  /**
   * Example of default auth
   */
  public Page<Bucket> authListBuckets() {
    // [START authListBucket]
    // If you don't specify credentials when constructing the client, the
    // client library will look for credentials in the environment.

    Storage storage = StorageOptions.getDefaultInstance().getService();

    Page<Bucket> buckets = storage.list();
    for (Bucket bucket : buckets.iterateAll()) {
      // do something with the info
    }
    // [END authListBucket]
    return buckets;
  }

  /**
   * Example of enabling Requester pays on a bucket.
   */
  public Bucket enableRequesterPays(String  bucketName) throws StorageException {
    // [START enable_requester_pays]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of the existing bucket to enable requester-paying for, e.g. "my-bucket"
    // String bucketName = "my-bucket"
    BucketInfo bucketInfo = BucketInfo.newBuilder(bucketName)
        .setRequesterPays(true)
        .build();

    // Update the bucket, throws StorageException on failure
    Bucket bucket = storage.update(bucketInfo);

    System.out.println("Requester pay status for " + bucketName +": " + bucket.requesterPays());
    // [END enable_requester_pays]
    return bucket;
  }

  /**
   * Example of disabling Requester pays on a bucket.
   */
  public Bucket disableRequesterPays(String bucketName) {
    // [START disable_requester_pays]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of the bucket to disable requester-paying for, e.g. "my-bucket"
    // String bucketName = "my-bucket"
    BucketInfo bucketInfo = BucketInfo.newBuilder(bucketName)
        .setRequesterPays(false)
        .build();

    // Update the bucket, throws StorageException on failure
    Bucket bucket = storage.update(bucketInfo);

    System.out.println("Requester pays status for " + bucketName +": " + bucket.requesterPays());
    // [END disable_requester_pays]
    return bucket;
  }

  /**
   * Example of retrieving Requester pays status on a bucket.
   */
  public Bucket getRequesterPaysStatus(String bucketName) throws StorageException {
    // [START get_requester_pays_status]
    // Instantiate a Google Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name of the bucket to retrieve requester-pays status, eg. "my-bucket"
    // String bucketName = "my-bucket"
    // Retrieve the bucket, throws StorageException on failure
    Bucket bucket = storage.get(bucketName,
        Storage.BucketGetOption.fields(BucketField.BILLING));

    System.out.println("Requester pays status : " + bucket.requesterPays());
    // [END get_requester_pays_status]
    return bucket;
  }

  /**
   * Example of downloading a file using Requester pay.
   */
  public void downloadFileUsingRequesterPays(String projectId, String bucketName,
      String srcFilename, Path destFilePath) throws IOException {
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
}
