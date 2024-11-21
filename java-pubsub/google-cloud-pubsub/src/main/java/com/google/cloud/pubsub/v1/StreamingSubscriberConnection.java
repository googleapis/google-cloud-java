/*
 * Copyright 2016 Google LLC
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

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.AbstractApiService;
import com.google.api.core.ApiClock;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.Distribution;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.pubsub.v1.MessageDispatcher.AckProcessor;
import com.google.cloud.pubsub.v1.stub.SubscriberStub;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.StreamingPullRequest;
import com.google.pubsub.v1.StreamingPullResponse;
import com.google.rpc.ErrorInfo;
import io.grpc.Status;
import io.grpc.protobuf.StatusProto;
import io.opentelemetry.api.trace.Span;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/** Implementation of {@link AckProcessor} based on Cloud Pub/Sub streaming pull. */
final class StreamingSubscriberConnection extends AbstractApiService implements AckProcessor {
  private static final Logger logger =
      Logger.getLogger(StreamingSubscriberConnection.class.getName());

  private static final Duration INITIAL_CHANNEL_RECONNECT_BACKOFF = Duration.ofMillis(100);
  private static final Duration MAX_CHANNEL_RECONNECT_BACKOFF = Duration.ofSeconds(10);

  private static final long INITIAL_ACK_OPERATIONS_RECONNECT_BACKOFF_MILLIS = 100;
  private static final long MAX_ACK_OPERATIONS_RECONNECT_BACKOFF_MILLIS =
      Duration.ofSeconds(10).toMillis();
  private static final int MAX_PER_REQUEST_CHANGES = 1000;

  private final String PERMANENT_FAILURE_INVALID_ACK_ID_METADATA =
      "PERMANENT_FAILURE_INVALID_ACK_ID";
  private final String TRANSIENT_FAILURE_METADATA_PREFIX = "TRANSIENT_";

  private Duration inititalStreamAckDeadline;

  private final Map<String, List<String>> streamMetadata;

  private final SubscriberStub subscriberStub;
  private final int channelAffinity;
  private final String subscription;
  private final ScheduledExecutorService systemExecutor;
  private final MessageDispatcher messageDispatcher;

  private final FlowControlSettings flowControlSettings;
  private final boolean useLegacyFlowControl;

  // Keeps track of requests without closed futures
  private final Set<AckRequestData> pendingRequests = ConcurrentHashMap.newKeySet();

  private final AtomicLong channelReconnectBackoffMillis =
      new AtomicLong(INITIAL_CHANNEL_RECONNECT_BACKOFF.toMillis());
  private final Waiter ackOperationsWaiter = new Waiter();

  private final Lock lock = new ReentrantLock();
  private ClientStream<StreamingPullRequest> clientStream;

  private AtomicBoolean exactlyOnceDeliveryEnabled = new AtomicBoolean(false);

  /**
   * The same clientId is used across all streaming pull connections that are created. This is
   * intentional, as it indicates to the server that any guarantees made for a stream that
   * disconnected will be made for the stream that is created to replace it.
   */
  private final String clientId = UUID.randomUUID().toString();

  private final boolean enableOpenTelemetryTracing;
  private OpenTelemetryPubsubTracer tracer = new OpenTelemetryPubsubTracer(null, false);

