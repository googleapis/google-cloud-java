/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.devtools.containeranalysis.v1;

import static org.junit.Assert.assertEquals;

import io.grafeas.v1.GrafeasClient;
import io.grafeas.v1.GrafeasSettings;
import java.io.IOException;
import org.junit.Test;

/**
 * This test requires application default credentials. They are available if running in Google
 * Compute Engine. Otherwise, the environment variable GOOGLE_APPLICATION_CREDENTIALS must point to
 * a file containing the credentials.
 */
public class ITGrafeasInteropTest {

  @Test
  public void createsGrafeasClient() throws IOException {
    ContainerAnalysisClient client =
        ContainerAnalysisClient.create(ContainerAnalysisSettings.newBuilder().build());
    GrafeasClient grafeasClient = client.getGrafeasClient();

    ContainerAnalysisSettings settings = client.getSettings();
    GrafeasSettings grafeasSettings = grafeasClient.getSettings();

    assertEquals(settings.getClock(), grafeasSettings.getClock());
    assertEquals(settings.getBackgroundExecutorProvider(), grafeasSettings.getExecutorProvider());
    assertEquals(settings.getEndpoint(), grafeasSettings.getEndpoint());
    assertEquals(settings.getBackgroundExecutorProvider(), grafeasSettings.getExecutorProvider());
    assertEquals(settings.getHeaderProvider(), grafeasSettings.getHeaderProvider());
    assertEquals(
        settings.getTransportChannelProvider(), grafeasSettings.getTransportChannelProvider());
    assertEquals(settings.getWatchdogCheckInterval(), grafeasSettings.getWatchdogCheckInterval());
    assertEquals(settings.getWatchdogProvider(), grafeasSettings.getWatchdogProvider());
  }
}
