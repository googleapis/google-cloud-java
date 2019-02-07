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
 * Request object for method compute.subnetworks.setPrivateIpGoogleAccess. Set whether VMs in this
 * subnet can access Google services without assigning external IP addresses through Private Google
 * Access.
 */
public final class SetPrivateIpGoogleAccessSubnetworkHttpRequest implements ApiMessage {
  private final String access_token;
  private final String callback;
  private final String fields;
  private final String key;
  private final String prettyPrint;
  private final String quotaUser;
  private final String requestId;
  private final String subnetwork;
  private final SubnetworksSetPrivateIpGoogleAccessRequest
      subnetworksSetPrivateIpGoogleAccessRequestResource;
  private final String userIp;

  private SetPrivateIpGoogleAccessSubnetworkHttpRequest() {
    this.access_token = null;
    this.callback = null;
    this.fields = null;
    this.key = null;
    this.prettyPrint = null;
    this.quotaUser = null;
    this.requestId = null;
    this.subnetwork = null;
    this.subnetworksSetPrivateIpGoogleAccessRequestResource = null;
    this.userIp = null;
  }

  private SetPrivateIpGoogleAccessSubnetworkHttpRequest(
      String access_token,
      String callback,
      String fields,
      String key,
      String prettyPrint,
      String quotaUser,
      String requestId,
      String subnetwork,
      SubnetworksSetPrivateIpGoogleAccessRequest subnetworksSetPrivateIpGoogleAccessRequestResource,
      String userIp) {
    this.access_token = access_token;
    this.callback = callback;
    this.fields = fields;
    this.key = key;
    this.prettyPrint = prettyPrint;
    this.quotaUser = quotaUser;
    this.requestId = requestId;
    this.subnetwork = subnetwork;
    this.subnetworksSetPrivateIpGoogleAccessRequestResource =
        subnetworksSetPrivateIpGoogleAccessRequestResource;
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
    if ("subnetwork".equals(fieldName)) {
      return subnetwork;
    }
    if ("subnetworksSetPrivateIpGoogleAccessRequestResource".equals(fieldName)) {
      return subnetworksSetPrivateIpGoogleAccessRequestResource;
    }
    if ("userIp".equals(fieldName)) {
      return userIp;
    }
    return null;
  }

