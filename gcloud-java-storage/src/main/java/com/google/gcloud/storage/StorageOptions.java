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

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import com.google.gcloud.ServiceOptions;
import com.google.gcloud.spi.DefaultStorageRpc;
import com.google.gcloud.spi.StorageRpc;
import com.google.gcloud.spi.StorageRpcFactory;

import java.util.Objects;
import java.util.Set;

public class StorageOptions extends ServiceOptions<StorageRpc, StorageOptions> {

  private static final long serialVersionUID = -7804860602287801084L;
  private static final String GCS_SCOPE = "https://www.googleapis.com/auth/devstorage.full_control";
  private static final Set<String> SCOPES = ImmutableSet.of(GCS_SCOPE);
  private static final String DEFAULT_PATH_DELIMITER = "/";

  private final String pathDelimiter;
  private transient StorageRpc storageRpc;

  public static class Builder extends
      ServiceOptions.Builder<StorageRpc, StorageOptions, Builder> {

    private String pathDelimiter;

    private Builder() {}

    private Builder(StorageOptions options) {
      super(options);
    }

    public Builder pathDelimiter(String pathDelimiter) {
      this.pathDelimiter = pathDelimiter;
      return this;
    }

    @Override
    public StorageOptions build() {
      return new StorageOptions(this);
    }
  }

  private StorageOptions(Builder builder) {
    super(builder);
    pathDelimiter = MoreObjects.firstNonNull(builder.pathDelimiter, DEFAULT_PATH_DELIMITER);
    // todo: consider providing read-timeout
  }

  @Override
  protected Set<String> scopes() {
    return SCOPES;
  }

  StorageRpc storageRpc() {
    if (storageRpc != null) {
      return storageRpc;
    }
    if (serviceRpcFactory() != null) {
      storageRpc = serviceRpcFactory().create(this);
    } else {
      storageRpc = createRpc(this, StorageRpcFactory.class);
      if (storageRpc == null) {
        storageRpc = new DefaultStorageRpc(this);
      }
    }
    return storageRpc;
  }

  public String pathDelimiter() {
    return pathDelimiter;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public int hashCode() {
    return baseHashCode() ^ Objects.hash(pathDelimiter);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof StorageOptions)) {
      return false;
    }
    StorageOptions other = (StorageOptions) obj;
    return baseEquals(other) && Objects.equals(pathDelimiter, other.pathDelimiter);
  }

  public static StorageOptions defaultInstance() {
    return builder().build();
  }

  public static Builder builder() {
    return new Builder();
  }
}
