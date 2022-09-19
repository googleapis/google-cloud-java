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

import com.google.cloud.ServiceOptions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ImportUserEventsInlineTest {

  private ByteArrayOutputStream bout;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() throws IOException, ExecutionException, InterruptedException {
    String projectId = ServiceOptions.getDefaultProjectId();
    String defaultCatalog =
        String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);
    bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    ImportUserEventsInline.importUserEventsFromInlineSource(defaultCatalog);
  }

  @Test
  public void testImportUserEventsInline() {
    String outputResult = bout.toString();

    assertThat(outputResult).contains("Import user events from inline source request");
    assertThat(outputResult).contains("The operation was started");
    assertThat(outputResult).contains("Number of successfully imported events");
    assertThat(outputResult).contains("Number of failures during the importing");
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }
}
