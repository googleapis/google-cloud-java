/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storage;

import static com.google.cloud.storage.StorageV2ProtoUtils.fmtProto;
import static com.google.cloud.storage.Utils.ifNonNull;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static java.util.Objects.requireNonNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.storage.v2.AppendObjectSpec;
import com.google.storage.v2.BidiWriteHandle;
import com.google.storage.v2.BidiWriteObjectRedirectedError;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.BidiWriteObjectResponse;
import com.google.storage.v2.ChecksummedData;
import com.google.storage.v2.WriteObjectSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

@SuppressWarnings("LoggingSimilarMessage")
abstract class BidiUploadState {
  private static final Logger LOGGER = LoggerFactory.getLogger(BidiUploadState.class);
  private static final Marker TRACE_ENTER = MarkerFactory.getMarker("enter");
  private static final Marker TRACE_EXIT = MarkerFactory.getMarker("exit");

  static final OneofDescriptor FIRST_MESSAGE_DESCRIPTOR =
      BidiWriteObjectRequest.getDescriptor().getOneofs().stream()
          .filter(d -> "first_message".equalsIgnoreCase(d.getName()))
          .findFirst()
          .orElseThrow(
              () -> new IllegalStateException("BidiWriteObject.first_message oneof not found"));

  // seal this class to extension
  private BidiUploadState() {}

  @VisibleForTesting
  BidiUploadState(String testName) {
    // some runtime enforcement that this constructor is only called from a test
    // if we had java9+ we could seal this all the way without this hack
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    boolean isJunitTest =
        Arrays.stream(stackTrace).anyMatch(ste -> ste.getClassName().startsWith("org.junit"));

    checkState(isJunitTest, "not a junit test", testName);
  }

  protected final StorageException err(
      UploadFailureScenario scenario, BidiWriteObjectResponse response) {
    BidiWriteObjectRequest t = peekLast();
    GrpcCallContext ctx = enqueueFirstMessageAndGetGrpcCallContext();
    return scenario.toStorageException(Utils.nullSafeList(t), response, ctx, null);
  }

  @Nullable Crc32cLengthKnown getCumulativeCrc32c() {
    return unimplemented();
  }

  long getTotalSentBytes() {
    return unimplemented();
  }

  long getConfirmedBytes() {
    return unimplemented();
  }

  long availableCapacity() {
    return unimplemented();
  }

  boolean offer(ChunkSegmenter.@NonNull ChunkSegment data) {
    return unimplemented();
  }

  boolean finalFlush(long totalLength) {
    return unimplemented();
  }

  boolean offer(@NonNull BidiWriteObjectRequest e) {
    return unimplemented();
  }

  void updateStateFromResponse(BidiWriteObjectResponse response) {
    unimplemented();
  }

  @NonNull GrpcCallContext enqueueFirstMessageAndGetGrpcCallContext() {
    return unimplemented();
  }

  void sendVia(Consumer<BidiWriteObjectRequest> consumer) {
    unimplemented();
  }

  void updateFromRedirect(@NonNull BidiWriteObjectRedirectedError redirect) {
    unimplemented();
  }

  void terminalError() {
    unimplemented();
  }

  void pendingRetry() {
    unimplemented();
  }

  void retrying() {
    unimplemented();
  }

  @Nullable BidiWriteObjectRequest peekLast() {
    return unimplemented();
  }

  boolean isFinalizing() {
    return unimplemented();
  }

  ApiFuture<Void> beginReconciliation() {
    return unimplemented();
  }

  static AppendableUploadState appendableNew(
      BidiWriteObjectRequest initial,
      Supplier<GrpcCallContext> baseCallContext,
      long maxBytes,
      SettableApiFuture<BidiWriteObjectResponse> resultFuture,
      @Nullable Crc32cLengthKnown initialCrc32c) {
    checkArgument(
        initial.hasWriteObjectSpec(), "provided initial request did not contain a WriteObjectSpec");
    WriteObjectSpec spec = initial.getWriteObjectSpec();
    return new NewAppendableUploadState(
        initial, spec, baseCallContext, maxBytes, resultFuture, initialCrc32c);
  }

