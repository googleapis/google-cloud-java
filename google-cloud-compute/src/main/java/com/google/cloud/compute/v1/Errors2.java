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
public final class Errors2 implements ApiMessage {
  private final String code;
  private final String location;
  private final String message;

  private Errors2() {
    this.code = null;
    this.location = null;
    this.message = null;
  }

  private Errors2(String code, String location, String message) {
    this.code = code;
    this.location = location;
    this.message = message;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("code") && code != null) {
      fieldMap.put("code", Collections.singletonList(String.valueOf(code)));
    }
    if (fieldNames.contains("location") && location != null) {
      fieldMap.put("location", Collections.singletonList(String.valueOf(location)));
    }
    if (fieldNames.contains("message") && message != null) {
      fieldMap.put("message", Collections.singletonList(String.valueOf(message)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("code")) {
      return String.valueOf(code);
    }
    if (fieldName.equals("location")) {
      return String.valueOf(location);
    }
    if (fieldName.equals("message")) {
      return String.valueOf(message);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public String getCode() {
    return code;
  }

  public String getLocation() {
    return location;
  }

  public String getMessage() {
    return message;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Errors2 prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Errors2 getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Errors2 DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Errors2();
  }

  public static class Builder {
    private String code;
    private String location;
    private String message;

    Builder() {}

    public Builder mergeFrom(Errors2 other) {
      if (other == Errors2.getDefaultInstance()) return this;
      if (other.getCode() != null) {
        this.code = other.code;
      }
      if (other.getLocation() != null) {
        this.location = other.location;
      }
      if (other.getMessage() != null) {
        this.message = other.message;
      }
      return this;
    }

    Builder(Errors2 source) {
      this.code = source.code;
      this.location = source.location;
      this.message = source.message;
    }

    public String getCode() {
      return code;
    }

    public Builder setCode(String code) {
      this.code = code;
      return this;
    }

    public String getLocation() {
      return location;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public String getMessage() {
      return message;
    }

    public Builder setMessage(String message) {
      this.message = message;
      return this;
    }

    public Errors2 build() {

      return new Errors2(code, location, message);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCode(this.code);
      newBuilder.setLocation(this.location);
      newBuilder.setMessage(this.message);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Errors2{"
        + "code="
        + code
        + ", "
        + "location="
        + location
        + ", "
        + "message="
        + message
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Errors2) {
      Errors2 that = (Errors2) o;
      return Objects.equals(this.code, that.getCode())
          && Objects.equals(this.location, that.getLocation())
          && Objects.equals(this.message, that.getMessage());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, location, message);
  }
}
