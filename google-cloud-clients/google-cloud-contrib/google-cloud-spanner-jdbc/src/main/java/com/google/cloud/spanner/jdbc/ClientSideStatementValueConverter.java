/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc;

/**
 * Interface for converters that are used by {@link ClientSideStatement} that sets a value that need
 * to be converted from a string to a specific type. Implementing classes must have a public
 * constructor that takes a String parameter. The String parameter will contain a regular expression
 * for the allowed values for the property.
 */
interface ClientSideStatementValueConverter<T> {

  /** The type to convert to. */
  Class<T> getParameterClass();

  /**
   * The actual convert method. Should return <code>null</code> for values that could not be
   * converted.
   */
  T convert(String value);
}