  static AppendableUploadState appendableTakeover(
      BidiWriteObjectRequest initial,
      Supplier<GrpcCallContext> baseCallContext,
      long maxBytes,
      SettableApiFuture<BidiWriteObjectResponse> resultFuture,
      @Nullable Crc32cLengthKnown initialCrc32c) {
    checkArgument(
        initial.hasAppendObjectSpec(),
        "provided initial request did not contain a AppendableObjectSpec");
    AppendObjectSpec spec = initial.getAppendObjectSpec();
    return new TakeoverAppendableUploadState(
        initial, spec, baseCallContext, maxBytes, resultFuture, initialCrc32c);
  }

  private static ImmutableMap<String, List<String>> makeHeadersMap(
      Stream<String> xGoogRequestParamsEntries) {
    return ImmutableMap.of(
        "x-goog-request-params",
        ImmutableList.of(
            xGoogRequestParamsEntries.filter(Objects::nonNull).collect(Collectors.joining("&"))));
  }

  /**
   * Create a single BidiWriteObjectRequest consisting of the same semantic meaning as if doing
   * first then second.
   *
   * @throws IllegalArgumentException if both first and second have checksummedData
   */
  static BidiWriteObjectRequest concatenate(
      BidiWriteObjectRequest first, BidiWriteObjectRequest second) {
    checkArgument(
        !(first.hasChecksummedData() && second.hasChecksummedData()),
        "attempting to merge two requests that both specify checksummed_data");
    BidiWriteObjectRequest.Builder b = first.toBuilder().mergeFrom(second);
    long lwo = first.getWriteOffset();
    long rwo = second.getWriteOffset();
    if (first.hasChecksummedData()) {
      int size = first.getChecksummedData().getContent().size();
      checkArgument(
          lwo + size == rwo,
          "(leftWriteOffset + size == rightWriteOffset) (%s + %s == %s)",
          lwo,
          size,
          rwo);
      b.setWriteOffset(lwo);
    } else {
      b.setWriteOffset(rwo);
    }

    // finish_write implies flush & state_lookup. dedupe to avoid an extra incremental message
    if (second.getFinishWrite() && (first.getFlush() || first.getStateLookup())) {
      b.clearFlush().clearStateLookup();
    }
    return b.build();
  }

  @Nullable StorageException onResponse(BidiWriteObjectResponse response) {
    return unimplemented();
  }

  State getState() {
    return unimplemented();
  }

  @VisibleForTesting
  @Nullable BidiWriteObjectRequest peekFirst() {
    return unimplemented();
  }

  SettableApiFuture<BidiWriteObjectResponse> getResultFuture() {
    return unimplemented();
  }

  void awaitState(State... state) throws InterruptedException {
    unimplemented();
  }

  public void awaitTakeoverStateReconciliation(Runnable restart) {
    unimplemented();
  }

  public void awaitAck(long writeOffset) throws InterruptedException {
    unimplemented();
  }

  enum State {
    INITIALIZING,
    TAKEOVER,
    RUNNING,
    PENDING_RETRY,
    RETRYING,
    TERMINAL_SUCCESS,
    TERMINAL_ERROR;

    private static final State[] allNonTerminal =
        new State[] {INITIALIZING, TAKEOVER, RUNNING, PENDING_RETRY, RETRYING};

    boolean in(State... states) {
      for (State state : states) {
        if (state == this) {
          return true;
        }
      }
      return false;
    }
  }

  private static <T> T unimplemented() {
    throw new IllegalStateException("not implemented");
  }

  abstract static class BaseUploadState extends BidiUploadState {

    protected final BidiWriteObjectRequest initial;
    protected final Supplier<GrpcCallContext> baseCallContext;
    protected final ReentrantLock lock;
    protected final Condition stateUpdated;
    protected final Condition confirmedBytesUpdated;

    /** The maximum number of bytes allowed to be enqueued in {@link #queue} across all messages. */
    protected final long maxBytes;

    protected final ArrayList<BidiWriteObjectRequest> queue;
    protected final SettableApiFuture<BidiWriteObjectResponse> resultFuture;

    /** The total number of bytes currently enqueued in {@link #queue} */
    private long enqueuedBytes;

    /** A value in the range of {@code -1 <= lastSentRequest && lastSentRequest < queue.size()} */
    @VisibleForTesting int lastSentRequestIndex;

    /** The minimum offset of bytes for those pending messages. */
    protected long minByteOffset;

    /**
     * The number of bytes that have been "sent". This might also be named something like
     * cumulativeWriteOffset.
     */
    protected long totalSentBytes;

