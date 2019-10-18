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
/** Specifies settings for an HTTP redirect. */
public final class HttpRedirectAction implements ApiMessage {
  private final String hostRedirect;
  private final Boolean httpsRedirect;
  private final String pathRedirect;
  private final String prefixRedirect;
  private final String redirectResponseCode;
  private final Boolean stripQuery;

  private HttpRedirectAction() {
    this.hostRedirect = null;
    this.httpsRedirect = null;
    this.pathRedirect = null;
    this.prefixRedirect = null;
    this.redirectResponseCode = null;
    this.stripQuery = null;
  }

  private HttpRedirectAction(
      String hostRedirect,
      Boolean httpsRedirect,
      String pathRedirect,
      String prefixRedirect,
      String redirectResponseCode,
      Boolean stripQuery) {
    this.hostRedirect = hostRedirect;
    this.httpsRedirect = httpsRedirect;
    this.pathRedirect = pathRedirect;
    this.prefixRedirect = prefixRedirect;
    this.redirectResponseCode = redirectResponseCode;
    this.stripQuery = stripQuery;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("hostRedirect".equals(fieldName)) {
      return hostRedirect;
    }
    if ("httpsRedirect".equals(fieldName)) {
      return httpsRedirect;
    }
    if ("pathRedirect".equals(fieldName)) {
      return pathRedirect;
    }
    if ("prefixRedirect".equals(fieldName)) {
      return prefixRedirect;
    }
    if ("redirectResponseCode".equals(fieldName)) {
      return redirectResponseCode;
    }
    if ("stripQuery".equals(fieldName)) {
      return stripQuery;
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
   * The host that will be used in the redirect response instead of the one that was supplied in the
   * request. The value must be between 1 and 255 characters.
   */
  public String getHostRedirect() {
    return hostRedirect;
  }

  /**
   * If set to true, the URL scheme in the redirected request is set to https. If set to false, the
   * URL scheme of the redirected request will remain the same as that of the request. This must
   * only be set for UrlMaps used in TargetHttpProxys. Setting this true for TargetHttpsProxy is not
   * permitted. The default is set to false.
   */
  public Boolean getHttpsRedirect() {
    return httpsRedirect;
  }

  /**
   * The path that will be used in the redirect response instead of the one that was supplied in the
   * request. Only one of pathRedirect or prefixRedirect must be specified. The value must be
   * between 1 and 1024 characters.
   */
  public String getPathRedirect() {
    return pathRedirect;
  }

  /**
   * The prefix that replaces the prefixMatch specified in the HttpRouteRuleMatch, retaining the
   * remaining portion of the URL before redirecting the request.
   */
  public String getPrefixRedirect() {
    return prefixRedirect;
  }

  /**
   * The HTTP Status code to use for this RedirectAction. Supported values are: -
   * MOVED_PERMANENTLY_DEFAULT, which is the default value and corresponds to 301. - FOUND, which
   * corresponds to 302. - SEE_OTHER which corresponds to 303. - TEMPORARY_REDIRECT, which
   * corresponds to 307. In this case, the request method will be retained. - PERMANENT_REDIRECT,
   * which corresponds to 308. In this case, the request method will be retained.
   */
  public String getRedirectResponseCode() {
    return redirectResponseCode;
  }

  /**
   * If set to true, any accompanying query portion of the original URL is removed prior to
   * redirecting the request. If set to false, the query portion of the original URL is retained.
   * The default is set to false.
   */
  public Boolean getStripQuery() {
    return stripQuery;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HttpRedirectAction prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HttpRedirectAction getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HttpRedirectAction DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HttpRedirectAction();
  }

  public static class Builder {
    private String hostRedirect;
    private Boolean httpsRedirect;
    private String pathRedirect;
    private String prefixRedirect;
    private String redirectResponseCode;
    private Boolean stripQuery;

    Builder() {}

    public Builder mergeFrom(HttpRedirectAction other) {
      if (other == HttpRedirectAction.getDefaultInstance()) return this;
      if (other.getHostRedirect() != null) {
        this.hostRedirect = other.hostRedirect;
      }
      if (other.getHttpsRedirect() != null) {
        this.httpsRedirect = other.httpsRedirect;
      }
      if (other.getPathRedirect() != null) {
        this.pathRedirect = other.pathRedirect;
      }
      if (other.getPrefixRedirect() != null) {
        this.prefixRedirect = other.prefixRedirect;
      }
      if (other.getRedirectResponseCode() != null) {
        this.redirectResponseCode = other.redirectResponseCode;
      }
      if (other.getStripQuery() != null) {
        this.stripQuery = other.stripQuery;
      }
      return this;
    }

    Builder(HttpRedirectAction source) {
      this.hostRedirect = source.hostRedirect;
      this.httpsRedirect = source.httpsRedirect;
      this.pathRedirect = source.pathRedirect;
      this.prefixRedirect = source.prefixRedirect;
      this.redirectResponseCode = source.redirectResponseCode;
      this.stripQuery = source.stripQuery;
    }

    /**
     * The host that will be used in the redirect response instead of the one that was supplied in
     * the request. The value must be between 1 and 255 characters.
     */
    public String getHostRedirect() {
      return hostRedirect;
    }

    /**
     * The host that will be used in the redirect response instead of the one that was supplied in
     * the request. The value must be between 1 and 255 characters.
     */
    public Builder setHostRedirect(String hostRedirect) {
      this.hostRedirect = hostRedirect;
      return this;
    }

    /**
     * If set to true, the URL scheme in the redirected request is set to https. If set to false,
     * the URL scheme of the redirected request will remain the same as that of the request. This
     * must only be set for UrlMaps used in TargetHttpProxys. Setting this true for TargetHttpsProxy
     * is not permitted. The default is set to false.
     */
    public Boolean getHttpsRedirect() {
      return httpsRedirect;
    }

    /**
     * If set to true, the URL scheme in the redirected request is set to https. If set to false,
     * the URL scheme of the redirected request will remain the same as that of the request. This
     * must only be set for UrlMaps used in TargetHttpProxys. Setting this true for TargetHttpsProxy
     * is not permitted. The default is set to false.
     */
    public Builder setHttpsRedirect(Boolean httpsRedirect) {
      this.httpsRedirect = httpsRedirect;
      return this;
    }

    /**
     * The path that will be used in the redirect response instead of the one that was supplied in
     * the request. Only one of pathRedirect or prefixRedirect must be specified. The value must be
     * between 1 and 1024 characters.
     */
    public String getPathRedirect() {
      return pathRedirect;
    }

    /**
     * The path that will be used in the redirect response instead of the one that was supplied in
     * the request. Only one of pathRedirect or prefixRedirect must be specified. The value must be
     * between 1 and 1024 characters.
     */
    public Builder setPathRedirect(String pathRedirect) {
      this.pathRedirect = pathRedirect;
      return this;
    }

    /**
     * The prefix that replaces the prefixMatch specified in the HttpRouteRuleMatch, retaining the
     * remaining portion of the URL before redirecting the request.
     */
    public String getPrefixRedirect() {
      return prefixRedirect;
    }

    /**
     * The prefix that replaces the prefixMatch specified in the HttpRouteRuleMatch, retaining the
     * remaining portion of the URL before redirecting the request.
     */
    public Builder setPrefixRedirect(String prefixRedirect) {
      this.prefixRedirect = prefixRedirect;
      return this;
    }

    /**
     * The HTTP Status code to use for this RedirectAction. Supported values are: -
     * MOVED_PERMANENTLY_DEFAULT, which is the default value and corresponds to 301. - FOUND, which
     * corresponds to 302. - SEE_OTHER which corresponds to 303. - TEMPORARY_REDIRECT, which
     * corresponds to 307. In this case, the request method will be retained. - PERMANENT_REDIRECT,
     * which corresponds to 308. In this case, the request method will be retained.
     */
    public String getRedirectResponseCode() {
      return redirectResponseCode;
    }

    /**
     * The HTTP Status code to use for this RedirectAction. Supported values are: -
     * MOVED_PERMANENTLY_DEFAULT, which is the default value and corresponds to 301. - FOUND, which
     * corresponds to 302. - SEE_OTHER which corresponds to 303. - TEMPORARY_REDIRECT, which
     * corresponds to 307. In this case, the request method will be retained. - PERMANENT_REDIRECT,
     * which corresponds to 308. In this case, the request method will be retained.
     */
    public Builder setRedirectResponseCode(String redirectResponseCode) {
      this.redirectResponseCode = redirectResponseCode;
      return this;
    }

    /**
     * If set to true, any accompanying query portion of the original URL is removed prior to
     * redirecting the request. If set to false, the query portion of the original URL is retained.
     * The default is set to false.
     */
    public Boolean getStripQuery() {
      return stripQuery;
    }

    /**
     * If set to true, any accompanying query portion of the original URL is removed prior to
     * redirecting the request. If set to false, the query portion of the original URL is retained.
     * The default is set to false.
     */
    public Builder setStripQuery(Boolean stripQuery) {
      this.stripQuery = stripQuery;
      return this;
    }

    public HttpRedirectAction build() {

      return new HttpRedirectAction(
          hostRedirect,
          httpsRedirect,
          pathRedirect,
          prefixRedirect,
          redirectResponseCode,
          stripQuery);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setHostRedirect(this.hostRedirect);
      newBuilder.setHttpsRedirect(this.httpsRedirect);
      newBuilder.setPathRedirect(this.pathRedirect);
      newBuilder.setPrefixRedirect(this.prefixRedirect);
      newBuilder.setRedirectResponseCode(this.redirectResponseCode);
      newBuilder.setStripQuery(this.stripQuery);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HttpRedirectAction{"
        + "hostRedirect="
        + hostRedirect
        + ", "
        + "httpsRedirect="
        + httpsRedirect
        + ", "
        + "pathRedirect="
        + pathRedirect
        + ", "
        + "prefixRedirect="
        + prefixRedirect
        + ", "
        + "redirectResponseCode="
        + redirectResponseCode
        + ", "
        + "stripQuery="
        + stripQuery
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HttpRedirectAction) {
      HttpRedirectAction that = (HttpRedirectAction) o;
      return Objects.equals(this.hostRedirect, that.getHostRedirect())
          && Objects.equals(this.httpsRedirect, that.getHttpsRedirect())
          && Objects.equals(this.pathRedirect, that.getPathRedirect())
          && Objects.equals(this.prefixRedirect, that.getPrefixRedirect())
          && Objects.equals(this.redirectResponseCode, that.getRedirectResponseCode())
          && Objects.equals(this.stripQuery, that.getStripQuery());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        hostRedirect,
        httpsRedirect,
        pathRedirect,
        prefixRedirect,
        redirectResponseCode,
        stripQuery);
  }
}
