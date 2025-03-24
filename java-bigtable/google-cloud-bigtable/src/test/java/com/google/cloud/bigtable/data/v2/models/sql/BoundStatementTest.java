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
package com.google.cloud.bigtable.data.v2.models.sql;

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.arrayType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.arrayValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.boolType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.boolValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.columnMetadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.dateType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.dateValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.float32Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.float64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.floatValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Value;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.nullValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.preparedStatement;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.timestampType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.timestampValue;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.bigtable.v2.ColumnMetadata;
import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.bigtable.v2.PrepareQueryResponse;
import com.google.bigtable.v2.Value;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.bigtable.data.v2.internal.PrepareResponse;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.protobuf.ByteString;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BoundStatementTest {

  private static final String EXPECTED_APP_PROFILE = "test-profile";
  private static final RequestContext REQUEST_CONTEXT =
      RequestContext.create("test-project", "test-instance", EXPECTED_APP_PROFILE);
  private static final String EXPECTED_INSTANCE_NAME =
      "projects/test-project/instances/test-instance";
  private static final ByteString EXPECTED_PREPARED_QUERY = ByteString.copyFromUtf8("foo");
  // BoundStatement doesn't validate params against schema right now, so we can use hardcoded
  // columns for now
  private static final ColumnMetadata[] DEFAULT_COLUMNS = {
    columnMetadata("_key", bytesType()), columnMetadata("cf", stringType())
  };
  private static final @Nullable ByteString NO_RESUME_TOKEN = null;

  // Use ColumnMetadata as a more concise way of specifying params
  public static BoundStatement.Builder boundStatementBuilder(ColumnMetadata... paramColumns) {
    HashMap<String, SqlType<?>> paramTypes = new HashMap<>(paramColumns.length);
    for (ColumnMetadata c : paramColumns) {
      paramTypes.put(c.getName(), SqlType.fromProto(c.getType()));
    }
    // This doesn't impact bound statement, but set it so it looks like a real response
    Instant expiry = Instant.now().plus(Duration.ofMinutes(1));
    return preparedStatement(
            PrepareResponse.fromProto(
                PrepareQueryResponse.newBuilder()
                    .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                    .setMetadata(metadata(DEFAULT_COLUMNS))
                    .setValidUntil(
                        Timestamp.ofTimeSecondsAndNanos(expiry.getEpochSecond(), expiry.getNano())
                            .toProto())
                    .build()),
            paramTypes)
        .bind();
  }

  @Test
  public void statementWithoutParameters() {
    BoundStatement s = boundStatementBuilder().build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithResumeToken() {
    BoundStatement s = boundStatementBuilder().build();

    assertThat(
            s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, ByteString.copyFromUtf8("token")))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .setResumeToken(ByteString.copyFromUtf8("token"))
                .build());
  }

  @Test
  public void statementWithBytesParam() {
    BoundStatement s =
        boundStatementBuilder(columnMetadata("key", bytesType()))
            .setBytesParam("key", ByteString.copyFromUtf8("test"))
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams(
                    "key",
                    Value.newBuilder()
                        .setType(bytesType())
                        .setBytesValue(ByteString.copyFromUtf8("test"))
                        .build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithNullBytesParam() {
    BoundStatement s =
        boundStatementBuilder(columnMetadata("key", bytesType()))
            .setBytesParam("key", null)
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams("key", Value.newBuilder().setType(bytesType()).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithStringParam() {
    BoundStatement s =
        boundStatementBuilder(columnMetadata("key", stringType()))
            .setStringParam("key", "test")
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams(
                    "key", Value.newBuilder().setType(stringType()).setStringValue("test").build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithNullStringParam() {
    BoundStatement s =
        boundStatementBuilder(columnMetadata("key", stringType()))
            .setStringParam("key", null)
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams("key", Value.newBuilder().setType(stringType()).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithInt64Param() {
    BoundStatement s =
        boundStatementBuilder(columnMetadata("number", int64Type()))
            .setLongParam("number", 1L)
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams("number", Value.newBuilder().setType(int64Type()).setIntValue(1).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithNullInt64Param() {
    BoundStatement s =
        boundStatementBuilder(columnMetadata("number", int64Type()))
            .setLongParam("number", null)
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams("number", Value.newBuilder().setType(int64Type()).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithBoolParam() {
    BoundStatement s =
        boundStatementBuilder(columnMetadata("bool", boolType()))
            .setBooleanParam("bool", true)
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams(
                    "bool", Value.newBuilder().setType(boolType()).setBoolValue(true).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithNullBoolParam() {
    BoundStatement s =
        boundStatementBuilder(columnMetadata("bool", boolType()))
            .setBooleanParam("bool", null)
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams("bool", Value.newBuilder().setType(boolType()).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithTimestampParam() {
    BoundStatement s =
        boundStatementBuilder(columnMetadata("timeParam", timestampType()))
            .setTimestampParam("timeParam", Instant.ofEpochSecond(1000, 100))
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams(
                    "timeParam",
                    Value.newBuilder()
                        .setType(timestampType())
                        .setTimestampValue(timestampValue(1000, 100).getTimestampValue())
                        .build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithNullTimestampParam() {
    BoundStatement s =
        boundStatementBuilder(columnMetadata("timeParam", timestampType()))
            .setTimestampParam("timeParam", null)
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams("timeParam", Value.newBuilder().setType(timestampType()).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithDateParam() {
    BoundStatement s =
        boundStatementBuilder(columnMetadata("dateParam", dateType()))
            .setDateParam("dateParam", Date.fromYearMonthDay(2024, 6, 11))
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams(
                    "dateParam",
                    Value.newBuilder()
                        .setType(dateType())
                        .setDateValue(dateValue(2024, 6, 11).getDateValue())
                        .build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithNullDateParam() {
    BoundStatement s =
        boundStatementBuilder(columnMetadata("dateParam", dateType()))
            .setDateParam("dateParam", null)
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams("dateParam", Value.newBuilder().setType(dateType()).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithBytesListParam() {
    BoundStatement s =
        boundStatementBuilder(
                columnMetadata("listParam", arrayType(bytesType())),
                columnMetadata("listWithNullElem", arrayType(bytesType())),
                columnMetadata("emptyList", arrayType(bytesType())),
                columnMetadata("nullList", arrayType(bytesType())))
            .setListParam(
                "listParam",
                Arrays.asList(ByteString.copyFromUtf8("foo"), ByteString.copyFromUtf8("bar")),
                SqlType.arrayOf(SqlType.bytes()))
            .setListParam(
                "listWithNullElem",
                Arrays.asList(ByteString.copyFromUtf8("foo"), null, ByteString.copyFromUtf8("bar")),
                SqlType.arrayOf(SqlType.bytes()))
            .setListParam("emptyList", Collections.emptyList(), SqlType.arrayOf(SqlType.bytes()))
            .setListParam("nullList", null, SqlType.arrayOf(SqlType.bytes()))
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams(
                    "listParam",
                    Value.newBuilder()
                        .setType(arrayType(bytesType()))
                        .setArrayValue(
                            arrayValue(bytesValue("foo"), bytesValue("bar")).getArrayValue())
                        .build())
                .putParams(
                    "listWithNullElem",
                    Value.newBuilder()
                        .setType(arrayType(bytesType()))
                        .setArrayValue(
                            arrayValue(bytesValue("foo"), nullValue(), bytesValue("bar"))
                                .getArrayValue())
                        .build())
                .putParams(
                    "emptyList",
                    Value.newBuilder()
                        .setType(arrayType(bytesType()))
                        .setArrayValue(arrayValue().getArrayValue())
                        .build())
                .putParams("nullList", Value.newBuilder().setType(arrayType(bytesType())).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithStringListParam() {
    BoundStatement s =
        boundStatementBuilder(
                columnMetadata("listParam", arrayType(stringType())),
                columnMetadata("listWithNullElem", arrayType(stringType())),
                columnMetadata("emptyList", arrayType(stringType())),
                columnMetadata("nullList", arrayType(stringType())))
            .setListParam(
                "listParam", Arrays.asList("foo", "bar"), SqlType.arrayOf(SqlType.string()))
            .setListParam(
                "listWithNullElem",
                Arrays.asList("foo", "bar", null),
                SqlType.arrayOf(SqlType.string()))
            .setListParam("emptyList", Collections.emptyList(), SqlType.arrayOf(SqlType.string()))
            .setListParam("nullList", null, SqlType.arrayOf(SqlType.string()))
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams(
                    "listParam",
                    Value.newBuilder()
                        .setType(arrayType(stringType()))
                        .setArrayValue(
                            arrayValue(stringValue("foo"), stringValue("bar")).getArrayValue())
                        .build())
                .putParams(
                    "listWithNullElem",
                    Value.newBuilder()
                        .setType(arrayType(stringType()))
                        .setArrayValue(
                            arrayValue(stringValue("foo"), stringValue("bar"), nullValue())
                                .getArrayValue())
                        .build())
                .putParams(
                    "emptyList",
                    Value.newBuilder()
                        .setType(arrayType(stringType()))
                        .setArrayValue(arrayValue().getArrayValue())
                        .build())
                .putParams("nullList", Value.newBuilder().setType(arrayType(stringType())).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithInt64ListParam() {
    BoundStatement s =
        boundStatementBuilder(
                columnMetadata("listParam", arrayType(int64Type())),
                columnMetadata("listWithNullElem", arrayType(int64Type())),
                columnMetadata("emptyList", arrayType(int64Type())),
                columnMetadata("nullList", arrayType(int64Type())))
            .setListParam("listParam", Arrays.asList(1L, 2L), SqlType.arrayOf(SqlType.int64()))
            .setListParam(
                "listWithNullElem", Arrays.asList(null, 3L, 4L), SqlType.arrayOf(SqlType.int64()))
            .setListParam("emptyList", Collections.emptyList(), SqlType.arrayOf(SqlType.int64()))
            .setListParam("nullList", null, SqlType.arrayOf(SqlType.int64()))
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams(
                    "listParam",
                    Value.newBuilder()
                        .setType(arrayType(int64Type()))
                        .setArrayValue(arrayValue(int64Value(1), int64Value(2)).getArrayValue())
                        .build())
                .putParams(
                    "listWithNullElem",
                    Value.newBuilder()
                        .setType(arrayType(int64Type()))
                        .setArrayValue(
                            arrayValue(nullValue(), int64Value(3), int64Value(4)).getArrayValue())
                        .build())
                .putParams(
                    "emptyList",
                    Value.newBuilder()
                        .setType(arrayType(int64Type()))
                        .setArrayValue(arrayValue().getArrayValue())
                        .build())
                .putParams("nullList", Value.newBuilder().setType(arrayType(int64Type())).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithFloat32ListParam() {
    BoundStatement s =
        boundStatementBuilder(
                columnMetadata("listParam", arrayType(float32Type())),
                columnMetadata("listWithNullElem", arrayType(float32Type())),
                columnMetadata("emptyList", arrayType(float32Type())),
                columnMetadata("nullList", arrayType(float32Type())))
            .setListParam(
                "listParam", Arrays.asList(1.1f, 1.2f), SqlType.arrayOf(SqlType.float32()))
            .setListParam(
                "listWithNullElem",
                Arrays.asList(1.3f, 1.4f, null),
                SqlType.arrayOf(SqlType.float32()))
            .setListParam("emptyList", Collections.emptyList(), SqlType.arrayOf(SqlType.float32()))
            .setListParam("nullList", null, SqlType.arrayOf(SqlType.float32()))
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams(
                    "listParam",
                    Value.newBuilder()
                        .setType(arrayType(float32Type()))
                        .setArrayValue(
                            arrayValue(floatValue(1.1f), floatValue(1.2f)).getArrayValue())
                        .build())
                .putParams(
                    "listWithNullElem",
                    Value.newBuilder()
                        .setType(arrayType(float32Type()))
                        .setArrayValue(
                            arrayValue(floatValue(1.3f), floatValue(1.4f), nullValue())
                                .getArrayValue())
                        .build())
                .putParams(
                    "emptyList",
                    Value.newBuilder()
                        .setType(arrayType(float32Type()))
                        .setArrayValue(arrayValue().getArrayValue())
                        .build())
                .putParams("nullList", Value.newBuilder().setType(arrayType(float32Type())).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithFloat64ListParam() {
    BoundStatement s =
        boundStatementBuilder(
                columnMetadata("listParam", arrayType(float64Type())),
                columnMetadata("listWithNullElem", arrayType(float64Type())),
                columnMetadata("emptyList", arrayType(float64Type())),
                columnMetadata("nullList", arrayType(float64Type())))
            .setListParam(
                "listParam", Arrays.asList(1.1d, 1.2d), SqlType.arrayOf(SqlType.float64()))
            .setListParam(
                "listWithNullElem",
                Arrays.asList(1.3d, 1.4d, null),
                SqlType.arrayOf(SqlType.float64()))
            .setListParam("emptyList", Collections.emptyList(), SqlType.arrayOf(SqlType.float64()))
            .setListParam("nullList", null, SqlType.arrayOf(SqlType.float64()))
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams(
                    "listParam",
                    Value.newBuilder()
                        .setType(arrayType(float64Type()))
                        .setArrayValue(arrayValue(floatValue(1.1), floatValue(1.2)).getArrayValue())
                        .build())
                .putParams(
                    "listWithNullElem",
                    Value.newBuilder()
                        .setType(arrayType(float64Type()))
                        .setArrayValue(
                            arrayValue(floatValue(1.3), floatValue(1.4), nullValue())
                                .getArrayValue())
                        .build())
                .putParams(
                    "emptyList",
                    Value.newBuilder()
                        .setType(arrayType(float64Type()))
                        .setArrayValue(arrayValue().getArrayValue())
                        .build())
                .putParams("nullList", Value.newBuilder().setType(arrayType(float64Type())).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithBooleanListParam() {
    BoundStatement s =
        boundStatementBuilder(
                columnMetadata("listParam", arrayType(boolType())),
                columnMetadata("listWithNullElem", arrayType(boolType())),
                columnMetadata("emptyList", arrayType(boolType())),
                columnMetadata("nullList", arrayType(boolType())))
            .setListParam("listParam", Arrays.asList(true, false), SqlType.arrayOf(SqlType.bool()))
            .setListParam(
                "listWithNullElem",
                Arrays.asList(true, false, null),
                SqlType.arrayOf(SqlType.bool()))
            .setListParam("emptyList", Collections.emptyList(), SqlType.arrayOf(SqlType.bool()))
            .setListParam("nullList", null, SqlType.arrayOf(SqlType.bool()))
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams(
                    "listParam",
                    Value.newBuilder()
                        .setType(arrayType(boolType()))
                        .setArrayValue(
                            arrayValue(boolValue(true), boolValue(false)).getArrayValue())
                        .build())
                .putParams(
                    "listWithNullElem",
                    Value.newBuilder()
                        .setType(arrayType(boolType()))
                        .setArrayValue(
                            arrayValue(boolValue(true), boolValue(false), nullValue())
                                .getArrayValue())
                        .build())
                .putParams(
                    "emptyList",
                    Value.newBuilder()
                        .setType(arrayType(boolType()))
                        .setArrayValue(arrayValue().getArrayValue())
                        .build())
                .putParams("nullList", Value.newBuilder().setType(arrayType(boolType())).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithTimestampListParam() {
    BoundStatement s =
        boundStatementBuilder(
                columnMetadata("listParam", arrayType(timestampType())),
                columnMetadata("listWithNullElem", arrayType(timestampType())),
                columnMetadata("emptyList", arrayType(timestampType())),
                columnMetadata("nullList", arrayType(timestampType())))
            .setListParam(
                "listParam",
                Arrays.asList(Instant.ofEpochSecond(3000, 100), Instant.ofEpochSecond(4000, 100)),
                SqlType.arrayOf(SqlType.timestamp()))
            .setListParam(
                "listWithNullElem",
                Arrays.asList(
                    Instant.ofEpochSecond(1000, 100), Instant.ofEpochSecond(2000, 100), null),
                SqlType.arrayOf(SqlType.timestamp()))
            .setListParam(
                "emptyList", Collections.emptyList(), SqlType.arrayOf(SqlType.timestamp()))
            .setListParam("nullList", null, SqlType.arrayOf(SqlType.timestamp()))
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams(
                    "listParam",
                    Value.newBuilder()
                        .setType(arrayType(timestampType()))
                        .setArrayValue(
                            arrayValue(timestampValue(3000, 100), timestampValue(4000, 100))
                                .getArrayValue())
                        .build())
                .putParams(
                    "listWithNullElem",
                    Value.newBuilder()
                        .setType(arrayType(timestampType()))
                        .setArrayValue(
                            arrayValue(
                                    timestampValue(1000, 100),
                                    timestampValue(2000, 100),
                                    nullValue())
                                .getArrayValue())
                        .build())
                .putParams(
                    "emptyList",
                    Value.newBuilder()
                        .setType(arrayType(timestampType()))
                        .setArrayValue(arrayValue().getArrayValue())
                        .build())
                .putParams(
                    "nullList", Value.newBuilder().setType(arrayType(timestampType())).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithDateListParam() {
    BoundStatement s =
        boundStatementBuilder(
                columnMetadata("listParam", arrayType(dateType())),
                columnMetadata("listWithNullElem", arrayType(dateType())),
                columnMetadata("emptyList", arrayType(dateType())),
                columnMetadata("nullList", arrayType(dateType())))
            .setListParam(
                "listParam",
                Arrays.asList(Date.fromYearMonthDay(2024, 6, 1), Date.fromYearMonthDay(2024, 7, 1)),
                SqlType.arrayOf(SqlType.date()))
            .setListParam(
                "listWithNullElem",
                Arrays.asList(
                    Date.fromYearMonthDay(2024, 8, 1), Date.fromYearMonthDay(2024, 8, 2), null),
                SqlType.arrayOf(SqlType.date()))
            .setListParam("emptyList", Collections.emptyList(), SqlType.arrayOf(SqlType.date()))
            .setListParam("nullList", null, SqlType.arrayOf(SqlType.date()))
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams(
                    "listParam",
                    Value.newBuilder()
                        .setType(arrayType(dateType()))
                        .setArrayValue(
                            arrayValue(dateValue(2024, 6, 1), dateValue(2024, 7, 1))
                                .getArrayValue())
                        .build())
                .putParams(
                    "listWithNullElem",
                    Value.newBuilder()
                        .setType(arrayType(dateType()))
                        .setArrayValue(
                            arrayValue(dateValue(2024, 8, 1), dateValue(2024, 8, 2), nullValue())
                                .getArrayValue())
                        .build())
                .putParams(
                    "emptyList",
                    Value.newBuilder()
                        .setType(arrayType(dateType()))
                        .setArrayValue(arrayValue().getArrayValue())
                        .build())
                .putParams("nullList", Value.newBuilder().setType(arrayType(dateType())).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void setListParamRejectsUnsupportedElementTypes() {
    BoundStatement.Builder statement = boundStatementBuilder();

    assertThrows(
        IllegalArgumentException.class,
        () -> statement.setListParam("param", null, SqlType.arrayOf(SqlType.struct())));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            statement.setListParam(
                "param", null, SqlType.arrayOf(SqlType.arrayOf(SqlType.string()))));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            statement.setListParam(
                "param", null, SqlType.arrayOf(SqlType.mapOf(SqlType.bytes(), SqlType.bytes()))));
  }

  @Test
  public void statementBuilderAllowsParamsToBeOverridden() {
    BoundStatement s =
        boundStatementBuilder(columnMetadata("key", stringType()))
            .setStringParam("key", "test1")
            .setStringParam("key", "test2")
            .setStringParam("key", "test3")
            .setStringParam("key", "test4")
            .build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .putParams(
                    "key", Value.newBuilder().setType(stringType()).setStringValue("test4").build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void builderWorksWithNoParams() {
    BoundStatement s = boundStatementBuilder().build();

    assertThat(s.toProto(EXPECTED_PREPARED_QUERY, REQUEST_CONTEXT, NO_RESUME_TOKEN))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setPreparedQuery(EXPECTED_PREPARED_QUERY)
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void builderValidatesParameterNames() {
    BoundStatement.Builder builder = boundStatementBuilder();

    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class, () -> builder.setStringParam("non-existent", "test"));
    assertThat(e.getMessage()).contains("No parameter named: non-existent");
  }

  @Test
  public void builderValidatesTypesMatch() {
    BoundStatement.Builder builder =
        boundStatementBuilder(
            columnMetadata("stringParam", stringType()),
            columnMetadata("bytesParam", bytesType()),
            columnMetadata("stringListParam", stringType()));

    IllegalArgumentException eString =
        assertThrows(
            IllegalArgumentException.class,
            () -> builder.setBytesParam("stringParam", ByteString.copyFromUtf8("foo")));
    assertThat(eString.getMessage()).contains("Invalid type passed for query param");
    IllegalArgumentException eBytes =
        assertThrows(
            IllegalArgumentException.class, () -> builder.setStringParam("bytesParam", "foo"));
    assertThat(eBytes.getMessage()).contains("Invalid type passed for query param");
    IllegalArgumentException eLong =
        assertThrows(IllegalArgumentException.class, () -> builder.setLongParam("bytesParam", 1L));
    assertThat(eLong.getMessage()).contains("Invalid type passed for query param");
    IllegalArgumentException eDouble =
        assertThrows(
            IllegalArgumentException.class, () -> builder.setDoubleParam("bytesParam", 1.1d));
    assertThat(eLong.getMessage()).contains("Invalid type passed for query param");
    IllegalArgumentException eFloat =
        assertThrows(
            IllegalArgumentException.class, () -> builder.setFloatParam("bytesParam", 1.1f));
    assertThat(eFloat.getMessage()).contains("Invalid type passed for query param");
    IllegalArgumentException eBool =
        assertThrows(
            IllegalArgumentException.class, () -> builder.setBooleanParam("bytesParam", true));
    assertThat(eBool.getMessage()).contains("Invalid type passed for query param");
    IllegalArgumentException eTs =
        assertThrows(
            IllegalArgumentException.class,
            () -> builder.setTimestampParam("bytesParam", Instant.now()));
    assertThat(eTs.getMessage()).contains("Invalid type passed for query param");
    IllegalArgumentException eDate =
        assertThrows(
            IllegalArgumentException.class,
            () -> builder.setDateParam("bytesParam", Date.fromYearMonthDay(2025, 1, 1)));
    assertThat(eDate.getMessage()).contains("Invalid type passed for query param");
    IllegalArgumentException eList =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                builder.setListParam(
                    "stringListParam",
                    Collections.singletonList(ByteString.copyFromUtf8("foo")),
                    SqlType.arrayOf(SqlType.bytes())));
    assertThat(eList.getMessage()).contains("Invalid type passed for query param");
  }

  @Test
  public void builderValidatesAllParamsAreSet() {
    BoundStatement.Builder builder =
        boundStatementBuilder(
            columnMetadata("stringParam", stringType()), columnMetadata("bytesParam", bytesType()));
    builder.setStringParam("stringParam", "s");

    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, builder::build);
    assertThat(e.getMessage())
        .contains("Attempting to build BoundStatement without binding parameter: bytesParam");
  }
}
