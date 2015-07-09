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
import com.google.gcloud.storage.Storage.BucketSourceOption;
import com.google.gcloud.storage.Storage.BucketTargetOption;

import java.util.List;
import java.util.Objects;

/**
 * A Google cloud storage bucket.
 */
public final class Bucket {

  private final Storage storage;
  private BucketInfo info;

  public Bucket(Storage storage, BucketInfo info) {
    this.storage = checkNotNull(storage);
    this.info = checkNotNull(info);
  }

  /**
   * Returns true if this bucket exists.
   *
   * @throws StorageException upon failure
   */
  public boolean exists() {
    return storage.get(info.name()) != null;
  }

  /**
   * Update the bucket's information. Bucket's name cannot be changed.
   *
   * @throws StorageException upon failure
   */
  public void update(BucketInfo bucketInfo, BucketTargetOption... options) {
    checkArgument(Objects.equals(bucketInfo.name(), info.name()), "Bucket name must match");
    info = storage.update(bucketInfo, options);
  }

  /**
   * Delete this bucket.
   *
   * @return true if bucket was deleted
   * @throws StorageException upon failure
   */
  public boolean delete(BucketSourceOption... options) {
    return storage.delete(info.name(), options);
  }

  public ListResult<BlobInfo> list(Storage.BlobListOption... options) {
    return storage.list(info.name(), options);
  }

  public BlobInfo get(String blob, BlobSourceOption... options) {
    return null;
  }

  public List<Blob> get(String... blob) {
    // todo
    return null;
  }

  /*
   * BlobInfo create(BlobInfo blobInfo, byte[] content, BlobTargetOption... options) {
   *
   * }
   */


  public Storage storage() {
    return storage;
  }
}
