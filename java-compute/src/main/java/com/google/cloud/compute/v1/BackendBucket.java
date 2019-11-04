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
 * Represents a Cloud Storage Bucket resource.
 *
 * <p>This Cloud Storage bucket resource is referenced by a URL map of a load balancer. For more
 * information, read Backend Buckets.
 */
public final class BackendBucket implements ApiMessage {
  private final String bucketName;
  private final BackendBucketCdnPolicy cdnPolicy;
  private final String creationTimestamp;
  private final String description;
  private final Boolean enableCdn;
  private final String id;
  private final String kind;
  private final String name;
  private final String selfLink;

  private BackendBucket() {
    this.bucketName = null;
    this.cdnPolicy = null;
    this.creationTimestamp = null;
    this.description = null;
    this.enableCdn = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.selfLink = null;
  }

  private BackendBucket(
      String bucketName,
      BackendBucketCdnPolicy cdnPolicy,
      String creationTimestamp,
      String description,
      Boolean enableCdn,
      String id,
      String kind,
      String name,
      String selfLink) {
    this.bucketName = bucketName;
    this.cdnPolicy = cdnPolicy;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.enableCdn = enableCdn;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.selfLink = selfLink;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("bucketName".equals(fieldName)) {
      return bucketName;
    }
    if ("cdnPolicy".equals(fieldName)) {
      return cdnPolicy;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("enableCdn".equals(fieldName)) {
      return enableCdn;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
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

  /** Cloud Storage bucket name. */
  public String getBucketName() {
    return bucketName;
  }

  /** Cloud CDN configuration for this BackendBucket. */
  public BackendBucketCdnPolicy getCdnPolicy() {
    return cdnPolicy;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * An optional textual description of the resource; provided by the client when the resource is
   * created.
   */
  public String getDescription() {
    return description;
  }

  /** If true, enable Cloud CDN for this BackendBucket. */
  public Boolean getEnableCdn() {
    return enableCdn;
  }

  /** [Output Only] Unique identifier for the resource; defined by the server. */
  public String getId() {
    return id;
  }

  /** Type of the resource. */
  public String getKind() {
    return kind;
  }

  /**
   * Name of the resource. Provided by the client when the resource is created. The name must be
   * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
   * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   * character must be a lowercase letter, and all following characters must be a dash, lowercase
   * letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(BackendBucket prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static BackendBucket getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final BackendBucket DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new BackendBucket();
  }

  public static class Builder {
    private String bucketName;
    private BackendBucketCdnPolicy cdnPolicy;
    private String creationTimestamp;
    private String description;
    private Boolean enableCdn;
    private String id;
    private String kind;
    private String name;
    private String selfLink;

    Builder() {}

    public Builder mergeFrom(BackendBucket other) {
      if (other == BackendBucket.getDefaultInstance()) return this;
      if (other.getBucketName() != null) {
        this.bucketName = other.bucketName;
      }
      if (other.getCdnPolicy() != null) {
        this.cdnPolicy = other.cdnPolicy;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getEnableCdn() != null) {
        this.enableCdn = other.enableCdn;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      return this;
    }

    Builder(BackendBucket source) {
      this.bucketName = source.bucketName;
      this.cdnPolicy = source.cdnPolicy;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.enableCdn = source.enableCdn;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.selfLink = source.selfLink;
    }

    /** Cloud Storage bucket name. */
    public String getBucketName() {
      return bucketName;
    }

    /** Cloud Storage bucket name. */
    public Builder setBucketName(String bucketName) {
      this.bucketName = bucketName;
      return this;
    }

    /** Cloud CDN configuration for this BackendBucket. */
    public BackendBucketCdnPolicy getCdnPolicy() {
      return cdnPolicy;
    }

    /** Cloud CDN configuration for this BackendBucket. */
    public Builder setCdnPolicy(BackendBucketCdnPolicy cdnPolicy) {
      this.cdnPolicy = cdnPolicy;
      return this;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    /**
     * An optional textual description of the resource; provided by the client when the resource is
     * created.
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional textual description of the resource; provided by the client when the resource is
     * created.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /** If true, enable Cloud CDN for this BackendBucket. */
    public Boolean getEnableCdn() {
      return enableCdn;
    }

    /** If true, enable Cloud CDN for this BackendBucket. */
    public Builder setEnableCdn(Boolean enableCdn) {
      this.enableCdn = enableCdn;
      return this;
    }

    /** [Output Only] Unique identifier for the resource; defined by the server. */
    public String getId() {
      return id;
    }

    /** [Output Only] Unique identifier for the resource; defined by the server. */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /** Type of the resource. */
    public String getKind() {
      return kind;
    }

    /** Type of the resource. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public BackendBucket build() {

      return new BackendBucket(
          bucketName,
          cdnPolicy,
          creationTimestamp,
          description,
          enableCdn,
          id,
          kind,
          name,
          selfLink);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setBucketName(this.bucketName);
      newBuilder.setCdnPolicy(this.cdnPolicy);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setEnableCdn(this.enableCdn);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setSelfLink(this.selfLink);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "BackendBucket{"
        + "bucketName="
        + bucketName
        + ", "
        + "cdnPolicy="
        + cdnPolicy
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "enableCdn="
        + enableCdn
        + ", "
        + "id="
        + id
        + ", "
        + "kind="
        + kind
        + ", "
        + "name="
        + name
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
    if (o instanceof BackendBucket) {
      BackendBucket that = (BackendBucket) o;
      return Objects.equals(this.bucketName, that.getBucketName())
          && Objects.equals(this.cdnPolicy, that.getCdnPolicy())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.enableCdn, that.getEnableCdn())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.selfLink, that.getSelfLink());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        bucketName, cdnPolicy, creationTimestamp, description, enableCdn, id, kind, name, selfLink);
  }
}
