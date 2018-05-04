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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class SetLabelsDiskHttpRequest implements ApiMessage {
  private final String access_token;
  private final String callback;
  private final String fields;
  private final String key;
  private final String prettyPrint;
  private final String quotaUser;
  private final String requestId;
  private final String resource;
  private final String userIp;
  private final ZoneSetLabelsRequest zoneSetLabelsRequestResource;

  private SetLabelsDiskHttpRequest() {
    this.access_token = null;
    this.callback = null;
    this.fields = null;
    this.key = null;
    this.prettyPrint = null;
    this.quotaUser = null;
    this.requestId = null;
    this.resource = null;
    this.userIp = null;
    this.zoneSetLabelsRequestResource = null;
  }

  private SetLabelsDiskHttpRequest(
      String access_token,
      String callback,
      String fields,
      String key,
      String prettyPrint,
      String quotaUser,
      String requestId,
      String resource,
      String userIp,
      ZoneSetLabelsRequest zoneSetLabelsRequestResource) {
    this.access_token = access_token;
    this.callback = callback;
    this.fields = fields;
    this.key = key;
    this.prettyPrint = prettyPrint;
    this.quotaUser = quotaUser;
    this.requestId = requestId;
    this.resource = resource;
    this.userIp = userIp;
    this.zoneSetLabelsRequestResource = zoneSetLabelsRequestResource;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("access_token") && access_token != null) {
      fieldMap.put("access_token", Collections.singletonList(String.valueOf(access_token)));
    }
    if (fieldNames.contains("callback") && callback != null) {
      fieldMap.put("callback", Collections.singletonList(String.valueOf(callback)));
    }
    if (fieldNames.contains("fields") && fields != null) {
      fieldMap.put("fields", Collections.singletonList(String.valueOf(fields)));
    }
    if (fieldNames.contains("key") && key != null) {
      fieldMap.put("key", Collections.singletonList(String.valueOf(key)));
    }
    if (fieldNames.contains("prettyPrint") && prettyPrint != null) {
      fieldMap.put("prettyPrint", Collections.singletonList(String.valueOf(prettyPrint)));
    }
    if (fieldNames.contains("quotaUser") && quotaUser != null) {
      fieldMap.put("quotaUser", Collections.singletonList(String.valueOf(quotaUser)));
    }
    if (fieldNames.contains("requestId") && requestId != null) {
      fieldMap.put("requestId", Collections.singletonList(String.valueOf(requestId)));
    }
    if (fieldNames.contains("resource") && resource != null) {
      fieldMap.put("resource", Collections.singletonList(String.valueOf(resource)));
    }
    if (fieldNames.contains("userIp") && userIp != null) {
      fieldMap.put("userIp", Collections.singletonList(String.valueOf(userIp)));
    }
    if (fieldNames.contains("zoneSetLabelsRequestResource")
        && zoneSetLabelsRequestResource != null) {
      fieldMap.put(
          "zoneSetLabelsRequestResource",
          Collections.singletonList(String.valueOf(zoneSetLabelsRequestResource)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("access_token")) {
      return String.valueOf(access_token);
    }
    if (fieldName.equals("callback")) {
      return String.valueOf(callback);
    }
    if (fieldName.equals("fields")) {
      return String.valueOf(fields);
    }
    if (fieldName.equals("key")) {
      return String.valueOf(key);
    }
    if (fieldName.equals("prettyPrint")) {
      return String.valueOf(prettyPrint);
    }
    if (fieldName.equals("quotaUser")) {
      return String.valueOf(quotaUser);
    }
    if (fieldName.equals("requestId")) {
      return String.valueOf(requestId);
    }
    if (fieldName.equals("resource")) {
      return String.valueOf(resource);
    }
    if (fieldName.equals("userIp")) {
      return String.valueOf(userIp);
    }
    if (fieldName.equals("zoneSetLabelsRequestResource")) {
      return String.valueOf(zoneSetLabelsRequestResource);
    }
    return null;
  }

  @Nullable
  @Override
  public ZoneSetLabelsRequest getApiMessageRequestBody() {
    return zoneSetLabelsRequestResource;
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

  public String getResource() {
    return resource;
  }

  public String getUserIp() {
    return userIp;
  }

  public ZoneSetLabelsRequest getZoneSetLabelsRequestResource() {
    return zoneSetLabelsRequestResource;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SetLabelsDiskHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SetLabelsDiskHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SetLabelsDiskHttpRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SetLabelsDiskHttpRequest();
  }

  public static class Builder {
    private String access_token;
    private String callback;
    private String fields;
    private String key;
    private String prettyPrint;
    private String quotaUser;
    private String requestId;
    private String resource;
    private String userIp;
    private ZoneSetLabelsRequest zoneSetLabelsRequestResource;

    Builder() {}

    public Builder mergeFrom(SetLabelsDiskHttpRequest other) {
      if (other == SetLabelsDiskHttpRequest.getDefaultInstance()) return this;
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
      if (other.getResource() != null) {
        this.resource = other.resource;
      }
      if (other.getUserIp() != null) {
        this.userIp = other.userIp;
      }
      if (other.getZoneSetLabelsRequestResource() != null) {
        this.zoneSetLabelsRequestResource = other.zoneSetLabelsRequestResource;
      }
      return this;
    }

    Builder(SetLabelsDiskHttpRequest source) {
      this.access_token = source.access_token;
      this.callback = source.callback;
      this.fields = source.fields;
      this.key = source.key;
      this.prettyPrint = source.prettyPrint;
      this.quotaUser = source.quotaUser;
      this.requestId = source.requestId;
      this.resource = source.resource;
      this.userIp = source.userIp;
      this.zoneSetLabelsRequestResource = source.zoneSetLabelsRequestResource;
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

    public ZoneSetLabelsRequest getZoneSetLabelsRequestResource() {
      return zoneSetLabelsRequestResource;
    }

    public Builder setZoneSetLabelsRequestResource(
        ZoneSetLabelsRequest zoneSetLabelsRequestResource) {
      this.zoneSetLabelsRequestResource = zoneSetLabelsRequestResource;
      return this;
    }

    public SetLabelsDiskHttpRequest build() {
      String missing = "";

      if (resource == null) {
        missing += " resource";
      }

      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new SetLabelsDiskHttpRequest(
          access_token,
          callback,
          fields,
          key,
          prettyPrint,
          quotaUser,
          requestId,
          resource,
          userIp,
          zoneSetLabelsRequestResource);
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
      newBuilder.setResource(this.resource);
      newBuilder.setUserIp(this.userIp);
      newBuilder.setZoneSetLabelsRequestResource(this.zoneSetLabelsRequestResource);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SetLabelsDiskHttpRequest{"
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
        + "resource="
        + resource
        + ", "
        + "userIp="
        + userIp
        + ", "
        + "zoneSetLabelsRequestResource="
        + zoneSetLabelsRequestResource
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SetLabelsDiskHttpRequest) {
      SetLabelsDiskHttpRequest that = (SetLabelsDiskHttpRequest) o;
      return Objects.equals(this.access_token, that.getAccessToken())
          && Objects.equals(this.callback, that.getCallback())
          && Objects.equals(this.fields, that.getFields())
          && Objects.equals(this.key, that.getKey())
          && Objects.equals(this.prettyPrint, that.getPrettyPrint())
          && Objects.equals(this.quotaUser, that.getQuotaUser())
          && Objects.equals(this.requestId, that.getRequestId())
          && Objects.equals(this.resource, that.getResource())
          && Objects.equals(this.userIp, that.getUserIp())
          && Objects.equals(
              this.zoneSetLabelsRequestResource, that.getZoneSetLabelsRequestResource());
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
        resource,
        userIp,
        zoneSetLabelsRequestResource);
  }
}
