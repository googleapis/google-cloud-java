/*
 * Copyright 2015 Google LLC
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

import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.TransportOptions;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.spi.StorageRpcFactory;
import com.google.cloud.storage.spi.v1.HttpStorageRpc;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

public class StorageOptions extends ServiceOptions<Storage, StorageOptions> {

  private static final long serialVersionUID = -2907268477247502947L;
  private static final String API_SHORT_NAME = "Storage";
  private static final String GCS_SCOPE = "https://www.googleapis.com/auth/devstorage.full_control";
  private static final Set<String> SCOPES = ImmutableSet.of(GCS_SCOPE);
  private static final String DEFAULT_HOST = "https://storage.googleapis.com";

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
    public ServiceRpc create(StorageOptions options) {
      return new HttpStorageRpc(options);
    }
  }

  public static class Builder extends ServiceOptions.Builder<Storage, StorageOptions, Builder> {

    private Builder() {}

    private Builder(StorageOptions options) {
      super(options);
    }

    @Override
    public Builder setTransportOptions(TransportOptions transportOptions) {
      if (!(transportOptions instanceof HttpTransportOptions)) {
        throw new IllegalArgumentException(
            "Only http transport is allowed for " + API_SHORT_NAME + ".");
      }
      return super.setTransportOptions(transportOptions);
    }

    @Override
    public StorageOptions build() {
      return new StorageOptions(this);
    }
  }

  private StorageOptions(Builder builder) {
    super(StorageFactory.class, StorageRpcFactory.class, builder, new StorageDefaults());
  }

  private static class StorageDefaults implements ServiceDefaults<Storage, StorageOptions> {

    @Override
    public StorageFactory getDefaultServiceFactory() {
      return DefaultStorageFactory.INSTANCE;
    }

    @Override
    public StorageRpcFactory getDefaultRpcFactory() {
      return DefaultStorageRpcFactory.INSTANCE;
    }

    @Override
    public TransportOptions getDefaultTransportOptions() {
      return getDefaultHttpTransportOptions();
    }
  }

  public static HttpTransportOptions getDefaultHttpTransportOptions() {
    return HttpTransportOptions.newBuilder().build();
  }

  // Project ID is only required for creating buckets, so we don't require it for creating the
  // service.
  @Override
  protected boolean projectIdRequired() {
    return false;
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }

  protected StorageRpc getStorageRpcV1() {
    return (StorageRpc) getRpc();
  }

  /** Returns a default {@code StorageOptions} instance. */
  public static StorageOptions getDefaultInstance() {
    return newBuilder().build();
  }

  /** Returns a unauthenticated {@code StorageOptions} instance. */
  public static StorageOptions getUnauthenticatedInstance() {
    return newBuilder().setCredentials(NoCredentials.getInstance()).build();
  }

  @SuppressWarnings("unchecked")
  @Override
  public Builder toBuilder() {
    return new Builder(this).setHost(DEFAULT_HOST);
  }

  @Override
  public int hashCode() {
    return baseHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof StorageOptions && baseEquals((StorageOptions) obj);
  }

  public static Builder newBuilder() {
    return new Builder().setHost(DEFAULT_HOST);
  }
}
