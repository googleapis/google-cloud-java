/*
 * Copyright 2018 Google LLC
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
public final class GetHealthBackendServiceHttpRequest implements ApiMessage {
  private final String access_token;
  private final String backendService;
  private final String callback;
  private final String fields;
  private final String key;
  private final String prettyPrint;
  private final String quotaUser;
  private final ResourceGroupReference resourceGroupReferenceResource;
  private final String userIp;

  private GetHealthBackendServiceHttpRequest() {
    this.access_token = null;
    this.backendService = null;
    this.callback = null;
    this.fields = null;
    this.key = null;
    this.prettyPrint = null;
    this.quotaUser = null;
    this.resourceGroupReferenceResource = null;
    this.userIp = null;
  }

  private GetHealthBackendServiceHttpRequest(
      String access_token,
      String backendService,
      String callback,
      String fields,
      String key,
      String prettyPrint,
      String quotaUser,
      ResourceGroupReference resourceGroupReferenceResource,
      String userIp) {
    this.access_token = access_token;
    this.backendService = backendService;
    this.callback = callback;
    this.fields = fields;
    this.key = key;
    this.prettyPrint = prettyPrint;
    this.quotaUser = quotaUser;
    this.resourceGroupReferenceResource = resourceGroupReferenceResource;
    this.userIp = userIp;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("access_token")) {
      return access_token;
    }
    if (fieldName.equals("backendService")) {
      return backendService;
    }
    if (fieldName.equals("callback")) {
      return callback;
    }
    if (fieldName.equals("fields")) {
      return fields;
    }
    if (fieldName.equals("key")) {
      return key;
    }
    if (fieldName.equals("prettyPrint")) {
      return prettyPrint;
    }
    if (fieldName.equals("quotaUser")) {
      return quotaUser;
    }
    if (fieldName.equals("resourceGroupReferenceResource")) {
      return resourceGroupReferenceResource;
    }
    if (fieldName.equals("userIp")) {
      return userIp;
    }
    return null;
  }

  @Nullable
  @Override
  public ResourceGroupReference getApiMessageRequestBody() {
    return resourceGroupReferenceResource;
  }

  @Nullable
  @Override
  public List<String> getFieldMask() {
    return null;
  }

  public String getAccessToken() {
    return access_token;
  }

  public String getBackendService() {
    return backendService;
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

  public ResourceGroupReference getResourceGroupReferenceResource() {
    return resourceGroupReferenceResource;
  }

  public String getUserIp() {
    return userIp;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(GetHealthBackendServiceHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static GetHealthBackendServiceHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final GetHealthBackendServiceHttpRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new GetHealthBackendServiceHttpRequest();
  }

  public static class Builder {
    private String access_token;
    private String backendService;
    private String callback;
    private String fields;
    private String key;
    private String prettyPrint;
    private String quotaUser;
    private ResourceGroupReference resourceGroupReferenceResource;
    private String userIp;

    Builder() {}

    public Builder mergeFrom(GetHealthBackendServiceHttpRequest other) {
      if (other == GetHealthBackendServiceHttpRequest.getDefaultInstance()) return this;
      if (other.getAccessToken() != null) {
        this.access_token = other.access_token;
      }
      if (other.getBackendService() != null) {
        this.backendService = other.backendService;
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
      if (other.getResourceGroupReferenceResource() != null) {
        this.resourceGroupReferenceResource = other.resourceGroupReferenceResource;
      }
      if (other.getUserIp() != null) {
        this.userIp = other.userIp;
      }
      return this;
    }

    Builder(GetHealthBackendServiceHttpRequest source) {
      this.access_token = source.access_token;
      this.backendService = source.backendService;
      this.callback = source.callback;
      this.fields = source.fields;
      this.key = source.key;
      this.prettyPrint = source.prettyPrint;
      this.quotaUser = source.quotaUser;
      this.resourceGroupReferenceResource = source.resourceGroupReferenceResource;
      this.userIp = source.userIp;
    }

    public String getAccessToken() {
      return access_token;
    }

    public Builder setAccessToken(String access_token) {
      this.access_token = access_token;
      return this;
    }

    public String getBackendService() {
      return backendService;
    }

    public Builder setBackendService(String backendService) {
      this.backendService = backendService;
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

    public ResourceGroupReference getResourceGroupReferenceResource() {
      return resourceGroupReferenceResource;
    }

    public Builder setResourceGroupReferenceResource(
        ResourceGroupReference resourceGroupReferenceResource) {
      this.resourceGroupReferenceResource = resourceGroupReferenceResource;
      return this;
    }

    public String getUserIp() {
      return userIp;
    }

    public Builder setUserIp(String userIp) {
      this.userIp = userIp;
      return this;
    }

    public GetHealthBackendServiceHttpRequest build() {
      String missing = "";

      if (backendService == null) {
        missing += " backendService";
      }

      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new GetHealthBackendServiceHttpRequest(
          access_token,
          backendService,
          callback,
          fields,
          key,
          prettyPrint,
          quotaUser,
          resourceGroupReferenceResource,
          userIp);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAccessToken(this.access_token);
      newBuilder.setBackendService(this.backendService);
      newBuilder.setCallback(this.callback);
      newBuilder.setFields(this.fields);
      newBuilder.setKey(this.key);
      newBuilder.setPrettyPrint(this.prettyPrint);
      newBuilder.setQuotaUser(this.quotaUser);
      newBuilder.setResourceGroupReferenceResource(this.resourceGroupReferenceResource);
      newBuilder.setUserIp(this.userIp);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "GetHealthBackendServiceHttpRequest{"
        + "access_token="
        + access_token
        + ", "
        + "backendService="
        + backendService
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
        + "resourceGroupReferenceResource="
        + resourceGroupReferenceResource
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
    if (o instanceof GetHealthBackendServiceHttpRequest) {
      GetHealthBackendServiceHttpRequest that = (GetHealthBackendServiceHttpRequest) o;
      return Objects.equals(this.access_token, that.getAccessToken())
          && Objects.equals(this.backendService, that.getBackendService())
          && Objects.equals(this.callback, that.getCallback())
          && Objects.equals(this.fields, that.getFields())
          && Objects.equals(this.key, that.getKey())
          && Objects.equals(this.prettyPrint, that.getPrettyPrint())
          && Objects.equals(this.quotaUser, that.getQuotaUser())
          && Objects.equals(
              this.resourceGroupReferenceResource, that.getResourceGroupReferenceResource())
          && Objects.equals(this.userIp, that.getUserIp());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        access_token,
        backendService,
        callback,
        fields,
        key,
        prettyPrint,
        quotaUser,
        resourceGroupReferenceResource,
        userIp);
  }
}
