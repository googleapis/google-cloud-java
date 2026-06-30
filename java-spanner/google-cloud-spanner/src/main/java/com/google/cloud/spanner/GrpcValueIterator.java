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
import java.util.List;
import javax.annotation.Nullable;

/** Adapts a stream of {@code PartialResultSet} messages into a stream of {@code Value} messages. */
class GrpcValueIterator extends AbstractIterator<com.google.protobuf.Value> {
  private enum StreamValue {
    METADATA,
    RESULT,
  }

  private final CloseableIterator<PartialResultSet> stream;
  private ResultSetMetadata metadata;
  private Type type;
  private PartialResultSet current;
  private int pos;
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

  Type type() {
    checkState(type != null, "metadata has not been received");
    return type;
  }

  private boolean ensureReady(StreamValue requiredValue) throws SpannerException {
    while (current == null || pos >= current.getValuesCount()) {
      if (!stream.hasNext()) {
        return false;
      }
      current = stream.next();
      pos = 0;
      if (type == null) {
        // This is the first message on the stream.
        if (!current.hasMetadata() || !current.getMetadata().hasRowType()) {
          throw newSpannerException(ErrorCode.INTERNAL, "Missing type metadata in first message");
        }
        metadata = current.getMetadata();
        com.google.spanner.v1.Type typeProto =
            com.google.spanner.v1.Type.newBuilder()
                .setCode(TypeCode.STRUCT)
                .setStructType(metadata.getRowType())
                .build();
        try {
          type = Type.fromProto(typeProto);
        } catch (IllegalArgumentException e) {
          throw newSpannerException(
              ErrorCode.INTERNAL, "Invalid type metadata: " + e.getMessage(), e);
        }
      }
      // collect the precommit token from each PartialResultSet
      if (current.hasPrecommitToken()) {
        listener.onPrecommitToken(current.getPrecommitToken());
      }
      if (current.hasStats()) {
        statistics = current.getStats();
      }
      if (requiredValue == StreamValue.METADATA) {
        return true;
      }
    }
    return true;
  }

  void close(@Nullable String message) {
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
