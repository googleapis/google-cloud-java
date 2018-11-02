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

import com.google.api.core.ApiFunction;
import com.google.api.services.bigquery.model.JobConfiguration;
import com.google.api.services.bigquery.model.JobStatistics2;
import com.google.api.services.bigquery.model.JobStatistics3;
import com.google.api.services.bigquery.model.JobStatistics4;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A Google BigQuery Job statistics.
 */
public abstract class JobStatistics implements Serializable {

  private static final long serialVersionUID = 1433024714741660399L;

  private final Long creationTime;
  private final Long endTime;
  private final Long startTime;

  /**
   * A Google BigQuery Copy Job statistics.
   */
  public static class CopyStatistics extends JobStatistics {

    private static final long serialVersionUID = 8218325588441660938L;

    static final class Builder extends JobStatistics.Builder<CopyStatistics, Builder> {

      private Builder() {}

      private Builder(com.google.api.services.bigquery.model.JobStatistics statisticsPb) {
        super(statisticsPb);
      }

      @Override
      CopyStatistics build() {
        return new CopyStatistics(this);
      }
    }

    private CopyStatistics(Builder builder) {
      super(builder);
    }

    @Override
    public final boolean equals(Object obj) {
      return obj == this
          || obj != null
          && obj.getClass().equals(CopyStatistics.class)
          && baseEquals((CopyStatistics) obj);
    }

    @Override
    public final int hashCode() {
      return baseHashCode();
    }

    static Builder newBuilder() {
      return new Builder();
    }

    @SuppressWarnings("unchecked")
    static CopyStatistics fromPb(
        com.google.api.services.bigquery.model.JobStatistics statisticPb) {
      return new Builder(statisticPb).build();
    }
  }

  /**
   * A Google BigQuery Extract Job statistics.
   */
  public static class ExtractStatistics extends JobStatistics {

    private static final long serialVersionUID = -1566598819212767373L;

    private final List<Long> destinationUriFileCounts;

    static final class Builder extends JobStatistics.Builder<ExtractStatistics, Builder> {

      private List<Long> destinationUriFileCounts;

      private Builder() {}

      private Builder(com.google.api.services.bigquery.model.JobStatistics statisticsPb) {
        super(statisticsPb);
        if (statisticsPb.getExtract() != null) {
          this.destinationUriFileCounts = statisticsPb.getExtract().getDestinationUriFileCounts();
        }
      }

      Builder setDestinationUriFileCounts(List<Long> destinationUriFileCounts) {
        this.destinationUriFileCounts = destinationUriFileCounts;
        return self();
      }

      @Override
      ExtractStatistics build() {
        return new ExtractStatistics(this);
      }
    }

    private ExtractStatistics(Builder builder) {
      super(builder);
      this.destinationUriFileCounts = builder.destinationUriFileCounts;
    }


    /**
     * Returns the number of files per destination URI or URI pattern specified in the extract job.
     * These values will be in the same order as the URIs specified by
     * {@link ExtractJobConfiguration#getDestinationUris()}.
     */
    public List<Long> getDestinationUriFileCounts() {
      return destinationUriFileCounts;
    }

    @Override
    ToStringHelper toStringHelper() {
      return super.toStringHelper().add("destinationUriFileCounts", destinationUriFileCounts);
    }

    @Override
    public final boolean equals(Object obj) {
      return obj == this
          || obj != null
          && obj.getClass().equals(ExtractStatistics.class)
          && baseEquals((ExtractStatistics) obj);
    }

    @Override
    public final int hashCode() {
      return Objects.hash(baseHashCode(), destinationUriFileCounts);
    }

    @Override
    com.google.api.services.bigquery.model.JobStatistics toPb() {
      com.google.api.services.bigquery.model.JobStatistics statisticsPb = super.toPb();
      return statisticsPb.setExtract(
          new JobStatistics4().setDestinationUriFileCounts(destinationUriFileCounts));
    }

    static Builder newBuilder() {
      return new Builder();
    }

    @SuppressWarnings("unchecked")
    static ExtractStatistics fromPb(
        com.google.api.services.bigquery.model.JobStatistics statisticPb) {
      return new Builder(statisticPb).build();
    }
  }

  /**
   * A Google BigQuery Load Job statistics.
   */
  public static class LoadStatistics extends JobStatistics {

