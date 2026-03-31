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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.FieldSelector;
import com.google.cloud.Timestamp;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.instance.v1.AutoscalingConfig;
import com.google.spanner.admin.instance.v1.Instance.Edition;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Represents a Cloud Spanner Instance. */
public class InstanceInfo {

  /** Represent an updatable field in Cloud Spanner instance. */
  public enum InstanceField implements FieldSelector {
    DISPLAY_NAME("display_name"),
    NODE_COUNT("node_count"),
    PROCESSING_UNITS("processing_units"),
    AUTOSCALING_CONFIG("autoscaling_config"),
    EDITION("edition"),
    LABELS("labels");

    static InstanceField[] defaultFieldsToUpdate(InstanceInfo info) {
      if (info.getAutoscalingConfig() != null) {
        return new InstanceField[] {DISPLAY_NAME, AUTOSCALING_CONFIG, LABELS};
      } else if (info.getNodeCount() > 0) {
        return new InstanceField[] {DISPLAY_NAME, AUTOSCALING_CONFIG, NODE_COUNT, LABELS};
      } else {
        return new InstanceField[] {DISPLAY_NAME, AUTOSCALING_CONFIG, PROCESSING_UNITS, LABELS};
      }
    }

    private final String selector;

    InstanceField(String selector) {
      this.selector = selector;
    }

    @Override
    public String getSelector() {
      return selector;
    }

    static FieldMask toFieldMask(InstanceField... fields) {
      FieldMask.Builder builder = FieldMask.newBuilder();
      for (InstanceField field : fields) {
        builder.addPaths(field.getSelector());
      }
      return builder.build();
    }
  }

  /** State of the Instance. */
  public enum State {
    UNSPECIFIED,
    CREATING,
    READY
  }

  /** Builder for {@code InstanceInfo}. */
  public abstract static class Builder {
    public abstract Builder setInstanceConfigId(InstanceConfigId configId);

    public abstract Builder setDisplayName(String displayName);

    Builder setUpdateTime(Timestamp updateTime) {
      throw new UnsupportedOperationException("Unimplemented");
    }

    Builder setCreateTime(Timestamp createTime) {
      throw new UnsupportedOperationException("Unimplemented");
    }

    /**
     * Sets the number of nodes for the instance. Exactly one of processing units, node count or
     * autoscaling config must be set when creating a new instance.
     */
    public abstract Builder setNodeCount(int nodeCount);

    /**
     * Sets the number of processing units for the instance. Exactly one of processing units, node
     * count, or autoscaling config must be set when creating a new instance. Processing units must
     * be between 1 and 999 (inclusive) when creating a new instance with node count = 0. Processing
     * units from 1000 and up must always be a multiple of 1000 (that is equal to an integer number
     * of nodes).
     */
    public Builder setProcessingUnits(int processingUnits) {
      throw new UnsupportedOperationException("Unimplemented");
    }

    /**
     * Sets the autoscaling config for the instance, which will enable the autoscaling for this
     * instance. Exactly one of processing units, node count, or autoscaling config must be set when
     * creating a new instance.
     */
    public Builder setAutoscalingConfig(AutoscalingConfig autoscalingConfig) {
      throw new UnsupportedOperationException("Unimplemented");
    }

    public Builder setEdition(Edition edition) {
      throw new UnsupportedOperationException("Unimplemented");
    }

    public abstract Builder setState(State state);

    public abstract Builder addLabel(String key, String value);

    public abstract Builder putAllLabels(Map<String, String> labels);

    public abstract InstanceInfo build();
  }

  static class BuilderImpl extends Builder {
    private InstanceId id;
    private InstanceConfigId configId;
    private String displayName;
    private int nodeCount;
    private int processingUnits;
    private AutoscalingConfig autoscalingConfig;
    private Edition edition;
    private State state;
    private Map<String, String> labels;
    private Timestamp updateTime;
    private Timestamp createTime;

    BuilderImpl(InstanceId id) {
      this.id = id;
      this.labels = new HashMap<>();
    }

    BuilderImpl(InstanceInfo instance) {
      this.id = instance.id;
      this.configId = instance.configId;
      this.displayName = instance.displayName;
      this.nodeCount = instance.nodeCount;
      this.processingUnits = instance.processingUnits;
      this.autoscalingConfig = instance.autoscalingConfig;
      this.state = instance.state;
      this.labels = new HashMap<>(instance.labels);
      this.updateTime = instance.updateTime;
      this.createTime = instance.createTime;
      this.edition = instance.edition;
    }

    @Override
    public BuilderImpl setInstanceConfigId(InstanceConfigId configId) {
      this.configId = configId;
      return this;
    }

