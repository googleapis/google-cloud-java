/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.executor.spanner;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.spanner.executor.v1.SessionPoolOptions;
import com.google.spanner.executor.v1.SpannerAction;
import com.google.spanner.executor.v1.SpannerAsyncActionRequest;
import com.google.spanner.executor.v1.SpannerAsyncActionResponse;
import com.google.spanner.executor.v1.SpannerExecutorProxyGrpc;
import com.google.spanner.executor.v1.SpannerOptions;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Send proxied action requests through Spanner Cloud API. */
public class CloudExecutorImpl extends SpannerExecutorProxyGrpc.SpannerExecutorProxyImplBase {

  private static final Logger LOGGER = Logger.getLogger(CloudExecutorImpl.class.getName());

  // Executors to proxy.
  private final CloudClientExecutor clientExecutor;

  // Ratio of operations to use multiplexed sessions.
  private final double multiplexedSessionOperationsRatio;

  // Count of checks performed to verify end to end traces using Cloud Trace APIs.
  private int cloudTraceCheckCount = 0;

  // Maximum checks allowed to verify end to end traces using Cloud Trace APIs.
  private static final int MAX_CLOUD_TRACE_CHECK_LIMIT = 20;

  public CloudExecutorImpl(
      boolean enableGrpcFaultInjector, double multiplexedSessionOperationsRatio) {
    clientExecutor = new CloudClientExecutor(enableGrpcFaultInjector);
    this.multiplexedSessionOperationsRatio = multiplexedSessionOperationsRatio;
  }

  private synchronized void incrementCloudTraceCheckCount() {
    cloudTraceCheckCount++;
  }

  private synchronized int getCloudTraceCheckCount() {
    return cloudTraceCheckCount;
  }

  /** Execute SpannerAsync action requests. */
  @Override
  public StreamObserver<SpannerAsyncActionRequest> executeActionAsync(
      StreamObserver<SpannerAsyncActionResponse> responseObserver) {
    // Create a top-level OpenTelemetry span for streaming request.
    Tracer tracer = WorkerProxy.openTelemetrySdk.getTracer(CloudClientExecutor.class.getName());
    Span span = tracer.spanBuilder("java_systest_execute_actions_stream").setNoParent().startSpan();
    Scope scope = span.makeCurrent();

    final String traceId = span.getSpanContext().getTraceId();
    final boolean isSampled = span.getSpanContext().getTraceFlags().isSampled();
    AtomicBoolean requestHasReadOrQueryAction = new AtomicBoolean(false);

    CloudClientExecutor.ExecutionFlowContext executionContext =
        clientExecutor.new ExecutionFlowContext(responseObserver);
    return new StreamObserver<SpannerAsyncActionRequest>() {
      @Override
      public void onNext(SpannerAsyncActionRequest request) {
        LOGGER.log(Level.INFO, String.format("Receiving request: \n%s", request));

        // Use Multiplexed sessions for all supported operations if the
        // multiplexedSessionOperationsRatio from command line is > 0.0
        if (multiplexedSessionOperationsRatio > 0.0) {
          SessionPoolOptions.Builder sessionPoolOptionsBuilder;
          if (request.getAction().getSpannerOptions().hasSessionPoolOptions()) {
            sessionPoolOptionsBuilder =
                request.getAction().getSpannerOptions().getSessionPoolOptions().toBuilder()
                    .setUseMultiplexed(true);
          } else {
            sessionPoolOptionsBuilder = SessionPoolOptions.newBuilder().setUseMultiplexed(true);
          }

          SpannerOptions.Builder optionsBuilder =
              request.getAction().getSpannerOptions().toBuilder()
                  .setSessionPoolOptions(sessionPoolOptionsBuilder);
          SpannerAction.Builder actionBuilder =
              request.getAction().toBuilder().setSpannerOptions(optionsBuilder);
          request = request.toBuilder().setAction(actionBuilder).build();
          LOGGER.log(
              Level.INFO,
              String.format("Updated request to set multiplexed session flag: \n%s", request));
        }
        String actionName = request.getAction().getActionCase().toString();
        if (actionName == "READ" || actionName == "QUERY") {
          requestHasReadOrQueryAction.set(true);
        }

        Status status = clientExecutor.startHandlingRequest(request, executionContext);
        if (!status.isOk()) {
          LOGGER.log(
              Level.WARNING,
              "Failed to handle request, half closed",
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, status.getDescription()));
        }
      }

      @Override
      public void onError(Throwable t) {
        LOGGER.log(Level.WARNING, "Client ends the stream with error.", t);
        executionContext.cleanup();
      }

      @Override
      public void onCompleted() {
        // Close the scope and end the span.
        scope.close();
        span.end();
        if (isSampled
            && getCloudTraceCheckCount() < MAX_CLOUD_TRACE_CHECK_LIMIT
            && requestHasReadOrQueryAction.get()) {
          Future<Boolean> traceVerificationTask =
              clientExecutor.getEndToEndTraceVerificationTask(traceId);
          try {
            LOGGER.log(
                Level.INFO,
                String.format("Starting end to end trace verification for trace_id:%s", traceId));
            Boolean isValidTrace = traceVerificationTask.get();
            incrementCloudTraceCheckCount();
            if (!isValidTrace) {
              executionContext.onError(
                  Status.INTERNAL
                      .withDescription(
                          String.format(
                              "failed to verify end to end trace for trace_id: %s", traceId))
                      .getCause());
              executionContext.cleanup();
              return;
            }
          } catch (Exception e) {
            LOGGER.log(
                Level.WARNING,
                String.format(
                    "Failed to verify end to end trace with exception: %s\n", e.getMessage()),
                e);
            executionContext.onError(e);
            executionContext.cleanup();
            return;
          }
        }
        LOGGER.log(Level.INFO, "Client called Done, half closed");
        executionContext.cleanup();
        responseObserver.onCompleted();
      }
    };
  }
}
