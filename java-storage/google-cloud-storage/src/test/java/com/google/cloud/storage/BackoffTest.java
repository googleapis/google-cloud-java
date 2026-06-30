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
import static java.time.Duration.ZERO;
import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertThrows;

import com.google.cloud.storage.Backoff.BackoffDuration;
import com.google.cloud.storage.Backoff.BackoffResult;
import com.google.cloud.storage.Backoff.BackoffResults;
import com.google.cloud.storage.Backoff.Jitterer;
import java.time.Duration;
import org.junit.Test;

public final class BackoffTest {

  @Test
  public void interruptedBackoffOnlyAddsActualElapsedTimeToCumulative() {
    Backoff backoff =
        Backoff.newBuilder()
            .setInitialBackoff(Duration.ofSeconds(2))
            .setMaxBackoff(Duration.ofSeconds(11))
            // this value is critical, if instead it is 35 seconds, the test can still succeed
            // even if the interrupted backoff duration isn't corrected
            .setTimeout(Duration.ofSeconds(34))
            .setJitterer(Jitterer.noJitter())
            .setRetryDelayMultiplier(2.0)
            .build();

    // operation failed after 1s
    BackoffResult r1 = backoff.nextBackoff(Duration.ofSeconds(1));
    // start backoff of 2s
    assertThat(r1).isEqualTo(BackoffDuration.of(Duration.ofSeconds(2)));
    // higher level failures happens only 300ms into our 2s
    BackoffResult r2 = backoff.nextBackoff(Duration.ofMillis(300));
    // backoff 4s (previous was 2s w/ 2.0 multiplier = 4s)
    // even though the previous backoff duration wasn't fully consumed, still use it as the basis
    // for the next backoff
    assertThat(r2).isEqualTo(BackoffDuration.of(Duration.ofSeconds(4)));
    // another failure 3s after the 4s backoff finished
    BackoffResult r3 = backoff.nextBackoff(Duration.ofSeconds(7));
    assertThat(r3).isEqualTo(BackoffDuration.of(Duration.ofSeconds(8)));
    // another failure 5s after the 8s backoff finished
    BackoffResult r4 = backoff.nextBackoff(Duration.ofSeconds(13));
    // 11s backoff because 11s is maxBackoff
    assertThat(r4).isEqualTo(BackoffDuration.of(Duration.ofSeconds(11)));
    // another failure 7s after the 11s backoff finished
    BackoffResult r5 = backoff.nextBackoff(Duration.ofSeconds(18));
    // at this point it has been ~39s, which is more than our timeout of 34s
    assertThat(r5).isEqualTo(BackoffResults.EXHAUSTED);
  }

  @Test
  public void simple() {
    Backoff backoff = defaultBackoff();

    final BackoffResult r01 = backoff.nextBackoff(Duration.ofSeconds(2));
    assertThat(r01).isEqualTo(BackoffDuration.of(Duration.ofSeconds(2)));
    BackoffResult r02 = backoff.nextBackoff(((BackoffDuration) r01).getDuration());
    assertThat(r02).isEqualTo(BackoffDuration.of(Duration.ofSeconds(4)));
    BackoffResult r03 = backoff.nextBackoff(((BackoffDuration) r02).getDuration());
    assertThat(r03).isEqualTo(BackoffDuration.of(Duration.ofSeconds(8)));
    BackoffResult r04 = backoff.nextBackoff(((BackoffDuration) r03).getDuration());
    assertThat(r04).isEqualTo(BackoffDuration.of(Duration.ofSeconds(16)));
    BackoffResult r05 = backoff.nextBackoff(((BackoffDuration) r04).getDuration());
    assertThat(r05).isEqualTo(BackoffDuration.of(Duration.ofSeconds(32)));
    BackoffResult r06 = backoff.nextBackoff(((BackoffDuration) r05).getDuration());
    assertThat(r06).isEqualTo(BackoffDuration.of(Duration.ofSeconds(57)));
    BackoffResult r07 = backoff.nextBackoff(((BackoffDuration) r06).getDuration());
    assertThat(r07).isEqualTo(BackoffDuration.of(Duration.ofSeconds(57)));
    BackoffResult r08 = backoff.nextBackoff(((BackoffDuration) r07).getDuration());
    assertThat(r08).isEqualTo(BackoffDuration.of(Duration.ofSeconds(57)));
    BackoffResult r09 = backoff.nextBackoff(((BackoffDuration) r08).getDuration());
    assertThat(r09).isEqualTo(BackoffDuration.of(Duration.ofSeconds(57)));
    BackoffResult r10 = backoff.nextBackoff(((BackoffDuration) r09).getDuration());
    assertThat(r10).isEqualTo(BackoffDuration.of(Duration.ofSeconds(57)));
    BackoffResult r11 = backoff.nextBackoff(((BackoffDuration) r10).getDuration());
    assertThat(r11).isEqualTo(BackoffDuration.of(Duration.ofSeconds(57)));
    BackoffResult r12 = backoff.nextBackoff(((BackoffDuration) r11).getDuration());
    assertThat(r12).isEqualTo(BackoffDuration.of(Duration.ofSeconds(14)));
    BackoffResult r13 = backoff.nextBackoff(((BackoffDuration) r12).getDuration());
    assertThat(r13).isEqualTo(BackoffResults.EXHAUSTED);
  }

