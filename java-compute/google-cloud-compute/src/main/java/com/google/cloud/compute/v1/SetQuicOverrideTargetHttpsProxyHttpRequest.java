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
 * Request object for method compute.targetHttpsProxies.setQuicOverride. Sets the QUIC override
 * policy for TargetHttpsProxy.
 */
public final class SetQuicOverrideTargetHttpsProxyHttpRequest implements ApiMessage {
  private final String access_token;
  private final String callback;
  private final String fields;
  private final String key;
  private final String prettyPrint;
  private final String quotaUser;
  private final String requestId;
  private final TargetHttpsProxiesSetQuicOverrideRequest
      targetHttpsProxiesSetQuicOverrideRequestResource;
  private final String targetHttpsProxy;
  private final String userIp;

  private SetQuicOverrideTargetHttpsProxyHttpRequest() {
    this.access_token = null;
    this.callback = null;
    this.fields = null;
    this.key = null;
    this.prettyPrint = null;
    this.quotaUser = null;
    this.requestId = null;
    this.targetHttpsProxiesSetQuicOverrideRequestResource = null;
    this.targetHttpsProxy = null;
    this.userIp = null;
  }

  private SetQuicOverrideTargetHttpsProxyHttpRequest(
      String access_token,
      String callback,
      String fields,
      String key,
      String prettyPrint,
      String quotaUser,
      String requestId,
      TargetHttpsProxiesSetQuicOverrideRequest targetHttpsProxiesSetQuicOverrideRequestResource,
      String targetHttpsProxy,
      String userIp) {
    this.access_token = access_token;
    this.callback = callback;
    this.fields = fields;
    this.key = key;
    this.prettyPrint = prettyPrint;
    this.quotaUser = quotaUser;
    this.requestId = requestId;
    this.targetHttpsProxiesSetQuicOverrideRequestResource =
        targetHttpsProxiesSetQuicOverrideRequestResource;
    this.targetHttpsProxy = targetHttpsProxy;
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
    if ("key".equals(fieldName)) {
      return key;
    }
    if ("prettyPrint".equals(fieldName)) {
      return prettyPrint;
    }
    if ("quotaUser".equals(fieldName)) {
      return quotaUser;
    }
    if ("requestId".equals(fieldName)) {
      return requestId;
    }
    if ("targetHttpsProxiesSetQuicOverrideRequestResource".equals(fieldName)) {
      return targetHttpsProxiesSetQuicOverrideRequestResource;
    }
    if ("targetHttpsProxy".equals(fieldName)) {
      return targetHttpsProxy;
    }
    if ("userIp".equals(fieldName)) {
      return userIp;
    }
    return null;
  }

