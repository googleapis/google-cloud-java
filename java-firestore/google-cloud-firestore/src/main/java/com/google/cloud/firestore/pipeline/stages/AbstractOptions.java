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

import com.google.cloud.firestore.PipelineUtils;
import com.google.cloud.firestore.pipeline.expressions.Expression;
import com.google.cloud.firestore.pipeline.expressions.Field;
import com.google.cloud.firestore.pipeline.expressions.FunctionUtils;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.firestore.v1.Value;
import java.util.Arrays;
import java.util.List;

/**
 * Parent class to Pipeline and Stage options.
 *
 * <p>Provides a base set of `wither` methods for adding undefined options.
 *
 * <p>Standardizes structure of options for uniform encoding and handling.
 *
 * <p>Intentionally package-private to prevent extension outside of library.
 *
 * @param <T> Subclass type.
 */
abstract class AbstractOptions<T> {

  protected final InternalOptions options;

  AbstractOptions(InternalOptions options) {
    this.options = options;
  }

  abstract T self(InternalOptions options);

  public final T with(String key, String value) {
    return with(key, encodeValue(value));
  }

  public final T with(String key, boolean value) {
    return with(key, encodeValue(value));
  }

  public final T with(String key, long value) {
    return with(key, encodeValue(value));
  }

  public final T with(String key, double value) {
    return with(key, encodeValue(value));
  }

  public final T with(String key, Field value) {
    return with(key, value.toProto());
  }

  protected final T with(String key, Value value) {
    return self(options.with(key, value));
  }

  protected final T with(String key, String[] values) {
    return self(options.with(key, Arrays.stream(values).map(PipelineUtils::encodeValue)::iterator));
  }

  protected final T with(String key, List<? extends Expression> expressions) {
    return self(options.with(key, Lists.transform(expressions, FunctionUtils::exprToValue)));
  }

  protected final T with(String key, AbstractOptions<?> subSection) {
    return self(options.with(key, subSection.options));
  }

  protected final T adding(AbstractOptions<?> subSection) {
    return self(options.adding(subSection));
  }

  public final T withSection(String key, RawOptions subSection) {
    return with(key, subSection);
  }

  final ImmutableMap<String, Value> toMap() {
    return options.options;
  }
}
