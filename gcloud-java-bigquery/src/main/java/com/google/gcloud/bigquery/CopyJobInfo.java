/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.bigquery.model.Job;
import com.google.api.services.bigquery.model.JobConfiguration;
import com.google.api.services.bigquery.model.JobConfigurationTableCopy;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery Copy Job. A Copy Job copies an existing table to another new or existing table.
 */
public class CopyJobInfo extends JobInfo<JobStatistics> {

  private static final long serialVersionUID = 7830335512951916299L;

  private final List<TableId> sourceTables;
  private final TableId destinationTable;
  private final CreateDisposition createDisposition;
  private final WriteDisposition writeDisposition;

  public static final class Builder extends JobInfo.Builder<CopyJobInfo, JobStatistics, Builder> {

    private List<TableId> sourceTables;
    private TableId destinationTable;
    private CreateDisposition createDisposition;
    private WriteDisposition writeDisposition;

    private Builder() {}

    private Builder(CopyJobInfo jobInfo) {
      super(jobInfo);
      this.sourceTables = jobInfo.sourceTables;
      this.destinationTable = jobInfo.destinationTable;
      this.createDisposition = jobInfo.createDisposition;
      this.writeDisposition = jobInfo.writeDisposition;
    }

    private Builder(Job jobPb) {
      super(jobPb);
      JobConfigurationTableCopy copyConfigurationPb = jobPb.getConfiguration().getCopy();
      this.destinationTable = TableId.fromPb(copyConfigurationPb.getDestinationTable());
      if (copyConfigurationPb.getSourceTables() != null) {
        this.sourceTables =
            Lists.transform(copyConfigurationPb.getSourceTables(), TableId.FROM_PB_FUNCTION);
      } else {
        this.sourceTables = ImmutableList.of(TableId.fromPb(copyConfigurationPb.getSourceTable()));
      }
      if (copyConfigurationPb.getCreateDisposition() != null) {
        this.createDisposition =
            CreateDisposition.valueOf(copyConfigurationPb.getCreateDisposition());
      }
      if (copyConfigurationPb.getWriteDisposition() != null) {
        this.writeDisposition = WriteDisposition.valueOf(copyConfigurationPb.getWriteDisposition());
      }
    }

    /**
     * Sets the source tables to copy.
     */
    public Builder sourceTables(List<TableId> sourceTables) {
      this.sourceTables = sourceTables != null ? ImmutableList.copyOf(sourceTables) : null;
      return self();
    }

    /**
     * Sets the destination table of the copy job.
     */
    public Builder destinationTable(TableId destinationTable) {
      this.destinationTable = destinationTable;
      return self();
    }

    /**
     * Sets whether the job is allowed to create new tables.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.copy.createDisposition">
     *     Create Disposition</a>
     */
    public Builder createDisposition(CreateDisposition createDisposition) {
      this.createDisposition = createDisposition;
      return self();
    }

    /**
     * Sets the action that should occur if the destination table already exists.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.copy.writeDisposition">
     *     Write Disposition</a>
     */
    public Builder writeDisposition(WriteDisposition writeDisposition) {
      this.writeDisposition = writeDisposition;
      return self();
    }

    @Override
    public CopyJobInfo build() {
      return new CopyJobInfo(this);
    }
  }

  private CopyJobInfo(Builder builder) {
    super(builder);
    this.sourceTables = checkNotNull(builder.sourceTables);
    this.destinationTable = checkNotNull(builder.destinationTable);
    this.createDisposition = builder.createDisposition;
    this.writeDisposition = builder.writeDisposition;
  }

  /**
   * Returns the source tables to copy.
   */
  public List<TableId> sourceTables() {
    return sourceTables;
  }

  /**
   * Returns the destination table to load the data into.
   */
  public TableId destinationTable() {
    return destinationTable;
  }

  /**
   * Returns whether the job is allowed to create new tables.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.copy.createDisposition">
   *     Create Disposition</a>
   */
  public CreateDisposition createDisposition() {
    return this.createDisposition;
  }

  /**
   * Returns the action that should occur if the destination table already exists.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.copy.writeDisposition">
   *     Write Disposition</a>
   */
  public WriteDisposition writeDisposition() {
    return writeDisposition;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("sourceTables", sourceTables)
        .add("destinationTable", destinationTable)
        .add("createDisposition", createDisposition)
        .add("writeDisposition", writeDisposition);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof CopyJobInfo && baseEquals((CopyJobInfo) obj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), sourceTables, destinationTable, createDisposition,
        writeDisposition);
  }

  @Override
  Job toPb() {
    JobConfigurationTableCopy copyConfigurationPb = new JobConfigurationTableCopy();
    copyConfigurationPb.setDestinationTable(destinationTable.toPb());
    if (sourceTables.size() == 1) {
      copyConfigurationPb.setSourceTable(sourceTables.get(0).toPb());
    } else {
      copyConfigurationPb.setSourceTables(Lists.transform(sourceTables, TableId.TO_PB_FUNCTION));
    }
    if (createDisposition != null) {
      copyConfigurationPb.setCreateDisposition(createDisposition.toString());
    }
    if (writeDisposition != null) {
      copyConfigurationPb.setWriteDisposition(writeDisposition.toString());
    }
    return super.toPb().setConfiguration(new JobConfiguration().setCopy(copyConfigurationPb));
  }

  /**
   * Creates a builder for a BigQuery Copy Job given destination and source table.
   */
  public static Builder builder(TableId destinationTable, TableId sourceTable) {
    return builder(destinationTable, ImmutableList.of(checkNotNull(sourceTable)));
  }

  /**
   * Creates a builder for a BigQuery Copy Job given destination and source tables.
   */
  public static Builder builder(TableId destinationTable, List<TableId> sourceTables) {
    return new Builder().destinationTable(destinationTable).sourceTables(sourceTables);
  }

  /**
   * Returns a BigQuery Copy Job for the given destination and source table. Job's id is chosen by
   * the service.
   */
  public static CopyJobInfo of(TableId destinationTable, TableId sourceTable) {
    return builder(destinationTable, sourceTable).build();
  }

  /**
   * Returns a BigQuery Copy Job for the given destination and source tables. Job's id is chosen by
   * the service.
   */
  public static CopyJobInfo of(TableId destinationTable, List<TableId> sourceTables) {
    return builder(destinationTable, sourceTables).build();
  }

  /**
   * Returns a BigQuery Copy Job for the given destination and source table. Job's id is set to the
   * provided value.
   */
  public static CopyJobInfo of(JobId jobId, TableId destinationTable, TableId sourceTable) {
    return builder(destinationTable, sourceTable).jobId(jobId).build();
  }

  /**
   * Returns a BigQuery Copy Job for the given destination and source tables. Job's id is set to the
   * provided value.
   */
  public static CopyJobInfo of(JobId jobId, TableId destinationTable, List<TableId> sourceTables) {
    return builder(destinationTable, sourceTables).jobId(jobId).build();
  }

  @SuppressWarnings("unchecked")
  static CopyJobInfo fromPb(Job jobPb) {
    return new Builder(jobPb).build();
  }
}
