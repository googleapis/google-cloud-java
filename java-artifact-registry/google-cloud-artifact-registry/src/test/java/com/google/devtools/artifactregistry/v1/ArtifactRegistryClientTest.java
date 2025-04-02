/*
 * Copyright 2025 Google LLC
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

package com.google.devtools.artifactregistry.v1;

import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListAttachmentsPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListDockerImagesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListFilesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListLocationsPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListMavenArtifactsPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListNpmPackagesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListPackagesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListPythonPackagesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListRepositoriesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListRulesPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListTagsPagedResponse;
import static com.google.devtools.artifactregistry.v1.ArtifactRegistryClient.ListVersionsPagedResponse;

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
import com.google.type.Expr;
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
public class ArtifactRegistryClientTest {
  private static MockArtifactRegistry mockArtifactRegistry;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ArtifactRegistryClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockArtifactRegistry = new MockArtifactRegistry();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockArtifactRegistry, mockLocations));
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
    ArtifactRegistrySettings settings =
        ArtifactRegistrySettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ArtifactRegistryClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listDockerImagesTest() throws Exception {
    DockerImage responsesElement = DockerImage.newBuilder().build();
    ListDockerImagesResponse expectedResponse =
        ListDockerImagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDockerImages(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDockerImagesPagedResponse pagedListResponse = client.listDockerImages(parent);

    List<DockerImage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDockerImagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDockerImagesRequest actualRequest = ((ListDockerImagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDockerImagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDockerImages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDockerImageTest() throws Exception {
    DockerImage expectedResponse =
        DockerImage.newBuilder()
            .setName(
                DockerImageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[DOCKER_IMAGE]")
                    .toString())
            .setUri("uri116076")
            .addAllTags(new ArrayList<String>())
            .setImageSizeBytes(837030929)
            .setUploadTime(Timestamp.newBuilder().build())
            .setMediaType("mediaType2140463422")
            .setBuildTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    DockerImageName name =
        DockerImageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[DOCKER_IMAGE]");

    DockerImage actualResponse = client.getDockerImage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDockerImageRequest actualRequest = ((GetDockerImageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDockerImageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      DockerImageName name =
          DockerImageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[DOCKER_IMAGE]");
      client.getDockerImage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDockerImageTest2() throws Exception {
    DockerImage expectedResponse =
        DockerImage.newBuilder()
            .setName(
                DockerImageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[DOCKER_IMAGE]")
                    .toString())
            .setUri("uri116076")
            .addAllTags(new ArrayList<String>())
            .setImageSizeBytes(837030929)
            .setUploadTime(Timestamp.newBuilder().build())
            .setMediaType("mediaType2140463422")
            .setBuildTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    DockerImage actualResponse = client.getDockerImage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDockerImageRequest actualRequest = ((GetDockerImageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDockerImageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getDockerImage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMavenArtifactsTest() throws Exception {
    MavenArtifact responsesElement = MavenArtifact.newBuilder().build();
    ListMavenArtifactsResponse expectedResponse =
        ListMavenArtifactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMavenArtifacts(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListMavenArtifactsPagedResponse pagedListResponse = client.listMavenArtifacts(parent);

    List<MavenArtifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMavenArtifactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMavenArtifactsRequest actualRequest = ((ListMavenArtifactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMavenArtifactsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listMavenArtifacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMavenArtifactsTest2() throws Exception {
    MavenArtifact responsesElement = MavenArtifact.newBuilder().build();
    ListMavenArtifactsResponse expectedResponse =
        ListMavenArtifactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMavenArtifacts(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMavenArtifactsPagedResponse pagedListResponse = client.listMavenArtifacts(parent);

    List<MavenArtifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMavenArtifactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMavenArtifactsRequest actualRequest = ((ListMavenArtifactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMavenArtifactsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMavenArtifacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMavenArtifactTest() throws Exception {
    MavenArtifact expectedResponse =
        MavenArtifact.newBuilder()
            .setName(
                MavenArtifactName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[MAVEN_ARTIFACT]")
                    .toString())
            .setPomUri("pomUri-982659010")
            .setGroupId("groupId293428218")
            .setArtifactId("artifactId240640653")
            .setVersion("version351608024")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    MavenArtifactName name =
        MavenArtifactName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[MAVEN_ARTIFACT]");

    MavenArtifact actualResponse = client.getMavenArtifact(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMavenArtifactRequest actualRequest = ((GetMavenArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMavenArtifactExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      MavenArtifactName name =
          MavenArtifactName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[MAVEN_ARTIFACT]");
      client.getMavenArtifact(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMavenArtifactTest2() throws Exception {
    MavenArtifact expectedResponse =
        MavenArtifact.newBuilder()
            .setName(
                MavenArtifactName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[MAVEN_ARTIFACT]")
                    .toString())
            .setPomUri("pomUri-982659010")
            .setGroupId("groupId293428218")
            .setArtifactId("artifactId240640653")
            .setVersion("version351608024")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    MavenArtifact actualResponse = client.getMavenArtifact(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMavenArtifactRequest actualRequest = ((GetMavenArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMavenArtifactExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getMavenArtifact(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNpmPackagesTest() throws Exception {
    NpmPackage responsesElement = NpmPackage.newBuilder().build();
    ListNpmPackagesResponse expectedResponse =
        ListNpmPackagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNpmPackages(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListNpmPackagesPagedResponse pagedListResponse = client.listNpmPackages(parent);

    List<NpmPackage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNpmPackagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNpmPackagesRequest actualRequest = ((ListNpmPackagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNpmPackagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listNpmPackages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNpmPackagesTest2() throws Exception {
    NpmPackage responsesElement = NpmPackage.newBuilder().build();
    ListNpmPackagesResponse expectedResponse =
        ListNpmPackagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNpmPackages(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNpmPackagesPagedResponse pagedListResponse = client.listNpmPackages(parent);

    List<NpmPackage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNpmPackagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNpmPackagesRequest actualRequest = ((ListNpmPackagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNpmPackagesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNpmPackages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNpmPackageTest() throws Exception {
    NpmPackage expectedResponse =
        NpmPackage.newBuilder()
            .setName(
                NpmPackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[NPM_PACKAGE]")
                    .toString())
            .setPackageName("packageName908759025")
            .setVersion("version351608024")
            .addAllTags(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    NpmPackageName name =
        NpmPackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[NPM_PACKAGE]");

    NpmPackage actualResponse = client.getNpmPackage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNpmPackageRequest actualRequest = ((GetNpmPackageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNpmPackageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      NpmPackageName name =
          NpmPackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[NPM_PACKAGE]");
      client.getNpmPackage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNpmPackageTest2() throws Exception {
    NpmPackage expectedResponse =
        NpmPackage.newBuilder()
            .setName(
                NpmPackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[NPM_PACKAGE]")
                    .toString())
            .setPackageName("packageName908759025")
            .setVersion("version351608024")
            .addAllTags(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    NpmPackage actualResponse = client.getNpmPackage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNpmPackageRequest actualRequest = ((GetNpmPackageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNpmPackageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getNpmPackage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPythonPackagesTest() throws Exception {
    PythonPackage responsesElement = PythonPackage.newBuilder().build();
    ListPythonPackagesResponse expectedResponse =
        ListPythonPackagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPythonPackages(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListPythonPackagesPagedResponse pagedListResponse = client.listPythonPackages(parent);

    List<PythonPackage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPythonPackagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPythonPackagesRequest actualRequest = ((ListPythonPackagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPythonPackagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listPythonPackages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPythonPackagesTest2() throws Exception {
    PythonPackage responsesElement = PythonPackage.newBuilder().build();
    ListPythonPackagesResponse expectedResponse =
        ListPythonPackagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPythonPackages(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPythonPackagesPagedResponse pagedListResponse = client.listPythonPackages(parent);

    List<PythonPackage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPythonPackagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPythonPackagesRequest actualRequest = ((ListPythonPackagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPythonPackagesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPythonPackages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPythonPackageTest() throws Exception {
    PythonPackage expectedResponse =
        PythonPackage.newBuilder()
            .setName(
                PythonPackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PYTHON_PACKAGE]")
                    .toString())
            .setUri("uri116076")
            .setPackageName("packageName908759025")
            .setVersion("version351608024")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    PythonPackageName name =
        PythonPackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PYTHON_PACKAGE]");

    PythonPackage actualResponse = client.getPythonPackage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPythonPackageRequest actualRequest = ((GetPythonPackageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPythonPackageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      PythonPackageName name =
          PythonPackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PYTHON_PACKAGE]");
      client.getPythonPackage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPythonPackageTest2() throws Exception {
    PythonPackage expectedResponse =
        PythonPackage.newBuilder()
            .setName(
                PythonPackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PYTHON_PACKAGE]")
                    .toString())
            .setUri("uri116076")
            .setPackageName("packageName908759025")
            .setVersion("version351608024")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    PythonPackage actualResponse = client.getPythonPackage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPythonPackageRequest actualRequest = ((GetPythonPackageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPythonPackageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getPythonPackage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importAptArtifactsTest() throws Exception {
    ImportAptArtifactsResponse expectedResponse =
        ImportAptArtifactsResponse.newBuilder()
            .addAllAptArtifacts(new ArrayList<AptArtifact>())
            .addAllErrors(new ArrayList<ImportAptArtifactsErrorInfo>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importAptArtifactsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    ImportAptArtifactsRequest request =
        ImportAptArtifactsRequest.newBuilder().setParent("parent-995424086").build();

    ImportAptArtifactsResponse actualResponse = client.importAptArtifactsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportAptArtifactsRequest actualRequest = ((ImportAptArtifactsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getGcsSource(), actualRequest.getGcsSource());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importAptArtifactsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      ImportAptArtifactsRequest request =
          ImportAptArtifactsRequest.newBuilder().setParent("parent-995424086").build();
      client.importAptArtifactsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importYumArtifactsTest() throws Exception {
    ImportYumArtifactsResponse expectedResponse =
        ImportYumArtifactsResponse.newBuilder()
            .addAllYumArtifacts(new ArrayList<YumArtifact>())
            .addAllErrors(new ArrayList<ImportYumArtifactsErrorInfo>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importYumArtifactsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    ImportYumArtifactsRequest request =
        ImportYumArtifactsRequest.newBuilder().setParent("parent-995424086").build();

    ImportYumArtifactsResponse actualResponse = client.importYumArtifactsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportYumArtifactsRequest actualRequest = ((ImportYumArtifactsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getGcsSource(), actualRequest.getGcsSource());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importYumArtifactsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      ImportYumArtifactsRequest request =
          ImportYumArtifactsRequest.newBuilder().setParent("parent-995424086").build();
      client.importYumArtifactsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listRepositoriesTest() throws Exception {
    Repository responsesElement = Repository.newBuilder().build();
    ListRepositoriesResponse expectedResponse =
        ListRepositoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRepositories(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRepositoriesPagedResponse pagedListResponse = client.listRepositories(parent);

    List<Repository> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRepositoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRepositoriesRequest actualRequest = ((ListRepositoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRepositoriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRepositories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRepositoriesTest2() throws Exception {
    Repository responsesElement = Repository.newBuilder().build();
    ListRepositoriesResponse expectedResponse =
        ListRepositoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRepositories(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRepositoriesPagedResponse pagedListResponse = client.listRepositories(parent);

    List<Repository> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRepositoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRepositoriesRequest actualRequest = ((ListRepositoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRepositoriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRepositories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRepositoryTest() throws Exception {
    Repository expectedResponse =
        Repository.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .putAllCleanupPolicies(new HashMap<String, CleanupPolicy>())
            .setSizeBytes(-1796325715)
            .setSatisfiesPzs(true)
            .setCleanupPolicyDryRun(true)
            .setVulnerabilityScanningConfig(
                Repository.VulnerabilityScanningConfig.newBuilder().build())
            .setDisallowUnspecifiedMode(true)
            .setSatisfiesPzi(true)
            .setRegistryUri("registryUri-2121082897")
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    Repository actualResponse = client.getRepository(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRepositoryRequest actualRequest = ((GetRepositoryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRepositoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.getRepository(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRepositoryTest2() throws Exception {
    Repository expectedResponse =
        Repository.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .putAllCleanupPolicies(new HashMap<String, CleanupPolicy>())
            .setSizeBytes(-1796325715)
            .setSatisfiesPzs(true)
            .setCleanupPolicyDryRun(true)
            .setVulnerabilityScanningConfig(
                Repository.VulnerabilityScanningConfig.newBuilder().build())
            .setDisallowUnspecifiedMode(true)
            .setSatisfiesPzi(true)
            .setRegistryUri("registryUri-2121082897")
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    Repository actualResponse = client.getRepository(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRepositoryRequest actualRequest = ((GetRepositoryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRepositoryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getRepository(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRepositoryTest() throws Exception {
    Repository expectedResponse =
        Repository.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .putAllCleanupPolicies(new HashMap<String, CleanupPolicy>())
            .setSizeBytes(-1796325715)
            .setSatisfiesPzs(true)
            .setCleanupPolicyDryRun(true)
            .setVulnerabilityScanningConfig(
                Repository.VulnerabilityScanningConfig.newBuilder().build())
            .setDisallowUnspecifiedMode(true)
            .setSatisfiesPzi(true)
            .setRegistryUri("registryUri-2121082897")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRepositoryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Repository repository = Repository.newBuilder().build();
    String repositoryId = "repositoryId2113747461";

    Repository actualResponse =
        client.createRepositoryAsync(parent, repository, repositoryId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRepositoryRequest actualRequest = ((CreateRepositoryRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(repository, actualRequest.getRepository());
    Assert.assertEquals(repositoryId, actualRequest.getRepositoryId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRepositoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Repository repository = Repository.newBuilder().build();
      String repositoryId = "repositoryId2113747461";
      client.createRepositoryAsync(parent, repository, repositoryId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createRepositoryTest2() throws Exception {
    Repository expectedResponse =
        Repository.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .putAllCleanupPolicies(new HashMap<String, CleanupPolicy>())
            .setSizeBytes(-1796325715)
            .setSatisfiesPzs(true)
            .setCleanupPolicyDryRun(true)
            .setVulnerabilityScanningConfig(
                Repository.VulnerabilityScanningConfig.newBuilder().build())
            .setDisallowUnspecifiedMode(true)
            .setSatisfiesPzi(true)
            .setRegistryUri("registryUri-2121082897")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRepositoryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    String parent = "parent-995424086";
    Repository repository = Repository.newBuilder().build();
    String repositoryId = "repositoryId2113747461";

    Repository actualResponse =
        client.createRepositoryAsync(parent, repository, repositoryId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRepositoryRequest actualRequest = ((CreateRepositoryRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(repository, actualRequest.getRepository());
    Assert.assertEquals(repositoryId, actualRequest.getRepositoryId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRepositoryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      Repository repository = Repository.newBuilder().build();
      String repositoryId = "repositoryId2113747461";
      client.createRepositoryAsync(parent, repository, repositoryId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateRepositoryTest() throws Exception {
    Repository expectedResponse =
        Repository.newBuilder()
            .setName(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .putAllCleanupPolicies(new HashMap<String, CleanupPolicy>())
            .setSizeBytes(-1796325715)
            .setSatisfiesPzs(true)
            .setCleanupPolicyDryRun(true)
            .setVulnerabilityScanningConfig(
                Repository.VulnerabilityScanningConfig.newBuilder().build())
            .setDisallowUnspecifiedMode(true)
            .setSatisfiesPzi(true)
            .setRegistryUri("registryUri-2121082897")
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    Repository repository = Repository.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Repository actualResponse = client.updateRepository(repository, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRepositoryRequest actualRequest = ((UpdateRepositoryRequest) actualRequests.get(0));

    Assert.assertEquals(repository, actualRequest.getRepository());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRepositoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      Repository repository = Repository.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRepository(repository, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRepositoryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRepositoryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    client.deleteRepositoryAsync(name).get();

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRepositoryRequest actualRequest = ((DeleteRepositoryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRepositoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      RepositoryName name = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.deleteRepositoryAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRepositoryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRepositoryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteRepositoryAsync(name).get();

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRepositoryRequest actualRequest = ((DeleteRepositoryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRepositoryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRepositoryAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listPackagesTest() throws Exception {
    Package responsesElement = Package.newBuilder().build();
    ListPackagesResponse expectedResponse =
        ListPackagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPackages(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListPackagesPagedResponse pagedListResponse = client.listPackages(parent);

    List<Package> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPackagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPackagesRequest actualRequest = ((ListPackagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPackagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listPackages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPackagesTest2() throws Exception {
    Package responsesElement = Package.newBuilder().build();
    ListPackagesResponse expectedResponse =
        ListPackagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPackages(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPackagesPagedResponse pagedListResponse = client.listPackages(parent);

    List<Package> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPackagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPackagesRequest actualRequest = ((ListPackagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPackagesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPackages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPackageTest() throws Exception {
    Package expectedResponse =
        Package.newBuilder()
            .setName(
                PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    PackageName name = PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]");

    Package actualResponse = client.getPackage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPackageRequest actualRequest = ((GetPackageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPackageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      PackageName name = PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]");
      client.getPackage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPackageTest2() throws Exception {
    Package expectedResponse =
        Package.newBuilder()
            .setName(
                PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    Package actualResponse = client.getPackage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPackageRequest actualRequest = ((GetPackageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPackageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getPackage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePackageTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePackageTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    PackageName name = PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]");

    client.deletePackageAsync(name).get();

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePackageRequest actualRequest = ((DeletePackageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePackageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      PackageName name = PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]");
      client.deletePackageAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePackageTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePackageTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    String name = "name3373707";

    client.deletePackageAsync(name).get();

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePackageRequest actualRequest = ((DeletePackageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePackageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.deletePackageAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listVersionsTest() throws Exception {
    Version responsesElement = Version.newBuilder().build();
    ListVersionsResponse expectedResponse =
        ListVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVersions(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListVersionsPagedResponse pagedListResponse = client.listVersions(parent);

    List<Version> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVersionsRequest actualRequest = ((ListVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVersionTest() throws Exception {
    Version expectedResponse =
        Version.newBuilder()
            .setName(
                VersionName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]", "[VERSION]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRelatedTags(new ArrayList<Tag>())
            .setMetadata(Struct.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    Version actualResponse = client.getVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVersionRequest actualRequest = ((GetVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteVersionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteVersionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteVersionAsync(name).get();

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteVersionRequest actualRequest = ((DeleteVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.deleteVersionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchDeleteVersionsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchDeleteVersionsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    PackageName parent = PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]");
    List<String> names = new ArrayList<>();

    client.batchDeleteVersionsAsync(parent, names).get();

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteVersionsRequest actualRequest = ((BatchDeleteVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(names, actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      PackageName parent = PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]");
      List<String> names = new ArrayList<>();
      client.batchDeleteVersionsAsync(parent, names).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchDeleteVersionsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchDeleteVersionsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    String parent = "parent-995424086";
    List<String> names = new ArrayList<>();

    client.batchDeleteVersionsAsync(parent, names).get();

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteVersionsRequest actualRequest = ((BatchDeleteVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(names, actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      List<String> names = new ArrayList<>();
      client.batchDeleteVersionsAsync(parent, names).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateVersionTest() throws Exception {
    Version expectedResponse =
        Version.newBuilder()
            .setName(
                VersionName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]", "[VERSION]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRelatedTags(new ArrayList<Tag>())
            .setMetadata(Struct.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    Version version = Version.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Version actualResponse = client.updateVersion(version, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateVersionRequest actualRequest = ((UpdateVersionRequest) actualRequests.get(0));

    Assert.assertEquals(version, actualRequest.getVersion());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      Version version = Version.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateVersion(version, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFilesTest() throws Exception {
    File responsesElement = File.newBuilder().build();
    ListFilesResponse expectedResponse =
        ListFilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFiles(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListFilesPagedResponse pagedListResponse = client.listFiles(parent);

    List<File> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFilesRequest actualRequest = ((ListFilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listFiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFilesTest2() throws Exception {
    File responsesElement = File.newBuilder().build();
    ListFilesResponse expectedResponse =
        ListFilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFiles(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFilesPagedResponse pagedListResponse = client.listFiles(parent);

    List<File> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFilesRequest actualRequest = ((ListFilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFilesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFileTest() throws Exception {
    File expectedResponse =
        File.newBuilder()
            .setName(FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]").toString())
            .setSizeBytes(-1796325715)
            .addAllHashes(new ArrayList<Hash>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOwner("owner106164915")
            .setFetchTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    FileName name = FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]");

    File actualResponse = client.getFile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFileRequest actualRequest = ((GetFileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      FileName name = FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]");
      client.getFile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFileTest2() throws Exception {
    File expectedResponse =
        File.newBuilder()
            .setName(FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]").toString())
            .setSizeBytes(-1796325715)
            .addAllHashes(new ArrayList<Hash>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOwner("owner106164915")
            .setFetchTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    File actualResponse = client.getFile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFileRequest actualRequest = ((GetFileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getFile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFileTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    FileName name = FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]");

    client.deleteFileAsync(name).get();

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFileRequest actualRequest = ((DeleteFileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      FileName name = FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]");
      client.deleteFileAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFileTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteFileAsync(name).get();

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFileRequest actualRequest = ((DeleteFileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.deleteFileAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateFileTest() throws Exception {
    File expectedResponse =
        File.newBuilder()
            .setName(FileName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[FILE]").toString())
            .setSizeBytes(-1796325715)
            .addAllHashes(new ArrayList<Hash>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOwner("owner106164915")
            .setFetchTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    File file = File.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    File actualResponse = client.updateFile(file, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFileRequest actualRequest = ((UpdateFileRequest) actualRequests.get(0));

    Assert.assertEquals(file, actualRequest.getFile());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      File file = File.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFile(file, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTagsTest() throws Exception {
    Tag responsesElement = Tag.newBuilder().build();
    ListTagsResponse expectedResponse =
        ListTagsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTags(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTagsPagedResponse pagedListResponse = client.listTags(parent);

    List<Tag> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTagsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTagsRequest actualRequest = ((ListTagsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTagsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTags(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTagTest() throws Exception {
    Tag expectedResponse =
        Tag.newBuilder().setName("name3373707").setVersion("version351608024").build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    Tag actualResponse = client.getTag(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTagRequest actualRequest = ((GetTagRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getTag(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTagTest() throws Exception {
    Tag expectedResponse =
        Tag.newBuilder().setName("name3373707").setVersion("version351608024").build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Tag tag = Tag.newBuilder().build();
    String tagId = "tagId110119509";

    Tag actualResponse = client.createTag(parent, tag, tagId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTagRequest actualRequest = ((CreateTagRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tag, actualRequest.getTag());
    Assert.assertEquals(tagId, actualRequest.getTagId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      Tag tag = Tag.newBuilder().build();
      String tagId = "tagId110119509";
      client.createTag(parent, tag, tagId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTagTest() throws Exception {
    Tag expectedResponse =
        Tag.newBuilder().setName("name3373707").setVersion("version351608024").build();
    mockArtifactRegistry.addResponse(expectedResponse);

    Tag tag = Tag.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Tag actualResponse = client.updateTag(tag, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTagRequest actualRequest = ((UpdateTagRequest) actualRequests.get(0));

    Assert.assertEquals(tag, actualRequest.getTag());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      Tag tag = Tag.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTag(tag, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTagTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTag(name);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTagRequest actualRequest = ((DeleteTagRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTag(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRuleTest() throws Exception {
    Rule expectedResponse =
        Rule.newBuilder()
            .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]").toString())
            .setCondition(Expr.newBuilder().build())
            .setPackageId("packageId1802060801")
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
    Rule rule = Rule.newBuilder().build();
    String ruleId = "ruleId-919875273";

    Rule actualResponse = client.createRule(parent, rule, ruleId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRuleRequest actualRequest = ((CreateRuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(rule, actualRequest.getRule());
    Assert.assertEquals(ruleId, actualRequest.getRuleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      Rule rule = Rule.newBuilder().build();
      String ruleId = "ruleId-919875273";
      client.createRule(parent, rule, ruleId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRuleTest2() throws Exception {
    Rule expectedResponse =
        Rule.newBuilder()
            .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]").toString())
            .setCondition(Expr.newBuilder().build())
            .setPackageId("packageId1802060801")
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Rule rule = Rule.newBuilder().build();
    String ruleId = "ruleId-919875273";

    Rule actualResponse = client.createRule(parent, rule, ruleId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRuleRequest actualRequest = ((CreateRuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(rule, actualRequest.getRule());
    Assert.assertEquals(ruleId, actualRequest.getRuleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      Rule rule = Rule.newBuilder().build();
      String ruleId = "ruleId-919875273";
      client.createRule(parent, rule, ruleId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRulesTest() throws Exception {
    Rule responsesElement = Rule.newBuilder().build();
    ListRulesResponse expectedResponse =
        ListRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRules(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListRulesPagedResponse pagedListResponse = client.listRules(parent);

    List<Rule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRulesRequest actualRequest = ((ListRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRulesTest2() throws Exception {
    Rule responsesElement = Rule.newBuilder().build();
    ListRulesResponse expectedResponse =
        ListRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRules(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRulesPagedResponse pagedListResponse = client.listRules(parent);

    List<Rule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRulesRequest actualRequest = ((ListRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRuleTest() throws Exception {
    Rule expectedResponse =
        Rule.newBuilder()
            .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]").toString())
            .setCondition(Expr.newBuilder().build())
            .setPackageId("packageId1802060801")
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]");

    Rule actualResponse = client.getRule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRuleRequest actualRequest = ((GetRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]");
      client.getRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRuleTest2() throws Exception {
    Rule expectedResponse =
        Rule.newBuilder()
            .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]").toString())
            .setCondition(Expr.newBuilder().build())
            .setPackageId("packageId1802060801")
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    Rule actualResponse = client.getRule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRuleRequest actualRequest = ((GetRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRuleTest() throws Exception {
    Rule expectedResponse =
        Rule.newBuilder()
            .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]").toString())
            .setCondition(Expr.newBuilder().build())
            .setPackageId("packageId1802060801")
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    Rule rule = Rule.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Rule actualResponse = client.updateRule(rule, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRuleRequest actualRequest = ((UpdateRuleRequest) actualRequests.get(0));

    Assert.assertEquals(rule, actualRequest.getRule());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      Rule rule = Rule.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRule(rule, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRuleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockArtifactRegistry.addResponse(expectedResponse);

    RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]");

    client.deleteRule(name);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRuleRequest actualRequest = ((DeleteRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[RULE]");
      client.deleteRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRuleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteRule(name);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRuleRequest actualRequest = ((DeleteRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRule(name);
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
    mockArtifactRegistry.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
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
    mockArtifactRegistry.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
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
    mockArtifactRegistry.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
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
    mockArtifactRegistry.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
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
    mockArtifactRegistry.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
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
    mockArtifactRegistry.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProjectSettingsTest() throws Exception {
    ProjectSettings expectedResponse =
        ProjectSettings.newBuilder()
            .setName(ProjectSettingsName.of("[PROJECT]").toString())
            .setPullPercent(1781572683)
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    ProjectSettingsName name = ProjectSettingsName.of("[PROJECT]");

    ProjectSettings actualResponse = client.getProjectSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProjectSettingsRequest actualRequest = ((GetProjectSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProjectSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      ProjectSettingsName name = ProjectSettingsName.of("[PROJECT]");
      client.getProjectSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProjectSettingsTest2() throws Exception {
    ProjectSettings expectedResponse =
        ProjectSettings.newBuilder()
            .setName(ProjectSettingsName.of("[PROJECT]").toString())
            .setPullPercent(1781572683)
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    ProjectSettings actualResponse = client.getProjectSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProjectSettingsRequest actualRequest = ((GetProjectSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProjectSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getProjectSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateProjectSettingsTest() throws Exception {
    ProjectSettings expectedResponse =
        ProjectSettings.newBuilder()
            .setName(ProjectSettingsName.of("[PROJECT]").toString())
            .setPullPercent(1781572683)
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    ProjectSettings projectSettings = ProjectSettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ProjectSettings actualResponse = client.updateProjectSettings(projectSettings, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateProjectSettingsRequest actualRequest =
        ((UpdateProjectSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(projectSettings, actualRequest.getProjectSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateProjectSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      ProjectSettings projectSettings = ProjectSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateProjectSettings(projectSettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVPCSCConfigTest() throws Exception {
    VPCSCConfig expectedResponse =
        VPCSCConfig.newBuilder()
            .setName(VpcscConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    VpcscConfigName name = VpcscConfigName.of("[PROJECT]", "[LOCATION]");

    VPCSCConfig actualResponse = client.getVPCSCConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVPCSCConfigRequest actualRequest = ((GetVPCSCConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVPCSCConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      VpcscConfigName name = VpcscConfigName.of("[PROJECT]", "[LOCATION]");
      client.getVPCSCConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVPCSCConfigTest2() throws Exception {
    VPCSCConfig expectedResponse =
        VPCSCConfig.newBuilder()
            .setName(VpcscConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    VPCSCConfig actualResponse = client.getVPCSCConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVPCSCConfigRequest actualRequest = ((GetVPCSCConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVPCSCConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getVPCSCConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateVPCSCConfigTest() throws Exception {
    VPCSCConfig expectedResponse =
        VPCSCConfig.newBuilder()
            .setName(VpcscConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    VPCSCConfig vpcscConfig = VPCSCConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    VPCSCConfig actualResponse = client.updateVPCSCConfig(vpcscConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateVPCSCConfigRequest actualRequest = ((UpdateVPCSCConfigRequest) actualRequests.get(0));

    Assert.assertEquals(vpcscConfig, actualRequest.getVpcscConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateVPCSCConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      VPCSCConfig vpcscConfig = VPCSCConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateVPCSCConfig(vpcscConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePackageTest() throws Exception {
    Package expectedResponse =
        Package.newBuilder()
            .setName(
                PackageName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[PACKAGE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    Package package_ = Package.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Package actualResponse = client.updatePackage(package_, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePackageRequest actualRequest = ((UpdatePackageRequest) actualRequests.get(0));

    Assert.assertEquals(package_, actualRequest.getPackage());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePackageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      Package package_ = Package.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePackage(package_, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttachmentsTest() throws Exception {
    Attachment responsesElement = Attachment.newBuilder().build();
    ListAttachmentsResponse expectedResponse =
        ListAttachmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttachments(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");

    ListAttachmentsPagedResponse pagedListResponse = client.listAttachments(parent);

    List<Attachment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttachmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAttachmentsRequest actualRequest = ((ListAttachmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAttachmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      client.listAttachments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttachmentsTest2() throws Exception {
    Attachment responsesElement = Attachment.newBuilder().build();
    ListAttachmentsResponse expectedResponse =
        ListAttachmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttachments(Arrays.asList(responsesElement))
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAttachmentsPagedResponse pagedListResponse = client.listAttachments(parent);

    List<Attachment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttachmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAttachmentsRequest actualRequest = ((ListAttachmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAttachmentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAttachments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttachmentTest() throws Exception {
    Attachment expectedResponse =
        Attachment.newBuilder()
            .setName(
                AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]")
                    .toString())
            .setTarget("target-880905839")
            .setType("type3575610")
            .setAttachmentNamespace("attachmentNamespace-1956859016")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllFiles(new ArrayList<String>())
            .setOciVersionName("ociVersionName-533968082")
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    AttachmentName name =
        AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]");

    Attachment actualResponse = client.getAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAttachmentRequest actualRequest = ((GetAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      AttachmentName name =
          AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]");
      client.getAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttachmentTest2() throws Exception {
    Attachment expectedResponse =
        Attachment.newBuilder()
            .setName(
                AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]")
                    .toString())
            .setTarget("target-880905839")
            .setType("type3575610")
            .setAttachmentNamespace("attachmentNamespace-1956859016")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllFiles(new ArrayList<String>())
            .setOciVersionName("ociVersionName-533968082")
            .build();
    mockArtifactRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    Attachment actualResponse = client.getAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAttachmentRequest actualRequest = ((GetAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAttachmentTest() throws Exception {
    Attachment expectedResponse =
        Attachment.newBuilder()
            .setName(
                AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]")
                    .toString())
            .setTarget("target-880905839")
            .setType("type3575610")
            .setAttachmentNamespace("attachmentNamespace-1956859016")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllFiles(new ArrayList<String>())
            .setOciVersionName("ociVersionName-533968082")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAttachmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
    Attachment attachment = Attachment.newBuilder().build();
    String attachmentId = "attachmentId-1434081890";

    Attachment actualResponse =
        client.createAttachmentAsync(parent, attachment, attachmentId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAttachmentRequest actualRequest = ((CreateAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(attachment, actualRequest.getAttachment());
    Assert.assertEquals(attachmentId, actualRequest.getAttachmentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      RepositoryName parent = RepositoryName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]");
      Attachment attachment = Attachment.newBuilder().build();
      String attachmentId = "attachmentId-1434081890";
      client.createAttachmentAsync(parent, attachment, attachmentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAttachmentTest2() throws Exception {
    Attachment expectedResponse =
        Attachment.newBuilder()
            .setName(
                AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]")
                    .toString())
            .setTarget("target-880905839")
            .setType("type3575610")
            .setAttachmentNamespace("attachmentNamespace-1956859016")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllFiles(new ArrayList<String>())
            .setOciVersionName("ociVersionName-533968082")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAttachmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    String parent = "parent-995424086";
    Attachment attachment = Attachment.newBuilder().build();
    String attachmentId = "attachmentId-1434081890";

    Attachment actualResponse =
        client.createAttachmentAsync(parent, attachment, attachmentId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAttachmentRequest actualRequest = ((CreateAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(attachment, actualRequest.getAttachment());
    Assert.assertEquals(attachmentId, actualRequest.getAttachmentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      Attachment attachment = Attachment.newBuilder().build();
      String attachmentId = "attachmentId-1434081890";
      client.createAttachmentAsync(parent, attachment, attachmentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAttachmentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAttachmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    AttachmentName name =
        AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]");

    client.deleteAttachmentAsync(name).get();

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAttachmentRequest actualRequest = ((DeleteAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      AttachmentName name =
          AttachmentName.of("[PROJECT]", "[LOCATION]", "[REPOSITORY]", "[ATTACHMENT]");
      client.deleteAttachmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAttachmentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAttachmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockArtifactRegistry.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAttachmentAsync(name).get();

    List<AbstractMessage> actualRequests = mockArtifactRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAttachmentRequest actualRequest = ((DeleteAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockArtifactRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAttachmentAsync(name).get();
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
