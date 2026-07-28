/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.internal.api;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.bigtable.v2.FeatureFlags;
import com.google.cloud.bigtable.data.v2.internal.channels.DirectPathIpInterceptor;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableList;
import io.grpc.ChannelCredentials;
import io.grpc.CompositeChannelCredentials;
import io.grpc.Grpc;
import io.grpc.ManagedChannelBuilder;
import io.grpc.TlsChannelCredentials;
import io.grpc.alts.AltsChannelCredentials;
import io.grpc.alts.GoogleDefaultChannelCredentials;
import io.grpc.auth.MoreCallCredentials;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;

public abstract class ChannelProviders {
  public static final String DEFAULT_HOST = "bigtable.googleapis.com";

  public interface ChannelProvider {

    ManagedChannelBuilder<?> newChannelBuilder();

    Optional<ChannelProvider> getFallback();

    FeatureFlags updateFeatureFlags(FeatureFlags featureFlags);

    boolean isSingleEndpoint();
  }

  public static class CloudPath implements ChannelProvider {
    private final String host;
    private final int port;
    private final ChannelCredentials credentials;

    public CloudPath(String endpoint) throws IOException {
      this(endpoint, GoogleCredentials.getApplicationDefault());
    }

    public CloudPath(String endpoint, Credentials credentials) {
      this.credentials =
          CompositeChannelCredentials.create(
              TlsChannelCredentials.create(), MoreCallCredentials.from(credentials));
      String host = endpoint;
      int port = 443;

      int sepI = endpoint.lastIndexOf(":");
      if (sepI > 0) {
        host = endpoint.substring(0, sepI);
        port = Integer.parseInt(endpoint.substring(sepI + 1));
      }
      this.host = host;
      this.port = port;
    }

    @Override
    public ManagedChannelBuilder<?> newChannelBuilder() {
      return Grpc.newChannelBuilderForAddress(host, port, credentials);
    }

    @Override
    public boolean isSingleEndpoint() {
      return false;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .addValue(String.format("%s:%d", host, port))
          .toString();
    }

    @Override
    public Optional<ChannelProvider> getFallback() {
      return Optional.empty();
    }

    @Override
    public FeatureFlags updateFeatureFlags(FeatureFlags featureFlags) {
      return featureFlags;
    }
  }

  public static class DirectAccess implements ChannelProvider {
    private final String endpoint;
    private final ChannelCredentials credentials;
    private final Optional<ChannelProvider> fallback;

    public DirectAccess(String endpoint) throws IOException {
      this(endpoint, GoogleCredentials.getApplicationDefault());
    }

    public DirectAccess(String endpoint, Credentials credentials) {
      this(endpoint, credentials, Optional.empty());
    }

    private DirectAccess(
        String endpoint, Credentials credentials, Optional<ChannelProvider> fallback) {
      this.endpoint = endpoint;
      this.credentials =
          GoogleDefaultChannelCredentials.newBuilder()
              .callCredentials(MoreCallCredentials.from(credentials))
              .build();
      this.fallback = fallback;
    }

    public static DirectAccess withFallback(String endpoint) throws IOException {
      return DirectAccess.withFallback(endpoint, GoogleCredentials.getApplicationDefault());
    }

    public static DirectAccess withFallback(String endpoint, Credentials credentials) {
      Optional<ChannelProvider> fallback = Optional.of(new CloudPath(endpoint, credentials));
      return new DirectAccess(endpoint, credentials, fallback);
    }

    @Override
    public ManagedChannelBuilder<?> newChannelBuilder() {
      return Grpc.newChannelBuilder("google-c2p:///" + endpoint, credentials)
          .intercept(new DirectPathIpInterceptor(true));
    }

    public String getEndpoint() {
      return endpoint;
    }

    @Override
    public FeatureFlags updateFeatureFlags(FeatureFlags featureFlags) {
      return featureFlags.toBuilder()
          .setTrafficDirectorEnabled(true)
          .setDirectAccessRequested(true)
          .build();
    }

    @Override
    public boolean isSingleEndpoint() {
      return false;
    }

