/*
 * Copyright 2024 Google LLC
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

package com.example.bigquerystorage;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.opentelemetry.metric.GoogleCloudMetricExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExportOpenTelemetryIT {

  private static final String GOOGLE_CLOUD_PROJECT = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static SdkMeterProvider METER_PROVIDER = null;

  private ByteArrayOutputStream bout;
  private PrintStream out;
  private BigQuery bigquery;
  private String datasetName;
  private String tableName;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  private void setupGoogleCloudMonitoringOT() {
    MetricExporter metricExporter = GoogleCloudMetricExporter.createWithDefaultConfiguration();
    METER_PROVIDER =
        SdkMeterProvider.builder()
            .registerMetricReader(
                PeriodicMetricReader.builder(metricExporter)
                    .setInterval(java.time.Duration.ofMillis(30000))
                    .build())
            .build();
    OpenTelemetrySdk.builder().setMeterProvider(METER_PROVIDER).buildAndRegisterGlobal();
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

    setupGoogleCloudMonitoringOT();
    bigquery = BigQueryOptions.getDefaultInstance().getService();

    // Create a new dataset and table for each test.
    datasetName = "WRITE_STREAM_TEST" + UUID.randomUUID().toString().substring(0, 8);
    tableName = "DEFAULT_STREAM_TEST" + UUID.randomUUID().toString().substring(0, 8);
    Schema schema =
        Schema.of(
            com.google.cloud.bigquery.Field.newBuilder("test_string", StandardSQLTypeName.STRING)
                .setMaxLength(20L)
                .build(),
            com.google.cloud.bigquery.Field.newBuilder("test_bytes", StandardSQLTypeName.BYTES)
                .build(),
            com.google.cloud.bigquery.Field.newBuilder("test_geo", StandardSQLTypeName.GEOGRAPHY)
                .build());
    bigquery.create(DatasetInfo.newBuilder(datasetName).build());
    TableInfo tableInfo =
        TableInfo.newBuilder(TableId.of(datasetName, tableName), StandardTableDefinition.of(schema))
            .build();
    bigquery.create(tableInfo);
  }

  @After
  public void tearDown() {
    bigquery.delete(
        DatasetId.of(GOOGLE_CLOUD_PROJECT, datasetName), DatasetDeleteOption.deleteContents());
    System.setOut(null);
    if (METER_PROVIDER != null) {
      METER_PROVIDER.shutdown();
    }
  }

  @Test
  public void testExportOpenTelemetry() throws Exception {
    ExportOpenTelemetry.exportToOpenTelemetry(GOOGLE_CLOUD_PROJECT, datasetName, tableName);
    assertThat(bout.toString()).contains("Appended records successfully.");
  }
}
