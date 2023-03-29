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

package com.google.api.servicecontrol.v2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.rpc.Status;
import com.google.rpc.context.AttributeContext;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class ServiceControllerClientTest {
  private static MockServiceController mockServiceController;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ServiceControllerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockServiceController = new MockServiceController();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockServiceController));
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
    ServiceControllerSettings settings =
        ServiceControllerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ServiceControllerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void checkTest() throws Exception {
    CheckResponse expectedResponse =
        CheckResponse.newBuilder()
            .setStatus(Status.newBuilder().build())
            .putAllHeaders(new HashMap<String, String>())
            .build();
    mockServiceController.addResponse(expectedResponse);

    CheckRequest request =
        CheckRequest.newBuilder()
            .setServiceName("serviceName-1928572192")
            .setServiceConfigId("serviceConfigId650537426")
            .setAttributes(AttributeContext.newBuilder().build())
            .addAllResources(new ArrayList<ResourceInfo>())
            .setFlags("flags97513095")
            .build();

    CheckResponse actualResponse = client.check(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckRequest actualRequest = ((CheckRequest) actualRequests.get(0));

    Assert.assertEquals(request.getServiceName(), actualRequest.getServiceName());
    Assert.assertEquals(request.getServiceConfigId(), actualRequest.getServiceConfigId());
    Assert.assertEquals(request.getAttributes(), actualRequest.getAttributes());
    Assert.assertEquals(request.getResourcesList(), actualRequest.getResourcesList());
    Assert.assertEquals(request.getFlags(), actualRequest.getFlags());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void checkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceController.addException(exception);

    try {
      CheckRequest request =
          CheckRequest.newBuilder()
              .setServiceName("serviceName-1928572192")
              .setServiceConfigId("serviceConfigId650537426")
              .setAttributes(AttributeContext.newBuilder().build())
              .addAllResources(new ArrayList<ResourceInfo>())
              .setFlags("flags97513095")
              .build();
      client.check(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void reportTest() throws Exception {
    ReportResponse expectedResponse = ReportResponse.newBuilder().build();
    mockServiceController.addResponse(expectedResponse);

    ReportRequest request =
        ReportRequest.newBuilder()
            .setServiceName("serviceName-1928572192")
            .setServiceConfigId("serviceConfigId650537426")
            .addAllOperations(new ArrayList<AttributeContext>())
            .build();

    ReportResponse actualResponse = client.report(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReportRequest actualRequest = ((ReportRequest) actualRequests.get(0));

    Assert.assertEquals(request.getServiceName(), actualRequest.getServiceName());
    Assert.assertEquals(request.getServiceConfigId(), actualRequest.getServiceConfigId());
    Assert.assertEquals(request.getOperationsList(), actualRequest.getOperationsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceController.addException(exception);

    try {
      ReportRequest request =
          ReportRequest.newBuilder()
              .setServiceName("serviceName-1928572192")
              .setServiceConfigId("serviceConfigId650537426")
              .addAllOperations(new ArrayList<AttributeContext>())
              .build();
      client.report(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
