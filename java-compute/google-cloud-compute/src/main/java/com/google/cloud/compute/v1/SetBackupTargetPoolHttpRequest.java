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
public final class SetBackupTargetPoolHttpRequest implements ApiMessage {
  private final String access_token;
  private final String callback;
  private final Float failoverRatio;
  private final String fields;
  private final String key;
  private final String prettyPrint;
  private final String quotaUser;
  private final String requestId;
  private final String targetPool;
  private final TargetReference targetReferenceResource;
  private final String userIp;

  private SetBackupTargetPoolHttpRequest() {
    this.access_token = null;
    this.callback = null;
    this.failoverRatio = null;
    this.fields = null;
    this.key = null;
    this.prettyPrint = null;
    this.quotaUser = null;
    this.requestId = null;
    this.targetPool = null;
    this.targetReferenceResource = null;
    this.userIp = null;
  }

  private SetBackupTargetPoolHttpRequest(
      String access_token,
      String callback,
      Float failoverRatio,
      String fields,
      String key,
      String prettyPrint,
      String quotaUser,
      String requestId,
      String targetPool,
      TargetReference targetReferenceResource,
      String userIp) {
    this.access_token = access_token;
    this.callback = callback;
    this.failoverRatio = failoverRatio;
    this.fields = fields;
    this.key = key;
    this.prettyPrint = prettyPrint;
    this.quotaUser = quotaUser;
    this.requestId = requestId;
    this.targetPool = targetPool;
    this.targetReferenceResource = targetReferenceResource;
    this.userIp = userIp;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("access_token")) {
      return access_token;
    }
    if (fieldName.equals("callback")) {
      return callback;
    }
    if (fieldName.equals("failoverRatio")) {
      return failoverRatio;
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
    if (fieldName.equals("requestId")) {
      return requestId;
    }
    if (fieldName.equals("targetPool")) {
      return targetPool;
    }
    if (fieldName.equals("targetReferenceResource")) {
      return targetReferenceResource;
    }
    if (fieldName.equals("userIp")) {
      return userIp;
    }
    return null;
  }

  @Nullable
  @Override
  public TargetReference getApiMessageRequestBody() {
    return targetReferenceResource;
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

  public Float getFailoverRatio() {
    return failoverRatio;
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

  public String getTargetPool() {
    return targetPool;
  }

  public TargetReference getTargetReferenceResource() {
    return targetReferenceResource;
  }

  public String getUserIp() {
    return userIp;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SetBackupTargetPoolHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SetBackupTargetPoolHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SetBackupTargetPoolHttpRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SetBackupTargetPoolHttpRequest();
  }

  public static class Builder {
    private String access_token;
    private String callback;
    private Float failoverRatio;
    private String fields;
    private String key;
    private String prettyPrint;
    private String quotaUser;
    private String requestId;
    private String targetPool;
    private TargetReference targetReferenceResource;
    private String userIp;

    Builder() {}

    public Builder mergeFrom(SetBackupTargetPoolHttpRequest other) {
      if (other == SetBackupTargetPoolHttpRequest.getDefaultInstance()) return this;
      if (other.getAccessToken() != null) {
        this.access_token = other.access_token;
      }
      if (other.getCallback() != null) {
        this.callback = other.callback;
      }
      if (other.getFailoverRatio() != null) {
        this.failoverRatio = other.failoverRatio;
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
      if (other.getTargetPool() != null) {
        this.targetPool = other.targetPool;
      }
      if (other.getTargetReferenceResource() != null) {
        this.targetReferenceResource = other.targetReferenceResource;
      }
      if (other.getUserIp() != null) {
        this.userIp = other.userIp;
      }
      return this;
    }

    Builder(SetBackupTargetPoolHttpRequest source) {
      this.access_token = source.access_token;
      this.callback = source.callback;
      this.failoverRatio = source.failoverRatio;
      this.fields = source.fields;
      this.key = source.key;
      this.prettyPrint = source.prettyPrint;
      this.quotaUser = source.quotaUser;
      this.requestId = source.requestId;
      this.targetPool = source.targetPool;
      this.targetReferenceResource = source.targetReferenceResource;
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

    public Float getFailoverRatio() {
      return failoverRatio;
    }

    public Builder setFailoverRatio(Float failoverRatio) {
      this.failoverRatio = failoverRatio;
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

    public String getTargetPool() {
      return targetPool;
    }

    public Builder setTargetPool(String targetPool) {
      this.targetPool = targetPool;
      return this;
    }

    public TargetReference getTargetReferenceResource() {
      return targetReferenceResource;
    }

    public Builder setTargetReferenceResource(TargetReference targetReferenceResource) {
      this.targetReferenceResource = targetReferenceResource;
      return this;
    }

    public String getUserIp() {
      return userIp;
    }

    public Builder setUserIp(String userIp) {
      this.userIp = userIp;
      return this;
    }

    public SetBackupTargetPoolHttpRequest build() {
      String missing = "";

      if (targetPool == null) {
        missing += " targetPool";
      }

      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new SetBackupTargetPoolHttpRequest(
          access_token,
          callback,
          failoverRatio,
          fields,
          key,
          prettyPrint,
          quotaUser,
          requestId,
          targetPool,
          targetReferenceResource,
          userIp);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAccessToken(this.access_token);
      newBuilder.setCallback(this.callback);
      newBuilder.setFailoverRatio(this.failoverRatio);
      newBuilder.setFields(this.fields);
      newBuilder.setKey(this.key);
      newBuilder.setPrettyPrint(this.prettyPrint);
      newBuilder.setQuotaUser(this.quotaUser);
      newBuilder.setRequestId(this.requestId);
      newBuilder.setTargetPool(this.targetPool);
      newBuilder.setTargetReferenceResource(this.targetReferenceResource);
      newBuilder.setUserIp(this.userIp);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SetBackupTargetPoolHttpRequest{"
        + "access_token="
        + access_token
        + ", "
        + "callback="
        + callback
        + ", "
        + "failoverRatio="
        + failoverRatio
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
        + "targetPool="
        + targetPool
        + ", "
        + "targetReferenceResource="
        + targetReferenceResource
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
    if (o instanceof SetBackupTargetPoolHttpRequest) {
      SetBackupTargetPoolHttpRequest that = (SetBackupTargetPoolHttpRequest) o;
      return Objects.equals(this.access_token, that.getAccessToken())
          && Objects.equals(this.callback, that.getCallback())
          && Objects.equals(this.failoverRatio, that.getFailoverRatio())
          && Objects.equals(this.fields, that.getFields())
          && Objects.equals(this.key, that.getKey())
          && Objects.equals(this.prettyPrint, that.getPrettyPrint())
          && Objects.equals(this.quotaUser, that.getQuotaUser())
          && Objects.equals(this.requestId, that.getRequestId())
          && Objects.equals(this.targetPool, that.getTargetPool())
          && Objects.equals(this.targetReferenceResource, that.getTargetReferenceResource())
          && Objects.equals(this.userIp, that.getUserIp());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        access_token,
        callback,
        failoverRatio,
        fields,
        key,
        prettyPrint,
        quotaUser,
        requestId,
        targetPool,
        targetReferenceResource,
        userIp);
  }
}
