/*
 * Copyright 2018 Google LLC
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
package com.google.api.gax.tracing;

import com.google.api.core.InternalApi;
import com.google.api.core.ObsoleteApi;

/**
 * A base implementation of {@link ApiTracer} that does nothing. With the deprecation of Java 7
 * support, all the methods in {@link ApiTracer} are now made default, we no longer need a base
 * class that does nothing. This class should be removed once all the references to it are removed
 * in Google Cloud Client Libraries.
 *
 * <p>For internal use only.
 */
@InternalApi("For internal use by google-cloud-java clients only")
public class BaseApiTracer implements ApiTracer {
  private static final ApiTracer INSTANCE = new BaseApiTracer();

  private static final Scope NOOP_SCOPE =
      new Scope() {
        @Override
        public void close() {
          // noop
        }
      };

  protected BaseApiTracer() {}

  public static ApiTracer getInstance() {
    return INSTANCE;
  }

  @Override
  public Scope inScope() {
    return NOOP_SCOPE;
  }

  @Override
  public void operationSucceeded() {
    // noop
  }

  @Override
  public void operationCancelled() {
    // noop
  }

  @Override
  public void operationFailed(Throwable error) {
    // noop
  }

  @Override
  public void connectionSelected(String id) {
    // noop
  }

  @Override
  public void attemptStarted(int attemptNumber) {
    // noop
  }

  @Override
  public void attemptStarted(Object request, int attemptNumber) {
    attemptStarted(attemptNumber);
  }

  @Override
  public void attemptSucceeded() {
    // noop
  }

  @Override
  public void attemptCancelled() {
    // noop
  }

  /**
   * This method is obsolete. Use {@link #attemptFailedDuration(Throwable, java.time.Duration)}
   * instead.
   */
  @Override
  @ObsoleteApi("Use attemptFailedDuration(Throwable, java.time.Duration) instead")
  public void attemptFailed(Throwable error, org.threeten.bp.Duration delay) {
    // noop
  }

  @Override
  public void attemptFailedRetriesExhausted(Throwable error) {
    // noop
  }

  @Override
  public void attemptPermanentFailure(Throwable error) {
    // noop

  }

  @Override
  public void lroStartFailed(Throwable error) {
    // noop
  }

  @Override
  public void lroStartSucceeded() {
    // noop
  }

  @Override
  public void responseReceived() {
    // noop
  }

  @Override
  public void requestSent() {
    // noop
  }

  @Override
  public void batchRequestSent(long elementCount, long requestSize) {
    // noop
  }
}
