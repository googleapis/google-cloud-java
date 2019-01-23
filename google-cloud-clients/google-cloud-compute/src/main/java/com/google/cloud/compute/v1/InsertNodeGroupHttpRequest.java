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
public final class InsertNodeGroupHttpRequest implements ApiMessage {
  private final String access_token;
  private final String callback;
  private final String fields;
  private final Integer initialNodeCount;
  private final String key;
  private final NodeGroup nodeGroupResource;
  private final String prettyPrint;
  private final String quotaUser;
  private final String requestId;
  private final String userIp;
  private final String zone;

  private InsertNodeGroupHttpRequest() {
    this.access_token = null;
    this.callback = null;
    this.fields = null;
    this.initialNodeCount = null;
    this.key = null;
    this.nodeGroupResource = null;
    this.prettyPrint = null;
    this.quotaUser = null;
    this.requestId = null;
    this.userIp = null;
    this.zone = null;
  }

  private InsertNodeGroupHttpRequest(
      String access_token,
      String callback,
      String fields,
      Integer initialNodeCount,
      String key,
      NodeGroup nodeGroupResource,
      String prettyPrint,
      String quotaUser,
      String requestId,
      String userIp,
      String zone) {
    this.access_token = access_token;
    this.callback = callback;
    this.fields = fields;
    this.initialNodeCount = initialNodeCount;
    this.key = key;
    this.nodeGroupResource = nodeGroupResource;
    this.prettyPrint = prettyPrint;
    this.quotaUser = quotaUser;
    this.requestId = requestId;
    this.userIp = userIp;
    this.zone = zone;
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
    if ("initialNodeCount".equals(fieldName)) {
      return initialNodeCount;
    }
    if ("key".equals(fieldName)) {
      return key;
    }
    if ("nodeGroupResource".equals(fieldName)) {
      return nodeGroupResource;
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
    if ("userIp".equals(fieldName)) {
      return userIp;
    }
    if ("zone".equals(fieldName)) {
      return zone;
    }
    return null;
  }

  @Nullable
  @Override
  public NodeGroup getApiMessageRequestBody() {
    return nodeGroupResource;
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

  public Integer getInitialNodeCount() {
    return initialNodeCount;
  }

  public String getKey() {
    return key;
  }

  public NodeGroup getNodeGroupResource() {
    return nodeGroupResource;
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

  public String getUserIp() {
    return userIp;
  }

  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InsertNodeGroupHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InsertNodeGroupHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InsertNodeGroupHttpRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InsertNodeGroupHttpRequest();
  }

  public static class Builder {
    private String access_token;
    private String callback;
    private String fields;
    private Integer initialNodeCount;
    private String key;
    private NodeGroup nodeGroupResource;
    private String prettyPrint;
    private String quotaUser;
    private String requestId;
    private String userIp;
    private String zone;

    Builder() {}

    public Builder mergeFrom(InsertNodeGroupHttpRequest other) {
      if (other == InsertNodeGroupHttpRequest.getDefaultInstance()) return this;
      if (other.getAccessToken() != null) {
        this.access_token = other.access_token;
      }
      if (other.getCallback() != null) {
        this.callback = other.callback;
      }
      if (other.getFields() != null) {
        this.fields = other.fields;
      }
      if (other.getInitialNodeCount() != null) {
        this.initialNodeCount = other.initialNodeCount;
      }
      if (other.getKey() != null) {
        this.key = other.key;
      }
      if (other.getNodeGroupResource() != null) {
        this.nodeGroupResource = other.nodeGroupResource;
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
      if (other.getUserIp() != null) {
        this.userIp = other.userIp;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(InsertNodeGroupHttpRequest source) {
      this.access_token = source.access_token;
      this.callback = source.callback;
      this.fields = source.fields;
      this.initialNodeCount = source.initialNodeCount;
      this.key = source.key;
      this.nodeGroupResource = source.nodeGroupResource;
      this.prettyPrint = source.prettyPrint;
      this.quotaUser = source.quotaUser;
      this.requestId = source.requestId;
      this.userIp = source.userIp;
      this.zone = source.zone;
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

    public Integer getInitialNodeCount() {
      return initialNodeCount;
    }

    public Builder setInitialNodeCount(Integer initialNodeCount) {
      this.initialNodeCount = initialNodeCount;
      return this;
    }

    public String getKey() {
      return key;
    }

    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    public NodeGroup getNodeGroupResource() {
      return nodeGroupResource;
    }

    public Builder setNodeGroupResource(NodeGroup nodeGroupResource) {
      this.nodeGroupResource = nodeGroupResource;
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

    public String getUserIp() {
      return userIp;
    }

    public Builder setUserIp(String userIp) {
      this.userIp = userIp;
      return this;
    }

    public String getZone() {
      return zone;
    }

    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public InsertNodeGroupHttpRequest build() {
      String missing = "";

      if (initialNodeCount == null) {
        missing += " initialNodeCount";
      }

      if (zone == null) {
        missing += " zone";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new InsertNodeGroupHttpRequest(
          access_token,
          callback,
          fields,
          initialNodeCount,
          key,
          nodeGroupResource,
          prettyPrint,
          quotaUser,
          requestId,
          userIp,
          zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAccessToken(this.access_token);
      newBuilder.setCallback(this.callback);
      newBuilder.setFields(this.fields);
      newBuilder.setInitialNodeCount(this.initialNodeCount);
      newBuilder.setKey(this.key);
      newBuilder.setNodeGroupResource(this.nodeGroupResource);
      newBuilder.setPrettyPrint(this.prettyPrint);
      newBuilder.setQuotaUser(this.quotaUser);
      newBuilder.setRequestId(this.requestId);
      newBuilder.setUserIp(this.userIp);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InsertNodeGroupHttpRequest{"
        + "access_token="
        + access_token
        + ", "
        + "callback="
        + callback
        + ", "
        + "fields="
        + fields
        + ", "
        + "initialNodeCount="
        + initialNodeCount
        + ", "
        + "key="
        + key
        + ", "
        + "nodeGroupResource="
        + nodeGroupResource
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
        + "userIp="
        + userIp
        + ", "
        + "zone="
        + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InsertNodeGroupHttpRequest) {
      InsertNodeGroupHttpRequest that = (InsertNodeGroupHttpRequest) o;
      return Objects.equals(this.access_token, that.getAccessToken())
          && Objects.equals(this.callback, that.getCallback())
          && Objects.equals(this.fields, that.getFields())
          && Objects.equals(this.initialNodeCount, that.getInitialNodeCount())
          && Objects.equals(this.key, that.getKey())
          && Objects.equals(this.nodeGroupResource, that.getNodeGroupResource())
          && Objects.equals(this.prettyPrint, that.getPrettyPrint())
          && Objects.equals(this.quotaUser, that.getQuotaUser())
          && Objects.equals(this.requestId, that.getRequestId())
          && Objects.equals(this.userIp, that.getUserIp())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        access_token,
        callback,
        fields,
        initialNodeCount,
        key,
        nodeGroupResource,
        prettyPrint,
        quotaUser,
        requestId,
        userIp,
        zone);
  }
}
