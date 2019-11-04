/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.compute.deprecated;

import com.google.api.core.ApiFunction;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Google Compute Engine instance scheduling options. When there are system events that might
 * cause your instances to be disrupted, Google Compute Engine automatically manages the scheduling
 * decisions for your instances. Use {@code SchedulingOptions.preemptible()} to create a preemptible
 * instance. Use {@code SchedulingOptions.standard()} to configure scheduling options for a standard
 * instance.
 *
 * @see <a
 *     href="https://cloud.google.com/compute/docs/instances/setting-instance-scheduling-options">
 *     Setting Instance Scheduling Options</a>
 */
public final class SchedulingOptions implements Serializable {

  private static final long serialVersionUID = 4199610694227857331L;

  private final boolean automaticRestart;
  private final Maintenance maintenance;
  private final boolean isPreemptible;

  /** Defines the maintenance behavior for this instance. */
  public static final class Maintenance extends StringEnumValue {
    private static final long serialVersionUID = 1041388027965833378L;

    private static final ApiFunction<String, Maintenance> CONSTRUCTOR =
        new ApiFunction<String, Maintenance>() {
          @Override
          public Maintenance apply(String constant) {
            return new Maintenance(constant);
          }
        };

    private static final StringEnumType<Maintenance> type =
        new StringEnumType(Maintenance.class, CONSTRUCTOR);

    /** The default behavior for standard instances. */
    public static final Maintenance MIGRATE = type.createAndRegister("MIGRATE");

    /** The default and only possible behavior for preemptible instances. */
    public static final Maintenance TERMINATE = type.createAndRegister("TERMINATE");

    private Maintenance(String constant) {
      super(constant);
    }

    /**
     * Get the Maintenance for the given String constant, and throw an exception if the constant is
     * not recognized.
     */
    public static Maintenance valueOfStrict(String constant) {
      return type.valueOfStrict(constant);
    }

    /** Get the Maintenance for the given String constant, and allow unrecognized values. */
    public static Maintenance valueOf(String constant) {
      return type.valueOf(constant);
    }

    /** Return the known values for Maintenance. */
    public static Maintenance[] values() {
      return type.values();
    }
  }

  private SchedulingOptions(
      Boolean automaticRestart, Maintenance maintenance, Boolean isPreemptible) {
    this.automaticRestart = automaticRestart;
    this.maintenance = maintenance;
    this.isPreemptible = isPreemptible;
  }

  /**
   * Returns whether the instance should be automatically restarted if it is terminated by Compute
   * Engine (not terminated by a user).
   */
  public Boolean automaticRestart() {
    return automaticRestart;
  }

  /** Returns the maintenance behavior for the instance. */
  public Maintenance getMaintenance() {
    return maintenance;
  }

  /**
   * Returns {@code true} if the instance is preemptible, {@code false} otherwhise.
   *
   * @see <a href="https://cloud.google.com/compute/docs/instances/preemptible">Preemptible
   *     Instance</a>
   */
  public boolean isPreemptible() {
    return isPreemptible;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("automaticRestart", automaticRestart)
        .add("maintenance", maintenance)
        .add("isPreemptible", isPreemptible)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(automaticRestart, maintenance, isPreemptible);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof SchedulingOptions
            && Objects.equals(toPb(), ((SchedulingOptions) obj).toPb());
  }

  com.google.api.services.compute.model.Scheduling toPb() {
    com.google.api.services.compute.model.Scheduling schedulingPb =
        new com.google.api.services.compute.model.Scheduling();
    schedulingPb.setAutomaticRestart(automaticRestart);
    schedulingPb.setPreemptible(isPreemptible);
    if (maintenance != null) {
      schedulingPb.setOnHostMaintenance(maintenance.name());
    }
    return schedulingPb;
  }

  /**
   * Returns a {@code SchedulingOptions} object for a preemptible instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/instances/preemptible">Preemptible
   *     Instance</a>
   */
  public static SchedulingOptions preemptible() {
    return new SchedulingOptions(false, Maintenance.TERMINATE, true);
  }

  /**
   * Returns a {@code SchedulingOptions} object for a standard instance.
   *
   * @param automaticRestart specifies whether the instance should be automatically restarted if it
   *     is terminated by Compute Engine (not terminated by a user)
   * @param maintenance defines the maintenance behavior for the instance
   */
  public static SchedulingOptions standard(boolean automaticRestart, Maintenance maintenance) {
    return new SchedulingOptions(automaticRestart, maintenance, false);
  }

  static SchedulingOptions fromPb(com.google.api.services.compute.model.Scheduling schedPb) {
    Maintenance maintenance = null;
    if (schedPb.getOnHostMaintenance() != null) {
      maintenance = Maintenance.valueOf(schedPb.getOnHostMaintenance());
    }
    return new SchedulingOptions(
        schedPb.getAutomaticRestart(), maintenance, schedPb.getPreemptible());
  }
}
