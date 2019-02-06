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
 * Request object for method compute.images.setLabels. Sets the labels on an image. To learn more
 * about labels, read the Labeling Resources documentation.
 */
public final class SetLabelsImageHttpRequest implements ApiMessage {
  private final String access_token;
  private final String callback;
  private final String fields;
  private final GlobalSetLabelsRequest globalSetLabelsRequestResource;
  private final String key;
  private final String prettyPrint;
  private final String quotaUser;
  private final String resource;
  private final String userIp;

  private SetLabelsImageHttpRequest() {
    this.access_token = null;
    this.callback = null;
    this.fields = null;
    this.globalSetLabelsRequestResource = null;
    this.key = null;
    this.prettyPrint = null;
    this.quotaUser = null;
    this.resource = null;
    this.userIp = null;
  }

  private SetLabelsImageHttpRequest(
      String access_token,
      String callback,
      String fields,
      GlobalSetLabelsRequest globalSetLabelsRequestResource,
      String key,
      String prettyPrint,
      String quotaUser,
      String resource,
      String userIp) {
    this.access_token = access_token;
    this.callback = callback;
    this.fields = fields;
    this.globalSetLabelsRequestResource = globalSetLabelsRequestResource;
    this.key = key;
    this.prettyPrint = prettyPrint;
    this.quotaUser = quotaUser;
    this.resource = resource;
    this.userIp = userIp;
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
    if ("globalSetLabelsRequestResource".equals(fieldName)) {
      return globalSetLabelsRequestResource;
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
    return null;
  }

  @Nullable
  @Override
  public GlobalSetLabelsRequest getApiMessageRequestBody() {
    return globalSetLabelsRequestResource;
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

  public GlobalSetLabelsRequest getGlobalSetLabelsRequestResource() {
    return globalSetLabelsRequestResource;
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

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SetLabelsImageHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SetLabelsImageHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SetLabelsImageHttpRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SetLabelsImageHttpRequest();
  }

  public static class Builder {
    private String access_token;
    private String callback;
    private String fields;
    private GlobalSetLabelsRequest globalSetLabelsRequestResource;
    private String key;
    private String prettyPrint;
    private String quotaUser;
    private String resource;
    private String userIp;

    Builder() {}

    public Builder mergeFrom(SetLabelsImageHttpRequest other) {
      if (other == SetLabelsImageHttpRequest.getDefaultInstance()) return this;
      if (other.getAccessToken() != null) {
        this.access_token = other.access_token;
      }
      if (other.getCallback() != null) {
        this.callback = other.callback;
      }
      if (other.getFields() != null) {
        this.fields = other.fields;
      }
      if (other.getGlobalSetLabelsRequestResource() != null) {
        this.globalSetLabelsRequestResource = other.globalSetLabelsRequestResource;
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
      return this;
    }

    Builder(SetLabelsImageHttpRequest source) {
      this.access_token = source.access_token;
      this.callback = source.callback;
      this.fields = source.fields;
      this.globalSetLabelsRequestResource = source.globalSetLabelsRequestResource;
      this.key = source.key;
      this.prettyPrint = source.prettyPrint;
      this.quotaUser = source.quotaUser;
      this.resource = source.resource;
      this.userIp = source.userIp;
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

    public GlobalSetLabelsRequest getGlobalSetLabelsRequestResource() {
      return globalSetLabelsRequestResource;
    }

    public Builder setGlobalSetLabelsRequestResource(
        GlobalSetLabelsRequest globalSetLabelsRequestResource) {
      this.globalSetLabelsRequestResource = globalSetLabelsRequestResource;
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

    public SetLabelsImageHttpRequest build() {
      String missing = "";

      if (resource == null) {
        missing += " resource";
      }

      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new SetLabelsImageHttpRequest(
          access_token,
          callback,
          fields,
          globalSetLabelsRequestResource,
          key,
          prettyPrint,
          quotaUser,
          resource,
          userIp);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAccessToken(this.access_token);
      newBuilder.setCallback(this.callback);
      newBuilder.setFields(this.fields);
      newBuilder.setGlobalSetLabelsRequestResource(this.globalSetLabelsRequestResource);
      newBuilder.setKey(this.key);
      newBuilder.setPrettyPrint(this.prettyPrint);
      newBuilder.setQuotaUser(this.quotaUser);
      newBuilder.setResource(this.resource);
      newBuilder.setUserIp(this.userIp);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SetLabelsImageHttpRequest{"
        + "access_token="
        + access_token
        + ", "
        + "callback="
        + callback
        + ", "
        + "fields="
        + fields
        + ", "
        + "globalSetLabelsRequestResource="
        + globalSetLabelsRequestResource
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
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SetLabelsImageHttpRequest) {
      SetLabelsImageHttpRequest that = (SetLabelsImageHttpRequest) o;
      return Objects.equals(this.access_token, that.getAccessToken())
          && Objects.equals(this.callback, that.getCallback())
          && Objects.equals(this.fields, that.getFields())
          && Objects.equals(
              this.globalSetLabelsRequestResource, that.getGlobalSetLabelsRequestResource())
          && Objects.equals(this.key, that.getKey())
          && Objects.equals(this.prettyPrint, that.getPrettyPrint())
          && Objects.equals(this.quotaUser, that.getQuotaUser())
          && Objects.equals(this.resource, that.getResource())
          && Objects.equals(this.userIp, that.getUserIp());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        access_token,
        callback,
        fields,
        globalSetLabelsRequestResource,
        key,
        prettyPrint,
        quotaUser,
        resource,
        userIp);
  }
}
