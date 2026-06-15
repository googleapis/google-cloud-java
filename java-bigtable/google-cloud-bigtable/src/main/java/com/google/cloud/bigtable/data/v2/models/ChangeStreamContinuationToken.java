/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.data.v2.models;

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.StreamContinuationToken;
import com.google.bigtable.v2.StreamPartition;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.Serializable;
import javax.annotation.Nonnull;

/** A simple wrapper for {@link StreamContinuationToken}. */
@InternalApi("Intended for use by the BigtableIO in apache/beam only.")
@AutoValue
public abstract class ChangeStreamContinuationToken implements Serializable {
  private static final long serialVersionUID = 524679926247095L;

  private static ChangeStreamContinuationToken create(@Nonnull StreamContinuationToken tokenProto) {
    return new AutoValue_ChangeStreamContinuationToken(tokenProto);
  }

  @InternalApi("Intended for use by the BigtableIO in apache/beam only.")
  public static ChangeStreamContinuationToken create(
      @Nonnull ByteStringRange byteStringRange, @Nonnull String token) {
    return create(
        StreamContinuationToken.newBuilder()
            .setPartition(
                StreamPartition.newBuilder()
                    .setRowRange(
                        RowRange.newBuilder()
                            .setStartKeyClosed(byteStringRange.getStart())
                            .setEndKeyOpen(byteStringRange.getEnd())
                            .build())
                    .build())
            .setToken(token)
            .build());
  }

  /** Wraps the protobuf {@link StreamContinuationToken}. */
  @InternalApi("Intended for use by the BigtableIO in apache/beam only.")
  static ChangeStreamContinuationToken fromProto(
      @Nonnull StreamContinuationToken streamContinuationToken) {
    return create(streamContinuationToken);
  }

  @InternalApi("Intended for use by the BigtableIO in apache/beam only.")
  public static ChangeStreamContinuationToken fromByteString(ByteString byteString)
      throws InvalidProtocolBufferException {
    return create(StreamContinuationToken.newBuilder().mergeFrom(byteString).build());
  }

  @Nonnull
  public abstract StreamContinuationToken getTokenProto();

  /**
   * Get the partition of the current continuation token, represented by a {@link ByteStringRange}.
   */
  public ByteStringRange getPartition() {
    return ByteStringRange.create(
        getTokenProto().getPartition().getRowRange().getStartKeyClosed(),
        getTokenProto().getPartition().getRowRange().getEndKeyOpen());
  }

  public String getToken() {
    return getTokenProto().getToken();
  }

  public ByteString toByteString() {
    return getTokenProto().toByteString();
  }
}