    private static final long serialVersionUID = -707369246536309215L;

    private final Long inputBytes;
    private final Long inputFiles;
    private final Long outputBytes;
    private final Long outputRows;

    static final class Builder extends JobStatistics.Builder<LoadStatistics, Builder> {

      private Long inputBytes;
      private Long inputFiles;
      private Long outputBytes;
      private Long outputRows;

      private Builder() {}

      private Builder(com.google.api.services.bigquery.model.JobStatistics statisticsPb) {
        super(statisticsPb);
        if (statisticsPb.getLoad() != null) {
          this.inputBytes = statisticsPb.getLoad().getInputFileBytes();
          this.inputFiles = statisticsPb.getLoad().getInputFiles();
          this.outputBytes = statisticsPb.getLoad().getOutputBytes();
          this.outputRows = statisticsPb.getLoad().getOutputRows();
        }
      }

      Builder setInputBytes(Long inputBytes) {
        this.inputBytes = inputBytes;
        return self();
      }

      Builder setInputFiles(Long inputFiles) {
        this.inputFiles = inputFiles;
        return self();
      }

      Builder setOutputBytes(Long outputBytes) {
        this.outputBytes = outputBytes;
        return self();
      }

      Builder setOutputRows(Long outputRows) {
        this.outputRows = outputRows;
        return self();
      }

      @Override
      LoadStatistics build() {
        return new LoadStatistics(this);
      }
    }

    private LoadStatistics(Builder builder) {
      super(builder);
      this.inputBytes = builder.inputBytes;
      this.inputFiles = builder.inputFiles;
      this.outputBytes = builder.outputBytes;
      this.outputRows = builder.outputRows;

    }


    /**
     * Returns the number of bytes of source data in a load job.
     */
    public Long getInputBytes() {
      return inputBytes;
    }


    /**
     * Returns the number of source files in a load job.
     */
    public Long getInputFiles() {
      return inputFiles;
    }


    /**
     * Returns the size of the data loaded by a load job so far, in bytes.
     */
    public Long getOutputBytes() {
      return outputBytes;
    }


    /**
     * Returns the number of rows loaded by a load job so far.
     */
    public Long getOutputRows() {
      return outputRows;
    }

    @Override
    ToStringHelper toStringHelper() {
      return super.toStringHelper()
          .add("inputBytes", inputBytes)
          .add("inputFiles", inputFiles)
          .add("outputBytes", outputBytes)
          .add("outputRows", outputRows);
    }

    @Override
    public final boolean equals(Object obj) {
      return obj == this
          || obj != null
          && obj.getClass().equals(LoadStatistics.class)
          && baseEquals((LoadStatistics) obj);
    }

    @Override
    public final int hashCode() {
      return Objects.hash(baseHashCode(), inputBytes, inputFiles, outputBytes, outputRows);
    }

    @Override
    com.google.api.services.bigquery.model.JobStatistics toPb() {
      JobStatistics3 loadStatisticsPb = new JobStatistics3();
      loadStatisticsPb.setInputFileBytes(inputBytes);
      loadStatisticsPb.setInputFiles(inputFiles);
      loadStatisticsPb.setOutputBytes(outputBytes);
      loadStatisticsPb.setOutputRows(outputRows);
      return super.toPb().setLoad(loadStatisticsPb);
    }

    static Builder newBuilder() {
      return new Builder();
    }

    @SuppressWarnings("unchecked")
    static LoadStatistics fromPb(com.google.api.services.bigquery.model.JobStatistics statisticPb) {
      return new Builder(statisticPb).build();
    }
  }


  /**
   * A Google BigQuery Query Job statistics.
   */
  public static class QueryStatistics extends JobStatistics {

    private static final long serialVersionUID = 7539354109226732353L;

    private final Integer billingTier;
    private final Boolean cacheHit;
    private final String ddlOperationPerformed;
    private final TableId ddlTargetTable;
    private final Long estimatedBytesProcessed;
    private final Long numDmlAffectedRows;
    private final List<TableId> referencedTables;
    private final StatementType statementType;
    private final Long totalBytesBilled;
    private final Long totalBytesProcessed;
    private final Long totalPartitionsProcessed;
    private final Long totalSlotMs;
    private final List<QueryStage> queryPlan;
    private final List<TimelineSample> timeline;
    private final Schema schema;


