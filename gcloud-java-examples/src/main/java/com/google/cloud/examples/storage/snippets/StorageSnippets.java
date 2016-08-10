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
  public void createBucket() {
    String bucketName = "my_unique_bucket";
    Bucket bucket = storage.create(BucketInfo.of(bucketName));
  }

  /**
   * Example of creating a blob with no content.
   */
  public void createBlob() {
    BlobId blobId = BlobId.of("my_unique_bucket", "my_blob_name");
    BlobInfo blobInfo = BlobInfo.builder(blobId).contentType("text/plain").build();
    Blob blob = storage.create(blobInfo);
  }

  /**
   * Example of creating a blob from a byte array.
   */
  public void createBlobFromByteArray() {
    BlobId blobId = BlobId.of("my_unique_bucket", "my_blob_name");
    BlobInfo blobInfo = BlobInfo.builder(blobId).contentType("text/plain").build();
    Blob blob = storage.create(blobInfo, "Hello, World!".getBytes(UTF_8));
  }

  /**
   * Example of creating a blob from an input stream.
   */
  public void createBlobFromInputStream() {
    InputStream content = new ByteArrayInputStream("Hello, World!".getBytes(UTF_8));
    BlobId blobId = BlobId.of("my_unique_bucket", "my_blob_name");
    BlobInfo blobInfo = BlobInfo.builder(blobId).contentType("text/plain").build();
    Blob blob = storage.create(blobInfo, content);
  }

  /**
   * Example of getting information on a bucket, only if its metageneration matches a value,
   * otherwise a {@link StorageException} is thrown.
   */
  public void getBucketWithMetageneration() {
    Bucket bucket = storage.get("my_unique_bucket", BucketGetOption.metagenerationMatch(42));
    System.out.println(bucket);
  }

  /**
   * Example of getting information on a blob, only if its metageneration matches a value, otherwise
   * a {@link StorageException} is thrown.
   */
  public void getBlobFromStringsWithMetageneration() {
    Blob blob = storage.get("my_unique_bucket", "my_blob_name",
        BlobGetOption.metagenerationMatch(42));
  }

  /**
   * Example of getting information on a blob.
   */
  public void getBlobFromId() {
    BlobId blobId = BlobId.of("my_unique_bucket", "my_blob_name");
    Blob blob = storage.get(blobId);
  }

  /**
   * Example of getting information on a blob, only if its metageneration matches a value, otherwise
   * a {@link StorageException} is thrown.
   */
  public void getBlobFromIdWithMetageneration() {
    BlobId blobId = BlobId.of("my_unique_bucket", "my_blob_name");
    Blob blob = storage.get(blobId, BlobGetOption.metagenerationMatch(42));
  }

  /**
   * Example of listing buckets, specifying the page size and a name prefix.
   */
  public void listBucketsWithSizeAndPrefix() {
    Page<Bucket> buckets = storage.list(BucketListOption.pageSize(100),
        BucketListOption.prefix("bucket_"));
    Iterator<Bucket> bucketIterator = buckets.iterateAll();
    while (bucketIterator.hasNext()) {
      Bucket bucket = bucketIterator.next();
      // do something with the bucket
    }
  }

  /**
   * Example of listing buckets, specifying the page size and a name prefix.
   */
  public void listBlobsWithDirectoryAndPrefix() {
    Page<Blob> blobs = storage.list("my_unique_bucket", BlobListOption.currentDirectory(),
        BlobListOption.prefix("my_directory"));
    Iterator<Blob> blobIterator = blobs.iterateAll();
    while (blobIterator.hasNext()) {
      Blob blob = blobIterator.next();
      // do something with the blob
    }
  }

  /**
   * Example of updating bucket information.
   */
  public void updateBucket() {
    BucketInfo bucketInfo = BucketInfo.builder("my_unique_bucket").versioningEnabled(true).build();
    Bucket bucket = storage.update(bucketInfo);
  }

  /**
   * Example of replacing blob's metadata.
   */
  public void updateBlob() {
    Map<String, String> newMetadata = new HashMap<>();
    newMetadata.put("key", "value");
    storage.update(BlobInfo.builder("bucket", "name").metadata(null).build());
    storage.update(BlobInfo.builder("bucket", "name").metadata(newMetadata).build());
  }

  /**
   * Example of deleting a bucket, only if its metageneration matches a value, otherwise a
   * {@link StorageException} is thrown.
   */
  public void deleteBucketWithMetageneration() {
    boolean deleted = storage.delete("my_unique_bucket",
        BucketSourceOption.metagenerationMatch(42));
    if (deleted) {
      // the bucket was deleted
    } else {
      // the bucket was not found
    }
  }

  /**
   * Example of deleting a blob, only if its generation matches a value, otherwise a
   * {@link StorageException} is thrown.
   */
  public void deleteBlobFromStringsWithGeneration() {
    boolean deleted = storage.delete("my_unique_bucket", "my_blob_name",
        BlobSourceOption.generationMatch(42));
    if (deleted) {
      // the blob was deleted
    } else {
      // the blob was not found
    }
  }

  /**
   * Example of deleting a blob, only if its generation matches a value, otherwise a
   * {@link StorageException} is thrown.
   */
  public void deleteBlobFromIdWithGeneration() {
    BlobId blobId = BlobId.of("my_unique_bucket", "my_blob_name");
    boolean deleted = storage.delete(blobId, BlobSourceOption.generationMatch(42));
    if (deleted) {
      // the blob was deleted
    } else {
      // the blob was not found
    }
  }

  /**
   * Example of deleting a blob.
   */
  public void deleteBlob() {
    BlobId blobId = BlobId.of("my_unique_bucket", "my_blob_name");
    boolean deleted = storage.delete(blobId);
    if (deleted) {
      // the blob was deleted
    } else {
      // the blob was not found
    }
  }

  /**
   * Example of composing two blobs.
   */
  public void composeBlobs() {
    BlobId blobId = BlobId.of("my_unique_bucket", "my_blob_name");
    BlobInfo blobInfo = BlobInfo.builder(blobId).contentType("text/plain").build();
    ComposeRequest request = ComposeRequest.builder()
        .target(blobInfo)
        .addSource("source_blob_1")
        .addSource("source_blob_2")
        .build();
    Blob blob = storage.compose(request);
  }

  /**
   * Example of copying a blob.
   */
  public void copyBlob() {
    CopyRequest request = CopyRequest.builder()
        .source(BlobId.of("my_unique_bucket", "my_blob_name"))
        .target(BlobId.of("my_unique_bucket", "copy_blob_name"))
        .build();
    BlobInfo blob = storage.copy(request).result();
  }

  /**
   * Example of copying a blob in chunks.
   */
  public void copyBlobInChunks() {
    CopyRequest request = CopyRequest.builder()
        .source(BlobId.of("my_unique_bucket", "my_blob_name"))
        .target(BlobId.of("my_unique_bucket", "copy_blob_name"))
        .build();
    CopyWriter copyWriter = storage.copy(request);
    while (!copyWriter.isDone()) {
      copyWriter.copyChunk();
    }
    BlobInfo blob = copyWriter.result();
  }

  /**
   * Example of reading all bytes of a blob, if generation matches a value, otherwise a
   * {@link StorageException} is thrown.
   */
  public void readBlobFromStringsWithGeneration() {
    byte[] content = storage.readAllBytes("empty-test-bucket", "blob",
        BlobSourceOption.generationMatch(42));
  }

  /**
   * Example of reading all bytes of a blob's specific generation, otherwise a
   * {@link StorageException} is thrown.
   */
  public void readBlobFromId() {
    BlobId blobId = BlobId.of("my_unique_bucket", "my_blob_name", 42L);
    byte[] content = storage.readAllBytes(blobId);
  }

  /**
   * Example of using a batch request to delete, update and get a blob.
   */
  public void batch() {
    StorageBatch batch = storage.batch();
    BlobId firstBlob = BlobId.of("bucket", "blob1");
    BlobId secondBlob = BlobId.of("bucket", "blob2");
    batch.delete(firstBlob).notify(new BatchResult.Callback<Boolean, StorageException>() {
      @Override
      public void success(Boolean result) {
        // deleted successfully
      }

      @Override
      public void error(StorageException exception) {
        // delete failed
      }
    });
    batch.update(BlobInfo.builder(secondBlob).contentType("text/plain").build());
    StorageBatchResult<Blob> result = batch.get(secondBlob);
    batch.submit();
    Blob blob = result.get(); // returns get result or throws StorageException
  }

  /**
   * Example of reading a blob's content through a reader.
   */
  public void readerFromStrings() throws IOException {
    try (ReadChannel reader = storage.reader("my_unique_bucket", "my_blob_name")) {
      ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
      while (reader.read(bytes) > 0) {
        bytes.flip();
        // do something with bytes
        bytes.clear();
      }
    }
  }

  /**
   * Example of reading a blob's content through a reader.
   */
  public void readerFromId() throws IOException {
    BlobId blobId = BlobId.of("my_unique_bucket", "my_blob_name");
    try (ReadChannel reader = storage.reader(blobId)) {
      ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
      while (reader.read(bytes) > 0) {
        bytes.flip();
        // do something with bytes
        bytes.clear();
      }
    }
  }

  /**
   * Example of writing a blob's content through a writer.
   */
  public void writer() throws IOException {
    BlobId blobId = BlobId.of("my_unique_bucket", "my_blob_name");
    byte[] content = "Hello, World!".getBytes(UTF_8);
    BlobInfo blobInfo = BlobInfo.builder(blobId).contentType("text/plain").build();
    try (WriteChannel writer = storage.writer(blobInfo)) {
      try {
        writer.write(ByteBuffer.wrap(content, 0, content.length));
      } catch (Exception ex) {
        // handle exception
      }
    }
  }

  /**
   * Example usage of creating a signed URL that is valid for 2 weeks, using the default credentials
   * for signing the URL.
   */
  public void signUrl() {
    storage.signUrl(BlobInfo.builder("my_unique_bucket", "my_blob_name").build(), 14,
        TimeUnit.DAYS);
  }

  /**
   * Example usage of creating a signed URL passing the
   * {@link SignUrlOption#signWith(ServiceAccountSigner)} option, that will be used for
   * signing the URL.
   */
  public void signUrlWithSigner() throws IOException {
    storage.signUrl(BlobInfo.builder("my_unique_bucket", "my_blob_name").build(), 14,
        TimeUnit.DAYS, SignUrlOption.signWith(
            AuthCredentials.createForJson(new FileInputStream("/path/to/key.json"))));
  }

  /**
   * Example of getting information on several blobs using a single batch request.
   */
  public void batchGet() {
    BlobId firstBlob = BlobId.of("my_unique_bucket", "my_blob_name_1");
    BlobId secondBlob = BlobId.of("my_unique_bucket", "my_blob_name_2");
    List<Blob> blobs = storage.get(firstBlob, secondBlob);
  }

  /**
   * Example of getting information on several blobs using a single batch request.
   */
  public void batchGetIterable() {
    List<BlobId> blobIds = new LinkedList<>();
    blobIds.add(BlobId.of("my_unique_bucket", "my_blob_name_1"));
    blobIds.add(BlobId.of("my_unique_bucket", "my_blob_name_2"));
    List<Blob> blobs = storage.get(blobIds);
  }

  /**
   * Example of updating information on several blobs using a single batch request.
   */
  public void batchUpdate() {
    Blob firstBlob = storage.get("my_unique_bucket", "my_blob_name_1");
    Blob secondBlob = storage.get("my_unique_bucket", "my_blob_name_2");
    List<Blob> updatedBlobs = storage.update(
        firstBlob.toBuilder().contentType("text/plain").build(),
        secondBlob.toBuilder().contentType("text/plain").build());
  }

  /**
   * Example of updating information on several blobs using a single batch request.
   */
  public void batchUpdateIterable() {
    Blob firstBlob = storage.get("my_unique_bucket", "my_blob_name_1");
    Blob secondBlob = storage.get("my_unique_bucket", "my_blob_name_2");
    List<BlobInfo> blobs = new LinkedList<>();
    blobs.add(firstBlob.toBuilder().contentType("text/plain").build());
    blobs.add(secondBlob.toBuilder().contentType("text/plain").build());
    List<Blob> updatedBlobs = storage.update(blobs);
  }

  /**
   * Example of deleting several blobs using a single batch request.
   */
  public void batchDelete() {
    BlobId firstBlob = BlobId.of("my_unique_bucket", "my_blob_name_1");
    BlobId secondBlob = BlobId.of("my_unique_bucket", "my_blob_name_2");
    List<Boolean> deleted = storage.delete(firstBlob, secondBlob);
  }

  /**
   * Example of deleting several blobs using a single batch request.
   */
  public void batchDeleteIterable() {
    List<BlobId> blobIds = new LinkedList<>();
    blobIds.add(BlobId.of("my_unique_bucket", "my_blob_name_1"));
    blobIds.add(BlobId.of("my_unique_bucket", "my_blob_name_2"));
    List<Boolean> deleted = storage.delete(blobIds);
  }
}
