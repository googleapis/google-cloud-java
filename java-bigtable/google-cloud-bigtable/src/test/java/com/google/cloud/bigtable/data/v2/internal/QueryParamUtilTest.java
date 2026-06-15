/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal;

import static com.google.cloud.bigtable.data.v2.internal.QueryParamUtil.convertToQueryParamProto;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.arrayType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.boolType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.dateType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.float32Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.float64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.timestampType;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class QueryParamUtilTest {

  @Test
  public void convertsSimpleTypes() {
    assertThat(convertToQueryParamProto(SqlType.string())).isEqualTo(stringType());
    assertThat(convertToQueryParamProto(SqlType.bytes())).isEqualTo(bytesType());
    assertThat(convertToQueryParamProto(SqlType.int64())).isEqualTo(int64Type());
    assertThat(convertToQueryParamProto(SqlType.float64())).isEqualTo(float64Type());
    assertThat(convertToQueryParamProto(SqlType.float32())).isEqualTo(float32Type());
    assertThat(convertToQueryParamProto(SqlType.bool())).isEqualTo(boolType());
    assertThat(convertToQueryParamProto(SqlType.timestamp())).isEqualTo(timestampType());
    assertThat(convertToQueryParamProto(SqlType.date())).isEqualTo(dateType());
  }

  @Test
  public void convertsValidArrayTypes() {
    assertThat(convertToQueryParamProto(SqlType.arrayOf(SqlType.string())))
        .isEqualTo(arrayType(stringType()));
    assertThat(convertToQueryParamProto(SqlType.arrayOf(SqlType.bytes())))
        .isEqualTo(arrayType(bytesType()));
    assertThat(convertToQueryParamProto(SqlType.arrayOf(SqlType.int64())))
        .isEqualTo(arrayType(int64Type()));
    assertThat(convertToQueryParamProto(SqlType.arrayOf(SqlType.float64())))
        .isEqualTo(arrayType(float64Type()));
    assertThat(convertToQueryParamProto(SqlType.arrayOf(SqlType.float32())))
        .isEqualTo(arrayType(float32Type()));
    assertThat(convertToQueryParamProto(SqlType.arrayOf(SqlType.bool())))
        .isEqualTo(arrayType(boolType()));
    assertThat(convertToQueryParamProto(SqlType.arrayOf(SqlType.timestamp())))
        .isEqualTo(arrayType(timestampType()));
    assertThat(convertToQueryParamProto(SqlType.arrayOf(SqlType.date())))
        .isEqualTo(arrayType(dateType()));
  }

  @Test
  public void failsForInvalidArrayElementTypes() {
    assertThrows(
        IllegalArgumentException.class,
        () -> convertToQueryParamProto(SqlType.arrayOf(SqlType.struct())));
    assertThrows(
        IllegalArgumentException.class,
        () -> convertToQueryParamProto(SqlType.arrayOf(SqlType.arrayOf(SqlType.string()))));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            convertToQueryParamProto(
                SqlType.arrayOf(SqlType.mapOf(SqlType.string(), SqlType.string()))));
  }

  @Test
  public void failsForMap() {
    assertThrows(
        IllegalArgumentException.class,
        () -> convertToQueryParamProto(SqlType.mapOf(SqlType.string(), SqlType.string())));
  }

  @Test
  public void failsForStruct() {
    assertThrows(IllegalArgumentException.class, () -> convertToQueryParamProto(SqlType.struct()));
  }
}
