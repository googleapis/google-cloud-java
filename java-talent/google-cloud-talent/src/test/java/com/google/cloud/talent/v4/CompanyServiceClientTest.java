/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.talent.v4;

import static com.google.cloud.talent.v4.CompanyServiceClient.ListCompaniesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
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
public class CompanyServiceClientTest {
  private static MockCompanyService mockCompanyService;
  private static MockServiceHelper mockServiceHelper;
  private CompanyServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCompanyService = new MockCompanyService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCompanyService));
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
    CompanyServiceSettings settings =
        CompanyServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CompanyServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createCompanyTest() throws Exception {
    Company expectedResponse =
        Company.newBuilder()
            .setName(CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]").toString())
            .setDisplayName("displayName1714148973")
            .setExternalId("externalId-1699764666")
            .setHeadquartersAddress("headquartersAddress555829453")
            .setHiringAgency(true)
            .setEeoText("eeoText-1854750308")
            .setWebsiteUri("websiteUri1317135057")
            .setCareerSiteUri("careerSiteUri2004228935")
            .setImageUri("imageUri-859610607")
            .addAllKeywordSearchableJobCustomAttributes(new ArrayList<String>())
            .setSuspended(true)
            .build();
    mockCompanyService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    Company company = Company.newBuilder().build();

    Company actualResponse = client.createCompany(parent, company);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompanyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCompanyRequest actualRequest = ((CreateCompanyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(company, actualRequest.getCompany());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCompanyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanyService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      Company company = Company.newBuilder().build();
      client.createCompany(parent, company);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCompanyTest2() throws Exception {
    Company expectedResponse =
        Company.newBuilder()
            .setName(CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]").toString())
            .setDisplayName("displayName1714148973")
            .setExternalId("externalId-1699764666")
            .setHeadquartersAddress("headquartersAddress555829453")
            .setHiringAgency(true)
            .setEeoText("eeoText-1854750308")
            .setWebsiteUri("websiteUri1317135057")
            .setCareerSiteUri("careerSiteUri2004228935")
            .setImageUri("imageUri-859610607")
            .addAllKeywordSearchableJobCustomAttributes(new ArrayList<String>())
            .setSuspended(true)
            .build();
    mockCompanyService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Company company = Company.newBuilder().build();

    Company actualResponse = client.createCompany(parent, company);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompanyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCompanyRequest actualRequest = ((CreateCompanyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(company, actualRequest.getCompany());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCompanyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanyService.addException(exception);

    try {
      String parent = "parent-995424086";
      Company company = Company.newBuilder().build();
      client.createCompany(parent, company);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCompanyTest() throws Exception {
    Company expectedResponse =
        Company.newBuilder()
            .setName(CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]").toString())
            .setDisplayName("displayName1714148973")
            .setExternalId("externalId-1699764666")
            .setHeadquartersAddress("headquartersAddress555829453")
            .setHiringAgency(true)
            .setEeoText("eeoText-1854750308")
            .setWebsiteUri("websiteUri1317135057")
            .setCareerSiteUri("careerSiteUri2004228935")
            .setImageUri("imageUri-859610607")
            .addAllKeywordSearchableJobCustomAttributes(new ArrayList<String>())
            .setSuspended(true)
            .build();
    mockCompanyService.addResponse(expectedResponse);

    CompanyName name = CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]");

    Company actualResponse = client.getCompany(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompanyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCompanyRequest actualRequest = ((GetCompanyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCompanyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanyService.addException(exception);

    try {
      CompanyName name = CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]");
      client.getCompany(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCompanyTest2() throws Exception {
    Company expectedResponse =
        Company.newBuilder()
            .setName(CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]").toString())
            .setDisplayName("displayName1714148973")
            .setExternalId("externalId-1699764666")
            .setHeadquartersAddress("headquartersAddress555829453")
            .setHiringAgency(true)
            .setEeoText("eeoText-1854750308")
            .setWebsiteUri("websiteUri1317135057")
            .setCareerSiteUri("careerSiteUri2004228935")
            .setImageUri("imageUri-859610607")
            .addAllKeywordSearchableJobCustomAttributes(new ArrayList<String>())
            .setSuspended(true)
            .build();
    mockCompanyService.addResponse(expectedResponse);

    String name = "name3373707";

    Company actualResponse = client.getCompany(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompanyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCompanyRequest actualRequest = ((GetCompanyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCompanyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanyService.addException(exception);

    try {
      String name = "name3373707";
      client.getCompany(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCompanyTest() throws Exception {
    Company expectedResponse =
        Company.newBuilder()
            .setName(CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]").toString())
            .setDisplayName("displayName1714148973")
            .setExternalId("externalId-1699764666")
            .setHeadquartersAddress("headquartersAddress555829453")
            .setHiringAgency(true)
            .setEeoText("eeoText-1854750308")
            .setWebsiteUri("websiteUri1317135057")
            .setCareerSiteUri("careerSiteUri2004228935")
            .setImageUri("imageUri-859610607")
            .addAllKeywordSearchableJobCustomAttributes(new ArrayList<String>())
            .setSuspended(true)
            .build();
    mockCompanyService.addResponse(expectedResponse);

    Company company = Company.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Company actualResponse = client.updateCompany(company, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompanyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCompanyRequest actualRequest = ((UpdateCompanyRequest) actualRequests.get(0));

    Assert.assertEquals(company, actualRequest.getCompany());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCompanyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanyService.addException(exception);

    try {
      Company company = Company.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCompany(company, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCompanyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCompanyService.addResponse(expectedResponse);

    CompanyName name = CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]");

    client.deleteCompany(name);

    List<AbstractMessage> actualRequests = mockCompanyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCompanyRequest actualRequest = ((DeleteCompanyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCompanyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanyService.addException(exception);

    try {
      CompanyName name = CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]");
      client.deleteCompany(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCompanyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCompanyService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteCompany(name);

    List<AbstractMessage> actualRequests = mockCompanyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCompanyRequest actualRequest = ((DeleteCompanyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCompanyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanyService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCompany(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCompaniesTest() throws Exception {
    Company responsesElement = Company.newBuilder().build();
    ListCompaniesResponse expectedResponse =
        ListCompaniesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCompanies(Arrays.asList(responsesElement))
            .build();
    mockCompanyService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");

    ListCompaniesPagedResponse pagedListResponse = client.listCompanies(parent);

    List<Company> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCompaniesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCompanyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCompaniesRequest actualRequest = ((ListCompaniesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCompaniesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanyService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      client.listCompanies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCompaniesTest2() throws Exception {
    Company responsesElement = Company.newBuilder().build();
    ListCompaniesResponse expectedResponse =
        ListCompaniesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCompanies(Arrays.asList(responsesElement))
            .build();
    mockCompanyService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCompaniesPagedResponse pagedListResponse = client.listCompanies(parent);

    List<Company> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCompaniesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCompanyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCompaniesRequest actualRequest = ((ListCompaniesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCompaniesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanyService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCompanies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
