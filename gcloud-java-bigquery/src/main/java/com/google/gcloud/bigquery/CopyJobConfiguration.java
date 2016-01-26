package com.google.gcloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.bigquery.model.JobConfigurationTableCopy;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery Copy Job configuration. A Copy Job copies an existing table to another new or
 * existing table.
 */
public final class CopyJobConfiguration implements JobConfiguration, Serializable {

  private static final long serialVersionUID = 1140509641399762967L;

  private final List<TableId> sourceTables;
  private final TableId destinationTable;
  private final JobInfo.CreateDisposition createDisposition;
  private final JobInfo.WriteDisposition writeDisposition;

  public static final class Builder {

    private List<TableId> sourceTables;
    private TableId destinationTable;
    private JobInfo.CreateDisposition createDisposition;
    private JobInfo.WriteDisposition writeDisposition;

    private Builder() {}

    private Builder(CopyJobConfiguration jobConfiguration) {
      this.sourceTables = jobConfiguration.sourceTables;
      this.destinationTable = jobConfiguration.destinationTable;
      this.createDisposition = jobConfiguration.createDisposition;
      this.writeDisposition = jobConfiguration.writeDisposition;
    }

    private Builder(com.google.api.services.bigquery.model.JobConfiguration configurationPb) {
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
        this.writeDisposition = JobInfo.WriteDisposition.valueOf(
            copyConfigurationPb.getWriteDisposition());
      }
    }

    /**
     * Sets the source tables to copy.
     */
    public Builder sourceTables(List<TableId> sourceTables) {
      this.sourceTables = sourceTables != null ? ImmutableList.copyOf(sourceTables) : null;
      return this;
    }

    /**
     * Sets the destination table of the copy job.
     */
    public Builder destinationTable(TableId destinationTable) {
      this.destinationTable = destinationTable;
      return this;
    }

    /**
     * Sets whether the job is allowed to create new tables.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.copy.createDisposition">
     *     Create Disposition</a>
     */
    public Builder createDisposition(JobInfo.CreateDisposition createDisposition) {
      this.createDisposition = createDisposition;
      return this;
    }

    /**
     * Sets the action that should occur if the destination table already exists.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.copy.writeDisposition">
     *     Write Disposition</a>
     */
    public Builder writeDisposition(JobInfo.WriteDisposition writeDisposition) {
      this.writeDisposition = writeDisposition;
      return this;
    }

    public CopyJobConfiguration build() {
      return new CopyJobConfiguration(this);
    }
  }

  private CopyJobConfiguration(Builder builder) {
    this.sourceTables = checkNotNull(builder.sourceTables);
    this.destinationTable = checkNotNull(builder.destinationTable);
    this.createDisposition = builder.createDisposition;
    this.writeDisposition = builder.writeDisposition;
  }

  @Override
  public Type type() {
    return Type.COPY;
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
  public JobInfo.CreateDisposition createDisposition() {
    return this.createDisposition;
  }

  /**
   * Returns the action that should occur if the destination table already exists.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.copy.writeDisposition">
   *     Write Disposition</a>
   */
  public JobInfo.WriteDisposition writeDisposition() {
    return writeDisposition;
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("sourceTables", sourceTables)
        .add("destinationTable", destinationTable)
        .add("createDisposition", createDisposition)
        .add("writeDisposition", writeDisposition)
        .toString();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof CopyJobConfiguration
        && Objects.equals(toPb(), ((CopyJobConfiguration) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourceTables, destinationTable, createDisposition, writeDisposition);
  }

  com.google.api.services.bigquery.model.JobConfiguration toPb() {
    JobConfigurationTableCopy configurationPb = new JobConfigurationTableCopy();
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
    return new com.google.api.services.bigquery.model.JobConfiguration().setCopy(configurationPb);
  }

  /**
   * Creates a builder for a BigQuery Copy Job configuration given destination and source table.
   */
  public static Builder builder(TableId destinationTable, TableId sourceTable) {
    return builder(destinationTable, ImmutableList.of(checkNotNull(sourceTable)));
  }

  /**
   * Creates a builder for a BigQuery Copy Job configuration given destination and source tables.
   */
  public static Builder builder(TableId destinationTable, List<TableId> sourceTables) {
    return new Builder().destinationTable(destinationTable).sourceTables(sourceTables);
  }

  /**
   * Returns a BigQuery Copy Job configuration for the given destination and source table.
   */
  public static CopyJobConfiguration of(TableId destinationTable, TableId sourceTable) {
    return builder(destinationTable, sourceTable).build();
  }

  /**
   * Returns a BigQuery Copy Job configuration for the given destination and source tables.
   */
  public static CopyJobConfiguration of(TableId destinationTable, List<TableId> sourceTables) {
    return builder(destinationTable, sourceTables).build();
  }

  static CopyJobConfiguration fromPb(
      com.google.api.services.bigquery.model.JobConfiguration jobPb) {
    return new Builder(jobPb).build();
  }
}
