/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Represents a Cloud Spanner instance config.{@code InstanceConfig} adds a layer of service related
 * functionality over {@code InstanceConfigInfo}.
 */
public class InstanceConfig extends InstanceConfigInfo {

  private final InstanceAdminClient client;

  /** Builder of {@code InstanceConfig}. */
  public static class Builder extends InstanceConfigInfo.BuilderImpl {
    private final InstanceAdminClient client;

    Builder(InstanceConfig instanceConfig) {
      super(instanceConfig);
      this.client = instanceConfig.client;
    }

    Builder(InstanceAdminClient client, InstanceConfigId id) {
      super(id);
      this.client = client;
    }

    @Override
    public Builder setDisplayName(String displayName) {
      super.setDisplayName(displayName);
      return this;
    }

    @Override
    protected Builder setReplicas(List<ReplicaInfo> replicas) {
      super.setReplicas(replicas);
      return this;
    }

    @Override
    public Builder setLeaderOptions(List<String> leaderOptions) {
      super.setLeaderOptions(leaderOptions);
      return this;
    }

    @Override
    protected Builder setOptionalReplicas(List<ReplicaInfo> optionalReplicas) {
      super.setOptionalReplicas(optionalReplicas);
      return this;
    }

    @Override
    protected Builder setBaseConfig(InstanceConfigInfo baseConfig) {
      super.setBaseConfig(baseConfig);
      return this;
    }

    @Override
    protected Builder setConfigType(Type configType) {
      super.setConfigType(configType);
      return this;
    }

    @Override
    protected Builder setState(State state) {
      super.setState(state);
      return this;
    }

    @Override
    public Builder setEtag(String etag) {
      super.setEtag(etag);
      return this;
    }

    @Override
    protected Builder setReconciling(boolean reconciling) {
      super.setReconciling(reconciling);
      return this;
    }

    @Override
    public Builder addLabel(String key, String value) {
      super.addLabel(key, value);
      return this;
    }

    @Override
    public Builder putAllLabels(Map<String, String> labels) {
      super.putAllLabels(labels);
      return this;
    }

    @Override
    public Builder addReadOnlyReplicas(List<ReplicaInfo> readOnlyReplicas) {
      super.addReadOnlyReplicas(readOnlyReplicas);
      return this;
    }

    @Override
    public InstanceConfig build() {
      return new InstanceConfig(this);
    }
  }

  public static Builder newBuilder(InstanceConfig instanceConfig) {
    return new Builder(instanceConfig);
  }

  public static Builder newBuilder(InstanceAdminClient client, InstanceConfigId instanceConfigId) {
    return new Builder(client, instanceConfigId);
  }

  /** Use {@link #newBuilder} instead */
  @Deprecated
  public InstanceConfig(InstanceConfigId id, String displayName, InstanceAdminClient client) {
    this(id, displayName, Collections.emptyList(), Collections.emptyList(), client);
  }

  /** Use {@link #newBuilder} instead */
  @Deprecated
  public InstanceConfig(
      InstanceConfigId id,
      String displayName,
      List<ReplicaInfo> replicas,
      List<String> leaderOptions,
      InstanceAdminClient client) {
    super(id, displayName, replicas, leaderOptions);
    this.client = client;
  }

  InstanceConfig(Builder builder) {
    super(builder);
    this.client = builder.client;
  }

  /** Gets the current state of this instance config. */
  public InstanceConfig reload() {
    return client.getInstanceConfig(getId().getInstanceConfig());
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }
}
