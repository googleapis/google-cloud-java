/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableList;
import com.google.cloud.bigquery.JobInfo.CreateDisposition;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;

import org.junit.Test;

import java.util.List;

public class CopyJobConfigurationTest {

  private static final TableId SOURCE_TABLE = TableId.of("dataset", "sourceTable");
  private static final List<TableId> SOURCE_TABLES = ImmutableList.of(
      TableId.of("dataset", "sourceTable1"),
      TableId.of("dataset", "sourceTable2"));
  private static final TableId DESTINATION_TABLE = TableId.of("dataset", "destinationTable");
  private static final CreateDisposition CREATE_DISPOSITION = CreateDisposition.CREATE_IF_NEEDED;
  private static final WriteDisposition WRITE_DISPOSITION = WriteDisposition.WRITE_APPEND;
  private static final CopyJobConfiguration COPY_JOB_CONFIGURATION =
      CopyJobConfiguration.builder(DESTINATION_TABLE, SOURCE_TABLE)
          .createDisposition(CREATE_DISPOSITION)
          .writeDisposition(WRITE_DISPOSITION)
          .build();
  private static final CopyJobConfiguration COPY_JOB_CONFIGURATION_MULTIPLE_TABLES =
      CopyJobConfiguration.builder(DESTINATION_TABLE, SOURCE_TABLES)
          .createDisposition(CREATE_DISPOSITION)
          .writeDisposition(WRITE_DISPOSITION)
          .build();

  @Test
  public void testToBuilder() {
    compareCopyJobConfiguration(COPY_JOB_CONFIGURATION, COPY_JOB_CONFIGURATION.toBuilder().build());
    compareCopyJobConfiguration(COPY_JOB_CONFIGURATION_MULTIPLE_TABLES,
        COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.toBuilder().build());
    CopyJobConfiguration jobConfiguration = COPY_JOB_CONFIGURATION.toBuilder()
        .destinationTable(TableId.of("dataset", "newTable"))
        .build();
    assertEquals("newTable", jobConfiguration.destinationTable().table());
    jobConfiguration = jobConfiguration.toBuilder().destinationTable(DESTINATION_TABLE).build();
    compareCopyJobConfiguration(COPY_JOB_CONFIGURATION, jobConfiguration);
  }

  @Test
  public void testOf() {
    CopyJobConfiguration job = CopyJobConfiguration.of(DESTINATION_TABLE, SOURCE_TABLES);
    assertEquals(DESTINATION_TABLE, job.destinationTable());
    assertEquals(SOURCE_TABLES, job.sourceTables());
    job = CopyJobConfiguration.of(DESTINATION_TABLE, SOURCE_TABLE);
    assertEquals(DESTINATION_TABLE, job.destinationTable());
    assertEquals(ImmutableList.of(SOURCE_TABLE), job.sourceTables());
  }

  @Test
  public void testToBuilderIncomplete() {
    CopyJobConfiguration jobConfiguration =
        CopyJobConfiguration.of(DESTINATION_TABLE, SOURCE_TABLES);
    compareCopyJobConfiguration(jobConfiguration, jobConfiguration.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(DESTINATION_TABLE, COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.destinationTable());
    assertEquals(SOURCE_TABLES, COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.sourceTables());
    assertEquals(CREATE_DISPOSITION, COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.createDisposition());
    assertEquals(WRITE_DISPOSITION, COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.writeDisposition());
    assertEquals(DESTINATION_TABLE, COPY_JOB_CONFIGURATION.destinationTable());
    assertEquals(ImmutableList.of(SOURCE_TABLE), COPY_JOB_CONFIGURATION.sourceTables());
    assertEquals(CREATE_DISPOSITION, COPY_JOB_CONFIGURATION.createDisposition());
    assertEquals(WRITE_DISPOSITION, COPY_JOB_CONFIGURATION.writeDisposition());
  }

  @Test
  public void testToPbAndFromPb() {
    assertNotNull(COPY_JOB_CONFIGURATION.toPb().getCopy());
    assertNull(COPY_JOB_CONFIGURATION.toPb().getExtract());
    assertNull(COPY_JOB_CONFIGURATION.toPb().getLoad());
    assertNull(COPY_JOB_CONFIGURATION.toPb().getQuery());
    assertNull(COPY_JOB_CONFIGURATION.toPb().getCopy().getSourceTables());
    assertNull(COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.toPb().getCopy().getSourceTable());
    compareCopyJobConfiguration(COPY_JOB_CONFIGURATION,
        CopyJobConfiguration.fromPb(COPY_JOB_CONFIGURATION.toPb()));
    compareCopyJobConfiguration(COPY_JOB_CONFIGURATION_MULTIPLE_TABLES,
        CopyJobConfiguration.fromPb(COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.toPb()));
    CopyJobConfiguration jobConfiguration =
        CopyJobConfiguration.of(DESTINATION_TABLE, SOURCE_TABLES);
    compareCopyJobConfiguration(
        jobConfiguration, CopyJobConfiguration.fromPb(jobConfiguration.toPb()));
  }

  @Test
  public void testSetProjectId() {
    CopyJobConfiguration configuration = COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.setProjectId("p");
    assertEquals("p", configuration.destinationTable().project());
    for (TableId sourceTable : configuration.sourceTables()) {
      assertEquals("p", sourceTable.project());
    }
  }

  private void compareCopyJobConfiguration(CopyJobConfiguration expected,
      CopyJobConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.destinationTable(), value.destinationTable());
    assertEquals(expected.sourceTables(), value.sourceTables());
    assertEquals(expected.createDisposition(), value.createDisposition());
    assertEquals(expected.writeDisposition(), value.writeDisposition());
  }
}
