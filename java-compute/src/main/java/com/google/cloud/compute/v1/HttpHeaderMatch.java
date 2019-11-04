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
/** matchRule criteria for request header matches. */
public final class HttpHeaderMatch implements ApiMessage {
  private final String exactMatch;
  private final String headerName;
  private final Boolean invertMatch;
  private final String prefixMatch;
  private final Boolean presentMatch;
  private final Int64RangeMatch rangeMatch;
  private final String regexMatch;
  private final String suffixMatch;

  private HttpHeaderMatch() {
    this.exactMatch = null;
    this.headerName = null;
    this.invertMatch = null;
    this.prefixMatch = null;
    this.presentMatch = null;
    this.rangeMatch = null;
    this.regexMatch = null;
    this.suffixMatch = null;
  }

  private HttpHeaderMatch(
      String exactMatch,
      String headerName,
      Boolean invertMatch,
      String prefixMatch,
      Boolean presentMatch,
      Int64RangeMatch rangeMatch,
      String regexMatch,
      String suffixMatch) {
    this.exactMatch = exactMatch;
    this.headerName = headerName;
    this.invertMatch = invertMatch;
    this.prefixMatch = prefixMatch;
    this.presentMatch = presentMatch;
    this.rangeMatch = rangeMatch;
    this.regexMatch = regexMatch;
    this.suffixMatch = suffixMatch;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("exactMatch".equals(fieldName)) {
      return exactMatch;
    }
    if ("headerName".equals(fieldName)) {
      return headerName;
    }
    if ("invertMatch".equals(fieldName)) {
      return invertMatch;
    }
    if ("prefixMatch".equals(fieldName)) {
      return prefixMatch;
    }
    if ("presentMatch".equals(fieldName)) {
      return presentMatch;
    }
    if ("rangeMatch".equals(fieldName)) {
      return rangeMatch;
    }
    if ("regexMatch".equals(fieldName)) {
      return regexMatch;
    }
    if ("suffixMatch".equals(fieldName)) {
      return suffixMatch;
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
   * The value should exactly match contents of exactMatch. Only one of exactMatch, prefixMatch,
   * suffixMatch, regexMatch, presentMatch or rangeMatch must be set.
   */
  public String getExactMatch() {
    return exactMatch;
  }

  /**
   * The name of the HTTP header to match. For matching against the HTTP request's authority, use a
   * headerMatch with the header name ":authority". For matching a request's method, use the
   * headerName ":method".
   */
  public String getHeaderName() {
    return headerName;
  }

  /**
   * If set to false, the headerMatch is considered a match if the match criteria above are met. If
   * set to true, the headerMatch is considered a match if the match criteria above are NOT met. The
   * default setting is false.
   */
  public Boolean getInvertMatch() {
    return invertMatch;
  }

  /**
   * The value of the header must start with the contents of prefixMatch. Only one of exactMatch,
   * prefixMatch, suffixMatch, regexMatch, presentMatch or rangeMatch must be set.
   */
  public String getPrefixMatch() {
    return prefixMatch;
  }

  /**
   * A header with the contents of headerName must exist. The match takes place whether or not the
   * request's header has a value or not. Only one of exactMatch, prefixMatch, suffixMatch,
   * regexMatch, presentMatch or rangeMatch must be set.
   */
  public Boolean getPresentMatch() {
    return presentMatch;
  }

  /**
   * The header value must be an integer and its value must be in the range specified in rangeMatch.
   * If the header does not contain an integer, number or is empty, the match fails. For example for
   * a range [-5, 0] - -3 will match. - 0 will not match. - 0.25 will not match. - -3someString will
   * not match. Only one of exactMatch, prefixMatch, suffixMatch, regexMatch, presentMatch or
   * rangeMatch must be set.
   */
  public Int64RangeMatch getRangeMatch() {
    return rangeMatch;
  }

  /**
   * The value of the header must match the regualar expression specified in regexMatch. For regular
   * expression grammar, please see: en.cppreference.com/w/cpp/regex/ecmascript For matching against
   * a port specified in the HTTP request, use a headerMatch with headerName set to PORT and a
   * regular expression that satisfies the RFC2616 Host header's port specifier. Only one of
   * exactMatch, prefixMatch, suffixMatch, regexMatch, presentMatch or rangeMatch must be set.
   */
  public String getRegexMatch() {
    return regexMatch;
  }

  /**
   * The value of the header must end with the contents of suffixMatch. Only one of exactMatch,
   * prefixMatch, suffixMatch, regexMatch, presentMatch or rangeMatch must be set.
   */
  public String getSuffixMatch() {
    return suffixMatch;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HttpHeaderMatch prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HttpHeaderMatch getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HttpHeaderMatch DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HttpHeaderMatch();
  }

  public static class Builder {
    private String exactMatch;
    private String headerName;
    private Boolean invertMatch;
    private String prefixMatch;
    private Boolean presentMatch;
    private Int64RangeMatch rangeMatch;
    private String regexMatch;
    private String suffixMatch;

    Builder() {}

    public Builder mergeFrom(HttpHeaderMatch other) {
      if (other == HttpHeaderMatch.getDefaultInstance()) return this;
      if (other.getExactMatch() != null) {
        this.exactMatch = other.exactMatch;
      }
      if (other.getHeaderName() != null) {
        this.headerName = other.headerName;
      }
      if (other.getInvertMatch() != null) {
        this.invertMatch = other.invertMatch;
      }
      if (other.getPrefixMatch() != null) {
        this.prefixMatch = other.prefixMatch;
      }
      if (other.getPresentMatch() != null) {
        this.presentMatch = other.presentMatch;
      }
      if (other.getRangeMatch() != null) {
        this.rangeMatch = other.rangeMatch;
      }
      if (other.getRegexMatch() != null) {
        this.regexMatch = other.regexMatch;
      }
      if (other.getSuffixMatch() != null) {
        this.suffixMatch = other.suffixMatch;
      }
      return this;
    }

    Builder(HttpHeaderMatch source) {
      this.exactMatch = source.exactMatch;
      this.headerName = source.headerName;
      this.invertMatch = source.invertMatch;
      this.prefixMatch = source.prefixMatch;
      this.presentMatch = source.presentMatch;
      this.rangeMatch = source.rangeMatch;
      this.regexMatch = source.regexMatch;
      this.suffixMatch = source.suffixMatch;
    }

    /**
     * The value should exactly match contents of exactMatch. Only one of exactMatch, prefixMatch,
     * suffixMatch, regexMatch, presentMatch or rangeMatch must be set.
     */
    public String getExactMatch() {
      return exactMatch;
    }

    /**
     * The value should exactly match contents of exactMatch. Only one of exactMatch, prefixMatch,
     * suffixMatch, regexMatch, presentMatch or rangeMatch must be set.
     */
    public Builder setExactMatch(String exactMatch) {
      this.exactMatch = exactMatch;
      return this;
    }

    /**
     * The name of the HTTP header to match. For matching against the HTTP request's authority, use
     * a headerMatch with the header name ":authority". For matching a request's method, use the
     * headerName ":method".
     */
    public String getHeaderName() {
      return headerName;
    }

    /**
     * The name of the HTTP header to match. For matching against the HTTP request's authority, use
     * a headerMatch with the header name ":authority". For matching a request's method, use the
     * headerName ":method".
     */
    public Builder setHeaderName(String headerName) {
      this.headerName = headerName;
      return this;
    }

    /**
     * If set to false, the headerMatch is considered a match if the match criteria above are met.
     * If set to true, the headerMatch is considered a match if the match criteria above are NOT
     * met. The default setting is false.
     */
    public Boolean getInvertMatch() {
      return invertMatch;
    }

    /**
     * If set to false, the headerMatch is considered a match if the match criteria above are met.
     * If set to true, the headerMatch is considered a match if the match criteria above are NOT
     * met. The default setting is false.
     */
    public Builder setInvertMatch(Boolean invertMatch) {
      this.invertMatch = invertMatch;
      return this;
    }

    /**
     * The value of the header must start with the contents of prefixMatch. Only one of exactMatch,
     * prefixMatch, suffixMatch, regexMatch, presentMatch or rangeMatch must be set.
     */
    public String getPrefixMatch() {
      return prefixMatch;
    }

    /**
     * The value of the header must start with the contents of prefixMatch. Only one of exactMatch,
     * prefixMatch, suffixMatch, regexMatch, presentMatch or rangeMatch must be set.
     */
    public Builder setPrefixMatch(String prefixMatch) {
      this.prefixMatch = prefixMatch;
      return this;
    }

    /**
     * A header with the contents of headerName must exist. The match takes place whether or not the
     * request's header has a value or not. Only one of exactMatch, prefixMatch, suffixMatch,
     * regexMatch, presentMatch or rangeMatch must be set.
     */
    public Boolean getPresentMatch() {
      return presentMatch;
    }

    /**
     * A header with the contents of headerName must exist. The match takes place whether or not the
     * request's header has a value or not. Only one of exactMatch, prefixMatch, suffixMatch,
     * regexMatch, presentMatch or rangeMatch must be set.
     */
    public Builder setPresentMatch(Boolean presentMatch) {
      this.presentMatch = presentMatch;
      return this;
    }

    /**
     * The header value must be an integer and its value must be in the range specified in
     * rangeMatch. If the header does not contain an integer, number or is empty, the match fails.
     * For example for a range [-5, 0] - -3 will match. - 0 will not match. - 0.25 will not match. -
     * -3someString will not match. Only one of exactMatch, prefixMatch, suffixMatch, regexMatch,
     * presentMatch or rangeMatch must be set.
     */
    public Int64RangeMatch getRangeMatch() {
      return rangeMatch;
    }

    /**
     * The header value must be an integer and its value must be in the range specified in
     * rangeMatch. If the header does not contain an integer, number or is empty, the match fails.
     * For example for a range [-5, 0] - -3 will match. - 0 will not match. - 0.25 will not match. -
     * -3someString will not match. Only one of exactMatch, prefixMatch, suffixMatch, regexMatch,
     * presentMatch or rangeMatch must be set.
     */
    public Builder setRangeMatch(Int64RangeMatch rangeMatch) {
      this.rangeMatch = rangeMatch;
      return this;
    }

    /**
     * The value of the header must match the regualar expression specified in regexMatch. For
     * regular expression grammar, please see: en.cppreference.com/w/cpp/regex/ecmascript For
     * matching against a port specified in the HTTP request, use a headerMatch with headerName set
     * to PORT and a regular expression that satisfies the RFC2616 Host header's port specifier.
     * Only one of exactMatch, prefixMatch, suffixMatch, regexMatch, presentMatch or rangeMatch must
     * be set.
     */
    public String getRegexMatch() {
      return regexMatch;
    }

    /**
     * The value of the header must match the regualar expression specified in regexMatch. For
     * regular expression grammar, please see: en.cppreference.com/w/cpp/regex/ecmascript For
     * matching against a port specified in the HTTP request, use a headerMatch with headerName set
     * to PORT and a regular expression that satisfies the RFC2616 Host header's port specifier.
     * Only one of exactMatch, prefixMatch, suffixMatch, regexMatch, presentMatch or rangeMatch must
     * be set.
     */
    public Builder setRegexMatch(String regexMatch) {
      this.regexMatch = regexMatch;
      return this;
    }

    /**
     * The value of the header must end with the contents of suffixMatch. Only one of exactMatch,
     * prefixMatch, suffixMatch, regexMatch, presentMatch or rangeMatch must be set.
     */
    public String getSuffixMatch() {
      return suffixMatch;
    }

    /**
     * The value of the header must end with the contents of suffixMatch. Only one of exactMatch,
     * prefixMatch, suffixMatch, regexMatch, presentMatch or rangeMatch must be set.
     */
    public Builder setSuffixMatch(String suffixMatch) {
      this.suffixMatch = suffixMatch;
      return this;
    }

    public HttpHeaderMatch build() {

      return new HttpHeaderMatch(
          exactMatch,
          headerName,
          invertMatch,
          prefixMatch,
          presentMatch,
          rangeMatch,
          regexMatch,
          suffixMatch);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setExactMatch(this.exactMatch);
      newBuilder.setHeaderName(this.headerName);
      newBuilder.setInvertMatch(this.invertMatch);
      newBuilder.setPrefixMatch(this.prefixMatch);
      newBuilder.setPresentMatch(this.presentMatch);
      newBuilder.setRangeMatch(this.rangeMatch);
      newBuilder.setRegexMatch(this.regexMatch);
      newBuilder.setSuffixMatch(this.suffixMatch);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HttpHeaderMatch{"
        + "exactMatch="
        + exactMatch
        + ", "
        + "headerName="
        + headerName
        + ", "
        + "invertMatch="
        + invertMatch
        + ", "
        + "prefixMatch="
        + prefixMatch
        + ", "
        + "presentMatch="
        + presentMatch
        + ", "
        + "rangeMatch="
        + rangeMatch
        + ", "
        + "regexMatch="
        + regexMatch
        + ", "
        + "suffixMatch="
        + suffixMatch
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HttpHeaderMatch) {
      HttpHeaderMatch that = (HttpHeaderMatch) o;
      return Objects.equals(this.exactMatch, that.getExactMatch())
          && Objects.equals(this.headerName, that.getHeaderName())
          && Objects.equals(this.invertMatch, that.getInvertMatch())
          && Objects.equals(this.prefixMatch, that.getPrefixMatch())
          && Objects.equals(this.presentMatch, that.getPresentMatch())
          && Objects.equals(this.rangeMatch, that.getRangeMatch())
          && Objects.equals(this.regexMatch, that.getRegexMatch())
          && Objects.equals(this.suffixMatch, that.getSuffixMatch());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        exactMatch,
        headerName,
        invertMatch,
        prefixMatch,
        presentMatch,
        rangeMatch,
        regexMatch,
        suffixMatch);
  }
}
