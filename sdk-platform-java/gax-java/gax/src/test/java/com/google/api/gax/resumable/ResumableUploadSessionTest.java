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
package com.google.api.gax.resumable;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResumableUploadSessionTest {

  private static final String UPLOAD_URL = "https://storage.googleapis.com/upload/session/12345";

  @Test
  void create_withUploadUrl_setsDefaultChunkGranularityToOneByte() {
    ResumableUploadSession session = ResumableUploadSession.create(UPLOAD_URL);

    assertThat(session.getUploadUrl()).isEqualTo(UPLOAD_URL);
    assertThat(session.getChunkGranularity()).isEqualTo(1L);
  }

  @Test
  void create_withExplicitChunkGranularity_preservesGranularity() {
    long customChunkGranularity = 256 * 1024L;

    ResumableUploadSession session =
        ResumableUploadSession.create(UPLOAD_URL, customChunkGranularity);

    assertThat(session.getUploadUrl()).isEqualTo(UPLOAD_URL);
    assertThat(session.getChunkGranularity()).isEqualTo(customChunkGranularity);
  }

  @ParameterizedTest
  @ValueSource(longs = {0L, -1L, -100L})
  void create_withNonPositiveChunkGranularity_normalizesToOneByte(long invalidGranularity) {
    ResumableUploadSession session =
        ResumableUploadSession.create(UPLOAD_URL, invalidGranularity);

    assertThat(session.getChunkGranularity()).isEqualTo(1L);
  }
}
