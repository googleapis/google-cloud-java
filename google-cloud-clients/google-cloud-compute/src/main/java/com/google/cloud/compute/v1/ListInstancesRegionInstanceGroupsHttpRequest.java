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
 * Request object for method compute.regionInstanceGroups.listInstances. Lists the instances in the
 * specified instance group and displays information about the named ports. Depending on the
 * specified options, this method can list all instances or only the instances that are running.
 */
public final class ListInstancesRegionInstanceGroupsHttpRequest implements ApiMessage {
  private final String access_token;
  private final String callback;
  private final String fields;
  private final String filter;
  private final String instanceGroup;
  private final String key;
  private final Integer maxResults;
  private final String orderBy;
  private final String pageToken;
  private final String prettyPrint;
  private final String quotaUser;
  private final RegionInstanceGroupsListInstancesRequest
      regionInstanceGroupsListInstancesRequestResource;
  private final String userIp;

  private ListInstancesRegionInstanceGroupsHttpRequest() {
    this.access_token = null;
    this.callback = null;
    this.fields = null;
    this.filter = null;
    this.instanceGroup = null;
    this.key = null;
    this.maxResults = null;
    this.orderBy = null;
    this.pageToken = null;
    this.prettyPrint = null;
    this.quotaUser = null;
    this.regionInstanceGroupsListInstancesRequestResource = null;
    this.userIp = null;
  }

  private ListInstancesRegionInstanceGroupsHttpRequest(
      String access_token,
      String callback,
      String fields,
      String filter,
      String instanceGroup,
      String key,
      Integer maxResults,
      String orderBy,
      String pageToken,
      String prettyPrint,
      String quotaUser,
      RegionInstanceGroupsListInstancesRequest regionInstanceGroupsListInstancesRequestResource,
      String userIp) {
    this.access_token = access_token;
    this.callback = callback;
    this.fields = fields;
    this.filter = filter;
    this.instanceGroup = instanceGroup;
    this.key = key;
    this.maxResults = maxResults;
    this.orderBy = orderBy;
    this.pageToken = pageToken;
    this.prettyPrint = prettyPrint;
    this.quotaUser = quotaUser;
    this.regionInstanceGroupsListInstancesRequestResource =
        regionInstanceGroupsListInstancesRequestResource;
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
    if ("filter".equals(fieldName)) {
      return filter;
    }
    if ("instanceGroup".equals(fieldName)) {
      return instanceGroup;
    }
    if ("key".equals(fieldName)) {
      return key;
    }
    if ("maxResults".equals(fieldName)) {
      return maxResults;
    }
    if ("orderBy".equals(fieldName)) {
      return orderBy;
    }
    if ("pageToken".equals(fieldName)) {
      return pageToken;
    }
    if ("prettyPrint".equals(fieldName)) {
      return prettyPrint;
    }
    if ("quotaUser".equals(fieldName)) {
      return quotaUser;
    }
    if ("regionInstanceGroupsListInstancesRequestResource".equals(fieldName)) {
      return regionInstanceGroupsListInstancesRequestResource;
    }
    if ("userIp".equals(fieldName)) {
      return userIp;
    }
    return null;
  }

