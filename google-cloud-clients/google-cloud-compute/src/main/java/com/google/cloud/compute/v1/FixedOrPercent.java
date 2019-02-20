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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** Encapsulates numeric value that can be either absolute or relative. */
public final class FixedOrPercent implements ApiMessage {
  private final Integer calculated;
  private final Integer fixed;
  private final Integer percent;

  private FixedOrPercent() {
    this.calculated = null;
    this.fixed = null;
    this.percent = null;
  }

  private FixedOrPercent(Integer calculated, Integer fixed, Integer percent) {
    this.calculated = calculated;
    this.fixed = fixed;
    this.percent = percent;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("calculated".equals(fieldName)) {
      return calculated;
    }
    if ("fixed".equals(fieldName)) {
      return fixed;
    }
    if ("percent".equals(fieldName)) {
      return percent;
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
   * [Output Only] Absolute value of VM instances calculated based on the specific mode.
   *
   * <p>- If the value is fixed, then the caculated value is equal to the fixed value. - If the
   * value is a percent, then the calculated value is percent/100 &#42; targetSize. For example, the
   * calculated value of a 80% of a managed instance group with 150 instances would be (80/100 &#42;
   * 150) = 120 VM instances. If there is a remainder, the number is rounded up.
   */
  public Integer getCalculated() {
    return calculated;
  }

  /** Specifies a fixed number of VM instances. This must be a positive integer. */
  public Integer getFixed() {
    return fixed;
  }

  /**
   * Specifies a percentage of instances between 0 to 100%, inclusive. For example, specify 80 for
   * 80%.
   */
  public Integer getPercent() {
    return percent;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(FixedOrPercent prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static FixedOrPercent getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final FixedOrPercent DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new FixedOrPercent();
  }

  public static class Builder {
    private Integer calculated;
    private Integer fixed;
    private Integer percent;

    Builder() {}

    public Builder mergeFrom(FixedOrPercent other) {
      if (other == FixedOrPercent.getDefaultInstance()) return this;
      if (other.getCalculated() != null) {
        this.calculated = other.calculated;
      }
      if (other.getFixed() != null) {
        this.fixed = other.fixed;
      }
      if (other.getPercent() != null) {
        this.percent = other.percent;
      }
      return this;
    }

    Builder(FixedOrPercent source) {
      this.calculated = source.calculated;
      this.fixed = source.fixed;
      this.percent = source.percent;
    }

    /**
     * [Output Only] Absolute value of VM instances calculated based on the specific mode.
     *
     * <p>- If the value is fixed, then the caculated value is equal to the fixed value. - If the
     * value is a percent, then the calculated value is percent/100 &#42; targetSize. For example,
     * the calculated value of a 80% of a managed instance group with 150 instances would be (80/100
     * &#42; 150) = 120 VM instances. If there is a remainder, the number is rounded up.
     */
    public Integer getCalculated() {
      return calculated;
    }

    /**
     * [Output Only] Absolute value of VM instances calculated based on the specific mode.
     *
     * <p>- If the value is fixed, then the caculated value is equal to the fixed value. - If the
     * value is a percent, then the calculated value is percent/100 &#42; targetSize. For example,
     * the calculated value of a 80% of a managed instance group with 150 instances would be (80/100
     * &#42; 150) = 120 VM instances. If there is a remainder, the number is rounded up.
     */
    public Builder setCalculated(Integer calculated) {
      this.calculated = calculated;
      return this;
    }

    /** Specifies a fixed number of VM instances. This must be a positive integer. */
    public Integer getFixed() {
      return fixed;
    }

    /** Specifies a fixed number of VM instances. This must be a positive integer. */
    public Builder setFixed(Integer fixed) {
      this.fixed = fixed;
      return this;
    }

    /**
     * Specifies a percentage of instances between 0 to 100%, inclusive. For example, specify 80 for
     * 80%.
     */
    public Integer getPercent() {
      return percent;
    }

    /**
     * Specifies a percentage of instances between 0 to 100%, inclusive. For example, specify 80 for
     * 80%.
     */
    public Builder setPercent(Integer percent) {
      this.percent = percent;
      return this;
    }

    public FixedOrPercent build() {

      return new FixedOrPercent(calculated, fixed, percent);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCalculated(this.calculated);
      newBuilder.setFixed(this.fixed);
      newBuilder.setPercent(this.percent);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "FixedOrPercent{"
        + "calculated="
        + calculated
        + ", "
        + "fixed="
        + fixed
        + ", "
        + "percent="
        + percent
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof FixedOrPercent) {
      FixedOrPercent that = (FixedOrPercent) o;
      return Objects.equals(this.calculated, that.getCalculated())
          && Objects.equals(this.fixed, that.getFixed())
          && Objects.equals(this.percent, that.getPercent());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(calculated, fixed, percent);
  }
}
