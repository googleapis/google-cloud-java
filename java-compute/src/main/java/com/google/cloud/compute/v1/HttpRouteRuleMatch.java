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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * HttpRouteRuleMatch specifies a set of criteria for matching requests to an HttpRouteRule. All
 * specified criteria must be satisfied for a match to occur.
 */
public final class HttpRouteRuleMatch implements ApiMessage {
  private final String fullPathMatch;
  private final List<HttpHeaderMatch> headerMatches;
  private final Boolean ignoreCase;
  private final List<MetadataFilter> metadataFilters;
  private final String prefixMatch;
  private final List<HttpQueryParameterMatch> queryParameterMatches;
  private final String regexMatch;

  private HttpRouteRuleMatch() {
    this.fullPathMatch = null;
    this.headerMatches = null;
    this.ignoreCase = null;
    this.metadataFilters = null;
    this.prefixMatch = null;
    this.queryParameterMatches = null;
    this.regexMatch = null;
  }

  private HttpRouteRuleMatch(
      String fullPathMatch,
      List<HttpHeaderMatch> headerMatches,
      Boolean ignoreCase,
      List<MetadataFilter> metadataFilters,
      String prefixMatch,
      List<HttpQueryParameterMatch> queryParameterMatches,
      String regexMatch) {
    this.fullPathMatch = fullPathMatch;
    this.headerMatches = headerMatches;
    this.ignoreCase = ignoreCase;
    this.metadataFilters = metadataFilters;
    this.prefixMatch = prefixMatch;
    this.queryParameterMatches = queryParameterMatches;
    this.regexMatch = regexMatch;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("fullPathMatch".equals(fieldName)) {
      return fullPathMatch;
    }
    if ("headerMatches".equals(fieldName)) {
      return headerMatches;
    }
    if ("ignoreCase".equals(fieldName)) {
      return ignoreCase;
    }
    if ("metadataFilters".equals(fieldName)) {
      return metadataFilters;
    }
    if ("prefixMatch".equals(fieldName)) {
      return prefixMatch;
    }
    if ("queryParameterMatches".equals(fieldName)) {
      return queryParameterMatches;
    }
    if ("regexMatch".equals(fieldName)) {
      return regexMatch;
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

  /**
   * For satifying the matchRule condition, the path of the request must exactly match the value
   * specified in fullPathMatch after removing any query parameters and anchor that may be part of
   * the original URL. FullPathMatch must be between 1 and 1024 characters. Only one of prefixMatch,
   * fullPathMatch or regexMatch must be specified.
   */
  public String getFullPathMatch() {
    return fullPathMatch;
  }

  /**
   * Specifies a list of header match criteria, all of which must match corresponding headers in the
   * request.
   */
  public List<HttpHeaderMatch> getHeaderMatchesList() {
    return headerMatches;
  }

  /**
   * Specifies that prefixMatch and fullPathMatch matches are case sensitive. The default value is
   * false. caseSensitive must not be used with regexMatch.
   */
  public Boolean getIgnoreCase() {
    return ignoreCase;
  }

  /**
   * Opaque filter criteria used by Loadbalancer to restrict routing configuration to a limited set
   * xDS compliant clients. In their xDS requests to Loadbalancer, xDS clients present node
   * metadata. If a match takes place, the relevant routing configuration is made available to those
   * proxies. For each metadataFilter in this list, if its filterMatchCriteria is set to MATCH_ANY,
   * at least one of the filterLabels must match the corresponding label provided in the metadata.
   * If its filterMatchCriteria is set to MATCH_ALL, then all of its filterLabels must match with
   * corresponding labels in the provided metadata. metadataFilters specified here can be overrides
   * those specified in ForwardingRule that refers to this UrlMap. metadataFilters only applies to
   * Loadbalancers that have their loadBalancingScheme set to INTERNAL_SELF_MANAGED.
   */
  public List<MetadataFilter> getMetadataFiltersList() {
    return metadataFilters;
  }

  /**
   * For satifying the matchRule condition, the request's path must begin with the specified
   * prefixMatch. prefixMatch must begin with a /. The value must be between 1 and 1024 characters.
   * Only one of prefixMatch, fullPathMatch or regexMatch must be specified.
   */
  public String getPrefixMatch() {
    return prefixMatch;
  }

  /**
   * Specifies a list of query parameter match criteria, all of which must match corresponding query
   * parameters in the request.
   */
  public List<HttpQueryParameterMatch> getQueryParameterMatchesList() {
    return queryParameterMatches;
  }

  /**
   * For satifying the matchRule condition, the path of the request must satisfy the regular
   * expression specified in regexMatch after removing any query parameters and anchor supplied with
   * the original URL. For regular expression grammar please see
   * en.cppreference.com/w/cpp/regex/ecmascript Only one of prefixMatch, fullPathMatch or regexMatch
   * must be specified.
   */
  public String getRegexMatch() {
    return regexMatch;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HttpRouteRuleMatch prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HttpRouteRuleMatch getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HttpRouteRuleMatch DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HttpRouteRuleMatch();
  }

  public static class Builder {
    private String fullPathMatch;
    private List<HttpHeaderMatch> headerMatches;
    private Boolean ignoreCase;
    private List<MetadataFilter> metadataFilters;
    private String prefixMatch;
    private List<HttpQueryParameterMatch> queryParameterMatches;
    private String regexMatch;

    Builder() {}

    public Builder mergeFrom(HttpRouteRuleMatch other) {
      if (other == HttpRouteRuleMatch.getDefaultInstance()) return this;
      if (other.getFullPathMatch() != null) {
        this.fullPathMatch = other.fullPathMatch;
      }
      if (other.getHeaderMatchesList() != null) {
        this.headerMatches = other.headerMatches;
      }
      if (other.getIgnoreCase() != null) {
        this.ignoreCase = other.ignoreCase;
      }
      if (other.getMetadataFiltersList() != null) {
        this.metadataFilters = other.metadataFilters;
      }
      if (other.getPrefixMatch() != null) {
        this.prefixMatch = other.prefixMatch;
      }
      if (other.getQueryParameterMatchesList() != null) {
        this.queryParameterMatches = other.queryParameterMatches;
      }
      if (other.getRegexMatch() != null) {
        this.regexMatch = other.regexMatch;
      }
      return this;
    }

    Builder(HttpRouteRuleMatch source) {
      this.fullPathMatch = source.fullPathMatch;
      this.headerMatches = source.headerMatches;
      this.ignoreCase = source.ignoreCase;
      this.metadataFilters = source.metadataFilters;
      this.prefixMatch = source.prefixMatch;
      this.queryParameterMatches = source.queryParameterMatches;
      this.regexMatch = source.regexMatch;
    }

    /**
     * For satifying the matchRule condition, the path of the request must exactly match the value
     * specified in fullPathMatch after removing any query parameters and anchor that may be part of
     * the original URL. FullPathMatch must be between 1 and 1024 characters. Only one of
     * prefixMatch, fullPathMatch or regexMatch must be specified.
     */
    public String getFullPathMatch() {
      return fullPathMatch;
    }

    /**
     * For satifying the matchRule condition, the path of the request must exactly match the value
     * specified in fullPathMatch after removing any query parameters and anchor that may be part of
     * the original URL. FullPathMatch must be between 1 and 1024 characters. Only one of
     * prefixMatch, fullPathMatch or regexMatch must be specified.
     */
    public Builder setFullPathMatch(String fullPathMatch) {
      this.fullPathMatch = fullPathMatch;
      return this;
    }

    /**
     * Specifies a list of header match criteria, all of which must match corresponding headers in
     * the request.
     */
    public List<HttpHeaderMatch> getHeaderMatchesList() {
      return headerMatches;
    }

    /**
     * Specifies a list of header match criteria, all of which must match corresponding headers in
     * the request.
     */
    public Builder addAllHeaderMatches(List<HttpHeaderMatch> headerMatches) {
      if (this.headerMatches == null) {
        this.headerMatches = new LinkedList<>();
      }
      this.headerMatches.addAll(headerMatches);
      return this;
    }

    /**
     * Specifies a list of header match criteria, all of which must match corresponding headers in
     * the request.
     */
    public Builder addHeaderMatches(HttpHeaderMatch headerMatches) {
      if (this.headerMatches == null) {
        this.headerMatches = new LinkedList<>();
      }
      this.headerMatches.add(headerMatches);
      return this;
    }

    /**
     * Specifies that prefixMatch and fullPathMatch matches are case sensitive. The default value is
     * false. caseSensitive must not be used with regexMatch.
     */
    public Boolean getIgnoreCase() {
      return ignoreCase;
    }

    /**
     * Specifies that prefixMatch and fullPathMatch matches are case sensitive. The default value is
     * false. caseSensitive must not be used with regexMatch.
     */
    public Builder setIgnoreCase(Boolean ignoreCase) {
      this.ignoreCase = ignoreCase;
      return this;
    }

    /**
     * Opaque filter criteria used by Loadbalancer to restrict routing configuration to a limited
     * set xDS compliant clients. In their xDS requests to Loadbalancer, xDS clients present node
     * metadata. If a match takes place, the relevant routing configuration is made available to
     * those proxies. For each metadataFilter in this list, if its filterMatchCriteria is set to
     * MATCH_ANY, at least one of the filterLabels must match the corresponding label provided in
     * the metadata. If its filterMatchCriteria is set to MATCH_ALL, then all of its filterLabels
     * must match with corresponding labels in the provided metadata. metadataFilters specified here
     * can be overrides those specified in ForwardingRule that refers to this UrlMap.
     * metadataFilters only applies to Loadbalancers that have their loadBalancingScheme set to
     * INTERNAL_SELF_MANAGED.
     */
    public List<MetadataFilter> getMetadataFiltersList() {
      return metadataFilters;
    }

    /**
     * Opaque filter criteria used by Loadbalancer to restrict routing configuration to a limited
     * set xDS compliant clients. In their xDS requests to Loadbalancer, xDS clients present node
     * metadata. If a match takes place, the relevant routing configuration is made available to
     * those proxies. For each metadataFilter in this list, if its filterMatchCriteria is set to
     * MATCH_ANY, at least one of the filterLabels must match the corresponding label provided in
     * the metadata. If its filterMatchCriteria is set to MATCH_ALL, then all of its filterLabels
     * must match with corresponding labels in the provided metadata. metadataFilters specified here
     * can be overrides those specified in ForwardingRule that refers to this UrlMap.
     * metadataFilters only applies to Loadbalancers that have their loadBalancingScheme set to
     * INTERNAL_SELF_MANAGED.
     */
    public Builder addAllMetadataFilters(List<MetadataFilter> metadataFilters) {
      if (this.metadataFilters == null) {
        this.metadataFilters = new LinkedList<>();
      }
      this.metadataFilters.addAll(metadataFilters);
      return this;
    }

    /**
     * Opaque filter criteria used by Loadbalancer to restrict routing configuration to a limited
     * set xDS compliant clients. In their xDS requests to Loadbalancer, xDS clients present node
     * metadata. If a match takes place, the relevant routing configuration is made available to
     * those proxies. For each metadataFilter in this list, if its filterMatchCriteria is set to
     * MATCH_ANY, at least one of the filterLabels must match the corresponding label provided in
     * the metadata. If its filterMatchCriteria is set to MATCH_ALL, then all of its filterLabels
     * must match with corresponding labels in the provided metadata. metadataFilters specified here
     * can be overrides those specified in ForwardingRule that refers to this UrlMap.
     * metadataFilters only applies to Loadbalancers that have their loadBalancingScheme set to
     * INTERNAL_SELF_MANAGED.
     */
    public Builder addMetadataFilters(MetadataFilter metadataFilters) {
      if (this.metadataFilters == null) {
        this.metadataFilters = new LinkedList<>();
      }
      this.metadataFilters.add(metadataFilters);
      return this;
    }

    /**
     * For satifying the matchRule condition, the request's path must begin with the specified
     * prefixMatch. prefixMatch must begin with a /. The value must be between 1 and 1024
     * characters. Only one of prefixMatch, fullPathMatch or regexMatch must be specified.
     */
    public String getPrefixMatch() {
      return prefixMatch;
    }

    /**
     * For satifying the matchRule condition, the request's path must begin with the specified
     * prefixMatch. prefixMatch must begin with a /. The value must be between 1 and 1024
     * characters. Only one of prefixMatch, fullPathMatch or regexMatch must be specified.
     */
    public Builder setPrefixMatch(String prefixMatch) {
      this.prefixMatch = prefixMatch;
      return this;
    }

    /**
     * Specifies a list of query parameter match criteria, all of which must match corresponding
     * query parameters in the request.
     */
    public List<HttpQueryParameterMatch> getQueryParameterMatchesList() {
      return queryParameterMatches;
    }

    /**
     * Specifies a list of query parameter match criteria, all of which must match corresponding
     * query parameters in the request.
     */
    public Builder addAllQueryParameterMatches(
        List<HttpQueryParameterMatch> queryParameterMatches) {
      if (this.queryParameterMatches == null) {
        this.queryParameterMatches = new LinkedList<>();
      }
      this.queryParameterMatches.addAll(queryParameterMatches);
      return this;
    }

    /**
     * Specifies a list of query parameter match criteria, all of which must match corresponding
     * query parameters in the request.
     */
    public Builder addQueryParameterMatches(HttpQueryParameterMatch queryParameterMatches) {
      if (this.queryParameterMatches == null) {
        this.queryParameterMatches = new LinkedList<>();
      }
      this.queryParameterMatches.add(queryParameterMatches);
      return this;
    }

    /**
     * For satifying the matchRule condition, the path of the request must satisfy the regular
     * expression specified in regexMatch after removing any query parameters and anchor supplied
     * with the original URL. For regular expression grammar please see
     * en.cppreference.com/w/cpp/regex/ecmascript Only one of prefixMatch, fullPathMatch or
     * regexMatch must be specified.
     */
    public String getRegexMatch() {
      return regexMatch;
    }

    /**
     * For satifying the matchRule condition, the path of the request must satisfy the regular
     * expression specified in regexMatch after removing any query parameters and anchor supplied
     * with the original URL. For regular expression grammar please see
     * en.cppreference.com/w/cpp/regex/ecmascript Only one of prefixMatch, fullPathMatch or
     * regexMatch must be specified.
     */
    public Builder setRegexMatch(String regexMatch) {
      this.regexMatch = regexMatch;
      return this;
    }

    public HttpRouteRuleMatch build() {

      return new HttpRouteRuleMatch(
          fullPathMatch,
          headerMatches,
          ignoreCase,
          metadataFilters,
          prefixMatch,
          queryParameterMatches,
          regexMatch);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setFullPathMatch(this.fullPathMatch);
      newBuilder.addAllHeaderMatches(this.headerMatches);
      newBuilder.setIgnoreCase(this.ignoreCase);
      newBuilder.addAllMetadataFilters(this.metadataFilters);
      newBuilder.setPrefixMatch(this.prefixMatch);
      newBuilder.addAllQueryParameterMatches(this.queryParameterMatches);
      newBuilder.setRegexMatch(this.regexMatch);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HttpRouteRuleMatch{"
        + "fullPathMatch="
        + fullPathMatch
        + ", "
        + "headerMatches="
        + headerMatches
        + ", "
        + "ignoreCase="
        + ignoreCase
        + ", "
        + "metadataFilters="
        + metadataFilters
        + ", "
        + "prefixMatch="
        + prefixMatch
        + ", "
        + "queryParameterMatches="
        + queryParameterMatches
        + ", "
        + "regexMatch="
        + regexMatch
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HttpRouteRuleMatch) {
      HttpRouteRuleMatch that = (HttpRouteRuleMatch) o;
      return Objects.equals(this.fullPathMatch, that.getFullPathMatch())
          && Objects.equals(this.headerMatches, that.getHeaderMatchesList())
          && Objects.equals(this.ignoreCase, that.getIgnoreCase())
          && Objects.equals(this.metadataFilters, that.getMetadataFiltersList())
          && Objects.equals(this.prefixMatch, that.getPrefixMatch())
          && Objects.equals(this.queryParameterMatches, that.getQueryParameterMatchesList())
          && Objects.equals(this.regexMatch, that.getRegexMatch());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        fullPathMatch,
        headerMatches,
        ignoreCase,
        metadataFilters,
        prefixMatch,
        queryParameterMatches,
        regexMatch);
  }
}
