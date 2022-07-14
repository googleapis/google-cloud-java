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

package com.google.cloud.resourcesettings.v1;

import static com.google.cloud.resourcesettings.v1.ResourceSettingsServiceClient.ListSettingsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.resourcesettings.v1.stub.HttpJsonResourceSettingsServiceStub;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ResourceSettingsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ResourceSettingsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonResourceSettingsServiceStub.getMethodDescriptors(),
            ResourceSettingsServiceSettings.getDefaultEndpoint());
    ResourceSettingsServiceSettings settings =
        ResourceSettingsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ResourceSettingsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ResourceSettingsServiceClient.create(settings);
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
  public void listSettingsTest() throws Exception {
    Setting responsesElement = Setting.newBuilder().build();
    ListSettingsResponse expectedResponse =
        ListSettingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSettings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ResourceName parent =
        new ResourceName() {
          @Override
          public Map<String, String> getFieldValuesMap() {
            Map<String, String> fieldValuesMap = new HashMap<>();
            fieldValuesMap.put("parent", "organizations/organization-8287");
            return fieldValuesMap;
          }

          @Override
          public String getFieldValue(String fieldName) {
            return getFieldValuesMap().get(fieldName);
          }

          @Override
          public String toString() {
            return "organizations/organization-8287";
          }
        };

    ListSettingsPagedResponse pagedListResponse = client.listSettings(parent);

    List<Setting> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSettingsList().get(0), resources.get(0));

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
  public void listSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceName parent =
          new ResourceName() {
            @Override
            public Map<String, String> getFieldValuesMap() {
              Map<String, String> fieldValuesMap = new HashMap<>();
              fieldValuesMap.put("parent", "organizations/organization-8287");
              return fieldValuesMap;
            }

            @Override
            public String getFieldValue(String fieldName) {
              return getFieldValuesMap().get(fieldName);
            }

            @Override
            public String toString() {
              return "organizations/organization-8287";
            }
          };
      client.listSettings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSettingsTest2() throws Exception {
    Setting responsesElement = Setting.newBuilder().build();
    ListSettingsResponse expectedResponse =
        ListSettingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSettings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-8287";

    ListSettingsPagedResponse pagedListResponse = client.listSettings(parent);

    List<Setting> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSettingsList().get(0), resources.get(0));

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
  public void listSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-8287";
      client.listSettings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSettingTest() throws Exception {
    Setting expectedResponse =
        Setting.newBuilder()
            .setName(
                SettingName.ofOrganizationSettingNameName("[ORGANIZATION]", "[SETTING_NAME]")
                    .toString())
            .setMetadata(SettingMetadata.newBuilder().build())
            .setLocalValue(Value.newBuilder().build())
            .setEffectiveValue(Value.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    SettingName name =
        SettingName.ofOrganizationSettingNameName("[ORGANIZATION]", "[SETTING_NAME]");

    Setting actualResponse = client.getSetting(name);
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
  public void getSettingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SettingName name =
          SettingName.ofOrganizationSettingNameName("[ORGANIZATION]", "[SETTING_NAME]");
      client.getSetting(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSettingTest2() throws Exception {
    Setting expectedResponse =
        Setting.newBuilder()
            .setName(
                SettingName.ofOrganizationSettingNameName("[ORGANIZATION]", "[SETTING_NAME]")
                    .toString())
            .setMetadata(SettingMetadata.newBuilder().build())
            .setLocalValue(Value.newBuilder().build())
            .setEffectiveValue(Value.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-4339/settings/setting-4339";

    Setting actualResponse = client.getSetting(name);
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
  public void getSettingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-4339/settings/setting-4339";
      client.getSetting(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSettingTest() throws Exception {
    Setting expectedResponse =
        Setting.newBuilder()
            .setName(
                SettingName.ofOrganizationSettingNameName("[ORGANIZATION]", "[SETTING_NAME]")
                    .toString())
            .setMetadata(SettingMetadata.newBuilder().build())
            .setLocalValue(Value.newBuilder().build())
            .setEffectiveValue(Value.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    UpdateSettingRequest request =
        UpdateSettingRequest.newBuilder()
            .setSetting(
                Setting.newBuilder()
                    .setName(
                        SettingName.ofProjectNumberSettingNameName(
                                "[PROJECT_NUMBER]", "[SETTING_NAME]")
                            .toString())
                    .setMetadata(SettingMetadata.newBuilder().build())
                    .setLocalValue(Value.newBuilder().build())
                    .setEffectiveValue(Value.newBuilder().build())
                    .setEtag("etag3123477")
                    .build())
            .build();

    Setting actualResponse = client.updateSetting(request);
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
  public void updateSettingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateSettingRequest request =
          UpdateSettingRequest.newBuilder()
              .setSetting(
                  Setting.newBuilder()
                      .setName(
                          SettingName.ofProjectNumberSettingNameName(
                                  "[PROJECT_NUMBER]", "[SETTING_NAME]")
                              .toString())
                      .setMetadata(SettingMetadata.newBuilder().build())
                      .setLocalValue(Value.newBuilder().build())
                      .setEffectiveValue(Value.newBuilder().build())
                      .setEtag("etag3123477")
                      .build())
              .build();
      client.updateSetting(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