  @Test
  public void backoffDuration_min_of_backoff_maxBackoff_remainingFromTimeout() {
    Backoff backoff = defaultBackoff();

    Duration elapsed = Duration.ofMinutes(6).plusSeconds(58);
    assertThat(backoff.nextBackoff(elapsed)).isEqualTo(BackoffDuration.of(Duration.ofSeconds(2)));
    assertThat(backoff.nextBackoff(Duration.ofSeconds(2))).isEqualTo(BackoffResults.EXHAUSTED);
  }

  @Test
  public void elapsedDurationProvidedToNextBackoffMustBeGtEqZero() {
    Backoff backoff = defaultBackoff();

    Duration elapsed = Duration.ofSeconds(-1);
    IllegalArgumentException iae =
        assertThrows(IllegalArgumentException.class, () -> backoff.nextBackoff(elapsed));

    assertThat(iae).hasMessageThat().isEqualTo("elapsed must be >= PT0S (PT-1S >= PT0S)");
  }

  @Test
  public void resetWorks() {
    Backoff backoff =
        Backoff.newBuilder()
            .setInitialBackoff(Duration.ofSeconds(2))
            .setMaxBackoff(Duration.ofSeconds(5))
            .setTimeout(Duration.ofSeconds(6))
            .setJitterer(Jitterer.noJitter())
            .setRetryDelayMultiplier(2.0)
            .build();

    assertThat(backoff.nextBackoff(Duration.ofSeconds(4)))
        .isEqualTo(BackoffDuration.of(Duration.ofSeconds(2)));
    assertThat(backoff.nextBackoff(Duration.ofSeconds(2))).isEqualTo(BackoffResults.EXHAUSTED);
    backoff.reset();
    assertThat(backoff.nextBackoff(Duration.ofSeconds(10))).isEqualTo(BackoffResults.EXHAUSTED);
  }

  @Test
  public void onceExhaustedStaysExhaustedUntilReset() {
    Backoff backoff =
        Backoff.newBuilder()
            .setInitialBackoff(Duration.ofSeconds(2))
            .setMaxBackoff(Duration.ofSeconds(5))
            .setTimeout(Duration.ofSeconds(5))
            .setJitterer(Jitterer.noJitter())
            .setRetryDelayMultiplier(1.0)
            .build();

    assertThat(backoff.nextBackoff(Duration.ofSeconds(5))).isEqualTo(BackoffResults.EXHAUSTED);
    assertThat(backoff.nextBackoff(ZERO)).isEqualTo(BackoffResults.EXHAUSTED);
    backoff.reset();
    assertThat(backoff.nextBackoff(ZERO)).isEqualTo(BackoffDuration.of(Duration.ofSeconds(2)));
  }

