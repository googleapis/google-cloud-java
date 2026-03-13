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
package com.google.api.gax.rpc;

import com.google.api.core.BetaApi;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.longrunning.OperationResponsePollAlgorithm;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.ScheduledRetryingExecutor;
import com.google.api.gax.retrying.StreamingRetryAlgorithm;
import java.util.Collection;

/**
 * Class with utility methods to create callable objects using provided settings.
 *
 * <p>The callable objects wrap a given direct callable with features like retry and exception
 * translation.
 */
@BetaApi
public class Callables {

  private Callables() {}

  /**
   * Create a callable object that represents a Unary API method. Designed for use by generated
   * code.
   *
   * @param innerCallable the callable to issue calls
   * @param callSettings {@link UnaryCallSettings} to configure the unary call-related settings
   *     with.
   * @param clientContext {@link ClientContext} to use to connect to the service.
   * @return {@link UnaryCallable} callable object.
   */
  public static <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> retrying(
      UnaryCallable<RequestT, ResponseT> innerCallable,
      UnaryCallSettings<?, ?> callSettings,
      ClientContext clientContext) {

    ScheduledRetryingExecutor<ResponseT> retryingExecutor =
        getRetryingExecutor(callSettings, clientContext);
    return new RetryingCallable<>(
        clientContext.getDefaultCallContext(), innerCallable, retryingExecutor);
  }

  /**
   * Create a callable object that represents a Unary API method that contains a Request Mutator.
   * Designed for use by generated code.
   *
   * @param innerCallable the callable to issue calls
   * @param callSettings {@link UnaryCallSettings} to configure the unary call-related settings
   *     with.
   * @param clientContext {@link ClientContext} to use to connect to the service.
   * @param requestMutator {@link RequestMutator} to modify the request. Currently only used for
   *     autopopulated fields.
   * @return {@link UnaryCallable} callable object.
   */
  public static <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> retrying(
      UnaryCallable<RequestT, ResponseT> innerCallable,
      UnaryCallSettings<?, ?> callSettings,
      ClientContext clientContext,
      RequestMutator requestMutator) {

    ScheduledRetryingExecutor<ResponseT> retryingExecutor =
        getRetryingExecutor(callSettings, clientContext);
    return new RetryingCallable<>(
        clientContext.getDefaultCallContext(), innerCallable, retryingExecutor, requestMutator);
  }

  private static <ResponseT> ScheduledRetryingExecutor<ResponseT> getRetryingExecutor(
      UnaryCallSettings<?, ?> callSettings, ClientContext clientContext) {
    UnaryCallSettings<?, ?> settings = callSettings;

    if (areRetriesDisabled(settings.getRetryableCodes(), settings.getRetrySettings())) {
      // When retries are disabled, the total timeout can be treated as the rpc timeout.
      settings =
          settings.toBuilder()
              .setSimpleTimeoutNoRetriesDuration(
                  settings.getRetrySettings().getTotalTimeoutDuration())
              .build();
    }

    RetryAlgorithm<ResponseT> retryAlgorithm =
        new RetryAlgorithm<>(
            new ApiResultRetryAlgorithm<ResponseT>(),
            new ExponentialRetryAlgorithm(settings.getRetrySettings(), clientContext.getClock()));
    ScheduledRetryingExecutor<ResponseT> retryingExecutor =
        new ScheduledRetryingExecutor<>(retryAlgorithm, clientContext.getExecutor());
    return retryingExecutor;
  }

  public static <RequestT, ResponseT> ServerStreamingCallable<RequestT, ResponseT> retrying(
      ServerStreamingCallable<RequestT, ResponseT> innerCallable,
      ServerStreamingCallSettings<RequestT, ResponseT> callSettings,
      ClientContext clientContext) {

    ServerStreamingCallSettings<RequestT, ResponseT> settings = callSettings;
    if (areRetriesDisabled(settings.getRetryableCodes(), settings.getRetrySettings())) {
      // When retries are disabled, the total timeout can be treated as the rpc timeout.
      settings =
          settings.toBuilder()
              .setSimpleTimeoutNoRetriesDuration(
                  settings.getRetrySettings().getTotalTimeoutDuration())
              .build();
    }

    StreamingRetryAlgorithm<Void> retryAlgorithm =
        new StreamingRetryAlgorithm<>(
            new ApiResultRetryAlgorithm<Void>(),
            new ExponentialRetryAlgorithm(settings.getRetrySettings(), clientContext.getClock()));

    ScheduledRetryingExecutor<Void> retryingExecutor =
        new ScheduledRetryingExecutor<>(retryAlgorithm, clientContext.getExecutor());

    return new RetryingServerStreamingCallable<>(
        innerCallable, retryingExecutor, settings.getResumptionStrategy());
  }

  public static <RequestT, ResponseT> ServerStreamingCallable<RequestT, ResponseT> watched(
      ServerStreamingCallable<RequestT, ResponseT> callable,
      ServerStreamingCallSettings<RequestT, ResponseT> callSettings,
      ClientContext clientContext) {

    callable = new WatchdogServerStreamingCallable<>(callable, clientContext.getStreamWatchdog());

    callable =
        callable.withDefaultCallContext(
            clientContext
                .getDefaultCallContext()
                .withStreamIdleTimeoutDuration(callSettings.getIdleTimeoutDuration())
                .withStreamWaitTimeoutDuration(callSettings.getWaitTimeoutDuration()));

    return callable;
  }

