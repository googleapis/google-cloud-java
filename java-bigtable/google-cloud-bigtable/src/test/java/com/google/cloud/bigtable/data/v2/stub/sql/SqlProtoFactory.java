/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub.sql;

import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.FailedPreconditionException;
import com.google.bigtable.v2.ArrayValue;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.ColumnMetadata;
import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.bigtable.v2.PartialResultSet;
import com.google.bigtable.v2.PrepareQueryRequest;
import com.google.bigtable.v2.PrepareQueryResponse;
import com.google.bigtable.v2.ProtoRows;
import com.google.bigtable.v2.ProtoRowsBatch;
import com.google.bigtable.v2.ProtoSchema;
import com.google.bigtable.v2.ResultSetMetadata;
import com.google.bigtable.v2.Type;
import com.google.bigtable.v2.Type.Struct.Field;
import com.google.bigtable.v2.Value;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.PrepareResponse;
import com.google.cloud.bigtable.data.v2.internal.PreparedStatementImpl;
import com.google.cloud.bigtable.data.v2.internal.PreparedStatementImpl.PreparedQueryData;
import com.google.cloud.bigtable.data.v2.internal.PreparedStatementImpl.PreparedQueryVersion;
import com.google.cloud.bigtable.data.v2.internal.QueryParamUtil;
import com.google.cloud.bigtable.data.v2.models.sql.BoundStatement;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.truth.Truth;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.rpc.PreconditionFailure;
import com.google.rpc.PreconditionFailure.Violation;
import com.google.type.Date;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.Nullable;

// TODO rename this to SqlApiTestUtils
/** Utilities for creating sql proto objects in tests */
public class SqlProtoFactory {

  private static final HashFunction CRC32C = Hashing.crc32c();
  private static final Metadata.Key<byte[]> ERROR_DETAILS_KEY =
      Metadata.Key.of("grpc-status-details-bin", Metadata.BINARY_BYTE_MARSHALLER);

  private SqlProtoFactory() {}

  public static ApiException planRefreshError() {
    Metadata trailers = new Metadata();
    PreconditionFailure failure =
        PreconditionFailure.newBuilder()
            .addViolations(Violation.newBuilder().setType("PREPARED_QUERY_EXPIRED").build())
            .build();
    ErrorDetails refreshErrorDetails =
        ErrorDetails.builder().setRawErrorMessages(ImmutableList.of(Any.pack(failure))).build();
    byte[] status =
        com.google.rpc.Status.newBuilder().addDetails(Any.pack(failure)).build().toByteArray();
    // This needs to be in trailers in order to round trip
    trailers.put(ERROR_DETAILS_KEY, status);

    // This is not initially retryable, the PlanRefreshingCallable overrides this.
    return new FailedPreconditionException(
        new StatusRuntimeException(Status.FAILED_PRECONDITION, trailers),
        GrpcStatusCode.of(Code.FAILED_PRECONDITION),
        false,
        refreshErrorDetails);
  }

  public static PrepareQueryResponse prepareResponse(
      ByteString preparedQuery, ResultSetMetadata metadata, Instant validUntil) {
    return PrepareQueryResponse.newBuilder()
        .setPreparedQuery(preparedQuery)
        // set validUntil a year in the future so these plans never expire in test runs
        .setValidUntil(
            Timestamp.newBuilder()
                .setSeconds(validUntil.getEpochSecond())
                .setNanos(validUntil.getNano())
                .build())
        .setMetadata(metadata)
        .build();
  }

  public static PrepareQueryResponse prepareResponse(
      ByteString preparedQuery, ResultSetMetadata metadata) {
    return prepareResponse(preparedQuery, metadata, Instant.now().plus(Duration.ofDays(365)));
  }

  public static PrepareQueryResponse prepareResponse(ResultSetMetadata metadata) {
    return prepareResponse(ByteString.copyFromUtf8("foo"), metadata);
  }

  public static PreparedStatementImpl preparedStatement(ResultSetMetadata metadata) {
    return preparedStatement(metadata, new HashMap<>());
  }

  public static PreparedStatementImpl preparedStatement(
      ResultSetMetadata metadata, Map<String, SqlType<?>> paramTypes) {
    // We never expire the test prepare response so it's safe to null the stub and request
    return preparedStatement(PrepareResponse.fromProto(prepareResponse(metadata)), paramTypes);
  }

