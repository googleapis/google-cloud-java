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
 * Request object for method compute.nodeGroups.insert. Creates a NodeGroup resource in the
 * specified project using the data included in the request.
 */
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

  /** Name of the JavaScript callback function that handles the response. */
  public String getCallback() {
    return callback;
  }

  /** Selector specifying a subset of fields to include in the response. */
  public String getFields() {
    return fields;
  }

  /** Initial count of nodes in the node group. */
  public Integer getInitialNodeCount() {
    return initialNodeCount;
  }

  /** API key. Required unless you provide an OAuth 2.0 token. */
  public String getKey() {
    return key;
  }

  /**
   * Represent a sole-tenant Node Group resource.
   *
   * <p>A sole-tenant node is a physical server that is dedicated to hosting VM instances only for
   * your specific project. Use sole-tenant nodes to keep your instances physically separated from
   * instances in other projects, or to group your instances together on the same host hardware. For
   * more information, read Sole-tenant nodes. (== resource_for beta.nodeGroups ==) (== resource_for
   * v1.nodeGroups ==) NextID: 15
   */
  public NodeGroup getNodeGroupResource() {
    return nodeGroupResource;
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

  /** IP address of the end user for whom the API call is being made. */
  public String getUserIp() {
    return userIp;
  }

  /**
   * The name of the zone for this request. It must have the format
   * `{project}/zones/{zone}/nodeGroups`. \`{zone}\` must start with a letter, and contain only
   * letters (\`[A-Za-z]\`), numbers (\`[0-9]\`), dashes (\`-\`), &#42; underscores (\`_\`), periods
   * (\`.\`), tildes (\`~\`), plus (\`+\`) or percent &#42; signs (\`%\`). It must be between 3 and
   * 255 characters in length, and it &#42; must not start with \`"goog"\`.
   */
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

    /** Initial count of nodes in the node group. */
    public Integer getInitialNodeCount() {
      return initialNodeCount;
    }

    /** Initial count of nodes in the node group. */
    public Builder setInitialNodeCount(Integer initialNodeCount) {
      this.initialNodeCount = initialNodeCount;
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

    /**
     * Represent a sole-tenant Node Group resource.
     *
     * <p>A sole-tenant node is a physical server that is dedicated to hosting VM instances only for
     * your specific project. Use sole-tenant nodes to keep your instances physically separated from
     * instances in other projects, or to group your instances together on the same host hardware.
     * For more information, read Sole-tenant nodes. (== resource_for beta.nodeGroups ==) (==
     * resource_for v1.nodeGroups ==) NextID: 15
     */
    public NodeGroup getNodeGroupResource() {
      return nodeGroupResource;
    }

    /**
     * Represent a sole-tenant Node Group resource.
     *
     * <p>A sole-tenant node is a physical server that is dedicated to hosting VM instances only for
     * your specific project. Use sole-tenant nodes to keep your instances physically separated from
     * instances in other projects, or to group your instances together on the same host hardware.
     * For more information, read Sole-tenant nodes. (== resource_for beta.nodeGroups ==) (==
     * resource_for v1.nodeGroups ==) NextID: 15
     */
    public Builder setNodeGroupResource(NodeGroup nodeGroupResource) {
      this.nodeGroupResource = nodeGroupResource;
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

    /** IP address of the end user for whom the API call is being made. */
    public String getUserIp() {
      return userIp;
    }

    /** IP address of the end user for whom the API call is being made. */
    public Builder setUserIp(String userIp) {
      this.userIp = userIp;
      return this;
    }

    /**
     * The name of the zone for this request. It must have the format
     * `{project}/zones/{zone}/nodeGroups`. \`{zone}\` must start with a letter, and contain only
     * letters (\`[A-Za-z]\`), numbers (\`[0-9]\`), dashes (\`-\`), &#42; underscores (\`_\`),
     * periods (\`.\`), tildes (\`~\`), plus (\`+\`) or percent &#42; signs (\`%\`). It must be
     * between 3 and 255 characters in length, and it &#42; must not start with \`"goog"\`.
     */
    public String getZone() {
      return zone;
    }

    /**
     * The name of the zone for this request. It must have the format
     * `{project}/zones/{zone}/nodeGroups`. \`{zone}\` must start with a letter, and contain only
     * letters (\`[A-Za-z]\`), numbers (\`[0-9]\`), dashes (\`-\`), &#42; underscores (\`_\`),
     * periods (\`.\`), tildes (\`~\`), plus (\`+\`) or percent &#42; signs (\`%\`). It must be
     * between 3 and 255 characters in length, and it &#42; must not start with \`"goog"\`.
     */
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
