/*
 * Copyright 2023 Google LLC
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

import static org.junit.Assert.assertFalse;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.BatchCreateSessionsRequest;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.TypeCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExperimentalHostMockServerTest extends AbstractMockServerTest {

  private static final String SQL_QUERY = "SELECT * FROM Singers";

  private static final ResultSetMetadata SINGERS_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      StructType.Field.newBuilder()
                          .setName("FirstName")
                          .setType(
                              com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.STRING)))
                  .addFields(
                      StructType.Field.newBuilder()
                          .setName("LastName")
                          .setType(
                              com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.STRING)))
                  .build())
          .build();

  private static final com.google.spanner.v1.ResultSet SINGERS_RESULT_SET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .setMetadata(SINGERS_METADATA)
          .addRows(
              ListValue.newBuilder()
                  .addValues(Value.newBuilder().setStringValue("Jane"))
                  .addValues(Value.newBuilder().setStringValue("Doe"))
                  .build())
          .build();

  @Test
  public void testExperimentalHostPreventsBatchCreateSessions() {
    mockSpanner.putStatementResult(
        StatementResult.query(Statement.of(SQL_QUERY), SINGERS_RESULT_SET));

    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("p")
            .setCredentials(NoCredentials.getInstance())
            .setExperimentalHost(null)
            .setChannelProvider(channelProvider)
            .build();

    try (Spanner spanner = options.getService()) {
      DatabaseClient dbClient = spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

      // Perform an operation to trigger session creation
      ResultSet resultSet = dbClient.singleUse().executeQuery(Statement.of(SQL_QUERY));
      while (resultSet.next()) {}

      assertFalse(mockSpanner.getRequestTypes().contains(BatchCreateSessionsRequest.class));
    }
  }
}