    /**
     * StatementType represents possible types of SQL statements reported as part of the
     * QueryStatistics of a BigQuery job.
     */
    public static final class StatementType extends StringEnumValue {
      private static final long serialVersionUID = 818920627219751204L;

      private static final ApiFunction<String, StatementType> CONSTRUCTOR =
          new ApiFunction<String, StatementType>() {
            @Override
            public StatementType apply(String constant) {
              return new StatementType(constant);
            }
          };

      private static final StringEnumType<StatementType> type = new StringEnumType(
          StatementType.class,
          CONSTRUCTOR);

      public static final StatementType SELECT = type.createAndRegister("SELECT");
      public static final StatementType UPDATE = type.createAndRegister("UPDATE");
      public static final StatementType INSERT = type.createAndRegister("INSERT");
      public static final StatementType DELETE = type.createAndRegister("DELETE");
      public static final StatementType CREATE_TABLE = type.createAndRegister("CREATE_TABLE");
      public static final StatementType CREATE_TABLE_AS_SELECT = type.createAndRegister("CREATE_TABLE_AS_SELECT");
      public static final StatementType CREATE_VIEW = type.createAndRegister("CREATE_VIEW");
      public static final StatementType DROP_TABLE = type.createAndRegister("DROP_TABLE");
      public static final StatementType DROP_VIEW = type.createAndRegister("DROP_VIEW");
      public static final StatementType MERGE = type.createAndRegister("MERGE");

      private StatementType(String constant) {
        super(constant);
      }

      /**
       * Get the StatementType for the given String constant, and throw an exception if the constant is
       * not recognized.
       */
      public static StatementType valueOfStrict(String constant) {
        return type.valueOfStrict(constant);
      }

      /**
       * Get the State for the given String constant, and allow unrecognized values.
       */
      public static StatementType valueOf(String constant) {
        return type.valueOf(constant);
      }

      /**
       * Return the known values for State.
       */
      public static StatementType[] values() {
        return type.values();
      }
    }

    static final class Builder extends JobStatistics.Builder<QueryStatistics, Builder> {

      private Integer billingTier;
      private Boolean cacheHit;
      private String ddlOperationPerformed;
      private TableId ddlTargetTable;
      private Long estimatedBytesProcessed;
      private Long numDmlAffectedRows;
      private List<TableId> referencedTables;
      private StatementType statementType;
      private Long totalBytesBilled;
      private Long totalBytesProcessed;
      private Long totalPartitionsProcessed;
      private Long totalSlotMs;
      private List<QueryStage> queryPlan;
      private List<TimelineSample> timeline;
      private Schema schema;

      private Builder() {}

      private Builder(com.google.api.services.bigquery.model.JobStatistics statisticsPb) {
        super(statisticsPb);
        if (statisticsPb.getQuery() != null) {
          this.billingTier = statisticsPb.getQuery().getBillingTier();
          this.cacheHit = statisticsPb.getQuery().getCacheHit();
          this.ddlOperationPerformed = statisticsPb.getQuery().getDdlOperationPerformed();
          if (statisticsPb.getQuery().getDdlTargetTable() != null) {
            this.ddlTargetTable = TableId.fromPb(statisticsPb.getQuery().getDdlTargetTable());
          }
          this.estimatedBytesProcessed = statisticsPb.getQuery().getEstimatedBytesProcessed();
          this.numDmlAffectedRows = statisticsPb.getQuery().getNumDmlAffectedRows();
          this.totalBytesBilled = statisticsPb.getQuery().getTotalBytesBilled();
          this.totalBytesProcessed = statisticsPb.getQuery().getTotalBytesProcessed();
          this.totalPartitionsProcessed = statisticsPb.getQuery().getTotalPartitionsProcessed();
          this.totalSlotMs = statisticsPb.getQuery().getTotalSlotMs();
          if (statisticsPb.getQuery().getStatementType() != null) {
            this.statementType = StatementType.valueOf(statisticsPb.getQuery().getStatementType());
          }

          if (statisticsPb.getQuery().getReferencedTables() != null) {
            this.referencedTables =
                Lists.transform(
                    statisticsPb.getQuery().getReferencedTables(), TableId.FROM_PB_FUNCTION);
          }
          if (statisticsPb.getQuery().getQueryPlan() != null) {
            this.queryPlan =
                Lists.transform(
                    statisticsPb.getQuery().getQueryPlan(), QueryStage.FROM_PB_FUNCTION);
          }
          if (statisticsPb.getQuery().getTimeline() != null) {
            this.timeline =
                Lists.transform(
                    statisticsPb.getQuery().getTimeline(), TimelineSample.FROM_PB_FUNCTION);
          }
          if (statisticsPb.getQuery().getSchema() != null) {
            this.schema = Schema.fromPb(statisticsPb.getQuery().getSchema());
          }
        }
      }

