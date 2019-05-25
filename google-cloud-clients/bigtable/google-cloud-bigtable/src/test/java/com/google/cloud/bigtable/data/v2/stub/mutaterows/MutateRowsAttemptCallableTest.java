/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.mutaterows;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.AbstractApiFuture;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.rpc.UnavailableException;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsRequest.Entry;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException.FailedMutation;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import com.google.rpc.Status;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class MutateRowsAttemptCallableTest {
  private static final Status OK_STATUS_PROTO =
      Status.newBuilder().setCode(com.google.rpc.Code.OK_VALUE).build();

  private static final Status TRANSIENT_ERROR_STATUS_PROTO =
      Status.newBuilder().setCode(com.google.rpc.Code.UNAVAILABLE_VALUE).build();

  private static final Status PERMENANT_ERROR_STATUS_PROTO =
      Status.newBuilder().setCode(com.google.rpc.Code.INVALID_ARGUMENT_VALUE).build();

  private MockInnerCallable innerCallable;
  private Set<Code> retryCodes;
  private ApiCallContext callContext;
  private MockRetryingFuture parentFuture;

  @Before
  public void setUp() {
    innerCallable = new MockInnerCallable();
    retryCodes = ImmutableSet.of(Code.DEADLINE_EXCEEDED, Code.UNAVAILABLE);
    callContext = GrpcCallContext.createDefault();
    parentFuture = new MockRetryingFuture();
  }

  @Test
  public void singleEntrySuccessTest() throws Exception {
    MutateRowsRequest request =
        MutateRowsRequest.newBuilder().addEntries(Entry.getDefaultInstance()).build();
    innerCallable.response.add(
        MutateRowsResponse.newBuilder()
            .addEntries(
                MutateRowsResponse.Entry.newBuilder().setIndex(0).setStatus(OK_STATUS_PROTO))
            .build());

    MutateRowsAttemptCallable attemptCallable =
        new MutateRowsAttemptCallable(innerCallable, request, callContext, retryCodes);
    attemptCallable.setExternalFuture(parentFuture);
    attemptCallable.call();

    // Attempt completed successfully and the useless response has been suppressed
    assertThat(parentFuture.attemptFuture.get()).isNull();
    // innerCallable received the request
    assertThat(innerCallable.lastRequest).isEqualTo(request);
  }

  @Test
  public void testNoRpcTimeout() {
    parentFuture.timedAttemptSettings =
        parentFuture.timedAttemptSettings.toBuilder().setRpcTimeout(Duration.ZERO).build();

    MutateRowsRequest request =
        MutateRowsRequest.newBuilder().addEntries(Entry.getDefaultInstance()).build();

    innerCallable.response.add(
        MutateRowsResponse.newBuilder()
            .addEntries(
                MutateRowsResponse.Entry.newBuilder().setIndex(0).setStatus(OK_STATUS_PROTO))
            .build());

    MutateRowsAttemptCallable attemptCallable =
        new MutateRowsAttemptCallable(innerCallable, request, callContext, retryCodes);
    attemptCallable.setExternalFuture(parentFuture);
    attemptCallable.call();

    assertThat(innerCallable.lastContext.getTimeout()).isNull();
  }

  @Test
  public void mixedTest() {
    // Setup the request & response
    MutateRowsRequest request =
        MutateRowsRequest.newBuilder()
            .addEntries(Entry.getDefaultInstance())
            .addEntries(Entry.getDefaultInstance())
            .addEntries(Entry.getDefaultInstance())
            .build();

    innerCallable.response.add(
        MutateRowsResponse.newBuilder()
            .addEntries(
                MutateRowsResponse.Entry.newBuilder().setIndex(0).setStatus(OK_STATUS_PROTO))
            .addEntries(
                MutateRowsResponse.Entry.newBuilder()
                    .setIndex(1)
                    .setStatus(TRANSIENT_ERROR_STATUS_PROTO))
            .addEntries(
                MutateRowsResponse.Entry.newBuilder()
                    .setIndex(2)
                    .setStatus(PERMENANT_ERROR_STATUS_PROTO))
            .build());

    MutateRowsAttemptCallable attemptCallable =
        new MutateRowsAttemptCallable(innerCallable, request, callContext, retryCodes);
    attemptCallable.setExternalFuture(parentFuture);

    // Make the only call
    attemptCallable.call();

    // Overall error expectations
    Throwable actualError = null;
    try {
      parentFuture.attemptFuture.get();
    } catch (Throwable t) {
      actualError = t.getCause();
    }

    assertThat(actualError).isInstanceOf(MutateRowsException.class);
    assertThat(((MutateRowsException) actualError).isRetryable()).isTrue();

    // Entry expectations
    @SuppressWarnings("ConstantConditions")
    List<FailedMutation> failedMutations = ((MutateRowsException) actualError).getFailedMutations();
    assertThat(failedMutations).hasSize(2);

    assertThat(failedMutations.get(0).getIndex()).isEqualTo(1);
    assertThat(failedMutations.get(0).getError().getStatusCode().getCode())
        .isEqualTo(Code.UNAVAILABLE);
    assertThat(failedMutations.get(0).getError().isRetryable()).isTrue();

    assertThat(failedMutations.get(1).getIndex()).isEqualTo(2);
    assertThat(failedMutations.get(1).getError().getStatusCode().getCode())
        .isEqualTo(Code.INVALID_ARGUMENT);
    assertThat(failedMutations.get(1).getError().isRetryable()).isFalse();
  }

  @Test
  public void nextAttemptTest() {
    // Setup the request & response for the first call
    MutateRowsRequest request =
        MutateRowsRequest.newBuilder()
            .addEntries(Entry.newBuilder().setRowKey(ByteString.copyFromUtf8("0-ok")))
            .addEntries(Entry.newBuilder().setRowKey(ByteString.copyFromUtf8("1-unavailable")))
            .addEntries(Entry.newBuilder().setRowKey(ByteString.copyFromUtf8("2-invalid")))
            .build();

    innerCallable.response.add(
        MutateRowsResponse.newBuilder()
            .addEntries(
                MutateRowsResponse.Entry.newBuilder().setIndex(0).setStatus(OK_STATUS_PROTO))
            .addEntries(
                MutateRowsResponse.Entry.newBuilder()
                    .setIndex(1)
                    .setStatus(TRANSIENT_ERROR_STATUS_PROTO))
            .addEntries(
                MutateRowsResponse.Entry.newBuilder()
                    .setIndex(2)
                    .setStatus(PERMENANT_ERROR_STATUS_PROTO))
            .build());

    MutateRowsAttemptCallable attemptCallable =
        new MutateRowsAttemptCallable(innerCallable, request, callContext, retryCodes);
    attemptCallable.setExternalFuture(parentFuture);

    // Make the first call
    attemptCallable.call();

    // Setup the request & response for the next call
    innerCallable.response =
        Lists.newArrayList(
            MutateRowsResponse.newBuilder()
                .addEntries(
                    MutateRowsResponse.Entry.newBuilder().setIndex(0).setStatus(OK_STATUS_PROTO))
                .build());
    attemptCallable.call();

    // Make sure that only the entry with the transient error is resubmitted
    assertThat(innerCallable.lastRequest.getEntriesCount()).isEqualTo(1);
    assertThat(innerCallable.lastRequest.getEntries(0).getRowKey())
        .isEqualTo(ByteString.copyFromUtf8("1-unavailable"));

    // Overall error expectations
    Throwable actualError = null;
    try {
      parentFuture.attemptFuture.get();
    } catch (Throwable t) {
      actualError = t.getCause();
    }
    assertThat(actualError).isInstanceOf(MutateRowsException.class);
    assertThat(((MutateRowsException) actualError).isRetryable()).isFalse();

    // Entry expectations
    @SuppressWarnings("ConstantConditions")
    List<FailedMutation> failedMutations = ((MutateRowsException) actualError).getFailedMutations();
    assertThat(failedMutations).hasSize(1);

    assertThat(failedMutations.get(0).getIndex()).isEqualTo(2);
    assertThat(failedMutations.get(0).getError().getStatusCode().getCode())
        .isEqualTo(Code.INVALID_ARGUMENT);
    assertThat(failedMutations.get(0).getError().isRetryable()).isFalse();
  }

  @Test
  public void rpcRetryableError() {
    // Setup the request & response
    MutateRowsRequest request =
        MutateRowsRequest.newBuilder()
            .addEntries(Entry.getDefaultInstance())
            .addEntries(Entry.getDefaultInstance())
            .build();

    final UnavailableException rpcError =
        new UnavailableException(
            "fake error", null, GrpcStatusCode.of(io.grpc.Status.Code.UNAVAILABLE), true);

    UnaryCallable<MutateRowsRequest, List<MutateRowsResponse>> innerCallable =
        new UnaryCallable<MutateRowsRequest, List<MutateRowsResponse>>() {
          @Override
          public ApiFuture<List<MutateRowsResponse>> futureCall(
              MutateRowsRequest request, ApiCallContext context) {
            return ApiFutures.immediateFailedFuture(rpcError);
          }
        };

    // Make the call
    MutateRowsAttemptCallable attemptCallable =
        new MutateRowsAttemptCallable(innerCallable, request, callContext, retryCodes);
    attemptCallable.setExternalFuture(parentFuture);
    attemptCallable.call();

    // Overall expectations: retryable error
    Throwable actualError = null;
    try {
      parentFuture.attemptFuture.get();
    } catch (Throwable t) {
      actualError = t.getCause();
    }
    assertThat(actualError).isInstanceOf(MutateRowsException.class);
    assertThat(((MutateRowsException) actualError).isRetryable()).isTrue();

    // Entry expectations: both entries failed with an error whose cause is the rpc error
    @SuppressWarnings("ConstantConditions")
    List<FailedMutation> failedMutations = ((MutateRowsException) actualError).getFailedMutations();
    assertThat(failedMutations).hasSize(2);

    assertThat(failedMutations.get(0).getIndex()).isEqualTo(0);
    assertThat(failedMutations.get(0).getError().isRetryable()).isTrue();
    assertThat(failedMutations.get(0).getError().getCause()).isEqualTo(rpcError);

    assertThat(failedMutations.get(1).getIndex()).isEqualTo(1);
    assertThat(failedMutations.get(1).getError().isRetryable()).isTrue();
    assertThat(failedMutations.get(1).getError().getCause()).isEqualTo(rpcError);
  }

  @Test
  public void rpcPermanentError() {
    // Setup the request & response
    MutateRowsRequest request =
        MutateRowsRequest.newBuilder()
            .addEntries(Entry.getDefaultInstance())
            .addEntries(Entry.getDefaultInstance())
            .build();

    final UnavailableException rpcError =
        new UnavailableException(
            "fake error", null, GrpcStatusCode.of(io.grpc.Status.Code.INVALID_ARGUMENT), false);

    UnaryCallable<MutateRowsRequest, List<MutateRowsResponse>> innerCallable =
        new UnaryCallable<MutateRowsRequest, List<MutateRowsResponse>>() {
          @Override
          public ApiFuture<List<MutateRowsResponse>> futureCall(
              MutateRowsRequest request, ApiCallContext context) {
            return ApiFutures.immediateFailedFuture(rpcError);
          }
        };

    // Make the call
    MutateRowsAttemptCallable attemptCallable =
        new MutateRowsAttemptCallable(innerCallable, request, callContext, retryCodes);
    attemptCallable.setExternalFuture(parentFuture);
    attemptCallable.call();

    // Overall expectations: retryable error
    Throwable actualError = null;
    try {
      parentFuture.attemptFuture.get();
    } catch (Throwable t) {
      actualError = t.getCause();
    }
    assertThat(actualError).isInstanceOf(MutateRowsException.class);
    assertThat(((MutateRowsException) actualError).isRetryable()).isFalse();

    // Entry expectations: both entries failed with an error whose cause is the rpc error
    @SuppressWarnings("ConstantConditions")
    List<FailedMutation> failedMutations = ((MutateRowsException) actualError).getFailedMutations();
    assertThat(failedMutations).hasSize(2);

    assertThat(failedMutations.get(0).getIndex()).isEqualTo(0);
    assertThat(failedMutations.get(0).getError().isRetryable()).isFalse();
    assertThat(failedMutations.get(0).getError().getCause()).isEqualTo(rpcError);

    assertThat(failedMutations.get(1).getIndex()).isEqualTo(1);
    assertThat(failedMutations.get(1).getError().isRetryable()).isFalse();
    assertThat(failedMutations.get(1).getError().getCause()).isEqualTo(rpcError);
  }

  // <editor-fold desc="Helpers">
  static class MockInnerCallable
      extends UnaryCallable<MutateRowsRequest, List<MutateRowsResponse>> {
    List<MutateRowsResponse> response = Lists.newArrayList();
    MutateRowsRequest lastRequest;
    ApiCallContext lastContext;

    @Override
    public ApiFuture<List<MutateRowsResponse>> futureCall(
        MutateRowsRequest request, ApiCallContext context) {
      lastRequest = request;
      lastContext = context;

      return ApiFutures.immediateFuture(response);
    }
  }

  static class MockRetryingFuture extends AbstractApiFuture<Void> implements RetryingFuture<Void> {
    ApiFuture<Void> attemptFuture;

    TimedAttemptSettings timedAttemptSettings;

    MockRetryingFuture() {
      this(Duration.ofSeconds(5));
    }

    MockRetryingFuture(Duration totalTimeout) {
      this.timedAttemptSettings =
          TimedAttemptSettings.newBuilder()
              .setRpcTimeout(Duration.ofSeconds(1))
              .setRetryDelay(Duration.ZERO)
              .setRandomizedRetryDelay(Duration.ZERO)
              .setAttemptCount(0)
              .setFirstAttemptStartTimeNanos(0)
              .setGlobalSettings(RetrySettings.newBuilder().setTotalTimeout(totalTimeout).build())
              .build();
    }

    @Override
    public void setAttemptFuture(ApiFuture<Void> attemptFuture) {
      this.attemptFuture = attemptFuture;
    }

    @Override
    public TimedAttemptSettings getAttemptSettings() {
      return timedAttemptSettings;
    }

    @Override
    public Callable<Void> getCallable() {
      throw new UnsupportedOperationException("not used");
    }

    @Override
    public ApiFuture<Void> peekAttemptResult() {
      throw new UnsupportedOperationException("not used");
    }

    @Override
    public ApiFuture<Void> getAttemptResult() {
      throw new UnsupportedOperationException("not used");
    }
  }
  // </editor-fold>
}
