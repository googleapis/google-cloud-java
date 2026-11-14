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

import static com.google.ads.admanager.v1.ProposalServiceClient.FetchMarketplaceCommentsPagedResponse;
import static com.google.ads.admanager.v1.ProposalServiceClient.ListProposalsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonProposalServiceStub;
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
import com.google.protobuf.Timestamp;
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
public class ProposalServiceClientTest {
  private static MockHttpService mockService;
  private static ProposalServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonProposalServiceStub.getMethodDescriptors(),
            ProposalServiceSettings.getDefaultEndpoint());
    ProposalServiceSettings settings =
        ProposalServiceSettings.newBuilder()
            .setTransportChannelProvider(
                ProposalServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProposalServiceClient.create(settings);
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
  public void getProposalTest() throws Exception {
    Proposal expectedResponse =
        Proposal.newBuilder()
            .setName(ProposalName.of("[NETWORK_CODE]", "[PROPOSAL]").toString())
            .setOrder(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setArchived(true)
            .setAdvertiser(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .addAllAgencies(new ArrayList<ProposalCompanyAssociation>())
            .setNotes("notes105008833")
            .setPrimarySalesperson(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllSalesPlannerUsers(new ArrayList<String>())
            .setTrafficker(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllSellerContactUsers(new ArrayList<String>())
            .addAllAppliedTeams(new ArrayList<String>())
            .addAllCustomFieldValues(new ArrayList<CustomFieldValue>())
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .setCurrencyCode("currencyCode1004773790")
            .setSold(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMarketplaceInfo(ProposalMarketplaceInfo.newBuilder().build())
            .setBuyerRfp(BuyerRfp.newBuilder().build())
            .setDeliveryPausingEnabled(true)
            .build();
    mockService.addResponse(expectedResponse);

    ProposalName name = ProposalName.of("[NETWORK_CODE]", "[PROPOSAL]");

    Proposal actualResponse = client.getProposal(name);
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
  public void getProposalExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProposalName name = ProposalName.of("[NETWORK_CODE]", "[PROPOSAL]");
      client.getProposal(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProposalTest2() throws Exception {
    Proposal expectedResponse =
        Proposal.newBuilder()
            .setName(ProposalName.of("[NETWORK_CODE]", "[PROPOSAL]").toString())
            .setOrder(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setArchived(true)
            .setAdvertiser(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .addAllAgencies(new ArrayList<ProposalCompanyAssociation>())
            .setNotes("notes105008833")
            .setPrimarySalesperson(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllSalesPlannerUsers(new ArrayList<String>())
            .setTrafficker(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllSellerContactUsers(new ArrayList<String>())
            .addAllAppliedTeams(new ArrayList<String>())
            .addAllCustomFieldValues(new ArrayList<CustomFieldValue>())
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .setCurrencyCode("currencyCode1004773790")
            .setSold(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMarketplaceInfo(ProposalMarketplaceInfo.newBuilder().build())
            .setBuyerRfp(BuyerRfp.newBuilder().build())
            .setDeliveryPausingEnabled(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-7240/proposals/proposal-7240";

    Proposal actualResponse = client.getProposal(name);
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
  public void getProposalExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-7240/proposals/proposal-7240";
      client.getProposal(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProposalsTest() throws Exception {
    Proposal responsesElement = Proposal.newBuilder().build();
    ListProposalsResponse expectedResponse =
        ListProposalsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProposals(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListProposalsPagedResponse pagedListResponse = client.listProposals(parent);

    List<Proposal> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProposalsList().get(0), resources.get(0));

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
  public void listProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listProposals(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProposalsTest2() throws Exception {
    Proposal responsesElement = Proposal.newBuilder().build();
    ListProposalsResponse expectedResponse =
        ListProposalsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProposals(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListProposalsPagedResponse pagedListResponse = client.listProposals(parent);

    List<Proposal> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProposalsList().get(0), resources.get(0));

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
  public void listProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listProposals(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createProposalTest() throws Exception {
    Proposal expectedResponse =
        Proposal.newBuilder()
            .setName(ProposalName.of("[NETWORK_CODE]", "[PROPOSAL]").toString())
            .setOrder(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setArchived(true)
            .setAdvertiser(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .addAllAgencies(new ArrayList<ProposalCompanyAssociation>())
            .setNotes("notes105008833")
            .setPrimarySalesperson(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllSalesPlannerUsers(new ArrayList<String>())
            .setTrafficker(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllSellerContactUsers(new ArrayList<String>())
            .addAllAppliedTeams(new ArrayList<String>())
            .addAllCustomFieldValues(new ArrayList<CustomFieldValue>())
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .setCurrencyCode("currencyCode1004773790")
            .setSold(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMarketplaceInfo(ProposalMarketplaceInfo.newBuilder().build())
            .setBuyerRfp(BuyerRfp.newBuilder().build())
            .setDeliveryPausingEnabled(true)
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    Proposal proposal = Proposal.newBuilder().build();

    Proposal actualResponse = client.createProposal(parent, proposal);
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
  public void createProposalExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      Proposal proposal = Proposal.newBuilder().build();
      client.createProposal(parent, proposal);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createProposalTest2() throws Exception {
    Proposal expectedResponse =
        Proposal.newBuilder()
            .setName(ProposalName.of("[NETWORK_CODE]", "[PROPOSAL]").toString())
            .setOrder(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setArchived(true)
            .setAdvertiser(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .addAllAgencies(new ArrayList<ProposalCompanyAssociation>())
            .setNotes("notes105008833")
            .setPrimarySalesperson(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllSalesPlannerUsers(new ArrayList<String>())
            .setTrafficker(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllSellerContactUsers(new ArrayList<String>())
            .addAllAppliedTeams(new ArrayList<String>())
            .addAllCustomFieldValues(new ArrayList<CustomFieldValue>())
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .setCurrencyCode("currencyCode1004773790")
            .setSold(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMarketplaceInfo(ProposalMarketplaceInfo.newBuilder().build())
            .setBuyerRfp(BuyerRfp.newBuilder().build())
            .setDeliveryPausingEnabled(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    Proposal proposal = Proposal.newBuilder().build();

    Proposal actualResponse = client.createProposal(parent, proposal);
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
  public void createProposalExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      Proposal proposal = Proposal.newBuilder().build();
      client.createProposal(parent, proposal);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateProposalsTest() throws Exception {
    BatchCreateProposalsResponse expectedResponse =
        BatchCreateProposalsResponse.newBuilder()
            .addAllProposals(new ArrayList<Proposal>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateProposalRequest> requests = new ArrayList<>();

    BatchCreateProposalsResponse actualResponse = client.batchCreateProposals(parent, requests);
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
  public void batchCreateProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateProposalRequest> requests = new ArrayList<>();
      client.batchCreateProposals(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateProposalsTest2() throws Exception {
    BatchCreateProposalsResponse expectedResponse =
        BatchCreateProposalsResponse.newBuilder()
            .addAllProposals(new ArrayList<Proposal>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateProposalRequest> requests = new ArrayList<>();

    BatchCreateProposalsResponse actualResponse = client.batchCreateProposals(parent, requests);
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
  public void batchCreateProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateProposalRequest> requests = new ArrayList<>();
      client.batchCreateProposals(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateProposalTest() throws Exception {
    Proposal expectedResponse =
        Proposal.newBuilder()
            .setName(ProposalName.of("[NETWORK_CODE]", "[PROPOSAL]").toString())
            .setOrder(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setArchived(true)
            .setAdvertiser(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .addAllAgencies(new ArrayList<ProposalCompanyAssociation>())
            .setNotes("notes105008833")
            .setPrimarySalesperson(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllSalesPlannerUsers(new ArrayList<String>())
            .setTrafficker(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllSellerContactUsers(new ArrayList<String>())
            .addAllAppliedTeams(new ArrayList<String>())
            .addAllCustomFieldValues(new ArrayList<CustomFieldValue>())
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .setCurrencyCode("currencyCode1004773790")
            .setSold(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMarketplaceInfo(ProposalMarketplaceInfo.newBuilder().build())
            .setBuyerRfp(BuyerRfp.newBuilder().build())
            .setDeliveryPausingEnabled(true)
            .build();
    mockService.addResponse(expectedResponse);

    Proposal proposal =
        Proposal.newBuilder()
            .setName(ProposalName.of("[NETWORK_CODE]", "[PROPOSAL]").toString())
            .setOrder(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setArchived(true)
            .setAdvertiser(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .addAllAgencies(new ArrayList<ProposalCompanyAssociation>())
            .setNotes("notes105008833")
            .setPrimarySalesperson(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllSalesPlannerUsers(new ArrayList<String>())
            .setTrafficker(UserName.of("[NETWORK_CODE]", "[USER]").toString())
            .addAllSellerContactUsers(new ArrayList<String>())
            .addAllAppliedTeams(new ArrayList<String>())
            .addAllCustomFieldValues(new ArrayList<CustomFieldValue>())
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .setCurrencyCode("currencyCode1004773790")
            .setSold(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMarketplaceInfo(ProposalMarketplaceInfo.newBuilder().build())
            .setBuyerRfp(BuyerRfp.newBuilder().build())
            .setDeliveryPausingEnabled(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Proposal actualResponse = client.updateProposal(proposal, updateMask);
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
  public void updateProposalExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Proposal proposal =
          Proposal.newBuilder()
              .setName(ProposalName.of("[NETWORK_CODE]", "[PROPOSAL]").toString())
              .setOrder(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
              .setDisplayName("displayName1714148973")
              .setStartTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .setArchived(true)
              .setAdvertiser(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
              .addAllAgencies(new ArrayList<ProposalCompanyAssociation>())
              .setNotes("notes105008833")
              .setPrimarySalesperson(UserName.of("[NETWORK_CODE]", "[USER]").toString())
              .addAllSalesPlannerUsers(new ArrayList<String>())
              .setTrafficker(UserName.of("[NETWORK_CODE]", "[USER]").toString())
              .addAllSellerContactUsers(new ArrayList<String>())
              .addAllAppliedTeams(new ArrayList<String>())
              .addAllCustomFieldValues(new ArrayList<CustomFieldValue>())
              .addAllAppliedLabels(new ArrayList<AppliedLabel>())
              .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
              .setCurrencyCode("currencyCode1004773790")
              .setSold(true)
              .setUpdateTime(Timestamp.newBuilder().build())
              .setMarketplaceInfo(ProposalMarketplaceInfo.newBuilder().build())
              .setBuyerRfp(BuyerRfp.newBuilder().build())
              .setDeliveryPausingEnabled(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateProposal(proposal, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateProposalsTest() throws Exception {
    BatchUpdateProposalsResponse expectedResponse =
        BatchUpdateProposalsResponse.newBuilder()
            .addAllProposals(new ArrayList<Proposal>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdateProposalRequest> requests = new ArrayList<>();

    BatchUpdateProposalsResponse actualResponse = client.batchUpdateProposals(parent, requests);
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
  public void batchUpdateProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdateProposalRequest> requests = new ArrayList<>();
      client.batchUpdateProposals(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateProposalsTest2() throws Exception {
    BatchUpdateProposalsResponse expectedResponse =
        BatchUpdateProposalsResponse.newBuilder()
            .addAllProposals(new ArrayList<Proposal>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdateProposalRequest> requests = new ArrayList<>();

    BatchUpdateProposalsResponse actualResponse = client.batchUpdateProposals(parent, requests);
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
  public void batchUpdateProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdateProposalRequest> requests = new ArrayList<>();
      client.batchUpdateProposals(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchArchiveProposalsTest() throws Exception {
    BatchArchiveProposalsResponse expectedResponse =
        BatchArchiveProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchArchiveProposalsResponse actualResponse = client.batchArchiveProposals(parent, names);
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
  public void batchArchiveProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchArchiveProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchArchiveProposalsTest2() throws Exception {
    BatchArchiveProposalsResponse expectedResponse =
        BatchArchiveProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchArchiveProposalsResponse actualResponse = client.batchArchiveProposals(parent, names);
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
  public void batchArchiveProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchArchiveProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUnarchiveProposalsTest() throws Exception {
    BatchUnarchiveProposalsResponse expectedResponse =
        BatchUnarchiveProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchUnarchiveProposalsResponse actualResponse = client.batchUnarchiveProposals(parent, names);
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
  public void batchUnarchiveProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchUnarchiveProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUnarchiveProposalsTest2() throws Exception {
    BatchUnarchiveProposalsResponse expectedResponse =
        BatchUnarchiveProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchUnarchiveProposalsResponse actualResponse = client.batchUnarchiveProposals(parent, names);
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
  public void batchUnarchiveProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchUnarchiveProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchPauseProposalsTest() throws Exception {
    BatchPauseProposalsResponse expectedResponse = BatchPauseProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();
    String reason = "reason-934964668";

    BatchPauseProposalsResponse actualResponse = client.batchPauseProposals(parent, names, reason);
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
  public void batchPauseProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      String reason = "reason-934964668";
      client.batchPauseProposals(parent, names, reason);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchPauseProposalsTest2() throws Exception {
    BatchPauseProposalsResponse expectedResponse = BatchPauseProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();
    String reason = "reason-934964668";

    BatchPauseProposalsResponse actualResponse = client.batchPauseProposals(parent, names, reason);
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
  public void batchPauseProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      String reason = "reason-934964668";
      client.batchPauseProposals(parent, names, reason);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchResumeProposalsTest() throws Exception {
    BatchResumeProposalsResponse expectedResponse =
        BatchResumeProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchResumeProposalsResponse actualResponse = client.batchResumeProposals(parent, names);
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
  public void batchResumeProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchResumeProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchResumeProposalsTest2() throws Exception {
    BatchResumeProposalsResponse expectedResponse =
        BatchResumeProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchResumeProposalsResponse actualResponse = client.batchResumeProposals(parent, names);
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
  public void batchResumeProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchResumeProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRequestBuyerReviewProposalsTest() throws Exception {
    BatchRequestBuyerReviewProposalsResponse expectedResponse =
        BatchRequestBuyerReviewProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchRequestBuyerReviewProposalsResponse actualResponse =
        client.batchRequestBuyerReviewProposals(parent, names);
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
  public void batchRequestBuyerReviewProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchRequestBuyerReviewProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRequestBuyerReviewProposalsTest2() throws Exception {
    BatchRequestBuyerReviewProposalsResponse expectedResponse =
        BatchRequestBuyerReviewProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchRequestBuyerReviewProposalsResponse actualResponse =
        client.batchRequestBuyerReviewProposals(parent, names);
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
  public void batchRequestBuyerReviewProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchRequestBuyerReviewProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRequestBuyerAcceptProposalsTest() throws Exception {
    BatchRequestBuyerAcceptProposalsResponse expectedResponse =
        BatchRequestBuyerAcceptProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchRequestBuyerAcceptProposalsResponse actualResponse =
        client.batchRequestBuyerAcceptProposals(parent, names);
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
  public void batchRequestBuyerAcceptProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchRequestBuyerAcceptProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRequestBuyerAcceptProposalsTest2() throws Exception {
    BatchRequestBuyerAcceptProposalsResponse expectedResponse =
        BatchRequestBuyerAcceptProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchRequestBuyerAcceptProposalsResponse actualResponse =
        client.batchRequestBuyerAcceptProposals(parent, names);
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
  public void batchRequestBuyerAcceptProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchRequestBuyerAcceptProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchReserveProposalsTest() throws Exception {
    BatchReserveProposalsResponse expectedResponse =
        BatchReserveProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchReserveProposalsResponse actualResponse = client.batchReserveProposals(parent, names);
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
  public void batchReserveProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchReserveProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchReserveProposalsTest2() throws Exception {
    BatchReserveProposalsResponse expectedResponse =
        BatchReserveProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchReserveProposalsResponse actualResponse = client.batchReserveProposals(parent, names);
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
  public void batchReserveProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchReserveProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRedraftProposalsTest() throws Exception {
    BatchRedraftProposalsResponse expectedResponse =
        BatchRedraftProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchRedraftProposalsResponse actualResponse = client.batchRedraftProposals(parent, names);
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
  public void batchRedraftProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchRedraftProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRedraftProposalsTest2() throws Exception {
    BatchRedraftProposalsResponse expectedResponse =
        BatchRedraftProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchRedraftProposalsResponse actualResponse = client.batchRedraftProposals(parent, names);
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
  public void batchRedraftProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchRedraftProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDiscardDraftProposalsTest() throws Exception {
    BatchDiscardDraftProposalsResponse expectedResponse =
        BatchDiscardDraftProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchDiscardDraftProposalsResponse actualResponse =
        client.batchDiscardDraftProposals(parent, names);
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
  public void batchDiscardDraftProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchDiscardDraftProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDiscardDraftProposalsTest2() throws Exception {
    BatchDiscardDraftProposalsResponse expectedResponse =
        BatchDiscardDraftProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchDiscardDraftProposalsResponse actualResponse =
        client.batchDiscardDraftProposals(parent, names);
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
  public void batchDiscardDraftProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchDiscardDraftProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchTerminateProposalsTest() throws Exception {
    BatchTerminateProposalsResponse expectedResponse =
        BatchTerminateProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchTerminateProposalsResponse actualResponse = client.batchTerminateProposals(parent, names);
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
  public void batchTerminateProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchTerminateProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchTerminateProposalsTest2() throws Exception {
    BatchTerminateProposalsResponse expectedResponse =
        BatchTerminateProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchTerminateProposalsResponse actualResponse = client.batchTerminateProposals(parent, names);
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
  public void batchTerminateProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchTerminateProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchPushToOrderProposalsTest() throws Exception {
    BatchPushToOrderProposalsResponse expectedResponse =
        BatchPushToOrderProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchPushToOrderProposalsResponse actualResponse =
        client.batchPushToOrderProposals(parent, names);
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
  public void batchPushToOrderProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchPushToOrderProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchPushToOrderProposalsTest2() throws Exception {
    BatchPushToOrderProposalsResponse expectedResponse =
        BatchPushToOrderProposalsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchPushToOrderProposalsResponse actualResponse =
        client.batchPushToOrderProposals(parent, names);
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
  public void batchPushToOrderProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchPushToOrderProposals(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchMarketplaceCommentsTest() throws Exception {
    MarketplaceComment responsesElement = MarketplaceComment.newBuilder().build();
    FetchMarketplaceCommentsResponse expectedResponse =
        FetchMarketplaceCommentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMarketplaceComments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    FetchMarketplaceCommentsPagedResponse pagedListResponse =
        client.fetchMarketplaceComments(parent, names);

    List<MarketplaceComment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMarketplaceCommentsList().get(0), resources.get(0));

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
  public void fetchMarketplaceCommentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.fetchMarketplaceComments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchMarketplaceCommentsTest2() throws Exception {
    MarketplaceComment responsesElement = MarketplaceComment.newBuilder().build();
    FetchMarketplaceCommentsResponse expectedResponse =
        FetchMarketplaceCommentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMarketplaceComments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    FetchMarketplaceCommentsPagedResponse pagedListResponse =
        client.fetchMarketplaceComments(parent, names);

    List<MarketplaceComment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMarketplaceCommentsList().get(0), resources.get(0));

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
  public void fetchMarketplaceCommentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.fetchMarketplaceComments(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
