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

package com.google.cloud.storage;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.cloud.storage.Storage.BlobGetOption;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobTargetOption;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Google storage batch request.
 */
public final class BatchRequest implements Serializable {

  private static final long serialVersionUID = -1527992265939800345L;

  private final Map<BlobId, Iterable<BlobSourceOption>> toDelete;
  private final Map<BlobInfo, Iterable<BlobTargetOption>> toUpdate;
  private final Map<BlobId, Iterable<BlobGetOption>> toGet;

  public static class Builder {

    private Map<BlobId, Iterable<BlobSourceOption>> toDelete = new LinkedHashMap<>();
    private Map<BlobInfo, Iterable<BlobTargetOption>> toUpdate = new LinkedHashMap<>();
    private Map<BlobId, Iterable<BlobGetOption>> toGet = new LinkedHashMap<>();

    private Builder() {}

    /**
     * Delete the given blob.
     */
    public Builder delete(String bucket, String blob, BlobSourceOption... options) {
      toDelete.put(BlobId.of(bucket, blob), Lists.newArrayList(options));
      return this;
    }

    /**
     * Delete the given blob.
     */
    public Builder delete(BlobId blob, BlobSourceOption... options) {
      toDelete.put(blob, Lists.newArrayList(options));
      return this;
    }

    /**
     * Update the given blob.
     */
    public Builder update(BlobInfo blobInfo, BlobTargetOption... options) {
      toUpdate.put(blobInfo, Lists.newArrayList(options));
      return this;
    }

    /**
     * Retrieve metadata for the given blob.
     */
    public Builder get(String bucket, String blob, BlobGetOption... options) {
      toGet.put(BlobId.of(bucket, blob), Lists.newArrayList(options));
      return this;
    }

    /**
     * Retrieve metadata for the given blob.
     */
    public Builder get(BlobId blob, BlobGetOption... options) {
      toGet.put(blob, Lists.newArrayList(options));
      return this;
    }

    public BatchRequest build() {
      return new BatchRequest(this);
    }
  }

  private BatchRequest(Builder builder) {
    toDelete = ImmutableMap.copyOf(builder.toDelete);
    toUpdate = ImmutableMap.copyOf(builder.toUpdate);
    toGet = ImmutableMap.copyOf(builder.toGet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(toDelete, toUpdate, toGet);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof BatchRequest)) {
      return false;
    }
    BatchRequest other = (BatchRequest) obj;
    return Objects.equals(toDelete, other.toDelete)
        && Objects.equals(toUpdate, other.toUpdate)
        && Objects.equals(toGet, other.toGet);
  }

  public Map<BlobId, Iterable<BlobSourceOption>> toDelete() {
    return toDelete;
  }

  public Map<BlobInfo, Iterable<BlobTargetOption>> toUpdate() {
    return toUpdate;
  }

  public Map<BlobId, Iterable<BlobGetOption>> toGet() {
    return toGet;
  }

  public static Builder builder() {
    return new Builder();
  }
}
