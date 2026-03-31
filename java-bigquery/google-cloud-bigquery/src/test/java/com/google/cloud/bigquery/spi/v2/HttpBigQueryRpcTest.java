/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigquery.spi.v2;

import static com.google.cloud.bigquery.spi.v2.HttpBigQueryRpc.RESOURCE_PROJECT_PREFIX;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.Json;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.services.bigquery.model.Dataset;
import com.google.api.services.bigquery.model.DatasetList;
import com.google.api.services.bigquery.model.DatasetReference;
import com.google.api.services.bigquery.model.Job;
import com.google.api.services.bigquery.model.JobReference;
import com.google.api.services.bigquery.model.Model;
import com.google.api.services.bigquery.model.ModelReference;
import com.google.api.services.bigquery.model.Policy;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.api.services.bigquery.model.Routine;
import com.google.api.services.bigquery.model.RoutineReference;
import com.google.api.services.bigquery.model.Table;
import com.google.api.services.bigquery.model.TableDataInsertAllRequest;
import com.google.api.services.bigquery.model.TableReference;
import com.google.cloud.NoCredentials;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.telemetry.BigQueryTelemetryTracer;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

// same thread execution temporarily required for using java system properties will get removed in
// issue https://github.com/googleapis/google-cloud-java/issues/12100
@Execution(ExecutionMode.SAME_THREAD)
public class HttpBigQueryRpcTest {

  private static final String PROJECT_ID = "test-project";
  private static final String DATASET_ID = "test-dataset";
  private static final String TABLE_ID = "test-table";
  private static final String MODEL_ID = "test-model";
  private static final String ROUTINE_ID = "test-routine";
  private static final String JOB_ID = "test-job";
  private static final String LOCATION = "test-location";

  private InMemorySpanExporter spanExporter;
  private MockLowLevelHttpResponse mockResponse;
  private String lastRequestMethod;
  private String lastRequestUrl;
  private MockLowLevelHttpRequest lastRequest;
  private Tracer tracer;
  private HttpTransport mockTransport;

