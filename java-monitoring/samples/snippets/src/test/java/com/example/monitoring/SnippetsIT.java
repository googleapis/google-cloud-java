/*
 * Copyright 2016 Google Inc.
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

package com.example.monitoring;

import static com.google.common.truth.Truth.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for quickstart sample.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class SnippetsIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private static final String LEGACY_PROJECT_ENV_NAME = "GCLOUD_PROJECT";
  private static final String PROJECT_ENV_NAME = "GOOGLE_CLOUD_PROJECT";

  private static String getProjectId() {
    String projectId = System.getProperty(PROJECT_ENV_NAME, System.getenv(PROJECT_ENV_NAME));
    if (projectId == null) {
      projectId = System.getProperty(LEGACY_PROJECT_ENV_NAME,
          System.getenv(LEGACY_PROJECT_ENV_NAME));
    }
    return projectId;
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testListMetricsDescriptor() throws Exception {
    // Act
    System.setProperty("projectId", SnippetsIT.getProjectId());
    Snippets snippets = new Snippets();

    snippets.listMetricDescriptors();
    // Assert
    String got = bout.toString();
    assertThat(got).contains("metricDescriptors/bigquery.googleapis.com/query/count");
  }

  @Test
  public void testGetMetricsDescriptor() throws Exception {
    // Act
    System.setProperty("projectId", SnippetsIT.getProjectId());
    Snippets snippets = new Snippets();

    snippets.getMonitoredResource("api");

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Produced API");
  }

  @Test
  public void testListTimeSeries() throws Exception {
    // Act
    System.setProperty("projectId", SnippetsIT.getProjectId());
    Snippets snippets = new Snippets();

    snippets.listTimeSeries("metric.type=\"compute.googleapis.com/instance/cpu/utilization\"");

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Got timeseries:");
  }

  @Test
  public void testListTimeSeriesHeader() throws Exception {
    // Act
    System.setProperty("projectId", SnippetsIT.getProjectId());
    Snippets snippets = new Snippets();

    snippets.listTimeSeriesHeaders();

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Got timeseries headers:");
  }

  @Test
  public void testListTimeSeriesAggregate() throws Exception {
    // Act
    System.setProperty("projectId", SnippetsIT.getProjectId());
    Snippets snippets = new Snippets();

    snippets.listTimeSeriesAggregrate();

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Got timeseries:");
  }

  @Test
  public void testListTimeSeriesReduce() throws Exception {
    // Act
    System.setProperty("projectId", SnippetsIT.getProjectId());
    Snippets snippets = new Snippets();

    snippets.listTimeSeriesReduce();

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Got timeseries:");
  }

  @Test
  public void testGetResource() throws Exception {
    // Act
    System.setProperty("projectId", SnippetsIT.getProjectId());
    Snippets snippets = new Snippets();

    snippets.describeMonitoredResources("cloudsql_database");

    // Assert
    String got = bout.toString();
    assertThat(got).contains("\"A database hosted in Google Cloud SQL");
  }

  @Test
  public void testListResources() throws Exception {
    // Act
    System.setProperty("projectId", SnippetsIT.getProjectId());
    Snippets snippets = new Snippets();

    snippets.listMonitoredResources();

    // Assert
    String got = bout.toString();
    assertThat(got).contains("gce_instance");
  }
}
