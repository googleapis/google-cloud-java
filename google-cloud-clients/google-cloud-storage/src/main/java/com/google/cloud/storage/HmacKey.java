/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage;

import com.google.api.client.util.DateTime;
import java.io.Serializable;
import java.util.Objects;

/** HMAC key for a service account. */
public class HmacKey implements Serializable {

  private static final long serialVersionUID = -1809610424373783062L;
  private final String secretKey;
  private final HmacKeyMetadata metadata;

  private HmacKey(Builder builder) {
    this.secretKey = builder.secretKey;
    this.metadata = builder.metadata;
  }

  public static Builder newBuilder(String secretKey) {
    return new Builder(secretKey);
  }

  /** Builder for {@code HmacKey} objects. * */
  public static class Builder {
    private String secretKey;
    private HmacKeyMetadata metadata;

    private Builder(String secretKey) {
      this.secretKey = secretKey;
    }

    public Builder setSecretKey(String secretKey) {
      this.secretKey = secretKey;
      return this;
    }

    public Builder setMetadata(HmacKeyMetadata metadata) {
      this.metadata = metadata;
      return this;
    }

    /** Creates an {@code HmacKey} object from this builder. * */
    public HmacKey build() {
      return new HmacKey(this);
    }
  }

  /** Returns the secret key associated with this HMAC key. * */
  public String getSecretKey() {
    return secretKey;
  }

  /** Returns the metadata associated with this HMAC key. * */
  public HmacKeyMetadata getMetadata() {
    return metadata;
  }

  @Override
  public int hashCode() {
    return Objects.hash(secretKey, metadata);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    final HmacKeyMetadata other = (HmacKeyMetadata) obj;
    return Objects.equals(this.secretKey, secretKey) && Objects.equals(this.metadata, metadata);
  }

  com.google.api.services.storage.model.HmacKey toPb() {
    com.google.api.services.storage.model.HmacKey hmacKey =
        new com.google.api.services.storage.model.HmacKey();
    hmacKey.setSecret(this.secretKey);

    if (metadata != null) {
      hmacKey.setMetadata(metadata.toPb());
    }

    return hmacKey;
  }

  static HmacKey fromPb(com.google.api.services.storage.model.HmacKey hmacKey) {
    return HmacKey.newBuilder(hmacKey.getSecret())
        .setMetadata(HmacKeyMetadata.fromPb(hmacKey.getMetadata()))
        .build();
  }

  public enum HmacKeyState {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    DELETED("DELETED");

    private final String state;

    HmacKeyState(String state) {
      this.state = state;
    }
  }

  /**
   * The metadata for a service account HMAC key. This class holds all data associated with an HMAC
   * key other than the secret key.
   */
  public static class HmacKeyMetadata implements Serializable {

    private static final long serialVersionUID = 4571684785352640737L;
    private final String accessId;
    private final String etag;
    private final String id;
    private final String projectId;
    private final ServiceAccount serviceAccount;
    private final HmacKeyState state;
    private final Long createTime;
    private final Long updateTime;

    private HmacKeyMetadata(Builder builder) {
      this.accessId = builder.accessId;
      this.etag = builder.etag;
      this.id = builder.id;
      this.projectId = builder.projectId;
      this.serviceAccount = builder.serviceAccount;
      this.state = builder.state;
      this.createTime = builder.createTime;
      this.updateTime = builder.updateTime;
    }

    public static Builder newBuilder(ServiceAccount serviceAccount) {
      return new Builder(serviceAccount);
    }

    public Builder toBuilder() {
      return new Builder(this);
    }

    public static HmacKeyMetadata of(
        ServiceAccount serviceAccount, String accessId, String projectId) {
      return newBuilder(serviceAccount).setAccessId(accessId).setProjectId(projectId).build();
    }

    @Override
    public int hashCode() {
      return Objects.hash(accessId, projectId);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      final HmacKeyMetadata other = (HmacKeyMetadata) obj;
      return Objects.equals(this.accessId, other.accessId)
          && Objects.equals(this.etag, other.etag)
          && Objects.equals(this.id, other.id)
          && Objects.equals(this.projectId, other.projectId)
          && Objects.equals(this.serviceAccount, other.serviceAccount)
          && Objects.equals(this.state, other.state)
          && Objects.equals(this.createTime, other.createTime)
          && Objects.equals(this.updateTime, other.updateTime);
    }

