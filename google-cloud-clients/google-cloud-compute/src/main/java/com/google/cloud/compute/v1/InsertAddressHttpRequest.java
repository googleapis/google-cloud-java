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
 * Request object for method compute.addresses.insert. Creates an address resource in the specified
 * project by using the data included in the request.
 */
public final class InsertAddressHttpRequest implements ApiMessage {
  private final String access_token;
  private final Address addressResource;
  private final String callback;
  private final String fields;
  private final String key;
  private final String prettyPrint;
  private final String quotaUser;
  private final String region;
  private final String requestId;
  private final String userIp;

  private InsertAddressHttpRequest() {
    this.access_token = null;
    this.addressResource = null;
    this.callback = null;
    this.fields = null;
    this.key = null;
    this.prettyPrint = null;
    this.quotaUser = null;
    this.region = null;
    this.requestId = null;
    this.userIp = null;
  }

  private InsertAddressHttpRequest(
      String access_token,
      Address addressResource,
      String callback,
      String fields,
      String key,
      String prettyPrint,
      String quotaUser,
      String region,
      String requestId,
      String userIp) {
    this.access_token = access_token;
    this.addressResource = addressResource;
    this.callback = callback;
    this.fields = fields;
    this.key = key;
    this.prettyPrint = prettyPrint;
    this.quotaUser = quotaUser;
    this.region = region;
    this.requestId = requestId;
    this.userIp = userIp;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("access_token".equals(fieldName)) {
      return access_token;
    }
    if ("addressResource".equals(fieldName)) {
      return addressResource;
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
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("requestId".equals(fieldName)) {
      return requestId;
    }
    if ("userIp".equals(fieldName)) {
      return userIp;
    }
    return null;
  }

  @Nullable
  @Override
  public Address getApiMessageRequestBody() {
    return addressResource;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** OAuth 2.0 token for the current user. */
  public String getAccessToken() {
    return access_token;
  }

  /**
   * Represents an IP Address resource.
   *
   * <p>An address resource represents a regional internal IP address. Regional internal IP
   * addresses are RFC 1918 addresses that come from either a primary or secondary IP range of a
   * subnet in a VPC network. Regional external IP addresses can be assigned to GCP VM instances,
   * Cloud VPN gateways, regional external forwarding rules for network load balancers (in either
   * Standard or Premium Tier), and regional external forwarding rules for HTTP(S), SSL Proxy, and
   * TCP Proxy load balancers in Standard Tier. For more information, read IP addresses.
   *
   * <p>A globalAddresses resource represent a global external IP address. Global external IP
   * addresses are IPv4 or IPv6 addresses. They can only be assigned to global forwarding rules for
   * HTTP(S), SSL Proxy, or TCP Proxy load balancers in Premium Tier. For more information, read
   * Global resources. (== resource_for beta.addresses ==) (== resource_for v1.addresses ==) (==
   * resource_for beta.globalAddresses ==) (== resource_for v1.globalAddresses ==)
   */
  public Address getAddressResource() {
    return addressResource;
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
   * Name of the region for this request. It must have the format
   * `{project}/regions/{region}/addresses`. \`{region}\` must start with a letter, and contain only
   * letters (\`[A-Za-z]\`), numbers (\`[0-9]\`), dashes (\`-\`), &#42; underscores (\`_\`), periods
   * (\`.\`), tildes (\`~\`), plus (\`+\`) or percent &#42; signs (\`%\`). It must be between 3 and
   * 255 characters in length, and it &#42; must not start with \`"goog"\`.
   */
  public String getRegion() {
    return region;
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

  /** IP address of the end user for whom the API call is being made. */
  public String getUserIp() {
    return userIp;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InsertAddressHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InsertAddressHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InsertAddressHttpRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InsertAddressHttpRequest();
  }

  public static class Builder {
    private String access_token;
    private Address addressResource;
    private String callback;
    private String fields;
    private String key;
    private String prettyPrint;
    private String quotaUser;
    private String region;
    private String requestId;
    private String userIp;

    Builder() {}

    public Builder mergeFrom(InsertAddressHttpRequest other) {
      if (other == InsertAddressHttpRequest.getDefaultInstance()) return this;
      if (other.getAccessToken() != null) {
        this.access_token = other.access_token;
      }
      if (other.getAddressResource() != null) {
        this.addressResource = other.addressResource;
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
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getRequestId() != null) {
        this.requestId = other.requestId;
      }
      if (other.getUserIp() != null) {
        this.userIp = other.userIp;
      }
      return this;
    }

    Builder(InsertAddressHttpRequest source) {
      this.access_token = source.access_token;
      this.addressResource = source.addressResource;
      this.callback = source.callback;
      this.fields = source.fields;
      this.key = source.key;
      this.prettyPrint = source.prettyPrint;
      this.quotaUser = source.quotaUser;
      this.region = source.region;
      this.requestId = source.requestId;
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

    /**
     * Represents an IP Address resource.
     *
     * <p>An address resource represents a regional internal IP address. Regional internal IP
     * addresses are RFC 1918 addresses that come from either a primary or secondary IP range of a
     * subnet in a VPC network. Regional external IP addresses can be assigned to GCP VM instances,
     * Cloud VPN gateways, regional external forwarding rules for network load balancers (in either
     * Standard or Premium Tier), and regional external forwarding rules for HTTP(S), SSL Proxy, and
     * TCP Proxy load balancers in Standard Tier. For more information, read IP addresses.
     *
     * <p>A globalAddresses resource represent a global external IP address. Global external IP
     * addresses are IPv4 or IPv6 addresses. They can only be assigned to global forwarding rules
     * for HTTP(S), SSL Proxy, or TCP Proxy load balancers in Premium Tier. For more information,
     * read Global resources. (== resource_for beta.addresses ==) (== resource_for v1.addresses ==)
     * (== resource_for beta.globalAddresses ==) (== resource_for v1.globalAddresses ==)
     */
    public Address getAddressResource() {
      return addressResource;
    }

    /**
     * Represents an IP Address resource.
     *
     * <p>An address resource represents a regional internal IP address. Regional internal IP
     * addresses are RFC 1918 addresses that come from either a primary or secondary IP range of a
     * subnet in a VPC network. Regional external IP addresses can be assigned to GCP VM instances,
     * Cloud VPN gateways, regional external forwarding rules for network load balancers (in either
     * Standard or Premium Tier), and regional external forwarding rules for HTTP(S), SSL Proxy, and
     * TCP Proxy load balancers in Standard Tier. For more information, read IP addresses.
     *
     * <p>A globalAddresses resource represent a global external IP address. Global external IP
     * addresses are IPv4 or IPv6 addresses. They can only be assigned to global forwarding rules
     * for HTTP(S), SSL Proxy, or TCP Proxy load balancers in Premium Tier. For more information,
     * read Global resources. (== resource_for beta.addresses ==) (== resource_for v1.addresses ==)
     * (== resource_for beta.globalAddresses ==) (== resource_for v1.globalAddresses ==)
     */
    public Builder setAddressResource(Address addressResource) {
      this.addressResource = addressResource;
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
     * Name of the region for this request. It must have the format
     * `{project}/regions/{region}/addresses`. \`{region}\` must start with a letter, and contain
     * only letters (\`[A-Za-z]\`), numbers (\`[0-9]\`), dashes (\`-\`), &#42; underscores (\`_\`),
     * periods (\`.\`), tildes (\`~\`), plus (\`+\`) or percent &#42; signs (\`%\`). It must be
     * between 3 and 255 characters in length, and it &#42; must not start with \`"goog"\`.
     */
    public String getRegion() {
      return region;
    }

    /**
     * Name of the region for this request. It must have the format
     * `{project}/regions/{region}/addresses`. \`{region}\` must start with a letter, and contain
     * only letters (\`[A-Za-z]\`), numbers (\`[0-9]\`), dashes (\`-\`), &#42; underscores (\`_\`),
     * periods (\`.\`), tildes (\`~\`), plus (\`+\`) or percent &#42; signs (\`%\`). It must be
     * between 3 and 255 characters in length, and it &#42; must not start with \`"goog"\`.
     */
    public Builder setRegion(String region) {
      this.region = region;
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

    /** IP address of the end user for whom the API call is being made. */
    public String getUserIp() {
      return userIp;
    }

    /** IP address of the end user for whom the API call is being made. */
    public Builder setUserIp(String userIp) {
      this.userIp = userIp;
      return this;
    }

    public InsertAddressHttpRequest build() {
      String missing = "";

      if (region == null) {
        missing += " region";
      }

      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new InsertAddressHttpRequest(
          access_token,
          addressResource,
          callback,
          fields,
          key,
          prettyPrint,
          quotaUser,
          region,
          requestId,
          userIp);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAccessToken(this.access_token);
      newBuilder.setAddressResource(this.addressResource);
      newBuilder.setCallback(this.callback);
      newBuilder.setFields(this.fields);
      newBuilder.setKey(this.key);
      newBuilder.setPrettyPrint(this.prettyPrint);
      newBuilder.setQuotaUser(this.quotaUser);
      newBuilder.setRegion(this.region);
      newBuilder.setRequestId(this.requestId);
      newBuilder.setUserIp(this.userIp);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InsertAddressHttpRequest{"
        + "access_token="
        + access_token
        + ", "
        + "addressResource="
        + addressResource
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
        + "region="
        + region
        + ", "
        + "requestId="
        + requestId
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
    if (o instanceof InsertAddressHttpRequest) {
      InsertAddressHttpRequest that = (InsertAddressHttpRequest) o;
      return Objects.equals(this.access_token, that.getAccessToken())
          && Objects.equals(this.addressResource, that.getAddressResource())
          && Objects.equals(this.callback, that.getCallback())
          && Objects.equals(this.fields, that.getFields())
          && Objects.equals(this.key, that.getKey())
          && Objects.equals(this.prettyPrint, that.getPrettyPrint())
          && Objects.equals(this.quotaUser, that.getQuotaUser())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.requestId, that.getRequestId())
          && Objects.equals(this.userIp, that.getUserIp());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        access_token,
        addressResource,
        callback,
        fields,
        key,
        prettyPrint,
        quotaUser,
        region,
        requestId,
        userIp);
  }
}
