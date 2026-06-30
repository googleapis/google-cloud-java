/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CallTest extends AbstractMockServerTest {

  @Test
  public void testCancelQuery() {
    // 'CALL' should be recognized as a valid query keyword.
    Statement statement = Statement.of("call cancel_query('1234')");
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.query(
            statement,
            com.google.spanner.v1.ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setRowType(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setName("call_result_tvf")
                                        .setType(Type.newBuilder().setCode(TypeCode.BOOL).build())
                                        .build())
                                .build())
                        .build())
                .build()));

    try (Connection connection = createConnection()) {
      try (ResultSet resultSet = connection.executeQuery(statement)) {
        assertFalse(resultSet.next());
        assertEquals(1, resultSet.getColumnCount());
      }
    }
  }
}
