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

import com.google.api.core.ApiClock;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.batching.FlowController.FlowControlException;
import com.google.api.gax.core.Distribution;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.ReceivedMessage;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Dispatches messages to a message receiver while handling the messages acking and lease
 * extensions.
 */
class MessageDispatcher {
  private static final Logger logger = Logger.getLogger(MessageDispatcher.class.getName());

  @InternalApi static final double PERCENTILE_FOR_ACK_DEADLINE_UPDATES = 99.9;
  @InternalApi static final Duration PENDING_ACKS_SEND_DELAY = Duration.ofMillis(100);

  private final Executor executor;
  private final SequentialExecutorService.AutoExecutor sequentialExecutor;
  private final ScheduledExecutorService systemExecutor;
  private final ApiClock clock;

  private final Duration ackExpirationPadding;
  private final Duration maxAckExtensionPeriod;
  private int minDurationPerAckExtensionSeconds;
  private final boolean minDurationPerAckExtensionDefaultUsed;
  private final int maxDurationPerAckExtensionSeconds;
  private final boolean maxDurationPerAckExtensionDefaultUsed;

  // Only one of receiver or receiverWithAckResponse will be set
  private MessageReceiver receiver;
  private MessageReceiverWithAckResponse receiverWithAckResponse;

  private final AckProcessor ackProcessor;

  private final FlowController flowController;

  private AtomicBoolean exactlyOnceDeliveryEnabled = new AtomicBoolean(false);
  private AtomicBoolean messageOrderingEnabled = new AtomicBoolean(false);

  private final Waiter messagesWaiter;

  // Maps ID to "total expiration time". If it takes longer than this, stop extending.
  private final ConcurrentMap<String, AckHandler> pendingMessages = new ConcurrentHashMap<>();

  private final LinkedBlockingQueue<AckRequestData> pendingAcks = new LinkedBlockingQueue<>();
  private final LinkedBlockingQueue<AckRequestData> pendingNacks = new LinkedBlockingQueue<>();
  private final LinkedBlockingQueue<AckRequestData> pendingReceipts = new LinkedBlockingQueue<>();
  private final LinkedHashMap<String, ReceiptCompleteData> outstandingReceipts =
      new LinkedHashMap<String, ReceiptCompleteData>();
  private final AtomicInteger messageDeadlineSeconds = new AtomicInteger();
  private final AtomicBoolean extendDeadline = new AtomicBoolean(true);
  private final Lock jobLock;
  private ScheduledFuture<?> backgroundJob;
  private ScheduledFuture<?> setExtendedDeadlineFuture;

  // To keep track of number of seconds the receiver takes to process messages.
  private final Distribution ackLatencyDistribution;

  private final String subscriptionName;
  private final boolean enableOpenTelemetryTracing;
  private OpenTelemetryPubsubTracer tracer = new OpenTelemetryPubsubTracer(null, false);

  /** Internal representation of a reply to a Pubsub message, to be sent back to the service. */
  public enum AckReply {
    ACK,
    NACK
  }

  /** Handles callbacks for acking/nacking messages from the {@link MessageReceiver}. */
  private class AckHandler implements ApiFutureCallback<AckReply> {
    private final AckRequestData ackRequestData;
    private final int outstandingBytes;
    private final long receivedTimeMillis;
    private final Instant totalExpiration;

    private AckHandler(
        AckRequestData ackRequestData, int outstandingBytes, Instant totalExpiration) {
      this.ackRequestData = ackRequestData;
      this.outstandingBytes = outstandingBytes;
      this.receivedTimeMillis = clock.millisTime();
      this.totalExpiration = totalExpiration;
    }

    public AckRequestData getAckRequestData() {
      return ackRequestData;
    }

    public SettableApiFuture<AckResponse> getMessageFutureIfExists() {
      return this.ackRequestData.getMessageFutureIfExists();
    }

