/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class EstimateBillingServiceClientTest {
  private static MockEstimateBillingService mockEstimateBillingService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EstimateBillingServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEstimateBillingService = new MockEstimateBillingService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockEstimateBillingService, mockLocations));
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
    EstimateBillingServiceSettings settings =
        EstimateBillingServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EstimateBillingServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void estimateDataSizeTest() throws Exception {
    EstimateDataSizeResponse expectedResponse =
        EstimateDataSizeResponse.newBuilder()
            .setDataSizeBytes(-2110122398)
            .setDocumentCount(1892156651)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("estimateDataSizeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEstimateBillingService.addResponse(resultOperation);

    EstimateDataSizeRequest request =
        EstimateDataSizeRequest.newBuilder()
            .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .build();

    EstimateDataSizeResponse actualResponse = client.estimateDataSizeAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEstimateBillingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EstimateDataSizeRequest actualRequest = ((EstimateDataSizeRequest) actualRequests.get(0));

    Assert.assertEquals(request.getWebsiteDataSource(), actualRequest.getWebsiteDataSource());
    Assert.assertEquals(request.getFileDataSource(), actualRequest.getFileDataSource());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void estimateDataSizeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEstimateBillingService.addException(exception);

    try {
      EstimateDataSizeRequest request =
          EstimateDataSizeRequest.newBuilder()
              .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .build();
      client.estimateDataSizeAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
