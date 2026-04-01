/*
 * Copyright 2017 Google LLC
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
package com.google.api.gax.core;

import java.util.concurrent.TimeUnit;

/**
 * Represents a resource running in the background that needs to be shut down for resources to be
 * released.
 */
public interface BackgroundResource extends AutoCloseable {

  /**
   * Initiates an orderly shutdown in which previously submitted work is finished, but no new work
   * will be accepted. Invocation has no additional effect if already shut down.
   *
   * <p>This method does not wait for previously submitted work to complete execution. Use
   * awaitTermination to do that.
   */
  void shutdown();

  /** Returns true if this background resource has been shut down. */
  boolean isShutdown();

  /**
   * Returns true if all work has completed following shut down. Note that isTerminated is never
   * true unless either shutdown or shutdownNow was called first.
   */
  boolean isTerminated();

  /**
   * Attempts to stop all actively executing work and halts the processing of waiting work.
   *
   * <p>This method does not wait for actively executing work to terminate. Use awaitTermination to
   * do that.
   *
   * <p>There are no guarantees beyond best-effort attempts to stop processing actively executing
   * work. For example, typical implementations will cancel via Thread.interrupt(), so any task that
   * fails to respond to interrupts may never terminate.
   */
  void shutdownNow();

  /**
   * Blocks until all work has completed execution after a shutdown request, or the timeout occurs,
   * or the current thread is interrupted, whichever happens first.
   */
  boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException;

  // NEXT_MAJOR_VER: override close() to remove 'throws Exception'
}
