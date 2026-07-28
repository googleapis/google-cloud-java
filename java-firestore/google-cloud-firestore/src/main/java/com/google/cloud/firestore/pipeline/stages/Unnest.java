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

package com.google.cloud.firestore.pipeline.stages;

import static com.google.cloud.firestore.PipelineUtils.encodeValue;
import static com.google.cloud.firestore.pipeline.expressions.Expression.field;

import com.google.cloud.firestore.pipeline.expressions.AliasedExpression;
import com.google.cloud.firestore.pipeline.expressions.Expression;
import com.google.cloud.firestore.pipeline.expressions.Field;
import com.google.cloud.firestore.pipeline.expressions.Selectable;
import com.google.common.collect.ImmutableList;
import com.google.firestore.v1.Value;
import javax.annotation.Nonnull;

public final class Unnest extends Stage {

  private final Expression expr;
  private final Field alias;

  public Unnest(@Nonnull Field field, @Nonnull String alias) {
    super("unnest", InternalOptions.EMPTY);
    this.expr = field;
    this.alias = field(alias);
  }

  public Unnest(@Nonnull Field field, @Nonnull String alias, @Nonnull UnnestOptions options) {
    super("unnest", options.options);
    this.expr = field;
    this.alias = field(alias);
  }

  public Unnest(@Nonnull Selectable field) {
    super("unnest", InternalOptions.EMPTY);
    if (field instanceof AliasedExpression) {
      this.expr = ((AliasedExpression) field).getExpr();
      this.alias = field(((AliasedExpression) field).getAlias());
    } else {
      this.expr = (Field) field;
      this.alias = (Field) field;
    }
  }

  public Unnest(@Nonnull Selectable field, @Nonnull UnnestOptions options) {
    super("unnest", options.options);
    if (field instanceof AliasedExpression) {
      this.expr = ((AliasedExpression) field).getExpr();
      this.alias = field(((AliasedExpression) field).getAlias());
    } else {
      this.expr = (Field) field;
      this.alias = (Field) field;
    }
  }

  @Override
  Iterable<Value> toStageArgs() {
    return ImmutableList.of(encodeValue(expr), encodeValue(alias));
  }
}