      Builder setBillingTier(Integer billingTier) {
        this.billingTier = billingTier;
        return self();
      }

      Builder setCacheHit(Boolean cacheHit) {
        this.cacheHit = cacheHit;
        return self();
      }

      Builder setDDLOperationPerformed(String ddlOperationPerformed) {
        this.ddlOperationPerformed = ddlOperationPerformed;
        return self();
      }

      Builder setDDLTargetTable(TableId ddlTargetTable) {
        this.ddlTargetTable = ddlTargetTable;
        return self();
      }

      Builder setEstimatedBytesProcessed(Long estimatedBytesProcessed) {
        this.estimatedBytesProcessed = estimatedBytesProcessed;
        return self();
      }

      Builder setNumDmlAffectedRows(Long numDmlAffectedRows) {
        this.numDmlAffectedRows = numDmlAffectedRows;
        return self();
      }

      Builder setReferenceTables(List<TableId> referencedTables) {
        this.referencedTables = referencedTables;
        return self();
      }

      Builder setStatementType(StatementType statementType) {
        this.statementType = statementType;
        return self();
      }

      Builder setStatementType(String strStatementType) {
        this.statementType = StatementType.valueOf(strStatementType);
        return self();
      }

      Builder setTotalBytesBilled(Long totalBytesBilled) {
        this.totalBytesBilled = totalBytesBilled;
        return self();
      }

      Builder setTotalBytesProcessed(Long totalBytesProcessed) {
        this.totalBytesProcessed = totalBytesProcessed;
        return self();
      }

      Builder setTotalPartitionsProcessed(Long totalPartitionsProcessed) {
        this.totalPartitionsProcessed = totalPartitionsProcessed;
        return self();
      }

      Builder setTotalSlotMs(Long totalSlotMs) {
        this.totalSlotMs = totalSlotMs;
        return self();
      }

      Builder setQueryPlan(List<QueryStage> queryPlan) {
        this.queryPlan = queryPlan;
        return self();
      }

      Builder setTimeline(List<TimelineSample> timeline) {
        this.timeline = timeline;
        return self();
      }

      Builder setSchema(Schema schema) {
        this.schema = schema;
        return self();
      }

      @Override
      QueryStatistics build() {
        return new QueryStatistics(this);
      }
    }

    private QueryStatistics(Builder builder) {
      super(builder);
      this.billingTier = builder.billingTier;
      this.cacheHit = builder.cacheHit;
      this.ddlOperationPerformed = builder.ddlOperationPerformed;
      this.ddlTargetTable = builder.ddlTargetTable;
      this.estimatedBytesProcessed = builder.estimatedBytesProcessed;
      this.numDmlAffectedRows = builder.numDmlAffectedRows;
      this.referencedTables = builder.referencedTables;
      this.statementType = builder.statementType;
      this.totalBytesBilled = builder.totalBytesBilled;
      this.totalBytesProcessed = builder.totalBytesProcessed;
      this.totalPartitionsProcessed = builder.totalPartitionsProcessed;
      this.totalSlotMs = builder.totalSlotMs;
      this.queryPlan = builder.queryPlan;
      this.timeline = builder.timeline;
      this.schema = builder.schema;
    }


    /**
     * Returns the billing tier for the job.
     */
    public Integer getBillingTier() {
      return billingTier;
    }


    /**
     * Returns whether the query result was fetched from the query cache.
     *
     * @see <a href="https://cloud.google.com/bigquery/querying-data#querycaching">
     *     Query Caching</a>
     */
    public Boolean getCacheHit() {
      return cacheHit;
    }

    /**
     * [BETA] For DDL queries, returns the operation applied to the DDL target table.
     */
    public String getDdlOperationPerformed() { return ddlOperationPerformed; }

