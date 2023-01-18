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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelEvaluationSlicesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelEvaluationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelVersionsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelsPagedResponse;

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
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
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
public class ModelServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockModelService mockModelService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ModelServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockModelService = new MockModelService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockModelService, mockLocations, mockIAMPolicy));
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
    ModelServiceSettings settings =
        ModelServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ModelServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void uploadModelTest() throws Exception {
    UploadModelResponse expectedResponse =
        UploadModelResponse.newBuilder()
            .setModel(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setModelVersionId("modelVersionId-2006125846")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("uploadModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Model model = Model.newBuilder().build();

    UploadModelResponse actualResponse = client.uploadModelAsync(parent, model).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UploadModelRequest actualRequest = ((UploadModelRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void uploadModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Model model = Model.newBuilder().build();
      client.uploadModelAsync(parent, model).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void uploadModelTest2() throws Exception {
    UploadModelResponse expectedResponse =
        UploadModelResponse.newBuilder()
            .setModel(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setModelVersionId("modelVersionId-2006125846")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("uploadModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Model model = Model.newBuilder().build();

    UploadModelResponse actualResponse = client.uploadModelAsync(parent, model).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UploadModelRequest actualRequest = ((UploadModelRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void uploadModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String parent = "parent-995424086";
      Model model = Model.newBuilder().build();
      client.uploadModelAsync(parent, model).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setVersionId("versionId-1407102957")
            .addAllVersionAliases(new ArrayList<String>())
            .setVersionCreateTime(Timestamp.newBuilder().build())
            .setVersionUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setVersionDescription("versionDescription-1736173564")
            .setPredictSchemata(PredictSchemata.newBuilder().build())
            .setMetadataSchemaUri("metadataSchemaUri781971868")
            .setMetadata(Value.newBuilder().setBoolValue(true).build())
            .addAllSupportedExportFormats(new ArrayList<Model.ExportFormat>())
            .setTrainingPipeline(
                TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
                    .toString())
            .setContainerSpec(ModelContainerSpec.newBuilder().build())
            .setArtifactUri("artifactUri-1130062278")
            .addAllSupportedDeploymentResourcesTypes(new ArrayList<Model.DeploymentResourcesType>())
            .addAllSupportedInputStorageFormats(new ArrayList<String>())
            .addAllSupportedOutputStorageFormats(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDeployedModels(new ArrayList<DeployedModelRef>())
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setModelSourceInfo(ModelSourceInfo.newBuilder().build())
            .setMetadataArtifact("metadataArtifact1018119713")
            .build();
    mockModelService.addResponse(expectedResponse);

    ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");

    Model actualResponse = client.getModel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelRequest actualRequest = ((GetModelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
      client.getModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelTest2() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setVersionId("versionId-1407102957")
            .addAllVersionAliases(new ArrayList<String>())
            .setVersionCreateTime(Timestamp.newBuilder().build())
            .setVersionUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setVersionDescription("versionDescription-1736173564")
            .setPredictSchemata(PredictSchemata.newBuilder().build())
            .setMetadataSchemaUri("metadataSchemaUri781971868")
            .setMetadata(Value.newBuilder().setBoolValue(true).build())
            .addAllSupportedExportFormats(new ArrayList<Model.ExportFormat>())
            .setTrainingPipeline(
                TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
                    .toString())
            .setContainerSpec(ModelContainerSpec.newBuilder().build())
            .setArtifactUri("artifactUri-1130062278")
            .addAllSupportedDeploymentResourcesTypes(new ArrayList<Model.DeploymentResourcesType>())
            .addAllSupportedInputStorageFormats(new ArrayList<String>())
            .addAllSupportedOutputStorageFormats(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDeployedModels(new ArrayList<DeployedModelRef>())
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setModelSourceInfo(ModelSourceInfo.newBuilder().build())
            .setMetadataArtifact("metadataArtifact1018119713")
            .build();
    mockModelService.addResponse(expectedResponse);

    String name = "name3373707";

    Model actualResponse = client.getModel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelRequest actualRequest = ((GetModelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String name = "name3373707";
      client.getModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelsTest() throws Exception {
    Model responsesElement = Model.newBuilder().build();
    ListModelsResponse expectedResponse =
        ListModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModels(Arrays.asList(responsesElement))
            .build();
    mockModelService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListModelsPagedResponse pagedListResponse = client.listModels(parent);

    List<Model> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelsRequest actualRequest = ((ListModelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listModels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelsTest2() throws Exception {
    Model responsesElement = Model.newBuilder().build();
    ListModelsResponse expectedResponse =
        ListModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModels(Arrays.asList(responsesElement))
            .build();
    mockModelService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListModelsPagedResponse pagedListResponse = client.listModels(parent);

    List<Model> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelsRequest actualRequest = ((ListModelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listModels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelVersionsTest() throws Exception {
    Model responsesElement = Model.newBuilder().build();
    ListModelVersionsResponse expectedResponse =
        ListModelVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModels(Arrays.asList(responsesElement))
            .build();
    mockModelService.addResponse(expectedResponse);

    ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");

    ListModelVersionsPagedResponse pagedListResponse = client.listModelVersions(name);

    List<Model> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelVersionsRequest actualRequest = ((ListModelVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
      client.listModelVersions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelVersionsTest2() throws Exception {
    Model responsesElement = Model.newBuilder().build();
    ListModelVersionsResponse expectedResponse =
        ListModelVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModels(Arrays.asList(responsesElement))
            .build();
    mockModelService.addResponse(expectedResponse);

    String name = "name3373707";

    ListModelVersionsPagedResponse pagedListResponse = client.listModelVersions(name);

    List<Model> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelVersionsRequest actualRequest = ((ListModelVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String name = "name3373707";
      client.listModelVersions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setVersionId("versionId-1407102957")
            .addAllVersionAliases(new ArrayList<String>())
            .setVersionCreateTime(Timestamp.newBuilder().build())
            .setVersionUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setVersionDescription("versionDescription-1736173564")
            .setPredictSchemata(PredictSchemata.newBuilder().build())
            .setMetadataSchemaUri("metadataSchemaUri781971868")
            .setMetadata(Value.newBuilder().setBoolValue(true).build())
            .addAllSupportedExportFormats(new ArrayList<Model.ExportFormat>())
            .setTrainingPipeline(
                TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
                    .toString())
            .setContainerSpec(ModelContainerSpec.newBuilder().build())
            .setArtifactUri("artifactUri-1130062278")
            .addAllSupportedDeploymentResourcesTypes(new ArrayList<Model.DeploymentResourcesType>())
            .addAllSupportedInputStorageFormats(new ArrayList<String>())
            .addAllSupportedOutputStorageFormats(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDeployedModels(new ArrayList<DeployedModelRef>())
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setModelSourceInfo(ModelSourceInfo.newBuilder().build())
            .setMetadataArtifact("metadataArtifact1018119713")
            .build();
    mockModelService.addResponse(expectedResponse);

    Model model = Model.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Model actualResponse = client.updateModel(model, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateModelRequest actualRequest = ((UpdateModelRequest) actualRequests.get(0));

    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      Model model = Model.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateModel(model, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateExplanationDatasetTest() throws Exception {
    UpdateExplanationDatasetResponse expectedResponse =
        UpdateExplanationDatasetResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateExplanationDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelService.addResponse(resultOperation);

    ModelName model = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");

    UpdateExplanationDatasetResponse actualResponse =
        client.updateExplanationDatasetAsync(model).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExplanationDatasetRequest actualRequest =
        ((UpdateExplanationDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(model.toString(), actualRequest.getModel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExplanationDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      ModelName model = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
      client.updateExplanationDatasetAsync(model).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateExplanationDatasetTest2() throws Exception {
    UpdateExplanationDatasetResponse expectedResponse =
        UpdateExplanationDatasetResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateExplanationDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelService.addResponse(resultOperation);

    String model = "model104069929";

    UpdateExplanationDatasetResponse actualResponse =
        client.updateExplanationDatasetAsync(model).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExplanationDatasetRequest actualRequest =
        ((UpdateExplanationDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExplanationDatasetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String model = "model104069929";
      client.updateExplanationDatasetAsync(model).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteModelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelService.addResponse(resultOperation);

    ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");

    client.deleteModelAsync(name).get();

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteModelRequest actualRequest = ((DeleteModelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
      client.deleteModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteModelTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteModelAsync(name).get();

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteModelRequest actualRequest = ((DeleteModelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteModelVersionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelVersionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelService.addResponse(resultOperation);

    ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");

    client.deleteModelVersionAsync(name).get();

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteModelVersionRequest actualRequest = ((DeleteModelVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteModelVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
      client.deleteModelVersionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteModelVersionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteModelVersionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteModelVersionAsync(name).get();

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteModelVersionRequest actualRequest = ((DeleteModelVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteModelVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteModelVersionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void mergeVersionAliasesTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setVersionId("versionId-1407102957")
            .addAllVersionAliases(new ArrayList<String>())
            .setVersionCreateTime(Timestamp.newBuilder().build())
            .setVersionUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setVersionDescription("versionDescription-1736173564")
            .setPredictSchemata(PredictSchemata.newBuilder().build())
            .setMetadataSchemaUri("metadataSchemaUri781971868")
            .setMetadata(Value.newBuilder().setBoolValue(true).build())
            .addAllSupportedExportFormats(new ArrayList<Model.ExportFormat>())
            .setTrainingPipeline(
                TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
                    .toString())
            .setContainerSpec(ModelContainerSpec.newBuilder().build())
            .setArtifactUri("artifactUri-1130062278")
            .addAllSupportedDeploymentResourcesTypes(new ArrayList<Model.DeploymentResourcesType>())
            .addAllSupportedInputStorageFormats(new ArrayList<String>())
            .addAllSupportedOutputStorageFormats(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDeployedModels(new ArrayList<DeployedModelRef>())
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setModelSourceInfo(ModelSourceInfo.newBuilder().build())
            .setMetadataArtifact("metadataArtifact1018119713")
            .build();
    mockModelService.addResponse(expectedResponse);

    ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
    List<String> versionAliases = new ArrayList<>();

    Model actualResponse = client.mergeVersionAliases(name, versionAliases);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MergeVersionAliasesRequest actualRequest = ((MergeVersionAliasesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(versionAliases, actualRequest.getVersionAliasesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void mergeVersionAliasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
      List<String> versionAliases = new ArrayList<>();
      client.mergeVersionAliases(name, versionAliases);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void mergeVersionAliasesTest2() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setVersionId("versionId-1407102957")
            .addAllVersionAliases(new ArrayList<String>())
            .setVersionCreateTime(Timestamp.newBuilder().build())
            .setVersionUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setVersionDescription("versionDescription-1736173564")
            .setPredictSchemata(PredictSchemata.newBuilder().build())
            .setMetadataSchemaUri("metadataSchemaUri781971868")
            .setMetadata(Value.newBuilder().setBoolValue(true).build())
            .addAllSupportedExportFormats(new ArrayList<Model.ExportFormat>())
            .setTrainingPipeline(
                TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
                    .toString())
            .setContainerSpec(ModelContainerSpec.newBuilder().build())
            .setArtifactUri("artifactUri-1130062278")
            .addAllSupportedDeploymentResourcesTypes(new ArrayList<Model.DeploymentResourcesType>())
            .addAllSupportedInputStorageFormats(new ArrayList<String>())
            .addAllSupportedOutputStorageFormats(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDeployedModels(new ArrayList<DeployedModelRef>())
            .setExplanationSpec(ExplanationSpec.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setModelSourceInfo(ModelSourceInfo.newBuilder().build())
            .setMetadataArtifact("metadataArtifact1018119713")
            .build();
    mockModelService.addResponse(expectedResponse);

    String name = "name3373707";
    List<String> versionAliases = new ArrayList<>();

    Model actualResponse = client.mergeVersionAliases(name, versionAliases);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MergeVersionAliasesRequest actualRequest = ((MergeVersionAliasesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(versionAliases, actualRequest.getVersionAliasesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void mergeVersionAliasesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String name = "name3373707";
      List<String> versionAliases = new ArrayList<>();
      client.mergeVersionAliases(name, versionAliases);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportModelTest() throws Exception {
    ExportModelResponse expectedResponse = ExportModelResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelService.addResponse(resultOperation);

    ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
    ExportModelRequest.OutputConfig outputConfig =
        ExportModelRequest.OutputConfig.newBuilder().build();

    ExportModelResponse actualResponse = client.exportModelAsync(name, outputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportModelRequest actualRequest = ((ExportModelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(outputConfig, actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
      ExportModelRequest.OutputConfig outputConfig =
          ExportModelRequest.OutputConfig.newBuilder().build();
      client.exportModelAsync(name, outputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportModelTest2() throws Exception {
    ExportModelResponse expectedResponse = ExportModelResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelService.addResponse(resultOperation);

    String name = "name3373707";
    ExportModelRequest.OutputConfig outputConfig =
        ExportModelRequest.OutputConfig.newBuilder().build();

    ExportModelResponse actualResponse = client.exportModelAsync(name, outputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportModelRequest actualRequest = ((ExportModelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(outputConfig, actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String name = "name3373707";
      ExportModelRequest.OutputConfig outputConfig =
          ExportModelRequest.OutputConfig.newBuilder().build();
      client.exportModelAsync(name, outputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importModelEvaluationTest() throws Exception {
    ModelEvaluation expectedResponse =
        ModelEvaluation.newBuilder()
            .setName(
                ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setMetricsSchemaUri("metricsSchemaUri-182209912")
            .setMetrics(Value.newBuilder().setBoolValue(true).build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSliceDimensions(new ArrayList<String>())
            .setModelExplanation(ModelExplanation.newBuilder().build())
            .addAllExplanationSpecs(new ArrayList<ModelEvaluation.ModelEvaluationExplanationSpec>())
            .setMetadata(Value.newBuilder().setBoolValue(true).build())
            .build();
    mockModelService.addResponse(expectedResponse);

    ModelName parent = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
    ModelEvaluation modelEvaluation = ModelEvaluation.newBuilder().build();

    ModelEvaluation actualResponse = client.importModelEvaluation(parent, modelEvaluation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportModelEvaluationRequest actualRequest =
        ((ImportModelEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(modelEvaluation, actualRequest.getModelEvaluation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importModelEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      ModelName parent = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
      ModelEvaluation modelEvaluation = ModelEvaluation.newBuilder().build();
      client.importModelEvaluation(parent, modelEvaluation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importModelEvaluationTest2() throws Exception {
    ModelEvaluation expectedResponse =
        ModelEvaluation.newBuilder()
            .setName(
                ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setMetricsSchemaUri("metricsSchemaUri-182209912")
            .setMetrics(Value.newBuilder().setBoolValue(true).build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSliceDimensions(new ArrayList<String>())
            .setModelExplanation(ModelExplanation.newBuilder().build())
            .addAllExplanationSpecs(new ArrayList<ModelEvaluation.ModelEvaluationExplanationSpec>())
            .setMetadata(Value.newBuilder().setBoolValue(true).build())
            .build();
    mockModelService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ModelEvaluation modelEvaluation = ModelEvaluation.newBuilder().build();

    ModelEvaluation actualResponse = client.importModelEvaluation(parent, modelEvaluation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportModelEvaluationRequest actualRequest =
        ((ImportModelEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(modelEvaluation, actualRequest.getModelEvaluation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importModelEvaluationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String parent = "parent-995424086";
      ModelEvaluation modelEvaluation = ModelEvaluation.newBuilder().build();
      client.importModelEvaluation(parent, modelEvaluation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchImportModelEvaluationSlicesTest() throws Exception {
    BatchImportModelEvaluationSlicesResponse expectedResponse =
        BatchImportModelEvaluationSlicesResponse.newBuilder()
            .addAllImportedModelEvaluationSlices(new ArrayList<String>())
            .build();
    mockModelService.addResponse(expectedResponse);

    ModelEvaluationName parent =
        ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]");
    List<ModelEvaluationSlice> modelEvaluationSlices = new ArrayList<>();

    BatchImportModelEvaluationSlicesResponse actualResponse =
        client.batchImportModelEvaluationSlices(parent, modelEvaluationSlices);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchImportModelEvaluationSlicesRequest actualRequest =
        ((BatchImportModelEvaluationSlicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(modelEvaluationSlices, actualRequest.getModelEvaluationSlicesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchImportModelEvaluationSlicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      ModelEvaluationName parent =
          ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]");
      List<ModelEvaluationSlice> modelEvaluationSlices = new ArrayList<>();
      client.batchImportModelEvaluationSlices(parent, modelEvaluationSlices);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchImportModelEvaluationSlicesTest2() throws Exception {
    BatchImportModelEvaluationSlicesResponse expectedResponse =
        BatchImportModelEvaluationSlicesResponse.newBuilder()
            .addAllImportedModelEvaluationSlices(new ArrayList<String>())
            .build();
    mockModelService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<ModelEvaluationSlice> modelEvaluationSlices = new ArrayList<>();

    BatchImportModelEvaluationSlicesResponse actualResponse =
        client.batchImportModelEvaluationSlices(parent, modelEvaluationSlices);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchImportModelEvaluationSlicesRequest actualRequest =
        ((BatchImportModelEvaluationSlicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(modelEvaluationSlices, actualRequest.getModelEvaluationSlicesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchImportModelEvaluationSlicesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<ModelEvaluationSlice> modelEvaluationSlices = new ArrayList<>();
      client.batchImportModelEvaluationSlices(parent, modelEvaluationSlices);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelEvaluationTest() throws Exception {
    ModelEvaluation expectedResponse =
        ModelEvaluation.newBuilder()
            .setName(
                ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setMetricsSchemaUri("metricsSchemaUri-182209912")
            .setMetrics(Value.newBuilder().setBoolValue(true).build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSliceDimensions(new ArrayList<String>())
            .setModelExplanation(ModelExplanation.newBuilder().build())
            .addAllExplanationSpecs(new ArrayList<ModelEvaluation.ModelEvaluationExplanationSpec>())
            .setMetadata(Value.newBuilder().setBoolValue(true).build())
            .build();
    mockModelService.addResponse(expectedResponse);

    ModelEvaluationName name =
        ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]");

    ModelEvaluation actualResponse = client.getModelEvaluation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelEvaluationRequest actualRequest = ((GetModelEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      ModelEvaluationName name =
          ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]");
      client.getModelEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelEvaluationTest2() throws Exception {
    ModelEvaluation expectedResponse =
        ModelEvaluation.newBuilder()
            .setName(
                ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setMetricsSchemaUri("metricsSchemaUri-182209912")
            .setMetrics(Value.newBuilder().setBoolValue(true).build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSliceDimensions(new ArrayList<String>())
            .setModelExplanation(ModelExplanation.newBuilder().build())
            .addAllExplanationSpecs(new ArrayList<ModelEvaluation.ModelEvaluationExplanationSpec>())
            .setMetadata(Value.newBuilder().setBoolValue(true).build())
            .build();
    mockModelService.addResponse(expectedResponse);

    String name = "name3373707";

    ModelEvaluation actualResponse = client.getModelEvaluation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelEvaluationRequest actualRequest = ((GetModelEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelEvaluationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String name = "name3373707";
      client.getModelEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelEvaluationsTest() throws Exception {
    ModelEvaluation responsesElement = ModelEvaluation.newBuilder().build();
    ListModelEvaluationsResponse expectedResponse =
        ListModelEvaluationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModelEvaluations(Arrays.asList(responsesElement))
            .build();
    mockModelService.addResponse(expectedResponse);

    ModelName parent = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");

    ListModelEvaluationsPagedResponse pagedListResponse = client.listModelEvaluations(parent);

    List<ModelEvaluation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelEvaluationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelEvaluationsRequest actualRequest =
        ((ListModelEvaluationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelEvaluationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      ModelName parent = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
      client.listModelEvaluations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelEvaluationsTest2() throws Exception {
    ModelEvaluation responsesElement = ModelEvaluation.newBuilder().build();
    ListModelEvaluationsResponse expectedResponse =
        ListModelEvaluationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModelEvaluations(Arrays.asList(responsesElement))
            .build();
    mockModelService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListModelEvaluationsPagedResponse pagedListResponse = client.listModelEvaluations(parent);

    List<ModelEvaluation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelEvaluationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelEvaluationsRequest actualRequest =
        ((ListModelEvaluationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelEvaluationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listModelEvaluations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelEvaluationSliceTest() throws Exception {
    ModelEvaluationSlice expectedResponse =
        ModelEvaluationSlice.newBuilder()
            .setName(
                ModelEvaluationSliceName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]")
                    .toString())
            .setSlice(ModelEvaluationSlice.Slice.newBuilder().build())
            .setMetricsSchemaUri("metricsSchemaUri-182209912")
            .setMetrics(Value.newBuilder().setBoolValue(true).build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockModelService.addResponse(expectedResponse);

    ModelEvaluationSliceName name =
        ModelEvaluationSliceName.of(
            "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]");

    ModelEvaluationSlice actualResponse = client.getModelEvaluationSlice(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelEvaluationSliceRequest actualRequest =
        ((GetModelEvaluationSliceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelEvaluationSliceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      ModelEvaluationSliceName name =
          ModelEvaluationSliceName.of(
              "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]");
      client.getModelEvaluationSlice(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelEvaluationSliceTest2() throws Exception {
    ModelEvaluationSlice expectedResponse =
        ModelEvaluationSlice.newBuilder()
            .setName(
                ModelEvaluationSliceName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]")
                    .toString())
            .setSlice(ModelEvaluationSlice.Slice.newBuilder().build())
            .setMetricsSchemaUri("metricsSchemaUri-182209912")
            .setMetrics(Value.newBuilder().setBoolValue(true).build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockModelService.addResponse(expectedResponse);

    String name = "name3373707";

    ModelEvaluationSlice actualResponse = client.getModelEvaluationSlice(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelEvaluationSliceRequest actualRequest =
        ((GetModelEvaluationSliceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelEvaluationSliceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String name = "name3373707";
      client.getModelEvaluationSlice(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelEvaluationSlicesTest() throws Exception {
    ModelEvaluationSlice responsesElement = ModelEvaluationSlice.newBuilder().build();
    ListModelEvaluationSlicesResponse expectedResponse =
        ListModelEvaluationSlicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllModelEvaluationSlices(Arrays.asList(responsesElement))
            .build();
    mockModelService.addResponse(expectedResponse);

    ModelEvaluationName parent =
        ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]");

    ListModelEvaluationSlicesPagedResponse pagedListResponse =
        client.listModelEvaluationSlices(parent);

    List<ModelEvaluationSlice> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelEvaluationSlicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelEvaluationSlicesRequest actualRequest =
        ((ListModelEvaluationSlicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelEvaluationSlicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      ModelEvaluationName parent =
          ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]");
      client.listModelEvaluationSlices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelEvaluationSlicesTest2() throws Exception {
    ModelEvaluationSlice responsesElement = ModelEvaluationSlice.newBuilder().build();
    ListModelEvaluationSlicesResponse expectedResponse =
        ListModelEvaluationSlicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllModelEvaluationSlices(Arrays.asList(responsesElement))
            .build();
    mockModelService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListModelEvaluationSlicesPagedResponse pagedListResponse =
        client.listModelEvaluationSlices(parent);

    List<ModelEvaluationSlice> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelEvaluationSlicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelEvaluationSlicesRequest actualRequest =
        ((ListModelEvaluationSlicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelEvaluationSlicesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listModelEvaluationSlices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                    .toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                      .toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                    .toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                      .toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                    .toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                      .toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
