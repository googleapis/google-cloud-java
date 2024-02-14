/*
 * Copyright 2024 Google LLC
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

import static org.junit.Assert.assertEquals;

import com.google.api.services.bigquery.model.TableReference;
import com.google.cloud.bigquery.TableMetadataCacheUsage.UnusedReason;
import org.junit.Test;

public class TableMetadataCacheUsageTest {

  private static final String EXPLANATION = "test explanation";

  private static final String TABLE_TYPE = "test tableType";

  private static final UnusedReason UNUSED_REASON = UnusedReason.UNUSED_REASON_UNSPECIFIED;
  private static final TableReference TABLE_REFERENCE =
      new TableReference()
          .setTableId("test tableId")
          .setProjectId("test projectId")
          .setDatasetId("test dataset");
  private static final TableMetadataCacheUsage TABLE_METADATA_CACHE_USAGE =
      TableMetadataCacheUsage.newBuilder()
          .setExplanation(EXPLANATION)
          .setTableType(TABLE_TYPE)
          .setUnusedReason(UNUSED_REASON)
          .setTableReference(TableId.fromPb(TABLE_REFERENCE))
          .build();

  private static final com.google.api.services.bigquery.model.TableMetadataCacheUsage
      TABLE_METADATA_CACHE_USAGE_PB =
          new com.google.api.services.bigquery.model.TableMetadataCacheUsage()
              .setTableReference(TABLE_REFERENCE)
              .setExplanation(EXPLANATION)
              .setTableType(TABLE_TYPE)
              .setUnusedReason(UNUSED_REASON.toString());

  @Test
  public void testToPbAndFromPb() {
    assertEquals(TABLE_METADATA_CACHE_USAGE_PB, TABLE_METADATA_CACHE_USAGE.toPb());
    compareTableMetadataCacheUsage(
        TABLE_METADATA_CACHE_USAGE, TableMetadataCacheUsage.fromPb(TABLE_METADATA_CACHE_USAGE_PB));
  }

  private void compareTableMetadataCacheUsage(
      TableMetadataCacheUsage expected, TableMetadataCacheUsage value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.getExplanation(), value.getExplanation());
    assertEquals(expected.getTableType(), value.getTableType());
    assertEquals(expected.getUnusedReason(), value.getUnusedReason());
    assertEquals(expected.getTableReference(), value.getTableReference());
  }
}
