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
public final class TargetVpnGatewaysScopedList implements ApiMessage {
  private final List<TargetVpnGateway> targetVpnGateways;
  private final Warning warning;

  private TargetVpnGatewaysScopedList() {
    this.targetVpnGateways = null;
    this.warning = null;
  }

  private TargetVpnGatewaysScopedList(List<TargetVpnGateway> targetVpnGateways, Warning warning) {
    this.targetVpnGateways = targetVpnGateways;
    this.warning = warning;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("targetVpnGateways") && targetVpnGateways != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (TargetVpnGateway item : targetVpnGateways) {
        stringList.add(item.toString());
      }
      fieldMap.put("targetVpnGateways", stringList.build());
    }
    if (fieldNames.contains("warning") && warning != null) {
      fieldMap.put("warning", Collections.singletonList(String.valueOf(warning)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("targetVpnGateways")) {
      return String.valueOf(targetVpnGateways);
    }
    if (fieldName.equals("warning")) {
      return String.valueOf(warning);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public List<TargetVpnGateway> getTargetVpnGatewaysList() {
    return targetVpnGateways;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetVpnGatewaysScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetVpnGatewaysScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetVpnGatewaysScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetVpnGatewaysScopedList();
  }

  public static class Builder {
    private List<TargetVpnGateway> targetVpnGateways;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(TargetVpnGatewaysScopedList other) {
      if (other == TargetVpnGatewaysScopedList.getDefaultInstance()) return this;
      if (other.getTargetVpnGatewaysList() != null) {
        this.targetVpnGateways = other.targetVpnGateways;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(TargetVpnGatewaysScopedList source) {
      this.targetVpnGateways = source.targetVpnGateways;
      this.warning = source.warning;
    }

    public List<TargetVpnGateway> getTargetVpnGatewaysList() {
      return targetVpnGateways;
    }

    public Builder addAllTargetVpnGateways(List<TargetVpnGateway> targetVpnGateways) {
      if (this.targetVpnGateways == null) {
        this.targetVpnGateways = new ArrayList<>(targetVpnGateways.size());
      }
      this.targetVpnGateways.addAll(targetVpnGateways);
      return this;
    }

    public Builder addTargetVpnGateways(TargetVpnGateway targetVpnGateways) {
      this.targetVpnGateways.add(targetVpnGateways);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public TargetVpnGatewaysScopedList build() {

      return new TargetVpnGatewaysScopedList(targetVpnGateways, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllTargetVpnGateways(this.targetVpnGateways);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetVpnGatewaysScopedList{"
        + "targetVpnGateways="
        + targetVpnGateways
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
    if (o instanceof TargetVpnGatewaysScopedList) {
      TargetVpnGatewaysScopedList that = (TargetVpnGatewaysScopedList) o;
      return Objects.equals(this.targetVpnGateways, that.getTargetVpnGatewaysList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(targetVpnGateways, warning);
  }
}
