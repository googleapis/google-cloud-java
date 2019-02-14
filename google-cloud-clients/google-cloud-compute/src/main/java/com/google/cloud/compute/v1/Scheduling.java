/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** Sets the scheduling options for an Instance. */
public final class Scheduling implements ApiMessage {
  private final Boolean automaticRestart;
  private final List<SchedulingNodeAffinity> nodeAffinities;
  private final String onHostMaintenance;
  private final Boolean preemptible;

  private Scheduling() {
    this.automaticRestart = null;
    this.nodeAffinities = null;
    this.onHostMaintenance = null;
    this.preemptible = null;
  }

  private Scheduling(
      Boolean automaticRestart,
      List<SchedulingNodeAffinity> nodeAffinities,
      String onHostMaintenance,
      Boolean preemptible) {
    this.automaticRestart = automaticRestart;
    this.nodeAffinities = nodeAffinities;
    this.onHostMaintenance = onHostMaintenance;
    this.preemptible = preemptible;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("automaticRestart".equals(fieldName)) {
      return automaticRestart;
    }
    if ("nodeAffinities".equals(fieldName)) {
      return nodeAffinities;
    }
    if ("onHostMaintenance".equals(fieldName)) {
      return onHostMaintenance;
    }
    if ("preemptible".equals(fieldName)) {
      return preemptible;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /**
   * Specifies whether the instance should be automatically restarted if it is terminated by Compute
   * Engine (not terminated by a user). You can only set the automatic restart option for standard
   * instances. Preemptible instances cannot be automatically restarted.
   *
   * <p>By default, this is set to true so an instance is automatically restarted if it is
   * terminated by Compute Engine.
   */
  public Boolean getAutomaticRestart() {
    return automaticRestart;
  }

  /** A set of node affinity and anti-affinity. */
  public List<SchedulingNodeAffinity> getNodeAffinitiesList() {
    return nodeAffinities;
  }

  /**
   * Defines the maintenance behavior for this instance. For standard instances, the default
   * behavior is MIGRATE. For preemptible instances, the default and only possible behavior is
   * TERMINATE. For more information, see Setting Instance Scheduling Options.
   */
  public String getOnHostMaintenance() {
    return onHostMaintenance;
  }

  /**
   * Defines whether the instance is preemptible. This can only be set during instance creation, it
   * cannot be set or changed after the instance has been created.
   */
  public Boolean getPreemptible() {
    return preemptible;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Scheduling prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Scheduling getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Scheduling DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Scheduling();
  }

  public static class Builder {
    private Boolean automaticRestart;
    private List<SchedulingNodeAffinity> nodeAffinities;
    private String onHostMaintenance;
    private Boolean preemptible;

    Builder() {}

    public Builder mergeFrom(Scheduling other) {
      if (other == Scheduling.getDefaultInstance()) return this;
      if (other.getAutomaticRestart() != null) {
        this.automaticRestart = other.automaticRestart;
      }
      if (other.getNodeAffinitiesList() != null) {
        this.nodeAffinities = other.nodeAffinities;
      }
      if (other.getOnHostMaintenance() != null) {
        this.onHostMaintenance = other.onHostMaintenance;
      }
      if (other.getPreemptible() != null) {
        this.preemptible = other.preemptible;
      }
      return this;
    }

    Builder(Scheduling source) {
      this.automaticRestart = source.automaticRestart;
      this.nodeAffinities = source.nodeAffinities;
      this.onHostMaintenance = source.onHostMaintenance;
      this.preemptible = source.preemptible;
    }

    /**
     * Specifies whether the instance should be automatically restarted if it is terminated by
     * Compute Engine (not terminated by a user). You can only set the automatic restart option for
     * standard instances. Preemptible instances cannot be automatically restarted.
     *
     * <p>By default, this is set to true so an instance is automatically restarted if it is
     * terminated by Compute Engine.
     */
    public Boolean getAutomaticRestart() {
      return automaticRestart;
    }

    /**
     * Specifies whether the instance should be automatically restarted if it is terminated by
     * Compute Engine (not terminated by a user). You can only set the automatic restart option for
     * standard instances. Preemptible instances cannot be automatically restarted.
     *
     * <p>By default, this is set to true so an instance is automatically restarted if it is
     * terminated by Compute Engine.
     */
    public Builder setAutomaticRestart(Boolean automaticRestart) {
      this.automaticRestart = automaticRestart;
      return this;
    }

    /** A set of node affinity and anti-affinity. */
    public List<SchedulingNodeAffinity> getNodeAffinitiesList() {
      return nodeAffinities;
    }

    /** A set of node affinity and anti-affinity. */
    public Builder addAllNodeAffinities(List<SchedulingNodeAffinity> nodeAffinities) {
      if (this.nodeAffinities == null) {
        this.nodeAffinities = new LinkedList<>();
      }
      this.nodeAffinities.addAll(nodeAffinities);
      return this;
    }

    /** A set of node affinity and anti-affinity. */
    public Builder addNodeAffinities(SchedulingNodeAffinity nodeAffinities) {
      if (this.nodeAffinities == null) {
        this.nodeAffinities = new LinkedList<>();
      }
      this.nodeAffinities.add(nodeAffinities);
      return this;
    }

    /**
     * Defines the maintenance behavior for this instance. For standard instances, the default
     * behavior is MIGRATE. For preemptible instances, the default and only possible behavior is
     * TERMINATE. For more information, see Setting Instance Scheduling Options.
     */
    public String getOnHostMaintenance() {
      return onHostMaintenance;
    }

    /**
     * Defines the maintenance behavior for this instance. For standard instances, the default
     * behavior is MIGRATE. For preemptible instances, the default and only possible behavior is
     * TERMINATE. For more information, see Setting Instance Scheduling Options.
     */
    public Builder setOnHostMaintenance(String onHostMaintenance) {
      this.onHostMaintenance = onHostMaintenance;
      return this;
    }

    /**
     * Defines whether the instance is preemptible. This can only be set during instance creation,
     * it cannot be set or changed after the instance has been created.
     */
    public Boolean getPreemptible() {
      return preemptible;
    }

    /**
     * Defines whether the instance is preemptible. This can only be set during instance creation,
     * it cannot be set or changed after the instance has been created.
     */
    public Builder setPreemptible(Boolean preemptible) {
      this.preemptible = preemptible;
      return this;
    }

    public Scheduling build() {

      return new Scheduling(automaticRestart, nodeAffinities, onHostMaintenance, preemptible);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAutomaticRestart(this.automaticRestart);
      newBuilder.addAllNodeAffinities(this.nodeAffinities);
      newBuilder.setOnHostMaintenance(this.onHostMaintenance);
      newBuilder.setPreemptible(this.preemptible);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Scheduling{"
        + "automaticRestart="
        + automaticRestart
        + ", "
        + "nodeAffinities="
        + nodeAffinities
        + ", "
        + "onHostMaintenance="
        + onHostMaintenance
        + ", "
        + "preemptible="
        + preemptible
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Scheduling) {
      Scheduling that = (Scheduling) o;
      return Objects.equals(this.automaticRestart, that.getAutomaticRestart())
          && Objects.equals(this.nodeAffinities, that.getNodeAffinitiesList())
          && Objects.equals(this.onHostMaintenance, that.getOnHostMaintenance())
          && Objects.equals(this.preemptible, that.getPreemptible());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(automaticRestart, nodeAffinities, onHostMaintenance, preemptible);
  }
}
