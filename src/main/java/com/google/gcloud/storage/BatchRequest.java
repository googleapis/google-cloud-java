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

import com.google.common.collect.ImmutableMap;
import com.google.gcloud.storage.StorageService.BlobSourceOption;
import com.google.gcloud.storage.StorageService.BlobTargetOption;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Google storage batch request.
 */
public class BatchRequest implements Serializable {

  private static final long serialVersionUID = -1527992265939800345L;

  private final Map<Blob, BlobSourceOption[]> toDelete;
  private final Map<Blob, BlobTargetOption[]> toUpdate;
  private final Map<Blob, BlobSourceOption[]> toGet;

  public static class Builder {

    private Map<Blob, BlobSourceOption[]> toDelete = new LinkedHashMap<>();
    private Map<Blob, BlobTargetOption[]> toUpdate = new LinkedHashMap<>();
    private Map<Blob, BlobSourceOption[]> toGet = new LinkedHashMap<>();

    private Builder() {}

    /**
     * Delete the given blob.
     */
    public void delete(Blob blob, BlobSourceOption... options) {
      toDelete.put(blob, options);
    }

    /**
     * Update the given blob.
     */
    public void update(Blob blob, BlobTargetOption... options) {
      toUpdate.put(blob, options);
    }

    /**
     * Retrieve metadata for the given blob.
     */
    public void get(Blob blob, BlobSourceOption... options) {
      toGet.put(blob, options);
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

  Map<Blob, BlobSourceOption[]> toDelete() {
    return toDelete;
  }

  Map<Blob, BlobTargetOption[]> toUpdate() {
    return toUpdate;
  }

  Map<Blob, BlobSourceOption[]> toGet() {
    return toGet;
  }

  public static Builder builder() {
    return new Builder();
  }
}
