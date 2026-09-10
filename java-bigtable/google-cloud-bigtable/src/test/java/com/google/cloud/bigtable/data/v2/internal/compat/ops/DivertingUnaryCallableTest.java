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
 * <p>Context: a production incident showed application-visible UNKNOWN errors with no matching
 * UNKNOWN anywhere in CSM or on the server. {@link DivertingUnaryCallable#translateException} is
 * the only place the session path converts a failure into the caller's exception, and it defaults
 * to UNKNOWN for anything that is not a {@link StatusException}/{@link StatusRuntimeException}.
 * These tests establish which throwables take that default.
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

  // ---------------------------------------------------------------------------------------------
  // (1) The mechanism: which throwables become UNKNOWN.
  // ---------------------------------------------------------------------------------------------

  @Test
  void translateException_nonStatusThrowableBecomesUnknown() {
    // IllegalStateException is the shape thrown by SessionList ("NEW session was closed", "double
    // close"), DebugTagTracer, and UnaryResponseFuture's OK-without-message branch. None of them
    // carry a grpc Status, so all of them arrive at the caller as UNKNOWN.
    ApiException translated = bare.translateException(new IllegalStateException("double close"));

    assertThat(codeOf(translated)).isEqualTo(Status.Code.UNKNOWN);
    assertThat(translated).hasMessageThat().contains("double close");
  }

  @Test
  void translateException_rejectedExecutionBecomesUnknown() {
    // A saturated or shutting-down executor is the other realistic non-Status throwable on this
    // path; SessionPoolMap's javadoc calls it out explicitly.
    ApiException translated =
        bare.translateException(new RejectedExecutionException("executor saturated"));

    assertThat(codeOf(translated)).isEqualTo(Status.Code.UNKNOWN);
  }

  @Test
  void translateException_retainsOriginalThrowableAsCause() {
    // The original is preserved in the exception chain -- what the default loses is the *status*
    // and any counter, not the throwable itself. Worth pinning so a future "just log the cause"
    // fix isn't mistaken for a complete one.
    IllegalStateException original = new IllegalStateException("double close");

    ApiException translated = bare.translateException(original);

    assertThat(translated).hasCauseThat().isSameInstanceAs(original);
  }

  // ---------------------------------------------------------------------------------------------
  // Controls: the normal error path must keep its status, or every session failure would be
  // UNKNOWN and the mapping above would be uninteresting.
  // ---------------------------------------------------------------------------------------------

  @Test
  void translateException_statusRuntimeExceptionKeepsItsCode() {
    ApiException translated =
        bare.translateException(
            Status.DEADLINE_EXCEEDED.withDescription("too slow").asRuntimeException());

    assertThat(codeOf(translated)).isEqualTo(Status.Code.DEADLINE_EXCEEDED);
  }

  @Test
  void translateException_statusExceptionKeepsItsCode() {
    ApiException translated =
        bare.translateException(Status.UNAVAILABLE.withDescription("no session").asException());

    assertThat(codeOf(translated)).isEqualTo(Status.Code.UNAVAILABLE);
  }

  @Test
  void translateException_unwrapsCompletionAndExecutionException() {
    // The async plumbing wraps failures in these two; both must be seen through.
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
    // Regression guard for the original defect: unwrapping used to stop at Completion/
    // ExecutionException, so a perfectly good StatusRuntimeException wrapped in anything else was
    // reported as UNKNOWN. The whole chain is walked now.
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
    // csm.attributes.Util#extractStatus special-cases CancellationException. Before this fix the
    // two mappings disagreed, so one failure could be CANCELLED in CSM and UNKNOWN to the caller.
    ApiException translated = bare.translateException(new CancellationException("caller gave up"));

    assertThat(codeOf(translated)).isEqualTo(Status.Code.CANCELLED);
  }

  @Test
  void translateException_findsCancellationDeepInCauseChain() {
    // A cancellation wrapped in anything other than Completion/ExecutionException would otherwise
    // fall through to UNKNOWN -- the same defect as a wrapped StatusRuntimeException. Note this is
    // strictly more specific than csm.attributes.Util#extractStatus, which only checks the top
    // level, so a nested cancellation is CANCELLED here and UNKNOWN in CSM.
    ApiException translated =
        bare.translateException(
            new IllegalStateException("wrapper", new CancellationException("caller gave up")));

    assertThat(codeOf(translated)).isEqualTo(Status.Code.CANCELLED);
  }

  @Test
  void translateException_statusOutranksCancellationAtTheSameDepth() {
    // A CancellationException wrapping a Status keeps CANCELLED -- outermost wins -- but a Status
    // wrapping a cancellation keeps the Status. Pins the walk order, which is what decides this.
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
    // A throwable that is its own cause must not spin the walk.
    SelfCausedException looping = new SelfCausedException();

    ApiException translated = bare.translateException(looping);

    assertThat(codeOf(translated)).isEqualTo(Status.Code.UNKNOWN);
  }

  // ---------------------------------------------------------------------------------------------
  // The point of the fix: an UNKNOWN must say what it actually was.
  // ---------------------------------------------------------------------------------------------

  @Test
  void translateException_unknownMessageNamesTheCauseChain() {
    // This message is the whole diagnostic value of the change. Without it, an operator sees a
    // bare UNKNOWN with no counterpart in CSM or on the server and has nothing to work from.
    ApiException translated =
        bare.translateException(
            new IllegalStateException(
                "Unary rpc completed OK but missing result",
                new RejectedExecutionException("executor saturated")));

    assertThat(codeOf(translated)).isEqualTo(Status.Code.UNKNOWN);
    assertThat(translated).hasMessageThat().contains("java.lang.IllegalStateException");
    assertThat(translated)
        .hasMessageThat()
        .contains("java.util.concurrent.RejectedExecutionException");
    assertThat(translated).hasMessageThat().contains("Unary rpc completed OK but missing result");
  }

  @Test
  void translateException_unknownMessageSurvivesNullCauseMessage() {
    // NullPointerException usually has no message; the chain must still identify it.
    ApiException translated = bare.translateException(new NullPointerException());

    assertThat(codeOf(translated)).isEqualTo(Status.Code.UNKNOWN);
    assertThat(translated).hasMessageThat().contains("java.lang.NullPointerException");
  }

  @Test
  void translateException_nullThrowableStillProducesUnknown() {
    // CompletableFuture#handle never hands us a null, so this is unreachable in production. It is
    // pinned anyway because this is the diagnostic path: an NPE raised while *building* the error
    // message would replace the failure the message exists to report.
    ApiException translated = bare.translateException(null);

    assertThat(codeOf(translated)).isEqualTo(Status.Code.UNKNOWN);
    assertThat(translated).hasMessageThat().contains("null error");
  }

  // ---------------------------------------------------------------------------------------------
  // (2) End to end: a synchronous throw below the shim reaches the application as UNKNOWN.
  // ---------------------------------------------------------------------------------------------

  @Test
  void futureCall_shimFailureWithNonStatusThrowableSurfacesAsUnknown() {
    DivertingUnaryCallable<String, String> callable =
        newCallable(
            (request, deadline) -> {
              CompletableFuture<String> f = new CompletableFuture<>();
              f.completeExceptionally(new IllegalStateException("double close"));
              return f;
            });

    ApiException surfaced = failureOf(callable.futureCall("req", GrpcCallContext.createDefault()));

    assertThat(codeOf(surfaced)).isEqualTo(Status.Code.UNKNOWN);
  }

  @Test
  void futureCall_sessionPoolMapSyncThrowSurfacesAsUnknown() {
    // The full seam, wired as production wires it: TableBase.readRow throws synchronously on the
    // caller thread -> SessionPoolMap.apply's `catch (Throwable)` converts it to a failed future
    // -> translateException defaults it to UNKNOWN. No grpc Status is involved at any point, which
    // is why this failure mode can produce an application UNKNOWN with no server-side counterpart.
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

    assertThat(codeOf(surfaced)).isEqualTo(Status.Code.UNKNOWN);
    assertThat(surfaced).hasCauseThat().isNotNull();
  }

  @Test
  void futureCall_sessionPoolMapStatusThrowKeepsItsCode() {
    // Same seam, but the throw already carries a Status. Contrast with the test above: the seam
    // itself is not lossy -- the loss happens only when the throwable has no Status to begin with.
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

  // ---------------------------------------------------------------------------------------------

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
