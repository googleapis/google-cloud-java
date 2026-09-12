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
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jspecify.annotations.NullMarked;

/** Publishes updates to listeners on resumable upload progress and state transitions. */
@NullMarked
class ResumableUploadProgressTracker {

  private static final Logger LOG =
      Logger.getLogger(ResumableUploadProgressTracker.class.getName());

  private static final class RegisteredListener {
    final ResumableUploadProgressListener listener;
    final Executor sequentialExecutor;
    final ConcurrentLinkedQueue<ResumableUploadProgress> pendingUpdates =
        new ConcurrentLinkedQueue<>();

    RegisteredListener(ResumableUploadProgressListener listener, Executor executor) {
      this.listener = listener;
      this.sequentialExecutor = MoreExecutors.newSequentialExecutor(executor);
    }

    void drain() {
      try {
        sequentialExecutor.execute(
            () -> {
              ResumableUploadProgress status;
              while ((status = pendingUpdates.poll()) != null) {
                dispatchSafely(status);
              }
            });
      } catch (RejectedExecutionException e) {
        LOG.log(
            Level.WARNING, "Resumable upload progress listener executor rejected the update", e);
      }
    }

    private void dispatchSafely(ResumableUploadProgress status) {
      try {
        listener.onProgress(status);
      } catch (Throwable t) {
        LOG.log(Level.WARNING, "Resumable upload progress listener threw an exception", t);
      }
    }
  }

  private final Object lock = new Object();

  @GuardedBy("lock")
  private final List<RegisteredListener> listeners = new ArrayList<>();

  @GuardedBy("lock")
  private ResumableUploadProgress currentStatus;

  ResumableUploadProgressTracker() {
    this.currentStatus = ResumableUploadProgress.newBuilder().build();
  }

  void addListener(ResumableUploadProgressListener listener, Executor executor) {
    checkNotNull(listener, "listener must not be null");
    checkNotNull(executor, "executor must not be null");
    RegisteredListener entry = new RegisteredListener(listener, executor);
    synchronized (lock) {
      entry.pendingUpdates.add(this.currentStatus);
      listeners.add(entry);
    }
    entry.drain();
  }

  ResumableUploadProgress getProgress() {
    synchronized (lock) {
      return currentStatus;
    }
  }

  void onStarted(String uploadUrl) {
    checkNotNull(uploadUrl, "uploadUrl must not be null");
    transition(
        builder -> builder.setState(ResumableUploadProgress.State.STARTED).setUploadUrl(uploadUrl));
  }

  void onChunkUploaded(long bytesUploaded) {
    transition(
        builder ->
            builder
                .setState(ResumableUploadProgress.State.UPLOADING)
                .setBytesUploaded(bytesUploaded));
  }

  void onRecovering() {
    transition(builder -> builder.setState(ResumableUploadProgress.State.RECOVERING));
  }

  void onOffsetReceived(long committedOffset) {
    transition(
        builder ->
            builder
                .setState(ResumableUploadProgress.State.OFFSET_RECEIVED)
                .setBytesUploaded(committedOffset));
  }

  void onFinalized(long totalBytes) {
    transition(
        builder ->
            builder.setState(ResumableUploadProgress.State.FINALIZED).setBytesUploaded(totalBytes));
  }

  void onFailed() {
    transition(builder -> builder.setState(ResumableUploadProgress.State.FAILED));
  }

  @GuardedBy("lock")
  private boolean isTerminal() {
    ResumableUploadProgress.State state = currentStatus.getState();
    return state == ResumableUploadProgress.State.FINALIZED
        || state == ResumableUploadProgress.State.FAILED;
  }

  private void transition(Consumer<ResumableUploadProgress.Builder> statusUpdater) {
    List<RegisteredListener> snapshot;
    synchronized (lock) {
      if (isTerminal()) {
        return;
      }
      ResumableUploadProgress.Builder builder = currentStatus.toBuilder();
      statusUpdater.accept(builder);
      ResumableUploadProgress newStatus = builder.build();
      this.currentStatus = newStatus;
      for (RegisteredListener entry : this.listeners) {
        entry.pendingUpdates.add(newStatus);
      }
      snapshot = new ArrayList<>(this.listeners);
    }
    for (RegisteredListener entry : snapshot) {
      entry.drain();
    }
  }
}
