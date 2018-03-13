/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.logging;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.logging.v2.WriteLogEntriesRequest;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.BeforeClass;
import org.junit.Test;

public class BatchingWriterTest {

  private static final WriteLogEntriesRequest EMPTY_REQUEST =
      WriteLogEntriesRequest.newBuilder().build();
  private static final com.google.logging.v2.LogEntry EMPTY_ENTRY =
      com.google.logging.v2.LogEntry.newBuilder().build();
  private static ScheduledThreadPoolExecutor EXECUTOR;

  @BeforeClass
  public static void beforeClass() {
    // Executor is never used.
    EXECUTOR = new ScheduledThreadPoolExecutor(1);
    EXECUTOR.shutdownNow();
  }

  @Test
  public void testEmptyWrite() {
    BatchingWriter.Rpc rpc =
        new BatchingWriter.Rpc() {
          @Override
          public ApiFuture<Void> call(WriteLogEntriesRequest request) {
            throw new UnsupportedOperationException("should never be called");
          }
        };

    BatchingWriter writer =
        new BatchingWriter(
            rpc,
            10,
            10,
            new FlowController(FlowControlSettings.getDefaultInstance()),
            EMPTY_REQUEST,
            EXECUTOR);
    writer.initFlush();

    // If there's no message, there's no RPC.
    assertThat(writer.pendingRpcs()).isEmpty();
  }

  @Test
  public void testFlush() throws Exception {
    final SettableApiFuture<Void> fakeFuture = SettableApiFuture.create();
    BatchingWriter.Rpc rpc =
        new BatchingWriter.Rpc() {
          @Override
          public ApiFuture<Void> call(WriteLogEntriesRequest request) {
            return fakeFuture;
          }
        };

    BatchingWriter writer =
        new BatchingWriter(
            rpc,
            10,
            10,
            new FlowController(FlowControlSettings.getDefaultInstance()),
            EMPTY_REQUEST,
            EXECUTOR);
    writer.add(EMPTY_ENTRY);
    writer.initFlush();

    List<ApiFuture<Void>> futures = writer.pendingRpcs();
    assertThat(futures).hasSize(1);
    assertThat(futures.get(0).isDone()).isFalse();

    fakeFuture.set(null);
    assertThat(futures.get(0).isDone()).isTrue();
    assertThat(writer.pendingRpcs()).isEmpty();
  }
}
