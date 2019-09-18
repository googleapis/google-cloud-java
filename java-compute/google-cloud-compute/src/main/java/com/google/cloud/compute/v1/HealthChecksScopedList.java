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
public final class HealthChecksScopedList implements ApiMessage {
  private final List<HealthCheck> healthChecks;
  private final Warning warning;

  private HealthChecksScopedList() {
    this.healthChecks = null;
    this.warning = null;
  }

  private HealthChecksScopedList(List<HealthCheck> healthChecks, Warning warning) {
    this.healthChecks = healthChecks;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("healthChecks".equals(fieldName)) {
      return healthChecks;
    }
    if ("warning".equals(fieldName)) {
      return warning;
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

  /** A list of HealthChecks contained in this scope. */
  public List<HealthCheck> getHealthChecksList() {
    return healthChecks;
  }

  /** Informational warning which replaces the list of backend services when the list is empty. */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HealthChecksScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HealthChecksScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HealthChecksScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HealthChecksScopedList();
  }

  public static class Builder {
    private List<HealthCheck> healthChecks;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(HealthChecksScopedList other) {
      if (other == HealthChecksScopedList.getDefaultInstance()) return this;
      if (other.getHealthChecksList() != null) {
        this.healthChecks = other.healthChecks;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(HealthChecksScopedList source) {
      this.healthChecks = source.healthChecks;
      this.warning = source.warning;
    }

    /** A list of HealthChecks contained in this scope. */
    public List<HealthCheck> getHealthChecksList() {
      return healthChecks;
    }

    /** A list of HealthChecks contained in this scope. */
    public Builder addAllHealthChecks(List<HealthCheck> healthChecks) {
      if (this.healthChecks == null) {
        this.healthChecks = new LinkedList<>();
      }
      this.healthChecks.addAll(healthChecks);
      return this;
    }

    /** A list of HealthChecks contained in this scope. */
    public Builder addHealthChecks(HealthCheck healthChecks) {
      if (this.healthChecks == null) {
        this.healthChecks = new LinkedList<>();
      }
      this.healthChecks.add(healthChecks);
      return this;
    }

    /** Informational warning which replaces the list of backend services when the list is empty. */
    public Warning getWarning() {
      return warning;
    }

    /** Informational warning which replaces the list of backend services when the list is empty. */
    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public HealthChecksScopedList build() {

      return new HealthChecksScopedList(healthChecks, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllHealthChecks(this.healthChecks);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HealthChecksScopedList{"
        + "healthChecks="
        + healthChecks
        + ", "
        + "warning="
        + warning
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HealthChecksScopedList) {
      HealthChecksScopedList that = (HealthChecksScopedList) o;
      return Objects.equals(this.healthChecks, that.getHealthChecksList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(healthChecks, warning);
  }
}
