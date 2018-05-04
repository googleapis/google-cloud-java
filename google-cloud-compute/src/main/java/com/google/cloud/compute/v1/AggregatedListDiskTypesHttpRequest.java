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
public final class AggregatedListDiskTypesHttpRequest implements ApiMessage {
  private final String access_token;
  private final String callback;
  private final String fields;
  private final String filter;
  private final String key;
  private final Integer maxResults;
  private final String orderBy;
  private final String pageToken;
  private final String prettyPrint;
  private final String project;
  private final String quotaUser;
  private final String userIp;

  private AggregatedListDiskTypesHttpRequest() {
    this.access_token = null;
    this.callback = null;
    this.fields = null;
    this.filter = null;
    this.key = null;
    this.maxResults = null;
    this.orderBy = null;
    this.pageToken = null;
    this.prettyPrint = null;
    this.project = null;
    this.quotaUser = null;
    this.userIp = null;
  }

  private AggregatedListDiskTypesHttpRequest(
      String access_token,
      String callback,
      String fields,
      String filter,
      String key,
      Integer maxResults,
      String orderBy,
      String pageToken,
      String prettyPrint,
      String project,
      String quotaUser,
      String userIp) {
    this.access_token = access_token;
    this.callback = callback;
    this.fields = fields;
    this.filter = filter;
    this.key = key;
    this.maxResults = maxResults;
    this.orderBy = orderBy;
    this.pageToken = pageToken;
    this.prettyPrint = prettyPrint;
    this.project = project;
    this.quotaUser = quotaUser;
    this.userIp = userIp;
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
    if (fieldNames.contains("filter") && filter != null) {
      fieldMap.put("filter", Collections.singletonList(String.valueOf(filter)));
    }
    if (fieldNames.contains("key") && key != null) {
      fieldMap.put("key", Collections.singletonList(String.valueOf(key)));
    }
    if (fieldNames.contains("maxResults") && maxResults != null) {
      fieldMap.put("maxResults", Collections.singletonList(String.valueOf(maxResults)));
    }
    if (fieldNames.contains("orderBy") && orderBy != null) {
      fieldMap.put("orderBy", Collections.singletonList(String.valueOf(orderBy)));
    }
    if (fieldNames.contains("pageToken") && pageToken != null) {
      fieldMap.put("pageToken", Collections.singletonList(String.valueOf(pageToken)));
    }
    if (fieldNames.contains("prettyPrint") && prettyPrint != null) {
      fieldMap.put("prettyPrint", Collections.singletonList(String.valueOf(prettyPrint)));
    }
    if (fieldNames.contains("project") && project != null) {
      fieldMap.put("project", Collections.singletonList(String.valueOf(project)));
    }
    if (fieldNames.contains("quotaUser") && quotaUser != null) {
      fieldMap.put("quotaUser", Collections.singletonList(String.valueOf(quotaUser)));
    }
    if (fieldNames.contains("userIp") && userIp != null) {
      fieldMap.put("userIp", Collections.singletonList(String.valueOf(userIp)));
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
    if (fieldName.equals("filter")) {
      return String.valueOf(filter);
    }
    if (fieldName.equals("key")) {
      return String.valueOf(key);
    }
    if (fieldName.equals("maxResults")) {
      return String.valueOf(maxResults);
    }
    if (fieldName.equals("orderBy")) {
      return String.valueOf(orderBy);
    }
    if (fieldName.equals("pageToken")) {
      return String.valueOf(pageToken);
    }
    if (fieldName.equals("prettyPrint")) {
      return String.valueOf(prettyPrint);
    }
    if (fieldName.equals("project")) {
      return String.valueOf(project);
    }
    if (fieldName.equals("quotaUser")) {
      return String.valueOf(quotaUser);
    }
    if (fieldName.equals("userIp")) {
      return String.valueOf(userIp);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
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

  public String getFilter() {
    return filter;
  }

  public String getKey() {
    return key;
  }

  public Integer getMaxResults() {
    return maxResults;
  }

  public String getOrderBy() {
    return orderBy;
  }

  public String getPageToken() {
    return pageToken;
  }

  public String getPrettyPrint() {
    return prettyPrint;
  }

  public String getProject() {
    return project;
  }

  public String getQuotaUser() {
    return quotaUser;
  }

  public String getUserIp() {
    return userIp;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AggregatedListDiskTypesHttpRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AggregatedListDiskTypesHttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AggregatedListDiskTypesHttpRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AggregatedListDiskTypesHttpRequest();
  }

  public static class Builder {
    private String access_token;
    private String callback;
    private String fields;
    private String filter;
    private String key;
    private Integer maxResults;
    private String orderBy;
    private String pageToken;
    private String prettyPrint;
    private String project;
    private String quotaUser;
    private String userIp;

    Builder() {}

    public Builder mergeFrom(AggregatedListDiskTypesHttpRequest other) {
      if (other == AggregatedListDiskTypesHttpRequest.getDefaultInstance()) return this;
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
      if (other.getProject() != null) {
        this.project = other.project;
      }
      if (other.getQuotaUser() != null) {
        this.quotaUser = other.quotaUser;
      }
      if (other.getUserIp() != null) {
        this.userIp = other.userIp;
      }
      return this;
    }

    Builder(AggregatedListDiskTypesHttpRequest source) {
      this.access_token = source.access_token;
      this.callback = source.callback;
      this.fields = source.fields;
      this.filter = source.filter;
      this.key = source.key;
      this.maxResults = source.maxResults;
      this.orderBy = source.orderBy;
      this.pageToken = source.pageToken;
      this.prettyPrint = source.prettyPrint;
      this.project = source.project;
      this.quotaUser = source.quotaUser;
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

    public String getFields() {
      return fields;
    }

    public Builder setFields(String fields) {
      this.fields = fields;
      return this;
    }

    public String getFilter() {
      return filter;
    }

    public Builder setFilter(String filter) {
      this.filter = filter;
      return this;
    }

    public String getKey() {
      return key;
    }

    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    public Integer getMaxResults() {
      return maxResults;
    }

    public Builder setMaxResults(Integer maxResults) {
      this.maxResults = maxResults;
      return this;
    }

    public String getOrderBy() {
      return orderBy;
    }

    public Builder setOrderBy(String orderBy) {
      this.orderBy = orderBy;
      return this;
    }

    public String getPageToken() {
      return pageToken;
    }

    public Builder setPageToken(String pageToken) {
      this.pageToken = pageToken;
      return this;
    }

    public String getPrettyPrint() {
      return prettyPrint;
    }

    public Builder setPrettyPrint(String prettyPrint) {
      this.prettyPrint = prettyPrint;
      return this;
    }

    public String getProject() {
      return project;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public String getQuotaUser() {
      return quotaUser;
    }

    public Builder setQuotaUser(String quotaUser) {
      this.quotaUser = quotaUser;
      return this;
    }

    public String getUserIp() {
      return userIp;
    }

    public Builder setUserIp(String userIp) {
      this.userIp = userIp;
      return this;
    }

    public AggregatedListDiskTypesHttpRequest build() {
      String missing = "";

      if (project == null) {
        missing += " project";
      }

      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AggregatedListDiskTypesHttpRequest(
          access_token,
          callback,
          fields,
          filter,
          key,
          maxResults,
          orderBy,
          pageToken,
          prettyPrint,
          project,
          quotaUser,
          userIp);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAccessToken(this.access_token);
      newBuilder.setCallback(this.callback);
      newBuilder.setFields(this.fields);
      newBuilder.setFilter(this.filter);
      newBuilder.setKey(this.key);
      newBuilder.setMaxResults(this.maxResults);
      newBuilder.setOrderBy(this.orderBy);
      newBuilder.setPageToken(this.pageToken);
      newBuilder.setPrettyPrint(this.prettyPrint);
      newBuilder.setProject(this.project);
      newBuilder.setQuotaUser(this.quotaUser);
      newBuilder.setUserIp(this.userIp);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AggregatedListDiskTypesHttpRequest{"
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
        + "project="
        + project
        + ", "
        + "quotaUser="
        + quotaUser
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
    if (o instanceof AggregatedListDiskTypesHttpRequest) {
      AggregatedListDiskTypesHttpRequest that = (AggregatedListDiskTypesHttpRequest) o;
      return Objects.equals(this.access_token, that.getAccessToken())
          && Objects.equals(this.callback, that.getCallback())
          && Objects.equals(this.fields, that.getFields())
          && Objects.equals(this.filter, that.getFilter())
          && Objects.equals(this.key, that.getKey())
          && Objects.equals(this.maxResults, that.getMaxResults())
          && Objects.equals(this.orderBy, that.getOrderBy())
          && Objects.equals(this.pageToken, that.getPageToken())
          && Objects.equals(this.prettyPrint, that.getPrettyPrint())
          && Objects.equals(this.project, that.getProject())
          && Objects.equals(this.quotaUser, that.getQuotaUser())
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
        key,
        maxResults,
        orderBy,
        pageToken,
        prettyPrint,
        project,
        quotaUser,
        userIp);
  }
}
