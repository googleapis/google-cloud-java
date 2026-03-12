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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class HttpBigQueryRpcTest {

  private InMemorySpanExporter spanExporter;
  private MockLowLevelHttpResponse mockResponse;
  private String lastRequestMethod;
  private String lastRequestUrl;
  private MockLowLevelHttpRequest lastRequest;
  private Tracer tracer;
  private HttpTransport mockTransport;

  @BeforeEach
  public void setUp() {
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
                  public LowLevelHttpResponse execute() {
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
            .setProjectId("test-project")
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

  private void verifySpan(String spanName, String service, String method) {
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertThat(spans).isNotEmpty();
    SpanData rpcSpan =
        spans.stream().filter(span -> span.getName().equals(spanName)).findFirst().orElse(null);
    assertNotNull(rpcSpan);
    assertEquals(service, rpcSpan.getAttributes().get(AttributeKey.stringKey("bq.rpc.service")));
    assertEquals(method, rpcSpan.getAttributes().get(AttributeKey.stringKey("bq.rpc.method")));
    assertEquals("http", rpcSpan.getAttributes().get(AttributeKey.stringKey("bq.rpc.system")));
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
      rpc = createRpc(true);
    }

    @Test
    public void testGetDataset() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#dataset\",\"id\":\"test-project:test-dataset\",\"datasetReference\":{\"projectId\":\"test-project\",\"datasetId\":\"test-dataset\"}}");

      rpc.getDatasetSkipExceptionTranslation("test-project", "test-dataset", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getDataset", "DatasetService", "GetDataset");
    }

    @Test
    public void testListDatasets() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#datasetList\",\"datasets\":[]}");

      rpc.listDatasetsSkipExceptionTranslation("test-project", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.listDatasets", "DatasetService", "ListDatasets");
    }

    @Test
    public void testCreateDataset() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#dataset\",\"id\":\"test-project:test-dataset\"}");

      Dataset dataset = new Dataset();
      dataset.setDatasetReference(
          new DatasetReference().setProjectId("test-project").setDatasetId("test-dataset"));
      rpc.createSkipExceptionTranslation(dataset, new HashMap<>());

      verifyRequest("POST", "/projects/test-project/datasets");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.createDataset", "DatasetService", "InsertDataset");
    }

    @Test
    public void testDeleteDataset() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteDatasetSkipExceptionTranslation("test-project", "test-dataset", new HashMap<>());

      verifyRequest("DELETE", "/projects/test-project/datasets/test-dataset");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.deleteDataset", "DatasetService", "DeleteDataset");
    }

    @Test
    public void testPatchDataset() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#dataset\",\"id\":\"test-project:test-dataset\"}");

      Dataset dataset = new Dataset();
      dataset.setDatasetReference(
          new DatasetReference().setProjectId("test-project").setDatasetId("test-dataset"));
      rpc.patchSkipExceptionTranslation(dataset, new HashMap<>());

      verifyRequest("PATCH", "/projects/test-project/datasets/test-dataset");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.patchDataset", "DatasetService", "PatchDataset");
    }

    @Test
    public void testGetTable() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#table\",\"id\":\"test-project:test-dataset.test-table\"}");

      rpc.getTableSkipExceptionTranslation(
          "test-project", "test-dataset", "test-table", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/tables/test-table");
      verifySpan("com.google.cloud.bigquery.BigQueryRpc.getTable", "TableService", "GetTable");
    }

    @Test
    public void testListTables() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#tableList\",\"tables\":[]}");

      rpc.listTablesSkipExceptionTranslation("test-project", "test-dataset", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/tables");
      verifySpan("com.google.cloud.bigquery.BigQueryRpc.listTables", "TableService", "ListTables");
    }

    @Test
    public void testCreateTable() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#table\",\"id\":\"test-project:test-dataset.test-table\"}");

      Table table = new Table();
      table.setTableReference(
          new TableReference()
              .setProjectId("test-project")
              .setDatasetId("test-dataset")
              .setTableId("test-table"));
      rpc.createSkipExceptionTranslation(table, new HashMap<>());

      verifyRequest("POST", "/projects/test-project/datasets/test-dataset/tables");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.createTable", "TableService", "InsertTable");
    }

    @Test
    public void testDeleteTable() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteTableSkipExceptionTranslation("test-project", "test-dataset", "test-table");

      verifyRequest("DELETE", "/projects/test-project/datasets/test-dataset/tables/test-table");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.deleteTable", "TableService", "DeleteTable");
    }

    @Test
    public void testPatchTable() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#table\",\"id\":\"test-project:test-dataset.test-table\"}");

      Table table = new Table();
      table.setTableReference(
          new TableReference()
              .setProjectId("test-project")
              .setDatasetId("test-dataset")
              .setTableId("test-table"));
      rpc.patchSkipExceptionTranslation(table, new HashMap<>());

      verifyRequest("PATCH", "/projects/test-project/datasets/test-dataset/tables/test-table");
      verifySpan("com.google.cloud.bigquery.BigQueryRpc.patchTable", "TableService", "PatchTable");
    }

    @Test
    public void testGetModel() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#model\",\"modelReference\":{\"projectId\":\"test-project\",\"datasetId\":\"test-dataset\",\"modelId\":\"test-model\"}}");

      rpc.getModelSkipExceptionTranslation(
          "test-project", "test-dataset", "test-model", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/models/test-model");
      verifySpan("com.google.cloud.bigquery.BigQueryRpc.getModel", "ModelService", "GetModel");
    }

    @Test
    public void testListModels() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#modelList\",\"models\":[]}");

      rpc.listModelsSkipExceptionTranslation("test-project", "test-dataset", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/models");
      verifySpan("com.google.cloud.bigquery.BigQueryRpc.listModels", "ModelService", "ListModels");
    }

    @Test
    public void testPatchModel() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#model\",\"modelReference\":{\"projectId\":\"test-project\",\"datasetId\":\"test-dataset\",\"modelId\":\"test-model\"}}");

      Model model = new Model();
      model.setModelReference(
          new ModelReference()
              .setProjectId("test-project")
              .setDatasetId("test-dataset")
              .setModelId("test-model"));
      rpc.patchSkipExceptionTranslation(model, new HashMap<>());

      verifyRequest("PATCH", "/projects/test-project/datasets/test-dataset/models/test-model");
      verifySpan("com.google.cloud.bigquery.BigQueryRpc.patchModel", "ModelService", "PatchModel");
    }

    @Test
    public void testDeleteModel() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteModelSkipExceptionTranslation("test-project", "test-dataset", "test-model");

      verifyRequest("DELETE", "/projects/test-project/datasets/test-dataset/models/test-model");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.deleteModel", "ModelService", "DeleteModel");
    }

    @Test
    public void testGetRoutine() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#routine\",\"routineReference\":{\"projectId\":\"test-project\",\"datasetId\":\"test-dataset\",\"routineId\":\"test-routine\"}}");

      rpc.getRoutineSkipExceptionTranslation(
          "test-project", "test-dataset", "test-routine", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/routines/test-routine");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getRoutine", "RoutineService", "GetRoutine");
    }

    @Test
    public void testListRoutines() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#routineList\",\"routines\":[]}");

      rpc.listRoutinesSkipExceptionTranslation("test-project", "test-dataset", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/routines");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.listRoutines", "RoutineService", "ListRoutines");
    }

    @Test
    public void testCreateRoutine() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#routine\",\"routineReference\":{\"projectId\":\"test-project\",\"datasetId\":\"test-dataset\",\"routineId\":\"test-routine\"}}");

      Routine routine = new Routine();
      routine.setRoutineReference(
          new RoutineReference()
              .setProjectId("test-project")
              .setDatasetId("test-dataset")
              .setRoutineId("test-routine"));
      rpc.createSkipExceptionTranslation(routine, new HashMap<>());

      verifyRequest("POST", "/projects/test-project/datasets/test-dataset/routines");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.createRoutine", "RoutineService", "InsertRoutine");
    }

    @Test
    public void testDeleteRoutine() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteRoutineSkipExceptionTranslation("test-project", "test-dataset", "test-routine");

      verifyRequest("DELETE", "/projects/test-project/datasets/test-dataset/routines/test-routine");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.listRoutines", "RoutineService", "ListRoutines");
    }

    @Test
    public void testUpdateRoutine() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#routine\",\"routineReference\":{\"projectId\":\"test-project\",\"datasetId\":\"test-dataset\",\"routineId\":\"test-routine\"}}");

      Routine routine = new Routine();
      routine.setRoutineReference(
          new RoutineReference()
              .setProjectId("test-project")
              .setDatasetId("test-dataset")
              .setRoutineId("test-routine"));
      rpc.updateSkipExceptionTranslation(routine, new HashMap<>());

      verifyRequest("PUT", "/projects/test-project/datasets/test-dataset/routines/test-routine");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.updateRoutine", "RoutineService", "UpdateRoutine");
    }

    @Test
    public void testInsertAll() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#tableDataInsertAllResponse\"}");

      TableDataInsertAllRequest request = new TableDataInsertAllRequest();
      rpc.insertAllSkipExceptionTranslation("test-project", "test-dataset", "test-table", request);

      verifyRequest(
          "POST", "/projects/test-project/datasets/test-dataset/tables/test-table/insertAll");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.insertAll", "TableDataService", "InsertAll");
    }

    @Test
    public void testListTableData() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#tableDataList\",\"rows\":[]}");

      rpc.listTableDataSkipExceptionTranslation(
          "test-project", "test-dataset", "test-table", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/tables/test-table/data");
      verifySpan("com.google.cloud.bigquery.BigQueryRpc.listTableData", "TableDataService", "List");
    }

    @Test
    public void testListTableDataWithRowLimit() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#tableDataList\",\"rows\":[]}");

      rpc.listTableDataWithRowLimitSkipExceptionTranslation(
          "test-project", "test-dataset", "test-table", 10, null);

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/tables/test-table/data");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.listTableDataWithRowLimit",
          "TableDataService",
          "List");
    }

    @Test
    public void testGetJob() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\"test-project:test-job\",\"status\":{\"state\":\"DONE\"}}");

      rpc.getJobSkipExceptionTranslation(
          "test-project", "test-job", "test-location", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/jobs/test-job");
      verifySpan("com.google.cloud.bigquery.BigQueryRpc.getJob", "JobService", "GetJob");
    }

    @Test
    public void testGetQueryJob() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\"test-project:test-job\",\"status\":{\"state\":\"DONE\"}}");

      rpc.getQueryJobSkipExceptionTranslation("test-project", "test-job", "test-location");

      verifyRequest("GET", "/projects/test-project/jobs/test-job");
      verifySpan("com.google.cloud.bigquery.BigQueryRpc.getQueryJob", "JobService", "GetJob");
    }

    @Test
    public void testListJobs() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#jobList\",\"jobs\":[]}");

      rpc.listJobsSkipExceptionTranslation("test-project", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/jobs");
      verifySpan("com.google.cloud.bigquery.BigQueryRpc.listJobs", "JobService", "ListJobs");
    }

    @Test
    public void testCreateJob() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\"test-project:test-job\",\"status\":{\"state\":\"DONE\"}}");

      Job job = new Job();
      job.setJobReference(new JobReference().setProjectId("test-project").setJobId("test-job"));
      rpc.createSkipExceptionTranslation(job, new HashMap<>());

      verifyRequest("POST", "/projects/test-project/jobs");
      verifySpan("com.google.cloud.bigquery.BigQueryRpc.createJob", "JobService", "InsertJob");
    }

    @Test
    public void testCreateJobForQuery() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\"test-project:test-job\",\"status\":{\"state\":\"DONE\"}}");

      Job job = new Job();
      job.setJobReference(new JobReference().setProjectId("test-project").setJobId("test-job"));
      rpc.createJobForQuerySkipExceptionTranslation(job);

      verifyRequest("POST", "/projects/test-project/jobs");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.createJobForQuery", "JobService", "InsertJob");
    }

    @Test
    public void testCancelJob() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#jobCancelResponse\"}");

      rpc.cancelSkipExceptionTranslation("test-project", "test-job", "test-location");

      verifyRequest("POST", "/projects/test-project/jobs/test-job/cancel");
      verifySpan("com.google.cloud.bigquery.BigQueryRpc.cancelJob", "JobService", "CancelJob");
    }

    @Test
    public void testDeleteJob() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteJobSkipExceptionTranslation("test-project", "test-job", "test-location");

      verifyRequest("DELETE", "/projects/test-project/jobs/test-job");
      verifySpan("com.google.cloud.bigquery.BigQueryRpc.deleteJob", "JobService", "DeleteJob");
    }

    @Test
    public void testGetQueryResults() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#getQueryResultsResponse\"}");

      rpc.getQueryResultsSkipExceptionTranslation(
          "test-project", "test-job", "test-location", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/queries/test-job");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getQueryResults", "JobService", "GetQueryResults");
    }

    @Test
    public void testGetQueryResultsWithRowLimit() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#getQueryResultsResponse\"}");

      rpc.getQueryResultsWithRowLimitSkipExceptionTranslation(
          "test-project", "test-job", "test-location", 10, 1000L);

      verifyRequest("GET", "/projects/test-project/queries/test-job");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getQueryResultsWithRowLimit",
          "JobService",
          "GetQueryResults");
    }

    @Test
    public void testQueryRpc() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#queryResponse\"}");

      rpc.queryRpcSkipExceptionTranslation("test-project", new QueryRequest());

      verifyRequest("POST", "/projects/test-project/queries");
      verifySpan("com.google.cloud.bigquery.BigQueryRpc.queryRpc", "JobService", "Query");
    }

    @Test
    public void testGetIamPolicy() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#policy\"}");

      rpc.getIamPolicySkipExceptionTranslation(
          "projects/test-project/datasets/test-dataset/tables/test-table", new HashMap<>());

      verifyRequest(
          "POST", "/projects/test-project/datasets/test-dataset/tables/test-table:getIamPolicy");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.getIamPolicy", "TableService", "GetIamPolicy");
    }

    @Test
    public void testSetIamPolicy() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#policy\"}");

      rpc.setIamPolicySkipExceptionTranslation(
          "projects/test-project/datasets/test-dataset/tables/test-table",
          new Policy(),
          new HashMap<>());

      verifyRequest(
          "POST", "/projects/test-project/datasets/test-dataset/tables/test-table:setIamPolicy");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.setIamPolicy", "TableService", "SetIamPolicy");
    }

    @Test
    public void testTestIamPermissions() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#testIamPermissionsResponse\"}");

      rpc.testIamPermissionsSkipExceptionTranslation(
          "projects/test-project/datasets/test-dataset/tables/test-table",
          Arrays.asList("p1", "p2"),
          new HashMap<>());

      verifyRequest(
          "POST",
          "/projects/test-project/datasets/test-dataset/tables/test-table:testIamPermissions");
      verifySpan(
          "com.google.cloud.bigquery.BigQueryRpc.setIamPolicy", "TableService", "SetIamPolicy");
    }
  }

  @Nested
  class TelemetryDisabled {
    private HttpBigQueryRpc rpc;

    @BeforeEach
    public void setUp() {
      rpc = createRpc(false);
    }

    @Test
    public void testGetDataset() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#dataset\",\"id\":\"test-project:test-dataset\",\"datasetReference\":{\"projectId\":\"test-project\",\"datasetId\":\"test-dataset\"}}");

      rpc.getDatasetSkipExceptionTranslation("test-project", "test-dataset", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset");
      verifyNoSpans();
    }

    @Test
    public void testListDatasets() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#datasetList\",\"datasets\":[]}");

      rpc.listDatasetsSkipExceptionTranslation("test-project", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets");
      verifyNoSpans();
    }

    @Test
    public void testCreateDataset() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#dataset\",\"id\":\"test-project:test-dataset\"}");

      Dataset dataset = new Dataset();
      dataset.setDatasetReference(
          new DatasetReference().setProjectId("test-project").setDatasetId("test-dataset"));
      rpc.createSkipExceptionTranslation(dataset, new HashMap<>());

      verifyRequest("POST", "/projects/test-project/datasets");
      verifyNoSpans();
    }

    @Test
    public void testDeleteDataset() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteDatasetSkipExceptionTranslation("test-project", "test-dataset", new HashMap<>());

      verifyRequest("DELETE", "/projects/test-project/datasets/test-dataset");
      verifyNoSpans();
    }

    @Test
    public void testPatchDataset() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#dataset\",\"id\":\"test-project:test-dataset\"}");

      Dataset dataset = new Dataset();
      dataset.setDatasetReference(
          new DatasetReference().setProjectId("test-project").setDatasetId("test-dataset"));
      rpc.patchSkipExceptionTranslation(dataset, new HashMap<>());

      verifyRequest("PATCH", "/projects/test-project/datasets/test-dataset");
      verifyNoSpans();
    }

    @Test
    public void testGetTable() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#table\",\"id\":\"test-project:test-dataset.test-table\"}");

      rpc.getTableSkipExceptionTranslation(
          "test-project", "test-dataset", "test-table", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/tables/test-table");
      verifyNoSpans();
    }

    @Test
    public void testListTables() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#tableList\",\"tables\":[]}");

      rpc.listTablesSkipExceptionTranslation("test-project", "test-dataset", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/tables");
      verifyNoSpans();
    }

    @Test
    public void testCreateTable() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#table\",\"id\":\"test-project:test-dataset.test-table\"}");

      Table table = new Table();
      table.setTableReference(
          new TableReference()
              .setProjectId("test-project")
              .setDatasetId("test-dataset")
              .setTableId("test-table"));
      rpc.createSkipExceptionTranslation(table, new HashMap<>());

      verifyRequest("POST", "/projects/test-project/datasets/test-dataset/tables");
      verifyNoSpans();
    }

    @Test
    public void testDeleteTable() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteTableSkipExceptionTranslation("test-project", "test-dataset", "test-table");

      verifyRequest("DELETE", "/projects/test-project/datasets/test-dataset/tables/test-table");
      verifyNoSpans();
    }

    @Test
    public void testPatchTable() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#table\",\"id\":\"test-project:test-dataset.test-table\"}");

      Table table = new Table();
      table.setTableReference(
          new TableReference()
              .setProjectId("test-project")
              .setDatasetId("test-dataset")
              .setTableId("test-table"));
      rpc.patchSkipExceptionTranslation(table, new HashMap<>());

      verifyRequest("PATCH", "/projects/test-project/datasets/test-dataset/tables/test-table");
      verifyNoSpans();
    }

    @Test
    public void testGetModel() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#model\",\"modelReference\":{\"projectId\":\"test-project\",\"datasetId\":\"test-dataset\",\"modelId\":\"test-model\"}}");

      rpc.getModelSkipExceptionTranslation(
          "test-project", "test-dataset", "test-model", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/models/test-model");
      verifyNoSpans();
    }

    @Test
    public void testListModels() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#modelList\",\"models\":[]}");

      rpc.listModelsSkipExceptionTranslation("test-project", "test-dataset", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/models");
      verifyNoSpans();
    }

    @Test
    public void testPatchModel() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#model\",\"modelReference\":{\"projectId\":\"test-project\",\"datasetId\":\"test-dataset\",\"modelId\":\"test-model\"}}");

      Model model = new Model();
      model.setModelReference(
          new ModelReference()
              .setProjectId("test-project")
              .setDatasetId("test-dataset")
              .setModelId("test-model"));
      rpc.patchSkipExceptionTranslation(model, new HashMap<>());

      verifyRequest("PATCH", "/projects/test-project/datasets/test-dataset/models/test-model");
      verifyNoSpans();
    }

    @Test
    public void testDeleteModel() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteModelSkipExceptionTranslation("test-project", "test-dataset", "test-model");

      verifyRequest("DELETE", "/projects/test-project/datasets/test-dataset/models/test-model");
      verifyNoSpans();
    }

    @Test
    public void testGetRoutine() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#routine\",\"routineReference\":{\"projectId\":\"test-project\",\"datasetId\":\"test-dataset\",\"routineId\":\"test-routine\"}}");

      rpc.getRoutineSkipExceptionTranslation(
          "test-project", "test-dataset", "test-routine", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/routines/test-routine");
      verifyNoSpans();
    }

    @Test
    public void testListRoutines() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#routineList\",\"routines\":[]}");

      rpc.listRoutinesSkipExceptionTranslation("test-project", "test-dataset", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/routines");
      verifyNoSpans();
    }

    @Test
    public void testCreateRoutine() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#routine\",\"routineReference\":{\"projectId\":\"test-project\",\"datasetId\":\"test-dataset\",\"routineId\":\"test-routine\"}}");

      Routine routine = new Routine();
      routine.setRoutineReference(
          new RoutineReference()
              .setProjectId("test-project")
              .setDatasetId("test-dataset")
              .setRoutineId("test-routine"));
      rpc.createSkipExceptionTranslation(routine, new HashMap<>());

      verifyRequest("POST", "/projects/test-project/datasets/test-dataset/routines");
      verifyNoSpans();
    }

    @Test
    public void testDeleteRoutine() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteRoutineSkipExceptionTranslation("test-project", "test-dataset", "test-routine");

      verifyRequest("DELETE", "/projects/test-project/datasets/test-dataset/routines/test-routine");
      verifyNoSpans();
    }

    @Test
    public void testUpdateRoutine() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#routine\",\"routineReference\":{\"projectId\":\"test-project\",\"datasetId\":\"test-dataset\",\"routineId\":\"test-routine\"}}");

      Routine routine = new Routine();
      routine.setRoutineReference(
          new RoutineReference()
              .setProjectId("test-project")
              .setDatasetId("test-dataset")
              .setRoutineId("test-routine"));
      rpc.updateSkipExceptionTranslation(routine, new HashMap<>());

      verifyRequest("PUT", "/projects/test-project/datasets/test-dataset/routines/test-routine");
      verifyNoSpans();
    }

    @Test
    public void testInsertAll() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#tableDataInsertAllResponse\"}");

      TableDataInsertAllRequest request = new TableDataInsertAllRequest();
      rpc.insertAllSkipExceptionTranslation("test-project", "test-dataset", "test-table", request);

      verifyRequest(
          "POST", "/projects/test-project/datasets/test-dataset/tables/test-table/insertAll");
      verifyNoSpans();
    }

    @Test
    public void testListTableData() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#tableDataList\",\"rows\":[]}");

      rpc.listTableDataSkipExceptionTranslation(
          "test-project", "test-dataset", "test-table", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/tables/test-table/data");
      verifyNoSpans();
    }

    @Test
    public void testListTableDataWithRowLimit() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#tableDataList\",\"rows\":[]}");

      rpc.listTableDataWithRowLimitSkipExceptionTranslation(
          "test-project", "test-dataset", "test-table", 10, null);

      verifyRequest("GET", "/projects/test-project/datasets/test-dataset/tables/test-table/data");
      verifyNoSpans();
    }

    @Test
    public void testGetJob() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\"test-project:test-job\",\"status\":{\"state\":\"DONE\"}}");

      rpc.getJobSkipExceptionTranslation(
          "test-project", "test-job", "test-location", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/jobs/test-job");
      verifyNoSpans();
    }

    @Test
    public void testGetQueryJob() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\"test-project:test-job\",\"status\":{\"state\":\"DONE\"}}");

      rpc.getQueryJobSkipExceptionTranslation("test-project", "test-job", "test-location");

      verifyRequest("GET", "/projects/test-project/jobs/test-job");
      verifyNoSpans();
    }

    @Test
    public void testListJobs() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#jobList\",\"jobs\":[]}");

      rpc.listJobsSkipExceptionTranslation("test-project", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/jobs");
      verifyNoSpans();
    }

    @Test
    public void testCreateJob() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\"test-project:test-job\",\"status\":{\"state\":\"DONE\"}}");

      Job job = new Job();
      job.setJobReference(new JobReference().setProjectId("test-project").setJobId("test-job"));
      rpc.createSkipExceptionTranslation(job, new HashMap<>());

      verifyRequest("POST", "/projects/test-project/jobs");
      verifyNoSpans();
    }

    @Test
    public void testCreateJobForQuery() throws Exception {
      setMockResponse(
          "{\"kind\":\"bigquery#job\",\"id\":\"test-project:test-job\",\"status\":{\"state\":\"DONE\"}}");

      Job job = new Job();
      job.setJobReference(new JobReference().setProjectId("test-project").setJobId("test-job"));
      rpc.createJobForQuerySkipExceptionTranslation(job);

      verifyRequest("POST", "/projects/test-project/jobs");
      verifyNoSpans();
    }

    @Test
    public void testCancelJob() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#jobCancelResponse\"}");

      rpc.cancelSkipExceptionTranslation("test-project", "test-job", "test-location");

      verifyRequest("POST", "/projects/test-project/jobs/test-job/cancel");
      verifyNoSpans();
    }

    @Test
    public void testDeleteJob() throws Exception {
      setMockResponse("");
      mockResponse.setStatusCode(204);

      rpc.deleteJobSkipExceptionTranslation("test-project", "test-job", "test-location");

      verifyRequest("DELETE", "/projects/test-project/jobs/test-job");
      verifyNoSpans();
    }

    @Test
    public void testGetQueryResults() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#getQueryResultsResponse\"}");

      rpc.getQueryResultsSkipExceptionTranslation(
          "test-project", "test-job", "test-location", new HashMap<>());

      verifyRequest("GET", "/projects/test-project/queries/test-job");
      verifyNoSpans();
    }

    @Test
    public void testGetQueryResultsWithRowLimit() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#getQueryResultsResponse\"}");

      rpc.getQueryResultsWithRowLimitSkipExceptionTranslation(
          "test-project", "test-job", "test-location", 10, 1000L);

      verifyRequest("GET", "/projects/test-project/queries/test-job");
      verifyNoSpans();
    }

    @Test
    public void testQueryRpc() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#queryResponse\"}");

      rpc.queryRpcSkipExceptionTranslation("test-project", new QueryRequest());

      verifyRequest("POST", "/projects/test-project/queries");
      verifyNoSpans();
    }

    @Test
    public void testGetIamPolicy() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#policy\"}");

      rpc.getIamPolicySkipExceptionTranslation(
          "projects/test-project/datasets/test-dataset/tables/test-table", new HashMap<>());

      verifyRequest(
          "POST", "/projects/test-project/datasets/test-dataset/tables/test-table:getIamPolicy");
      verifyNoSpans();
    }

    @Test
    public void testSetIamPolicy() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#policy\"}");

      rpc.setIamPolicySkipExceptionTranslation(
          "projects/test-project/datasets/test-dataset/tables/test-table",
          new Policy(),
          new HashMap<>());

      verifyRequest(
          "POST", "/projects/test-project/datasets/test-dataset/tables/test-table:setIamPolicy");
      verifyNoSpans();
    }

    @Test
    public void testTestIamPermissions() throws Exception {
      setMockResponse("{\"kind\":\"bigquery#testIamPermissionsResponse\"}");

      rpc.testIamPermissionsSkipExceptionTranslation(
          "projects/test-project/datasets/test-dataset/tables/test-table",
          Arrays.asList("p1", "p2"),
          new HashMap<>());

      verifyRequest(
          "POST",
          "/projects/test-project/datasets/test-dataset/tables/test-table:testIamPermissions");
      verifyNoSpans();
    }
  }
}
