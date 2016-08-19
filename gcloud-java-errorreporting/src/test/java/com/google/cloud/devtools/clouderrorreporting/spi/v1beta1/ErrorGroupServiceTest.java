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

package com.google.cloud.devtools.clouderrorreporting.spi.v1beta1;

import com.google.api.gax.core.PageAccessor;
import com.google.api.gax.testing.MockGrpcService;
import com.google.api.gax.testing.MockServiceHelper;
import com.google.common.collect.Lists;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup;
import com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest;
import com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest;
import com.google.protobuf.GeneratedMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class ErrorGroupServiceTest {
  private static MockServiceHelper serviceHelper;
  private ErrorGroupServiceApi api;

  @BeforeClass
  public static void startStaticServer() {
    MockErrorGroupService mockService = new MockErrorGroupService();
    serviceHelper = new MockServiceHelper("in-process-1", mockService);
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    ErrorGroupServiceSettings settings =
        ErrorGroupServiceSettings.defaultBuilder()
            .provideChannelWith(serviceHelper.createChannel(), true)
            .build();
    api = ErrorGroupServiceApi.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    api.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getGroupTest() {
    ErrorGroup expectedResponse = ErrorGroup.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String formattedGroupName = ErrorGroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
    ErrorGroup actualResponse = api.getGroup(formattedGroupName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGroupRequest actualRequest = (GetGroupRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getGroupName(), formattedGroupName);
  }

  @Test
  @SuppressWarnings("all")
  public void updateGroupTest() {
    ErrorGroup expectedResponse = ErrorGroup.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    ErrorGroup group = ErrorGroup.newBuilder().build();
    ErrorGroup actualResponse = api.updateGroup(group);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGroupRequest actualRequest = (UpdateGroupRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getGroup(), group);
  }
}
