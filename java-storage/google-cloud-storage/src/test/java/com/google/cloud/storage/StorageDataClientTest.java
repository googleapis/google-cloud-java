/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.ReadRange;
import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public final class StorageDataClientTest {

  @Mock public ScheduledExecutorService exec;

  @Test
  public void readSession_requestWithRangeRead_noAllowed() throws Exception {
    try (StorageDataClient dc =
        StorageDataClient.create(exec, Duration.ofSeconds(2), null, null, IOAutoCloseable.noOp())) {
      assertThrows(
          IllegalArgumentException.class,
          () -> {
            BidiReadObjectRequest req =
                BidiReadObjectRequest.newBuilder()
                    .addReadRanges(ReadRange.newBuilder().setReadId(1))
                    .build();
            dc.readSession(req, GrpcCallContext.createDefault());
          });
    }
  }

  @Test
  public void executorServiceProvidedShouldBeClosed() throws Exception {
    assertThat(exec).isNotNull();
    StorageDataClient sdc =
        StorageDataClient.create(exec, Duration.ofSeconds(2), null, null, IOAutoCloseable.noOp());

    sdc.close();
    verify(exec, times(1)).shutdownNow();
    verify(exec, times(1)).awaitTermination(TimeUnit.SECONDS.toNanos(2), TimeUnit.NANOSECONDS);
  }
}
