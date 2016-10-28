/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

import static com.google.cloud.RetryParams.DEFAULT_INITIAL_RETRY_DELAY_MILLIS;
import static com.google.cloud.RetryParams.DEFAULT_MAX_RETRY_DELAY_MILLIS;
import static com.google.cloud.RetryParams.DEFAULT_RETRY_DELAY_BACKOFF_FACTOR;
import static com.google.cloud.RetryParams.DEFAULT_RETRY_MAX_ATTEMPTS;
import static com.google.cloud.RetryParams.DEFAULT_RETRY_MIN_ATTEMPTS;
import static com.google.cloud.RetryParams.DEFAULT_TOTAL_RETRY_PERIOD_MILLIS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.google.cloud.RetryParams.Builder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

/**
 * Tests for {@link RetryParams}.
 */
@RunWith(JUnit4.class)
public class RetryParamsTest {

  @Test
  public void testDefaults() {
    RetryParams params1 = RetryParams.getDefaultInstance();
    RetryParams params2 = RetryParams.newBuilder().build();
    for (RetryParams params : Arrays.asList(params1, params2)) {
      assertEquals(DEFAULT_INITIAL_RETRY_DELAY_MILLIS, params.getInitialRetryDelayMillis());
      assertEquals(DEFAULT_MAX_RETRY_DELAY_MILLIS, params.getMaxRetryDelayMillis());
      assertEquals(DEFAULT_RETRY_DELAY_BACKOFF_FACTOR, params.getRetryDelayBackoffFactor(), 0);
      assertEquals(DEFAULT_RETRY_MAX_ATTEMPTS, params.getRetryMaxAttempts());
      assertEquals(DEFAULT_RETRY_MIN_ATTEMPTS, params.getRetryMinAttempts());
      assertEquals(DEFAULT_TOTAL_RETRY_PERIOD_MILLIS, params.getTotalRetryPeriodMillis());
    }
  }

  @Test
  public void testDefaultsDeprecated() {
    RetryParams params1 = RetryParams.defaultInstance();
    RetryParams params2 = RetryParams.builder().build();
    for (RetryParams params : Arrays.asList(params1, params2)) {
      assertEquals(DEFAULT_INITIAL_RETRY_DELAY_MILLIS, params.initialRetryDelayMillis());
      assertEquals(DEFAULT_MAX_RETRY_DELAY_MILLIS, params.maxRetryDelayMillis());
      assertEquals(DEFAULT_RETRY_DELAY_BACKOFF_FACTOR, params.retryDelayBackoffFactor(), 0);
      assertEquals(DEFAULT_RETRY_MAX_ATTEMPTS, params.retryMaxAttempts());
      assertEquals(DEFAULT_RETRY_MIN_ATTEMPTS, params.retryMinAttempts());
      assertEquals(DEFAULT_TOTAL_RETRY_PERIOD_MILLIS, params.totalRetryPeriodMillis());
    }
  }

  @Test
  public void testSetAndCopy() {
    RetryParams.Builder builder = RetryParams.newBuilder();
    builder.setInitialRetryDelayMillis(101);
    builder.setMaxRetryDelayMillis(102);
    builder.setRetryDelayBackoffFactor(103);
    builder.setRetryMinAttempts(107);
    builder.setRetryMaxAttempts(108);
    builder.setTotalRetryPeriodMillis(109);
    RetryParams params1 = builder.build();
    RetryParams params2 = new RetryParams.Builder(params1).build();
    for (RetryParams params : Arrays.asList(params1, params2)) {
      assertEquals(101, params.getInitialRetryDelayMillis());
      assertEquals(102, params.getMaxRetryDelayMillis());
      assertEquals(103, params.getRetryDelayBackoffFactor(), 0);
      assertEquals(107, params.getRetryMinAttempts());
      assertEquals(108, params.getRetryMaxAttempts());
      assertEquals(109, params.getTotalRetryPeriodMillis());
    }
  }

  @Test
  public void testSetAndCopyDeprecated() {
    RetryParams.Builder builder = RetryParams.builder();
    builder.initialRetryDelayMillis(101);
    builder.maxRetryDelayMillis(102);
    builder.retryDelayBackoffFactor(103);
    builder.retryMinAttempts(107);
    builder.retryMaxAttempts(108);
    builder.totalRetryPeriodMillis(109);
    RetryParams params1 = builder.build();
    RetryParams params2 = new RetryParams.Builder(params1).build();
    for (RetryParams params : Arrays.asList(params1, params2)) {
      assertEquals(101, params.initialRetryDelayMillis());
      assertEquals(102, params.maxRetryDelayMillis());
      assertEquals(103, params.retryDelayBackoffFactor(), 0);
      assertEquals(107, params.retryMinAttempts());
      assertEquals(108, params.retryMaxAttempts());
      assertEquals(109, params.totalRetryPeriodMillis());
    }
  }

  @Test
  public void testBadSettings() {
    RetryParams.Builder builder = RetryParams.newBuilder();
    builder.setInitialRetryDelayMillis(-1);
    builder = assertFailure(builder);
    builder.setMaxRetryDelayMillis(
        RetryParams.getDefaultInstance().getInitialRetryDelayMillis() - 1);
    builder = assertFailure(builder);
    builder.setRetryDelayBackoffFactor(-1);
    builder = assertFailure(builder);
    builder.setRetryMinAttempts(-1);
    builder = assertFailure(builder);
    builder.setRetryMaxAttempts(RetryParams.getDefaultInstance().getRetryMinAttempts() - 1);
    builder = assertFailure(builder);
    builder.setTotalRetryPeriodMillis(-1);
    builder = assertFailure(builder);
    // verify that it is OK for min and max to be equal
    builder.setRetryMaxAttempts(RetryParams.getDefaultInstance().getRetryMinAttempts());
    builder.setMaxRetryDelayMillis(RetryParams.getDefaultInstance().getInitialRetryDelayMillis());
    builder.build();
  }

  private static Builder assertFailure(Builder builder) {
    try {
      builder.build();
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException ex) {
      // expected
    }
    return RetryParams.newBuilder();
  }
}
