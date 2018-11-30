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

package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.google.cloud.bigquery.JobInfo.CreateDisposition;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class CopyJobConfigurationTest {

  private static final TableId SOURCE_TABLE = TableId.of("dataset", "sourceTable");
  private static final List<TableId> SOURCE_TABLES =
      ImmutableList.of(
          TableId.of("dataset", "sourceTable1"), TableId.of("dataset", "sourceTable2"));
  private static final TableId DESTINATION_TABLE = TableId.of("dataset", "destinationTable");
  private static final CreateDisposition CREATE_DISPOSITION = CreateDisposition.CREATE_IF_NEEDED;
  private static final WriteDisposition WRITE_DISPOSITION = WriteDisposition.WRITE_APPEND;
  private static final EncryptionConfiguration COPY_JOB_ENCRYPTION_CONFIGURATION =
      EncryptionConfiguration.newBuilder().setKmsKeyName("KMS_KEY_1").build();
  private static final CopyJobConfiguration COPY_JOB_CONFIGURATION =
      CopyJobConfiguration.newBuilder(DESTINATION_TABLE, SOURCE_TABLE)
          .setCreateDisposition(CREATE_DISPOSITION)
          .setWriteDisposition(WRITE_DISPOSITION)
          .setDestinationEncryptionConfiguration(COPY_JOB_ENCRYPTION_CONFIGURATION)
          .build();
  private static final CopyJobConfiguration COPY_JOB_CONFIGURATION_MULTIPLE_TABLES =
      CopyJobConfiguration.newBuilder(DESTINATION_TABLE, SOURCE_TABLES)
          .setCreateDisposition(CREATE_DISPOSITION)
          .setWriteDisposition(WRITE_DISPOSITION)
          .build();

  @Test
  public void testToBuilder() {
    compareCopyJobConfiguration(COPY_JOB_CONFIGURATION, COPY_JOB_CONFIGURATION.toBuilder().build());
    compareCopyJobConfiguration(
        COPY_JOB_CONFIGURATION_MULTIPLE_TABLES,
        COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.toBuilder().build());
    CopyJobConfiguration jobConfiguration =
        COPY_JOB_CONFIGURATION
            .toBuilder()
            .setDestinationTable(TableId.of("dataset", "newTable"))
            .build();
    assertEquals("newTable", jobConfiguration.getDestinationTable().getTable());
    jobConfiguration = jobConfiguration.toBuilder().setDestinationTable(DESTINATION_TABLE).build();
    compareCopyJobConfiguration(COPY_JOB_CONFIGURATION, jobConfiguration);
  }

  @Test
  public void testOf() {
    CopyJobConfiguration job = CopyJobConfiguration.of(DESTINATION_TABLE, SOURCE_TABLES);
    assertEquals(DESTINATION_TABLE, job.getDestinationTable());
    assertEquals(SOURCE_TABLES, job.getSourceTables());
    job = CopyJobConfiguration.of(DESTINATION_TABLE, SOURCE_TABLE);
    assertEquals(DESTINATION_TABLE, job.getDestinationTable());
    assertEquals(ImmutableList.of(SOURCE_TABLE), job.getSourceTables());
  }

  @Test
  public void testToBuilderIncomplete() {
    CopyJobConfiguration jobConfiguration =
        CopyJobConfiguration.of(DESTINATION_TABLE, SOURCE_TABLES);
    compareCopyJobConfiguration(jobConfiguration, jobConfiguration.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(DESTINATION_TABLE, COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.getDestinationTable());
    assertEquals(SOURCE_TABLES, COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.getSourceTables());
    assertEquals(CREATE_DISPOSITION, COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.getCreateDisposition());
    assertEquals(WRITE_DISPOSITION, COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.getWriteDisposition());
    assertEquals(DESTINATION_TABLE, COPY_JOB_CONFIGURATION.getDestinationTable());
    assertEquals(ImmutableList.of(SOURCE_TABLE), COPY_JOB_CONFIGURATION.getSourceTables());
    assertEquals(CREATE_DISPOSITION, COPY_JOB_CONFIGURATION.getCreateDisposition());
    assertEquals(WRITE_DISPOSITION, COPY_JOB_CONFIGURATION.getWriteDisposition());
  }

  @Test
  public void testToPbAndFromPb() {
    assertNotNull(COPY_JOB_CONFIGURATION.toPb().getCopy());
    assertNull(COPY_JOB_CONFIGURATION.toPb().getExtract());
    assertNull(COPY_JOB_CONFIGURATION.toPb().getLoad());
    assertNull(COPY_JOB_CONFIGURATION.toPb().getQuery());
    assertNull(COPY_JOB_CONFIGURATION.toPb().getCopy().getSourceTables());
    assertNull(COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.toPb().getCopy().getSourceTable());
    compareCopyJobConfiguration(
        COPY_JOB_CONFIGURATION, CopyJobConfiguration.fromPb(COPY_JOB_CONFIGURATION.toPb()));
    compareCopyJobConfiguration(
        COPY_JOB_CONFIGURATION_MULTIPLE_TABLES,
        CopyJobConfiguration.fromPb(COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.toPb()));
    CopyJobConfiguration jobConfiguration =
        CopyJobConfiguration.of(DESTINATION_TABLE, SOURCE_TABLES);
    compareCopyJobConfiguration(
        jobConfiguration, CopyJobConfiguration.fromPb(jobConfiguration.toPb()));
  }

  @Test
  public void testSetProjectId() {
    CopyJobConfiguration configuration = COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.setProjectId("p");
    assertEquals("p", configuration.getDestinationTable().getProject());
    for (TableId sourceTable : configuration.getSourceTables()) {
      assertEquals("p", sourceTable.getProject());
    }
  }

  @Test
  public void testGetType() {
    assertEquals(JobConfiguration.Type.COPY, COPY_JOB_CONFIGURATION.getType());
    assertEquals(JobConfiguration.Type.COPY, COPY_JOB_CONFIGURATION_MULTIPLE_TABLES.getType());
  }

  private void compareCopyJobConfiguration(
      CopyJobConfiguration expected, CopyJobConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.getDestinationTable(), value.getDestinationTable());
    assertEquals(expected.getSourceTables(), value.getSourceTables());
    assertEquals(expected.getCreateDisposition(), value.getCreateDisposition());
    assertEquals(expected.getWriteDisposition(), value.getWriteDisposition());
    assertEquals(
        expected.getDestinationEncryptionConfiguration(),
        value.getDestinationEncryptionConfiguration());
  }
}
