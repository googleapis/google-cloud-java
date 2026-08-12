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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ResumableUploadCallSettingsTest {

  @Test
  public void testDefaultChunkSize() {
    ResumableUploadCallSettings<String, String> settings =
        ResumableUploadCallSettings.<String, String>newBuilder().build();

    assertNull(settings.getChunkSize());
    assertNull(settings.getTotalBytes());
    assertEquals(8 * 1024 * 1024, settings.getChunkSizeOrDefault());
  }

  @Test
  public void testCustomInitialization() {
    ResumableUploadCallSettings<String, String> settings =
        ResumableUploadCallSettings.<String, String>newBuilder()
            .setChunkSize(16 * 1024 * 1024)
            .setTotalBytes(100L * 1024 * 1024)
            .build();

    assertEquals(Integer.valueOf(16 * 1024 * 1024), settings.getChunkSize());
    assertEquals(16 * 1024 * 1024, settings.getChunkSizeOrDefault());
    assertEquals(Long.valueOf(100L * 1024 * 1024), settings.getTotalBytes());
  }

  @Test
  public void testMergeWith_NullPerRequestSettings() {
    ResumableUploadCallSettings<String, String> stubSettings =
        ResumableUploadCallSettings.<String, String>newBuilder()
            .setChunkSize(4 * 1024 * 1024)
            .build();

    ResumableUploadCallSettings<String, String> merged = stubSettings.mergeWith(null);

    assertSame(stubSettings, merged);
  }

  @Test
  public void testMergeWith_PerRequestOverrides() {
    ResumableUploadCallSettings<String, String> stubSettings =
        ResumableUploadCallSettings.<String, String>newBuilder()
            .setChunkSize(4 * 1024 * 1024)
            .setTotalBytes(50L * 1024 * 1024)
            .build();

    ResumableUploadCallSettings<String, String> perRequestSettings =
        ResumableUploadCallSettings.<String, String>newBuilder()
            .setChunkSize(32 * 1024 * 1024)
            .build();

    ResumableUploadCallSettings<String, String> merged = stubSettings.mergeWith(perRequestSettings);

    // Chunk size overridden by Tier-1 per-request settings
    assertEquals(Integer.valueOf(32 * 1024 * 1024), merged.getChunkSize());
    // Total bytes preserved from Tier-2 stub-level settings
    assertEquals(Long.valueOf(50L * 1024 * 1024), merged.getTotalBytes());
  }
}
