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
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

/**
 * A Google BigQuery Job status. Objects of this class can be examined when polling an asynchronous
 * job to see if the job completed.
 */
public class JobStatus implements Serializable {

  private static final long serialVersionUID = -714976456815445365L;

  /** Possible states that a BigQuery Job can assume. */
  public static final class State extends StringEnumValue {
    private static final long serialVersionUID = 818920627219751204L;

    private static final ApiFunction<String, State> CONSTRUCTOR =
        new ApiFunction<String, State>() {
          @Override
          public State apply(String constant) {
            return new State(constant);
          }
        };

    private static final StringEnumType<State> type = new StringEnumType(State.class, CONSTRUCTOR);

    /** The BigQuery Job is waiting to be executed. */
    public static final State PENDING = type.createAndRegister("PENDING");

    /** The BigQuery Job is being executed. */
    public static final State RUNNING = type.createAndRegister("RUNNING");

    /**
     * The BigQuery Job has completed either succeeding or failing. If failed {@link #getError()}
     * will be non-null.
     */
    public static final State DONE = type.createAndRegister("DONE");

    private State(String constant) {
      super(constant);
    }

    /**
     * Get the State for the given String constant, and throw an exception if the constant is not
     * recognized.
     */
    public static State valueOfStrict(String constant) {
      return type.valueOfStrict(constant);
    }

    /** Get the State for the given String constant, and allow unrecognized values. */
    public static State valueOf(String constant) {
      return type.valueOf(constant);
    }

    /** Return the known values for State. */
    public static State[] values() {
      return type.values();
    }
  }

  private final State state;
  private final BigQueryError error;
  private final List<BigQueryError> executionErrors;

  JobStatus(State state) {
    this.state = state;
    this.error = null;
    this.executionErrors = null;
  }

  JobStatus(State state, BigQueryError error, List<BigQueryError> executionErrors) {
    this.state = state;
    this.error = error;
    this.executionErrors = executionErrors != null ? ImmutableList.copyOf(executionErrors) : null;
  }

  /**
   * Returns the state of the job. A {@link State#PENDING} job is waiting to be executed. A {@link
   * State#RUNNING} is being executed. A {@link State#DONE} job has completed either succeeding or
   * failing. If failed {@link #getError()} will be non-null.
   */
  public State getState() {
    return state;
  }

  /**
   * Returns the final error result of the job. If present, indicates that the job has completed and
   * was unsuccessful.
   *
   * @see <a href="https://cloud.google.com/bigquery/troubleshooting-errors">Troubleshooting
   *     Errors</a>
   */
  @Nullable
  public BigQueryError getError() {
    return error;
  }

  /**
   * Returns all errors encountered during the running of the job. Errors here do not necessarily
   * mean that the job has completed or was unsuccessful.
   *
   * @see <a href="https://cloud.google.com/bigquery/troubleshooting-errors">Troubleshooting
   *     Errors</a>
   */
  public List<BigQueryError> getExecutionErrors() {
    return executionErrors;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("state", state)
        .add("error", error)
        .add("executionErrors", executionErrors)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(state, error, executionErrors);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(JobStatus.class)
            && Objects.equals(toPb(), ((JobStatus) obj).toPb());
  }

  com.google.api.services.bigquery.model.JobStatus toPb() {
    com.google.api.services.bigquery.model.JobStatus statusPb =
        new com.google.api.services.bigquery.model.JobStatus();
    if (state != null) {
      statusPb.setState(state.toString());
    }
    if (error != null) {
      statusPb.setErrorResult(error.toPb());
    }
    if (executionErrors != null) {
      statusPb.setErrors(Lists.transform(executionErrors, BigQueryError.TO_PB_FUNCTION));
    }
    return statusPb;
  }

  static JobStatus fromPb(com.google.api.services.bigquery.model.JobStatus statusPb) {
    List<BigQueryError> allErrors = null;
    if (statusPb.getErrors() != null) {
      allErrors = Lists.transform(statusPb.getErrors(), BigQueryError.FROM_PB_FUNCTION);
    }
    BigQueryError error =
        statusPb.getErrorResult() != null ? BigQueryError.fromPb(statusPb.getErrorResult()) : null;
    return new JobStatus(State.valueOf(statusPb.getState()), error, allErrors);
  }
}