  private StreamingSubscriberConnection(Builder builder) {
    subscription = builder.subscription;
    systemExecutor = builder.systemExecutor;

    // We need to set the default stream ack deadline on the initial request, this will be
    // updated by modack requests in the message dispatcher
    if (builder.maxDurationPerAckExtensionDefaultUsed) {
      inititalStreamAckDeadline = Subscriber.STREAM_ACK_DEADLINE_DEFAULT;
    } else if (builder.maxDurationPerAckExtension.compareTo(Subscriber.MIN_STREAM_ACK_DEADLINE)
        < 0) {
      // We will not be able to extend more than the default minimum
      inititalStreamAckDeadline = Subscriber.MIN_STREAM_ACK_DEADLINE;
    } else if (builder.maxDurationPerAckExtension.compareTo(Subscriber.MAX_STREAM_ACK_DEADLINE)
        > 0) {
      // Will not be able to extend past the max
      inititalStreamAckDeadline = Subscriber.MAX_STREAM_ACK_DEADLINE;
    } else {
      inititalStreamAckDeadline = builder.maxDurationPerAckExtension;
    }

    streamMetadata =
        ImmutableMap.of("x-goog-request-params", ImmutableList.of("subscription=" + subscription));

    subscriberStub = builder.subscriberStub;
    channelAffinity = builder.channelAffinity;

    MessageDispatcher.Builder messageDispatcherBuilder;
    if (builder.receiver != null) {
      messageDispatcherBuilder = MessageDispatcher.newBuilder(builder.receiver);
    } else {
      messageDispatcherBuilder = MessageDispatcher.newBuilder(builder.receiverWithAckResponse);
    }

    enableOpenTelemetryTracing = builder.enableOpenTelemetryTracing;
    if (builder.tracer != null) {
      tracer = builder.tracer;
    }

    messageDispatcher =
        messageDispatcherBuilder
            .setAckProcessor(this)
            .setAckExpirationPadding(builder.ackExpirationPadding)
            .setMaxAckExtensionPeriod(builder.maxAckExtensionPeriod)
            .setMinDurationPerAckExtension(builder.minDurationPerAckExtension)
            .setMinDurationPerAckExtensionDefaultUsed(builder.minDurationPerAckExtensionDefaultUsed)
            .setMaxDurationPerAckExtension(builder.maxDurationPerAckExtension)
            .setMaxDurationPerAckExtensionDefaultUsed(builder.maxDurationPerAckExtensionDefaultUsed)
            .setAckLatencyDistribution(builder.ackLatencyDistribution)
            .setFlowController(builder.flowController)
            .setExecutor(builder.executor)
            .setSystemExecutor(builder.systemExecutor)
            .setApiClock(builder.clock)
            .setSubscriptionName(subscription)
            .setEnableOpenTelemetryTracing(enableOpenTelemetryTracing)
            .setTracer(tracer)
            .build();

    flowControlSettings = builder.flowControlSettings;
    useLegacyFlowControl = builder.useLegacyFlowControl;
  }

  public StreamingSubscriberConnection setExactlyOnceDeliveryEnabled(
      boolean isExactlyOnceDeliveryEnabled) {
    exactlyOnceDeliveryEnabled.set(isExactlyOnceDeliveryEnabled);
    return this;
  }

  public boolean getExactlyOnceDeliveryEnabled() {
    return exactlyOnceDeliveryEnabled.get();
  }

  @Override
  protected void doStart() {
    logger.config("Starting subscriber.");
    messageDispatcher.start();
    initialize();
    notifyStarted();
  }

  @Override
  protected void doStop() {
    lock.lock();
    try {
      clientStream.closeSendWithError(Status.CANCELLED.asException());
    } finally {
      lock.unlock();
    }
    runShutdown();
    notifyStopped();
  }

  private void runShutdown() {
    messageDispatcher.stop();
    ackOperationsWaiter.waitComplete();
  }

  private class StreamingPullResponseObserver implements ResponseObserver<StreamingPullResponse> {

    final SettableApiFuture<Void> errorFuture;

    /**
     * When a batch finsihes processing, we want to request one more batch from the server. But by
     * the time this happens, our stream might have already errored, and new stream created. We
     * don't want to request more batches from the new stream -- that might pull more messages than
     * the user can deal with -- so we save the request observer this response observer is "paired
     * with". If the stream has already errored, requesting more messages is a no-op.
     */
    StreamController thisController;

    StreamingPullResponseObserver(SettableApiFuture<Void> errorFuture) {
      this.errorFuture = errorFuture;
    }

    @Override
    public void onStart(StreamController controller) {
      thisController = controller;
      thisController.disableAutoInboundFlowControl();
      thisController.request(1);
    }

    @Override
    public void onResponse(StreamingPullResponse response) {
      channelReconnectBackoffMillis.set(INITIAL_CHANNEL_RECONNECT_BACKOFF.toMillis());

      boolean exactlyOnceDeliveryEnabledResponse =
          response.getSubscriptionProperties().getExactlyOnceDeliveryEnabled();
      boolean messageOrderingEnabledResponse =
          response.getSubscriptionProperties().getMessageOrderingEnabled();

      setExactlyOnceDeliveryEnabled(exactlyOnceDeliveryEnabledResponse);
      messageDispatcher.setExactlyOnceDeliveryEnabled(exactlyOnceDeliveryEnabledResponse);
      messageDispatcher.setMessageOrderingEnabled(messageOrderingEnabledResponse);
      messageDispatcher.processReceivedMessages(response.getReceivedMessagesList());

      // Only request more if we're not shutdown.
      // If errorFuture is done, the stream has either failed or hung up,
      // and we don't need to request.
      if (isAlive() && !errorFuture.isDone()) {
        lock.lock();
        try {
          thisController.request(1);
        } catch (Exception e) {
          logger.log(Level.WARNING, "cannot request more messages", e);
        } finally {
          lock.unlock();
        }
      }
    }

