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

    /** Returns a list of human-readable stage descriptions. */
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
      return new QueryStep(
          stepPb.getKind(),
          ImmutableList.copyOf(
              stepPb.getSubsteps() != null ? stepPb.getSubsteps() : ImmutableList.<String>of()));
    }
  }

  private final long completedParallelInputs;
  private final long computeMsAvg;
  private final long computeMsMax;
  private final double computeRatioAvg;
  private final double computeRatioMax;
  private final long endMs;
  private final long generatedId;
  private final List<Long> inputStages;
  private final String name;
  private final long parallelInputs;
  private final long readMsAvg;
  private final long readMsMax;
  private final double readRatioAvg;
  private final double readRatioMax;
  private final long recordsRead;
  private final long recordsWritten;
  private final long shuffleOutputBytes;
  private final long shuffleOutputBytesSpilled;
  private final List<QueryStep> steps;
  private final long startMs;
  private String status;
  private final long waitMsAvg;
  private final long waitMsMax;
  private final double waitRatioAvg;
  private final double waitRatioMax;
  private final long writeMsAvg;
  private final long writeMsMax;
  private final double writeRatioAvg;
  private final double writeRatioMax;

  static final class Builder {

    private long completedParallelInputs;
    private long computeMsAvg;
    private long computeMsMax;
    private double computeRatioAvg;
    private double computeRatioMax;
    private long endMs;
    private long generatedId;
    private List<Long> inputStages;
    private String name;
    private long parallelInputs;
    private long readMsAvg;
    private long readMsMax;
    private double readRatioAvg;
    private double readRatioMax;
    private long recordsRead;
    private long recordsWritten;
    private long shuffleOutputBytes;
    private long shuffleOutputBytesSpilled;
    private long startMs;
    private String status;
    private List<QueryStep> steps;
    private long waitMsAvg;
    private long waitMsMax;
    private double waitRatioAvg;
    private double waitRatioMax;
    private long writeMsAvg;
    private long writeMsMax;
    private double writeRatioAvg;
    private double writeRatioMax;

    private Builder() {}

    Builder setCompletedParallelInputs(long completedParallelInputs) {
      this.completedParallelInputs = completedParallelInputs;
      return this;
    }

    Builder setComputeMsAvg(long computeMsAvg) {
      this.computeMsAvg = computeMsAvg;
      return this;
    }

    Builder setComputeMsMax(long computeMsMax) {
      this.computeMsMax = computeMsMax;
      return this;
    }

    Builder setComputeRatioAvg(double computeRatioAvg) {
      this.computeRatioAvg = computeRatioAvg;
      return this;
    }

    Builder setComputeRatioMax(double computeRatioMax) {
      this.computeRatioMax = computeRatioMax;
      return this;
    }

    Builder setEndMs(long endMs) {
      this.endMs = endMs;
      return this;
    }

    Builder setGeneratedId(long generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    Builder setInputStages(List<Long> inputStages) {
      this.inputStages = inputStages;
      return this;
    }

    Builder setName(String name) {
      this.name = name;
      return this;
    }

    Builder setParallelInputs(long parallelInputs) {
      this.parallelInputs = parallelInputs;
      return this;
    }

    Builder setReadMsAvg(long readMsAvg) {
      this.readMsAvg = readMsAvg;
      return this;
    }

    Builder setReadMsMax(long readMsMax) {
      this.readMsMax = readMsMax;
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

    Builder setShuffleOutputBytes(long shuffleOutputBytes) {
      this.shuffleOutputBytes = shuffleOutputBytes;
      return this;
    }

    Builder setShuffleOutputBytesSpilled(long shuffleOutputBytesSpilled) {
      this.shuffleOutputBytesSpilled = shuffleOutputBytesSpilled;
      return this;
    }

    Builder setStartMs(long startMs) {
      this.startMs = startMs;
      return this;
    }

    Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    Builder setSteps(List<QueryStep> steps) {
      this.steps = steps;
      return this;
    }

    Builder setWaitMsAvg(long waitMsAvg) {
      this.waitMsAvg = waitMsAvg;
      return this;
    }

    Builder setWaitMsMax(long waitMsMax) {
      this.waitMsMax = waitMsMax;
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

    Builder setWriteMsAvg(long writeMsAvg) {
      this.writeMsAvg = writeMsAvg;
      return this;
    }

    Builder setWriteMsMax(long writeMsMax) {
      this.writeMsMax = writeMsMax;
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
    completedParallelInputs = builder.completedParallelInputs;
    computeMsAvg = builder.computeMsAvg;
    computeMsMax = builder.computeMsMax;
    computeRatioAvg = builder.computeRatioAvg;
    computeRatioMax = builder.computeRatioMax;
    endMs = builder.endMs;
    generatedId = builder.generatedId;
    inputStages = builder.inputStages;
    name = builder.name;
    parallelInputs = builder.parallelInputs;
    readMsAvg = builder.readMsAvg;
    readMsMax = builder.readMsMax;
    readRatioAvg = builder.readRatioAvg;
    readRatioMax = builder.readRatioMax;
    recordsRead = builder.recordsRead;
    recordsWritten = builder.recordsWritten;
    shuffleOutputBytes = builder.shuffleOutputBytes;
    shuffleOutputBytesSpilled = builder.shuffleOutputBytesSpilled;
    startMs = builder.startMs;
    status = builder.status;
    steps = builder.steps;
    waitMsAvg = builder.waitMsAvg;
    waitMsMax = builder.waitMsMax;
    waitRatioAvg = builder.waitRatioAvg;
    waitRatioMax = builder.waitRatioMax;
    writeMsAvg = builder.writeMsAvg;
    writeMsMax = builder.writeMsMax;
    writeRatioAvg = builder.writeRatioAvg;
    writeRatioMax = builder.writeRatioMax;
  }

  /** Returns the number of parallel input segments completed. */
  public long getCompletedParallelInputs() {
    return completedParallelInputs;
  }

  /** Returns the time in milliseconds the average worker spent on CPU-bound tasks. */
  public long getComputeMsAvg() {
    return computeMsAvg;
  }

  /** Returns the time in milliseconds the slowest worker spent on CPU-bound tasks. */
  public long getComputeMsMax() {
    return computeMsMax;
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

  /** Returns the stage end time represented as milliseconds since epoch. */
  public long getEndMs() {
    return endMs;
  }

  /** Returns a unique, server-generated ID for the stage within its plan. */
  public long getGeneratedId() {
    return generatedId;
  }

  /** Returns a list of the stage IDs that are inputs to this stage. */
  public List<Long> getInputStages() {
    return inputStages;
  }

  /** Returns a human-readable name for the stage. */
  public String getName() {
    return name;
  }

  /** Returns the number of parallel input segments to be processed. */
  public long getParallelInputs() {
    return parallelInputs;
  }

  /** Returns the time in milliseconds the average worker spent reading input. */
  public long getReadMsAvg() {
    return readMsAvg;
  }

  /** Returns the time in milliseconds the slowest worker spent reading input. */
  public long getReadMsMax() {
    return readMsMax;
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

  /** Returns the number of rows (top-level records) read by the stage. */
  public long getRecordsRead() {
    return recordsRead;
  }

  /** Returns the number of rows (top-level records) written by the stage. */
  public long getRecordsWritten() {
    return recordsWritten;
  }

  /** Returns the total number of bytes written to shuffle. */
  public long getShuffleOutputBytes() {
    return shuffleOutputBytes;
  }

  /** Returns the total number of bytes writtedn to shuffle and spilled to disk. */
  public long getShuffleOutputBytesSpilled() {
    return shuffleOutputBytesSpilled;
  }

  /** Returns the stage start time represented as milliseconds since epoch. */
  public long getStartMs() {
    return startMs;
  }

  /** Returns the current status for the stage. */
  public String getStatus() {
    return status;
  }

  /**
   * Returns the list of steps within the stage in dependency order (approximately chronological).
   */
  public List<QueryStep> getSteps() {
    return steps;
  }

  /** Returns the time in milliseconds the average worker spent waiting to be scheduled. */
  public long getWaitMsAvg() {
    return waitMsAvg;
  }

  /** Returns the time in milliseconds the slowest worker spent waiting to be scheduled. */
  public long getWaitMsMax() {
    return waitMsMax;
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

  /** Returns the time in milliseconds the average worker spent writing output. */
  public long getWriteMsAvg() {
    return writeMsAvg;
  }

  /** Returns the time in milliseconds the slowest worker spent writing output. */
  public long getWriteMsMax() {
    return writeMsMax;
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
        .add("completedParallelInputs", completedParallelInputs)
        .add("computeMsAvg", computeMsAvg)
        .add("computeMsMax", computeMsMax)
        .add("computeRatioAvg", computeRatioAvg)
        .add("computeRatioMax", computeRatioMax)
        .add("endMs", endMs)
        .add("generatedId", generatedId)
        .add("inputStages", inputStages)
        .add("name", name)
        .add("parallelInputs", parallelInputs)
        .add("readMsAvg", readMsAvg)
        .add("readMsMax", readMsMax)
        .add("readRatioAvg", readRatioAvg)
        .add("readRatioMax", readRatioMax)
        .add("recordsRead", recordsRead)
        .add("recordsWritten", recordsWritten)
        .add("shuffleOutputBytes", shuffleOutputBytes)
        .add("shuffleOutputBytesSpilled", shuffleOutputBytesSpilled)
        .add("startMs", startMs)
        .add("status", status)
        .add("steps", steps)
        .add("waitMsAvg", waitMsAvg)
        .add("waitMsMax", waitMsMax)
        .add("waitRatioAvg", waitRatioAvg)
        .add("waitRatioMax", waitRatioMax)
        .add("writeMsAvg", writeMsAvg)
        .add("writeMsMax", writeMsMax)
        .add("writeRatioAvg", writeRatioAvg)
        .add("writeRatioMax", writeRatioMax)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(
        completedParallelInputs,
        computeMsAvg,
        computeMsMax,
        computeRatioAvg,
        computeRatioMax,
        endMs,
        generatedId,
        inputStages,
        name,
        parallelInputs,
        readMsAvg,
        readMsMax,
        readRatioAvg,
        readRatioMax,
        recordsRead,
        recordsWritten,
        shuffleOutputBytes,
        shuffleOutputBytesSpilled,
        startMs,
        status,
        steps,
        waitMsAvg,
        waitMsMax,
        waitRatioAvg,
        waitRatioMax,
        writeMsAvg,
        writeMsMax,
        writeRatioAvg,
        writeRatioMax);
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
        && completedParallelInputs == other.completedParallelInputs
        && computeMsAvg == other.computeMsAvg
        && computeMsMax == other.computeMsMax
        && computeRatioAvg == other.computeRatioAvg
        && computeRatioMax == other.computeRatioMax
        && endMs == other.endMs
        && parallelInputs == other.parallelInputs
        && readMsAvg == other.readMsAvg
        && readMsMax == other.readMsMax
        && readRatioAvg == other.readRatioAvg
        && readRatioMax == other.readRatioMax
        && recordsRead == other.recordsRead
        && recordsWritten == other.recordsWritten
        && shuffleOutputBytes == other.shuffleOutputBytes
        && shuffleOutputBytesSpilled == other.shuffleOutputBytesSpilled
        && startMs == other.startMs
        && waitMsAvg == other.waitMsAvg
        && waitMsMax == other.waitMsMax
        && waitRatioAvg == other.waitRatioAvg
        && waitRatioMax == other.waitRatioMax
        && writeMsAvg == other.writeMsAvg
        && writeMsMax == other.writeMsMax
        && writeRatioAvg == other.writeRatioAvg
        && writeRatioMax == other.writeRatioMax
        && Objects.equals(steps, other.steps)
        && Objects.equals(name, other.name)
        && Objects.equals(status, other.status)
        && Objects.equals(inputStages, other.inputStages);
  }

  static Builder newBuilder() {
    return new Builder();
  }

  ExplainQueryStage toPb() {
    ExplainQueryStage stagePb =
        new ExplainQueryStage()
            .setCompletedParallelInputs(completedParallelInputs)
            .setComputeMsAvg(computeMsAvg)
            .setComputeMsMax(computeMsMax)
            .setComputeRatioAvg(computeRatioAvg)
            .setComputeRatioMax(computeRatioMax)
            .setEndMs(endMs)
            .setId(generatedId)
            .setInputStages(inputStages)
            .setName(name)
            .setParallelInputs(parallelInputs)
            .setReadMsAvg(readMsAvg)
            .setReadMsMax(readMsMax)
            .setReadRatioAvg(readRatioAvg)
            .setReadRatioMax(readRatioMax)
            .setRecordsRead(recordsRead)
            .setRecordsWritten(recordsWritten)
            .setShuffleOutputBytes(shuffleOutputBytes)
            .setShuffleOutputBytesSpilled(shuffleOutputBytesSpilled)
            .setStartMs(startMs)
            .setStatus(status)
            .setWaitMsAvg(waitMsAvg)
            .setWaitMsMax(waitMsMax)
            .setWaitRatioAvg(waitRatioAvg)
            .setWaitRatioMax(waitRatioMax)
            .setWriteMsAvg(writeMsAvg)
            .setWriteMsMax(writeMsMax)
            .setWriteRatioAvg(writeRatioAvg)
            .setWriteRatioMax(writeRatioMax);
    if (steps != null) {
      stagePb.setSteps(Lists.transform(steps, QueryStep.TO_PB_FUNCTION));
    }
    return stagePb;
  }

  static QueryStage fromPb(com.google.api.services.bigquery.model.ExplainQueryStage stagePb) {
    Builder builder = new QueryStage.Builder();
    builder.setCompletedParallelInputs(stagePb.getCompletedParallelInputs());
    builder.setComputeMsAvg(stagePb.getComputeMsAvg());
    builder.setComputeMsMax(stagePb.getComputeMsMax());
    builder.setComputeRatioAvg(stagePb.getComputeRatioAvg());
    builder.setComputeRatioMax(stagePb.getComputeRatioMax());
    builder.setEndMs(stagePb.getEndMs());
    builder.setGeneratedId(stagePb.getId());
    builder.setInputStages(stagePb.getInputStages());
    builder.setName(stagePb.getName());
    builder.setParallelInputs(stagePb.getParallelInputs());
    builder.setReadMsAvg(stagePb.getReadMsAvg());
    builder.setReadMsMax(stagePb.getReadMsMax());
    builder.setReadRatioAvg(stagePb.getReadRatioAvg());
    builder.setReadRatioMax(stagePb.getReadRatioMax());
    builder.setRecordsRead(stagePb.getRecordsRead());
    builder.setRecordsWritten(stagePb.getRecordsWritten());
    builder.setShuffleOutputBytes(stagePb.getShuffleOutputBytes());
    builder.setShuffleOutputBytesSpilled(stagePb.getShuffleOutputBytesSpilled());
    builder.setStartMs(stagePb.getStartMs());
    builder.setStatus(stagePb.getStatus());
    if (stagePb.getSteps() != null) {
      builder.setSteps(Lists.transform(stagePb.getSteps(), QueryStep.FROM_PB_FUNCTION));
    }
    builder.setWaitMsAvg(stagePb.getWaitMsAvg());
    builder.setWaitMsMax(stagePb.getWaitMsMax());
    builder.setWaitRatioAvg(stagePb.getWaitRatioAvg());
    builder.setWaitRatioMax(stagePb.getWaitRatioMax());
    builder.setWriteMsAvg(stagePb.getWriteMsAvg());
    builder.setWriteMsMax(stagePb.getWriteMsMax());
    builder.setWriteRatioAvg(stagePb.getWriteRatioAvg());
    builder.setWriteRatioMax(stagePb.getWriteRatioMax());
    return builder.build();
  }
}
