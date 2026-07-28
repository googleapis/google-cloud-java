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

import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ServerStream;
import com.google.auto.value.AutoValue;
import com.google.cloud.bigtable.data.v2.internal.SqlRow;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;

/**
 * Implementation of {@link SqlServerStream} using AutoValue
 *
 * <p>This is considered an internal implementation detail and should not be used by applications.
 */
@InternalApi("For internal use only")
@AutoValue
public abstract class SqlServerStreamImpl implements SqlServerStream {

  @InternalApi("Visible for testing")
  public static SqlServerStreamImpl create(
      ApiFuture<ResultSetMetadata> metadataApiFuture, ServerStream<SqlRow> rowServerStream) {
    return new AutoValue_SqlServerStreamImpl(metadataApiFuture, rowServerStream);
  }

  @Override
  public abstract ApiFuture<ResultSetMetadata> metadataFuture();

  @Override
  public abstract ServerStream<SqlRow> rows();
}
