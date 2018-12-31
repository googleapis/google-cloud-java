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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class Expr implements ApiMessage {
  private final String description;
  private final String expression;
  private final String location;
  private final String title;

  private Expr() {
    this.description = null;
    this.expression = null;
    this.location = null;
    this.title = null;
  }

  private Expr(String description, String expression, String location, String title) {
    this.description = description;
    this.expression = expression;
    this.location = location;
    this.title = title;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("expression")) {
      return expression;
    }
    if (fieldName.equals("location")) {
      return location;
    }
    if (fieldName.equals("title")) {
      return title;
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

  public String getDescription() {
    return description;
  }

  public String getExpression() {
    return expression;
  }

  public String getLocation() {
    return location;
  }

  public String getTitle() {
    return title;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Expr prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Expr getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Expr DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Expr();
  }

  public static class Builder {
    private String description;
    private String expression;
    private String location;
    private String title;

    Builder() {}

    public Builder mergeFrom(Expr other) {
      if (other == Expr.getDefaultInstance()) return this;
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getExpression() != null) {
        this.expression = other.expression;
      }
      if (other.getLocation() != null) {
        this.location = other.location;
      }
      if (other.getTitle() != null) {
        this.title = other.title;
      }
      return this;
    }

    Builder(Expr source) {
      this.description = source.description;
      this.expression = source.expression;
      this.location = source.location;
      this.title = source.title;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public String getExpression() {
      return expression;
    }

    public Builder setExpression(String expression) {
      this.expression = expression;
      return this;
    }

    public String getLocation() {
      return location;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public String getTitle() {
      return title;
    }

    public Builder setTitle(String title) {
      this.title = title;
      return this;
    }

    public Expr build() {

      return new Expr(description, expression, location, title);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDescription(this.description);
      newBuilder.setExpression(this.expression);
      newBuilder.setLocation(this.location);
      newBuilder.setTitle(this.title);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Expr{"
        + "description="
        + description
        + ", "
        + "expression="
        + expression
        + ", "
        + "location="
        + location
        + ", "
        + "title="
        + title
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Expr) {
      Expr that = (Expr) o;
      return Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.expression, that.getExpression())
          && Objects.equals(this.location, that.getLocation())
          && Objects.equals(this.title, that.getTitle());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, expression, location, title);
  }
}