  @Nullable
  @Override
  public TargetHttpsProxiesSetQuicOverrideRequest getApiMessageRequestBody() {
    return targetHttpsProxiesSetQuicOverrideRequestResource;
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

  public String getRequestId() {
    return requestId;
  }

  public TargetHttpsProxiesSetQuicOverrideRequest
      getTargetHttpsProxiesSetQuicOverrideRequestResource() {
    return targetHttpsProxiesSetQuicOverrideRequestResource;
  }

  public String getTargetHttpsProxy() {
    return targetHttpsProxy;
  }

  public String getUserIp() {
    return userIp;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SetQuicOverrideTargetHttpsProxyHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SetQuicOverrideTargetHttpsProxyHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SetQuicOverrideTargetHttpsProxyHttpRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SetQuicOverrideTargetHttpsProxyHttpRequest();
  }

  public static class Builder {
    private String access_token;
    private String callback;
    private String fields;
    private String key;
    private String prettyPrint;
    private String quotaUser;
    private String requestId;
    private TargetHttpsProxiesSetQuicOverrideRequest
        targetHttpsProxiesSetQuicOverrideRequestResource;
    private String targetHttpsProxy;
    private String userIp;

    Builder() {}

    public Builder mergeFrom(SetQuicOverrideTargetHttpsProxyHttpRequest other) {
      if (other == SetQuicOverrideTargetHttpsProxyHttpRequest.getDefaultInstance()) return this;
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
      if (other.getRequestId() != null) {
        this.requestId = other.requestId;
      }
      if (other.getTargetHttpsProxiesSetQuicOverrideRequestResource() != null) {
        this.targetHttpsProxiesSetQuicOverrideRequestResource =
            other.targetHttpsProxiesSetQuicOverrideRequestResource;
      }
      if (other.getTargetHttpsProxy() != null) {
        this.targetHttpsProxy = other.targetHttpsProxy;
      }
      if (other.getUserIp() != null) {
        this.userIp = other.userIp;
      }
      return this;
    }

    Builder(SetQuicOverrideTargetHttpsProxyHttpRequest source) {
      this.access_token = source.access_token;
      this.callback = source.callback;
      this.fields = source.fields;
      this.key = source.key;
      this.prettyPrint = source.prettyPrint;
      this.quotaUser = source.quotaUser;
      this.requestId = source.requestId;
      this.targetHttpsProxiesSetQuicOverrideRequestResource =
          source.targetHttpsProxiesSetQuicOverrideRequestResource;
      this.targetHttpsProxy = source.targetHttpsProxy;
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

    public String getRequestId() {
      return requestId;
    }

    public Builder setRequestId(String requestId) {
      this.requestId = requestId;
      return this;
    }

    public TargetHttpsProxiesSetQuicOverrideRequest
        getTargetHttpsProxiesSetQuicOverrideRequestResource() {
      return targetHttpsProxiesSetQuicOverrideRequestResource;
    }

    public Builder setTargetHttpsProxiesSetQuicOverrideRequestResource(
        TargetHttpsProxiesSetQuicOverrideRequest targetHttpsProxiesSetQuicOverrideRequestResource) {
      this.targetHttpsProxiesSetQuicOverrideRequestResource =
          targetHttpsProxiesSetQuicOverrideRequestResource;
      return this;
    }

    public String getTargetHttpsProxy() {
      return targetHttpsProxy;
    }

    public Builder setTargetHttpsProxy(String targetHttpsProxy) {
      this.targetHttpsProxy = targetHttpsProxy;
      return this;
    }

    public String getUserIp() {
      return userIp;
    }

    public Builder setUserIp(String userIp) {
      this.userIp = userIp;
      return this;
    }

    public SetQuicOverrideTargetHttpsProxyHttpRequest build() {
      String missing = "";

      if (targetHttpsProxy == null) {
        missing += " targetHttpsProxy";
      }

      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new SetQuicOverrideTargetHttpsProxyHttpRequest(
          access_token,
          callback,
          fields,
          key,
          prettyPrint,
          quotaUser,
          requestId,
          targetHttpsProxiesSetQuicOverrideRequestResource,
          targetHttpsProxy,
          userIp);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAccessToken(this.access_token);
      newBuilder.setCallback(this.callback);
      newBuilder.setFields(this.fields);
      newBuilder.setKey(this.key);
      newBuilder.setPrettyPrint(this.prettyPrint);
      newBuilder.setQuotaUser(this.quotaUser);
      newBuilder.setRequestId(this.requestId);
      newBuilder.setTargetHttpsProxiesSetQuicOverrideRequestResource(
          this.targetHttpsProxiesSetQuicOverrideRequestResource);
      newBuilder.setTargetHttpsProxy(this.targetHttpsProxy);
      newBuilder.setUserIp(this.userIp);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SetQuicOverrideTargetHttpsProxyHttpRequest{"
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
        + "requestId="
        + requestId
        + ", "
        + "targetHttpsProxiesSetQuicOverrideRequestResource="
        + targetHttpsProxiesSetQuicOverrideRequestResource
        + ", "
        + "targetHttpsProxy="
        + targetHttpsProxy
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
    if (o instanceof SetQuicOverrideTargetHttpsProxyHttpRequest) {
      SetQuicOverrideTargetHttpsProxyHttpRequest that =
          (SetQuicOverrideTargetHttpsProxyHttpRequest) o;
      return Objects.equals(this.access_token, that.getAccessToken())
          && Objects.equals(this.callback, that.getCallback())
          && Objects.equals(this.fields, that.getFields())
          && Objects.equals(this.key, that.getKey())
          && Objects.equals(this.prettyPrint, that.getPrettyPrint())
          && Objects.equals(this.quotaUser, that.getQuotaUser())
          && Objects.equals(this.requestId, that.getRequestId())
          && Objects.equals(
              this.targetHttpsProxiesSetQuicOverrideRequestResource,
              that.getTargetHttpsProxiesSetQuicOverrideRequestResource())
          && Objects.equals(this.targetHttpsProxy, that.getTargetHttpsProxy())
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
        key,
        prettyPrint,
        quotaUser,
        requestId,
        targetHttpsProxiesSetQuicOverrideRequestResource,
        targetHttpsProxy,
        userIp);
  }
}