    @Override
    public void onError(Throwable t) {
      errorFuture.setException(t);
    }

    @Override
    public void onComplete() {
      logger.fine("Streaming pull terminated successfully!");
      errorFuture.set(null);
    }
  }

  private void initialize() {
    final SettableApiFuture<Void> errorFuture = SettableApiFuture.create();

    final ResponseObserver<StreamingPullResponse> responseObserver =
        new StreamingPullResponseObserver(errorFuture);

    ClientStream<StreamingPullRequest> initClientStream =
        subscriberStub
            .streamingPullCallable()
            .splitCall(
                responseObserver,
                GrpcCallContext.createDefault()
                    .withChannelAffinity(channelAffinity)
                    .withExtraHeaders(streamMetadata));

    logger.log(Level.FINER, "Initializing stream to subscription {0}", subscription);
    // We need to set streaming ack deadline, but it's not useful since we'll modack to send receipt
    // anyway. Set to some big-ish value in case we modack late.
    initClientStream.send(
        StreamingPullRequest.newBuilder()
            .setSubscription(subscription)
            .setStreamAckDeadlineSeconds(Math.toIntExact(inititalStreamAckDeadline.getSeconds()))
            .setClientId(clientId)
            .setMaxOutstandingMessages(
                this.useLegacyFlowControl
                    ? 0
                    : valueOrZero(flowControlSettings.getMaxOutstandingElementCount()))
            .setMaxOutstandingBytes(
                this.useLegacyFlowControl
                    ? 0
                    : valueOrZero(flowControlSettings.getMaxOutstandingRequestBytes()))
            .build());

    /**
     * Must make sure we do this after sending the subscription name and deadline. Otherwise, some
     * other thread might use this stream to do something else before we could send the first
     * request.
     */
    lock.lock();
    try {
      this.clientStream = initClientStream;
    } finally {
      lock.unlock();
    }

    ApiFutures.addCallback(
        errorFuture,
        new ApiFutureCallback<Void>() {
          @Override
          public void onSuccess(@Nullable Void result) {
            if (!isAlive()) {
              return;
            }
            channelReconnectBackoffMillis.set(INITIAL_CHANNEL_RECONNECT_BACKOFF.toMillis());
            // The stream was closed. And any case we want to reopen it to continue receiving
            // messages.
            initialize();
          }

          @Override
          public void onFailure(Throwable cause) {
            if (!isAlive()) {
              // we don't care about subscription failures when we're no longer running.
              logger.log(Level.FINE, "pull failure after service no longer running", cause);
              return;
            }
            if (!StatusUtil.isRetryable(cause)) {
              ApiException gaxException =
                  ApiExceptionFactory.createException(
                      cause, GrpcStatusCode.of(Status.fromThrowable(cause).getCode()), false);
              logger.log(Level.SEVERE, "terminated streaming with exception", gaxException);
              runShutdown();
              setFailureFutureOutstandingMessages(cause);
              notifyFailed(gaxException);
              return;
            }
            logger.log(Level.FINE, "stream closed with retryable exception; will reconnect", cause);
            long backoffMillis = channelReconnectBackoffMillis.get();
            long newBackoffMillis =
                Math.min(backoffMillis * 2, MAX_CHANNEL_RECONNECT_BACKOFF.toMillis());
            channelReconnectBackoffMillis.set(newBackoffMillis);

            systemExecutor.schedule(
                new Runnable() {
                  @Override
                  public void run() {
                    initialize();
                  }
                },
                backoffMillis,
                TimeUnit.MILLISECONDS);
          }
        },
        MoreExecutors.directExecutor());
  }

  private Long valueOrZero(Long value) {
    return value != null ? value : 0;
  }

  private boolean isAlive() {
    State state = state(); // Read the state only once.
    return state == State.RUNNING || state == State.STARTING;
  }

