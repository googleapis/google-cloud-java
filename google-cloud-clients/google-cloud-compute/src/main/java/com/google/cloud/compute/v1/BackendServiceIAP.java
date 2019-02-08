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
/** Identity-Aware Proxy */
public final class BackendServiceIAP implements ApiMessage {
  private final Boolean enabled;
  private final String oauth2ClientId;
  private final String oauth2ClientSecret;
  private final String oauth2ClientSecretSha256;

  private BackendServiceIAP() {
    this.enabled = null;
    this.oauth2ClientId = null;
    this.oauth2ClientSecret = null;
    this.oauth2ClientSecretSha256 = null;
  }

  private BackendServiceIAP(
      Boolean enabled,
      String oauth2ClientId,
      String oauth2ClientSecret,
      String oauth2ClientSecretSha256) {
    this.enabled = enabled;
    this.oauth2ClientId = oauth2ClientId;
    this.oauth2ClientSecret = oauth2ClientSecret;
    this.oauth2ClientSecretSha256 = oauth2ClientSecretSha256;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("enabled".equals(fieldName)) {
      return enabled;
    }
    if ("oauth2ClientId".equals(fieldName)) {
      return oauth2ClientId;
    }
    if ("oauth2ClientSecret".equals(fieldName)) {
      return oauth2ClientSecret;
    }
    if ("oauth2ClientSecretSha256".equals(fieldName)) {
      return oauth2ClientSecretSha256;
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

  public Boolean getEnabled() {
    return enabled;
  }

  public String getOauth2ClientId() {
    return oauth2ClientId;
  }

  public String getOauth2ClientSecret() {
    return oauth2ClientSecret;
  }

  /** [Output Only] SHA256 hash value for the field oauth2_client_secret above. */
  public String getOauth2ClientSecretSha256() {
    return oauth2ClientSecretSha256;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(BackendServiceIAP prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static BackendServiceIAP getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final BackendServiceIAP DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new BackendServiceIAP();
  }

  public static class Builder {
    private Boolean enabled;
    private String oauth2ClientId;
    private String oauth2ClientSecret;
    private String oauth2ClientSecretSha256;

    Builder() {}

    public Builder mergeFrom(BackendServiceIAP other) {
      if (other == BackendServiceIAP.getDefaultInstance()) return this;
      if (other.getEnabled() != null) {
        this.enabled = other.enabled;
      }
      if (other.getOauth2ClientId() != null) {
        this.oauth2ClientId = other.oauth2ClientId;
      }
      if (other.getOauth2ClientSecret() != null) {
        this.oauth2ClientSecret = other.oauth2ClientSecret;
      }
      if (other.getOauth2ClientSecretSha256() != null) {
        this.oauth2ClientSecretSha256 = other.oauth2ClientSecretSha256;
      }
      return this;
    }

    Builder(BackendServiceIAP source) {
      this.enabled = source.enabled;
      this.oauth2ClientId = source.oauth2ClientId;
      this.oauth2ClientSecret = source.oauth2ClientSecret;
      this.oauth2ClientSecretSha256 = source.oauth2ClientSecretSha256;
    }

    public Boolean getEnabled() {
      return enabled;
    }

    public Builder setEnabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    public String getOauth2ClientId() {
      return oauth2ClientId;
    }

    public Builder setOauth2ClientId(String oauth2ClientId) {
      this.oauth2ClientId = oauth2ClientId;
      return this;
    }

    public String getOauth2ClientSecret() {
      return oauth2ClientSecret;
    }

    public Builder setOauth2ClientSecret(String oauth2ClientSecret) {
      this.oauth2ClientSecret = oauth2ClientSecret;
      return this;
    }

    /** [Output Only] SHA256 hash value for the field oauth2_client_secret above. */
    public String getOauth2ClientSecretSha256() {
      return oauth2ClientSecretSha256;
    }

    /** [Output Only] SHA256 hash value for the field oauth2_client_secret above. */
    public Builder setOauth2ClientSecretSha256(String oauth2ClientSecretSha256) {
      this.oauth2ClientSecretSha256 = oauth2ClientSecretSha256;
      return this;
    }

    public BackendServiceIAP build() {

      return new BackendServiceIAP(
          enabled, oauth2ClientId, oauth2ClientSecret, oauth2ClientSecretSha256);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setEnabled(this.enabled);
      newBuilder.setOauth2ClientId(this.oauth2ClientId);
      newBuilder.setOauth2ClientSecret(this.oauth2ClientSecret);
      newBuilder.setOauth2ClientSecretSha256(this.oauth2ClientSecretSha256);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "BackendServiceIAP{"
        + "enabled="
        + enabled
        + ", "
        + "oauth2ClientId="
        + oauth2ClientId
        + ", "
        + "oauth2ClientSecret="
        + oauth2ClientSecret
        + ", "
        + "oauth2ClientSecretSha256="
        + oauth2ClientSecretSha256
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BackendServiceIAP) {
      BackendServiceIAP that = (BackendServiceIAP) o;
      return Objects.equals(this.enabled, that.getEnabled())
          && Objects.equals(this.oauth2ClientId, that.getOauth2ClientId())
          && Objects.equals(this.oauth2ClientSecret, that.getOauth2ClientSecret())
          && Objects.equals(this.oauth2ClientSecretSha256, that.getOauth2ClientSecretSha256());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, oauth2ClientId, oauth2ClientSecret, oauth2ClientSecretSha256);
  }
}
