/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.gcloud.storage.Storage.BlobSourceOption;
import com.google.gcloud.storage.Storage.BlobTargetOption;
import com.google.gcloud.storage.Storage.BucketSourceOption;
import com.google.gcloud.storage.Storage.BucketTargetOption;
import java.util.LinkedList;

import java.util.List;
import java.util.Objects;

/**
 * A Google cloud storage bucket.
 */
public final class Bucket {

  private final Storage storage;
  private BucketInfo info;

  /**
   * Construct a {@code Bucket} object for the provided {@code BucketInfo}. The storage service is
   * used to issue requests.
   * 
   * @param storage the storage service used for issuing requests
   * @param info bucket's info
   */
  public Bucket(Storage storage, BucketInfo info) {
    this.storage = checkNotNull(storage);
    this.info = checkNotNull(info);
  }

  /**
   * Construct a {@code Bucket} object for the provided name. The storage service is used to issue
   * requests.
   * 
   * @param storage the storage service used for issuing requests
   * @param bucket bucket's name
   */
  public Bucket(Storage storage, String bucket) {
    this.storage = checkNotNull(storage);
    this.info = BucketInfo.of(checkNotNull(bucket));
  }

  /**
   * Return the bucket's information.
   */
  public BucketInfo info() {
    return info;
  }

  /**
   * Check if this bucket exists.
   *
   * @return true if this bucket exists, false otherwise
   * @throws StorageException upon failure
   */
  public boolean exists() {
    return storage.get(info.name()) != null;
  }

  /**
   * Update the bucket's information. Bucket's name cannot be changed.
   *
   * @param bucketInfo new bucket's information. Name must match the one of the current bucket
   * @param options update options
   * @throws StorageException upon failure
   */
  public void update(BucketInfo bucketInfo, BucketTargetOption... options) {
    checkArgument(Objects.equals(bucketInfo.name(), info.name()), "Bucket name must match");
    info = storage.update(bucketInfo, options);
  }

  /**
   * Delete this bucket.
   *
   * @param options bucket delete options
   * @return true if bucket was deleted
   * @throws StorageException upon failure
   */
  public boolean delete(BucketSourceOption... options) {
    return storage.delete(info.name(), options);
  }

  /**
   * Return the paginated list of {@code Blob} in this bucket.
   * 
   * @param options options for listing blobs
   * @throws StorageException upon failure
   */
  public ListResult<Blob> list(Storage.BlobListOption... options) {
    return new BlobListResult(storage, storage.list(info.name(), options));
  }

  /**
   * Return the requested blob in this bucket or {@code null} if not found.
   * 
   * @param blob name of the requested blob
   * @param options blob search options
   * @throws StorageException upon failure
   */
  public Blob get(String blob, BlobSourceOption... options) {
    return new Blob(storage, storage.get(info.name(), blob, options));
  }

  /**
   * Return a list of requested blobs in this bucket. Blobs that do not exist are null.
   * 
   * @param blobNames names of the requested blobs
   * @throws StorageException upon failure
   */
  public List<Blob> getAll(String... blobNames) {
    BatchRequest.Builder batch = BatchRequest.builder();
    for (String blobName : blobNames) {
      batch.get(info.name(), blobName);
    }
    List<Blob> blobs = new LinkedList<>();
    BatchResponse response = storage.apply(batch.build());
    for (BatchResponse.Result<BlobInfo> result : response.gets()) {
      BlobInfo blobInfo = result.get();
      blobs.add(blobInfo != null ? new Blob(storage, blobInfo) : null);
    }
    return blobs;
  }

  /**
   * Create a new blob in this bucket.
   * 
   * @param blob a blob name
   * @param content the blob content
   * @param options options for blob creation
   * @return a complete blob information.
   * @throws StorageException upon failure
   */
  Blob create(String blob, byte[] content, BlobTargetOption... options) {
    BlobInfo blobInfo = BlobInfo.of(info.name(), blob);
    return new Blob(storage, storage.create(blobInfo, content, options));
  }

  /**
   * Return the bucket's {@code Storage} object used to issue requests.
   */
  public Storage storage() {
    return storage;
  }
}
