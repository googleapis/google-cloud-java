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

package com.google.cloud.discoveryengine.v1beta;

import static com.google.cloud.discoveryengine.v1beta.LicenseConfigServiceClient.ListLicenseConfigsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1beta.stub.HttpJsonLicenseConfigServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.FieldMask;
import com.google.type.Date;
import java.io.IOException;
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
public class LicenseConfigServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static LicenseConfigServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLicenseConfigServiceStub.getMethodDescriptors(),
            LicenseConfigServiceSettings.getDefaultEndpoint());
    LicenseConfigServiceSettings settings =
        LicenseConfigServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                LicenseConfigServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LicenseConfigServiceClient.create(settings);
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
  public void createLicenseConfigTest() throws Exception {
    LicenseConfig expectedResponse =
        LicenseConfig.newBuilder()
            .setName(LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
            .setLicenseCount(-1565113455)
            .setSubscriptionTier(SubscriptionTier.forNumber(0))
            .setAutoRenew(true)
            .setStartDate(Date.newBuilder().build())
            .setEndDate(Date.newBuilder().build())
            .setSubscriptionTerm(SubscriptionTerm.forNumber(0))
            .setFreeTrial(true)
            .setGeminiBundle(true)
            .setEarlyTerminated(true)
            .setEarlyTerminationDate(Date.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    LicenseConfig licenseConfig = LicenseConfig.newBuilder().build();
    String licenseConfigId = "licenseConfigId-372057250";

    LicenseConfig actualResponse =
        client.createLicenseConfig(parent, licenseConfig, licenseConfigId);
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
  public void createLicenseConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      LicenseConfig licenseConfig = LicenseConfig.newBuilder().build();
      String licenseConfigId = "licenseConfigId-372057250";
      client.createLicenseConfig(parent, licenseConfig, licenseConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLicenseConfigTest2() throws Exception {
    LicenseConfig expectedResponse =
        LicenseConfig.newBuilder()
            .setName(LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
            .setLicenseCount(-1565113455)
            .setSubscriptionTier(SubscriptionTier.forNumber(0))
            .setAutoRenew(true)
            .setStartDate(Date.newBuilder().build())
            .setEndDate(Date.newBuilder().build())
            .setSubscriptionTerm(SubscriptionTerm.forNumber(0))
            .setFreeTrial(true)
            .setGeminiBundle(true)
            .setEarlyTerminated(true)
            .setEarlyTerminationDate(Date.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    LicenseConfig licenseConfig = LicenseConfig.newBuilder().build();
    String licenseConfigId = "licenseConfigId-372057250";

    LicenseConfig actualResponse =
        client.createLicenseConfig(parent, licenseConfig, licenseConfigId);
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
  public void createLicenseConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      LicenseConfig licenseConfig = LicenseConfig.newBuilder().build();
      String licenseConfigId = "licenseConfigId-372057250";
      client.createLicenseConfig(parent, licenseConfig, licenseConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateLicenseConfigTest() throws Exception {
    LicenseConfig expectedResponse =
        LicenseConfig.newBuilder()
            .setName(LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
            .setLicenseCount(-1565113455)
            .setSubscriptionTier(SubscriptionTier.forNumber(0))
            .setAutoRenew(true)
            .setStartDate(Date.newBuilder().build())
            .setEndDate(Date.newBuilder().build())
            .setSubscriptionTerm(SubscriptionTerm.forNumber(0))
            .setFreeTrial(true)
            .setGeminiBundle(true)
            .setEarlyTerminated(true)
            .setEarlyTerminationDate(Date.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LicenseConfig licenseConfig =
        LicenseConfig.newBuilder()
            .setName(LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
            .setLicenseCount(-1565113455)
            .setSubscriptionTier(SubscriptionTier.forNumber(0))
            .setAutoRenew(true)
            .setStartDate(Date.newBuilder().build())
            .setEndDate(Date.newBuilder().build())
            .setSubscriptionTerm(SubscriptionTerm.forNumber(0))
            .setFreeTrial(true)
            .setGeminiBundle(true)
            .setEarlyTerminated(true)
            .setEarlyTerminationDate(Date.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LicenseConfig actualResponse = client.updateLicenseConfig(licenseConfig, updateMask);
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
  public void updateLicenseConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LicenseConfig licenseConfig =
          LicenseConfig.newBuilder()
              .setName(
                  LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
              .setLicenseCount(-1565113455)
              .setSubscriptionTier(SubscriptionTier.forNumber(0))
              .setAutoRenew(true)
              .setStartDate(Date.newBuilder().build())
              .setEndDate(Date.newBuilder().build())
              .setSubscriptionTerm(SubscriptionTerm.forNumber(0))
              .setFreeTrial(true)
              .setGeminiBundle(true)
              .setEarlyTerminated(true)
              .setEarlyTerminationDate(Date.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateLicenseConfig(licenseConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLicenseConfigTest() throws Exception {
    LicenseConfig expectedResponse =
        LicenseConfig.newBuilder()
            .setName(LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
            .setLicenseCount(-1565113455)
            .setSubscriptionTier(SubscriptionTier.forNumber(0))
            .setAutoRenew(true)
            .setStartDate(Date.newBuilder().build())
            .setEndDate(Date.newBuilder().build())
            .setSubscriptionTerm(SubscriptionTerm.forNumber(0))
            .setFreeTrial(true)
            .setGeminiBundle(true)
            .setEarlyTerminated(true)
            .setEarlyTerminationDate(Date.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LicenseConfigName name = LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]");

    LicenseConfig actualResponse = client.getLicenseConfig(name);
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
  public void getLicenseConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LicenseConfigName name = LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]");
      client.getLicenseConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLicenseConfigTest2() throws Exception {
    LicenseConfig expectedResponse =
        LicenseConfig.newBuilder()
            .setName(LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
            .setLicenseCount(-1565113455)
            .setSubscriptionTier(SubscriptionTier.forNumber(0))
            .setAutoRenew(true)
            .setStartDate(Date.newBuilder().build())
            .setEndDate(Date.newBuilder().build())
            .setSubscriptionTerm(SubscriptionTerm.forNumber(0))
            .setFreeTrial(true)
            .setGeminiBundle(true)
            .setEarlyTerminated(true)
            .setEarlyTerminationDate(Date.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9552/locations/location-9552/licenseConfigs/licenseConfig-9552";

    LicenseConfig actualResponse = client.getLicenseConfig(name);
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
  public void getLicenseConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9552/locations/location-9552/licenseConfigs/licenseConfig-9552";
      client.getLicenseConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLicenseConfigsTest() throws Exception {
    LicenseConfig responsesElement = LicenseConfig.newBuilder().build();
    ListLicenseConfigsResponse expectedResponse =
        ListLicenseConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLicenseConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListLicenseConfigsPagedResponse pagedListResponse = client.listLicenseConfigs(parent);

    List<LicenseConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLicenseConfigsList().get(0), resources.get(0));

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
  public void listLicenseConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listLicenseConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLicenseConfigsTest2() throws Exception {
    LicenseConfig responsesElement = LicenseConfig.newBuilder().build();
    ListLicenseConfigsResponse expectedResponse =
        ListLicenseConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLicenseConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListLicenseConfigsPagedResponse pagedListResponse = client.listLicenseConfigs(parent);

    List<LicenseConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLicenseConfigsList().get(0), resources.get(0));

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
  public void listLicenseConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listLicenseConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void distributeLicenseConfigTest() throws Exception {
    DistributeLicenseConfigResponse expectedResponse =
        DistributeLicenseConfigResponse.newBuilder()
            .setLicenseConfig(LicenseConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    BillingAccountLicenseConfigName billingAccountLicenseConfig =
        BillingAccountLicenseConfigName.of("[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]");
    long projectNumber = 828084015;
    String location = "location1901043637";
    long licenseCount = -1565113455;
    String licenseConfigId = "licenseConfigId-372057250";

    DistributeLicenseConfigResponse actualResponse =
        client.distributeLicenseConfig(
            billingAccountLicenseConfig, projectNumber, location, licenseCount, licenseConfigId);
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
  public void distributeLicenseConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BillingAccountLicenseConfigName billingAccountLicenseConfig =
          BillingAccountLicenseConfigName.of(
              "[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]");
      long projectNumber = 828084015;
      String location = "location1901043637";
      long licenseCount = -1565113455;
      String licenseConfigId = "licenseConfigId-372057250";
      client.distributeLicenseConfig(
          billingAccountLicenseConfig, projectNumber, location, licenseCount, licenseConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void distributeLicenseConfigTest2() throws Exception {
    DistributeLicenseConfigResponse expectedResponse =
        DistributeLicenseConfigResponse.newBuilder()
            .setLicenseConfig(LicenseConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String billingAccountLicenseConfig =
        "billingAccounts/billingAccount-511/billingAccountLicenseConfigs/billingAccountLicenseConfig-511";
    long projectNumber = 828084015;
    String location = "location1901043637";
    long licenseCount = -1565113455;
    String licenseConfigId = "licenseConfigId-372057250";

    DistributeLicenseConfigResponse actualResponse =
        client.distributeLicenseConfig(
            billingAccountLicenseConfig, projectNumber, location, licenseCount, licenseConfigId);
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
  public void distributeLicenseConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String billingAccountLicenseConfig =
          "billingAccounts/billingAccount-511/billingAccountLicenseConfigs/billingAccountLicenseConfig-511";
      long projectNumber = 828084015;
      String location = "location1901043637";
      long licenseCount = -1565113455;
      String licenseConfigId = "licenseConfigId-372057250";
      client.distributeLicenseConfig(
          billingAccountLicenseConfig, projectNumber, location, licenseCount, licenseConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retractLicenseConfigTest() throws Exception {
    RetractLicenseConfigResponse expectedResponse =
        RetractLicenseConfigResponse.newBuilder()
            .setLicenseConfig(LicenseConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    BillingAccountLicenseConfigName billingAccountLicenseConfig =
        BillingAccountLicenseConfigName.of("[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]");
    LicenseConfigName licenseConfig =
        LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]");
    boolean fullRetract = true;
    long licenseCount = -1565113455;

    RetractLicenseConfigResponse actualResponse =
        client.retractLicenseConfig(
            billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
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
  public void retractLicenseConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BillingAccountLicenseConfigName billingAccountLicenseConfig =
          BillingAccountLicenseConfigName.of(
              "[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]");
      LicenseConfigName licenseConfig =
          LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]");
      boolean fullRetract = true;
      long licenseCount = -1565113455;
      client.retractLicenseConfig(
          billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retractLicenseConfigTest2() throws Exception {
    RetractLicenseConfigResponse expectedResponse =
        RetractLicenseConfigResponse.newBuilder()
            .setLicenseConfig(LicenseConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    BillingAccountLicenseConfigName billingAccountLicenseConfig =
        BillingAccountLicenseConfigName.of("[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]");
    String licenseConfig = "licenseConfig1939275491";
    boolean fullRetract = true;
    long licenseCount = -1565113455;

    RetractLicenseConfigResponse actualResponse =
        client.retractLicenseConfig(
            billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
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
  public void retractLicenseConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BillingAccountLicenseConfigName billingAccountLicenseConfig =
          BillingAccountLicenseConfigName.of(
              "[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]");
      String licenseConfig = "licenseConfig1939275491";
      boolean fullRetract = true;
      long licenseCount = -1565113455;
      client.retractLicenseConfig(
          billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retractLicenseConfigTest3() throws Exception {
    RetractLicenseConfigResponse expectedResponse =
        RetractLicenseConfigResponse.newBuilder()
            .setLicenseConfig(LicenseConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String billingAccountLicenseConfig =
        "billingAccounts/billingAccount-511/billingAccountLicenseConfigs/billingAccountLicenseConfig-511";
    LicenseConfigName licenseConfig =
        LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]");
    boolean fullRetract = true;
    long licenseCount = -1565113455;

    RetractLicenseConfigResponse actualResponse =
        client.retractLicenseConfig(
            billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
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
  public void retractLicenseConfigExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String billingAccountLicenseConfig =
          "billingAccounts/billingAccount-511/billingAccountLicenseConfigs/billingAccountLicenseConfig-511";
      LicenseConfigName licenseConfig =
          LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]");
      boolean fullRetract = true;
      long licenseCount = -1565113455;
      client.retractLicenseConfig(
          billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retractLicenseConfigTest4() throws Exception {
    RetractLicenseConfigResponse expectedResponse =
        RetractLicenseConfigResponse.newBuilder()
            .setLicenseConfig(LicenseConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String billingAccountLicenseConfig =
        "billingAccounts/billingAccount-511/billingAccountLicenseConfigs/billingAccountLicenseConfig-511";
    String licenseConfig = "licenseConfig1939275491";
    boolean fullRetract = true;
    long licenseCount = -1565113455;

    RetractLicenseConfigResponse actualResponse =
        client.retractLicenseConfig(
            billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
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
  public void retractLicenseConfigExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String billingAccountLicenseConfig =
          "billingAccounts/billingAccount-511/billingAccountLicenseConfigs/billingAccountLicenseConfig-511";
      String licenseConfig = "licenseConfig1939275491";
      boolean fullRetract = true;
      long licenseCount = -1565113455;
      client.retractLicenseConfig(
          billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
