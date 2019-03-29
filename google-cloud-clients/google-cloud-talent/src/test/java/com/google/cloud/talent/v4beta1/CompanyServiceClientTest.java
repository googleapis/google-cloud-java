/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.talent.v4beta1;

import static com.google.cloud.talent.v4beta1.CompanyServiceClient.ListCompaniesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class CompanyServiceClientTest {
  private static MockApplicationService mockApplicationService;
  private static MockCompanyService mockCompanyService;
  private static MockCompletion mockCompletion;
  private static MockEventService mockEventService;
  private static MockJobService mockJobService;
  private static MockProfileService mockProfileService;
  private static MockTenantService mockTenantService;
  private static MockServiceHelper serviceHelper;
  private CompanyServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockApplicationService = new MockApplicationService();
    mockCompanyService = new MockCompanyService();
    mockCompletion = new MockCompletion();
    mockEventService = new MockEventService();
    mockJobService = new MockJobService();
    mockProfileService = new MockProfileService();
    mockTenantService = new MockTenantService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockApplicationService,
                mockCompanyService,
                mockCompletion,
                mockEventService,
                mockJobService,
                mockProfileService,
                mockTenantService));
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
  @SuppressWarnings("all")
  public void createCompanyTest() {
    CompanyName name = CompanyOldName.of("[PROJECT]", "[COMPANY]");
    String displayName = "displayName1615086568";
    String externalId = "externalId-1153075697";
    String headquartersAddress = "headquartersAddress-1879520036";
    boolean hiringAgency = false;
    String eeoText = "eeoText-1652097123";
    String websiteUri = "websiteUri-2118185016";
    String careerSiteUri = "careerSiteUri1223331861";
    String imageUri = "imageUri-877823864";
    boolean suspended = false;
    Company expectedResponse =
        Company.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setExternalId(externalId)
            .setHeadquartersAddress(headquartersAddress)
            .setHiringAgency(hiringAgency)
            .setEeoText(eeoText)
            .setWebsiteUri(websiteUri)
            .setCareerSiteUri(careerSiteUri)
            .setImageUri(imageUri)
            .setSuspended(suspended)
            .build();
    mockCompanyService.addResponse(expectedResponse);

    TenantOrProjectName parent = TenantName.of("[PROJECT]", "[TENANT]");
    Company company = Company.newBuilder().build();

    Company actualResponse = client.createCompany(parent, company);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockCompanyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCompanyRequest actualRequest = (CreateCompanyRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TenantOrProjectNames.parse(actualRequest.getParent()));
    Assert.assertEquals(company, actualRequest.getCompany());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createCompanyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCompanyService.addException(exception);

    try {
      TenantOrProjectName parent = TenantName.of("[PROJECT]", "[TENANT]");
      Company company = Company.newBuilder().build();

      client.createCompany(parent, company);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getCompanyTest() {
    CompanyName name2 = CompanyOldName.of("[PROJECT]", "[COMPANY]");
    String displayName = "displayName1615086568";
    String externalId = "externalId-1153075697";
    String headquartersAddress = "headquartersAddress-1879520036";
    boolean hiringAgency = false;
    String eeoText = "eeoText-1652097123";
    String websiteUri = "websiteUri-2118185016";
    String careerSiteUri = "careerSiteUri1223331861";
    String imageUri = "imageUri-877823864";
    boolean suspended = false;
    Company expectedResponse =
        Company.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setExternalId(externalId)
            .setHeadquartersAddress(headquartersAddress)
            .setHiringAgency(hiringAgency)
            .setEeoText(eeoText)
            .setWebsiteUri(websiteUri)
            .setCareerSiteUri(careerSiteUri)
            .setImageUri(imageUri)
            .setSuspended(suspended)
            .build();
    mockCompanyService.addResponse(expectedResponse);

    CompanyName name = CompanyOldName.of("[PROJECT]", "[COMPANY]");

    Company actualResponse = client.getCompany(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockCompanyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCompanyRequest actualRequest = (GetCompanyRequest) actualRequests.get(0);

    Assert.assertEquals(name, CompanyNames.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getCompanyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCompanyService.addException(exception);

    try {
      CompanyName name = CompanyOldName.of("[PROJECT]", "[COMPANY]");

      client.getCompany(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateCompanyTest() {
    CompanyName name = CompanyOldName.of("[PROJECT]", "[COMPANY]");
    String displayName = "displayName1615086568";
    String externalId = "externalId-1153075697";
    String headquartersAddress = "headquartersAddress-1879520036";
    boolean hiringAgency = false;
    String eeoText = "eeoText-1652097123";
    String websiteUri = "websiteUri-2118185016";
    String careerSiteUri = "careerSiteUri1223331861";
    String imageUri = "imageUri-877823864";
    boolean suspended = false;
    Company expectedResponse =
        Company.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setExternalId(externalId)
            .setHeadquartersAddress(headquartersAddress)
            .setHiringAgency(hiringAgency)
            .setEeoText(eeoText)
            .setWebsiteUri(websiteUri)
            .setCareerSiteUri(careerSiteUri)
            .setImageUri(imageUri)
            .setSuspended(suspended)
            .build();
    mockCompanyService.addResponse(expectedResponse);

    Company company = Company.newBuilder().build();

    Company actualResponse = client.updateCompany(company);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockCompanyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCompanyRequest actualRequest = (UpdateCompanyRequest) actualRequests.get(0);

    Assert.assertEquals(company, actualRequest.getCompany());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateCompanyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCompanyService.addException(exception);

    try {
      Company company = Company.newBuilder().build();

      client.updateCompany(company);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteCompanyTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCompanyService.addResponse(expectedResponse);

    CompanyName name = CompanyOldName.of("[PROJECT]", "[COMPANY]");

    client.deleteCompany(name);

    List<GeneratedMessageV3> actualRequests = mockCompanyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCompanyRequest actualRequest = (DeleteCompanyRequest) actualRequests.get(0);

    Assert.assertEquals(name, CompanyNames.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteCompanyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCompanyService.addException(exception);

    try {
      CompanyName name = CompanyOldName.of("[PROJECT]", "[COMPANY]");

      client.deleteCompany(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listCompaniesTest() {
    String nextPageToken = "";
    Company companiesElement = Company.newBuilder().build();
    List<Company> companies = Arrays.asList(companiesElement);
    ListCompaniesResponse expectedResponse =
        ListCompaniesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllCompanies(companies)
            .build();
    mockCompanyService.addResponse(expectedResponse);

    TenantOrProjectName parent = TenantName.of("[PROJECT]", "[TENANT]");

    ListCompaniesPagedResponse pagedListResponse = client.listCompanies(parent);

    List<Company> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCompaniesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockCompanyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCompaniesRequest actualRequest = (ListCompaniesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TenantOrProjectNames.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listCompaniesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCompanyService.addException(exception);

    try {
      TenantOrProjectName parent = TenantName.of("[PROJECT]", "[TENANT]");

      client.listCompanies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
