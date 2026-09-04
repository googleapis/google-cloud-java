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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.ChildPublisherServiceClient.ListChildPublishersPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonChildPublisherServiceStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ChildPublisherServiceClientTest {
  private static MockHttpService mockService;
  private static ChildPublisherServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonChildPublisherServiceStub.getMethodDescriptors(),
            ChildPublisherServiceSettings.getDefaultEndpoint());
    ChildPublisherServiceSettings settings =
        ChildPublisherServiceSettings.newBuilder()
            .setTransportChannelProvider(
                ChildPublisherServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ChildPublisherServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void getChildPublisherTest() throws Exception {
    ChildPublisher expectedResponse =
        ChildPublisher.newBuilder()
            .setName(ChildPublisherName.of("[NETWORK_CODE]", "[CHILD_PUBLISHER]").toString())
            .setDisplayName("displayName1714148973")
            .setEmail("email96619420")
            .setChildNetwork(NetworkName.of("[NETWORK_CODE]").toString())
            .setParentRevenueShareMillipercent(-1577502224)
            .setSellerId("sellerId1198093562")
            .addAllPendingOnboardingTasks(
                new ArrayList<ChildPublisherOnboardingTaskEnum.ChildPublisherOnboardingTask>())
            .setApprovedManageAccountRevenueShareMillipercent(797069343)
            .build();
    mockService.addResponse(expectedResponse);

    ChildPublisherName name = ChildPublisherName.of("[NETWORK_CODE]", "[CHILD_PUBLISHER]");

    ChildPublisher actualResponse = client.getChildPublisher(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getChildPublisherExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ChildPublisherName name = ChildPublisherName.of("[NETWORK_CODE]", "[CHILD_PUBLISHER]");
      client.getChildPublisher(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChildPublisherTest2() throws Exception {
    ChildPublisher expectedResponse =
        ChildPublisher.newBuilder()
            .setName(ChildPublisherName.of("[NETWORK_CODE]", "[CHILD_PUBLISHER]").toString())
            .setDisplayName("displayName1714148973")
            .setEmail("email96619420")
            .setChildNetwork(NetworkName.of("[NETWORK_CODE]").toString())
            .setParentRevenueShareMillipercent(-1577502224)
            .setSellerId("sellerId1198093562")
            .addAllPendingOnboardingTasks(
                new ArrayList<ChildPublisherOnboardingTaskEnum.ChildPublisherOnboardingTask>())
            .setApprovedManageAccountRevenueShareMillipercent(797069343)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-6870/childPublishers/childPublisher-6870";

    ChildPublisher actualResponse = client.getChildPublisher(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getChildPublisherExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-6870/childPublishers/childPublisher-6870";
      client.getChildPublisher(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChildPublishersTest() throws Exception {
    ChildPublisher responsesElement = ChildPublisher.newBuilder().build();
    ListChildPublishersResponse expectedResponse =
        ListChildPublishersResponse.newBuilder()
            .setNextPageToken("")
            .addAllChildPublishers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListChildPublishersPagedResponse pagedListResponse = client.listChildPublishers(parent);

    List<ChildPublisher> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChildPublishersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listChildPublishersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listChildPublishers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChildPublishersTest2() throws Exception {
    ChildPublisher responsesElement = ChildPublisher.newBuilder().build();
    ListChildPublishersResponse expectedResponse =
        ListChildPublishersResponse.newBuilder()
            .setNextPageToken("")
            .addAllChildPublishers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListChildPublishersPagedResponse pagedListResponse = client.listChildPublishers(parent);

    List<ChildPublisher> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChildPublishersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listChildPublishersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listChildPublishers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createChildPublisherTest() throws Exception {
    ChildPublisher expectedResponse =
        ChildPublisher.newBuilder()
            .setName(ChildPublisherName.of("[NETWORK_CODE]", "[CHILD_PUBLISHER]").toString())
            .setDisplayName("displayName1714148973")
            .setEmail("email96619420")
            .setChildNetwork(NetworkName.of("[NETWORK_CODE]").toString())
            .setParentRevenueShareMillipercent(-1577502224)
            .setSellerId("sellerId1198093562")
            .addAllPendingOnboardingTasks(
                new ArrayList<ChildPublisherOnboardingTaskEnum.ChildPublisherOnboardingTask>())
            .setApprovedManageAccountRevenueShareMillipercent(797069343)
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    ChildPublisher childPublisher = ChildPublisher.newBuilder().build();

    ChildPublisher actualResponse = client.createChildPublisher(parent, childPublisher);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createChildPublisherExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      ChildPublisher childPublisher = ChildPublisher.newBuilder().build();
      client.createChildPublisher(parent, childPublisher);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createChildPublisherTest2() throws Exception {
    ChildPublisher expectedResponse =
        ChildPublisher.newBuilder()
            .setName(ChildPublisherName.of("[NETWORK_CODE]", "[CHILD_PUBLISHER]").toString())
            .setDisplayName("displayName1714148973")
            .setEmail("email96619420")
            .setChildNetwork(NetworkName.of("[NETWORK_CODE]").toString())
            .setParentRevenueShareMillipercent(-1577502224)
            .setSellerId("sellerId1198093562")
            .addAllPendingOnboardingTasks(
                new ArrayList<ChildPublisherOnboardingTaskEnum.ChildPublisherOnboardingTask>())
            .setApprovedManageAccountRevenueShareMillipercent(797069343)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    ChildPublisher childPublisher = ChildPublisher.newBuilder().build();

    ChildPublisher actualResponse = client.createChildPublisher(parent, childPublisher);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createChildPublisherExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      ChildPublisher childPublisher = ChildPublisher.newBuilder().build();
      client.createChildPublisher(parent, childPublisher);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateChildPublishersTest() throws Exception {
    BatchCreateChildPublishersResponse expectedResponse =
        BatchCreateChildPublishersResponse.newBuilder()
            .addAllChildPublishers(new ArrayList<ChildPublisher>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateChildPublisherRequest> requests = new ArrayList<>();

    BatchCreateChildPublishersResponse actualResponse =
        client.batchCreateChildPublishers(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchCreateChildPublishersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateChildPublisherRequest> requests = new ArrayList<>();
      client.batchCreateChildPublishers(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateChildPublishersTest2() throws Exception {
    BatchCreateChildPublishersResponse expectedResponse =
        BatchCreateChildPublishersResponse.newBuilder()
            .addAllChildPublishers(new ArrayList<ChildPublisher>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateChildPublisherRequest> requests = new ArrayList<>();

    BatchCreateChildPublishersResponse actualResponse =
        client.batchCreateChildPublishers(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchCreateChildPublishersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateChildPublisherRequest> requests = new ArrayList<>();
      client.batchCreateChildPublishers(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateChildPublisherTest() throws Exception {
    ChildPublisher expectedResponse =
        ChildPublisher.newBuilder()
            .setName(ChildPublisherName.of("[NETWORK_CODE]", "[CHILD_PUBLISHER]").toString())
            .setDisplayName("displayName1714148973")
            .setEmail("email96619420")
            .setChildNetwork(NetworkName.of("[NETWORK_CODE]").toString())
            .setParentRevenueShareMillipercent(-1577502224)
            .setSellerId("sellerId1198093562")
            .addAllPendingOnboardingTasks(
                new ArrayList<ChildPublisherOnboardingTaskEnum.ChildPublisherOnboardingTask>())
            .setApprovedManageAccountRevenueShareMillipercent(797069343)
            .build();
    mockService.addResponse(expectedResponse);

    ChildPublisher childPublisher =
        ChildPublisher.newBuilder()
            .setName(ChildPublisherName.of("[NETWORK_CODE]", "[CHILD_PUBLISHER]").toString())
            .setDisplayName("displayName1714148973")
            .setEmail("email96619420")
            .setChildNetwork(NetworkName.of("[NETWORK_CODE]").toString())
            .setParentRevenueShareMillipercent(-1577502224)
            .setSellerId("sellerId1198093562")
            .addAllPendingOnboardingTasks(
                new ArrayList<ChildPublisherOnboardingTaskEnum.ChildPublisherOnboardingTask>())
            .setApprovedManageAccountRevenueShareMillipercent(797069343)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ChildPublisher actualResponse = client.updateChildPublisher(childPublisher, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateChildPublisherExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ChildPublisher childPublisher =
          ChildPublisher.newBuilder()
              .setName(ChildPublisherName.of("[NETWORK_CODE]", "[CHILD_PUBLISHER]").toString())
              .setDisplayName("displayName1714148973")
              .setEmail("email96619420")
              .setChildNetwork(NetworkName.of("[NETWORK_CODE]").toString())
              .setParentRevenueShareMillipercent(-1577502224)
              .setSellerId("sellerId1198093562")
              .addAllPendingOnboardingTasks(
                  new ArrayList<ChildPublisherOnboardingTaskEnum.ChildPublisherOnboardingTask>())
              .setApprovedManageAccountRevenueShareMillipercent(797069343)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateChildPublisher(childPublisher, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateChildPublishersTest() throws Exception {
    BatchUpdateChildPublishersResponse expectedResponse =
        BatchUpdateChildPublishersResponse.newBuilder()
            .addAllChildPublishers(new ArrayList<ChildPublisher>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdateChildPublisherRequest> requests = new ArrayList<>();

    BatchUpdateChildPublishersResponse actualResponse =
        client.batchUpdateChildPublishers(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchUpdateChildPublishersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdateChildPublisherRequest> requests = new ArrayList<>();
      client.batchUpdateChildPublishers(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateChildPublishersTest2() throws Exception {
    BatchUpdateChildPublishersResponse expectedResponse =
        BatchUpdateChildPublishersResponse.newBuilder()
            .addAllChildPublishers(new ArrayList<ChildPublisher>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdateChildPublisherRequest> requests = new ArrayList<>();

    BatchUpdateChildPublishersResponse actualResponse =
        client.batchUpdateChildPublishers(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchUpdateChildPublishersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdateChildPublisherRequest> requests = new ArrayList<>();
      client.batchUpdateChildPublishers(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchResendChildPublisherInvitationEmailsTest() throws Exception {
    BatchResendChildPublisherInvitationEmailsResponse expectedResponse =
        BatchResendChildPublisherInvitationEmailsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchResendChildPublisherInvitationEmailsResponse actualResponse =
        client.batchResendChildPublisherInvitationEmails(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchResendChildPublisherInvitationEmailsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchResendChildPublisherInvitationEmails(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchResendChildPublisherInvitationEmailsTest2() throws Exception {
    BatchResendChildPublisherInvitationEmailsResponse expectedResponse =
        BatchResendChildPublisherInvitationEmailsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchResendChildPublisherInvitationEmailsResponse actualResponse =
        client.batchResendChildPublisherInvitationEmails(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchResendChildPublisherInvitationEmailsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchResendChildPublisherInvitationEmails(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRenegotiateChildPublisherAgreementsTest() throws Exception {
    BatchRenegotiateChildPublisherAgreementsResponse expectedResponse =
        BatchRenegotiateChildPublisherAgreementsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<RenegotiateChildPublisherAgreementRequest> requests = new ArrayList<>();

    BatchRenegotiateChildPublisherAgreementsResponse actualResponse =
        client.batchRenegotiateChildPublisherAgreements(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchRenegotiateChildPublisherAgreementsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<RenegotiateChildPublisherAgreementRequest> requests = new ArrayList<>();
      client.batchRenegotiateChildPublisherAgreements(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRenegotiateChildPublisherAgreementsTest2() throws Exception {
    BatchRenegotiateChildPublisherAgreementsResponse expectedResponse =
        BatchRenegotiateChildPublisherAgreementsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<RenegotiateChildPublisherAgreementRequest> requests = new ArrayList<>();

    BatchRenegotiateChildPublisherAgreementsResponse actualResponse =
        client.batchRenegotiateChildPublisherAgreements(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchRenegotiateChildPublisherAgreementsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<RenegotiateChildPublisherAgreementRequest> requests = new ArrayList<>();
      client.batchRenegotiateChildPublisherAgreements(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRejectChildPublishersTest() throws Exception {
    BatchRejectChildPublishersResponse expectedResponse =
        BatchRejectChildPublishersResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchRejectChildPublishersResponse actualResponse =
        client.batchRejectChildPublishers(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchRejectChildPublishersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchRejectChildPublishers(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRejectChildPublishersTest2() throws Exception {
    BatchRejectChildPublishersResponse expectedResponse =
        BatchRejectChildPublishersResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchRejectChildPublishersResponse actualResponse =
        client.batchRejectChildPublishers(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchRejectChildPublishersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchRejectChildPublishers(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchWithdrawChildPublishersTest() throws Exception {
    BatchWithdrawChildPublishersResponse expectedResponse =
        BatchWithdrawChildPublishersResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchWithdrawChildPublishersResponse actualResponse =
        client.batchWithdrawChildPublishers(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchWithdrawChildPublishersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchWithdrawChildPublishers(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchWithdrawChildPublishersTest2() throws Exception {
    BatchWithdrawChildPublishersResponse expectedResponse =
        BatchWithdrawChildPublishersResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchWithdrawChildPublishersResponse actualResponse =
        client.batchWithdrawChildPublishers(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchWithdrawChildPublishersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchWithdrawChildPublishers(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
