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
package com.google.api.gax.tracing;

import org.junit.jupiter.api.Test;

public class BaseApiTracerTest {

  @Test
  public void testInScope() {
    BaseApiTracer tracer = new BaseApiTracer();
    ApiTracer.Scope scope = tracer.inScope();
    scope.close();
    // No-op, so nothing to verify.
  }

  @Test
  public void testOperationSucceeded() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.operationSucceeded();
    // No-op, so nothing to verify.
  }

  @Test
  public void testOperationCancelled() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.operationCancelled();
    // No-op, so nothing to verify.
  }

  @Test
  public void testOperationFailed() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.operationFailed(new RuntimeException());
    // No-op, so nothing to verify.
  }

  @Test
  public void testConnectionSelected() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.connectionSelected("test-connection");
    // No-op, so nothing to verify.
  }

  @Test
  public void testAttemptStarted() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.attemptStarted(1);
    // No-op, so nothing to verify.
  }

  @Test
  public void testAttemptStartedWithRequest() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.attemptStarted(new Object(), 1);
    // No-op, so nothing to verify.
  }

  @Test
  public void testAttemptSucceeded() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.attemptSucceeded();
    // No-op, so nothing to verify.
  }

  @Test
  public void testAttemptCancelled() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.attemptCancelled();
    // No-op, so nothing to verify.
  }

  @Test
  public void testAttemptFailedDuration() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.attemptFailedDuration(new RuntimeException(), java.time.Duration.ofMillis(100));
    // No-op, so nothing to verify.
  }

  @Test
  public void testAttemptFailed() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.attemptFailed(new RuntimeException(), org.threeten.bp.Duration.ofMillis(100));
    // No-op, so nothing to verify.
  }

  @Test
  public void testAttemptFailedRetriesExhausted() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.attemptFailedRetriesExhausted(new RuntimeException());
    // No-op, so nothing to verify.
  }

  @Test
  public void testAttemptPermanentFailure() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.attemptPermanentFailure(new RuntimeException());
    // No-op, so nothing to verify.
  }

  @Test
  public void testLroStartFailed() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.lroStartFailed(new RuntimeException());
    // No-op, so nothing to verify.
  }

  @Test
  public void testLroStartSucceeded() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.lroStartSucceeded();
    // No-op, so nothing to verify.
  }

  @Test
  public void testResponseReceived() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.responseReceived();
    // No-op, so nothing to verify.
  }

  @Test
  public void testRequestSent() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.requestSent();
    // No-op, so nothing to verify.
  }

  @Test
  public void testBatchRequestSent() {
    BaseApiTracer tracer = new BaseApiTracer();
    tracer.batchRequestSent(10, 100);
    // No-op, so nothing to verify.
  }
}
