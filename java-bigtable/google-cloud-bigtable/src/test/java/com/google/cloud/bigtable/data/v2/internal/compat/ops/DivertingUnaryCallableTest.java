/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.internal.compat.ops;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.ClientConfiguration;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import io.grpc.Deadline;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.io.Closeable;
import java.time.Duration;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Pins the status mapping the session path presents to the application.
 *
 * <p>{@link DivertingUnaryCallable#translateException} is the only place the session path converts
 * a failure into the caller's exception. A throwable that carries a {@link StatusException}/{@link
 * StatusRuntimeException} keeps its code; anything else has to be classified from its type, and
 * only what cannot be classified is reported as UNKNOWN. These tests pin that mapping.
 */
class DivertingUnaryCallableTest {

  private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

  /**
   * translateException reads no instance state, so a field-less instance is enough to exercise it
   * directly. The end-to-end tests below build a fully wired callable instead.
   */
  private final DivertingUnaryCallable<String, String> bare =
      new DivertingUnaryCallable<>(null, null, null, DEFAULT_TIMEOUT);

  private static Status.Code codeOf(ApiException e) {
    return ((GrpcStatusCode) e.getStatusCode()).getTransportCode();
  }

  @Test
  void translateException_illegalStateBecomesInternal() {
    // Verifies that a violated client-side invariant is reported as INTERNAL rather than UNKNOWN.
    // IllegalStateException is the shape thrown by SessionList ("NEW session was closed", "double
    // close"), DebugTagTracer, and UnaryResponseFuture's OK-without-message branch. None of them
    // carry a grpc Status, but all of them mean the same thing: a bug on the client side.
    ApiException translated = bare.translateException(new IllegalStateException("double close"));

    assertThat(codeOf(translated)).isEqualTo(Status.Code.INTERNAL);
    assertThat(translated).hasMessageThat().contains("double close");
  }

  @Test
  void translateException_rejectedExecutionBecomesResourceExhausted() {
    // Verifies that an executor refusing work is reported as RESOURCE_EXHAUSTED. A saturated or
    // shutting-down executor is the other realistic non-Status throwable on this path;
    // SessionPoolMap's javadoc calls it out explicitly.
    ApiException translated =
        bare.translateException(new RejectedExecutionException("executor saturated"));

    assertThat(codeOf(translated)).isEqualTo(Status.Code.RESOURCE_EXHAUSTED);
  }

  @Test
  void translateException_unclassifiableThrowableBecomesUnknown() {
    // Verifies that UNKNOWN is now reserved for types that genuinely say nothing about the failure.
    ApiException translated = bare.translateException(new RuntimeException("something else"));

    assertThat(codeOf(translated)).isEqualTo(Status.Code.UNKNOWN);
  }

  @Test
  void translateException_classifiesOutermostRecognizedTypeFirst() {
    // Verifies the precedence between two classifiable types in one chain: outermost wins, matching
    // how a carried Status is found.
    ApiException rejectedOutside =
        bare.translateException(
            new RejectedExecutionException(
                "executor saturated", new IllegalStateException("double close")));
    ApiException illegalStateOutside =
        bare.translateException(
            new IllegalStateException(
                "double close", new RejectedExecutionException("executor saturated")));

    assertThat(codeOf(rejectedOutside)).isEqualTo(Status.Code.RESOURCE_EXHAUSTED);
    assertThat(codeOf(illegalStateOutside)).isEqualTo(Status.Code.INTERNAL);
  }

  @Test
  void translateException_retainsOriginalThrowableAsCause() {
    // Verifies the original throwable is preserved in the exception chain, not just described in
    // the message.
    IllegalStateException original = new IllegalStateException("double close");

    ApiException translated = bare.translateException(original);

    assertThat(translated).hasCauseThat().isSameInstanceAs(original);
  }

  @Test
  void translateException_statusRuntimeExceptionKeepsItsCode() {
    // Verifies the normal error path is untouched: a carried Status keeps its code.
    ApiException translated =
        bare.translateException(
            Status.DEADLINE_EXCEEDED.withDescription("too slow").asRuntimeException());

    assertThat(codeOf(translated)).isEqualTo(Status.Code.DEADLINE_EXCEEDED);
  }

  @Test
  void translateException_statusExceptionKeepsItsCode() {
    // Verifies the checked variant of the same, which arrives from a different grpc entry point.
    ApiException translated =
        bare.translateException(Status.UNAVAILABLE.withDescription("no session").asException());

    assertThat(codeOf(translated)).isEqualTo(Status.Code.UNAVAILABLE);
  }