    public com.google.api.services.storage.model.HmacKeyMetadata toPb() {
      com.google.api.services.storage.model.HmacKeyMetadata metadata =
          new com.google.api.services.storage.model.HmacKeyMetadata();
      metadata.setAccessId(this.accessId);
      metadata.setEtag(this.etag);
      metadata.setId(this.id);
      metadata.setProjectId(this.projectId);
      metadata.setServiceAccountEmail(
          this.serviceAccount == null ? null : this.serviceAccount.getEmail());
      metadata.setState(this.state == null ? null : this.state.toString());
      metadata.setTimeCreated(this.createTime == null ? null : new DateTime(this.createTime));
      metadata.setUpdated(this.updateTime == null ? null : new DateTime(this.updateTime));

      return metadata;
    }

    static HmacKeyMetadata fromPb(com.google.api.services.storage.model.HmacKeyMetadata metadata) {
      return newBuilder(ServiceAccount.of(metadata.getServiceAccountEmail()))
          .setAccessId(metadata.getAccessId())
          .setCreateTime(metadata.getTimeCreated().getValue())
          .setEtag(metadata.getEtag())
          .setId(metadata.getId())
          .setProjectId(metadata.getProjectId())
          .setState(HmacKeyState.valueOf(metadata.getState()))
          .setUpdateTime(metadata.getUpdated().getValue())
          .build();
    }

    /**
     * Returns the access id for this HMAC key. This is the id needed to get or delete the key. *
     */
    public String getAccessId() {
      return accessId;
    }

    /**
     * Returns HTTP 1.1 Entity tag for this HMAC key.
     *
     * @see <a href="http://tools.ietf.org/html/rfc2616#section-3.11">Entity Tags</a>
     */
    public String getEtag() {
      return etag;
    }

    /** Returns the resource name of this HMAC key. * */
    public String getId() {
      return id;
    }

    /** Returns the project id associated with this HMAC key. * */
    public String getProjectId() {
      return projectId;
    }

    /** Returns the service account associated with this HMAC key. * */
    public ServiceAccount getServiceAccount() {
      return serviceAccount;
    }

    /** Returns the current state of this HMAC key. * */
    public HmacKeyState getState() {
      return state;
    }

    /** Returns the creation time of this HMAC key. * */
    public Long getCreateTime() {
      return createTime;
    }

    /** Returns the last updated time of this HMAC key. * */
    public Long getUpdateTime() {
      return updateTime;
    }

    /** Builder for {@code HmacKeyMetadata} objects. * */
    public static class Builder {
      private String accessId;
      private String etag;
      private String id;
      private String projectId;
      private ServiceAccount serviceAccount;
      private HmacKeyState state;
      private Long createTime;
      private Long updateTime;

      private Builder(ServiceAccount serviceAccount) {
        this.serviceAccount = serviceAccount;
      }

      private Builder(HmacKeyMetadata metadata) {
        this.accessId = metadata.accessId;
        this.etag = metadata.etag;
        this.id = metadata.id;
        this.projectId = metadata.projectId;
        this.serviceAccount = metadata.serviceAccount;
        this.state = metadata.state;
        this.createTime = metadata.createTime;
        this.updateTime = metadata.updateTime;
      }

      public Builder setAccessId(String accessId) {
        this.accessId = accessId;
        return this;
      }

      public Builder setEtag(String etag) {
        this.etag = etag;
        return this;
      }

      public Builder setId(String id) {
        this.id = id;
        return this;
      }

      public Builder setServiceAccount(ServiceAccount serviceAccount) {
        this.serviceAccount = serviceAccount;
        return this;
      }

      public Builder setState(HmacKeyState state) {
        this.state = state;
        return this;
      }

      public Builder setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
      }

      public Builder setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
      }

      /** Creates an {@code HmacKeyMetadata} object from this builder. * */
      public HmacKeyMetadata build() {
        return new HmacKeyMetadata(this);
      }

      public Builder setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
        return this;
      }
    }
  }
}
