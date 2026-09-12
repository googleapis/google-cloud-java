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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Thread-safe tracker and dispatcher for resumable upload progress and state transitions.
 *
 * <p>Enforces monotonic progress reporting, isolates listeners from upload pipeline failures,
 * serializes callbacks per listener, and manages transition to terminal states.
 */
@NullMarked
class UploadProgressTracker {

  private static final Logger LOG = Logger.getLogger(UploadProgressTracker.class.getName());

  private static final class RegisteredListener {
    final ResumableUploadProgressListener listener;
    final Executor sequentialExecutor;

    RegisteredListener(ResumableUploadProgressListener listener, Executor executor) {
      this.listener = listener;
      this.sequentialExecutor = MoreExecutors.newSequentialExecutor(executor);
    }
  }

  private final Object lock = new Object();

  @GuardedBy("lock")
  private final List<RegisteredListener> listeners = new ArrayList<>();

  @GuardedBy("lock")
  private ResumableUploadStatus currentStatus;

  @GuardedBy("lock")
  private boolean terminal;

  @GuardedBy("lock")
  private @Nullable String uploadSessionUrl;

  UploadProgressTracker() {
    this.currentStatus =
        ResumableUploadStatus.newBuilder()
            .setState(ResumableUploadStatus.State.STARTING)
            .setBytesUploaded(0L)
            .build();
  }

  void addListener(ResumableUploadProgressListener listener, Executor executor) {
    checkNotNull(listener, "listener must not be null");
    checkNotNull(executor, "executor must not be null");
    RegisteredListener entry = new RegisteredListener(listener, executor);
    ResumableUploadStatus snapshot;
    synchronized (lock) {
      snapshot = this.currentStatus;
      if (!terminal) {
        listeners.add(entry);
      }
    }
    entry.sequentialExecutor.execute(() -> dispatchSafely(listener, snapshot));
  }

  ResumableUploadStatus getStatus() {
    synchronized (lock) {
      return currentStatus;
    }
  }

  void onStarted(String uploadUrl) {
    checkNotNull(uploadUrl, "uploadUrl must not be null");
    synchronized (lock) {
      this.uploadSessionUrl = uploadUrl;
      ResumableUploadStatus status =
          currentStatus.toBuilder()
              .setState(ResumableUploadStatus.State.STARTED)
              .setUploadUrl(uploadUrl)
              .build();
      updateStatusLocked(status);
    }
  }

  void onChunkUploaded(long bytesUploaded) {
    synchronized (lock) {
      if (terminal) {
        return;
      }
      long bytes = Math.max(currentStatus.getBytesUploaded(), bytesUploaded);
      ResumableUploadStatus status =
          currentStatus.toBuilder()
              .setState(ResumableUploadStatus.State.UPLOADING)
              .setBytesUploaded(bytes)
              .setUploadUrl(uploadSessionUrl)
              .build();
      updateStatusLocked(status);
    }
  }

  void onRecovering(@Nullable Throwable cause) {
    synchronized (lock) {
      if (terminal) {
        return;
      }
      ResumableUploadStatus status =
          currentStatus.toBuilder()
              .setState(ResumableUploadStatus.State.RECOVERING)
              .setException(cause)
              .setUploadUrl(uploadSessionUrl)
              .build();
      updateStatusLocked(status);
    }
  }

  void onOffsetReceived(long committedOffset) {
    synchronized (lock) {
      if (terminal) {
        return;
      }
      long bytes = Math.max(currentStatus.getBytesUploaded(), committedOffset);
      ResumableUploadStatus status =
          currentStatus.toBuilder()
              .setState(ResumableUploadStatus.State.OFFSET_RECEIVED)
              .setBytesUploaded(bytes)
              .setUploadUrl(uploadSessionUrl)
              .build();
      updateStatusLocked(status);
    }
  }

  void onFinalized(long totalBytes) {
    synchronized (lock) {
      if (terminal) {
        return;
      }
      terminal = true;
      long bytes = Math.max(currentStatus.getBytesUploaded(), totalBytes);
      ResumableUploadStatus status =
          currentStatus.toBuilder()
              .setState(ResumableUploadStatus.State.FINALIZED)
              .setBytesUploaded(bytes)
              .setUploadUrl(uploadSessionUrl)
              .build();
      updateStatusLocked(status);
    }
  }

  void onFailed(@Nullable Throwable error, @Nullable String sessionUrl) {
    synchronized (lock) {
      if (terminal) {
        return;
      }
      terminal = true;
      String url = sessionUrl != null ? sessionUrl : uploadSessionUrl;
      ResumableUploadStatus status =
          currentStatus.toBuilder()
              .setState(ResumableUploadStatus.State.FAILED)
              .setException(error)
              .setUploadUrl(url)
              .build();
      updateStatusLocked(status);
    }
  }

  @GuardedBy("lock")
  private void updateStatusLocked(ResumableUploadStatus newStatus) {
    this.currentStatus = newStatus;
    if (newStatus.getUploadUrl() != null && this.uploadSessionUrl == null) {
      this.uploadSessionUrl = newStatus.getUploadUrl();
    }
    List<RegisteredListener> snapshot = new ArrayList<>(this.listeners);
    for (RegisteredListener entry : snapshot) {
      entry.sequentialExecutor.execute(() -> dispatchSafely(entry.listener, newStatus));
    }
  }

  private static void dispatchSafely(
      ResumableUploadProgressListener listener, ResumableUploadStatus status) {
    try {
      listener.onProgress(status);
    } catch (Throwable t) {
      LOG.log(Level.WARNING, "Exception thrown by ResumableUploadProgressListener", t);
    }
  }
}