  /**
   * Create a callable object that represents a batching API method. Designed for use by generated
   * code.
   *
   * @param innerCallable the callable to issue calls
   * @param batchingCallSettings {@link BatchingSettings} to configure the batching related settings
   *     with.
   * @param context {@link ClientContext} to use to connect to the service.
   * @return {@link UnaryCallable} callable object.
   */
  public static <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> batching(
      UnaryCallable<RequestT, ResponseT> innerCallable,
      BatchingCallSettings<RequestT, ResponseT> batchingCallSettings,
      ClientContext context) {
    return batchingImpl(innerCallable, batchingCallSettings, context).unaryCallable;
  }

  /** This only exists to give tests access to batcherFactory for flushing purposes. */
  static class BatchingCreateResult<RequestT, ResponseT> {
    private final BatcherFactory<RequestT, ResponseT> batcherFactory;
    private final UnaryCallable<RequestT, ResponseT> unaryCallable;

    private BatchingCreateResult(
        BatcherFactory<RequestT, ResponseT> batcherFactory,
        UnaryCallable<RequestT, ResponseT> unaryCallable) {
      this.batcherFactory = batcherFactory;
      this.unaryCallable = unaryCallable;
    }

    public BatcherFactory<RequestT, ResponseT> getBatcherFactory() {
      return batcherFactory;
    }

    public UnaryCallable<RequestT, ResponseT> getUnaryCallable() {
      return unaryCallable;
    }
  }

  static <RequestT, ResponseT> BatchingCreateResult<RequestT, ResponseT> batchingImpl(
      UnaryCallable<RequestT, ResponseT> innerCallable,
      BatchingCallSettings<RequestT, ResponseT> batchingCallSettings,
      ClientContext clientContext) {
    BatcherFactory<RequestT, ResponseT> batcherFactory =
        new BatcherFactory<>(
            batchingCallSettings.getBatchingDescriptor(),
            batchingCallSettings.getBatchingSettings(),
            clientContext.getExecutor(),
            batchingCallSettings.getFlowController());
    UnaryCallable<RequestT, ResponseT> callable =
        new BatchingCallable<>(
            innerCallable, batchingCallSettings.getBatchingDescriptor(), batcherFactory);
    return new BatchingCreateResult<>(batcherFactory, callable);
  }

  /**
   * Create a paged callable object that represents a paged API method. Designed for use by
   * generated code.
   *
   * @param innerCallable the callable to issue calls
   * @param pagedCallSettings {@link PagedCallSettings} to configure the paged settings with.
   * @return {@link UnaryCallable} callable object.
   */
  public static <RequestT, ResponseT, PagedListResponseT>
      UnaryCallable<RequestT, PagedListResponseT> paged(
          UnaryCallable<RequestT, ResponseT> innerCallable,
          PagedCallSettings<RequestT, ResponseT, PagedListResponseT> pagedCallSettings) {
    return new PagedCallable<>(innerCallable, pagedCallSettings.getPagedListResponseFactory());
  }

  /**
   * Creates a callable object that represents a long-running operation. Designed for use by
   * generated code.
   *
   * @param initialCallable the callable that initiates the operation
   * @param operationCallSettings {@link OperationCallSettings} to configure the method-level
   *     settings with.
   * @param clientContext {@link ClientContext} to use to connect to the service.
   * @param longRunningClient {@link LongRunningClient} to use to poll for updates on the Operation.
   * @return {@link OperationCallable} callable object.
   */
  public static <RequestT, ResponseT, MetadataT>
      OperationCallable<RequestT, ResponseT, MetadataT> longRunningOperation(
          UnaryCallable<RequestT, OperationSnapshot> initialCallable,
          OperationCallSettings<RequestT, ResponseT, MetadataT> operationCallSettings,
          ClientContext clientContext,
          LongRunningClient longRunningClient) {
    return longRunningOperationImpl(
        initialCallable, operationCallSettings, clientContext, longRunningClient);
  }

  static <RequestT, ResponseT, MetadataT>
      OperationCallableImpl<RequestT, ResponseT, MetadataT> longRunningOperationImpl(
          UnaryCallable<RequestT, OperationSnapshot> initialCallable,
          OperationCallSettings<RequestT, ResponseT, MetadataT> operationCallSettings,
          ClientContext clientContext,
          LongRunningClient longRunningClient) {
    RetryAlgorithm<OperationSnapshot> pollingAlgorithm =
        new RetryAlgorithm<>(
            new OperationResponsePollAlgorithm(), operationCallSettings.getPollingAlgorithm());
    ScheduledRetryingExecutor<OperationSnapshot> scheduler =
        new ScheduledRetryingExecutor<>(pollingAlgorithm, clientContext.getExecutor());

    return new OperationCallableImpl<>(
        initialCallable, scheduler, longRunningClient, operationCallSettings);
  }

  private static boolean areRetriesDisabled(
      Collection<StatusCode.Code> retryableCodes, RetrySettings retrySettings) {
    return retrySettings.getMaxAttempts() == 1
        || retryableCodes.isEmpty()
        || (retrySettings.getMaxAttempts() == 0
            && retrySettings.getTotalTimeoutDuration().isZero());
  }
}