  public void setResponseOutstandingMessages(AckResponse ackResponse) {
    // We will close the futures with ackResponse - if there are multiple references to the same
    // future they will be handled appropriately
    logger.log(
        Level.WARNING, "Setting response: {0} on outstanding messages", ackResponse.toString());
    for (AckRequestData ackRequestData : pendingRequests) {
      ackRequestData.setResponse(ackResponse, false);
    }

    // Clear our pending requests
    pendingRequests.clear();
  }

  private void setFailureFutureOutstandingMessages(Throwable t) {
    AckResponse ackResponse;

    if (getExactlyOnceDeliveryEnabled()) {
      if (!(t instanceof ApiException)) {
        ackResponse = AckResponse.OTHER;
      }

      ApiException apiException = (ApiException) t;
      switch (apiException.getStatusCode().getCode()) {
        case FAILED_PRECONDITION:
          ackResponse = AckResponse.FAILED_PRECONDITION;
          break;
        case PERMISSION_DENIED:
          ackResponse = AckResponse.PERMISSION_DENIED;
          break;
        default:
          ackResponse = AckResponse.OTHER;
      }
    } else {
      // We should set success regardless if ExactlyOnceDelivery is not enabled
      ackResponse = AckResponse.SUCCESSFUL;
    }

    setResponseOutstandingMessages(ackResponse);
  }

  @Override
  public void sendAckOperations(List<AckRequestData> ackRequestDataList) {
    sendAckOperations(ackRequestDataList, INITIAL_ACK_OPERATIONS_RECONNECT_BACKOFF_MILLIS);
  }

  @Override
  public void sendModackOperations(List<ModackRequestData> modackRequestDataList) {
    sendModackOperations(modackRequestDataList, INITIAL_ACK_OPERATIONS_RECONNECT_BACKOFF_MILLIS);
  }

  private void sendAckOperations(
      List<AckRequestData> ackRequestDataList, long currentBackoffMillis) {
    int pendingOperations = 0;
    for (List<AckRequestData> ackRequestDataInRequestList :
        Lists.partition(ackRequestDataList, MAX_PER_REQUEST_CHANGES)) {
      List<String> ackIdsInRequest = new ArrayList<>();
      List<PubsubMessageWrapper> messagesInRequest = new ArrayList<>();
      for (AckRequestData ackRequestData : ackRequestDataInRequestList) {
        ackIdsInRequest.add(ackRequestData.getAckId());
        messagesInRequest.add(ackRequestData.getMessageWrapper());
        if (ackRequestData.hasMessageFuture()) {
          // Add to our pending requests if we care about the response
          pendingRequests.add(ackRequestData);
        }
      }
      // Creates an Ack span to be passed to the callback
      Span rpcSpan = tracer.startSubscribeRpcSpan(subscription, "ack", messagesInRequest, 0, false);
      ApiFutureCallback<Empty> callback =
          getCallback(ackRequestDataInRequestList, 0, false, currentBackoffMillis, rpcSpan);
      ApiFuture<Empty> ackFuture =
          subscriberStub
              .acknowledgeCallable()
              .futureCall(
                  AcknowledgeRequest.newBuilder()
                      .setSubscription(subscription)
                      .addAllAckIds(ackIdsInRequest)
                      .build());
      ApiFutures.addCallback(ackFuture, callback, directExecutor());
      pendingOperations++;
    }
    ackOperationsWaiter.incrementPendingCount(pendingOperations);
  }

