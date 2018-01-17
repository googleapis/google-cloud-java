/*
 * Copyright 2015 Google LLC
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

import com.google.api.services.bigquery.model.ExplainQueryStage;
import com.google.api.services.bigquery.model.ExplainQueryStep;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * BigQuery provides diagnostic information about a completed query's execution plan (or query plan
 * for short). The query plan describes a query as a series of stages, with each stage comprising a
 * number of steps that read from data sources, perform a series of transformations on the input,
 * and emit an output to a future stage (or the final result). This class contains information on a
 * query stage.
 *
 * @see <a href="https://cloud.google.com/bigquery/query-plan-explanation">Query Plan</a>
 */
public class QueryStage implements Serializable {

  static final Function<ExplainQueryStage, QueryStage> FROM_PB_FUNCTION =
      new Function<ExplainQueryStage, QueryStage>() {
        @Override
        public QueryStage apply(ExplainQueryStage pb) {
          return QueryStage.fromPb(pb);
        }
      };
  static final Function<QueryStage, ExplainQueryStage> TO_PB_FUNCTION =
      new Function<QueryStage, ExplainQueryStage>() {
        @Override
        public ExplainQueryStage apply(QueryStage stage) {
          return stage.toPb();
        }
      };
  private static final long serialVersionUID = -472281297327952320L;

  /**
   * Each query stage is made of a number of steps. This class contains information on a query step.
   *
   * @see <a href="https://cloud.google.com/bigquery/query-plan-explanation#steps_metadata">Steps
   *     Metadata</a>
   */
  public static class QueryStep implements Serializable {

    static final Function<ExplainQueryStep, QueryStep> FROM_PB_FUNCTION =
        new Function<ExplainQueryStep, QueryStep>() {
          @Override
          public QueryStep apply(ExplainQueryStep pb) {
            return QueryStep.fromPb(pb);
          }
        };
    static final Function<QueryStep, ExplainQueryStep> TO_PB_FUNCTION =
        new Function<QueryStep, ExplainQueryStep>() {
          @Override
          public ExplainQueryStep apply(QueryStep stage) {
            return stage.toPb();
          }
        };
    private static final long serialVersionUID = 8663444604771794411L;

    private final String name;
    private final List<String> substeps;

    QueryStep(String name, List<String> substeps) {
      this.name = name;
      this.substeps = substeps;
    }


    /**
     * Returns a machine-readable name for the operation.
     *
     * @see <a href="https://cloud.google.com/bigquery/query-plan-explanation#steps_metadata">Steps
     *     Metadata</a>
     */
    public String getName() {
      return name;
    }


