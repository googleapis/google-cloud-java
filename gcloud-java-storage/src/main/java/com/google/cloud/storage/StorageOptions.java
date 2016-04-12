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

import com.google.common.collect.ImmutableSet;
import com.google.cloud.ServiceOptions;
import com.google.cloud.storage.spi.DefaultStorageRpc;
import com.google.cloud.storage.spi.StorageRpc;
import com.google.cloud.storage.spi.StorageRpcFactory;

import java.util.Set;

public class StorageOptions extends ServiceOptions<Storage, StorageRpc, StorageOptions> {

  private static final long serialVersionUID = -7804860602287801084L;
  private static final String GCS_SCOPE = "https://www.googleapis.com/auth/devstorage.full_control";
  private static final Set<String> SCOPES = ImmutableSet.of(GCS_SCOPE);

  public static class DefaultStorageFactory implements StorageFactory {

    private static final StorageFactory INSTANCE = new DefaultStorageFactory();

    @Override
    public Storage create(StorageOptions options) {
      return new StorageImpl(options);
    }
  }

  public static class DefaultStorageRpcFactory implements StorageRpcFactory {

    private static final StorageRpcFactory INSTANCE = new DefaultStorageRpcFactory();

    @Override
    public StorageRpc create(StorageOptions options) {
      return new DefaultStorageRpc(options);
    }
  }

  public static class Builder extends
      ServiceOptions.Builder<Storage, StorageRpc, StorageOptions, Builder> {

    private Builder() {}

    private Builder(StorageOptions options) {
      super(options);
    }

    @Override
    public StorageOptions build() {
      return new StorageOptions(this);
    }
  }

  private StorageOptions(Builder builder) {
    super(StorageFactory.class, StorageRpcFactory.class, builder);
  }

  @Override
  protected StorageFactory defaultServiceFactory() {
    return DefaultStorageFactory.INSTANCE;
  }

  @Override
  protected StorageRpcFactory defaultRpcFactory() {
    return DefaultStorageRpcFactory.INSTANCE;
  }

  @Override
  protected Set<String> scopes() {
    return SCOPES;
  }

  /**
   * Returns a default {@code StorageOptions} instance.
   */
  public static StorageOptions defaultInstance() {
    return builder().build();
  }

  @SuppressWarnings("unchecked")
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public int hashCode() {
    return baseHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof StorageOptions && baseEquals((StorageOptions) obj);
  }

  public static Builder builder() {
    return new Builder();
  }
}
