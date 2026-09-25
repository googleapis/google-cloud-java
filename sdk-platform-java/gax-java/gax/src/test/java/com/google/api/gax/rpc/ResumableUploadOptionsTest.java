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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Duration;
import org.junit.jupiter.api.Test;

public class ResumableUploadOptionsTest {

  @Test
  public void testCustomOptionsAndToBuilder() {
    ResumableUploadOptions options =
        ResumableUploadOptions.newBuilder()
            .setChunkSize(16 * 1024 * 1024)
            .setGlobalTimeout(Duration.ofMinutes(15))
            .build();

    assertEquals(16 * 1024 * 1024, options.getChunkSize());
    assertEquals(Duration.ofMinutes(15), options.getGlobalTimeout());
    assertEquals(options, options.toBuilder().build());
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
}
