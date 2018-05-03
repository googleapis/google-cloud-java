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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class CacheKeyPolicy implements ApiMessage {
  private final Boolean includeHost;
  private final Boolean includeProtocol;
  private final Boolean includeQueryString;
  private final List<String> queryStringBlacklist;
  private final List<String> queryStringWhitelist;

  private CacheKeyPolicy() {
    this.includeHost = null;
    this.includeProtocol = null;
    this.includeQueryString = null;
    this.queryStringBlacklist = null;
    this.queryStringWhitelist = null;
  }

  private CacheKeyPolicy(
      Boolean includeHost,
      Boolean includeProtocol,
      Boolean includeQueryString,
      List<String> queryStringBlacklist,
      List<String> queryStringWhitelist) {
    this.includeHost = includeHost;
    this.includeProtocol = includeProtocol;
    this.includeQueryString = includeQueryString;
    this.queryStringBlacklist = queryStringBlacklist;
    this.queryStringWhitelist = queryStringWhitelist;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("includeHost")) {
      return includeHost;
    }
    if (fieldName.equals("includeProtocol")) {
      return includeProtocol;
    }
    if (fieldName.equals("includeQueryString")) {
      return includeQueryString;
    }
    if (fieldName.equals("queryStringBlacklist")) {
      return queryStringBlacklist;
    }
    if (fieldName.equals("queryStringWhitelist")) {
      return queryStringWhitelist;
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
  public List<String> getFieldMask() {
    return null;
  }

  public Boolean getIncludeHost() {
    return includeHost;
  }

  public Boolean getIncludeProtocol() {
    return includeProtocol;
  }

  public Boolean getIncludeQueryString() {
    return includeQueryString;
  }

  public List<String> getQueryStringBlacklistList() {
    return queryStringBlacklist;
  }

  public List<String> getQueryStringWhitelistList() {
    return queryStringWhitelist;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(CacheKeyPolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static CacheKeyPolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final CacheKeyPolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new CacheKeyPolicy();
  }

  public static class Builder {
    private Boolean includeHost;
    private Boolean includeProtocol;
    private Boolean includeQueryString;
    private List<String> queryStringBlacklist;
    private List<String> queryStringWhitelist;

    Builder() {}

    public Builder mergeFrom(CacheKeyPolicy other) {
      if (other == CacheKeyPolicy.getDefaultInstance()) return this;
      if (other.getIncludeHost() != null) {
        this.includeHost = other.includeHost;
      }
      if (other.getIncludeProtocol() != null) {
        this.includeProtocol = other.includeProtocol;
      }
      if (other.getIncludeQueryString() != null) {
        this.includeQueryString = other.includeQueryString;
      }
      if (other.getQueryStringBlacklistList() != null) {
        this.queryStringBlacklist = other.queryStringBlacklist;
      }
      if (other.getQueryStringWhitelistList() != null) {
        this.queryStringWhitelist = other.queryStringWhitelist;
      }
      return this;
    }

    Builder(CacheKeyPolicy source) {
      this.includeHost = source.includeHost;
      this.includeProtocol = source.includeProtocol;
      this.includeQueryString = source.includeQueryString;
      this.queryStringBlacklist = source.queryStringBlacklist;
      this.queryStringWhitelist = source.queryStringWhitelist;
    }

    public Boolean getIncludeHost() {
      return includeHost;
    }

    public Builder setIncludeHost(Boolean includeHost) {
      this.includeHost = includeHost;
      return this;
    }

    public Boolean getIncludeProtocol() {
      return includeProtocol;
    }

    public Builder setIncludeProtocol(Boolean includeProtocol) {
      this.includeProtocol = includeProtocol;
      return this;
    }

    public Boolean getIncludeQueryString() {
      return includeQueryString;
    }

    public Builder setIncludeQueryString(Boolean includeQueryString) {
      this.includeQueryString = includeQueryString;
      return this;
    }

    public List<String> getQueryStringBlacklistList() {
      return queryStringBlacklist;
    }

    public Builder addAllQueryStringBlacklist(List<String> queryStringBlacklist) {
      if (this.queryStringBlacklist == null) {
        this.queryStringBlacklist = new ArrayList<>(queryStringBlacklist.size());
      }
      this.queryStringBlacklist.addAll(queryStringBlacklist);
      return this;
    }

    public Builder addQueryStringBlacklist(String queryStringBlacklist) {
      this.queryStringBlacklist.add(queryStringBlacklist);
      return this;
    }

    public List<String> getQueryStringWhitelistList() {
      return queryStringWhitelist;
    }

    public Builder addAllQueryStringWhitelist(List<String> queryStringWhitelist) {
      if (this.queryStringWhitelist == null) {
        this.queryStringWhitelist = new ArrayList<>(queryStringWhitelist.size());
      }
      this.queryStringWhitelist.addAll(queryStringWhitelist);
      return this;
    }

    public Builder addQueryStringWhitelist(String queryStringWhitelist) {
      this.queryStringWhitelist.add(queryStringWhitelist);
      return this;
    }

    public CacheKeyPolicy build() {

      return new CacheKeyPolicy(
          includeHost,
          includeProtocol,
          includeQueryString,
          queryStringBlacklist,
          queryStringWhitelist);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setIncludeHost(this.includeHost);
      newBuilder.setIncludeProtocol(this.includeProtocol);
      newBuilder.setIncludeQueryString(this.includeQueryString);
      newBuilder.addAllQueryStringBlacklist(this.queryStringBlacklist);
      newBuilder.addAllQueryStringWhitelist(this.queryStringWhitelist);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "CacheKeyPolicy{"
        + "includeHost="
        + includeHost
        + ", "
        + "includeProtocol="
        + includeProtocol
        + ", "
        + "includeQueryString="
        + includeQueryString
        + ", "
        + "queryStringBlacklist="
        + queryStringBlacklist
        + ", "
        + "queryStringWhitelist="
        + queryStringWhitelist
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CacheKeyPolicy) {
      CacheKeyPolicy that = (CacheKeyPolicy) o;
      return Objects.equals(this.includeHost, that.getIncludeHost())
          && Objects.equals(this.includeProtocol, that.getIncludeProtocol())
          && Objects.equals(this.includeQueryString, that.getIncludeQueryString())
          && Objects.equals(this.queryStringBlacklist, that.getQueryStringBlacklistList())
          && Objects.equals(this.queryStringWhitelist, that.getQueryStringWhitelistList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        includeHost,
        includeProtocol,
        includeQueryString,
        queryStringBlacklist,
        queryStringWhitelist);
  }
}