    protected @Nullable Crc32cLengthKnown cumulativeCrc32c;

    /**
     * Initially {@code -1} to signify the upload does not exist at all in the server, when the
     * server responds successfully this will be updated to a value >= 0.
     */
    protected long confirmedBytes;

    protected long generation;
    protected @Nullable BidiWriteHandle writeHandle;
    protected @Nullable String routingToken;
    protected @NonNull State state;
    protected @MonotonicNonNull BidiWriteObjectResponse lastResponseWithResource;
    protected @Nullable State stateToReturnToAfterRetry;
    protected long finalFlushOffset;
    protected boolean finalFlushSent;
    protected long finishWriteOffset;
    protected boolean finishWriteSent;
    protected @MonotonicNonNull OpenArguments lastOpenArguments;
    protected @Nullable SettableApiFuture<Void> pendingReconciliation;

    private BaseUploadState(
        BidiWriteObjectRequest initial,
        Supplier<GrpcCallContext> baseCallContext,
        long maxBytes,
        SettableApiFuture<BidiWriteObjectResponse> resultFuture,
        @Nullable Crc32cLengthKnown initialCrc32c,
        State startingState) {
      this.initial = initial;
      this.baseCallContext = baseCallContext;
      this.resultFuture = resultFuture;
      this.cumulativeCrc32c = initialCrc32c;
      this.maxBytes = maxBytes;
      this.queue = new ArrayList<>();
      this.enqueuedBytes = 0;
      this.lock = new ReentrantLock();
      this.stateUpdated = lock.newCondition();
      this.confirmedBytesUpdated = lock.newCondition();
      this.lastSentRequestIndex = -1;
      this.minByteOffset = 0;
      this.totalSentBytes = 0;
      this.confirmedBytes = -1;
      this.state = startingState;
      this.finalFlushOffset = -1;
      this.finishWriteOffset = -1;
    }

    @Override
    final State getState() {
      lock.lock();
      try {
        return state;
      } finally {
        lock.unlock();
      }
    }

    @Override
    final @Nullable Crc32cLengthKnown getCumulativeCrc32c() {
      lock.lock();
      try {
        return cumulativeCrc32c;
      } finally {
        lock.unlock();
      }
    }

    @Override
    final long getTotalSentBytes() {
      lock.lock();
      try {
        return totalSentBytes;
      } finally {
        lock.unlock();
      }
    }

    @Override
    final long getConfirmedBytes() {
      lock.lock();
      try {
        return confirmedBytes;
      } finally {
        lock.unlock();
      }
    }

    @Override
    final long availableCapacity() {
      lock.lock();
      try {
        return maxBytes - enqueuedBytes;
      } finally {
        lock.unlock();
      }
    }

    @Override
    final boolean offer(ChunkSegmenter.@NonNull ChunkSegment datum) {
      lock.lock();
      try {
        requireNonNull(datum, "data must be non null");
        validateCurrentStateIsOneOf(State.allNonTerminal);
        ByteString b = datum.getB();
        int size = b.size();
        checkNotFinalizing(size);
        long availableCapacity = availableCapacity();
        if (size <= availableCapacity) {
          Crc32cLengthKnown crc32c = datum.getCrc32c();
          ChecksummedData.Builder checksummedData = ChecksummedData.newBuilder().setContent(b);
          if (crc32c != null) {
            checksummedData.setCrc32C(crc32c.getValue());
          }
          ChecksummedData built = checksummedData.build();
          boolean offered =
              internalOffer(
                  BidiWriteObjectRequest.newBuilder()
                      .setWriteOffset(totalSentBytes)
                      .setChecksummedData(built)
                      .build());
          if (offered) {
            cumulativeCrc32c = crc32cConcat(crc32c);
          }
          return offered;
        }
        return false;
      } finally {
        lock.unlock();
      }
    }

