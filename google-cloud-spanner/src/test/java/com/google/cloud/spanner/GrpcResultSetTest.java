/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import static com.google.cloud.spanner.SpannerMatchers.isSpannerException;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.ByteArray;
import com.google.cloud.spanner.spi.SpannerRpc;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.protobuf.NullValue;
import com.google.spanner.v1.ExecuteSqlRequest.QueryMode;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.QueryPlan;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.Transaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.SpannerImpl.GrpcResultSet}. */
@RunWith(JUnit4.class)
public class GrpcResultSetTest {
  @Rule public ExpectedException expectedException = ExpectedException.none();

  private SpannerImpl.GrpcResultSet resultSet;
  private SpannerRpc.ResultStreamConsumer consumer;
  private SpannerImpl.GrpcStreamIterator stream;

  private static class NoOpListener implements SpannerImpl.AbstractResultSet.Listener {
    @Override
    public void onTransactionMetadata(Transaction transaction) throws SpannerException {}

    @Override
    public void onError(SpannerException e) {}

    @Override
    public void onDone() {}
  }

  @Before
  public void setUp() {
    stream = new SpannerImpl.GrpcStreamIterator(10);
    stream.setCall(
        new SpannerRpc.StreamingCall() {
          @Override
          public void cancel(@Nullable String message) {}

          @Override
          public void request(int numMessages) {}
        });
    consumer = stream.consumer();
    resultSet = new SpannerImpl.GrpcResultSet(stream, new NoOpListener(), QueryMode.NORMAL);
  }

  public SpannerImpl.GrpcResultSet resultSetWithMode(QueryMode queryMode) {
    return new SpannerImpl.GrpcResultSet(stream, new NoOpListener(), queryMode);
  }

  @Test
  public void metadata() {
    Type rowType = Type.struct(Type.StructField.of("f", Type.string()));
    ResultSetMetadata.Builder metadataBuilder = ResultSetMetadata.newBuilder();
    metadataBuilder
        .setRowType(rowType.toProto().getStructType())
        .getTransactionBuilder()
        .setId(ByteString.copyFromUtf8("t1"));
    PartialResultSet partialResultSet =
        PartialResultSet.newBuilder().setMetadata(metadataBuilder.build()).build();

    consumer.onPartialResultSet(partialResultSet);
    consumer.onCompleted();
    assertThat(resultSet.next()).isFalse();
    assertThat(resultSet.getType()).isEqualTo(rowType);
  }

  @Test
  public void metadataFailure() {
    SpannerException t =
        SpannerExceptionFactory.newSpannerException(ErrorCode.DEADLINE_EXCEEDED, "outatime");
    consumer.onError(t);
    expectedException.expect(isSpannerException(ErrorCode.DEADLINE_EXCEEDED));
    expectedException.expectMessage("outatime");
    resultSet.next();
  }

  @Test
  public void noMetadata() {
    consumer.onCompleted();
    expectedException.expect(isSpannerException(ErrorCode.INTERNAL));
    resultSet.next();
  }

  @Test
  public void empty() {
    Type type = Type.struct(Type.StructField.of("f", Type.string()));
    PartialResultSet partialResultSet =
        PartialResultSet.newBuilder().setMetadata(makeMetadata(type)).build();
    consumer.onPartialResultSet(partialResultSet);
    consumer.onCompleted();
    assertThat(resultSet.next()).isFalse();
    assertThat(resultSet.getType()).isEqualTo(type);
  }