  public static PreparedStatementImpl preparedStatement(
      PrepareResponse response, Map<String, SqlType<?>> paramTypes) {
    return new FakePreparedStatement(response, paramTypes);
  }

  public static ExecuteQueryCallContext callContext(BoundStatement boundStatement) {
    return callContext(boundStatement, SettableApiFuture.create());
  }

  public static ExecuteQueryCallContext callContext(
      BoundStatement boundStatement,
      SettableApiFuture<com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata> mdFuture) {
    return ExecuteQueryCallContext.create(boundStatement, mdFuture);
  }

  public static ColumnMetadata columnMetadata(String name, Type type) {
    return ColumnMetadata.newBuilder().setName(name).setType(type).build();
  }

  public static Type stringType() {
    return Type.newBuilder().setStringType(Type.String.getDefaultInstance()).build();
  }

  public static Type bytesType() {
    return Type.newBuilder().setBytesType(Type.Bytes.getDefaultInstance()).build();
  }

  public static Type int64Type() {
    return Type.newBuilder().setInt64Type(Type.Int64.getDefaultInstance()).build();
  }

  public static Type boolType() {
    return Type.newBuilder().setBoolType(Type.Bool.getDefaultInstance()).build();
  }

  public static Type float32Type() {
    return Type.newBuilder().setFloat32Type(Type.Float32.getDefaultInstance()).build();
  }

  public static Type float64Type() {
    return Type.newBuilder().setFloat64Type(Type.Float64.getDefaultInstance()).build();
  }

  public static Type timestampType() {
    return Type.newBuilder().setTimestampType(Type.Timestamp.getDefaultInstance()).build();
  }

  public static Type dateType() {
    return Type.newBuilder().setDateType(Type.Date.getDefaultInstance()).build();
  }

  public static Type aggregateSumType() {
    return Type.newBuilder()
        .setAggregateType(
            Type.Aggregate.newBuilder().setSum(Type.Aggregate.Sum.getDefaultInstance()))
        .build();
  }

  public static Type arrayType(Type elementType) {
    return Type.newBuilder()
        .setArrayType(Type.Array.newBuilder().setElementType(elementType).build())
        .build();
  }

  public static Type structType(Type... fieldTypes) {
    Field[] fields = new Field[fieldTypes.length];
    for (int i = 0; i < fieldTypes.length; i++) {
      fields[i] = Type.Struct.Field.newBuilder().setType(fieldTypes[i]).build();
    }
    return structType(fields);
  }

  public static Type structType(Field... fields) {
    return Type.newBuilder()
        .setStructType(Type.Struct.newBuilder().addAllFields(Arrays.asList(fields)).build())
        .build();
  }

  public static Field structField(String name, Type type) {
    return Type.Struct.Field.newBuilder().setFieldName(name).setType(type).build();
  }

  public static Type mapType(Type keyType, Type valueType) {
    return Type.newBuilder()
        .setMapType(Type.Map.newBuilder().setKeyType(keyType).setValueType(valueType).build())
        .build();
  }

  public static Value nullValue() {
    return Value.newBuilder().build();
  }

  public static Value stringValue(String contents) {
    return Value.newBuilder().setStringValue(contents).build();
  }

  public static Value bytesValue(String contents) {
    return Value.newBuilder().setBytesValue(ByteString.copyFromUtf8(contents)).build();
  }

  public static Value int64Value(long data) {
    return Value.newBuilder().setIntValue(data).build();
  }

  public static Value floatValue(double data) {
    return Value.newBuilder().setFloatValue(data).build();
  }

  public static Value boolValue(boolean data) {
    return Value.newBuilder().setBoolValue(data).build();
  }

  public static Value timestampValue(long seconds, int nanos) {
    return Value.newBuilder()
        .setTimestampValue(Timestamp.newBuilder().setSeconds(seconds).setNanos(nanos).build())
        .build();
  }

  public static Value dateValue(int year, int month, int day) {
    return Value.newBuilder()
        .setDateValue(Date.newBuilder().setYear(year).setMonth(month).setDay(day).build())
        .build();
  }

  public static Value arrayValue(Value... elements) {
    return Value.newBuilder()
        .setArrayValue(ArrayValue.newBuilder().addAllValues(Arrays.asList(elements)))
        .build();
  }

  public static Value structValue(Value... fields) {
    return arrayValue(fields);
  }

  public static Value mapValue(Value... elements) {
    return arrayValue(elements);
  }