    /** Stop extending deadlines for this message and free flow control. */
    private void forget() {
      if (pendingMessages.remove(this.ackRequestData.getAckId()) == null) {
        /*
         * We're forgetting the message for the second time. Probably because we ran out of total
         * expiration, forget the message, then the user finishes working on the message, and forget
         * again. Turn the second forget into a no-op so we don't free twice.
         */
        return;
      }
      flowController.release(1, outstandingBytes);
      messagesWaiter.incrementPendingCount(-1);
    }

    @Override
    public void onFailure(Throwable t) {
      logger.log(
          Level.WARNING,
          "MessageReceiver failed to process ack ID: "
              + this.ackRequestData.getAckId()
              + ", the message will be nacked.",
          t);
      this.ackRequestData.setResponse(AckResponse.OTHER, false);
      pendingNacks.add(this.ackRequestData);
      tracer.endSubscribeProcessSpan(this.ackRequestData.getMessageWrapper(), "nack");
      forget();
    }

    @Override
    public void onSuccess(AckReply reply) {
      switch (reply) {
        case ACK:
          pendingAcks.add(this.ackRequestData);
          // Record the latency rounded to the next closest integer.
          ackLatencyDistribution.record(
              Ints.saturatedCast(
                  (long) Math.ceil((clock.millisTime() - receivedTimeMillis) / 1000D)));
          tracer.endSubscribeProcessSpan(this.ackRequestData.getMessageWrapper(), "ack");
          break;
        case NACK:
          pendingNacks.add(this.ackRequestData);
          tracer.endSubscribeProcessSpan(this.ackRequestData.getMessageWrapper(), "nack");
          break;
        default:
          throw new IllegalArgumentException(String.format("AckReply: %s not supported", reply));
      }
      forget();
    }
  }

  interface AckProcessor {
    public void sendAckOperations(List<AckRequestData> ackRequestDataList);

    public void sendModackOperations(List<ModackRequestData> modackRequestDataList);
  }

  private MessageDispatcher(Builder builder) {
    executor = builder.executor;
    systemExecutor = builder.systemExecutor;
    ackExpirationPadding = builder.ackExpirationPadding;
    maxAckExtensionPeriod = builder.maxAckExtensionPeriod;

    minDurationPerAckExtensionSeconds =
        Math.toIntExact(builder.minDurationPerAckExtension.getSeconds());
    minDurationPerAckExtensionDefaultUsed = builder.minDurationPerAckExtensionDefaultUsed;
    maxDurationPerAckExtensionSeconds =
        Math.toIntExact(builder.maxDurationPerAckExtension.getSeconds());
    maxDurationPerAckExtensionDefaultUsed = builder.maxDurationPerAckExtensionDefaultUsed;

    // Start the deadline at the minimum ack deadline so messages which arrive before this is
    // updated will not have a long ack deadline.
    if (minDurationPerAckExtensionDefaultUsed) {
      messageDeadlineSeconds.set(Math.toIntExact(Subscriber.MIN_STREAM_ACK_DEADLINE.getSeconds()));
    } else {
      messageDeadlineSeconds.set(minDurationPerAckExtensionSeconds);
    }

    receiver = builder.receiver;
    receiverWithAckResponse = builder.receiverWithAckResponse;

    ackProcessor = builder.ackProcessor;
    flowController = builder.flowController;
    ackLatencyDistribution = builder.ackLatencyDistribution;
    clock = builder.clock;
    jobLock = new ReentrantLock();
    messagesWaiter = new Waiter();
    sequentialExecutor = new SequentialExecutorService.AutoExecutor(builder.executor);

    subscriptionName = builder.subscriptionName;
    enableOpenTelemetryTracing = builder.enableOpenTelemetryTracing;
    if (builder.tracer != null) {
      tracer = builder.tracer;
    }
  }

  private boolean shouldSetMessageFuture() {
    return receiverWithAckResponse != null;
  }

