/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.grpc;

import com.google.api.core.ApiFunction;
import com.google.cloud.grpc.multiendpoint.MultiEndpoint;
import com.google.common.base.Preconditions;
import io.grpc.ChannelCredentials;
import io.grpc.ManagedChannelBuilder;
import java.time.Duration;
import java.util.List;

/**
 * {@link MultiEndpoint} configuration for the {@link GcpMultiEndpointChannel}.
 */
public class GcpMultiEndpointOptions {

  private final String name;
  private final List<String> endpoints;
  private final ApiFunction<ManagedChannelBuilder<?>, ManagedChannelBuilder<?>> channelConfigurator;
  private final ChannelCredentials channelCredentials;
  private final Duration recoveryTimeout;

  public static String DEFAULT_NAME = "default";

  public GcpMultiEndpointOptions(Builder builder) {
    this.name = builder.name;
    this.endpoints = builder.endpoints;
    this.channelConfigurator = builder.channelConfigurator;
    this.channelCredentials = builder.channelCredentials;
    this.recoveryTimeout = builder.recoveryTimeout;
  }

  /**
   * Creates a new GcpMultiEndpointOptions.Builder.
   *
   * @param endpoints list of endpoints for the MultiEndpoint.
   */
  public static Builder newBuilder(List<String> endpoints) {
    return new Builder(endpoints);
  }

  /**
   * Creates a new GcpMultiEndpointOptions.Builder from GcpMultiEndpointOptions.
   */
  public static Builder newBuilder(GcpMultiEndpointOptions options) {
    return new Builder(options);
  }

  public String getName() {
    return name;
  }

  public List<String> getEndpoints() {
    return endpoints;
  }

  public ApiFunction<ManagedChannelBuilder<?>, ManagedChannelBuilder<?>> getChannelConfigurator() {
    return channelConfigurator;
  }

  public ChannelCredentials getChannelCredentials() {
    return channelCredentials;
  }

  public Duration getRecoveryTimeout() {
    return recoveryTimeout;
  }

  public static class Builder {

    private String name = GcpMultiEndpointOptions.DEFAULT_NAME;
    private List<String> endpoints;
    private ApiFunction<ManagedChannelBuilder<?>, ManagedChannelBuilder<?>> channelConfigurator;
    private ChannelCredentials channelCredentials;
    private Duration recoveryTimeout = Duration.ZERO;

    public Builder(List<String> endpoints) {
      setEndpoints(endpoints);
    }

    public Builder(GcpMultiEndpointOptions options) {
      this.name = options.getName();
      this.endpoints = options.getEndpoints();
      this.channelConfigurator = options.getChannelConfigurator();
      this.channelCredentials = options.getChannelCredentials();
      this.recoveryTimeout = options.getRecoveryTimeout();
    }

    public GcpMultiEndpointOptions build() {
      return new GcpMultiEndpointOptions(this);
    }

    private void setEndpoints(List<String> endpoints) {
      Preconditions.checkNotNull(endpoints);
      Preconditions.checkArgument(
          !endpoints.isEmpty(), "At least one endpoint must be specified.");
      Preconditions.checkArgument(
          endpoints.stream().noneMatch(s -> s.trim().isEmpty()), "No empty endpoints allowed.");
      this.endpoints = endpoints;
    }

    /**
     * Sets the name of the MultiEndpoint.
     *
     * @param name MultiEndpoint name.
     */
    public GcpMultiEndpointOptions.Builder withName(String name) {
      this.name = name;
      return this;
    }

    /**
     * Sets the endpoints of the MultiEndpoint.
     *
     * @param endpoints List of endpoints in the form of host:port in descending priority order.
     */
    public GcpMultiEndpointOptions.Builder withEndpoints(List<String> endpoints) {
      this.setEndpoints(endpoints);
      return this;
    }

    /**
     * Sets the channel configurator for the MultiEndpoint channel pool.
     *
     * @param channelConfigurator function to perform on the ManagedChannelBuilder in the channel
     * pool.
     */
    public GcpMultiEndpointOptions.Builder withChannelConfigurator(
        ApiFunction<ManagedChannelBuilder<?>, ManagedChannelBuilder<?>> channelConfigurator) {
      this.channelConfigurator = channelConfigurator;
      return this;
    }

    /**
     * Sets the channel credentials to use in the MultiEndpoint channel pool.
     *
     * @param channelCredentials channel credentials.
     */
    public GcpMultiEndpointOptions.Builder withChannelCredentials(
        ChannelCredentials channelCredentials) {
      this.channelCredentials = channelCredentials;
      return this;
    }

    /**
     * Sets the recovery timeout for the MultiEndpoint. See more info in the {@link MultiEndpoint}.
     *
     * @param recoveryTimeout recovery timeout.
     */
    public GcpMultiEndpointOptions.Builder withRecoveryTimeout(Duration recoveryTimeout) {
      this.recoveryTimeout = recoveryTimeout;
      return this;
    }
  }
}
