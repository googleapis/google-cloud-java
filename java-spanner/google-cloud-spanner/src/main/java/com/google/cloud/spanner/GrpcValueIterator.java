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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

/** Adapts a stream of {@code PartialResultSet} messages into a stream of {@code Value} messages. */
class GrpcValueIterator extends AbstractIterator<com.google.protobuf.Value> {
  private enum StreamValue {
    METADATA,
    RESULT,
  }

  private final CloseableIterator<PartialResultSet> stream;
  private final LinkedList<PartialResultSet> bufferedChunks = new LinkedList<>();
  private boolean streamFinished;
  private ResultSetMetadata metadata;
  private Type type;
  private volatile PartialResultSet current;
  private volatile int pos;
  private ResultSetStats statistics;
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
  @Nullable
  ResultSetStats getStats() {
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
    return Math.max(1, firstChunk.getMetadata().getRowType().getFieldsCount());
  }

  /**
   * Returns {@code true} if the first chunk of the stream has arrived in {@link #bufferedChunks}
   * but is missing the required row-type metadata. In that case, {@link #isDataAvailable()} should
   * return {@code true} immediately so {@link #ensureReady(StreamValue)} can surface the metadata
   * error without waiting for more chunks.
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
   * Counts the total number of complete (fully merged) {@link com.google.protobuf.Value}s currently
   * available across the unconsumed tail of {@link #current} and all chunks in {@link
   * #bufferedChunks}.
   */
  private int countCompleteValues() {
    int completeValues = countCompleteValuesInChunk(this.current, this.pos);
    for (PartialResultSet chunk : bufferedChunks) {
      completeValues += countCompleteValuesInChunk(chunk, 0);
    }
    return completeValues;
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
   */
  private boolean hasCompleteRowAvailable() {
    return (type != null || !bufferedChunks.isEmpty())
        && countCompleteValues() >= requiredCompleteValues();
  }

  /**
   * Non-blockingly pulls available chunks from {@link #stream} into {@link #bufferedChunks} until a
   * complete row is available, EOF is reached, or no further chunks can be polled without blocking.
   */
  private void bufferAvailableChunks() {
    while (!streamFinished
        && !hasInvalidFirstChunkMetadata()
        && !hasCompleteRowAvailable()
        && stream.canPollWithoutBlocking()) {
      if (stream.hasNext()) {
        bufferedChunks.addLast(stream.next());
      } else {
        streamFinished = true;
      }
    }
  }

  /**
   * Returns {@code true} if the next call to {@link GrpcResultSet#next()} is guaranteed not to
   * block on network I/O (because a complete row, EOF, or an error/closure is already available).
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

  private boolean ensureReady(StreamValue requiredValue) throws SpannerException {
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

  private boolean advanceToNextChunk() {
    PartialResultSet nextChunk;
    synchronized (this) {
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
    synchronized (this) {
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
