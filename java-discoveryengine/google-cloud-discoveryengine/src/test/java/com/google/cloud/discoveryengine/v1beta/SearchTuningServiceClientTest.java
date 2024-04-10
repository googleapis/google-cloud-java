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

package com.google.cloud.discoveryengine.v1beta;

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
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class SearchTuningServiceClientTest {
  private static MockLocations mockLocations;
  private static MockSearchTuningService mockSearchTuningService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private SearchTuningServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSearchTuningService = new MockSearchTuningService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSearchTuningService, mockLocations));
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
    SearchTuningServiceSettings settings =
        SearchTuningServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SearchTuningServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void trainCustomModelTest() throws Exception {
    TrainCustomModelResponse expectedResponse =
        TrainCustomModelResponse.newBuilder()
            .addAllErrorSamples(new ArrayList<Status>())
            .setErrorConfig(ImportErrorConfig.newBuilder().build())
            .setModelStatus("modelStatus488502395")
            .putAllMetrics(new HashMap<String, Double>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("trainCustomModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSearchTuningService.addResponse(resultOperation);

    TrainCustomModelRequest request =
        TrainCustomModelRequest.newBuilder()
            .setDataStore(
                DataStoreName.ofProjectLocationCollectionDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
                    .toString())
            .setModelType("modelType-2010627581")
            .setErrorConfig(ImportErrorConfig.newBuilder().build())
            .build();

    TrainCustomModelResponse actualResponse = client.trainCustomModelAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSearchTuningService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TrainCustomModelRequest actualRequest = ((TrainCustomModelRequest) actualRequests.get(0));

    Assert.assertEquals(request.getGcsTrainingInput(), actualRequest.getGcsTrainingInput());
    Assert.assertEquals(request.getDataStore(), actualRequest.getDataStore());
    Assert.assertEquals(request.getModelType(), actualRequest.getModelType());
    Assert.assertEquals(request.getErrorConfig(), actualRequest.getErrorConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void trainCustomModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSearchTuningService.addException(exception);

    try {
      TrainCustomModelRequest request =
          TrainCustomModelRequest.newBuilder()
              .setDataStore(
                  DataStoreName.ofProjectLocationCollectionDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
                      .toString())
              .setModelType("modelType-2010627581")
              .setErrorConfig(ImportErrorConfig.newBuilder().build())
              .build();
      client.trainCustomModelAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
