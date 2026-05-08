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

import com.google.bigtable.v2.Type;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PrepareQueryRequestTest {

  @Test
  public void testProtoConversion() {
    Map<String, SqlType<?>> paramTypes = new HashMap<>();
    paramTypes.put("strParam", SqlType.string());
    paramTypes.put("bytesParam", SqlType.bytes());
    paramTypes.put("intParam", SqlType.int64());
    paramTypes.put("float64Param", SqlType.float64());
    paramTypes.put("float32Param", SqlType.float32());
    paramTypes.put("boolParam", SqlType.bool());
    paramTypes.put("timestampParam", SqlType.timestamp());
    paramTypes.put("dateParam", SqlType.date());
    paramTypes.put("strArrayParam", SqlType.arrayOf(SqlType.string()));
    paramTypes.put("byteArrayParam", SqlType.arrayOf(SqlType.bytes()));
    paramTypes.put("intArrayParam", SqlType.arrayOf(SqlType.int64()));
    paramTypes.put("float32ArrayParam", SqlType.arrayOf(SqlType.float32()));
    paramTypes.put("float64ArrayParam", SqlType.arrayOf(SqlType.float64()));
    paramTypes.put("boolArrayParam", SqlType.arrayOf(SqlType.bool()));
    paramTypes.put("tsArrayParam", SqlType.arrayOf(SqlType.timestamp()));
    paramTypes.put("dateArrayParam", SqlType.arrayOf(SqlType.date()));

    PrepareQueryRequest request = PrepareQueryRequest.create("SELECT * FROM table", paramTypes);
    RequestContext rc = RequestContext.create("project", "instance", "profile");
    com.google.bigtable.v2.PrepareQueryRequest proto = request.toProto(rc);

    assertThat(proto.getQuery()).isEqualTo("SELECT * FROM table");
    assertThat(proto.getAppProfileId()).isEqualTo("profile");
    assertThat(proto.getInstanceName())
        .isEqualTo(NameUtil.formatInstanceName("project", "instance"));

    Map<String, Type> protoParamTypes = new HashMap<>();
    protoParamTypes.put("strParam", stringType());
    protoParamTypes.put("bytesParam", bytesType());
    protoParamTypes.put("intParam", int64Type());
    protoParamTypes.put("float64Param", float64Type());
    protoParamTypes.put("float32Param", float32Type());
    protoParamTypes.put("boolParam", boolType());
    protoParamTypes.put("timestampParam", timestampType());
    protoParamTypes.put("dateParam", dateType());
    protoParamTypes.put("strArrayParam", arrayType(stringType()));
    protoParamTypes.put("byteArrayParam", arrayType(bytesType()));
    protoParamTypes.put("intArrayParam", arrayType(int64Type()));
    protoParamTypes.put("float32ArrayParam", arrayType(float32Type()));
    protoParamTypes.put("float64ArrayParam", arrayType(float64Type()));
    protoParamTypes.put("boolArrayParam", arrayType(boolType()));
    protoParamTypes.put("tsArrayParam", arrayType(timestampType()));
    protoParamTypes.put("dateArrayParam", arrayType(dateType()));
    assertThat(proto.getParamTypesMap()).isEqualTo(protoParamTypes);
  }
}
