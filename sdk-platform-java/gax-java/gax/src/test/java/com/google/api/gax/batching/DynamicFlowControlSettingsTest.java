/*
 * Copyright 2021 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.batching;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import org.junit.jupiter.api.Test;

class DynamicFlowControlSettingsTest {

  @Test
  void testEmptyBuilder() {
    DynamicFlowControlSettings.Builder builder = DynamicFlowControlSettings.newBuilder();
    DynamicFlowControlSettings settings = builder.build();
    assertNull(settings.getInitialOutstandingElementCount());
    assertNull(settings.getInitialOutstandingRequestBytes());
    assertNull(settings.getMaxOutstandingElementCount());
    assertNull(settings.getMaxOutstandingRequestBytes());
    assertNull(settings.getMinOutstandingElementCount());
    assertNull(settings.getMinOutstandingRequestBytes());
    assertEquals(LimitExceededBehavior.Block, settings.getLimitExceededBehavior());
  }

  @Test
  void testPartialSettingsIgnored() {
    // If behavior is ignore, build shouldn't throw exceptions even when only one of the bytes or
    // element limits is set
    DynamicFlowControlSettings.Builder builder =
        DynamicFlowControlSettings.newBuilder()
            .setLimitExceededBehavior(LimitExceededBehavior.Ignore)
            .setMaxOutstandingElementCount(1L);
    builder.build();
    builder =
        DynamicFlowControlSettings.newBuilder()
            .setLimitExceededBehavior(LimitExceededBehavior.Ignore)
            .setMinOutstandingRequestBytes(1L);
    builder.build();
  }

  @Test
  void testBuilder() {
    DynamicFlowControlSettings.Builder builder =
        DynamicFlowControlSettings.newBuilder()
            .setInitialOutstandingElementCount(5L)
            .setMaxOutstandingElementCount(10L)
            .setMinOutstandingElementCount(1L)
            .setInitialOutstandingRequestBytes(500L)
            .setMaxOutstandingRequestBytes(1000L)
            .setMinOutstandingRequestBytes(100L);
    DynamicFlowControlSettings settings = builder.build();
    assertThat(settings.getInitialOutstandingElementCount()).isEqualTo(5L);
    assertThat(settings.getMaxOutstandingElementCount()).isEqualTo(10L);
    assertThat(settings.getMinOutstandingElementCount()).isEqualTo(1L);
    assertThat(settings.getInitialOutstandingRequestBytes()).isEqualTo(500L);
    assertThat(settings.getMaxOutstandingRequestBytes()).isEqualTo(1000L);
    assertThat(settings.getMinOutstandingRequestBytes()).isEqualTo(100L);
  }

  @Test
  void testValidElementCountSettings() {
    DynamicFlowControlSettings.Builder builder =
        DynamicFlowControlSettings.newBuilder()
            .setInitialOutstandingElementCount(5L)
            .setMaxOutstandingElementCount(10L)
            .setMinOutstandingElementCount(1L);
    DynamicFlowControlSettings settings = builder.build();
    assertThat(settings.getInitialOutstandingElementCount()).isEqualTo(5L);
    assertThat(settings.getMaxOutstandingElementCount()).isEqualTo(10L);
    assertThat(settings.getMinOutstandingElementCount()).isEqualTo(1L);
  }

  @Test
  void testValidRequestByteSettings() {
    DynamicFlowControlSettings.Builder builder =
        DynamicFlowControlSettings.newBuilder()
            .setInitialOutstandingRequestBytes(500L)
            .setMaxOutstandingRequestBytes(1000L)
            .setMinOutstandingRequestBytes(100L);
    DynamicFlowControlSettings settings = builder.build();
    assertThat(settings.getInitialOutstandingRequestBytes()).isEqualTo(500L);
    assertThat(settings.getMaxOutstandingRequestBytes()).isEqualTo(1000L);
    assertThat(settings.getMinOutstandingRequestBytes()).isEqualTo(100L);
  }

  @Test
  void testInvalidPartialSettings() {
    DynamicFlowControlSettings.Builder builder =
        DynamicFlowControlSettings.newBuilder().setInitialOutstandingElementCount(1L);
    try {
      builder.build();
      fail("Did not throw an illegal state exception");
    } catch (IllegalStateException e) {
      // Expected, ignore
    }
    builder = DynamicFlowControlSettings.newBuilder().setMinOutstandingRequestBytes(1L);
    try {
      builder.build();
      fail("Did not throw an illegal state exception");
    } catch (IllegalStateException e) {
      // Expected, ignore
    }
  }

  @Test
  void testInvalidArguments() {
    testInvalidElementCount(-1, -5, 10);
    testInvalidElementCount(5, -1, 10);
    testInvalidElementCount(5, 0, 10);
    testInvalidElementCount(5, 6, 10);
    testInvalidElementCount(5, 2, 2);

    testInvalidNumberOfBytes(-1, -5, 10);
    testInvalidNumberOfBytes(5, -1, 10);
    testInvalidNumberOfBytes(5, 0, 10);
    testInvalidNumberOfBytes(5, 6, 10);
    testInvalidNumberOfBytes(5, 2, 2);
  }

  private void testInvalidElementCount(long initial, long min, long max) {
    DynamicFlowControlSettings.Builder builder =
        DynamicFlowControlSettings.newBuilder()
            .setInitialOutstandingElementCount(initial)
            .setMinOutstandingElementCount(min)
            .setMaxOutstandingElementCount(max);
    try {
      builder.build();
      fail("Did not throw an illegal state exception");
    } catch (IllegalStateException e) {
      // Expected, ignore
    }
  }

  private void testInvalidNumberOfBytes(long initial, long min, long max) {
    DynamicFlowControlSettings.Builder builder =
        DynamicFlowControlSettings.newBuilder()
            .setInitialOutstandingRequestBytes(initial)
            .setMinOutstandingRequestBytes(min)
            .setMaxOutstandingRequestBytes(max);
    try {
      builder.build();
      fail("Did not throw an illegal state exception");
    } catch (IllegalStateException e) {
      // Expected, ignore
    }
  }
}
