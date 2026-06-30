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

import com.google.cloud.FieldSelector;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.instance.v1.InstanceConfig;
import com.google.spanner.admin.instance.v1.InstanceConfig.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/** Represents a Cloud Spanner instance config resource. */
public class InstanceConfigInfo {

  /** Represent an updatable field in Cloud Spanner InstanceConfig. */
  public enum InstanceConfigField implements FieldSelector {
    DISPLAY_NAME("display_name"),
    LABELS("labels");

    private final String selector;

    InstanceConfigField(String selector) {
      this.selector = selector;
    }

    @Override
    public String getSelector() {
      return selector;
    }

    static FieldMask toFieldMask(Iterable<InstanceConfigField> fields) {
      FieldMask.Builder builder = FieldMask.newBuilder();
      for (InstanceConfigField field : fields) {
        builder.addPaths(field.getSelector());
      }
      return builder.build();
    }
  }

  /** Type of the Instance config. */
  public enum Type {
    TYPE_UNSPECIFIED,
    GOOGLE_MANAGED,
    USER_MANAGED
  }

  /** Type of the Instance config. */
  public enum State {
    STATE_UNSPECIFIED,
    CREATING,
    READY
  }

  private final InstanceConfigId id;
  private final String displayName;
  private final List<ReplicaInfo> replicas;
  private final List<String> leaderOptions;
  private final List<ReplicaInfo> optionalReplicas;
  private final InstanceConfigInfo baseConfig;
  private final Type configType;
  private final String etag;
  private final boolean reconciling;
  private final State state;
  private final Map<String, String> labels;

  /** Returns the id of this instance config. */
  public InstanceConfigId getId() {
    return id;
  }

  /** Returns the display name of this instance config. */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * The geographic placement of nodes in this instance configuration and their replication
   * properties.
   */
  public List<ReplicaInfo> getReplicas() {
    return replicas;
  }

  /**
   * Allowed values of the default leader schema option for databases in instances that use this
   * instance configuration.
   */
  public List<String> getLeaderOptions() {
    return leaderOptions;
  }

  /**
   * The available optional replicas to choose from for user managed configurations. Populated for
   * Google managed configurations.
   */
  public List<ReplicaInfo> getOptionalReplicas() {
    return optionalReplicas;
  }

  /**
   * Base configuration, e.g. {@code projects/<project_name>/instanceConfigs/nam3}, based on which
   * this configuration is created. Only set for user managed configurations. The base config must
   * refer to a configuration of type GOOGLE_MANAGED.
   */
  public InstanceConfigInfo getBaseConfig() {
    return baseConfig;
  }

  /**
   * Config type, indicates whether this instance config is a Google or User Managed Configuration.
   */
  public Type getConfigType() {
    return configType;
  }

  /**
   * etag, which is used for optimistic concurrency control as a way to help prevent simultaneous
   * updates of an instance config from overwriting each other.
   */
  public String getEtag() {
    return etag;
  }

  /**
   * If true, the instance config is being created or updated. If false, there are no ongoing
   * operations for the instance config.
   */
  public boolean getReconciling() {
    return reconciling;
  }

  /** The current instance config state. */
  public State getState() {
    return state;
  }

  /**
   * Cloud Labels, which can be used to filter collections of resources. They can be used to control
   * how resource metrics are aggregated.
   */
  public Map<String, String> getLabels() {
    return labels;
  }

  /** Builder for {@code InstanceConfigInfo}. */
  public abstract static class Builder {
    public abstract Builder setDisplayName(String displayName);

    protected abstract Builder setReplicas(List<ReplicaInfo> replicas);

    protected abstract Builder setOptionalReplicas(List<ReplicaInfo> optionalReplicas);

    protected abstract Builder setBaseConfig(InstanceConfigInfo baseConfig);

    /**
     * Sets the allowed values of the "default_leader" schema option for databases in instances that
     * use this instance configuration.
     */
    public abstract Builder setLeaderOptions(List<String> leaderOptions);

    protected abstract Builder setConfigType(Type configType);

    protected abstract Builder setState(State state);

    public abstract Builder setEtag(String etag);

    protected abstract Builder setReconciling(boolean reconciling);

    public abstract Builder addLabel(String key, String value);

    public abstract Builder putAllLabels(Map<String, String> labels);

    /**
     * Adds the read only replicas to the set of replicas for a custom instance config. Called with
     * one or more of the optional replicas of the base config.
     */
    public abstract Builder addReadOnlyReplicas(List<ReplicaInfo> readOnlyReplicas);

    public abstract InstanceConfigInfo build();
  }

  static class BuilderImpl extends Builder {
    private InstanceConfigId id;
    private String displayName = "";
    private List<ReplicaInfo> replicas = new ArrayList<>();
    private List<String> leaderOptions = new ArrayList<>();
    private List<ReplicaInfo> optionalReplicas = new ArrayList<>();
    private InstanceConfigInfo baseConfig;
    private Type configType = Type.TYPE_UNSPECIFIED;
    private String etag = "";
    private boolean reconciling = false;
    private State state = State.STATE_UNSPECIFIED;
    private Map<String, String> labels = new HashMap<>();

