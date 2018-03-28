/*
 * Copyright 2018 Google LLC
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class TargetPoolsAddHealthCheckRequest implements ApiMessage {
  private final List<HealthCheckReference> healthChecks;

  private TargetPoolsAddHealthCheckRequest() {
    this.healthChecks = null;
  }


  private TargetPoolsAddHealthCheckRequest(
      List<HealthCheckReference> healthChecks
      ) {
    this.healthChecks = healthChecks;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("healthChecks") && healthChecks != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (HealthCheckReference item : healthChecks) {
        stringList.add(item.toString());
      }
      fieldMap.put("healthChecks", stringList.build());
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("healthChecks")) {
      return String.valueOf(healthChecks);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public List<HealthCheckReference> getHealthChecksList() {
    return healthChecks;
  }


  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(TargetPoolsAddHealthCheckRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetPoolsAddHealthCheckRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  private static final TargetPoolsAddHealthCheckRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new TargetPoolsAddHealthCheckRequest();
  }

  public static class Builder {
    private List<HealthCheckReference> healthChecks;

    Builder() {}

    public Builder mergeFrom(TargetPoolsAddHealthCheckRequest other) {
      if (other == TargetPoolsAddHealthCheckRequest.getDefaultInstance()) return this;
      if (other.getHealthChecksList() != null) {
        this.healthChecks = other.healthChecks;
      }
      return this;
    }

    Builder(TargetPoolsAddHealthCheckRequest source) {
      this.healthChecks = source.healthChecks;
    }

    public List<HealthCheckReference> getHealthChecksList() {
      return healthChecks;
    }

    public Builder addAllHealthChecks(List<HealthCheckReference> healthChecks) {
      if (this.healthChecks == null) {
        this.healthChecks = new ArrayList<>(healthChecks.size());
      }
      this.healthChecks.addAll(healthChecks);
      return this;
    }

    public Builder addHealthChecks(HealthCheckReference healthChecks) {
      this.healthChecks.add(healthChecks);
      return this;
    }


    public TargetPoolsAddHealthCheckRequest build() {
      return new TargetPoolsAddHealthCheckRequest(
        healthChecks
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllHealthChecks(this.healthChecks);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetPoolsAddHealthCheckRequest{"
        + "healthChecks=" + healthChecks
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetPoolsAddHealthCheckRequest) {
      TargetPoolsAddHealthCheckRequest that = (TargetPoolsAddHealthCheckRequest) o;
      return
          Objects.equals(this.healthChecks, that.getHealthChecksList())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      healthChecks
    );
  }
}
