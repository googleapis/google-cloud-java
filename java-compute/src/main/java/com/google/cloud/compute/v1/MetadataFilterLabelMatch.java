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
 * MetadataFilter label name value pairs that are expected to match corresponding labels presented
 * as metadata to the loadbalancer.
 */
public final class MetadataFilterLabelMatch implements ApiMessage {
  private final String name;
  private final String value;

  private MetadataFilterLabelMatch() {
    this.name = null;
    this.value = null;
  }

  private MetadataFilterLabelMatch(String name, String value) {
    this.name = name;
    this.value = value;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("name".equals(fieldName)) {
      return name;
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
   * Name of metadata label. The name can have a maximum length of 1024 characters and must be at
   * least 1 character long.
   */
  public String getName() {
    return name;
  }

  /**
   * The value of the label must match the specified value. value can have a maximum length of 1024
   * characters.
   */
  public String getValue() {
    return value;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(MetadataFilterLabelMatch prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static MetadataFilterLabelMatch getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final MetadataFilterLabelMatch DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new MetadataFilterLabelMatch();
  }

  public static class Builder {
    private String name;
    private String value;

    Builder() {}

    public Builder mergeFrom(MetadataFilterLabelMatch other) {
      if (other == MetadataFilterLabelMatch.getDefaultInstance()) return this;
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getValue() != null) {
        this.value = other.value;
      }
      return this;
    }

    Builder(MetadataFilterLabelMatch source) {
      this.name = source.name;
      this.value = source.value;
    }

    /**
     * Name of metadata label. The name can have a maximum length of 1024 characters and must be at
     * least 1 character long.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of metadata label. The name can have a maximum length of 1024 characters and must be at
     * least 1 character long.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * The value of the label must match the specified value. value can have a maximum length of
     * 1024 characters.
     */
    public String getValue() {
      return value;
    }

    /**
     * The value of the label must match the specified value. value can have a maximum length of
     * 1024 characters.
     */
    public Builder setValue(String value) {
      this.value = value;
      return this;
    }

    public MetadataFilterLabelMatch build() {

      return new MetadataFilterLabelMatch(name, value);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setName(this.name);
      newBuilder.setValue(this.value);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "MetadataFilterLabelMatch{" + "name=" + name + ", " + "value=" + value + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof MetadataFilterLabelMatch) {
      MetadataFilterLabelMatch that = (MetadataFilterLabelMatch) o;
      return Objects.equals(this.name, that.getName())
          && Objects.equals(this.value, that.getValue());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value);
  }
}
