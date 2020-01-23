/*
 * Copyright 2020 Google LLC
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
 * Custom fields. These can be used to create a counter with arbitrary field/value pairs. See:
 * go/rpcsp-custom-fields.
 */
public final class LogConfigCounterOptionsCustomField implements ApiMessage {
  private final String name;
  private final String value;

  private LogConfigCounterOptionsCustomField() {
    this.name = null;
    this.value = null;
  }

  private LogConfigCounterOptionsCustomField(String name, String value) {
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

  /** Name is the field name. */
  public String getName() {
    return name;
  }

  /**
   * Value is the field value. It is important that in contrast to the CounterOptions.field, the
   * value here is a constant that is not derived from the IAMContext.
   */
  public String getValue() {
    return value;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(LogConfigCounterOptionsCustomField prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static LogConfigCounterOptionsCustomField getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final LogConfigCounterOptionsCustomField DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new LogConfigCounterOptionsCustomField();
  }

  public static class Builder {
    private String name;
    private String value;

    Builder() {}

    public Builder mergeFrom(LogConfigCounterOptionsCustomField other) {
      if (other == LogConfigCounterOptionsCustomField.getDefaultInstance()) return this;
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getValue() != null) {
        this.value = other.value;
      }
      return this;
    }

    Builder(LogConfigCounterOptionsCustomField source) {
      this.name = source.name;
      this.value = source.value;
    }

    /** Name is the field name. */
    public String getName() {
      return name;
    }

    /** Name is the field name. */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * Value is the field value. It is important that in contrast to the CounterOptions.field, the
     * value here is a constant that is not derived from the IAMContext.
     */
    public String getValue() {
      return value;
    }

    /**
     * Value is the field value. It is important that in contrast to the CounterOptions.field, the
     * value here is a constant that is not derived from the IAMContext.
     */
    public Builder setValue(String value) {
      this.value = value;
      return this;
    }

    public LogConfigCounterOptionsCustomField build() {

      return new LogConfigCounterOptionsCustomField(name, value);
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
    return "LogConfigCounterOptionsCustomField{" + "name=" + name + ", " + "value=" + value + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof LogConfigCounterOptionsCustomField) {
      LogConfigCounterOptionsCustomField that = (LogConfigCounterOptionsCustomField) o;
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
