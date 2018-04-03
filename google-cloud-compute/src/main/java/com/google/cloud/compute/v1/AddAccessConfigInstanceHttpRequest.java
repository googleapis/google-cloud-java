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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
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
public final class AddAccessConfigInstanceHttpRequest implements ApiMessage {
  private final AccessConfig accessConfigResource;
  private final String access_token;
  private final String callback;
  private final String fields;
  private final String instance;
  private final String key;
  private final String networkInterface;
  private final String prettyPrint;
  private final String quotaUser;
  private final String requestId;
  private final String userIp;

  private AddAccessConfigInstanceHttpRequest() {
    this.accessConfigResource = null;
    this.access_token = null;
    this.callback = null;
    this.fields = null;
    this.instance = null;
    this.key = null;
    this.networkInterface = null;
    this.prettyPrint = null;
    this.quotaUser = null;
    this.requestId = null;
    this.userIp = null;
  }


  private AddAccessConfigInstanceHttpRequest(
      AccessConfig accessConfigResource,
      String access_token,
      String callback,
      String fields,
      String instance,
      String key,
      String networkInterface,
      String prettyPrint,
      String quotaUser,
      String requestId,
      String userIp
      ) {
    this.accessConfigResource = accessConfigResource;
    this.access_token = access_token;
    this.callback = callback;
    this.fields = fields;
    this.instance = instance;
    this.key = key;
    this.networkInterface = networkInterface;
    this.prettyPrint = prettyPrint;
    this.quotaUser = quotaUser;
    this.requestId = requestId;
    this.userIp = userIp;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("accessConfigResource") && accessConfigResource != null) {
      fieldMap.put("accessConfigResource", Collections.singletonList(String.valueOf(accessConfigResource)));
    }
    if (fieldNames.contains("access_token") && access_token != null) {
      fieldMap.put("access_token", Collections.singletonList(String.valueOf(access_token)));
    }
    if (fieldNames.contains("callback") && callback != null) {
      fieldMap.put("callback", Collections.singletonList(String.valueOf(callback)));
    }
    if (fieldNames.contains("fields") && fields != null) {
      fieldMap.put("fields", Collections.singletonList(String.valueOf(fields)));
    }
    if (fieldNames.contains("instance") && instance != null) {
      fieldMap.put("instance", Collections.singletonList(String.valueOf(instance)));
    }
    if (fieldNames.contains("key") && key != null) {
      fieldMap.put("key", Collections.singletonList(String.valueOf(key)));
    }
    if (fieldNames.contains("networkInterface") && networkInterface != null) {
      fieldMap.put("networkInterface", Collections.singletonList(String.valueOf(networkInterface)));
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
    if (fieldNames.contains("userIp") && userIp != null) {
      fieldMap.put("userIp", Collections.singletonList(String.valueOf(userIp)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("accessConfigResource")) {
      return String.valueOf(accessConfigResource);
    }
    if (fieldName.equals("access_token")) {
      return String.valueOf(access_token);
    }
    if (fieldName.equals("callback")) {
      return String.valueOf(callback);
    }
    if (fieldName.equals("fields")) {
      return String.valueOf(fields);
    }
    if (fieldName.equals("instance")) {
      return String.valueOf(instance);
    }
    if (fieldName.equals("key")) {
      return String.valueOf(key);
    }
    if (fieldName.equals("networkInterface")) {
      return String.valueOf(networkInterface);
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
    if (fieldName.equals("userIp")) {
      return String.valueOf(userIp);
    }
    return null;
  }

  @Nullable
  @Override
  public AccessConfig getApiMessageRequestBody() {
    return accessConfigResource;
  }

  public AccessConfig getAccessConfigResource() {
    return accessConfigResource;
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

  public String getInstance() {
    return instance;
  }

  public String getKey() {
    return key;
  }

  public String getNetworkInterface() {
    return networkInterface;
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


  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(AddAccessConfigInstanceHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AddAccessConfigInstanceHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  private static final AddAccessConfigInstanceHttpRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new AddAccessConfigInstanceHttpRequest();
  }

  public static class Builder {
    private AccessConfig accessConfigResource;
    private String access_token;
    private String callback;
    private String fields;
    private String instance;
    private String key;
    private String networkInterface;
    private String prettyPrint;
    private String quotaUser;
    private String requestId;
    private String userIp;

    Builder() {}

    public Builder mergeFrom(AddAccessConfigInstanceHttpRequest other) {
      if (other == AddAccessConfigInstanceHttpRequest.getDefaultInstance()) return this;
      if (other.getAccessConfigResource() != null) {
        this.accessConfigResource = other.accessConfigResource;
      }
      if (other.getAccessToken() != null) {
        this.access_token = other.access_token;
      }
      if (other.getCallback() != null) {
        this.callback = other.callback;
      }
      if (other.getFields() != null) {
        this.fields = other.fields;
      }
      if (other.getInstance() != null) {
        this.instance = other.instance;
      }
      if (other.getKey() != null) {
        this.key = other.key;
      }
      if (other.getNetworkInterface() != null) {
        this.networkInterface = other.networkInterface;
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
      return this;
    }

    Builder(AddAccessConfigInstanceHttpRequest source) {
      this.accessConfigResource = source.accessConfigResource;
      this.access_token = source.access_token;
      this.callback = source.callback;
      this.fields = source.fields;
      this.instance = source.instance;
      this.key = source.key;
      this.networkInterface = source.networkInterface;
      this.prettyPrint = source.prettyPrint;
      this.quotaUser = source.quotaUser;
      this.requestId = source.requestId;
      this.userIp = source.userIp;
    }

    public AccessConfig getAccessConfigResource() {
      return accessConfigResource;
    }

    public Builder setAccessConfigResource(AccessConfig accessConfigResource) {
      this.accessConfigResource = accessConfigResource;
      return this;
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

    public String getInstance() {
      return instance;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    public String getKey() {
      return key;
    }

    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    public String getNetworkInterface() {
      return networkInterface;
    }

    public Builder setNetworkInterface(String networkInterface) {
      this.networkInterface = networkInterface;
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


    public AddAccessConfigInstanceHttpRequest build() {
      String missing = "";




      if (instance == null) {
        missing += " instance";
      }

      if (networkInterface == null) {
        missing += " networkInterface";
      }




      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AddAccessConfigInstanceHttpRequest(
        accessConfigResource,
        access_token,
        callback,
        fields,
        instance,
        key,
        networkInterface,
        prettyPrint,
        quotaUser,
        requestId,
        userIp
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAccessConfigResource(this.accessConfigResource);
      newBuilder.setAccessToken(this.access_token);
      newBuilder.setCallback(this.callback);
      newBuilder.setFields(this.fields);
      newBuilder.setInstance(this.instance);
      newBuilder.setKey(this.key);
      newBuilder.setNetworkInterface(this.networkInterface);
      newBuilder.setPrettyPrint(this.prettyPrint);
      newBuilder.setQuotaUser(this.quotaUser);
      newBuilder.setRequestId(this.requestId);
      newBuilder.setUserIp(this.userIp);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AddAccessConfigInstanceHttpRequest{"
        + "accessConfigResource=" + accessConfigResource + ", "
        + "access_token=" + access_token + ", "
        + "callback=" + callback + ", "
        + "fields=" + fields + ", "
        + "instance=" + instance + ", "
        + "key=" + key + ", "
        + "networkInterface=" + networkInterface + ", "
        + "prettyPrint=" + prettyPrint + ", "
        + "quotaUser=" + quotaUser + ", "
        + "requestId=" + requestId + ", "
        + "userIp=" + userIp
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AddAccessConfigInstanceHttpRequest) {
      AddAccessConfigInstanceHttpRequest that = (AddAccessConfigInstanceHttpRequest) o;
      return
          Objects.equals(this.accessConfigResource, that.getAccessConfigResource()) &&
          Objects.equals(this.access_token, that.getAccessToken()) &&
          Objects.equals(this.callback, that.getCallback()) &&
          Objects.equals(this.fields, that.getFields()) &&
          Objects.equals(this.instance, that.getInstance()) &&
          Objects.equals(this.key, that.getKey()) &&
          Objects.equals(this.networkInterface, that.getNetworkInterface()) &&
          Objects.equals(this.prettyPrint, that.getPrettyPrint()) &&
          Objects.equals(this.quotaUser, that.getQuotaUser()) &&
          Objects.equals(this.requestId, that.getRequestId()) &&
          Objects.equals(this.userIp, that.getUserIp())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      accessConfigResource,
      access_token,
      callback,
      fields,
      instance,
      key,
      networkInterface,
      prettyPrint,
      quotaUser,
      requestId,
      userIp
    );
  }
}
