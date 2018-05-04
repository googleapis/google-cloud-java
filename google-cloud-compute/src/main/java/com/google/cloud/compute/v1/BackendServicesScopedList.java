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
public final class BackendServicesScopedList implements ApiMessage {
  private final List<BackendService> backendServices;
  private final Warning warning;

  private BackendServicesScopedList() {
    this.backendServices = null;
    this.warning = null;
  }

  private BackendServicesScopedList(List<BackendService> backendServices, Warning warning) {
    this.backendServices = backendServices;
    this.warning = warning;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("backendServices") && backendServices != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (BackendService item : backendServices) {
        stringList.add(item.toString());
      }
      fieldMap.put("backendServices", stringList.build());
    }
    if (fieldNames.contains("warning") && warning != null) {
      fieldMap.put("warning", Collections.singletonList(String.valueOf(warning)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("backendServices")) {
      return String.valueOf(backendServices);
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

  public List<BackendService> getBackendServicesList() {
    return backendServices;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(BackendServicesScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static BackendServicesScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final BackendServicesScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new BackendServicesScopedList();
  }

  public static class Builder {
    private List<BackendService> backendServices;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(BackendServicesScopedList other) {
      if (other == BackendServicesScopedList.getDefaultInstance()) return this;
      if (other.getBackendServicesList() != null) {
        this.backendServices = other.backendServices;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(BackendServicesScopedList source) {
      this.backendServices = source.backendServices;
      this.warning = source.warning;
    }

    public List<BackendService> getBackendServicesList() {
      return backendServices;
    }

    public Builder addAllBackendServices(List<BackendService> backendServices) {
      if (this.backendServices == null) {
        this.backendServices = new ArrayList<>(backendServices.size());
      }
      this.backendServices.addAll(backendServices);
      return this;
    }

    public Builder addBackendServices(BackendService backendServices) {
      this.backendServices.add(backendServices);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public BackendServicesScopedList build() {

      return new BackendServicesScopedList(backendServices, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllBackendServices(this.backendServices);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "BackendServicesScopedList{"
        + "backendServices="
        + backendServices
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
    if (o instanceof BackendServicesScopedList) {
      BackendServicesScopedList that = (BackendServicesScopedList) o;
      return Objects.equals(this.backendServices, that.getBackendServicesList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(backendServices, warning);
  }
}
