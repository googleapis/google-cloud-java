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
 * Request object for method compute.instances.setIamPolicy. Sets the access control policy on the
 * specified resource. Replaces any existing policy.
 */
public final class SetIamPolicyInstanceHttpRequest implements ApiMessage {
  private final String access_token;
  private final String callback;
  private final String fields;
  private final String key;
  private final String prettyPrint;
  private final String quotaUser;
  private final String resource;
  private final String userIp;
  private final ZoneSetPolicyRequest zoneSetPolicyRequestResource;

  private SetIamPolicyInstanceHttpRequest() {
    this.access_token = null;
    this.callback = null;
    this.fields = null;
    this.key = null;
    this.prettyPrint = null;
    this.quotaUser = null;
    this.resource = null;
    this.userIp = null;
    this.zoneSetPolicyRequestResource = null;
  }

  private SetIamPolicyInstanceHttpRequest(
      String access_token,
      String callback,
      String fields,
      String key,
      String prettyPrint,
      String quotaUser,
      String resource,
      String userIp,
      ZoneSetPolicyRequest zoneSetPolicyRequestResource) {
    this.access_token = access_token;
    this.callback = callback;
    this.fields = fields;
    this.key = key;
    this.prettyPrint = prettyPrint;
    this.quotaUser = quotaUser;
    this.resource = resource;
    this.userIp = userIp;
    this.zoneSetPolicyRequestResource = zoneSetPolicyRequestResource;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("access_token".equals(fieldName)) {
      return access_token;
    }
    if ("callback".equals(fieldName)) {
      return callback;
    }
    if ("fields".equals(fieldName)) {
      return fields;
    }
    if ("key".equals(fieldName)) {
      return key;
    }
    if ("prettyPrint".equals(fieldName)) {
      return prettyPrint;
    }
    if ("quotaUser".equals(fieldName)) {
      return quotaUser;
    }
    if ("resource".equals(fieldName)) {
      return resource;
    }
    if ("userIp".equals(fieldName)) {
      return userIp;
    }
    if ("zoneSetPolicyRequestResource".equals(fieldName)) {
      return zoneSetPolicyRequestResource;
    }
    return null;
  }

  @Nullable
  @Override
  public ZoneSetPolicyRequest getApiMessageRequestBody() {
    return zoneSetPolicyRequestResource;
  }

  @Nullable
  @Override
  public List<String> getFieldMask() {
    return null;
  }

  public String getAccessToken() {
    return access_token;
  }

  public String getCallback() {
    return callback;
  }

  public String getFields() {
    return fields;
  }

  public String getKey() {
    return key;
  }

  public String getPrettyPrint() {
    return prettyPrint;
  }

  public String getQuotaUser() {
    return quotaUser;
  }

  public String getResource() {
    return resource;
  }

  public String getUserIp() {
    return userIp;
  }

  public ZoneSetPolicyRequest getZoneSetPolicyRequestResource() {
    return zoneSetPolicyRequestResource;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SetIamPolicyInstanceHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SetIamPolicyInstanceHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SetIamPolicyInstanceHttpRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SetIamPolicyInstanceHttpRequest();
  }

  public static class Builder {
    private String access_token;
    private String callback;
    private String fields;
    private String key;
    private String prettyPrint;
    private String quotaUser;
    private String resource;
    private String userIp;
    private ZoneSetPolicyRequest zoneSetPolicyRequestResource;

    Builder() {}

    public Builder mergeFrom(SetIamPolicyInstanceHttpRequest other) {
      if (other == SetIamPolicyInstanceHttpRequest.getDefaultInstance()) return this;
      if (other.getAccessToken() != null) {
        this.access_token = other.access_token;
      }
      if (other.getCallback() != null) {
        this.callback = other.callback;
      }
      if (other.getFields() != null) {
        this.fields = other.fields;
      }
      if (other.getKey() != null) {
        this.key = other.key;
      }
      if (other.getPrettyPrint() != null) {
        this.prettyPrint = other.prettyPrint;
      }
      if (other.getQuotaUser() != null) {
        this.quotaUser = other.quotaUser;
      }
      if (other.getResource() != null) {
        this.resource = other.resource;
      }
      if (other.getUserIp() != null) {
        this.userIp = other.userIp;
      }
      if (other.getZoneSetPolicyRequestResource() != null) {
        this.zoneSetPolicyRequestResource = other.zoneSetPolicyRequestResource;
      }
      return this;
    }

