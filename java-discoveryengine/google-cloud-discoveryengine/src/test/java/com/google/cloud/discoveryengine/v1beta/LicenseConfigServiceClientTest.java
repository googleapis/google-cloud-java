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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
import com.google.type.Date;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class LicenseConfigServiceClientTest {
  private static MockLicenseConfigService mockLicenseConfigService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LicenseConfigServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLicenseConfigService = new MockLicenseConfigService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockLicenseConfigService, mockLocations));
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
    LicenseConfigServiceSettings settings =
        LicenseConfigServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LicenseConfigServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockLicenseConfigService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    LicenseConfig licenseConfig = LicenseConfig.newBuilder().build();
    String licenseConfigId = "licenseConfigId-372057250";

    LicenseConfig actualResponse =
        client.createLicenseConfig(parent, licenseConfig, licenseConfigId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLicenseConfigRequest actualRequest = ((CreateLicenseConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(licenseConfig, actualRequest.getLicenseConfig());
    Assert.assertEquals(licenseConfigId, actualRequest.getLicenseConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLicenseConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseConfigService.addException(exception);

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
    mockLicenseConfigService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    LicenseConfig licenseConfig = LicenseConfig.newBuilder().build();
    String licenseConfigId = "licenseConfigId-372057250";

    LicenseConfig actualResponse =
        client.createLicenseConfig(parent, licenseConfig, licenseConfigId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLicenseConfigRequest actualRequest = ((CreateLicenseConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(licenseConfig, actualRequest.getLicenseConfig());
    Assert.assertEquals(licenseConfigId, actualRequest.getLicenseConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLicenseConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseConfigService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockLicenseConfigService.addResponse(expectedResponse);

    LicenseConfig licenseConfig = LicenseConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LicenseConfig actualResponse = client.updateLicenseConfig(licenseConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateLicenseConfigRequest actualRequest = ((UpdateLicenseConfigRequest) actualRequests.get(0));

    Assert.assertEquals(licenseConfig, actualRequest.getLicenseConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateLicenseConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseConfigService.addException(exception);

    try {
      LicenseConfig licenseConfig = LicenseConfig.newBuilder().build();
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
    mockLicenseConfigService.addResponse(expectedResponse);

    LicenseConfigName name = LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]");

    LicenseConfig actualResponse = client.getLicenseConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLicenseConfigRequest actualRequest = ((GetLicenseConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLicenseConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseConfigService.addException(exception);

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
    mockLicenseConfigService.addResponse(expectedResponse);

    String name = "name3373707";

    LicenseConfig actualResponse = client.getLicenseConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLicenseConfigRequest actualRequest = ((GetLicenseConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLicenseConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseConfigService.addException(exception);

    try {
      String name = "name3373707";
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
    mockLicenseConfigService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListLicenseConfigsPagedResponse pagedListResponse = client.listLicenseConfigs(parent);

    List<LicenseConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLicenseConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLicenseConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLicenseConfigsRequest actualRequest = ((ListLicenseConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLicenseConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseConfigService.addException(exception);

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
    mockLicenseConfigService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLicenseConfigsPagedResponse pagedListResponse = client.listLicenseConfigs(parent);

    List<LicenseConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLicenseConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLicenseConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLicenseConfigsRequest actualRequest = ((ListLicenseConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLicenseConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseConfigService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockLicenseConfigService.addResponse(expectedResponse);

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

    List<AbstractMessage> actualRequests = mockLicenseConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DistributeLicenseConfigRequest actualRequest =
        ((DistributeLicenseConfigRequest) actualRequests.get(0));

    Assert.assertEquals(
        billingAccountLicenseConfig.toString(), actualRequest.getBillingAccountLicenseConfig());
    Assert.assertEquals(projectNumber, actualRequest.getProjectNumber());
    Assert.assertEquals(location, actualRequest.getLocation());
    Assert.assertEquals(licenseCount, actualRequest.getLicenseCount());
    Assert.assertEquals(licenseConfigId, actualRequest.getLicenseConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void distributeLicenseConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseConfigService.addException(exception);

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
    mockLicenseConfigService.addResponse(expectedResponse);

    String billingAccountLicenseConfig = "billingAccountLicenseConfig474063057";
    long projectNumber = 828084015;
    String location = "location1901043637";
    long licenseCount = -1565113455;
    String licenseConfigId = "licenseConfigId-372057250";

    DistributeLicenseConfigResponse actualResponse =
        client.distributeLicenseConfig(
            billingAccountLicenseConfig, projectNumber, location, licenseCount, licenseConfigId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DistributeLicenseConfigRequest actualRequest =
        ((DistributeLicenseConfigRequest) actualRequests.get(0));

    Assert.assertEquals(
        billingAccountLicenseConfig, actualRequest.getBillingAccountLicenseConfig());
    Assert.assertEquals(projectNumber, actualRequest.getProjectNumber());
    Assert.assertEquals(location, actualRequest.getLocation());
    Assert.assertEquals(licenseCount, actualRequest.getLicenseCount());
    Assert.assertEquals(licenseConfigId, actualRequest.getLicenseConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void distributeLicenseConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseConfigService.addException(exception);

    try {
      String billingAccountLicenseConfig = "billingAccountLicenseConfig474063057";
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
    mockLicenseConfigService.addResponse(expectedResponse);

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

    List<AbstractMessage> actualRequests = mockLicenseConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetractLicenseConfigRequest actualRequest =
        ((RetractLicenseConfigRequest) actualRequests.get(0));

    Assert.assertEquals(
        billingAccountLicenseConfig.toString(), actualRequest.getBillingAccountLicenseConfig());
    Assert.assertEquals(licenseConfig.toString(), actualRequest.getLicenseConfig());
    Assert.assertEquals(fullRetract, actualRequest.getFullRetract());
    Assert.assertEquals(licenseCount, actualRequest.getLicenseCount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retractLicenseConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseConfigService.addException(exception);

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
    mockLicenseConfigService.addResponse(expectedResponse);

    BillingAccountLicenseConfigName billingAccountLicenseConfig =
        BillingAccountLicenseConfigName.of("[BILLING_ACCOUNT]", "[BILLING_ACCOUNT_LICENSE_CONFIG]");
    String licenseConfig = "licenseConfig1939275491";
    boolean fullRetract = true;
    long licenseCount = -1565113455;

    RetractLicenseConfigResponse actualResponse =
        client.retractLicenseConfig(
            billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetractLicenseConfigRequest actualRequest =
        ((RetractLicenseConfigRequest) actualRequests.get(0));

    Assert.assertEquals(
        billingAccountLicenseConfig.toString(), actualRequest.getBillingAccountLicenseConfig());
    Assert.assertEquals(licenseConfig, actualRequest.getLicenseConfig());
    Assert.assertEquals(fullRetract, actualRequest.getFullRetract());
    Assert.assertEquals(licenseCount, actualRequest.getLicenseCount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retractLicenseConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseConfigService.addException(exception);

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
    mockLicenseConfigService.addResponse(expectedResponse);

    String billingAccountLicenseConfig = "billingAccountLicenseConfig474063057";
    LicenseConfigName licenseConfig =
        LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]");
    boolean fullRetract = true;
    long licenseCount = -1565113455;

    RetractLicenseConfigResponse actualResponse =
        client.retractLicenseConfig(
            billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetractLicenseConfigRequest actualRequest =
        ((RetractLicenseConfigRequest) actualRequests.get(0));

    Assert.assertEquals(
        billingAccountLicenseConfig, actualRequest.getBillingAccountLicenseConfig());
    Assert.assertEquals(licenseConfig.toString(), actualRequest.getLicenseConfig());
    Assert.assertEquals(fullRetract, actualRequest.getFullRetract());
    Assert.assertEquals(licenseCount, actualRequest.getLicenseCount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retractLicenseConfigExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseConfigService.addException(exception);

    try {
      String billingAccountLicenseConfig = "billingAccountLicenseConfig474063057";
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
    mockLicenseConfigService.addResponse(expectedResponse);

    String billingAccountLicenseConfig = "billingAccountLicenseConfig474063057";
    String licenseConfig = "licenseConfig1939275491";
    boolean fullRetract = true;
    long licenseCount = -1565113455;

    RetractLicenseConfigResponse actualResponse =
        client.retractLicenseConfig(
            billingAccountLicenseConfig, licenseConfig, fullRetract, licenseCount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetractLicenseConfigRequest actualRequest =
        ((RetractLicenseConfigRequest) actualRequests.get(0));

    Assert.assertEquals(
        billingAccountLicenseConfig, actualRequest.getBillingAccountLicenseConfig());
    Assert.assertEquals(licenseConfig, actualRequest.getLicenseConfig());
    Assert.assertEquals(fullRetract, actualRequest.getFullRetract());
    Assert.assertEquals(licenseCount, actualRequest.getLicenseCount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retractLicenseConfigExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseConfigService.addException(exception);

    try {
      String billingAccountLicenseConfig = "billingAccountLicenseConfig474063057";
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
