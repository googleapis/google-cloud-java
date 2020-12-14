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
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
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
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SecretManagerServiceClientTest {
  private static MockSecretManagerService mockSecretManagerService;
  private static MockServiceHelper mockServiceHelper;
  private SecretManagerServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockSecretManagerService = new MockSecretManagerService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSecretManagerService));
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
  public void listSecretsTest() throws Exception {
    Secret responsesElement = Secret.newBuilder().build();
    ListSecretsResponse expectedResponse =
        ListSecretsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecrets(Arrays.asList(responsesElement))
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListSecretsPagedResponse pagedListResponse = client.listSecrets(parent);

    List<Secret> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSecretsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecretsRequest actualRequest = ((ListSecretsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecretsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listSecrets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSecretsTest2() throws Exception {
    Secret responsesElement = Secret.newBuilder().build();
    ListSecretsResponse expectedResponse =
        ListSecretsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecrets(Arrays.asList(responsesElement))
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSecretsPagedResponse pagedListResponse = client.listSecrets(parent);

    List<Secret> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSecretsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecretsRequest actualRequest = ((ListSecretsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecretsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSecrets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSecretTest() throws Exception {
    Secret expectedResponse =
        Secret.newBuilder()
            .setName(SecretName.of("[PROJECT]", "[SECRET]").toString())
            .setReplication(Replication.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String secretId = "secretId945974251";
    Secret secret = Secret.newBuilder().build();

    Secret actualResponse = client.createSecret(parent, secretId, secret);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSecretRequest actualRequest = ((CreateSecretRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(secretId, actualRequest.getSecretId());
    Assert.assertEquals(secret, actualRequest.getSecret());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String secretId = "secretId945974251";
      Secret secret = Secret.newBuilder().build();
      client.createSecret(parent, secretId, secret);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSecretTest2() throws Exception {
    Secret expectedResponse =
        Secret.newBuilder()
            .setName(SecretName.of("[PROJECT]", "[SECRET]").toString())
            .setReplication(Replication.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String secretId = "secretId945974251";
    Secret secret = Secret.newBuilder().build();

    Secret actualResponse = client.createSecret(parent, secretId, secret);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSecretRequest actualRequest = ((CreateSecretRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(secretId, actualRequest.getSecretId());
    Assert.assertEquals(secret, actualRequest.getSecret());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSecretExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      String parent = "parent-995424086";
      String secretId = "secretId945974251";
      Secret secret = Secret.newBuilder().build();
      client.createSecret(parent, secretId, secret);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addSecretVersionTest() throws Exception {
    SecretVersion expectedResponse =
        SecretVersion.newBuilder()
            .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretName parent = SecretName.of("[PROJECT]", "[SECRET]");
    SecretPayload payload = SecretPayload.newBuilder().build();

    SecretVersion actualResponse = client.addSecretVersion(parent, payload);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddSecretVersionRequest actualRequest = ((AddSecretVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(payload, actualRequest.getPayload());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addSecretVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretName parent = SecretName.of("[PROJECT]", "[SECRET]");
      SecretPayload payload = SecretPayload.newBuilder().build();
      client.addSecretVersion(parent, payload);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addSecretVersionTest2() throws Exception {
    SecretVersion expectedResponse =
        SecretVersion.newBuilder()
            .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    SecretPayload payload = SecretPayload.newBuilder().build();

    SecretVersion actualResponse = client.addSecretVersion(parent, payload);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddSecretVersionRequest actualRequest = ((AddSecretVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(payload, actualRequest.getPayload());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addSecretVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      String parent = "parent-995424086";
      SecretPayload payload = SecretPayload.newBuilder().build();
      client.addSecretVersion(parent, payload);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSecretTest() throws Exception {
    Secret expectedResponse =
        Secret.newBuilder()
            .setName(SecretName.of("[PROJECT]", "[SECRET]").toString())
            .setReplication(Replication.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretName name = SecretName.of("[PROJECT]", "[SECRET]");

    Secret actualResponse = client.getSecret(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSecretRequest actualRequest = ((GetSecretRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretName name = SecretName.of("[PROJECT]", "[SECRET]");
      client.getSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSecretTest2() throws Exception {
    Secret expectedResponse =
        Secret.newBuilder()
            .setName(SecretName.of("[PROJECT]", "[SECRET]").toString())
            .setReplication(Replication.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    String name = "name3373707";

    Secret actualResponse = client.getSecret(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSecretRequest actualRequest = ((GetSecretRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSecretExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      String name = "name3373707";
      client.getSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSecretTest() throws Exception {
    Secret expectedResponse =
        Secret.newBuilder()
            .setName(SecretName.of("[PROJECT]", "[SECRET]").toString())
            .setReplication(Replication.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    Secret secret = Secret.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Secret actualResponse = client.updateSecret(secret, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSecretRequest actualRequest = ((UpdateSecretRequest) actualRequests.get(0));

    Assert.assertEquals(secret, actualRequest.getSecret());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      Secret secret = Secret.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSecret(secret, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSecretTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretName name = SecretName.of("[PROJECT]", "[SECRET]");

    client.deleteSecret(name);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSecretRequest actualRequest = ((DeleteSecretRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretName name = SecretName.of("[PROJECT]", "[SECRET]");
      client.deleteSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSecretTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecretManagerService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSecret(name);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSecretRequest actualRequest = ((DeleteSecretRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSecretExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSecretVersionsTest() throws Exception {
    SecretVersion responsesElement = SecretVersion.newBuilder().build();
    ListSecretVersionsResponse expectedResponse =
        ListSecretVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVersions(Arrays.asList(responsesElement))
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretName parent = SecretName.of("[PROJECT]", "[SECRET]");

    ListSecretVersionsPagedResponse pagedListResponse = client.listSecretVersions(parent);

    List<SecretVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecretVersionsRequest actualRequest = ((ListSecretVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecretVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretName parent = SecretName.of("[PROJECT]", "[SECRET]");
      client.listSecretVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSecretVersionsTest2() throws Exception {
    SecretVersion responsesElement = SecretVersion.newBuilder().build();
    ListSecretVersionsResponse expectedResponse =
        ListSecretVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVersions(Arrays.asList(responsesElement))
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSecretVersionsPagedResponse pagedListResponse = client.listSecretVersions(parent);

    List<SecretVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecretVersionsRequest actualRequest = ((ListSecretVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecretVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSecretVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSecretVersionTest() throws Exception {
    SecretVersion expectedResponse =
        SecretVersion.newBuilder()
            .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");

    SecretVersion actualResponse = client.getSecretVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSecretVersionRequest actualRequest = ((GetSecretVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSecretVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
      client.getSecretVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSecretVersionTest2() throws Exception {
    SecretVersion expectedResponse =
        SecretVersion.newBuilder()
            .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    String name = "name3373707";

    SecretVersion actualResponse = client.getSecretVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSecretVersionRequest actualRequest = ((GetSecretVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSecretVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      String name = "name3373707";
      client.getSecretVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void accessSecretVersionTest() throws Exception {
    AccessSecretVersionResponse expectedResponse =
        AccessSecretVersionResponse.newBuilder()
            .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
            .setPayload(SecretPayload.newBuilder().build())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");

    AccessSecretVersionResponse actualResponse = client.accessSecretVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AccessSecretVersionRequest actualRequest = ((AccessSecretVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void accessSecretVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
      client.accessSecretVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void accessSecretVersionTest2() throws Exception {
    AccessSecretVersionResponse expectedResponse =
        AccessSecretVersionResponse.newBuilder()
            .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
            .setPayload(SecretPayload.newBuilder().build())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    String name = "name3373707";

    AccessSecretVersionResponse actualResponse = client.accessSecretVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AccessSecretVersionRequest actualRequest = ((AccessSecretVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void accessSecretVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      String name = "name3373707";
      client.accessSecretVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disableSecretVersionTest() throws Exception {
    SecretVersion expectedResponse =
        SecretVersion.newBuilder()
            .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");

    SecretVersion actualResponse = client.disableSecretVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableSecretVersionRequest actualRequest =
        ((DisableSecretVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableSecretVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
      client.disableSecretVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disableSecretVersionTest2() throws Exception {
    SecretVersion expectedResponse =
        SecretVersion.newBuilder()
            .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    String name = "name3373707";

    SecretVersion actualResponse = client.disableSecretVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableSecretVersionRequest actualRequest =
        ((DisableSecretVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableSecretVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      String name = "name3373707";
      client.disableSecretVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableSecretVersionTest() throws Exception {
    SecretVersion expectedResponse =
        SecretVersion.newBuilder()
            .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");

    SecretVersion actualResponse = client.enableSecretVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableSecretVersionRequest actualRequest = ((EnableSecretVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enableSecretVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
      client.enableSecretVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableSecretVersionTest2() throws Exception {
    SecretVersion expectedResponse =
        SecretVersion.newBuilder()
            .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    String name = "name3373707";

    SecretVersion actualResponse = client.enableSecretVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableSecretVersionRequest actualRequest = ((EnableSecretVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enableSecretVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      String name = "name3373707";
      client.enableSecretVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void destroySecretVersionTest() throws Exception {
    SecretVersion expectedResponse =
        SecretVersion.newBuilder()
            .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");

    SecretVersion actualResponse = client.destroySecretVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DestroySecretVersionRequest actualRequest =
        ((DestroySecretVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void destroySecretVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
      client.destroySecretVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void destroySecretVersionTest2() throws Exception {
    SecretVersion expectedResponse =
        SecretVersion.newBuilder()
            .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    String name = "name3373707";

    SecretVersion actualResponse = client.destroySecretVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DestroySecretVersionRequest actualRequest =
        ((DestroySecretVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void destroySecretVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      String name = "name3373707";
      client.destroySecretVersion(name);
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
            .setEtag(ByteString.EMPTY)
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(SecretName.of("[PROJECT]", "[SECRET]").toString())
            .setPolicy(Policy.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecretManagerService.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(SecretName.of("[PROJECT]", "[SECRET]").toString())
              .setPolicy(Policy.newBuilder().build())
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
            .setEtag(ByteString.EMPTY)
            .build();
    mockSecretManagerService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(SecretName.of("[PROJECT]", "[SECRET]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
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
    mockSecretManagerService.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(SecretName.of("[PROJECT]", "[SECRET]").toString())
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
    mockSecretManagerService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(SecretName.of("[PROJECT]", "[SECRET]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecretManagerService.getRequests();
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
    mockSecretManagerService.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(SecretName.of("[PROJECT]", "[SECRET]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