  void start() {
    final Runnable setExtendDeadline =
        new Runnable() {
          @Override
          public void run() {
            extendDeadline.set(true);
          }
        };

    jobLock.lock();
    try {
      // Do not adjust deadline concurrently with extendDeadline or processOutstandingAckOperations.
      // The following sequence can happen:
      //  0. Initially, deadline = 1 min
      //  1. Thread A (TA) wants to send receipts, reads deadline = 1m, but stalls before actually
      // sending request
      //  2. Thread B (TB) adjusts deadline to 2m
      //  3. TB calls extendDeadline, modack all messages to 2m, schedules next extension in 2m
      //  4. TA sends request, modacking messages to 1m.
      // Then messages will expire too early.
      // This can be resolved by adding locks in the right places, but at that point,
      // we might as well do things sequentially.
      backgroundJob =
          systemExecutor.scheduleWithFixedDelay(
              new Runnable() {
                @Override
                public void run() {
                  try {
                    if (extendDeadline.getAndSet(false)) {
                      int newDeadlineSec = computeDeadlineSeconds();
                      messageDeadlineSeconds.set(newDeadlineSec);
                      extendDeadlines();
                      if (setExtendedDeadlineFuture != null && !backgroundJob.isDone()) {
                        setExtendedDeadlineFuture.cancel(true);
                      }

                      setExtendedDeadlineFuture =
                          systemExecutor.schedule(
                              setExtendDeadline,
                              newDeadlineSec - ackExpirationPadding.getSeconds(),
                              TimeUnit.SECONDS);
                    }
                    processOutstandingOperations();
                  } catch (Throwable t) {
                    // Catch everything so that one run failing doesn't prevent subsequent runs.
                    logger.log(Level.WARNING, "failed to run periodic job", t);
                  }
                }
              },
              PENDING_ACKS_SEND_DELAY.toMillis(),
              PENDING_ACKS_SEND_DELAY.toMillis(),
              TimeUnit.MILLISECONDS);
    } finally {
      jobLock.unlock();
    }
  }

  void stop() {
    messagesWaiter.waitComplete();
    jobLock.lock();
    try {
      if (backgroundJob != null) {
        backgroundJob.cancel(false);
      }
      if (setExtendedDeadlineFuture != null) {
        setExtendedDeadlineFuture.cancel(true);
      }
      backgroundJob = null;
      setExtendedDeadlineFuture = null;
    } finally {
      jobLock.unlock();
    }
    processOutstandingOperations();
  }

  @InternalApi
  void setMessageDeadlineSeconds(int sec) {
    messageDeadlineSeconds.set(sec);
  }

  @InternalApi
  int getMessageDeadlineSeconds() {
    return messageDeadlineSeconds.get();
  }

  @InternalApi
  void setExactlyOnceDeliveryEnabled(boolean exactlyOnceDeliveryEnabled) {
    // Sanity check that we are changing the exactlyOnceDeliveryEnabled state
    if (exactlyOnceDeliveryEnabled == this.exactlyOnceDeliveryEnabled.get()) {
      return;
    }

    this.exactlyOnceDeliveryEnabled.set(exactlyOnceDeliveryEnabled);

    // If a custom value for minDurationPerAckExtension, we should respect that
    if (!minDurationPerAckExtensionDefaultUsed) {
      return;
    }

    // We just need to update the minDurationPerAckExtensionSeconds as the
    // maxDurationPerAckExtensionSeconds does not change
    int possibleNewMinAckDeadlineExtensionSeconds;

    if (exactlyOnceDeliveryEnabled) {
      possibleNewMinAckDeadlineExtensionSeconds =
          Math.toIntExact(
              Subscriber.DEFAULT_MIN_ACK_DEADLINE_EXTENSION_EXACTLY_ONCE_DELIVERY.getSeconds());
    } else {
      possibleNewMinAckDeadlineExtensionSeconds =
          Math.toIntExact(Subscriber.DEFAULT_MIN_ACK_DEADLINE_EXTENSION.getSeconds());
    }

    // If we are not using the default maxDurationAckExtension, check if the
    // minAckDeadlineExtensionExactlyOnceDelivery needs to be bounded by the set max
    if (!maxDurationPerAckExtensionDefaultUsed
        && (possibleNewMinAckDeadlineExtensionSeconds > maxDurationPerAckExtensionSeconds)) {
      minDurationPerAckExtensionSeconds = maxDurationPerAckExtensionSeconds;
    } else {
      minDurationPerAckExtensionSeconds = possibleNewMinAckDeadlineExtensionSeconds;
    }
  }

