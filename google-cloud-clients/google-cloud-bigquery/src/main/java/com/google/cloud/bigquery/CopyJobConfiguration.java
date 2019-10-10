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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.bigquery.model.JobConfigurationTableCopy;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Google BigQuery copy job configuration. A copy job copies an existing table to another new or
 * existing table. Copy job configurations have {@link JobConfiguration.Type#COPY} type.
 */
public final class CopyJobConfiguration extends JobConfiguration {

  private static final long serialVersionUID = 1140509641399762967L;

  private final List<TableId> sourceTables;
  private final TableId destinationTable;
  private final JobInfo.CreateDisposition createDisposition;
  private final JobInfo.WriteDisposition writeDisposition;
  private final EncryptionConfiguration destinationEncryptionConfiguration;
  private final Map<String, String> labels;
  private final Long jobTimeoutMs;

  public static final class Builder
      extends JobConfiguration.Builder<CopyJobConfiguration, Builder> {

    private List<TableId> sourceTables;
    private TableId destinationTable;
    private JobInfo.CreateDisposition createDisposition;
    private JobInfo.WriteDisposition writeDisposition;
    private EncryptionConfiguration destinationEncryptionConfiguration;
    private Map<String, String> labels;
    private Long jobTimeoutMs;

    private Builder() {
      super(Type.COPY);
    }

    private Builder(CopyJobConfiguration jobConfiguration) {
      this();
      this.sourceTables = jobConfiguration.sourceTables;
      this.destinationTable = jobConfiguration.destinationTable;
      this.createDisposition = jobConfiguration.createDisposition;
      this.writeDisposition = jobConfiguration.writeDisposition;
      this.destinationEncryptionConfiguration = jobConfiguration.destinationEncryptionConfiguration;
      this.labels = jobConfiguration.labels;
      this.jobTimeoutMs = jobConfiguration.jobTimeoutMs;
    }

    private Builder(com.google.api.services.bigquery.model.JobConfiguration configurationPb) {
      this();
      JobConfigurationTableCopy copyConfigurationPb = configurationPb.getCopy();
      this.destinationTable = TableId.fromPb(copyConfigurationPb.getDestinationTable());
      if (copyConfigurationPb.getSourceTables() != null) {
        this.sourceTables =
            Lists.transform(copyConfigurationPb.getSourceTables(), TableId.FROM_PB_FUNCTION);
      } else {
        this.sourceTables = ImmutableList.of(TableId.fromPb(copyConfigurationPb.getSourceTable()));
      }
      if (copyConfigurationPb.getCreateDisposition() != null) {
        this.createDisposition =
            JobInfo.CreateDisposition.valueOf(copyConfigurationPb.getCreateDisposition());
      }
      if (copyConfigurationPb.getWriteDisposition() != null) {
        this.writeDisposition =
            JobInfo.WriteDisposition.valueOf(copyConfigurationPb.getWriteDisposition());
      }
      if (copyConfigurationPb.getDestinationEncryptionConfiguration() != null) {
        this.destinationEncryptionConfiguration =
            new EncryptionConfiguration.Builder(
                    copyConfigurationPb.getDestinationEncryptionConfiguration())
                .build();
      }
      if (configurationPb.getLabels() != null) {
        this.labels = configurationPb.getLabels();
      }
      if (configurationPb.getJobTimeoutMs() != null) {
        this.jobTimeoutMs = configurationPb.getJobTimeoutMs();
      }
    }

    /** Sets the source tables to copy. */
    public Builder setSourceTables(List<TableId> sourceTables) {
      this.sourceTables = sourceTables != null ? ImmutableList.copyOf(sourceTables) : null;
      return this;
    }

    /** Sets the destination table of the copy job. */
    public Builder setDestinationTable(TableId destinationTable) {
      this.destinationTable = destinationTable;
      return this;
    }

    public Builder setDestinationEncryptionConfiguration(
        EncryptionConfiguration encryptionConfiguration) {
      this.destinationEncryptionConfiguration = encryptionConfiguration;
      return this;
    }

    /**
     * Sets whether the job is allowed to create new tables.
     *
     * @see <a
     *     href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.copy.createDisposition">
     *     Create Disposition</a>
     */
    public Builder setCreateDisposition(JobInfo.CreateDisposition createDisposition) {
      this.createDisposition = createDisposition;
      return this;
    }

    /**
     * Sets the action that should occur if the destination table already exists.
     *
     * @see <a
     *     href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.copy.writeDisposition">
     *     Write Disposition</a>
     */
    public Builder setWriteDisposition(JobInfo.WriteDisposition writeDisposition) {
      this.writeDisposition = writeDisposition;
      return this;
    }

    /**
     * The labels associated with this job. You can use these to organize and group your jobs. Label
     * keys and values can be no longer than 63 characters, can only contain lowercase letters,
     * numeric characters, underscores and dashes. International characters are allowed. Label
     * values are optional. Label keys must start with a letter and each label in the list must have
     * a different key.
     *
     * @param labels labels or {@code null} for none
     */
    public Builder setLabels(Map<String, String> labels) {
      this.labels = labels;
      return this;
    }

    /**
     * [Optional] Job timeout in milliseconds. If this time limit is exceeded, BigQuery may attempt
     * to terminate the job.
     *
     * @param jobTimeoutMs jobTimeoutMs or {@code null} for none
     */
    public Builder setJobTimeoutMs(Long jobTimeoutMs) {
      this.jobTimeoutMs = jobTimeoutMs;
      return this;
    }

    public CopyJobConfiguration build() {
      return new CopyJobConfiguration(this);
    }
  }

  private CopyJobConfiguration(Builder builder) {
    super(builder);
    this.sourceTables = checkNotNull(builder.sourceTables);
    this.destinationTable = checkNotNull(builder.destinationTable);
    this.createDisposition = builder.createDisposition;
    this.writeDisposition = builder.writeDisposition;
    this.destinationEncryptionConfiguration = builder.destinationEncryptionConfiguration;
    this.labels = builder.labels;
    this.jobTimeoutMs = builder.jobTimeoutMs;
  }

  /** Returns the source tables to copy. */
  public List<TableId> getSourceTables() {
    return sourceTables;
  }

  /** Returns the destination table to load the data into. */
  public TableId getDestinationTable() {
    return destinationTable;
  }

  public EncryptionConfiguration getDestinationEncryptionConfiguration() {
    return destinationEncryptionConfiguration;
  }

  /**
   * Returns whether the job is allowed to create new tables.
   *
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.copy.createDisposition">
   *     Create Disposition</a>
   */
  public JobInfo.CreateDisposition getCreateDisposition() {
    return this.createDisposition;
  }

  /**
   * Returns the action that should occur if the destination table already exists.
   *
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.copy.writeDisposition">
   *     Write Disposition</a>
   */
  public JobInfo.WriteDisposition getWriteDisposition() {
    return writeDisposition;
  }

  /** Returns the labels associated with this job */
  public Map<String, String> getLabels() {
    return labels;
  }

  /** Returns the timeout associated with this job */
  public Long getJobTimeoutMs() {
    return jobTimeoutMs;
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
        .add("destinationEncryptionConfiguration", destinationEncryptionConfiguration)
        .add("createDisposition", createDisposition)
        .add("writeDisposition", writeDisposition)
        .add("labels", labels)
        .add("jobTimeoutMs", jobTimeoutMs);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof CopyJobConfiguration && baseEquals((CopyJobConfiguration) obj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        baseHashCode(),
        sourceTables,
        destinationTable,
        createDisposition,
        writeDisposition,
        labels,
        jobTimeoutMs);
  }

  @Override
  CopyJobConfiguration setProjectId(final String projectId) {
    Builder builder = toBuilder();
    builder.setSourceTables(
        Lists.transform(
            getSourceTables(),
            new Function<TableId, TableId>() {
              @Override
              public TableId apply(TableId tableId) {
                if (Strings.isNullOrEmpty(tableId.getProject())) {
                  return tableId.setProjectId(projectId);
                }
                return tableId;
              }
            }));
    if (Strings.isNullOrEmpty(getDestinationTable().getProject())) {
      builder.setDestinationTable(getDestinationTable().setProjectId(projectId));
    }
    return builder.build();
  }

  @Override
  com.google.api.services.bigquery.model.JobConfiguration toPb() {
    JobConfigurationTableCopy configurationPb = new JobConfigurationTableCopy();
    com.google.api.services.bigquery.model.JobConfiguration jobConfiguration =
        new com.google.api.services.bigquery.model.JobConfiguration();
    configurationPb.setDestinationTable(destinationTable.toPb());
    if (sourceTables.size() == 1) {
      configurationPb.setSourceTable(sourceTables.get(0).toPb());
    } else {
      configurationPb.setSourceTables(Lists.transform(sourceTables, TableId.TO_PB_FUNCTION));
    }
    if (createDisposition != null) {
      configurationPb.setCreateDisposition(createDisposition.toString());
    }
    if (writeDisposition != null) {
      configurationPb.setWriteDisposition(writeDisposition.toString());
    }
    if (destinationEncryptionConfiguration != null) {
      configurationPb.setDestinationEncryptionConfiguration(
          destinationEncryptionConfiguration.toPb());
    }
    if (labels != null) {
      jobConfiguration.setLabels(labels);
    }
    if (jobTimeoutMs != null) {
      jobConfiguration.setJobTimeoutMs(jobTimeoutMs);
    }
    jobConfiguration.setCopy(configurationPb);
    return jobConfiguration;
  }

  /** Creates a builder for a BigQuery Copy Job configuration given destination and source table. */
  public static Builder newBuilder(TableId destinationTable, TableId sourceTable) {
    return newBuilder(destinationTable, ImmutableList.of(checkNotNull(sourceTable)));
  }

  /**
   * Creates a builder for a BigQuery Copy Job configuration given destination and source tables.
   */
  public static Builder newBuilder(TableId destinationTable, List<TableId> sourceTables) {
    return new Builder().setDestinationTable(destinationTable).setSourceTables(sourceTables);
  }

  /** Returns a BigQuery Copy Job configuration for the given destination and source table. */
  public static CopyJobConfiguration of(TableId destinationTable, TableId sourceTable) {
    return newBuilder(destinationTable, sourceTable).build();
  }

  /** Returns a BigQuery Copy Job configuration for the given destination and source tables. */
  public static CopyJobConfiguration of(TableId destinationTable, List<TableId> sourceTables) {
    return newBuilder(destinationTable, sourceTables).build();
  }

  @SuppressWarnings("unchecked")
  static CopyJobConfiguration fromPb(
      com.google.api.services.bigquery.model.JobConfiguration jobPb) {
    return new Builder(jobPb).build();
  }
}