    /**
     * [BETA] For DDL queries, returns the TableID of the targeted table.
     */
    public TableId getDdlTargetTable() { return ddlTargetTable; }

    /**
     * The original estimate of bytes processed for the job.
     */
    public Long getEstimatedBytesProcessed() { return estimatedBytesProcessed; }

    /**
     * The number of rows affected by a DML statement.
     * Present only for DML statements INSERT, UPDATE or DELETE.
     */
    public Long getNumDmlAffectedRows() { return numDmlAffectedRows; }

    /**
     * Referenced tables for the job.
     * Queries that reference more than 50 tables will not have a complete list.
     */
    public List<TableId> getReferencedTables() { return referencedTables; }

    /**
     * [BETA] The type of query statement, if valid.
     * Possible values include:
     * SELECT
     * INSERT
     * UPDATE
     * DELETE
     * CREATE_TABLE
     * CREATE_TABLE_AS_SELECT
     * DROP_TABLE
     * CREATE_VIEW
     * DROP_VIEW
     */
    public StatementType getStatementType() { return statementType; }

    /**
     * Returns the total number of bytes billed for the job.
     */
    public Long getTotalBytesBilled() {
      return totalBytesBilled;
    }


    /**
     * Returns the total number of bytes processed by the job.
     */
    public Long getTotalBytesProcessed() {
      return totalBytesProcessed;
    }

    /**
     * Total number of partitions processed from all partitioned tables referenced in the job.
     */
    public Long getTotalPartitionsProcessed() { return totalPartitionsProcessed; }

    /**
     * Returns the slot-milliseconds consumed by the query.
     */
    public Long getTotalSlotMs() { return totalSlotMs; }

    /**
     * Returns the query plan as a list of stages or {@code null} if a query plan is not available.
     * Each stage involves a number of steps that read from data sources, perform a series of
     * transformations on the input, and emit an output to a future stage (or the final result). The
     * query plan is available for a completed query job and is retained for 7 days.
     *
     * @see <a href="https://cloud.google.com/bigquery/query-plan-explanation">Query Plan</a>
     */
    public List<QueryStage> getQueryPlan() {
      return queryPlan;
    }

    /**
     * Return the timeline for the query, as a list of timeline samples.  Each sample provides
     * information about the overall progress of the query.  Information includes time of the
     * sample, progress reporting on active, completed, and
     * pending units of work, as well as the cumulative estimation of slot-milliseconds consumed
     * by the query.
     */
    public List<TimelineSample> getTimeline() { return timeline; }

    /**
     * Returns the schema for the query result. Present only for successful dry run of
     * non-legacy SQL queries.
     */
    public Schema getSchema() {
      return schema;
    }

    @Override
    ToStringHelper toStringHelper() {
      return super.toStringHelper()
          .add("billingTier", billingTier)
          .add("cacheHit", cacheHit)
          .add("totalBytesBilled", totalBytesBilled)
          .add("totalBytesProcessed", totalBytesProcessed)
          .add("queryPlan", queryPlan)
          .add("timeline", timeline)
          .add("schema", schema);
    }

    @Override
    public final boolean equals(Object obj) {
      return obj == this
          || obj != null
          && obj.getClass().equals(QueryStatistics.class)
          && baseEquals((QueryStatistics) obj);
    }

    @Override
    public final int hashCode() {
      return Objects.hash(baseHashCode(), billingTier, cacheHit, totalBytesBilled,
          totalBytesProcessed, queryPlan, schema);
    }

