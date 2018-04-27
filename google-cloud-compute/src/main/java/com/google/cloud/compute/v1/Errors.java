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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class Errors implements ApiMessage {
  private final List<Errors> errors;

  private Errors() {
    this.errors = null;
  }

  private Errors(List<Errors> errors) {
    this.errors = errors;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("errors") && errors != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (Errors item : errors) {
        stringList.add(item.toString());
      }
      fieldMap.put("errors", stringList.build());
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("errors")) {
      return String.valueOf(errors);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public List<Errors> getErrorsList() {
    return errors;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Errors prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Errors getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Errors DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Errors();
  }

  public static class Builder {
    private List<Errors> errors;

    Builder() {}

    public Builder mergeFrom(Errors other) {
      if (other == Errors.getDefaultInstance()) return this;
      if (other.getErrorsList() != null) {
        this.errors = other.errors;
      }
      return this;
    }

    Builder(Errors source) {
      this.errors = source.errors;
    }

    public List<Errors> getErrorsList() {
      return errors;
    }

    public Builder addAllErrors(List<Errors> errors) {
      if (this.errors == null) {
        this.errors = new ArrayList<>(errors.size());
      }
      this.errors.addAll(errors);
      return this;
    }

    public Builder addErrors(Errors errors) {
      this.errors.add(errors);
      return this;
    }

    public Errors build() {
      return new Errors(errors);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllErrors(this.errors);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Errors{" + "errors=" + errors + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Errors) {
      Errors that = (Errors) o;
      return Objects.equals(this.errors, that.getErrorsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(errors);
  }
}