  @Test
  public void emptyMultipleResponses() {
    PartialResultSet partialResultSet =
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.string()))))
            .build();
    consumer.onPartialResultSet(partialResultSet);
    consumer.onPartialResultSet(PartialResultSet.getDefaultInstance());
    consumer.onPartialResultSet(PartialResultSet.getDefaultInstance());
    consumer.onCompleted();
    assertThat(resultSet.next()).isFalse();
  }

  private List<String> consumeAllString() {
    List<String> results = new ArrayList<>();
    while (resultSet.next()) {
      results.add(resultSet.getString(0));
    }
    return results;
  }

  @Test
  public void singleResponse() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.string()))))
            .addValues(Value.string("a").toProto())
            .addValues(Value.string("b").toProto())
            .addValues(Value.string("c").toProto())
            .build());
    consumer.onCompleted();
    assertThat(consumeAllString()).containsExactly("a", "b", "c").inOrder();
  }

  @Test
  public void multiResponse() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.string()))))
            .addValues(Value.string("a").toProto())
            .addValues(Value.string("b").toProto())
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(Value.string("c").toProto())
            .addValues(Value.string("d").toProto())
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(Value.string("e").toProto())
            .addValues(Value.string("f").toProto())
            .build());
    consumer.onCompleted();
    assertThat(consumeAllString()).containsExactly("a", "b", "c", "d", "e", "f").inOrder();
  }

  @Test
  public void multiResponseChunkingStreamClosed() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.string()))))
            .addValues(Value.string("abcdefg").toProto())
            .setChunkedValue(true)
            .build());
    consumer.onCompleted();
    expectedException.expect(isSpannerException(ErrorCode.INTERNAL));
    resultSet.next();
  }

  @Test
  public void multiResponseChunkingStrings() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.string()))))
            .addValues(Value.string("before").toProto())
            .addValues(Value.string("abcdefg").toProto())
            .setChunkedValue(true)
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(Value.string("hijklmnop").toProto())
            .setChunkedValue(true)
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(Value.string("qrstuvwxyz").toProto())
            .addValues(Value.string("after").toProto())
            .setChunkedValue(false)
            .build());
    consumer.onCompleted();
    assertThat(consumeAllString())
        .containsExactly("before", "abcdefghijklmnopqrstuvwxyz", "after")
        .inOrder();
  }

  @Test
  public void multiResponseChunkingBytes() {
    ByteArray expectedBytes = ByteArray.copyFrom("abcdefghijklmnopqrstuvwxyz");
    String base64 = ByteArrays.toBase64(expectedBytes);
    String chunk1 = base64.substring(0, 10);
    String chunk2 = base64.substring(10, 20);
    String chunk3 = base64.substring(20);
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.bytes()))))
            .addValues(Value.bytes(ByteArray.copyFrom("before")).toProto())
            .addValues(com.google.protobuf.Value.newBuilder().setStringValue(chunk1))
            .setChunkedValue(true)
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(com.google.protobuf.Value.newBuilder().setStringValue(chunk2))
            .setChunkedValue(true)
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(com.google.protobuf.Value.newBuilder().setStringValue(chunk3))
            .addValues(Value.bytes(ByteArray.copyFrom("after")).toProto())
            .setChunkedValue(false)
            .build());
    consumer.onCompleted();
    List<ByteArray> results = new ArrayList<>();
    while (resultSet.next()) {
      results.add(resultSet.getBytes(0));
    }
    assertThat(results)
        .containsExactly(ByteArray.copyFrom("before"), expectedBytes, ByteArray.copyFrom("after"))
        .inOrder();
  }

  @Test
  public void multiResponseChunkingBoolArray() {
    List<Boolean> beforeValue = Arrays.asList(true);
    List<Boolean> chunkedValue = Arrays.asList(false, null, true, true, true, null, null, false);
    List<Boolean> afterValue = Arrays.asList(true);
    doArrayTest(
        beforeValue,
        chunkedValue,
        afterValue,
        Type.bool(),
        new Function<List<Boolean>, com.google.protobuf.Value>() {
          @Override
          public com.google.protobuf.Value apply(List<Boolean> input) {
            return Value.boolArray(input).toProto();
          }
        },
        new Function<StructReader, List<Boolean>>() {
          @Override
          public List<Boolean> apply(StructReader input) {
            return input.getBooleanList(0);
          }
        });
  }

  @Test
  public void multiResponseChunkingInt64Array() {
    List<Long> beforeValue = Arrays.asList(10L);
    List<Long> chunkedValue = Arrays.asList(1L, 2L, null, null, 5L, null, 7L, 8L);
    List<Long> afterValue = Arrays.asList(20L);
    doArrayTest(
        beforeValue,
        chunkedValue,
        afterValue,
        Type.int64(),
        new Function<List<Long>, com.google.protobuf.Value>() {
          @Override
          public com.google.protobuf.Value apply(List<Long> input) {
            return Value.int64Array(input).toProto();
          }
        },
        new Function<StructReader, List<Long>>() {
          @Override
          public List<Long> apply(StructReader input) {
            return input.getLongList(0);
          }
        });
  }

  @Test
  public void multiResponseChunkingFloat64Array() {
    List<Double> beforeValue = Arrays.asList(10.0);
    List<Double> chunkedValue = Arrays.asList(null, 2.0, 3.0, 4.0, null, 6.0, 7.0, null);
    List<Double> afterValue = Arrays.asList(20.0);
    doArrayTest(
        beforeValue,
        chunkedValue,
        afterValue,
        Type.float64(),
        new Function<List<Double>, com.google.protobuf.Value>() {
          @Override
          public com.google.protobuf.Value apply(List<Double> input) {
            return Value.float64Array(input).toProto();
          }
        },
        new Function<StructReader, List<Double>>() {
          @Override
          public List<Double> apply(StructReader input) {
            return input.getDoubleList(0);
          }
        });
  }

  @Test
  public void multiResponseChunkingStringArray() {
    List<String> beforeValue = Arrays.asList("before");
    List<String> chunkedValue = Arrays.asList("a", "b", null, "d", null, "f", null, "h");
    List<String> afterValue = Arrays.asList("after");
    doArrayTest(
        beforeValue,
        chunkedValue,
        afterValue,
        Type.string(),
        new Function<List<String>, com.google.protobuf.Value>() {
          @Override
          public com.google.protobuf.Value apply(List<String> input) {
            return Value.stringArray(input).toProto();
          }
        },
        new Function<StructReader, List<String>>() {
          @Override
          public List<String> apply(StructReader input) {
            return input.getStringList(0);
          }
        });
  }

  private static ByteArray b(String data) {
    return ByteArray.copyFrom(data);
  }

  @Test
  public void multiResponseChunkingBytesArray() {
    List<ByteArray> beforeValue = Arrays.asList(b("before"));
    List<ByteArray> chunkedValue =
        Arrays.asList(b("a"), b("b"), null, b("d"), null, b("f"), null, b("h"));
    List<ByteArray> afterValue = Arrays.asList(b("after"));
    doArrayTest(
        beforeValue,
        chunkedValue,
        afterValue,
        Type.bytes(),
        new Function<List<ByteArray>, com.google.protobuf.Value>() {
          @Override
          public com.google.protobuf.Value apply(List<ByteArray> input) {
            return Value.bytesArray(input).toProto();
          }
        },
        new Function<StructReader, List<ByteArray>>() {
          @Override
          public List<ByteArray> apply(StructReader input) {
            return input.getBytesList(0);
          }
        });
  }

  private static Struct s(String a, long b) {
    return Struct.newBuilder().set("a").to(a).set("b").to(b).build();
  }

  @Test
  public void multiResponseChunkingStructArray() {
    final Type elementType =
        Type.struct(
            Type.StructField.of("a", Type.string()), Type.StructField.of("b", Type.int64()));
    List<Struct> beforeValue = Arrays.asList(s("before", 10));
    List<Struct> chunkedValue =
        Arrays.asList(s("a", 1), s("b", 2), s("c", 3), null, s("e", 5), null, s("g", 7), s("h", 8));
    List<Struct> afterValue = Arrays.asList(s("after", 20));
    doArrayTest(
        beforeValue,
        chunkedValue,
        afterValue,
        elementType,
        new Function<List<Struct>, com.google.protobuf.Value>() {
          @Override
          public com.google.protobuf.Value apply(List<Struct> input) {
            // Value itself doesn't support serialization to proto, as struct isn't ever sent to the
            // backend.  Implement simple serialization ourselves.
            com.google.protobuf.Value.Builder proto = com.google.protobuf.Value.newBuilder();
            for (Struct element : input) {
              com.google.protobuf.Value.Builder elementProto =
                  proto.getListValueBuilder().addValuesBuilder();
              if (element == null) {
                elementProto.setNullValue(NullValue.NULL_VALUE);
              } else {
                elementProto
                    .getListValueBuilder()
                    .addValuesBuilder()
                    .setStringValue(element.getString(0));
                elementProto
                    .getListValueBuilder()
                    .addValuesBuilder()
                    .setStringValue(Long.toString(element.getLong(1)));
              }
            }
            return proto.build();
          }
        },
        new Function<StructReader, List<Struct>>() {
          @Override
          public List<Struct> apply(StructReader input) {
            return input.getStructList(0);
          }
        });
  }

  @Test
  public void profileResultInFinalResultSet() {
    Map<String, com.google.protobuf.Value> statsMap =
        ImmutableMap.of(
            "f1", Value.string("").toProto(),
            "f2", Value.string("").toProto());
    ResultSetStats stats =
        ResultSetStats.newBuilder()
            .setQueryPlan(QueryPlan.newBuilder().build())
            .setQueryStats(com.google.protobuf.Struct.newBuilder().putAllFields(statsMap).build())
            .build();
    ArrayList<Type.StructField> dataType = new ArrayList<>();
    dataType.add(Type.StructField.of("data", Type.string()));
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(dataType)))
            .addValues(Value.string("d1").toProto())
            .setChunkedValue(false)
            .setStats(stats)
            .build());
    resultSet = resultSetWithMode(QueryMode.PROFILE);
    consumer.onCompleted();
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.next()).isFalse();
    ResultSetStats receivedStats = resultSet.getStats();
    assertThat(stats).isEqualTo(receivedStats);
    resultSet.close();
  }

  public void profileResultInExtraFinalResultSet() {
    Map<String, com.google.protobuf.Value> statsMap =
        ImmutableMap.of(
            "f1", Value.string("").toProto(),
            "f2", Value.string("").toProto());
    ResultSetStats stats =
        ResultSetStats.newBuilder()
            .setQueryPlan(QueryPlan.newBuilder().build())
            .setQueryStats(com.google.protobuf.Struct.newBuilder().putAllFields(statsMap).build())
            .build();
    ArrayList<Type.StructField> dataType = new ArrayList<>();
    dataType.add(Type.StructField.of("data", Type.string()));
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(dataType)))
            .addValues(Value.string("d1").toProto())
            .setChunkedValue(false)
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(dataType)))
            .setChunkedValue(false)
            .setStats(stats)
            .build());
    resultSet = resultSetWithMode(QueryMode.PROFILE);
    consumer.onCompleted();
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.next()).isFalse();
    ResultSetStats receivedStats = resultSet.getStats();
    assertThat(stats).isEqualTo(receivedStats);
    resultSet.close();
  }

  @Test
  public void planResult() {
    ResultSetStats stats =
        ResultSetStats.newBuilder().setQueryPlan(QueryPlan.newBuilder().build()).build();
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(new ArrayList<Type.StructField>())))
            .setChunkedValue(false)
            .setStats(stats)
            .build());
    resultSet = resultSetWithMode(QueryMode.PLAN);
    consumer.onCompleted();
    assertThat(resultSet.next()).isFalse();
    ResultSetStats receivedStats = resultSet.getStats();
    assertThat(stats).isEqualTo(receivedStats);
    resultSet.close();
  }

  @Test
  public void statsUnavailableError() {
    ResultSetStats stats = ResultSetStats.newBuilder().build();
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(new ArrayList<Type.StructField>())))
            .setChunkedValue(false)
            .setStats(stats)
            .build());
    resultSet = resultSetWithMode(QueryMode.PROFILE);
    consumer.onCompleted();
    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage(
        "ResultSetStats requested before consuming the entire ResultSet");
    resultSet.getStats();
  }

  @Test
  public void statsNotSupportedError() {
    ResultSetStats stats = ResultSetStats.newBuilder().build();
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(new ArrayList<Type.StructField>())))
            .setChunkedValue(false)
            .setStats(stats)
            .build());
    resultSet = resultSetWithMode(QueryMode.NORMAL);
    consumer.onCompleted();
    expectedException.expect(UnsupportedOperationException.class);
    expectedException.expectMessage(
        "ResultSetStats are available only in PLAN and PROFILE execution modes");
    resultSet.getStats();
  }

  private <T> void doArrayTest(
      List<T> beforeValue,
      List<T> chunkedValue,
      List<T> afterValue,
      Type elementType,
      Function<List<T>, com.google.protobuf.Value> toProto,
      Function<StructReader, List<T>> getter) {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(elementType)))))
            .addValues(toProto.apply(beforeValue))
            .addValues(toProto.apply(chunkedValue.subList(0, 3)))
            .setChunkedValue(true)
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(toProto.apply(chunkedValue.subList(3, 5)))
            .setChunkedValue(true)
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(toProto.apply(chunkedValue.subList(5, chunkedValue.size())))
            .addValues(toProto.apply(afterValue))
            .setChunkedValue(false)
            .build());
    consumer.onCompleted();
    assertThat(resultSet.next()).isTrue();
    assertThat(getter.apply(resultSet)).containsExactlyElementsIn(beforeValue).inOrder();
    assertThat(resultSet.next()).isTrue();
    assertThat(getter.apply(resultSet)).containsExactlyElementsIn(chunkedValue).inOrder();
    assertThat(resultSet.next()).isTrue();
    assertThat(getter.apply(resultSet)).containsExactlyElementsIn(afterValue).inOrder();
    assertThat(resultSet.next()).isFalse();
  }

  private static ResultSetMetadata makeMetadata(Type rowType) {
    com.google.spanner.v1.Type typeProto = rowType.toProto();
    return ResultSetMetadata.newBuilder().setRowType(typeProto.getStructType()).build();
  }
}
