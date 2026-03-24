/*
 * Copyright 2024 Google LLC
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
package com.google.api.gax.httpjson.testing;

import com.google.api.gax.tracing.ApiTracer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.threeten.bp.Duration;

/**
 * Test tracer that keeps count of different events. See {@link TestApiTracerFactory} for more
 * details.
 */
public class TestApiTracer implements ApiTracer {

  private final AtomicInteger attemptsStarted = new AtomicInteger();
  private final AtomicInteger attemptsFailed = new AtomicInteger();
  private final AtomicBoolean retriesExhausted = new AtomicBoolean(false);

  public TestApiTracer() {}

  public AtomicInteger getAttemptsStarted() {
    return attemptsStarted;
  }

  public AtomicInteger getAttemptsFailed() {
    return attemptsFailed;
  }

  public AtomicBoolean getRetriesExhausted() {
    return retriesExhausted;
  }

  @Override
  public void attemptStarted(int attemptNumber) {
    attemptsStarted.incrementAndGet();
  }

  @Override
  public void attemptStarted(Object request, int attemptNumber) {
    attemptsStarted.incrementAndGet();
  }

  @Override
  public void attemptFailed(Throwable error, Duration delay) {
    attemptsFailed.incrementAndGet();
  }

  @Override
  public void attemptFailedRetriesExhausted(Throwable error) {
    attemptsFailed.incrementAndGet();
    retriesExhausted.set(true);
  }
}
;
