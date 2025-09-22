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

package com.google.cloud.apihub.v1;

import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListPluginInstancesPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListPluginsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.apihub.v1.stub.HttpJsonApiHubPluginStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ApiHubPluginClientTest {
  private static MockHttpService mockService;
  private static ApiHubPluginClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonApiHubPluginStub.getMethodDescriptors(),
            ApiHubPluginSettings.getDefaultEndpoint());
    ApiHubPluginSettings settings =
        ApiHubPluginSettings.newBuilder()
            .setTransportChannelProvider(
                ApiHubPluginSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ApiHubPluginClient.create(settings);
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
  public void getPluginTest() throws Exception {
    Plugin expectedResponse =
        Plugin.newBuilder()
            .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setDisplayName("displayName1714148973")
            .setType(AttributeValues.newBuilder().build())
            .setDescription("description-1724546052")
            .setHostingService(Plugin.HostingService.newBuilder().build())
            .addAllActionsConfig(new ArrayList<PluginActionConfig>())
            .setDocumentation(Documentation.newBuilder().build())
            .setPluginCategory(PluginCategory.forNumber(0))
            .setConfigTemplate(Plugin.ConfigTemplate.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setGatewayType(GatewayType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");

    Plugin actualResponse = client.getPlugin(name);
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
  public void getPluginExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
      client.getPlugin(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPluginTest2() throws Exception {
    Plugin expectedResponse =
        Plugin.newBuilder()
            .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setDisplayName("displayName1714148973")
            .setType(AttributeValues.newBuilder().build())
            .setDescription("description-1724546052")
            .setHostingService(Plugin.HostingService.newBuilder().build())
            .addAllActionsConfig(new ArrayList<PluginActionConfig>())
            .setDocumentation(Documentation.newBuilder().build())
            .setPluginCategory(PluginCategory.forNumber(0))
            .setConfigTemplate(Plugin.ConfigTemplate.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setGatewayType(GatewayType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1258/locations/location-1258/plugins/plugin-1258";

    Plugin actualResponse = client.getPlugin(name);
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
  public void getPluginExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1258/locations/location-1258/plugins/plugin-1258";
      client.getPlugin(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enablePluginTest() throws Exception {
    Plugin expectedResponse =
        Plugin.newBuilder()
            .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setDisplayName("displayName1714148973")
            .setType(AttributeValues.newBuilder().build())
            .setDescription("description-1724546052")
            .setHostingService(Plugin.HostingService.newBuilder().build())
            .addAllActionsConfig(new ArrayList<PluginActionConfig>())
            .setDocumentation(Documentation.newBuilder().build())
            .setPluginCategory(PluginCategory.forNumber(0))
            .setConfigTemplate(Plugin.ConfigTemplate.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setGatewayType(GatewayType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");

    Plugin actualResponse = client.enablePlugin(name);
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
  public void enablePluginExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
      client.enablePlugin(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enablePluginTest2() throws Exception {
    Plugin expectedResponse =
        Plugin.newBuilder()
            .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setDisplayName("displayName1714148973")
            .setType(AttributeValues.newBuilder().build())
            .setDescription("description-1724546052")
            .setHostingService(Plugin.HostingService.newBuilder().build())
            .addAllActionsConfig(new ArrayList<PluginActionConfig>())
            .setDocumentation(Documentation.newBuilder().build())
            .setPluginCategory(PluginCategory.forNumber(0))
            .setConfigTemplate(Plugin.ConfigTemplate.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setGatewayType(GatewayType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1258/locations/location-1258/plugins/plugin-1258";

    Plugin actualResponse = client.enablePlugin(name);
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
  public void enablePluginExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1258/locations/location-1258/plugins/plugin-1258";
      client.enablePlugin(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disablePluginTest() throws Exception {
    Plugin expectedResponse =
        Plugin.newBuilder()
            .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setDisplayName("displayName1714148973")
            .setType(AttributeValues.newBuilder().build())
            .setDescription("description-1724546052")
            .setHostingService(Plugin.HostingService.newBuilder().build())
            .addAllActionsConfig(new ArrayList<PluginActionConfig>())
            .setDocumentation(Documentation.newBuilder().build())
            .setPluginCategory(PluginCategory.forNumber(0))
            .setConfigTemplate(Plugin.ConfigTemplate.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setGatewayType(GatewayType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");

    Plugin actualResponse = client.disablePlugin(name);
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
  public void disablePluginExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
      client.disablePlugin(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disablePluginTest2() throws Exception {
    Plugin expectedResponse =
        Plugin.newBuilder()
            .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setDisplayName("displayName1714148973")
            .setType(AttributeValues.newBuilder().build())
            .setDescription("description-1724546052")
            .setHostingService(Plugin.HostingService.newBuilder().build())
            .addAllActionsConfig(new ArrayList<PluginActionConfig>())
            .setDocumentation(Documentation.newBuilder().build())
            .setPluginCategory(PluginCategory.forNumber(0))
            .setConfigTemplate(Plugin.ConfigTemplate.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setGatewayType(GatewayType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1258/locations/location-1258/plugins/plugin-1258";

    Plugin actualResponse = client.disablePlugin(name);
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
  public void disablePluginExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1258/locations/location-1258/plugins/plugin-1258";
      client.disablePlugin(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPluginTest() throws Exception {
    Plugin expectedResponse =
        Plugin.newBuilder()
            .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setDisplayName("displayName1714148973")
            .setType(AttributeValues.newBuilder().build())
            .setDescription("description-1724546052")
            .setHostingService(Plugin.HostingService.newBuilder().build())
            .addAllActionsConfig(new ArrayList<PluginActionConfig>())
            .setDocumentation(Documentation.newBuilder().build())
            .setPluginCategory(PluginCategory.forNumber(0))
            .setConfigTemplate(Plugin.ConfigTemplate.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setGatewayType(GatewayType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Plugin plugin = Plugin.newBuilder().build();
    String pluginId = "pluginId-1859618898";

    Plugin actualResponse = client.createPlugin(parent, plugin, pluginId);
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
  public void createPluginExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Plugin plugin = Plugin.newBuilder().build();
      String pluginId = "pluginId-1859618898";
      client.createPlugin(parent, plugin, pluginId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPluginTest2() throws Exception {
    Plugin expectedResponse =
        Plugin.newBuilder()
            .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setDisplayName("displayName1714148973")
            .setType(AttributeValues.newBuilder().build())
            .setDescription("description-1724546052")
            .setHostingService(Plugin.HostingService.newBuilder().build())
            .addAllActionsConfig(new ArrayList<PluginActionConfig>())
            .setDocumentation(Documentation.newBuilder().build())
            .setPluginCategory(PluginCategory.forNumber(0))
            .setConfigTemplate(Plugin.ConfigTemplate.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setGatewayType(GatewayType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    Plugin plugin = Plugin.newBuilder().build();
    String pluginId = "pluginId-1859618898";

    Plugin actualResponse = client.createPlugin(parent, plugin, pluginId);
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
  public void createPluginExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Plugin plugin = Plugin.newBuilder().build();
      String pluginId = "pluginId-1859618898";
      client.createPlugin(parent, plugin, pluginId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPluginsTest() throws Exception {
    Plugin responsesElement = Plugin.newBuilder().build();
    ListPluginsResponse expectedResponse =
        ListPluginsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPlugins(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPluginsPagedResponse pagedListResponse = client.listPlugins(parent);

    List<Plugin> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPluginsList().get(0), resources.get(0));

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
  public void listPluginsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPlugins(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPluginsTest2() throws Exception {
    Plugin responsesElement = Plugin.newBuilder().build();
    ListPluginsResponse expectedResponse =
        ListPluginsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPlugins(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListPluginsPagedResponse pagedListResponse = client.listPlugins(parent);

    List<Plugin> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPluginsList().get(0), resources.get(0));

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
  public void listPluginsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listPlugins(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePluginTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePluginTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");

    client.deletePluginAsync(name).get();

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
  public void deletePluginExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
      client.deletePluginAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePluginTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePluginTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-1258/locations/location-1258/plugins/plugin-1258";

    client.deletePluginAsync(name).get();

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
  public void deletePluginExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1258/locations/location-1258/plugins/plugin-1258";
      client.deletePluginAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createPluginInstanceTest() throws Exception {
    PluginInstance expectedResponse =
        PluginInstance.newBuilder()
            .setName(
                PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setAuthConfig(AuthConfig.newBuilder().build())
            .putAllAdditionalConfig(new HashMap<String, ConfigVariable>())
            .setErrorMessage("errorMessage1203236063")
            .addAllActions(new ArrayList<PluginInstanceAction>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProjectId("sourceProjectId-213936071")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPluginInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PluginName parent = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
    PluginInstance pluginInstance = PluginInstance.newBuilder().build();
    String pluginInstanceId = "pluginInstanceId-1741818845";

    PluginInstance actualResponse =
        client.createPluginInstanceAsync(parent, pluginInstance, pluginInstanceId).get();
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
  public void createPluginInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PluginName parent = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
      PluginInstance pluginInstance = PluginInstance.newBuilder().build();
      String pluginInstanceId = "pluginInstanceId-1741818845";
      client.createPluginInstanceAsync(parent, pluginInstance, pluginInstanceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createPluginInstanceTest2() throws Exception {
    PluginInstance expectedResponse =
        PluginInstance.newBuilder()
            .setName(
                PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setAuthConfig(AuthConfig.newBuilder().build())
            .putAllAdditionalConfig(new HashMap<String, ConfigVariable>())
            .setErrorMessage("errorMessage1203236063")
            .addAllActions(new ArrayList<PluginInstanceAction>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProjectId("sourceProjectId-213936071")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPluginInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-7467/locations/location-7467/plugins/plugin-7467";
    PluginInstance pluginInstance = PluginInstance.newBuilder().build();
    String pluginInstanceId = "pluginInstanceId-1741818845";

    PluginInstance actualResponse =
        client.createPluginInstanceAsync(parent, pluginInstance, pluginInstanceId).get();
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
  public void createPluginInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7467/locations/location-7467/plugins/plugin-7467";
      PluginInstance pluginInstance = PluginInstance.newBuilder().build();
      String pluginInstanceId = "pluginInstanceId-1741818845";
      client.createPluginInstanceAsync(parent, pluginInstance, pluginInstanceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void executePluginInstanceActionTest() throws Exception {
    ExecutePluginInstanceActionResponse expectedResponse =
        ExecutePluginInstanceActionResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("executePluginInstanceActionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PluginInstanceName name =
        PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]");
    ActionExecutionDetail actionExecutionDetail = ActionExecutionDetail.newBuilder().build();

    ExecutePluginInstanceActionResponse actualResponse =
        client.executePluginInstanceActionAsync(name, actionExecutionDetail).get();
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
  public void executePluginInstanceActionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PluginInstanceName name =
          PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]");
      ActionExecutionDetail actionExecutionDetail = ActionExecutionDetail.newBuilder().build();
      client.executePluginInstanceActionAsync(name, actionExecutionDetail).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void executePluginInstanceActionTest2() throws Exception {
    ExecutePluginInstanceActionResponse expectedResponse =
        ExecutePluginInstanceActionResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("executePluginInstanceActionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-528/locations/location-528/plugins/plugin-528/instances/instance-528";
    ActionExecutionDetail actionExecutionDetail = ActionExecutionDetail.newBuilder().build();

    ExecutePluginInstanceActionResponse actualResponse =
        client.executePluginInstanceActionAsync(name, actionExecutionDetail).get();
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
  public void executePluginInstanceActionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-528/locations/location-528/plugins/plugin-528/instances/instance-528";
      ActionExecutionDetail actionExecutionDetail = ActionExecutionDetail.newBuilder().build();
      client.executePluginInstanceActionAsync(name, actionExecutionDetail).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getPluginInstanceTest() throws Exception {
    PluginInstance expectedResponse =
        PluginInstance.newBuilder()
            .setName(
                PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setAuthConfig(AuthConfig.newBuilder().build())
            .putAllAdditionalConfig(new HashMap<String, ConfigVariable>())
            .setErrorMessage("errorMessage1203236063")
            .addAllActions(new ArrayList<PluginInstanceAction>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProjectId("sourceProjectId-213936071")
            .build();
    mockService.addResponse(expectedResponse);

    PluginInstanceName name =
        PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]");

    PluginInstance actualResponse = client.getPluginInstance(name);
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
  public void getPluginInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PluginInstanceName name =
          PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]");
      client.getPluginInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPluginInstanceTest2() throws Exception {
    PluginInstance expectedResponse =
        PluginInstance.newBuilder()
            .setName(
                PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setAuthConfig(AuthConfig.newBuilder().build())
            .putAllAdditionalConfig(new HashMap<String, ConfigVariable>())
            .setErrorMessage("errorMessage1203236063")
            .addAllActions(new ArrayList<PluginInstanceAction>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProjectId("sourceProjectId-213936071")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-528/locations/location-528/plugins/plugin-528/instances/instance-528";

    PluginInstance actualResponse = client.getPluginInstance(name);
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
  public void getPluginInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-528/locations/location-528/plugins/plugin-528/instances/instance-528";
      client.getPluginInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPluginInstancesTest() throws Exception {
    PluginInstance responsesElement = PluginInstance.newBuilder().build();
    ListPluginInstancesResponse expectedResponse =
        ListPluginInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPluginInstances(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PluginName parent = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");

    ListPluginInstancesPagedResponse pagedListResponse = client.listPluginInstances(parent);

    List<PluginInstance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPluginInstancesList().get(0), resources.get(0));

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
  public void listPluginInstancesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PluginName parent = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
      client.listPluginInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPluginInstancesTest2() throws Exception {
    PluginInstance responsesElement = PluginInstance.newBuilder().build();
    ListPluginInstancesResponse expectedResponse =
        ListPluginInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPluginInstances(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7467/locations/location-7467/plugins/plugin-7467";

    ListPluginInstancesPagedResponse pagedListResponse = client.listPluginInstances(parent);

    List<PluginInstance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPluginInstancesList().get(0), resources.get(0));

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
  public void listPluginInstancesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7467/locations/location-7467/plugins/plugin-7467";
      client.listPluginInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enablePluginInstanceActionTest() throws Exception {
    EnablePluginInstanceActionResponse expectedResponse =
        EnablePluginInstanceActionResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enablePluginInstanceActionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PluginInstanceName name =
        PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]");
    String actionId = "actionId-1656172047";

    EnablePluginInstanceActionResponse actualResponse =
        client.enablePluginInstanceActionAsync(name, actionId).get();
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
  public void enablePluginInstanceActionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PluginInstanceName name =
          PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]");
      String actionId = "actionId-1656172047";
      client.enablePluginInstanceActionAsync(name, actionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void enablePluginInstanceActionTest2() throws Exception {
    EnablePluginInstanceActionResponse expectedResponse =
        EnablePluginInstanceActionResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enablePluginInstanceActionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-528/locations/location-528/plugins/plugin-528/instances/instance-528";
    String actionId = "actionId-1656172047";

    EnablePluginInstanceActionResponse actualResponse =
        client.enablePluginInstanceActionAsync(name, actionId).get();
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
  public void enablePluginInstanceActionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-528/locations/location-528/plugins/plugin-528/instances/instance-528";
      String actionId = "actionId-1656172047";
      client.enablePluginInstanceActionAsync(name, actionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void disablePluginInstanceActionTest() throws Exception {
    DisablePluginInstanceActionResponse expectedResponse =
        DisablePluginInstanceActionResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disablePluginInstanceActionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PluginInstanceName name =
        PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]");
    String actionId = "actionId-1656172047";

    DisablePluginInstanceActionResponse actualResponse =
        client.disablePluginInstanceActionAsync(name, actionId).get();
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
  public void disablePluginInstanceActionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PluginInstanceName name =
          PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]");
      String actionId = "actionId-1656172047";
      client.disablePluginInstanceActionAsync(name, actionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void disablePluginInstanceActionTest2() throws Exception {
    DisablePluginInstanceActionResponse expectedResponse =
        DisablePluginInstanceActionResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disablePluginInstanceActionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-528/locations/location-528/plugins/plugin-528/instances/instance-528";
    String actionId = "actionId-1656172047";

    DisablePluginInstanceActionResponse actualResponse =
        client.disablePluginInstanceActionAsync(name, actionId).get();
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
  public void disablePluginInstanceActionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-528/locations/location-528/plugins/plugin-528/instances/instance-528";
      String actionId = "actionId-1656172047";
      client.disablePluginInstanceActionAsync(name, actionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updatePluginInstanceTest() throws Exception {
    PluginInstance expectedResponse =
        PluginInstance.newBuilder()
            .setName(
                PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setAuthConfig(AuthConfig.newBuilder().build())
            .putAllAdditionalConfig(new HashMap<String, ConfigVariable>())
            .setErrorMessage("errorMessage1203236063")
            .addAllActions(new ArrayList<PluginInstanceAction>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProjectId("sourceProjectId-213936071")
            .build();
    mockService.addResponse(expectedResponse);

    PluginInstance pluginInstance =
        PluginInstance.newBuilder()
            .setName(
                PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setAuthConfig(AuthConfig.newBuilder().build())
            .putAllAdditionalConfig(new HashMap<String, ConfigVariable>())
            .setErrorMessage("errorMessage1203236063")
            .addAllActions(new ArrayList<PluginInstanceAction>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProjectId("sourceProjectId-213936071")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PluginInstance actualResponse = client.updatePluginInstance(pluginInstance, updateMask);
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
  public void updatePluginInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PluginInstance pluginInstance =
          PluginInstance.newBuilder()
              .setName(
                  PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setAuthConfig(AuthConfig.newBuilder().build())
              .putAllAdditionalConfig(new HashMap<String, ConfigVariable>())
              .setErrorMessage("errorMessage1203236063")
              .addAllActions(new ArrayList<PluginInstanceAction>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setSourceProjectId("sourceProjectId-213936071")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePluginInstance(pluginInstance, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePluginInstanceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePluginInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PluginInstanceName name =
        PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]");

    client.deletePluginInstanceAsync(name).get();

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
  public void deletePluginInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PluginInstanceName name =
          PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]");
      client.deletePluginInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePluginInstanceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePluginInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-528/locations/location-528/plugins/plugin-528/instances/instance-528";

    client.deletePluginInstanceAsync(name).get();

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
  public void deletePluginInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-528/locations/location-528/plugins/plugin-528/instances/instance-528";
      client.deletePluginInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
