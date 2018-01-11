/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.bigquery;

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

@InternalApi
@AutoValue
public abstract class QueryResponse {
  QueryResponse() {
    // Package private so users can't subclass it but AutoValue can.
  }

  // Only null if the job fails.
  @Nullable
  abstract Schema getSchema();

  abstract boolean getCompleted();

  abstract long getTotalRows();

  abstract ImmutableList<BigQueryError> getErrors();

  static Builder newBuilder() {
    return new AutoValue_QueryResponse.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {
    abstract Builder setSchema(Schema val);

    abstract Builder setCompleted(boolean val);

    abstract Builder setTotalRows(long val);

    abstract Builder setErrors(ImmutableList<BigQueryError> val);

    abstract QueryResponse build();
  }

}
