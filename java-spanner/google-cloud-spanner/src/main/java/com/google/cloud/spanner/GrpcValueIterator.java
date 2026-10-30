/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner;

import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerException;
import static com.google.common.base.Preconditions.checkState;

import com.google.cloud.spanner.AbstractResultSet.CloseableIterator;
import com.google.cloud.spanner.AbstractResultSet.Listener;
import com.google.common.collect.AbstractIterator;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value.KindCase;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.TypeCode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.jspecify.annotations.Nullable;

/** Adapts a stream of {@code PartialResultSet} messages into a stream of {@code Value} messages. */
class GrpcValueIterator extends AbstractIterator<com.google.protobuf.Value> {
  private enum StreamValue {
    METADATA,
    RESULT,
  }

  private final CloseableIterator<PartialResultSet> stream;
  private final Deque<PartialResultSet> bufferedChunks = new ArrayDeque<>();
  private final ReentrantLock streamPollLock = new ReentrantLock();
  private volatile boolean closed;
  private volatile boolean streamFinished;
  private volatile ResultSetMetadata metadata;
  private volatile Type type;
  private volatile PartialResultSet current;
  private volatile int pos;
  private volatile ResultSetStats statistics;
  private final Listener listener;

  GrpcValueIterator(CloseableIterator<PartialResultSet> stream, Listener listener) {
    this.stream = stream;
    this.listener = listener;
  }

  @SuppressWarnings("unchecked")
  @Override
  protected com.google.protobuf.Value computeNext() {
    if (!ensureReady(StreamValue.RESULT)) {
      endOfData();
      return null;
    }
    com.google.protobuf.Value value = current.getValues(pos++);
    KindCase kind = value.getKindCase();

    if (!isMergeable(kind)) {
      if (pos == current.getValuesCount() && current.getChunkedValue()) {
        throw newSpannerException(ErrorCode.INTERNAL, "Unexpected chunked PartialResultSet.");
      } else {
        return value;
      }
    }
    if (!current.getChunkedValue() || pos != current.getValuesCount()) {
      return value;
    }

    Object merged =
        kind == KindCase.STRING_VALUE
            ? value.getStringValue()
            : new ArrayList<>(value.getListValue().getValuesList());
    while (current.getChunkedValue() && pos == current.getValuesCount()) {
      if (!ensureReady(StreamValue.RESULT)) {
        throw newSpannerException(
            ErrorCode.INTERNAL, "Stream closed in the middle of chunked value");
      }
      com.google.protobuf.Value newValue = current.getValues(pos++);
      if (newValue.getKindCase() != kind) {
        throw newSpannerException(
            ErrorCode.INTERNAL,
            "Unexpected type in middle of chunked value. Expected: "
                + kind
                + " but got: "
                + newValue.getKindCase());
      }
      if (kind == KindCase.STRING_VALUE) {
        merged = merged + newValue.getStringValue();
      } else {
        concatLists(
            (List<com.google.protobuf.Value>) merged, newValue.getListValue().getValuesList());
      }
    }
    if (kind == KindCase.STRING_VALUE) {
      return com.google.protobuf.Value.newBuilder().setStringValue((String) merged).build();
    } else {
      return com.google.protobuf.Value.newBuilder()
          .setListValue(
              ListValue.newBuilder().addAllValues((List<com.google.protobuf.Value>) merged))
          .build();
    }
  }

  ResultSetMetadata getMetadata() throws SpannerException {
    if (metadata == null) {
      if (!ensureReady(StreamValue.METADATA)) {
        throw newSpannerException(ErrorCode.INTERNAL, "Stream closed without sending metadata");
      }
    }
    return metadata;
  }

  /**
   * Get the query statistics. Query statistics are delivered with the last PartialResultSet in the
   * stream. Any attempt to call this method before the caller has finished consuming the results
   * will return null.
   */
  @Nullable ResultSetStats getStats() {
    return statistics;
  }

  boolean initiateStreaming(AsyncResultSet.StreamMessageListener streamMessageListener) {
    return stream.initiateStreaming(streamMessageListener);
  }