  private void sendModackOperations(
      List<ModackRequestData> modackRequestDataList, long currentBackoffMillis) {
    // Send modacks
    int pendingOperations = 0;
    for (ModackRequestData modackRequestData : modackRequestDataList) {
      for (List<AckRequestData> ackRequestDataInRequestList :
          Lists.partition(modackRequestData.getAckRequestData(), MAX_PER_REQUEST_CHANGES)) {
        List<String> ackIdsInRequest = new ArrayList<>();
        List<PubsubMessageWrapper> messagesInRequest = new ArrayList<>();
        for (AckRequestData ackRequestData : ackRequestDataInRequestList) {
          ackIdsInRequest.add(ackRequestData.getAckId());
          messagesInRequest.add(ackRequestData.getMessageWrapper());
          if (ackRequestData.hasMessageFuture()) {
            // Add to our pending requests if we care about the response
            pendingRequests.add(ackRequestData);
          }
        }
        int deadlineExtensionSeconds = modackRequestData.getDeadlineExtensionSeconds();
        String rpcOperation = deadlineExtensionSeconds == 0 ? "nack" : "modack";
        // Creates either a ModAck span or a Nack span depending on the given ack deadline
        Span rpcSpan =
            tracer.startSubscribeRpcSpan(
                subscription,
                rpcOperation,
                messagesInRequest,
                deadlineExtensionSeconds,
                modackRequestData.getIsReceiptModack());
        ApiFutureCallback<Empty> callback =
            getCallback(
                modackRequestData.getAckRequestData(),
                deadlineExtensionSeconds,
                true,
                currentBackoffMillis,
                rpcSpan);
        ApiFuture<Empty> modackFuture =
            subscriberStub
                .modifyAckDeadlineCallable()
                .futureCall(
                    ModifyAckDeadlineRequest.newBuilder()
                        .setSubscription(subscription)
                        .addAllAckIds(ackIdsInRequest)
                        .setAckDeadlineSeconds(modackRequestData.getDeadlineExtensionSeconds())
                        .build());
        ApiFutures.addCallback(modackFuture, callback, directExecutor());
        pendingOperations++;
      }
    }
    ackOperationsWaiter.incrementPendingCount(pendingOperations);
  }

  private Map<String, String> getMetadataMapFromThrowable(Throwable t)
      throws InvalidProtocolBufferException {
    // This converts a Throwable (from a "OK" grpc response) to a map of metadata
    // will be of the format:
    // {
    //    "ACK-ID-1": "PERMANENT_*",
    //    "ACK-ID-2": "TRANSIENT_*"
    // }
    com.google.rpc.Status status = StatusProto.fromThrowable(t);
    Map<String, String> metadataMap = new HashMap<>();
    if (status != null) {
      for (Any any : status.getDetailsList()) {
        if (any.is(ErrorInfo.class)) {
          ErrorInfo errorInfo = any.unpack(ErrorInfo.class);
          metadataMap = errorInfo.getMetadataMap();
        }
      }
    }
    return metadataMap;
  }