  public void setUpServer() {
    spanExporter = InMemorySpanExporter.create();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
    tracer = openTelemetry.getTracer("test-tracer");

    mockResponse = new MockLowLevelHttpResponse();
    mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            lastRequestMethod = method;
            lastRequestUrl = url;
            lastRequest =
                new MockLowLevelHttpRequest() {
                  @Override
                  public LowLevelHttpResponse execute() throws IOException {
                    if (mockResponse.getContent() == null) {
                      throw new IOException("Simulated network error");
                    }
                    return mockResponse;
                  }
                };
            return lastRequest;
          }
        };
  }

  private HttpBigQueryRpc createRpc(boolean enableTracing) {
    BigQueryOptions options =
        BigQueryOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .setEnableOpenTelemetryTracing(enableTracing)
            .setOpenTelemetryTracer(tracer)
            .setTransportOptions(
                BigQueryOptions.getDefaultHttpTransportOptions().toBuilder()
                    .setHttpTransportFactory(() -> mockTransport)
                    .build())
            .build();
    return new HttpBigQueryRpc(options);
  }

  private void setMockResponse(String content) {
    mockResponse.setStatusCode(200);
    mockResponse.setContentType(Json.MEDIA_TYPE);
    mockResponse.setContent(content);
  }

  private void verifySpan(
      String spanName,
      String service,
      String method,
      String gcpResourceDestinationId,
      Map<String, String> attributes) {
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertThat(spans).isNotEmpty();
    SpanData rpcSpan =
        spans.stream().filter(span -> span.getName().equals(spanName)).findFirst().orElse(null);

    verifySpanProductionAttributes(service, method, attributes, rpcSpan);

    assertNotNull(
        rpcSpan.getAttributes().get(AttributeKey.stringKey("url.template")),
        "url.template attribute should be set");

    assertEquals(
        gcpResourceDestinationId,
        rpcSpan.getAttributes().get(BigQueryTelemetryTracer.GCP_RESOURCE_DESTINATION_ID));
  }

  private void verifySpanProductionAttributes(
      String service, String method, Map<String, String> attributes, SpanData rpcSpan) {
    assertNotNull(rpcSpan);
    assertEquals(service, rpcSpan.getAttributes().get(AttributeKey.stringKey("bq.rpc.service")));
    assertEquals(method, rpcSpan.getAttributes().get(AttributeKey.stringKey("bq.rpc.method")));
    assertEquals("http", rpcSpan.getAttributes().get(AttributeKey.stringKey("bq.rpc.system")));

    if (attributes != null) {
      for (Map.Entry<String, String> entry : attributes.entrySet()) {
        assertEquals(
            entry.getValue(), rpcSpan.getAttributes().get(AttributeKey.stringKey(entry.getKey())));
      }
    }
  }

  private void verifyNoSpans() {
    assertThat(spanExporter.getFinishedSpanItems()).isEmpty();
  }

  private void verifyRequest(String expectedMethod, String expectedUrlPart) {
    assertNotNull(lastRequestMethod);
    assertNotNull(lastRequestUrl);
    assertEquals(expectedMethod, lastRequestMethod);
    assertTrue(
        lastRequestUrl.contains(expectedUrlPart),
        "Expected URL to contain " + expectedUrlPart + " but was " + lastRequestUrl);
  }

  @Test
  public void testListToDataset() {
    DatasetReference datasetRef =
        new DatasetReference().setDatasetId("dataset-id").setProjectId("project-id");

    DatasetList.Datasets listDataSet =
        new DatasetList.Datasets()
            .setDatasetReference(datasetRef)
            .setId("project-id:dataset-id")
            .setFriendlyName("friendly")
            .setKind("bigquery#dataset")
            .setLabels(Collections.singletonMap("foo", "bar"))
            .setLocation("test-region-1");
    Dataset dataset = HttpBigQueryRpc.LIST_TO_DATASET.apply(listDataSet);

    assertThat(dataset.getKind()).isEqualTo("bigquery#dataset");
    assertThat(dataset.getId()).isEqualTo("project-id:dataset-id");
    assertThat(dataset.getFriendlyName()).isEqualTo("friendly");
    assertThat(dataset.getDatasetReference()).isEqualTo(datasetRef);
    assertThat(dataset.getLabels()).containsExactly("foo", "bar");
    assertThat(dataset.getLocation()).isEqualTo("test-region-1");
  }

  @Nested
  class TelemetryEnabled {
    private HttpBigQueryRpc rpc;

    @BeforeEach
    public void setUp() {
      setUpServer();
      System.setProperty("com.google.cloud.bigquery.http.tracing.dev.enabled", "true");
      rpc = createRpc(true);
    }

    @Test
    public void testSpanEndOnError() {
      assertThrows(
          IOException.class,
          () -> {
            rpc.getDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());
          });

      // Verify that span was ended (collected) despite the error
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getDataset",
          "DatasetService",
          "GetDataset",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID,
          null);
    }

    @Test
    public void testGetDatasetTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#dataset\",\"id\":\""
              + PROJECT_ID
              + ":"
              + DATASET_ID
              + "\",\"datasetReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\"}}");

      rpc.getDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());

      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getDataset",
          "DatasetService",
          "GetDataset",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID,
          Collections.singletonMap("bq.rpc.response.dataset.id", PROJECT_ID + ":" + DATASET_ID));
    }

    @Test
    public void testListDatasetsTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#datasetList\",\"datasets\":[], \"nextPageToken\":\"next-page-token\"}");

      rpc.listDatasetsSkipExceptionTranslation(PROJECT_ID, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/datasets");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.listDatasets",
          "DatasetService",
          "ListDatasets",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets",
          Collections.singletonMap("bq.rpc.next_page_token", "next-page-token"));
    }

    @Test
    public void testCreateDatasetTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#dataset\",\"id\":\"" + PROJECT_ID + ":" + DATASET_ID + "\"}");

      Dataset dataset = new Dataset();
      dataset.setDatasetReference(
          new DatasetReference().setProjectId(PROJECT_ID).setDatasetId(DATASET_ID));
      rpc.createSkipExceptionTranslation(dataset, new HashMap<>());

      verifyRequest("POST", "/projects/" + PROJECT_ID + "/datasets");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.createDataset",
          "DatasetService",
          "InsertDataset",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID,
          Collections.singletonMap("bq.rpc.response.dataset.id", PROJECT_ID + ":" + DATASET_ID));
    }

    @Test
    public void testDeleteDatasetTelemetry() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());

      verifyRequest("DELETE", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID);
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.deleteDataset",
          "DatasetService",
          "DeleteDataset",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID,
          null);
    }

    @Test
    public void testPatchDatasetTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#dataset\",\"id\":\"" + PROJECT_ID + ":" + DATASET_ID + "\"}");

      Dataset dataset = new Dataset();
      dataset.setDatasetReference(
          new DatasetReference().setProjectId(PROJECT_ID).setDatasetId(DATASET_ID));
      rpc.patchSkipExceptionTranslation(dataset, new HashMap<>());

      verifyRequest("PATCH", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID);
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.patchDataset",
          "DatasetService",
          "PatchDataset",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID,
          Collections.singletonMap("bq.rpc.response.dataset.id", PROJECT_ID + ":" + DATASET_ID));
    }

    @Test
    public void testGetTableTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#table\",\"id\":\""
              + PROJECT_ID
              + ":"
              + DATASET_ID
              + "."
              + TABLE_ID
              + "\"}");

      rpc.getTableSkipExceptionTranslation(PROJECT_ID, DATASET_ID, TABLE_ID, new HashMap<>());

      verifyRequest(
          "GET", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID);
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getTable",
          "TableService",
          "GetTable",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          Collections.singletonMap(
              "bq.rpc.response.table.id", PROJECT_ID + ":" + DATASET_ID + "." + TABLE_ID));
    }

    @Test
    public void testListTablesTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#tableList\",\"tables\":[], \"nextPageToken\":\"next-page-token\"}");

      rpc.listTablesSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.listTables",
          "TableService",
          "ListTables",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables",
          Collections.singletonMap("bq.rpc.next_page_token", "next-page-token"));
    }

    @Test
    public void testCreateTableTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#table\",\"id\":\""
              + PROJECT_ID
              + ":"
              + DATASET_ID
              + "."
              + TABLE_ID
              + "\"}");

      Table table = new Table();
      table.setTableReference(
          new TableReference()
              .setProjectId(PROJECT_ID)
              .setDatasetId(DATASET_ID)
              .setTableId(TABLE_ID));
      rpc.createSkipExceptionTranslation(table, new HashMap<>());

      verifyRequest("POST", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.createTable",
          "TableService",
          "InsertTable",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          Collections.singletonMap(
              "bq.rpc.response.table.id", PROJECT_ID + ":" + DATASET_ID + "." + TABLE_ID));
    }

    @Test
    public void testDeleteTableTelemetry() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteTableSkipExceptionTranslation(PROJECT_ID, DATASET_ID, TABLE_ID);

      verifyRequest(
          "DELETE", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID);
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.deleteTable",
          "TableService",
          "DeleteTable",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          null);
    }

    @Test
    public void testPatchTableTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#table\",\"id\":\""
              + PROJECT_ID
              + ":"
              + DATASET_ID
              + "."
              + TABLE_ID
              + "\"}");

      Table table = new Table();
      table.setTableReference(
          new TableReference()
              .setProjectId(PROJECT_ID)
              .setDatasetId(DATASET_ID)
              .setTableId(TABLE_ID));
      rpc.patchSkipExceptionTranslation(table, new HashMap<>());

      verifyRequest(
          "PATCH", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID);
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.patchTable",
          "TableService",
          "PatchTable",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          Collections.singletonMap(
              "bq.rpc.response.table.id", PROJECT_ID + ":" + DATASET_ID + "." + TABLE_ID));
    }

    @Test
    public void testGetModelTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#model\",\"modelReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\",\"modelId\":\""
              + MODEL_ID
              + "\"}}");

      rpc.getModelSkipExceptionTranslation(PROJECT_ID, DATASET_ID, MODEL_ID, new HashMap<>());

      verifyRequest(
          "GET", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/models/" + MODEL_ID);
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getModel",
          "ModelService",
          "GetModel",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/models/" + MODEL_ID,
          Collections.singletonMap("bq.rpc.response.model.id", MODEL_ID));
    }

    @Test
    public void testListModelsTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#modelList\",\"models\":[], \"nextPageToken\":\"next-page-token\"}");

      rpc.listModelsSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/models");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.listModels",
          "ModelService",
          "ListModels",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/models",
          Collections.singletonMap("bq.rpc.next_page_token", "next-page-token"));
    }

    @Test
    public void testPatchModelTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#model\",\"modelReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\",\"modelId\":\""
              + MODEL_ID
              + "\"}}");

      Model model = new Model();
      model.setModelReference(
          new ModelReference()
              .setProjectId(PROJECT_ID)
              .setDatasetId(DATASET_ID)
              .setModelId(MODEL_ID));
      rpc.patchSkipExceptionTranslation(model, new HashMap<>());

      verifyRequest(
          "PATCH", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/models/" + MODEL_ID);
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.patchModel",
          "ModelService",
          "PatchModel",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/models/" + MODEL_ID,
          Collections.singletonMap("bq.rpc.response.model.id", MODEL_ID));
    }

    @Test
    public void testDeleteModelTelemetry() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteModelSkipExceptionTranslation(PROJECT_ID, DATASET_ID, MODEL_ID);

      verifyRequest(
          "DELETE", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/models/" + MODEL_ID);
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.deleteModel",
          "ModelService",
          "DeleteModel",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/models/" + MODEL_ID,
          null);
    }

    @Test
    public void testGetRoutineTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#routine\",\"routineReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\",\"routineId\":\""
              + ROUTINE_ID
              + "\"}}");

      rpc.getRoutineSkipExceptionTranslation(PROJECT_ID, DATASET_ID, ROUTINE_ID, new HashMap<>());

      verifyRequest(
          "GET", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/routines/" + ROUTINE_ID);
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getRoutine",
          "RoutineService",
          "GetRoutine",
          RESOURCE_PROJECT_PREFIX
              + PROJECT_ID
              + "/datasets/"
              + DATASET_ID
              + "/routines/"
              + ROUTINE_ID,
          Collections.singletonMap("bq.rpc.response.routine.id", ROUTINE_ID));
    }

    @Test
    public void testListRoutinesTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#routineList\",\"routines\":[], \"nextPageToken\":\"next-page-token\"}");

      rpc.listRoutinesSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/routines");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.listRoutines",
          "RoutineService",
          "ListRoutines",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/routines",
          Collections.singletonMap("bq.rpc.next_page_token", "next-page-token"));
    }

    @Test
    public void testCreateRoutineTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#routine\",\"routineReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\",\"routineId\":\""
              + ROUTINE_ID
              + "\"}}");

      Routine routine = new Routine();
      routine.setRoutineReference(
          new RoutineReference()
              .setProjectId(PROJECT_ID)
              .setDatasetId(DATASET_ID)
              .setRoutineId(ROUTINE_ID));
      rpc.createSkipExceptionTranslation(routine, new HashMap<>());

      verifyRequest("POST", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/routines");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.createRoutine",
          "RoutineService",
          "InsertRoutine",
          RESOURCE_PROJECT_PREFIX
              + PROJECT_ID
              + "/datasets/"
              + DATASET_ID
              + "/routines/"
              + ROUTINE_ID,
          Collections.singletonMap("bq.rpc.response.routine.id", ROUTINE_ID));
    }

    @Test
    public void testDeleteRoutineTelemetry() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteRoutineSkipExceptionTranslation(PROJECT_ID, DATASET_ID, ROUTINE_ID);

      verifyRequest(
          "DELETE",
          "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/routines/" + ROUTINE_ID);
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.deleteRoutine",
          "RoutineService",
          "DeleteRoutine",
          RESOURCE_PROJECT_PREFIX
              + PROJECT_ID
              + "/datasets/"
              + DATASET_ID
              + "/routines/"
              + ROUTINE_ID,
          null);
    }

    @Test
    public void testUpdateRoutineTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#routine\",\"routineReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\",\"routineId\":\""
              + ROUTINE_ID
              + "\"}}");

      Routine routine = new Routine();
      routine.setRoutineReference(
          new RoutineReference()
              .setProjectId(PROJECT_ID)
              .setDatasetId(DATASET_ID)
              .setRoutineId(ROUTINE_ID));
      rpc.updateSkipExceptionTranslation(routine, new HashMap<>());

      verifyRequest(
          "PUT", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/routines/" + ROUTINE_ID);
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.updateRoutine",
          "RoutineService",
          "UpdateRoutine",
          RESOURCE_PROJECT_PREFIX
              + PROJECT_ID
              + "/datasets/"
              + DATASET_ID
              + "/routines/"
              + ROUTINE_ID,
          Collections.singletonMap("bq.rpc.response.routine.id", ROUTINE_ID));
    }

    @Test
    public void testInsertAllTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#tableDataInsertAllResponse\"}");

      TableDataInsertAllRequest request = new TableDataInsertAllRequest();
      rpc.insertAllSkipExceptionTranslation(PROJECT_ID, DATASET_ID, TABLE_ID, request);

      verifyRequest(
          "POST",
          "/projects/"
              + PROJECT_ID
              + "/datasets/"
              + DATASET_ID
              + "/tables/"
              + TABLE_ID
              + "/insertAll");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.insertAll",
          "TableDataService",
          "InsertAll",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          null);
    }

    @Test
    public void testListTableDataTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#tableDataList\",\"rows\":[]}");

      rpc.listTableDataSkipExceptionTranslation(PROJECT_ID, DATASET_ID, TABLE_ID, new HashMap<>());

      verifyRequest(
          "GET",
          "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID + "/data");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.listTableData",
          "TableDataService",
          "List",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          null);
    }

    @Test
    public void testListTableDataWithRowLimitTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#tableDataList\",\"rows\":[]}");

      rpc.listTableDataWithRowLimitSkipExceptionTranslation(
          PROJECT_ID, DATASET_ID, TABLE_ID, 10, null);

      verifyRequest(
          "GET",
          "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID + "/data");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.listTableDataWithRowLimit",
          "TableDataService",
          "List",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          null);
    }

    @Test
    public void testGetJobTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\""
              + PROJECT_ID
              + ":"
              + JOB_ID
              + "\",\"status\":{\"state\":\"DONE\"}}");

      rpc.getJobSkipExceptionTranslation(PROJECT_ID, JOB_ID, LOCATION, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/jobs/" + JOB_ID);
      Map<String, String> attributes = new HashMap<>();
      attributes.put("bq.rpc.response.job.id", PROJECT_ID + ":" + JOB_ID);
      attributes.put("bq.rpc.response.job.status.state", "DONE");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getJob",
          "JobService",
          "GetJob",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/jobs/" + JOB_ID,
          attributes);
    }

    @Test
    public void testGetQueryJobTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\""
              + PROJECT_ID
              + ":"
              + JOB_ID
              + "\",\"status\":{\"state\":\"DONE\"}}");

      rpc.getQueryJobSkipExceptionTranslation(PROJECT_ID, JOB_ID, LOCATION);

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/jobs/" + JOB_ID);
      Map<String, String> attributes = new HashMap<>();
      attributes.put("bq.rpc.response.job.id", PROJECT_ID + ":" + JOB_ID);
      attributes.put("bq.rpc.response.job.status.state", "DONE");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getQueryJob",
          "JobService",
          "GetJob",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/jobs/" + JOB_ID,
          attributes);
    }

    @Test
    public void testListJobsTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#jobList\",\"jobs\":[], \"nextPageToken\":\"next-page-token\"}");

      rpc.listJobsSkipExceptionTranslation(PROJECT_ID, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/jobs");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.listJobs",
          "JobService",
          "ListJobs",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/jobs",
          Collections.singletonMap("bq.rpc.next_page_token", "next-page-token"));
    }

    @Test
    public void testCreateJobTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\""
              + PROJECT_ID
              + ":"
              + JOB_ID
              + "\",\"status\":{\"state\":\"DONE\"}}");

      Job job = new Job();
      job.setJobReference(new JobReference().setProjectId(PROJECT_ID).setJobId(JOB_ID));
      rpc.createSkipExceptionTranslation(job, new HashMap<>());

      verifyRequest("POST", "/projects/" + PROJECT_ID + "/jobs");
      Map<String, String> attributes = new HashMap<>();
      attributes.put("bq.rpc.response.job.id", PROJECT_ID + ":" + JOB_ID);
      attributes.put("bq.rpc.response.job.status.state", "DONE");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.createJob",
          "JobService",
          "InsertJob",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/jobs",
          attributes);
    }

    @Test
    public void testCreateJobForQueryTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\""
              + PROJECT_ID
              + ":"
              + JOB_ID
              + "\",\"status\":{\"state\":\"DONE\"}}");

      Job job = new Job();
      job.setJobReference(new JobReference().setProjectId(PROJECT_ID).setJobId(JOB_ID));
      rpc.createJobForQuerySkipExceptionTranslation(job);

      verifyRequest("POST", "/projects/" + PROJECT_ID + "/jobs");
      Map<String, String> attributes = new HashMap<>();
      attributes.put("bq.rpc.response.job.id", PROJECT_ID + ":" + JOB_ID);
      attributes.put("bq.rpc.response.job.status.state", "DONE");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.createJobForQuery",
          "JobService",
          "InsertJob",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/jobs",
          attributes);
    }

    @Test
    public void testCancelJobTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#jobCancelResponse\"}");

      rpc.cancelSkipExceptionTranslation(PROJECT_ID, JOB_ID, LOCATION);

      verifyRequest("POST", "/projects/" + PROJECT_ID + "/jobs/" + JOB_ID + "/cancel");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.cancelJob",
          "JobService",
          "CancelJob",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/jobs/" + JOB_ID,
          null);
    }

    @Test
    public void testDeleteJobTelemetry() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteJobSkipExceptionTranslation(PROJECT_ID, JOB_ID, LOCATION);

      verifyRequest("DELETE", "/projects/" + PROJECT_ID + "/jobs/" + JOB_ID);
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.deleteJob",
          "JobService",
          "DeleteJob",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/jobs/" + JOB_ID,
          null);
    }

    @Test
    public void testGetQueryResultsTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#getQueryResultsResponse\"}");

      rpc.getQueryResultsSkipExceptionTranslation(PROJECT_ID, JOB_ID, LOCATION, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/queries/" + JOB_ID);
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getQueryResults",
          "JobService",
          "GetQueryResults",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/jobs/" + JOB_ID,
          null);
    }

    @Test
    public void testGetQueryResultsWithRowLimitTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#getQueryResultsResponse\"}");

      rpc.getQueryResultsWithRowLimitSkipExceptionTranslation(
          PROJECT_ID, JOB_ID, LOCATION, 10, 1000L);

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/queries/" + JOB_ID);
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getQueryResultsWithRowLimit",
          "JobService",
          "GetQueryResults",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/jobs/" + JOB_ID,
          null);
    }

    @Test
    public void testQueryRpcTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#queryResponse\"}");

      rpc.queryRpcSkipExceptionTranslation(PROJECT_ID, new QueryRequest());

      verifyRequest("POST", "/projects/" + PROJECT_ID + "/queries");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.queryRpc",
          "JobService",
          "Query",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/jobs",
          null);
    }

    @Test
    public void testGetIamPolicyTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#policy\"}");

      rpc.getIamPolicySkipExceptionTranslation(
          "projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          new HashMap<>());

      verifyRequest(
          "POST",
          "/projects/"
              + PROJECT_ID
              + "/datasets/"
              + DATASET_ID
              + "/tables/"
              + TABLE_ID
              + ":getIamPolicy");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getIamPolicy",
          "TableService",
          "GetIamPolicy",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          null);
    }

    @Test
    public void testSetIamPolicyTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#policy\"}");

      rpc.setIamPolicySkipExceptionTranslation(
          "projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          new Policy(),
          new HashMap<>());

      verifyRequest(
          "POST",
          "/projects/"
              + PROJECT_ID
              + "/datasets/"
              + DATASET_ID
              + "/tables/"
              + TABLE_ID
              + ":setIamPolicy");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.setIamPolicy",
          "TableService",
          "SetIamPolicy",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          null);
    }

    @Test
    public void testTestIamPermissionsTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#testIamPermissionsResponse\"}");

      rpc.testIamPermissionsSkipExceptionTranslation(
          "projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          Arrays.asList("p1", "p2"),
          new HashMap<>());

      verifyRequest(
          "POST",
          "/projects/"
              + PROJECT_ID
              + "/datasets/"
              + DATASET_ID
              + "/tables/"
              + TABLE_ID
              + ":testIamPermissions");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.testIamPermissions",
          "TableService",
          "TestIamPermissions",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          null);
    }

    @Test
    public void testOtelAttributesFromOptionsGetAddedtoSpan() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#dataset\",\"id\":\""
              + PROJECT_ID
              + ":"
              + DATASET_ID
              + "\",\"datasetReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\"}}");

      Map<BigQueryRpc.Option, Object> options = new HashMap<>();
      options.put(BigQueryRpc.Option.FIELDS, "foo,bar");

      rpc.getDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, options);

      Map<String, String> expectedAttributes = new HashMap<>();
      expectedAttributes.put("FIELDS", "foo,bar");
      expectedAttributes.put("bq.rpc.response.dataset.id", PROJECT_ID + ":" + DATASET_ID);

      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getDataset",
          "DatasetService",
          "GetDataset",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID,
          expectedAttributes);
    }

    @Test
    public void testHttpTracingEnabledAddsAdditionalAttributes() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#dataset\",\"id\":\""
              + PROJECT_ID
              + ":"
              + DATASET_ID
              + "\",\"datasetReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\"}}");

      rpc.getDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID);
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getDataset",
          "DatasetService",
          "GetDataset",
          RESOURCE_PROJECT_PREFIX + PROJECT_ID + "/datasets/" + DATASET_ID,
          Collections.singletonMap("bq.rpc.response.dataset.id", PROJECT_ID + ":" + DATASET_ID));

      List<SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).isNotEmpty();
      SpanData rpcSpan =
          spans.stream()
              .filter(
                  span -> span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.getDataset"))
              .findFirst()
              .orElse(null);
      assertNotNull(rpcSpan);
      assertEquals("http", rpcSpan.getAttributes().get(BigQueryTelemetryTracer.RPC_SYSTEM_NAME));
      assertNotNull(rpcSpan.getAttributes().get(BigQueryTelemetryTracer.GCP_CLIENT_SERVICE));
    }

    @Test
    public void testHttpTracingEnabled_GenericException_SetsAttributes() throws Exception {
      assertThrows(
          IOException.class,
          () -> {
            rpc.getDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());
          });

      List<SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).isNotEmpty();
      SpanData rpcSpan =
          spans.stream()
              .filter(
                  span -> span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.getDataset"))
              .findFirst()
              .orElse(null);
      assertNotNull(rpcSpan);
      assertEquals(
          "java.io.IOException",
          rpcSpan.getAttributes().get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
      assertEquals(
          "CLIENT_UNKNOWN_ERROR", rpcSpan.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
    }

    @Test
    public void testHttpTracingEnabled_JsonResponseException_SetsAttributes() throws Exception {
      mockResponse.setStatusCode(400);
      mockResponse.setContentType(Json.MEDIA_TYPE);
      mockResponse.setContent(
          "{\"error\":{\"code\":400,\"message\":\"Invalid request\",\"errors\":[{\"message\":\"Invalid request\",\"domain\":\"global\",\"reason\":\"invalid\"}]}}");

      assertThrows(
          IOException.class,
          () -> {
            rpc.getDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());
          });

      List<SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).isNotEmpty();
      SpanData rpcSpan =
          spans.stream()
              .filter(
                  span -> span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.getDataset"))
              .findFirst()
              .orElse(null);
      assertNotNull(rpcSpan);
      assertEquals("invalid", rpcSpan.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
      assertEquals(
          "Invalid request", rpcSpan.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
      assertNull(rpcSpan.getAttributes().get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
    }

    @Test
    public void testGetUriTemplateValueTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#dataset\",\"id\":\""
              + PROJECT_ID
              + ":"
              + DATASET_ID
              + "\",\"datasetReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\"}}");

      rpc.getDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());

      List<SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).isNotEmpty();
      SpanData rpcSpan =
          spans.stream()
              .filter(
                  span -> span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.getDataset"))
              .findFirst()
              .orElse(null);
      assertNotNull(rpcSpan);
      assertEquals(
          "projects/{+projectId}/datasets/{+datasetId}",
          rpcSpan.getAttributes().get(BigQueryTelemetryTracer.URL_TEMPLATE));
    }

    @Test
    public void testUrlDomain_DefaultValue() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#dataset\",\"id\":\"" + PROJECT_ID + ":" + DATASET_ID + "\"}");

      rpc.getDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());

      List<io.opentelemetry.sdk.trace.data.SpanData> spans = spanExporter.getFinishedSpanItems();
      io.opentelemetry.sdk.trace.data.SpanData rpcSpan =
          spans.stream()
              .filter(
                  span -> span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.getDataset"))
              .findFirst()
              .orElse(null);
      assertNotNull(rpcSpan);
      assertEquals(
          "bigquery.googleapis.com",
          rpcSpan.getAttributes().get(BigQueryTelemetryTracer.URL_DOMAIN));
    }

    @Test
    public void testUrlDomain_OverriddenValue() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#dataset\",\"id\":\"" + PROJECT_ID + ":" + DATASET_ID + "\"}");

      BigQueryOptions customOptions =
          BigQueryOptions.newBuilder()
              .setProjectId(PROJECT_ID)
              .setCredentials(NoCredentials.getInstance())
              .setEnableOpenTelemetryTracing(true)
              .setOpenTelemetryTracer(tracer)
              .setTransportOptions(
                  BigQueryOptions.getDefaultHttpTransportOptions().toBuilder()
                      .setHttpTransportFactory(() -> mockTransport)
                      .build())
              .setHost("https://custom.googleapis.com")
              .build();
      HttpBigQueryRpc customRpc = new HttpBigQueryRpc(customOptions);

      customRpc.getDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());

      List<io.opentelemetry.sdk.trace.data.SpanData> spans = spanExporter.getFinishedSpanItems();
      io.opentelemetry.sdk.trace.data.SpanData rpcSpan =
          spans.stream()
              .filter(
                  span -> span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.getDataset"))
              .findFirst()
              .orElse(null);
      assertNotNull(rpcSpan);
      assertEquals(
          "custom.googleapis.com", rpcSpan.getAttributes().get(BigQueryTelemetryTracer.URL_DOMAIN));
    }
  }

  @Nested
  class TelemetryEnabledDevDisabled {
    private HttpBigQueryRpc rpc;

    @BeforeEach
    public void setUp() {
      setUpServer();
      System.clearProperty("com.google.cloud.bigquery.http.tracing.dev.enabled");
      rpc = createRpc(true);
    }

    @Test
    public void testHttpTracingDisabledDoesNotAddAdditionalAttributes() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#dataset\",\"id\":\""
              + PROJECT_ID
              + ":"
              + DATASET_ID
              + "\",\"datasetReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\"}}");

      rpc.getDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID);

      List<SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).isNotEmpty();
      SpanData rpcSpan =
          spans.stream()
              .filter(
                  span -> span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.getDataset"))
              .findFirst()
              .orElse(null);
      assertNotNull(rpcSpan);
      verifySpanProductionAttributes(
          "DatasetService",
          "GetDataset",
          Collections.singletonMap("bq.rpc.response.dataset.id", PROJECT_ID + ":" + DATASET_ID),
          rpcSpan);

      assertNull(rpcSpan.getAttributes().get(BigQueryTelemetryTracer.RPC_SYSTEM_NAME));
      assertNull(rpcSpan.getAttributes().get(BigQueryTelemetryTracer.GCP_CLIENT_SERVICE));
      assertNull(
          rpcSpan.getAttributes().get(AttributeKey.stringKey("url.template")),
          "url.template attribute should not be set");
      assertNull(rpcSpan.getAttributes().get(BigQueryTelemetryTracer.GCP_RESOURCE_DESTINATION_ID));
      assertNull(rpcSpan.getAttributes().get(BigQueryTelemetryTracer.URL_DOMAIN));
    }

    @Test
    public void testHttpTracingDisabled_GenericException_DoesNotSetAttributes() throws Exception {
      assertThrows(
          IOException.class,
          () -> {
            rpc.getDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());
          });

      List<io.opentelemetry.sdk.trace.data.SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).isNotEmpty();
      io.opentelemetry.sdk.trace.data.SpanData rpcSpan =
          spans.stream()
              .filter(
                  span -> span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.getDataset"))
              .findFirst()
              .orElse(null);
      assertNotNull(rpcSpan);
      assertNull(rpcSpan.getAttributes().get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
      assertNull(rpcSpan.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
      assertNull(rpcSpan.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
    }

    @Test
    public void testHttpTracingDisabled_GoogleJsonResponseException_DoesNotSetAttributes()
        throws Exception {
      mockResponse.setStatusCode(400);
      mockResponse.setContentType(Json.MEDIA_TYPE);
      mockResponse.setContent(
          "{\"error\":{\"code\":400,\"message\":\"Invalid request\",\"errors\":[{\"message\":\"Invalid request\",\"domain\":\"global\",\"reason\":\"invalid\"}]}}");

      assertThrows(
          IOException.class,
          () -> {
            rpc.getDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());
          });

      List<io.opentelemetry.sdk.trace.data.SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).isNotEmpty();
      io.opentelemetry.sdk.trace.data.SpanData rpcSpan =
          spans.stream()
              .filter(
                  span -> span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.getDataset"))
              .findFirst()
              .orElse(null);
      assertNotNull(rpcSpan);
      assertNull(rpcSpan.getAttributes().get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
      assertNull(rpcSpan.getAttributes().get(BigQueryTelemetryTracer.ERROR_TYPE));
      assertNull(rpcSpan.getAttributes().get(BigQueryTelemetryTracer.STATUS_MESSAGE));
    }
  }

  @Nested
  class TelemetryDisabled {
    private HttpBigQueryRpc rpc;

    @BeforeEach
    public void setUp() {
      setUpServer();
      System.clearProperty("com.google.cloud.bigquery.http.tracing.dev.enabled");
      rpc = createRpc(false);
    }

    @Test
    public void testGetDatasetNoTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#dataset\",\"id\":\""
              + PROJECT_ID
              + ":"
              + DATASET_ID
              + "\",\"datasetReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\"}}");

      rpc.getDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID);
      verifyNoSpans();
    }

    @Test
    public void testListDatasetsNoTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#datasetList\",\"datasets\":[]}");

      rpc.listDatasetsSkipExceptionTranslation(PROJECT_ID, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/datasets");
      verifyNoSpans();
    }

    @Test
    public void testCreateDatasetNoTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#dataset\",\"id\":\"" + PROJECT_ID + ":" + DATASET_ID + "\"}");

      Dataset dataset = new Dataset();
      dataset.setDatasetReference(
          new DatasetReference().setProjectId(PROJECT_ID).setDatasetId(DATASET_ID));
      rpc.createSkipExceptionTranslation(dataset, new HashMap<>());

      verifyRequest("POST", "/projects/" + PROJECT_ID + "/datasets");
      verifyNoSpans();
    }

    @Test
    public void testDeleteDatasetNoTelemetry() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());

      verifyRequest("DELETE", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID);
      verifyNoSpans();
    }

    @Test
    public void testPatchDatasetNoTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#dataset\",\"id\":\"" + PROJECT_ID + ":" + DATASET_ID + "\"}");

      Dataset dataset = new Dataset();
      dataset.setDatasetReference(
          new DatasetReference().setProjectId(PROJECT_ID).setDatasetId(DATASET_ID));
      rpc.patchSkipExceptionTranslation(dataset, new HashMap<>());

      verifyRequest("PATCH", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID);
      verifyNoSpans();
    }

    @Test
    public void testGetTableNoTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#table\",\"id\":\""
              + PROJECT_ID
              + ":"
              + DATASET_ID
              + "."
              + TABLE_ID
              + "\"}");

      rpc.getTableSkipExceptionTranslation(PROJECT_ID, DATASET_ID, TABLE_ID, new HashMap<>());

      verifyRequest(
          "GET", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID);
      verifyNoSpans();
    }

    @Test
    public void testListTablesNoTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#tableList\",\"tables\":[]}");

      rpc.listTablesSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables");
      verifyNoSpans();
    }

    @Test
    public void testCreateTableNoTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#table\",\"id\":\""
              + PROJECT_ID
              + ":"
              + DATASET_ID
              + "."
              + TABLE_ID
              + "\"}");

      Table table = new Table();
      table.setTableReference(
          new TableReference()
              .setProjectId(PROJECT_ID)
              .setDatasetId(DATASET_ID)
              .setTableId(TABLE_ID));
      rpc.createSkipExceptionTranslation(table, new HashMap<>());

      verifyRequest("POST", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables");
      verifyNoSpans();
    }

    @Test
    public void testDeleteTableNoTelemetry() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteTableSkipExceptionTranslation(PROJECT_ID, DATASET_ID, TABLE_ID);

      verifyRequest(
          "DELETE", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID);
      verifyNoSpans();
    }

    @Test
    public void testPatchTableNoTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#table\",\"id\":\""
              + PROJECT_ID
              + ":"
              + DATASET_ID
              + "."
              + TABLE_ID
              + "\"}");

      Table table = new Table();
      table.setTableReference(
          new TableReference()
              .setProjectId(PROJECT_ID)
              .setDatasetId(DATASET_ID)
              .setTableId(TABLE_ID));
      rpc.patchSkipExceptionTranslation(table, new HashMap<>());

      verifyRequest(
          "PATCH", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID);
      verifyNoSpans();
    }

    @Test
    public void testGetModelNoTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#model\",\"modelReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\",\"modelId\":\""
              + MODEL_ID
              + "\"}}");

      rpc.getModelSkipExceptionTranslation(PROJECT_ID, DATASET_ID, MODEL_ID, new HashMap<>());

      verifyRequest(
          "GET", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/models/" + MODEL_ID);
      verifyNoSpans();
    }

    @Test
    public void testListModelsNoTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#modelList\",\"models\":[]}");

      rpc.listModelsSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/models");
      verifyNoSpans();
    }

    @Test
    public void testPatchModelNoTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#model\",\"modelReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\",\"modelId\":\""
              + MODEL_ID
              + "\"}}");

      Model model = new Model();
      model.setModelReference(
          new ModelReference()
              .setProjectId(PROJECT_ID)
              .setDatasetId(DATASET_ID)
              .setModelId(MODEL_ID));
      rpc.patchSkipExceptionTranslation(model, new HashMap<>());

      verifyRequest(
          "PATCH", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/models/" + MODEL_ID);
      verifyNoSpans();
    }

    @Test
    public void testDeleteModelNoTelemetry() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteModelSkipExceptionTranslation(PROJECT_ID, DATASET_ID, MODEL_ID);

      verifyRequest(
          "DELETE", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/models/" + MODEL_ID);
      verifyNoSpans();
    }

    @Test
    public void testGetRoutineNoTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#routine\",\"routineReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\",\"routineId\":\""
              + ROUTINE_ID
              + "\"}}");

      rpc.getRoutineSkipExceptionTranslation(PROJECT_ID, DATASET_ID, ROUTINE_ID, new HashMap<>());

      verifyRequest(
          "GET", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/routines/" + ROUTINE_ID);
      verifyNoSpans();
    }

    @Test
    public void testListRoutinesNoTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#routineList\",\"routines\":[]}");

      rpc.listRoutinesSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/routines");
      verifyNoSpans();
    }

    @Test
    public void testCreateRoutineNoTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#routine\",\"routineReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\",\"routineId\":\""
              + ROUTINE_ID
              + "\"}}");

      Routine routine = new Routine();
      routine.setRoutineReference(
          new RoutineReference()
              .setProjectId(PROJECT_ID)
              .setDatasetId(DATASET_ID)
              .setRoutineId(ROUTINE_ID));
      rpc.createSkipExceptionTranslation(routine, new HashMap<>());

      verifyRequest("POST", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/routines");
      verifyNoSpans();
    }

    @Test
    public void testDeleteRoutineNoTelemetry() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteRoutineSkipExceptionTranslation(PROJECT_ID, DATASET_ID, ROUTINE_ID);

      verifyRequest(
          "DELETE",
          "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/routines/" + ROUTINE_ID);
      verifyNoSpans();
    }

    @Test
    public void testUpdateRoutineNoTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#routine\",\"routineReference\":{\"projectId\":\""
              + PROJECT_ID
              + "\",\"datasetId\":\""
              + DATASET_ID
              + "\",\"routineId\":\""
              + ROUTINE_ID
              + "\"}}");

      Routine routine = new Routine();
      routine.setRoutineReference(
          new RoutineReference()
              .setProjectId(PROJECT_ID)
              .setDatasetId(DATASET_ID)
              .setRoutineId(ROUTINE_ID));
      rpc.updateSkipExceptionTranslation(routine, new HashMap<>());

      verifyRequest(
          "PUT", "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/routines/" + ROUTINE_ID);
      verifyNoSpans();
    }

    @Test
    public void testInsertAllNoTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#tableDataInsertAllResponse\"}");

      TableDataInsertAllRequest request = new TableDataInsertAllRequest();
      rpc.insertAllSkipExceptionTranslation(PROJECT_ID, DATASET_ID, TABLE_ID, request);

      verifyRequest(
          "POST",
          "/projects/"
              + PROJECT_ID
              + "/datasets/"
              + DATASET_ID
              + "/tables/"
              + TABLE_ID
              + "/insertAll");
      verifyNoSpans();
    }

    @Test
    public void testListTableDataNoTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#tableDataList\",\"rows\":[]}");

      rpc.listTableDataSkipExceptionTranslation(PROJECT_ID, DATASET_ID, TABLE_ID, new HashMap<>());

      verifyRequest(
          "GET",
          "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID + "/data");
      verifyNoSpans();
    }

    @Test
    public void testListTableDataWithRowLimitNoTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#tableDataList\",\"rows\":[]}");

      rpc.listTableDataWithRowLimitSkipExceptionTranslation(
          PROJECT_ID, DATASET_ID, TABLE_ID, 10, null);

      verifyRequest(
          "GET",
          "/projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID + "/data");
      verifyNoSpans();
    }

    @Test
    public void testGetJobNoTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\""
              + PROJECT_ID
              + ":"
              + JOB_ID
              + "\",\"status\":{\"state\":\"DONE\"}}");

      rpc.getJobSkipExceptionTranslation(PROJECT_ID, JOB_ID, LOCATION, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/jobs/" + JOB_ID);
      verifyNoSpans();
    }

    @Test
    public void testGetQueryJobNoTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\""
              + PROJECT_ID
              + ":"
              + JOB_ID
              + "\",\"status\":{\"state\":\"DONE\"}}");

      rpc.getQueryJobSkipExceptionTranslation(PROJECT_ID, JOB_ID, LOCATION);

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/jobs/" + JOB_ID);
      verifyNoSpans();
    }

    @Test
    public void testListJobsNoTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#jobList\",\"jobs\":[]}");

      rpc.listJobsSkipExceptionTranslation(PROJECT_ID, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/jobs");
      verifyNoSpans();
    }

    @Test
    public void testCreateJobNoTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\""
              + PROJECT_ID
              + ":"
              + JOB_ID
              + "\",\"status\":{\"state\":\"DONE\"}}");

      Job job = new Job();
      job.setJobReference(new JobReference().setProjectId(PROJECT_ID).setJobId(JOB_ID));
      rpc.createSkipExceptionTranslation(job, new HashMap<>());

      verifyRequest("POST", "/projects/" + PROJECT_ID + "/jobs");
      verifyNoSpans();
    }

    @Test
    public void testCreateJobForQueryNoTelemetry() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\""
              + PROJECT_ID
              + ":"
              + JOB_ID
              + "\",\"status\":{\"state\":\"DONE\"}}");

      Job job = new Job();
      job.setJobReference(new JobReference().setProjectId(PROJECT_ID).setJobId(JOB_ID));
      rpc.createJobForQuerySkipExceptionTranslation(job);

      verifyRequest("POST", "/projects/" + PROJECT_ID + "/jobs");
      verifyNoSpans();
    }

    @Test
    public void testCancelJobNoTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#jobCancelResponse\"}");

      rpc.cancelSkipExceptionTranslation(PROJECT_ID, JOB_ID, LOCATION);

      verifyRequest("POST", "/projects/" + PROJECT_ID + "/jobs/" + JOB_ID + "/cancel");
      verifyNoSpans();
    }

    @Test
    public void testDeleteJobNoTelemetry() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteJobSkipExceptionTranslation(PROJECT_ID, JOB_ID, LOCATION);

      verifyRequest("DELETE", "/projects/" + PROJECT_ID + "/jobs/" + JOB_ID);
      verifyNoSpans();
    }

    @Test
    public void testGetQueryResultsNoTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#getQueryResultsResponse\"}");

      rpc.getQueryResultsSkipExceptionTranslation(PROJECT_ID, JOB_ID, LOCATION, new HashMap<>());

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/queries/" + JOB_ID);
      verifyNoSpans();
    }

    @Test
    public void testGetQueryResultsWithRowLimitNoTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#getQueryResultsResponse\"}");

      rpc.getQueryResultsWithRowLimitSkipExceptionTranslation(
          PROJECT_ID, JOB_ID, LOCATION, 10, 1000L);

      verifyRequest("GET", "/projects/" + PROJECT_ID + "/queries/" + JOB_ID);
      verifyNoSpans();
    }

    @Test
    public void testQueryRpcNoTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#queryResponse\"}");

      rpc.queryRpcSkipExceptionTranslation(PROJECT_ID, new QueryRequest());

      verifyRequest("POST", "/projects/" + PROJECT_ID + "/queries");
      verifyNoSpans();
    }

    @Test
    public void testGetIamPolicyNoTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#policy\"}");

      rpc.getIamPolicySkipExceptionTranslation(
          "projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          new HashMap<>());

      verifyRequest(
          "POST",
          "/projects/"
              + PROJECT_ID
              + "/datasets/"
              + DATASET_ID
              + "/tables/"
              + TABLE_ID
              + ":getIamPolicy");
      verifyNoSpans();
    }

    @Test
    public void testSetIamPolicyNoTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#policy\"}");

      rpc.setIamPolicySkipExceptionTranslation(
          "projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          new Policy(),
          new HashMap<>());

      verifyRequest(
          "POST",
          "/projects/"
              + PROJECT_ID
              + "/datasets/"
              + DATASET_ID
              + "/tables/"
              + TABLE_ID
              + ":setIamPolicy");
      verifyNoSpans();
    }

    @Test
    public void testTestIamPermissionsNoTelemetry() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#testIamPermissionsResponse\"}");

      rpc.testIamPermissionsSkipExceptionTranslation(
          "projects/" + PROJECT_ID + "/datasets/" + DATASET_ID + "/tables/" + TABLE_ID,
          Arrays.asList("p1", "p2"),
          new HashMap<>());

      verifyRequest(
          "POST",
          "/projects/"
              + PROJECT_ID
              + "/datasets/"
              + DATASET_ID
              + "/tables/"
              + TABLE_ID
              + ":testIamPermissions");
      verifyNoSpans();
    }

    @Test
    public void testExecuteWithSpan_IgnoresHttpResponseException() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(404);

      try {
        rpc.getDatasetSkipExceptionTranslation(PROJECT_ID, DATASET_ID, new HashMap<>());
        org.junit.jupiter.api.Assertions.fail("Expected HttpResponseException was not thrown");
      } catch (com.google.api.client.http.HttpResponseException e) {
        assertEquals(404, e.getStatusCode());
      }

      verifyNoSpans();
    }
  }
}
