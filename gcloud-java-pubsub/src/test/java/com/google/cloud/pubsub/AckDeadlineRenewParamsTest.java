/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.pubsub;

import static com.google.cloud.pubsub.AckDeadlineRenewParams.DEFAULT_DEADLINE_BACKOFF_FACTOR;
import static com.google.cloud.pubsub.AckDeadlineRenewParams.DEFAULT_INITIAL_DEADLINE_SECONDS;
import static com.google.cloud.pubsub.AckDeadlineRenewParams.DEFAULT_MAX_DEADLINED_SECONDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.google.cloud.pubsub.AckDeadlineRenewParams.Builder;

import org.junit.Test;

import java.util.Arrays;

public class AckDeadlineRenewParamsTest {

  private static final AckDeadlineRenewParams RENEW_PARAMS = AckDeadlineRenewParams.builder()
      .initialDeadlineSeconds(101)
      .maxDeadlineSeconds(102)
      .deadlineBackoffFactor(103)
      .build();

  @Test
  public void testDefaults() {
    AckDeadlineRenewParams params1 = AckDeadlineRenewParams.defaultInstance();
    AckDeadlineRenewParams params2 = AckDeadlineRenewParams.builder().build();
    compareAckDeadlineRenewParams(params1, params2);
    for (AckDeadlineRenewParams params : Arrays.asList(params1, params2)) {
      assertEquals(DEFAULT_INITIAL_DEADLINE_SECONDS, params.initialDeadlineSeconds());
      assertEquals(DEFAULT_MAX_DEADLINED_SECONDS, params.maxDeadlineSeconds());
      assertEquals(DEFAULT_DEADLINE_BACKOFF_FACTOR, params.deadlineBackoffFactor(), 0);
    }
  }

  @Test
  public void testNoBackoff() {
    AckDeadlineRenewParams params = AckDeadlineRenewParams.noBackoff();
    assertEquals(DEFAULT_INITIAL_DEADLINE_SECONDS, params.initialDeadlineSeconds());
    assertEquals(DEFAULT_INITIAL_DEADLINE_SECONDS, params.maxDeadlineSeconds());
    assertEquals(1, params.deadlineBackoffFactor(), 0);
  }

  @Test
  public void testBuilder() {
    assertEquals(101, RENEW_PARAMS.initialDeadlineSeconds());
    assertEquals(102, RENEW_PARAMS.maxDeadlineSeconds());
    assertEquals(103, RENEW_PARAMS.deadlineBackoffFactor(), 0);
  }

  @Test
  public void testToBuilder() {
    compareAckDeadlineRenewParams(RENEW_PARAMS, RENEW_PARAMS.toBuilder().build());
    compareAckDeadlineRenewParams(AckDeadlineRenewParams.defaultInstance(),
        AckDeadlineRenewParams.defaultInstance().toBuilder().build());
    compareAckDeadlineRenewParams(AckDeadlineRenewParams.noBackoff(),
        AckDeadlineRenewParams.noBackoff().toBuilder().build());
  }

  @Test
  public void testBadSettings() {
    Builder builder = AckDeadlineRenewParams.builder();
    builder.initialDeadlineSeconds(9);
    builder = assertFailure(builder);
    builder.maxDeadlineSeconds(DEFAULT_INITIAL_DEADLINE_SECONDS - 1);
    builder = assertFailure(builder);
    builder.deadlineBackoffFactor(0.9);
    assertFailure(builder);
  }

  private static Builder assertFailure(Builder builder) {
    try {
      builder.build();
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException ex) {
      // expected
    }
    return AckDeadlineRenewParams.builder();
  }

  private static void compareAckDeadlineRenewParams(AckDeadlineRenewParams expected,
      AckDeadlineRenewParams value) {
    assertEquals(expected, value);
    assertEquals(expected.initialDeadlineSeconds(), value.initialDeadlineSeconds());
    assertEquals(expected.maxDeadlineSeconds(), value.maxDeadlineSeconds());
    assertEquals(expected.deadlineBackoffFactor(), value.deadlineBackoffFactor(), 0);
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
