/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery.jdbc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteSettings;
import com.google.cloud.bigquery.storage.v1.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.cloud.bigquery.storage.v1.TableSchema;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Types;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Regression test for https://github.com/googleapis/google-cloud-java/issues/14066: a
 * null-valued STRING parameter in a Storage Write API batch insert used to throw NPE while
 * building the row's JSON representation, instead of writing a JSON null.
 */
public class BigQueryPreparedStatementBulkInsertNullValueTest {

  private BigQueryConnection connection;
  private BigQueryPreparedStatement preparedStatement;
  private BigQueryWriteClient mockWriteClient;

  @BeforeEach
  public void setUp() throws Exception {
    connection = mock(BigQueryConnection.class);
    mockWriteClient = mock(BigQueryWriteClient.class);

    BigQueryWriteSettings mockSettings =
        BigQueryWriteSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    when(mockWriteClient.getSettings()).thenReturn(mockSettings);

    WriteStream stream =
        WriteStream.newBuilder()
            .setName(
                "projects/test-project/datasets/test_dataset/tables/test_table/streams/_default")
            .setTableSchema(TableSchema.newBuilder().build())
            .build();
    when(mockWriteClient.createWriteStream(any(CreateWriteStreamRequest.class)))
        .thenReturn(stream);

    preparedStatement =
        new BigQueryPreparedStatement(connection, "INSERT INTO test_table (name) VALUES (?)");
    preparedStatement.insertSchema = Schema.of(Field.of("name", StandardSQLTypeName.STRING));

    java.lang.reflect.Field insertTableNameField =
        BigQueryPreparedStatement.class.getDeclaredField("insertTableName");
    insertTableNameField.setAccessible(true);
    insertTableNameField.set(
        preparedStatement, TableName.of("test-project", "test_dataset", "test_table"));
  }

  @Test
  public void testBulkInsertWithWriteApiDoesNotThrowNpeForNullStringParameter() throws Exception {
    preparedStatement.setNull(1, Types.VARCHAR);
    preparedStatement.addBatch();

    Method bulkInsertMethod =
        BigQueryPreparedStatement.class.getDeclaredMethod(
            "bulkInsertWithWriteAPI", BigQueryWriteClient.class);
    bulkInsertMethod.setAccessible(true);

    try {
      bulkInsertMethod.invoke(preparedStatement, mockWriteClient);
    } catch (InvocationTargetException e) {
      assertFalse(
          e.getCause() instanceof NullPointerException,
          "Row construction should not NPE on a null STRING parameter, but got: " + e.getCause());
    }
  }
}
