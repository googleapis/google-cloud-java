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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class WafExpressionSet implements ApiMessage {
  private final List<String> aliases;
  private final List<WafExpressionSetExpression> expressions;
  private final String id;

  private WafExpressionSet() {
    this.aliases = null;
    this.expressions = null;
    this.id = null;
  }

  private WafExpressionSet(
      List<String> aliases, List<WafExpressionSetExpression> expressions, String id) {
    this.aliases = aliases;
    this.expressions = expressions;
    this.id = id;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("aliases".equals(fieldName)) {
      return aliases;
    }
    if ("expressions".equals(fieldName)) {
      return expressions;
    }
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
   * A list of alternate IDs. The format should be: - E.g. XSS-stable Generic suffix like "stable"
   * is particularly useful if a policy likes to avail newer set of expressions without having to
   * change the policy. A given alias name can't be used for more than one entity set.
   */
  public List<String> getAliasesList() {
    return aliases;
  }

  /** List of available expressions. */
  public List<WafExpressionSetExpression> getExpressionsList() {
    return expressions;
  }

  /** Google specified expression set ID. The format should be: - E.g. XSS-20170329 */
  public String getId() {
    return id;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(WafExpressionSet prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static WafExpressionSet getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final WafExpressionSet DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new WafExpressionSet();
  }

  public static class Builder {
    private List<String> aliases;
    private List<WafExpressionSetExpression> expressions;
    private String id;

    Builder() {}

    public Builder mergeFrom(WafExpressionSet other) {
      if (other == WafExpressionSet.getDefaultInstance()) return this;
      if (other.getAliasesList() != null) {
        this.aliases = other.aliases;
      }
      if (other.getExpressionsList() != null) {
        this.expressions = other.expressions;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      return this;
    }

    Builder(WafExpressionSet source) {
      this.aliases = source.aliases;
      this.expressions = source.expressions;
      this.id = source.id;
    }

    /**
     * A list of alternate IDs. The format should be: - E.g. XSS-stable Generic suffix like "stable"
     * is particularly useful if a policy likes to avail newer set of expressions without having to
     * change the policy. A given alias name can't be used for more than one entity set.
     */
    public List<String> getAliasesList() {
      return aliases;
    }

    /**
     * A list of alternate IDs. The format should be: - E.g. XSS-stable Generic suffix like "stable"
     * is particularly useful if a policy likes to avail newer set of expressions without having to
     * change the policy. A given alias name can't be used for more than one entity set.
     */
    public Builder addAllAliases(List<String> aliases) {
      if (this.aliases == null) {
        this.aliases = new LinkedList<>();
      }
      this.aliases.addAll(aliases);
      return this;
    }

    /**
     * A list of alternate IDs. The format should be: - E.g. XSS-stable Generic suffix like "stable"
     * is particularly useful if a policy likes to avail newer set of expressions without having to
     * change the policy. A given alias name can't be used for more than one entity set.
     */
    public Builder addAliases(String aliases) {
      if (this.aliases == null) {
        this.aliases = new LinkedList<>();
      }
      this.aliases.add(aliases);
      return this;
    }

    /** List of available expressions. */
    public List<WafExpressionSetExpression> getExpressionsList() {
      return expressions;
    }

    /** List of available expressions. */
    public Builder addAllExpressions(List<WafExpressionSetExpression> expressions) {
      if (this.expressions == null) {
        this.expressions = new LinkedList<>();
      }
      this.expressions.addAll(expressions);
      return this;
    }

    /** List of available expressions. */
    public Builder addExpressions(WafExpressionSetExpression expressions) {
      if (this.expressions == null) {
        this.expressions = new LinkedList<>();
      }
      this.expressions.add(expressions);
      return this;
    }

    /** Google specified expression set ID. The format should be: - E.g. XSS-20170329 */
    public String getId() {
      return id;
    }

    /** Google specified expression set ID. The format should be: - E.g. XSS-20170329 */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public WafExpressionSet build() {

      return new WafExpressionSet(aliases, expressions, id);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllAliases(this.aliases);
      newBuilder.addAllExpressions(this.expressions);
      newBuilder.setId(this.id);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "WafExpressionSet{"
        + "aliases="
        + aliases
        + ", "
        + "expressions="
        + expressions
        + ", "
        + "id="
        + id
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof WafExpressionSet) {
      WafExpressionSet that = (WafExpressionSet) o;
      return Objects.equals(this.aliases, that.getAliasesList())
          && Objects.equals(this.expressions, that.getExpressionsList())
          && Objects.equals(this.id, that.getId());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(aliases, expressions, id);
  }
}
