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
import com.google.api.services.monitoring.v3.model.Point;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * Integration tests for the basic Cloud Monitoring v3 examples. Running
 * these tests requires that GOOGLE_APPLICATION_CREDENTIALS points to a
 * valid JSON Service Account downloaded from a project with the Cloud
 * Monitoring API enabled.
 */
public class CreateCustomMetricTest {

  /**
   * Overrides the Random number generator so our tests get a predictable result.
   */
  private static class MockRandom extends Random {

    public int nextInt(int bound) {
      return 4;
    }
  }

  /**
   * Google Cloud Monitoring client to integration test.
   */
  private CreateCustomMetric underTest;

  /**
   * Creates the monitoring service client.
   *
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    Monitoring monitoringService = ListResources.authenticate();
    String projectResource = "projects/" + ListResourcesTest.TEST_PROJECT_ID;
    String name = RandomStringUtils.randomAlphanumeric(20).toUpperCase();
    underTest = new CreateCustomMetric(monitoringService, projectResource, name, 1);
  }

  /**
   * Tests that the value written for a custom metric can be read back correctly.
   *
   * @throws Exception
   */
  @Test
  public void testValueRead() throws Exception {
    underTest.createCustomMetric();

    while (underTest.getCustomMetric() == null) {
      Thread.sleep(2000);
    }
    underTest.writeCustomMetricTimeseriesValue();
    // give time for write to register
    Thread.sleep(2000);
    List<Point> response = underTest.readTimeseriesValue()
        .getTimeSeries().get(0).getPoints();

    boolean found = false;
    for (Point p : response) {
      System.out.println("found a response " + p.getValue().getInt64Value());
      if (p.getValue().getInt64Value() == 0) {
        found = true;
      }
    }
    Assert.assertTrue(found);
  }

}
