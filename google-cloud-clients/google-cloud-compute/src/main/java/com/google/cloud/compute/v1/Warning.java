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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** [Output Only] Informational warning message. */
public final class Warning implements ApiMessage {
  private final String code;
  private final List<Data> data;
  private final String message;

  private Warning() {
    this.code = null;
    this.data = null;
    this.message = null;
  }

  private Warning(String code, List<Data> data, String message) {
    this.code = code;
    this.data = data;
    this.message = message;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("code".equals(fieldName)) {
      return code;
    }
    if ("data".equals(fieldName)) {
      return data;
    }
    if ("message".equals(fieldName)) {
      return message;
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
   * [Output Only] A warning code, if applicable. For example, Compute Engine returns
   * NO_RESULTS_ON_PAGE if there are no results in the response.
   */
  public String getCode() {
    return code;
  }

  /**
   * [Output Only] Metadata about this warning in key: value format. For example: "data": [ { "key":
   * "scope", "value": "zones/us-east1-d" }
   */
  public List<Data> getDataList() {
    return data;
  }

  /** [Output Only] A human-readable description of the warning code. */
  public String getMessage() {
    return message;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Warning prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Warning getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Warning DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Warning();
  }

  public static class Builder {
    private String code;
    private List<Data> data;
    private String message;

    Builder() {}

    public Builder mergeFrom(Warning other) {
      if (other == Warning.getDefaultInstance()) return this;
      if (other.getCode() != null) {
        this.code = other.code;
      }
      if (other.getDataList() != null) {
        this.data = other.data;
      }
      if (other.getMessage() != null) {
        this.message = other.message;
      }
      return this;
    }

    Builder(Warning source) {
      this.code = source.code;
      this.data = source.data;
      this.message = source.message;
    }

    /**
     * [Output Only] A warning code, if applicable. For example, Compute Engine returns
     * NO_RESULTS_ON_PAGE if there are no results in the response.
     */
    public String getCode() {
      return code;
    }

    /**
     * [Output Only] A warning code, if applicable. For example, Compute Engine returns
     * NO_RESULTS_ON_PAGE if there are no results in the response.
     */
    public Builder setCode(String code) {
      this.code = code;
      return this;
    }

    /**
     * [Output Only] Metadata about this warning in key: value format. For example: "data": [ {
     * "key": "scope", "value": "zones/us-east1-d" }
     */
    public List<Data> getDataList() {
      return data;
    }

    /**
     * [Output Only] Metadata about this warning in key: value format. For example: "data": [ {
     * "key": "scope", "value": "zones/us-east1-d" }
     */
    public Builder addAllData(List<Data> data) {
      if (this.data == null) {
        this.data = new LinkedList<>();
      }
      this.data.addAll(data);
      return this;
    }

    /**
     * [Output Only] Metadata about this warning in key: value format. For example: "data": [ {
     * "key": "scope", "value": "zones/us-east1-d" }
     */
    public Builder addData(Data data) {
      if (this.data == null) {
        this.data = new LinkedList<>();
      }
      this.data.add(data);
      return this;
    }

    /** [Output Only] A human-readable description of the warning code. */
    public String getMessage() {
      return message;
    }

    /** [Output Only] A human-readable description of the warning code. */
    public Builder setMessage(String message) {
      this.message = message;
      return this;
    }

    public Warning build() {

      return new Warning(code, data, message);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCode(this.code);
      newBuilder.addAllData(this.data);
      newBuilder.setMessage(this.message);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Warning{" + "code=" + code + ", " + "data=" + data + ", " + "message=" + message + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Warning) {
      Warning that = (Warning) o;
      return Objects.equals(this.code, that.getCode())
          && Objects.equals(this.data, that.getDataList())
          && Objects.equals(this.message, that.getMessage());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, data, message);
  }
}
