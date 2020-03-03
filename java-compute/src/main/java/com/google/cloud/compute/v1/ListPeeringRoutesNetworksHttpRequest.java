/*
 * Copyright 2020 Google LLC
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
 * Request object for method compute.networks.listPeeringRoutes. Lists the peering routes exchanged
 * over peering connection.
 */
public final class ListPeeringRoutesNetworksHttpRequest implements ApiMessage {
  private final String access_token;
  private final String callback;
  private final String direction;
  private final String fields;
  private final String filter;
  private final String key;
  private final Integer maxResults;
  private final String network;
  private final String orderBy;
  private final String pageToken;
  private final String peeringName;
  private final String prettyPrint;
  private final String quotaUser;
  private final String region;
  private final String userIp;

  private ListPeeringRoutesNetworksHttpRequest() {
    this.access_token = null;
    this.callback = null;
    this.direction = null;
    this.fields = null;
    this.filter = null;
    this.key = null;
    this.maxResults = null;
    this.network = null;
    this.orderBy = null;
    this.pageToken = null;
    this.peeringName = null;
    this.prettyPrint = null;
    this.quotaUser = null;
    this.region = null;
    this.userIp = null;
  }

  private ListPeeringRoutesNetworksHttpRequest(
      String access_token,
      String callback,
      String direction,
      String fields,
      String filter,
      String key,
      Integer maxResults,
      String network,
      String orderBy,
      String pageToken,
      String peeringName,
      String prettyPrint,
      String quotaUser,
      String region,
      String userIp) {
    this.access_token = access_token;
    this.callback = callback;
    this.direction = direction;
    this.fields = fields;
    this.filter = filter;
    this.key = key;
    this.maxResults = maxResults;
    this.network = network;
    this.orderBy = orderBy;
    this.pageToken = pageToken;
    this.peeringName = peeringName;
    this.prettyPrint = prettyPrint;
    this.quotaUser = quotaUser;
    this.region = region;
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
    if ("direction".equals(fieldName)) {
      return direction;
    }
    if ("fields".equals(fieldName)) {
      return fields;
    }
    if ("filter".equals(fieldName)) {
      return filter;
    }
    if ("key".equals(fieldName)) {
      return key;
    }
    if ("maxResults".equals(fieldName)) {
      return maxResults;
    }
    if ("network".equals(fieldName)) {
      return network;
    }
    if ("orderBy".equals(fieldName)) {
      return orderBy;
    }
    if ("pageToken".equals(fieldName)) {
      return pageToken;
    }
    if ("peeringName".equals(fieldName)) {
      return peeringName;
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
    if ("userIp".equals(fieldName)) {
      return userIp;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
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

  /** The direction of the exchanged routes. */
  public String getDirection() {
    return direction;
  }

  /** Selector specifying a subset of fields to include in the response. */
  public String getFields() {
    return fields;
  }

  /**
   * A filter expression that filters resources listed in the response. The expression must specify
   * the field name, a comparison operator, and the value that you want to use for filtering. The
   * value must be a string, a number, or a boolean. The comparison operator must be either =, !=,
   * &gt;, or &lt;.
   *
   * <p>For example, if you are filtering Compute Engine instances, you can exclude instances named
   * example-instance by specifying name != example-instance.
   *
   * <p>You can also filter nested fields. For example, you could specify
   * scheduling.automaticRestart = false to include instances only if they are not scheduled for
   * automatic restarts. You can use filtering on nested fields to filter based on resource labels.
   *
   * <p>To filter on multiple expressions, provide each separate expression within parentheses. For
   * example, (scheduling.automaticRestart = true) (cpuPlatform = "Intel Skylake"). By default, each
   * expression is an AND expression. However, you can include AND and OR expressions explicitly.
   * For example, (cpuPlatform = "Intel Skylake") OR (cpuPlatform = "Intel Broadwell") AND
   * (scheduling.automaticRestart = true).
   */
  public String getFilter() {
    return filter;
  }

  /** API key. Required unless you provide an OAuth 2.0 token. */
  public String getKey() {
    return key;
  }

  /**
   * The maximum number of results per page that should be returned. If the number of available
   * results is larger than maxResults, Compute Engine returns a nextPageToken that can be used to
   * get the next page of results in subsequent list requests. Acceptable values are 0 to 500,
   * inclusive. (Default: 500)
   */
  public Integer getMaxResults() {
    return maxResults;
  }

  /**
   * Name of the network for this request. It must have the format
   * `{project}/global/networks/{network}/listPeeringRoutes`. \`{network}\` must start with a
   * letter, and contain only letters (\`[A-Za-z]\`), numbers (\`[0-9]\`), dashes (\`-\`), &#42;
   * underscores (\`_\`), periods (\`.\`), tildes (\`~\`), plus (\`+\`) or percent &#42; signs
   * (\`%\`). It must be between 3 and 255 characters in length, and it &#42; must not start with
   * \`"goog"\`.
   */
  public String getNetwork() {
    return network;
  }

  /**
   * Sorts list results by a certain order. By default, results are returned in alphanumerical order
   * based on the resource name.
   *
   * <p>You can also sort results in descending order based on the creation timestamp using
   * orderBy="creationTimestamp desc". This sorts results based on the creationTimestamp field in
   * reverse chronological order (newest result first). Use this to sort resources like operations
   * so that the newest operation is returned first.
   *
   * <p>Currently, only sorting by name or creationTimestamp desc is supported.
   */
  public String getOrderBy() {
    return orderBy;
  }

  /**
   * Specifies a page token to use. Set pageToken to the nextPageToken returned by a previous list
   * request to get the next page of results.
   */
  public String getPageToken() {
    return pageToken;
  }

  /** The response will show routes exchanged over the given peering connection. */
  public String getPeeringName() {
    return peeringName;
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
   * The region of the request. The response will include all subnet routes, static routes and
   * dynamic routes in the region.
   */
  public String getRegion() {
    return region;
  }

  /** IP address of the end user for whom the API call is being made. */
  public String getUserIp() {
    return userIp;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ListPeeringRoutesNetworksHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ListPeeringRoutesNetworksHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ListPeeringRoutesNetworksHttpRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ListPeeringRoutesNetworksHttpRequest();
  }

  public static class Builder {
    private String access_token;
    private String callback;
    private String direction;
    private String fields;
    private String filter;
    private String key;
    private Integer maxResults;
    private String network;
    private String orderBy;
    private String pageToken;
    private String peeringName;
    private String prettyPrint;
    private String quotaUser;
    private String region;
    private String userIp;

    Builder() {}

    public Builder mergeFrom(ListPeeringRoutesNetworksHttpRequest other) {
      if (other == ListPeeringRoutesNetworksHttpRequest.getDefaultInstance()) return this;
      if (other.getAccessToken() != null) {
        this.access_token = other.access_token;
      }
      if (other.getCallback() != null) {
        this.callback = other.callback;
      }
      if (other.getDirection() != null) {
        this.direction = other.direction;
      }
      if (other.getFields() != null) {
        this.fields = other.fields;
      }
      if (other.getFilter() != null) {
        this.filter = other.filter;
      }
      if (other.getKey() != null) {
        this.key = other.key;
      }
      if (other.getMaxResults() != null) {
        this.maxResults = other.maxResults;
      }
      if (other.getNetwork() != null) {
        this.network = other.network;
      }
      if (other.getOrderBy() != null) {
        this.orderBy = other.orderBy;
      }
      if (other.getPageToken() != null) {
        this.pageToken = other.pageToken;
      }
      if (other.getPeeringName() != null) {
        this.peeringName = other.peeringName;
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
      if (other.getUserIp() != null) {
        this.userIp = other.userIp;
      }
      return this;
    }

    Builder(ListPeeringRoutesNetworksHttpRequest source) {
      this.access_token = source.access_token;
      this.callback = source.callback;
      this.direction = source.direction;
      this.fields = source.fields;
      this.filter = source.filter;
      this.key = source.key;
      this.maxResults = source.maxResults;
      this.network = source.network;
      this.orderBy = source.orderBy;
      this.pageToken = source.pageToken;
      this.peeringName = source.peeringName;
      this.prettyPrint = source.prettyPrint;
      this.quotaUser = source.quotaUser;
      this.region = source.region;
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

    /** The direction of the exchanged routes. */
    public String getDirection() {
      return direction;
    }

    /** The direction of the exchanged routes. */
    public Builder setDirection(String direction) {
      this.direction = direction;
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

    /**
     * A filter expression that filters resources listed in the response. The expression must
     * specify the field name, a comparison operator, and the value that you want to use for
     * filtering. The value must be a string, a number, or a boolean. The comparison operator must
     * be either =, !=, &gt;, or &lt;.
     *
     * <p>For example, if you are filtering Compute Engine instances, you can exclude instances
     * named example-instance by specifying name != example-instance.
     *
     * <p>You can also filter nested fields. For example, you could specify
     * scheduling.automaticRestart = false to include instances only if they are not scheduled for
     * automatic restarts. You can use filtering on nested fields to filter based on resource
     * labels.
     *
     * <p>To filter on multiple expressions, provide each separate expression within parentheses.
     * For example, (scheduling.automaticRestart = true) (cpuPlatform = "Intel Skylake"). By
     * default, each expression is an AND expression. However, you can include AND and OR
     * expressions explicitly. For example, (cpuPlatform = "Intel Skylake") OR (cpuPlatform = "Intel
     * Broadwell") AND (scheduling.automaticRestart = true).
     */
    public String getFilter() {
      return filter;
    }

    /**
     * A filter expression that filters resources listed in the response. The expression must
     * specify the field name, a comparison operator, and the value that you want to use for
     * filtering. The value must be a string, a number, or a boolean. The comparison operator must
     * be either =, !=, &gt;, or &lt;.
     *
     * <p>For example, if you are filtering Compute Engine instances, you can exclude instances
     * named example-instance by specifying name != example-instance.
     *
     * <p>You can also filter nested fields. For example, you could specify
     * scheduling.automaticRestart = false to include instances only if they are not scheduled for
     * automatic restarts. You can use filtering on nested fields to filter based on resource
     * labels.
     *
     * <p>To filter on multiple expressions, provide each separate expression within parentheses.
     * For example, (scheduling.automaticRestart = true) (cpuPlatform = "Intel Skylake"). By
     * default, each expression is an AND expression. However, you can include AND and OR
     * expressions explicitly. For example, (cpuPlatform = "Intel Skylake") OR (cpuPlatform = "Intel
     * Broadwell") AND (scheduling.automaticRestart = true).
     */
    public Builder setFilter(String filter) {
      this.filter = filter;
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
     * The maximum number of results per page that should be returned. If the number of available
     * results is larger than maxResults, Compute Engine returns a nextPageToken that can be used to
     * get the next page of results in subsequent list requests. Acceptable values are 0 to 500,
     * inclusive. (Default: 500)
     */
    public Integer getMaxResults() {
      return maxResults;
    }

    /**
     * The maximum number of results per page that should be returned. If the number of available
     * results is larger than maxResults, Compute Engine returns a nextPageToken that can be used to
     * get the next page of results in subsequent list requests. Acceptable values are 0 to 500,
     * inclusive. (Default: 500)
     */
    public Builder setMaxResults(Integer maxResults) {
      this.maxResults = maxResults;
      return this;
    }

    /**
     * Name of the network for this request. It must have the format
     * `{project}/global/networks/{network}/listPeeringRoutes`. \`{network}\` must start with a
     * letter, and contain only letters (\`[A-Za-z]\`), numbers (\`[0-9]\`), dashes (\`-\`), &#42;
     * underscores (\`_\`), periods (\`.\`), tildes (\`~\`), plus (\`+\`) or percent &#42; signs
     * (\`%\`). It must be between 3 and 255 characters in length, and it &#42; must not start with
     * \`"goog"\`.
     */
    public String getNetwork() {
      return network;
    }

    /**
     * Name of the network for this request. It must have the format
     * `{project}/global/networks/{network}/listPeeringRoutes`. \`{network}\` must start with a
     * letter, and contain only letters (\`[A-Za-z]\`), numbers (\`[0-9]\`), dashes (\`-\`), &#42;
     * underscores (\`_\`), periods (\`.\`), tildes (\`~\`), plus (\`+\`) or percent &#42; signs
     * (\`%\`). It must be between 3 and 255 characters in length, and it &#42; must not start with
     * \`"goog"\`.
     */
    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    /**
     * Sorts list results by a certain order. By default, results are returned in alphanumerical
     * order based on the resource name.
     *
     * <p>You can also sort results in descending order based on the creation timestamp using
     * orderBy="creationTimestamp desc". This sorts results based on the creationTimestamp field in
     * reverse chronological order (newest result first). Use this to sort resources like operations
     * so that the newest operation is returned first.
     *
     * <p>Currently, only sorting by name or creationTimestamp desc is supported.
     */
    public String getOrderBy() {
      return orderBy;
    }

    /**
     * Sorts list results by a certain order. By default, results are returned in alphanumerical
     * order based on the resource name.
     *
     * <p>You can also sort results in descending order based on the creation timestamp using
     * orderBy="creationTimestamp desc". This sorts results based on the creationTimestamp field in
     * reverse chronological order (newest result first). Use this to sort resources like operations
     * so that the newest operation is returned first.
     *
     * <p>Currently, only sorting by name or creationTimestamp desc is supported.
     */
    public Builder setOrderBy(String orderBy) {
      this.orderBy = orderBy;
      return this;
    }

    /**
     * Specifies a page token to use. Set pageToken to the nextPageToken returned by a previous list
     * request to get the next page of results.
     */
    public String getPageToken() {
      return pageToken;
    }

    /**
     * Specifies a page token to use. Set pageToken to the nextPageToken returned by a previous list
     * request to get the next page of results.
     */
    public Builder setPageToken(String pageToken) {
      this.pageToken = pageToken;
      return this;
    }

    /** The response will show routes exchanged over the given peering connection. */
    public String getPeeringName() {
      return peeringName;
    }

    /** The response will show routes exchanged over the given peering connection. */
    public Builder setPeeringName(String peeringName) {
      this.peeringName = peeringName;
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
     * The region of the request. The response will include all subnet routes, static routes and
     * dynamic routes in the region.
     */
    public String getRegion() {
      return region;
    }

    /**
     * The region of the request. The response will include all subnet routes, static routes and
     * dynamic routes in the region.
     */
    public Builder setRegion(String region) {
      this.region = region;
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

    public ListPeeringRoutesNetworksHttpRequest build() {
      String missing = "";

      if (network == null) {
        missing += " network";
      }

      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new ListPeeringRoutesNetworksHttpRequest(
          access_token,
          callback,
          direction,
          fields,
          filter,
          key,
          maxResults,
          network,
          orderBy,
          pageToken,
          peeringName,
          prettyPrint,
          quotaUser,
          region,
          userIp);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAccessToken(this.access_token);
      newBuilder.setCallback(this.callback);
      newBuilder.setDirection(this.direction);
      newBuilder.setFields(this.fields);
      newBuilder.setFilter(this.filter);
      newBuilder.setKey(this.key);
      newBuilder.setMaxResults(this.maxResults);
      newBuilder.setNetwork(this.network);
      newBuilder.setOrderBy(this.orderBy);
      newBuilder.setPageToken(this.pageToken);
      newBuilder.setPeeringName(this.peeringName);
      newBuilder.setPrettyPrint(this.prettyPrint);
      newBuilder.setQuotaUser(this.quotaUser);
      newBuilder.setRegion(this.region);
      newBuilder.setUserIp(this.userIp);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ListPeeringRoutesNetworksHttpRequest{"
        + "access_token="
        + access_token
        + ", "
        + "callback="
        + callback
        + ", "
        + "direction="
        + direction
        + ", "
        + "fields="
        + fields
        + ", "
        + "filter="
        + filter
        + ", "
        + "key="
        + key
        + ", "
        + "maxResults="
        + maxResults
        + ", "
        + "network="
        + network
        + ", "
        + "orderBy="
        + orderBy
        + ", "
        + "pageToken="
        + pageToken
        + ", "
        + "peeringName="
        + peeringName
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
        + "userIp="
        + userIp
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ListPeeringRoutesNetworksHttpRequest) {
      ListPeeringRoutesNetworksHttpRequest that = (ListPeeringRoutesNetworksHttpRequest) o;
      return Objects.equals(this.access_token, that.getAccessToken())
          && Objects.equals(this.callback, that.getCallback())
          && Objects.equals(this.direction, that.getDirection())
          && Objects.equals(this.fields, that.getFields())
          && Objects.equals(this.filter, that.getFilter())
          && Objects.equals(this.key, that.getKey())
          && Objects.equals(this.maxResults, that.getMaxResults())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.orderBy, that.getOrderBy())
          && Objects.equals(this.pageToken, that.getPageToken())
          && Objects.equals(this.peeringName, that.getPeeringName())
          && Objects.equals(this.prettyPrint, that.getPrettyPrint())
          && Objects.equals(this.quotaUser, that.getQuotaUser())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.userIp, that.getUserIp());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        access_token,
        callback,
        direction,
        fields,
        filter,
        key,
        maxResults,
        network,
        orderBy,
        pageToken,
        peeringName,
        prettyPrint,
        quotaUser,
        region,
        userIp);
  }
}
