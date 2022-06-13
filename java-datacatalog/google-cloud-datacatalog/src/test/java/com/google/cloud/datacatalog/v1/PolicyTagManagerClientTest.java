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

package com.google.cloud.datacatalog.v1;

import static com.google.cloud.datacatalog.v1.PolicyTagManagerClient.ListPolicyTagsPagedResponse;
import static com.google.cloud.datacatalog.v1.PolicyTagManagerClient.ListTaxonomiesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
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
public class PolicyTagManagerClientTest {
  private static MockPolicyTagManager mockPolicyTagManager;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PolicyTagManagerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPolicyTagManager = new MockPolicyTagManager();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockPolicyTagManager));
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
  public void createTaxonomyTest() throws Exception {
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicyTagCount(1074340189)
            .setTaxonomyTimestamps(SystemTimestamps.newBuilder().build())
            .addAllActivatedPolicyTypes(new ArrayList<Taxonomy.PolicyType>())
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Taxonomy taxonomy = Taxonomy.newBuilder().build();

    Taxonomy actualResponse = client.createTaxonomy(parent, taxonomy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTaxonomyRequest actualRequest = ((CreateTaxonomyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(taxonomy, actualRequest.getTaxonomy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTaxonomyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Taxonomy taxonomy = Taxonomy.newBuilder().build();
      client.createTaxonomy(parent, taxonomy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTaxonomyTest2() throws Exception {
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicyTagCount(1074340189)
            .setTaxonomyTimestamps(SystemTimestamps.newBuilder().build())
            .addAllActivatedPolicyTypes(new ArrayList<Taxonomy.PolicyType>())
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Taxonomy taxonomy = Taxonomy.newBuilder().build();

    Taxonomy actualResponse = client.createTaxonomy(parent, taxonomy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTaxonomyRequest actualRequest = ((CreateTaxonomyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(taxonomy, actualRequest.getTaxonomy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTaxonomyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      String parent = "parent-995424086";
      Taxonomy taxonomy = Taxonomy.newBuilder().build();
      client.createTaxonomy(parent, taxonomy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTaxonomyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPolicyTagManager.addResponse(expectedResponse);

    TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");

    client.deleteTaxonomy(name);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTaxonomyRequest actualRequest = ((DeleteTaxonomyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTaxonomyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
      client.deleteTaxonomy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTaxonomyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPolicyTagManager.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTaxonomy(name);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTaxonomyRequest actualRequest = ((DeleteTaxonomyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTaxonomyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTaxonomy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTaxonomyTest() throws Exception {
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicyTagCount(1074340189)
            .setTaxonomyTimestamps(SystemTimestamps.newBuilder().build())
            .addAllActivatedPolicyTypes(new ArrayList<Taxonomy.PolicyType>())
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    Taxonomy taxonomy = Taxonomy.newBuilder().build();

    Taxonomy actualResponse = client.updateTaxonomy(taxonomy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTaxonomyRequest actualRequest = ((UpdateTaxonomyRequest) actualRequests.get(0));

    Assert.assertEquals(taxonomy, actualRequest.getTaxonomy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTaxonomyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      Taxonomy taxonomy = Taxonomy.newBuilder().build();
      client.updateTaxonomy(taxonomy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTaxonomiesTest() throws Exception {
    Taxonomy responsesElement = Taxonomy.newBuilder().build();
    ListTaxonomiesResponse expectedResponse =
        ListTaxonomiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTaxonomies(Arrays.asList(responsesElement))
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTaxonomiesPagedResponse pagedListResponse = client.listTaxonomies(parent);

    List<Taxonomy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTaxonomiesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTaxonomiesRequest actualRequest = ((ListTaxonomiesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTaxonomiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTaxonomies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTaxonomiesTest2() throws Exception {
    Taxonomy responsesElement = Taxonomy.newBuilder().build();
    ListTaxonomiesResponse expectedResponse =
        ListTaxonomiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTaxonomies(Arrays.asList(responsesElement))
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTaxonomiesPagedResponse pagedListResponse = client.listTaxonomies(parent);

    List<Taxonomy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTaxonomiesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTaxonomiesRequest actualRequest = ((ListTaxonomiesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTaxonomiesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTaxonomies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTaxonomyTest() throws Exception {
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicyTagCount(1074340189)
            .setTaxonomyTimestamps(SystemTimestamps.newBuilder().build())
            .addAllActivatedPolicyTypes(new ArrayList<Taxonomy.PolicyType>())
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");

    Taxonomy actualResponse = client.getTaxonomy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTaxonomyRequest actualRequest = ((GetTaxonomyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTaxonomyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
      client.getTaxonomy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTaxonomyTest2() throws Exception {
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicyTagCount(1074340189)
            .setTaxonomyTimestamps(SystemTimestamps.newBuilder().build())
            .addAllActivatedPolicyTypes(new ArrayList<Taxonomy.PolicyType>())
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    String name = "name3373707";

    Taxonomy actualResponse = client.getTaxonomy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTaxonomyRequest actualRequest = ((GetTaxonomyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTaxonomyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      String name = "name3373707";
      client.getTaxonomy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPolicyTagTest() throws Exception {
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setParentPolicyTag("parentPolicyTag973173630")
            .addAllChildPolicyTags(new ArrayList<String>())
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    TaxonomyName parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
    PolicyTag policyTag = PolicyTag.newBuilder().build();

    PolicyTag actualResponse = client.createPolicyTag(parent, policyTag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePolicyTagRequest actualRequest = ((CreatePolicyTagRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(policyTag, actualRequest.getPolicyTag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPolicyTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      TaxonomyName parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
      PolicyTag policyTag = PolicyTag.newBuilder().build();
      client.createPolicyTag(parent, policyTag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPolicyTagTest2() throws Exception {
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setParentPolicyTag("parentPolicyTag973173630")
            .addAllChildPolicyTags(new ArrayList<String>())
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    String parent = "parent-995424086";
    PolicyTag policyTag = PolicyTag.newBuilder().build();

    PolicyTag actualResponse = client.createPolicyTag(parent, policyTag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePolicyTagRequest actualRequest = ((CreatePolicyTagRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(policyTag, actualRequest.getPolicyTag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPolicyTagExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      String parent = "parent-995424086";
      PolicyTag policyTag = PolicyTag.newBuilder().build();
      client.createPolicyTag(parent, policyTag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePolicyTagTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPolicyTagManager.addResponse(expectedResponse);

    PolicyTagName name = PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");

    client.deletePolicyTag(name);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePolicyTagRequest actualRequest = ((DeletePolicyTagRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePolicyTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      PolicyTagName name =
          PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");
      client.deletePolicyTag(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePolicyTagTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPolicyTagManager.addResponse(expectedResponse);

    String name = "name3373707";

    client.deletePolicyTag(name);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePolicyTagRequest actualRequest = ((DeletePolicyTagRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePolicyTagExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      String name = "name3373707";
      client.deletePolicyTag(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePolicyTagTest() throws Exception {
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setParentPolicyTag("parentPolicyTag973173630")
            .addAllChildPolicyTags(new ArrayList<String>())
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    PolicyTag policyTag = PolicyTag.newBuilder().build();

    PolicyTag actualResponse = client.updatePolicyTag(policyTag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePolicyTagRequest actualRequest = ((UpdatePolicyTagRequest) actualRequests.get(0));

    Assert.assertEquals(policyTag, actualRequest.getPolicyTag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePolicyTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      PolicyTag policyTag = PolicyTag.newBuilder().build();
      client.updatePolicyTag(policyTag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPolicyTagsTest() throws Exception {
    PolicyTag responsesElement = PolicyTag.newBuilder().build();
    ListPolicyTagsResponse expectedResponse =
        ListPolicyTagsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyTags(Arrays.asList(responsesElement))
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    TaxonomyName parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");

    ListPolicyTagsPagedResponse pagedListResponse = client.listPolicyTags(parent);

    List<PolicyTag> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyTagsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPolicyTagsRequest actualRequest = ((ListPolicyTagsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPolicyTagsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      TaxonomyName parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
      client.listPolicyTags(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPolicyTagsTest2() throws Exception {
    PolicyTag responsesElement = PolicyTag.newBuilder().build();
    ListPolicyTagsResponse expectedResponse =
        ListPolicyTagsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyTags(Arrays.asList(responsesElement))
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPolicyTagsPagedResponse pagedListResponse = client.listPolicyTags(parent);

    List<PolicyTag> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyTagsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPolicyTagsRequest actualRequest = ((ListPolicyTagsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPolicyTagsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPolicyTags(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPolicyTagTest() throws Exception {
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setParentPolicyTag("parentPolicyTag973173630")
            .addAllChildPolicyTags(new ArrayList<String>())
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    PolicyTagName name = PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");

    PolicyTag actualResponse = client.getPolicyTag(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPolicyTagRequest actualRequest = ((GetPolicyTagRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPolicyTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      PolicyTagName name =
          PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");
      client.getPolicyTag(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPolicyTagTest2() throws Exception {
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setParentPolicyTag("parentPolicyTag973173630")
            .addAllChildPolicyTags(new ArrayList<String>())
            .build();
    mockPolicyTagManager.addResponse(expectedResponse);

    String name = "name3373707";

    PolicyTag actualResponse = client.getPolicyTag(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPolicyTagRequest actualRequest = ((GetPolicyTagRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPolicyTagExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyTagManager.addException(exception);

    try {
      String name = "name3373707";
      client.getPolicyTag(name);
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
    mockPolicyTagManager.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
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
    mockPolicyTagManager.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                      .toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
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
    mockPolicyTagManager.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
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
    mockPolicyTagManager.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                      .toString())
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
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockPolicyTagManager.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManager.getRequests();
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
    mockPolicyTagManager.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                      .toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
