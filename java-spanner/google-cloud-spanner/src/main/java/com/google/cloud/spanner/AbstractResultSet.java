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

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ListValue;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.Value.KindCase;
import com.google.spanner.v1.MultiplexedSessionPrecommitToken;
import com.google.spanner.v1.Transaction;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.AbstractList;
import java.util.Base64;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** Implementation of {@link ResultSet}. */
abstract class AbstractResultSet<R> extends AbstractStructReader implements ResultSet {

  interface Listener {
    /**
     * Called when transaction metadata is seen. This method may be invoked at most once. If the
     * method is invoked, it will precede {@link #onError(SpannerException,boolean)} or {@link
     * #onDone(boolean)}.
     */
    void onTransactionMetadata(Transaction transaction, boolean shouldIncludeId)
        throws SpannerException;

    /** Called when the read finishes with an error. Returns the error that should be thrown. */
    SpannerException onError(
        SpannerException e, boolean withBeginTransaction, boolean lastStatement);

    /** Called when the read finishes normally. */
    void onDone(boolean withBeginTransaction);

    /**
     * Called when the RPC response contains a MultiplexedSessionPrecommitToken. A precommit token
     * will be included if the read-write transaction is executed on a multiplexed session.
     */
    void onPrecommitToken(MultiplexedSessionPrecommitToken token);
  }

  static final class LazyByteArray implements Serializable {
    private static final Base64.Encoder ENCODER = Base64.getEncoder();
    private static final Base64.Decoder DECODER = Base64.getDecoder();
    private final String base64String;
    private transient AbstractLazyInitializer<ByteArray> byteArray;

    LazyByteArray(@Nonnull String base64String) {
      this.base64String = Preconditions.checkNotNull(base64String);
      this.byteArray = defaultInitializer();
    }

    LazyByteArray(@Nonnull ByteArray byteArray) {
      this.base64String =
          ENCODER.encodeToString(Preconditions.checkNotNull(byteArray).toByteArray());
      this.byteArray =
          new AbstractLazyInitializer<ByteArray>() {
            @Override
            protected ByteArray initialize() {
              return byteArray;
            }
          };
    }

    private AbstractLazyInitializer<ByteArray> defaultInitializer() {
      return new AbstractLazyInitializer<ByteArray>() {
        @Override
        protected ByteArray initialize() {
          return ByteArray.copyFrom(DECODER.decode(base64String));
        }
      };
    }

    private void readObject(java.io.ObjectInputStream in)
        throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      byteArray = defaultInitializer();
    }

    ByteArray getByteArray() {
      try {
        return byteArray.get();
      } catch (Throwable t) {
        throw SpannerExceptionFactory.asSpannerException(t);
      }
    }

    String getBase64String() {
      return base64String;
    }

    @Override
    public String toString() {
      return getBase64String();
    }

    @Override
    public int hashCode() {
      return base64String.hashCode();
    }

    @Override
    public boolean equals(Object o) {
      if (o instanceof LazyByteArray) {
        return lazyByteArraysEqual((LazyByteArray) o);
      }
      return false;
    }

    private boolean lazyByteArraysEqual(LazyByteArray other) {
      return Objects.equals(getBase64String(), other.getBase64String());
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

    boolean isWithBeginTransaction();

    boolean isLastStatement();

    /**
     * @param streamMessageListener A class object which implements StreamMessageListener
     * @return true if streaming is supported by the iterator, otherwise false
     */
    default boolean initiateStreaming(AsyncResultSet.StreamMessageListener streamMessageListener) {
      return false;
    }

    /** it requests the initial prefetch chunks from gRPC stream */
    default void requestPrefetchChunks() {}
  }

