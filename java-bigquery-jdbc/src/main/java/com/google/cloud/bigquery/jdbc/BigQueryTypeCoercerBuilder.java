/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.api.core.InternalApi;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * A builder to create {@link BigQueryTypeCoercer} to perform the coercion of custom user defined
 * types.
 */
@InternalApi
class BigQueryTypeCoercerBuilder {

  private final Map<Class<?>, Map<Class<?>, BigQueryCoercion<?, ?>>> allCoercions;

  BigQueryTypeCoercerBuilder() {
    this.allCoercions = new HashMap<>();
  }

  /**
   * registers a {@link BigQueryCoercion}
   *
   * @param coercion A {@link BigQueryCoercion} to register with this builder.
   */
  BigQueryTypeCoercerBuilder registerTypeCoercion(BigQueryCoercion<?, ?> coercion) {
    Type[] typeArguments =
        ((ParameterizedType) coercion.getClass().getGenericInterfaces()[0])
            .getActualTypeArguments();
    Class<?> sourceClass = (Class<?>) typeArguments[0];
    Class<?> targetClass = (Class<?>) typeArguments[1];
    this.registerInternal(coercion, sourceClass, targetClass);
    return this;
  }

  /**
   * registers a {@link BigQueryCoercion} using an implementation of {@link Function}
   *
   * @param function A {@link Function} to register with the builder.
   * @param sourceClass the source class
   * @param targetClass the target class
   */
  <I, O> BigQueryTypeCoercerBuilder registerTypeCoercion(
      Function<I, O> function, Class<I> sourceClass, Class<O> targetClass) {
    this.registerInternal((BigQueryCoercion<I, O>) function::apply, sourceClass, targetClass);
    return this;
  }

  /** builds the {@link BigQueryTypeCoercer} with all the registered {@link BigQueryCoercion}s. */
  BigQueryTypeCoercer build() {
    return new BigQueryTypeCoercer(this.allCoercions);
  }

  private void registerInternal(
      BigQueryCoercion<?, ?> coercion, Class<?> sourceClass, Class<?> targetClass) {
    Map<Class<?>, BigQueryCoercion<?, ?>> mapBySource =
        this.allCoercions.getOrDefault(sourceClass, new HashMap<>());
    mapBySource.put(targetClass, coercion);
    this.allCoercions.putIfAbsent(sourceClass, mapBySource);
  }
}