  private ApiFutureCallback<Empty> getCallback(
      List<AckRequestData> ackRequestDataList,
      int deadlineExtensionSeconds,
      boolean isModack,
      long currentBackoffMillis,
      Span rpcSpan) {
    // This callback handles retries, and sets message futures

    // Check if ack or nack
    boolean setResponseOnSuccess = (!isModack || (deadlineExtensionSeconds == 0)) ? true : false;

    boolean rpcSpanSampled = rpcSpan == null ? false : rpcSpan.getSpanContext().isSampled();

    return new ApiFutureCallback<Empty>() {
      @Override
      public void onSuccess(Empty empty) {
        ackOperationsWaiter.incrementPendingCount(-1);

        tracer.endSubscribeRpcSpan(rpcSpan);

        for (AckRequestData ackRequestData : ackRequestDataList) {
          // This will check if a response is needed, and if it has already been set
          ackRequestData.setResponse(AckResponse.SUCCESSFUL, setResponseOnSuccess);
          messageDispatcher.notifyAckSuccess(ackRequestData);
          // Remove from our pending operations
          pendingRequests.remove(ackRequestData);
          tracer.addEndRpcEvent(
              ackRequestData.getMessageWrapper(),
              rpcSpanSampled,
              isModack,
              deadlineExtensionSeconds);
          if (!isModack || deadlineExtensionSeconds == 0) {
            tracer.endSubscriberSpan(ackRequestData.getMessageWrapper());
          }
        }
      }

      @Override
      public void onFailure(Throwable t) {
        // Remove from our pending operations
        ackOperationsWaiter.incrementPendingCount(-1);

        Level level = isAlive() ? Level.WARNING : Level.FINER;
        logger.log(level, "failed to send operations", t);

        tracer.setSubscribeRpcSpanException(rpcSpan, isModack, deadlineExtensionSeconds, t);

        if (!getExactlyOnceDeliveryEnabled()) {
          if (enableOpenTelemetryTracing) {
            for (AckRequestData ackRequestData : ackRequestDataList) {
              tracer.addEndRpcEvent(
                  ackRequestData.getMessageWrapper(),
                  rpcSpanSampled,
                  isModack,
                  deadlineExtensionSeconds);
              if (!isModack || deadlineExtensionSeconds == 0) {
                tracer.endSubscriberSpan(ackRequestData.getMessageWrapper());
              }
            }
          }
          return;
        }
        List<AckRequestData> ackRequestDataArrayRetryList = new ArrayList<>();
        try {
          Map<String, String> metadataMap = getMetadataMapFromThrowable(t);
          ackRequestDataList.forEach(
              ackRequestData -> {
                String ackId = ackRequestData.getAckId();
                if (metadataMap.containsKey(ackId)) {
                  // An error occured
                  String errorMessage = metadataMap.get(ackId);
                  if (errorMessage.startsWith(TRANSIENT_FAILURE_METADATA_PREFIX)) {
                    // Retry all "TRANSIENT_*" error messages - do not set message future
                    logger.log(Level.INFO, "Transient error message, will resend", errorMessage);
                    ackRequestDataArrayRetryList.add(ackRequestData);
                  } else if (errorMessage.equals(PERMANENT_FAILURE_INVALID_ACK_ID_METADATA)) {
                    // Permanent failure, send
                    logger.log(
                        Level.INFO,
                        "Permanent error invalid ack id message, will not resend",
                        errorMessage);
                    ackRequestData.setResponse(AckResponse.INVALID, setResponseOnSuccess);
                    messageDispatcher.notifyAckFailed(ackRequestData);
                    tracer.addEndRpcEvent(
                        ackRequestData.getMessageWrapper(),
                        rpcSpanSampled,
                        isModack,
                        deadlineExtensionSeconds);
                    tracer.setSubscriberSpanException(
                        ackRequestData.getMessageWrapper(), t, "Invalid ack ID");
                  } else {
                    logger.log(Level.INFO, "Unknown error message, will not resend", errorMessage);
                    ackRequestData.setResponse(AckResponse.OTHER, setResponseOnSuccess);
                    messageDispatcher.notifyAckFailed(ackRequestData);
                    tracer.addEndRpcEvent(
                        ackRequestData.getMessageWrapper(),
                        rpcSpanSampled,
                        isModack,
                        deadlineExtensionSeconds);
                    tracer.setSubscriberSpanException(
                        ackRequestData.getMessageWrapper(), t, "Unknown error message");
                    ackRequestData
                        .getMessageWrapper()
                        .setSubscriberSpanException(t, "Unknown error message");
                  }
                } else {
                  ackRequestData.setResponse(AckResponse.SUCCESSFUL, setResponseOnSuccess);
                  messageDispatcher.notifyAckSuccess(ackRequestData);
                  tracer.endSubscriberSpan(ackRequestData.getMessageWrapper());
                  tracer.addEndRpcEvent(
                      ackRequestData.getMessageWrapper(),
                      rpcSpanSampled,
                      isModack,
                      deadlineExtensionSeconds);
                }
                // Remove from our pending
                pendingRequests.remove(ackRequestData);
              });
        } catch (InvalidProtocolBufferException e) {
          // If we fail to parse out the errorInfo, we should retry all
          logger.log(
              Level.WARNING, "Exception occurred when parsing throwable {0} for errorInfo", t);
          ackRequestDataArrayRetryList.addAll(ackRequestDataList);
        }

        // Handle retries
        if (!ackRequestDataArrayRetryList.isEmpty()) {
          long newBackoffMillis =
              Math.min(currentBackoffMillis * 2, MAX_ACK_OPERATIONS_RECONNECT_BACKOFF_MILLIS);
          systemExecutor.schedule(
              new Runnable() {
                @Override
                public void run() {
                  if (isModack) {
                    // Create a new modackRequest with only the retries
                    ModackRequestData modackRequestData =
                        new ModackRequestData(
                            deadlineExtensionSeconds, ackRequestDataArrayRetryList);
                    sendModackOperations(
                        Collections.singletonList(modackRequestData), newBackoffMillis);
                  } else {
                    sendAckOperations(ackRequestDataArrayRetryList, newBackoffMillis);
                  }
                }
              },
              currentBackoffMillis,
              TimeUnit.MILLISECONDS);
        }
      }
    };
  }