  /**
   * Returns the number of complete {@link com.google.protobuf.Value}s required to assemble one row
   * without blocking.
   *
   * <p>Returns at least {@code 1} even when the result set has 0 columns (such as DML statements
   * without a {@code THEN RETURN} clause or {@code QueryMode.PLAN} queries). For 0-column
   * statements, {@link GrpcResultSet#next()} calls {@link #ensureReady(StreamValue)} with {@link
   * StreamValue#RESULT}, which loops until the entire stream has finished so that the final {@link
   * ResultSetStats} is collected. Requiring at least 1 value ensures that {@link
   * #isDataAvailable()} waits for {@link #streamFinished} rather than returning {@code true} as
   * soon as an initial metadata-only chunk arrives.
   */
  private int requiredCompleteValues() {
    if (type != null) {
      return Math.max(1, type.getStructFields().size());
    }
    PartialResultSet firstChunk = bufferedChunks.peekFirst();
    if (firstChunk != null && firstChunk.hasMetadata() && firstChunk.getMetadata().hasRowType()) {
      return Math.max(1, firstChunk.getMetadata().getRowType().getFieldsCount());
    }
    return 1;
  }

  /**
   * Returns {@code true} if the first chunk of the stream has arrived in {@link #bufferedChunks}
   * but is missing the required row-type metadata. In that case, {@link #isDataAvailable()} should
   * return {@code true} immediately so {@link #ensureReady(StreamValue)} can surface the metadata
   * error without waiting for more chunks.
   *
   * <p>This should never happen in reality with a well-behaved Spanner backend or mock, which
   * always delivers row-type metadata in the first message. This is a defensive check to guarantee
   * that even in an ill-behaved situation, the client returns a reasonable error message instead of
   * getting stuck waiting for metadata that will never arrive.
   */
  private boolean hasInvalidFirstChunkMetadata() {
    if (type != null) {
      return false;
    }
    PartialResultSet firstChunk = bufferedChunks.peekFirst();
    return firstChunk != null
        && (!firstChunk.hasMetadata() || !firstChunk.getMetadata().hasRowType());
  }

  /**
   * Counts how many complete values are contributed by {@code chunk} starting at {@code
   * startIndex}.
   *
   * <p>Whenever a chunk has {@code chunked_value = true} (with a mergeable trailing value), its
   * last value is incomplete and will be merged with the first value of the following non-empty
   * chunk. Thus each chunk with an incomplete trailing value reduces the number of complete values
   * by 1 (either because its last value merges with the next chunk's first value, or, if it is the
   * final buffered chunk, because its last value is still awaiting continuation).
   */
  private int countCompleteValuesInChunk(@Nullable PartialResultSet chunk, int startIndex) {
    if (chunk == null) {
      return 0;
    }
    int count = chunk.getValuesCount();
    int remaining = count - startIndex;
    if (remaining <= 0) {
      return 0;
    }
    boolean hasIncompleteTrailingValue =
        chunk.getChunkedValue() && isMergeable(chunk.getValues(count - 1).getKindCase());
    return hasIncompleteTrailingValue ? remaining - 1 : remaining;
  }

  /**
   * Returns {@code true} if metadata is known (either already parsed into {@link #type} or present
   * on the first buffered chunk) and enough complete values are buffered to assemble a full row.
   *
   * <p>Short-circuits immediately without allocating an iterator if {@link #current} already
   * contains enough complete values or if {@link #bufferedChunks} is empty.
   */
  private boolean hasCompleteRowAvailable() {
    if (type == null && bufferedChunks.isEmpty()) {
      return false;
    }
    int requiredCompleteValues = requiredCompleteValues();
    int completeValues = countCompleteValuesInChunk(this.current, this.pos);
    if (completeValues >= requiredCompleteValues) {
      return true;
    }
    if (bufferedChunks.isEmpty()) {
      return false;
    }
    for (PartialResultSet chunk : bufferedChunks) {
      completeValues += countCompleteValuesInChunk(chunk, /* startIndex= */ 0);
      if (completeValues >= requiredCompleteValues) {
        return true;
      }
    }
    return false;
  }