  @Test
  void translateException_unwrapsCompletionAndExecutionException() {
    // Verifies the two wrappers the async plumbing adds are both seen through, including nested.
    ApiException viaCompletion =
        bare.translateException(new CompletionException(Status.NOT_FOUND.asRuntimeException()));
    ApiException viaExecution =
        bare.translateException(new ExecutionException(Status.NOT_FOUND.asRuntimeException()));
    ApiException viaNested =
        bare.translateException(
            new CompletionException(new ExecutionException(Status.NOT_FOUND.asRuntimeException())));

    assertThat(codeOf(viaCompletion)).isEqualTo(Status.Code.NOT_FOUND);
    assertThat(codeOf(viaExecution)).isEqualTo(Status.Code.NOT_FOUND);
    assertThat(codeOf(viaNested)).isEqualTo(Status.Code.NOT_FOUND);
  }

  @Test
  void translateException_findsStatusDeepInCauseChain() {
    // Verifies a Status is found at any depth. Unwrapping used to stop at Completion/
    // ExecutionException, so a StatusRuntimeException wrapped in anything else lost its code.
    ApiException oneDeep =
        bare.translateException(
            new RuntimeException("wrapper", Status.DEADLINE_EXCEEDED.asRuntimeException()));
    ApiException threeDeep =
        bare.translateException(
            new IllegalStateException(
                "outer",
                new RuntimeException(
                    "middle",
                    new IllegalArgumentException("inner", Status.ABORTED.asException()))));

    assertThat(codeOf(oneDeep)).isEqualTo(Status.Code.DEADLINE_EXCEEDED);
    assertThat(codeOf(threeDeep)).isEqualTo(Status.Code.ABORTED);
  }

  @Test
  void translateException_cancellationExceptionBecomesCancelled() {
    // Verifies CancellationException maps to CANCELLED, the same code the classic path reports for
    // it via csm.attributes.Util#extractStatus. The two used to disagree, so the same failure got a
    // different code depending on whether sessionLoad happened to divert the request.
    ApiException translated = bare.translateException(new CancellationException("caller gave up"));

    assertThat(codeOf(translated)).isEqualTo(Status.Code.CANCELLED);
  }

  @Test
  void translateException_findsCancellationDeepInCauseChain() {
    // Verifies a wrapped cancellation is still CANCELLED. This is stricter than
    // csm.attributes.Util#extractStatus, which only checks the top level, so a nested cancellation
    // is CANCELLED here and UNKNOWN on the classic path.
    ApiException translated =
        bare.translateException(
            new IllegalStateException("wrapper", new CancellationException("caller gave up")));

    assertThat(codeOf(translated)).isEqualTo(Status.Code.CANCELLED);
  }

  @Test
  void translateException_statusOutranksCancellationAtTheSameDepth() {
    // Verifies the walk order between the two: outermost wins, whichever it is.
    CancellationException outer = new CancellationException("caller gave up");
    outer.initCause(Status.DEADLINE_EXCEEDED.asRuntimeException());

    ApiException cancellationOutside = bare.translateException(outer);
    ApiException statusOutside =
        bare.translateException(
            Status.DEADLINE_EXCEEDED
                .withCause(new CancellationException("caller gave up"))
                .asRuntimeException());

    assertThat(codeOf(cancellationOutside)).isEqualTo(Status.Code.CANCELLED);
    assertThat(codeOf(statusOutside)).isEqualTo(Status.Code.DEADLINE_EXCEEDED);
  }

  @Test
  void translateException_toleratesSelfReferentialCauseChain() {
    // Verifies a throwable that is its own cause does not spin the walk.
    SelfCausedException looping = new SelfCausedException();

    ApiException translated = bare.translateException(looping);

    assertThat(codeOf(translated)).isEqualTo(Status.Code.UNKNOWN);
  }

  @Test
  void translateException_messageNamesTheCauseChain() {
    // Verifies the message identifies the failure by itself. Without it the caller gets a code and
    // nothing else, which is all that reaches CSM, their error counters, or a support case.
    ApiException translated =
        bare.translateException(
            new IllegalStateException(
                "Unary rpc completed OK but missing result",
                new RejectedExecutionException("executor saturated")));

    assertThat(codeOf(translated)).isEqualTo(Status.Code.INTERNAL);
    assertThat(translated).hasMessageThat().contains("INTERNAL");
    assertThat(translated).hasMessageThat().contains("java.lang.IllegalStateException");
    assertThat(translated)
        .hasMessageThat()
        .contains("java.util.concurrent.RejectedExecutionException");
    assertThat(translated).hasMessageThat().contains("Unary rpc completed OK but missing result");
  }

  @Test
  void translateException_messageSurvivesNullCauseMessage() {
    // Verifies the chain still identifies the throwable when it has no message of its own, as a
    // NullPointerException usually does not.
    ApiException translated = bare.translateException(new NullPointerException());

    assertThat(codeOf(translated)).isEqualTo(Status.Code.UNKNOWN);
    assertThat(translated).hasMessageThat().contains("java.lang.NullPointerException");
  }

