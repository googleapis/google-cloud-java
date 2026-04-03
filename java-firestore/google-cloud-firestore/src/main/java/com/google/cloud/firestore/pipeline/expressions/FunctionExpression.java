/*
 * Copyright 2024 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.firestore.v1.Value;
import java.util.List;
import java.util.stream.Collectors;

@BetaApi
public class FunctionExpression extends Expression {
  private final String name;
  private final List<Expression> params;
  private final java.util.Map<String, Value> options;

  public FunctionExpression(String name, List<? extends Expression> params) {
    this(name, params, java.util.Collections.emptyMap());
  }

  @InternalApi
  FunctionExpression(
      String name, List<? extends Expression> params, java.util.Map<String, Value> options) {
    this.name = name;
    this.params = java.util.Collections.unmodifiableList(params);
    this.options = java.util.Collections.unmodifiableMap(options);
  }

  @InternalApi
  @Override
  Value toProto() {
    return Value.newBuilder()
        .setFunctionValue(
            com.google.firestore.v1.Function.newBuilder()
                .setName(this.name)
                .addAllArgs(
                    this.params.stream()
                        .map(FunctionUtils::exprToValue)
                        .collect(Collectors.toList()))
                .putAllOptions(this.options))
        .build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FunctionExpression that = (FunctionExpression) o;
    return java.util.Objects.equals(name, that.name)
        && java.util.Objects.equals(params, that.params)
        && java.util.Objects.equals(options, that.options);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(name, params, options);
  }
}