    @Override
    public boolean finalFlush(long totalLength) {
      lock.lock();
      try {
        validateCurrentStateIsOneOf(State.allNonTerminal);
        checkNotFinalizing(0);
        checkArgument(
            totalLength == totalSentBytes,
            "(totalLength == totalSentBytes) (%s == %s)",
            totalLength,
            totalSentBytes);

        BidiWriteObjectRequest flush =
            BidiWriteObjectRequest.newBuilder()
                .setWriteOffset(totalLength)
                .setFlush(true)
                .setStateLookup(true)
                .build();

        BidiWriteObjectRequest currentLast = peekLast();
        boolean equals = flush.equals(currentLast);
        if (equals && finalFlushOffset == totalLength) {
          return true;
        } else if (equals && lastSentRequestIndex == queue.size() - 1) {
          finalFlushOffset = totalLength;
          finalFlushSent = true;
          return true;
        }

        boolean offered = internalOffer(flush);
        if (offered) {
          finalFlushOffset = totalLength;
        }
        return offered;
      } finally {
        lock.unlock();
      }
    }

    @Override
    final boolean offer(@NonNull BidiWriteObjectRequest e) {
      lock.lock();
      try {
        requireNonNull(e, "e must be non null");
        validateCurrentStateIsOneOf(State.allNonTerminal);
        if (e.hasChecksummedData()) {
          checkNotFinalizing(e.getChecksummedData().getContent().size());
        }
        int size = e.getChecksummedData().getContent().size();
        long availableCapacity = availableCapacity();
        if (size > availableCapacity) {
          return false;
        }

        checkArgument(
            e.hasOneof(FIRST_MESSAGE_DESCRIPTOR) || e.getWriteOffset() == totalSentBytes,
            "(write_offset == totalSentBytes) (%s == %s)",
            e.getWriteOffset(),
            totalSentBytes);
        return internalOffer(e);
      } finally {
        lock.unlock();
      }
    }

    protected void setConfirmedBytes(long newConfirmedBytes) {
      this.confirmedBytes = newConfirmedBytes;
      this.confirmedBytesUpdated.signalAll();
    }

    @Override
    final void updateStateFromResponse(BidiWriteObjectResponse response) {
      lock.lock();
      try {
        long persistedSize = -1;
        if (response.hasPersistedSize()) {
          persistedSize = response.getPersistedSize();
        } else if (response.hasResource()) {
          persistedSize = response.getResource().getSize();
          lastResponseWithResource = response;
          generation = lastResponseWithResource.getResource().getGeneration();
        }
        checkState(persistedSize > -1, "persistedSize > -1 (%s > -1)", persistedSize);
        checkArgument(
            persistedSize >= confirmedBytes,
            "(persistedSize >= confirmedBytes) (%s >= %s)",
            response,
            confirmedBytes);
        validateCurrentStateIsOneOf(
            State.INITIALIZING, State.TAKEOVER, State.RUNNING, State.RETRYING);
        routingToken = null;
        // todo: test more permutations where this might be true
        //   1. retry, object not yet created
        if (state == State.INITIALIZING) {
          setConfirmedBytes(persistedSize);
          totalSentBytes = Math.max(totalSentBytes, persistedSize);
        }
        if (state == State.INITIALIZING || state == State.RETRYING) {
          transitionTo(
              stateToReturnToAfterRetry != null ? stateToReturnToAfterRetry : State.RUNNING);
        }

        boolean signalTerminalSuccess = false;
        BidiWriteObjectRequest peek;
        while ((peek = peekFirst()) != null) {
          if (peek.hasChecksummedData()) {
            int size = peek.getChecksummedData().getContent().size();
            long endOffset = peek.getWriteOffset() + size;
            if (endOffset <= persistedSize) {
              poll();
              setConfirmedBytes(endOffset);
              enqueuedBytes -= size;
              minByteOffset = peek.getWriteOffset();
            } else {
              break;
            }
          } else if (peek.hasOneof(FIRST_MESSAGE_DESCRIPTOR)) {
            poll();
          } else if (peek.getFlush()) {
            if (finalFlushSent
                && persistedSize == totalSentBytes
                && persistedSize == finalFlushOffset) {
              setConfirmedBytes(persistedSize);
              signalTerminalSuccess = true;
              poll();
            } else if (persistedSize >= peek.getWriteOffset()) {
              setConfirmedBytes(persistedSize);
              poll();
            } else {
              break;
            }
          } else if (peek.getFinishWrite()) {
            checkState(
                enqueuedBytes == 0,
                "attempting to evict finish_write: true while bytes are still enqueued");
            if (response.hasResource()
                && persistedSize == totalSentBytes
                && persistedSize == finishWriteOffset) {
              setConfirmedBytes(persistedSize);
              if (response.getResource().hasFinalizeTime()) {
                signalTerminalSuccess = true;
                poll();
              } else {
                break;
              }
            } else {
              break;
            }
          } else {
            //noinspection DataFlowIssue
            checkState(false, "peek = {%s}, response = {%s}", fmtProto(peek), fmtProto(response));
          }
        }

        if (pendingReconciliation != null) {
          pendingReconciliation.set(null);
          pendingReconciliation = null;
        }

        if (signalTerminalSuccess && lastResponseWithResource != null) {
          BidiWriteObjectResponse.Builder b = lastResponseWithResource.toBuilder();
          b.getResourceBuilder().setSize(confirmedBytes);
          b.getResourceBuilder().getChecksumsBuilder().clearMd5Hash().clearCrc32C();
          if (cumulativeCrc32c != null) {
            b.getResourceBuilder().getChecksumsBuilder().setCrc32C(cumulativeCrc32c.getValue());
          }
          BidiWriteObjectResponse updated = b.build();
          resultFuture.set(updated);
          terminalSuccess();
        } else if (signalTerminalSuccess) {
          checkState(false, "signalTerminalSuccess without prior resource response");
        }
      } finally {
        lock.unlock();
      }
    }

