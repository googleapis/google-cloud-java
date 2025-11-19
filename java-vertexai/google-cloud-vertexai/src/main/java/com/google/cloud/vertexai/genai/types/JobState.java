/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Auto-generated code. Do not edit.

package com.google.cloud.vertexai.genai.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.Ascii;
import java.util.Objects;

/** Output only. The detailed state of the job. */
public class JobState {

  /** Enum representing the known values for JobState. */
  public enum Known {
    /** The job state is unspecified. */
    JOB_STATE_UNSPECIFIED,

    /** The job has been just created or resumed and processing has not yet begun. */
    JOB_STATE_QUEUED,

    /** The service is preparing to run the job. */
    JOB_STATE_PENDING,

    /** The job is in progress. */
    JOB_STATE_RUNNING,

    /** The job completed successfully. */
    JOB_STATE_SUCCEEDED,

    /** The job failed. */
    JOB_STATE_FAILED,

    /**
     * The job is being cancelled. From this state the job may only go to either
     * `JOB_STATE_SUCCEEDED`, `JOB_STATE_FAILED` or `JOB_STATE_CANCELLED`.
     */
    JOB_STATE_CANCELLING,

    /** The job has been cancelled. */
    JOB_STATE_CANCELLED,

    /** The job has been stopped, and can be resumed. */
    JOB_STATE_PAUSED,

    /** The job has expired. */
    JOB_STATE_EXPIRED,

    /**
     * The job is being updated. Only jobs in the `RUNNING` state can be updated. After updating,
     * the job goes back to the `RUNNING` state.
     */
    JOB_STATE_UPDATING,

    /** The job is partially succeeded, some results may be missing due to errors. */
    JOB_STATE_PARTIALLY_SUCCEEDED
  }

  private Known jobStateEnum;
  private final String value;

  @JsonCreator
  public JobState(String value) {
    this.value = value;
    for (Known jobStateEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(jobStateEnum.toString(), value)) {
        this.jobStateEnum = jobStateEnum;
        break;
      }
    }
    if (this.jobStateEnum == null) {
      this.jobStateEnum = Known.JOB_STATE_UNSPECIFIED;
    }
  }

  public JobState(Known knownValue) {
    this.jobStateEnum = knownValue;
    this.value = knownValue.toString();
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  @JsonValue
  public String toString() {
    return this.value;
  }

  @ExcludeFromGeneratedCoverageReport
  @SuppressWarnings("PatternMatchingInstanceof")
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }

    if (!(o instanceof JobState)) {
      return false;
    }

    JobState other = (JobState) o;

    if (this.jobStateEnum != Known.JOB_STATE_UNSPECIFIED
        && other.jobStateEnum != Known.JOB_STATE_UNSPECIFIED) {
      return this.jobStateEnum == other.jobStateEnum;
    } else if (this.jobStateEnum == Known.JOB_STATE_UNSPECIFIED
        && other.jobStateEnum == Known.JOB_STATE_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.jobStateEnum != Known.JOB_STATE_UNSPECIFIED) {
      return this.jobStateEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.jobStateEnum;
  }
}
