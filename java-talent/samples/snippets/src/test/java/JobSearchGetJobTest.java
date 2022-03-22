/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import static com.google.common.truth.Truth.assertThat;

import com.example.jobs.JobSearchGetJob;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JobSearchGetJobTest {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String TENANT_ID = System.getenv("CTS_TENANT_ID");
  private static final String JOB_ID = System.getenv("CTS_GET_JOB_ID");

  private ByteArrayOutputStream bout;
  private PrintStream out;

  @Before
  public void setUp() throws IOException {
    bout = new ByteArrayOutputStream();
    out = System.out;
    System.setOut(new PrintStream(bout));
  }

  @Test
  public void testGetJob() throws IOException {
    // retrieve a job.
    JobSearchGetJob.getJob(PROJECT_ID, TENANT_ID, JOB_ID);
    String got = bout.toString();
    assertThat(got).contains("Job name: ");
    assertThat(got).contains("Website:");
  }

  @After
  public void tearDown() {
    System.setOut(out);
  }

  // Helper method for getting the last id from the full path.
  public static String extractLastId(String fullPath) {
    if (fullPath == null || fullPath.length() < 1 || !fullPath.contains("/")) {
      throw new IllegalArgumentException("Not valid path");
    }
    String[] parts = fullPath.split("/");
    return parts[parts.length - 1];
  }
}