  /**
   * Non-blockingly pulls available chunks from {@link #stream} into {@link #bufferedChunks} until a
   * complete row is available, EOF is reached, or no further chunks can be polled without blocking.
   *
   * <p>Acquires {@link #streamPollLock} via non-blocking {@link ReentrantLock#tryLock()} so that
   * calls to {@link #isDataAvailable()} never block if another thread is currently polling or
   * waiting on {@link #stream}.
   */
  private void bufferAvailableChunks() {
    if (!streamPollLock.tryLock()) {
      return;
    }
    try {
      while (!streamFinished
          && !hasInvalidFirstChunkMetadata()
          && !hasCompleteRowAvailable()
          && stream.canPollWithoutErrorOrBlocking()) {
        if (stream.hasNext()) {
          bufferedChunks.addLast(stream.next());
        } else {
          streamFinished = true;
        }
      }
    } finally {
      streamPollLock.unlock();
    }
  }

  /**
   * Returns {@code true} if the next call to {@link GrpcResultSet#next()} is guaranteed not to
   * block on network I/O (because a complete row, EOF, or an error/closure is already available).
   *
   * <p>All operations in this method are guaranteed to be non-blocking: {@link
   * #bufferAvailableChunks()} only polls while {@link
   * CloseableIterator#canPollWithoutErrorOrBlocking()} is true (which returns immediately from
   * memory without blocking or throwing), and subsequent checks inspect only in-memory buffered
   * state. Therefore, it is safe to hold the synchronization monitor for this method without risk
   * of blocking on network I/O.
   */
  synchronized boolean isDataAvailable() {
    bufferAvailableChunks();
    if (streamFinished || hasInvalidFirstChunkMetadata() || hasCompleteRowAvailable()) {
      return true;
    }
    return stream.isDataAvailable();
  }

  Type type() {
    checkState(type != null, "metadata has not been received");
    return type;
  }

  /**
   * Ensures that the iterator is in a ready state satisfying {@code requiredValue}.
   *
   * <ul>
   *   <li>For {@link StreamValue#METADATA}: Ensures that metadata has been received and parsed into
   *       {@link #type} (and {@link #metadata}). If metadata is already initialized, returns {@code
   *       true} immediately without advancing chunks. Otherwise, advances to the first chunk and
   *       initializes metadata, returning {@code true} even if that chunk contains zero values.
   *   <li>For {@link StreamValue#RESULT}: Ensures that {@link #current} contains at least one
   *       unread value (i.e. {@link #hasUnreadValuesInCurrentChunk()} is true). If {@link #current}
   *       is null or exhausted, advances through chunks until a chunk containing values is reached,
   *       or returns {@code false} if the stream finishes (EOF).
   * </ul>
   *
   * @param requiredValue whether metadata or a result value is required
   * @return {@code true} if the required item is ready; {@code false} if EOF is reached before it
   *     could be satisfied
   * @throws SpannerException if stream or metadata parsing errors occur
   */
  private boolean ensureReady(StreamValue requiredValue) throws SpannerException {
    if (requiredValue == StreamValue.METADATA && type != null) {
      return true;
    }
    while (!hasUnreadValuesInCurrentChunk()) {
      if (!advanceToNextChunk()) {
        return false;
      }
      if (type == null) {
        initializeMetadata(current);
      }
      updatePrecommitTokenAndStats(current);
      if (requiredValue == StreamValue.METADATA) {
        return true;
      }
    }
    return true;
  }

  private boolean hasUnreadValuesInCurrentChunk() {
    return current != null && pos < current.getValuesCount();
  }

