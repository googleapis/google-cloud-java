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
/** Array of key/value pairs. The total size of all keys and values must be less than 512 KB. */
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

  /**
   * Key for the metadata entry. Keys must conform to the following regexp: [a-zA-Z0-9-_]+, and be
   * less than 128 bytes in length. This is reflected as part of a URL in the metadata server.
   * Additionally, to avoid ambiguity, keys must not conflict with any other metadata keys for the
   * project.
   */
  public String getKey() {
    return key;
  }

  /**
   * Value for the metadata entry. These are free-form strings, and only have meaning as interpreted
   * by the image running in the instance. The only restriction placed on values is that their size
   * must be less than or equal to 262144 bytes (256 KiB).
   */
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

    /**
     * Key for the metadata entry. Keys must conform to the following regexp: [a-zA-Z0-9-_]+, and be
     * less than 128 bytes in length. This is reflected as part of a URL in the metadata server.
     * Additionally, to avoid ambiguity, keys must not conflict with any other metadata keys for the
     * project.
     */
    public String getKey() {
      return key;
    }

    /**
     * Key for the metadata entry. Keys must conform to the following regexp: [a-zA-Z0-9-_]+, and be
     * less than 128 bytes in length. This is reflected as part of a URL in the metadata server.
     * Additionally, to avoid ambiguity, keys must not conflict with any other metadata keys for the
     * project.
     */
    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    /**
     * Value for the metadata entry. These are free-form strings, and only have meaning as
     * interpreted by the image running in the instance. The only restriction placed on values is
     * that their size must be less than or equal to 262144 bytes (256 KiB).
     */
    public String getValue() {
      return value;
    }

    /**
     * Value for the metadata entry. These are free-form strings, and only have meaning as
     * interpreted by the image running in the instance. The only restriction placed on values is
     * that their size must be less than or equal to 262144 bytes (256 KiB).
     */
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
