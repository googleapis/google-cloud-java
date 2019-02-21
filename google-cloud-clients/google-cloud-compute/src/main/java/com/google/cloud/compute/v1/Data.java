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
/**
 * [Output Only] Metadata about this warning in key: value format. For example: "data": [ { "key":
 * "scope", "value": "zones/us-east1-d" }
 */
public final class Data implements ApiMessage {
  private final String key;
  private final String value;

  private Data() {
    this.key = null;
    this.value = null;
  }

  private Data(String key, String value) {
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
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /**
   * [Output Only] A key that provides more detail on the warning being returned. For example, for
   * warnings where there are no results in a list request for a particular zone, this key might be
   * scope and the key value might be the zone name. Other examples might be a key indicating a
   * deprecated resource and a suggested replacement, or a warning about invalid network settings
   * (for example, if an instance attempts to perform IP forwarding but is not enabled for IP
   * forwarding).
   */
  public String getKey() {
    return key;
  }

  /** [Output Only] A warning data value corresponding to the key. */
  public String getValue() {
    return value;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Data prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Data getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Data DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Data();
  }

  public static class Builder {
    private String key;
    private String value;

    Builder() {}

    public Builder mergeFrom(Data other) {
      if (other == Data.getDefaultInstance()) return this;
      if (other.getKey() != null) {
        this.key = other.key;
      }
      if (other.getValue() != null) {
        this.value = other.value;
      }
      return this;
    }

    Builder(Data source) {
      this.key = source.key;
      this.value = source.value;
    }

    /**
     * [Output Only] A key that provides more detail on the warning being returned. For example, for
     * warnings where there are no results in a list request for a particular zone, this key might
     * be scope and the key value might be the zone name. Other examples might be a key indicating a
     * deprecated resource and a suggested replacement, or a warning about invalid network settings
     * (for example, if an instance attempts to perform IP forwarding but is not enabled for IP
     * forwarding).
     */
    public String getKey() {
      return key;
    }

    /**
     * [Output Only] A key that provides more detail on the warning being returned. For example, for
     * warnings where there are no results in a list request for a particular zone, this key might
     * be scope and the key value might be the zone name. Other examples might be a key indicating a
     * deprecated resource and a suggested replacement, or a warning about invalid network settings
     * (for example, if an instance attempts to perform IP forwarding but is not enabled for IP
     * forwarding).
     */
    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    /** [Output Only] A warning data value corresponding to the key. */
    public String getValue() {
      return value;
    }

    /** [Output Only] A warning data value corresponding to the key. */
    public Builder setValue(String value) {
      this.value = value;
      return this;
    }

    public Data build() {

      return new Data(key, value);
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
    return "Data{" + "key=" + key + ", " + "value=" + value + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Data) {
      Data that = (Data) o;
      return Objects.equals(this.key, that.getKey()) && Objects.equals(this.value, that.getValue());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }
}
