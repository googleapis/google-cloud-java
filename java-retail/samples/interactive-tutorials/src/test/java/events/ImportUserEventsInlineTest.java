/*
 * Copyright 2022 Google LLC
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

package events;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ImportUserEventsInlineTest {

  private String projectId;
  private String defaultCatalog;

  private ByteArrayOutputStream bout;
  private PrintStream originalPrintStream;
  private PrintStream out;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("PROJECT_ID");
  }

  @Before
  public void setUp() {
    projectId = System.getenv("PROJECT_ID");
    defaultCatalog =
        String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);

    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @Test
  public void testImportUserEventsInline()
      throws IOException, InterruptedException, ExecutionException {
    ImportUserEventsInline.importUserEventsFromInlineSource(defaultCatalog);
    String got = bout.toString();

    assertThat(got).contains("Import user events from inline source request");
    assertThat(got).contains("The operation was started");
    assertThat(got).contains("Number of successfully imported events");
    assertThat(got).contains("Number of failures during the importing");
    assertThat(got).contains("Operation result");
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }
}
