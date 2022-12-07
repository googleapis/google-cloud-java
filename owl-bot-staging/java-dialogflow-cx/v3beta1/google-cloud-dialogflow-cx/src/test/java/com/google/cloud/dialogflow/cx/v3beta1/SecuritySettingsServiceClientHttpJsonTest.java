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

package com.google.cloud.dialogflow.cx.v3beta1;

import static com.google.cloud.dialogflow.cx.v3beta1.SecuritySettingsServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.SecuritySettingsServiceClient.ListSecuritySettingsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dialogflow.cx.v3beta1.stub.HttpJsonSecuritySettingsServiceStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SecuritySettingsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SecuritySettingsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSecuritySettingsServiceStub.getMethodDescriptors(),
            SecuritySettingsServiceSettings.getDefaultEndpoint());
    SecuritySettingsServiceSettings settings =
        SecuritySettingsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SecuritySettingsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SecuritySettingsServiceClient.create(settings);
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
  public void createSecuritySettingsTest() throws Exception {
    SecuritySettings expectedResponse =
        SecuritySettings.newBuilder()
            .setName(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setInspectTemplate("inspectTemplate-2053620050")
            .setDeidentifyTemplate("deidentifyTemplate-2141929945")
            .addAllPurgeDataTypes(new ArrayList<SecuritySettings.PurgeDataType>())
            .setAudioExportSettings(SecuritySettings.AudioExportSettings.newBuilder().build())
            .setInsightsExportSettings(SecuritySettings.InsightsExportSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    SecuritySettings securitySettings = SecuritySettings.newBuilder().build();

    SecuritySettings actualResponse = client.createSecuritySettings(parent, securitySettings);
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
  public void createSecuritySettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      SecuritySettings securitySettings = SecuritySettings.newBuilder().build();
      client.createSecuritySettings(parent, securitySettings);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSecuritySettingsTest2() throws Exception {
    SecuritySettings expectedResponse =
        SecuritySettings.newBuilder()
            .setName(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setInspectTemplate("inspectTemplate-2053620050")
            .setDeidentifyTemplate("deidentifyTemplate-2141929945")
            .addAllPurgeDataTypes(new ArrayList<SecuritySettings.PurgeDataType>())
            .setAudioExportSettings(SecuritySettings.AudioExportSettings.newBuilder().build())
            .setInsightsExportSettings(SecuritySettings.InsightsExportSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    SecuritySettings securitySettings = SecuritySettings.newBuilder().build();

    SecuritySettings actualResponse = client.createSecuritySettings(parent, securitySettings);
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
  public void createSecuritySettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      SecuritySettings securitySettings = SecuritySettings.newBuilder().build();
      client.createSecuritySettings(parent, securitySettings);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSecuritySettingsTest() throws Exception {
    SecuritySettings expectedResponse =
        SecuritySettings.newBuilder()
            .setName(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setInspectTemplate("inspectTemplate-2053620050")
            .setDeidentifyTemplate("deidentifyTemplate-2141929945")
            .addAllPurgeDataTypes(new ArrayList<SecuritySettings.PurgeDataType>())
            .setAudioExportSettings(SecuritySettings.AudioExportSettings.newBuilder().build())
            .setInsightsExportSettings(SecuritySettings.InsightsExportSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SecuritySettingsName name =
        SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]");

    SecuritySettings actualResponse = client.getSecuritySettings(name);
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
  public void getSecuritySettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SecuritySettingsName name =
          SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]");
      client.getSecuritySettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSecuritySettingsTest2() throws Exception {
    SecuritySettings expectedResponse =
        SecuritySettings.newBuilder()
            .setName(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setInspectTemplate("inspectTemplate-2053620050")
            .setDeidentifyTemplate("deidentifyTemplate-2141929945")
            .addAllPurgeDataTypes(new ArrayList<SecuritySettings.PurgeDataType>())
            .setAudioExportSettings(SecuritySettings.AudioExportSettings.newBuilder().build())
            .setInsightsExportSettings(SecuritySettings.InsightsExportSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9453/locations/location-9453/securitySettings/securitySetting-9453";

    SecuritySettings actualResponse = client.getSecuritySettings(name);
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
  public void getSecuritySettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9453/locations/location-9453/securitySettings/securitySetting-9453";
      client.getSecuritySettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSecuritySettingsTest() throws Exception {
    SecuritySettings expectedResponse =
        SecuritySettings.newBuilder()
            .setName(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setInspectTemplate("inspectTemplate-2053620050")
            .setDeidentifyTemplate("deidentifyTemplate-2141929945")
            .addAllPurgeDataTypes(new ArrayList<SecuritySettings.PurgeDataType>())
            .setAudioExportSettings(SecuritySettings.AudioExportSettings.newBuilder().build())
            .setInsightsExportSettings(SecuritySettings.InsightsExportSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SecuritySettings securitySettings =
        SecuritySettings.newBuilder()
            .setName(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setInspectTemplate("inspectTemplate-2053620050")
            .setDeidentifyTemplate("deidentifyTemplate-2141929945")
            .addAllPurgeDataTypes(new ArrayList<SecuritySettings.PurgeDataType>())
            .setAudioExportSettings(SecuritySettings.AudioExportSettings.newBuilder().build())
            .setInsightsExportSettings(SecuritySettings.InsightsExportSettings.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SecuritySettings actualResponse = client.updateSecuritySettings(securitySettings, updateMask);
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
  public void updateSecuritySettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SecuritySettings securitySettings =
          SecuritySettings.newBuilder()
              .setName(
                  SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setInspectTemplate("inspectTemplate-2053620050")
              .setDeidentifyTemplate("deidentifyTemplate-2141929945")
              .addAllPurgeDataTypes(new ArrayList<SecuritySettings.PurgeDataType>())
              .setAudioExportSettings(SecuritySettings.AudioExportSettings.newBuilder().build())
              .setInsightsExportSettings(
                  SecuritySettings.InsightsExportSettings.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSecuritySettings(securitySettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSecuritySettingsTest() throws Exception {
    SecuritySettings responsesElement = SecuritySettings.newBuilder().build();
    ListSecuritySettingsResponse expectedResponse =
        ListSecuritySettingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecuritySettings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSecuritySettingsPagedResponse pagedListResponse = client.listSecuritySettings(parent);

    List<SecuritySettings> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSecuritySettingsList().get(0), resources.get(0));

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
  public void listSecuritySettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSecuritySettings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSecuritySettingsTest2() throws Exception {
    SecuritySettings responsesElement = SecuritySettings.newBuilder().build();
    ListSecuritySettingsResponse expectedResponse =
        ListSecuritySettingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecuritySettings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListSecuritySettingsPagedResponse pagedListResponse = client.listSecuritySettings(parent);

    List<SecuritySettings> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSecuritySettingsList().get(0), resources.get(0));

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
  public void listSecuritySettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listSecuritySettings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSecuritySettingsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SecuritySettingsName name =
        SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]");

    client.deleteSecuritySettings(name);

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
  public void deleteSecuritySettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SecuritySettingsName name =
          SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]");
      client.deleteSecuritySettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSecuritySettingsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9453/locations/location-9453/securitySettings/securitySetting-9453";

    client.deleteSecuritySettings(name);

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
  public void deleteSecuritySettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9453/locations/location-9453/securitySettings/securitySetting-9453";
      client.deleteSecuritySettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

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
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
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
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