  public static Value mapElement(Value... fields) {
    return structValue(fields);
  }

  /** Creates a single response representing a complete batch, with no token */
  public static ExecuteQueryResponse partialResultSetWithoutToken(Value... values) {
    return partialResultSets(1, false, ByteString.EMPTY, values).get(0);
  }

  /** Creates a single response representing a complete batch, with a resume token of 'test' */
  public static ExecuteQueryResponse partialResultSetWithToken(Value... values) {
    return partialResultSets(1, false, ByteString.copyFromUtf8("test"), values).get(0);
  }

  /** Creates a single response representing a complete batch, with a resume token of token */
  public static ExecuteQueryResponse partialResultSetWithToken(ByteString token, Value... values) {
    return partialResultSets(1, false, token, values).get(0);
  }

  public static ExecuteQueryResponse tokenOnlyResultSet(ByteString token) {
    return ExecuteQueryResponse.newBuilder()
        .setResults(PartialResultSet.newBuilder().setResumeToken(token))
        .build();
  }

  /**
   * splits values across specified number of batches. Sets reset on first response, and resume
   * token on final response
   */
  public static ImmutableList<ExecuteQueryResponse> partialResultSets(
      int batches, Value... values) {
    return partialResultSets(batches, true, ByteString.copyFromUtf8("test"), values);
  }

  /**
   * @param batches number of {@link ProtoRowsBatch}s to split values across
   * @param reset whether to set the reset bit on the first response
   * @param resumeToken resumption token for the final response. Unset if empty
   * @param values List of values to split across batches
   * @return List of responses with length equal to number of batches
   */
  public static ImmutableList<ExecuteQueryResponse> partialResultSets(
      int batches, boolean reset, ByteString resumeToken, Value... values) {
    ProtoRows protoRows = ProtoRows.newBuilder().addAllValues(Arrays.asList(values)).build();
    ByteString batchData = protoRows.toByteString();
    int batch_checksum = checksum(batchData);
    ImmutableList.Builder<ExecuteQueryResponse> responses = ImmutableList.builder();
    int batchSize = batchData.size() / batches;
    for (int i = 0; i < batches; i++) {
      boolean finalBatch = i == batches - 1;
      int batchStart = i * batchSize;
      int batchEnd = finalBatch ? batchData.size() : batchStart + batchSize;
      ProtoRowsBatch.Builder batchBuilder = ProtoRowsBatch.newBuilder();
      batchBuilder.setBatchData(batchData.substring(batchStart, batchEnd));
      PartialResultSet.Builder resultSetBuilder = PartialResultSet.newBuilder();
      if (reset && i == 0) {
        resultSetBuilder.setReset(true);
      }
      if (finalBatch) {
        resultSetBuilder.setBatchChecksum(batch_checksum);
        if (!resumeToken.isEmpty()) {
          resultSetBuilder.setResumeToken(resumeToken);
        }
      }
      resultSetBuilder.setProtoRowsBatch(batchBuilder.build());
      responses.add(ExecuteQueryResponse.newBuilder().setResults(resultSetBuilder.build()).build());
    }
    return responses.build();
  }

  public static ResultSetMetadata metadata(ColumnMetadata... columnMetadata) {
    ProtoSchema schema =
        ProtoSchema.newBuilder().addAllColumns(Arrays.asList(columnMetadata)).build();
    return ResultSetMetadata.newBuilder().setProtoSchema(schema).build();
  }

  public static int checksum(ByteString bytes) {
    return CRC32C.hashBytes(bytes.toByteArray()).asInt();
  }

  /** Used to test ExecuteQuery and PrepareQuery APIs using the RpcExpectations below */
  public static class TestBigtableSqlService extends BigtableGrpc.BigtableImplBase {
    public static final String DEFAULT_PROJECT_ID = "fake-project";
    public static final String DEFAULT_INSTANCE_ID = "fake-instance";
    public static final String DEFAULT_APP_PROFILE_ID = "fake-app-profile";
    public static final ByteString DEFAULT_PREPARED_QUERY = ByteString.copyFromUtf8("foo");
    Queue<ExecuteRpcExpectation> executeExpectations = new LinkedBlockingDeque<>();
    Queue<PrepareRpcExpectation> prepareExpectations = new LinkedBlockingDeque<>();
    int executeCount = 0;
    public int prepareCount = 0;

    public void addExpectation(ExecuteRpcExpectation expectation) {
      executeExpectations.add(expectation);
    }

