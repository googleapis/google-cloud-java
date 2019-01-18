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
  public List<String> getFieldMask() {
    return null;
  }

  public String getBucketName() {
    return bucketName;
  }

  public BackendBucketCdnPolicy getCdnPolicy() {
    return cdnPolicy;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public Boolean getEnableCdn() {
    return enableCdn;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

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

    public String getBucketName() {
      return bucketName;
    }

    public Builder setBucketName(String bucketName) {
      this.bucketName = bucketName;
      return this;
    }

    public BackendBucketCdnPolicy getCdnPolicy() {
      return cdnPolicy;
    }

    public Builder setCdnPolicy(BackendBucketCdnPolicy cdnPolicy) {
      this.cdnPolicy = cdnPolicy;
      return this;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public Boolean getEnableCdn() {
      return enableCdn;
    }

    public Builder setEnableCdn(Boolean enableCdn) {
      this.enableCdn = enableCdn;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

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