  /**
   * Advances the iterator to the next {@link PartialResultSet} chunk, first draining any in-memory
   * chunks from {@link #bufferedChunks}, and falling back to pulling from {@link #stream}.
   *
   * @return {@code true} if a new chunk was successfully assigned to {@link #current}; {@code
   *     false} if the iterator is closed or the stream reached EOF
   */
  private boolean advanceToNextChunk() {
    PartialResultSet nextChunk;

    // Step 1: Fast-path. Attempt to retrieve an already-buffered chunk from memory.
    synchronized (this) {
      if (closed) {
        return false;
      }
      nextChunk = bufferedChunks.pollFirst();
      if (nextChunk == null && streamFinished) {
        // All buffered chunks have been consumed and the stream has reached EOF.
        return false;
      }
    }

    // Step 2: Slow-path. No in-memory chunk was immediately available; pull from the underlying
    // stream.
    if (nextChunk == null) {
      // Acquire streamPollLock outside 'synchronized (this)' so that blocking on network I/O
      // does not block concurrent callers of isDataAvailable().
      streamPollLock.lock();
      try {
        // Double-checked locking: Another thread (such as isDataAvailable()) might have buffered
        // chunks or closed the iterator while we were waiting to acquire streamPollLock.
        synchronized (this) {
          if (closed) {
            return false;
          }
          nextChunk = bufferedChunks.pollFirst();
          if (nextChunk == null && streamFinished) {
            return false;
          }
        }
        if (nextChunk == null) {
          if (!stream.hasNext()) {
            synchronized (this) {
              streamFinished = true;
            }
            return false;
          }
          nextChunk = stream.next();
        }
      } finally {
        streamPollLock.unlock();
      }
    }

    // Step 3: Assign the new chunk to current.
    synchronized (this) {
      // Check closed once more in case close() was called while stream.next() was in flight.
      // If closed, discard the chunk to avoid resurrecting state on a closed iterator.
      if (closed) {
        return false;
      }
      pos = 0;
      current = nextChunk;
    }
    return true;
  }

  private void initializeMetadata(PartialResultSet firstChunk) {
    if (!firstChunk.hasMetadata() || !firstChunk.getMetadata().hasRowType()) {
      throw newSpannerException(ErrorCode.INTERNAL, "Missing type metadata in first message");
    }
    metadata = firstChunk.getMetadata();
    com.google.spanner.v1.Type typeProto =
        com.google.spanner.v1.Type.newBuilder()
            .setCode(TypeCode.STRUCT)
            .setStructType(metadata.getRowType())
            .build();
    try {
      type = Type.fromProto(typeProto);
    } catch (IllegalArgumentException e) {
      throw newSpannerException(ErrorCode.INTERNAL, "Invalid type metadata: " + e.getMessage(), e);
    }
  }

  private void updatePrecommitTokenAndStats(PartialResultSet chunk) {
    if (chunk.hasPrecommitToken()) {
      listener.onPrecommitToken(chunk.getPrecommitToken());
    }
    if (chunk.hasStats()) {
      statistics = chunk.getStats();
    }
  }

  void close(@Nullable String message) {
    synchronized (this) {
      closed = true;
      bufferedChunks.clear();
      streamFinished = true;
    }
    stream.close(message);
  }

  boolean isWithBeginTransaction() {
    return stream.isWithBeginTransaction();
  }

  boolean isLastStatement() {
    return stream.isLastStatement();
  }

  /**
   * @param a is a mutable list and b will be concatenated into a.
   */
  private void concatLists(List<com.google.protobuf.Value> a, List<com.google.protobuf.Value> b) {
    if (a.size() == 0 || b.size() == 0) {
      a.addAll(b);
      return;
    } else {
      com.google.protobuf.Value last = a.get(a.size() - 1);
      com.google.protobuf.Value first = b.get(0);
      KindCase lastKind = last.getKindCase();
      KindCase firstKind = first.getKindCase();
      if (isMergeable(lastKind) && lastKind == firstKind) {
        com.google.protobuf.Value merged;
        if (lastKind == KindCase.STRING_VALUE) {
          String lastStr = last.getStringValue();
          String firstStr = first.getStringValue();
          merged =
              com.google.protobuf.Value.newBuilder().setStringValue(lastStr + firstStr).build();
        } else { // List
          List<com.google.protobuf.Value> mergedList = new ArrayList<>();
          mergedList.addAll(last.getListValue().getValuesList());
          concatLists(mergedList, first.getListValue().getValuesList());
          merged =
              com.google.protobuf.Value.newBuilder()
                  .setListValue(ListValue.newBuilder().addAllValues(mergedList))
                  .build();
        }
        a.set(a.size() - 1, merged);
        a.addAll(b.subList(1, b.size()));
      } else {
        a.addAll(b);
      }
    }
  }

  private boolean isMergeable(KindCase kind) {
    return kind == KindCase.STRING_VALUE || kind == KindCase.LIST_VALUE;
  }
}