    BuilderImpl(InstanceConfigId id) {
      this.id = id;
    }

    BuilderImpl(InstanceConfigId id, InstanceConfigInfo baseConfig) {
      this.id = id;
      this.baseConfig = baseConfig;
      this.replicas = new ArrayList<>(baseConfig.replicas);
    }

    BuilderImpl(InstanceConfigInfo instanceConfigInfo) {
      this.id = instanceConfigInfo.id;
      this.displayName = instanceConfigInfo.displayName;
      this.replicas = new ArrayList<>(instanceConfigInfo.replicas);
      this.leaderOptions = new ArrayList<>(instanceConfigInfo.leaderOptions);
      this.optionalReplicas = new ArrayList<>(instanceConfigInfo.optionalReplicas);
      this.baseConfig = instanceConfigInfo.baseConfig;
      this.configType = instanceConfigInfo.configType;
      this.etag = instanceConfigInfo.etag;
      this.reconciling = instanceConfigInfo.reconciling;
      this.state = instanceConfigInfo.state;
      this.labels = new HashMap<>(instanceConfigInfo.labels);
    }

    @Override
    public Builder setDisplayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    @Override
    protected Builder setReplicas(List<ReplicaInfo> replicas) {
      this.replicas = replicas;
      return this;
    }

    @Override
    public Builder setLeaderOptions(List<String> leaderOptions) {
      this.leaderOptions = leaderOptions;
      return this;
    }

    @Override
    protected Builder setOptionalReplicas(List<ReplicaInfo> optionalReplicas) {
      this.optionalReplicas = optionalReplicas;
      return this;
    }

    @Override
    protected Builder setBaseConfig(InstanceConfigInfo baseConfig) {
      this.baseConfig = baseConfig;
      return this;
    }

    @Override
    protected Builder setConfigType(Type configType) {
      this.configType = configType;
      return this;
    }

    @Override
    protected Builder setState(State state) {
      this.state = state;
      return this;
    }

    @Override
    public Builder setEtag(String etag) {
      this.etag = etag;
      return this;
    }

    @Override
    protected Builder setReconciling(boolean reconciling) {
      this.reconciling = reconciling;
      return this;
    }

    @Override
    public Builder addLabel(String key, String value) {
      this.labels.put(key, value);
      return this;
    }

    @Override
    public Builder putAllLabels(Map<String, String> labels) {
      this.labels.putAll(labels);
      return this;
    }

    @Override
    public Builder addReadOnlyReplicas(List<ReplicaInfo> readOnlyReplicas) {
      this.replicas.addAll(readOnlyReplicas);
      return this;
    }

    @Override
    public InstanceConfigInfo build() {
      return new InstanceConfigInfo(this);
    }
  }

  /** Use {@link #newBuilder} instead */
  @Deprecated
  public InstanceConfigInfo(InstanceConfigId id, String displayName) {
    this((BuilderImpl) newBuilder(id).setDisplayName(displayName));
  }

  public static Builder newBuilder(InstanceConfigId id) {
    return new BuilderImpl(id);
  }

  public static Builder newBuilder(InstanceConfigId id, InstanceConfigInfo baseConfig) {
    return new BuilderImpl(id, baseConfig);
  }

  /** Use {@link #newBuilder} instead */
  @Deprecated
  public InstanceConfigInfo(
      InstanceConfigId id,
      String displayName,
      List<ReplicaInfo> replicas,
      List<String> leaderOptions) {
    this(
        (BuilderImpl)
            newBuilder(id)
                .setDisplayName(displayName)
                .setReplicas(replicas)
                .setLeaderOptions(leaderOptions));
  }

