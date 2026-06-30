/*
 * Copyright 2026 Google LLC
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

import javax.annotation.Nullable;

/**
 * Maps to <a
 * href="https://docs.cloud.google.com/bigquery/docs/reference/rest/v2/JobCreationReason">JobCreationReason</a>
 * when used with {@link
 * com.google.cloud.bigquery.QueryJobConfiguration.JobCreationMode#JOB_CREATION_OPTIONAL}.
 *
 * <p>The code indicates the high level reason why a job was created. The default is `UNKNOWN` if
 * there is no mapping found between the server response and the client library.
 */
public class JobCreationReason {

  public enum Code {
    REQUESTED("REQUESTED"),
    LONG_RUNNING("LONG_RUNNING"),
    LARGE_RESULTS("LARGE_RESULTS"),
    OTHER("OTHER"),
    UNKNOWN("UNKNOWN");

    private final String reason;

    Code(String reason) {
      this.reason = reason;
    }

    /**
     * Maps the server code to BQ code. Returns {@link Code#UNKNOWN} if the mapping does not exist.
     */
    static Code fromValue(@Nullable String reason) {
      for (JobCreationReason.Code code : Code.values()) {
        if (code.reason.equals(reason)) {
          return code;
        }
      }
      return UNKNOWN;
    }
  }

  @Nullable private final Code code;

  JobCreationReason(Code code) {
    this.code = code;
  }

  static JobCreationReason fromPb(
      com.google.api.services.bigquery.model.JobCreationReason jobCreationReason) {
    // JobCreationReason may be null if the JobCreationMode is specified to be Optional
    // Note: JobCreationMode.Optional may also end up creating a job depending on the
    // query complexity and other factors.
    if (jobCreationReason == null) {
      return null;
    }
    return new JobCreationReason(Code.fromValue(jobCreationReason.getCode()));
  }

  /**
   * @return JobCreationReason code or {@link Code#UNKNOWN} if mapping does not exist.
   */
  public Code getCode() {
    return code;
  }
}