  @InternalApi
  void setMessageOrderingEnabled(boolean messageOrderingEnabled) {
    this.messageOrderingEnabled.set(messageOrderingEnabled);
  }

  private static class OutstandingMessage {
    private final AckHandler ackHandler;

    private OutstandingMessage(AckHandler ackHandler) {
      this.ackHandler = ackHandler;
    }

    public PubsubMessageWrapper messageWrapper() {
      return this.ackHandler.ackRequestData.getMessageWrapper();
    }
  }

  private static class ReceiptCompleteData {
    private OutstandingMessage outstandingMessage;
    private Boolean receiptComplete;

    private ReceiptCompleteData(OutstandingMessage outstandingMessage) {
      this.outstandingMessage = outstandingMessage;
      this.receiptComplete = false;
    }

    private OutstandingMessage getOutstandingMessage() {
      return this.outstandingMessage;
    }

    private Boolean isReceiptComplete() {
      return this.receiptComplete;
    }

    private void notifyReceiptComplete() {
      this.receiptComplete = true;
    }
  }

  void processReceivedMessages(List<ReceivedMessage> messages) {
    Instant totalExpiration = now().plus(maxAckExtensionPeriod);
    List<OutstandingMessage> outstandingBatch = new ArrayList<>(messages.size());
    for (ReceivedMessage message : messages) {
      AckRequestData.Builder builder = AckRequestData.newBuilder(message.getAckId());
      if (shouldSetMessageFuture()) {
        builder.setMessageFuture(SettableApiFuture.create());
      }
      PubsubMessageWrapper messageWrapper =
          PubsubMessageWrapper.newBuilder(
                  message.getMessage(),
                  subscriptionName,
                  message.getAckId(),
                  message.getDeliveryAttempt())
              .build();
      builder.setMessageWrapper(messageWrapper);
      tracer.startSubscriberSpan(messageWrapper, this.exactlyOnceDeliveryEnabled.get());

      AckRequestData ackRequestData = builder.build();
      AckHandler ackHandler =
          new AckHandler(ackRequestData, message.getMessage().getSerializedSize(), totalExpiration);
      OutstandingMessage outstandingMessage = new OutstandingMessage(ackHandler);

      if (this.exactlyOnceDeliveryEnabled.get()) {
        // For exactly once deliveries we don't add to outstanding batch because we first
        // process the receipt modack. If that is successful then we process the message.
        synchronized (outstandingReceipts) {
          outstandingReceipts.put(message.getAckId(), new ReceiptCompleteData(outstandingMessage));
        }
      } else if (pendingMessages.putIfAbsent(message.getAckId(), ackHandler) != null) {
        // putIfAbsent puts ackHandler if ackID isn't previously mapped, then return the
        // previously-mapped element.
        // If the previous element is not null, we already have the message and the new one is
        // definitely a duplicate.
        // Don't nack this, because that'd also nack the one we already have in queue.
        // Don't update the existing one's total expiration either. If the user "loses" the message,
        // we want to eventually
        // totally expire so that pubsub service sends us the message again.
        continue;
      } else {
        outstandingBatch.add(outstandingMessage);
      }
      pendingReceipts.add(ackRequestData);
    }
    processBatch(outstandingBatch);
  }

