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

package com.google.cloud.talent.v4beta1;

import static com.google.cloud.talent.v4beta1.CompanyServiceClient.ListCompaniesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.talent.v4beta1.stub.HttpJsonCompanyServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
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
public class CompanyServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CompanyServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCompanyServiceStub.getMethodDescriptors(),
            CompanyServiceSettings.getDefaultEndpoint());
    CompanyServiceSettings settings =
        CompanyServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CompanyServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CompanyServiceClient.create(settings);
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
  public void createCompanyTest() throws Exception {
    Company expectedResponse =
        Company.newBuilder()
            .setName(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setExternalId("externalId-1699764666")
            .setSize(CompanySize.forNumber(0))
            .setHeadquartersAddress("headquartersAddress555829453")
            .setHiringAgency(true)
            .setEeoText("eeoText-1854750308")
            .setWebsiteUri("websiteUri1317135057")
            .setCareerSiteUri("careerSiteUri2004228935")
            .setImageUri("imageUri-859610607")
            .addAllKeywordSearchableJobCustomAttributes(new ArrayList<String>())
            .setDerivedInfo(Company.DerivedInfo.newBuilder().build())
            .setSuspended(true)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Company company = Company.newBuilder().build();

    Company actualResponse = client.createCompany(parent, company);
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
  public void createCompanyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
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
            .setName(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setExternalId("externalId-1699764666")
            .setSize(CompanySize.forNumber(0))
            .setHeadquartersAddress("headquartersAddress555829453")
            .setHiringAgency(true)
            .setEeoText("eeoText-1854750308")
            .setWebsiteUri("websiteUri1317135057")
            .setCareerSiteUri("careerSiteUri2004228935")
            .setImageUri("imageUri-859610607")
            .addAllKeywordSearchableJobCustomAttributes(new ArrayList<String>())
            .setDerivedInfo(Company.DerivedInfo.newBuilder().build())
            .setSuspended(true)
            .build();
    mockService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    Company company = Company.newBuilder().build();

    Company actualResponse = client.createCompany(parent, company);
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
  public void createCompanyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
  public void createCompanyTest3() throws Exception {
    Company expectedResponse =
        Company.newBuilder()
            .setName(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setExternalId("externalId-1699764666")
            .setSize(CompanySize.forNumber(0))
            .setHeadquartersAddress("headquartersAddress555829453")
            .setHiringAgency(true)
            .setEeoText("eeoText-1854750308")
            .setWebsiteUri("websiteUri1317135057")
            .setCareerSiteUri("careerSiteUri2004228935")
            .setImageUri("imageUri-859610607")
            .addAllKeywordSearchableJobCustomAttributes(new ArrayList<String>())
            .setDerivedInfo(Company.DerivedInfo.newBuilder().build())
            .setSuspended(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8940/tenants/tenant-8940";
    Company company = Company.newBuilder().build();

    Company actualResponse = client.createCompany(parent, company);
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
  public void createCompanyExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8940/tenants/tenant-8940";
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
            .setName(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setExternalId("externalId-1699764666")
            .setSize(CompanySize.forNumber(0))
            .setHeadquartersAddress("headquartersAddress555829453")
            .setHiringAgency(true)
            .setEeoText("eeoText-1854750308")
            .setWebsiteUri("websiteUri1317135057")
            .setCareerSiteUri("careerSiteUri2004228935")
            .setImageUri("imageUri-859610607")
            .addAllKeywordSearchableJobCustomAttributes(new ArrayList<String>())
            .setDerivedInfo(Company.DerivedInfo.newBuilder().build())
            .setSuspended(true)
            .build();
    mockService.addResponse(expectedResponse);

    CompanyName name = CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]");

    Company actualResponse = client.getCompany(name);
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
  public void getCompanyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CompanyName name =
          CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]");
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
            .setName(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setExternalId("externalId-1699764666")
            .setSize(CompanySize.forNumber(0))
            .setHeadquartersAddress("headquartersAddress555829453")
            .setHiringAgency(true)
            .setEeoText("eeoText-1854750308")
            .setWebsiteUri("websiteUri1317135057")
            .setCareerSiteUri("careerSiteUri2004228935")
            .setImageUri("imageUri-859610607")
            .addAllKeywordSearchableJobCustomAttributes(new ArrayList<String>())
            .setDerivedInfo(Company.DerivedInfo.newBuilder().build())
            .setSuspended(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7596/tenants/tenant-7596/companies/companie-7596";

    Company actualResponse = client.getCompany(name);
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
  public void getCompanyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7596/tenants/tenant-7596/companies/companie-7596";
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
            .setName(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setExternalId("externalId-1699764666")
            .setSize(CompanySize.forNumber(0))
            .setHeadquartersAddress("headquartersAddress555829453")
            .setHiringAgency(true)
            .setEeoText("eeoText-1854750308")
            .setWebsiteUri("websiteUri1317135057")
            .setCareerSiteUri("careerSiteUri2004228935")
            .setImageUri("imageUri-859610607")
            .addAllKeywordSearchableJobCustomAttributes(new ArrayList<String>())
            .setDerivedInfo(Company.DerivedInfo.newBuilder().build())
            .setSuspended(true)
            .build();
    mockService.addResponse(expectedResponse);

    Company company =
        Company.newBuilder()
            .setName(
                CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setExternalId("externalId-1699764666")
            .setSize(CompanySize.forNumber(0))
            .setHeadquartersAddress("headquartersAddress555829453")
            .setHiringAgency(true)
            .setEeoText("eeoText-1854750308")
            .setWebsiteUri("websiteUri1317135057")
            .setCareerSiteUri("careerSiteUri2004228935")
            .setImageUri("imageUri-859610607")
            .addAllKeywordSearchableJobCustomAttributes(new ArrayList<String>())
            .setDerivedInfo(Company.DerivedInfo.newBuilder().build())
            .setSuspended(true)
            .build();

    Company actualResponse = client.updateCompany(company);
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
  public void updateCompanyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Company company =
          Company.newBuilder()
              .setName(
                  CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setExternalId("externalId-1699764666")
              .setSize(CompanySize.forNumber(0))
              .setHeadquartersAddress("headquartersAddress555829453")
              .setHiringAgency(true)
              .setEeoText("eeoText-1854750308")
              .setWebsiteUri("websiteUri1317135057")
              .setCareerSiteUri("careerSiteUri2004228935")
              .setImageUri("imageUri-859610607")
              .addAllKeywordSearchableJobCustomAttributes(new ArrayList<String>())
              .setDerivedInfo(Company.DerivedInfo.newBuilder().build())
              .setSuspended(true)
              .build();
      client.updateCompany(company);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCompanyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CompanyName name = CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]");

    client.deleteCompany(name);

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
  public void deleteCompanyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CompanyName name =
          CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]");
      client.deleteCompany(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCompanyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7596/tenants/tenant-7596/companies/companie-7596";

    client.deleteCompany(name);

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
  public void deleteCompanyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7596/tenants/tenant-7596/companies/companie-7596";
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
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListCompaniesPagedResponse pagedListResponse = client.listCompanies(parent);

    List<Company> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCompaniesList().get(0), resources.get(0));

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
  public void listCompaniesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
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
    mockService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");

    ListCompaniesPagedResponse pagedListResponse = client.listCompanies(parent);

    List<Company> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCompaniesList().get(0), resources.get(0));

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
  public void listCompaniesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      client.listCompanies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCompaniesTest3() throws Exception {
    Company responsesElement = Company.newBuilder().build();
    ListCompaniesResponse expectedResponse =
        ListCompaniesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCompanies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8940/tenants/tenant-8940";

    ListCompaniesPagedResponse pagedListResponse = client.listCompanies(parent);

    List<Company> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCompaniesList().get(0), resources.get(0));

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
  public void listCompaniesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8940/tenants/tenant-8940";
      client.listCompanies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