    @Override
    final void updateFromRedirect(@NonNull BidiWriteObjectRedirectedError redirect) {
      lock.lock();
      try {
        validateCurrentStateIsOneOf(
            State.INITIALIZING, State.RUNNING, State.PENDING_RETRY, State.RETRYING);
        if (redirect.hasWriteHandle()) {
          this.writeHandle = redirect.getWriteHandle();
        }
        if (redirect.hasRoutingToken()) {
          routingToken = redirect.getRoutingToken();
        }
        if (redirect.hasGeneration()) {
          if (generation > 0) {
            checkState(
                generation == redirect.getGeneration(),
                "Generation changed: (generation == redirect.getGeneration()) (%s == %s)",
                generation,
                redirect.getGeneration());
          }
          generation = redirect.getGeneration();
        }
      } finally {
        lock.unlock();
      }
    }

    @Override
    final void terminalError() {
      lock.lock();
      try {
        validateCurrentStateIsOneOf(State.allNonTerminal);
        transitionTo(State.TERMINAL_ERROR);
        if (pendingReconciliation != null) {
          pendingReconciliation.cancel(true);
        }
        stateUpdated.signalAll();
      } finally {
        lock.unlock();
      }
    }

    private void terminalSuccess() {
      lock.lock();
      try {
        validateCurrentStateIsOneOf(State.allNonTerminal);
        transitionTo(State.TERMINAL_SUCCESS);
        stateUpdated.signalAll();
      } finally {
        lock.unlock();
      }
    }

    @Override
    final void pendingRetry() {
      lock.lock();
      try {
        validateCurrentStateIsOneOf(State.allNonTerminal);
        stateToReturnToAfterRetry = state;
        transitionTo(State.PENDING_RETRY);
      } finally {
        lock.unlock();
      }
    }

    @Override
    final void retrying() {
      lock.lock();
      try {
        validateCurrentStateIsOneOf(State.PENDING_RETRY, State.INITIALIZING, State.TAKEOVER);
        transitionTo(State.RETRYING);
        lastSentRequestIndex = -1;
        finishWriteSent = false;
      } finally {
        lock.unlock();
      }
    }

    @Override
    final boolean isFinalizing() {
      lock.lock();
      try {
        return finishWriteOffset >= 0 && finishWriteSent;
      } finally {
        lock.unlock();
      }
    }

    @Override
    ApiFuture<Void> beginReconciliation() {
      lock.lock();
      try {
        if (pendingReconciliation == null) {
          pendingReconciliation = SettableApiFuture.create();
        }
        return pendingReconciliation;
      } finally {
        lock.unlock();
      }
    }

