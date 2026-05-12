/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.pubsub.v1;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.Distribution;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.pubsub.v1.stub.SubscriberStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Any;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.StreamingPullRequest;
import com.google.pubsub.v1.StreamingPullResponse;
import com.google.rpc.ErrorInfo;
import com.google.rpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusException;
import io.grpc.protobuf.StatusProto;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.mockito.ArgumentCaptor;

/** Tests for {@link StreamingSubscriberConnection}. */
public class StreamingSubscriberConnectionTest {
  @Rule public TestName testName = new TestName();

  private FakeScheduledExecutorService systemExecutor;
  private FakeScheduledExecutorService executor;
  private FakeClock clock;
  private SubscriberStub mockSubscriberStub;

  private static final String MOCK_SUBSCRIPTION_NAME =
      "projects/MOCK-PROJECT/subscriptions/MOCK-SUBSCRIPTION";
  private static final String MOCK_ACK_ID_SUCCESS = "MOCK-ACK-ID-SUCCESS";
  private static final String MOCK_ACK_ID_SUCCESS_2 = "MOCK-ACK-ID-SUCCESS-2";
  private static final String MOCK_ACK_ID_NACK_SUCCESS = "MOCK-ACK-ID-NACK-SUCCESS";
  // Successful modacks should not return a message
  private static final String MOCK_ACK_ID_SUCCESS_NO_MESSAGE = "MOCK-ACK-ID-SUCCESS-NO-MESSAGE";
  private static final String MOCK_ACK_ID_TRANSIENT_FAILURE_UNORDERED_ACK_ID_THEN_SUCCESS =
      "MOCK-ACK-ID-TRANSIENT-FAILURE-UNORDERED-ACK-ID-THEN-SUCCESS";
  private static final String MOCK_ACK_ID_TRANSIENT_FAILURE_SERVICE_UNAVAILABLE_THEN_SUCCESS =
      "MOCK-ACK-ID-TRANSIENT-FAILURE-SERVICE-UNAVAILABLE-THEN-SUCCESS";
  private static final String MOCK_ACK_ID_INVALID = "MOCK-ACK-ID-INVALID";
  private static final String MOCK_ACK_ID_OTHER = "MOCK-ACK-ID-OTHER";
  private static final String MOCK_ACK_ID_NO_METADATA_MAP_INTERNAL_ERROR_THEN_PERMISSION_DENIED =
      "MOCK-ACK-ID-NO-METADATA-MAP-INTERNAL-ERROR";

  private static final String PERMANENT_FAILURE_INVALID_ACK_ID = "PERMANENT_FAILURE_INVALID_ACK_ID";
  private static final String TRANSIENT_FAILURE_UNORDERED_ACK_ID =
      "TRANSIENT_FAILURE_UNORDERED_ACK_ID";
  private static final String TRANSIENT_FAILURE_SERVICE_UNAVAILABLE =
      "TRANSIENT_FAILURE_SERVICE_UNAVAILABLE";
  private static final String PERMANENT_FAILURE_OTHER = "I_DO_NOT_MATCH_ANY_KNOWN_ERRORS";

  private static int MOCK_ACK_EXTENSION_DEFAULT_SECONDS = 10;
  private static Duration ACK_EXPIRATION_PADDING_DEFAULT_DURATION = Duration.ofSeconds(10);
  private static int MAX_DURATION_PER_ACK_EXTENSION_DEFAULT_SECONDS = 10;

  private static final long KEEP_ALIVE_SUPPORT_VERSION = 1;
  private static final Duration CLIENT_PING_INTERVAL = Duration.ofSeconds(30);
  private static final Duration MAX_ACK_EXTENSION_PERIOD = Duration.ofMinutes(60);

  @Before
  public void setUp() {
    systemExecutor = new FakeScheduledExecutorService();
    clock = systemExecutor.getClock();
    mockSubscriberStub = mock(SubscriberStub.class, RETURNS_DEEP_STUBS);
  }

  @After
  public void tearDown() {
    systemExecutor.shutdown();
  }

  @Test
  public void testSetupAndTeardown() {
    StreamingSubscriberConnection streamingSubscriberConnection =
        getStreamingSubscriberConnection(false);

    streamingSubscriberConnection.startAsync();
    streamingSubscriberConnection.awaitRunning();
    streamingSubscriberConnection.stopAsync();
    streamingSubscriberConnection.awaitTerminated();
  }

  @Test
  public void testRunShutdown_TimeoutMet() throws Exception {
    SubscriberShutdownSettings shutdownSettings =
        SubscriberShutdownSettings.newBuilder().setTimeout(Duration.ofSeconds(10)).build();
    StreamingSubscriberConnection.Builder builder =
        StreamingSubscriberConnection.newBuilder(mock(MessageReceiverWithAckResponse.class));
    builder.setSubscriberShutdownSettings(shutdownSettings);
    StreamingSubscriberConnection streamingSubscriberConnection =
        getStreamingSubscriberConnectionFromBuilder(builder);

    streamingSubscriberConnection.startAsync().awaitRunning();
    streamingSubscriberConnection.stopAsync();

    // Should terminate quickly as there are no outstanding messages.
    streamingSubscriberConnection.awaitTerminated(1, TimeUnit.SECONDS);
  }

