/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.dataflow.v1beta3;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class FlexTemplatesServiceClientTest {
  private static MockFlexTemplatesService mockFlexTemplatesService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private FlexTemplatesServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockFlexTemplatesService = new MockFlexTemplatesService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockFlexTemplatesService));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    FlexTemplatesServiceSettings settings =
        FlexTemplatesServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FlexTemplatesServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void launchFlexTemplateTest() throws Exception {
    LaunchFlexTemplateResponse expectedResponse =
        LaunchFlexTemplateResponse.newBuilder().setJob(Job.newBuilder().build()).build();
    mockFlexTemplatesService.addResponse(expectedResponse);

    LaunchFlexTemplateRequest request =
        LaunchFlexTemplateRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setLaunchParameter(LaunchFlexTemplateParameter.newBuilder().build())
            .setLocation("location1901043637")
            .setValidateOnly(true)
            .build();

    LaunchFlexTemplateResponse actualResponse = client.launchFlexTemplate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFlexTemplatesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LaunchFlexTemplateRequest actualRequest = ((LaunchFlexTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getLaunchParameter(), actualRequest.getLaunchParameter());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertEquals(request.getValidateOnly(), actualRequest.getValidateOnly());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void launchFlexTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlexTemplatesService.addException(exception);

    try {
      LaunchFlexTemplateRequest request =
          LaunchFlexTemplateRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setLaunchParameter(LaunchFlexTemplateParameter.newBuilder().build())
              .setLocation("location1901043637")
              .setValidateOnly(true)
              .build();
      client.launchFlexTemplate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
