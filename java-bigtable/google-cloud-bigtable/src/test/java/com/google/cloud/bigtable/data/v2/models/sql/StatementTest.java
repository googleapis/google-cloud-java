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

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.boolType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.dateType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.dateValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.timestampType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.timestampValue;
import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.bigtable.v2.Value;
import com.google.cloud.Date;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.protobuf.ByteString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Instant;

@RunWith(JUnit4.class)
public class StatementTest {

  private static final String EXPECTED_APP_PROFILE = "test-profile";
  private static final RequestContext REQUEST_CONTEXT =
      RequestContext.create("test-project", "test-instance", EXPECTED_APP_PROFILE);
  private static final String EXPECTED_INSTANCE_NAME =
      "projects/test-project/instances/test-instance";

  @Test
  public void statementWithoutParameters() {
    Statement s = Statement.of("SELECT * FROM table");

    assertThat(s.toProto(REQUEST_CONTEXT))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setQuery("SELECT * FROM table")
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithBytesParam() {
    Statement s =
        Statement.newBuilder("SELECT * FROM table WHERE _key=@key")
            .setBytesParam("key", ByteString.copyFromUtf8("test"))
            .build();

    assertThat(s.toProto(REQUEST_CONTEXT))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setQuery("SELECT * FROM table WHERE _key=@key")
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
    Statement s =
        Statement.newBuilder("SELECT * FROM table WHERE _key=@key")
            .setBytesParam("key", null)
            .build();

    assertThat(s.toProto(REQUEST_CONTEXT))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setQuery("SELECT * FROM table WHERE _key=@key")
                .putParams("key", Value.newBuilder().setType(bytesType()).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithStringParam() {
    Statement s =
        Statement.newBuilder("SELECT * FROM table WHERE _key=@key")
            .setStringParam("key", "test")
            .build();

    assertThat(s.toProto(REQUEST_CONTEXT))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setQuery("SELECT * FROM table WHERE _key=@key")
                .putParams(
                    "key", Value.newBuilder().setType(stringType()).setStringValue("test").build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithNullStringParam() {
    Statement s =
        Statement.newBuilder("SELECT * FROM table WHERE _key=@key")
            .setStringParam("key", null)
            .build();

    assertThat(s.toProto(REQUEST_CONTEXT))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setQuery("SELECT * FROM table WHERE _key=@key")
                .putParams("key", Value.newBuilder().setType(stringType()).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithInt64Param() {
    Statement s =
        Statement.newBuilder("SELECT * FROM table WHERE 1=@number")
            .setLongParam("number", 1L)
            .build();

    assertThat(s.toProto(REQUEST_CONTEXT))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setQuery("SELECT * FROM table WHERE 1=@number")
                .putParams("number", Value.newBuilder().setType(int64Type()).setIntValue(1).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithNullInt64Param() {
    Statement s =
        Statement.newBuilder("SELECT * FROM table WHERE 1=@number")
            .setLongParam("number", null)
            .build();

    assertThat(s.toProto(REQUEST_CONTEXT))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setQuery("SELECT * FROM table WHERE 1=@number")
                .putParams("number", Value.newBuilder().setType(int64Type()).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithBoolParam() {
    Statement s =
        Statement.newBuilder("SELECT * FROM table WHERE @bool")
            .setBooleanParam("bool", true)
            .build();

    assertThat(s.toProto(REQUEST_CONTEXT))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setQuery("SELECT * FROM table WHERE @bool")
                .putParams(
                    "bool", Value.newBuilder().setType(boolType()).setBoolValue(true).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithNullBoolParam() {
    Statement s =
        Statement.newBuilder("SELECT * FROM table WHERE @bool")
            .setBooleanParam("bool", null)
            .build();

    assertThat(s.toProto(REQUEST_CONTEXT))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setQuery("SELECT * FROM table WHERE @bool")
                .putParams("bool", Value.newBuilder().setType(boolType()).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithTimestampParam() {
    Statement s =
        Statement.newBuilder(
                "SELECT * FROM table WHERE PARSE_TIMESTAMP(\"%Y/%m/%dT%H:%M:%S\", CAST(cf[\"ts\"] AS STRING)) < @timeParam")
            .setTimestampParam("timeParam", Instant.ofEpochSecond(1000, 100))
            .build();

    assertThat(s.toProto(REQUEST_CONTEXT))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setQuery(
                    "SELECT * FROM table WHERE PARSE_TIMESTAMP(\"%Y/%m/%dT%H:%M:%S\", CAST(cf[\"ts\"] AS STRING)) < @timeParam")
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
    Statement s =
        Statement.newBuilder(
                "SELECT * FROM table WHERE PARSE_TIMESTAMP(\"%Y/%m/%dT%H:%M:%S\", CAST(cf[\"ts\"] AS STRING)) < @timeParam")
            .setTimestampParam("timeParam", null)
            .build();

    assertThat(s.toProto(REQUEST_CONTEXT))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setQuery(
                    "SELECT * FROM table WHERE PARSE_TIMESTAMP(\"%Y/%m/%dT%H:%M:%S\", CAST(cf[\"ts\"] AS STRING)) < @timeParam")
                .putParams("timeParam", Value.newBuilder().setType(timestampType()).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementWithDateParam() {
    Statement s =
        Statement.newBuilder(
                "SELECT * FROM table WHERE PARSE_DATE(\"%Y%m%d\", CAST(cf[\"date\"] AS STRING)) < @dateParam")
            .setDateParam("dateParam", Date.fromYearMonthDay(2024, 6, 11))
            .build();

    assertThat(s.toProto(REQUEST_CONTEXT))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setQuery(
                    "SELECT * FROM table WHERE PARSE_DATE(\"%Y%m%d\", CAST(cf[\"date\"] AS STRING)) < @dateParam")
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
    Statement s =
        Statement.newBuilder(
                "SELECT * FROM table WHERE PARSE_DATE(\"%Y%m%d\", CAST(cf[\"date\"] AS STRING)) < @dateParam")
            .setDateParam("dateParam", null)
            .build();

    assertThat(s.toProto(REQUEST_CONTEXT))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setQuery(
                    "SELECT * FROM table WHERE PARSE_DATE(\"%Y%m%d\", CAST(cf[\"date\"] AS STRING)) < @dateParam")
                .putParams("dateParam", Value.newBuilder().setType(dateType()).build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void statementBuilderAllowsParamsToBeOverridden() {
    Statement s =
        Statement.newBuilder("SELECT * FROM table WHERE _key=@key")
            .setStringParam("key", "test1")
            .setStringParam("key", "test2")
            .setStringParam("key", "test3")
            .setStringParam("key", "test4")
            .build();

    assertThat(s.toProto(REQUEST_CONTEXT))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setQuery("SELECT * FROM table WHERE _key=@key")
                .putParams(
                    "key", Value.newBuilder().setType(stringType()).setStringValue("test4").build())
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }

  @Test
  public void builderWorksWithNoParams() {
    Statement s = Statement.newBuilder("SELECT * FROM table").build();

    assertThat(s.toProto(REQUEST_CONTEXT))
        .isEqualTo(
            ExecuteQueryRequest.newBuilder()
                .setQuery("SELECT * FROM table")
                .setInstanceName(EXPECTED_INSTANCE_NAME)
                .setAppProfileId(EXPECTED_APP_PROFILE)
                .build());
  }
}