  void notifyAckSuccess(AckRequestData ackRequestData) {
    synchronized (outstandingReceipts) {
      if (outstandingReceipts.containsKey(ackRequestData.getAckId())) {
        outstandingReceipts.get(ackRequestData.getAckId()).notifyReceiptComplete();
        List<OutstandingMessage> outstandingBatch = new ArrayList<>();

        for (Iterator<Entry<String, ReceiptCompleteData>> it =
                outstandingReceipts.entrySet().iterator();
            it.hasNext(); ) {
          Map.Entry<String, ReceiptCompleteData> receipt = it.next();
          // If receipt is complete then add to outstandingBatch to process the batch
          if (receipt.getValue().isReceiptComplete()) {
            it.remove();
            if (pendingMessages.putIfAbsent(
                    receipt.getKey(), receipt.getValue().getOutstandingMessage().ackHandler)
                == null) {
              outstandingBatch.add(receipt.getValue().getOutstandingMessage());
            }
          } else {
            break;
          }
        }
        processBatch(outstandingBatch);
      }
    }
  }

  void notifyAckFailed(AckRequestData ackRequestData) {
    synchronized (outstandingReceipts) {
      outstandingReceipts.remove(ackRequestData.getAckId());
    }
  }

  private void processBatch(List<OutstandingMessage> batch) {
    messagesWaiter.incrementPendingCount(batch.size());
    for (OutstandingMessage message : batch) {
      // This is a blocking flow controller.  We have already incremented messagesWaiter, so
      // shutdown will block on processing of all these messages anyway.
      tracer.startSubscribeConcurrencyControlSpan(message.messageWrapper());
      try {
        flowController.reserve(1, message.messageWrapper().getPubsubMessage().getSerializedSize());
        tracer.endSubscribeConcurrencyControlSpan(message.messageWrapper());
      } catch (FlowControlException unexpectedException) {
        // This should be a blocking flow controller and never throw an exception.
        tracer.setSubscribeConcurrencyControlSpanException(
            message.messageWrapper(), unexpectedException);
        throw new IllegalStateException("Flow control unexpected exception", unexpectedException);
      }
      addDeliveryInfoCount(message.messageWrapper());
      processOutstandingMessage(message.ackHandler);
    }
  }

  private void addDeliveryInfoCount(PubsubMessageWrapper messageWrapper) {
    PubsubMessage originalMessage = messageWrapper.getPubsubMessage();
    int deliveryAttempt = messageWrapper.getDeliveryAttempt();
    // Delivery Attempt will be set to 0 if DeadLetterPolicy is not set on the subscription. In
    // this case, do not populate the PubsubMessage with the delivery attempt attribute.
    if (deliveryAttempt > 0) {
      messageWrapper.setPubsubMessage(
          PubsubMessage.newBuilder(originalMessage)
              .putAttributes("googclient_deliveryattempt", Integer.toString(deliveryAttempt))
              .build());
    }
  }

  private void processOutstandingMessage(final AckHandler ackHandler) {
    // Get the PubsubMessageWrapper and the PubsubMessage it wraps that are stored withing the
    // AckHandler object.
    PubsubMessageWrapper messageWrapper = ackHandler.ackRequestData.getMessageWrapper();
    PubsubMessage message = messageWrapper.getPubsubMessage();

    // This future is for internal bookkeeping to be sent to the StreamingSubscriberConnection
    // use below in the consumers
    SettableApiFuture<AckReply> ackReplySettableApiFuture = SettableApiFuture.create();
    ApiFutures.addCallback(ackReplySettableApiFuture, ackHandler, MoreExecutors.directExecutor());

    Runnable deliverMessageTask =
        new Runnable() {
          @Override
          public void run() {
            try {
              if (ackHandler
                  .totalExpiration
                  .plusSeconds(messageDeadlineSeconds.get())
                  .isBefore(now())) {
                // Message expired while waiting. We don't extend these messages anymore,
                // so it was probably sent to someone else. Don't work on it.
                // Don't nack it either, because we'd be nacking someone else's message.
                ackHandler.forget();
                tracer.setSubscriberSpanExpirationResult(messageWrapper);
                return;
              }
              tracer.startSubscribeProcessSpan(messageWrapper);
              if (shouldSetMessageFuture()) {
                // This is the message future that is propagated to the user
                SettableApiFuture<AckResponse> messageFuture =
                    ackHandler.getMessageFutureIfExists();
                final AckReplyConsumerWithResponse ackReplyConsumerWithResponse =
                    new AckReplyConsumerWithResponseImpl(ackReplySettableApiFuture, messageFuture);
                receiverWithAckResponse.receiveMessage(message, ackReplyConsumerWithResponse);
              } else {
                final AckReplyConsumer ackReplyConsumer =
                    new AckReplyConsumerImpl(ackReplySettableApiFuture);
                receiver.receiveMessage(message, ackReplyConsumer);
              }
            } catch (Exception e) {
              ackReplySettableApiFuture.setException(e);
            }
          }
        };
    if (!messageOrderingEnabled.get() || message.getOrderingKey().isEmpty()) {
      executor.execute(deliverMessageTask);
    } else {
      tracer.startSubscribeSchedulerSpan(messageWrapper);
      sequentialExecutor.submit(message.getOrderingKey(), deliverMessageTask);
      tracer.endSubscribeSchedulerSpan(messageWrapper);
    }
  }