  InstanceConfigInfo(BuilderImpl builder) {
    this.id = builder.id;
    this.displayName = builder.displayName;
    this.replicas = new ArrayList<>(builder.replicas);
    this.leaderOptions = new ArrayList<>(builder.leaderOptions);
    this.baseConfig = builder.baseConfig;
    this.optionalReplicas = new ArrayList<>(builder.optionalReplicas);
    this.configType = builder.configType;
    this.etag = builder.etag;
    this.reconciling = builder.reconciling;
    this.state = builder.state;
    this.labels = ImmutableMap.copyOf(builder.labels);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof InstanceConfigInfo)) {
      return false;
    }
    InstanceConfigInfo that = (InstanceConfigInfo) o;
    return Objects.equals(id, that.id)
        && Objects.equals(displayName, that.displayName)
        && Objects.equals(replicas, that.replicas)
        && Objects.equals(leaderOptions, that.leaderOptions)
        && Objects.equals(optionalReplicas, that.optionalReplicas)
        && Objects.equals(baseConfig, that.baseConfig)
        && Objects.equals(configType, that.configType)
        && Objects.equals(etag, that.etag)
        && Objects.equals(reconciling, that.reconciling)
        && Objects.equals(state, that.state)
        && Objects.equals(labels, that.labels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        displayName,
        replicas,
        leaderOptions,
        optionalReplicas,
        baseConfig,
        configType,
        etag,
        reconciling,
        state,
        labels);
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public String toString() {
    return String.format(
        "Instance Config[%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s]",
        id,
        displayName,
        replicas,
        leaderOptions,
        optionalReplicas,
        baseConfig,
        configType,
        etag,
        reconciling,
        state,
        labels);
  }

  com.google.spanner.admin.instance.v1.InstanceConfig toProto() {
    InstanceConfig.Builder builder =
        com.google.spanner.admin.instance.v1.InstanceConfig.newBuilder()
            .setName(getId().getName())
            .setDisplayName(getDisplayName())
            .addAllReplicas(
                getReplicas().stream().map(ReplicaInfo::getProto).collect(Collectors.toList()))
            .addAllLeaderOptions(getLeaderOptions())
            .setEtag(getEtag())
            .setReconciling(getReconciling())
            .putAllLabels(getLabels())
            .addAllOptionalReplicas(
                getOptionalReplicas().stream()
                    .map(ReplicaInfo::getProto)
                    .collect(Collectors.toList()))
            .setConfigType(toProtoConfigType(getConfigType()))
            .setState(toProtoState(getState()));

    if (getBaseConfig() != null) {
      builder.setBaseConfig(getBaseConfig().getId().getName());
    }

    return builder.build();
  }

  private static InstanceConfig.Type toProtoConfigType(Type type) {
    switch (type) {
      case TYPE_UNSPECIFIED:
        return com.google.spanner.admin.instance.v1.InstanceConfig.Type.TYPE_UNSPECIFIED;
      case GOOGLE_MANAGED:
        return com.google.spanner.admin.instance.v1.InstanceConfig.Type.GOOGLE_MANAGED;
      case USER_MANAGED:
        return InstanceConfig.Type.USER_MANAGED;
      default:
        throw new IllegalArgumentException("Unknown config type:" + type);
    }
  }

  private static InstanceConfig.State toProtoState(State state) {
    switch (state) {
      case STATE_UNSPECIFIED:
        return com.google.spanner.admin.instance.v1.InstanceConfig.State.STATE_UNSPECIFIED;
      case CREATING:
        return com.google.spanner.admin.instance.v1.InstanceConfig.State.CREATING;
      case READY:
        return com.google.spanner.admin.instance.v1.InstanceConfig.State.READY;
      default:
        throw new IllegalArgumentException("Unknown state:" + state);
    }
  }

  static com.google.cloud.spanner.InstanceConfig fromProto(
      com.google.spanner.admin.instance.v1.InstanceConfig proto, InstanceAdminClient client) {
    com.google.cloud.spanner.InstanceConfig.Builder builder =
        com.google.cloud.spanner.InstanceConfig.newBuilder(
                client, InstanceConfigId.of(proto.getName()))
            .setReconciling(proto.getReconciling())
            .setReplicas(
                proto.getReplicasList().stream()
                    .map(ReplicaInfo::fromProto)
                    .collect(Collectors.toList()))
            .setDisplayName(proto.getDisplayName())
            .putAllLabels(proto.getLabelsMap())
            .setEtag(proto.getEtag())
            .setLeaderOptions(proto.getLeaderOptionsList())
            .setOptionalReplicas(
                proto.getOptionalReplicasList().stream()
                    .map(ReplicaInfo::fromProto)
                    .collect(Collectors.toList()))
            .setState(fromProtoState(proto.getState()))
            .setConfigType(fromProtoConfigType(proto.getConfigType()));

    if (!proto.getBaseConfig().isEmpty()) {
      builder.setBaseConfig(newBuilder(InstanceConfigId.of(proto.getBaseConfig())).build());
    }

    return builder.build();
  }

  private static State fromProtoState(
      com.google.spanner.admin.instance.v1.InstanceConfig.State state) {
    switch (state) {
      case STATE_UNSPECIFIED:
        return State.STATE_UNSPECIFIED;
      case CREATING:
        return State.CREATING;
      case READY:
        return State.READY;
      default:
        throw new IllegalArgumentException("Unknown state:" + state);
    }
  }

  private static Type fromProtoConfigType(
      com.google.spanner.admin.instance.v1.InstanceConfig.Type type) {
    switch (type) {
      case TYPE_UNSPECIFIED:
        return Type.TYPE_UNSPECIFIED;
      case GOOGLE_MANAGED:
        return Type.GOOGLE_MANAGED;
      case USER_MANAGED:
        return Type.USER_MANAGED;
      default:
        throw new IllegalArgumentException("Unknown config type:" + type);
    }
  }
}
