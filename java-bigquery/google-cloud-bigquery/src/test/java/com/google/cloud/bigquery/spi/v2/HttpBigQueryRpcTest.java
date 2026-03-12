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
import com.google.cloud.NoCredentials;
import com.google.cloud.bigquery.BigQueryOptions;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

public class HttpBigQueryRpcTest {
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

  @Test
  public void testOpenTelemetrySpanCreation() throws Exception {
    InMemorySpanExporter spanExporter = InMemorySpanExporter.create();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
    Tracer tracer = openTelemetry.getTracer("test-tracer");

    HttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() {
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(200);
                response.setContentType(Json.MEDIA_TYPE);
                // Return a minimal valid dataset JSON
                response.setContent(
                    "{"
                        + "\"kind\":\"bigquery#dataset\","
                        + "\"id\":\"test-project:test-dataset\","
                        + "\"datasetReference\":{"
                        + "  \"projectId\":\"test-project\","
                        + "  \"datasetId\":\"test-dataset\""
                        + "}"
                        + "}");
                return response;
              }
            };
          }
        };

    // Create BigQueryOptions with OpenTelemetry enabled and custom transport
    BigQueryOptions options =
        BigQueryOptions.newBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEnableOpenTelemetryTracing(true)
            .setOpenTelemetryTracer(tracer)
            .setTransportOptions(
                BigQueryOptions.getDefaultHttpTransportOptions().toBuilder()
                    .setHttpTransportFactory(() -> mockTransport)
                    .build())
            .build();
    HttpBigQueryRpc rpc = new HttpBigQueryRpc(options);

    Dataset result = rpc.getDataset("test-project", "test-dataset", new HashMap<>());

    // Verify the RPC call succeeded
    assertNotNull(result);
    assertEquals("test-project", result.getDatasetReference().getProjectId());
    assertEquals("test-dataset", result.getDatasetReference().getDatasetId());

    // Verify that spans were created
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertThat(spans).isNotEmpty();

    // Find the RPC span (should be the one we created in executeWithSpan)
    SpanData rpcSpan =
        spans.stream()
            .filter(span -> span.getName().contains("BigQueryRpc.getDataset"))
            .findFirst()
            .orElse(null);

    assertNotNull(rpcSpan, "Expected to find a span for BigQueryRpc.getDataset");

    // Verify span attributes are set correctly
    assertEquals(
        "DatasetService",
        rpcSpan
            .getAttributes()
            .asMap()
            .get(io.opentelemetry.api.common.AttributeKey.stringKey("bq.rpc.service")));
    assertEquals(
        "GetDataset",
        rpcSpan
            .getAttributes()
            .asMap()
            .get(io.opentelemetry.api.common.AttributeKey.stringKey("bq.rpc.method")));
    assertEquals(
        "http",
        rpcSpan
            .getAttributes()
            .asMap()
            .get(io.opentelemetry.api.common.AttributeKey.stringKey("bq.rpc.system")));
  }
}
