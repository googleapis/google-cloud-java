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
import com.google.bigtable.v2.ReadChangeStreamResponse;
import com.google.cloud.bigtable.common.Status;
import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * A simple wrapper for {@link ReadChangeStreamResponse.CloseStream}. This message is received when
 * the stream reading is finished(i.e. read past the stream end time), or an error has occurred.
 */
@InternalApi("Intended for use by the BigtableIO in apache/beam only.")
@AutoValue
public abstract class CloseStream implements ChangeStreamRecord, Serializable {
  private static final long serialVersionUID = 7316215828353608505L;

  private static CloseStream create(
      com.google.rpc.Status status,
      List<ChangeStreamContinuationToken> changeStreamContinuationTokens) {
    return new AutoValue_CloseStream(Status.fromProto(status), changeStreamContinuationTokens);
  }

  /** Wraps the protobuf {@link ReadChangeStreamResponse.CloseStream}. */
  @InternalApi("Intended for use by the BigtableIO in apache/beam only.")
  public static CloseStream fromProto(@Nonnull ReadChangeStreamResponse.CloseStream closeStream) {
    return create(
        closeStream.getStatus(),
        closeStream.getContinuationTokensList().stream()
            .map(ChangeStreamContinuationToken::fromProto)
            .collect(ImmutableList.toImmutableList()));
  }

  @InternalApi("Intended for use by the BigtableIO in apache/beam only.")
  @Nonnull
  public abstract Status getStatus();

  @InternalApi("Intended for use by the BigtableIO in apache/beam only.")
  @Nonnull
  public abstract List<ChangeStreamContinuationToken> getChangeStreamContinuationTokens();
}
