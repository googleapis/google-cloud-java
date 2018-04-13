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
public final class RoutersScopedList implements ApiMessage {
  private final List<Router> routers;
  private final Warning warning;

  private RoutersScopedList() {
    this.routers = null;
    this.warning = null;
  }

  private RoutersScopedList(List<Router> routers, Warning warning) {
    this.routers = routers;
    this.warning = warning;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("routers") && routers != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (Router item : routers) {
        stringList.add(item.toString());
      }
      fieldMap.put("routers", stringList.build());
    }
    if (fieldNames.contains("warning") && warning != null) {
      fieldMap.put("warning", Collections.singletonList(String.valueOf(warning)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("routers")) {
      return String.valueOf(routers);
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

  public List<Router> getRoutersList() {
    return routers;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RoutersScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RoutersScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RoutersScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RoutersScopedList();
  }

  public static class Builder {
    private List<Router> routers;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(RoutersScopedList other) {
      if (other == RoutersScopedList.getDefaultInstance()) return this;
      if (other.getRoutersList() != null) {
        this.routers = other.routers;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(RoutersScopedList source) {
      this.routers = source.routers;
      this.warning = source.warning;
    }

    public List<Router> getRoutersList() {
      return routers;
    }

    public Builder addAllRouters(List<Router> routers) {
      if (this.routers == null) {
        this.routers = new ArrayList<>(routers.size());
      }
      this.routers.addAll(routers);
      return this;
    }

    public Builder addRouters(Router routers) {
      this.routers.add(routers);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public RoutersScopedList build() {

      return new RoutersScopedList(routers, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllRouters(this.routers);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RoutersScopedList{" + "routers=" + routers + ", " + "warning=" + warning + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RoutersScopedList) {
      RoutersScopedList that = (RoutersScopedList) o;
      return Objects.equals(this.routers, that.getRoutersList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(routers, warning);
  }
}
