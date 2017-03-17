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

import com.google.cloud.GrpcTransportOptions;
import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.TransportOptions;
import com.google.cloud.pubsub.deprecated.spi.v1.GrpcPubSubRpc;
import com.google.cloud.pubsub.deprecated.spi.v1.PubSubRpc;
import com.google.cloud.pubsub.deprecated.spi.PubSubRpcFactory;
import com.google.cloud.pubsub.spi.v1.PublisherSettings;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.Set;

public class PubSubOptions extends ServiceOptions<PubSub, PubSubOptions> {

  private static final long serialVersionUID = 5598666986447361352L;
  private static final String API_SHORT_NAME = "PubSub";
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
    public ServiceRpc create(PubSubOptions options) {
      try {
        return new GrpcPubSubRpc(options);
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
      ServiceOptions.Builder<PubSub, PubSubOptions, Builder> {

    private Builder() {}

    private Builder(PubSubOptions options) {
      super(options);
    }

    @Override
    public Builder setTransportOptions(TransportOptions transportOptions) {
      if (!(transportOptions instanceof GrpcTransportOptions)) {
        throw new IllegalArgumentException(
            "Only grpc transport is allowed for " + API_SHORT_NAME + ".");
      }
      return super.setTransportOptions(transportOptions);
    }

    @Override
    public PubSubOptions build() {
      return new PubSubOptions(this);
    }
  }

  protected PubSubOptions(Builder builder) {
    super(PubSubFactory.class, PubSubRpcFactory.class, builder, new PubSubDefaults());
  }

  private static class PubSubDefaults implements
      ServiceDefaults<PubSub, PubSubOptions> {

    @Override
    public PubSubFactory getDefaultServiceFactory() {
      return DefaultPubSubFactory.INSTANCE;
    }

    @Override
    public PubSubRpcFactory getDefaultRpcFactory() {
      return DefaultPubSubRpcFactory.INSTANCE;
    }

    @Override
    public TransportOptions getDefaultTransportOptions() {
      return getDefaultGrpcTransportOptions();
    }
  }

  public static GrpcTransportOptions getDefaultGrpcTransportOptions() {
    return GrpcTransportOptions.newBuilder().build();
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }

  protected PubSubRpc getPubSubRpcV1() {
    return (PubSubRpc) getRpc();
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

  public static Builder newBuilder() {
    return new Builder();
  }
}
