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
public final class LicenseCodeLicenseAlias implements ApiMessage {
  private final String description;
  private final String selfLink;

  private LicenseCodeLicenseAlias() {
    this.description = null;
    this.selfLink = null;
  }

  private LicenseCodeLicenseAlias(String description, String selfLink) {
    this.description = description;
    this.selfLink = selfLink;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
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

  /** [Output Only] Description of this License Code. */
  public String getDescription() {
    return description;
  }

  /** [Output Only] URL of license corresponding to this License Code. */
  public String getSelfLink() {
    return selfLink;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(LicenseCodeLicenseAlias prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static LicenseCodeLicenseAlias getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final LicenseCodeLicenseAlias DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new LicenseCodeLicenseAlias();
  }

  public static class Builder {
    private String description;
    private String selfLink;

    Builder() {}

    public Builder mergeFrom(LicenseCodeLicenseAlias other) {
      if (other == LicenseCodeLicenseAlias.getDefaultInstance()) return this;
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      return this;
    }

    Builder(LicenseCodeLicenseAlias source) {
      this.description = source.description;
      this.selfLink = source.selfLink;
    }

    /** [Output Only] Description of this License Code. */
    public String getDescription() {
      return description;
    }

    /** [Output Only] Description of this License Code. */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /** [Output Only] URL of license corresponding to this License Code. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] URL of license corresponding to this License Code. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public LicenseCodeLicenseAlias build() {

      return new LicenseCodeLicenseAlias(description, selfLink);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDescription(this.description);
      newBuilder.setSelfLink(this.selfLink);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "LicenseCodeLicenseAlias{"
        + "description="
        + description
        + ", "
        + "selfLink="
        + selfLink
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof LicenseCodeLicenseAlias) {
      LicenseCodeLicenseAlias that = (LicenseCodeLicenseAlias) o;
      return Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.selfLink, that.getSelfLink());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, selfLink);
  }
}
