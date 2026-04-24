/*
 * Copyright 2026 Google LLC
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

package com.google.iam.v3beta;

import static com.google.iam.v3beta.AccessPoliciesClient.ListAccessPoliciesPagedResponse;
import static com.google.iam.v3beta.AccessPoliciesClient.SearchAccessPolicyBindingsPagedResponse;

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
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class AccessPoliciesClientTest {
  private static MockAccessPolicies mockAccessPolicies;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AccessPoliciesClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAccessPolicies = new MockAccessPolicies();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAccessPolicies, mockLocations));
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
    AccessPoliciesSettings settings =
        AccessPoliciesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccessPoliciesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createAccessPolicyTest() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(
                AccessPolicyName.ofOrganizationLocationAccessPolicyName(
                        "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(AccessPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessPolicies.addResponse(resultOperation);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
    AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
    String accessPolicyId = "accessPolicyId97623921";

    AccessPolicy actualResponse =
        client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAccessPolicyRequest actualRequest = ((CreateAccessPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(accessPolicy, actualRequest.getAccessPolicy());
    Assert.assertEquals(accessPolicyId, actualRequest.getAccessPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAccessPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessPolicies.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
      String accessPolicyId = "accessPolicyId97623921";
      client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAccessPolicyTest2() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(
                AccessPolicyName.ofOrganizationLocationAccessPolicyName(
                        "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(AccessPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessPolicies.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
    String accessPolicyId = "accessPolicyId97623921";

    AccessPolicy actualResponse =
        client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAccessPolicyRequest actualRequest = ((CreateAccessPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(accessPolicy, actualRequest.getAccessPolicy());
    Assert.assertEquals(accessPolicyId, actualRequest.getAccessPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAccessPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessPolicies.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
      String accessPolicyId = "accessPolicyId97623921";
      client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAccessPolicyTest3() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(
                AccessPolicyName.ofOrganizationLocationAccessPolicyName(
                        "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(AccessPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessPolicies.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
    String accessPolicyId = "accessPolicyId97623921";

    AccessPolicy actualResponse =
        client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAccessPolicyRequest actualRequest = ((CreateAccessPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(accessPolicy, actualRequest.getAccessPolicy());
    Assert.assertEquals(accessPolicyId, actualRequest.getAccessPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAccessPolicyExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessPolicies.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
      String accessPolicyId = "accessPolicyId97623921";
      client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAccessPolicyTest4() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(
                AccessPolicyName.ofOrganizationLocationAccessPolicyName(
                        "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(AccessPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessPolicies.addResponse(resultOperation);

    String parent = "parent-995424086";
    AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
    String accessPolicyId = "accessPolicyId97623921";

    AccessPolicy actualResponse =
        client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAccessPolicyRequest actualRequest = ((CreateAccessPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(accessPolicy, actualRequest.getAccessPolicy());
    Assert.assertEquals(accessPolicyId, actualRequest.getAccessPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAccessPolicyExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessPolicies.addException(exception);

    try {
      String parent = "parent-995424086";
      AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
      String accessPolicyId = "accessPolicyId97623921";
      client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getAccessPolicyTest() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(
                AccessPolicyName.ofProjectLocationAccessPolicyName(
                        "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(AccessPolicyDetails.newBuilder().build())
            .build();
    mockAccessPolicies.addResponse(expectedResponse);

    AccessPolicyName name =
        AccessPolicyName.ofProjectLocationAccessPolicyName(
            "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]");

    AccessPolicy actualResponse = client.getAccessPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessPolicies.getRequests();
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
    mockAccessPolicies.addException(exception);

    try {
      AccessPolicyName name =
          AccessPolicyName.ofProjectLocationAccessPolicyName(
              "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]");
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
            .setName(
                AccessPolicyName.ofProjectLocationAccessPolicyName(
                        "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(AccessPolicyDetails.newBuilder().build())
            .build();
    mockAccessPolicies.addResponse(expectedResponse);

    String name = "name3373707";

    AccessPolicy actualResponse = client.getAccessPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessPolicies.getRequests();
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
    mockAccessPolicies.addException(exception);

    try {
      String name = "name3373707";
      client.getAccessPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAccessPolicyTest() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(
                AccessPolicyName.ofProjectLocationAccessPolicyName(
                        "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(AccessPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAccessPolicies.addResponse(resultOperation);

    UpdateAccessPolicyRequest request =
        UpdateAccessPolicyRequest.newBuilder()
            .setAccessPolicy(AccessPolicy.newBuilder().build())
            .setValidateOnly(true)
            .build();

    AccessPolicy actualResponse = client.updateAccessPolicyAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAccessPolicyRequest actualRequest = ((UpdateAccessPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAccessPolicy(), actualRequest.getAccessPolicy());
    Assert.assertEquals(request.getValidateOnly(), actualRequest.getValidateOnly());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAccessPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessPolicies.addException(exception);

    try {
      UpdateAccessPolicyRequest request =
          UpdateAccessPolicyRequest.newBuilder()
              .setAccessPolicy(AccessPolicy.newBuilder().build())
              .setValidateOnly(true)
              .build();
      client.updateAccessPolicyAsync(request).get();
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
    mockAccessPolicies.addResponse(resultOperation);

    AccessPolicyName name =
        AccessPolicyName.ofProjectLocationAccessPolicyName(
            "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]");

    client.deleteAccessPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockAccessPolicies.getRequests();
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
    mockAccessPolicies.addException(exception);

    try {
      AccessPolicyName name =
          AccessPolicyName.ofProjectLocationAccessPolicyName(
              "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]");
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
    mockAccessPolicies.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAccessPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockAccessPolicies.getRequests();
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
    mockAccessPolicies.addException(exception);

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
  public void listAccessPoliciesTest() throws Exception {
    AccessPolicy responsesElement = AccessPolicy.newBuilder().build();
    ListAccessPoliciesResponse expectedResponse =
        ListAccessPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessPolicies(Arrays.asList(responsesElement))
            .build();
    mockAccessPolicies.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListAccessPoliciesPagedResponse pagedListResponse = client.listAccessPolicies(parent);

    List<AccessPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccessPoliciesRequest actualRequest = ((ListAccessPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccessPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessPolicies.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listAccessPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessPoliciesTest2() throws Exception {
    AccessPolicy responsesElement = AccessPolicy.newBuilder().build();
    ListAccessPoliciesResponse expectedResponse =
        ListAccessPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessPolicies(Arrays.asList(responsesElement))
            .build();
    mockAccessPolicies.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAccessPoliciesPagedResponse pagedListResponse = client.listAccessPolicies(parent);

    List<AccessPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccessPoliciesRequest actualRequest = ((ListAccessPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccessPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessPolicies.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAccessPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessPoliciesTest3() throws Exception {
    AccessPolicy responsesElement = AccessPolicy.newBuilder().build();
    ListAccessPoliciesResponse expectedResponse =
        ListAccessPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessPolicies(Arrays.asList(responsesElement))
            .build();
    mockAccessPolicies.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListAccessPoliciesPagedResponse pagedListResponse = client.listAccessPolicies(parent);

    List<AccessPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccessPoliciesRequest actualRequest = ((ListAccessPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccessPoliciesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessPolicies.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listAccessPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessPoliciesTest4() throws Exception {
    AccessPolicy responsesElement = AccessPolicy.newBuilder().build();
    ListAccessPoliciesResponse expectedResponse =
        ListAccessPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessPolicies(Arrays.asList(responsesElement))
            .build();
    mockAccessPolicies.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAccessPoliciesPagedResponse pagedListResponse = client.listAccessPolicies(parent);

    List<AccessPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccessPoliciesRequest actualRequest = ((ListAccessPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccessPoliciesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessPolicies.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAccessPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchAccessPolicyBindingsTest() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    SearchAccessPolicyBindingsResponse expectedResponse =
        SearchAccessPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockAccessPolicies.addResponse(expectedResponse);

    AccessPolicyName name =
        AccessPolicyName.ofOrganizationLocationAccessPolicyName(
            "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]");

    SearchAccessPolicyBindingsPagedResponse pagedListResponse =
        client.searchAccessPolicyBindings(name);

    List<PolicyBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchAccessPolicyBindingsRequest actualRequest =
        ((SearchAccessPolicyBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchAccessPolicyBindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessPolicies.addException(exception);

    try {
      AccessPolicyName name =
          AccessPolicyName.ofOrganizationLocationAccessPolicyName(
              "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]");
      client.searchAccessPolicyBindings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchAccessPolicyBindingsTest2() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    SearchAccessPolicyBindingsResponse expectedResponse =
        SearchAccessPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockAccessPolicies.addResponse(expectedResponse);

    String name = "name3373707";

    SearchAccessPolicyBindingsPagedResponse pagedListResponse =
        client.searchAccessPolicyBindings(name);

    List<PolicyBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchAccessPolicyBindingsRequest actualRequest =
        ((SearchAccessPolicyBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchAccessPolicyBindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessPolicies.addException(exception);

    try {
      String name = "name3373707";
      client.searchAccessPolicyBindings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
