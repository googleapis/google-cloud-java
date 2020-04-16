/*
 * Copyright 2016 Google LLC
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
package com.google.cloud.bigquery.storage.v1alpha2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.google.cloud.bigquery.*;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.storage.test.Test.FooType;
import java.io.IOException;
import javax.annotation.Nullable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(JUnit4.class)
public class SchemaCompactTest {
  @Mock private BigQuery mockBigquery;
  @Mock private Table mockBigqueryTable;

  @Before
  public void setUp() throws IOException {
    MockitoAnnotations.initMocks(this);
    when(mockBigquery.getTable(any(TableId.class))).thenReturn(mockBigqueryTable);
  }

  @After
  public void tearDown() {
    verifyNoMoreInteractions(mockBigquery);
    verifyNoMoreInteractions(mockBigqueryTable);
  }

  @Test
  public void testSuccess() throws Exception {
    TableDefinition definition =
        new TableDefinition() {
          @Override
          public Type getType() {
            return null;
          }

          @Nullable
          @Override
          public Schema getSchema() {
            return Schema.of(Field.of("Foo", LegacySQLTypeName.STRING));
          }

          @Override
          public Builder toBuilder() {
            return null;
          }
        };
    when(mockBigqueryTable.getDefinition()).thenReturn(definition);
    SchemaCompact compact = SchemaCompact.getInstance(mockBigquery);
    compact.check("projects/p/datasets/d/tables/t", FooType.getDescriptor());
    verify(mockBigquery, times(1)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(1)).getDefinition();
  }

  @Test
  public void testFailed() throws Exception {
    TableDefinition definition =
        new TableDefinition() {
          @Override
          public Type getType() {
            return null;
          }

          @Nullable
          @Override
          public Schema getSchema() {
            return Schema.of(
                Field.of("Foo", LegacySQLTypeName.STRING),
                Field.of("Bar", LegacySQLTypeName.STRING));
          }

          @Override
          public Builder toBuilder() {
            return null;
          }
        };
    when(mockBigqueryTable.getDefinition()).thenReturn(definition);
    SchemaCompact compact = SchemaCompact.getInstance(mockBigquery);
    try {
      compact.check("projects/p/datasets/d/tables/t", FooType.getDescriptor());
      fail("should fail");
    } catch (IllegalArgumentException expected) {
      assertEquals(
          "User schema doesn't have expected field number with BigQuery table schema, expected: 2 actual: 1",
          expected.getMessage());
    }
    verify(mockBigquery, times(1)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(1)).getDefinition();
  }

  @Test
  public void testBadTableName() throws Exception {
    try {
      SchemaCompact compact = SchemaCompact.getInstance(mockBigquery);
      compact.check("blah", FooType.getDescriptor());
      fail("should fail");
    } catch (IllegalArgumentException expected) {
      assertEquals("Invalid table name: blah", expected.getMessage());
    }
  }
}
