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

import static com.google.ads.admanager.v1.PartnerServiceClient.ListPartnersPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonPartnerServiceStub;
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
public class PartnerServiceClientTest {
  private static MockHttpService mockService;
  private static PartnerServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPartnerServiceStub.getMethodDescriptors(),
            PartnerServiceSettings.getDefaultEndpoint());
    PartnerServiceSettings settings =
        PartnerServiceSettings.newBuilder()
            .setTransportChannelProvider(
                PartnerServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PartnerServiceClient.create(settings);
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
  public void getPartnerTest() throws Exception {
    Partner expectedResponse =
        Partner.newBuilder()
            .setName(PartnerName.of("[NETWORK_CODE]", "[PARTNER]").toString())
            .setDisplayName("displayName1714148973")
            .setAddress("address-1147692044")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setPhone("phone106642798")
            .setExternalId("externalId-1699764666")
            .setComment("comment950398559")
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .setPrimaryContact(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .addAllAppliedTeams(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PartnerName name = PartnerName.of("[NETWORK_CODE]", "[PARTNER]");

    Partner actualResponse = client.getPartner(name);
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
  public void getPartnerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PartnerName name = PartnerName.of("[NETWORK_CODE]", "[PARTNER]");
      client.getPartner(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPartnerTest2() throws Exception {
    Partner expectedResponse =
        Partner.newBuilder()
            .setName(PartnerName.of("[NETWORK_CODE]", "[PARTNER]").toString())
            .setDisplayName("displayName1714148973")
            .setAddress("address-1147692044")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setPhone("phone106642798")
            .setExternalId("externalId-1699764666")
            .setComment("comment950398559")
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .setPrimaryContact(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .addAllAppliedTeams(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-9930/partners/partner-9930";

    Partner actualResponse = client.getPartner(name);
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
  public void getPartnerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-9930/partners/partner-9930";
      client.getPartner(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPartnersTest() throws Exception {
    Partner responsesElement = Partner.newBuilder().build();
    ListPartnersResponse expectedResponse =
        ListPartnersResponse.newBuilder()
            .setNextPageToken("")
            .addAllPartners(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListPartnersPagedResponse pagedListResponse = client.listPartners(parent);

    List<Partner> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPartnersList().get(0), resources.get(0));

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
  public void listPartnersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listPartners(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPartnersTest2() throws Exception {
    Partner responsesElement = Partner.newBuilder().build();
    ListPartnersResponse expectedResponse =
        ListPartnersResponse.newBuilder()
            .setNextPageToken("")
            .addAllPartners(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListPartnersPagedResponse pagedListResponse = client.listPartners(parent);

    List<Partner> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPartnersList().get(0), resources.get(0));

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
  public void listPartnersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listPartners(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePartnerTest() throws Exception {
    Partner expectedResponse =
        Partner.newBuilder()
            .setName(PartnerName.of("[NETWORK_CODE]", "[PARTNER]").toString())
            .setDisplayName("displayName1714148973")
            .setAddress("address-1147692044")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setPhone("phone106642798")
            .setExternalId("externalId-1699764666")
            .setComment("comment950398559")
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .setPrimaryContact(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .addAllAppliedTeams(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Partner partner =
        Partner.newBuilder()
            .setName(PartnerName.of("[NETWORK_CODE]", "[PARTNER]").toString())
            .setDisplayName("displayName1714148973")
            .setAddress("address-1147692044")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setPhone("phone106642798")
            .setExternalId("externalId-1699764666")
            .setComment("comment950398559")
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .setPrimaryContact(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .addAllAppliedTeams(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Partner actualResponse = client.updatePartner(partner, updateMask);
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
  public void updatePartnerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Partner partner =
          Partner.newBuilder()
              .setName(PartnerName.of("[NETWORK_CODE]", "[PARTNER]").toString())
              .setDisplayName("displayName1714148973")
              .setAddress("address-1147692044")
              .setEmail("email96619420")
              .setFax("fax101149")
              .setPhone("phone106642798")
              .setExternalId("externalId-1699764666")
              .setComment("comment950398559")
              .addAllAppliedLabels(new ArrayList<AppliedLabel>())
              .setPrimaryContact(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
              .addAllAppliedTeams(new ArrayList<String>())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePartner(partner, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdatePartnersTest() throws Exception {
    BatchUpdatePartnersResponse expectedResponse =
        BatchUpdatePartnersResponse.newBuilder().addAllPartners(new ArrayList<Partner>()).build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdatePartnerRequest> requests = new ArrayList<>();

    BatchUpdatePartnersResponse actualResponse = client.batchUpdatePartners(parent, requests);
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
  public void batchUpdatePartnersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdatePartnerRequest> requests = new ArrayList<>();
      client.batchUpdatePartners(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdatePartnersTest2() throws Exception {
    BatchUpdatePartnersResponse expectedResponse =
        BatchUpdatePartnersResponse.newBuilder().addAllPartners(new ArrayList<Partner>()).build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdatePartnerRequest> requests = new ArrayList<>();

    BatchUpdatePartnersResponse actualResponse = client.batchUpdatePartners(parent, requests);
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
  public void batchUpdatePartnersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdatePartnerRequest> requests = new ArrayList<>();
      client.batchUpdatePartners(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