    Builder(SetIamPolicyInstanceHttpRequest source) {
      this.access_token = source.access_token;
      this.callback = source.callback;
      this.fields = source.fields;
      this.key = source.key;
      this.prettyPrint = source.prettyPrint;
      this.quotaUser = source.quotaUser;
      this.resource = source.resource;
      this.userIp = source.userIp;
      this.zoneSetPolicyRequestResource = source.zoneSetPolicyRequestResource;
    }

    public String getAccessToken() {
      return access_token;
    }

    public Builder setAccessToken(String access_token) {
      this.access_token = access_token;
      return this;
    }

    public String getCallback() {
      return callback;
    }

    public Builder setCallback(String callback) {
      this.callback = callback;
      return this;
    }

    public String getFields() {
      return fields;
    }

    public Builder setFields(String fields) {
      this.fields = fields;
      return this;
    }

    public String getKey() {
      return key;
    }

    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    public String getPrettyPrint() {
      return prettyPrint;
    }

    public Builder setPrettyPrint(String prettyPrint) {
      this.prettyPrint = prettyPrint;
      return this;
    }

    public String getQuotaUser() {
      return quotaUser;
    }

    public Builder setQuotaUser(String quotaUser) {
      this.quotaUser = quotaUser;
      return this;
    }

    public String getResource() {
      return resource;
    }

    public Builder setResource(String resource) {
      this.resource = resource;
      return this;
    }

    public String getUserIp() {
      return userIp;
    }

    public Builder setUserIp(String userIp) {
      this.userIp = userIp;
      return this;
    }

    public ZoneSetPolicyRequest getZoneSetPolicyRequestResource() {
      return zoneSetPolicyRequestResource;
    }

    public Builder setZoneSetPolicyRequestResource(
        ZoneSetPolicyRequest zoneSetPolicyRequestResource) {
      this.zoneSetPolicyRequestResource = zoneSetPolicyRequestResource;
      return this;
    }

    public SetIamPolicyInstanceHttpRequest build() {
      String missing = "";

      if (resource == null) {
        missing += " resource";
      }

      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new SetIamPolicyInstanceHttpRequest(
          access_token,
          callback,
          fields,
          key,
          prettyPrint,
          quotaUser,
          resource,
          userIp,
          zoneSetPolicyRequestResource);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAccessToken(this.access_token);
      newBuilder.setCallback(this.callback);
      newBuilder.setFields(this.fields);
      newBuilder.setKey(this.key);
      newBuilder.setPrettyPrint(this.prettyPrint);
      newBuilder.setQuotaUser(this.quotaUser);
      newBuilder.setResource(this.resource);
      newBuilder.setUserIp(this.userIp);
      newBuilder.setZoneSetPolicyRequestResource(this.zoneSetPolicyRequestResource);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SetIamPolicyInstanceHttpRequest{"
        + "access_token="
        + access_token
        + ", "
        + "callback="
        + callback
        + ", "
        + "fields="
        + fields
        + ", "
        + "key="
        + key
        + ", "
        + "prettyPrint="
        + prettyPrint
        + ", "
        + "quotaUser="
        + quotaUser
        + ", "
        + "resource="
        + resource
        + ", "
        + "userIp="
        + userIp
        + ", "
        + "zoneSetPolicyRequestResource="
        + zoneSetPolicyRequestResource
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SetIamPolicyInstanceHttpRequest) {
      SetIamPolicyInstanceHttpRequest that = (SetIamPolicyInstanceHttpRequest) o;
      return Objects.equals(this.access_token, that.getAccessToken())
          && Objects.equals(this.callback, that.getCallback())
          && Objects.equals(this.fields, that.getFields())
          && Objects.equals(this.key, that.getKey())
          && Objects.equals(this.prettyPrint, that.getPrettyPrint())
          && Objects.equals(this.quotaUser, that.getQuotaUser())
          && Objects.equals(this.resource, that.getResource())
          && Objects.equals(this.userIp, that.getUserIp())
          && Objects.equals(
              this.zoneSetPolicyRequestResource, that.getZoneSetPolicyRequestResource());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        access_token,
        callback,
        fields,
        key,
        prettyPrint,
        quotaUser,
        resource,
        userIp,
        zoneSetPolicyRequestResource);
  }
}
