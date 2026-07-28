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

package com.google.cloud.bigquery.exception;

import com.google.api.core.InternalApi;

/**
 * Thrown to indicate that the current TypeCoercer can not perform the coercion as the Coercion
 * implementation is not registered for the mentioned source and target type.
 */
@InternalApi
public class BigQueryJdbcCoercionNotFoundException extends RuntimeException {

  /**
   * Construct a new exception.
   *
   * @param source the source type.
   * @param target the target type.
   */
  public BigQueryJdbcCoercionNotFoundException(Class<?> source, Class<?> target) {
    super(
        String.format(
            "Coercion not found for [%s -> %s] conversion",
            source.getCanonicalName(), target.getCanonicalName()));
  }
}
