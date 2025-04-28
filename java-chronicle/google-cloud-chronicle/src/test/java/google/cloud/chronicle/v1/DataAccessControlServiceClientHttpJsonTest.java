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

package google.cloud.chronicle.v1;

import static google.cloud.chronicle.v1.DataAccessControlServiceClient.ListDataAccessLabelsPagedResponse;
import static google.cloud.chronicle.v1.DataAccessControlServiceClient.ListDataAccessScopesPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import google.cloud.chronicle.v1.stub.HttpJsonDataAccessControlServiceStub;
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
public class DataAccessControlServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DataAccessControlServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDataAccessControlServiceStub.getMethodDescriptors(),
            DataAccessControlServiceSettings.getDefaultEndpoint());
    DataAccessControlServiceSettings settings =
        DataAccessControlServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DataAccessControlServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataAccessControlServiceClient.create(settings);
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
  public void createDataAccessLabelTest() throws Exception {
    DataAccessLabel expectedResponse =
        DataAccessLabel.newBuilder()
            .setName(
                DataAccessLabelName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
    String dataAccessLabelId = "dataAccessLabelId1775298977";

    DataAccessLabel actualResponse =
        client.createDataAccessLabel(parent, dataAccessLabel, dataAccessLabelId);
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
  public void createDataAccessLabelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
      String dataAccessLabelId = "dataAccessLabelId1775298977";
      client.createDataAccessLabel(parent, dataAccessLabel, dataAccessLabelId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataAccessLabelTest2() throws Exception {
    DataAccessLabel expectedResponse =
        DataAccessLabel.newBuilder()
            .setName(
                DataAccessLabelName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
    String dataAccessLabelId = "dataAccessLabelId1775298977";

    DataAccessLabel actualResponse =
        client.createDataAccessLabel(parent, dataAccessLabel, dataAccessLabelId);
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
  public void createDataAccessLabelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
      String dataAccessLabelId = "dataAccessLabelId1775298977";
      client.createDataAccessLabel(parent, dataAccessLabel, dataAccessLabelId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAccessLabelTest() throws Exception {
    DataAccessLabel expectedResponse =
        DataAccessLabel.newBuilder()
            .setName(
                DataAccessLabelName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    DataAccessLabelName name =
        DataAccessLabelName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]");

    DataAccessLabel actualResponse = client.getDataAccessLabel(name);
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
  public void getDataAccessLabelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataAccessLabelName name =
          DataAccessLabelName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]");
      client.getDataAccessLabel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAccessLabelTest2() throws Exception {
    DataAccessLabel expectedResponse =
        DataAccessLabel.newBuilder()
            .setName(
                DataAccessLabelName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7667/locations/location-7667/instances/instance-7667/dataAccessLabels/dataAccessLabel-7667";

    DataAccessLabel actualResponse = client.getDataAccessLabel(name);
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
  public void getDataAccessLabelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7667/locations/location-7667/instances/instance-7667/dataAccessLabels/dataAccessLabel-7667";
      client.getDataAccessLabel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataAccessLabelsTest() throws Exception {
    DataAccessLabel responsesElement = DataAccessLabel.newBuilder().build();
    ListDataAccessLabelsResponse expectedResponse =
        ListDataAccessLabelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAccessLabels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListDataAccessLabelsPagedResponse pagedListResponse = client.listDataAccessLabels(parent);

    List<DataAccessLabel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAccessLabelsList().get(0), resources.get(0));

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
  public void listDataAccessLabelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listDataAccessLabels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataAccessLabelsTest2() throws Exception {
    DataAccessLabel responsesElement = DataAccessLabel.newBuilder().build();
    ListDataAccessLabelsResponse expectedResponse =
        ListDataAccessLabelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAccessLabels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListDataAccessLabelsPagedResponse pagedListResponse = client.listDataAccessLabels(parent);

    List<DataAccessLabel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAccessLabelsList().get(0), resources.get(0));

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
  public void listDataAccessLabelsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      client.listDataAccessLabels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataAccessLabelTest() throws Exception {
    DataAccessLabel expectedResponse =
        DataAccessLabel.newBuilder()
            .setName(
                DataAccessLabelName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    DataAccessLabel dataAccessLabel =
        DataAccessLabel.newBuilder()
            .setName(
                DataAccessLabelName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataAccessLabel actualResponse = client.updateDataAccessLabel(dataAccessLabel, updateMask);
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
  public void updateDataAccessLabelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataAccessLabel dataAccessLabel =
          DataAccessLabel.newBuilder()
              .setName(
                  DataAccessLabelName.of(
                          "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setAuthor("author-1406328437")
              .setLastEditor("lastEditor1523898275")
              .setDescription("description-1724546052")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataAccessLabel(dataAccessLabel, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataAccessLabelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DataAccessLabelName name =
        DataAccessLabelName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]");

    client.deleteDataAccessLabel(name);

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
  public void deleteDataAccessLabelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataAccessLabelName name =
          DataAccessLabelName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]");
      client.deleteDataAccessLabel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataAccessLabelTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7667/locations/location-7667/instances/instance-7667/dataAccessLabels/dataAccessLabel-7667";

    client.deleteDataAccessLabel(name);

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
  public void deleteDataAccessLabelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7667/locations/location-7667/instances/instance-7667/dataAccessLabels/dataAccessLabel-7667";
      client.deleteDataAccessLabel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataAccessScopeTest() throws Exception {
    DataAccessScope expectedResponse =
        DataAccessScope.newBuilder()
            .setName(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllAllowedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .addAllDeniedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .setAllowAll(true)
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    DataAccessScope dataAccessScope = DataAccessScope.newBuilder().build();
    String dataAccessScopeId = "dataAccessScopeId-532524799";

    DataAccessScope actualResponse =
        client.createDataAccessScope(parent, dataAccessScope, dataAccessScopeId);
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
  public void createDataAccessScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      DataAccessScope dataAccessScope = DataAccessScope.newBuilder().build();
      String dataAccessScopeId = "dataAccessScopeId-532524799";
      client.createDataAccessScope(parent, dataAccessScope, dataAccessScopeId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataAccessScopeTest2() throws Exception {
    DataAccessScope expectedResponse =
        DataAccessScope.newBuilder()
            .setName(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllAllowedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .addAllDeniedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .setAllowAll(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    DataAccessScope dataAccessScope = DataAccessScope.newBuilder().build();
    String dataAccessScopeId = "dataAccessScopeId-532524799";

    DataAccessScope actualResponse =
        client.createDataAccessScope(parent, dataAccessScope, dataAccessScopeId);
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
  public void createDataAccessScopeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      DataAccessScope dataAccessScope = DataAccessScope.newBuilder().build();
      String dataAccessScopeId = "dataAccessScopeId-532524799";
      client.createDataAccessScope(parent, dataAccessScope, dataAccessScopeId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAccessScopeTest() throws Exception {
    DataAccessScope expectedResponse =
        DataAccessScope.newBuilder()
            .setName(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllAllowedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .addAllDeniedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .setAllowAll(true)
            .build();
    mockService.addResponse(expectedResponse);

    DataAccessScopeName name =
        DataAccessScopeName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]");

    DataAccessScope actualResponse = client.getDataAccessScope(name);
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
  public void getDataAccessScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataAccessScopeName name =
          DataAccessScopeName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]");
      client.getDataAccessScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAccessScopeTest2() throws Exception {
    DataAccessScope expectedResponse =
        DataAccessScope.newBuilder()
            .setName(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllAllowedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .addAllDeniedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .setAllowAll(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2653/locations/location-2653/instances/instance-2653/dataAccessScopes/dataAccessScope-2653";

    DataAccessScope actualResponse = client.getDataAccessScope(name);
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
  public void getDataAccessScopeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2653/locations/location-2653/instances/instance-2653/dataAccessScopes/dataAccessScope-2653";
      client.getDataAccessScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataAccessScopesTest() throws Exception {
    DataAccessScope responsesElement = DataAccessScope.newBuilder().build();
    ListDataAccessScopesResponse expectedResponse =
        ListDataAccessScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAccessScopes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListDataAccessScopesPagedResponse pagedListResponse = client.listDataAccessScopes(parent);

    List<DataAccessScope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAccessScopesList().get(0), resources.get(0));

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
  public void listDataAccessScopesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listDataAccessScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataAccessScopesTest2() throws Exception {
    DataAccessScope responsesElement = DataAccessScope.newBuilder().build();
    ListDataAccessScopesResponse expectedResponse =
        ListDataAccessScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAccessScopes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListDataAccessScopesPagedResponse pagedListResponse = client.listDataAccessScopes(parent);

    List<DataAccessScope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAccessScopesList().get(0), resources.get(0));

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
  public void listDataAccessScopesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      client.listDataAccessScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataAccessScopeTest() throws Exception {
    DataAccessScope expectedResponse =
        DataAccessScope.newBuilder()
            .setName(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllAllowedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .addAllDeniedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .setAllowAll(true)
            .build();
    mockService.addResponse(expectedResponse);

    DataAccessScope dataAccessScope =
        DataAccessScope.newBuilder()
            .setName(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllAllowedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .addAllDeniedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAuthor("author-1406328437")
            .setLastEditor("lastEditor1523898275")
            .setDescription("description-1724546052")
            .setAllowAll(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataAccessScope actualResponse = client.updateDataAccessScope(dataAccessScope, updateMask);
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
  public void updateDataAccessScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataAccessScope dataAccessScope =
          DataAccessScope.newBuilder()
              .setName(
                  DataAccessScopeName.of(
                          "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                      .toString())
              .addAllAllowedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
              .addAllDeniedDataAccessLabels(new ArrayList<DataAccessLabelReference>())
              .setDisplayName("displayName1714148973")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setAuthor("author-1406328437")
              .setLastEditor("lastEditor1523898275")
              .setDescription("description-1724546052")
              .setAllowAll(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataAccessScope(dataAccessScope, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataAccessScopeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DataAccessScopeName name =
        DataAccessScopeName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]");

    client.deleteDataAccessScope(name);

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
  public void deleteDataAccessScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataAccessScopeName name =
          DataAccessScopeName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]");
      client.deleteDataAccessScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataAccessScopeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2653/locations/location-2653/instances/instance-2653/dataAccessScopes/dataAccessScope-2653";

    client.deleteDataAccessScope(name);

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
  public void deleteDataAccessScopeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2653/locations/location-2653/instances/instance-2653/dataAccessScopes/dataAccessScope-2653";
      client.deleteDataAccessScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
