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

import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListArtifactsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListContextsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListExecutionsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListMetadataSchemasPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListMetadataStoresPagedResponse;

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
import com.google.protobuf.Struct;
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
public class MetadataServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockMetadataService mockMetadataService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MetadataServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMetadataService = new MockMetadataService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockMetadataService, mockLocations, mockIAMPolicy));
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
    MetadataServiceSettings settings =
        MetadataServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MetadataServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createMetadataStoreTest() throws Exception {
    MetadataStore expectedResponse =
        MetadataStore.newBuilder()
            .setName(MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setDescription("description-1724546052")
            .setState(MetadataStore.MetadataStoreState.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMetadataStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    MetadataStore metadataStore = MetadataStore.newBuilder().build();
    String metadataStoreId = "metadataStoreId-1811789907";

    MetadataStore actualResponse =
        client.createMetadataStoreAsync(parent, metadataStore, metadataStoreId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMetadataStoreRequest actualRequest = ((CreateMetadataStoreRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(metadataStore, actualRequest.getMetadataStore());
    Assert.assertEquals(metadataStoreId, actualRequest.getMetadataStoreId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMetadataStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      MetadataStore metadataStore = MetadataStore.newBuilder().build();
      String metadataStoreId = "metadataStoreId-1811789907";
      client.createMetadataStoreAsync(parent, metadataStore, metadataStoreId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMetadataStoreTest2() throws Exception {
    MetadataStore expectedResponse =
        MetadataStore.newBuilder()
            .setName(MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setDescription("description-1724546052")
            .setState(MetadataStore.MetadataStoreState.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMetadataStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    String parent = "parent-995424086";
    MetadataStore metadataStore = MetadataStore.newBuilder().build();
    String metadataStoreId = "metadataStoreId-1811789907";

    MetadataStore actualResponse =
        client.createMetadataStoreAsync(parent, metadataStore, metadataStoreId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMetadataStoreRequest actualRequest = ((CreateMetadataStoreRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(metadataStore, actualRequest.getMetadataStore());
    Assert.assertEquals(metadataStoreId, actualRequest.getMetadataStoreId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMetadataStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String parent = "parent-995424086";
      MetadataStore metadataStore = MetadataStore.newBuilder().build();
      String metadataStoreId = "metadataStoreId-1811789907";
      client.createMetadataStoreAsync(parent, metadataStore, metadataStoreId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getMetadataStoreTest() throws Exception {
    MetadataStore expectedResponse =
        MetadataStore.newBuilder()
            .setName(MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setDescription("description-1724546052")
            .setState(MetadataStore.MetadataStoreState.newBuilder().build())
            .build();
    mockMetadataService.addResponse(expectedResponse);

    MetadataStoreName name = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");

    MetadataStore actualResponse = client.getMetadataStore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMetadataStoreRequest actualRequest = ((GetMetadataStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMetadataStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      MetadataStoreName name = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
      client.getMetadataStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMetadataStoreTest2() throws Exception {
    MetadataStore expectedResponse =
        MetadataStore.newBuilder()
            .setName(MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setDescription("description-1724546052")
            .setState(MetadataStore.MetadataStoreState.newBuilder().build())
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String name = "name3373707";

    MetadataStore actualResponse = client.getMetadataStore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMetadataStoreRequest actualRequest = ((GetMetadataStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMetadataStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String name = "name3373707";
      client.getMetadataStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMetadataStoresTest() throws Exception {
    MetadataStore responsesElement = MetadataStore.newBuilder().build();
    ListMetadataStoresResponse expectedResponse =
        ListMetadataStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllMetadataStores(Arrays.asList(responsesElement))
            .build();
    mockMetadataService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMetadataStoresPagedResponse pagedListResponse = client.listMetadataStores(parent);

    List<MetadataStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMetadataStoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMetadataStoresRequest actualRequest = ((ListMetadataStoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMetadataStoresExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMetadataStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMetadataStoresTest2() throws Exception {
    MetadataStore responsesElement = MetadataStore.newBuilder().build();
    ListMetadataStoresResponse expectedResponse =
        ListMetadataStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllMetadataStores(Arrays.asList(responsesElement))
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMetadataStoresPagedResponse pagedListResponse = client.listMetadataStores(parent);

    List<MetadataStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMetadataStoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMetadataStoresRequest actualRequest = ((ListMetadataStoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMetadataStoresExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMetadataStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMetadataStoreTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMetadataStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    MetadataStoreName name = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");

    client.deleteMetadataStoreAsync(name).get();

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMetadataStoreRequest actualRequest = ((DeleteMetadataStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMetadataStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      MetadataStoreName name = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
      client.deleteMetadataStoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMetadataStoreTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMetadataStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteMetadataStoreAsync(name).get();

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMetadataStoreRequest actualRequest = ((DeleteMetadataStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMetadataStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMetadataStoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createArtifactTest() throws Exception {
    Artifact expectedResponse =
        Artifact.newBuilder()
            .setName(
                ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUri("uri116076")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSchemaTitle("schemaTitle-1020962505")
            .setSchemaVersion("schemaVersion-233564169")
            .setMetadata(Struct.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    MetadataStoreName parent = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
    Artifact artifact = Artifact.newBuilder().build();
    String artifactId = "artifactId240640653";

    Artifact actualResponse = client.createArtifact(parent, artifact, artifactId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateArtifactRequest actualRequest = ((CreateArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(artifact, actualRequest.getArtifact());
    Assert.assertEquals(artifactId, actualRequest.getArtifactId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createArtifactExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      MetadataStoreName parent =
          MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
      Artifact artifact = Artifact.newBuilder().build();
      String artifactId = "artifactId240640653";
      client.createArtifact(parent, artifact, artifactId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createArtifactTest2() throws Exception {
    Artifact expectedResponse =
        Artifact.newBuilder()
            .setName(
                ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUri("uri116076")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSchemaTitle("schemaTitle-1020962505")
            .setSchemaVersion("schemaVersion-233564169")
            .setMetadata(Struct.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Artifact artifact = Artifact.newBuilder().build();
    String artifactId = "artifactId240640653";

    Artifact actualResponse = client.createArtifact(parent, artifact, artifactId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateArtifactRequest actualRequest = ((CreateArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(artifact, actualRequest.getArtifact());
    Assert.assertEquals(artifactId, actualRequest.getArtifactId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createArtifactExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String parent = "parent-995424086";
      Artifact artifact = Artifact.newBuilder().build();
      String artifactId = "artifactId240640653";
      client.createArtifact(parent, artifact, artifactId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getArtifactTest() throws Exception {
    Artifact expectedResponse =
        Artifact.newBuilder()
            .setName(
                ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUri("uri116076")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSchemaTitle("schemaTitle-1020962505")
            .setSchemaVersion("schemaVersion-233564169")
            .setMetadata(Struct.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    ArtifactName name =
        ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]");

    Artifact actualResponse = client.getArtifact(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetArtifactRequest actualRequest = ((GetArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getArtifactExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      ArtifactName name =
          ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]");
      client.getArtifact(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getArtifactTest2() throws Exception {
    Artifact expectedResponse =
        Artifact.newBuilder()
            .setName(
                ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUri("uri116076")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSchemaTitle("schemaTitle-1020962505")
            .setSchemaVersion("schemaVersion-233564169")
            .setMetadata(Struct.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String name = "name3373707";

    Artifact actualResponse = client.getArtifact(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetArtifactRequest actualRequest = ((GetArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getArtifactExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String name = "name3373707";
      client.getArtifact(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listArtifactsTest() throws Exception {
    Artifact responsesElement = Artifact.newBuilder().build();
    ListArtifactsResponse expectedResponse =
        ListArtifactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllArtifacts(Arrays.asList(responsesElement))
            .build();
    mockMetadataService.addResponse(expectedResponse);

    MetadataStoreName parent = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");

    ListArtifactsPagedResponse pagedListResponse = client.listArtifacts(parent);

    List<Artifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getArtifactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListArtifactsRequest actualRequest = ((ListArtifactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listArtifactsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      MetadataStoreName parent =
          MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
      client.listArtifacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listArtifactsTest2() throws Exception {
    Artifact responsesElement = Artifact.newBuilder().build();
    ListArtifactsResponse expectedResponse =
        ListArtifactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllArtifacts(Arrays.asList(responsesElement))
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListArtifactsPagedResponse pagedListResponse = client.listArtifacts(parent);

    List<Artifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getArtifactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListArtifactsRequest actualRequest = ((ListArtifactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listArtifactsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listArtifacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateArtifactTest() throws Exception {
    Artifact expectedResponse =
        Artifact.newBuilder()
            .setName(
                ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setUri("uri116076")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSchemaTitle("schemaTitle-1020962505")
            .setSchemaVersion("schemaVersion-233564169")
            .setMetadata(Struct.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    Artifact artifact = Artifact.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Artifact actualResponse = client.updateArtifact(artifact, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateArtifactRequest actualRequest = ((UpdateArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(artifact, actualRequest.getArtifact());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateArtifactExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      Artifact artifact = Artifact.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateArtifact(artifact, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteArtifactTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteArtifactTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    ArtifactName name =
        ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]");

    client.deleteArtifactAsync(name).get();

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteArtifactRequest actualRequest = ((DeleteArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteArtifactExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      ArtifactName name =
          ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]");
      client.deleteArtifactAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteArtifactTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteArtifactTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteArtifactAsync(name).get();

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteArtifactRequest actualRequest = ((DeleteArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteArtifactExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteArtifactAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void purgeArtifactsTest() throws Exception {
    PurgeArtifactsResponse expectedResponse =
        PurgeArtifactsResponse.newBuilder()
            .setPurgeCount(575305851)
            .addAllPurgeSample(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeArtifactsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    MetadataStoreName parent = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");

    PurgeArtifactsResponse actualResponse = client.purgeArtifactsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeArtifactsRequest actualRequest = ((PurgeArtifactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void purgeArtifactsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      MetadataStoreName parent =
          MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
      client.purgeArtifactsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void purgeArtifactsTest2() throws Exception {
    PurgeArtifactsResponse expectedResponse =
        PurgeArtifactsResponse.newBuilder()
            .setPurgeCount(575305851)
            .addAllPurgeSample(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeArtifactsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    String parent = "parent-995424086";

    PurgeArtifactsResponse actualResponse = client.purgeArtifactsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeArtifactsRequest actualRequest = ((PurgeArtifactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void purgeArtifactsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.purgeArtifactsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createContextTest() throws Exception {
    Context expectedResponse =
        Context.newBuilder()
            .setName(
                ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllParentContexts(new ArrayList<String>())
            .setSchemaTitle("schemaTitle-1020962505")
            .setSchemaVersion("schemaVersion-233564169")
            .setMetadata(Struct.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    MetadataStoreName parent = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
    Context context = Context.newBuilder().build();
    String contextId = "contextId-406810838";

    Context actualResponse = client.createContext(parent, context, contextId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateContextRequest actualRequest = ((CreateContextRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(context, actualRequest.getContext());
    Assert.assertEquals(contextId, actualRequest.getContextId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createContextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      MetadataStoreName parent =
          MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
      Context context = Context.newBuilder().build();
      String contextId = "contextId-406810838";
      client.createContext(parent, context, contextId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createContextTest2() throws Exception {
    Context expectedResponse =
        Context.newBuilder()
            .setName(
                ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllParentContexts(new ArrayList<String>())
            .setSchemaTitle("schemaTitle-1020962505")
            .setSchemaVersion("schemaVersion-233564169")
            .setMetadata(Struct.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Context context = Context.newBuilder().build();
    String contextId = "contextId-406810838";

    Context actualResponse = client.createContext(parent, context, contextId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateContextRequest actualRequest = ((CreateContextRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(context, actualRequest.getContext());
    Assert.assertEquals(contextId, actualRequest.getContextId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createContextExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String parent = "parent-995424086";
      Context context = Context.newBuilder().build();
      String contextId = "contextId-406810838";
      client.createContext(parent, context, contextId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getContextTest() throws Exception {
    Context expectedResponse =
        Context.newBuilder()
            .setName(
                ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllParentContexts(new ArrayList<String>())
            .setSchemaTitle("schemaTitle-1020962505")
            .setSchemaVersion("schemaVersion-233564169")
            .setMetadata(Struct.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    ContextName name = ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");

    Context actualResponse = client.getContext(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetContextRequest actualRequest = ((GetContextRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getContextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      ContextName name = ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
      client.getContext(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getContextTest2() throws Exception {
    Context expectedResponse =
        Context.newBuilder()
            .setName(
                ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllParentContexts(new ArrayList<String>())
            .setSchemaTitle("schemaTitle-1020962505")
            .setSchemaVersion("schemaVersion-233564169")
            .setMetadata(Struct.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String name = "name3373707";

    Context actualResponse = client.getContext(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetContextRequest actualRequest = ((GetContextRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getContextExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String name = "name3373707";
      client.getContext(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listContextsTest() throws Exception {
    Context responsesElement = Context.newBuilder().build();
    ListContextsResponse expectedResponse =
        ListContextsResponse.newBuilder()
            .setNextPageToken("")
            .addAllContexts(Arrays.asList(responsesElement))
            .build();
    mockMetadataService.addResponse(expectedResponse);

    MetadataStoreName parent = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");

    ListContextsPagedResponse pagedListResponse = client.listContexts(parent);

    List<Context> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getContextsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListContextsRequest actualRequest = ((ListContextsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listContextsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      MetadataStoreName parent =
          MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
      client.listContexts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listContextsTest2() throws Exception {
    Context responsesElement = Context.newBuilder().build();
    ListContextsResponse expectedResponse =
        ListContextsResponse.newBuilder()
            .setNextPageToken("")
            .addAllContexts(Arrays.asList(responsesElement))
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListContextsPagedResponse pagedListResponse = client.listContexts(parent);

    List<Context> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getContextsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListContextsRequest actualRequest = ((ListContextsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listContextsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listContexts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateContextTest() throws Exception {
    Context expectedResponse =
        Context.newBuilder()
            .setName(
                ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllParentContexts(new ArrayList<String>())
            .setSchemaTitle("schemaTitle-1020962505")
            .setSchemaVersion("schemaVersion-233564169")
            .setMetadata(Struct.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    Context context = Context.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Context actualResponse = client.updateContext(context, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateContextRequest actualRequest = ((UpdateContextRequest) actualRequests.get(0));

    Assert.assertEquals(context, actualRequest.getContext());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateContextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      Context context = Context.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateContext(context, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteContextTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteContextTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    ContextName name = ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");

    client.deleteContextAsync(name).get();

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteContextRequest actualRequest = ((DeleteContextRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteContextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      ContextName name = ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
      client.deleteContextAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteContextTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteContextTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteContextAsync(name).get();

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteContextRequest actualRequest = ((DeleteContextRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteContextExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteContextAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void purgeContextsTest() throws Exception {
    PurgeContextsResponse expectedResponse =
        PurgeContextsResponse.newBuilder()
            .setPurgeCount(575305851)
            .addAllPurgeSample(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeContextsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    MetadataStoreName parent = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");

    PurgeContextsResponse actualResponse = client.purgeContextsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeContextsRequest actualRequest = ((PurgeContextsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void purgeContextsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      MetadataStoreName parent =
          MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
      client.purgeContextsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void purgeContextsTest2() throws Exception {
    PurgeContextsResponse expectedResponse =
        PurgeContextsResponse.newBuilder()
            .setPurgeCount(575305851)
            .addAllPurgeSample(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeContextsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    String parent = "parent-995424086";

    PurgeContextsResponse actualResponse = client.purgeContextsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeContextsRequest actualRequest = ((PurgeContextsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void purgeContextsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.purgeContextsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void addContextArtifactsAndExecutionsTest() throws Exception {
    AddContextArtifactsAndExecutionsResponse expectedResponse =
        AddContextArtifactsAndExecutionsResponse.newBuilder().build();
    mockMetadataService.addResponse(expectedResponse);

    ContextName context =
        ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
    List<String> artifacts = new ArrayList<>();
    List<String> executions = new ArrayList<>();

    AddContextArtifactsAndExecutionsResponse actualResponse =
        client.addContextArtifactsAndExecutions(context, artifacts, executions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddContextArtifactsAndExecutionsRequest actualRequest =
        ((AddContextArtifactsAndExecutionsRequest) actualRequests.get(0));

    Assert.assertEquals(context.toString(), actualRequest.getContext());
    Assert.assertEquals(artifacts, actualRequest.getArtifactsList());
    Assert.assertEquals(executions, actualRequest.getExecutionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addContextArtifactsAndExecutionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      ContextName context =
          ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
      List<String> artifacts = new ArrayList<>();
      List<String> executions = new ArrayList<>();
      client.addContextArtifactsAndExecutions(context, artifacts, executions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addContextArtifactsAndExecutionsTest2() throws Exception {
    AddContextArtifactsAndExecutionsResponse expectedResponse =
        AddContextArtifactsAndExecutionsResponse.newBuilder().build();
    mockMetadataService.addResponse(expectedResponse);

    String context = "context951530927";
    List<String> artifacts = new ArrayList<>();
    List<String> executions = new ArrayList<>();

    AddContextArtifactsAndExecutionsResponse actualResponse =
        client.addContextArtifactsAndExecutions(context, artifacts, executions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddContextArtifactsAndExecutionsRequest actualRequest =
        ((AddContextArtifactsAndExecutionsRequest) actualRequests.get(0));

    Assert.assertEquals(context, actualRequest.getContext());
    Assert.assertEquals(artifacts, actualRequest.getArtifactsList());
    Assert.assertEquals(executions, actualRequest.getExecutionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addContextArtifactsAndExecutionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String context = "context951530927";
      List<String> artifacts = new ArrayList<>();
      List<String> executions = new ArrayList<>();
      client.addContextArtifactsAndExecutions(context, artifacts, executions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addContextChildrenTest() throws Exception {
    AddContextChildrenResponse expectedResponse = AddContextChildrenResponse.newBuilder().build();
    mockMetadataService.addResponse(expectedResponse);

    ContextName context =
        ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
    List<String> childContexts = new ArrayList<>();

    AddContextChildrenResponse actualResponse = client.addContextChildren(context, childContexts);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddContextChildrenRequest actualRequest = ((AddContextChildrenRequest) actualRequests.get(0));

    Assert.assertEquals(context.toString(), actualRequest.getContext());
    Assert.assertEquals(childContexts, actualRequest.getChildContextsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addContextChildrenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      ContextName context =
          ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
      List<String> childContexts = new ArrayList<>();
      client.addContextChildren(context, childContexts);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addContextChildrenTest2() throws Exception {
    AddContextChildrenResponse expectedResponse = AddContextChildrenResponse.newBuilder().build();
    mockMetadataService.addResponse(expectedResponse);

    String context = "context951530927";
    List<String> childContexts = new ArrayList<>();

    AddContextChildrenResponse actualResponse = client.addContextChildren(context, childContexts);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddContextChildrenRequest actualRequest = ((AddContextChildrenRequest) actualRequests.get(0));

    Assert.assertEquals(context, actualRequest.getContext());
    Assert.assertEquals(childContexts, actualRequest.getChildContextsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addContextChildrenExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String context = "context951530927";
      List<String> childContexts = new ArrayList<>();
      client.addContextChildren(context, childContexts);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeContextChildrenTest() throws Exception {
    RemoveContextChildrenResponse expectedResponse =
        RemoveContextChildrenResponse.newBuilder().build();
    mockMetadataService.addResponse(expectedResponse);

    ContextName context =
        ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
    List<String> childContexts = new ArrayList<>();

    RemoveContextChildrenResponse actualResponse =
        client.removeContextChildren(context, childContexts);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveContextChildrenRequest actualRequest =
        ((RemoveContextChildrenRequest) actualRequests.get(0));

    Assert.assertEquals(context.toString(), actualRequest.getContext());
    Assert.assertEquals(childContexts, actualRequest.getChildContextsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeContextChildrenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      ContextName context =
          ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
      List<String> childContexts = new ArrayList<>();
      client.removeContextChildren(context, childContexts);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeContextChildrenTest2() throws Exception {
    RemoveContextChildrenResponse expectedResponse =
        RemoveContextChildrenResponse.newBuilder().build();
    mockMetadataService.addResponse(expectedResponse);

    String context = "context951530927";
    List<String> childContexts = new ArrayList<>();

    RemoveContextChildrenResponse actualResponse =
        client.removeContextChildren(context, childContexts);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveContextChildrenRequest actualRequest =
        ((RemoveContextChildrenRequest) actualRequests.get(0));

    Assert.assertEquals(context, actualRequest.getContext());
    Assert.assertEquals(childContexts, actualRequest.getChildContextsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeContextChildrenExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String context = "context951530927";
      List<String> childContexts = new ArrayList<>();
      client.removeContextChildren(context, childContexts);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryContextLineageSubgraphTest() throws Exception {
    LineageSubgraph expectedResponse =
        LineageSubgraph.newBuilder()
            .addAllArtifacts(new ArrayList<Artifact>())
            .addAllExecutions(new ArrayList<Execution>())
            .addAllEvents(new ArrayList<Event>())
            .build();
    mockMetadataService.addResponse(expectedResponse);

    ContextName context =
        ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");

    LineageSubgraph actualResponse = client.queryContextLineageSubgraph(context);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryContextLineageSubgraphRequest actualRequest =
        ((QueryContextLineageSubgraphRequest) actualRequests.get(0));

    Assert.assertEquals(context.toString(), actualRequest.getContext());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryContextLineageSubgraphExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      ContextName context =
          ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
      client.queryContextLineageSubgraph(context);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryContextLineageSubgraphTest2() throws Exception {
    LineageSubgraph expectedResponse =
        LineageSubgraph.newBuilder()
            .addAllArtifacts(new ArrayList<Artifact>())
            .addAllExecutions(new ArrayList<Execution>())
            .addAllEvents(new ArrayList<Event>())
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String context = "context951530927";

    LineageSubgraph actualResponse = client.queryContextLineageSubgraph(context);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryContextLineageSubgraphRequest actualRequest =
        ((QueryContextLineageSubgraphRequest) actualRequests.get(0));

    Assert.assertEquals(context, actualRequest.getContext());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryContextLineageSubgraphExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String context = "context951530927";
      client.queryContextLineageSubgraph(context);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExecutionTest() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSchemaTitle("schemaTitle-1020962505")
            .setSchemaVersion("schemaVersion-233564169")
            .setMetadata(Struct.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    MetadataStoreName parent = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
    Execution execution = Execution.newBuilder().build();
    String executionId = "executionId-454906285";

    Execution actualResponse = client.createExecution(parent, execution, executionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExecutionRequest actualRequest = ((CreateExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(execution, actualRequest.getExecution());
    Assert.assertEquals(executionId, actualRequest.getExecutionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExecutionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      MetadataStoreName parent =
          MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
      Execution execution = Execution.newBuilder().build();
      String executionId = "executionId-454906285";
      client.createExecution(parent, execution, executionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExecutionTest2() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSchemaTitle("schemaTitle-1020962505")
            .setSchemaVersion("schemaVersion-233564169")
            .setMetadata(Struct.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Execution execution = Execution.newBuilder().build();
    String executionId = "executionId-454906285";

    Execution actualResponse = client.createExecution(parent, execution, executionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExecutionRequest actualRequest = ((CreateExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(execution, actualRequest.getExecution());
    Assert.assertEquals(executionId, actualRequest.getExecutionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExecutionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String parent = "parent-995424086";
      Execution execution = Execution.newBuilder().build();
      String executionId = "executionId-454906285";
      client.createExecution(parent, execution, executionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExecutionTest() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSchemaTitle("schemaTitle-1020962505")
            .setSchemaVersion("schemaVersion-233564169")
            .setMetadata(Struct.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    ExecutionName name =
        ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]");

    Execution actualResponse = client.getExecution(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExecutionRequest actualRequest = ((GetExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExecutionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      ExecutionName name =
          ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]");
      client.getExecution(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExecutionTest2() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSchemaTitle("schemaTitle-1020962505")
            .setSchemaVersion("schemaVersion-233564169")
            .setMetadata(Struct.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String name = "name3373707";

    Execution actualResponse = client.getExecution(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExecutionRequest actualRequest = ((GetExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExecutionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String name = "name3373707";
      client.getExecution(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExecutionsTest() throws Exception {
    Execution responsesElement = Execution.newBuilder().build();
    ListExecutionsResponse expectedResponse =
        ListExecutionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExecutions(Arrays.asList(responsesElement))
            .build();
    mockMetadataService.addResponse(expectedResponse);

    MetadataStoreName parent = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");

    ListExecutionsPagedResponse pagedListResponse = client.listExecutions(parent);

    List<Execution> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExecutionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExecutionsRequest actualRequest = ((ListExecutionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExecutionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      MetadataStoreName parent =
          MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
      client.listExecutions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExecutionsTest2() throws Exception {
    Execution responsesElement = Execution.newBuilder().build();
    ListExecutionsResponse expectedResponse =
        ListExecutionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExecutions(Arrays.asList(responsesElement))
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListExecutionsPagedResponse pagedListResponse = client.listExecutions(parent);

    List<Execution> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExecutionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExecutionsRequest actualRequest = ((ListExecutionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExecutionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listExecutions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateExecutionTest() throws Exception {
    Execution expectedResponse =
        Execution.newBuilder()
            .setName(
                ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSchemaTitle("schemaTitle-1020962505")
            .setSchemaVersion("schemaVersion-233564169")
            .setMetadata(Struct.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    Execution execution = Execution.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Execution actualResponse = client.updateExecution(execution, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExecutionRequest actualRequest = ((UpdateExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(execution, actualRequest.getExecution());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExecutionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      Execution execution = Execution.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateExecution(execution, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteExecutionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExecutionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    ExecutionName name =
        ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]");

    client.deleteExecutionAsync(name).get();

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExecutionRequest actualRequest = ((DeleteExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExecutionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      ExecutionName name =
          ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]");
      client.deleteExecutionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteExecutionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExecutionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteExecutionAsync(name).get();

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExecutionRequest actualRequest = ((DeleteExecutionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExecutionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteExecutionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void purgeExecutionsTest() throws Exception {
    PurgeExecutionsResponse expectedResponse =
        PurgeExecutionsResponse.newBuilder()
            .setPurgeCount(575305851)
            .addAllPurgeSample(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeExecutionsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    MetadataStoreName parent = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");

    PurgeExecutionsResponse actualResponse = client.purgeExecutionsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeExecutionsRequest actualRequest = ((PurgeExecutionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void purgeExecutionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      MetadataStoreName parent =
          MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
      client.purgeExecutionsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void purgeExecutionsTest2() throws Exception {
    PurgeExecutionsResponse expectedResponse =
        PurgeExecutionsResponse.newBuilder()
            .setPurgeCount(575305851)
            .addAllPurgeSample(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeExecutionsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetadataService.addResponse(resultOperation);

    String parent = "parent-995424086";

    PurgeExecutionsResponse actualResponse = client.purgeExecutionsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeExecutionsRequest actualRequest = ((PurgeExecutionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void purgeExecutionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.purgeExecutionsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void addExecutionEventsTest() throws Exception {
    AddExecutionEventsResponse expectedResponse = AddExecutionEventsResponse.newBuilder().build();
    mockMetadataService.addResponse(expectedResponse);

    ExecutionName execution =
        ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]");
    List<Event> events = new ArrayList<>();

    AddExecutionEventsResponse actualResponse = client.addExecutionEvents(execution, events);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddExecutionEventsRequest actualRequest = ((AddExecutionEventsRequest) actualRequests.get(0));

    Assert.assertEquals(execution.toString(), actualRequest.getExecution());
    Assert.assertEquals(events, actualRequest.getEventsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addExecutionEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      ExecutionName execution =
          ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]");
      List<Event> events = new ArrayList<>();
      client.addExecutionEvents(execution, events);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addExecutionEventsTest2() throws Exception {
    AddExecutionEventsResponse expectedResponse = AddExecutionEventsResponse.newBuilder().build();
    mockMetadataService.addResponse(expectedResponse);

    String execution = "execution-1090974952";
    List<Event> events = new ArrayList<>();

    AddExecutionEventsResponse actualResponse = client.addExecutionEvents(execution, events);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddExecutionEventsRequest actualRequest = ((AddExecutionEventsRequest) actualRequests.get(0));

    Assert.assertEquals(execution, actualRequest.getExecution());
    Assert.assertEquals(events, actualRequest.getEventsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addExecutionEventsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String execution = "execution-1090974952";
      List<Event> events = new ArrayList<>();
      client.addExecutionEvents(execution, events);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryExecutionInputsAndOutputsTest() throws Exception {
    LineageSubgraph expectedResponse =
        LineageSubgraph.newBuilder()
            .addAllArtifacts(new ArrayList<Artifact>())
            .addAllExecutions(new ArrayList<Execution>())
            .addAllEvents(new ArrayList<Event>())
            .build();
    mockMetadataService.addResponse(expectedResponse);

    ExecutionName execution =
        ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]");

    LineageSubgraph actualResponse = client.queryExecutionInputsAndOutputs(execution);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryExecutionInputsAndOutputsRequest actualRequest =
        ((QueryExecutionInputsAndOutputsRequest) actualRequests.get(0));

    Assert.assertEquals(execution.toString(), actualRequest.getExecution());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryExecutionInputsAndOutputsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      ExecutionName execution =
          ExecutionName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[EXECUTION]");
      client.queryExecutionInputsAndOutputs(execution);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryExecutionInputsAndOutputsTest2() throws Exception {
    LineageSubgraph expectedResponse =
        LineageSubgraph.newBuilder()
            .addAllArtifacts(new ArrayList<Artifact>())
            .addAllExecutions(new ArrayList<Execution>())
            .addAllEvents(new ArrayList<Event>())
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String execution = "execution-1090974952";

    LineageSubgraph actualResponse = client.queryExecutionInputsAndOutputs(execution);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryExecutionInputsAndOutputsRequest actualRequest =
        ((QueryExecutionInputsAndOutputsRequest) actualRequests.get(0));

    Assert.assertEquals(execution, actualRequest.getExecution());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryExecutionInputsAndOutputsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String execution = "execution-1090974952";
      client.queryExecutionInputsAndOutputs(execution);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMetadataSchemaTest() throws Exception {
    MetadataSchema expectedResponse =
        MetadataSchema.newBuilder()
            .setName(
                MetadataSchemaName.of(
                        "[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[METADATA_SCHEMA]")
                    .toString())
            .setSchemaVersion("schemaVersion-233564169")
            .setSchema("schema-907987551")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    MetadataStoreName parent = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
    MetadataSchema metadataSchema = MetadataSchema.newBuilder().build();
    String metadataSchemaId = "metadataSchemaId1549245163";

    MetadataSchema actualResponse =
        client.createMetadataSchema(parent, metadataSchema, metadataSchemaId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMetadataSchemaRequest actualRequest =
        ((CreateMetadataSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(metadataSchema, actualRequest.getMetadataSchema());
    Assert.assertEquals(metadataSchemaId, actualRequest.getMetadataSchemaId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMetadataSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      MetadataStoreName parent =
          MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
      MetadataSchema metadataSchema = MetadataSchema.newBuilder().build();
      String metadataSchemaId = "metadataSchemaId1549245163";
      client.createMetadataSchema(parent, metadataSchema, metadataSchemaId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMetadataSchemaTest2() throws Exception {
    MetadataSchema expectedResponse =
        MetadataSchema.newBuilder()
            .setName(
                MetadataSchemaName.of(
                        "[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[METADATA_SCHEMA]")
                    .toString())
            .setSchemaVersion("schemaVersion-233564169")
            .setSchema("schema-907987551")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    MetadataSchema metadataSchema = MetadataSchema.newBuilder().build();
    String metadataSchemaId = "metadataSchemaId1549245163";

    MetadataSchema actualResponse =
        client.createMetadataSchema(parent, metadataSchema, metadataSchemaId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMetadataSchemaRequest actualRequest =
        ((CreateMetadataSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(metadataSchema, actualRequest.getMetadataSchema());
    Assert.assertEquals(metadataSchemaId, actualRequest.getMetadataSchemaId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMetadataSchemaExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String parent = "parent-995424086";
      MetadataSchema metadataSchema = MetadataSchema.newBuilder().build();
      String metadataSchemaId = "metadataSchemaId1549245163";
      client.createMetadataSchema(parent, metadataSchema, metadataSchemaId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMetadataSchemaTest() throws Exception {
    MetadataSchema expectedResponse =
        MetadataSchema.newBuilder()
            .setName(
                MetadataSchemaName.of(
                        "[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[METADATA_SCHEMA]")
                    .toString())
            .setSchemaVersion("schemaVersion-233564169")
            .setSchema("schema-907987551")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    MetadataSchemaName name =
        MetadataSchemaName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[METADATA_SCHEMA]");

    MetadataSchema actualResponse = client.getMetadataSchema(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMetadataSchemaRequest actualRequest = ((GetMetadataSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMetadataSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      MetadataSchemaName name =
          MetadataSchemaName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[METADATA_SCHEMA]");
      client.getMetadataSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMetadataSchemaTest2() throws Exception {
    MetadataSchema expectedResponse =
        MetadataSchema.newBuilder()
            .setName(
                MetadataSchemaName.of(
                        "[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[METADATA_SCHEMA]")
                    .toString())
            .setSchemaVersion("schemaVersion-233564169")
            .setSchema("schema-907987551")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String name = "name3373707";

    MetadataSchema actualResponse = client.getMetadataSchema(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMetadataSchemaRequest actualRequest = ((GetMetadataSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMetadataSchemaExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String name = "name3373707";
      client.getMetadataSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMetadataSchemasTest() throws Exception {
    MetadataSchema responsesElement = MetadataSchema.newBuilder().build();
    ListMetadataSchemasResponse expectedResponse =
        ListMetadataSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllMetadataSchemas(Arrays.asList(responsesElement))
            .build();
    mockMetadataService.addResponse(expectedResponse);

    MetadataStoreName parent = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");

    ListMetadataSchemasPagedResponse pagedListResponse = client.listMetadataSchemas(parent);

    List<MetadataSchema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMetadataSchemasList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMetadataSchemasRequest actualRequest = ((ListMetadataSchemasRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMetadataSchemasExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      MetadataStoreName parent =
          MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
      client.listMetadataSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMetadataSchemasTest2() throws Exception {
    MetadataSchema responsesElement = MetadataSchema.newBuilder().build();
    ListMetadataSchemasResponse expectedResponse =
        ListMetadataSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllMetadataSchemas(Arrays.asList(responsesElement))
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMetadataSchemasPagedResponse pagedListResponse = client.listMetadataSchemas(parent);

    List<MetadataSchema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMetadataSchemasList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMetadataSchemasRequest actualRequest = ((ListMetadataSchemasRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMetadataSchemasExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMetadataSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryArtifactLineageSubgraphTest() throws Exception {
    LineageSubgraph expectedResponse =
        LineageSubgraph.newBuilder()
            .addAllArtifacts(new ArrayList<Artifact>())
            .addAllExecutions(new ArrayList<Execution>())
            .addAllEvents(new ArrayList<Event>())
            .build();
    mockMetadataService.addResponse(expectedResponse);

    ArtifactName artifact =
        ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]");

    LineageSubgraph actualResponse = client.queryArtifactLineageSubgraph(artifact);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryArtifactLineageSubgraphRequest actualRequest =
        ((QueryArtifactLineageSubgraphRequest) actualRequests.get(0));

    Assert.assertEquals(artifact.toString(), actualRequest.getArtifact());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryArtifactLineageSubgraphExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      ArtifactName artifact =
          ArtifactName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[ARTIFACT]");
      client.queryArtifactLineageSubgraph(artifact);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryArtifactLineageSubgraphTest2() throws Exception {
    LineageSubgraph expectedResponse =
        LineageSubgraph.newBuilder()
            .addAllArtifacts(new ArrayList<Artifact>())
            .addAllExecutions(new ArrayList<Execution>())
            .addAllEvents(new ArrayList<Event>())
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String artifact = "artifact-1228798510";

    LineageSubgraph actualResponse = client.queryArtifactLineageSubgraph(artifact);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryArtifactLineageSubgraphRequest actualRequest =
        ((QueryArtifactLineageSubgraphRequest) actualRequests.get(0));

    Assert.assertEquals(artifact, actualRequest.getArtifact());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryArtifactLineageSubgraphExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String artifact = "artifact-1228798510";
      client.queryArtifactLineageSubgraph(artifact);
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
