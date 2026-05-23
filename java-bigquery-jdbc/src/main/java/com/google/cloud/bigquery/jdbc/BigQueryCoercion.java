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
import java.util.function.Function;

/**
 * A {@link BigQueryCoercion} is responsible for coercing one type to another. An implementation of
 * {@link BigQueryCoercion} is used to extend the behaviour of {@link BigQueryTypeCoercer} for the
 * coercion of one user defined type to another.
 *
 * @param <INPUT> represents the source type
 * @param <OUTPUT> represents the target type
 */
@InternalApi
interface BigQueryCoercion<INPUT, OUTPUT> extends Function<INPUT, OUTPUT> {
  /**
   * Coerce the provided value to the desired type.
   *
   * @param value the input value.
   * @return the output value after coercion.
   */
  OUTPUT coerce(INPUT value);

  @Override
  default OUTPUT apply(INPUT input) {
    return coerce(input);
  }
}