    public void addExpectation(PrepareRpcExpectation expectation) {
      prepareExpectations.add(expectation);
    }

    @Override
    public void executeQuery(
        ExecuteQueryRequest request, StreamObserver<ExecuteQueryResponse> responseObserver) {
      ExecuteRpcExpectation expectedRpc = executeExpectations.poll();
      executeCount++;
      int requestIndex = executeCount - 1;

      Truth.assertWithMessage("Unexpected request#" + requestIndex + ":" + request.toString())
          .that(expectedRpc)
          .isNotNull();
      Truth.assertWithMessage("Unexpected request#" + requestIndex)
          .that(request)
          .isEqualTo(expectedRpc.getExpectedRequest());

      try {
        Thread.sleep(expectedRpc.delay.toMillis());
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      for (ExecuteQueryResponse response : expectedRpc.responses) {
        responseObserver.onNext(response);
      }
      if (expectedRpc.statusCode.toStatus().isOk()) {
        responseObserver.onCompleted();
      } else if (expectedRpc.exception != null) {
        responseObserver.onError(expectedRpc.exception);
      } else {
        responseObserver.onError(expectedRpc.statusCode.toStatus().asRuntimeException());
      }
    }

    @Override
    public void prepareQuery(
        PrepareQueryRequest request, StreamObserver<PrepareQueryResponse> responseObserver) {
      PrepareRpcExpectation expectedRpc = prepareExpectations.poll();
      prepareCount++;
      int requestIndex = prepareCount - 1;

      Truth.assertWithMessage("Unexpected request#" + requestIndex + ":" + request.toString())
          .that(expectedRpc)
          .isNotNull();
      Truth.assertWithMessage("Unexpected request#" + requestIndex)
          .that(request)
          .isEqualTo(expectedRpc.getExpectedRequest());

      try {
        Thread.sleep(expectedRpc.delay.toMillis());
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      if (expectedRpc.statusCode == Code.OK) {
        responseObserver.onNext(expectedRpc.response);
        responseObserver.onCompleted();
      } else {
        responseObserver.onError(expectedRpc.statusCode.toStatus().asRuntimeException());
      }
    }
  }

  public static class ExecuteRpcExpectation {
    ExecuteQueryRequest.Builder request;
    Status.Code statusCode;
    @Nullable ApiException exception;
    List<ExecuteQueryResponse> responses;
    Duration delay;

    private ExecuteRpcExpectation() {
      this.request = ExecuteQueryRequest.newBuilder();
      this.request.setPreparedQuery(TestBigtableSqlService.DEFAULT_PREPARED_QUERY);
      this.request.setInstanceName(
          NameUtil.formatInstanceName(
              TestBigtableSqlService.DEFAULT_PROJECT_ID,
              TestBigtableSqlService.DEFAULT_INSTANCE_ID));
      this.request.setAppProfileId(TestBigtableSqlService.DEFAULT_APP_PROFILE_ID);
      this.statusCode = Code.OK;
      this.responses = new ArrayList<>();
      this.delay = Duration.ZERO;
    }

    public static ExecuteRpcExpectation create() {
      return new ExecuteRpcExpectation();
    }

    public ExecuteRpcExpectation withResumeToken(ByteString resumeToken) {
      this.request.setResumeToken(resumeToken);
      return this;
    }

    public ExecuteRpcExpectation withDelay(Duration delay) {
      this.delay = delay;
      return this;
    }

    public ExecuteRpcExpectation withParams(Map<String, Value> params) {
      this.request.putAllParams(params);
      return this;
    }

    public ExecuteRpcExpectation withPreparedQuery(ByteString preparedQuery) {
      this.request.setPreparedQuery(preparedQuery);
      return this;
    }

    public ExecuteRpcExpectation respondWithStatus(Status.Code code) {
      this.statusCode = code;
      return this;
    }

    public ExecuteRpcExpectation respondWithException(Status.Code code, ApiException exception) {
      this.statusCode = code;
      this.exception = exception;
      return this;
    }

    public ExecuteRpcExpectation respondWith(ExecuteQueryResponse... responses) {
      this.responses = Arrays.asList(responses);
      return this;
    }

    ExecuteQueryRequest getExpectedRequest() {
      return this.request.build();
    }
  }

  public static class PrepareRpcExpectation {
    PrepareQueryRequest.Builder request;
    Status.Code statusCode;
    PrepareQueryResponse response;
    Duration delay;

    private PrepareRpcExpectation() {
      this.request = PrepareQueryRequest.newBuilder();
      this.request.setInstanceName(
          NameUtil.formatInstanceName(
              TestBigtableSqlService.DEFAULT_PROJECT_ID,
              TestBigtableSqlService.DEFAULT_INSTANCE_ID));
      this.request.setAppProfileId(TestBigtableSqlService.DEFAULT_APP_PROFILE_ID);
      this.statusCode = Code.OK;
      this.delay = Duration.ZERO;
    }

    public static PrepareRpcExpectation create() {
      return new PrepareRpcExpectation();
    }

    public PrepareRpcExpectation withSql(String sqlQuery) {
      this.request.setQuery(sqlQuery);
      return this;
    }

    public PrepareRpcExpectation withParamTypes(Map<String, SqlType<?>> paramTypes) {
      Map<String, Type> protoParamTypes = new HashMap<>();
      for (Map.Entry<String, SqlType<?>> entry : paramTypes.entrySet()) {
        Type proto = QueryParamUtil.convertToQueryParamProto(entry.getValue());
        protoParamTypes.put(entry.getKey(), proto);
      }
      this.request.putAllParamTypes(protoParamTypes);
      return this;
    }

    public PrepareRpcExpectation respondWithStatus(Status.Code code) {
      this.statusCode = code;
      return this;
    }

    public PrepareRpcExpectation respondWith(PrepareQueryResponse res) {
      this.response = res;
      return this;
    }

    public PrepareRpcExpectation withDelay(Duration delay) {
      this.delay = delay;
      return this;
    }

    PrepareQueryRequest getExpectedRequest() {
      return this.request.build();
    }
  }

  /**
   * Fake prepared statement for testing. Note that the schema changes on calls to hard refresh.
   * This is used to test plan updates propagate.
   */
  public static final class FakePreparedStatement extends PreparedStatementImpl {
    private static final PrepareResponse DEFAULT_INITIAL_RESPONSE =
        PrepareResponse.fromProto(
            prepareResponse(
                ByteString.copyFromUtf8("initialPlan"),
                metadata(columnMetadata("strCol", stringType()))));
    private static final PreparedQueryData DEFAULT_INITIAL_PLAN =
        PreparedQueryData.create(ApiFutures.immediateFuture(DEFAULT_INITIAL_RESPONSE));
    private static final PreparedQueryData DEFAULT_PLAN_ON_REFRESH =
        PreparedQueryData.create(
            ApiFutures.immediateFuture(
                PrepareResponse.fromProto(
                    prepareResponse(
                        ByteString.copyFromUtf8("refreshedPlan"),
                        metadata(columnMetadata("bytesColl", bytesType()))))));

    private PreparedQueryData initialPlan;
    private PreparedQueryData planOnRefresh;
    private Map<String, SqlType<?>> paramTypes;

    public FakePreparedStatement() {
      super(DEFAULT_INITIAL_RESPONSE, new HashMap<>(), null, null);
      this.initialPlan = DEFAULT_INITIAL_PLAN;
      this.planOnRefresh = DEFAULT_PLAN_ON_REFRESH;
      this.paramTypes = new HashMap<>();
    }

    public FakePreparedStatement(
        PrepareResponse prepareResponse, Map<String, SqlType<?>> paramTypes) {
      super(prepareResponse, paramTypes, null, null);
      this.initialPlan = PreparedQueryData.create(ApiFutures.immediateFuture(prepareResponse));
      // Don't expect an refresh using this configuration
      this.planOnRefresh = null;
      this.paramTypes = paramTypes;
    }

    FakePreparedStatement withUpdatedPlans(
        PreparedQueryData initialPlan, PreparedQueryData planOnRefresh) {
      this.initialPlan = initialPlan;
      this.planOnRefresh = planOnRefresh;
      return this;
    }

    @Override
    public PreparedQueryData getLatestPrepareResponse() {
      Preconditions.checkState(
          initialPlan != null, "Trying to refresh FakePreparedStatement without planOnRefresh set");
      return initialPlan;
    }

    @Override
    public PreparedQueryData markExpiredAndStartRefresh(
        PreparedQueryVersion expiredPreparedQueryVersion) {
      return planOnRefresh;
    }

    @Override
    public void assertUsingSameStub(EnhancedBigtableStub stub) {}
  }
}
