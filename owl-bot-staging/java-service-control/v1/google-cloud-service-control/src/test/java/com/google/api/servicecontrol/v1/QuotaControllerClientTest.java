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

package com.google.api.servicecontrol.v1;

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
import java.util.ArrayList;
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
public class QuotaControllerClientTest {
  private static MockQuotaController mockQuotaController;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private QuotaControllerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockQuotaController = new MockQuotaController();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockQuotaController));
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
    QuotaControllerSettings settings =
        QuotaControllerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = QuotaControllerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void allocateQuotaTest() throws Exception {
    AllocateQuotaResponse expectedResponse =
        AllocateQuotaResponse.newBuilder()
            .setOperationId("operationId129704162")
            .addAllAllocateErrors(new ArrayList<QuotaError>())
            .addAllQuotaMetrics(new ArrayList<MetricValueSet>())
            .setServiceConfigId("serviceConfigId650537426")
            .build();
    mockQuotaController.addResponse(expectedResponse);

    AllocateQuotaRequest request =
        AllocateQuotaRequest.newBuilder()
            .setServiceName("serviceName-1928572192")
            .setAllocateOperation(QuotaOperation.newBuilder().build())
            .setServiceConfigId("serviceConfigId650537426")
            .build();

    AllocateQuotaResponse actualResponse = client.allocateQuota(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockQuotaController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AllocateQuotaRequest actualRequest = ((AllocateQuotaRequest) actualRequests.get(0));

    Assert.assertEquals(request.getServiceName(), actualRequest.getServiceName());
    Assert.assertEquals(request.getAllocateOperation(), actualRequest.getAllocateOperation());
    Assert.assertEquals(request.getServiceConfigId(), actualRequest.getServiceConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void allocateQuotaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockQuotaController.addException(exception);

    try {
      AllocateQuotaRequest request =
          AllocateQuotaRequest.newBuilder()
              .setServiceName("serviceName-1928572192")
              .setAllocateOperation(QuotaOperation.newBuilder().build())
              .setServiceConfigId("serviceConfigId650537426")
              .build();
      client.allocateQuota(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
