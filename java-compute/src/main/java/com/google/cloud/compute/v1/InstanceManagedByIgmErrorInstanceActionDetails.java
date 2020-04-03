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
public final class InstanceManagedByIgmErrorInstanceActionDetails implements ApiMessage {
  private final String action;
  private final String instance;
  private final ManagedInstanceVersion version;

  private InstanceManagedByIgmErrorInstanceActionDetails() {
    this.action = null;
    this.instance = null;
    this.version = null;
  }

  private InstanceManagedByIgmErrorInstanceActionDetails(
      String action, String instance, ManagedInstanceVersion version) {
    this.action = action;
    this.instance = instance;
    this.version = version;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("action".equals(fieldName)) {
      return action;
    }
    if ("instance".equals(fieldName)) {
      return instance;
    }
    if ("version".equals(fieldName)) {
      return version;
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
   * [Output Only] Action that managed instance group was executing on the instance when the error
   * occurred. Possible values:
   */
  public String getAction() {
    return action;
  }

  /**
   * [Output Only] The URL of the instance. The URL can be set even if the instance has not yet been
   * created.
   */
  public String getInstance() {
    return instance;
  }

  /**
   * [Output Only] Version this instance was created from, or was being created from, but the
   * creation failed. Corresponds to one of the versions that were set on the Instance Group Manager
   * resource at the time this instance was being created.
   */
  public ManagedInstanceVersion getVersion() {
    return version;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceManagedByIgmErrorInstanceActionDetails prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceManagedByIgmErrorInstanceActionDetails getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceManagedByIgmErrorInstanceActionDetails DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceManagedByIgmErrorInstanceActionDetails();
  }

  public static class Builder {
    private String action;
    private String instance;
    private ManagedInstanceVersion version;

    Builder() {}

    public Builder mergeFrom(InstanceManagedByIgmErrorInstanceActionDetails other) {
      if (other == InstanceManagedByIgmErrorInstanceActionDetails.getDefaultInstance()) return this;
      if (other.getAction() != null) {
        this.action = other.action;
      }
      if (other.getInstance() != null) {
        this.instance = other.instance;
      }
      if (other.getVersion() != null) {
        this.version = other.version;
      }
      return this;
    }

    Builder(InstanceManagedByIgmErrorInstanceActionDetails source) {
      this.action = source.action;
      this.instance = source.instance;
      this.version = source.version;
    }

    /**
     * [Output Only] Action that managed instance group was executing on the instance when the error
     * occurred. Possible values:
     */
    public String getAction() {
      return action;
    }

    /**
     * [Output Only] Action that managed instance group was executing on the instance when the error
     * occurred. Possible values:
     */
    public Builder setAction(String action) {
      this.action = action;
      return this;
    }

    /**
     * [Output Only] The URL of the instance. The URL can be set even if the instance has not yet
     * been created.
     */
    public String getInstance() {
      return instance;
    }

    /**
     * [Output Only] The URL of the instance. The URL can be set even if the instance has not yet
     * been created.
     */
    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    /**
     * [Output Only] Version this instance was created from, or was being created from, but the
     * creation failed. Corresponds to one of the versions that were set on the Instance Group
     * Manager resource at the time this instance was being created.
     */
    public ManagedInstanceVersion getVersion() {
      return version;
    }

    /**
     * [Output Only] Version this instance was created from, or was being created from, but the
     * creation failed. Corresponds to one of the versions that were set on the Instance Group
     * Manager resource at the time this instance was being created.
     */
    public Builder setVersion(ManagedInstanceVersion version) {
      this.version = version;
      return this;
    }

    public InstanceManagedByIgmErrorInstanceActionDetails build() {

      return new InstanceManagedByIgmErrorInstanceActionDetails(action, instance, version);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAction(this.action);
      newBuilder.setInstance(this.instance);
      newBuilder.setVersion(this.version);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceManagedByIgmErrorInstanceActionDetails{"
        + "action="
        + action
        + ", "
        + "instance="
        + instance
        + ", "
        + "version="
        + version
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceManagedByIgmErrorInstanceActionDetails) {
      InstanceManagedByIgmErrorInstanceActionDetails that =
          (InstanceManagedByIgmErrorInstanceActionDetails) o;
      return Objects.equals(this.action, that.getAction())
          && Objects.equals(this.instance, that.getInstance())
          && Objects.equals(this.version, that.getVersion());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, instance, version);
  }
}
