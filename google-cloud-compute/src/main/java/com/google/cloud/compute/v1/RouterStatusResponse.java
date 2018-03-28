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
public final class RouterStatusResponse implements ApiMessage {
  private final String kind;
  private final RouterStatus result;

  private RouterStatusResponse() {
    this.kind = null;
    this.result = null;
  }


  private RouterStatusResponse(
      String kind,
      RouterStatus result
      ) {
    this.kind = kind;
    this.result = result;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("result") && result != null) {
      fieldMap.put("result", Collections.singletonList(String.valueOf(result)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("result")) {
      return String.valueOf(result);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public String getKind() {
    return kind;
  }

  public RouterStatus getResult() {
    return result;
  }


  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(RouterStatusResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RouterStatusResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  private static final RouterStatusResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new RouterStatusResponse();
  }

  public static class Builder {
    private String kind;
    private RouterStatus result;

    Builder() {}

    public Builder mergeFrom(RouterStatusResponse other) {
      if (other == RouterStatusResponse.getDefaultInstance()) return this;
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getResult() != null) {
        this.result = other.result;
      }
      return this;
    }

    Builder(RouterStatusResponse source) {
      this.kind = source.kind;
      this.result = source.result;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public RouterStatus getResult() {
      return result;
    }

    public Builder setResult(RouterStatus result) {
      this.result = result;
      return this;
    }


    public RouterStatusResponse build() {

      return new RouterStatusResponse(
        kind,
        result
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setKind(this.kind);
      newBuilder.setResult(this.result);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RouterStatusResponse{"
        + "kind=" + kind + ", "
        + "result=" + result
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RouterStatusResponse) {
      RouterStatusResponse that = (RouterStatusResponse) o;
      return
          Objects.equals(this.kind, that.getKind()) &&
          Objects.equals(this.result, that.getResult())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      kind,
      result
    );
  }
}
