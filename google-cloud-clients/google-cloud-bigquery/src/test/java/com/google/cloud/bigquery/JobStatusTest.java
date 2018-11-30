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

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class JobStatusTest {

  private static final JobStatus.State STATE = JobStatus.State.DONE;
  private static final BigQueryError ERROR =
      new BigQueryError("reason", "location", "message", "debugInfo");
  private static final List<BigQueryError> ALL_ERRORS =
      ImmutableList.of(
          new BigQueryError("reason1", "location1", "message1", "debugInfo1"),
          new BigQueryError("reason2", "location2", "message2", "debugInfo2"));
  private static final JobStatus JOB_STATUS = new JobStatus(STATE, ERROR, ALL_ERRORS);
  private static final JobStatus JOB_STATUS_INCOMPLETE1 = new JobStatus(STATE, ERROR, null);
  private static final JobStatus JOB_STATUS_INCOMPLETE2 = new JobStatus(STATE, null, null);

  @Test
  public void testConstructor() {
    assertEquals(STATE, JOB_STATUS.getState());
    assertEquals(ERROR, JOB_STATUS.getError());
    assertEquals(ALL_ERRORS, JOB_STATUS.getExecutionErrors());

    assertEquals(STATE, JOB_STATUS_INCOMPLETE1.getState());
    assertEquals(ERROR, JOB_STATUS_INCOMPLETE1.getError());
    assertEquals(null, JOB_STATUS_INCOMPLETE1.getExecutionErrors());

    assertEquals(STATE, JOB_STATUS_INCOMPLETE2.getState());
    assertEquals(null, JOB_STATUS_INCOMPLETE2.getError());
    assertEquals(null, JOB_STATUS_INCOMPLETE2.getExecutionErrors());
  }

  @Test
  public void testToPbAndFromPb() {
    compareStatus(JOB_STATUS, JobStatus.fromPb(JOB_STATUS.toPb()));
    compareStatus(JOB_STATUS_INCOMPLETE1, JobStatus.fromPb(JOB_STATUS_INCOMPLETE1.toPb()));
    compareStatus(JOB_STATUS_INCOMPLETE2, JobStatus.fromPb(JOB_STATUS_INCOMPLETE2.toPb()));
  }

  private void compareStatus(JobStatus expected, JobStatus value) {
    assertEquals(expected, value);
    assertEquals(expected.getState(), value.getState());
    assertEquals(expected.getError(), value.getError());
    assertEquals(expected.getExecutionErrors(), value.getExecutionErrors());
  }
}
