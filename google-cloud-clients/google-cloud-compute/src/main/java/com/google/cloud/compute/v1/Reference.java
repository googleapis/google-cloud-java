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
/** Represents a reference to a resource. */
public final class Reference implements ApiMessage {
  private final String kind;
  private final String referenceType;
  private final String referrer;
  private final String target;

  private Reference() {
    this.kind = null;
    this.referenceType = null;
    this.referrer = null;
    this.target = null;
  }

  private Reference(String kind, String referenceType, String referrer, String target) {
    this.kind = kind;
    this.referenceType = referenceType;
    this.referrer = referrer;
    this.target = target;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("referenceType".equals(fieldName)) {
      return referenceType;
    }
    if ("referrer".equals(fieldName)) {
      return referrer;
    }
    if ("target".equals(fieldName)) {
      return target;
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

  /** [Output Only] Type of the resource. Always compute#reference for references. */
  public String getKind() {
    return kind;
  }

  /**
   * A description of the reference type with no implied semantics. Possible values include: -
   * MEMBER_OF
   */
  public String getReferenceType() {
    return referenceType;
  }

  /** URL of the resource which refers to the target. */
  public String getReferrer() {
    return referrer;
  }

  /** URL of the resource to which this reference points. */
  public String getTarget() {
    return target;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Reference prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Reference getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Reference DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Reference();
  }

  public static class Builder {
    private String kind;
    private String referenceType;
    private String referrer;
    private String target;

    Builder() {}

    public Builder mergeFrom(Reference other) {
      if (other == Reference.getDefaultInstance()) return this;
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getReferenceType() != null) {
        this.referenceType = other.referenceType;
      }
      if (other.getReferrer() != null) {
        this.referrer = other.referrer;
      }
      if (other.getTarget() != null) {
        this.target = other.target;
      }
      return this;
    }

    Builder(Reference source) {
      this.kind = source.kind;
      this.referenceType = source.referenceType;
      this.referrer = source.referrer;
      this.target = source.target;
    }

    /** [Output Only] Type of the resource. Always compute#reference for references. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#reference for references. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * A description of the reference type with no implied semantics. Possible values include: -
     * MEMBER_OF
     */
    public String getReferenceType() {
      return referenceType;
    }

    /**
     * A description of the reference type with no implied semantics. Possible values include: -
     * MEMBER_OF
     */
    public Builder setReferenceType(String referenceType) {
      this.referenceType = referenceType;
      return this;
    }

    /** URL of the resource which refers to the target. */
    public String getReferrer() {
      return referrer;
    }

    /** URL of the resource which refers to the target. */
    public Builder setReferrer(String referrer) {
      this.referrer = referrer;
      return this;
    }

    /** URL of the resource to which this reference points. */
    public String getTarget() {
      return target;
    }

    /** URL of the resource to which this reference points. */
    public Builder setTarget(String target) {
      this.target = target;
      return this;
    }

    public Reference build() {

      return new Reference(kind, referenceType, referrer, target);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setKind(this.kind);
      newBuilder.setReferenceType(this.referenceType);
      newBuilder.setReferrer(this.referrer);
      newBuilder.setTarget(this.target);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Reference{"
        + "kind="
        + kind
        + ", "
        + "referenceType="
        + referenceType
        + ", "
        + "referrer="
        + referrer
        + ", "
        + "target="
        + target
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Reference) {
      Reference that = (Reference) o;
      return Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.referenceType, that.getReferenceType())
          && Objects.equals(this.referrer, that.getReferrer())
          && Objects.equals(this.target, that.getTarget());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, referenceType, referrer, target);
  }
}