  /**
   * If a next computed backoff would exceed the timeout, truncate the backoff to the amount of time
   * remaining until timeout.
   *
   * <p>This is primarily here to preserve behavior of {@link com.google.cloud.RetryHelper}.
   */
  @Test
  public void ifANextBackoffWouldExceedTheTimeoutTheBackoffDurationShouldBeTruncated_single() {
    Backoff backoff =
        Backoff.newBuilder()
            .setInitialBackoff(Duration.ofSeconds(2))
            .setMaxBackoff(Duration.ofSeconds(6))
            .setTimeout(Duration.ofSeconds(24))
            .setJitterer(Jitterer.noJitter())
            .setRetryDelayMultiplier(2.0)
            .build();

    assertThat(backoff.nextBackoff(Duration.ofSeconds(22)))
        .isEqualTo(BackoffDuration.of(ofSeconds(2)));
    assertThat(backoff.nextBackoff(Duration.ofSeconds(2))).isEqualTo(BackoffResults.EXHAUSTED);
  }

  /**
   * If a next computed backoff would exceed the timeout, truncate the backoff to the amount of time
   * remaining until timeout.
   *
   * <p>This is primarily here to preserve behavior of {@link com.google.cloud.RetryHelper}.
   */
  @Test
  public void ifANextBackoffWouldExceedTheTimeoutTheBackoffDurationShouldBeTruncated_multiple() {
    Duration timeout = ofSeconds(24);
    Backoff backoff =
        Backoff.newBuilder()
            .setInitialBackoff(Duration.ofSeconds(2))
            .setMaxBackoff(Duration.ofSeconds(6))
            .setTimeout(timeout)
            .setJitterer(Jitterer.noJitter())
            .setRetryDelayMultiplier(2.0)
            .build();

    assertThat(backoff.getCumulativeBackoff()).isEqualTo(Duration.ZERO);
    BackoffResult r1 = backoff.nextBackoff(Duration.ofSeconds(21));
    assertThat(backoff.getCumulativeBackoff()).isEqualTo(Duration.ofSeconds(21));
    assertThat(r1).isEqualTo(BackoffDuration.of(Duration.ofSeconds(2)));
    BackoffResult r2 = backoff.nextBackoff(((BackoffDuration) r1).getDuration());
    assertThat(backoff.getCumulativeBackoff()).isEqualTo(Duration.ofSeconds(23));
    assertThat(r2).isEqualTo(BackoffDuration.of(Duration.ofSeconds(1)));
    BackoffResult r3 = backoff.nextBackoff(((BackoffDuration) r2).getDuration());
    assertThat(backoff.getCumulativeBackoff()).isEqualTo(Duration.ofSeconds(24));
    assertThat(r3).isEqualTo(BackoffResults.EXHAUSTED);
  }

  @Test
  public void noJitter_alwaysReturnsInput() {
    Jitterer jitterer = Jitterer.noJitter();
    Duration _5s = Duration.ofSeconds(5);
    Duration _10s = Duration.ofSeconds(10);
    Duration _30s = Duration.ofSeconds(30);
    assertThat(jitterer.jitter(_5s)).isEqualTo(_5s);
    assertThat(jitterer.jitter(_10s)).isEqualTo(_10s);
    assertThat(jitterer.jitter(_30s)).isEqualTo(_30s);
  }

  @Test
  public void threadLocalRandomJitter_works() {
    Jitterer jitterer = Jitterer.threadLocalRandom();
    Duration min = Duration.ofNanos(-1);
    Duration _5s = Duration.ofSeconds(5);
    Duration _10s = Duration.ofSeconds(10);
    Duration _30s = Duration.ofSeconds(30);
    assertThat(jitterer.jitter(_5s)).isGreaterThan(min);
    assertThat(jitterer.jitter(_10s)).isGreaterThan(min);
    assertThat(jitterer.jitter(_30s)).isGreaterThan(min);

    assertThat(jitterer.jitter(min)).isEqualTo(min);
  }

  private static Backoff defaultBackoff() {
    return Backoff.newBuilder()
        .setInitialBackoff(Duration.ofSeconds(2))
        .setMaxBackoff(Duration.ofSeconds(57))
        .setTimeout(Duration.ofMinutes(7))
        .setJitterer(Jitterer.noJitter())
        .setRetryDelayMultiplier(2.0)
        .build();
  }
}