  @Nullable
  @Override
  public SubnetworksSetPrivateIpGoogleAccessRequest getApiMessageRequestBody() {
    return subnetworksSetPrivateIpGoogleAccessRequestResource;
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
   * An optional request ID to identify requests. Specify a unique request ID so that if you must
   * retry your request, the server will know to ignore the request if it has already been
   * completed.
   *
   * <p>For example, consider a situation where you make an initial request and the request times
   * out. If you make the request again with the same request ID, the server can check if original
   * operation with the same request ID was received, and if so, will ignore the second request.
   * This prevents clients from accidentally creating duplicate commitments.
   *
   * <p>The request ID must be a valid UUID with the exception that zero UUID is not supported
   * (00000000-0000-0000-0000-000000000000).
   */
  public String getRequestId() {
    return requestId;
  }

  /**
   * Name of the Subnetwork resource. It must have the format
   * `{project}/regions/{region}/subnetworks/{subnetwork}/setPrivateIpGoogleAccess`.
   * \`{subnetwork}\` must start with a letter, and contain only letters (\`[A-Za-z]\`), numbers
   * (\`[0-9]\`), dashes (\`-\`), &#42; underscores (\`_\`), periods (\`.\`), tildes (\`~\`), plus
   * (\`+\`) or percent &#42; signs (\`%\`). It must be between 3 and 255 characters in length, and
   * it &#42; must not start with \`"goog"\`.
   */
  public String getSubnetwork() {
    return subnetwork;
  }

  public SubnetworksSetPrivateIpGoogleAccessRequest
      getSubnetworksSetPrivateIpGoogleAccessRequestResource() {
    return subnetworksSetPrivateIpGoogleAccessRequestResource;
  }

  /** IP address of the end user for whom the API call is being made. */
  public String getUserIp() {
    return userIp;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SetPrivateIpGoogleAccessSubnetworkHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SetPrivateIpGoogleAccessSubnetworkHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SetPrivateIpGoogleAccessSubnetworkHttpRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SetPrivateIpGoogleAccessSubnetworkHttpRequest();
  }

  public static class Builder {
    private String access_token;
    private String callback;
    private String fields;
    private String key;
    private String prettyPrint;
    private String quotaUser;
    private String requestId;
    private String subnetwork;
    private SubnetworksSetPrivateIpGoogleAccessRequest
        subnetworksSetPrivateIpGoogleAccessRequestResource;
    private String userIp;

    Builder() {}

    public Builder mergeFrom(SetPrivateIpGoogleAccessSubnetworkHttpRequest other) {
      if (other == SetPrivateIpGoogleAccessSubnetworkHttpRequest.getDefaultInstance()) return this;
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
      if (other.getSubnetwork() != null) {
        this.subnetwork = other.subnetwork;
      }
      if (other.getSubnetworksSetPrivateIpGoogleAccessRequestResource() != null) {
        this.subnetworksSetPrivateIpGoogleAccessRequestResource =
            other.subnetworksSetPrivateIpGoogleAccessRequestResource;
      }
      if (other.getUserIp() != null) {
        this.userIp = other.userIp;
      }
      return this;
    }

    Builder(SetPrivateIpGoogleAccessSubnetworkHttpRequest source) {
      this.access_token = source.access_token;
      this.callback = source.callback;
      this.fields = source.fields;
      this.key = source.key;
      this.prettyPrint = source.prettyPrint;
      this.quotaUser = source.quotaUser;
      this.requestId = source.requestId;
      this.subnetwork = source.subnetwork;
      this.subnetworksSetPrivateIpGoogleAccessRequestResource =
          source.subnetworksSetPrivateIpGoogleAccessRequestResource;
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
     * An optional request ID to identify requests. Specify a unique request ID so that if you must
     * retry your request, the server will know to ignore the request if it has already been
     * completed.
     *
     * <p>For example, consider a situation where you make an initial request and the request times
     * out. If you make the request again with the same request ID, the server can check if original
     * operation with the same request ID was received, and if so, will ignore the second request.
     * This prevents clients from accidentally creating duplicate commitments.
     *
     * <p>The request ID must be a valid UUID with the exception that zero UUID is not supported
     * (00000000-0000-0000-0000-000000000000).
     */
    public String getRequestId() {
      return requestId;
    }

    /**
     * An optional request ID to identify requests. Specify a unique request ID so that if you must
     * retry your request, the server will know to ignore the request if it has already been
     * completed.
     *
     * <p>For example, consider a situation where you make an initial request and the request times
     * out. If you make the request again with the same request ID, the server can check if original
     * operation with the same request ID was received, and if so, will ignore the second request.
     * This prevents clients from accidentally creating duplicate commitments.
     *
     * <p>The request ID must be a valid UUID with the exception that zero UUID is not supported
     * (00000000-0000-0000-0000-000000000000).
     */
    public Builder setRequestId(String requestId) {
      this.requestId = requestId;
      return this;
    }

    /**
     * Name of the Subnetwork resource. It must have the format
     * `{project}/regions/{region}/subnetworks/{subnetwork}/setPrivateIpGoogleAccess`.
     * \`{subnetwork}\` must start with a letter, and contain only letters (\`[A-Za-z]\`), numbers
     * (\`[0-9]\`), dashes (\`-\`), &#42; underscores (\`_\`), periods (\`.\`), tildes (\`~\`), plus
     * (\`+\`) or percent &#42; signs (\`%\`). It must be between 3 and 255 characters in length,
     * and it &#42; must not start with \`"goog"\`.
     */
    public String getSubnetwork() {
      return subnetwork;
    }

    /**
     * Name of the Subnetwork resource. It must have the format
     * `{project}/regions/{region}/subnetworks/{subnetwork}/setPrivateIpGoogleAccess`.
     * \`{subnetwork}\` must start with a letter, and contain only letters (\`[A-Za-z]\`), numbers
     * (\`[0-9]\`), dashes (\`-\`), &#42; underscores (\`_\`), periods (\`.\`), tildes (\`~\`), plus
     * (\`+\`) or percent &#42; signs (\`%\`). It must be between 3 and 255 characters in length,
     * and it &#42; must not start with \`"goog"\`.
     */
    public Builder setSubnetwork(String subnetwork) {
      this.subnetwork = subnetwork;
      return this;
    }

    public SubnetworksSetPrivateIpGoogleAccessRequest
        getSubnetworksSetPrivateIpGoogleAccessRequestResource() {
      return subnetworksSetPrivateIpGoogleAccessRequestResource;
    }

    public Builder setSubnetworksSetPrivateIpGoogleAccessRequestResource(
        SubnetworksSetPrivateIpGoogleAccessRequest
            subnetworksSetPrivateIpGoogleAccessRequestResource) {
      this.subnetworksSetPrivateIpGoogleAccessRequestResource =
          subnetworksSetPrivateIpGoogleAccessRequestResource;
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

    public SetPrivateIpGoogleAccessSubnetworkHttpRequest build() {
      String missing = "";

      if (subnetwork == null) {
        missing += " subnetwork";
      }

      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new SetPrivateIpGoogleAccessSubnetworkHttpRequest(
          access_token,
          callback,
          fields,
          key,
          prettyPrint,
          quotaUser,
          requestId,
          subnetwork,
          subnetworksSetPrivateIpGoogleAccessRequestResource,
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
      newBuilder.setSubnetwork(this.subnetwork);
      newBuilder.setSubnetworksSetPrivateIpGoogleAccessRequestResource(
          this.subnetworksSetPrivateIpGoogleAccessRequestResource);
      newBuilder.setUserIp(this.userIp);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SetPrivateIpGoogleAccessSubnetworkHttpRequest{"
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
        + "subnetwork="
        + subnetwork
        + ", "
        + "subnetworksSetPrivateIpGoogleAccessRequestResource="
        + subnetworksSetPrivateIpGoogleAccessRequestResource
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
    if (o instanceof SetPrivateIpGoogleAccessSubnetworkHttpRequest) {
      SetPrivateIpGoogleAccessSubnetworkHttpRequest that =
          (SetPrivateIpGoogleAccessSubnetworkHttpRequest) o;
      return Objects.equals(this.access_token, that.getAccessToken())
          && Objects.equals(this.callback, that.getCallback())
          && Objects.equals(this.fields, that.getFields())
          && Objects.equals(this.key, that.getKey())
          && Objects.equals(this.prettyPrint, that.getPrettyPrint())
          && Objects.equals(this.quotaUser, that.getQuotaUser())
          && Objects.equals(this.requestId, that.getRequestId())
          && Objects.equals(this.subnetwork, that.getSubnetwork())
          && Objects.equals(
              this.subnetworksSetPrivateIpGoogleAccessRequestResource,
              that.getSubnetworksSetPrivateIpGoogleAccessRequestResource())
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
        subnetwork,
        subnetworksSetPrivateIpGoogleAccessRequestResource,
        userIp);
  }
}