  /** Compute the ideal deadline, set subsequent modacks to this deadline, and return it. */
  @InternalApi
  int computeDeadlineSeconds() {
    int deadlineSeconds = ackLatencyDistribution.getPercentile(PERCENTILE_FOR_ACK_DEADLINE_UPDATES);

    // Bound deadlineSeconds by extensions
    if (!maxDurationPerAckExtensionDefaultUsed
        && (deadlineSeconds > maxDurationPerAckExtensionSeconds)) {
      deadlineSeconds = maxDurationPerAckExtensionSeconds;
    } else if (deadlineSeconds < minDurationPerAckExtensionSeconds) {
      deadlineSeconds = minDurationPerAckExtensionSeconds;
    }

    // Bound deadlineSeconds by hard limits in subscriber
    if (deadlineSeconds < Subscriber.MIN_STREAM_ACK_DEADLINE.getSeconds()) {
      deadlineSeconds = Math.toIntExact(Subscriber.MIN_STREAM_ACK_DEADLINE.getSeconds());
    } else if (deadlineSeconds > Subscriber.MAX_STREAM_ACK_DEADLINE.getSeconds()) {
      deadlineSeconds = Math.toIntExact(Subscriber.MAX_STREAM_ACK_DEADLINE.getSeconds());
    }

    return deadlineSeconds;
  }

  @InternalApi
  void extendDeadlines() {
    int extendSeconds = getMessageDeadlineSeconds();
    int numAckIdToSend = 0;
    Map<Integer, ModackRequestData> deadlineExtensionModacks =
        new HashMap<Integer, ModackRequestData>();
    Instant now = now();
    Instant extendTo = now.plusSeconds(extendSeconds);

    for (Map.Entry<String, AckHandler> entry : pendingMessages.entrySet()) {
      String ackId = entry.getKey();
      Instant totalExpiration = entry.getValue().totalExpiration;
      if (totalExpiration.isAfter(extendTo)) {
        ModackRequestData modackRequestData =
            deadlineExtensionModacks.computeIfAbsent(
                extendSeconds,
                deadlineExtensionSeconds -> new ModackRequestData(deadlineExtensionSeconds));
        modackRequestData.addAckRequestData(entry.getValue().getAckRequestData());
        numAckIdToSend++;
        continue;
      }

      // forget removes from pendingMessages; this is OK, concurrent maps can
      // handle concurrent iterations and modifications.
      entry.getValue().forget();
      if (totalExpiration.isAfter(now)) {
        int sec = Math.max(1, (int) now.until(totalExpiration, ChronoUnit.SECONDS));
        ModackRequestData modackRequestData =
            deadlineExtensionModacks.computeIfAbsent(
                sec, extensionSeconds -> new ModackRequestData(extensionSeconds));
        modackRequestData.addAckRequestData(entry.getValue().getAckRequestData());
        numAckIdToSend++;
      }
    }

    if (numAckIdToSend > 0) {
      logger.log(Level.FINER, "Sending {0} modacks", numAckIdToSend);
      ackProcessor.sendModackOperations(
          new ArrayList<ModackRequestData>(deadlineExtensionModacks.values()));
    }
  }

