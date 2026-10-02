/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.firestore.pipeline.expressions;

import com.google.api.core.InternalApi;
import com.google.firestore.v1.Value;
import java.util.Objects;

public final class AliasedWindowFunction {
  private final String alias;
  private final WindowFunction expr;

  AliasedWindowFunction(String alias, WindowFunction expr) {
    this.alias = alias;
    this.expr = expr;
  }

  @InternalApi
  public String getAlias() {
    return alias;
  }

  @InternalApi
  public WindowFunction getExpr() {
    return expr;
  }

  @InternalApi
  public Value toProto() {
    return expr.toProto();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof AliasedWindowFunction)) {
      return false;
    }
    AliasedWindowFunction that = (AliasedWindowFunction) other;
    if (!Objects.equals(alias, that.alias)) {
      return false;
    }
    if (!Objects.equals(expr, that.expr)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = alias.hashCode();
    result = 31 * result + expr.hashCode();
    return result;
  }

  @InternalApi
  public static AliasedWindowFunction toAliasedWindowFunction(Object o) {
    if (o instanceof AliasedWindowFunction) {
      return (AliasedWindowFunction) o;
    } else if (o instanceof AliasedAggregate) {
      AliasedAggregate agg = (AliasedAggregate) o;
      return new AliasedWindowFunction(
          agg.getAlias(), WindowFunction.fromAggregate(agg.getExpr(), null));
    } else {
      throw new IllegalArgumentException("Unsupported window function type: " + o);
    }
  }
}
