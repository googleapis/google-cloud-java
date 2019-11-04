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
 * The specification for allowing client side cross-origin requests. Please see W3C Recommendation
 * for Cross Origin Resource Sharing
 */
public final class CorsPolicy implements ApiMessage {
  private final Boolean allowCredentials;
  private final List<String> allowHeaders;
  private final List<String> allowMethods;
  private final List<String> allowOriginRegexes;
  private final List<String> allowOrigins;
  private final Boolean disabled;
  private final List<String> exposeHeaders;
  private final Integer maxAge;

  private CorsPolicy() {
    this.allowCredentials = null;
    this.allowHeaders = null;
    this.allowMethods = null;
    this.allowOriginRegexes = null;
    this.allowOrigins = null;
    this.disabled = null;
    this.exposeHeaders = null;
    this.maxAge = null;
  }

  private CorsPolicy(
      Boolean allowCredentials,
      List<String> allowHeaders,
      List<String> allowMethods,
      List<String> allowOriginRegexes,
      List<String> allowOrigins,
      Boolean disabled,
      List<String> exposeHeaders,
      Integer maxAge) {
    this.allowCredentials = allowCredentials;
    this.allowHeaders = allowHeaders;
    this.allowMethods = allowMethods;
    this.allowOriginRegexes = allowOriginRegexes;
    this.allowOrigins = allowOrigins;
    this.disabled = disabled;
    this.exposeHeaders = exposeHeaders;
    this.maxAge = maxAge;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("allowCredentials".equals(fieldName)) {
      return allowCredentials;
    }
    if ("allowHeaders".equals(fieldName)) {
      return allowHeaders;
    }
    if ("allowMethods".equals(fieldName)) {
      return allowMethods;
    }
    if ("allowOriginRegexes".equals(fieldName)) {
      return allowOriginRegexes;
    }
    if ("allowOrigins".equals(fieldName)) {
      return allowOrigins;
    }
    if ("disabled".equals(fieldName)) {
      return disabled;
    }
    if ("exposeHeaders".equals(fieldName)) {
      return exposeHeaders;
    }
    if ("maxAge".equals(fieldName)) {
      return maxAge;
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
   * In response to a preflight request, setting this to true indicates that the actual request can
   * include user credentials. This translates to the Access-Control-Allow-Credentials header.
   * Default is false.
   */
  public Boolean getAllowCredentials() {
    return allowCredentials;
  }

  /** Specifies the content for the Access-Control-Allow-Headers header. */
  public List<String> getAllowHeadersList() {
    return allowHeaders;
  }

  /** Specifies the content for the Access-Control-Allow-Methods header. */
  public List<String> getAllowMethodsList() {
    return allowMethods;
  }

  /**
   * Specifies the regualar expression patterns that match allowed origins. For regular expression
   * grammar please see en.cppreference.com/w/cpp/regex/ecmascript An origin is allowed if it
   * matches either allow_origins or allow_origin_regex.
   */
  public List<String> getAllowOriginRegexesList() {
    return allowOriginRegexes;
  }

  /**
   * Specifies the list of origins that will be allowed to do CORS requests. An origin is allowed if
   * it matches either allow_origins or allow_origin_regex.
   */
  public List<String> getAllowOriginsList() {
    return allowOrigins;
  }

  /**
   * If true, specifies the CORS policy is disabled. The default value of false, which indicates
   * that the CORS policy is in effect.
   */
  public Boolean getDisabled() {
    return disabled;
  }

  /** Specifies the content for the Access-Control-Expose-Headers header. */
  public List<String> getExposeHeadersList() {
    return exposeHeaders;
  }

  /**
   * Specifies how long the results of a preflight request can be cached. This translates to the
   * content for the Access-Control-Max-Age header.
   */
  public Integer getMaxAge() {
    return maxAge;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(CorsPolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static CorsPolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final CorsPolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new CorsPolicy();
  }

  public static class Builder {
    private Boolean allowCredentials;
    private List<String> allowHeaders;
    private List<String> allowMethods;
    private List<String> allowOriginRegexes;
    private List<String> allowOrigins;
    private Boolean disabled;
    private List<String> exposeHeaders;
    private Integer maxAge;

    Builder() {}

    public Builder mergeFrom(CorsPolicy other) {
      if (other == CorsPolicy.getDefaultInstance()) return this;
      if (other.getAllowCredentials() != null) {
        this.allowCredentials = other.allowCredentials;
      }
      if (other.getAllowHeadersList() != null) {
        this.allowHeaders = other.allowHeaders;
      }
      if (other.getAllowMethodsList() != null) {
        this.allowMethods = other.allowMethods;
      }
      if (other.getAllowOriginRegexesList() != null) {
        this.allowOriginRegexes = other.allowOriginRegexes;
      }
      if (other.getAllowOriginsList() != null) {
        this.allowOrigins = other.allowOrigins;
      }
      if (other.getDisabled() != null) {
        this.disabled = other.disabled;
      }
      if (other.getExposeHeadersList() != null) {
        this.exposeHeaders = other.exposeHeaders;
      }
      if (other.getMaxAge() != null) {
        this.maxAge = other.maxAge;
      }
      return this;
    }

    Builder(CorsPolicy source) {
      this.allowCredentials = source.allowCredentials;
      this.allowHeaders = source.allowHeaders;
      this.allowMethods = source.allowMethods;
      this.allowOriginRegexes = source.allowOriginRegexes;
      this.allowOrigins = source.allowOrigins;
      this.disabled = source.disabled;
      this.exposeHeaders = source.exposeHeaders;
      this.maxAge = source.maxAge;
    }

    /**
     * In response to a preflight request, setting this to true indicates that the actual request
     * can include user credentials. This translates to the Access-Control-Allow-Credentials header.
     * Default is false.
     */
    public Boolean getAllowCredentials() {
      return allowCredentials;
    }

    /**
     * In response to a preflight request, setting this to true indicates that the actual request
     * can include user credentials. This translates to the Access-Control-Allow-Credentials header.
     * Default is false.
     */
    public Builder setAllowCredentials(Boolean allowCredentials) {
      this.allowCredentials = allowCredentials;
      return this;
    }

    /** Specifies the content for the Access-Control-Allow-Headers header. */
    public List<String> getAllowHeadersList() {
      return allowHeaders;
    }

    /** Specifies the content for the Access-Control-Allow-Headers header. */
    public Builder addAllAllowHeaders(List<String> allowHeaders) {
      if (this.allowHeaders == null) {
        this.allowHeaders = new LinkedList<>();
      }
      this.allowHeaders.addAll(allowHeaders);
      return this;
    }

    /** Specifies the content for the Access-Control-Allow-Headers header. */
    public Builder addAllowHeaders(String allowHeaders) {
      if (this.allowHeaders == null) {
        this.allowHeaders = new LinkedList<>();
      }
      this.allowHeaders.add(allowHeaders);
      return this;
    }

    /** Specifies the content for the Access-Control-Allow-Methods header. */
    public List<String> getAllowMethodsList() {
      return allowMethods;
    }

    /** Specifies the content for the Access-Control-Allow-Methods header. */
    public Builder addAllAllowMethods(List<String> allowMethods) {
      if (this.allowMethods == null) {
        this.allowMethods = new LinkedList<>();
      }
      this.allowMethods.addAll(allowMethods);
      return this;
    }

    /** Specifies the content for the Access-Control-Allow-Methods header. */
    public Builder addAllowMethods(String allowMethods) {
      if (this.allowMethods == null) {
        this.allowMethods = new LinkedList<>();
      }
      this.allowMethods.add(allowMethods);
      return this;
    }

    /**
     * Specifies the regualar expression patterns that match allowed origins. For regular expression
     * grammar please see en.cppreference.com/w/cpp/regex/ecmascript An origin is allowed if it
     * matches either allow_origins or allow_origin_regex.
     */
    public List<String> getAllowOriginRegexesList() {
      return allowOriginRegexes;
    }

    /**
     * Specifies the regualar expression patterns that match allowed origins. For regular expression
     * grammar please see en.cppreference.com/w/cpp/regex/ecmascript An origin is allowed if it
     * matches either allow_origins or allow_origin_regex.
     */
    public Builder addAllAllowOriginRegexes(List<String> allowOriginRegexes) {
      if (this.allowOriginRegexes == null) {
        this.allowOriginRegexes = new LinkedList<>();
      }
      this.allowOriginRegexes.addAll(allowOriginRegexes);
      return this;
    }

    /**
     * Specifies the regualar expression patterns that match allowed origins. For regular expression
     * grammar please see en.cppreference.com/w/cpp/regex/ecmascript An origin is allowed if it
     * matches either allow_origins or allow_origin_regex.
     */
    public Builder addAllowOriginRegexes(String allowOriginRegexes) {
      if (this.allowOriginRegexes == null) {
        this.allowOriginRegexes = new LinkedList<>();
      }
      this.allowOriginRegexes.add(allowOriginRegexes);
      return this;
    }

    /**
     * Specifies the list of origins that will be allowed to do CORS requests. An origin is allowed
     * if it matches either allow_origins or allow_origin_regex.
     */
    public List<String> getAllowOriginsList() {
      return allowOrigins;
    }

    /**
     * Specifies the list of origins that will be allowed to do CORS requests. An origin is allowed
     * if it matches either allow_origins or allow_origin_regex.
     */
    public Builder addAllAllowOrigins(List<String> allowOrigins) {
      if (this.allowOrigins == null) {
        this.allowOrigins = new LinkedList<>();
      }
      this.allowOrigins.addAll(allowOrigins);
      return this;
    }

    /**
     * Specifies the list of origins that will be allowed to do CORS requests. An origin is allowed
     * if it matches either allow_origins or allow_origin_regex.
     */
    public Builder addAllowOrigins(String allowOrigins) {
      if (this.allowOrigins == null) {
        this.allowOrigins = new LinkedList<>();
      }
      this.allowOrigins.add(allowOrigins);
      return this;
    }

    /**
     * If true, specifies the CORS policy is disabled. The default value of false, which indicates
     * that the CORS policy is in effect.
     */
    public Boolean getDisabled() {
      return disabled;
    }

    /**
     * If true, specifies the CORS policy is disabled. The default value of false, which indicates
     * that the CORS policy is in effect.
     */
    public Builder setDisabled(Boolean disabled) {
      this.disabled = disabled;
      return this;
    }

    /** Specifies the content for the Access-Control-Expose-Headers header. */
    public List<String> getExposeHeadersList() {
      return exposeHeaders;
    }

    /** Specifies the content for the Access-Control-Expose-Headers header. */
    public Builder addAllExposeHeaders(List<String> exposeHeaders) {
      if (this.exposeHeaders == null) {
        this.exposeHeaders = new LinkedList<>();
      }
      this.exposeHeaders.addAll(exposeHeaders);
      return this;
    }

    /** Specifies the content for the Access-Control-Expose-Headers header. */
    public Builder addExposeHeaders(String exposeHeaders) {
      if (this.exposeHeaders == null) {
        this.exposeHeaders = new LinkedList<>();
      }
      this.exposeHeaders.add(exposeHeaders);
      return this;
    }

    /**
     * Specifies how long the results of a preflight request can be cached. This translates to the
     * content for the Access-Control-Max-Age header.
     */
    public Integer getMaxAge() {
      return maxAge;
    }

    /**
     * Specifies how long the results of a preflight request can be cached. This translates to the
     * content for the Access-Control-Max-Age header.
     */
    public Builder setMaxAge(Integer maxAge) {
      this.maxAge = maxAge;
      return this;
    }

    public CorsPolicy build() {

      return new CorsPolicy(
          allowCredentials,
          allowHeaders,
          allowMethods,
          allowOriginRegexes,
          allowOrigins,
          disabled,
          exposeHeaders,
          maxAge);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAllowCredentials(this.allowCredentials);
      newBuilder.addAllAllowHeaders(this.allowHeaders);
      newBuilder.addAllAllowMethods(this.allowMethods);
      newBuilder.addAllAllowOriginRegexes(this.allowOriginRegexes);
      newBuilder.addAllAllowOrigins(this.allowOrigins);
      newBuilder.setDisabled(this.disabled);
      newBuilder.addAllExposeHeaders(this.exposeHeaders);
      newBuilder.setMaxAge(this.maxAge);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "CorsPolicy{"
        + "allowCredentials="
        + allowCredentials
        + ", "
        + "allowHeaders="
        + allowHeaders
        + ", "
        + "allowMethods="
        + allowMethods
        + ", "
        + "allowOriginRegexes="
        + allowOriginRegexes
        + ", "
        + "allowOrigins="
        + allowOrigins
        + ", "
        + "disabled="
        + disabled
        + ", "
        + "exposeHeaders="
        + exposeHeaders
        + ", "
        + "maxAge="
        + maxAge
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CorsPolicy) {
      CorsPolicy that = (CorsPolicy) o;
      return Objects.equals(this.allowCredentials, that.getAllowCredentials())
          && Objects.equals(this.allowHeaders, that.getAllowHeadersList())
          && Objects.equals(this.allowMethods, that.getAllowMethodsList())
          && Objects.equals(this.allowOriginRegexes, that.getAllowOriginRegexesList())
          && Objects.equals(this.allowOrigins, that.getAllowOriginsList())
          && Objects.equals(this.disabled, that.getDisabled())
          && Objects.equals(this.exposeHeaders, that.getExposeHeadersList())
          && Objects.equals(this.maxAge, that.getMaxAge());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        allowCredentials,
        allowHeaders,
        allowMethods,
        allowOriginRegexes,
        allowOrigins,
        disabled,
        exposeHeaders,
        maxAge);
  }
}