    @Override
    public BuilderImpl setDisplayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    @Override
    Builder setUpdateTime(Timestamp updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    @Override
    Builder setCreateTime(Timestamp createTime) {
      this.createTime = createTime;
      return this;
    }

    @Override
    public BuilderImpl setNodeCount(int nodeCount) {
      this.nodeCount = nodeCount;
      return this;
    }

    @Override
    public BuilderImpl setProcessingUnits(int processingUnits) {
      this.processingUnits = processingUnits;
      return this;
    }

    @Override
    public BuilderImpl setAutoscalingConfig(AutoscalingConfig autoscalingConfig) {
      this.autoscalingConfig = autoscalingConfig;
      return this;
    }

    @Override
    public BuilderImpl setEdition(Edition edition) {
      this.edition = edition;
      return this;
    }

    @Override
    public BuilderImpl setState(State state) {
      this.state = state;
      return this;
    }

    @Override
    public BuilderImpl addLabel(String key, String value) {
      labels.put(key, value);
      return this;
    }

    @Override
    public BuilderImpl putAllLabels(Map<String, String> labels) {
      this.labels.putAll(labels);
      return this;
    }

    @Override
    public InstanceInfo build() {
      return new InstanceInfo(this);
    }
  }

  private final InstanceId id;
  private final InstanceConfigId configId;
  private final String displayName;
  private final int nodeCount;
  private final int processingUnits;
  private final AutoscalingConfig autoscalingConfig;
  private final Edition edition;
  private final State state;
  private final ImmutableMap<String, String> labels;
  private final Timestamp updateTime;
  private final Timestamp createTime;

  InstanceInfo(BuilderImpl builder) {
    this.id = builder.id;
    this.configId = builder.configId;
    this.displayName = builder.displayName;
    this.nodeCount = builder.nodeCount;
    this.processingUnits = builder.processingUnits;
    this.autoscalingConfig = builder.autoscalingConfig;
    this.edition = builder.edition;
    this.state = builder.state;
    this.labels = ImmutableMap.copyOf(builder.labels);
    this.updateTime = builder.updateTime;
    this.createTime = builder.createTime;
  }

  /** Returns the identifier of the instance. */
  public InstanceId getId() {
    return id;
  }

  /** Returns the identifier of the instance configuration. */
  public InstanceConfigId getInstanceConfigId() {
    return configId;
  }

  /** Returns the display name of the instance. */
  public String getDisplayName() {
    return displayName;
  }

  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  /** Returns the node count of the instance. */
  public int getNodeCount() {
    return nodeCount;
  }

  /** Returns the number of processing units of the instance. */
  public int getProcessingUnits() {
    return processingUnits;
  }

  /** Returns the autoscaling config of the instance. */
  public AutoscalingConfig getAutoscalingConfig() {
    return autoscalingConfig;
  }

  public Edition getEdition() {
    return edition;
  }

  /** Returns the current state of the instance. */
  public State getState() {
    return state;
  }

  /** Returns the cloud labels attached to this instance. */
  public Map<String, String> getLabels() {
    return labels;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", id.getName())
        .add("configName", configId == null ? null : configId.getName())
        .add("displayName", displayName)
        .add("nodeCount", nodeCount)
        .add("processingUnits", processingUnits)
        .add("autoscaling_config", autoscalingConfig)
        .add("edition", edition)
        .add("state", state)
        .add("labels", labels)
        .add("createTime", createTime)
        .add("updateTime", updateTime)
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstanceInfo that = (InstanceInfo) o;
    return id.equals(that.id)
        && Objects.equals(configId, that.configId)
        && Objects.equals(displayName, that.displayName)
        && nodeCount == that.nodeCount
        && processingUnits == that.processingUnits
        && Objects.equals(autoscalingConfig, that.autoscalingConfig)
        && edition == that.edition
        && state == that.state
        && Objects.equals(labels, that.labels)
        && Objects.equals(updateTime, that.updateTime)
        && Objects.equals(createTime, that.createTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        configId,
        displayName,
        nodeCount,
        processingUnits,
        autoscalingConfig,
        edition,
        state,
        labels,
        updateTime,
        createTime);
  }

  com.google.spanner.admin.instance.v1.Instance toProto() {
    com.google.spanner.admin.instance.v1.Instance.Builder builder =
        com.google.spanner.admin.instance.v1.Instance.newBuilder()
            .setName(getId().getName())
            .setNodeCount(getNodeCount())
            .setProcessingUnits(getProcessingUnits())
            .putAllLabels(getLabels());
    if (getDisplayName() != null) {
      builder.setDisplayName(getDisplayName());
    }
    if (getInstanceConfigId() != null) {
      builder.setConfig(getInstanceConfigId().getName());
    }
    if (getAutoscalingConfig() != null) {
      builder.setAutoscalingConfig(getAutoscalingConfig());
    }
    if (getEdition() != null) {
      builder.setEdition(getEdition());
    }
    return builder.build();
  }

  public static Builder newBuilder(InstanceId id) {
    return new BuilderImpl(checkNotNull(id));
  }
}
