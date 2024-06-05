/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.discoveryengine.v1beta.ControlServiceClient.ListControlsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1beta.stub.HttpJsonControlServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class ControlServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ControlServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonControlServiceStub.getMethodDescriptors(),
            ControlServiceSettings.getDefaultEndpoint());
    ControlServiceSettings settings =
        ControlServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ControlServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ControlServiceClient.create(settings);
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
  public void createControlTest() throws Exception {
    Control expectedResponse =
        Control.newBuilder()
            .setName(
                ControlName.ofProjectLocationDataStoreControlName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllAssociatedServingConfigIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .addAllUseCases(new ArrayList<SearchUseCase>())
            .addAllConditions(new ArrayList<Condition>())
            .build();
    mockService.addResponse(expectedResponse);

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
    Control control = Control.newBuilder().build();
    String controlId = "controlId-395080872";

    Control actualResponse = client.createControl(parent, control, controlId);
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
  public void createControlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStoreName parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      Control control = Control.newBuilder().build();
      String controlId = "controlId-395080872";
      client.createControl(parent, control, controlId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createControlTest2() throws Exception {
    Control expectedResponse =
        Control.newBuilder()
            .setName(
                ControlName.ofProjectLocationDataStoreControlName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllAssociatedServingConfigIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .addAllUseCases(new ArrayList<SearchUseCase>())
            .addAllConditions(new ArrayList<Condition>())
            .build();
    mockService.addResponse(expectedResponse);

    EngineName parent = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
    Control control = Control.newBuilder().build();
    String controlId = "controlId-395080872";

    Control actualResponse = client.createControl(parent, control, controlId);
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
  public void createControlExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EngineName parent = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
      Control control = Control.newBuilder().build();
      String controlId = "controlId-395080872";
      client.createControl(parent, control, controlId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createControlTest3() throws Exception {
    Control expectedResponse =
        Control.newBuilder()
            .setName(
                ControlName.ofProjectLocationDataStoreControlName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllAssociatedServingConfigIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .addAllUseCases(new ArrayList<SearchUseCase>())
            .addAllConditions(new ArrayList<Condition>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
    Control control = Control.newBuilder().build();
    String controlId = "controlId-395080872";

    Control actualResponse = client.createControl(parent, control, controlId);
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
  public void createControlExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
      Control control = Control.newBuilder().build();
      String controlId = "controlId-395080872";
      client.createControl(parent, control, controlId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteControlTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ControlName name =
        ControlName.ofProjectLocationDataStoreControlName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]");

    client.deleteControl(name);

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
  public void deleteControlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ControlName name =
          ControlName.ofProjectLocationDataStoreControlName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]");
      client.deleteControl(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteControlTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2220/locations/location-2220/dataStores/dataStore-2220/controls/control-2220";

    client.deleteControl(name);

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
  public void deleteControlExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2220/locations/location-2220/dataStores/dataStore-2220/controls/control-2220";
      client.deleteControl(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateControlTest() throws Exception {
    Control expectedResponse =
        Control.newBuilder()
            .setName(
                ControlName.ofProjectLocationDataStoreControlName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllAssociatedServingConfigIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .addAllUseCases(new ArrayList<SearchUseCase>())
            .addAllConditions(new ArrayList<Condition>())
            .build();
    mockService.addResponse(expectedResponse);

    Control control =
        Control.newBuilder()
            .setName(
                ControlName.ofProjectLocationDataStoreControlName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllAssociatedServingConfigIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .addAllUseCases(new ArrayList<SearchUseCase>())
            .addAllConditions(new ArrayList<Condition>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Control actualResponse = client.updateControl(control, updateMask);
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
  public void updateControlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Control control =
          Control.newBuilder()
              .setName(
                  ControlName.ofProjectLocationDataStoreControlName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .addAllAssociatedServingConfigIds(new ArrayList<String>())
              .setSolutionType(SolutionType.forNumber(0))
              .addAllUseCases(new ArrayList<SearchUseCase>())
              .addAllConditions(new ArrayList<Condition>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateControl(control, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getControlTest() throws Exception {
    Control expectedResponse =
        Control.newBuilder()
            .setName(
                ControlName.ofProjectLocationDataStoreControlName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllAssociatedServingConfigIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .addAllUseCases(new ArrayList<SearchUseCase>())
            .addAllConditions(new ArrayList<Condition>())
            .build();
    mockService.addResponse(expectedResponse);

    ControlName name =
        ControlName.ofProjectLocationDataStoreControlName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]");

    Control actualResponse = client.getControl(name);
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
  public void getControlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ControlName name =
          ControlName.ofProjectLocationDataStoreControlName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]");
      client.getControl(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getControlTest2() throws Exception {
    Control expectedResponse =
        Control.newBuilder()
            .setName(
                ControlName.ofProjectLocationDataStoreControlName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONTROL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllAssociatedServingConfigIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .addAllUseCases(new ArrayList<SearchUseCase>())
            .addAllConditions(new ArrayList<Condition>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2220/locations/location-2220/dataStores/dataStore-2220/controls/control-2220";

    Control actualResponse = client.getControl(name);
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
  public void getControlExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2220/locations/location-2220/dataStores/dataStore-2220/controls/control-2220";
      client.getControl(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listControlsTest() throws Exception {
    Control responsesElement = Control.newBuilder().build();
    ListControlsResponse expectedResponse =
        ListControlsResponse.newBuilder()
            .setNextPageToken("")
            .addAllControls(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");

    ListControlsPagedResponse pagedListResponse = client.listControls(parent);

    List<Control> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getControlsList().get(0), resources.get(0));

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
  public void listControlsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStoreName parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      client.listControls(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listControlsTest2() throws Exception {
    Control responsesElement = Control.newBuilder().build();
    ListControlsResponse expectedResponse =
        ListControlsResponse.newBuilder()
            .setNextPageToken("")
            .addAllControls(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    EngineName parent = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");

    ListControlsPagedResponse pagedListResponse = client.listControls(parent);

    List<Control> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getControlsList().get(0), resources.get(0));

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
  public void listControlsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EngineName parent = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
      client.listControls(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listControlsTest3() throws Exception {
    Control responsesElement = Control.newBuilder().build();
    ListControlsResponse expectedResponse =
        ListControlsResponse.newBuilder()
            .setNextPageToken("")
            .addAllControls(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";

    ListControlsPagedResponse pagedListResponse = client.listControls(parent);

    List<Control> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getControlsList().get(0), resources.get(0));

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
  public void listControlsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
      client.listControls(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
