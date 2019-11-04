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
public final class ManagedInstanceVersion implements ApiMessage {
  private final String instanceTemplate;
  private final String name;

  private ManagedInstanceVersion() {
    this.instanceTemplate = null;
    this.name = null;
  }

  private ManagedInstanceVersion(String instanceTemplate, String name) {
    this.instanceTemplate = instanceTemplate;
    this.name = name;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("instanceTemplate".equals(fieldName)) {
      return instanceTemplate;
    }
    if ("name".equals(fieldName)) {
      return name;
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
   * [Output Only] The intended template of the instance. This field is empty when current_action is
   * one of { DELETING, ABANDONING }.
   */
  public String getInstanceTemplate() {
    return instanceTemplate;
  }

  /** [Output Only] Name of the version. */
  public String getName() {
    return name;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ManagedInstanceVersion prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ManagedInstanceVersion getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ManagedInstanceVersion DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ManagedInstanceVersion();
  }

  public static class Builder {
    private String instanceTemplate;
    private String name;

    Builder() {}

    public Builder mergeFrom(ManagedInstanceVersion other) {
      if (other == ManagedInstanceVersion.getDefaultInstance()) return this;
      if (other.getInstanceTemplate() != null) {
        this.instanceTemplate = other.instanceTemplate;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      return this;
    }

    Builder(ManagedInstanceVersion source) {
      this.instanceTemplate = source.instanceTemplate;
      this.name = source.name;
    }

    /**
     * [Output Only] The intended template of the instance. This field is empty when current_action
     * is one of { DELETING, ABANDONING }.
     */
    public String getInstanceTemplate() {
      return instanceTemplate;
    }

    /**
     * [Output Only] The intended template of the instance. This field is empty when current_action
     * is one of { DELETING, ABANDONING }.
     */
    public Builder setInstanceTemplate(String instanceTemplate) {
      this.instanceTemplate = instanceTemplate;
      return this;
    }

    /** [Output Only] Name of the version. */
    public String getName() {
      return name;
    }

    /** [Output Only] Name of the version. */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public ManagedInstanceVersion build() {

      return new ManagedInstanceVersion(instanceTemplate, name);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setInstanceTemplate(this.instanceTemplate);
      newBuilder.setName(this.name);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ManagedInstanceVersion{"
        + "instanceTemplate="
        + instanceTemplate
        + ", "
        + "name="
        + name
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ManagedInstanceVersion) {
      ManagedInstanceVersion that = (ManagedInstanceVersion) o;
      return Objects.equals(this.instanceTemplate, that.getInstanceTemplate())
          && Objects.equals(this.name, that.getName());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceTemplate, name);
  }
}