    @Override
    final void sendVia(Consumer<BidiWriteObjectRequest> consumer) {
      lock.lock();
      try {
        validateCurrentStateIsOneOf(
            State.INITIALIZING, State.RUNNING, State.RETRYING, State.TAKEOVER);
        BidiWriteObjectRequest prev = null;
        int i = lastSentRequestIndex + 1;
        for (; i < queue.size(); i++) {
          BidiWriteObjectRequest m = queue.get(i);
          lastSentRequestIndex = i;
          if (state == State.RETRYING) {
            prev = m;
            break; // if retrying only send the first message
          }

          if (prev != null) {
            // never compact bytes, purely for simplicity’s sake. ByteString won't copy when
            // concatenating two values together, but there is a limit on how many bytes can be in
            // an
            // individual message, and it's much easier to not have to worry about all of that here.
            // We're mainly wanting to ensure things like flush/finish are packed into the last data
            // message, and the first data message is included with the initial request if no state
            // reconciliation needs to take place.
            if (prev.hasChecksummedData() && m.hasChecksummedData()) {
              consumer.accept(prev);
              prev = m;
            } else {
              prev = concatenate(prev, m);
            }
          } else {
            prev = m;
          }
        }
        if (prev != null) {
          if (prev.getFinishWrite()) {
            finishWriteSent = true;
          } else if (prev.getFlush() && prev.getStateLookup() && finalFlushOffset > -1) {
            finalFlushSent = true;
          }
          consumer.accept(prev);
        }
      } finally {
        lock.unlock();
      }
    }

    private void prepend(BidiWriteObjectRequest e) {
      queue.add(0, e);
      enqueuedBytes = enqueuedBytes + e.getChecksummedData().getContent().size();
    }

    private void append(BidiWriteObjectRequest e) {
      queue.add(e);
      enqueuedBytes = enqueuedBytes + e.getChecksummedData().getContent().size();
    }

    @Override
    final @Nullable BidiWriteObjectRequest peekLast() {
      lock.lock();
      try {
        int index = queue.size() - 1;
        if (index < 0) {
          return null;
        }
        return queue.get(index);
      } finally {
        lock.unlock();
      }
    }

    @VisibleForTesting
    @Override
    final @Nullable BidiWriteObjectRequest peekFirst() {
      lock.lock();
      try {
        if (queue.isEmpty()) {
          return null;
        }
        return queue.get(0);
      } finally {
        lock.unlock();
      }
    }

    private void poll() {
      BidiWriteObjectRequest remove = queue.remove(0);
      if (remove != null) {
        lastSentRequestIndex = Math.max(lastSentRequestIndex - 1, -1);
      }
    }

    protected final void transitionTo(State state) {
      this.state = state;
      stateUpdated.signalAll();
    }

    protected final void validateCurrentStateIsOneOf(State... allowed) {
      checkState(
          state.in(allowed),
          "state mismatch. expected one of %s but is %s",
          Arrays.toString(allowed),
          state);
    }

    private void checkNotFinalizing(int size) {
      checkState(
          finishWriteOffset == -1,
          "Attempting to append bytes even though finalization has previously been signaled."
              + " (finishWriteOffset: %s, totalSentBytes: %s, confirmedBytes: %s, size: %s)",
          finishWriteOffset,
          totalSentBytes,
          confirmedBytes,
          size);
    }

    protected final boolean internalOffer(BidiWriteObjectRequest e) {
      Consumer<BidiWriteObjectRequest> add = this::append;
      if (e.hasOneof(FIRST_MESSAGE_DESCRIPTOR)) {
        if (!queue.isEmpty() && queue.get(0).hasOneof(FIRST_MESSAGE_DESCRIPTOR)) {
          poll(); // dequeue the existing first message
        }
        add = this::prepend;
      }

      boolean appended = false;
      if (e.hasChecksummedData() && finishWriteOffset == -1) {
        ChecksummedData checksummedData = e.getChecksummedData();
        int size = checksummedData.getContent().size();
        if (size <= availableCapacity()) {
          totalSentBytes += size;
          add.accept(e);
          appended = true;
        }
      } else {
        add.accept(e);
        appended = true;
      }

      if (e.getFinishWrite()) {
        finishWriteOffset = totalSentBytes;
      }

      return appended;
    }

    @Nullable
    private Crc32cLengthKnown crc32cConcat(@Nullable Crc32cLengthKnown rhs) {
      if (cumulativeCrc32c == null) {
        return null;
      }
      requireNonNull(rhs, "rhs must be non null");
      return cumulativeCrc32c.concat(rhs);
    }

    @Override
    public SettableApiFuture<BidiWriteObjectResponse> getResultFuture() {
      return resultFuture;
    }

