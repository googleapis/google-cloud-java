/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JobIdTest {

  private static final JobId JOB = JobId.of("job");
  private static final JobId JOB_COMPLETE = JobId.of("project", "job");

  @Test
  public void testOf() {
    assertEquals(null, JOB.project());
    assertEquals("job", JOB.job());
    assertEquals("project", JOB_COMPLETE.project());
    assertEquals("job", JOB_COMPLETE.job());
  }

  @Test
  public void testEquals() {
    compareJobs(JOB, JobId.of("job"));
    compareJobs(JOB_COMPLETE, JobId.of("project", "job"));
  }

  @Test
  public void testToPbAndFromPb() {
    compareJobs(JOB, JobId.fromPb(JOB.toPb()));
    compareJobs(JOB_COMPLETE, JobId.fromPb(JOB_COMPLETE.toPb()));
  }

  private void compareJobs(JobId expected, JobId value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.project(), value.project());
    assertEquals(expected.job(), value.job());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
