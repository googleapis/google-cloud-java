/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import com.google.auto.value.AutoValue;
import javax.annotation.Nullable;

/* Wrapper class for query parameters */
@AutoValue
public abstract class Parameter {
  Parameter() {
    // Package private so users can't subclass it but AutoValue can.
  }

  /**
   * Returns the name of the query parameter. If unset, this is a positional parameter. Otherwise,
   * should be unique within a query.
   *
   * @return value or {@code null} for none
   */
  @Nullable
  public abstract String getName();

  /** Returns the value for a query parameter along with its type. */
  public abstract QueryParameterValue getValue();

  /** Returns a builder pre-populated using the current values of this field. */
  public abstract Builder toBuilder();

  /** Returns a builder for a {@code Parameter} object. */
  public static Builder newBuilder() {
    return new AutoValue_Parameter.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {

    /**
     * [Optional] Sets the name of the query parameter. If unset, this is a positional parameter.
     * Otherwise, should be unique within a query.
     *
     * @param name name or {@code null} for none
     */
    public abstract Builder setName(String name);

    /**
     * Sets the the value for a query parameter along with its type.
     *
     * @param parameter parameter or {@code null} for none
     */
    public abstract Builder setValue(QueryParameterValue parameter);

    /** Creates a {@code Parameter} object. */
    public abstract Parameter build();
  }
}
