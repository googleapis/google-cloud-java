/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.monitoring.spi.v3;

import com.google.api.MonitoredResource;
import com.google.api.gax.testing.MockGrpcService;
import com.google.api.gax.testing.MockServiceHelper;
import com.google.monitoring.v3.CollectdPayload;
import com.google.monitoring.v3.CreateCollectdTimeSeriesRequest;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class AgentTranslationServiceTest {
  private static MockGroupService mockGroupService;
  private static MockMetricService mockMetricService;
  private static MockAgentTranslationService mockAgentTranslationService;
  private static MockServiceHelper serviceHelper;
  private AgentTranslationServiceApi api;

  @BeforeClass
  public static void startStaticServer() {
    mockGroupService = new MockGroupService();
    mockMetricService = new MockMetricService();
    mockAgentTranslationService = new MockAgentTranslationService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockGroupService, mockMetricService, mockAgentTranslationService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    AgentTranslationServiceSettings settings =
        AgentTranslationServiceSettings.defaultBuilder()
            .provideChannelWith(serviceHelper.createChannel(), true)
            .build();
    api = AgentTranslationServiceApi.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    api.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createCollectdTimeSeriesTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockAgentTranslationService.setResponses(expectedResponses);

    String formattedName = AgentTranslationServiceApi.formatProjectName("[PROJECT]");
    MonitoredResource resource = MonitoredResource.newBuilder().build();
    String collectdVersion = "collectdVersion-177050093";
    List<CollectdPayload> collectdPayloads = new ArrayList<>();

    api.createCollectdTimeSeries(formattedName, resource, collectdVersion, collectdPayloads);

    List<GeneratedMessageV3> actualRequests = mockAgentTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCollectdTimeSeriesRequest actualRequest =
        (CreateCollectdTimeSeriesRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(collectdVersion, actualRequest.getCollectdVersion());
    Assert.assertEquals(collectdPayloads, actualRequest.getCollectdPayloadsList());
  }
}
