/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelEvaluationSlicesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelEvaluationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
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
  private static MockServiceHelper mockServiceHelper;
  private ModelServiceClient client;
  private static MockModelService mockModelService;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockModelService = new MockModelService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockModelService));
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
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPredictSchemata(PredictSchemata.newBuilder().build())
            .setMetadataSchemaUri("metadataSchemaUri781971868")
            .setMetadata(Value.newBuilder().build())
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
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPredictSchemata(PredictSchemata.newBuilder().build())
            .setMetadataSchemaUri("metadataSchemaUri781971868")
            .setMetadata(Value.newBuilder().build())
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
  public void updateModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPredictSchemata(PredictSchemata.newBuilder().build())
            .setMetadataSchemaUri("metadataSchemaUri781971868")
            .setMetadata(Value.newBuilder().build())
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
  public void getModelEvaluationTest() throws Exception {
    ModelEvaluation expectedResponse =
        ModelEvaluation.newBuilder()
            .setName(
                ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
                    .toString())
            .setMetricsSchemaUri("metricsSchemaUri-182209912")
            .setMetrics(Value.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSliceDimensions(new ArrayList<String>())
            .setModelExplanation(ModelExplanation.newBuilder().build())
            .addAllExplanationSpecs(new ArrayList<ModelEvaluation.ModelEvaluationExplanationSpec>())
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
            .setMetricsSchemaUri("metricsSchemaUri-182209912")
            .setMetrics(Value.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSliceDimensions(new ArrayList<String>())
            .setModelExplanation(ModelExplanation.newBuilder().build())
            .addAllExplanationSpecs(new ArrayList<ModelEvaluation.ModelEvaluationExplanationSpec>())
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
            .setMetrics(Value.newBuilder().build())
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
            .setMetrics(Value.newBuilder().build())
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
}
