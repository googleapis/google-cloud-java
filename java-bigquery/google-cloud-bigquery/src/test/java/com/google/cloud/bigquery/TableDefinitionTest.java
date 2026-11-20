/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import com.google.api.services.bigquery.model.ExternalDataConfiguration;
import com.google.api.services.bigquery.model.Table;
import com.google.api.services.bigquery.model.TableReference;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

class TableDefinitionTest {

  private static final String SOURCE_URI = "gs://bucket/warehouse/mytable/metadata/v1.json";

  private static Table metastoreTablePb() {
    return new Table()
        .setTableReference(
            new TableReference()
                .setProjectId("project_id")
                .setDatasetId("dataset")
                .setTableId("mytable"))
        .setType("METASTORE")
        .setExternalDataConfiguration(
            new ExternalDataConfiguration()
                .setSourceFormat("ICEBERG")
                .setSourceUris(ImmutableList.of(SOURCE_URI)));
  }

  @Test
  void testFromPbMetastoreTable() {
    TableDefinition definition = TableDefinition.fromPb(metastoreTablePb());

    ExternalTableDefinition external = assertInstanceOf(ExternalTableDefinition.class, definition);
    assertEquals(TableDefinition.Type.METASTORE, external.getType());
    assertEquals(FormatOptions.ICEBERG, external.getFormatOptions().getType());
    assertEquals(ImmutableList.of(SOURCE_URI), external.getSourceUris());
    assertEquals("METASTORE", external.toPb().getType());
  }

  @Test
  void testTableInfoFromPbMetastoreTable() {
    // This is the path used by listTables(), getTable() and Dataset.list().
    TableInfo tableInfo = TableInfo.fromPb(metastoreTablePb());

    assertEquals(TableId.of("project_id", "dataset", "mytable"), tableInfo.getTableId());
    assertEquals(TableDefinition.Type.METASTORE, tableInfo.getDefinition().getType());
  }

  @Test
  void testFromPbUnknownTypeWithoutExternalConfiguration() {
    TableDefinition definition = TableDefinition.fromPb(new Table().setType("SOME_FUTURE_TYPE"));

    assertInstanceOf(StandardTableDefinition.class, definition);
    assertEquals("SOME_FUTURE_TYPE", definition.getType().name());
  }

  @Test
  void testFromPbUnknownTypeWithExternalConfiguration() {
    TableDefinition definition =
        TableDefinition.fromPb(
            new Table()
                .setType("SOME_FUTURE_TYPE")
                .setExternalDataConfiguration(
                    new ExternalDataConfiguration()
                        .setSourceFormat("PARQUET")
                        .setSourceUris(ImmutableList.of("gs://bucket/*.parquet"))));

    ExternalTableDefinition external = assertInstanceOf(ExternalTableDefinition.class, definition);
    assertEquals("SOME_FUTURE_TYPE", external.getType().name());
    assertEquals(FormatOptions.PARQUET, external.getFormatOptions().getType());
  }
}
