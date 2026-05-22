/*
 * Copyright 2026 Google LLC
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

package com.google.showcase.v1beta1.it;

import static org.junit.Assert.assertEquals;

import com.google.api.gax.retrying.RetrySettings;
import org.junit.Test;

/**
 * Tests to confirm that usage of retry settings can be done regardless of whether threeten or
 * java.time is being used
 */
public class ITTimeObjectsPropagationTest {
  @Test
  public void testRetrySettings_fromJavaTimeHasEquivalentThreetenValues() {
    java.time.Duration javaTimeCommonValue = java.time.Duration.ofMillis(123l);
    org.threeten.bp.Duration threetenConvertedValue =
        org.threeten.bp.Duration.ofMillis(javaTimeCommonValue.toMillis());
    RetrySettings javaTimeRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(javaTimeCommonValue)
            .setMaxRetryDelayDuration(javaTimeCommonValue)
            .setInitialRpcTimeoutDuration(javaTimeCommonValue)
            .setMaxRpcTimeoutDuration(javaTimeCommonValue)
            .setTotalTimeoutDuration(javaTimeCommonValue)
            .build();

    assertEquals(
        threetenConvertedValue.toMillis(), javaTimeRetrySettings.getInitialRetryDelay().toMillis());
    assertEquals(
        threetenConvertedValue.toMillis(), javaTimeRetrySettings.getMaxRetryDelay().toMillis());
    assertEquals(
        threetenConvertedValue.toMillis(), javaTimeRetrySettings.getInitialRpcTimeout().toMillis());
    assertEquals(
        threetenConvertedValue.toMillis(), javaTimeRetrySettings.getMaxRpcTimeout().toMillis());
    assertEquals(
        threetenConvertedValue.toMillis(), javaTimeRetrySettings.getTotalTimeout().toMillis());
  }

  @Test
  public void testRetrySettings_fromThreetenHasEquivalentJavaTimeValues() {
    org.threeten.bp.Duration threetenCommonValue = org.threeten.bp.Duration.ofMillis(123l);
    java.time.Duration javaTimeConvertedValue =
        java.time.Duration.ofMillis(threetenCommonValue.toMillis());
    RetrySettings threetenRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelay(threetenCommonValue)
            .setMaxRetryDelay(threetenCommonValue)
            .setInitialRpcTimeout(threetenCommonValue)
            .setMaxRpcTimeout(threetenCommonValue)
            .setTotalTimeout(threetenCommonValue)
            .build();

    assertEquals(
        javaTimeConvertedValue.toMillis(), threetenRetrySettings.getInitialRetryDelay().toMillis());
    assertEquals(
        javaTimeConvertedValue.toMillis(), threetenRetrySettings.getMaxRetryDelay().toMillis());
    assertEquals(
        javaTimeConvertedValue.toMillis(), threetenRetrySettings.getInitialRpcTimeout().toMillis());
    assertEquals(
        javaTimeConvertedValue.toMillis(), threetenRetrySettings.getMaxRpcTimeout().toMillis());
    assertEquals(
        javaTimeConvertedValue.toMillis(), threetenRetrySettings.getTotalTimeout().toMillis());
  }
}
