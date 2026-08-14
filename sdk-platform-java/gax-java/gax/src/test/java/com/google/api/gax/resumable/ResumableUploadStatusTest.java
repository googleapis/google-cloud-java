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
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

class ResumableUploadStatusTest {

  private static final String UPLOAD_URL = "https://storage.googleapis.com/upload/session/12345";

  @Test
  void status_enforcesBoundsAndInvariants() {
    // Valid status: bytesUploaded >= 0, totalBytes == -1 (unknown / indeterminate)
    ResumableUploadStatus streamingStatus =
        ResumableUploadStatus.create(
            UPLOAD_URL, 500L, -1L, ResumableUploadStatus.State.UPLOADING);
    assertThat(streamingStatus.getBytesUploaded()).isEqualTo(500L);
    assertThat(streamingStatus.getTotalBytes()).isEqualTo(-1L);
    assertThat(streamingStatus.hasTotalBytes()).isFalse();
    assertThat(streamingStatus.isCompleted()).isFalse();
    assertThat(streamingStatus.isDone()).isFalse();

    // Valid status: known totalBytes with bytesUploaded <= totalBytes
    ResumableUploadStatus knownStatus =
        ResumableUploadStatus.create(
            UPLOAD_URL, 1000L, 2000L, ResumableUploadStatus.State.UPLOADING);
    assertThat(knownStatus.getBytesUploaded()).isEqualTo(1000L);
    assertThat(knownStatus.getTotalBytes()).isEqualTo(2000L);
    assertThat(knownStatus.hasTotalBytes()).isTrue();
    assertThat(knownStatus.isCompleted()).isFalse();
    assertThat(knownStatus.isDone()).isFalse();

    // Invalid: negative bytesUploaded
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ResumableUploadStatus.create(
                UPLOAD_URL, -1L, 1000L, ResumableUploadStatus.State.UPLOADING));

    // Invalid: totalBytes < -1
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ResumableUploadStatus.create(
                UPLOAD_URL, 0L, -2L, ResumableUploadStatus.State.STARTING));

    // Invalid: bytesUploaded > totalBytes when totalBytes >= 0
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ResumableUploadStatus.create(
                UPLOAD_URL, 2001L, 2000L, ResumableUploadStatus.State.UPLOADING));
  }

  @Test
  void status_terminalAndCompletionStates() {
    ResumableUploadStatus starting =
        ResumableUploadStatus.create(null, 0L, 1000L, ResumableUploadStatus.State.STARTING);
    assertThat(starting.isCompleted()).isFalse();
    assertThat(starting.isDone()).isFalse();

    ResumableUploadStatus uploading =
        ResumableUploadStatus.create(UPLOAD_URL, 500L, 1000L, ResumableUploadStatus.State.UPLOADING);
    assertThat(uploading.isCompleted()).isFalse();
    assertThat(uploading.isDone()).isFalse();

    ResumableUploadStatus recovering =
        ResumableUploadStatus.create(UPLOAD_URL, 500L, 1000L, ResumableUploadStatus.State.RECOVERING);
    assertThat(recovering.isCompleted()).isFalse();
    assertThat(recovering.isDone()).isFalse();

    ResumableUploadStatus finalized =
        ResumableUploadStatus.create(UPLOAD_URL, 1000L, 1000L, ResumableUploadStatus.State.FINALIZED);
    assertThat(finalized.isCompleted()).isTrue();
    assertThat(finalized.isDone()).isTrue();

    ResumableUploadStatus failed =
        ResumableUploadStatus.builder()
            .setUploadUrl(UPLOAD_URL)
            .setBytesUploaded(500L)
            .setTotalBytes(1000L)
            .setState(ResumableUploadStatus.State.FAILED)
            .setException(new IOException("connection reset"))
            .build();
    assertThat(failed.isCompleted()).isFalse();
    assertThat(failed.isDone()).isTrue();
    assertThat(failed.getException()).hasMessageThat().contains("connection reset");
  }

  @Test
  void status_builderAndToBuilderSupport() {
    ResumableUploadStatus initial =
        ResumableUploadStatus.builder()
            .setUploadUrl(UPLOAD_URL)
            .setBytesUploaded(0L)
            .setTotalBytes(5000L)
            .setState(ResumableUploadStatus.State.STARTING)
            .build();

    assertThat(initial.getState()).isEqualTo(ResumableUploadStatus.State.STARTING);
    assertThat(initial.getBytesUploaded()).isEqualTo(0L);
    assertThat(initial.hasTotalBytes()).isTrue();

    Exception recoverableError = new IOException("timeout");
    ResumableUploadStatus recovering =
        initial.toBuilder()
            .setBytesUploaded(2500L)
            .setState(ResumableUploadStatus.State.RECOVERING)
            .setException(recoverableError)
            .build();

    assertThat(recovering.getBytesUploaded()).isEqualTo(2500L);
    assertThat(recovering.getState()).isEqualTo(ResumableUploadStatus.State.RECOVERING);
    assertThat(recovering.getException()).isSameInstanceAs(recoverableError);
  }

  @Test
  void progressListener_dispatchesStatusSnapshot() {
    AtomicReference<ResumableUploadStatus> capturedStatus = new AtomicReference<>();
    ResumableUploadProgressListener listener = capturedStatus::set;

    ResumableUploadStatus status =
        ResumableUploadStatus.create(
            UPLOAD_URL, 1024L, 2048L, ResumableUploadStatus.State.UPLOADING);
    listener.onProgress(status);

    assertThat(capturedStatus.get()).isEqualTo(status);
    assertThat(capturedStatus.get().getBytesUploaded()).isEqualTo(1024L);
    assertThat(capturedStatus.get().getTotalBytes()).isEqualTo(2048L);
  }
}