    @Override
    com.google.api.services.bigquery.model.JobStatistics toPb() {
      JobStatistics2 queryStatisticsPb = new JobStatistics2();
      queryStatisticsPb.setBillingTier(billingTier);
      queryStatisticsPb.setCacheHit(cacheHit);
      queryStatisticsPb.setDdlOperationPerformed(ddlOperationPerformed);
      queryStatisticsPb.setEstimatedBytesProcessed(estimatedBytesProcessed);
      queryStatisticsPb.setTotalBytesBilled(totalBytesBilled);
      queryStatisticsPb.setTotalBytesProcessed(totalBytesProcessed);
      queryStatisticsPb.setTotalPartitionsProcessed(totalPartitionsProcessed);
      queryStatisticsPb.setTotalSlotMs(totalSlotMs);
      if (ddlTargetTable != null) {
        queryStatisticsPb.setDdlTargetTable(ddlTargetTable.toPb());
      }

      if (referencedTables != null) {
        queryStatisticsPb.setReferencedTables(Lists.transform(referencedTables, TableId.TO_PB_FUNCTION));
      }
      if (statementType != null) {
        queryStatisticsPb.setStatementType(statementType.toString());
      }
      if (queryPlan != null) {
        queryStatisticsPb.setQueryPlan(Lists.transform(queryPlan, QueryStage.TO_PB_FUNCTION));
      }
      if (timeline != null) {
        queryStatisticsPb.setTimeline(Lists.transform(timeline, TimelineSample.TO_PB_FUNCTION));
      }
      if (schema != null) {
        queryStatisticsPb.setSchema(schema.toPb());
      }
      return super.toPb().setQuery(queryStatisticsPb);
    }

    static Builder newBuilder() {
      return new Builder();
    }

    @SuppressWarnings("unchecked")
    static QueryStatistics fromPb(
        com.google.api.services.bigquery.model.JobStatistics statisticPb) {
      return new Builder(statisticPb).build();
    }
  }

  abstract static class Builder<T extends JobStatistics, B extends Builder<T, B>> {

    private Long creationTime;
    private Long endTime;
    private Long startTime;

    protected Builder() {}

    protected Builder(com.google.api.services.bigquery.model.JobStatistics statisticsPb) {
      this.creationTime = statisticsPb.getCreationTime();
      this.endTime = statisticsPb.getEndTime();
      this.startTime = statisticsPb.getStartTime();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    B setCreationTimestamp(Long creationTime) {
      this.creationTime = creationTime;
      return self();
    }

    B setEndTime(Long endTime) {
      this.endTime = endTime;
      return self();
    }

    B setStartTime(Long startTime) {
      this.startTime = startTime;
      return self();
    }

    abstract T build();
  }

  protected JobStatistics(Builder builder) {
    this.creationTime = builder.creationTime;
    this.endTime = builder.endTime;
    this.startTime = builder.startTime;
  }


  /**
   * Returns the creation time of the job in milliseconds since epoch.
   */
  public Long getCreationTime() {
    return creationTime;
  }


  /**
   * Returns the end time of the job in milliseconds since epoch. Returns {@code null} if the
   * job has not finished yet.
   */
  public Long getEndTime() {
    return endTime;
  }


  /**
   * Returns the start time of the job in milliseconds since epoch. Returns {@code null} if the
   * job has not started yet.
   */
  public Long getStartTime() {
    return startTime;
  }

  ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this)
        .add("creationTime", creationTime)
        .add("endTime", endTime)
        .add("startTime", startTime);
  }

  @Override
  public String toString() {
    return toStringHelper().toString();
  }

  final int baseHashCode() {
    return Objects.hash(creationTime, endTime, startTime);
  }

  final boolean baseEquals(JobStatistics jobStatistics) {
    return Objects.equals(toPb(), jobStatistics.toPb());
  }

  com.google.api.services.bigquery.model.JobStatistics toPb() {
    com.google.api.services.bigquery.model.JobStatistics statistics =
        new com.google.api.services.bigquery.model.JobStatistics();
    statistics.setCreationTime(creationTime);
    statistics.setEndTime(endTime);
    statistics.setStartTime(startTime);
    return statistics;
  }

  @SuppressWarnings("unchecked")
  static <T extends JobStatistics> T fromPb(com.google.api.services.bigquery.model.Job jobPb) {
    JobConfiguration jobConfigPb = jobPb.getConfiguration();
    com.google.api.services.bigquery.model.JobStatistics statisticPb = jobPb.getStatistics();
    if (jobConfigPb.getLoad() != null) {
      return (T) LoadStatistics.fromPb(statisticPb);
    } else if (jobConfigPb.getExtract() != null) {
      return (T) ExtractStatistics.fromPb(statisticPb);
    } else if (jobConfigPb.getQuery() != null) {
      return (T) QueryStatistics.fromPb(statisticPb);
    } else if (jobConfigPb.getCopy() != null) {
      return (T) CopyStatistics.fromPb(statisticPb);
    } else {
      throw new IllegalArgumentException("unknown job configuration: " + jobConfigPb);
    }
  }
}
