/*
 * Copyright 2016 Google LLC
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

import java.util.concurrent.ScheduledExecutorService;

/** FixedExecutorProvider is an ExecutorProvider which always returns the same executor. */
public final class FixedExecutorProvider implements ExecutorProvider {

  private final ScheduledExecutorService executor;
  private final boolean autoClose;

  private FixedExecutorProvider(ScheduledExecutorService executor, boolean autoClose) {
    this.executor = executor;
    this.autoClose = autoClose;
  }

  @Override
  public ScheduledExecutorService getExecutor() {
    return executor;
  }

  @Override
  public boolean shouldAutoClose() {
    return autoClose;
  }

  /** Creates a FixedExecutorProvider. */
  public static FixedExecutorProvider create(ScheduledExecutorService executor) {
    return new FixedExecutorProvider(executor, false);
  }

  /** Create a FixedExecutorProvider and specify if it should auto close. */
  public static FixedExecutorProvider create(ScheduledExecutorService executor, boolean autoClose) {
    return new FixedExecutorProvider(executor, autoClose);
  }
}
