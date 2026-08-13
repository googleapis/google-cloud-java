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

import org.junit.jupiter.api.Test;

public class ResumableUploadCallSettingsTest {

  @Test
  public void testDefaultChunkSizeInBuilder() {
    ResumableUploadCallSettings settings = ResumableUploadCallSettings.newBuilder().build();

    assertEquals(8 * 1024 * 1024, settings.getChunkSize());
  }

  @Test
  public void testCustomInitialization() {
    ResumableUploadCallSettings settings =
        ResumableUploadCallSettings.newBuilder().setChunkSize(16 * 1024 * 1024).build();

    assertEquals(16 * 1024 * 1024, settings.getChunkSize());
  }

  @Test
  public void testMerge_NullSettings() {
    ResumableUploadCallSettings stubSettings =
        ResumableUploadCallSettings.newBuilder().setChunkSize(4 * 1024 * 1024).build();

    ResumableUploadCallSettings merged = stubSettings.merge(null);

    assertSame(stubSettings, merged);
  }

  @Test
  public void testMerge_SettingsOverrides() {
    ResumableUploadCallSettings stubSettings =
        ResumableUploadCallSettings.newBuilder().setChunkSize(4 * 1024 * 1024).build();

    ResumableUploadCallSettings perRequestSettings =
        ResumableUploadCallSettings.newBuilder().setChunkSize(32 * 1024 * 1024).build();

    ResumableUploadCallSettings merged = stubSettings.merge(perRequestSettings);

    // Chunk size overridden by Tier-1 per-request settings
    assertEquals(32 * 1024 * 1024, merged.getChunkSize());
  }
}
