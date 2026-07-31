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

package com.google.cloud.chronicle.v1;

import static com.google.cloud.chronicle.v1.FindingsRefinementServiceClient.ListAllFindingsRefinementDeploymentsPagedResponse;
import static com.google.cloud.chronicle.v1.FindingsRefinementServiceClient.ListFindingsRefinementsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class FindingsRefinementServiceClientTest {
  private static MockFindingsRefinementService mockFindingsRefinementService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private FindingsRefinementServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockFindingsRefinementService = new MockFindingsRefinementService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockFindingsRefinementService));
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
    FindingsRefinementServiceSettings settings =
        FindingsRefinementServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FindingsRefinementServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getFindingsRefinementTest() throws Exception {
    FindingsRefinement expectedResponse =
        FindingsRefinement.newBuilder()
            .setName(
                FindingsRefinementName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FindingsRefinementType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuery("query107944136")
            .addAllOutcomeFilters(new ArrayList<OutcomeFilter>())
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    FindingsRefinementName name =
        FindingsRefinementName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");

    FindingsRefinement actualResponse = client.getFindingsRefinement(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFindingsRefinementRequest actualRequest =
        ((GetFindingsRefinementRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFindingsRefinementExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      FindingsRefinementName name =
          FindingsRefinementName.of(
              "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");
      client.getFindingsRefinement(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFindingsRefinementTest2() throws Exception {
    FindingsRefinement expectedResponse =
        FindingsRefinement.newBuilder()
            .setName(
                FindingsRefinementName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FindingsRefinementType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuery("query107944136")
            .addAllOutcomeFilters(new ArrayList<OutcomeFilter>())
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    String name = "name3373707";

    FindingsRefinement actualResponse = client.getFindingsRefinement(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFindingsRefinementRequest actualRequest =
        ((GetFindingsRefinementRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFindingsRefinementExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      String name = "name3373707";
      client.getFindingsRefinement(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingsRefinementsTest() throws Exception {
    FindingsRefinement responsesElement = FindingsRefinement.newBuilder().build();
    ListFindingsRefinementsResponse expectedResponse =
        ListFindingsRefinementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFindingsRefinements(Arrays.asList(responsesElement))
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListFindingsRefinementsPagedResponse pagedListResponse = client.listFindingsRefinements(parent);

    List<FindingsRefinement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingsRefinementsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingsRefinementsRequest actualRequest =
        ((ListFindingsRefinementsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFindingsRefinementsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listFindingsRefinements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingsRefinementsTest2() throws Exception {
    FindingsRefinement responsesElement = FindingsRefinement.newBuilder().build();
    ListFindingsRefinementsResponse expectedResponse =
        ListFindingsRefinementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFindingsRefinements(Arrays.asList(responsesElement))
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFindingsRefinementsPagedResponse pagedListResponse = client.listFindingsRefinements(parent);

    List<FindingsRefinement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingsRefinementsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingsRefinementsRequest actualRequest =
        ((ListFindingsRefinementsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFindingsRefinementsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFindingsRefinements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFindingsRefinementTest() throws Exception {
    FindingsRefinement expectedResponse =
        FindingsRefinement.newBuilder()
            .setName(
                FindingsRefinementName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FindingsRefinementType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuery("query107944136")
            .addAllOutcomeFilters(new ArrayList<OutcomeFilter>())
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    FindingsRefinement findingsRefinement = FindingsRefinement.newBuilder().build();

    FindingsRefinement actualResponse = client.createFindingsRefinement(parent, findingsRefinement);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFindingsRefinementRequest actualRequest =
        ((CreateFindingsRefinementRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(findingsRefinement, actualRequest.getFindingsRefinement());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFindingsRefinementExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      FindingsRefinement findingsRefinement = FindingsRefinement.newBuilder().build();
      client.createFindingsRefinement(parent, findingsRefinement);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFindingsRefinementTest2() throws Exception {
    FindingsRefinement expectedResponse =
        FindingsRefinement.newBuilder()
            .setName(
                FindingsRefinementName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FindingsRefinementType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuery("query107944136")
            .addAllOutcomeFilters(new ArrayList<OutcomeFilter>())
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    FindingsRefinement findingsRefinement = FindingsRefinement.newBuilder().build();

    FindingsRefinement actualResponse = client.createFindingsRefinement(parent, findingsRefinement);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFindingsRefinementRequest actualRequest =
        ((CreateFindingsRefinementRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(findingsRefinement, actualRequest.getFindingsRefinement());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFindingsRefinementExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      String parent = "parent-995424086";
      FindingsRefinement findingsRefinement = FindingsRefinement.newBuilder().build();
      client.createFindingsRefinement(parent, findingsRefinement);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFindingsRefinementTest() throws Exception {
    FindingsRefinement expectedResponse =
        FindingsRefinement.newBuilder()
            .setName(
                FindingsRefinementName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FindingsRefinementType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuery("query107944136")
            .addAllOutcomeFilters(new ArrayList<OutcomeFilter>())
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    FindingsRefinement findingsRefinement = FindingsRefinement.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FindingsRefinement actualResponse =
        client.updateFindingsRefinement(findingsRefinement, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFindingsRefinementRequest actualRequest =
        ((UpdateFindingsRefinementRequest) actualRequests.get(0));

    Assert.assertEquals(findingsRefinement, actualRequest.getFindingsRefinement());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFindingsRefinementExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      FindingsRefinement findingsRefinement = FindingsRefinement.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFindingsRefinement(findingsRefinement, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFindingsRefinementDeploymentTest() throws Exception {
    FindingsRefinementDeployment expectedResponse =
        FindingsRefinementDeployment.newBuilder()
            .setName(
                FindingsRefinementDeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setEnabled(true)
            .setArchived(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    FindingsRefinementDeploymentName name =
        FindingsRefinementDeploymentName.of(
            "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");

    FindingsRefinementDeployment actualResponse = client.getFindingsRefinementDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFindingsRefinementDeploymentRequest actualRequest =
        ((GetFindingsRefinementDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFindingsRefinementDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      FindingsRefinementDeploymentName name =
          FindingsRefinementDeploymentName.of(
              "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");
      client.getFindingsRefinementDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFindingsRefinementDeploymentTest2() throws Exception {
    FindingsRefinementDeployment expectedResponse =
        FindingsRefinementDeployment.newBuilder()
            .setName(
                FindingsRefinementDeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setEnabled(true)
            .setArchived(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    String name = "name3373707";

    FindingsRefinementDeployment actualResponse = client.getFindingsRefinementDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFindingsRefinementDeploymentRequest actualRequest =
        ((GetFindingsRefinementDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFindingsRefinementDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      String name = "name3373707";
      client.getFindingsRefinementDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFindingsRefinementDeploymentTest() throws Exception {
    FindingsRefinementDeployment expectedResponse =
        FindingsRefinementDeployment.newBuilder()
            .setName(
                FindingsRefinementDeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setEnabled(true)
            .setArchived(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    FindingsRefinementDeployment findingsRefinementDeployment =
        FindingsRefinementDeployment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FindingsRefinementDeployment actualResponse =
        client.updateFindingsRefinementDeployment(findingsRefinementDeployment, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFindingsRefinementDeploymentRequest actualRequest =
        ((UpdateFindingsRefinementDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(
        findingsRefinementDeployment, actualRequest.getFindingsRefinementDeployment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFindingsRefinementDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      FindingsRefinementDeployment findingsRefinementDeployment =
          FindingsRefinementDeployment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFindingsRefinementDeployment(findingsRefinementDeployment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAllFindingsRefinementDeploymentsTest() throws Exception {
    FindingsRefinementDeployment responsesElement =
        FindingsRefinementDeployment.newBuilder().build();
    ListAllFindingsRefinementDeploymentsResponse expectedResponse =
        ListAllFindingsRefinementDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAllFindingsRefinementDeployments(Arrays.asList(responsesElement))
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListAllFindingsRefinementDeploymentsPagedResponse pagedListResponse =
        client.listAllFindingsRefinementDeployments(instance);

    List<FindingsRefinementDeployment> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAllFindingsRefinementDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAllFindingsRefinementDeploymentsRequest actualRequest =
        ((ListAllFindingsRefinementDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(instance.toString(), actualRequest.getInstance());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAllFindingsRefinementDeploymentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listAllFindingsRefinementDeployments(instance);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAllFindingsRefinementDeploymentsTest2() throws Exception {
    FindingsRefinementDeployment responsesElement =
        FindingsRefinementDeployment.newBuilder().build();
    ListAllFindingsRefinementDeploymentsResponse expectedResponse =
        ListAllFindingsRefinementDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAllFindingsRefinementDeployments(Arrays.asList(responsesElement))
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    String instance = "instance555127957";

    ListAllFindingsRefinementDeploymentsPagedResponse pagedListResponse =
        client.listAllFindingsRefinementDeployments(instance);

    List<FindingsRefinementDeployment> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAllFindingsRefinementDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAllFindingsRefinementDeploymentsRequest actualRequest =
        ((ListAllFindingsRefinementDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAllFindingsRefinementDeploymentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      String instance = "instance555127957";
      client.listAllFindingsRefinementDeployments(instance);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void computeFindingsRefinementActivityTest() throws Exception {
    ComputeFindingsRefinementActivityResponse expectedResponse =
        ComputeFindingsRefinementActivityResponse.newBuilder()
            .setActivity(FindingsRefinementActivity.newBuilder().build())
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    FindingsRefinementName name =
        FindingsRefinementName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");

    ComputeFindingsRefinementActivityResponse actualResponse =
        client.computeFindingsRefinementActivity(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ComputeFindingsRefinementActivityRequest actualRequest =
        ((ComputeFindingsRefinementActivityRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void computeFindingsRefinementActivityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      FindingsRefinementName name =
          FindingsRefinementName.of(
              "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");
      client.computeFindingsRefinementActivity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void computeFindingsRefinementActivityTest2() throws Exception {
    ComputeFindingsRefinementActivityResponse expectedResponse =
        ComputeFindingsRefinementActivityResponse.newBuilder()
            .setActivity(FindingsRefinementActivity.newBuilder().build())
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    String name = "name3373707";

    ComputeFindingsRefinementActivityResponse actualResponse =
        client.computeFindingsRefinementActivity(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ComputeFindingsRefinementActivityRequest actualRequest =
        ((ComputeFindingsRefinementActivityRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void computeFindingsRefinementActivityExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      String name = "name3373707";
      client.computeFindingsRefinementActivity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void computeAllFindingsRefinementActivitiesTest() throws Exception {
    ComputeAllFindingsRefinementActivitiesResponse expectedResponse =
        ComputeAllFindingsRefinementActivitiesResponse.newBuilder()
            .addAllActivities(new ArrayList<FindingsRefinementActivity>())
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ComputeAllFindingsRefinementActivitiesResponse actualResponse =
        client.computeAllFindingsRefinementActivities(instance);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ComputeAllFindingsRefinementActivitiesRequest actualRequest =
        ((ComputeAllFindingsRefinementActivitiesRequest) actualRequests.get(0));

    Assert.assertEquals(instance.toString(), actualRequest.getInstance());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void computeAllFindingsRefinementActivitiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.computeAllFindingsRefinementActivities(instance);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void computeAllFindingsRefinementActivitiesTest2() throws Exception {
    ComputeAllFindingsRefinementActivitiesResponse expectedResponse =
        ComputeAllFindingsRefinementActivitiesResponse.newBuilder()
            .addAllActivities(new ArrayList<FindingsRefinementActivity>())
            .build();
    mockFindingsRefinementService.addResponse(expectedResponse);

    String instance = "instance555127957";

    ComputeAllFindingsRefinementActivitiesResponse actualResponse =
        client.computeAllFindingsRefinementActivities(instance);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFindingsRefinementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ComputeAllFindingsRefinementActivitiesRequest actualRequest =
        ((ComputeAllFindingsRefinementActivitiesRequest) actualRequests.get(0));

    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void computeAllFindingsRefinementActivitiesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFindingsRefinementService.addException(exception);

    try {
      String instance = "instance555127957";
      client.computeAllFindingsRefinementActivities(instance);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
