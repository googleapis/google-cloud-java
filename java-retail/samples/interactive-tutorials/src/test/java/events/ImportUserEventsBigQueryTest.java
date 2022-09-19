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
import static org.junit.Assert.assertThrows;

import com.google.api.gax.rpc.InvalidArgumentException;
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
public class ImportUserEventsBigQueryTest {

  private ByteArrayOutputStream bout;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() throws IOException, InterruptedException, ExecutionException {
    bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @Test
  public void testValidImportUserEventsBigQuery() throws IOException, InterruptedException {
    String projectId = ServiceOptions.getDefaultProjectId();
    String defaultCatalog =
        String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);
    String datasetId = "user_events";
    String tableId = "events";

    ImportUserEventsBigQuery.importUserEventsFromBigQuery(
        projectId, defaultCatalog, datasetId, tableId);

    String outputResult = bout.toString();

    assertThat(outputResult).contains("Import user events from BigQuery source request");
    assertThat(outputResult).contains("table_id: \"events\"");
    assertThat(outputResult).contains("Number of successfully imported events:");
    assertThat(outputResult).contains("Number of failures during the importing: 0");
  }

  @Test
  public void testInvalidImportUserEventsBigQuery() throws IOException, InterruptedException {
    String projectId = ServiceOptions.getDefaultProjectId();
    String defaultCatalog =
        String.format("projects/%s/locations/global/catalogs/invalid_catalog_name", projectId);
    String datasetId = "user_events";
    String tableId = "events_some_invalid";

    ImportUserEventsBigQuery.importUserEventsFromBigQuery(
        projectId, defaultCatalog, datasetId, tableId);

    String outputResult = bout.toString();

    assertThat(outputResult).contains("table_id: \"events_some_invalid\"");
    assertThat(outputResult).contains("Catalog name is not found.");
  }

  @Test
  public void testInvalidDefaultCatalogBigQuery() {
    String projectId = ServiceOptions.getDefaultProjectId();
    String defaultCatalog = "invalid_catalog_name";
    String datasetId = "user_events";
    String tableId = "events";

    assertThrows(
        InvalidArgumentException.class,
        () ->
            ImportUserEventsBigQuery.importUserEventsFromBigQuery(
                projectId, defaultCatalog, datasetId, tableId));
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }
}