    @Override
    void awaitState(State... anyOf) throws InterruptedException {
      lock.lock();
      try {
        ImmutableSet<State> states = ImmutableSet.copyOf(anyOf);
        while (!states.contains(this.state) && !stateUpdated.await(5, TimeUnit.MILLISECONDS)) {
          if (resultFuture.isDone()) {
            return;
          }
        }
      } finally {
        lock.unlock();
      }
    }

    @Override
    public void awaitTakeoverStateReconciliation(Runnable restart) {
      try {
        pendingRetry();
        restart.run();
        awaitState(State.RUNNING);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw StorageException.coalesce(e);
      }
    }

    @Override
    public void awaitAck(long writeOffset) throws InterruptedException {
      lock.lock();
      try {
        while (confirmedBytes < writeOffset
            && !confirmedBytesUpdated.await(5, TimeUnit.MILLISECONDS)) {
          if (resultFuture.isDone()) {
            return;
          }
        }
      } finally {
        lock.unlock();
      }
    }
  }

  abstract static class AppendableUploadState extends BaseUploadState {

    private AppendableUploadState(
        BidiWriteObjectRequest initial,
        Supplier<GrpcCallContext> baseCallContext,
        long maxBytes,
        SettableApiFuture<BidiWriteObjectResponse> resultFuture,
        @Nullable Crc32cLengthKnown initialCrc32c,
        State startingState) {
      super(initial, baseCallContext, maxBytes, resultFuture, initialCrc32c, startingState);
    }

    protected abstract String getBucket();

    protected abstract BidiWriteObjectRequest.Builder getBuilder();

    @Override
    public @NonNull GrpcCallContext enqueueFirstMessageAndGetGrpcCallContext() {
      super.lock.lock();
      try {
        if (!state.in(State.INITIALIZING, State.RETRYING, State.TAKEOVER)) {
          return lastOpenArguments.getCtx();
        }
        ImmutableMap<String, List<String>> xGoogRequestParams =
            makeHeadersMap(
                Stream.of(
                    "bucket=" + this.getBucket(),
                    "appendable=true",
                    routingToken != null ? "routing_token=" + routingToken : null));
        GrpcCallContext context = baseCallContext.get().withExtraHeaders(xGoogRequestParams);

        BidiWriteObjectRequest.Builder b = this.getBuilder();
        if (state == State.RETRYING) {
          b.setStateLookup(true);
        }
        BidiWriteObjectRequest req = b.build();
        OpenArguments openArguments = new OpenArguments(req, context);
        internalOffer(req);
        lastOpenArguments = openArguments;
        return openArguments.getCtx();
      } finally {
        super.lock.unlock();
      }
    }

    @Override
    @Nullable StorageException onResponse(BidiWriteObjectResponse response) {
      lock.lock();
      try {
        validateCurrentStateIsOneOf(State.allNonTerminal);

        if (response.hasWriteHandle()) {
          this.writeHandle = response.getWriteHandle();
        }

        boolean incremental = !response.hasResource();
        long persistedSize = -1;
        if (response.hasPersistedSize()) {
          persistedSize = response.getPersistedSize();
        } else if (response.hasResource()) {
          persistedSize = response.getResource().getSize();
        }
        checkState(persistedSize > -1, "persistedSize > -1 (%s > -1)", persistedSize);
        if (state == State.TAKEOVER || stateToReturnToAfterRetry == State.TAKEOVER) {
          totalSentBytes = persistedSize;
          setConfirmedBytes(persistedSize);
          if (response.hasResource()
              && response.getResource().hasChecksums()
              && response.getResource().getChecksums().hasCrc32C()) {
            cumulativeCrc32c =
                Crc32cValue.of(response.getResource().getChecksums().getCrc32C(), persistedSize);
          }
          updateStateFromResponse(response);
          transitionTo(State.RUNNING);
          return null;
        }

        long totalSentBytes = getTotalSentBytes();
        long minWriteOffset = minByteOffset;
        boolean finalizing = isFinalizing();

        if (!finalizing && incremental) {
          if (persistedSize == totalSentBytes) {
            updateStateFromResponse(response);
          } else if (persistedSize < totalSentBytes) {
            updateStateFromResponse(response);
          } else {
            return err(UploadFailureScenario.SCENARIO_7, response);
          }
        } else if (finalizing && !incremental) {
          if (persistedSize == totalSentBytes) {
            updateStateFromResponse(response);
          } else if (persistedSize < totalSentBytes) {
            if (persistedSize > minWriteOffset) {
              updateStateFromResponse(response);
            } else if (lastResponseWithResource != null) {
              return err(UploadFailureScenario.SCENARIO_4_1, response);
            }
          } else {
            return err(UploadFailureScenario.SCENARIO_4_2, response);
          }
        } else if (!finalizing /* && !incremental*/) {
          // generally the first response from the server
          if (persistedSize <= totalSentBytes) {
            updateStateFromResponse(response);
          } else {
            return err(UploadFailureScenario.SCENARIO_7, response);
          }
        } else /* (finalizing && incremental) */ {
          // might happen if a `flush: true, state_lookup: true, finish_write: true`
          if (persistedSize == totalSentBytes) {
            updateStateFromResponse(response);
          } else if (persistedSize < totalSentBytes) {
            if (persistedSize > minWriteOffset) {
              updateStateFromResponse(response);
            } else if (lastResponseWithResource != null) {
              return err(UploadFailureScenario.SCENARIO_3, response);
            }
          } else {
            return err(UploadFailureScenario.SCENARIO_2, response);
          }
        }

        return null;
      } finally {
        lock.unlock();
      }
    }
  }

