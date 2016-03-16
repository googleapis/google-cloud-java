/**
 * Copyright (c) 2015 Google Inc.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


import com.google.api.services.monitoring.v3.Monitoring;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Integration tests for the basic Cloud Monitoring v3 examples. Running
 * these tests requires that GOOGLE_APPLICATION_CREDENTIALS points to a
 * valid JSON Service Account downloaded from a project with the Cloud
 * Monitoring API enabled.
 */
public class ListResourcesTest {

  /**
   * The project ID of the project created for the integration tests.
   */
  public static final String TEST_PROJECT_ID = "cloud-monitoring-dev";

  /**
   * Google Cloud Monitoring client to integration test.
   */
  private ListResources underTest;

  /**
   * Output stream to capture output and verify expected output.
   */
  private ByteArrayOutputStream os;

  @Before
  public void setUp() throws Exception {
    Monitoring monitoringService = ListResources.authenticate();
    os = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(os);
    String projectResource = "projects/" + TEST_PROJECT_ID;
    underTest = new ListResources(monitoringService, projectResource, ps);
  }

  /**
   * Integration tests that tests that getting the monitored resource returns
   * the expected strings.
   */
  @Test
  public void testListMonitoredResourceDescriptors() throws Exception {
    this.underTest.listMonitoredResourceDescriptors();
    String result = new String(os.toByteArray());
    Assert.assertTrue(result.contains("An application running in Google App Engine"));
  }

  /**
   * Integration tests that tests that getting the metric returns
   * the expected strings.
   */
  @Test
  public void testListMetrics() throws Exception {
    this.underTest.listMetricDescriptors();
    String result = new String(os.toByteArray());
    Assert.assertTrue(result.contains("Delta CPU usage time. Units are second"));
  }

  /**
   * Integration tests that tests that getting time series returns
   * the expected strings.
   */
  @Test
  public void testListTimeseries() throws Exception {
    this.underTest.listTimeseries();
    String result = new String(os.toByteArray());
    Assert.assertTrue(result.contains("listTimeseries response"));
  }

}
