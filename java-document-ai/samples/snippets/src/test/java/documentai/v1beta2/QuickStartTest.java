/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package documentai.v1beta2;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuickStartTest {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String INPUT_URI = "gs://cloud-samples-data/documentai/invoice.pdf";

  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static void requireEnvVar(String varName) {
    assertNotNull(
            String.format("Environment variable '%s' must be set to perform these tests.", varName),
            System.getenv(varName));
  }

  @Before
  public void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @Test
  public void testQuickStart() throws IOException {
    // parse a PDF document.
    QuickStart.quickStart(PROJECT_ID,"us", INPUT_URI);
    String got = bout.toString();

    assertThat(got).contains("Entity");
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }
}
