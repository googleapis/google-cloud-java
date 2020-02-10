/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.datacatalog.v1beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
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
public class PolicyTagManagerClientTest {
  private static MockDataCatalog mockDataCatalog;
  private static MockPolicyTagManager mockPolicyTagManager;
  private static MockPolicyTagManagerSerialization mockPolicyTagManagerSerialization;
  private static MockServiceHelper serviceHelper;
  private PolicyTagManagerClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDataCatalog = new MockDataCatalog();
    mockPolicyTagManager = new MockPolicyTagManager();
    mockPolicyTagManagerSerialization = new MockPolicyTagManagerSerialization();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockDataCatalog, mockPolicyTagManager, mockPolicyTagManagerSerialization));
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
    PolicyTagManagerSettings settings =
        PolicyTagManagerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PolicyTagManagerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createTaxonomyTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    CreateTaxonomyRequest request = CreateTaxonomyRequest.newBuilder().build();

    Taxonomy actualResponse = client.createTaxonomy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTaxonomyRequest actualRequest = (CreateTaxonomyRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createTaxonomyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      CreateTaxonomyRequest request = CreateTaxonomyRequest.newBuilder().build();

      client.createTaxonomy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTaxonomyTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPolicyTagManager.addResponse(expectedResponse);

    DeleteTaxonomyRequest request = DeleteTaxonomyRequest.newBuilder().build();

    client.deleteTaxonomy(request);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTaxonomyRequest actualRequest = (DeleteTaxonomyRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTaxonomyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      DeleteTaxonomyRequest request = DeleteTaxonomyRequest.newBuilder().build();

      client.deleteTaxonomy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateTaxonomyTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    UpdateTaxonomyRequest request = UpdateTaxonomyRequest.newBuilder().build();

    Taxonomy actualResponse = client.updateTaxonomy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTaxonomyRequest actualRequest = (UpdateTaxonomyRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateTaxonomyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      UpdateTaxonomyRequest request = UpdateTaxonomyRequest.newBuilder().build();

      client.updateTaxonomy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTaxonomiesTest() {
    String nextPageToken = "nextPageToken-1530815211";
    ListTaxonomiesResponse expectedResponse =
        ListTaxonomiesResponse.newBuilder().setNextPageToken(nextPageToken).build();
    mockPolicyTagManager.addResponse(expectedResponse);

    ListTaxonomiesRequest request = ListTaxonomiesRequest.newBuilder().build();

    ListTaxonomiesResponse actualResponse = client.listTaxonomies(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTaxonomiesRequest actualRequest = (ListTaxonomiesRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listTaxonomiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      ListTaxonomiesRequest request = ListTaxonomiesRequest.newBuilder().build();

      client.listTaxonomies(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTaxonomyTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    GetTaxonomyRequest request = GetTaxonomyRequest.newBuilder().build();

    Taxonomy actualResponse = client.getTaxonomy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTaxonomyRequest actualRequest = (GetTaxonomyRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getTaxonomyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      GetTaxonomyRequest request = GetTaxonomyRequest.newBuilder().build();

      client.getTaxonomy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createPolicyTagTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    String parentPolicyTag = "parentPolicyTag2071382466";
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .setParentPolicyTag(parentPolicyTag)
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    CreatePolicyTagRequest request = CreatePolicyTagRequest.newBuilder().build();

    PolicyTag actualResponse = client.createPolicyTag(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePolicyTagRequest actualRequest = (CreatePolicyTagRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createPolicyTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      CreatePolicyTagRequest request = CreatePolicyTagRequest.newBuilder().build();

      client.createPolicyTag(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deletePolicyTagTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPolicyTagManager.addResponse(expectedResponse);

    DeletePolicyTagRequest request = DeletePolicyTagRequest.newBuilder().build();

    client.deletePolicyTag(request);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePolicyTagRequest actualRequest = (DeletePolicyTagRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deletePolicyTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      DeletePolicyTagRequest request = DeletePolicyTagRequest.newBuilder().build();

      client.deletePolicyTag(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updatePolicyTagTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    String parentPolicyTag = "parentPolicyTag2071382466";
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .setParentPolicyTag(parentPolicyTag)
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    UpdatePolicyTagRequest request = UpdatePolicyTagRequest.newBuilder().build();

    PolicyTag actualResponse = client.updatePolicyTag(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePolicyTagRequest actualRequest = (UpdatePolicyTagRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updatePolicyTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      UpdatePolicyTagRequest request = UpdatePolicyTagRequest.newBuilder().build();

      client.updatePolicyTag(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listPolicyTagsTest() {
    String nextPageToken = "nextPageToken-1530815211";
    ListPolicyTagsResponse expectedResponse =
        ListPolicyTagsResponse.newBuilder().setNextPageToken(nextPageToken).build();
    mockPolicyTagManager.addResponse(expectedResponse);

    ListPolicyTagsRequest request = ListPolicyTagsRequest.newBuilder().build();

    ListPolicyTagsResponse actualResponse = client.listPolicyTags(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPolicyTagsRequest actualRequest = (ListPolicyTagsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listPolicyTagsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      ListPolicyTagsRequest request = ListPolicyTagsRequest.newBuilder().build();

      client.listPolicyTags(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getPolicyTagTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    String parentPolicyTag = "parentPolicyTag2071382466";
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .setParentPolicyTag(parentPolicyTag)
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    GetPolicyTagRequest request = GetPolicyTagRequest.newBuilder().build();

    PolicyTag actualResponse = client.getPolicyTag(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPolicyTagRequest actualRequest = (GetPolicyTagRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getPolicyTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      GetPolicyTagRequest request = GetPolicyTagRequest.newBuilder().build();

      client.getPolicyTag(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockPolicyTagManager.addResponse(expectedResponse);

    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().build();

      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockPolicyTagManager.addResponse(expectedResponse);

    SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder().build();

      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestIamPermissionsResponse expectedResponse = TestIamPermissionsResponse.newBuilder().build();
    mockPolicyTagManager.addResponse(expectedResponse);

    TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder().build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder().build();

      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
