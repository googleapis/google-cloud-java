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

import com.google.cloud.AuthCredentials;
import com.google.cloud.BatchResult;
import com.google.cloud.Page;
import com.google.cloud.ReadChannel;
import com.google.cloud.ServiceAccountSigner;
import com.google.cloud.WriteChannel;
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
import com.google.cloud.storage.Storage.BucketGetOption;
import com.google.cloud.storage.Storage.BucketListOption;
import com.google.cloud.storage.Storage.BucketSourceOption;
import com.google.cloud.storage.Storage.ComposeRequest;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.cloud.storage.Storage.SignUrlOption;
import com.google.cloud.storage.StorageBatch;
import com.google.cloud.storage.StorageBatchResult;
import com.google.cloud.storage.StorageException;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
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
  // [SNIPPET TARGET create(BucketInfo, BucketTargetOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  public Bucket createBucket(String bucketName) {
    // [SNIPPET START]
    Bucket bucket = storage.create(BucketInfo.of(bucketName));
    // [SNIPPET END]
    return bucket;
  }

  /**
   * Example of creating a blob with no content.
   */
  // [SNIPPET TARGET create(BlobInfo, BlobTargetOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  public Blob createBlob(String bucketName, String blobName) {
    // [SNIPPET START]
    BlobId blobId = BlobId.of(bucketName, blobName);
    BlobInfo blobInfo = BlobInfo.builder(blobId).contentType("text/plain").build();
    Blob blob = storage.create(blobInfo);
    // [SNIPPET END]
    return blob;
  }

  /**
   * Example of creating a blob from a byte array.
   */
  // [SNIPPET TARGET create(BlobInfo, byte[], BlobTargetOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  public Blob createBlobFromByteArray(String bucketName, String blobName) {
    // [SNIPPET START]
    BlobId blobId = BlobId.of(bucketName, blobName);
    BlobInfo blobInfo = BlobInfo.builder(blobId).contentType("text/plain").build();
    Blob blob = storage.create(blobInfo, "Hello, World!".getBytes(UTF_8));
    // [SNIPPET END]
    return blob;
  }

  /**
   * Example of creating a blob from an input stream.
   */
  // [SNIPPET TARGET create(BlobInfo, InputStream, BlobWriteOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  public Blob createBlobFromInputStream(String bucketName, String blobName) {
    // [SNIPPET START]
    InputStream content = new ByteArrayInputStream("Hello, World!".getBytes(UTF_8));
    BlobId blobId = BlobId.of(bucketName, blobName);
    BlobInfo blobInfo = BlobInfo.builder(blobId).contentType("text/plain").build();
    Blob blob = storage.create(blobInfo, content);
    // [SNIPPET END]
    return blob;
  }

  /**
   * Example of getting information on a bucket, only if its metageneration matches a value,
   * otherwise a {@link StorageException} is thrown.
   */
  // [SNIPPET TARGET get(String, BucketGetOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE 42]
  public Bucket getBucketWithMetageneration(String bucketName, long bucketMetageneration) {
    // [SNIPPET START]
    Bucket bucket = storage.get(bucketName,
        BucketGetOption.metagenerationMatch(bucketMetageneration));
    // [SNIPPET END]
    return bucket;
  }

  /**
   * Example of getting information on a blob, only if its metageneration matches a value, otherwise
   * a {@link StorageException} is thrown.
   */
  // [SNIPPET TARGET get(String, String, BlobGetOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  // [SNIPPET VARIABLE 42]
  public Blob getBlobFromStringsWithMetageneration(String bucketName, String blobName,
      long blobMetageneration) {
    // [SNIPPET START]
    Blob blob = storage.get(bucketName, blobName,
        BlobGetOption.metagenerationMatch(blobMetageneration));
    // [SNIPPET END]
    return blob;
  }

  /**
   * Example of getting information on a blob.
   */
  // [SNIPPET TARGET get(BlobId)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  public Blob getBlobFromId(String bucketName, String blobName) {
    // [SNIPPET START]
    BlobId blobId = BlobId.of(bucketName, blobName);
    Blob blob = storage.get(blobId);
    // [SNIPPET END]
    return blob;
  }

  /**
   * Example of getting information on a blob, only if its metageneration matches a value, otherwise
   * a {@link StorageException} is thrown.
   */
  // [SNIPPET TARGET get(BlobId, BlobGetOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  // [SNIPPET VARIABLE 42]
  public Blob getBlobFromIdWithMetageneration(String bucketName, String blobName,
      long blobMetageneration) {
    // [SNIPPET START]
    BlobId blobId = BlobId.of(bucketName, blobName);
    Blob blob = storage.get(blobId, BlobGetOption.metagenerationMatch(blobMetageneration));
    // [SNIPPET END]
    return blob;
  }

  /**
   * Example of listing buckets, specifying the page size and a name prefix.
   */
  // [SNIPPET TARGET list(BucketListOption...)]
  // [SNIPPET VARIABLE "bucket_"]
  public Iterator<Bucket> listBucketsWithSizeAndPrefix(String prefix) {
    // [SNIPPET START]
    Page<Bucket> buckets = storage.list(BucketListOption.pageSize(100),
        BucketListOption.prefix(prefix));
    Iterator<Bucket> bucketIterator = buckets.iterateAll();
    while (bucketIterator.hasNext()) {
      Bucket bucket = bucketIterator.next();
      // do something with the bucket
    }
    // [SNIPPET END]
    return bucketIterator;
  }

  /**
   * Example of listing buckets, specifying the page size and a name prefix.
   */
  // [SNIPPET TARGET list(String, BlobListOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_directory"]
  public Iterator<Blob> listBlobsWithDirectoryAndPrefix(String bucketName, String directory) {
    // [SNIPPET START]
    Page<Blob> blobs = storage.list(bucketName, BlobListOption.currentDirectory(),
        BlobListOption.prefix(directory));
    Iterator<Blob> blobIterator = blobs.iterateAll();
    while (blobIterator.hasNext()) {
      Blob blob = blobIterator.next();
      // do something with the blob
    }
    // [SNIPPET END]
    return blobIterator;
  }

  /**
   * Example of updating bucket information.
   */
  // [SNIPPET TARGET update(BucketInfo, BucketTargetOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  public Bucket updateBucket(String bucketName) {
    // [SNIPPET START]
    BucketInfo bucketInfo = BucketInfo.builder(bucketName).versioningEnabled(true).build();
    Bucket bucket = storage.update(bucketInfo);
    // [SNIPPET END]
    return bucket;
  }

  /**
   * Example of replacing blob's metadata.
   */
  // [SNIPPET TARGET update(BlobInfo)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  public Blob updateBlob(String bucketName, String blobName) {
    // [SNIPPET START]
    Map<String, String> newMetadata = new HashMap<>();
    newMetadata.put("key", "value");
    storage.update(BlobInfo.builder(bucketName, blobName).metadata(null).build());
    Blob blob = storage.update(BlobInfo.builder(bucketName, blobName)
        .metadata(newMetadata)
        .build());
    // [SNIPPET END]
    return blob;
  }

  /**
   * Example of udating a blob, only if the blob's metageneration matches a value, otherwise a
   * {@link StorageException} is thrown.
   */
  // [SNIPPET TARGET update(BlobInfo, BlobTargetOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  public Blob updateBlobWithMetageneration(String bucketName, String blobName) {
    // [SNIPPET START]
    Blob blob = storage.get(bucketName, blobName);
    BlobInfo updatedInfo = blob.toBuilder().contentType("text/plain").build();
    storage.update(updatedInfo, BlobTargetOption.metagenerationMatch());
    // [SNIPPET END]
    return blob;
  }

  /**
   * Example of deleting a bucket, only if its metageneration matches a value, otherwise a
   * {@link StorageException} is thrown.
   */
  // [SNIPPET TARGET delete(String, BucketSourceOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE 42]
  public boolean deleteBucketWithMetageneration(String bucketName, long bucketMetageneration) {
    // [SNIPPET START]
    boolean deleted = storage.delete(bucketName,
        BucketSourceOption.metagenerationMatch(bucketMetageneration));
    if (deleted) {
      // the bucket was deleted
    } else {
      // the bucket was not found
    }
    // [SNIPPET END]
    return deleted;
  }

  /**
   * Example of deleting a blob, only if its generation matches a value, otherwise a
   * {@link StorageException} is thrown.
   */
  // [SNIPPET TARGET delete(String, String, BlobSourceOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  // [SNIPPET VARIABLE 42]
  public boolean deleteBlobFromStringsWithGeneration(String bucketName, String blobName,
      long blobGeneration) {
    // [SNIPPET START]
    boolean deleted = storage.delete(bucketName, blobName,
        BlobSourceOption.generationMatch(blobGeneration));
    if (deleted) {
      // the blob was deleted
    } else {
      // the blob was not found
    }
    // [SNIPPET END]
    return deleted;
  }

  /**
   * Example of deleting a blob, only if its generation matches a value, otherwise a
   * {@link StorageException} is thrown.
   */
  // [SNIPPET TARGET delete(BlobId, BlobSourceOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  // [SNIPPET VARIABLE 42]
  public boolean deleteBlobFromIdWithGeneration(String bucketName, String blobName,
      long blobGeneration) {
    // [SNIPPET START]
    BlobId blobId = BlobId.of(bucketName, blobName);
    boolean deleted = storage.delete(blobId, BlobSourceOption.generationMatch(blobGeneration));
    if (deleted) {
      // the blob was deleted
    } else {
      // the blob was not found
    }
    // [SNIPPET END]
    return deleted;
  }

  /**
   * Example of deleting a blob.
   */
  // [SNIPPET TARGET delete(BlobId)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  public boolean deleteBlob(String bucketName, String blobName) {
    // [SNIPPET START]
    BlobId blobId = BlobId.of(bucketName, blobName);
    boolean deleted = storage.delete(blobId);
    if (deleted) {
      // the blob was deleted
    } else {
      // the blob was not found
    }
    // [SNIPPET END]
    return deleted;
  }

  /**
   * Example of composing two blobs.
   */
  // [SNIPPET TARGET compose(ComposeRequest)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  // [SNIPPET VARIABLE "source_blob_1"]
  // [SNIPPET VARIABLE "source_blob_2"]
  public Blob composeBlobs(String bucketName, String blobName, String sourceBlob1,
      String sourceBlob2) {
    // [SNIPPET START]
    BlobId blobId = BlobId.of(bucketName, blobName);
    BlobInfo blobInfo = BlobInfo.builder(blobId).contentType("text/plain").build();
    ComposeRequest request = ComposeRequest.builder()
        .target(blobInfo)
        .addSource(sourceBlob1)
        .addSource(sourceBlob2)
        .build();
    Blob blob = storage.compose(request);
    // [SNIPPET END]
    return blob;
  }

  /**
   * Example of copying a blob.
   */
  // [SNIPPET TARGET copy(CopyRequest)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  // [SNIPPET VARIABLE "copy_blob_name"]
  public Blob copyBlob(String bucketName, String blobName, String copyBlobName) {
    // [SNIPPET START]
    CopyRequest request = CopyRequest.builder()
        .source(BlobId.of(bucketName, blobName))
        .target(BlobId.of(bucketName, copyBlobName))
        .build();
    Blob blob = storage.copy(request).result();
    // [SNIPPET END]
    return blob;
  }

  /**
   * Example of copying a blob in chunks.
   */
  // [SNIPPET TARGET copy(CopyRequest)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  // [SNIPPET VARIABLE "copy_blob_name"]
  public Blob copyBlobInChunks(String bucketName, String blobName, String copyBlobName) {
    // [SNIPPET START]
    CopyRequest request = CopyRequest.builder()
        .source(BlobId.of(bucketName, blobName))
        .target(BlobId.of(bucketName, copyBlobName))
        .build();
    CopyWriter copyWriter = storage.copy(request);
    while (!copyWriter.isDone()) {
      copyWriter.copyChunk();
    }
    Blob blob = copyWriter.result();
    // [SNIPPET END]
    return blob;
  }

  /**
   * Example of reading all bytes of a blob, if generation matches a value, otherwise a
   * {@link StorageException} is thrown.
   */
  // [SNIPPET TARGET readAllBytes(String, String, BlobSourceOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  // [SNIPPET VARIABLE 42"]
  public byte[] readBlobFromStringsWithGeneration(String bucketName, String blobName,
      long blobGeneration) {
    // [SNIPPET START]
    byte[] content = storage.readAllBytes(bucketName, blobName,
        BlobSourceOption.generationMatch(blobGeneration));
    // [SNIPPET END]
    return content;
  }

  /**
   * Example of reading all bytes of a blob's specific generation, otherwise a
   * {@link StorageException} is thrown.
   */
  // [SNIPPET TARGET readAllBytes(BlobId, BlobSourceOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  // [SNIPPET VARIABLE 42"]
  public byte[] readBlobFromId(String bucketName, String blobName, long blobGeneration) {
    // [SNIPPET START]
    BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
    byte[] content = storage.readAllBytes(blobId);
    // [SNIPPET END]
    return content;
  }

  /**
   * Example of using a batch request to delete, update and get a blob.
   */
  // [SNIPPET TARGET batch()]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name1"]
  // [SNIPPET VARIABLE "my_blob_name2"]
  public Blob batch(String bucketName, String blobName1, String blobName2) {
    // [SNIPPET START]
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
    batch.update(BlobInfo.builder(secondBlob).contentType("text/plain").build());
    StorageBatchResult<Blob> result = batch.get(secondBlob);
    batch.submit();
    Blob blob = result.get(); // returns get result or throws StorageException
    // [SNIPPET END]
    return blob;
  }

  /**
   * Example of reading a blob's content through a reader.
   */
  // [SNIPPET TARGET reader(String, String, BlobSourceOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  public void readerFromStrings(String bucketName, String blobName) throws IOException {
    // [SNIPPET START]
    try (ReadChannel reader = storage.reader(bucketName, blobName)) {
      ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
      while (reader.read(bytes) > 0) {
        bytes.flip();
        // do something with bytes
        bytes.clear();
      }
    }
    // [SNIPPET END]
  }

  /**
   * Example of reading a blob's content through a reader.
   */
  // [SNIPPET TARGET reader(BlobId, BlobSourceOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  public void readerFromId(String bucketName, String blobName) throws IOException {
    // [SNIPPET START]
    BlobId blobId = BlobId.of(bucketName, blobName);
    try (ReadChannel reader = storage.reader(blobId)) {
      ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
      while (reader.read(bytes) > 0) {
        bytes.flip();
        // do something with bytes
        bytes.clear();
      }
    }
    // [SNIPPET END]
  }

  /**
   * Example of writing a blob's content through a writer.
   */
  // [SNIPPET TARGET writer(BlobInfo, BlobWriteOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  public void writer(String bucketName, String blobName) throws IOException {
    // [SNIPPET START]
    BlobId blobId = BlobId.of(bucketName, blobName);
    byte[] content = "Hello, World!".getBytes(UTF_8);
    BlobInfo blobInfo = BlobInfo.builder(blobId).contentType("text/plain").build();
    try (WriteChannel writer = storage.writer(blobInfo)) {
      try {
        writer.write(ByteBuffer.wrap(content, 0, content.length));
      } catch (Exception ex) {
        // handle exception
      }
    }
    // [SNIPPET END]
  }

  /**
   * Example of creating a signed URL that is valid for 2 weeks, using the default credentials for
   * signing the URL.
   */
  // [SNIPPET TARGET signUrl(BlobInfo, long, TimeUnit, SignUrlOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  public URL signUrl(String bucketName, String blobName) {
    // [SNIPPET START]
    URL signedUrl = storage.signUrl(BlobInfo.builder(bucketName, blobName).build(), 14,
        TimeUnit.DAYS);
    // [SNIPPET END]
    return signedUrl;
  }

  /**
   * Example of creating a signed URL passing the
   * {@link SignUrlOption#signWith(ServiceAccountSigner)} option, that will be used for signing the
   * URL.
   */
  // [SNIPPET TARGET signUrl(BlobInfo, long, TimeUnit, SignUrlOption...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name"]
  // [SNIPPET VARIABLE "/path/to/key.json"]
  public URL signUrlWithSigner(String bucketName, String blobName, String keyPath)
      throws IOException {
    // [SNIPPET START]
    URL signedUrl = storage.signUrl(BlobInfo.builder(bucketName, blobName).build(),
        14, TimeUnit.DAYS, SignUrlOption.signWith(
            AuthCredentials.createForJson(new FileInputStream(keyPath))));
    // [SNIPPET END]
    return signedUrl;
  }

  /**
   * Example of getting information on several blobs using a single batch request.
   */
  // [SNIPPET TARGET get(BlobId...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name1"]
  // [SNIPPET VARIABLE "my_blob_name2"]
  public List<Blob> batchGet(String bucketName, String blobName1, String blobName2) {
    // [SNIPPET START]
    BlobId firstBlob = BlobId.of(bucketName, blobName1);
    BlobId secondBlob = BlobId.of(bucketName, blobName2);
    List<Blob> blobs = storage.get(firstBlob, secondBlob);
    // [SNIPPET END]
    return blobs;
  }

  /**
   * Example of getting information on several blobs using a single batch request.
   */
  // [SNIPPET TARGET get(Iterable)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name1"]
  // [SNIPPET VARIABLE "my_blob_name2"]
  public List<Blob> batchGetIterable(String bucketName, String blobName1, String blobName2) {
    // [SNIPPET START]
    List<BlobId> blobIds = new LinkedList<>();
    blobIds.add(BlobId.of(bucketName, blobName1));
    blobIds.add(BlobId.of(bucketName, blobName2));
    List<Blob> blobs = storage.get(blobIds);
    // [SNIPPET END]
    return blobs;
  }

  /**
   * Example of updating information on several blobs using a single batch request.
   */
  // [SNIPPET TARGET update(BlobInfo...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name1"]
  // [SNIPPET VARIABLE "my_blob_name2"]
  public List<Blob> batchUpdate(String bucketName, String blobName1, String blobName2) {
    // [SNIPPET START]
    Blob firstBlob = storage.get(bucketName, blobName1);
    Blob secondBlob = storage.get(bucketName, blobName2);
    List<Blob> updatedBlobs = storage.update(
        firstBlob.toBuilder().contentType("text/plain").build(),
        secondBlob.toBuilder().contentType("text/plain").build());
    // [SNIPPET END]
    return updatedBlobs;
  }

  /**
   * Example of updating information on several blobs using a single batch request.
   */
  // [SNIPPET TARGET update(Iterable)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name1"]
  // [SNIPPET VARIABLE "my_blob_name2"]
  public List<Blob> batchUpdateIterable(String bucketName, String blobName1, String blobName2) {
    // [SNIPPET START]
    Blob firstBlob = storage.get(bucketName, blobName1);
    Blob secondBlob = storage.get(bucketName, blobName2);
    List<BlobInfo> blobs = new LinkedList<>();
    blobs.add(firstBlob.toBuilder().contentType("text/plain").build());
    blobs.add(secondBlob.toBuilder().contentType("text/plain").build());
    List<Blob> updatedBlobs = storage.update(blobs);
    // [SNIPPET END]
    return updatedBlobs;
  }

  /**
   * Example of deleting several blobs using a single batch request.
   */
  // [SNIPPET TARGET delete(BlobId...)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name1"]
  // [SNIPPET VARIABLE "my_blob_name2"]
  public List<Boolean> batchDelete(String bucketName, String blobName1, String blobName2) {
    // [SNIPPET START]
    BlobId firstBlob = BlobId.of(bucketName, blobName1);
    BlobId secondBlob = BlobId.of(bucketName, blobName2);
    List<Boolean> deleted = storage.delete(firstBlob, secondBlob);
    // [SNIPPET END]
    return deleted;
  }

  /**
   * Example of deleting several blobs using a single batch request.
   */
  // [SNIPPET TARGET delete(Iterable)]
  // [SNIPPET VARIABLE "my_unique_bucket"]
  // [SNIPPET VARIABLE "my_blob_name1"]
  // [SNIPPET VARIABLE "my_blob_name2"]
  public List<Boolean> batchDeleteIterable(String bucketName, String blobName1, String blobName2) {
    // [SNIPPET START]
    List<BlobId> blobIds = new LinkedList<>();
    blobIds.add(BlobId.of(bucketName, blobName1));
    blobIds.add(BlobId.of(bucketName, blobName2));
    List<Boolean> deleted = storage.delete(blobIds);
    // [SNIPPET END]
    return deleted;
  }
}
