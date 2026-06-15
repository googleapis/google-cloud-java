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
package com.google.cloud.bigtable.data.v2.internal.middleware;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.base.Ticker;
import com.google.common.collect.Range;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VRpcCallContextTest {

  @Test
  public void testDeadline() {
    FakeTicker fakeTicker = new FakeTicker(System.nanoTime());
    VRpc.OperationInfo operationInfo =
        VRpc.OperationInfo.create(fakeTicker, Duration.ofMinutes(1), true);
    assertThat(operationInfo.getDeadline().timeRemaining(TimeUnit.SECONDS))
        .isIn(Range.closed(58L, 60L));

    fakeTicker.increment(Duration.ofSeconds(10));
    assertThat(operationInfo.getDeadline().timeRemaining(TimeUnit.SECONDS))
        .isIn(Range.closed(48L, 50L));

    fakeTicker.increment(Duration.ofSeconds(10));
    VRpc.OperationInfo nextAttempt = operationInfo.createForNextAttempt();
    assertThat(nextAttempt.getDeadline().timeRemaining(TimeUnit.SECONDS))
        .isIn(Range.closed(38L, 40L));

    fakeTicker.increment(Duration.ofSeconds(50));
    assertThat(nextAttempt.getDeadline().isExpired()).isTrue();
  }

  private static class FakeTicker extends Ticker {
    private long nanoTime;

    FakeTicker(long time) {
      this.nanoTime = time;
    }

    void increment(Duration duration) {
      this.nanoTime += duration.toNanos();
    }

    @Override
    public long read() {
      return nanoTime;
    }
  }
}
