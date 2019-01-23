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
public final class Items implements ApiMessage {
  private final String key;
  private final String value;

  private Items() {
    this.key = null;
    this.value = null;
  }

  private Items(String key, String value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("key".equals(fieldName)) {
      return key;
    }
    if ("value".equals(fieldName)) {
      return value;
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
  public List<String> getFieldMask() {
    return null;
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Items prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Items getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Items DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Items();
  }

  public static class Builder {
    private String key;
    private String value;

    Builder() {}

    public Builder mergeFrom(Items other) {
      if (other == Items.getDefaultInstance()) return this;
      if (other.getKey() != null) {
        this.key = other.key;
      }
      if (other.getValue() != null) {
        this.value = other.value;
      }
      return this;
    }

    Builder(Items source) {
      this.key = source.key;
      this.value = source.value;
    }

    public String getKey() {
      return key;
    }

    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    public String getValue() {
      return value;
    }

    public Builder setValue(String value) {
      this.value = value;
      return this;
    }

    public Items build() {

      return new Items(key, value);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setKey(this.key);
      newBuilder.setValue(this.value);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Items{" + "key=" + key + ", " + "value=" + value + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Items) {
      Items that = (Items) o;
      return Objects.equals(this.key, that.getKey()) && Objects.equals(this.value, that.getValue());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }
}
