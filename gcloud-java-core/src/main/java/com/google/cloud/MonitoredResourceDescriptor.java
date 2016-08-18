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

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class describes the schema of Cloud monitored resources. Monitored resource descriptors
 * contain a type name and a set of labels. For example, the monitored resource descriptor for
 * Google Compute Engine VM instances has a type of {@code gce_instance} and specifies the use of
 * the labels {@code instance_id} and {@code zone} to identify particular VM instances.
 */
public class MonitoredResourceDescriptor implements Serializable {

  private static final long serialVersionUID = -3702077512777687441L;
  public static final Function<com.google.api.MonitoredResourceDescriptor,
      MonitoredResourceDescriptor> FROM_PB_FUNCTION =
      new Function<com.google.api.MonitoredResourceDescriptor, MonitoredResourceDescriptor>() {
        @Override
        public MonitoredResourceDescriptor apply(
            com.google.api.MonitoredResourceDescriptor pb) {
          return fromPb(pb);
        }
      };

  private final String type;
  private final String name;
  private final String displayName;
  private final String description;
  private final List<LabelDescriptor> labels;

  /**
   * This class describes a label for a monitored resource. Label descriptors contain the key for
   * the label, the type of data that the label can hold and an optional description.
   */
  public static class LabelDescriptor implements Serializable {

    private static final long serialVersionUID = -2811608103754481777L;
    private static final Function<com.google.api.LabelDescriptor, LabelDescriptor>
        FROM_PB_FUNCTION = new Function<com.google.api.LabelDescriptor, LabelDescriptor>() {
          @Override
          public LabelDescriptor apply(com.google.api.LabelDescriptor descriptorPb) {
            return fromPb(descriptorPb);
          }
        };
    private static final Function<LabelDescriptor, com.google.api.LabelDescriptor>
        TO_PB_FUNCTION = new Function<LabelDescriptor, com.google.api.LabelDescriptor>() {
          @Override
          public com.google.api.LabelDescriptor apply(LabelDescriptor descriptor) {
            return descriptor.toPb();
          }
        };

    private final String key;
    private final ValueType valueType;
    private final String description;

    /**
     * Value types that can be used as label values.
     */
    public enum ValueType {
      STRING(com.google.api.LabelDescriptor.ValueType.STRING),
      BOOL(com.google.api.LabelDescriptor.ValueType.BOOL),
      INT64(com.google.api.LabelDescriptor.ValueType.INT64);

      private com.google.api.LabelDescriptor.ValueType typePb;

      ValueType(com.google.api.LabelDescriptor.ValueType typePb) {
        this.typePb = typePb;
      }

      com.google.api.LabelDescriptor.ValueType toPb() {
        return typePb;
      }

      static ValueType fromPb(com.google.api.LabelDescriptor.ValueType typePb) {
        switch (typePb) {
          case STRING:
            return ValueType.STRING;
          case BOOL:
            return ValueType.BOOL;
          case INT64:
            return ValueType.INT64;
          default:
            throw new IllegalArgumentException("Unrecognized label type");
        }
      }
    }

    LabelDescriptor(String key, ValueType valueType, String description) {
      this.key = checkNotNull(key);
      this.valueType = checkNotNull(valueType);
      this.description = description;
    }

    /**
     * Returns the key associated to this label.
     */
    public String key() {
      return key;
    }

    /**
     * Returns the type of data that can be assigned to this label.
     */
    public ValueType valueType() {
      return valueType;
    }

    /**
     * Returns the optional human-readable description for this label. If not set, this method
     * returns {@code null}.
     */
    public String description() {
      return description;
    }

    @Override
    public final int hashCode() {
      return Objects.hash(key, valueType, description);
    }

    @Override
    public final boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (obj == null || !obj.getClass().equals(LabelDescriptor.class)) {
        return false;
      }
      LabelDescriptor other = (LabelDescriptor) obj;
      return Objects.equals(key, other.key)
          && Objects.equals(valueType, other.valueType)
          && Objects.equals(description, other.description);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("key", key)
          .add("valueType", valueType)
          .add("description", description)
          .toString();
    }

    com.google.api.LabelDescriptor toPb() {
      com.google.api.LabelDescriptor.Builder builder = com.google.api.LabelDescriptor.newBuilder()
          .setKey(key)
          .setValueType(valueType.toPb());
      if (description != null) {
        builder.setDescription(description);
      }
      return builder.build();
    }