  static double valueProtoToFloat64(com.google.protobuf.Value proto) {
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

  static float valueProtoToFloat32(com.google.protobuf.Value proto) {
    if (proto.getKindCase() == KindCase.STRING_VALUE) {
      switch (proto.getStringValue()) {
        case "-Infinity":
          return Float.NEGATIVE_INFINITY;
        case "Infinity":
          return Float.POSITIVE_INFINITY;
        case "NaN":
          return Float.NaN;
        default:
          // Fall-through to handling below to produce an error.
      }
    }
    if (proto.getKindCase() != KindCase.NUMBER_VALUE) {
      throw newSpannerException(
          ErrorCode.INTERNAL,
          "Invalid value for column type "
              + Type.float32()
              + " expected NUMBER_VALUE or STRING_VALUE with value one of"
              + " \"Infinity\", \"-Infinity\", or \"NaN\" but was "
              + proto.getKindCase()
              + (proto.getKindCase() == KindCase.STRING_VALUE
                  ? " with value \"" + proto.getStringValue() + "\""
                  : ""));
    }
    return (float) proto.getNumberValue();
  }

  static NullPointerException throwNotNull(int columnIndex) {
    throw new NullPointerException(
        "Cannot call array getter for column " + columnIndex + " with null elements");
  }

  /**
   * Memory-optimized base class for {@code ARRAY<INT64>}, {@code ARRAY<FLOAT32>} and {@code
   * ARRAY<FLOAT64>} types. All of these involve conversions from the type yielded by JSON parsing,
   * which are {@code String} and {@code BigDecimal} respectively. Rather than construct new wrapper
   * objects for each array element, we use primitive arrays and a {@code BitSet} to track nulls.
   */
  abstract static class PrimitiveArray<T, A> extends AbstractList<T> {
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

  static class Int64Array extends PrimitiveArray<Long, long[]> {
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

  static class Float32Array extends PrimitiveArray<Float, float[]> {
    Float32Array(ListValue protoList) {
      super(protoList);
    }

    Float32Array(float[] data, BitSet nulls) {
      super(data, nulls, data.length);
    }

    @Override
    float[] newArray(int size) {
      return new float[size];
    }

    @Override
    void setProto(float[] array, int i, com.google.protobuf.Value protoValue) {
      array[i] = valueProtoToFloat32(protoValue);
    }

    @Override
    Float get(float[] array, int i) {
      return array[i];
    }
  }

  static class Float64Array extends PrimitiveArray<Double, double[]> {
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
  protected float getFloatInternal(int columnIndex) {
    return currRow().getFloatInternal(columnIndex);
  }

  @Override
  protected double getDoubleInternal(int columnIndex) {
    return currRow().getDoubleInternal(columnIndex);
  }

  @Override
  protected BigDecimal getBigDecimalInternal(int columnIndex) {
    return currRow().getBigDecimalInternal(columnIndex);
  }

  @Override
  protected String getStringInternal(int columnIndex) {
    return currRow().getStringInternal(columnIndex);
  }

  @Override
  protected <T extends AbstractMessage> T getProtoMessageInternal(int columnIndex, T message) {
    return currRow().getProtoMessageInternal(columnIndex, message);
  }

  @Override
  protected <T extends ProtocolMessageEnum> T getProtoEnumInternal(
      int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
    return currRow().getProtoEnumInternal(columnIndex, method);
  }

  @Override
  protected String getJsonInternal(int columnIndex) {
    return currRow().getJsonInternal(columnIndex);
  }

  @Override
  protected String getPgJsonbInternal(int columnIndex) {
    return currRow().getPgJsonbInternal(columnIndex);
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
  protected UUID getUuidInternal(int columnIndex) {
    return currRow().getUuidInternal(columnIndex);
  }

  @Override
  protected Interval getIntervalInternal(int columnIndex) {
    return currRow().getIntervalInternal(columnIndex);
  }

  @Override
  protected Value getValueInternal(int columnIndex) {
    return currRow().getValueInternal(columnIndex);
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
  protected float[] getFloatArrayInternal(int columnIndex) {
    return currRow().getFloatArrayInternal(columnIndex);
  }

  @Override
  protected List<Float> getFloatListInternal(int columnIndex) {
    return currRow().getFloatListInternal(columnIndex);
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
  protected List<BigDecimal> getBigDecimalListInternal(int columnIndex) {
    return currRow().getBigDecimalListInternal(columnIndex);
  }

  @Override
  protected List<String> getStringListInternal(int columnIndex) {
    return currRow().getStringListInternal(columnIndex);
  }

  @Override
  protected List<String> getJsonListInternal(int columnIndex) {
    return currRow().getJsonListInternal(columnIndex);
  }

  @Override
  protected List<String> getPgJsonbListInternal(int columnIndex) {
    return currRow().getJsonListInternal(columnIndex);
  }

  @Override
  protected List<ByteArray> getBytesListInternal(int columnIndex) {
    return currRow().getBytesListInternal(columnIndex);
  }

  @Override
  protected <T extends AbstractMessage> List<T> getProtoMessageListInternal(
      int columnIndex, T message) {
    return currRow().getProtoMessageListInternal(columnIndex, message);
  }

  @Override
  protected <T extends ProtocolMessageEnum> List<T> getProtoEnumListInternal(
      int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
    return currRow().getProtoEnumListInternal(columnIndex, method);
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
  protected List<UUID> getUuidListInternal(int columnIndex) {
    return currRow().getUuidListInternal(columnIndex);
  }

  @Override
  protected List<Interval> getIntervalListInternal(int columnIndex) {
    return currRow().getIntervalListInternal(columnIndex);
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
