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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListRagCorporaPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListRagFilesPagedResponse;

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
public class VertexRagDataServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockVertexRagDataService mockVertexRagDataService;
  private LocalChannelProvider channelProvider;
  private VertexRagDataServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockVertexRagDataService = new MockVertexRagDataService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockVertexRagDataService, mockLocations, mockIAMPolicy));
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
    VertexRagDataServiceSettings settings =
        VertexRagDataServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = VertexRagDataServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createRagCorpusTest() throws Exception {
    RagCorpus expectedResponse =
        RagCorpus.newBuilder()
            .setName(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRagCorpusTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVertexRagDataService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    RagCorpus ragCorpus = RagCorpus.newBuilder().build();

    RagCorpus actualResponse = client.createRagCorpusAsync(parent, ragCorpus).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRagCorpusRequest actualRequest = ((CreateRagCorpusRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(ragCorpus, actualRequest.getRagCorpus());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRagCorpusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      RagCorpus ragCorpus = RagCorpus.newBuilder().build();
      client.createRagCorpusAsync(parent, ragCorpus).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createRagCorpusTest2() throws Exception {
    RagCorpus expectedResponse =
        RagCorpus.newBuilder()
            .setName(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRagCorpusTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVertexRagDataService.addResponse(resultOperation);

    String parent = "parent-995424086";
    RagCorpus ragCorpus = RagCorpus.newBuilder().build();

    RagCorpus actualResponse = client.createRagCorpusAsync(parent, ragCorpus).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRagCorpusRequest actualRequest = ((CreateRagCorpusRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(ragCorpus, actualRequest.getRagCorpus());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRagCorpusExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      String parent = "parent-995424086";
      RagCorpus ragCorpus = RagCorpus.newBuilder().build();
      client.createRagCorpusAsync(parent, ragCorpus).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getRagCorpusTest() throws Exception {
    RagCorpus expectedResponse =
        RagCorpus.newBuilder()
            .setName(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockVertexRagDataService.addResponse(expectedResponse);

    RagCorpusName name = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");

    RagCorpus actualResponse = client.getRagCorpus(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRagCorpusRequest actualRequest = ((GetRagCorpusRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRagCorpusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      RagCorpusName name = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
      client.getRagCorpus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRagCorpusTest2() throws Exception {
    RagCorpus expectedResponse =
        RagCorpus.newBuilder()
            .setName(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockVertexRagDataService.addResponse(expectedResponse);

    String name = "name3373707";

    RagCorpus actualResponse = client.getRagCorpus(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRagCorpusRequest actualRequest = ((GetRagCorpusRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRagCorpusExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      String name = "name3373707";
      client.getRagCorpus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRagCorporaTest() throws Exception {
    RagCorpus responsesElement = RagCorpus.newBuilder().build();
    ListRagCorporaResponse expectedResponse =
        ListRagCorporaResponse.newBuilder()
            .setNextPageToken("")
            .addAllRagCorpora(Arrays.asList(responsesElement))
            .build();
    mockVertexRagDataService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRagCorporaPagedResponse pagedListResponse = client.listRagCorpora(parent);

    List<RagCorpus> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRagCorporaList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRagCorporaRequest actualRequest = ((ListRagCorporaRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRagCorporaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRagCorpora(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRagCorporaTest2() throws Exception {
    RagCorpus responsesElement = RagCorpus.newBuilder().build();
    ListRagCorporaResponse expectedResponse =
        ListRagCorporaResponse.newBuilder()
            .setNextPageToken("")
            .addAllRagCorpora(Arrays.asList(responsesElement))
            .build();
    mockVertexRagDataService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRagCorporaPagedResponse pagedListResponse = client.listRagCorpora(parent);

    List<RagCorpus> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRagCorporaList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRagCorporaRequest actualRequest = ((ListRagCorporaRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRagCorporaExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRagCorpora(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRagCorpusTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRagCorpusTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVertexRagDataService.addResponse(resultOperation);

    RagCorpusName name = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");

    client.deleteRagCorpusAsync(name).get();

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRagCorpusRequest actualRequest = ((DeleteRagCorpusRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRagCorpusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      RagCorpusName name = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
      client.deleteRagCorpusAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRagCorpusTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRagCorpusTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVertexRagDataService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteRagCorpusAsync(name).get();

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRagCorpusRequest actualRequest = ((DeleteRagCorpusRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRagCorpusExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRagCorpusAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void uploadRagFileTest() throws Exception {
    UploadRagFileResponse expectedResponse = UploadRagFileResponse.newBuilder().build();
    mockVertexRagDataService.addResponse(expectedResponse);

    RagCorpusName parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
    RagFile ragFile = RagFile.newBuilder().build();
    UploadRagFileConfig uploadRagFileConfig = UploadRagFileConfig.newBuilder().build();

    UploadRagFileResponse actualResponse =
        client.uploadRagFile(parent, ragFile, uploadRagFileConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UploadRagFileRequest actualRequest = ((UploadRagFileRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(ragFile, actualRequest.getRagFile());
    Assert.assertEquals(uploadRagFileConfig, actualRequest.getUploadRagFileConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void uploadRagFileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      RagCorpusName parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
      RagFile ragFile = RagFile.newBuilder().build();
      UploadRagFileConfig uploadRagFileConfig = UploadRagFileConfig.newBuilder().build();
      client.uploadRagFile(parent, ragFile, uploadRagFileConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void uploadRagFileTest2() throws Exception {
    UploadRagFileResponse expectedResponse = UploadRagFileResponse.newBuilder().build();
    mockVertexRagDataService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    RagFile ragFile = RagFile.newBuilder().build();
    UploadRagFileConfig uploadRagFileConfig = UploadRagFileConfig.newBuilder().build();

    UploadRagFileResponse actualResponse =
        client.uploadRagFile(parent, ragFile, uploadRagFileConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UploadRagFileRequest actualRequest = ((UploadRagFileRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(ragFile, actualRequest.getRagFile());
    Assert.assertEquals(uploadRagFileConfig, actualRequest.getUploadRagFileConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void uploadRagFileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      String parent = "parent-995424086";
      RagFile ragFile = RagFile.newBuilder().build();
      UploadRagFileConfig uploadRagFileConfig = UploadRagFileConfig.newBuilder().build();
      client.uploadRagFile(parent, ragFile, uploadRagFileConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importRagFilesTest() throws Exception {
    ImportRagFilesResponse expectedResponse =
        ImportRagFilesResponse.newBuilder()
            .setImportedRagFilesCount(1148003429)
            .setFailedRagFilesCount(-854525026)
            .setSkippedRagFilesCount(-1294759791)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importRagFilesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVertexRagDataService.addResponse(resultOperation);

    RagCorpusName parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
    ImportRagFilesConfig importRagFilesConfig = ImportRagFilesConfig.newBuilder().build();

    ImportRagFilesResponse actualResponse =
        client.importRagFilesAsync(parent, importRagFilesConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportRagFilesRequest actualRequest = ((ImportRagFilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(importRagFilesConfig, actualRequest.getImportRagFilesConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importRagFilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      RagCorpusName parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
      ImportRagFilesConfig importRagFilesConfig = ImportRagFilesConfig.newBuilder().build();
      client.importRagFilesAsync(parent, importRagFilesConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importRagFilesTest2() throws Exception {
    ImportRagFilesResponse expectedResponse =
        ImportRagFilesResponse.newBuilder()
            .setImportedRagFilesCount(1148003429)
            .setFailedRagFilesCount(-854525026)
            .setSkippedRagFilesCount(-1294759791)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importRagFilesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVertexRagDataService.addResponse(resultOperation);

    String parent = "parent-995424086";
    ImportRagFilesConfig importRagFilesConfig = ImportRagFilesConfig.newBuilder().build();

    ImportRagFilesResponse actualResponse =
        client.importRagFilesAsync(parent, importRagFilesConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportRagFilesRequest actualRequest = ((ImportRagFilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(importRagFilesConfig, actualRequest.getImportRagFilesConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importRagFilesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      String parent = "parent-995424086";
      ImportRagFilesConfig importRagFilesConfig = ImportRagFilesConfig.newBuilder().build();
      client.importRagFilesAsync(parent, importRagFilesConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getRagFileTest() throws Exception {
    RagFile expectedResponse =
        RagFile.newBuilder()
            .setName(
                RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setSizeBytes(-1796325715)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockVertexRagDataService.addResponse(expectedResponse);

    RagFileName name = RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]");

    RagFile actualResponse = client.getRagFile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRagFileRequest actualRequest = ((GetRagFileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRagFileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      RagFileName name = RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]");
      client.getRagFile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRagFileTest2() throws Exception {
    RagFile expectedResponse =
        RagFile.newBuilder()
            .setName(
                RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setSizeBytes(-1796325715)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockVertexRagDataService.addResponse(expectedResponse);

    String name = "name3373707";

    RagFile actualResponse = client.getRagFile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRagFileRequest actualRequest = ((GetRagFileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRagFileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      String name = "name3373707";
      client.getRagFile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRagFilesTest() throws Exception {
    RagFile responsesElement = RagFile.newBuilder().build();
    ListRagFilesResponse expectedResponse =
        ListRagFilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRagFiles(Arrays.asList(responsesElement))
            .build();
    mockVertexRagDataService.addResponse(expectedResponse);

    RagCorpusName parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");

    ListRagFilesPagedResponse pagedListResponse = client.listRagFiles(parent);

    List<RagFile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRagFilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRagFilesRequest actualRequest = ((ListRagFilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRagFilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      RagCorpusName parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
      client.listRagFiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRagFilesTest2() throws Exception {
    RagFile responsesElement = RagFile.newBuilder().build();
    ListRagFilesResponse expectedResponse =
        ListRagFilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRagFiles(Arrays.asList(responsesElement))
            .build();
    mockVertexRagDataService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRagFilesPagedResponse pagedListResponse = client.listRagFiles(parent);

    List<RagFile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRagFilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRagFilesRequest actualRequest = ((ListRagFilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRagFilesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRagFiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRagFileTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRagFileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVertexRagDataService.addResponse(resultOperation);

    RagFileName name = RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]");

    client.deleteRagFileAsync(name).get();

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRagFileRequest actualRequest = ((DeleteRagFileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRagFileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      RagFileName name = RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]");
      client.deleteRagFileAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRagFileTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRagFileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVertexRagDataService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteRagFileAsync(name).get();

    List<AbstractMessage> actualRequests = mockVertexRagDataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRagFileRequest actualRequest = ((DeleteRagFileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRagFileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVertexRagDataService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRagFileAsync(name).get();
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
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
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
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
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
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
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
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
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
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
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
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
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
