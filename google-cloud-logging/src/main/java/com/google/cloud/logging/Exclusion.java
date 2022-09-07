/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.logging;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.logging.v2.LogExclusion;
import com.google.protobuf.Timestamp;
import java.util.Objects;

/**
 * Specifies a set of log entries that are not to be stored in Logging. If your GCP resource
 * receives a large volume of logs, you can use exclusions to reduce your chargeable logs.
 * Exclusions are processed after log sinks, so you can export log entries before they are excluded.
 * Note that organization-level and folder-level exclusions don't apply to child resources, and that
 * you can't exclude audit log entries.
 */
public class Exclusion {

  static final Function<LogExclusion, Exclusion> FROM_PROTOBUF_FUNCTION =
      (LogExclusion exclusionPb) -> {
        return exclusionPb != null ? Exclusion.fromProtobuf(exclusionPb) : null;
      };

  static final Function<Exclusion, LogExclusion> TO_PROTOBUF_FUNCTION =
      (Exclusion exclusion) -> {
        return exclusion != null ? exclusion.toProtobuf() : null;
      };

  private final String name;
  private final String description;
  private final String filter;
  private final boolean disabled;
  private final Timestamp createTime;
  private final Timestamp updateTime;

  /** A builder for {@code Exclusion} objects. */
  public static class Builder {

    private String name;
    private String description;
    private String filter;
    private boolean disabled;
    private Timestamp createTime;
    private Timestamp updateTime;

    private Builder(String name, String filter) {
      this.name = checkNotNull(name);
      this.filter = checkNotNull(filter);
    }

    private Builder(Exclusion exclusion) {
      this.name = exclusion.name;
      this.description = exclusion.description;
      this.filter = exclusion.filter;
      this.disabled = exclusion.disabled;
      this.createTime = exclusion.createTime;
      this.updateTime = exclusion.updateTime;
    }

    /**
     * [Required] A client-assigned identifier, such as "load-balancer-exclusion". Identifiers are
     * limited to 100 characters and can include only letters, digits, underscores, hyphens, and
     * periods. First character has to be alphanumeric.
     */
    @CanIgnoreReturnValue
    public Builder setName(String name) {
      this.name = checkNotNull(name);
      return this;
    }

    /** [Optional] A description of this exclusion. */
    @CanIgnoreReturnValue
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * [Required] An advanced logs filter that matches the log entries to be excluded. By using the
     * sample function, you can exclude less than 100% of the matching log entries.
     */
    @CanIgnoreReturnValue
    public Builder setFilter(String filter) {
      this.filter = checkNotNull(filter);
      return this;
    }

    /**
     * [Optional] If set to True, then this exclusion is disabled and it does not exclude any log
     * entries.
     */
    @CanIgnoreReturnValue
    public Builder setDisabled(boolean disabled) {
      this.disabled = disabled;
      return this;
    }

    /** [Output only] The creation timestamp of the exclusion. */
    @CanIgnoreReturnValue
    public Builder setCreateTime(Timestamp createTime) {
      this.createTime = createTime;
      return this;
    }

    /** [Output only] The last update timestamp of the exclusion. */
    @CanIgnoreReturnValue
    public Builder setUpdateTime(Timestamp updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    /** Creates a {@code Exclusion} object. */
    public Exclusion build() {
      return new Exclusion(this);
    }
  }

  Exclusion(Builder builder) {
    this.name = checkNotNull(builder.name);
    this.description = builder.description;
    this.filter = checkNotNull(builder.filter);
    this.disabled = builder.disabled;
    this.createTime = builder.createTime;
    this.updateTime = builder.updateTime;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .add("description", description)
        .add("filter", filter)
        .add("disabled", disabled)
        .add("createTime", createTime)
        .add("updateTime", updateTime)
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Exclusion)) {
      return false;
    }
    Exclusion exclusion = (Exclusion) o;
    return disabled == exclusion.disabled
        && Objects.equals(name, exclusion.name)
        && Objects.equals(description, exclusion.description)
        && Objects.equals(filter, exclusion.filter)
        && Objects.equals(createTime, exclusion.createTime)
        && Objects.equals(updateTime, exclusion.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, filter, disabled, createTime, updateTime);
  }

  /** Returns the name of log exclusion. */
  public String getName() {
    return name;
  }

  /** Returns an optional description of an exclusion. Used for documentation purpose. */
  public String getDescription() {
    return description;
  }

  /**
   * Returns an advanced logs filter. Example: {@code resource.type=gcs_bucket severity<ERROR
   * sample(insertId, 0.99)}.
   *
   * @see <a href="https://cloud.google.com/logging/docs/view/advanced-queries">Advanced Log
   *     Filters</a>
   */
  public String getFilter() {
    return filter;
  }

  /** If set to True, then this exclusion is disabled and it does not exclude any log entries. */
  public boolean isDisabled() {
    return disabled;
  }

  /** Returns the creation timestamp of the exclusion. */
  public Timestamp getCreateTime() {
    return createTime;
  }

  /** Returns the last update timestamp of the exclusion. */
  public Timestamp getUpdateTime() {
    return updateTime;
  }

  /** Returns a builder for this {@code Exclusion} object. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /**
   * Returns a builder for {@code Exclusion} objects given the name of the exclusion and its filter.
   */
  public static Builder newBuilder(String name, String filter) {
    return new Builder(name, filter);
  }

  /** Creates a {@code Exclusion} object given the name of the exclusion and its filter. */
  public static Exclusion of(String name, String filter) {
    return new Builder(name, filter).build();
  }

  LogExclusion toProtobuf() {
    LogExclusion.Builder builder =
        LogExclusion.newBuilder().setName(name).setFilter(filter).setDisabled(disabled);
    if (description != null) {
      builder.setDescription(description);
    }
    if (createTime != null) {
      builder.setCreateTime(createTime);
    }
    if (updateTime != null) {
      builder.setUpdateTime(updateTime);
    }
    return builder.build();
  }

  static Exclusion fromProtobuf(LogExclusion exclusionPb) {
    Exclusion.Builder builder = newBuilder(exclusionPb.getName(), exclusionPb.getFilter());
    builder.setDisabled(exclusionPb.getDisabled());
    if (!exclusionPb.getDescription().isEmpty()) {
      builder.setDescription(exclusionPb.getDescription());
    }
    if (exclusionPb.hasCreateTime()) {
      builder.setCreateTime(exclusionPb.getCreateTime());
    }
    if (exclusionPb.hasUpdateTime()) {
      builder.setUpdateTime(exclusionPb.getUpdateTime());
    }
    return builder.build();
  }
}
