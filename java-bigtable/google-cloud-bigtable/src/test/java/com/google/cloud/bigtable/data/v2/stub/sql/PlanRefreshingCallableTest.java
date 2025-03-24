/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.sql;

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.columnMetadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Value;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithoutToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.planRefreshError;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.prepareResponse;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.preparedStatement;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.api.core.ApiClock;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.core.FakeApiClock;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.FailedPreconditionException;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.cloud.bigtable.data.v2.internal.PrepareResponse;
import com.google.cloud.bigtable.data.v2.internal.PreparedStatementImpl.PreparedQueryData;
import com.google.cloud.bigtable.data.v2.internal.ProtoResultSetMetadata;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.sql.PreparedStatement;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import com.google.cloud.bigtable.data.v2.stub.sql.PlanRefreshingCallable.PlanRefreshingObserver;
import com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.FakePreparedStatement;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockResponseObserver;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockServerStreamingCall;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockServerStreamingCallable;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockStreamController;
import com.google.protobuf.ByteString;
import io.grpc.Deadline;
import io.grpc.Status.Code;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PlanRefreshingCallableTest {

  private static final ExecuteQueryRequest FAKE_REQUEST = ExecuteQueryRequest.newBuilder().build();
  private static final com.google.bigtable.v2.ResultSetMetadata METADATA =
      metadata(columnMetadata("foo", stringType()), columnMetadata("bar", int64Type()));
  private static final ExecuteQueryResponse DATA =
      partialResultSetWithToken(stringValue("fooVal"), int64Value(100));

  ExecuteQueryCallContext callContext;
  MockResponseObserver<ExecuteQueryResponse> outerObserver;
  SettableApiFuture<ResultSetMetadata> metadataFuture;
  PlanRefreshingObserver observer;
  RetrySettings retrySettings;
  ApiClock clock;

  @Before
  public void setUp() {
    metadataFuture = SettableApiFuture.create();
    PreparedStatement preparedStatement =
        preparedStatement(
            metadata(columnMetadata("foo", stringType()), columnMetadata("bar", int64Type())));

    retrySettings =
        EnhancedBigtableStubSettings.newBuilder().executeQuerySettings().retrySettings().build();
    clock = new FakeApiClock(System.nanoTime());
    callContext = ExecuteQueryCallContext.create(preparedStatement.bind().build(), metadataFuture);
    outerObserver = new MockResponseObserver<>(true);
    observer = new PlanRefreshingObserver(outerObserver, callContext);
  }

  @Test
  public void observer_doesNotSetFutureUntilTokenReceived()
      throws ExecutionException, InterruptedException {
    MockServerStreamingCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new MockServerStreamingCallable<>();
    innerCallable.call(FAKE_REQUEST, observer);
    MockServerStreamingCall<ExecuteQueryRequest, ExecuteQueryResponse> lastCall =
        innerCallable.popLastCall();
    MockStreamController<ExecuteQueryResponse> innerController = lastCall.getController();

    innerController.getObserver().onResponse(partialResultSetWithoutToken(stringValue("foo")));
    assertFalse(callContext.resultSetMetadataFuture().isDone());
    innerController.getObserver().onResponse(partialResultSetWithToken(stringValue("bar")));
    assertTrue(callContext.resultSetMetadataFuture().isDone());
    assertThat(callContext.resultSetMetadataFuture().get())
        .isEqualTo(ProtoResultSetMetadata.fromProto(METADATA));
  }

  @Test
  public void observer_setsFutureAndPassesThroughResponses()
      throws ExecutionException, InterruptedException {
    // This has a token so it should finalize the metadata
    ServerStreamingStashCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new ServerStreamingStashCallable<>(Collections.singletonList(DATA));
    innerCallable.call(FAKE_REQUEST, observer);

    assertThat(metadataFuture.isDone()).isTrue();
    assertThat(metadataFuture.get()).isEqualTo(ProtoResultSetMetadata.fromProto(METADATA));
    assertThat(outerObserver.popNextResponse()).isEqualTo(DATA);
    assertThat(outerObserver.isDone()).isTrue();
    assertThat(outerObserver.getFinalError()).isNull();
  }

  @Test
  public void observer_passThroughOnStart() {
    MockServerStreamingCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new MockServerStreamingCallable<>();
    innerCallable.call(FAKE_REQUEST, observer);
    MockServerStreamingCall<ExecuteQueryRequest, ExecuteQueryResponse> lastCall =
        innerCallable.popLastCall();
    MockStreamController<ExecuteQueryResponse> innerController = lastCall.getController();

    assertThat(outerObserver.getController()).isEqualTo(innerController);
  }

  @Test
  public void observer_onCompleteWithNoData_resolvesMetadata()
      throws InterruptedException, ExecutionException {
    MockServerStreamingCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new MockServerStreamingCallable<>();
    innerCallable.call(FAKE_REQUEST, observer);
    MockServerStreamingCall<ExecuteQueryRequest, ExecuteQueryResponse> lastCall =
        innerCallable.popLastCall();
    MockStreamController<ExecuteQueryResponse> innerController = lastCall.getController();

    innerController.getObserver().onComplete();
    assertThat(metadataFuture.get()).isEqualTo(ProtoResultSetMetadata.fromProto(METADATA));
    assertThat(outerObserver.isDone()).isTrue();
    assertThat(outerObserver.getFinalError()).isNull();
  }

  @Test
  public void testCallable() throws ExecutionException, InterruptedException {
    ServerStreamingStashCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new ServerStreamingStashCallable<>(Collections.singletonList(DATA));
    RequestContext requestContext = RequestContext.create("project", "instance", "profile");
    PlanRefreshingCallable callable = new PlanRefreshingCallable(innerCallable, requestContext);
    MockResponseObserver<ExecuteQueryResponse> outerObserver = new MockResponseObserver<>(true);
    SettableApiFuture<ResultSetMetadata> metadataFuture = SettableApiFuture.create();
    PreparedStatement preparedStatement =
        preparedStatement(
            metadata(columnMetadata("foo", stringType()), columnMetadata("bar", int64Type())));

    ExecuteQueryCallContext callContext =
        ExecuteQueryCallContext.create(preparedStatement.bind().build(), metadataFuture);

    callable.call(callContext, outerObserver);

    assertThat(metadataFuture.isDone()).isTrue();
    assertThat(metadataFuture.get()).isEqualTo(ProtoResultSetMetadata.fromProto(METADATA));
    assertThat(outerObserver.popNextResponse()).isEqualTo(DATA);
    assertThat(outerObserver.isDone()).isTrue();
    assertThat(outerObserver.getFinalError()).isNull();
  }

  @Test
  public void testPlanRefreshError() {
    RequestContext requestContext = RequestContext.create("project", "instance", "profile");
    MockServerStreamingCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new MockServerStreamingCallable<>();
    PlanRefreshingCallable planRefreshingCallable =
        new PlanRefreshingCallable(innerCallable, requestContext);
    MockResponseObserver<ExecuteQueryResponse> outerObserver = new MockResponseObserver<>(true);
    ExecuteQueryCallContext callContext =
        ExecuteQueryCallContext.create(new FakePreparedStatement().bind().build(), metadataFuture);

    planRefreshingCallable.call(callContext, outerObserver);
    innerCallable.popLastCall().getController().getObserver().onError(planRefreshError());
    ApiException e = (ApiException) outerObserver.getFinalError();

    assertThat(e.isRetryable()).isTrue();
    assertThat(callContext.resultSetMetadataFuture().isDone()).isFalse();
    ExecuteQueryRequest nextRequest =
        callContext.buildRequestWithDeadline(
            requestContext, Deadline.after(1, TimeUnit.MILLISECONDS));
    assertThat(nextRequest.getPreparedQuery()).isEqualTo(ByteString.copyFromUtf8("refreshedPlan"));
  }

  @Test
  public void testPlanRefreshErrorAfterToken() {
    RequestContext requestContext = RequestContext.create("project", "instance", "profile");
    MockServerStreamingCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new MockServerStreamingCallable<>();
    PlanRefreshingCallable planRefreshingCallable =
        new PlanRefreshingCallable(innerCallable, requestContext);
    MockResponseObserver<ExecuteQueryResponse> outerObserver = new MockResponseObserver<>(true);
    ExecuteQueryCallContext callContext =
        ExecuteQueryCallContext.create(new FakePreparedStatement().bind().build(), metadataFuture);

    planRefreshingCallable.call(callContext, outerObserver);
    ResponseObserver<ExecuteQueryResponse> innerObserver =
        innerCallable.popLastCall().getController().getObserver();
    innerObserver.onResponse(partialResultSetWithToken(stringValue("foo")));
    innerObserver.onError(planRefreshError());

    Throwable t = outerObserver.getFinalError();
    assertThat(t).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void testIsPlanRefreshError() {
    assertThat(PlanRefreshingCallable.isPlanRefreshError(planRefreshError())).isTrue();
    assertFalse(
        PlanRefreshingCallable.isPlanRefreshError(
            new FailedPreconditionException(
                "A different failed precondition",
                null,
                GrpcStatusCode.of(Code.FAILED_PRECONDITION),
                false)));
  }

  @Test
  public void planRefreshDelayIsFactoredIntoExecuteTimeout() throws InterruptedException {
    MockServerStreamingCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new MockServerStreamingCallable<>();
    RequestContext requestContext = RequestContext.create("project", "instance", "profile");
    PlanRefreshingCallable callable = new PlanRefreshingCallable(innerCallable, requestContext);
    MockResponseObserver<ExecuteQueryResponse> outerObserver = new MockResponseObserver<>(true);
    SettableApiFuture<ResultSetMetadata> metadataFuture = SettableApiFuture.create();
    SettableApiFuture<PrepareResponse> prepareFuture = SettableApiFuture.create();
    PreparedStatement preparedStatement =
        new FakePreparedStatement().withUpdatedPlans(PreparedQueryData.create(prepareFuture), null);
    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    ExecuteQueryCallContext callContext =
        ExecuteQueryCallContext.create(preparedStatement.bind().build(), metadataFuture);

    Duration originalAttemptTimeout = Duration.ofMillis(100);
    scheduler.schedule(
        () -> {
          prepareFuture.set(
              PrepareResponse.fromProto(
                  prepareResponse(
                      ByteString.copyFromUtf8("initialPlan"),
                      metadata(columnMetadata("strCol", stringType())))));
        },
        50,
        TimeUnit.MILLISECONDS);
    ApiCallContext context =
        GrpcCallContext.createDefault().withTimeoutDuration(originalAttemptTimeout);
    // prepare takes 50 ms to resolve. Despite that the execute timeout should be around 100ms from
    // now (w padding)
    Deadline paddedDeadlineAtStartOfCall =
        Deadline.after(originalAttemptTimeout.toMillis() + 5, TimeUnit.MILLISECONDS);
    callable.call(callContext, outerObserver, context);
    scheduler.shutdown();
    scheduler.awaitTermination(30, TimeUnit.SECONDS);
    GrpcCallContext grpcCallContext =
        (GrpcCallContext) innerCallable.popLastCall().getApiCallContext();
    Deadline executeDeadline = grpcCallContext.getCallOptions().getDeadline();
    assertThat(executeDeadline.isBefore(paddedDeadlineAtStartOfCall)).isTrue();
  }

  @Test
  public void testGetDeadlineWithAttemptTimeout() {
    GrpcCallContext callContext =
        GrpcCallContext.createDefault().withTimeoutDuration(Duration.ofMinutes(1));
    // startTimeOfOverallRequest doesn't matter here
    Deadline deadline = PlanRefreshingCallable.getDeadline(callContext, Instant.now());
    long millisRemaining = deadline.timeRemaining(TimeUnit.MILLISECONDS);
    assertThat(millisRemaining).isLessThan((60 * 1000) + 1);
    // Give some padding in case tests are very slow
    assertThat(millisRemaining).isGreaterThan(58 * 1000);
  }

  @Test
  public void testGetDeadlineWithTotalTimeout() {
    GrpcCallContext callContext =
        GrpcCallContext.createDefault()
            .withRetrySettings(
                RetrySettings.newBuilder()
                    .setTotalTimeout(org.threeten.bp.Duration.ofMinutes(1))
                    .build());
    Deadline deadline = PlanRefreshingCallable.getDeadline(callContext, Instant.now());
    long millisRemaining = deadline.timeRemaining(TimeUnit.MILLISECONDS);
    assertThat(millisRemaining).isLessThan((60 * 1000) + 1);
    // Give some padding in case tests are very slow
    assertThat(millisRemaining).isGreaterThan(58 * 1000);
  }

  @Test
  public void testAttemptTimeoutUsedOverTotalTimeout() {
    GrpcCallContext callContext =
        GrpcCallContext.createDefault()
            .withTimeoutDuration(Duration.ofMinutes(1))
            .withRetrySettings(
                RetrySettings.newBuilder()
                    .setTotalTimeout(org.threeten.bp.Duration.ofHours(1))
                    .build());
    Deadline deadline = PlanRefreshingCallable.getDeadline(callContext, Instant.now());
    long millisRemaining = deadline.timeRemaining(TimeUnit.MILLISECONDS);
    assertThat(millisRemaining).isLessThan((60 * 1000) + 1);
    // Give some padding in case tests are very slow
    assertThat(millisRemaining).isGreaterThan(58 * 1000);
  }
}
