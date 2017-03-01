/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.FieldMask;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Represents a Cloud Spanner Instance. */
public class InstanceInfo {

  /** Represent an updatable field in Cloud Spanner instance. */
  public enum InstanceField implements FieldSelector {
    DISPLAY_NAME("display_name"),
    NODE_COUNT("node_count"),
    LABELS("labels");

    private final String selector;

    InstanceField(String selector) {
      this.selector = selector;
    }

    @Override
    @Deprecated
    public String selector() {
      return getSelector();
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
  public static enum State {
    UNSPECIFIED,
    CREATING,
    READY
  }

  /** Builder for {@code InstanceInfo}. */
  public abstract static class Builder {
    public abstract Builder setInstanceConfigId(InstanceConfigId configId);

    public abstract Builder setDisplayName(String displayName);

    public abstract Builder setNodeCount(int nodeCount);

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
    private State state;
    private Map<String, String> labels;

    BuilderImpl(InstanceId id) {
      this.id = id;
      this.labels = new HashMap<>();
    }

    BuilderImpl(InstanceInfo instance) {
      this.id = instance.id;
      this.configId = instance.configId;
      this.displayName = instance.displayName;
      this.nodeCount = instance.nodeCount;
      this.state = instance.state;
      this.labels = new HashMap<>(instance.labels);
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
    public BuilderImpl setNodeCount(int nodeCount) {
      this.nodeCount = nodeCount;
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
  private final State state;
  private final ImmutableMap<String, String> labels;

  InstanceInfo(BuilderImpl builder) {
    this.id = builder.id;
    this.configId = builder.configId;
    this.displayName = builder.displayName;
    this.nodeCount = builder.nodeCount;
    this.state = builder.state;
    this.labels = ImmutableMap.copyOf(builder.labels);
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

  /** Returns the node count of the instance. */
  public int getNodeCount() {
    return nodeCount;
  }

  /** Returns the current state of the instance. */
  public State getState() {
    return state;
  }

  /** Returns the cloud labels attached to this instance. */
  public ImmutableMap<String, String> getLabels() {
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
        .add("state", state)
        .add("labels", labels)
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
        && state == that.state
        && Objects.equals(labels, that.labels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, configId, displayName, nodeCount, state, labels);
  }

  com.google.spanner.admin.instance.v1.Instance toProto() {
    com.google.spanner.admin.instance.v1.Instance.Builder builder =
        com.google.spanner.admin.instance.v1.Instance.newBuilder()
            .setName(getId().getName())
            .setNodeCount(getNodeCount())
            .putAllLabels(getLabels());
    if (getDisplayName() != null) {
      builder.setDisplayName(getDisplayName());
    }
    if (getInstanceConfigId() != null) {
      builder.setConfig(getInstanceConfigId().getName());
    }
    return builder.build();
  }

  public static Builder newBuilder(InstanceId id) {
    return new BuilderImpl(checkNotNull(id));
  }
}