  @Test
  public void testRunShutdown_TimeoutExceeded() throws Exception {
    final SettableApiFuture<com.google.protobuf.Empty> ackFuture = SettableApiFuture.create();
    when(mockSubscriberStub.acknowledgeCallable().futureCall(any(AcknowledgeRequest.class)))
        .thenReturn(ackFuture);

    SubscriberShutdownSettings shutdownSettings =
        SubscriberShutdownSettings.newBuilder().setTimeout(Duration.ofSeconds(2)).build();
    StreamingSubscriberConnection.Builder builder =
        StreamingSubscriberConnection.newBuilder(mock(MessageReceiverWithAckResponse.class));
    StreamingSubscriberConnection streamingSubscriberConnection =
        getStreamingSubscriberConnectionFromBuilder(builder, shutdownSettings);
    streamingSubscriberConnection.setExactlyOnceDeliveryEnabled(true);

    streamingSubscriberConnection.startAsync().awaitRunning();

    // Send an ACK that will not complete.
    SettableApiFuture<AckResponse> messageFuture = SettableApiFuture.create();
    streamingSubscriberConnection.sendAckOperations(
        Collections.singletonList(
            AckRequestData.newBuilder("ack1").setMessageFuture(messageFuture).build()));

    Thread t =
        new Thread(
            () -> {
              streamingSubscriberConnection.stopAsync();
            });
    t.start();

    Thread t2 =
        new Thread(
            () -> {
              try {
                streamingSubscriberConnection.awaitTerminated(1, TimeUnit.SECONDS);
                fail("Should have timed out");
              } catch (TimeoutException e) {
                // expected
              }
            });
    t2.start();
    t2.join();

    // Advance the clock past the shutdown timeout.
    clock.advance(3, TimeUnit.SECONDS);
    t.join();

    // Now it should terminate.
    streamingSubscriberConnection.awaitTerminated();
    assertFalse(streamingSubscriberConnection.isRunning());
    assertFalse(messageFuture.isDone());
  }

  @Test
  public void testAckDuringNackImmediatelyShutdown() throws Exception {
    SubscriberShutdownSettings shutdownSettings =
        SubscriberShutdownSettings.newBuilder()
            .setMode(SubscriberShutdownSettings.ShutdownMode.NACK_IMMEDIATELY)
            .build();

    MessageDispatcher mockMessageDispatcher = mock(MessageDispatcher.class);
    when(mockMessageDispatcher.getNackImmediatelyShutdownInProgress()).thenReturn(true);

    StreamingSubscriberConnection.Builder builder =
        StreamingSubscriberConnection.newBuilder(mock(MessageReceiverWithAckResponse.class));
    StreamingSubscriberConnection streamingSubscriberConnection =
        getStreamingSubscriberConnectionFromBuilder(builder, shutdownSettings);

    // Use reflection to set the mock message dispatcher
    java.lang.reflect.Field dispatcherField =
        StreamingSubscriberConnection.class.getDeclaredField("messageDispatcher");
    dispatcherField.setAccessible(true);
    dispatcherField.set(streamingSubscriberConnection, mockMessageDispatcher);

    streamingSubscriberConnection.setExactlyOnceDeliveryEnabled(true);

    SettableApiFuture<AckResponse> messageFuture = SettableApiFuture.create();
    AckRequestData ackRequestData =
        AckRequestData.newBuilder("ack1").setMessageFuture(messageFuture).build();

    when(mockSubscriberStub.acknowledgeCallable().futureCall(any()))
        .thenReturn(ApiFutures.immediateFuture(null));
    streamingSubscriberConnection.sendAckOperations(Collections.singletonList(ackRequestData));

    verify(mockMessageDispatcher, times(1)).notifyAckFailed(ackRequestData);
    assertEquals(AckResponse.OTHER, messageFuture.get());
  }

  @Test
  public void testSendAckOperationsExactlyOnceDisabledNoMessageFutures() {
    // Setup mocks
    List<ModackRequestData> modackRequestDataList = new ArrayList<ModackRequestData>();

    ModackRequestData modackRequestDataSuccess =
        new ModackRequestData(
            MOCK_ACK_EXTENSION_DEFAULT_SECONDS,
            AckRequestData.newBuilder(MOCK_ACK_ID_SUCCESS).build());
    modackRequestDataList.add(modackRequestDataSuccess);

    ModackRequestData modackRequestDataNack =
        new ModackRequestData(0, AckRequestData.newBuilder(MOCK_ACK_ID_SUCCESS).build());
    modackRequestDataList.add(modackRequestDataNack);

    List<AckRequestData> ackRequestDataList = new ArrayList<AckRequestData>();
    AckRequestData ackRequestDataSuccess = AckRequestData.newBuilder(MOCK_ACK_ID_SUCCESS).build();
    ackRequestDataList.add(ackRequestDataSuccess);

    // Instantiate class and run operation(s)
    StreamingSubscriberConnection streamingSubscriberConnection =
        getStreamingSubscriberConnection(false);
    streamingSubscriberConnection.sendAckOperations(ackRequestDataList);
    streamingSubscriberConnection.sendModackOperations(modackRequestDataList);

    // Assert expected behavior
    verify(mockSubscriberStub, times(2)).modifyAckDeadlineCallable();
    verify(mockSubscriberStub, times(1)).acknowledgeCallable();
  }

