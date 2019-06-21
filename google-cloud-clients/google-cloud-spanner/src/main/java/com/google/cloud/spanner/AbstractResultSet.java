/*
 * Copyright 2019 Google LLC
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
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.api.client.util.BackOff;
import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.protobuf.ByteString;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value.KindCase;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TypeCode;
import io.grpc.Context;
import io.opencensus.common.Scope;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/** Implementation of {@link ResultSet}. */
abstract class AbstractResultSet<R> extends AbstractStructReader implements ResultSet {
  private static final Tracer tracer = Tracing.getTracer();

  interface Listener {
    /**
     * Called when transaction metadata is seen. This method may be invoked at most once. If the
     * method is invoked, it will precede {@link #onError(SpannerException)} or {@link #onDone()}.
     */
    void onTransactionMetadata(Transaction transaction) throws SpannerException;

    /** Called when the read finishes with an error. */
    void onError(SpannerException e);

    /** Called when the read finishes normally. */
    void onDone();
  }

  @VisibleForTesting
  static class GrpcResultSet extends AbstractResultSet<List<Object>> {
    private final GrpcValueIterator iterator;
    private final Listener listener;
    private GrpcStruct currRow;
    private SpannerException error;
    private ResultSetStats statistics;
    private boolean closed;

    GrpcResultSet(CloseableIterator<PartialResultSet> iterator, Listener listener) {
      this.iterator = new GrpcValueIterator(iterator);
      this.listener = listener;
    }

    @Override
    protected GrpcStruct currRow() {
      checkState(!closed, "ResultSet is closed");
      checkState(currRow != null, "next() call required");
      return currRow;
    }

    @Override
    public boolean next() throws SpannerException {
      if (error != null) {
        throw newSpannerException(error);
      }
      try {
        if (currRow == null) {
          ResultSetMetadata metadata = iterator.getMetadata();
          if (metadata.hasTransaction()) {
            listener.onTransactionMetadata(metadata.getTransaction());
          }
          currRow = new GrpcStruct(iterator.type(), new ArrayList<>());
        }
        boolean hasNext = currRow.consumeRow(iterator);
        if (!hasNext) {
          statistics = iterator.getStats();
        }
        return hasNext;
      } catch (SpannerException e) {
        throw yieldError(e);
      }
    }

    @Override
    @Nullable
    public ResultSetStats getStats() {
      return statistics;
    }

    @Override
    public void close() {
      iterator.close("ResultSet closed");
      closed = true;
    }

    @Override
    public Type getType() {
      checkState(currRow != null, "next() call required");
      return currRow.getType();
    }

    private SpannerException yieldError(SpannerException e) {
      close();
      listener.onError(e);
      throw e;
    }
  }
  /**
   * Adapts a stream of {@code PartialResultSet} messages into a stream of {@code Value} messages.
   */
  private static class GrpcValueIterator extends AbstractIterator<com.google.protobuf.Value> {
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