  static final class NewAppendableUploadState extends AppendableUploadState {
    private final WriteObjectSpec spec;

    private NewAppendableUploadState(
        BidiWriteObjectRequest initial,
        WriteObjectSpec spec,
        Supplier<GrpcCallContext> baseCallContext,
        long maxBytes,
        SettableApiFuture<BidiWriteObjectResponse> resultFuture,
        @Nullable Crc32cLengthKnown initialCrc32c) {
      super(initial, baseCallContext, maxBytes, resultFuture, initialCrc32c, State.INITIALIZING);
      this.spec = spec;
    }

    @Override
    protected String getBucket() {
      return spec.getResource().getBucket();
    }

    @Override
    protected BidiWriteObjectRequest.Builder getBuilder() {
      BidiWriteObjectRequest.Builder b = BidiWriteObjectRequest.newBuilder();
      if (confirmedBytes >= 0) {
        checkState(generation > 0, "generation > 0");

        AppendObjectSpec.Builder aosb =
            AppendObjectSpec.newBuilder()
                .setBucket(spec.getResource().getBucket())
                .setObject(spec.getResource().getName())
                .setGeneration(generation);
        if (spec.hasIfMetagenerationMatch()) {
          aosb.setIfMetagenerationMatch(spec.getIfMetagenerationMatch());
        }
        if (spec.hasIfMetagenerationNotMatch()) {
          aosb.setIfMetagenerationNotMatch(spec.getIfMetagenerationMatch());
        }
        ifNonNull(routingToken, aosb::setRoutingToken);
        ifNonNull(writeHandle, aosb::setWriteHandle);
        b.setAppendObjectSpec(aosb);
      } else {
        b.setWriteObjectSpec(spec);
      }
      return b;
    }
  }

  static final class TakeoverAppendableUploadState extends AppendableUploadState {
    private final AppendObjectSpec spec;

    private TakeoverAppendableUploadState(
        BidiWriteObjectRequest initial,
        AppendObjectSpec spec,
        Supplier<GrpcCallContext> baseCallContext,
        long maxBytes,
        SettableApiFuture<BidiWriteObjectResponse> resultFuture,
        @Nullable Crc32cLengthKnown initialCrc32c) {
      super(initial, baseCallContext, maxBytes, resultFuture, initialCrc32c, State.TAKEOVER);
      this.spec = spec;
    }

    @Override
    protected String getBucket() {
      return spec.getBucket();
    }

    @Override
    protected BidiWriteObjectRequest.Builder getBuilder() {
      AppendObjectSpec.Builder aosb = spec.toBuilder();
      ifNonNull(routingToken, aosb::setRoutingToken);
      ifNonNull(writeHandle, aosb::setWriteHandle);
      return BidiWriteObjectRequest.newBuilder().setAppendObjectSpec(aosb);
    }
  }

  static final class OpenArguments {

    private final BidiWriteObjectRequest req;
    private final GrpcCallContext ctx;

    private OpenArguments(BidiWriteObjectRequest req, GrpcCallContext ctx) {
      this.req = req;
      this.ctx = ctx;
    }

    public BidiWriteObjectRequest getReq() {
      return req;
    }

    public GrpcCallContext getCtx() {
      return ctx;
    }
  }
}
