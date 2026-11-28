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

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Verifies that {@link CompositeTracer} still dispatches completion callbacks to all child tracers
 * when entering or closing a child's scope throws a {@link RuntimeException}.
 */
class CompositeTracerScopeFailureTest {
  private static final Throwable ERROR = new RuntimeException("rpc failed");
  private static final java.time.Duration DELAY = java.time.Duration.ofMillis(10);
  private static final org.threeten.bp.Duration THREETEN_DELAY =
      org.threeten.bp.Duration.ofMillis(10);

  private ApiTracer child1;
  private ApiTracer child2;
  private CompositeTracer compositeTracer;

  /** Initializes mock child tracers and the {@link CompositeTracer} under test. */
  @BeforeEach
  void setUp() {
    child1 = mock(ApiTracer.class, withSettings().withoutAnnotations());
    child2 = mock(ApiTracer.class, withSettings().withoutAnnotations());
    compositeTracer = new CompositeTracer(Arrays.asList(child1, child2));
  }

  /** Returns the nine completion callbacks that {@link CompositeTracer} dispatches in a scope. */
  @SuppressWarnings("deprecation") // attemptFailed(Throwable, org.threeten.bp.Duration)
  static Stream<Arguments> scopedCallbacks() {
    return Stream.of(
        callback("operationSucceeded", ApiTracer::operationSucceeded),
        callback("operationCancelled", ApiTracer::operationCancelled),
        callback("operationFailed", tracer -> tracer.operationFailed(ERROR)),
        callback("attemptSucceeded", ApiTracer::attemptSucceeded),
        callback("attemptCancelled", ApiTracer::attemptCancelled),
        callback("attemptFailed", tracer -> tracer.attemptFailed(ERROR, THREETEN_DELAY)),
        callback("attemptFailedDuration", tracer -> tracer.attemptFailedDuration(ERROR, DELAY)),
        callback(
            "attemptFailedRetriesExhausted", tracer -> tracer.attemptFailedRetriesExhausted(ERROR)),
        callback("attemptPermanentFailure", tracer -> tracer.attemptPermanentFailure(ERROR)));
  }

  /** Creates a named {@link Arguments} tuple for a parameterized callback test case. */
  private static Arguments callback(String name, Consumer<ApiTracer> invocation) {
    return Arguments.of(name, invocation);
  }

  /** Verifies all children still receive the callback when {@link ApiTracer#inScope()} throws. */
  @ParameterizedTest(name = "{0}")
  @MethodSource("scopedCallbacks")
  void callbackReachesAllChildren_whenEnteringScopeThrows(
      String name, Consumer<ApiTracer> callback) {
    when(child1.inScope()).thenThrow(new IllegalStateException("broken inScope()"));

    callback.accept(compositeTracer); // must not throw

    callback.accept(verify(child1));
    callback.accept(verify(child2));
  }

  /**
   * Verifies all children still receive the callback when {@link ApiTracer.Scope#close()} throws.
   */
  @ParameterizedTest(name = "{0}")
  @MethodSource("scopedCallbacks")
  void callbackReachesAllChildren_whenClosingScopeThrows(
      String name, Consumer<ApiTracer> callback) {
    ApiTracer.Scope brokenScope = mock(ApiTracer.Scope.class, withSettings().withoutAnnotations());
    doThrow(new IllegalStateException("broken close()")).when(brokenScope).close();
    when(child1.inScope()).thenReturn(brokenScope);

    callback.accept(compositeTracer); // must not throw

    callback.accept(verify(child1));
    callback.accept(verify(child2));
    verify(brokenScope).close();
  }
}
