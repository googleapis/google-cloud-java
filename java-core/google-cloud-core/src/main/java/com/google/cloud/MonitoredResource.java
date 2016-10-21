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

package com.google.cloud;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Objects of this class represent a resource that can be used for monitoring, logging, billing, or
 * other purposes. Examples include virtual machine instances, databases, and storage devices such
 * as disks. The type field identifies a {@link MonitoredResourceDescriptor} object that describes
 * the resource's schema. Information in the labels field identifies the actual resource and its
 * attributes according to the schema.
 *
 * <p>For example, the monitored resource for Google Compute Engine VM instances has
 * {@code gce_instance} type and specifies values for the labels {@code instance_id} and
 * {@code zone} to identify particular VM instances.
 */
public final class MonitoredResource implements Serializable {

  private static final long serialVersionUID = -4393604148752640581L;

  private final String type;
  private final Map<String, String> labels;

  /**
   * A builder for {@code MonitoredResource} objects.
   */
  public static class Builder {

    private String type;
    private Map<String, String> labels = new HashMap<>();

    Builder(String type) {
      this.type = type;
    }

    Builder(MonitoredResource monitoredResource) {
      this.type = monitoredResource.type;
      this.labels = new HashMap<>(monitoredResource.labels);
    }

    /**
     * Sets the monitored resource type. This value must match the one of
     * {@link MonitoredResourceDescriptor#type()} of a {@code MonitoredResourceDescriptor} object.
     * For example, the type {@code cloudsql_database} represent databases in Google Cloud SQL.
     */
    @Deprecated
    public Builder type(String type) {
      return setType(type);
    }

    /**
     * Sets the monitored resource type. This value must match the one of
     * {@link MonitoredResourceDescriptor#type()} of a {@code MonitoredResourceDescriptor} object.
     * For example, the type {@code cloudsql_database} represent databases in Google Cloud SQL.
     */
    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    /**
     * Sets the values for all the labels required by the corresponding monitored resource
     * descriptor (see {@link MonitoredResourceDescriptor#labels()}. For example, Google Compute
     * Engine VM instances use the labels {@code instance_id} and {@code zone}.
     */
    @Deprecated
    public Builder labels(Map<String, String> labels) {
      return setLabels(labels);
    }

    /**
     * Sets the values for all the labels required by the corresponding monitored resource
     * descriptor (see {@link MonitoredResourceDescriptor#labels()}. For example, Google Compute
     * Engine VM instances use the labels {@code instance_id} and {@code zone}.
     */
    public Builder setLabels(Map<String, String> labels) {
      this.labels = new HashMap<>(checkNotNull(labels));
      return this;
    }

    /**
     * Adds a label to the labels of the monitored resource.
     */
    public Builder addLabel(String key, String value) {
      this.labels.put(key, value);
      return this;
    }

    /**
     * Clears all the labels of the monitored resource.
     */
    public Builder clearLabels() {
      this.labels.clear();
      return this;
    }

    public MonitoredResource build() {
      return new MonitoredResource(this);
    }
  }

  MonitoredResource(Builder builder) {
    this.type = checkNotNull(builder.type);
    this.labels = ImmutableMap.copyOf(builder.labels);
  }

  /**
   * Returns the monitored resource type. This value must match the one of
   * {@link MonitoredResourceDescriptor#type()} of a {@code MonitoredResourceDescriptor} object.
   * For example, the type {@code cloudsql_database} represent databases in Google Cloud SQL.
   */
  @Deprecated
  public String type() {
    return getType();
  }

  /**
   * Returns the monitored resource type. This value must match the one of
   * {@link MonitoredResourceDescriptor#type()} of a {@code MonitoredResourceDescriptor} object.
   * For example, the type {@code cloudsql_database} represent databases in Google Cloud SQL.
   */
  public String getType() {
    return type;
  }

  /**
   * Returns the values for all the labels required by the corresponding monitored resource
   * descriptor (see {@link MonitoredResourceDescriptor#labels()}. For example, Google Compute
   * Engine VM instances use the labels {@code instance_id} and {@code zone}.
   */
  @Deprecated
  public Map<String, String> labels() {
    return getLabels();
  }

  /**
   * Returns the values for all the labels required by the corresponding monitored resource
   * descriptor (see {@link MonitoredResourceDescriptor#labels()}. For example, Google Compute
   * Engine VM instances use the labels {@code instance_id} and {@code zone}.
   */
  public Map<String, String> getLabels() {
    return labels;
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, labels);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof MonitoredResource)) {
      return false;
    }
    MonitoredResource other = (MonitoredResource) obj;
    return Objects.equals(type, other.type) && Objects.equals(labels, other.labels);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("type", type)
        .add("labels", labels)
        .toString();
  }

  public com.google.api.MonitoredResource toPb() {
    return com.google.api.MonitoredResource.newBuilder()
        .setType(type)
        .putAllLabels(labels)
        .build();
  }

  /**
   * Returns a builder for this {@code MonitoredResource} object.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /**
   * Returns a builder for {@code MonitoredResource} objects given the resource's type.
   */
  @Deprecated
  public static Builder builder(String type) {
    return newBuilder(type);
  }

  /**
   * Returns a builder for {@code MonitoredResource} objects given the resource's type.
   */
  public static Builder newBuilder(String type) {
    return new Builder(type);
  }

  /**
   * Creates a {@code MonitoredResource} object given the resource's type and labels.
   */
  public static MonitoredResource of(String type, Map<String, String> labels) {
    return newBuilder(type).setLabels(labels).build();
  }

  public static MonitoredResource fromPb(com.google.api.MonitoredResource descriptorPb) {
    return new Builder(descriptorPb.getType()).setLabels(descriptorPb.getLabelsMap()).build();
  }
}
