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

package com.google.cloud.resourcemanager;

import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.TransportOptions;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.resourcemanager.spi.ResourceManagerRpcFactory;
import com.google.cloud.resourcemanager.spi.v1beta1.HttpResourceManagerRpc;
import com.google.cloud.resourcemanager.spi.v1beta1.ResourceManagerRpc;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

/** @deprecated v3 GAPIC client of ResourceManager is now available */
@Deprecated
public class ResourceManagerOptions
    extends ServiceOptions<ResourceManager, ResourceManagerOptions> {

  private static final long serialVersionUID = 624147474447836183L;
  private static final String API_SHORT_NAME = "ResourceManager";
  private static final String GCRM_SCOPE = "https://www.googleapis.com/auth/cloud-platform";
  private static final Set<String> SCOPES = ImmutableSet.of(GCRM_SCOPE);
  private static final String DEFAULT_HOST = "https://cloudresourcemanager.googleapis.com";

  public static class DefaultResourceManagerFactory implements ResourceManagerFactory {
    private static final ResourceManagerFactory INSTANCE = new DefaultResourceManagerFactory();

    @Override
    public ResourceManager create(ResourceManagerOptions options) {
      return new ResourceManagerImpl(options);
    }
  }

  /** Returns a default {@code ResourceManagerOptions} instance. */
  public static ResourceManagerOptions getDefaultInstance() {
    return newBuilder().build();
  }

  public static class DefaultResourceManagerRpcFactory implements ResourceManagerRpcFactory {
    private static final ResourceManagerRpcFactory INSTANCE =
        new DefaultResourceManagerRpcFactory();

    @Override
    public ServiceRpc create(ResourceManagerOptions options) {
      return new HttpResourceManagerRpc(options);
    }
  }

  @Override
  protected String getDefaultHost() {
    return DEFAULT_HOST;
  }

  public static class Builder
      extends ServiceOptions.Builder<ResourceManager, ResourceManagerOptions, Builder> {

    private Builder() {}

    private Builder(ResourceManagerOptions options) {
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
    public ResourceManagerOptions build() {
      return new ResourceManagerOptions(this);
    }
  }

  private ResourceManagerOptions(Builder builder) {
    super(
        ResourceManagerFactory.class,
        ResourceManagerRpcFactory.class,
        builder,
        new ResourceManagerDefaults());
  }

  @Override
  protected boolean projectIdRequired() {
    return false;
  }

  private static class ResourceManagerDefaults
      implements ServiceDefaults<ResourceManager, ResourceManagerOptions> {

    @Override
    public ResourceManagerFactory getDefaultServiceFactory() {
      return DefaultResourceManagerFactory.INSTANCE;
    }

    @Override
    public ResourceManagerRpcFactory getDefaultRpcFactory() {
      return DefaultResourceManagerRpcFactory.INSTANCE;
    }

    @Override
    public TransportOptions getDefaultTransportOptions() {
      return getDefaultHttpTransportOptions();
    }
  }

  public static HttpTransportOptions getDefaultHttpTransportOptions() {
    return HttpTransportOptions.newBuilder().build();
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }

  protected ResourceManagerRpc getResourceManagerRpcV1Beta1() {
    return (ResourceManagerRpc) getRpc();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof ResourceManagerOptions && baseEquals((ResourceManagerOptions) obj);
  }

  @Override
  public int hashCode() {
    return baseHashCode();
  }

  @SuppressWarnings("unchecked")
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder newBuilder() {
    return new Builder();
  }
}
