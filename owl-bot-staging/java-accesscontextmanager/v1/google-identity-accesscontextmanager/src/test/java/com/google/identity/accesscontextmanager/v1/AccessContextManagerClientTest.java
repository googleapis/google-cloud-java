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

package com.google.identity.accesscontextmanager.v1;

import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListAccessLevelsPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListAccessPoliciesPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListGcpUserAccessBindingsPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListServicePerimetersPagedResponse;

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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class AccessContextManagerClientTest {
  private static MockAccessContextManager mockAccessContextManager;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AccessContextManagerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAccessContextManager = new MockAccessContextManager();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAccessContextManager));
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
    AccessContextManagerSettings settings =
        AccessContextManagerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccessContextManagerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAccessPoliciesTest() throws Exception {
    AccessPolicy responsesElement = AccessPolicy.newBuilder().build();
    ListAccessPoliciesResponse expectedResponse =
        ListAccessPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessPolicies(Arrays.asList(responsesElement))
            .build();
    mockAccessContextManager.addResponse(expectedResponse);

    ListAccessPoliciesRequest request =
        ListAccessPoliciesRequest.newBuilder()
            .setParent(OrganizationName.of("[ORGANIZATION]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListAccessPoliciesPagedResponse pagedListResponse = client.listAccessPolicies(request);

    List<AccessPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccessPoliciesRequest actualRequest = ((ListAccessPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccessPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      ListAccessPoliciesRequest request =
          ListAccessPoliciesRequest.newBuilder()
              .setParent(OrganizationName.of("[ORGANIZATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listAccessPolicies(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccessPolicyTest() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(AccessPolicyName.of("[ACCESS_POLICY]").toString())
            .setParent("parent-995424086")
            .setTitle("title110371416")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAccessContextManager.addResponse(expectedResponse);

    AccessPolicyName name = AccessPolicyName.of("[ACCESS_POLICY]");

    AccessPolicy actualResponse = client.getAccessPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccessPolicyRequest actualRequest = ((GetAccessPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccessPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      AccessPolicyName name = AccessPolicyName.of("[ACCESS_POLICY]");
      client.getAccessPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccessPolicyTest2() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(AccessPolicyName.of("[ACCESS_POLICY]").toString())
            .setParent("parent-995424086")
            .setTitle("title110371416")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAccessContextManager.addResponse(expectedResponse);

    String name = "name3373707";

    AccessPolicy actualResponse = client.getAccessPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccessPolicyRequest actualRequest = ((GetAccessPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccessPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      String name = "name3373707";
      client.getAccessPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAccessPolicyTest() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(AccessPolicyName.of("[ACCESS_POLICY]").toString())
            .setParent("parent-995424086")
            .setTitle("title110371416")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    AccessPolicy request =
        AccessPolicy.newBuilder()
            .setName(AccessPolicyName.of("[ACCESS_POLICY]").toString())
            .setParent("parent-995424086")
            .setTitle("title110371416")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();

    AccessPolicy actualResponse = client.createAccessPolicyAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AccessPolicy actualRequest = ((AccessPolicy) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getTitle(), actualRequest.getTitle());
    Assert.assertEquals(request.getCreateTime(), actualRequest.getCreateTime());
    Assert.assertEquals(request.getUpdateTime(), actualRequest.getUpdateTime());
    Assert.assertEquals(request.getEtag(), actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAccessPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      AccessPolicy request =
          AccessPolicy.newBuilder()
              .setName(AccessPolicyName.of("[ACCESS_POLICY]").toString())
              .setParent("parent-995424086")
              .setTitle("title110371416")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setEtag("etag3123477")
              .build();
      client.createAccessPolicyAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateAccessPolicyTest() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(AccessPolicyName.of("[ACCESS_POLICY]").toString())
            .setParent("parent-995424086")
            .setTitle("title110371416")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    AccessPolicy policy = AccessPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AccessPolicy actualResponse = client.updateAccessPolicyAsync(policy, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAccessPolicyRequest actualRequest = ((UpdateAccessPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAccessPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      AccessPolicy policy = AccessPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAccessPolicyAsync(policy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAccessPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    AccessPolicyName name = AccessPolicyName.of("[ACCESS_POLICY]");

    client.deleteAccessPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAccessPolicyRequest actualRequest = ((DeleteAccessPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAccessPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      AccessPolicyName name = AccessPolicyName.of("[ACCESS_POLICY]");
      client.deleteAccessPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAccessPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAccessPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAccessPolicyRequest actualRequest = ((DeleteAccessPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAccessPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAccessPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listAccessLevelsTest() throws Exception {
    AccessLevel responsesElement = AccessLevel.newBuilder().build();
    ListAccessLevelsResponse expectedResponse =
        ListAccessLevelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessLevels(Arrays.asList(responsesElement))
            .build();
    mockAccessContextManager.addResponse(expectedResponse);

    AccessPolicyName parent = AccessPolicyName.of("[ACCESS_POLICY]");

    ListAccessLevelsPagedResponse pagedListResponse = client.listAccessLevels(parent);

    List<AccessLevel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessLevelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccessLevelsRequest actualRequest = ((ListAccessLevelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccessLevelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      AccessPolicyName parent = AccessPolicyName.of("[ACCESS_POLICY]");
      client.listAccessLevels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessLevelsTest2() throws Exception {
    AccessLevel responsesElement = AccessLevel.newBuilder().build();
    ListAccessLevelsResponse expectedResponse =
        ListAccessLevelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessLevels(Arrays.asList(responsesElement))
            .build();
    mockAccessContextManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAccessLevelsPagedResponse pagedListResponse = client.listAccessLevels(parent);

    List<AccessLevel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessLevelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccessLevelsRequest actualRequest = ((ListAccessLevelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccessLevelsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAccessLevels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccessLevelTest() throws Exception {
    AccessLevel expectedResponse =
        AccessLevel.newBuilder()
            .setName(AccessLevelName.of("[ACCESS_POLICY]", "[ACCESS_LEVEL]").toString())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAccessContextManager.addResponse(expectedResponse);

    AccessLevelName name = AccessLevelName.of("[ACCESS_POLICY]", "[ACCESS_LEVEL]");

    AccessLevel actualResponse = client.getAccessLevel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccessLevelRequest actualRequest = ((GetAccessLevelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccessLevelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      AccessLevelName name = AccessLevelName.of("[ACCESS_POLICY]", "[ACCESS_LEVEL]");
      client.getAccessLevel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccessLevelTest2() throws Exception {
    AccessLevel expectedResponse =
        AccessLevel.newBuilder()
            .setName(AccessLevelName.of("[ACCESS_POLICY]", "[ACCESS_LEVEL]").toString())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAccessContextManager.addResponse(expectedResponse);

    String name = "name3373707";

    AccessLevel actualResponse = client.getAccessLevel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccessLevelRequest actualRequest = ((GetAccessLevelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccessLevelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      String name = "name3373707";
      client.getAccessLevel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAccessLevelTest() throws Exception {
    AccessLevel expectedResponse =
        AccessLevel.newBuilder()
            .setName(AccessLevelName.of("[ACCESS_POLICY]", "[ACCESS_LEVEL]").toString())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAccessLevelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    AccessPolicyName parent = AccessPolicyName.of("[ACCESS_POLICY]");
    AccessLevel accessLevel = AccessLevel.newBuilder().build();

    AccessLevel actualResponse = client.createAccessLevelAsync(parent, accessLevel).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAccessLevelRequest actualRequest = ((CreateAccessLevelRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(accessLevel, actualRequest.getAccessLevel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAccessLevelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      AccessPolicyName parent = AccessPolicyName.of("[ACCESS_POLICY]");
      AccessLevel accessLevel = AccessLevel.newBuilder().build();
      client.createAccessLevelAsync(parent, accessLevel).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAccessLevelTest2() throws Exception {
    AccessLevel expectedResponse =
        AccessLevel.newBuilder()
            .setName(AccessLevelName.of("[ACCESS_POLICY]", "[ACCESS_LEVEL]").toString())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAccessLevelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    AccessLevel accessLevel = AccessLevel.newBuilder().build();

    AccessLevel actualResponse = client.createAccessLevelAsync(parent, accessLevel).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAccessLevelRequest actualRequest = ((CreateAccessLevelRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(accessLevel, actualRequest.getAccessLevel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAccessLevelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      String parent = "parent-995424086";
      AccessLevel accessLevel = AccessLevel.newBuilder().build();
      client.createAccessLevelAsync(parent, accessLevel).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateAccessLevelTest() throws Exception {
    AccessLevel expectedResponse =
        AccessLevel.newBuilder()
            .setName(AccessLevelName.of("[ACCESS_POLICY]", "[ACCESS_LEVEL]").toString())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAccessLevelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    AccessLevel accessLevel = AccessLevel.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AccessLevel actualResponse = client.updateAccessLevelAsync(accessLevel, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAccessLevelRequest actualRequest = ((UpdateAccessLevelRequest) actualRequests.get(0));

    Assert.assertEquals(accessLevel, actualRequest.getAccessLevel());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAccessLevelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      AccessLevel accessLevel = AccessLevel.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAccessLevelAsync(accessLevel, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAccessLevelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAccessLevelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    AccessLevelName name = AccessLevelName.of("[ACCESS_POLICY]", "[ACCESS_LEVEL]");

    client.deleteAccessLevelAsync(name).get();

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAccessLevelRequest actualRequest = ((DeleteAccessLevelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAccessLevelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      AccessLevelName name = AccessLevelName.of("[ACCESS_POLICY]", "[ACCESS_LEVEL]");
      client.deleteAccessLevelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAccessLevelTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAccessLevelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAccessLevelAsync(name).get();

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAccessLevelRequest actualRequest = ((DeleteAccessLevelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAccessLevelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAccessLevelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void replaceAccessLevelsTest() throws Exception {
    ReplaceAccessLevelsResponse expectedResponse =
        ReplaceAccessLevelsResponse.newBuilder()
            .addAllAccessLevels(new ArrayList<AccessLevel>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("replaceAccessLevelsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    ReplaceAccessLevelsRequest request =
        ReplaceAccessLevelsRequest.newBuilder()
            .setParent(AccessPolicyName.of("[ACCESS_POLICY]").toString())
            .addAllAccessLevels(new ArrayList<AccessLevel>())
            .setEtag("etag3123477")
            .build();

    ReplaceAccessLevelsResponse actualResponse = client.replaceAccessLevelsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReplaceAccessLevelsRequest actualRequest = ((ReplaceAccessLevelsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getAccessLevelsList(), actualRequest.getAccessLevelsList());
    Assert.assertEquals(request.getEtag(), actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void replaceAccessLevelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      ReplaceAccessLevelsRequest request =
          ReplaceAccessLevelsRequest.newBuilder()
              .setParent(AccessPolicyName.of("[ACCESS_POLICY]").toString())
              .addAllAccessLevels(new ArrayList<AccessLevel>())
              .setEtag("etag3123477")
              .build();
      client.replaceAccessLevelsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listServicePerimetersTest() throws Exception {
    ServicePerimeter responsesElement = ServicePerimeter.newBuilder().build();
    ListServicePerimetersResponse expectedResponse =
        ListServicePerimetersResponse.newBuilder()
            .setNextPageToken("")
            .addAllServicePerimeters(Arrays.asList(responsesElement))
            .build();
    mockAccessContextManager.addResponse(expectedResponse);

    AccessPolicyName parent = AccessPolicyName.of("[ACCESS_POLICY]");

    ListServicePerimetersPagedResponse pagedListResponse = client.listServicePerimeters(parent);

    List<ServicePerimeter> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicePerimetersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicePerimetersRequest actualRequest =
        ((ListServicePerimetersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServicePerimetersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      AccessPolicyName parent = AccessPolicyName.of("[ACCESS_POLICY]");
      client.listServicePerimeters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServicePerimetersTest2() throws Exception {
    ServicePerimeter responsesElement = ServicePerimeter.newBuilder().build();
    ListServicePerimetersResponse expectedResponse =
        ListServicePerimetersResponse.newBuilder()
            .setNextPageToken("")
            .addAllServicePerimeters(Arrays.asList(responsesElement))
            .build();
    mockAccessContextManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListServicePerimetersPagedResponse pagedListResponse = client.listServicePerimeters(parent);

    List<ServicePerimeter> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicePerimetersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicePerimetersRequest actualRequest =
        ((ListServicePerimetersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServicePerimetersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listServicePerimeters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServicePerimeterTest() throws Exception {
    ServicePerimeter expectedResponse =
        ServicePerimeter.newBuilder()
            .setName(ServicePerimeterName.of("[ACCESS_POLICY]", "[SERVICE_PERIMETER]").toString())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatus(ServicePerimeterConfig.newBuilder().build())
            .setSpec(ServicePerimeterConfig.newBuilder().build())
            .setUseExplicitDryRunSpec(true)
            .build();
    mockAccessContextManager.addResponse(expectedResponse);

    ServicePerimeterName name = ServicePerimeterName.of("[ACCESS_POLICY]", "[SERVICE_PERIMETER]");

    ServicePerimeter actualResponse = client.getServicePerimeter(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServicePerimeterRequest actualRequest = ((GetServicePerimeterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServicePerimeterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      ServicePerimeterName name = ServicePerimeterName.of("[ACCESS_POLICY]", "[SERVICE_PERIMETER]");
      client.getServicePerimeter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServicePerimeterTest2() throws Exception {
    ServicePerimeter expectedResponse =
        ServicePerimeter.newBuilder()
            .setName(ServicePerimeterName.of("[ACCESS_POLICY]", "[SERVICE_PERIMETER]").toString())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatus(ServicePerimeterConfig.newBuilder().build())
            .setSpec(ServicePerimeterConfig.newBuilder().build())
            .setUseExplicitDryRunSpec(true)
            .build();
    mockAccessContextManager.addResponse(expectedResponse);

    String name = "name3373707";

    ServicePerimeter actualResponse = client.getServicePerimeter(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServicePerimeterRequest actualRequest = ((GetServicePerimeterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServicePerimeterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      String name = "name3373707";
      client.getServicePerimeter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServicePerimeterTest() throws Exception {
    ServicePerimeter expectedResponse =
        ServicePerimeter.newBuilder()
            .setName(ServicePerimeterName.of("[ACCESS_POLICY]", "[SERVICE_PERIMETER]").toString())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatus(ServicePerimeterConfig.newBuilder().build())
            .setSpec(ServicePerimeterConfig.newBuilder().build())
            .setUseExplicitDryRunSpec(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServicePerimeterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    AccessPolicyName parent = AccessPolicyName.of("[ACCESS_POLICY]");
    ServicePerimeter servicePerimeter = ServicePerimeter.newBuilder().build();

    ServicePerimeter actualResponse =
        client.createServicePerimeterAsync(parent, servicePerimeter).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServicePerimeterRequest actualRequest =
        ((CreateServicePerimeterRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(servicePerimeter, actualRequest.getServicePerimeter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServicePerimeterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      AccessPolicyName parent = AccessPolicyName.of("[ACCESS_POLICY]");
      ServicePerimeter servicePerimeter = ServicePerimeter.newBuilder().build();
      client.createServicePerimeterAsync(parent, servicePerimeter).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createServicePerimeterTest2() throws Exception {
    ServicePerimeter expectedResponse =
        ServicePerimeter.newBuilder()
            .setName(ServicePerimeterName.of("[ACCESS_POLICY]", "[SERVICE_PERIMETER]").toString())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatus(ServicePerimeterConfig.newBuilder().build())
            .setSpec(ServicePerimeterConfig.newBuilder().build())
            .setUseExplicitDryRunSpec(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServicePerimeterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    ServicePerimeter servicePerimeter = ServicePerimeter.newBuilder().build();

    ServicePerimeter actualResponse =
        client.createServicePerimeterAsync(parent, servicePerimeter).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServicePerimeterRequest actualRequest =
        ((CreateServicePerimeterRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(servicePerimeter, actualRequest.getServicePerimeter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServicePerimeterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      String parent = "parent-995424086";
      ServicePerimeter servicePerimeter = ServicePerimeter.newBuilder().build();
      client.createServicePerimeterAsync(parent, servicePerimeter).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateServicePerimeterTest() throws Exception {
    ServicePerimeter expectedResponse =
        ServicePerimeter.newBuilder()
            .setName(ServicePerimeterName.of("[ACCESS_POLICY]", "[SERVICE_PERIMETER]").toString())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStatus(ServicePerimeterConfig.newBuilder().build())
            .setSpec(ServicePerimeterConfig.newBuilder().build())
            .setUseExplicitDryRunSpec(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateServicePerimeterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    ServicePerimeter servicePerimeter = ServicePerimeter.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ServicePerimeter actualResponse =
        client.updateServicePerimeterAsync(servicePerimeter, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateServicePerimeterRequest actualRequest =
        ((UpdateServicePerimeterRequest) actualRequests.get(0));

    Assert.assertEquals(servicePerimeter, actualRequest.getServicePerimeter());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateServicePerimeterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      ServicePerimeter servicePerimeter = ServicePerimeter.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateServicePerimeterAsync(servicePerimeter, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServicePerimeterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServicePerimeterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    ServicePerimeterName name = ServicePerimeterName.of("[ACCESS_POLICY]", "[SERVICE_PERIMETER]");

    client.deleteServicePerimeterAsync(name).get();

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServicePerimeterRequest actualRequest =
        ((DeleteServicePerimeterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServicePerimeterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      ServicePerimeterName name = ServicePerimeterName.of("[ACCESS_POLICY]", "[SERVICE_PERIMETER]");
      client.deleteServicePerimeterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServicePerimeterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServicePerimeterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteServicePerimeterAsync(name).get();

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServicePerimeterRequest actualRequest =
        ((DeleteServicePerimeterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServicePerimeterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteServicePerimeterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void replaceServicePerimetersTest() throws Exception {
    ReplaceServicePerimetersResponse expectedResponse =
        ReplaceServicePerimetersResponse.newBuilder()
            .addAllServicePerimeters(new ArrayList<ServicePerimeter>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("replaceServicePerimetersTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    ReplaceServicePerimetersRequest request =
        ReplaceServicePerimetersRequest.newBuilder()
            .setParent(AccessPolicyName.of("[ACCESS_POLICY]").toString())
            .addAllServicePerimeters(new ArrayList<ServicePerimeter>())
            .setEtag("etag3123477")
            .build();

    ReplaceServicePerimetersResponse actualResponse =
        client.replaceServicePerimetersAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReplaceServicePerimetersRequest actualRequest =
        ((ReplaceServicePerimetersRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(
        request.getServicePerimetersList(), actualRequest.getServicePerimetersList());
    Assert.assertEquals(request.getEtag(), actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void replaceServicePerimetersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      ReplaceServicePerimetersRequest request =
          ReplaceServicePerimetersRequest.newBuilder()
              .setParent(AccessPolicyName.of("[ACCESS_POLICY]").toString())
              .addAllServicePerimeters(new ArrayList<ServicePerimeter>())
              .setEtag("etag3123477")
              .build();
      client.replaceServicePerimetersAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void commitServicePerimetersTest() throws Exception {
    CommitServicePerimetersResponse expectedResponse =
        CommitServicePerimetersResponse.newBuilder()
            .addAllServicePerimeters(new ArrayList<ServicePerimeter>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("commitServicePerimetersTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    CommitServicePerimetersRequest request =
        CommitServicePerimetersRequest.newBuilder()
            .setParent(AccessPolicyName.of("[ACCESS_POLICY]").toString())
            .setEtag("etag3123477")
            .build();

    CommitServicePerimetersResponse actualResponse =
        client.commitServicePerimetersAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CommitServicePerimetersRequest actualRequest =
        ((CommitServicePerimetersRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getEtag(), actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void commitServicePerimetersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      CommitServicePerimetersRequest request =
          CommitServicePerimetersRequest.newBuilder()
              .setParent(AccessPolicyName.of("[ACCESS_POLICY]").toString())
              .setEtag("etag3123477")
              .build();
      client.commitServicePerimetersAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listGcpUserAccessBindingsTest() throws Exception {
    GcpUserAccessBinding responsesElement = GcpUserAccessBinding.newBuilder().build();
    ListGcpUserAccessBindingsResponse expectedResponse =
        ListGcpUserAccessBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGcpUserAccessBindings(Arrays.asList(responsesElement))
            .build();
    mockAccessContextManager.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListGcpUserAccessBindingsPagedResponse pagedListResponse =
        client.listGcpUserAccessBindings(parent);

    List<GcpUserAccessBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGcpUserAccessBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGcpUserAccessBindingsRequest actualRequest =
        ((ListGcpUserAccessBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGcpUserAccessBindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listGcpUserAccessBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGcpUserAccessBindingsTest2() throws Exception {
    GcpUserAccessBinding responsesElement = GcpUserAccessBinding.newBuilder().build();
    ListGcpUserAccessBindingsResponse expectedResponse =
        ListGcpUserAccessBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGcpUserAccessBindings(Arrays.asList(responsesElement))
            .build();
    mockAccessContextManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGcpUserAccessBindingsPagedResponse pagedListResponse =
        client.listGcpUserAccessBindings(parent);

    List<GcpUserAccessBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGcpUserAccessBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGcpUserAccessBindingsRequest actualRequest =
        ((ListGcpUserAccessBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGcpUserAccessBindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGcpUserAccessBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGcpUserAccessBindingTest() throws Exception {
    GcpUserAccessBinding expectedResponse =
        GcpUserAccessBinding.newBuilder()
            .setName(
                GcpUserAccessBindingName.of("[ORGANIZATION]", "[GCP_USER_ACCESS_BINDING]")
                    .toString())
            .setGroupKey("groupKey506342240")
            .addAllAccessLevels(new ArrayList<String>())
            .build();
    mockAccessContextManager.addResponse(expectedResponse);

    GcpUserAccessBindingName name =
        GcpUserAccessBindingName.of("[ORGANIZATION]", "[GCP_USER_ACCESS_BINDING]");

    GcpUserAccessBinding actualResponse = client.getGcpUserAccessBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGcpUserAccessBindingRequest actualRequest =
        ((GetGcpUserAccessBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGcpUserAccessBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      GcpUserAccessBindingName name =
          GcpUserAccessBindingName.of("[ORGANIZATION]", "[GCP_USER_ACCESS_BINDING]");
      client.getGcpUserAccessBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGcpUserAccessBindingTest2() throws Exception {
    GcpUserAccessBinding expectedResponse =
        GcpUserAccessBinding.newBuilder()
            .setName(
                GcpUserAccessBindingName.of("[ORGANIZATION]", "[GCP_USER_ACCESS_BINDING]")
                    .toString())
            .setGroupKey("groupKey506342240")
            .addAllAccessLevels(new ArrayList<String>())
            .build();
    mockAccessContextManager.addResponse(expectedResponse);

    String name = "name3373707";

    GcpUserAccessBinding actualResponse = client.getGcpUserAccessBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGcpUserAccessBindingRequest actualRequest =
        ((GetGcpUserAccessBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGcpUserAccessBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      String name = "name3373707";
      client.getGcpUserAccessBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGcpUserAccessBindingTest() throws Exception {
    GcpUserAccessBinding expectedResponse =
        GcpUserAccessBinding.newBuilder()
            .setName(
                GcpUserAccessBindingName.of("[ORGANIZATION]", "[GCP_USER_ACCESS_BINDING]")
                    .toString())
            .setGroupKey("groupKey506342240")
            .addAllAccessLevels(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGcpUserAccessBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    GcpUserAccessBinding gcpUserAccessBinding = GcpUserAccessBinding.newBuilder().build();

    GcpUserAccessBinding actualResponse =
        client.createGcpUserAccessBindingAsync(parent, gcpUserAccessBinding).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGcpUserAccessBindingRequest actualRequest =
        ((CreateGcpUserAccessBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(gcpUserAccessBinding, actualRequest.getGcpUserAccessBinding());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGcpUserAccessBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      GcpUserAccessBinding gcpUserAccessBinding = GcpUserAccessBinding.newBuilder().build();
      client.createGcpUserAccessBindingAsync(parent, gcpUserAccessBinding).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createGcpUserAccessBindingTest2() throws Exception {
    GcpUserAccessBinding expectedResponse =
        GcpUserAccessBinding.newBuilder()
            .setName(
                GcpUserAccessBindingName.of("[ORGANIZATION]", "[GCP_USER_ACCESS_BINDING]")
                    .toString())
            .setGroupKey("groupKey506342240")
            .addAllAccessLevels(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGcpUserAccessBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    GcpUserAccessBinding gcpUserAccessBinding = GcpUserAccessBinding.newBuilder().build();

    GcpUserAccessBinding actualResponse =
        client.createGcpUserAccessBindingAsync(parent, gcpUserAccessBinding).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGcpUserAccessBindingRequest actualRequest =
        ((CreateGcpUserAccessBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(gcpUserAccessBinding, actualRequest.getGcpUserAccessBinding());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGcpUserAccessBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      String parent = "parent-995424086";
      GcpUserAccessBinding gcpUserAccessBinding = GcpUserAccessBinding.newBuilder().build();
      client.createGcpUserAccessBindingAsync(parent, gcpUserAccessBinding).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateGcpUserAccessBindingTest() throws Exception {
    GcpUserAccessBinding expectedResponse =
        GcpUserAccessBinding.newBuilder()
            .setName(
                GcpUserAccessBindingName.of("[ORGANIZATION]", "[GCP_USER_ACCESS_BINDING]")
                    .toString())
            .setGroupKey("groupKey506342240")
            .addAllAccessLevels(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGcpUserAccessBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    GcpUserAccessBinding gcpUserAccessBinding = GcpUserAccessBinding.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GcpUserAccessBinding actualResponse =
        client.updateGcpUserAccessBindingAsync(gcpUserAccessBinding, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGcpUserAccessBindingRequest actualRequest =
        ((UpdateGcpUserAccessBindingRequest) actualRequests.get(0));

    Assert.assertEquals(gcpUserAccessBinding, actualRequest.getGcpUserAccessBinding());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGcpUserAccessBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      GcpUserAccessBinding gcpUserAccessBinding = GcpUserAccessBinding.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGcpUserAccessBindingAsync(gcpUserAccessBinding, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGcpUserAccessBindingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGcpUserAccessBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    GcpUserAccessBindingName name =
        GcpUserAccessBindingName.of("[ORGANIZATION]", "[GCP_USER_ACCESS_BINDING]");

    client.deleteGcpUserAccessBindingAsync(name).get();

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGcpUserAccessBindingRequest actualRequest =
        ((DeleteGcpUserAccessBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGcpUserAccessBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      GcpUserAccessBindingName name =
          GcpUserAccessBindingName.of("[ORGANIZATION]", "[GCP_USER_ACCESS_BINDING]");
      client.deleteGcpUserAccessBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGcpUserAccessBindingTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGcpUserAccessBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessContextManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteGcpUserAccessBindingAsync(name).get();

    List<AbstractMessage> actualRequests = mockAccessContextManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGcpUserAccessBindingRequest actualRequest =
        ((DeleteGcpUserAccessBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGcpUserAccessBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessContextManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGcpUserAccessBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
