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

package com.example.monitoring;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for time series sample. */
@RunWith(JUnit4.class)
public class TimeSeriesIT {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private final String filter =
      String.format("metric.type=\"compute.googleapis.com/instance/cpu/utilization\"");
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable '%s' is required to perform these tests.".format(varName),
        System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testCreateTimeSeries() throws IOException {
    CreateTimeSeries.createTimeSeries(PROJECT_ID);
    assertThat(bout.toString()).contains("Done writing time series value");
  }

  @Test
  public void testListTimeSeries() throws IOException {
    ListTimeSeries.listTimeSeries(filter, PROJECT_ID);
    assertThat(bout.toString()).contains("Got timeseries:");
  }

  @Test
  public void testListTimeSeriesHeaders() throws IOException {
    TimeSeriesHeadersList.listTimeSeriesHeaders(PROJECT_ID, filter);
    assertThat(bout.toString()).contains("Got timeseries headers:");
  }
}
