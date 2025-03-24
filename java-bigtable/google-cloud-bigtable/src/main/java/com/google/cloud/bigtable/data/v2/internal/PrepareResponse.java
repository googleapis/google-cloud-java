/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.PrepareQueryResponse;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.protobuf.ByteString;
import java.time.Instant;

/**
 * Wrapper for results of a PrepareQuery call.
 *
 * <p>This should only be managed by {@link
 * com.google.cloud.bigtable.data.v2.models.sql.PreparedStatement}, and never used directly by users
 *
 * <p>This is considered an internal implementation detail and should not be used by applications.
 */
@InternalApi("For internal use only")
@AutoValue
public abstract class PrepareResponse {
  public abstract ResultSetMetadata resultSetMetadata();

  public abstract ByteString preparedQuery();

  public abstract Instant validUntil();

  public static PrepareResponse fromProto(PrepareQueryResponse proto) {
    ResultSetMetadata metadata = ProtoResultSetMetadata.fromProto(proto.getMetadata());
    Instant validUntil = TimestampUtil.toInstant(proto.getValidUntil());
    return new AutoValue_PrepareResponse(metadata, proto.getPreparedQuery(), validUntil);
  }
}
