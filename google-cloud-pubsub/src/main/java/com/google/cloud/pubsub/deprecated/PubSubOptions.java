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

package com.google.cloud.pubsub.deprecated;

import com.google.cloud.GrpcServiceOptions;
import com.google.cloud.pubsub.deprecated.spi.DefaultPubSubRpc;
import com.google.cloud.pubsub.deprecated.spi.PubSubRpc;
import com.google.cloud.pubsub.deprecated.spi.PubSubRpcFactory;
import com.google.cloud.pubsub.spi.v1.PublisherSettings;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public class PubSubOptions extends GrpcServiceOptions<PubSub, PubSubRpc, PubSubOptions> {

  private static final long serialVersionUID = 5598666986447361352L;
  private static final String PUBSUB_SCOPE = "https://www.googleapis.com/auth/pubsub";
  private static final Set<String> SCOPES = ImmutableSet.of(PUBSUB_SCOPE);
  private static final String EMULATOR_HOST_ENV_VAR = "PUBSUB_EMULATOR_HOST";
  private static final String DEFAULT_HOST = PublisherSettings.getDefaultServiceAddress()
      + ':' + PublisherSettings.getDefaultServicePort();

  public static class DefaultPubSubFactory implements PubSubFactory {
    private static final PubSubFactory INSTANCE = new DefaultPubSubFactory();

    @Override
    public PubSub create(PubSubOptions options) {
      return new PubSubImpl(options);
    }
  }

  /**
   * Returns a default {@code PubSubOptions} instance.
   */
  @Deprecated
  public static PubSubOptions defaultInstance() {
    return getDefaultInstance();
  }

  /**
   * Returns a default {@code PubSubOptions} instance.
   */
  public static PubSubOptions getDefaultInstance() {
    return newBuilder().build();
  }

  public static class DefaultPubSubRpcFactory implements PubSubRpcFactory {
    private static final PubSubRpcFactory INSTANCE = new DefaultPubSubRpcFactory();

    @Override
    public PubSubRpc create(PubSubOptions options) {
      try {
        return new DefaultPubSubRpc(options);
      } catch (IOException e) {
        throw new PubSubException(e, true);
      }
    }
  }

  @Override
  protected String getDefaultHost() {
    String host = System.getProperty(EMULATOR_HOST_ENV_VAR, System.getenv(EMULATOR_HOST_ENV_VAR));
    return host != null ? host : DEFAULT_HOST;
  }

  public static class Builder extends
      GrpcServiceOptions.Builder<PubSub, PubSubRpc, PubSubOptions, Builder> {

    private Builder() {}

    private Builder(PubSubOptions options) {
      super(options);
    }

    @Override
    public PubSubOptions build() {
      return new PubSubOptions(this);
    }
  }

  protected PubSubOptions(Builder builder) {
    super(PubSubFactory.class, PubSubRpcFactory.class, builder);
  }

  @Override
  protected ExecutorFactory<ScheduledExecutorService> getExecutorFactory() {
    return super.getExecutorFactory();
  }

  @Override
  protected PubSubFactory getDefaultServiceFactory() {
    return DefaultPubSubFactory.INSTANCE;
  }

  @Override
  protected PubSubRpcFactory getDefaultRpcFactory() {
    return DefaultPubSubRpcFactory.INSTANCE;
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof PubSubOptions && baseEquals((PubSubOptions) obj);
  }

  @Override
  public int hashCode() {
    return baseHashCode();
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Deprecated
  public static Builder builder() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return new Builder();
  }
}
