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

import com.google.cloud.firestore.pipeline.expressions.Expression;
import com.google.common.collect.ImmutableList;
import com.google.firestore.v1.Value;
import javax.annotation.Nonnull;

public class ReplaceWith extends Stage {

  private final Expression expr;
  private final Mode mode;

  public enum Mode {
    FULL_REPLACE(Value.newBuilder().setStringValue("full_replace").build()),
    MERGE_PREFER_NEXT(Value.newBuilder().setStringValue("merge_prefer_nest").build()),
    MERGE_PREFER_PARENT(Value.newBuilder().setStringValue("merge_prefer_parent").build());

    public final Value value;

    Mode(Value value) {
      this.value = value;
    }
  }

  public ReplaceWith(@Nonnull Expression field) {
    this(field, Mode.FULL_REPLACE);
  }

  public ReplaceWith(@Nonnull Expression expr, @Nonnull Mode mode) {
    super("replace_with", InternalOptions.EMPTY);
    this.expr = expr;
    this.mode = mode;
  }

  @Override
  Iterable<Value> toStageArgs() {
    return ImmutableList.of(encodeValue(expr), mode.value);
  }
}