    static LabelDescriptor fromPb(com.google.api.LabelDescriptor descriptorPb) {
      String description = null;
      if (descriptorPb.getDescription() != null && !descriptorPb.getDescription().equals("")) {
        description = descriptorPb.getDescription();
      }
      return new LabelDescriptor(descriptorPb.getKey(),
          ValueType.fromPb(descriptorPb.getValueType()), description);
    }
  }

  static class Builder {

    private final String type;
    private String name;
    private String displayName;
    private String description;
    private List<LabelDescriptor> labels = new ArrayList<>();

    Builder(String type) {
      this.type = type;
    }

    Builder name(String name) {
      this.name = name;
      return this;
    }

    Builder displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    Builder description(String description) {
      this.description = description;
      return this;
    }

    Builder labels(List<LabelDescriptor> labels) {
      this.labels = labels;
      return this;
    }

    MonitoredResourceDescriptor build() {
      return new MonitoredResourceDescriptor(this);
    }
  }

  MonitoredResourceDescriptor(Builder builder) {
    this.type = checkNotNull(builder.type);
    this.name = builder.name;
    this.displayName = builder.displayName;
    this.description = builder.description;
    this.labels = checkNotNull(builder.labels);
  }

  /**
   * Returns the monitored resource type. For example, the type {@code cloudsql_database} represents
   * databases in Google Cloud SQL.
   */
  public String type() {
    return type;
  }

  /**
   * Returns an optional name for the monitored resource descriptor. If not set, this method returns
   * {@code null}.
   */
  public String name() {
    return name;
  }

  /**
   * Returns an optional concise name for the monitored resource type. This value might be displayed
   * in user interfaces. For example, {@code Google Cloud SQL Database}. If not set, this method
   * returns {@code null}.
   */
  public String displayName() {
    return displayName;
  }

  /**
   * Returns an optional detailed description of the monitored resource type. This value might be
   * used in documentation. If not set, this method returns {@code null}.
   */
  public String description() {
    return description;
  }

  /**
   * Returns a list of labels used to describe instances of this monitored resource type. For
   * example, an individual Google Cloud SQL database is identified by values for the labels
   * {@code database_id} and {@code region}.
   */
  public List<LabelDescriptor> labels() {
    return labels;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(type, name, displayName, description, labels);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(MonitoredResourceDescriptor.class)) {
      return false;
    }
    MonitoredResourceDescriptor other = (MonitoredResourceDescriptor) obj;
    return Objects.equals(type, other.type)
        && Objects.equals(name, other.name)
        && Objects.equals(displayName, other.displayName)
        && Objects.equals(description, other.description)
        && Objects.equals(labels, other.labels);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("type", type)
        .add("name", name)
        .add("displayName", displayName)
        .add("description", description)
        .add("labels", labels)
        .toString();
  }

  public com.google.api.MonitoredResourceDescriptor toPb() {
    com.google.api.MonitoredResourceDescriptor.Builder builder =
        com.google.api.MonitoredResourceDescriptor.newBuilder()
            .setType(type)
            .addAllLabels(Iterables.transform(labels, LabelDescriptor.TO_PB_FUNCTION));
    if (name != null) {
      builder.setName(name);
    }
    if (displayName != null) {
      builder.setDisplayName(displayName);
    }
    if (description != null) {
      builder.setDescription(description);
    }
    return builder.build();
  }

  static Builder builder(String type) {
    return new Builder(type);
  }

  public static MonitoredResourceDescriptor fromPb(
      com.google.api.MonitoredResourceDescriptor descriptorPb) {
    Builder builder = builder(descriptorPb.getType());
    if (descriptorPb.getName() != null && !descriptorPb.getName().equals("")) {
      builder.name(descriptorPb.getName());
    }
    if (descriptorPb.getDisplayName() != null && !descriptorPb.getDisplayName().equals("")) {
      builder.displayName(descriptorPb.getDisplayName());
    }
    if (descriptorPb.getDescription() != null && !descriptorPb.getDescription().equals("")) {
      builder.description(descriptorPb.getDescription());
    }
    builder.labels(Lists.transform(descriptorPb.getLabelsList(), LabelDescriptor.FROM_PB_FUNCTION));
    return builder.build();
  }
}