    GrpcValueIterator(CloseableIterator<PartialResultSet> stream) {
      this.stream = stream;
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
              : new ArrayList<com.google.protobuf.Value>(value.getListValue().getValuesList());
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
          merged = (String) merged + newValue.getStringValue();
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
     * Get the query statistics. Query statistics are delivered with the last PartialResultSet in
     * the stream. Any attempt to call this method before the caller has finished consuming the
     * results will return null.
     */
    @Nullable
    ResultSetStats getStats() {
      return statistics;
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

    /** @param a is a mutable list and b will be concatenated into a. */
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
          com.google.protobuf.Value merged = null;
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

  static class GrpcStruct extends Struct implements Serializable {
    private final Type type;
    private final List<Object> rowData;

    /**
     * Builds an immutable version of this struct using {@link Struct#newBuilder()} which is used as
     * a serialization proxy.
     */
    private Object writeReplace() {
      Builder builder = Struct.newBuilder();
      List<Type.StructField> structFields = getType().getStructFields();
      for (int i = 0; i < structFields.size(); i++) {
        Type.StructField field = structFields.get(i);
        String fieldName = field.getName();
        Object value = rowData.get(i);
        Type fieldType = field.getType();
        switch (fieldType.getCode()) {
          case BOOL:
            builder.set(fieldName).to((Boolean) value);
            break;
          case INT64:
            builder.set(fieldName).to((Long) value);
            break;
          case FLOAT64:
            builder.set(fieldName).to((Double) value);
            break;
          case STRING:
            builder.set(fieldName).to((String) value);
            break;
          case BYTES:
            builder.set(fieldName).to((ByteArray) value);
            break;
          case TIMESTAMP:
            builder.set(fieldName).to((Timestamp) value);
            break;
          case DATE:
            builder.set(fieldName).to((Date) value);
            break;
          case ARRAY:
            switch (fieldType.getArrayElementType().getCode()) {
              case BOOL:
                builder.set(fieldName).toBoolArray((Iterable<Boolean>) value);
                break;
              case INT64:
                builder.set(fieldName).toInt64Array((Iterable<Long>) value);
                break;
              case FLOAT64:
                builder.set(fieldName).toFloat64Array((Iterable<Double>) value);
                break;
              case STRING:
                builder.set(fieldName).toStringArray((Iterable<String>) value);
                break;
              case BYTES:
                builder.set(fieldName).toBytesArray((Iterable<ByteArray>) value);
                break;
              case TIMESTAMP:
                builder.set(fieldName).toTimestampArray((Iterable<Timestamp>) value);
                break;
              case DATE:
                builder.set(fieldName).toDateArray((Iterable<Date>) value);
                break;
              case STRUCT:
                builder
                    .set(fieldName)
                    .toStructArray(fieldType.getArrayElementType(), (Iterable<Struct>) value);
                break;
              default:
                throw new AssertionError(
                    "Unhandled array type code: " + fieldType.getArrayElementType());
            }
            break;
          case STRUCT:
            if (value == null) {
              builder.set(fieldName).to(fieldType, null);
            } else {
              builder.set(fieldName).to((Struct) value);
            }
            break;
          default:
            throw new AssertionError("Unhandled type code: " + fieldType.getCode());
        }
      }
      return builder.build();
    }

    GrpcStruct(Type type, List<Object> rowData) {
      this.type = type;
      this.rowData = rowData;
    }

    @Override
    public String toString() {
      return this.rowData.toString();
    }

    boolean consumeRow(Iterator<com.google.protobuf.Value> iterator) {
      rowData.clear();
      if (!iterator.hasNext()) {
        return false;
      }
      for (Type.StructField fieldType : getType().getStructFields()) {
        if (!iterator.hasNext()) {
          throw newSpannerException(
              ErrorCode.INTERNAL,
              "Invalid value stream: end of stream reached before row is complete");
        }
        com.google.protobuf.Value value = iterator.next();
        rowData.add(decodeValue(fieldType.getType(), value));
      }
      return true;
    }

    private static Object decodeValue(Type fieldType, com.google.protobuf.Value proto) {
      if (proto.getKindCase() == KindCase.NULL_VALUE) {
        return null;
      }
      switch (fieldType.getCode()) {
        case BOOL:
          checkType(fieldType, proto, KindCase.BOOL_VALUE);
          return proto.getBoolValue();
        case INT64:
          checkType(fieldType, proto, KindCase.STRING_VALUE);
          return Long.parseLong(proto.getStringValue());
        case FLOAT64:
          return valueProtoToFloat64(proto);
        case STRING:
          checkType(fieldType, proto, KindCase.STRING_VALUE);
          return proto.getStringValue();
        case BYTES:
          checkType(fieldType, proto, KindCase.STRING_VALUE);
          return ByteArray.fromBase64(proto.getStringValue());
        case TIMESTAMP:
          checkType(fieldType, proto, KindCase.STRING_VALUE);
          return Timestamp.parseTimestamp(proto.getStringValue());
        case DATE:
          checkType(fieldType, proto, KindCase.STRING_VALUE);
          return Date.parseDate(proto.getStringValue());
        case ARRAY:
          checkType(fieldType, proto, KindCase.LIST_VALUE);
          ListValue listValue = proto.getListValue();
          return decodeArrayValue(fieldType.getArrayElementType(), listValue);
        case STRUCT:
          checkType(fieldType, proto, KindCase.LIST_VALUE);
          ListValue structValue = proto.getListValue();
          return decodeStructValue(fieldType, structValue);
        default:
          throw new AssertionError("Unhandled type code: " + fieldType.getCode());
      }
    }

    private static Struct decodeStructValue(Type structType, ListValue structValue) {
      List<Type.StructField> fieldTypes = structType.getStructFields();
      checkArgument(
          structValue.getValuesCount() == fieldTypes.size(),
          "Size mismatch between type descriptor and actual values.");
      List<Object> fields = new ArrayList<>(fieldTypes.size());
      List<com.google.protobuf.Value> fieldValues = structValue.getValuesList();
      for (int i = 0; i < fieldTypes.size(); ++i) {
        fields.add(decodeValue(fieldTypes.get(i).getType(), fieldValues.get(i)));
      }
      return new GrpcStruct(structType, fields);
    }

    private static Object decodeArrayValue(Type elementType, ListValue listValue) {
      switch (elementType.getCode()) {
        case BOOL:
          // Use a view: element conversion is virtually free.
          return Lists.transform(
              listValue.getValuesList(),
              new Function<com.google.protobuf.Value, Boolean>() {
                @Override
                public Boolean apply(com.google.protobuf.Value input) {
                  return input.getKindCase() == KindCase.NULL_VALUE ? null : input.getBoolValue();
                }
              });
        case INT64:
          // For int64/float64 types, use custom containers.  These avoid wrapper object
          // creation for non-null arrays.
          return new Int64Array(listValue);
        case FLOAT64:
          return new Float64Array(listValue);
        case STRING:
          return Lists.transform(
              listValue.getValuesList(),
              new Function<com.google.protobuf.Value, String>() {
                @Override
                public String apply(com.google.protobuf.Value input) {
                  return input.getKindCase() == KindCase.NULL_VALUE ? null : input.getStringValue();
                }
              });
        case BYTES:
          {
            // Materialize list: element conversion is expensive and should happen only once.
            ArrayList<Object> list = new ArrayList<>(listValue.getValuesCount());
            for (com.google.protobuf.Value value : listValue.getValuesList()) {
              list.add(
                  value.getKindCase() == KindCase.NULL_VALUE
                      ? null
                      : ByteArray.fromBase64(value.getStringValue()));
            }
            return list;
          }
        case TIMESTAMP:
          {
            // Materialize list: element conversion is expensive and should happen only once.
            ArrayList<Object> list = new ArrayList<>(listValue.getValuesCount());
            for (com.google.protobuf.Value value : listValue.getValuesList()) {
              list.add(
                  value.getKindCase() == KindCase.NULL_VALUE
                      ? null
                      : Timestamp.parseTimestamp(value.getStringValue()));
            }
            return list;
          }
        case DATE:
          {
            // Materialize list: element conversion is expensive and should happen only once.
            ArrayList<Object> list = new ArrayList<>(listValue.getValuesCount());
            for (com.google.protobuf.Value value : listValue.getValuesList()) {
              list.add(
                  value.getKindCase() == KindCase.NULL_VALUE
                      ? null
                      : Date.parseDate(value.getStringValue()));
            }
            return list;
          }

        case STRUCT:
          {
            ArrayList<Struct> list = new ArrayList<>(listValue.getValuesCount());
            for (com.google.protobuf.Value value : listValue.getValuesList()) {
              if (value.getKindCase() == KindCase.NULL_VALUE) {
                list.add(null);
              } else {
                ListValue structValue = value.getListValue();
                list.add(decodeStructValue(elementType, structValue));
              }
            }
            return list;
          }
        default:
          throw new AssertionError("Unhandled type code: " + elementType.getCode());
      }
    }

    private static void checkType(
        Type fieldType, com.google.protobuf.Value proto, KindCase expected) {
      if (proto.getKindCase() != expected) {
        throw newSpannerException(
            ErrorCode.INTERNAL,
            "Invalid value for column type "
                + fieldType
                + " expected "
                + expected
                + " but was "
                + proto.getKindCase());
      }
    }

    Struct immutableCopy() {
      return new GrpcStruct(type, new ArrayList<>(rowData));
    }

    @Override
    public Type getType() {
      return type;
    }

    @Override
    public boolean isNull(int columnIndex) {
      return rowData.get(columnIndex) == null;
    }

    @Override
    protected boolean getBooleanInternal(int columnIndex) {
      return (Boolean) rowData.get(columnIndex);
    }

    @Override
    protected long getLongInternal(int columnIndex) {
      return (Long) rowData.get(columnIndex);
    }

    @Override
    protected double getDoubleInternal(int columnIndex) {
      return (Double) rowData.get(columnIndex);
    }

    @Override
    protected String getStringInternal(int columnIndex) {
      return (String) rowData.get(columnIndex);
    }

    @Override
    protected ByteArray getBytesInternal(int columnIndex) {
      return (ByteArray) rowData.get(columnIndex);
    }

    @Override
    protected Timestamp getTimestampInternal(int columnIndex) {
      return (Timestamp) rowData.get(columnIndex);
    }

    @Override
    protected Date getDateInternal(int columnIndex) {
      return (Date) rowData.get(columnIndex);
    }

    @Override
    protected Struct getStructInternal(int columnIndex) {
      return (Struct) rowData.get(columnIndex);
    }

    @Override
    protected boolean[] getBooleanArrayInternal(int columnIndex) {
      @SuppressWarnings("unchecked") // We know ARRAY<BOOL> produces a List<Boolean>.
      List<Boolean> values = (List<Boolean>) rowData.get(columnIndex);
      boolean[] r = new boolean[values.size()];
      for (int i = 0; i < values.size(); ++i) {
        if (values.get(i) == null) {
          throw throwNotNull(columnIndex);
        }
        r[i] = values.get(i);
      }
      return r;
    }

    @Override
    @SuppressWarnings("unchecked") // We know ARRAY<BOOL> produces a List<Boolean>.
    protected List<Boolean> getBooleanListInternal(int columnIndex) {
      return Collections.unmodifiableList((List<Boolean>) rowData.get(columnIndex));
    }

    @Override
    protected long[] getLongArrayInternal(int columnIndex) {
      return getLongListInternal(columnIndex).toPrimitiveArray(columnIndex);
    }

    @Override
    protected Int64Array getLongListInternal(int columnIndex) {
      return (Int64Array) rowData.get(columnIndex);
    }

    @Override
    protected double[] getDoubleArrayInternal(int columnIndex) {
      return getDoubleListInternal(columnIndex).toPrimitiveArray(columnIndex);
    }

    @Override
    protected Float64Array getDoubleListInternal(int columnIndex) {
      return (Float64Array) rowData.get(columnIndex);
    }

    @Override
    @SuppressWarnings("unchecked") // We know ARRAY<STRING> produces a List<String>.
    protected List<String> getStringListInternal(int columnIndex) {
      return Collections.unmodifiableList((List<String>) rowData.get(columnIndex));
    }

    @Override
    @SuppressWarnings("unchecked") // We know ARRAY<BYTES> produces a List<ByteArray>.
    protected List<ByteArray> getBytesListInternal(int columnIndex) {
      return Collections.unmodifiableList((List<ByteArray>) rowData.get(columnIndex));
    }

    @Override
    @SuppressWarnings("unchecked") // We know ARRAY<TIMESTAMP> produces a List<Timestamp>.
    protected List<Timestamp> getTimestampListInternal(int columnIndex) {
      return Collections.unmodifiableList((List<Timestamp>) rowData.get(columnIndex));
    }

    @Override
    @SuppressWarnings("unchecked") // We know ARRAY<DATE> produces a List<Date>.
    protected List<Date> getDateListInternal(int columnIndex) {
      return Collections.unmodifiableList((List<Date>) rowData.get(columnIndex));
    }

    @Override
    @SuppressWarnings("unchecked") // We know ARRAY<STRUCT<...>> produces a List<STRUCT>.
    protected List<Struct> getStructListInternal(int columnIndex) {
      return Collections.unmodifiableList((List<Struct>) rowData.get(columnIndex));
    }
  }

  @VisibleForTesting
  interface CloseableIterator<T> extends Iterator<T> {

    /**
     * Closes the iterator, freeing any underlying resources.
     *
     * @param message a message to include in the final RPC status
     */
    void close(@Nullable String message);
  }

  /** Adapts a streaming read/query call into an iterator over partial result sets. */
  @VisibleForTesting
  static class GrpcStreamIterator extends AbstractIterator<PartialResultSet>
      implements CloseableIterator<PartialResultSet> {
    private static final PartialResultSet END_OF_STREAM = PartialResultSet.newBuilder().build();

    private final ConsumerImpl consumer = new ConsumerImpl();
    private final BlockingQueue<PartialResultSet> stream;

    private SpannerRpc.StreamingCall call;
    private SpannerException error;

    // Visible for testing.
    GrpcStreamIterator(int prefetchChunks) {
      // One extra to allow for END_OF_STREAM message.
      this.stream = new LinkedBlockingQueue<>(prefetchChunks + 1);
    }

    protected final SpannerRpc.ResultStreamConsumer consumer() {
      return consumer;
    }

    public void setCall(SpannerRpc.StreamingCall call) {
      this.call = call;
    }

    @Override
    public void close(@Nullable String message) {
      if (call != null) {
        call.cancel(message);
      }
    }

    @Override
    protected final PartialResultSet computeNext() {
      PartialResultSet next;
      try {
        // TODO: Ideally honor io.grpc.Context while blocking here.  In practice,
        //       cancellation/deadline results in an error being delivered to "stream", which
        //       should mean that we do not block significantly longer afterwards, but it would
        //       be more robust to use poll() with a timeout.
        next = stream.take();
      } catch (InterruptedException e) {
        // Treat interrupt as a request to cancel the read.
        throw SpannerExceptionFactory.propagateInterrupt(e);
      }
      if (next != END_OF_STREAM) {
        call.request(1);
        return next;
      }

      // All done - close() no longer needs to cancel the call.
      call = null;

      if (error != null) {
        throw SpannerExceptionFactory.newSpannerException(error);
      }

      endOfData();
      return null;
    }

    private void addToStream(PartialResultSet results) {
      // We assume that nothing from the user will interrupt gRPC event threads.
      Uninterruptibles.putUninterruptibly(stream, results);
    }

    private class ConsumerImpl implements SpannerRpc.ResultStreamConsumer {
      @Override
      public void onPartialResultSet(PartialResultSet results) {
        addToStream(results);
      }

      @Override
      public void onCompleted() {
        addToStream(END_OF_STREAM);
      }

      @Override
      public void onError(SpannerException e) {
        error = e;
        addToStream(END_OF_STREAM);
      }

      // Visible only for testing.
      @VisibleForTesting
      void setCall(SpannerRpc.StreamingCall call) {
        GrpcStreamIterator.this.setCall(call);
      }
    }
  }

  /**
   * Wraps an iterator over partial result sets, supporting resuming RPCs on error. This class keeps
   * track of the most recent resume token seen, and will buffer partial result set chunks that do
   * not have a resume token until one is seen or buffer space is exceeded, which reduces the chance
   * of yielding data to the caller that cannot be resumed.
   */
  @VisibleForTesting
  abstract static class ResumableStreamIterator extends AbstractIterator<PartialResultSet>
      implements CloseableIterator<PartialResultSet> {
    private static final Logger logger = Logger.getLogger(ResumableStreamIterator.class.getName());
    private final BackOff backOff = SpannerImpl.newBackOff();
    private final LinkedList<PartialResultSet> buffer = new LinkedList<>();
    private final int maxBufferSize;
    private final Span span;
    private CloseableIterator<PartialResultSet> stream;
    private ByteString resumeToken;
    private boolean finished;
    /**
     * Indicates whether it is currently safe to retry RPCs. This will be {@code false} if we have
     * reached the maximum buffer size without seeing a restart token; in this case, we will drain
     * the buffer and remain in this state until we see a new restart token.
     */
    private boolean safeToRetry = true;

    protected ResumableStreamIterator(int maxBufferSize, String streamName, Span parent) {
      checkArgument(maxBufferSize >= 0);
      this.maxBufferSize = maxBufferSize;
      this.span = tracer.spanBuilderWithExplicitParent(streamName, parent).startSpan();
    }

    abstract CloseableIterator<PartialResultSet> startStream(@Nullable ByteString resumeToken);

    @Override
    public void close(@Nullable String message) {
      if (stream != null) {
        stream.close(message);
        span.end();
      }
    }

    @Override
    protected PartialResultSet computeNext() {
      Context context = Context.current();
      while (true) {
        // Eagerly start stream before consuming any buffered items.
        if (stream == null) {
          span.addAnnotation(
              "Starting/Resuming stream",
              ImmutableMap.of(
                  "ResumeToken",
                  AttributeValue.stringAttributeValue(
                      resumeToken == null ? "null" : resumeToken.toStringUtf8())));
          try (Scope s = tracer.withSpan(span)) {
            // When start a new stream set the Span as current to make the gRPC Span a child of
            // this Span.
            stream = checkNotNull(startStream(resumeToken));
          }
        }
        // Buffer contains items up to a resume token or has reached capacity: flush.
        if (!buffer.isEmpty()
            && (finished || !safeToRetry || !buffer.getLast().getResumeToken().isEmpty())) {
          return buffer.pop();
        }
        try {
          if (stream.hasNext()) {
            PartialResultSet next = stream.next();
            boolean hasResumeToken = !next.getResumeToken().isEmpty();
            if (hasResumeToken) {
              resumeToken = next.getResumeToken();
              safeToRetry = true;
            }
            // If the buffer is empty and this chunk has a resume token or we cannot resume safely
            // anyway, we can yield it immediately rather than placing it in the buffer to be
            // returned on the next iteration.
            if ((hasResumeToken || !safeToRetry) && buffer.isEmpty()) {
              return next;
            }
            buffer.add(next);
            if (buffer.size() > maxBufferSize && buffer.getLast().getResumeToken().isEmpty()) {
              // We need to flush without a restart token.  Errors encountered until we see
              // such a token will fail the read.
              safeToRetry = false;
            }
          } else {
            finished = true;
            if (buffer.isEmpty()) {
              endOfData();
              return null;
            }
          }
        } catch (SpannerException e) {
          if (safeToRetry && e.isRetryable()) {
            span.addAnnotation(
                "Stream broken. Safe to retry", TraceUtil.getExceptionAnnotations(e));
            logger.log(Level.FINE, "Retryable exception, will sleep and retry", e);
            // Truncate any items in the buffer before the last retry token.
            while (!buffer.isEmpty() && buffer.getLast().getResumeToken().isEmpty()) {
              buffer.removeLast();
            }
            assert buffer.isEmpty() || buffer.getLast().getResumeToken().equals(resumeToken);
            stream = null;
            try (Scope s = tracer.withSpan(span)) {
              long delay = e.getRetryDelayInMillis();
              if (delay != -1) {
                SpannerImpl.backoffSleep(context, delay);
              } else {
                SpannerImpl.backoffSleep(context, backOff);
              }
            }
            continue;
          }
          span.addAnnotation("Stream broken. Not safe to retry");
          TraceUtil.endSpanWithFailure(span, e);
          throw e;
        } catch (RuntimeException e) {
          span.addAnnotation("Stream broken. Not safe to retry");
          TraceUtil.endSpanWithFailure(span, e);
          throw e;
        }
      }
    }
  }

  private static double valueProtoToFloat64(com.google.protobuf.Value proto) {
    if (proto.getKindCase() == KindCase.STRING_VALUE) {
      switch (proto.getStringValue()) {
        case "-Infinity":
          return Double.NEGATIVE_INFINITY;
        case "Infinity":
          return Double.POSITIVE_INFINITY;
        case "NaN":
          return Double.NaN;
        default:
          // Fall-through to handling below to produce an error.
      }
    }
    if (proto.getKindCase() != KindCase.NUMBER_VALUE) {
      throw newSpannerException(
          ErrorCode.INTERNAL,
          "Invalid value for column type "
              + Type.float64()
              + " expected NUMBER_VALUE or STRING_VALUE with value one of"
              + " \"Infinity\", \"-Infinity\", or \"NaN\" but was "
              + proto.getKindCase()
              + (proto.getKindCase() == KindCase.STRING_VALUE
                  ? " with value \"" + proto.getStringValue() + "\""
                  : ""));
    }
    return proto.getNumberValue();
  }

  private static NullPointerException throwNotNull(int columnIndex) {
    throw new NullPointerException(
        "Cannot call array getter for column " + columnIndex + " with null elements");
  }

  /**
   * Memory-optimized base class for {@code ARRAY<INT64>} and {@code ARRAY<FLOAT64>} types. Both of
   * these involve conversions from the type yielded by JSON parsing, which are {@code String} and
   * {@code BigDecimal} respectively. Rather than construct new wrapper objects for each array
   * element, we use primitive arrays and a {@code BitSet} to track nulls.
   */
  private abstract static class PrimitiveArray<T, A> extends AbstractList<T> {
    private final A data;
    private final BitSet nulls;
    private final int size;

    PrimitiveArray(ListValue protoList) {
      this.size = protoList.getValuesCount();
      A data = newArray(size);
      BitSet nulls = new BitSet(size);
      for (int i = 0; i < protoList.getValuesCount(); ++i) {
        if (protoList.getValues(i).getKindCase() == KindCase.NULL_VALUE) {
          nulls.set(i);
        } else {
          setProto(data, i, protoList.getValues(i));
        }
      }
      this.data = data;
      this.nulls = nulls;
    }

    PrimitiveArray(A data, BitSet nulls, int size) {
      this.data = data;
      this.nulls = nulls;
      this.size = size;
    }

    abstract A newArray(int size);

    abstract void setProto(A array, int i, com.google.protobuf.Value protoValue);

    abstract T get(A array, int i);

    @Override
    public T get(int index) {
      if (index < 0 || index >= size) {
        throw new ArrayIndexOutOfBoundsException("index=" + index + " size=" + size);
      }
      return nulls.get(index) ? null : get(data, index);
    }

    @Override
    public int size() {
      return size;
    }

    A toPrimitiveArray(int columnIndex) {
      if (nulls.length() > 0) {
        throw throwNotNull(columnIndex);
      }
      A r = newArray(size);
      System.arraycopy(data, 0, r, 0, size);
      return r;
    }
  }

  private static class Int64Array extends PrimitiveArray<Long, long[]> {
    Int64Array(ListValue protoList) {
      super(protoList);
    }

    Int64Array(long[] data, BitSet nulls) {
      super(data, nulls, data.length);
    }

    @Override
    long[] newArray(int size) {
      return new long[size];
    }

    @Override
    void setProto(long[] array, int i, com.google.protobuf.Value protoValue) {
      array[i] = Long.parseLong(protoValue.getStringValue());
    }

    @Override
    Long get(long[] array, int i) {
      return array[i];
    }
  }

  private static class Float64Array extends PrimitiveArray<Double, double[]> {
    Float64Array(ListValue protoList) {
      super(protoList);
    }

    Float64Array(double[] data, BitSet nulls) {
      super(data, nulls, data.length);
    }

    @Override
    double[] newArray(int size) {
      return new double[size];
    }

    @Override
    void setProto(double[] array, int i, com.google.protobuf.Value protoValue) {
      array[i] = valueProtoToFloat64(protoValue);
    }

    @Override
    Double get(double[] array, int i) {
      return array[i];
    }
  }

  protected abstract GrpcStruct currRow();

  @Override
  public Struct getCurrentRowAsStruct() {
    return currRow().immutableCopy();
  }

  @Override
  protected boolean getBooleanInternal(int columnIndex) {
    return currRow().getBooleanInternal(columnIndex);
  }

  @Override
  protected long getLongInternal(int columnIndex) {
    return currRow().getLongInternal(columnIndex);
  }

  @Override
  protected double getDoubleInternal(int columnIndex) {
    return currRow().getDoubleInternal(columnIndex);
  }

  @Override
  protected String getStringInternal(int columnIndex) {
    return currRow().getStringInternal(columnIndex);
  }

  @Override
  protected ByteArray getBytesInternal(int columnIndex) {
    return currRow().getBytesInternal(columnIndex);
  }

  @Override
  protected Timestamp getTimestampInternal(int columnIndex) {
    return currRow().getTimestampInternal(columnIndex);
  }

  @Override
  protected Date getDateInternal(int columnIndex) {
    return currRow().getDateInternal(columnIndex);
  }

  @Override
  protected boolean[] getBooleanArrayInternal(int columnIndex) {
    return currRow().getBooleanArrayInternal(columnIndex);
  }

  @Override
  protected List<Boolean> getBooleanListInternal(int columnIndex) {
    return currRow().getBooleanListInternal(columnIndex);
  }

  @Override
  protected long[] getLongArrayInternal(int columnIndex) {
    return currRow().getLongArrayInternal(columnIndex);
  }

  @Override
  protected List<Long> getLongListInternal(int columnIndex) {
    return currRow().getLongListInternal(columnIndex);
  }

  @Override
  protected double[] getDoubleArrayInternal(int columnIndex) {
    return currRow().getDoubleArrayInternal(columnIndex);
  }

  @Override
  protected List<Double> getDoubleListInternal(int columnIndex) {
    return currRow().getDoubleListInternal(columnIndex);
  }

  @Override
  protected List<String> getStringListInternal(int columnIndex) {
    return currRow().getStringListInternal(columnIndex);
  }

  @Override
  protected List<ByteArray> getBytesListInternal(int columnIndex) {
    return currRow().getBytesListInternal(columnIndex);
  }

  @Override
  protected List<Timestamp> getTimestampListInternal(int columnIndex) {
    return currRow().getTimestampListInternal(columnIndex);
  }

  @Override
  protected List<Date> getDateListInternal(int columnIndex) {
    return currRow().getDateListInternal(columnIndex);
  }

  @Override
  protected List<Struct> getStructListInternal(int columnIndex) {
    return currRow().getStructListInternal(columnIndex);
  }

  @Override
  public boolean isNull(int columnIndex) {
    return currRow().isNull(columnIndex);
  }
}