    @Override
    public Optional<ChannelProvider> getFallback() {
      return fallback;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).addValue(endpoint).toString();
    }
  }

  public static class RawDirectPath implements ChannelProvider {
    private final List<String> endpoints;
    ChannelCredentials credentials;

    public RawDirectPath(List<String> endpoints) throws IOException {
      this(endpoints, GoogleCredentials.getApplicationDefault());
    }

    public RawDirectPath(List<String> endpoints, Credentials credentials) {
      this.endpoints = ImmutableList.copyOf(endpoints);
      this.credentials =
          CompositeChannelCredentials.create(
              AltsChannelCredentials.create(), MoreCallCredentials.from(credentials));
    }

    @Override
    public ManagedChannelBuilder<?> newChannelBuilder() {
      int endpointI = new Random().nextInt(endpoints.size());
      String endpoint = endpoints.get(endpointI);
      int portSplit = endpoint.lastIndexOf(":");
      String host = endpoint.substring(0, portSplit);
      int port = Integer.parseInt(endpoint.substring(portSplit + 1));

      return Grpc.newChannelBuilderForAddress(host, port, credentials);
    }

    @Override
    public FeatureFlags updateFeatureFlags(FeatureFlags featureFlags) {
      return featureFlags.toBuilder().setDirectAccessRequested(true).build();
    }

    @Override
    public boolean isSingleEndpoint() {
      return endpoints.size() <= 1;
    }

    @Override
    public String toString() {
      ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
      endpoints.forEach(stringHelper::addValue);
      return stringHelper.toString();
    }

    @Override
    public Optional<ChannelProvider> getFallback() {
      return Optional.empty();
    }
  }

  public static class EmulatorChannelProvider implements ChannelProvider {

    private final String host;
    private final int port;

    public EmulatorChannelProvider(String host, int port) {
      this.host = host;
      this.port = port;
    }

    @Override
    public ManagedChannelBuilder<?> newChannelBuilder() {
      return ManagedChannelBuilder.forAddress(host, port).usePlaintext();
    }

    @Override
    public boolean isSingleEndpoint() {
      return true;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .addValue(String.format("%s:%d", host, port))
          .toString();
    }

    @Override
    public Optional<ChannelProvider> getFallback() {
      return Optional.empty();
    }

    @Override
    public FeatureFlags updateFeatureFlags(FeatureFlags featureFlags) {
      return featureFlags;
    }
  }

  public static class ForwardingChannelProvider implements ChannelProvider {
    private final ChannelProvider delegate;

    public ForwardingChannelProvider(ChannelProvider delegate) {
      this.delegate = delegate;
    }

    @Override
    public ManagedChannelBuilder<?> newChannelBuilder() {
      return delegate.newChannelBuilder();
    }

    @Override
    public FeatureFlags updateFeatureFlags(FeatureFlags featureFlags) {
      return delegate.updateFeatureFlags(featureFlags);
    }

    @Override
    public boolean isSingleEndpoint() {
      return delegate.isSingleEndpoint();
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).addValue(delegate).toString();
    }

    @Override
    public Optional<ChannelProvider> getFallback() {
      return delegate.getFallback();
    }
  }

  /**
   * ConfiguredChannelProvider is responsible for applying a custom options to the channel builder.
   * It is meant to be used only during client construction phase and not during client
   * configuration phase.
   */
  public static class ConfiguredChannelProvider extends ForwardingChannelProvider {
    private final Function<ManagedChannelBuilder<?>, ManagedChannelBuilder<?>> configurator;

    public ConfiguredChannelProvider(
        ChannelProvider delegate,
        Function<ManagedChannelBuilder<?>, ManagedChannelBuilder<?>> configurator) {
      super(delegate);
      this.configurator = configurator;
    }

    @Override
    public ManagedChannelBuilder<?> newChannelBuilder() {
      return configurator.apply(super.newChannelBuilder());
    }

    @Override
    public Optional<ChannelProvider> getFallback() {
      return super.getFallback()
          .flatMap(cb -> Optional.of(new ConfiguredChannelProvider(cb, configurator)));
    }
  }
}
