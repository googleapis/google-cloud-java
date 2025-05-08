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

package com.google.iam.v3beta;

import static com.google.iam.v3beta.PrincipalAccessBoundaryPoliciesClient.ListPrincipalAccessBoundaryPoliciesPagedResponse;
import static com.google.iam.v3beta.PrincipalAccessBoundaryPoliciesClient.SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse;

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
public class PrincipalAccessBoundaryPoliciesClientTest {
  private static MockLocations mockLocations;
  private static MockPrincipalAccessBoundaryPolicies mockPrincipalAccessBoundaryPolicies;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PrincipalAccessBoundaryPoliciesClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPrincipalAccessBoundaryPolicies = new MockPrincipalAccessBoundaryPolicies();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockPrincipalAccessBoundaryPolicies, mockLocations));
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
    PrincipalAccessBoundaryPoliciesSettings settings =
        PrincipalAccessBoundaryPoliciesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PrincipalAccessBoundaryPoliciesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createPrincipalAccessBoundaryPolicyTest() throws Exception {
    PrincipalAccessBoundaryPolicy expectedResponse =
        PrincipalAccessBoundaryPolicy.newBuilder()
            .setName(
                PrincipalAccessBoundaryPolicyName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(PrincipalAccessBoundaryPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPrincipalAccessBoundaryPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPrincipalAccessBoundaryPolicies.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy =
        PrincipalAccessBoundaryPolicy.newBuilder().build();
    String principalAccessBoundaryPolicyId = "principalAccessBoundaryPolicyId-198573175";

    PrincipalAccessBoundaryPolicy actualResponse =
        client
            .createPrincipalAccessBoundaryPolicyAsync(
                parent, principalAccessBoundaryPolicy, principalAccessBoundaryPolicyId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrincipalAccessBoundaryPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePrincipalAccessBoundaryPolicyRequest actualRequest =
        ((CreatePrincipalAccessBoundaryPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        principalAccessBoundaryPolicy, actualRequest.getPrincipalAccessBoundaryPolicy());
    Assert.assertEquals(
        principalAccessBoundaryPolicyId, actualRequest.getPrincipalAccessBoundaryPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPrincipalAccessBoundaryPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrincipalAccessBoundaryPolicies.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy =
          PrincipalAccessBoundaryPolicy.newBuilder().build();
      String principalAccessBoundaryPolicyId = "principalAccessBoundaryPolicyId-198573175";
      client
          .createPrincipalAccessBoundaryPolicyAsync(
              parent, principalAccessBoundaryPolicy, principalAccessBoundaryPolicyId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createPrincipalAccessBoundaryPolicyTest2() throws Exception {
    PrincipalAccessBoundaryPolicy expectedResponse =
        PrincipalAccessBoundaryPolicy.newBuilder()
            .setName(
                PrincipalAccessBoundaryPolicyName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(PrincipalAccessBoundaryPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPrincipalAccessBoundaryPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPrincipalAccessBoundaryPolicies.addResponse(resultOperation);

    String parent = "parent-995424086";
    PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy =
        PrincipalAccessBoundaryPolicy.newBuilder().build();
    String principalAccessBoundaryPolicyId = "principalAccessBoundaryPolicyId-198573175";

    PrincipalAccessBoundaryPolicy actualResponse =
        client
            .createPrincipalAccessBoundaryPolicyAsync(
                parent, principalAccessBoundaryPolicy, principalAccessBoundaryPolicyId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrincipalAccessBoundaryPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePrincipalAccessBoundaryPolicyRequest actualRequest =
        ((CreatePrincipalAccessBoundaryPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(
        principalAccessBoundaryPolicy, actualRequest.getPrincipalAccessBoundaryPolicy());
    Assert.assertEquals(
        principalAccessBoundaryPolicyId, actualRequest.getPrincipalAccessBoundaryPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPrincipalAccessBoundaryPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrincipalAccessBoundaryPolicies.addException(exception);

    try {
      String parent = "parent-995424086";
      PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy =
          PrincipalAccessBoundaryPolicy.newBuilder().build();
      String principalAccessBoundaryPolicyId = "principalAccessBoundaryPolicyId-198573175";
      client
          .createPrincipalAccessBoundaryPolicyAsync(
              parent, principalAccessBoundaryPolicy, principalAccessBoundaryPolicyId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getPrincipalAccessBoundaryPolicyTest() throws Exception {
    PrincipalAccessBoundaryPolicy expectedResponse =
        PrincipalAccessBoundaryPolicy.newBuilder()
            .setName(
                PrincipalAccessBoundaryPolicyName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(PrincipalAccessBoundaryPolicyDetails.newBuilder().build())
            .build();
    mockPrincipalAccessBoundaryPolicies.addResponse(expectedResponse);

    PrincipalAccessBoundaryPolicyName name =
        PrincipalAccessBoundaryPolicyName.of(
            "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");

    PrincipalAccessBoundaryPolicy actualResponse = client.getPrincipalAccessBoundaryPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrincipalAccessBoundaryPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPrincipalAccessBoundaryPolicyRequest actualRequest =
        ((GetPrincipalAccessBoundaryPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPrincipalAccessBoundaryPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrincipalAccessBoundaryPolicies.addException(exception);

    try {
      PrincipalAccessBoundaryPolicyName name =
          PrincipalAccessBoundaryPolicyName.of(
              "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");
      client.getPrincipalAccessBoundaryPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPrincipalAccessBoundaryPolicyTest2() throws Exception {
    PrincipalAccessBoundaryPolicy expectedResponse =
        PrincipalAccessBoundaryPolicy.newBuilder()
            .setName(
                PrincipalAccessBoundaryPolicyName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(PrincipalAccessBoundaryPolicyDetails.newBuilder().build())
            .build();
    mockPrincipalAccessBoundaryPolicies.addResponse(expectedResponse);

    String name = "name3373707";

    PrincipalAccessBoundaryPolicy actualResponse = client.getPrincipalAccessBoundaryPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrincipalAccessBoundaryPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPrincipalAccessBoundaryPolicyRequest actualRequest =
        ((GetPrincipalAccessBoundaryPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPrincipalAccessBoundaryPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrincipalAccessBoundaryPolicies.addException(exception);

    try {
      String name = "name3373707";
      client.getPrincipalAccessBoundaryPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePrincipalAccessBoundaryPolicyTest() throws Exception {
    PrincipalAccessBoundaryPolicy expectedResponse =
        PrincipalAccessBoundaryPolicy.newBuilder()
            .setName(
                PrincipalAccessBoundaryPolicyName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(PrincipalAccessBoundaryPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePrincipalAccessBoundaryPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPrincipalAccessBoundaryPolicies.addResponse(resultOperation);

    PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy =
        PrincipalAccessBoundaryPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PrincipalAccessBoundaryPolicy actualResponse =
        client
            .updatePrincipalAccessBoundaryPolicyAsync(principalAccessBoundaryPolicy, updateMask)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrincipalAccessBoundaryPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePrincipalAccessBoundaryPolicyRequest actualRequest =
        ((UpdatePrincipalAccessBoundaryPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(
        principalAccessBoundaryPolicy, actualRequest.getPrincipalAccessBoundaryPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePrincipalAccessBoundaryPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrincipalAccessBoundaryPolicies.addException(exception);

    try {
      PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy =
          PrincipalAccessBoundaryPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client
          .updatePrincipalAccessBoundaryPolicyAsync(principalAccessBoundaryPolicy, updateMask)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePrincipalAccessBoundaryPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePrincipalAccessBoundaryPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPrincipalAccessBoundaryPolicies.addResponse(resultOperation);

    PrincipalAccessBoundaryPolicyName name =
        PrincipalAccessBoundaryPolicyName.of(
            "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");

    client.deletePrincipalAccessBoundaryPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockPrincipalAccessBoundaryPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePrincipalAccessBoundaryPolicyRequest actualRequest =
        ((DeletePrincipalAccessBoundaryPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePrincipalAccessBoundaryPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrincipalAccessBoundaryPolicies.addException(exception);

    try {
      PrincipalAccessBoundaryPolicyName name =
          PrincipalAccessBoundaryPolicyName.of(
              "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");
      client.deletePrincipalAccessBoundaryPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePrincipalAccessBoundaryPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePrincipalAccessBoundaryPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPrincipalAccessBoundaryPolicies.addResponse(resultOperation);

    String name = "name3373707";

    client.deletePrincipalAccessBoundaryPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockPrincipalAccessBoundaryPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePrincipalAccessBoundaryPolicyRequest actualRequest =
        ((DeletePrincipalAccessBoundaryPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePrincipalAccessBoundaryPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrincipalAccessBoundaryPolicies.addException(exception);

    try {
      String name = "name3373707";
      client.deletePrincipalAccessBoundaryPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listPrincipalAccessBoundaryPoliciesTest() throws Exception {
    PrincipalAccessBoundaryPolicy responsesElement =
        PrincipalAccessBoundaryPolicy.newBuilder().build();
    ListPrincipalAccessBoundaryPoliciesResponse expectedResponse =
        ListPrincipalAccessBoundaryPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrincipalAccessBoundaryPolicies(Arrays.asList(responsesElement))
            .build();
    mockPrincipalAccessBoundaryPolicies.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListPrincipalAccessBoundaryPoliciesPagedResponse pagedListResponse =
        client.listPrincipalAccessBoundaryPolicies(parent);

    List<PrincipalAccessBoundaryPolicy> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getPrincipalAccessBoundaryPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPrincipalAccessBoundaryPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPrincipalAccessBoundaryPoliciesRequest actualRequest =
        ((ListPrincipalAccessBoundaryPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPrincipalAccessBoundaryPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrincipalAccessBoundaryPolicies.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listPrincipalAccessBoundaryPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrincipalAccessBoundaryPoliciesTest2() throws Exception {
    PrincipalAccessBoundaryPolicy responsesElement =
        PrincipalAccessBoundaryPolicy.newBuilder().build();
    ListPrincipalAccessBoundaryPoliciesResponse expectedResponse =
        ListPrincipalAccessBoundaryPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrincipalAccessBoundaryPolicies(Arrays.asList(responsesElement))
            .build();
    mockPrincipalAccessBoundaryPolicies.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPrincipalAccessBoundaryPoliciesPagedResponse pagedListResponse =
        client.listPrincipalAccessBoundaryPolicies(parent);

    List<PrincipalAccessBoundaryPolicy> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getPrincipalAccessBoundaryPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPrincipalAccessBoundaryPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPrincipalAccessBoundaryPoliciesRequest actualRequest =
        ((ListPrincipalAccessBoundaryPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPrincipalAccessBoundaryPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrincipalAccessBoundaryPolicies.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPrincipalAccessBoundaryPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchPrincipalAccessBoundaryPolicyBindingsTest() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    SearchPrincipalAccessBoundaryPolicyBindingsResponse expectedResponse =
        SearchPrincipalAccessBoundaryPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockPrincipalAccessBoundaryPolicies.addResponse(expectedResponse);

    PrincipalAccessBoundaryPolicyName name =
        PrincipalAccessBoundaryPolicyName.of(
            "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");

    SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse pagedListResponse =
        client.searchPrincipalAccessBoundaryPolicyBindings(name);

    List<PolicyBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPrincipalAccessBoundaryPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchPrincipalAccessBoundaryPolicyBindingsRequest actualRequest =
        ((SearchPrincipalAccessBoundaryPolicyBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchPrincipalAccessBoundaryPolicyBindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrincipalAccessBoundaryPolicies.addException(exception);

    try {
      PrincipalAccessBoundaryPolicyName name =
          PrincipalAccessBoundaryPolicyName.of(
              "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");
      client.searchPrincipalAccessBoundaryPolicyBindings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchPrincipalAccessBoundaryPolicyBindingsTest2() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    SearchPrincipalAccessBoundaryPolicyBindingsResponse expectedResponse =
        SearchPrincipalAccessBoundaryPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockPrincipalAccessBoundaryPolicies.addResponse(expectedResponse);

    String name = "name3373707";

    SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse pagedListResponse =
        client.searchPrincipalAccessBoundaryPolicyBindings(name);

    List<PolicyBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPrincipalAccessBoundaryPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchPrincipalAccessBoundaryPolicyBindingsRequest actualRequest =
        ((SearchPrincipalAccessBoundaryPolicyBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchPrincipalAccessBoundaryPolicyBindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrincipalAccessBoundaryPolicies.addException(exception);

    try {
      String name = "name3373707";
      client.searchPrincipalAccessBoundaryPolicyBindings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
