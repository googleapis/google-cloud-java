/*
 * Copyright 2020 Google LLC
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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * Configuration that allows for slower scale in so that even if Autoscaler recommends an abrupt
 * scale in of a MIG, it will be throttled as specified by the parameters below.
 */
public final class AutoscalingPolicyScaleInControl implements ApiMessage {
  private final FixedOrPercent maxScaledInReplicas;
  private final Integer timeWindowSec;

  private AutoscalingPolicyScaleInControl() {
    this.maxScaledInReplicas = null;
    this.timeWindowSec = null;
  }

  private AutoscalingPolicyScaleInControl(
      FixedOrPercent maxScaledInReplicas, Integer timeWindowSec) {
    this.maxScaledInReplicas = maxScaledInReplicas;
    this.timeWindowSec = timeWindowSec;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("maxScaledInReplicas".equals(fieldName)) {
      return maxScaledInReplicas;
    }
    if ("timeWindowSec".equals(fieldName)) {
      return timeWindowSec;
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
   * Maximum allowed number (or %) of VMs that can be deducted from the peak recommendation during
   * the window autoscaler looks at when computing recommendations. Possibly all these VMs can be
   * deleted at once so user service needs to be prepared to lose that many VMs in one step.
   */
  public FixedOrPercent getMaxScaledInReplicas() {
    return maxScaledInReplicas;
  }

  /**
   * How long back autoscaling should look when computing recommendations to include directives
   * regarding slower scale in, as described above.
   */
  public Integer getTimeWindowSec() {
    return timeWindowSec;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AutoscalingPolicyScaleInControl prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AutoscalingPolicyScaleInControl getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AutoscalingPolicyScaleInControl DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AutoscalingPolicyScaleInControl();
  }

  public static class Builder {
    private FixedOrPercent maxScaledInReplicas;
    private Integer timeWindowSec;

    Builder() {}

    public Builder mergeFrom(AutoscalingPolicyScaleInControl other) {
      if (other == AutoscalingPolicyScaleInControl.getDefaultInstance()) return this;
      if (other.getMaxScaledInReplicas() != null) {
        this.maxScaledInReplicas = other.maxScaledInReplicas;
      }
      if (other.getTimeWindowSec() != null) {
        this.timeWindowSec = other.timeWindowSec;
      }
      return this;
    }

    Builder(AutoscalingPolicyScaleInControl source) {
      this.maxScaledInReplicas = source.maxScaledInReplicas;
      this.timeWindowSec = source.timeWindowSec;
    }

    /**
     * Maximum allowed number (or %) of VMs that can be deducted from the peak recommendation during
     * the window autoscaler looks at when computing recommendations. Possibly all these VMs can be
     * deleted at once so user service needs to be prepared to lose that many VMs in one step.
     */
    public FixedOrPercent getMaxScaledInReplicas() {
      return maxScaledInReplicas;
    }

    /**
     * Maximum allowed number (or %) of VMs that can be deducted from the peak recommendation during
     * the window autoscaler looks at when computing recommendations. Possibly all these VMs can be
     * deleted at once so user service needs to be prepared to lose that many VMs in one step.
     */
    public Builder setMaxScaledInReplicas(FixedOrPercent maxScaledInReplicas) {
      this.maxScaledInReplicas = maxScaledInReplicas;
      return this;
    }

    /**
     * How long back autoscaling should look when computing recommendations to include directives
     * regarding slower scale in, as described above.
     */
    public Integer getTimeWindowSec() {
      return timeWindowSec;
    }

    /**
     * How long back autoscaling should look when computing recommendations to include directives
     * regarding slower scale in, as described above.
     */
    public Builder setTimeWindowSec(Integer timeWindowSec) {
      this.timeWindowSec = timeWindowSec;
      return this;
    }

    public AutoscalingPolicyScaleInControl build() {

      return new AutoscalingPolicyScaleInControl(maxScaledInReplicas, timeWindowSec);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setMaxScaledInReplicas(this.maxScaledInReplicas);
      newBuilder.setTimeWindowSec(this.timeWindowSec);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AutoscalingPolicyScaleInControl{"
        + "maxScaledInReplicas="
        + maxScaledInReplicas
        + ", "
        + "timeWindowSec="
        + timeWindowSec
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AutoscalingPolicyScaleInControl) {
      AutoscalingPolicyScaleInControl that = (AutoscalingPolicyScaleInControl) o;
      return Objects.equals(this.maxScaledInReplicas, that.getMaxScaledInReplicas())
          && Objects.equals(this.timeWindowSec, that.getTimeWindowSec());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxScaledInReplicas, timeWindowSec);
  }
}
