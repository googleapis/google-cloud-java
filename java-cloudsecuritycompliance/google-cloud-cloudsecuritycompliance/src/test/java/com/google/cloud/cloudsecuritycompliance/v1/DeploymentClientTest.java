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

package com.google.cloud.cloudsecuritycompliance.v1;

import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListCloudControlDeploymentsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListFrameworkDeploymentsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListLocationsPagedResponse;

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
public class DeploymentClientTest {
  private static MockDeployment mockDeployment;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DeploymentClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDeployment = new MockDeployment();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDeployment, mockLocations));
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
    DeploymentSettings settings =
        DeploymentSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DeploymentClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createFrameworkDeploymentTest() throws Exception {
    FrameworkDeployment expectedResponse =
        FrameworkDeployment.newBuilder()
            .setName(
                FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
                    .toString())
            .setTargetResourceConfig(TargetResourceConfig.newBuilder().build())
            .setComputedTargetResource("computedTargetResource-479139540")
            .setFramework(FrameworkReference.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllCloudControlMetadata(new ArrayList<CloudControlMetadata>())
            .setDeploymentState(DeploymentState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setTargetResourceDisplayName("targetResourceDisplayName-1474402258")
            .addAllCloudControlDeploymentReferences(
                new ArrayList<CloudControlDeploymentReference>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFrameworkDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDeployment.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    FrameworkDeployment frameworkDeployment = FrameworkDeployment.newBuilder().build();
    String frameworkDeploymentId = "frameworkDeploymentId-1244700706";

    FrameworkDeployment actualResponse =
        client
            .createFrameworkDeploymentAsync(parent, frameworkDeployment, frameworkDeploymentId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeployment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFrameworkDeploymentRequest actualRequest =
        ((CreateFrameworkDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(frameworkDeployment, actualRequest.getFrameworkDeployment());
    Assert.assertEquals(frameworkDeploymentId, actualRequest.getFrameworkDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFrameworkDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeployment.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      FrameworkDeployment frameworkDeployment = FrameworkDeployment.newBuilder().build();
      String frameworkDeploymentId = "frameworkDeploymentId-1244700706";
      client
          .createFrameworkDeploymentAsync(parent, frameworkDeployment, frameworkDeploymentId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createFrameworkDeploymentTest2() throws Exception {
    FrameworkDeployment expectedResponse =
        FrameworkDeployment.newBuilder()
            .setName(
                FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
                    .toString())
            .setTargetResourceConfig(TargetResourceConfig.newBuilder().build())
            .setComputedTargetResource("computedTargetResource-479139540")
            .setFramework(FrameworkReference.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllCloudControlMetadata(new ArrayList<CloudControlMetadata>())
            .setDeploymentState(DeploymentState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setTargetResourceDisplayName("targetResourceDisplayName-1474402258")
            .addAllCloudControlDeploymentReferences(
                new ArrayList<CloudControlDeploymentReference>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFrameworkDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDeployment.addResponse(resultOperation);

    String parent = "parent-995424086";
    FrameworkDeployment frameworkDeployment = FrameworkDeployment.newBuilder().build();
    String frameworkDeploymentId = "frameworkDeploymentId-1244700706";

    FrameworkDeployment actualResponse =
        client
            .createFrameworkDeploymentAsync(parent, frameworkDeployment, frameworkDeploymentId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeployment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFrameworkDeploymentRequest actualRequest =
        ((CreateFrameworkDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(frameworkDeployment, actualRequest.getFrameworkDeployment());
    Assert.assertEquals(frameworkDeploymentId, actualRequest.getFrameworkDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFrameworkDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeployment.addException(exception);

    try {
      String parent = "parent-995424086";
      FrameworkDeployment frameworkDeployment = FrameworkDeployment.newBuilder().build();
      String frameworkDeploymentId = "frameworkDeploymentId-1244700706";
      client
          .createFrameworkDeploymentAsync(parent, frameworkDeployment, frameworkDeploymentId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFrameworkDeploymentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFrameworkDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDeployment.addResponse(resultOperation);

    FrameworkDeploymentName name =
        FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]");

    client.deleteFrameworkDeploymentAsync(name).get();

    List<AbstractMessage> actualRequests = mockDeployment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFrameworkDeploymentRequest actualRequest =
        ((DeleteFrameworkDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFrameworkDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeployment.addException(exception);

    try {
      FrameworkDeploymentName name =
          FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]");
      client.deleteFrameworkDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFrameworkDeploymentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFrameworkDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDeployment.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteFrameworkDeploymentAsync(name).get();

    List<AbstractMessage> actualRequests = mockDeployment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFrameworkDeploymentRequest actualRequest =
        ((DeleteFrameworkDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFrameworkDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeployment.addException(exception);

    try {
      String name = "name3373707";
      client.deleteFrameworkDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getFrameworkDeploymentTest() throws Exception {
    FrameworkDeployment expectedResponse =
        FrameworkDeployment.newBuilder()
            .setName(
                FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
                    .toString())
            .setTargetResourceConfig(TargetResourceConfig.newBuilder().build())
            .setComputedTargetResource("computedTargetResource-479139540")
            .setFramework(FrameworkReference.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllCloudControlMetadata(new ArrayList<CloudControlMetadata>())
            .setDeploymentState(DeploymentState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setTargetResourceDisplayName("targetResourceDisplayName-1474402258")
            .addAllCloudControlDeploymentReferences(
                new ArrayList<CloudControlDeploymentReference>())
            .build();
    mockDeployment.addResponse(expectedResponse);

    FrameworkDeploymentName name =
        FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]");

    FrameworkDeployment actualResponse = client.getFrameworkDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeployment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFrameworkDeploymentRequest actualRequest =
        ((GetFrameworkDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFrameworkDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeployment.addException(exception);

    try {
      FrameworkDeploymentName name =
          FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]");
      client.getFrameworkDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFrameworkDeploymentTest2() throws Exception {
    FrameworkDeployment expectedResponse =
        FrameworkDeployment.newBuilder()
            .setName(
                FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
                    .toString())
            .setTargetResourceConfig(TargetResourceConfig.newBuilder().build())
            .setComputedTargetResource("computedTargetResource-479139540")
            .setFramework(FrameworkReference.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllCloudControlMetadata(new ArrayList<CloudControlMetadata>())
            .setDeploymentState(DeploymentState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setTargetResourceDisplayName("targetResourceDisplayName-1474402258")
            .addAllCloudControlDeploymentReferences(
                new ArrayList<CloudControlDeploymentReference>())
            .build();
    mockDeployment.addResponse(expectedResponse);

    String name = "name3373707";

    FrameworkDeployment actualResponse = client.getFrameworkDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeployment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFrameworkDeploymentRequest actualRequest =
        ((GetFrameworkDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFrameworkDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeployment.addException(exception);

    try {
      String name = "name3373707";
      client.getFrameworkDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFrameworkDeploymentsTest() throws Exception {
    FrameworkDeployment responsesElement = FrameworkDeployment.newBuilder().build();
    ListFrameworkDeploymentsResponse expectedResponse =
        ListFrameworkDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworkDeployments(Arrays.asList(responsesElement))
            .build();
    mockDeployment.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListFrameworkDeploymentsPagedResponse pagedListResponse =
        client.listFrameworkDeployments(parent);

    List<FrameworkDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFrameworkDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeployment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFrameworkDeploymentsRequest actualRequest =
        ((ListFrameworkDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFrameworkDeploymentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeployment.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listFrameworkDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFrameworkDeploymentsTest2() throws Exception {
    FrameworkDeployment responsesElement = FrameworkDeployment.newBuilder().build();
    ListFrameworkDeploymentsResponse expectedResponse =
        ListFrameworkDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworkDeployments(Arrays.asList(responsesElement))
            .build();
    mockDeployment.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFrameworkDeploymentsPagedResponse pagedListResponse =
        client.listFrameworkDeployments(parent);

    List<FrameworkDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFrameworkDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeployment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFrameworkDeploymentsRequest actualRequest =
        ((ListFrameworkDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFrameworkDeploymentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeployment.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFrameworkDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudControlDeploymentTest() throws Exception {
    CloudControlDeployment expectedResponse =
        CloudControlDeployment.newBuilder()
            .setName(
                CloudControlDeploymentName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL_DEPLOYMENT]")
                    .toString())
            .setTargetResourceConfig(TargetResourceConfig.newBuilder().build())
            .setTargetResource("targetResource-1933150017")
            .setCloudControlMetadata(CloudControlMetadata.newBuilder().build())
            .setDescription("description-1724546052")
            .setDeploymentState(DeploymentState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setParameterSubstitutedCloudControl(CloudControl.newBuilder().build())
            .addAllFrameworkDeploymentReferences(new ArrayList<FrameworkDeploymentReference>())
            .setTargetResourceDisplayName("targetResourceDisplayName-1474402258")
            .build();
    mockDeployment.addResponse(expectedResponse);

    CloudControlDeploymentName name =
        CloudControlDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL_DEPLOYMENT]");

    CloudControlDeployment actualResponse = client.getCloudControlDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeployment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCloudControlDeploymentRequest actualRequest =
        ((GetCloudControlDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCloudControlDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeployment.addException(exception);

    try {
      CloudControlDeploymentName name =
          CloudControlDeploymentName.of(
              "[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL_DEPLOYMENT]");
      client.getCloudControlDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudControlDeploymentTest2() throws Exception {
    CloudControlDeployment expectedResponse =
        CloudControlDeployment.newBuilder()
            .setName(
                CloudControlDeploymentName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL_DEPLOYMENT]")
                    .toString())
            .setTargetResourceConfig(TargetResourceConfig.newBuilder().build())
            .setTargetResource("targetResource-1933150017")
            .setCloudControlMetadata(CloudControlMetadata.newBuilder().build())
            .setDescription("description-1724546052")
            .setDeploymentState(DeploymentState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setParameterSubstitutedCloudControl(CloudControl.newBuilder().build())
            .addAllFrameworkDeploymentReferences(new ArrayList<FrameworkDeploymentReference>())
            .setTargetResourceDisplayName("targetResourceDisplayName-1474402258")
            .build();
    mockDeployment.addResponse(expectedResponse);

    String name = "name3373707";

    CloudControlDeployment actualResponse = client.getCloudControlDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeployment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCloudControlDeploymentRequest actualRequest =
        ((GetCloudControlDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCloudControlDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeployment.addException(exception);

    try {
      String name = "name3373707";
      client.getCloudControlDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCloudControlDeploymentsTest() throws Exception {
    CloudControlDeployment responsesElement = CloudControlDeployment.newBuilder().build();
    ListCloudControlDeploymentsResponse expectedResponse =
        ListCloudControlDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudControlDeployments(Arrays.asList(responsesElement))
            .build();
    mockDeployment.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListCloudControlDeploymentsPagedResponse pagedListResponse =
        client.listCloudControlDeployments(parent);

    List<CloudControlDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudControlDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeployment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCloudControlDeploymentsRequest actualRequest =
        ((ListCloudControlDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCloudControlDeploymentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeployment.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listCloudControlDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCloudControlDeploymentsTest2() throws Exception {
    CloudControlDeployment responsesElement = CloudControlDeployment.newBuilder().build();
    ListCloudControlDeploymentsResponse expectedResponse =
        ListCloudControlDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudControlDeployments(Arrays.asList(responsesElement))
            .build();
    mockDeployment.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCloudControlDeploymentsPagedResponse pagedListResponse =
        client.listCloudControlDeployments(parent);

    List<CloudControlDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudControlDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeployment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCloudControlDeploymentsRequest actualRequest =
        ((ListCloudControlDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCloudControlDeploymentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeployment.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCloudControlDeployments(parent);
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
}
