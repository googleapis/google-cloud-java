/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.channels;

import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.Mutation.SetCell;
import com.google.bigtable.v2.Mutation.TimestampOrigin;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.MethodDescriptor;
import java.util.ArrayList;
import java.util.List;

/**
 * Rounds client generated cell timestamps down to millisecond granularity.
 *
 * <p>{@link com.google.cloud.bigtable.data.v2.models.Mutation#setCell(String, String, String)} and
 * its siblings that don't take an explicit timestamp stamp the cell with the current time in
 * microseconds and tag it as {@link TimestampOrigin#CLIENT_AUTO_GENERATED}. The Bigtable service
 * truncates such timestamps to the granularity of the target table, so writing to a table with the
 * default {@code MILLIS} granularity keeps working. The Bigtable emulator predates {@code
 * timestamp_origin} and instead rejects any timestamp that is not a multiple of 1000, which breaks
 * every auto timestamped write.
 *
 * <p>This interceptor performs the truncation that the emulator is missing, so that it behaves like
 * a production table with millisecond granularity. Timestamps that the caller specified explicitly
 * are left untouched: those are rejected by a millisecond granularity table in production too.
 */
public class MillisTimestampInterceptor implements ClientInterceptor {
  private static final long MICROS_PER_MILLI = 1_000L;

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
    return new SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
      @SuppressWarnings("unchecked")
      @Override
      public void sendMessage(ReqT message) {
        super.sendMessage((ReqT) truncateRequest(message));
      }
    };
  }

  private static Object truncateRequest(Object message) {
    if (message instanceof MutateRowRequest) {
      MutateRowRequest request = (MutateRowRequest) message;
      return request.toBuilder()
          .clearMutations()
          .addAllMutations(truncateAll(request.getMutationsList()))
          .build();
    } else if (message instanceof MutateRowsRequest) {
      MutateRowsRequest request = (MutateRowsRequest) message;
      MutateRowsRequest.Builder builder = request.toBuilder().clearEntries();
      for (MutateRowsRequest.Entry entry : request.getEntriesList()) {
        builder.addEntries(
            entry.toBuilder()
                .clearMutations()
                .addAllMutations(truncateAll(entry.getMutationsList())));
      }
      return builder.build();
    } else if (message instanceof CheckAndMutateRowRequest) {
      CheckAndMutateRowRequest request = (CheckAndMutateRowRequest) message;
      return request.toBuilder()
          .clearTrueMutations()
          .addAllTrueMutations(truncateAll(request.getTrueMutationsList()))
          .clearFalseMutations()
          .addAllFalseMutations(truncateAll(request.getFalseMutationsList()))
          .build();
    }

    return message;
  }

  private static List<Mutation> truncateAll(List<Mutation> mutations) {
    List<Mutation> truncated = new ArrayList<>(mutations.size());
    for (Mutation mutation : mutations) {
      truncated.add(truncate(mutation));
    }
    return truncated;
  }

  /** Returns the mutation with its timestamp truncated, or as is if it didn't need truncating. */
  private static Mutation truncate(Mutation mutation) {
    if (mutation.getTimestampOrigin() != TimestampOrigin.CLIENT_AUTO_GENERATED
        || !mutation.hasSetCell()) {
      return mutation;
    }

    SetCell setCell = mutation.getSetCell();
    long micros = setCell.getTimestampMicros();
    long millisAligned = micros - Math.floorMod(micros, MICROS_PER_MILLI);
    if (millisAligned == micros) {
      return mutation;
    }

    return mutation.toBuilder()
        .setSetCell(setCell.toBuilder().setTimestampMicros(millisAligned))
        .build();
  }
}
