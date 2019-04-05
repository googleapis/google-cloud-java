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
/** Deprecation status for a public resource. */
public final class DeprecationStatus implements ApiMessage {
  private final String deleted;
  private final String deprecated;
  private final String obsolete;
  private final String replacement;
  private final String state;

  private DeprecationStatus() {
    this.deleted = null;
    this.deprecated = null;
    this.obsolete = null;
    this.replacement = null;
    this.state = null;
  }

  private DeprecationStatus(
      String deleted, String deprecated, String obsolete, String replacement, String state) {
    this.deleted = deleted;
    this.deprecated = deprecated;
    this.obsolete = obsolete;
    this.replacement = replacement;
    this.state = state;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("deleted".equals(fieldName)) {
      return deleted;
    }
    if ("deprecated".equals(fieldName)) {
      return deprecated;
    }
    if ("obsolete".equals(fieldName)) {
      return obsolete;
    }
    if ("replacement".equals(fieldName)) {
      return replacement;
    }
    if ("state".equals(fieldName)) {
      return state;
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
   * An optional RFC3339 timestamp on or after which the state of this resource is intended to
   * change to DELETED. This is only informational and the status will not change unless the client
   * explicitly changes it.
   */
  public String getDeleted() {
    return deleted;
  }

  /**
   * An optional RFC3339 timestamp on or after which the state of this resource is intended to
   * change to DEPRECATED. This is only informational and the status will not change unless the
   * client explicitly changes it.
   */
  public String getDeprecated() {
    return deprecated;
  }

  /**
   * An optional RFC3339 timestamp on or after which the state of this resource is intended to
   * change to OBSOLETE. This is only informational and the status will not change unless the client
   * explicitly changes it.
   */
  public String getObsolete() {
    return obsolete;
  }

  /**
   * The URL of the suggested replacement for a deprecated resource. The suggested replacement
   * resource must be the same kind of resource as the deprecated resource.
   */
  public String getReplacement() {
    return replacement;
  }

  /**
   * The deprecation state of this resource. This can be ACTIVE, DEPRECATED, OBSOLETE, or DELETED.
   * Operations which communicate the end of life date for an image, can use ACTIVE. Operations
   * which create a new resource using a DEPRECATED resource will return successfully, but with a
   * warning indicating the deprecated resource and recommending its replacement. Operations which
   * use OBSOLETE or DELETED resources will be rejected and result in an error.
   */
  public String getState() {
    return state;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(DeprecationStatus prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static DeprecationStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final DeprecationStatus DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new DeprecationStatus();
  }

  public static class Builder {
    private String deleted;
    private String deprecated;
    private String obsolete;
    private String replacement;
    private String state;

    Builder() {}

    public Builder mergeFrom(DeprecationStatus other) {
      if (other == DeprecationStatus.getDefaultInstance()) return this;
      if (other.getDeleted() != null) {
        this.deleted = other.deleted;
      }
      if (other.getDeprecated() != null) {
        this.deprecated = other.deprecated;
      }
      if (other.getObsolete() != null) {
        this.obsolete = other.obsolete;
      }
      if (other.getReplacement() != null) {
        this.replacement = other.replacement;
      }
      if (other.getState() != null) {
        this.state = other.state;
      }
      return this;
    }

    Builder(DeprecationStatus source) {
      this.deleted = source.deleted;
      this.deprecated = source.deprecated;
      this.obsolete = source.obsolete;
      this.replacement = source.replacement;
      this.state = source.state;
    }

    /**
     * An optional RFC3339 timestamp on or after which the state of this resource is intended to
     * change to DELETED. This is only informational and the status will not change unless the
     * client explicitly changes it.
     */
    public String getDeleted() {
      return deleted;
    }

    /**
     * An optional RFC3339 timestamp on or after which the state of this resource is intended to
     * change to DELETED. This is only informational and the status will not change unless the
     * client explicitly changes it.
     */
    public Builder setDeleted(String deleted) {
      this.deleted = deleted;
      return this;
    }

    /**
     * An optional RFC3339 timestamp on or after which the state of this resource is intended to
     * change to DEPRECATED. This is only informational and the status will not change unless the
     * client explicitly changes it.
     */
    public String getDeprecated() {
      return deprecated;
    }

    /**
     * An optional RFC3339 timestamp on or after which the state of this resource is intended to
     * change to DEPRECATED. This is only informational and the status will not change unless the
     * client explicitly changes it.
     */
    public Builder setDeprecated(String deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    /**
     * An optional RFC3339 timestamp on or after which the state of this resource is intended to
     * change to OBSOLETE. This is only informational and the status will not change unless the
     * client explicitly changes it.
     */
    public String getObsolete() {
      return obsolete;
    }

    /**
     * An optional RFC3339 timestamp on or after which the state of this resource is intended to
     * change to OBSOLETE. This is only informational and the status will not change unless the
     * client explicitly changes it.
     */
    public Builder setObsolete(String obsolete) {
      this.obsolete = obsolete;
      return this;
    }

    /**
     * The URL of the suggested replacement for a deprecated resource. The suggested replacement
     * resource must be the same kind of resource as the deprecated resource.
     */
    public String getReplacement() {
      return replacement;
    }

    /**
     * The URL of the suggested replacement for a deprecated resource. The suggested replacement
     * resource must be the same kind of resource as the deprecated resource.
     */
    public Builder setReplacement(String replacement) {
      this.replacement = replacement;
      return this;
    }

    /**
     * The deprecation state of this resource. This can be ACTIVE, DEPRECATED, OBSOLETE, or DELETED.
     * Operations which communicate the end of life date for an image, can use ACTIVE. Operations
     * which create a new resource using a DEPRECATED resource will return successfully, but with a
     * warning indicating the deprecated resource and recommending its replacement. Operations which
     * use OBSOLETE or DELETED resources will be rejected and result in an error.
     */
    public String getState() {
      return state;
    }

    /**
     * The deprecation state of this resource. This can be ACTIVE, DEPRECATED, OBSOLETE, or DELETED.
     * Operations which communicate the end of life date for an image, can use ACTIVE. Operations
     * which create a new resource using a DEPRECATED resource will return successfully, but with a
     * warning indicating the deprecated resource and recommending its replacement. Operations which
     * use OBSOLETE or DELETED resources will be rejected and result in an error.
     */
    public Builder setState(String state) {
      this.state = state;
      return this;
    }

    public DeprecationStatus build() {

      return new DeprecationStatus(deleted, deprecated, obsolete, replacement, state);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDeleted(this.deleted);
      newBuilder.setDeprecated(this.deprecated);
      newBuilder.setObsolete(this.obsolete);
      newBuilder.setReplacement(this.replacement);
      newBuilder.setState(this.state);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "DeprecationStatus{"
        + "deleted="
        + deleted
        + ", "
        + "deprecated="
        + deprecated
        + ", "
        + "obsolete="
        + obsolete
        + ", "
        + "replacement="
        + replacement
        + ", "
        + "state="
        + state
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DeprecationStatus) {
      DeprecationStatus that = (DeprecationStatus) o;
      return Objects.equals(this.deleted, that.getDeleted())
          && Objects.equals(this.deprecated, that.getDeprecated())
          && Objects.equals(this.obsolete, that.getObsolete())
          && Objects.equals(this.replacement, that.getReplacement())
          && Objects.equals(this.state, that.getState());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(deleted, deprecated, obsolete, replacement, state);
  }
}
