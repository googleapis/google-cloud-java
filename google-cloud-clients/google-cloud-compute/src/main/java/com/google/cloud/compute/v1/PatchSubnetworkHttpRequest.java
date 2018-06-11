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
public final class PatchSubnetworkHttpRequest implements ApiMessage {
  private final String access_token;
  private final String callback;
  private final List<String> fieldMask;
  private final String fields;
  private final String key;
  private final String prettyPrint;
  private final String quotaUser;
  private final String requestId;
  private final String subnetwork;
  private final Subnetwork subnetworkResource;
  private final String userIp;

  private PatchSubnetworkHttpRequest() {
    this.access_token = null;
    this.callback = null;
    this.fieldMask = null;
    this.fields = null;
    this.key = null;
    this.prettyPrint = null;
    this.quotaUser = null;
    this.requestId = null;
    this.subnetwork = null;
    this.subnetworkResource = null;
    this.userIp = null;
  }

  private PatchSubnetworkHttpRequest(
      String access_token,
      String callback,
      List<String> fieldMask,
      String fields,
      String key,
      String prettyPrint,
      String quotaUser,
      String requestId,
      String subnetwork,
      Subnetwork subnetworkResource,
      String userIp) {
    this.access_token = access_token;
    this.callback = callback;
    this.fieldMask = fieldMask;
    this.fields = fields;
    this.key = key;
    this.prettyPrint = prettyPrint;
    this.quotaUser = quotaUser;
    this.requestId = requestId;
    this.subnetwork = subnetwork;
    this.subnetworkResource = subnetworkResource;
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
    if (fieldName.equals("fieldMask")) {
      return fieldMask;
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
    if (fieldName.equals("subnetwork")) {
      return subnetwork;
    }
    if (fieldName.equals("subnetworkResource")) {
      return subnetworkResource;
    }
    if (fieldName.equals("userIp")) {
      return userIp;
    }
    return null;
  }

  @Nullable
  @Override
  public Subnetwork getApiMessageRequestBody() {
    return subnetworkResource;
  }

  @Nullable
  @Override
  public List<String> getFieldMask() {
    return fieldMask;
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

  public String getSubnetwork() {
    return subnetwork;
  }

  public Subnetwork getSubnetworkResource() {
    return subnetworkResource;
  }

  public String getUserIp() {
    return userIp;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(PatchSubnetworkHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static PatchSubnetworkHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final PatchSubnetworkHttpRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PatchSubnetworkHttpRequest();
  }

  public static class Builder {
    private String access_token;
    private String callback;
    private List<String> fieldMask;
    private String fields;
    private String key;
    private String prettyPrint;
    private String quotaUser;
    private String requestId;
    private String subnetwork;
    private Subnetwork subnetworkResource;
    private String userIp;

    Builder() {}

    public Builder mergeFrom(PatchSubnetworkHttpRequest other) {
      if (other == PatchSubnetworkHttpRequest.getDefaultInstance()) return this;
      if (other.getAccessToken() != null) {
        this.access_token = other.access_token;
      }
      if (other.getCallback() != null) {
        this.callback = other.callback;
      }
      if (other.getFieldMask() != null) {
        this.fieldMask = other.fieldMask;
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
      if (other.getSubnetwork() != null) {
        this.subnetwork = other.subnetwork;
      }
      if (other.getSubnetworkResource() != null) {
        this.subnetworkResource = other.subnetworkResource;
      }
      if (other.getUserIp() != null) {
        this.userIp = other.userIp;
      }
      return this;
    }

    Builder(PatchSubnetworkHttpRequest source) {
      this.access_token = source.access_token;
      this.callback = source.callback;
      this.fieldMask = source.fieldMask;
      this.fields = source.fields;
      this.key = source.key;
      this.prettyPrint = source.prettyPrint;
      this.quotaUser = source.quotaUser;
      this.requestId = source.requestId;
      this.subnetwork = source.subnetwork;
      this.subnetworkResource = source.subnetworkResource;
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

    public List<String> getFieldMask() {
      return fieldMask;
    }

    public Builder setFieldMask(List<String> fieldMask) {
      this.fieldMask = fieldMask;
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

    public String getSubnetwork() {
      return subnetwork;
    }

    public Builder setSubnetwork(String subnetwork) {
      this.subnetwork = subnetwork;
      return this;
    }

    public Subnetwork getSubnetworkResource() {
      return subnetworkResource;
    }

    public Builder setSubnetworkResource(Subnetwork subnetworkResource) {
      this.subnetworkResource = subnetworkResource;
      return this;
    }

    public String getUserIp() {
      return userIp;
    }

    public Builder setUserIp(String userIp) {
      this.userIp = userIp;
      return this;
    }

    public PatchSubnetworkHttpRequest build() {
      String missing = "";

      if (subnetwork == null) {
        missing += " subnetwork";
      }

      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new PatchSubnetworkHttpRequest(
          access_token,
          callback,
          fieldMask,
          fields,
          key,
          prettyPrint,
          quotaUser,
          requestId,
          subnetwork,
          subnetworkResource,
          userIp);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAccessToken(this.access_token);
      newBuilder.setCallback(this.callback);
      newBuilder.setFieldMask(this.fieldMask);
      newBuilder.setFields(this.fields);
      newBuilder.setKey(this.key);
      newBuilder.setPrettyPrint(this.prettyPrint);
      newBuilder.setQuotaUser(this.quotaUser);
      newBuilder.setRequestId(this.requestId);
      newBuilder.setSubnetwork(this.subnetwork);
      newBuilder.setSubnetworkResource(this.subnetworkResource);
      newBuilder.setUserIp(this.userIp);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "PatchSubnetworkHttpRequest{"
        + "access_token="
        + access_token
        + ", "
        + "callback="
        + callback
        + ", "
        + "fieldMask="
        + fieldMask
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
        + "subnetwork="
        + subnetwork
        + ", "
        + "subnetworkResource="
        + subnetworkResource
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
    if (o instanceof PatchSubnetworkHttpRequest) {
      PatchSubnetworkHttpRequest that = (PatchSubnetworkHttpRequest) o;
      return Objects.equals(this.access_token, that.getAccessToken())
          && Objects.equals(this.callback, that.getCallback())
          && Objects.equals(this.fieldMask, that.getFieldMask())
          && Objects.equals(this.fields, that.getFields())
          && Objects.equals(this.key, that.getKey())
          && Objects.equals(this.prettyPrint, that.getPrettyPrint())
          && Objects.equals(this.quotaUser, that.getQuotaUser())
          && Objects.equals(this.requestId, that.getRequestId())
          && Objects.equals(this.subnetwork, that.getSubnetwork())
          && Objects.equals(this.subnetworkResource, that.getSubnetworkResource())
          && Objects.equals(this.userIp, that.getUserIp());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        access_token,
        callback,
        fieldMask,
        fields,
        key,
        prettyPrint,
        quotaUser,
        requestId,
        subnetwork,
        subnetworkResource,
        userIp);
  }
}