  @InternalApi
  void processOutstandingOperations() {

    List<ModackRequestData> modackRequestData = new ArrayList<ModackRequestData>();

    // Nacks are modacks with an expiration of 0
    List<AckRequestData> nackRequestDataList = new ArrayList<AckRequestData>();
    pendingNacks.drainTo(nackRequestDataList);

    if (!nackRequestDataList.isEmpty()) {
      modackRequestData.add(new ModackRequestData(0, nackRequestDataList));
    }
    logger.log(Level.FINER, "Sending {0} nacks", nackRequestDataList.size());

    List<AckRequestData> ackRequestDataReceipts = new ArrayList<AckRequestData>();
    pendingReceipts.drainTo(ackRequestDataReceipts);
    if (!ackRequestDataReceipts.isEmpty()) {
      ModackRequestData receiptModack =
          new ModackRequestData(this.getMessageDeadlineSeconds(), ackRequestDataReceipts);
      receiptModack.setIsReceiptModack(true);
      modackRequestData.add(receiptModack);
    }
    logger.log(Level.FINER, "Sending {0} receipts", ackRequestDataReceipts.size());

    ackProcessor.sendModackOperations(modackRequestData);

    List<AckRequestData> ackRequestDataList = new ArrayList<AckRequestData>();
    pendingAcks.drainTo(ackRequestDataList);
    logger.log(Level.FINER, "Sending {0} acks", ackRequestDataList.size());

    ackProcessor.sendAckOperations(ackRequestDataList);
  }

  private Instant now() {
    return Instant.ofEpochMilli(clock.millisTime());
  }

  /** Builder of {@link MessageDispatcher MessageDispatchers}. */
  public static final class Builder {
    private MessageReceiver receiver;
    private MessageReceiverWithAckResponse receiverWithAckResponse;

    private AckProcessor ackProcessor;
    private Duration ackExpirationPadding;
    private Duration maxAckExtensionPeriod;
    private Duration minDurationPerAckExtension;
    private boolean minDurationPerAckExtensionDefaultUsed;
    private Duration maxDurationPerAckExtension;
    private boolean maxDurationPerAckExtensionDefaultUsed;

    private Distribution ackLatencyDistribution;
    private FlowController flowController;

    private Executor executor;
    private ScheduledExecutorService systemExecutor;
    private ApiClock clock;

    private String subscriptionName;
    private boolean enableOpenTelemetryTracing;
    private OpenTelemetryPubsubTracer tracer;

    protected Builder(MessageReceiver receiver) {
      this.receiver = receiver;
    }

    protected Builder(MessageReceiverWithAckResponse receiverWithAckResponse) {
      this.receiverWithAckResponse = receiverWithAckResponse;
    }

    public Builder setAckProcessor(AckProcessor ackProcessor) {
      this.ackProcessor = ackProcessor;
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

    public Builder setFlowController(FlowController flowController) {
      this.flowController = flowController;
      return this;
    }

    public Builder setExecutor(Executor executor) {
      this.executor = executor;
      return this;
    }

    public Builder setSystemExecutor(ScheduledExecutorService systemExecutor) {
      this.systemExecutor = systemExecutor;
      return this;
    }

    public Builder setApiClock(ApiClock clock) {
      this.clock = clock;
      return this;
    }

    public Builder setSubscriptionName(String subscriptionName) {
      this.subscriptionName = subscriptionName;
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

    public MessageDispatcher build() {
      return new MessageDispatcher(this);
    }
  }

  public static Builder newBuilder(MessageReceiver receiver) {
    return new Builder(receiver);
  }

  public static Builder newBuilder(MessageReceiverWithAckResponse receiverWithAckResponse) {
    return new Builder(receiverWithAckResponse);
  }
}
