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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JobIdTest {

  private static final JobId JOB = JobId.of("job");
  private static final JobId JOB_COMPLETE = JobId.of("project", "job");

  @Test
  void testOf() {
    assertEquals(null, JOB.getProject());
    assertEquals("job", JOB.getJob());
    assertEquals("project", JOB_COMPLETE.getProject());
    assertEquals("job", JOB_COMPLETE.getJob());
  }

  @Test
  void testEquals() {
    compareJobs(JOB, JobId.of("job"));
    compareJobs(JOB_COMPLETE, JobId.of("project", "job"));
  }

  @Test
  void testToPbAndFromPb() {
    compareJobs(JOB, JobId.fromPb(JOB.toPb()));
    compareJobs(JOB_COMPLETE, JobId.fromPb(JOB_COMPLETE.toPb()));
  }

  @Test
  void testSetProjectId() {
    assertEquals(JOB_COMPLETE, JOB.setProjectId("project"));
  }

  private void compareJobs(JobId expected, JobId value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.getProject(), value.getProject());
    assertEquals(expected.getJob(), value.getJob());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
