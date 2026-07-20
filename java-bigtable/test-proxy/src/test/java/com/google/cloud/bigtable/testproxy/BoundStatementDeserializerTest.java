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
package com.google.cloud.bigtable.testproxy;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.bigtable.v2.Type;
import com.google.bigtable.v2.Value;
import com.google.cloud.bigtable.data.v2.models.sql.BoundStatement;
import com.google.cloud.bigtable.data.v2.models.sql.PreparedStatement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BoundStatementDeserializerTest {

  @Test
  public void testDeserializeStringViewParameter() {
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    BoundStatement.Builder builder = mock(BoundStatement.Builder.class);
    when(preparedStatement.bind()).thenReturn(builder);
    when(builder.setStringViewParameter(anyString(), nullable(String.class))).thenReturn(builder);

    Value stringVal =
        Value.newBuilder()
            .setType(Type.newBuilder().setStringType(Type.String.getDefaultInstance()))
            .setStringValue("alice")
            .build();
    com.google.cloud.bigtable.testproxy.ExecuteQueryRequest request =
        com.google.cloud.bigtable.testproxy.ExecuteQueryRequest.newBuilder()
            .setRequest(ExecuteQueryRequest.newBuilder().putViewParameters("user_id", stringVal))
            .build();

    BoundStatementDeserializer.toBoundStatement(preparedStatement, request);
    verify(builder).setStringViewParameter("user_id", "alice");
  }

  @Test
  public void testDeserializeNullStringViewParameter() {
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    BoundStatement.Builder builder = mock(BoundStatement.Builder.class);
    when(preparedStatement.bind()).thenReturn(builder);
    when(builder.setStringViewParameter(anyString(), nullable(String.class))).thenReturn(builder);

    Value nullStringVal =
        Value.newBuilder()
            .setType(Type.newBuilder().setStringType(Type.String.getDefaultInstance()))
            .build();
    com.google.cloud.bigtable.testproxy.ExecuteQueryRequest request =
        com.google.cloud.bigtable.testproxy.ExecuteQueryRequest.newBuilder()
            .setRequest(
                ExecuteQueryRequest.newBuilder().putViewParameters("user_id", nullStringVal))
            .build();

    BoundStatementDeserializer.toBoundStatement(preparedStatement, request);
    verify(builder).setStringViewParameter("user_id", null);
  }

  @Test
  public void testDeserializeInvalidTypeViewParameterThrows() {
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    BoundStatement.Builder builder = mock(BoundStatement.Builder.class);
    when(preparedStatement.bind()).thenReturn(builder);

    Value intVal =
        Value.newBuilder()
            .setType(Type.newBuilder().setInt64Type(Type.Int64.getDefaultInstance()))
            .setIntValue(123)
            .build();
    com.google.cloud.bigtable.testproxy.ExecuteQueryRequest request =
        com.google.cloud.bigtable.testproxy.ExecuteQueryRequest.newBuilder()
            .setRequest(ExecuteQueryRequest.newBuilder().putViewParameters("user_id", intVal))
            .build();

    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () -> BoundStatementDeserializer.toBoundStatement(preparedStatement, request));
    assertThat(e.getMessage()).contains("Unexpected view parameter type in param");
  }

  @Test
  public void testDeserializeMalformedStringViewParameterThrows() {
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    BoundStatement.Builder builder = mock(BoundStatement.Builder.class);
    when(preparedStatement.bind()).thenReturn(builder);

    Value malformedVal =
        Value.newBuilder()
            .setType(Type.newBuilder().setStringType(Type.String.getDefaultInstance()))
            .setIntValue(123)
            .build();
    com.google.cloud.bigtable.testproxy.ExecuteQueryRequest request =
        com.google.cloud.bigtable.testproxy.ExecuteQueryRequest.newBuilder()
            .setRequest(ExecuteQueryRequest.newBuilder().putViewParameters("user_id", malformedVal))
            .build();

    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () -> BoundStatementDeserializer.toBoundStatement(preparedStatement, request));
    assertThat(e.getMessage()).contains("Malformed string value");
  }
}
