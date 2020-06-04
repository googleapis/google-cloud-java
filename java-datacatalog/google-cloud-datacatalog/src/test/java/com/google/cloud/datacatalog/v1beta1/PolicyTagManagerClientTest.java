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

import static com.google.cloud.datacatalog.v1beta1.PolicyTagManagerClient.ListPolicyTagsPagedResponse;
import static com.google.cloud.datacatalog.v1beta1.PolicyTagManagerClient.ListTaxonomiesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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
    TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Taxonomy taxonomy = Taxonomy.newBuilder().build();

    Taxonomy actualResponse = client.createTaxonomy(parent, taxonomy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTaxonomyRequest actualRequest = (CreateTaxonomyRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(taxonomy, actualRequest.getTaxonomy());
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
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Taxonomy taxonomy = Taxonomy.newBuilder().build();

      client.createTaxonomy(parent, taxonomy);
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

    TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");

    client.deleteTaxonomy(name);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTaxonomyRequest actualRequest = (DeleteTaxonomyRequest) actualRequests.get(0);

    Assert.assertEquals(name, TaxonomyName.parse(actualRequest.getName()));
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
      TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");

      client.deleteTaxonomy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateTaxonomyTest() {
    TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    Taxonomy taxonomy = Taxonomy.newBuilder().build();

    Taxonomy actualResponse = client.updateTaxonomy(taxonomy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTaxonomyRequest actualRequest = (UpdateTaxonomyRequest) actualRequests.get(0);

    Assert.assertEquals(taxonomy, actualRequest.getTaxonomy());
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
      Taxonomy taxonomy = Taxonomy.newBuilder().build();

      client.updateTaxonomy(taxonomy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTaxonomiesTest() {
    String nextPageToken = "";
    Taxonomy taxonomiesElement = Taxonomy.newBuilder().build();
    List<Taxonomy> taxonomies = Arrays.asList(taxonomiesElement);
    ListTaxonomiesResponse expectedResponse =
        ListTaxonomiesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllTaxonomies(taxonomies)
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTaxonomiesPagedResponse pagedListResponse = client.listTaxonomies(parent);

    List<Taxonomy> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTaxonomiesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTaxonomiesRequest actualRequest = (ListTaxonomiesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
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
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listTaxonomies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTaxonomyTest() {
    TaxonomyName name2 = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");

    Taxonomy actualResponse = client.getTaxonomy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTaxonomyRequest actualRequest = (GetTaxonomyRequest) actualRequests.get(0);

    Assert.assertEquals(name, TaxonomyName.parse(actualRequest.getName()));
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
      TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");

      client.getTaxonomy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createPolicyTagTest() {
    PolicyTagName name = PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    String parentPolicyTag = "parentPolicyTag2071382466";
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .setParentPolicyTag(parentPolicyTag)
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    TaxonomyName parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
    PolicyTag policyTag = PolicyTag.newBuilder().build();

    PolicyTag actualResponse = client.createPolicyTag(parent, policyTag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePolicyTagRequest actualRequest = (CreatePolicyTagRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TaxonomyName.parse(actualRequest.getParent()));
    Assert.assertEquals(policyTag, actualRequest.getPolicyTag());
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
      TaxonomyName parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
      PolicyTag policyTag = PolicyTag.newBuilder().build();

      client.createPolicyTag(parent, policyTag);
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

    PolicyTagName name = PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");

    client.deletePolicyTag(name);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePolicyTagRequest actualRequest = (DeletePolicyTagRequest) actualRequests.get(0);

    Assert.assertEquals(name, PolicyTagName.parse(actualRequest.getName()));
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
      PolicyTagName name =
          PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");

      client.deletePolicyTag(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updatePolicyTagTest() {
    PolicyTagName name = PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    String parentPolicyTag = "parentPolicyTag2071382466";
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .setParentPolicyTag(parentPolicyTag)
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    PolicyTag policyTag = PolicyTag.newBuilder().build();

    PolicyTag actualResponse = client.updatePolicyTag(policyTag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePolicyTagRequest actualRequest = (UpdatePolicyTagRequest) actualRequests.get(0);

    Assert.assertEquals(policyTag, actualRequest.getPolicyTag());
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
      PolicyTag policyTag = PolicyTag.newBuilder().build();

      client.updatePolicyTag(policyTag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listPolicyTagsTest() {
    String nextPageToken = "";
    PolicyTag policyTagsElement = PolicyTag.newBuilder().build();
    List<PolicyTag> policyTags = Arrays.asList(policyTagsElement);
    ListPolicyTagsResponse expectedResponse =
        ListPolicyTagsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllPolicyTags(policyTags)
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    TaxonomyName parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");

    ListPolicyTagsPagedResponse pagedListResponse = client.listPolicyTags(parent);

    List<PolicyTag> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyTagsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPolicyTagsRequest actualRequest = (ListPolicyTagsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TaxonomyName.parse(actualRequest.getParent()));
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
      TaxonomyName parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");

      client.listPolicyTags(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getPolicyTagTest() {
    PolicyTagName name2 = PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    String parentPolicyTag = "parentPolicyTag2071382466";
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .setParentPolicyTag(parentPolicyTag)
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    PolicyTagName name = PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");

    PolicyTag actualResponse = client.getPolicyTag(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPolicyTagRequest actualRequest = (GetPolicyTagRequest) actualRequests.get(0);

    Assert.assertEquals(name, PolicyTagName.parse(actualRequest.getName()));
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
      PolicyTagName name =
          PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");

      client.getPolicyTag(name);
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

    ResourceName resource = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder().setResource(resource.toString()).build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
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
      ResourceName resource = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder().setResource(resource.toString()).build();

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

    ResourceName resource = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
    Policy policy = Policy.newBuilder().build();
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource.toString()).setPolicy(policy).build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertEquals(policy, actualRequest.getPolicy());
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
      ResourceName resource = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      Policy policy = Policy.newBuilder().build();
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(resource.toString())
              .setPolicy(policy)
              .build();

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

    ResourceName resource = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
    List<String> permissions = new ArrayList<>();
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource.toString())
            .addAllPermissions(permissions)
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
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
      ResourceName resource = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      List<String> permissions = new ArrayList<>();
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(resource.toString())
              .addAllPermissions(permissions)
              .build();

      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
