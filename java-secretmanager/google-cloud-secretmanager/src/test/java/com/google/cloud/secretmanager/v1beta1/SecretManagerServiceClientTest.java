/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.secretmanager.v1beta1;

import static com.google.cloud.secretmanager.v1beta1.SecretManagerServiceClient.ListSecretVersionsPagedResponse;
import static com.google.cloud.secretmanager.v1beta1.SecretManagerServiceClient.ListSecretsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class SecretManagerServiceClientTest {
  private static MockSecretManagerService mockSecretManagerService;
  private static MockServiceHelper serviceHelper;
  private SecretManagerServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockSecretManagerService = new MockSecretManagerService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSecretManagerService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    SecretManagerServiceSettings settings =
        SecretManagerServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SecretManagerServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listSecretsTest() {
    String nextPageToken = "";
    int totalSize = 705419236;
    Secret secretsElement = Secret.newBuilder().build();
    List<Secret> secrets = Arrays.asList(secretsElement);
    ListSecretsResponse expectedResponse =
        ListSecretsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .setTotalSize(totalSize)
            .addAllSecrets(secrets)
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListSecretsPagedResponse pagedListResponse = client.listSecrets(parent);

    List<Secret> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSecretsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecretsRequest actualRequest = (ListSecretsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listSecretsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");

      client.listSecrets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createSecretTest() {
    SecretName name = SecretName.of("[PROJECT]", "[SECRET]");
    Secret expectedResponse = Secret.newBuilder().setName(name.toString()).build();
    mockSecretManagerService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String secretId = "secretId-739547894";
    Secret secret = Secret.newBuilder().build();

    Secret actualResponse = client.createSecret(parent, secretId, secret);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSecretRequest actualRequest = (CreateSecretRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(secretId, actualRequest.getSecretId());
    Assert.assertEquals(secret, actualRequest.getSecret());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String secretId = "secretId-739547894";
      Secret secret = Secret.newBuilder().build();

      client.createSecret(parent, secretId, secret);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void addSecretVersionTest() {
    SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
    SecretVersion expectedResponse = SecretVersion.newBuilder().setName(name.toString()).build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretName parent = SecretName.of("[PROJECT]", "[SECRET]");
    SecretPayload payload = SecretPayload.newBuilder().build();

    SecretVersion actualResponse = client.addSecretVersion(parent, payload);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddSecretVersionRequest actualRequest = (AddSecretVersionRequest) actualRequests.get(0);

    Assert.assertEquals(parent, SecretName.parse(actualRequest.getParent()));
    Assert.assertEquals(payload, actualRequest.getPayload());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void addSecretVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretName parent = SecretName.of("[PROJECT]", "[SECRET]");
      SecretPayload payload = SecretPayload.newBuilder().build();

      client.addSecretVersion(parent, payload);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getSecretTest() {
    SecretName name2 = SecretName.of("[PROJECT]", "[SECRET]");
    Secret expectedResponse = Secret.newBuilder().setName(name2.toString()).build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretName name = SecretName.of("[PROJECT]", "[SECRET]");

    Secret actualResponse = client.getSecret(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSecretRequest actualRequest = (GetSecretRequest) actualRequests.get(0);

    Assert.assertEquals(name, SecretName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretName name = SecretName.of("[PROJECT]", "[SECRET]");

      client.getSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateSecretTest() {
    SecretName name = SecretName.of("[PROJECT]", "[SECRET]");
    Secret expectedResponse = Secret.newBuilder().setName(name.toString()).build();
    mockSecretManagerService.addResponse(expectedResponse);

    Secret secret = Secret.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Secret actualResponse = client.updateSecret(secret, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSecretRequest actualRequest = (UpdateSecretRequest) actualRequests.get(0);

    Assert.assertEquals(secret, actualRequest.getSecret());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      Secret secret = Secret.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateSecret(secret, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteSecretTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretName name = SecretName.of("[PROJECT]", "[SECRET]");

    client.deleteSecret(name);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSecretRequest actualRequest = (DeleteSecretRequest) actualRequests.get(0);

    Assert.assertEquals(name, SecretName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretName name = SecretName.of("[PROJECT]", "[SECRET]");

      client.deleteSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listSecretVersionsTest() {
    String nextPageToken = "";
    int totalSize = 705419236;
    SecretVersion versionsElement = SecretVersion.newBuilder().build();
    List<SecretVersion> versions = Arrays.asList(versionsElement);
    ListSecretVersionsResponse expectedResponse =
        ListSecretVersionsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .setTotalSize(totalSize)
            .addAllVersions(versions)
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretName parent = SecretName.of("[PROJECT]", "[SECRET]");

    ListSecretVersionsPagedResponse pagedListResponse = client.listSecretVersions(parent);

    List<SecretVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecretVersionsRequest actualRequest = (ListSecretVersionsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, SecretName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listSecretVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretName parent = SecretName.of("[PROJECT]", "[SECRET]");

      client.listSecretVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getSecretVersionTest() {
    SecretVersionName name2 = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
    SecretVersion expectedResponse = SecretVersion.newBuilder().setName(name2.toString()).build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");

    SecretVersion actualResponse = client.getSecretVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSecretVersionRequest actualRequest = (GetSecretVersionRequest) actualRequests.get(0);

    Assert.assertEquals(name, SecretVersionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getSecretVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");

      client.getSecretVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void accessSecretVersionTest() {
    SecretVersionName name2 = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
    AccessSecretVersionResponse expectedResponse =
        AccessSecretVersionResponse.newBuilder().setName(name2.toString()).build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");

    AccessSecretVersionResponse actualResponse = client.accessSecretVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AccessSecretVersionRequest actualRequest = (AccessSecretVersionRequest) actualRequests.get(0);

    Assert.assertEquals(name, SecretVersionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void accessSecretVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");

      client.accessSecretVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void disableSecretVersionTest() {
    SecretVersionName name2 = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
    SecretVersion expectedResponse = SecretVersion.newBuilder().setName(name2.toString()).build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");

    SecretVersion actualResponse = client.disableSecretVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableSecretVersionRequest actualRequest = (DisableSecretVersionRequest) actualRequests.get(0);

    Assert.assertEquals(name, SecretVersionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void disableSecretVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");

      client.disableSecretVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void enableSecretVersionTest() {
    SecretVersionName name2 = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
    SecretVersion expectedResponse = SecretVersion.newBuilder().setName(name2.toString()).build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");

    SecretVersion actualResponse = client.enableSecretVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableSecretVersionRequest actualRequest = (EnableSecretVersionRequest) actualRequests.get(0);

    Assert.assertEquals(name, SecretVersionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void enableSecretVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");

      client.enableSecretVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void destroySecretVersionTest() {
    SecretVersionName name2 = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
    SecretVersion expectedResponse = SecretVersion.newBuilder().setName(name2.toString()).build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");

    SecretVersion actualResponse = client.destroySecretVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DestroySecretVersionRequest actualRequest = (DestroySecretVersionRequest) actualRequests.get(0);

    Assert.assertEquals(name, SecretVersionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void destroySecretVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");

      client.destroySecretVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
