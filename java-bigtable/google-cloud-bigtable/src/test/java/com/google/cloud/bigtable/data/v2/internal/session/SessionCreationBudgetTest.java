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
package com.google.cloud.bigtable.data.v2.internal.session;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeClock;
import java.time.Duration;
import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SessionCreationBudgetTest {

  private FakeClock clock;
  private Duration penalty;

  @BeforeEach
  public void setup() {
    clock = new FakeClock(Instant.now());
    penalty = Duration.ofMinutes(1);
  }

  @Test
  public void test() {
    SessionCreationBudget budget = new SessionCreationBudget(1, penalty, clock);
    // Try reserve 2 sessions, the second one should return false
    assertThat(budget.tryReserveSession()).isTrue();
    assertThat(budget.tryReserveSession()).isFalse();

    // Release the session, try reserve again should return true
    budget.onSessionCreationSuccess();
    assertThat(budget.tryReserveSession()).isTrue();

    // Release the session as failure, try reserve again should false because of penalty
    budget.onSessionCreationFailure();
    assertThat(budget.tryReserveSession()).isFalse();

    // increment the clock, try reserver again should return true
    clock.increment(penalty.plus(Duration.ofNanos(1)));
    assertThat(budget.tryReserveSession()).isTrue();
  }
}
