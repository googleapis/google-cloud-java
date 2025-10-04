/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.accounts.v1;

import static com.google.shopping.merchant.accounts.v1.OmnichannelSettingsServiceClient.ListOmnichannelSettingsPagedResponse;

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
import com.google.shopping.merchant.accounts.v1.stub.HttpJsonOmnichannelSettingsServiceStub;
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
public class OmnichannelSettingsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static OmnichannelSettingsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonOmnichannelSettingsServiceStub.getMethodDescriptors(),
            OmnichannelSettingsServiceSettings.getDefaultEndpoint());
    OmnichannelSettingsServiceSettings settings =
        OmnichannelSettingsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                OmnichannelSettingsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OmnichannelSettingsServiceClient.create(settings);
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
  public void getOmnichannelSettingTest() throws Exception {
    OmnichannelSetting expectedResponse =
        OmnichannelSetting.newBuilder()
            .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
            .setRegionCode("regionCode-1991004415")
            .setInStock(InStock.newBuilder().build())
            .setPickup(Pickup.newBuilder().build())
            .setLfpLink(LfpLink.newBuilder().build())
            .setOdo(OnDisplayToOrder.newBuilder().build())
            .setAbout(About.newBuilder().build())
            .setInventoryVerification(InventoryVerification.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    OmnichannelSettingName name = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");

    OmnichannelSetting actualResponse = client.getOmnichannelSetting(name);
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
  public void getOmnichannelSettingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OmnichannelSettingName name = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");
      client.getOmnichannelSetting(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOmnichannelSettingTest2() throws Exception {
    OmnichannelSetting expectedResponse =
        OmnichannelSetting.newBuilder()
            .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
            .setRegionCode("regionCode-1991004415")
            .setInStock(InStock.newBuilder().build())
            .setPickup(Pickup.newBuilder().build())
            .setLfpLink(LfpLink.newBuilder().build())
            .setOdo(OnDisplayToOrder.newBuilder().build())
            .setAbout(About.newBuilder().build())
            .setInventoryVerification(InventoryVerification.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-8661/omnichannelSettings/omnichannelSetting-8661";

    OmnichannelSetting actualResponse = client.getOmnichannelSetting(name);
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
  public void getOmnichannelSettingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-8661/omnichannelSettings/omnichannelSetting-8661";
      client.getOmnichannelSetting(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOmnichannelSettingsTest() throws Exception {
    OmnichannelSetting responsesElement = OmnichannelSetting.newBuilder().build();
    ListOmnichannelSettingsResponse expectedResponse =
        ListOmnichannelSettingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOmnichannelSettings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListOmnichannelSettingsPagedResponse pagedListResponse = client.listOmnichannelSettings(parent);

    List<OmnichannelSetting> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOmnichannelSettingsList().get(0), resources.get(0));

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
  public void listOmnichannelSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listOmnichannelSettings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOmnichannelSettingsTest2() throws Exception {
    OmnichannelSetting responsesElement = OmnichannelSetting.newBuilder().build();
    ListOmnichannelSettingsResponse expectedResponse =
        ListOmnichannelSettingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOmnichannelSettings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListOmnichannelSettingsPagedResponse pagedListResponse = client.listOmnichannelSettings(parent);

    List<OmnichannelSetting> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOmnichannelSettingsList().get(0), resources.get(0));

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
  public void listOmnichannelSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      client.listOmnichannelSettings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOmnichannelSettingTest() throws Exception {
    OmnichannelSetting expectedResponse =
        OmnichannelSetting.newBuilder()
            .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
            .setRegionCode("regionCode-1991004415")
            .setInStock(InStock.newBuilder().build())
            .setPickup(Pickup.newBuilder().build())
            .setLfpLink(LfpLink.newBuilder().build())
            .setOdo(OnDisplayToOrder.newBuilder().build())
            .setAbout(About.newBuilder().build())
            .setInventoryVerification(InventoryVerification.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    OmnichannelSetting omnichannelSetting = OmnichannelSetting.newBuilder().build();

    OmnichannelSetting actualResponse = client.createOmnichannelSetting(parent, omnichannelSetting);
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
  public void createOmnichannelSettingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      OmnichannelSetting omnichannelSetting = OmnichannelSetting.newBuilder().build();
      client.createOmnichannelSetting(parent, omnichannelSetting);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOmnichannelSettingTest2() throws Exception {
    OmnichannelSetting expectedResponse =
        OmnichannelSetting.newBuilder()
            .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
            .setRegionCode("regionCode-1991004415")
            .setInStock(InStock.newBuilder().build())
            .setPickup(Pickup.newBuilder().build())
            .setLfpLink(LfpLink.newBuilder().build())
            .setOdo(OnDisplayToOrder.newBuilder().build())
            .setAbout(About.newBuilder().build())
            .setInventoryVerification(InventoryVerification.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";
    OmnichannelSetting omnichannelSetting = OmnichannelSetting.newBuilder().build();

    OmnichannelSetting actualResponse = client.createOmnichannelSetting(parent, omnichannelSetting);
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
  public void createOmnichannelSettingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      OmnichannelSetting omnichannelSetting = OmnichannelSetting.newBuilder().build();
      client.createOmnichannelSetting(parent, omnichannelSetting);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateOmnichannelSettingTest() throws Exception {
    OmnichannelSetting expectedResponse =
        OmnichannelSetting.newBuilder()
            .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
            .setRegionCode("regionCode-1991004415")
            .setInStock(InStock.newBuilder().build())
            .setPickup(Pickup.newBuilder().build())
            .setLfpLink(LfpLink.newBuilder().build())
            .setOdo(OnDisplayToOrder.newBuilder().build())
            .setAbout(About.newBuilder().build())
            .setInventoryVerification(InventoryVerification.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    OmnichannelSetting omnichannelSetting =
        OmnichannelSetting.newBuilder()
            .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
            .setRegionCode("regionCode-1991004415")
            .setInStock(InStock.newBuilder().build())
            .setPickup(Pickup.newBuilder().build())
            .setLfpLink(LfpLink.newBuilder().build())
            .setOdo(OnDisplayToOrder.newBuilder().build())
            .setAbout(About.newBuilder().build())
            .setInventoryVerification(InventoryVerification.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    OmnichannelSetting actualResponse =
        client.updateOmnichannelSetting(omnichannelSetting, updateMask);
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
  public void updateOmnichannelSettingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OmnichannelSetting omnichannelSetting =
          OmnichannelSetting.newBuilder()
              .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
              .setRegionCode("regionCode-1991004415")
              .setInStock(InStock.newBuilder().build())
              .setPickup(Pickup.newBuilder().build())
              .setLfpLink(LfpLink.newBuilder().build())
              .setOdo(OnDisplayToOrder.newBuilder().build())
              .setAbout(About.newBuilder().build())
              .setInventoryVerification(InventoryVerification.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateOmnichannelSetting(omnichannelSetting, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void requestInventoryVerificationTest() throws Exception {
    RequestInventoryVerificationResponse expectedResponse =
        RequestInventoryVerificationResponse.newBuilder()
            .setOmnichannelSetting(OmnichannelSetting.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    OmnichannelSettingName name = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");

    RequestInventoryVerificationResponse actualResponse = client.requestInventoryVerification(name);
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
  public void requestInventoryVerificationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OmnichannelSettingName name = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");
      client.requestInventoryVerification(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void requestInventoryVerificationTest2() throws Exception {
    RequestInventoryVerificationResponse expectedResponse =
        RequestInventoryVerificationResponse.newBuilder()
            .setOmnichannelSetting(OmnichannelSetting.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-8661/omnichannelSettings/omnichannelSetting-8661";

    RequestInventoryVerificationResponse actualResponse = client.requestInventoryVerification(name);
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
  public void requestInventoryVerificationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-8661/omnichannelSettings/omnichannelSetting-8661";
      client.requestInventoryVerification(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
