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

package com.google.cloud.errorreporting.spi.v1beta1;

import com.google.api.gax.core.PagedListResponse;
import com.google.api.gax.testing.MockGrpcService;
import com.google.api.gax.testing.MockServiceHelper;
import com.google.common.collect.Lists;
import com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ReportedErrorEvent;
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
public class ReportErrorsServiceTest {
  private static MockErrorGroupService mockErrorGroupService;
  private static MockErrorStatsService mockErrorStatsService;
  private static MockReportErrorsService mockReportErrorsService;
  private static MockServiceHelper serviceHelper;
  private ReportErrorsServiceApi api;

  @BeforeClass
  public static void startStaticServer() {
    mockErrorGroupService = new MockErrorGroupService();
    mockErrorStatsService = new MockErrorStatsService();
    mockReportErrorsService = new MockReportErrorsService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockErrorGroupService, mockErrorStatsService, mockReportErrorsService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    ReportErrorsServiceSettings settings =
        ReportErrorsServiceSettings.defaultBuilder()
            .provideChannelWith(serviceHelper.createChannel(), true)
            .build();
    api = ReportErrorsServiceApi.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    api.close();
  }

  @Test
  @SuppressWarnings("all")
  public void reportErrorEventTest() {
    ReportErrorEventResponse expectedResponse = ReportErrorEventResponse.newBuilder().build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockReportErrorsService.setResponses(expectedResponses);

    String formattedProjectName = ReportErrorsServiceApi.formatProjectName("[PROJECT]");
    ReportedErrorEvent event = ReportedErrorEvent.newBuilder().build();

    ReportErrorEventResponse actualResponse = api.reportErrorEvent(formattedProjectName, event);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockReportErrorsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReportErrorEventRequest actualRequest = (ReportErrorEventRequest) actualRequests.get(0);

    Assert.assertEquals(formattedProjectName, actualRequest.getProjectName());
    Assert.assertEquals(event, actualRequest.getEvent());
  }
}
