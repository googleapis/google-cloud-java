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
package com.google.api.gax.tracing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

class CompositeTracerTest {

  private ApiTracer child1;
  private ApiTracer child2;
  private CompositeTracer compositeTracer;

  @BeforeEach
  void setUp() {
    child1 = mock(ApiTracer.class);
    child2 = mock(ApiTracer.class);
    compositeTracer = new CompositeTracer(Arrays.asList(child1, child2));
  }

  @Test
  void testInScope_lifoOrder() {
    ApiTracer.Scope scope1 = mock(ApiTracer.Scope.class);
    ApiTracer.Scope scope2 = mock(ApiTracer.Scope.class);

    when(child1.inScope()).thenReturn(scope1);
    when(child2.inScope()).thenReturn(scope2);

    ApiTracer.Scope compositeScope = compositeTracer.inScope();
    compositeScope.close();

    verify(child1).inScope();
    verify(child2).inScope();

    InOrder inOrder = inOrder(scope2, scope1);
    inOrder.verify(scope2).close();
    inOrder.verify(scope1).close();
  }

  @Test
  void testInScope_childInScopeThrows() {
    ApiTracer.Scope scope1 = mock(ApiTracer.Scope.class);
    RuntimeException exception = new RuntimeException("Runtime Error");

    when(child1.inScope()).thenReturn(scope1);
    when(child2.inScope()).thenThrow(exception);

    RuntimeException thrown = assertThrows(RuntimeException.class, () -> compositeTracer.inScope());

    assertEquals(exception, thrown);
    verify(child1).inScope();
    verify(child2).inScope();
    verify(scope1).close();
  }

  @Test
  void testInScope_childScopeCloseThrows() {
    ApiTracer.Scope scope1 = mock(ApiTracer.Scope.class);
    ApiTracer.Scope scope2 = mock(ApiTracer.Scope.class);

    RuntimeException exception2 = new RuntimeException("Scope 2 close Error");
    RuntimeException exception1 = new RuntimeException("Scope 1 close Error");

    when(child1.inScope()).thenReturn(scope1);
    when(child2.inScope()).thenReturn(scope2);

    doThrow(exception2).when(scope2).close();
    doThrow(exception1).when(scope1).close();

    ApiTracer.Scope compositeScope = compositeTracer.inScope();

    RuntimeException thrown = assertThrows(RuntimeException.class, () -> compositeScope.close());

    assertEquals(exception2, thrown);
    assertTrue(Arrays.asList(thrown.getSuppressed()).contains(exception1));

    InOrder inOrder = inOrder(scope2, scope1);
    inOrder.verify(scope2).close();
    inOrder.verify(scope1).close();
  }

  @Test
  void testOperationSucceeded() {
    compositeTracer.operationSucceeded();
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).operationSucceeded();
    inOrder.verify(child1).operationSucceeded();
  }

  @Test
  void testOperationCancelled() {
    compositeTracer.operationCancelled();
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).operationCancelled();
    inOrder.verify(child1).operationCancelled();
  }

  @Test
  void testOperationFailed() {
    Throwable error = new RuntimeException("test error");
    compositeTracer.operationFailed(error);
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).operationFailed(error);
    inOrder.verify(child1).operationFailed(error);
  }

  @Test
  void testConnectionSelected() {
    String id = "connection_id_1";
    compositeTracer.connectionSelected(id);
    verify(child1).connectionSelected(id);
    verify(child2).connectionSelected(id);
  }

  @Test
  @SuppressWarnings("deprecation")
  void testAttemptStartedDeprecated() {
    compositeTracer.attemptStarted(2);
    verify(child1).attemptStarted(2);
    verify(child2).attemptStarted(2);
  }

  @Test
  void testAttemptStarted() {
    Object request = new Object();
    compositeTracer.attemptStarted(request, 3);
    verify(child1).attemptStarted(request, 3);
    verify(child2).attemptStarted(request, 3);
  }

  @Test
  void testAttemptSucceeded() {
    compositeTracer.attemptSucceeded();
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).attemptSucceeded();
    inOrder.verify(child1).attemptSucceeded();
  }

  @Test
  void testAttemptCancelled() {
    compositeTracer.attemptCancelled();
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).attemptCancelled();
    inOrder.verify(child1).attemptCancelled();
  }

  @Test
  @SuppressWarnings("deprecation")
  void testAttemptFailedDeprecated() {
    Throwable error = new RuntimeException("test error");
    org.threeten.bp.Duration delay = org.threeten.bp.Duration.ofSeconds(1);
    compositeTracer.attemptFailed(error, delay);
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).attemptFailed(error, delay);
    inOrder.verify(child1).attemptFailed(error, delay);
  }

  @Test
  void testAttemptFailedDuration() {
    Throwable error = new RuntimeException("test error");
    java.time.Duration delay = java.time.Duration.ofSeconds(1);
    compositeTracer.attemptFailedDuration(error, delay);
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).attemptFailedDuration(error, delay);
    inOrder.verify(child1).attemptFailedDuration(error, delay);
  }

  @Test
  void testAttemptFailedRetriesExhausted() {
    Throwable error = new RuntimeException("test error");
    compositeTracer.attemptFailedRetriesExhausted(error);
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).attemptFailedRetriesExhausted(error);
    inOrder.verify(child1).attemptFailedRetriesExhausted(error);
  }

  @Test
  void testAttemptPermanentFailure() {
    Throwable error = new RuntimeException("test error");
    compositeTracer.attemptPermanentFailure(error);
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).attemptPermanentFailure(error);
    inOrder.verify(child1).attemptPermanentFailure(error);
  }

  @Test
  void testLroStartFailed() {
    Throwable error = new RuntimeException("test error");
    compositeTracer.lroStartFailed(error);
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).lroStartFailed(error);
    inOrder.verify(child1).lroStartFailed(error);
  }

  @Test
  void testLroStartSucceeded() {
    compositeTracer.lroStartSucceeded();
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).lroStartSucceeded();
    inOrder.verify(child1).lroStartSucceeded();
  }

  @Test
  void testResponseReceived() {
    compositeTracer.responseReceived();
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).responseReceived();
    inOrder.verify(child1).responseReceived();
  }

  @Test
  void testResponseHeadersReceived() {
    Map<String, Object> headers = ImmutableMap.<String, Object>of("testHeader", "testValue");
    compositeTracer.responseHeadersReceived(headers);
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).responseHeadersReceived(headers);
    inOrder.verify(child1).responseHeadersReceived(headers);
  }

  @Test
  void testRequestSent() {
    compositeTracer.requestSent();
    verify(child1).requestSent();
    verify(child2).requestSent();
  }

  @Test
  void testBatchRequestSent() {
    compositeTracer.batchRequestSent(10L, 100L);
    verify(child1).batchRequestSent(10L, 100L);
    verify(child2).batchRequestSent(10L, 100L);
  }
}
