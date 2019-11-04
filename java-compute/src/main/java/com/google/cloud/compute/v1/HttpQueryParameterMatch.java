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
/** HttpRouteRuleMatch criteria for a request's query parameter. */
public final class HttpQueryParameterMatch implements ApiMessage {
  private final String exactMatch;
  private final String name;
  private final Boolean presentMatch;
  private final String regexMatch;

  private HttpQueryParameterMatch() {
    this.exactMatch = null;
    this.name = null;
    this.presentMatch = null;
    this.regexMatch = null;
  }

  private HttpQueryParameterMatch(
      String exactMatch, String name, Boolean presentMatch, String regexMatch) {
    this.exactMatch = exactMatch;
    this.name = name;
    this.presentMatch = presentMatch;
    this.regexMatch = regexMatch;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("exactMatch".equals(fieldName)) {
      return exactMatch;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("presentMatch".equals(fieldName)) {
      return presentMatch;
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
   * The queryParameterMatch matches if the value of the parameter exactly matches the contents of
   * exactMatch. Only one of presentMatch, exactMatch and regexMatch must be set.
   */
  public String getExactMatch() {
    return exactMatch;
  }

  /**
   * The name of the query parameter to match. The query parameter must exist in the request, in the
   * absence of which the request match fails.
   */
  public String getName() {
    return name;
  }

  /**
   * Specifies that the queryParameterMatch matches if the request contains the query parameter,
   * irrespective of whether the parameter has a value or not. Only one of presentMatch, exactMatch
   * and regexMatch must be set.
   */
  public Boolean getPresentMatch() {
    return presentMatch;
  }

  /**
   * The queryParameterMatch matches if the value of the parameter matches the regular expression
   * specified by regexMatch. For the regular expression grammar, please see
   * en.cppreference.com/w/cpp/regex/ecmascript Only one of presentMatch, exactMatch and regexMatch
   * must be set.
   */
  public String getRegexMatch() {
    return regexMatch;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HttpQueryParameterMatch prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HttpQueryParameterMatch getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HttpQueryParameterMatch DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HttpQueryParameterMatch();
  }

  public static class Builder {
    private String exactMatch;
    private String name;
    private Boolean presentMatch;
    private String regexMatch;

    Builder() {}

    public Builder mergeFrom(HttpQueryParameterMatch other) {
      if (other == HttpQueryParameterMatch.getDefaultInstance()) return this;
      if (other.getExactMatch() != null) {
        this.exactMatch = other.exactMatch;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getPresentMatch() != null) {
        this.presentMatch = other.presentMatch;
      }
      if (other.getRegexMatch() != null) {
        this.regexMatch = other.regexMatch;
      }
      return this;
    }

    Builder(HttpQueryParameterMatch source) {
      this.exactMatch = source.exactMatch;
      this.name = source.name;
      this.presentMatch = source.presentMatch;
      this.regexMatch = source.regexMatch;
    }

    /**
     * The queryParameterMatch matches if the value of the parameter exactly matches the contents of
     * exactMatch. Only one of presentMatch, exactMatch and regexMatch must be set.
     */
    public String getExactMatch() {
      return exactMatch;
    }

    /**
     * The queryParameterMatch matches if the value of the parameter exactly matches the contents of
     * exactMatch. Only one of presentMatch, exactMatch and regexMatch must be set.
     */
    public Builder setExactMatch(String exactMatch) {
      this.exactMatch = exactMatch;
      return this;
    }

    /**
     * The name of the query parameter to match. The query parameter must exist in the request, in
     * the absence of which the request match fails.
     */
    public String getName() {
      return name;
    }

    /**
     * The name of the query parameter to match. The query parameter must exist in the request, in
     * the absence of which the request match fails.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * Specifies that the queryParameterMatch matches if the request contains the query parameter,
     * irrespective of whether the parameter has a value or not. Only one of presentMatch,
     * exactMatch and regexMatch must be set.
     */
    public Boolean getPresentMatch() {
      return presentMatch;
    }

    /**
     * Specifies that the queryParameterMatch matches if the request contains the query parameter,
     * irrespective of whether the parameter has a value or not. Only one of presentMatch,
     * exactMatch and regexMatch must be set.
     */
    public Builder setPresentMatch(Boolean presentMatch) {
      this.presentMatch = presentMatch;
      return this;
    }

    /**
     * The queryParameterMatch matches if the value of the parameter matches the regular expression
     * specified by regexMatch. For the regular expression grammar, please see
     * en.cppreference.com/w/cpp/regex/ecmascript Only one of presentMatch, exactMatch and
     * regexMatch must be set.
     */
    public String getRegexMatch() {
      return regexMatch;
    }

    /**
     * The queryParameterMatch matches if the value of the parameter matches the regular expression
     * specified by regexMatch. For the regular expression grammar, please see
     * en.cppreference.com/w/cpp/regex/ecmascript Only one of presentMatch, exactMatch and
     * regexMatch must be set.
     */
    public Builder setRegexMatch(String regexMatch) {
      this.regexMatch = regexMatch;
      return this;
    }

    public HttpQueryParameterMatch build() {

      return new HttpQueryParameterMatch(exactMatch, name, presentMatch, regexMatch);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setExactMatch(this.exactMatch);
      newBuilder.setName(this.name);
      newBuilder.setPresentMatch(this.presentMatch);
      newBuilder.setRegexMatch(this.regexMatch);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HttpQueryParameterMatch{"
        + "exactMatch="
        + exactMatch
        + ", "
        + "name="
        + name
        + ", "
        + "presentMatch="
        + presentMatch
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
    if (o instanceof HttpQueryParameterMatch) {
      HttpQueryParameterMatch that = (HttpQueryParameterMatch) o;
      return Objects.equals(this.exactMatch, that.getExactMatch())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.presentMatch, that.getPresentMatch())
          && Objects.equals(this.regexMatch, that.getRegexMatch());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(exactMatch, name, presentMatch, regexMatch);
  }
}
