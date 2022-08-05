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

package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListConversationModelEvaluationsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListConversationModelsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
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
public class ConversationModelsClientTest {
  private static MockConversationModels mockConversationModels;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ConversationModelsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockConversationModels = new MockConversationModels();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockConversationModels, mockLocations));
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
    ConversationModelsSettings settings =
        ConversationModelsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConversationModelsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createConversationModelTest() throws Exception {
    ConversationModel expectedResponse =
        ConversationModel.newBuilder()
            .setName(
                ConversationModelName.ofProjectLocationConversationModelName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION_MODEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDatasets(new ArrayList<InputDataset>())
            .setLanguageCode("languageCode-2092349083")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConversationModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockConversationModels.addResponse(resultOperation);

    String parent = "parent-995424086";
    ConversationModel conversationModel = ConversationModel.newBuilder().build();

    ConversationModel actualResponse =
        client.createConversationModelAsync(parent, conversationModel).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationModels.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversationModelRequest actualRequest =
        ((CreateConversationModelRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(conversationModel, actualRequest.getConversationModel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversationModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationModels.addException(exception);

    try {
      String parent = "parent-995424086";
      ConversationModel conversationModel = ConversationModel.newBuilder().build();
      client.createConversationModelAsync(parent, conversationModel).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getConversationModelTest() throws Exception {
    ConversationModel expectedResponse =
        ConversationModel.newBuilder()
            .setName(
                ConversationModelName.ofProjectConversationModelName(
                        "[PROJECT]", "[CONVERSATION_MODEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDatasets(new ArrayList<InputDataset>())
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockConversationModels.addResponse(expectedResponse);

    String name = "name3373707";

    ConversationModel actualResponse = client.getConversationModel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationModels.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConversationModelRequest actualRequest =
        ((GetConversationModelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConversationModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationModels.addException(exception);

    try {
      String name = "name3373707";
      client.getConversationModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversationModelsTest() throws Exception {
    ConversationModel responsesElement = ConversationModel.newBuilder().build();
    ListConversationModelsResponse expectedResponse =
        ListConversationModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversationModels(Arrays.asList(responsesElement))
            .build();
    mockConversationModels.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConversationModelsPagedResponse pagedListResponse = client.listConversationModels(parent);

    List<ConversationModel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationModelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConversationModels.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversationModelsRequest actualRequest =
        ((ListConversationModelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversationModelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationModels.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConversationModels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversationModelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConversationModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockConversationModels.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteConversationModelAsync(name).get();

    List<AbstractMessage> actualRequests = mockConversationModels.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConversationModelRequest actualRequest =
        ((DeleteConversationModelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConversationModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationModels.addException(exception);

    try {
      String name = "name3373707";
      client.deleteConversationModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deployConversationModelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deployConversationModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockConversationModels.addResponse(resultOperation);

    DeployConversationModelRequest request =
        DeployConversationModelRequest.newBuilder().setName("name3373707").build();

    client.deployConversationModelAsync(request).get();

    List<AbstractMessage> actualRequests = mockConversationModels.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeployConversationModelRequest actualRequest =
        ((DeployConversationModelRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deployConversationModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationModels.addException(exception);

    try {
      DeployConversationModelRequest request =
          DeployConversationModelRequest.newBuilder().setName("name3373707").build();
      client.deployConversationModelAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void undeployConversationModelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeployConversationModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockConversationModels.addResponse(resultOperation);

    UndeployConversationModelRequest request =
        UndeployConversationModelRequest.newBuilder().setName("name3373707").build();

    client.undeployConversationModelAsync(request).get();

    List<AbstractMessage> actualRequests = mockConversationModels.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeployConversationModelRequest actualRequest =
        ((UndeployConversationModelRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeployConversationModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationModels.addException(exception);

    try {
      UndeployConversationModelRequest request =
          UndeployConversationModelRequest.newBuilder().setName("name3373707").build();
      client.undeployConversationModelAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getConversationModelEvaluationTest() throws Exception {
    ConversationModelEvaluation expectedResponse =
        ConversationModelEvaluation.newBuilder()
            .setName(
                ConversationModelEvaluationName.ofProjectConversationModelEvaluationName(
                        "[PROJECT]", "[CONVERSATION_MODEL]", "[EVALUATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEvaluationConfig(EvaluationConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockConversationModels.addResponse(expectedResponse);

    String name = "name3373707";

    ConversationModelEvaluation actualResponse = client.getConversationModelEvaluation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationModels.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConversationModelEvaluationRequest actualRequest =
        ((GetConversationModelEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConversationModelEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationModels.addException(exception);

    try {
      String name = "name3373707";
      client.getConversationModelEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversationModelEvaluationsTest() throws Exception {
    ConversationModelEvaluation responsesElement = ConversationModelEvaluation.newBuilder().build();
    ListConversationModelEvaluationsResponse expectedResponse =
        ListConversationModelEvaluationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversationModelEvaluations(Arrays.asList(responsesElement))
            .build();
    mockConversationModels.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConversationModelEvaluationsPagedResponse pagedListResponse =
        client.listConversationModelEvaluations(parent);

    List<ConversationModelEvaluation> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getConversationModelEvaluationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConversationModels.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversationModelEvaluationsRequest actualRequest =
        ((ListConversationModelEvaluationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversationModelEvaluationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationModels.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConversationModelEvaluations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConversationModelEvaluationTest() throws Exception {
    ConversationModelEvaluation expectedResponse =
        ConversationModelEvaluation.newBuilder()
            .setName(
                ConversationModelEvaluationName.ofProjectConversationModelEvaluationName(
                        "[PROJECT]", "[CONVERSATION_MODEL]", "[EVALUATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEvaluationConfig(EvaluationConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConversationModelEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockConversationModels.addResponse(resultOperation);

    ConversationModelName parent =
        ConversationModelName.ofProjectLocationConversationModelName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION_MODEL]");
    ConversationModelEvaluation conversationModelEvaluation =
        ConversationModelEvaluation.newBuilder().build();

    ConversationModelEvaluation actualResponse =
        client.createConversationModelEvaluationAsync(parent, conversationModelEvaluation).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationModels.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversationModelEvaluationRequest actualRequest =
        ((CreateConversationModelEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        conversationModelEvaluation, actualRequest.getConversationModelEvaluation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversationModelEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationModels.addException(exception);

    try {
      ConversationModelName parent =
          ConversationModelName.ofProjectLocationConversationModelName(
              "[PROJECT]", "[LOCATION]", "[CONVERSATION_MODEL]");
      ConversationModelEvaluation conversationModelEvaluation =
          ConversationModelEvaluation.newBuilder().build();
      client.createConversationModelEvaluationAsync(parent, conversationModelEvaluation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createConversationModelEvaluationTest2() throws Exception {
    ConversationModelEvaluation expectedResponse =
        ConversationModelEvaluation.newBuilder()
            .setName(
                ConversationModelEvaluationName.ofProjectConversationModelEvaluationName(
                        "[PROJECT]", "[CONVERSATION_MODEL]", "[EVALUATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEvaluationConfig(EvaluationConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConversationModelEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockConversationModels.addResponse(resultOperation);

    String parent = "parent-995424086";
    ConversationModelEvaluation conversationModelEvaluation =
        ConversationModelEvaluation.newBuilder().build();

    ConversationModelEvaluation actualResponse =
        client.createConversationModelEvaluationAsync(parent, conversationModelEvaluation).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationModels.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversationModelEvaluationRequest actualRequest =
        ((CreateConversationModelEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(
        conversationModelEvaluation, actualRequest.getConversationModelEvaluation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversationModelEvaluationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationModels.addException(exception);

    try {
      String parent = "parent-995424086";
      ConversationModelEvaluation conversationModelEvaluation =
          ConversationModelEvaluation.newBuilder().build();
      client.createConversationModelEvaluationAsync(parent, conversationModelEvaluation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
