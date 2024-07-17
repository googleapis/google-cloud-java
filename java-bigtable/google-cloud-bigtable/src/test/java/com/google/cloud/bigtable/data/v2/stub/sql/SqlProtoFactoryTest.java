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

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithToken;
import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.bigtable.v2.PartialResultSet;
import com.google.bigtable.v2.ProtoRows;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class SqlProtoFactoryTest {

  @Test
  public void serializedProtoRows_canRoundTrip() throws InvalidProtocolBufferException {
    ExecuteQueryResponse response =
        partialResultSetWithToken(
            SqlProtoFactory.stringValue("string"), SqlProtoFactory.bytesValue("bytes"));
    PartialResultSet results = response.getResults();

    assertThat(results.getResumeToken()).isEqualTo(ByteString.copyFromUtf8("test"));
    ProtoRows protoRows = ProtoRows.parseFrom(results.getProtoRowsBatch().getBatchData());
    assertThat(protoRows.getValuesCount()).isEqualTo(2);
    assertThat(protoRows.getValuesList().get(0).getStringValue()).isEqualTo("string");
    assertThat(protoRows.getValuesList().get(1).getBytesValue())
        .isEqualTo(ByteString.copyFromUtf8("bytes"));
  }
}
