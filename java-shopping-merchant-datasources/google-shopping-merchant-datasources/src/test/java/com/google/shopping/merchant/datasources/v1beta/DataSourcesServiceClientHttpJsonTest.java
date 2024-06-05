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

package com.google.shopping.merchant.datasources.v1beta;

import static com.google.shopping.merchant.datasources.v1beta.DataSourcesServiceClient.ListDataSourcesPagedResponse;

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
import com.google.shopping.merchant.datasources.v1beta.stub.HttpJsonDataSourcesServiceStub;
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
public class DataSourcesServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DataSourcesServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDataSourcesServiceStub.getMethodDescriptors(),
            DataSourcesServiceSettings.getDefaultEndpoint());
    DataSourcesServiceSettings settings =
        DataSourcesServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DataSourcesServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataSourcesServiceClient.create(settings);
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
  public void getDataSourceTest() throws Exception {
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
            .setDataSourceId(-1015796374)
            .setDisplayName("displayName1714148973")
            .setFileInput(FileInput.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DataSourceName name = DataSourceName.of("[ACCOUNT]", "[DATASOURCE]");

    DataSource actualResponse = client.getDataSource(name);
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
  public void getDataSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataSourceName name = DataSourceName.of("[ACCOUNT]", "[DATASOURCE]");
      client.getDataSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataSourceTest2() throws Exception {
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
            .setDataSourceId(-1015796374)
            .setDisplayName("displayName1714148973")
            .setFileInput(FileInput.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-3574/dataSources/dataSource-3574";

    DataSource actualResponse = client.getDataSource(name);
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
  public void getDataSourceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-3574/dataSources/dataSource-3574";
      client.getDataSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataSourcesTest() throws Exception {
    DataSource responsesElement = DataSource.newBuilder().build();
    ListDataSourcesResponse expectedResponse =
        ListDataSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataSources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListDataSourcesPagedResponse pagedListResponse = client.listDataSources(parent);

    List<DataSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourcesList().get(0), resources.get(0));

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
  public void listDataSourcesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listDataSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataSourcesTest2() throws Exception {
    DataSource responsesElement = DataSource.newBuilder().build();
    ListDataSourcesResponse expectedResponse =
        ListDataSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataSources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListDataSourcesPagedResponse pagedListResponse = client.listDataSources(parent);

    List<DataSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourcesList().get(0), resources.get(0));

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
  public void listDataSourcesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      client.listDataSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataSourceTest() throws Exception {
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
            .setDataSourceId(-1015796374)
            .setDisplayName("displayName1714148973")
            .setFileInput(FileInput.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    DataSource dataSource = DataSource.newBuilder().build();

    DataSource actualResponse = client.createDataSource(parent, dataSource);
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
  public void createDataSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      DataSource dataSource = DataSource.newBuilder().build();
      client.createDataSource(parent, dataSource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataSourceTest2() throws Exception {
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
            .setDataSourceId(-1015796374)
            .setDisplayName("displayName1714148973")
            .setFileInput(FileInput.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";
    DataSource dataSource = DataSource.newBuilder().build();

    DataSource actualResponse = client.createDataSource(parent, dataSource);
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
  public void createDataSourceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      DataSource dataSource = DataSource.newBuilder().build();
      client.createDataSource(parent, dataSource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataSourceTest() throws Exception {
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
            .setDataSourceId(-1015796374)
            .setDisplayName("displayName1714148973")
            .setFileInput(FileInput.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DataSource dataSource =
        DataSource.newBuilder()
            .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
            .setDataSourceId(-1015796374)
            .setDisplayName("displayName1714148973")
            .setFileInput(FileInput.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataSource actualResponse = client.updateDataSource(dataSource, updateMask);
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
  public void updateDataSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataSource dataSource =
          DataSource.newBuilder()
              .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
              .setDataSourceId(-1015796374)
              .setDisplayName("displayName1714148973")
              .setFileInput(FileInput.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataSource(dataSource, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataSourceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DataSourceName name = DataSourceName.of("[ACCOUNT]", "[DATASOURCE]");

    client.deleteDataSource(name);

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
  public void deleteDataSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataSourceName name = DataSourceName.of("[ACCOUNT]", "[DATASOURCE]");
      client.deleteDataSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataSourceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-3574/dataSources/dataSource-3574";

    client.deleteDataSource(name);

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
  public void deleteDataSourceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-3574/dataSources/dataSource-3574";
      client.deleteDataSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchDataSourceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    FetchDataSourceRequest request =
        FetchDataSourceRequest.newBuilder()
            .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
            .build();

    client.fetchDataSource(request);

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
  public void fetchDataSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FetchDataSourceRequest request =
          FetchDataSourceRequest.newBuilder()
              .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
              .build();
      client.fetchDataSource(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