  /** Builder of {@link StreamingSubscriberConnection StreamingSubscriberConnections}. */
  public static final class Builder {
    private MessageReceiver receiver;
    private MessageReceiverWithAckResponse receiverWithAckResponse;
    private String subscription;
    private Duration ackExpirationPadding;
    private Duration maxAckExtensionPeriod;
    private Duration minDurationPerAckExtension;
    private boolean minDurationPerAckExtensionDefaultUsed;
    private Duration maxDurationPerAckExtension;
    private boolean maxDurationPerAckExtensionDefaultUsed;

    private Distribution ackLatencyDistribution;
    private SubscriberStub subscriberStub;
    private int channelAffinity;
    private FlowController flowController;
    private FlowControlSettings flowControlSettings;
    private boolean useLegacyFlowControl;
    private ScheduledExecutorService executor;
    private ScheduledExecutorService systemExecutor;
    private ApiClock clock;

    private boolean enableOpenTelemetryTracing;
    private OpenTelemetryPubsubTracer tracer;

    protected Builder(MessageReceiver receiver) {
      this.receiver = receiver;
    }

    protected Builder(MessageReceiverWithAckResponse receiverWithAckResponse) {
      this.receiverWithAckResponse = receiverWithAckResponse;
    }

    public Builder setSubscription(String subscription) {
      this.subscription = subscription;
      return this;
    }

    public Builder setAckExpirationPadding(Duration ackExpirationPadding) {
      this.ackExpirationPadding = ackExpirationPadding;
      return this;
    }

    public Builder setMaxAckExtensionPeriod(Duration maxAckExtensionPeriod) {
      this.maxAckExtensionPeriod = maxAckExtensionPeriod;
      return this;
    }

    public Builder setMinDurationPerAckExtension(Duration minDurationPerAckExtension) {
      this.minDurationPerAckExtension = minDurationPerAckExtension;
      return this;
    }

    public Builder setMinDurationPerAckExtensionDefaultUsed(
        boolean minDurationPerAckExtensionDefaultUsed) {
      this.minDurationPerAckExtensionDefaultUsed = minDurationPerAckExtensionDefaultUsed;
      return this;
    }

    public Builder setMaxDurationPerAckExtension(Duration maxDurationPerAckExtension) {
      this.maxDurationPerAckExtension = maxDurationPerAckExtension;
      return this;
    }

    public Builder setMaxDurationPerAckExtensionDefaultUsed(
        boolean maxDurationPerAckExtensionDefaultUsed) {
      this.maxDurationPerAckExtensionDefaultUsed = maxDurationPerAckExtensionDefaultUsed;
      return this;
    }

    public Builder setAckLatencyDistribution(Distribution ackLatencyDistribution) {
      this.ackLatencyDistribution = ackLatencyDistribution;
      return this;
    }

    public Builder setSubscriberStub(SubscriberStub subscriberStub) {
      this.subscriberStub = subscriberStub;
      return this;
    }

    public Builder setChannelAffinity(int channelAffinity) {
      this.channelAffinity = channelAffinity;
      return this;
    }

    public Builder setFlowController(FlowController flowController) {
      this.flowController = flowController;
      return this;
    }

    public Builder setFlowControlSettings(FlowControlSettings flowControlSettings) {
      this.flowControlSettings = flowControlSettings;
      return this;
    }

    public Builder setUseLegacyFlowControl(boolean useLegacyFlowControl) {
      this.useLegacyFlowControl = useLegacyFlowControl;
      return this;
    }

    public Builder setExecutor(ScheduledExecutorService executor) {
      this.executor = executor;
      return this;
    }

    public Builder setSystemExecutor(ScheduledExecutorService systemExecutor) {
      this.systemExecutor = systemExecutor;
      return this;
    }

    public Builder setClock(ApiClock clock) {
      this.clock = clock;
      return this;
    }

    public Builder setEnableOpenTelemetryTracing(boolean enableOpenTelemetryTracing) {
      this.enableOpenTelemetryTracing = enableOpenTelemetryTracing;
      return this;
    }

    public Builder setTracer(OpenTelemetryPubsubTracer tracer) {
      this.tracer = tracer;
      return this;
    }

    public StreamingSubscriberConnection build() {
      return new StreamingSubscriberConnection(this);
    }
  }

  public static Builder newBuilder(MessageReceiver receiver) {
    return new Builder(receiver);
  }

  public static Builder newBuilder(MessageReceiverWithAckResponse receiverWithAckResponse) {
    return new Builder(receiverWithAckResponse);
  }
}