  @Test
  void translateException_nullThrowableStillProducesUnknown() {
    // Verifies the diagnostic path itself cannot throw. CompletableFuture#handle never hands us a
    // null, but an NPE raised while *building* the error message would replace the very failure
    // the message exists to report.
    ApiException translated = bare.translateException(null);

    assertThat(codeOf(translated)).isEqualTo(Status.Code.UNKNOWN);
    assertThat(translated).hasMessageThat().contains("null error");
  }

  @Test
  void futureCall_shimFailureWithNonStatusThrowableSurfacesAsInternal() {
    // Verifies the mapping end to end: a shim future that fails with a statusless throwable reaches
    // the application through the real futureCall plumbing, not just translateException.
    DivertingUnaryCallable<String, String> callable =
        newCallable(
            (request, deadline) -> {
              CompletableFuture<String> f = new CompletableFuture<>();
              f.completeExceptionally(new IllegalStateException("double close"));
              return f;
            });

    ApiException surfaced = failureOf(callable.futureCall("req", GrpcCallContext.createDefault()));

    assertThat(codeOf(surfaced)).isEqualTo(Status.Code.INTERNAL);
  }

  @Test
  void futureCall_sessionPoolMapSyncThrowSurfacesAsInternal() {
    // Verifies the full seam: TableBase.readRow throws synchronously on the caller thread ->
    // SessionPoolMap.apply's `catch (Throwable)` converts it to a failed future ->
    // translateException
    // classifies it. No grpc Status is involved at any point, so the code comes entirely from the
    // throwable's type.
    SessionPoolMap<String, NoopHandle> poolMap = new SessionPoolMap<>(key -> new NoopHandle());
    DivertingUnaryCallable<String, String> callable =
        newCallable(
            (request, deadline) ->
                poolMap.apply(
                    "table",
                    handle -> {
                      throw new IllegalStateException("NEW session was closed");
                    }));

    ApiException surfaced = failureOf(callable.futureCall("req", GrpcCallContext.createDefault()));

    assertThat(codeOf(surfaced)).isEqualTo(Status.Code.INTERNAL);
    assertThat(surfaced).hasCauseThat().isNotNull();
  }

  @Test
  void futureCall_sessionPoolMapStatusThrowKeepsItsCode() {
    // Verifies the same seam is not itself lossy: a throw that already carries a Status keeps it.
    SessionPoolMap<String, NoopHandle> poolMap = new SessionPoolMap<>(key -> new NoopHandle());
    DivertingUnaryCallable<String, String> callable =
        newCallable(
            (request, deadline) ->
                poolMap.apply(
                    "table",
                    handle -> {
                      throw Status.UNAVAILABLE.withDescription("pool wedged").asRuntimeException();
                    }));

    ApiException surfaced = failureOf(callable.futureCall("req", GrpcCallContext.createDefault()));

    assertThat(codeOf(surfaced)).isEqualTo(Status.Code.UNAVAILABLE);
  }

  private static DivertingUnaryCallable<String, String> newCallable(ShimFn shim) {
    ClientConfiguration.Builder config = ClientConfiguration.newBuilder();
    config.getSessionConfigurationBuilder().setSessionLoad(1.0f);

    ClientConfigurationManager configManager = Mockito.mock(ClientConfigurationManager.class);
    Mockito.when(configManager.getClientConfiguration()).thenReturn(config.build());

    return new DivertingUnaryCallable<>(configManager, new FailingClassic(), shim, DEFAULT_TIMEOUT);
  }

  /** Extracts the ApiException the application would observe from {@code future.get()}. */
  private static ApiException failureOf(ApiFuture<String> future) {
    ExecutionException ee =
        assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
    assertThat(ee).hasCauseThat().isInstanceOf(ApiException.class);
    return (ApiException) ee.getCause();
  }

  /** sessionLoad is pinned to 1.0 in these tests, so the classic path must never be taken. */
  private static final class FailingClassic extends UnaryCallable<String, String> {
    @Override
    public ApiFuture<String> futureCall(String request, ApiCallContext context) {
      throw new AssertionError("classic path taken despite sessionLoad=1.0");
    }
  }

  private static final class NoopHandle implements Closeable {
    @Override
    public void close() {}
  }

  /** Its own cause — exercises the cycle guard in the cause walk. */
  private static final class SelfCausedException extends RuntimeException {
    @Override
    public synchronized Throwable getCause() {
      return this;
    }
  }

  /**
   * UnaryShim extends Closeable, so it has two abstract methods and cannot be a lambda target on
   * its own. Defaulting close() away makes call() the single abstract method.
   */
  @FunctionalInterface
  private interface ShimFn extends UnaryShim<String, String> {
    @Override
    CompletableFuture<String> call(String request, Deadline deadline);

    @Override
    default void close() {}
  }
}
