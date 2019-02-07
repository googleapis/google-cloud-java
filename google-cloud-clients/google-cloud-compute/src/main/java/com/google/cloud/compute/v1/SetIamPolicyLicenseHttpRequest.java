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
 * Request object for method compute.licenses.setIamPolicy. Sets the access control policy on the
 * specified resource. Replaces any existing policy.
 */
public final class SetIamPolicyLicenseHttpRequest implements ApiMessage {
  private final String access_token;
  private final String callback;
  private final String fields;
  private final GlobalSetPolicyRequest globalSetPolicyRequestResource;
  private final String key;
  private final String prettyPrint;
  private final String quotaUser;
  private final String resource;
  private final String userIp;

  private SetIamPolicyLicenseHttpRequest() {
    this.access_token = null;
    this.callback = null;
    this.fields = null;
    this.globalSetPolicyRequestResource = null;
    this.key = null;
    this.prettyPrint = null;
    this.quotaUser = null;
    this.resource = null;
    this.userIp = null;
  }

  private SetIamPolicyLicenseHttpRequest(
      String access_token,
      String callback,
      String fields,
      GlobalSetPolicyRequest globalSetPolicyRequestResource,
      String key,
      String prettyPrint,
      String quotaUser,
      String resource,
      String userIp) {
    this.access_token = access_token;
    this.callback = callback;
    this.fields = fields;
    this.globalSetPolicyRequestResource = globalSetPolicyRequestResource;
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
    if ("globalSetPolicyRequestResource".equals(fieldName)) {
      return globalSetPolicyRequestResource;
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
  public GlobalSetPolicyRequest getApiMessageRequestBody() {
    return globalSetPolicyRequestResource;
  }

  @Nullable
  @Override
  public List<String> getFieldMask() {
    return null;
  }

  /** OAuth 2.0 token for the current user. */
  public String getAccessToken() {
    return access_token;
  }

  /** Name of the JavaScript callback function that handles the response. */
  public String getCallback() {
    return callback;
  }

  /** Selector specifying a subset of fields to include in the response. */
  public String getFields() {
    return fields;
  }

  public GlobalSetPolicyRequest getGlobalSetPolicyRequestResource() {
    return globalSetPolicyRequestResource;
  }

  /** API key. Required unless you provide an OAuth 2.0 token. */
  public String getKey() {
    return key;
  }

  /** Returns response with indentations and line breaks. */
  public String getPrettyPrint() {
    return prettyPrint;
  }

  /** Alternative to userIp. */
  public String getQuotaUser() {
    return quotaUser;
  }

  /**
   * Name or id of the resource for this request. It must have the format
   * `{project}/global/licenses/{resource}/setIamPolicy`. \`{resource}\` must start with a letter,
   * and contain only letters (\`[A-Za-z]\`), numbers (\`[0-9]\`), dashes (\`-\`), &#42; underscores
   * (\`_\`), periods (\`.\`), tildes (\`~\`), plus (\`+\`) or percent &#42; signs (\`%\`). It must
   * be between 3 and 255 characters in length, and it &#42; must not start with \`"goog"\`.
   */
  public String getResource() {
    return resource;
  }

  /** IP address of the end user for whom the API call is being made. */
  public String getUserIp() {
    return userIp;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SetIamPolicyLicenseHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SetIamPolicyLicenseHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SetIamPolicyLicenseHttpRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SetIamPolicyLicenseHttpRequest();
  }

  public static class Builder {
    private String access_token;
    private String callback;
    private String fields;
    private GlobalSetPolicyRequest globalSetPolicyRequestResource;
    private String key;
    private String prettyPrint;
    private String quotaUser;
    private String resource;
    private String userIp;

    Builder() {}

    public Builder mergeFrom(SetIamPolicyLicenseHttpRequest other) {
      if (other == SetIamPolicyLicenseHttpRequest.getDefaultInstance()) return this;
      if (other.getAccessToken() != null) {
        this.access_token = other.access_token;
      }
      if (other.getCallback() != null) {
        this.callback = other.callback;
      }
      if (other.getFields() != null) {
        this.fields = other.fields;
      }
      if (other.getGlobalSetPolicyRequestResource() != null) {
        this.globalSetPolicyRequestResource = other.globalSetPolicyRequestResource;
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

    Builder(SetIamPolicyLicenseHttpRequest source) {
      this.access_token = source.access_token;
      this.callback = source.callback;
      this.fields = source.fields;
      this.globalSetPolicyRequestResource = source.globalSetPolicyRequestResource;
      this.key = source.key;
      this.prettyPrint = source.prettyPrint;
      this.quotaUser = source.quotaUser;
      this.resource = source.resource;
      this.userIp = source.userIp;
    }

    /** OAuth 2.0 token for the current user. */
    public String getAccessToken() {
      return access_token;
    }

    /** OAuth 2.0 token for the current user. */
    public Builder setAccessToken(String access_token) {
      this.access_token = access_token;
      return this;
    }

    /** Name of the JavaScript callback function that handles the response. */
    public String getCallback() {
      return callback;
    }

    /** Name of the JavaScript callback function that handles the response. */
    public Builder setCallback(String callback) {
      this.callback = callback;
      return this;
    }

    /** Selector specifying a subset of fields to include in the response. */
    public String getFields() {
      return fields;
    }

    /** Selector specifying a subset of fields to include in the response. */
    public Builder setFields(String fields) {
      this.fields = fields;
      return this;
    }

    public GlobalSetPolicyRequest getGlobalSetPolicyRequestResource() {
      return globalSetPolicyRequestResource;
    }

    public Builder setGlobalSetPolicyRequestResource(
        GlobalSetPolicyRequest globalSetPolicyRequestResource) {
      this.globalSetPolicyRequestResource = globalSetPolicyRequestResource;
      return this;
    }

    /** API key. Required unless you provide an OAuth 2.0 token. */
    public String getKey() {
      return key;
    }

    /** API key. Required unless you provide an OAuth 2.0 token. */
    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    /** Returns response with indentations and line breaks. */
    public String getPrettyPrint() {
      return prettyPrint;
    }

    /** Returns response with indentations and line breaks. */
    public Builder setPrettyPrint(String prettyPrint) {
      this.prettyPrint = prettyPrint;
      return this;
    }

    /** Alternative to userIp. */
    public String getQuotaUser() {
      return quotaUser;
    }

    /** Alternative to userIp. */
    public Builder setQuotaUser(String quotaUser) {
      this.quotaUser = quotaUser;
      return this;
    }

    /**
     * Name or id of the resource for this request. It must have the format
     * `{project}/global/licenses/{resource}/setIamPolicy`. \`{resource}\` must start with a letter,
     * and contain only letters (\`[A-Za-z]\`), numbers (\`[0-9]\`), dashes (\`-\`), &#42;
     * underscores (\`_\`), periods (\`.\`), tildes (\`~\`), plus (\`+\`) or percent &#42; signs
     * (\`%\`). It must be between 3 and 255 characters in length, and it &#42; must not start with
     * \`"goog"\`.
     */
    public String getResource() {
      return resource;
    }

    /**
     * Name or id of the resource for this request. It must have the format
     * `{project}/global/licenses/{resource}/setIamPolicy`. \`{resource}\` must start with a letter,
     * and contain only letters (\`[A-Za-z]\`), numbers (\`[0-9]\`), dashes (\`-\`), &#42;
     * underscores (\`_\`), periods (\`.\`), tildes (\`~\`), plus (\`+\`) or percent &#42; signs
     * (\`%\`). It must be between 3 and 255 characters in length, and it &#42; must not start with
     * \`"goog"\`.
     */
    public Builder setResource(String resource) {
      this.resource = resource;
      return this;
    }

    /** IP address of the end user for whom the API call is being made. */
    public String getUserIp() {
      return userIp;
    }

    /** IP address of the end user for whom the API call is being made. */
    public Builder setUserIp(String userIp) {
      this.userIp = userIp;
      return this;
    }

    public SetIamPolicyLicenseHttpRequest build() {
      String missing = "";

      if (resource == null) {
        missing += " resource";
      }

      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new SetIamPolicyLicenseHttpRequest(
          access_token,
          callback,
          fields,
          globalSetPolicyRequestResource,
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
      newBuilder.setGlobalSetPolicyRequestResource(this.globalSetPolicyRequestResource);
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
    return "SetIamPolicyLicenseHttpRequest{"
        + "access_token="
        + access_token
        + ", "
        + "callback="
        + callback
        + ", "
        + "fields="
        + fields
        + ", "
        + "globalSetPolicyRequestResource="
        + globalSetPolicyRequestResource
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
    if (o instanceof SetIamPolicyLicenseHttpRequest) {
      SetIamPolicyLicenseHttpRequest that = (SetIamPolicyLicenseHttpRequest) o;
      return Objects.equals(this.access_token, that.getAccessToken())
          && Objects.equals(this.callback, that.getCallback())
          && Objects.equals(this.fields, that.getFields())
          && Objects.equals(
              this.globalSetPolicyRequestResource, that.getGlobalSetPolicyRequestResource())
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
        globalSetPolicyRequestResource,
        key,
        prettyPrint,
        quotaUser,
        resource,
        userIp);
  }
}
