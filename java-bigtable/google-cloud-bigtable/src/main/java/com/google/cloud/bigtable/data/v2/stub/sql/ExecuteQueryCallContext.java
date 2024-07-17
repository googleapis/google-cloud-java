/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub.sql;

import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;

/**
 * POJO used to provide a future to the ExecuteQuery callable chain in order to return metadata to
 * users outside of the stream of rows.
 *
 * <p>This should only be constructed by {@link ExecuteQueryCallable} not directly by users.
 *
 * <p>This is considered an internal implementation detail and should not be used by applications.
 */
@InternalApi("For internal use only")
@AutoValue
public abstract class ExecuteQueryCallContext {

  @InternalApi("For internal use only")
  public static ExecuteQueryCallContext create(
      ExecuteQueryRequest request, SettableApiFuture<ResultSetMetadata> metadataFuture) {
    return new AutoValue_ExecuteQueryCallContext(request, metadataFuture);
  }

  abstract ExecuteQueryRequest request();

  abstract SettableApiFuture<ResultSetMetadata> resultSetMetadataFuture();
}