    /**
     * Returns a list of human-readable stage descriptions.
     */
    public List<String> getSubsteps() {
      return substeps;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("name", name)
          .add("substeps", substeps)
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, substeps);
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof QueryStep)) {
        return false;
      }
      QueryStep other = (QueryStep) obj;
      return Objects.equals(name, other.name) && Objects.equals(substeps, other.substeps);
    }

    ExplainQueryStep toPb() {
      return new ExplainQueryStep().setKind(name).setSubsteps(substeps);
    }

    static QueryStep fromPb(com.google.api.services.bigquery.model.ExplainQueryStep stepPb) {
      return new QueryStep(stepPb.getKind(), ImmutableList.copyOf(stepPb.getSubsteps() != null
          ? stepPb.getSubsteps() : ImmutableList.<String>of()));
    }
  }

  private final double computeRatioAvg;
  private final double computeRatioMax;
  private final long generatedId;
  private final String name;
  private final double readRatioAvg;
  private final double readRatioMax;
  private final long recordsRead;
  private final long recordsWritten;
  private final List<QueryStep> steps;
  private final double waitRatioAvg;
  private final double waitRatioMax;
  private final double writeRatioAvg;
  private final double writeRatioMax;

  static final class Builder {

    private double computeRatioAvg;
    private double computeRatioMax;
    private long generatedId;
    private String name;
    private double readRatioAvg;
    private double readRatioMax;
    private long recordsRead;
    private long recordsWritten;
    private List<QueryStep> steps;
    private double waitRatioAvg;
    private double waitRatioMax;
    private double writeRatioAvg;
    private double writeRatioMax;

    private Builder() {}

    Builder setComputeRationAvg(double computeRatioAvg) {
      this.computeRatioAvg = computeRatioAvg;
      return this;
    }

    Builder setComputeRatioMax(double computeRatioMax) {
      this.computeRatioMax = computeRatioMax;
      return this;
    }

    Builder setGeneratedId(long generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    Builder setName(String name) {
      this.name = name;
      return this;
    }

    Builder setReadRatioAvg(double readRatioAvg) {
      this.readRatioAvg = readRatioAvg;
      return this;
    }

    Builder setReadRatioMax(double readRatioMax) {
      this.readRatioMax = readRatioMax;
      return this;
    }

    Builder setRecordsRead(long recordsRead) {
      this.recordsRead = recordsRead;
      return this;
    }

    Builder setRecordsWritten(long recordsWritten) {
      this.recordsWritten = recordsWritten;
      return this;
    }

    Builder setSteps(List<QueryStep> steps) {
      this.steps = steps;
      return this;
    }

    Builder setWaitRatioAvg(double waitRatioAvg) {
      this.waitRatioAvg = waitRatioAvg;
      return this;
    }

    Builder setWaitRatioMax(double waitRatioMax) {
      this.waitRatioMax = waitRatioMax;
      return this;
    }

    Builder setWriteRatioAvg(double writeRatioAvg) {
      this.writeRatioAvg = writeRatioAvg;
      return this;
    }

    Builder setWriteRatioMax(double writeRatioMax) {
      this.writeRatioMax = writeRatioMax;
      return this;
    }

    QueryStage build() {
      return new QueryStage(this);
    }
  }

  QueryStage(Builder builder) {
    computeRatioAvg = builder.computeRatioAvg;
    computeRatioMax = builder.computeRatioMax;
    generatedId = builder.generatedId;
    name = builder.name;
    readRatioAvg = builder.readRatioAvg;
    readRatioMax = builder.readRatioMax;
    recordsRead = builder.recordsRead;
    recordsWritten = builder.recordsWritten;
    steps = builder.steps;
    waitRatioAvg = builder.waitRatioAvg;
    waitRatioMax = builder.waitRatioMax;
    writeRatioAvg = builder.writeRatioAvg;
    writeRatioMax = builder.writeRatioMax;
  }


  /**
   * Returns the time the average worker spent CPU-bound, divided by the longest time spent by any
   * worker in any segment.
   */
  public double getComputeRatioAvg() {
    return computeRatioAvg;
  }


  /**
   * Returns the time the slowest worker spent CPU-bound, divided by the longest time spent by any
   * worker in any segment.
   */
  public double getComputeRatioMax() {
    return computeRatioMax;
  }


  /**
   * Returns a unique, server-generated ID for the stage within its plan.
   */
  public long getGeneratedId() {
    return generatedId;
  }


  /**
   * Returns a human-readable name for the stage.
   */
  public String getName() {
    return name;
  }


  /**
   * Returns the time the average worker spent reading input data, divided by the longest time spent
   * by any worker in any segment.
   */
  public double getReadRatioAvg() {
    return readRatioAvg;
  }


  /**
   * Returns the time the slowest worker spent reading input data, divided by the longest time spent
   * by any worker in any segment.
   */
  public double getReadRatioMax() {
    return readRatioMax;
  }


  /**
   * Returns the number of rows (top-level records) read by the stage.
   */
  public long getRecordsRead() {
    return recordsRead;
  }


  /**
   * Returns the number of rows (top-level records) written by the stage.
   */
  public long getRecordsWritten() {
    return recordsWritten;
  }


  /**
   * Returns the list of steps within the stage in dependency order (approximately chronological).
   */
  public List<QueryStep> getSteps() {
    return steps;
  }


  /**
   * Returns the time the average worker spent waiting to be scheduled, divided by the longest time
   * spent by any worker in any segment.
   */
  public double getWaitRatioAvg() {
    return waitRatioAvg;
  }


  /**
   * Returns the time the slowest worker spent waiting to be scheduled, divided by the longest time
   * spent by any worker in any segment.
   */
  public double getWaitRatioMax() {
    return waitRatioMax;
  }


  /**
   * Returns the time the average worker spent writing output data, divided by the longest time
   * spent by any worker in any segment.
   */
  public double getWriteRatioAvg() {
    return writeRatioAvg;
  }


  /**
   * Returns the time the slowest worker spent writing output data, divided by the longest time
   * spent by any worker in any segment.
   */
  public double getWriteRatioMax() {
    return writeRatioMax;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("computeRatioAvg", computeRatioAvg)
        .add("computeRatioMax", computeRatioMax)
        .add("generatedId", generatedId)
        .add("name", name)
        .add("readRatioAvg", readRatioAvg)
        .add("readRatioMax", readRatioMax)
        .add("recordsRead", recordsRead)
        .add("recordsWritten", recordsWritten)
        .add("steps", steps)
        .add("waitRatioAvg", waitRatioAvg)
        .add("waitRatioMax", waitRatioMax)
        .add("writeRatioAvg", writeRatioAvg)
        .add("writeRatioMax", writeRatioMax)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(computeRatioAvg, computeRatioMax, generatedId, name, readRatioAvg,
        readRatioMax, recordsRead, recordsWritten, steps, waitRatioAvg, waitRatioMax,
        writeRatioAvg);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(QueryStage.class)) {
      return false;
    }
    QueryStage other = (QueryStage) obj;
    return generatedId == other.generatedId
        && computeRatioAvg == other.computeRatioAvg
        && computeRatioMax == other.computeRatioMax
        && readRatioAvg == other.readRatioAvg
        && readRatioMax == other.readRatioMax
        && recordsRead == other.recordsRead
        && recordsWritten == other.recordsWritten
        && waitRatioAvg == other.waitRatioAvg
        && waitRatioMax == other.waitRatioMax
        && writeRatioAvg == other.writeRatioAvg
        && writeRatioMax == other.writeRatioMax
        && Objects.equals(steps, other.steps)
        && Objects.equals(name, other.name);
  }

  static Builder newBuilder() {
    return new Builder();
  }

  ExplainQueryStage toPb() {
    ExplainQueryStage stagePb = new ExplainQueryStage()
        .setComputeRatioAvg(computeRatioAvg)
        .setComputeRatioMax(computeRatioMax)
        .setId(generatedId)
        .setName(name)
        .setReadRatioAvg(readRatioAvg)
        .setReadRatioMax(readRatioMax)
        .setRecordsRead(recordsRead)
        .setRecordsWritten(recordsWritten)
        .setWaitRatioAvg(waitRatioAvg)
        .setWaitRatioMax(waitRatioMax)
        .setWriteRatioAvg(writeRatioAvg)
        .setWriteRatioMax(writeRatioMax);
    if (steps != null) {
      stagePb.setSteps(Lists.transform(steps, QueryStep.TO_PB_FUNCTION));
    }
    return stagePb;
  }

  static QueryStage fromPb(com.google.api.services.bigquery.model.ExplainQueryStage stagePb) {
    Builder builder = new QueryStage.Builder();
    builder.setComputeRationAvg(stagePb.getComputeRatioAvg());
    builder.setComputeRatioMax(stagePb.getComputeRatioMax());
    builder.setGeneratedId(stagePb.getId());
    builder.setName(stagePb.getName());
    builder.setReadRatioAvg(stagePb.getReadRatioAvg());
    builder.setReadRatioMax(stagePb.getReadRatioMax());
    builder.setRecordsRead(stagePb.getRecordsRead());
    builder.setRecordsWritten(stagePb.getRecordsWritten());
    if (stagePb.getSteps() != null) {
      builder.setSteps(Lists.transform(stagePb.getSteps(), QueryStep.FROM_PB_FUNCTION));
    }
    builder.setWaitRatioAvg(stagePb.getWaitRatioAvg());
    builder.setWaitRatioMax(stagePb.getWaitRatioMax());
    builder.setWriteRatioAvg(stagePb.getWriteRatioAvg());
    builder.setWriteRatioMax(stagePb.getWriteRatioMax());
    return builder.build();
  }
}
