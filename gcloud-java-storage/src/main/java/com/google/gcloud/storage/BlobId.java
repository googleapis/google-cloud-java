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

import com.google.api.services.storage.model.StorageObject;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Google Storage object identifier.
 */
public final class BlobId implements Serializable {

  private static final long serialVersionUID = -6156002883225601925L;
  private final String bucket;
  private final String name;

  private BlobId(String bucket, String name) {
    this.bucket = bucket;
    this.name = name;
  }

  public String bucket() {
    return bucket;
  }

  public String name() {
    return name;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("bucket", bucket())
        .add("name", name())
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucket, name);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof BlobId && Objects.equals(bucket, ((BlobId) obj).bucket)
        && Objects.equals(name, ((BlobId) obj).name);
  }

  StorageObject toPb() {
    StorageObject storageObject = new StorageObject();
    storageObject.setBucket(bucket);
    storageObject.setName(name);
    return storageObject;
  }

  public static BlobId of(String bucket, String name) {
    return new BlobId(checkNotNull(bucket), checkNotNull(name));
  }

  static BlobId fromPb(StorageObject storageObject) {
    return BlobId.of(storageObject.getBucket(), storageObject.getName());
  }
}
