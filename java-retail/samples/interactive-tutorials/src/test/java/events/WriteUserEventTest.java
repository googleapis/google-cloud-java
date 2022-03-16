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
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WriteUserEventTest {

  private ByteArrayOutputStream bout;
  private PrintStream originalPrintStream;
  private PrintStream out;

  private String projectId;
  private String defaultCatalog;
  private String visitorId;

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
  public void setUp() throws IOException, InterruptedException, ExecutionException {
    projectId = System.getenv("PROJECT_ID");
    defaultCatalog =
        String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);
    visitorId = UUID.randomUUID().toString();

    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @Test
  public void testPurgeUserEvent() throws IOException {
    WriteUserEvent.writeUserEvent(defaultCatalog, visitorId);
    String got = bout.toString();

    assertThat(got).contains("Write user event request");
    assertThat(got).contains("Written user event");
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }
}
