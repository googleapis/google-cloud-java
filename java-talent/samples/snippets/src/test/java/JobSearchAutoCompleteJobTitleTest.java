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

import com.example.jobs.JobSearchAutoCompleteJobTitle;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JobSearchAutoCompleteJobTitleTest {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String TENANT_ID = System.getenv("CTS_TENANT_ID");

  private ByteArrayOutputStream bout;
  private PrintStream out;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = System.out;
    System.setOut(new PrintStream(bout));
  }

  @Test
  public void testAutoCompleteJobTitle() throws IOException {
    // retrieve a tenant.
    JobSearchAutoCompleteJobTitle.completeQuery(PROJECT_ID, TENANT_ID, "Developer Program");
    String got = bout.toString();
    assertThat(got).contains("Suggested title:");
    assertThat(got).contains("Suggestion type:");
  }

  @After
  public void tearDown() {
    System.setOut(out);
  }
}
