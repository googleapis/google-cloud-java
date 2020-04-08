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
public final class WafExpressionSetExpression implements ApiMessage {
  private final String id;

  private WafExpressionSetExpression() {
    this.id = null;
  }

  private WafExpressionSetExpression(String id) {
    this.id = id;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("id".equals(fieldName)) {
      return id;
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
   * Expression ID should uniquely identify the origin of the expression. E.g.
   * owasp-crs-v020901-id973337 identifies Owasp core rule set version 2.9.1 rule id 973337. The ID
   * could be used to determine the individual attack definition that has been detected. It could
   * also be used to exclude it from the policy in case of false positive.
   */
  public String getId() {
    return id;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(WafExpressionSetExpression prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static WafExpressionSetExpression getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final WafExpressionSetExpression DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new WafExpressionSetExpression();
  }

  public static class Builder {
    private String id;

    Builder() {}

    public Builder mergeFrom(WafExpressionSetExpression other) {
      if (other == WafExpressionSetExpression.getDefaultInstance()) return this;
      if (other.getId() != null) {
        this.id = other.id;
      }
      return this;
    }

    Builder(WafExpressionSetExpression source) {
      this.id = source.id;
    }

    /**
     * Expression ID should uniquely identify the origin of the expression. E.g.
     * owasp-crs-v020901-id973337 identifies Owasp core rule set version 2.9.1 rule id 973337. The
     * ID could be used to determine the individual attack definition that has been detected. It
     * could also be used to exclude it from the policy in case of false positive.
     */
    public String getId() {
      return id;
    }

    /**
     * Expression ID should uniquely identify the origin of the expression. E.g.
     * owasp-crs-v020901-id973337 identifies Owasp core rule set version 2.9.1 rule id 973337. The
     * ID could be used to determine the individual attack definition that has been detected. It
     * could also be used to exclude it from the policy in case of false positive.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public WafExpressionSetExpression build() {
      return new WafExpressionSetExpression(id);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setId(this.id);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "WafExpressionSetExpression{" + "id=" + id + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof WafExpressionSetExpression) {
      WafExpressionSetExpression that = (WafExpressionSetExpression) o;
      return Objects.equals(this.id, that.getId());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
