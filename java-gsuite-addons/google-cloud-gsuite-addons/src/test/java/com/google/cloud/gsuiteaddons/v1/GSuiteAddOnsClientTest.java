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

package com.google.cloud.gsuiteaddons.v1;

import static com.google.cloud.gsuiteaddons.v1.GSuiteAddOnsClient.ListDeploymentsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
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
public class GSuiteAddOnsClientTest {
  private static MockGSuiteAddOns mockGSuiteAddOns;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GSuiteAddOnsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGSuiteAddOns = new MockGSuiteAddOns();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockGSuiteAddOns));
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
    GSuiteAddOnsSettings settings =
        GSuiteAddOnsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GSuiteAddOnsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getAuthorizationTest() throws Exception {
    Authorization expectedResponse =
        Authorization.newBuilder()
            .setName(AuthorizationName.of("[PROJECT]").toString())
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setOauthClientId("oauthClientId-2001133059")
            .build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    AuthorizationName name = AuthorizationName.of("[PROJECT]");

    Authorization actualResponse = client.getAuthorization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuthorizationRequest actualRequest = ((GetAuthorizationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAuthorizationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      AuthorizationName name = AuthorizationName.of("[PROJECT]");
      client.getAuthorization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAuthorizationTest2() throws Exception {
    Authorization expectedResponse =
        Authorization.newBuilder()
            .setName(AuthorizationName.of("[PROJECT]").toString())
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .setOauthClientId("oauthClientId-2001133059")
            .build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    String name = "name3373707";

    Authorization actualResponse = client.getAuthorization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuthorizationRequest actualRequest = ((GetAuthorizationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAuthorizationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      String name = "name3373707";
      client.getAuthorization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString())
            .addAllOauthScopes(new ArrayList<String>())
            .setAddOns(AddOns.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Deployment deployment = Deployment.newBuilder().build();
    String deploymentId = "deploymentId-136894784";

    Deployment actualResponse = client.createDeployment(parent, deployment, deploymentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeploymentRequest actualRequest = ((CreateDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(deployment, actualRequest.getDeployment());
    Assert.assertEquals(deploymentId, actualRequest.getDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Deployment deployment = Deployment.newBuilder().build();
      String deploymentId = "deploymentId-136894784";
      client.createDeployment(parent, deployment, deploymentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeploymentTest2() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString())
            .addAllOauthScopes(new ArrayList<String>())
            .setAddOns(AddOns.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Deployment deployment = Deployment.newBuilder().build();
    String deploymentId = "deploymentId-136894784";

    Deployment actualResponse = client.createDeployment(parent, deployment, deploymentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeploymentRequest actualRequest = ((CreateDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(deployment, actualRequest.getDeployment());
    Assert.assertEquals(deploymentId, actualRequest.getDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      String parent = "parent-995424086";
      Deployment deployment = Deployment.newBuilder().build();
      String deploymentId = "deploymentId-136894784";
      client.createDeployment(parent, deployment, deploymentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void replaceDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString())
            .addAllOauthScopes(new ArrayList<String>())
            .setAddOns(AddOns.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    Deployment deployment = Deployment.newBuilder().build();

    Deployment actualResponse = client.replaceDeployment(deployment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReplaceDeploymentRequest actualRequest = ((ReplaceDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(deployment, actualRequest.getDeployment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void replaceDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      Deployment deployment = Deployment.newBuilder().build();
      client.replaceDeployment(deployment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString())
            .addAllOauthScopes(new ArrayList<String>())
            .setAddOns(AddOns.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]");

    Deployment actualResponse = client.getDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeploymentRequest actualRequest = ((GetDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]");
      client.getDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeploymentTest2() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[DEPLOYMENT]").toString())
            .addAllOauthScopes(new ArrayList<String>())
            .setAddOns(AddOns.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    String name = "name3373707";

    Deployment actualResponse = client.getDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeploymentRequest actualRequest = ((GetDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      String name = "name3373707";
      client.getDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeploymentsTest() throws Exception {
    Deployment responsesElement = Deployment.newBuilder().build();
    ListDeploymentsResponse expectedResponse =
        ListDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeployments(Arrays.asList(responsesElement))
            .build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListDeploymentsPagedResponse pagedListResponse = client.listDeployments(parent);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeploymentsRequest actualRequest = ((ListDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeploymentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeploymentsTest2() throws Exception {
    Deployment responsesElement = Deployment.newBuilder().build();
    ListDeploymentsResponse expectedResponse =
        ListDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeployments(Arrays.asList(responsesElement))
            .build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDeploymentsPagedResponse pagedListResponse = client.listDeployments(parent);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeploymentsRequest actualRequest = ((ListDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeploymentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDeploymentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]");

    client.deleteDeployment(name);

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeploymentRequest actualRequest = ((DeleteDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]");
      client.deleteDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDeploymentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDeployment(name);

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeploymentRequest actualRequest = ((DeleteDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void installDeploymentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]");

    client.installDeployment(name);

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InstallDeploymentRequest actualRequest = ((InstallDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void installDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]");
      client.installDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void installDeploymentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    String name = "name3373707";

    client.installDeployment(name);

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InstallDeploymentRequest actualRequest = ((InstallDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void installDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      String name = "name3373707";
      client.installDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void uninstallDeploymentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]");

    client.uninstallDeployment(name);

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UninstallDeploymentRequest actualRequest = ((UninstallDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void uninstallDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[DEPLOYMENT]");
      client.uninstallDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void uninstallDeploymentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    String name = "name3373707";

    client.uninstallDeployment(name);

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UninstallDeploymentRequest actualRequest = ((UninstallDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void uninstallDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      String name = "name3373707";
      client.uninstallDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstallStatusTest() throws Exception {
    InstallStatus expectedResponse =
        InstallStatus.newBuilder()
            .setName(InstallStatusName.of("[PROJECT]", "[DEPLOYMENT]").toString())
            .setInstalled(BoolValue.newBuilder().build())
            .build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    InstallStatusName name = InstallStatusName.of("[PROJECT]", "[DEPLOYMENT]");

    InstallStatus actualResponse = client.getInstallStatus(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstallStatusRequest actualRequest = ((GetInstallStatusRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstallStatusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      InstallStatusName name = InstallStatusName.of("[PROJECT]", "[DEPLOYMENT]");
      client.getInstallStatus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstallStatusTest2() throws Exception {
    InstallStatus expectedResponse =
        InstallStatus.newBuilder()
            .setName(InstallStatusName.of("[PROJECT]", "[DEPLOYMENT]").toString())
            .setInstalled(BoolValue.newBuilder().build())
            .build();
    mockGSuiteAddOns.addResponse(expectedResponse);

    String name = "name3373707";

    InstallStatus actualResponse = client.getInstallStatus(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGSuiteAddOns.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstallStatusRequest actualRequest = ((GetInstallStatusRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstallStatusExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGSuiteAddOns.addException(exception);

    try {
      String name = "name3373707";
      client.getInstallStatus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