  @Test
  public void testSendAckOperationsExactlyOnceEnabledMessageFuturesModacks() {
    // Setup

    // The list(s) of ackIds allows us to mock the grpc response(s)
    List<String> ackIdsInitialRequest = new ArrayList<>();
    List<String> ackIdsRetryRequest = new ArrayList<>();

    Map<String, String> errorInfoMetadataMapInitialRequest = new HashMap<String, String>();
    List<ModackRequestData> modackRequestDataList = new ArrayList<ModackRequestData>();

    ModackRequestData modackRequestDataDefault =
        new ModackRequestData(MOCK_ACK_EXTENSION_DEFAULT_SECONDS);

    // Nack SUCCESS
    SettableApiFuture<AckResponse> messageFutureSuccessExpected = SettableApiFuture.create();
    ModackRequestData modackRequestDataSuccess =
        new ModackRequestData(
            0,
            AckRequestData.newBuilder(MOCK_ACK_ID_NACK_SUCCESS)
                .setMessageFuture(messageFutureSuccessExpected)
                .build());
    modackRequestDataList.add(modackRequestDataSuccess);

    // SUCCESS - no message
    SettableApiFuture<AckResponse> messageFutureNotDoneExpected = SettableApiFuture.create();
    modackRequestDataDefault.addAckRequestData(
        AckRequestData.newBuilder(MOCK_ACK_ID_SUCCESS_NO_MESSAGE)
            .setMessageFuture(messageFutureNotDoneExpected)
            .build());
    ackIdsInitialRequest.add(MOCK_ACK_ID_SUCCESS_NO_MESSAGE);

    // INVALID
    SettableApiFuture<AckResponse> messageFutureInvalidExpected = SettableApiFuture.create();
    modackRequestDataDefault.addAckRequestData(
        AckRequestData.newBuilder(MOCK_ACK_ID_INVALID)
            .setMessageFuture(messageFutureInvalidExpected)
            .build());
    errorInfoMetadataMapInitialRequest.put(MOCK_ACK_ID_INVALID, PERMANENT_FAILURE_INVALID_ACK_ID);
    ackIdsInitialRequest.add(MOCK_ACK_ID_INVALID);

    // OTHER
    SettableApiFuture<AckResponse> messageFutureOtherExpected = SettableApiFuture.create();
    modackRequestDataDefault.addAckRequestData(
        AckRequestData.newBuilder(MOCK_ACK_ID_OTHER)
            .setMessageFuture(messageFutureOtherExpected)
            .build());
    errorInfoMetadataMapInitialRequest.put(MOCK_ACK_ID_OTHER, PERMANENT_FAILURE_OTHER);
    ackIdsInitialRequest.add(MOCK_ACK_ID_OTHER);

    // Initial) FAILURE - TRANSIENT SERVICE UNAVAILABLE
    // Retry) SUCCESS - but no message future set
    SettableApiFuture<AckResponse> messageFutureTransientFailureServiceUnavailableThenSuccess =
        SettableApiFuture.create();
    modackRequestDataDefault.addAckRequestData(
        AckRequestData.newBuilder(MOCK_ACK_ID_TRANSIENT_FAILURE_SERVICE_UNAVAILABLE_THEN_SUCCESS)
            .setMessageFuture(messageFutureTransientFailureServiceUnavailableThenSuccess)
            .build());
    errorInfoMetadataMapInitialRequest.put(
        MOCK_ACK_ID_TRANSIENT_FAILURE_SERVICE_UNAVAILABLE_THEN_SUCCESS,
        TRANSIENT_FAILURE_SERVICE_UNAVAILABLE);
    ackIdsInitialRequest.add(MOCK_ACK_ID_TRANSIENT_FAILURE_SERVICE_UNAVAILABLE_THEN_SUCCESS);
    ackIdsRetryRequest.add(MOCK_ACK_ID_TRANSIENT_FAILURE_SERVICE_UNAVAILABLE_THEN_SUCCESS);

    // Initial) FAILURE - TRANSIENT - UNORDERED ACK ID
    // Retry) SUCCESS - but no message future set
    SettableApiFuture<AckResponse> messageFutureTransientFailureUnorderedAckIdThenSuccess =
        SettableApiFuture.create();
    modackRequestDataDefault.addAckRequestData(
        AckRequestData.newBuilder(MOCK_ACK_ID_TRANSIENT_FAILURE_UNORDERED_ACK_ID_THEN_SUCCESS)
            .setMessageFuture(messageFutureTransientFailureUnorderedAckIdThenSuccess)
            .build());
    errorInfoMetadataMapInitialRequest.put(
        MOCK_ACK_ID_TRANSIENT_FAILURE_UNORDERED_ACK_ID_THEN_SUCCESS,
        TRANSIENT_FAILURE_UNORDERED_ACK_ID);
    ackIdsInitialRequest.add(MOCK_ACK_ID_TRANSIENT_FAILURE_UNORDERED_ACK_ID_THEN_SUCCESS);
    ackIdsRetryRequest.add(MOCK_ACK_ID_TRANSIENT_FAILURE_UNORDERED_ACK_ID_THEN_SUCCESS);

    modackRequestDataList.add(modackRequestDataDefault);

    // Build our requests so we can set our mock responses
    ModifyAckDeadlineRequest modifyAckDeadlineRequestNack =
        ModifyAckDeadlineRequest.newBuilder()
            .setSubscription(MOCK_SUBSCRIPTION_NAME)
            .addAckIds(MOCK_ACK_ID_NACK_SUCCESS)
            .setAckDeadlineSeconds(0)
            .build();

    ModifyAckDeadlineRequest modifyAckDeadlineRequestInitial =
        ModifyAckDeadlineRequest.newBuilder()
            .setSubscription(MOCK_SUBSCRIPTION_NAME)
            .addAllAckIds(ackIdsInitialRequest)
            .setAckDeadlineSeconds(MOCK_ACK_EXTENSION_DEFAULT_SECONDS)
            .build();

    ModifyAckDeadlineRequest modifyAckDeadlineRequestRetry =
        ModifyAckDeadlineRequest.newBuilder()
            .setSubscription(MOCK_SUBSCRIPTION_NAME)
            .addAllAckIds(ackIdsRetryRequest)
            .setAckDeadlineSeconds(MOCK_ACK_EXTENSION_DEFAULT_SECONDS)
            .build();

    // Set mock grpc responses
    when(mockSubscriberStub.modifyAckDeadlineCallable().futureCall(modifyAckDeadlineRequestNack))
        .thenReturn(ApiFutures.immediateFuture(null));
    when(mockSubscriberStub.modifyAckDeadlineCallable().futureCall(modifyAckDeadlineRequestInitial))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                getMockStatusException(errorInfoMetadataMapInitialRequest)));
    when(mockSubscriberStub
            .modifyAckDeadlineCallable()
            .futureCall(
                argThat(
                    new CustomArgumentMatchers.ModifyAckDeadlineRequestMatcher(
                        modifyAckDeadlineRequestRetry))))
        .thenReturn(ApiFutures.immediateFuture(null));

    // Instantiate class and run operation(s)
    StreamingSubscriberConnection streamingSubscriberConnection =
        getStreamingSubscriberConnection(true);

    streamingSubscriberConnection.sendModackOperations(modackRequestDataList);

    // Backoff
    systemExecutor.advanceTime(Duration.ofSeconds(200));

    // Assert expected behavior
    verify(mockSubscriberStub.modifyAckDeadlineCallable(), times(1))
        .futureCall(modifyAckDeadlineRequestNack);
    verify(mockSubscriberStub.modifyAckDeadlineCallable(), times(1))
        .futureCall(modifyAckDeadlineRequestInitial);
    verify(mockSubscriberStub.modifyAckDeadlineCallable(), times(1))
        .futureCall(modifyAckDeadlineRequestRetry);
    verify(mockSubscriberStub, never()).acknowledgeCallable();

    try {
      assertEquals(AckResponse.SUCCESSFUL, messageFutureSuccessExpected.get());
      assertEquals(AckResponse.INVALID, messageFutureInvalidExpected.get());
      assertEquals(AckResponse.OTHER, messageFutureOtherExpected.get());
      assertFalse(messageFutureTransientFailureServiceUnavailableThenSuccess.isDone());
      assertFalse(messageFutureTransientFailureUnorderedAckIdThenSuccess.isDone());
    } catch (InterruptedException | ExecutionException e) {
      // In case something goes wrong retrieving the futures
      throw new AssertionError();
    }
  }

  @Test
  public void testSendAckOperationsExactlyOnceEnabledMessageFuturesAcks() {
    // Setup

    // The list(s) of ackIds allows us to mock the grpc response(s)
    List<String> ackIdsInitialRequest = new ArrayList<>();
    List<String> ackIdsRetryRequest = new ArrayList<>();

    Map<String, String> errorInfoMetadataMapInitialRequest = new HashMap<String, String>();
    List<AckRequestData> ackRequestDataList = new ArrayList<AckRequestData>();

    // SUCCESS
    SettableApiFuture<AckResponse> messageFutureSuccessExpected = SettableApiFuture.create();
    ackRequestDataList.add(
        AckRequestData.newBuilder(MOCK_ACK_ID_SUCCESS)
            .setMessageFuture(messageFutureSuccessExpected)
            .build());
    ackIdsInitialRequest.add(MOCK_ACK_ID_SUCCESS);

    // INVALID
    SettableApiFuture<AckResponse> messageFutureInvalidExpected = SettableApiFuture.create();
    ackRequestDataList.add(
        AckRequestData.newBuilder(MOCK_ACK_ID_INVALID)
            .setMessageFuture(messageFutureInvalidExpected)
            .build());
    errorInfoMetadataMapInitialRequest.put(MOCK_ACK_ID_INVALID, PERMANENT_FAILURE_INVALID_ACK_ID);
    ackIdsInitialRequest.add(MOCK_ACK_ID_INVALID);

    // OTHER
    SettableApiFuture<AckResponse> messageFutureOtherExpected = SettableApiFuture.create();
    ackRequestDataList.add(
        AckRequestData.newBuilder(MOCK_ACK_ID_OTHER)
            .setMessageFuture(messageFutureOtherExpected)
            .build());
    errorInfoMetadataMapInitialRequest.put(MOCK_ACK_ID_OTHER, PERMANENT_FAILURE_OTHER);
    ackIdsInitialRequest.add(MOCK_ACK_ID_OTHER);

    // Initial) FAILURE - TRANSIENT SERVICE UNAVAILABLE
    // Retry) SUCCESS
    SettableApiFuture<AckResponse> messageFutureTransientFailureServiceUnavailableThenSuccess =
        SettableApiFuture.create();
    ackRequestDataList.add(
        AckRequestData.newBuilder(MOCK_ACK_ID_TRANSIENT_FAILURE_SERVICE_UNAVAILABLE_THEN_SUCCESS)
            .setMessageFuture(messageFutureTransientFailureServiceUnavailableThenSuccess)
            .build());
    errorInfoMetadataMapInitialRequest.put(
        MOCK_ACK_ID_TRANSIENT_FAILURE_SERVICE_UNAVAILABLE_THEN_SUCCESS,
        TRANSIENT_FAILURE_SERVICE_UNAVAILABLE);
    ackIdsInitialRequest.add(MOCK_ACK_ID_TRANSIENT_FAILURE_SERVICE_UNAVAILABLE_THEN_SUCCESS);
    ackIdsRetryRequest.add(MOCK_ACK_ID_TRANSIENT_FAILURE_SERVICE_UNAVAILABLE_THEN_SUCCESS);

    // Initial) FAILURE - TRANSIENT - UNORDERED ACK ID
    // Retry) SUCCESS
    SettableApiFuture<AckResponse> messageFutureTransientFailureUnorderedAckIdThenSuccess =
        SettableApiFuture.create();
    ackRequestDataList.add(
        AckRequestData.newBuilder(MOCK_ACK_ID_TRANSIENT_FAILURE_UNORDERED_ACK_ID_THEN_SUCCESS)
            .setMessageFuture(messageFutureTransientFailureUnorderedAckIdThenSuccess)
            .build());
    errorInfoMetadataMapInitialRequest.put(
        MOCK_ACK_ID_TRANSIENT_FAILURE_UNORDERED_ACK_ID_THEN_SUCCESS,
        TRANSIENT_FAILURE_UNORDERED_ACK_ID);
    ackIdsInitialRequest.add(MOCK_ACK_ID_TRANSIENT_FAILURE_UNORDERED_ACK_ID_THEN_SUCCESS);
    ackIdsRetryRequest.add(MOCK_ACK_ID_TRANSIENT_FAILURE_UNORDERED_ACK_ID_THEN_SUCCESS);

    // Build our requests so we can set our mock responses
    AcknowledgeRequest acknowledgeRequestInitial =
        AcknowledgeRequest.newBuilder()
            .setSubscription(MOCK_SUBSCRIPTION_NAME)
            .addAllAckIds(ackIdsInitialRequest)
            .build();

    AcknowledgeRequest acknowledgeRequestRetry =
        AcknowledgeRequest.newBuilder()
            .setSubscription(MOCK_SUBSCRIPTION_NAME)
            .addAllAckIds(ackIdsRetryRequest)
            .build();

    // Set mock grpc responses
    when(mockSubscriberStub.acknowledgeCallable().futureCall(acknowledgeRequestInitial))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                getMockStatusException(errorInfoMetadataMapInitialRequest)));
    when(mockSubscriberStub
            .acknowledgeCallable()
            .futureCall(
                argThat(
                    new CustomArgumentMatchers.AcknowledgeRequestMatcher(acknowledgeRequestRetry))))
        .thenReturn(ApiFutures.immediateFuture(null));

    // Instantiate class and run operation(s)
    StreamingSubscriberConnection streamingSubscriberConnection =
        getStreamingSubscriberConnection(true);

    streamingSubscriberConnection.sendAckOperations(ackRequestDataList);

    // Backoff
    systemExecutor.advanceTime(Duration.ofMillis(200));

    // Assert expected behavior;
    verify(mockSubscriberStub.acknowledgeCallable(), times(1))
        .futureCall(acknowledgeRequestInitial);
    verify(mockSubscriberStub.acknowledgeCallable(), times(1))
        .futureCall(
            argThat(new CustomArgumentMatchers.AcknowledgeRequestMatcher(acknowledgeRequestRetry)));
    verify(mockSubscriberStub, never()).modifyAckDeadlineCallable();

    try {
      assertEquals(AckResponse.SUCCESSFUL, messageFutureSuccessExpected.get());
      assertEquals(AckResponse.INVALID, messageFutureInvalidExpected.get());
      assertEquals(AckResponse.OTHER, messageFutureOtherExpected.get());
      assertEquals(
          AckResponse.SUCCESSFUL, messageFutureTransientFailureServiceUnavailableThenSuccess.get());
      assertEquals(
          AckResponse.SUCCESSFUL, messageFutureTransientFailureUnorderedAckIdThenSuccess.get());
    } catch (InterruptedException | ExecutionException e) {
      // In case something goes wrong retrieving the futures
      throw new AssertionError();
    }
  }

  @Test
  public void testSendAckOperationsExactlyOnceEnabledErrorWithEmptyMetadataMap() {
    // Setup

    // The list(s) of ackIds allows us to mock the grpc response(s)
    List<String> ackIdsRequest = new ArrayList<>();
    List<AckRequestData> ackRequestDataList = new ArrayList<AckRequestData>();

    // Initial) INTERNAL error, retryable
    // Retry) PERMISSION_DENIED, not retryable
    SettableApiFuture<AckResponse> messageInternalErrorThenPermissionDenied =
        SettableApiFuture.create();
    ackRequestDataList.add(
        AckRequestData.newBuilder(MOCK_ACK_ID_NO_METADATA_MAP_INTERNAL_ERROR_THEN_PERMISSION_DENIED)
            .setMessageFuture(messageInternalErrorThenPermissionDenied)
            .build());
    ackIdsRequest.add(MOCK_ACK_ID_NO_METADATA_MAP_INTERNAL_ERROR_THEN_PERMISSION_DENIED);

    // Build our request so we can set our mock responses
    AcknowledgeRequest acknowledgeRequest =
        AcknowledgeRequest.newBuilder()
            .setSubscription(MOCK_SUBSCRIPTION_NAME)
            .addAllAckIds(ackIdsRequest)
            .build();

    ApiException internalError =
        new ApiException("internal", null, GrpcStatusCode.of(Code.INTERNAL), true);
    ApiException permissionDeniedError =
        new ApiException(
            "permission_denied", null, GrpcStatusCode.of(Code.PERMISSION_DENIED), false);
    // Set mock grpc responses
    when(mockSubscriberStub.acknowledgeCallable().futureCall(acknowledgeRequest))
        .thenReturn(ApiFutures.immediateFailedFuture(internalError))
        .thenReturn(ApiFutures.immediateFailedFuture(permissionDeniedError));

    // Instantiate class and run operation(s)
    StreamingSubscriberConnection streamingSubscriberConnection =
        getStreamingSubscriberConnection(true);

    streamingSubscriberConnection.sendAckOperations(ackRequestDataList);

    // Backoff
    systemExecutor.advanceTime(Duration.ofMillis(200));

    // Assert expected behavior;
    verify(mockSubscriberStub.acknowledgeCallable(), times(2)).futureCall(acknowledgeRequest);
    verify(mockSubscriberStub, never()).modifyAckDeadlineCallable();

    try {
      assertEquals(AckResponse.PERMISSION_DENIED, messageInternalErrorThenPermissionDenied.get());
    } catch (InterruptedException | ExecutionException e) {
      // In case something goes wrong retrieving the futures
      throw new AssertionError();
    }
  }

  @Test
  public void testSetFailureResponseOutstandingMessages() {
    // Setup

    List<AckRequestData> ackRequestDataList = new ArrayList<AckRequestData>();
    List<AckRequestData> nackRequestDataList = new ArrayList<AckRequestData>();
    List<SettableApiFuture<AckResponse>> futureList =
        new ArrayList<SettableApiFuture<AckResponse>>();

    // Create some acks
    for (int i = 0; i < 5; i++) {
      SettableApiFuture<AckResponse> future = SettableApiFuture.create();
      futureList.add(future);
      ackRequestDataList.add(
          AckRequestData.newBuilder("ACK-ID-" + i).setMessageFuture(future).build());
    }

    // Create some nacks
    for (int i = 5; i < 10; i++) {
      SettableApiFuture<AckResponse> future = SettableApiFuture.create();
      futureList.add(future);
      nackRequestDataList.add(
          AckRequestData.newBuilder("ACK-ID-" + i).setMessageFuture(future).build());
    }

    ModackRequestData modackRequestData = new ModackRequestData(0, nackRequestDataList);

    StreamingSubscriberConnection streamingSubscriberConnection =
        getStreamingSubscriberConnection(true);

    streamingSubscriberConnection.sendAckOperations(ackRequestDataList);
    streamingSubscriberConnection.sendModackOperations(
        Collections.singletonList(modackRequestData));

    // Assert pending status
    futureList.forEach(
        ackResponseSettableApiFuture -> {
          assertFalse(ackResponseSettableApiFuture.isDone());
        });

    // Set
    streamingSubscriberConnection.setResponseOutstandingMessages(AckResponse.PERMISSION_DENIED);

    // Assert futures

    futureList.forEach(
        ackResponseSettableApiFuture -> {
          try {
            assertEquals(ackResponseSettableApiFuture.get(), AckResponse.PERMISSION_DENIED);
          } catch (InterruptedException | ExecutionException e) {
            // In case something goes wrong retrieving the futures
            throw new AssertionError();
          }
        });
  }

  @Test
  public void testMaxPerRequestChanges() {
    // Setup mocks
    List<ModackRequestData> modackRequestDataList = new ArrayList<ModackRequestData>();
    List<AckRequestData> ackRequestDataList = new ArrayList<AckRequestData>();

    int numAckIds = 3000;
    int numMaxPerRequestChanges = 1000;

    List<String> mockAckIds = new ArrayList<String>();

    for (int i = 0; i < numAckIds; i++) {
      String mockAckId = "MOCK-ACK-ID-" + i;
      mockAckIds.add(mockAckId);
      ackRequestDataList.add(AckRequestData.newBuilder(mockAckId).build());
    }

    modackRequestDataList.add(
        new ModackRequestData(MOCK_ACK_EXTENSION_DEFAULT_SECONDS, ackRequestDataList));

    // Instantiate class and run operation(s)
    StreamingSubscriberConnection streamingSubscriberConnection =
        getStreamingSubscriberConnection(false);
    streamingSubscriberConnection.sendAckOperations(ackRequestDataList);
    streamingSubscriberConnection.sendModackOperations(modackRequestDataList);

    // Assert expected behavior
    for (List<String> mockAckIdsInRequest : Lists.partition(mockAckIds, numMaxPerRequestChanges)) {
      AcknowledgeRequest expectedAcknowledgeRequest =
          AcknowledgeRequest.newBuilder()
              .setSubscription(MOCK_SUBSCRIPTION_NAME)
              .addAllAckIds(mockAckIdsInRequest)
              .build();
      verify(mockSubscriberStub.acknowledgeCallable(), times(1))
          .futureCall(expectedAcknowledgeRequest);

      ModifyAckDeadlineRequest expectedModifyAckDeadlineRequest =
          ModifyAckDeadlineRequest.newBuilder()
              .setSubscription(MOCK_SUBSCRIPTION_NAME)
              .addAllAckIds(mockAckIdsInRequest)
              .setAckDeadlineSeconds(MOCK_ACK_EXTENSION_DEFAULT_SECONDS)
              .build();
      verify(mockSubscriberStub.modifyAckDeadlineCallable(), times(1))
          .futureCall(expectedModifyAckDeadlineRequest);
    }
  }

  @Test
  public void testClientPinger_pingSent() {
    BidiStreamingCallable<StreamingPullRequest, StreamingPullResponse> mockStreamingCallable =
        mock(BidiStreamingCallable.class);
    ClientStream<StreamingPullRequest> mockClientStream = mock(ClientStream.class);
    when(mockSubscriberStub.streamingPullCallable()).thenReturn(mockStreamingCallable);
    when(mockStreamingCallable.splitCall(any(ResponseObserver.class), any()))
        .thenReturn(mockClientStream);

    StreamingSubscriberConnection streamingSubscriberConnection =
        getKeepaliveStreamingSubscriberConnection();

    streamingSubscriberConnection.startAsync();
    streamingSubscriberConnection.awaitRunning();

    systemExecutor.advanceTime(CLIENT_PING_INTERVAL);
    systemExecutor.advanceTime(CLIENT_PING_INTERVAL);

    ArgumentCaptor<StreamingPullRequest> requestCaptor =
        ArgumentCaptor.forClass(StreamingPullRequest.class);
    // 1 initial request + 3 pings
    verify(mockClientStream, times(4)).send(requestCaptor.capture());
    List<StreamingPullRequest> requests = requestCaptor.getAllValues();

    StreamingPullRequest initialRequest = requests.get(0);
    assertEquals(MOCK_SUBSCRIPTION_NAME, initialRequest.getSubscription());
    assertEquals(KEEP_ALIVE_SUPPORT_VERSION, initialRequest.getProtocolVersion());
    assertEquals(0, initialRequest.getMaxOutstandingMessages());

    StreamingPullRequest firstPing = requests.get(1);
    assertEquals(StreamingPullRequest.getDefaultInstance(), firstPing);

    StreamingPullRequest secondPing = requests.get(2);
    assertEquals(StreamingPullRequest.getDefaultInstance(), secondPing);

    streamingSubscriberConnection.stopAsync();
    streamingSubscriberConnection.awaitTerminated();

    // No more pings
    systemExecutor.advanceTime(CLIENT_PING_INTERVAL);
    verify(mockClientStream, times(4)).send(any(StreamingPullRequest.class));
  }

  @Test
  public void testClientPinger_pingsNotSentWhenDisabled() {
    BidiStreamingCallable<StreamingPullRequest, StreamingPullResponse> mockStreamingCallable =
        mock(BidiStreamingCallable.class);
    ClientStream<StreamingPullRequest> mockClientStream = mock(ClientStream.class);
    when(mockSubscriberStub.streamingPullCallable()).thenReturn(mockStreamingCallable);
    when(mockStreamingCallable.splitCall(any(ResponseObserver.class), any()))
        .thenReturn(mockClientStream);

    StreamingSubscriberConnection streamingSubscriberConnection =
        getStreamingSubscriberConnection(false); // keepalive disabled

    streamingSubscriberConnection.startAsync();
    streamingSubscriberConnection.awaitRunning();

    // Initial request.
    verify(mockClientStream, times(1)).send(any(StreamingPullRequest.class));

    // No pings
    systemExecutor.advanceTime(CLIENT_PING_INTERVAL);
    systemExecutor.advanceTime(CLIENT_PING_INTERVAL);

    verify(mockClientStream, times(1)).send(any(StreamingPullRequest.class));
  }

  @Test
  public void testServerMonitor_timesOut() {
    BidiStreamingCallable<StreamingPullRequest, StreamingPullResponse> mockStreamingCallable =
        mock(BidiStreamingCallable.class);
    ClientStream<StreamingPullRequest> mockClientStream = mock(ClientStream.class);
    ArgumentCaptor<ResponseObserver<StreamingPullResponse>> observerCaptor =
        ArgumentCaptor.forClass(ResponseObserver.class);
    when(mockSubscriberStub.streamingPullCallable()).thenReturn(mockStreamingCallable);
    when(mockStreamingCallable.splitCall(observerCaptor.capture(), any()))
        .thenReturn(mockClientStream);

    // fail pings after the first one to ensure timeout occurs
    AtomicInteger pingCount = new AtomicInteger(0);
    doAnswer(
            (invocation) -> {
              StreamingPullRequest req = invocation.getArgument(0);
              // Pings are empty requests
              if (req.getSubscription().isEmpty()) {
                if (pingCount.incrementAndGet() > 2) { // allow first 2 pings
                  throw new RuntimeException("ping failed");
                }
              }
              return null;
            })
        .when(mockClientStream)
        .send(any(StreamingPullRequest.class));

    StreamingSubscriberConnection streamingSubscriberConnection =
        getKeepaliveStreamingSubscriberConnection();

    streamingSubscriberConnection.startAsync();
    streamingSubscriberConnection.awaitRunning();

    ResponseObserver<StreamingPullResponse> observer = observerCaptor.getValue();
    StreamController mockController = mock(StreamController.class);
    observer.onStart(mockController);

    systemExecutor.advanceTime(CLIENT_PING_INTERVAL);
    verify(mockClientStream, never()).closeSendWithError(any(Exception.class));

    systemExecutor.advanceTime(CLIENT_PING_INTERVAL);
    ArgumentCaptor<Exception> exceptionCaptor = ArgumentCaptor.forClass(Exception.class);
    verify(mockClientStream, times(1)).closeSendWithError(exceptionCaptor.capture());
    StatusException exception = (StatusException) exceptionCaptor.getValue();
    assertEquals(Code.UNAVAILABLE, exception.getStatus().getCode());
    assertEquals("Keepalive timeout with server", exception.getStatus().getDescription());
  }

  @Test
  public void testServerMonitor_doesNotTimeOutIfResponseReceived() {
    BidiStreamingCallable<StreamingPullRequest, StreamingPullResponse> mockStreamingCallable =
        mock(BidiStreamingCallable.class);
    ClientStream<StreamingPullRequest> mockClientStream = mock(ClientStream.class);
    ArgumentCaptor<ResponseObserver<StreamingPullResponse>> observerCaptor =
        ArgumentCaptor.forClass(ResponseObserver.class);
    when(mockSubscriberStub.streamingPullCallable()).thenReturn(mockStreamingCallable);
    when(mockStreamingCallable.splitCall(observerCaptor.capture(), any()))
        .thenReturn(mockClientStream);

    StreamingSubscriberConnection streamingSubscriberConnection =
        getKeepaliveStreamingSubscriberConnection();

    streamingSubscriberConnection.startAsync();
    streamingSubscriberConnection.awaitRunning();

    ResponseObserver<StreamingPullResponse> observer = observerCaptor.getValue();
    StreamController mockController = mock(StreamController.class);
    observer.onStart(mockController);

    // t=30s: ping sent.
    // t=40s: response received.
    // t=45s: monitor check. lastPing=30, lastResponse=40. lastPing>lastResponse is false -> no
    // timeout.
    systemExecutor.advanceTime(Duration.ofSeconds(40));
    observer.onResponse(StreamingPullResponse.getDefaultInstance());
    systemExecutor.advanceTime(Duration.ofSeconds(20)); // to t=60s
    observer.onResponse(StreamingPullResponse.getDefaultInstance());

    verify(mockClientStream, never()).closeSendWithError(any(Exception.class));
  }

  private StreamingSubscriberConnection getStreamingSubscriberConnection(
      boolean exactlyOnceDeliveryEnabled) {
    StreamingSubscriberConnection streamingSubscriberConnection =
        getStreamingSubscriberConnectionFromBuilder(
            StreamingSubscriberConnection.newBuilder(mock(MessageReceiverWithAckResponse.class)));

    // This would normally be set from the streaming pull response
    streamingSubscriberConnection.setExactlyOnceDeliveryEnabled(exactlyOnceDeliveryEnabled);

    return streamingSubscriberConnection;
  }

  private StreamingSubscriberConnection getKeepaliveStreamingSubscriberConnection() {
    StreamingSubscriberConnection streamingSubscriberConnection =
        getStreamingSubscriberConnectionFromBuilder(
            StreamingSubscriberConnection.newBuilder(mock(MessageReceiverWithAckResponse.class))
                .setProtocolVersion(KEEP_ALIVE_SUPPORT_VERSION));

    return streamingSubscriberConnection;
  }

  private StreamingSubscriberConnection getStreamingSubscriberConnectionFromBuilder(
      StreamingSubscriberConnection.Builder builder) {
    return builder
        .setSubscription(MOCK_SUBSCRIPTION_NAME)
        .setAckExpirationPadding(ACK_EXPIRATION_PADDING_DEFAULT_DURATION)
        .setMaxAckExtensionPeriod(MAX_ACK_EXTENSION_PERIOD)
        .setAckLatencyDistribution(mock(Distribution.class))
        .setSubscriberStub(mockSubscriberStub)
        .setChannelAffinity(0)
        .setFlowControlSettings(mock(FlowControlSettings.class))
        .setFlowController(mock(FlowController.class))
        .setExecutor(executor)
        .setSystemExecutor(systemExecutor)
        .setClock(clock)
        .setMinDurationPerAckExtension(Subscriber.DEFAULT_MIN_ACK_DEADLINE_EXTENSION)
        .setMinDurationPerAckExtensionDefaultUsed(true)
        .setMaxDurationPerAckExtension(Subscriber.DEFAULT_MAX_ACK_DEADLINE_EXTENSION)
        .setMaxDurationPerAckExtensionDefaultUsed(true)
        .setSubscriberShutdownSettings(SubscriberShutdownSettings.newBuilder().build())
        .build();
  }

  private StreamingSubscriberConnection getStreamingSubscriberConnectionFromBuilder(
      StreamingSubscriberConnection.Builder builder, SubscriberShutdownSettings shutdownSettings) {
    return builder
        .setSubscription(MOCK_SUBSCRIPTION_NAME)
        .setAckExpirationPadding(ACK_EXPIRATION_PADDING_DEFAULT_DURATION)
        .setAckLatencyDistribution(mock(Distribution.class))
        .setSubscriberStub(mockSubscriberStub)
        .setChannelAffinity(0)
        .setFlowControlSettings(mock(FlowControlSettings.class))
        .setFlowController(mock(FlowController.class))
        .setExecutor(executor)
        .setSystemExecutor(systemExecutor)
        .setClock(clock)
        .setMinDurationPerAckExtension(Subscriber.DEFAULT_MIN_ACK_DEADLINE_EXTENSION)
        .setMinDurationPerAckExtensionDefaultUsed(true)
        .setMaxDurationPerAckExtension(Subscriber.DEFAULT_MAX_ACK_DEADLINE_EXTENSION)
        .setMaxDurationPerAckExtensionDefaultUsed(true)
        .setSubscriberShutdownSettings(shutdownSettings)
        .build();
  }

  private StatusException getMockStatusException(Map<String, String> metadata) {
    ErrorInfo errorInfo = ErrorInfo.newBuilder().putAllMetadata(metadata).build();
    Status status =
        Status.newBuilder()
            .setCode(StatusCode.Code.OK.ordinal())
            .addDetails(Any.pack(errorInfo))
            .build();
    return StatusProto.toStatusException(status);
  }
}
