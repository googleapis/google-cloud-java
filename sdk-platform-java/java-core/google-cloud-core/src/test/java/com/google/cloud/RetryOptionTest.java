/*
 * Copyright 2016 Google LLC
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

package com.google.cloud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.google.api.gax.retrying.RetrySettings;
import java.time.Duration;
import org.junit.jupiter.api.Test;

class RetryOptionTest {
  private static final long TOTAL_TIMEOUT_MILLIS = 420l;
  private static final long INITIAL_RETRY_DELAY_MILLIS = 42l;
  private static final long MAX_RETRY_DELAY_MILLIS = 100l;

  private static final RetryOption TOTAL_TIMEOUT =
      RetryOption.totalTimeoutDuration(Duration.ofMillis(TOTAL_TIMEOUT_MILLIS));
  private static final RetryOption INITIAL_RETRY_DELAY =
      RetryOption.initialRetryDelayDuration(Duration.ofMillis(INITIAL_RETRY_DELAY_MILLIS));
  private static final RetryOption RETRY_DELAY_MULTIPLIER = RetryOption.retryDelayMultiplier(1.5);
  private static final RetryOption MAX_RETRY_DELAY =
      RetryOption.maxRetryDelayDuration(Duration.ofMillis(MAX_RETRY_DELAY_MILLIS));
  private static final RetryOption MAX_ATTEMPTS = RetryOption.maxAttempts(100);
  private static final RetryOption JITTERED = RetryOption.jittered(false);

  private static final RetrySettings retrySettings =
      RetrySettings.newBuilder()
          .setTotalTimeoutDuration(Duration.ofMillis(420L))
          .setInitialRetryDelayDuration(Duration.ofMillis(42L))
          .setRetryDelayMultiplier(1.5)
          .setMaxRetryDelayDuration(Duration.ofMillis(100))
          .setMaxAttempts(100)
          .setJittered(false)
          .build();

  @Test
  void testEqualsAndHashCode() {
    assertEquals(TOTAL_TIMEOUT, TOTAL_TIMEOUT);
    assertEquals(INITIAL_RETRY_DELAY, INITIAL_RETRY_DELAY);
    assertEquals(RETRY_DELAY_MULTIPLIER, RETRY_DELAY_MULTIPLIER);
    assertEquals(MAX_RETRY_DELAY, MAX_RETRY_DELAY);
    assertEquals(MAX_ATTEMPTS, MAX_ATTEMPTS);
    assertEquals(JITTERED, JITTERED);

    assertNotEquals(TOTAL_TIMEOUT, JITTERED);
    assertNotEquals(INITIAL_RETRY_DELAY, TOTAL_TIMEOUT);
    assertNotEquals(RETRY_DELAY_MULTIPLIER, INITIAL_RETRY_DELAY);
    assertNotEquals(MAX_RETRY_DELAY, RETRY_DELAY_MULTIPLIER);
    assertNotEquals(MAX_ATTEMPTS, MAX_RETRY_DELAY);
    assertNotEquals(JITTERED, MAX_ATTEMPTS);

    RetryOption totalTimeout = RetryOption.totalTimeoutDuration(Duration.ofMillis(420L));
    RetryOption initialRetryDelay = RetryOption.initialRetryDelayDuration(Duration.ofMillis(42L));
    RetryOption retryDelayMultiplier = RetryOption.retryDelayMultiplier(1.5);
    RetryOption maxRetryDelay = RetryOption.maxRetryDelayDuration(Duration.ofMillis(100));
    RetryOption maxAttempts = RetryOption.maxAttempts(100);
    RetryOption jittered = RetryOption.jittered(false);

    assertEquals(TOTAL_TIMEOUT, totalTimeout);
    assertEquals(INITIAL_RETRY_DELAY, initialRetryDelay);
    assertEquals(RETRY_DELAY_MULTIPLIER, retryDelayMultiplier);
    assertEquals(MAX_RETRY_DELAY, maxRetryDelay);
    assertEquals(MAX_ATTEMPTS, maxAttempts);
    assertEquals(JITTERED, jittered);

    assertEquals(TOTAL_TIMEOUT.hashCode(), totalTimeout.hashCode());
    assertEquals(INITIAL_RETRY_DELAY.hashCode(), initialRetryDelay.hashCode());
    assertEquals(RETRY_DELAY_MULTIPLIER.hashCode(), retryDelayMultiplier.hashCode());
    assertEquals(MAX_RETRY_DELAY.hashCode(), maxRetryDelay.hashCode());
    assertEquals(MAX_ATTEMPTS.hashCode(), maxAttempts.hashCode());
    assertEquals(JITTERED.hashCode(), jittered.hashCode());
  }

  @Test
  void testMergeToSettings() {
    RetrySettings defRetrySettings = RetrySettings.newBuilder().build();

    assertEquals(defRetrySettings, RetryOption.mergeToSettings(defRetrySettings));

    RetrySettings mergedRetrySettings =
        RetryOption.mergeToSettings(
            defRetrySettings,
            TOTAL_TIMEOUT,
            INITIAL_RETRY_DELAY,
            RETRY_DELAY_MULTIPLIER,
            MAX_RETRY_DELAY,
            MAX_ATTEMPTS,
            JITTERED);
    assertEquals(retrySettings, mergedRetrySettings);

    defRetrySettings =
        defRetrySettings.toBuilder().setTotalTimeoutDuration(Duration.ofMillis(420L)).build();
    mergedRetrySettings = RetryOption.mergeToSettings(defRetrySettings, TOTAL_TIMEOUT);
    assertEquals(defRetrySettings, mergedRetrySettings);

    defRetrySettings =
        defRetrySettings.toBuilder().setMaxRetryDelayDuration(Duration.ofMillis(100)).build();
    mergedRetrySettings = RetryOption.mergeToSettings(defRetrySettings, MAX_RETRY_DELAY);
    assertEquals(defRetrySettings, mergedRetrySettings);

    defRetrySettings =
        defRetrySettings.toBuilder().setInitialRetryDelayDuration(Duration.ofMillis(42L)).build();
    mergedRetrySettings = RetryOption.mergeToSettings(defRetrySettings, INITIAL_RETRY_DELAY);
    assertEquals(defRetrySettings, mergedRetrySettings);

    defRetrySettings = defRetrySettings.toBuilder().setRetryDelayMultiplier(1.5).build();
    mergedRetrySettings = RetryOption.mergeToSettings(defRetrySettings, RETRY_DELAY_MULTIPLIER);
    assertEquals(defRetrySettings, mergedRetrySettings);

    defRetrySettings = defRetrySettings.toBuilder().setMaxAttempts(100).build();
    mergedRetrySettings = RetryOption.mergeToSettings(defRetrySettings, MAX_ATTEMPTS);
    assertEquals(defRetrySettings, mergedRetrySettings);

    defRetrySettings = defRetrySettings.toBuilder().setJittered(false).build();
    mergedRetrySettings = RetryOption.mergeToSettings(defRetrySettings, JITTERED);
    assertEquals(defRetrySettings, mergedRetrySettings);
  }

  @Test
  public void threetenMethods_producesEquivalentJavaTimeRetryOptions() {

    final RetryOption totalTimeoutThreeten =
        RetryOption.totalTimeout(org.threeten.bp.Duration.ofMillis(TOTAL_TIMEOUT_MILLIS));
    final RetryOption initialRetryDelayThreeten =
        RetryOption.initialRetryDelay(
            org.threeten.bp.Duration.ofMillis(INITIAL_RETRY_DELAY_MILLIS));
    final RetryOption maxRetryDelayThreeten =
        RetryOption.maxRetryDelay(org.threeten.bp.Duration.ofMillis(MAX_RETRY_DELAY_MILLIS));

    assertEquals(TOTAL_TIMEOUT, totalTimeoutThreeten);
    assertEquals(INITIAL_RETRY_DELAY, initialRetryDelayThreeten);
    assertEquals(MAX_RETRY_DELAY, maxRetryDelayThreeten);
  }
}
