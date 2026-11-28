/*
 * Copyright 2026 Google LLC
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
package com.google.api.gax.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import org.junit.jupiter.api.Test;

public class ResumableUploadOptionsTest {

  @Test
  public void testDefaultOptions() {
    ResumableUploadOptions options = ResumableUploadOptions.newBuilder().build();

    assertEquals(8 * 1024 * 1024, options.getChunkSize());
    assertNull(options.getGlobalTimeout());
    assertNull(options.getProgressListener());
    assertNull(options.getTransferStallMinimumRate());
    assertNull(options.getTransferStallTimeout());
    assertFalse(options.isStallControlEnabled());
  }

  @Test
  public void testCustomOptionsAndToBuilder() {
    ResumableUploadOptions options =
        ResumableUploadOptions.newBuilder()
            .setChunkSize(16 * 1024 * 1024)
            .setGlobalTimeout(Duration.ofMinutes(15))
            .setTransferStallMinimumRate(2.5)
            .setTransferStallTimeout(Duration.ofSeconds(45))
            .build();

    assertEquals(16 * 1024 * 1024, options.getChunkSize());
    assertEquals(Duration.ofMinutes(15), options.getGlobalTimeout());
    assertEquals(2.5, options.getTransferStallMinimumRate());
    assertEquals(Duration.ofSeconds(45), options.getTransferStallTimeout());
    assertTrue(options.isStallControlEnabled());
    assertEquals(options, options.toBuilder().build());
  }

  @Test
  public void testPartialStallPair_stallControlDisabled() {
    assertFalse(
        ResumableUploadOptions.newBuilder()
            .setTransferStallMinimumRate(10.0)
            .build()
            .isStallControlEnabled());
    assertFalse(
        ResumableUploadOptions.newBuilder()
            .setTransferStallTimeout(Duration.ofSeconds(30))
            .build()
            .isStallControlEnabled());
  }

  @Test
  public void testInvalidTransferStallOptions_throwsIllegalArgumentException() {
    for (double invalidRate :
        new double[] {0.0, -1.0, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY}) {
      assertThrows(
          IllegalArgumentException.class,
          () ->
              ResumableUploadOptions.newBuilder().setTransferStallMinimumRate(invalidRate).build());
    }
    assertThrows(
        IllegalArgumentException.class,
        () -> ResumableUploadOptions.newBuilder().setTransferStallTimeout(Duration.ZERO).build());
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ResumableUploadOptions.newBuilder()
                .setTransferStallTimeout(Duration.ofSeconds(-5))
                .build());
  }

  @Test
  public void testInvalidChunkSize_throwsIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> ResumableUploadOptions.newBuilder().setChunkSize(0).build());
    assertThrows(
        IllegalArgumentException.class,
        () -> ResumableUploadOptions.newBuilder().setChunkSize(-1).build());
  }

  @Test
  public void testInvalidGlobalTimeout_throwsIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> ResumableUploadOptions.newBuilder().setGlobalTimeout(Duration.ZERO).build());
    assertThrows(
        IllegalArgumentException.class,
        () -> ResumableUploadOptions.newBuilder().setGlobalTimeout(Duration.ofSeconds(-5)).build());
  }

  @Test
  public void testMerge_nullOptions_returnsSameInstance() {
    ResumableUploadOptions options =
        ResumableUploadOptions.newBuilder().setChunkSize(4 * 1024 * 1024).build();

    assertSame(options, options.merge(null));
  }

  @Test
  public void testMerge_overridesChunkSizeAndGlobalTimeout() {
    ResumableUploadOptions defaultOptions =
        ResumableUploadOptions.newBuilder()
            .setChunkSize(4 * 1024 * 1024)
            .setGlobalTimeout(Duration.ofMinutes(10))
            .build();

    ResumableUploadOptions perRequestOptions =
        ResumableUploadOptions.newBuilder()
            .setChunkSize(32 * 1024 * 1024)
            .setGlobalTimeout(Duration.ofMinutes(30))
            .build();

    ResumableUploadOptions merged = defaultOptions.merge(perRequestOptions);

    assertEquals(32 * 1024 * 1024, merged.getChunkSize());
    assertEquals(Duration.ofMinutes(30), merged.getGlobalTimeout());
  }

  @Test
  public void testMerge_nullGlobalTimeoutDoesNotOverride() {
    ResumableUploadOptions defaultOptions =
        ResumableUploadOptions.newBuilder().setGlobalTimeout(Duration.ofMinutes(10)).build();

    ResumableUploadOptions perRequestOptions =
        ResumableUploadOptions.newBuilder().setChunkSize(32 * 1024 * 1024).build();

    ResumableUploadOptions merged = defaultOptions.merge(perRequestOptions);

    assertEquals(32 * 1024 * 1024, merged.getChunkSize());
    assertEquals(Duration.ofMinutes(10), merged.getGlobalTimeout());
  }

  @Test
  public void testMerge_overridesProgressListener() {
    ResumableUploadProgressListener defaultListener = progress -> {};
    ResumableUploadProgressListener perRequestListener = progress -> {};
    ResumableUploadOptions defaultOptions =
        ResumableUploadOptions.newBuilder().setProgressListener(defaultListener).build();
    ResumableUploadOptions perRequestOptions =
        ResumableUploadOptions.newBuilder().setProgressListener(perRequestListener).build();

    ResumableUploadOptions merged = defaultOptions.merge(perRequestOptions);

    assertSame(perRequestListener, merged.getProgressListener());
  }

  @Test
  public void testMerge_nullProgressListenerDoesNotOverride() {
    ResumableUploadProgressListener defaultListener = progress -> {};
    ResumableUploadOptions defaultOptions =
        ResumableUploadOptions.newBuilder().setProgressListener(defaultListener).build();
    ResumableUploadOptions perRequestOptions = ResumableUploadOptions.newBuilder().build();

    ResumableUploadOptions merged = defaultOptions.merge(perRequestOptions);

    assertSame(defaultListener, merged.getProgressListener());
  }

  @Test
  public void testMerge_stallControlClearsDefaultGlobalTimeoutUnlessExplicitOnOverride() {
    ResumableUploadOptions defaults =
        ResumableUploadOptions.newBuilder().setGlobalTimeout(Duration.ofSeconds(5)).build();
    ResumableUploadOptions stallPair =
        ResumableUploadOptions.newBuilder()
            .setTransferStallMinimumRate(5.0)
            .setTransferStallTimeout(Duration.ofSeconds(60))
            .build();

    // 1. Enabling stall control per-call clears the default globalTimeout.
    ResumableUploadOptions mergedPerCall = defaults.merge(stallPair);
    assertTrue(mergedPerCall.isStallControlEnabled());
    assertNull(mergedPerCall.getGlobalTimeout());

    // 2. Completing the stall pair across default + per-call also clears the default globalTimeout.
    ResumableUploadOptions defaultWithRate =
        defaults.toBuilder().setTransferStallMinimumRate(5.0).build();
    ResumableUploadOptions perCallWithTimeout =
        ResumableUploadOptions.newBuilder().setTransferStallTimeout(Duration.ofSeconds(60)).build();
    ResumableUploadOptions mergedSplit = defaultWithRate.merge(perCallWithTimeout);
    assertTrue(mergedSplit.isStallControlEnabled());
    assertNull(mergedSplit.getGlobalTimeout());

    // 3. Explicit per-call globalTimeout is preserved alongside stall control.
    ResumableUploadOptions stallWithExplicitGlobal =
        stallPair.toBuilder().setGlobalTimeout(Duration.ofMinutes(30)).build();
    assertEquals(
        Duration.ofMinutes(30), defaults.merge(stallWithExplicitGlobal).getGlobalTimeout());
  }
}