  @Nullable
  @Override
  public RegionInstanceGroupsListInstancesRequest getApiMessageRequestBody() {
    return regionInstanceGroupsListInstancesRequestResource;
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

  /**
   * Name of the regional instance group for which we want to list the instances. It must have the
   * format `{project}/regions/{region}/instanceGroups/{instanceGroup}/listInstances`.
   * \`{instanceGroup}\` must start with a letter, and contain only letters (\`[A-Za-z]\`), numbers
   * (\`[0-9]\`), dashes (\`-\`), &#42; underscores (\`_\`), periods (\`.\`), tildes (\`~\`), plus
   * (\`+\`) or percent &#42; signs (\`%\`). It must be between 3 and 255 characters in length, and
   * it &#42; must not start with \`"goog"\`.
   */
  public String getInstanceGroup() {
    return instanceGroup;
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

  /** Returns response with indentations and line breaks. */
  public String getPrettyPrint() {
    return prettyPrint;
  }

  /** Alternative to userIp. */
  public String getQuotaUser() {
    return quotaUser;
  }

  public RegionInstanceGroupsListInstancesRequest
      getRegionInstanceGroupsListInstancesRequestResource() {
    return regionInstanceGroupsListInstancesRequestResource;
  }

  /** IP address of the end user for whom the API call is being made. */
  public String getUserIp() {
    return userIp;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ListInstancesRegionInstanceGroupsHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ListInstancesRegionInstanceGroupsHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ListInstancesRegionInstanceGroupsHttpRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ListInstancesRegionInstanceGroupsHttpRequest();
  }

  public static class Builder {
    private String access_token;
    private String callback;
    private String fields;
    private String filter;
    private String instanceGroup;
    private String key;
    private Integer maxResults;
    private String orderBy;
    private String pageToken;
    private String prettyPrint;
    private String quotaUser;
    private RegionInstanceGroupsListInstancesRequest
        regionInstanceGroupsListInstancesRequestResource;
    private String userIp;

    Builder() {}

    public Builder mergeFrom(ListInstancesRegionInstanceGroupsHttpRequest other) {
      if (other == ListInstancesRegionInstanceGroupsHttpRequest.getDefaultInstance()) return this;
      if (other.getAccessToken() != null) {
        this.access_token = other.access_token;
      }
      if (other.getCallback() != null) {
        this.callback = other.callback;
      }
      if (other.getFields() != null) {
        this.fields = other.fields;
      }
      if (other.getFilter() != null) {
        this.filter = other.filter;
      }
      if (other.getInstanceGroup() != null) {
        this.instanceGroup = other.instanceGroup;
      }
      if (other.getKey() != null) {
        this.key = other.key;
      }
      if (other.getMaxResults() != null) {
        this.maxResults = other.maxResults;
      }
      if (other.getOrderBy() != null) {
        this.orderBy = other.orderBy;
      }
      if (other.getPageToken() != null) {
        this.pageToken = other.pageToken;
      }
      if (other.getPrettyPrint() != null) {
        this.prettyPrint = other.prettyPrint;
      }
      if (other.getQuotaUser() != null) {
        this.quotaUser = other.quotaUser;
      }
      if (other.getRegionInstanceGroupsListInstancesRequestResource() != null) {
        this.regionInstanceGroupsListInstancesRequestResource =
            other.regionInstanceGroupsListInstancesRequestResource;
      }
      if (other.getUserIp() != null) {
        this.userIp = other.userIp;
      }
      return this;
    }

    Builder(ListInstancesRegionInstanceGroupsHttpRequest source) {
      this.access_token = source.access_token;
      this.callback = source.callback;
      this.fields = source.fields;
      this.filter = source.filter;
      this.instanceGroup = source.instanceGroup;
      this.key = source.key;
      this.maxResults = source.maxResults;
      this.orderBy = source.orderBy;
      this.pageToken = source.pageToken;
      this.prettyPrint = source.prettyPrint;
      this.quotaUser = source.quotaUser;
      this.regionInstanceGroupsListInstancesRequestResource =
          source.regionInstanceGroupsListInstancesRequestResource;
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

    /**
     * Name of the regional instance group for which we want to list the instances. It must have the
     * format `{project}/regions/{region}/instanceGroups/{instanceGroup}/listInstances`.
     * \`{instanceGroup}\` must start with a letter, and contain only letters (\`[A-Za-z]\`),
     * numbers (\`[0-9]\`), dashes (\`-\`), &#42; underscores (\`_\`), periods (\`.\`), tildes
     * (\`~\`), plus (\`+\`) or percent &#42; signs (\`%\`). It must be between 3 and 255 characters
     * in length, and it &#42; must not start with \`"goog"\`.
     */
    public String getInstanceGroup() {
      return instanceGroup;
    }

    /**
     * Name of the regional instance group for which we want to list the instances. It must have the
     * format `{project}/regions/{region}/instanceGroups/{instanceGroup}/listInstances`.
     * \`{instanceGroup}\` must start with a letter, and contain only letters (\`[A-Za-z]\`),
     * numbers (\`[0-9]\`), dashes (\`-\`), &#42; underscores (\`_\`), periods (\`.\`), tildes
     * (\`~\`), plus (\`+\`) or percent &#42; signs (\`%\`). It must be between 3 and 255 characters
     * in length, and it &#42; must not start with \`"goog"\`.
     */
    public Builder setInstanceGroup(String instanceGroup) {
      this.instanceGroup = instanceGroup;
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

    public RegionInstanceGroupsListInstancesRequest
        getRegionInstanceGroupsListInstancesRequestResource() {
      return regionInstanceGroupsListInstancesRequestResource;
    }

    public Builder setRegionInstanceGroupsListInstancesRequestResource(
        RegionInstanceGroupsListInstancesRequest regionInstanceGroupsListInstancesRequestResource) {
      this.regionInstanceGroupsListInstancesRequestResource =
          regionInstanceGroupsListInstancesRequestResource;
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

    public ListInstancesRegionInstanceGroupsHttpRequest build() {
      String missing = "";

      if (instanceGroup == null) {
        missing += " instanceGroup";
      }

      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new ListInstancesRegionInstanceGroupsHttpRequest(
          access_token,
          callback,
          fields,
          filter,
          instanceGroup,
          key,
          maxResults,
          orderBy,
          pageToken,
          prettyPrint,
          quotaUser,
          regionInstanceGroupsListInstancesRequestResource,
          userIp);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAccessToken(this.access_token);
      newBuilder.setCallback(this.callback);
      newBuilder.setFields(this.fields);
      newBuilder.setFilter(this.filter);
      newBuilder.setInstanceGroup(this.instanceGroup);
      newBuilder.setKey(this.key);
      newBuilder.setMaxResults(this.maxResults);
      newBuilder.setOrderBy(this.orderBy);
      newBuilder.setPageToken(this.pageToken);
      newBuilder.setPrettyPrint(this.prettyPrint);
      newBuilder.setQuotaUser(this.quotaUser);
      newBuilder.setRegionInstanceGroupsListInstancesRequestResource(
          this.regionInstanceGroupsListInstancesRequestResource);
      newBuilder.setUserIp(this.userIp);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ListInstancesRegionInstanceGroupsHttpRequest{"
        + "access_token="
        + access_token
        + ", "
        + "callback="
        + callback
        + ", "
        + "fields="
        + fields
        + ", "
        + "filter="
        + filter
        + ", "
        + "instanceGroup="
        + instanceGroup
        + ", "
        + "key="
        + key
        + ", "
        + "maxResults="
        + maxResults
        + ", "
        + "orderBy="
        + orderBy
        + ", "
        + "pageToken="
        + pageToken
        + ", "
        + "prettyPrint="
        + prettyPrint
        + ", "
        + "quotaUser="
        + quotaUser
        + ", "
        + "regionInstanceGroupsListInstancesRequestResource="
        + regionInstanceGroupsListInstancesRequestResource
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
    if (o instanceof ListInstancesRegionInstanceGroupsHttpRequest) {
      ListInstancesRegionInstanceGroupsHttpRequest that =
          (ListInstancesRegionInstanceGroupsHttpRequest) o;
      return Objects.equals(this.access_token, that.getAccessToken())
          && Objects.equals(this.callback, that.getCallback())
          && Objects.equals(this.fields, that.getFields())
          && Objects.equals(this.filter, that.getFilter())
          && Objects.equals(this.instanceGroup, that.getInstanceGroup())
          && Objects.equals(this.key, that.getKey())
          && Objects.equals(this.maxResults, that.getMaxResults())
          && Objects.equals(this.orderBy, that.getOrderBy())
          && Objects.equals(this.pageToken, that.getPageToken())
          && Objects.equals(this.prettyPrint, that.getPrettyPrint())
          && Objects.equals(this.quotaUser, that.getQuotaUser())
          && Objects.equals(
              this.regionInstanceGroupsListInstancesRequestResource,
              that.getRegionInstanceGroupsListInstancesRequestResource())
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
        filter,
        instanceGroup,
        key,
        maxResults,
        orderBy,
        pageToken,
        prettyPrint,
        quotaUser,
        regionInstanceGroupsListInstancesRequestResource,
        userIp);
  }
}
