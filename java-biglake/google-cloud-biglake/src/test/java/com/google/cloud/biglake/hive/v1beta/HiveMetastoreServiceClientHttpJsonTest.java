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

package com.google.cloud.biglake.hive.v1beta;

import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveCatalogsPagedResponse;
import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveDatabasesPagedResponse;
import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveTablesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.biglake.hive.v1beta.stub.HttpJsonHiveMetastoreServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class HiveMetastoreServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static HiveMetastoreServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonHiveMetastoreServiceStub.getMethodDescriptors(),
            HiveMetastoreServiceSettings.getDefaultEndpoint());
    HiveMetastoreServiceSettings settings =
        HiveMetastoreServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                HiveMetastoreServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = HiveMetastoreServiceClient.create(settings);
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
  public void createHiveCatalogTest() throws Exception {
    HiveCatalog expectedResponse =
        HiveCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .addAllReplicas(new ArrayList<HiveCatalog.Replica>())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    HiveCatalog hiveCatalog = HiveCatalog.newBuilder().build();
    String hiveCatalogId = "hiveCatalogId-575314556";

    HiveCatalog actualResponse = client.createHiveCatalog(parent, hiveCatalog, hiveCatalogId);
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
  public void createHiveCatalogExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      HiveCatalog hiveCatalog = HiveCatalog.newBuilder().build();
      String hiveCatalogId = "hiveCatalogId-575314556";
      client.createHiveCatalog(parent, hiveCatalog, hiveCatalogId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHiveCatalogTest2() throws Exception {
    HiveCatalog expectedResponse =
        HiveCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .addAllReplicas(new ArrayList<HiveCatalog.Replica>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";
    HiveCatalog hiveCatalog = HiveCatalog.newBuilder().build();
    String hiveCatalogId = "hiveCatalogId-575314556";

    HiveCatalog actualResponse = client.createHiveCatalog(parent, hiveCatalog, hiveCatalogId);
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
  public void createHiveCatalogExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      HiveCatalog hiveCatalog = HiveCatalog.newBuilder().build();
      String hiveCatalogId = "hiveCatalogId-575314556";
      client.createHiveCatalog(parent, hiveCatalog, hiveCatalogId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHiveCatalogTest() throws Exception {
    HiveCatalog expectedResponse =
        HiveCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .addAllReplicas(new ArrayList<HiveCatalog.Replica>())
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");

    HiveCatalog actualResponse = client.getHiveCatalog(name);
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
  public void getHiveCatalogExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");
      client.getHiveCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHiveCatalogTest2() throws Exception {
    HiveCatalog expectedResponse =
        HiveCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .addAllReplicas(new ArrayList<HiveCatalog.Replica>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9652/catalogs/catalog-9652";

    HiveCatalog actualResponse = client.getHiveCatalog(name);
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
  public void getHiveCatalogExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9652/catalogs/catalog-9652";
      client.getHiveCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHiveCatalogsTest() throws Exception {
    HiveCatalog responsesElement = HiveCatalog.newBuilder().build();
    ListHiveCatalogsResponse expectedResponse =
        ListHiveCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListHiveCatalogsPagedResponse pagedListResponse = client.listHiveCatalogs(parent);

    List<HiveCatalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogsList().get(0), resources.get(0));

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
  public void listHiveCatalogsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listHiveCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHiveCatalogsTest2() throws Exception {
    HiveCatalog responsesElement = HiveCatalog.newBuilder().build();
    ListHiveCatalogsResponse expectedResponse =
        ListHiveCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListHiveCatalogsPagedResponse pagedListResponse = client.listHiveCatalogs(parent);

    List<HiveCatalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogsList().get(0), resources.get(0));

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
  public void listHiveCatalogsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      client.listHiveCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateHiveCatalogTest() throws Exception {
    HiveCatalog expectedResponse =
        HiveCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .addAllReplicas(new ArrayList<HiveCatalog.Replica>())
            .build();
    mockService.addResponse(expectedResponse);

    HiveCatalog hiveCatalog =
        HiveCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .addAllReplicas(new ArrayList<HiveCatalog.Replica>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    HiveCatalog actualResponse = client.updateHiveCatalog(hiveCatalog, updateMask);
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
  public void updateHiveCatalogExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      HiveCatalog hiveCatalog =
          HiveCatalog.newBuilder()
              .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
              .setDescription("description-1724546052")
              .setLocationUri("locationUri552310135")
              .addAllReplicas(new ArrayList<HiveCatalog.Replica>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHiveCatalog(hiveCatalog, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteHiveCatalogTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");

    client.deleteHiveCatalog(name);

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
  public void deleteHiveCatalogExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");
      client.deleteHiveCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteHiveCatalogTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9652/catalogs/catalog-9652";

    client.deleteHiveCatalog(name);

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
  public void deleteHiveCatalogExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9652/catalogs/catalog-9652";
      client.deleteHiveCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHiveDatabaseTest() throws Exception {
    HiveDatabase expectedResponse =
        HiveDatabase.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .putAllParameters(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[CATALOG]");
    HiveDatabase hiveDatabase = HiveDatabase.newBuilder().build();
    String hiveDatabaseId = "hiveDatabaseId-1150232698";

    HiveDatabase actualResponse = client.createHiveDatabase(parent, hiveDatabase, hiveDatabaseId);
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
  public void createHiveDatabaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[CATALOG]");
      HiveDatabase hiveDatabase = HiveDatabase.newBuilder().build();
      String hiveDatabaseId = "hiveDatabaseId-1150232698";
      client.createHiveDatabase(parent, hiveDatabase, hiveDatabaseId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHiveDatabaseTest2() throws Exception {
    HiveDatabase expectedResponse =
        HiveDatabase.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .putAllParameters(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2565/catalogs/catalog-2565";
    HiveDatabase hiveDatabase = HiveDatabase.newBuilder().build();
    String hiveDatabaseId = "hiveDatabaseId-1150232698";

    HiveDatabase actualResponse = client.createHiveDatabase(parent, hiveDatabase, hiveDatabaseId);
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
  public void createHiveDatabaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2565/catalogs/catalog-2565";
      HiveDatabase hiveDatabase = HiveDatabase.newBuilder().build();
      String hiveDatabaseId = "hiveDatabaseId-1150232698";
      client.createHiveDatabase(parent, hiveDatabase, hiveDatabaseId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHiveDatabaseTest() throws Exception {
    HiveDatabase expectedResponse =
        HiveDatabase.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .putAllParameters(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    NamespaceName name = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");

    HiveDatabase actualResponse = client.getHiveDatabase(name);
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
  public void getHiveDatabaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NamespaceName name = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");
      client.getHiveDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHiveDatabaseTest2() throws Exception {
    HiveDatabase expectedResponse =
        HiveDatabase.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .putAllParameters(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2808/catalogs/catalog-2808/databases/database-2808";

    HiveDatabase actualResponse = client.getHiveDatabase(name);
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
  public void getHiveDatabaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2808/catalogs/catalog-2808/databases/database-2808";
      client.getHiveDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHiveDatabasesTest() throws Exception {
    HiveDatabase responsesElement = HiveDatabase.newBuilder().build();
    ListHiveDatabasesResponse expectedResponse =
        ListHiveDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatabases(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[CATALOG]");

    ListHiveDatabasesPagedResponse pagedListResponse = client.listHiveDatabases(parent);

    List<HiveDatabase> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatabasesList().get(0), resources.get(0));

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
  public void listHiveDatabasesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[CATALOG]");
      client.listHiveDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHiveDatabasesTest2() throws Exception {
    HiveDatabase responsesElement = HiveDatabase.newBuilder().build();
    ListHiveDatabasesResponse expectedResponse =
        ListHiveDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatabases(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2565/catalogs/catalog-2565";

    ListHiveDatabasesPagedResponse pagedListResponse = client.listHiveDatabases(parent);

    List<HiveDatabase> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatabasesList().get(0), resources.get(0));

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
  public void listHiveDatabasesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2565/catalogs/catalog-2565";
      client.listHiveDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateHiveDatabaseTest() throws Exception {
    HiveDatabase expectedResponse =
        HiveDatabase.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .putAllParameters(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    HiveDatabase hiveDatabase =
        HiveDatabase.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .putAllParameters(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    HiveDatabase actualResponse = client.updateHiveDatabase(hiveDatabase, updateMask);
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
  public void updateHiveDatabaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      HiveDatabase hiveDatabase =
          HiveDatabase.newBuilder()
              .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
              .setDescription("description-1724546052")
              .setLocationUri("locationUri552310135")
              .putAllParameters(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHiveDatabase(hiveDatabase, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteHiveDatabaseTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NamespaceName name = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");

    client.deleteHiveDatabase(name);

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
  public void deleteHiveDatabaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NamespaceName name = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");
      client.deleteHiveDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteHiveDatabaseTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2808/catalogs/catalog-2808/databases/database-2808";

    client.deleteHiveDatabase(name);

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
  public void deleteHiveDatabaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2808/catalogs/catalog-2808/databases/database-2808";
      client.deleteHiveDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHiveTableTest() throws Exception {
    HiveTable expectedResponse =
        HiveTable.newBuilder()
            .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
            .setDescription("description-1724546052")
            .setStorageDescriptor(StorageDescriptor.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllPartitionKeys(new ArrayList<FieldSchema>())
            .putAllParameters(new HashMap<String, String>())
            .setTableType("tableType-1988515800")
            .build();
    mockService.addResponse(expectedResponse);

    NamespaceName parent = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");
    HiveTable hiveTable = HiveTable.newBuilder().build();
    String hiveTableId = "hiveTableId152241145";

    HiveTable actualResponse = client.createHiveTable(parent, hiveTable, hiveTableId);
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
  public void createHiveTableExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NamespaceName parent = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");
      HiveTable hiveTable = HiveTable.newBuilder().build();
      String hiveTableId = "hiveTableId152241145";
      client.createHiveTable(parent, hiveTable, hiveTableId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHiveTableTest2() throws Exception {
    HiveTable expectedResponse =
        HiveTable.newBuilder()
            .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
            .setDescription("description-1724546052")
            .setStorageDescriptor(StorageDescriptor.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllPartitionKeys(new ArrayList<FieldSchema>())
            .putAllParameters(new HashMap<String, String>())
            .setTableType("tableType-1988515800")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9879/catalogs/catalog-9879/databases/database-9879";
    HiveTable hiveTable = HiveTable.newBuilder().build();
    String hiveTableId = "hiveTableId152241145";

    HiveTable actualResponse = client.createHiveTable(parent, hiveTable, hiveTableId);
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
  public void createHiveTableExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9879/catalogs/catalog-9879/databases/database-9879";
      HiveTable hiveTable = HiveTable.newBuilder().build();
      String hiveTableId = "hiveTableId152241145";
      client.createHiveTable(parent, hiveTable, hiveTableId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHiveTableTest() throws Exception {
    HiveTable expectedResponse =
        HiveTable.newBuilder()
            .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
            .setDescription("description-1724546052")
            .setStorageDescriptor(StorageDescriptor.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllPartitionKeys(new ArrayList<FieldSchema>())
            .putAllParameters(new HashMap<String, String>())
            .setTableType("tableType-1988515800")
            .build();
    mockService.addResponse(expectedResponse);

    TableName name = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");

    HiveTable actualResponse = client.getHiveTable(name);
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
  public void getHiveTableExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TableName name = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");
      client.getHiveTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHiveTableTest2() throws Exception {
    HiveTable expectedResponse =
        HiveTable.newBuilder()
            .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
            .setDescription("description-1724546052")
            .setStorageDescriptor(StorageDescriptor.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllPartitionKeys(new ArrayList<FieldSchema>())
            .putAllParameters(new HashMap<String, String>())
            .setTableType("tableType-1988515800")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9385/catalogs/catalog-9385/databases/database-9385/tables/table-9385";

    HiveTable actualResponse = client.getHiveTable(name);
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
  public void getHiveTableExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9385/catalogs/catalog-9385/databases/database-9385/tables/table-9385";
      client.getHiveTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHiveTablesTest() throws Exception {
    HiveTable responsesElement = HiveTable.newBuilder().build();
    ListHiveTablesResponse expectedResponse =
        ListHiveTablesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTables(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NamespaceName parent = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");

    ListHiveTablesPagedResponse pagedListResponse = client.listHiveTables(parent);

    List<HiveTable> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTablesList().get(0), resources.get(0));

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
  public void listHiveTablesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NamespaceName parent = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");
      client.listHiveTables(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHiveTablesTest2() throws Exception {
    HiveTable responsesElement = HiveTable.newBuilder().build();
    ListHiveTablesResponse expectedResponse =
        ListHiveTablesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTables(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9879/catalogs/catalog-9879/databases/database-9879";

    ListHiveTablesPagedResponse pagedListResponse = client.listHiveTables(parent);

    List<HiveTable> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTablesList().get(0), resources.get(0));

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
  public void listHiveTablesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9879/catalogs/catalog-9879/databases/database-9879";
      client.listHiveTables(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateHiveTableTest() throws Exception {
    HiveTable expectedResponse =
        HiveTable.newBuilder()
            .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
            .setDescription("description-1724546052")
            .setStorageDescriptor(StorageDescriptor.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllPartitionKeys(new ArrayList<FieldSchema>())
            .putAllParameters(new HashMap<String, String>())
            .setTableType("tableType-1988515800")
            .build();
    mockService.addResponse(expectedResponse);

    HiveTable hiveTable =
        HiveTable.newBuilder()
            .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
            .setDescription("description-1724546052")
            .setStorageDescriptor(StorageDescriptor.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllPartitionKeys(new ArrayList<FieldSchema>())
            .putAllParameters(new HashMap<String, String>())
            .setTableType("tableType-1988515800")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    HiveTable actualResponse = client.updateHiveTable(hiveTable, updateMask);
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
  public void updateHiveTableExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      HiveTable hiveTable =
          HiveTable.newBuilder()
              .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
              .setDescription("description-1724546052")
              .setStorageDescriptor(StorageDescriptor.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .addAllPartitionKeys(new ArrayList<FieldSchema>())
              .putAllParameters(new HashMap<String, String>())
              .setTableType("tableType-1988515800")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHiveTable(hiveTable, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteHiveTableTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    TableName name = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");

    client.deleteHiveTable(name);

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
  public void deleteHiveTableExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TableName name = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");
      client.deleteHiveTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteHiveTableTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9385/catalogs/catalog-9385/databases/database-9385/tables/table-9385";

    client.deleteHiveTable(name);

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
  public void deleteHiveTableExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9385/catalogs/catalog-9385/databases/database-9385/tables/table-9385";
      client.deleteHiveTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreatePartitionsTest() throws Exception {
    BatchCreatePartitionsResponse expectedResponse =
        BatchCreatePartitionsResponse.newBuilder()
            .addAllPartitions(new ArrayList<Partition>())
            .build();
    mockService.addResponse(expectedResponse);

    TableName parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");

    BatchCreatePartitionsResponse actualResponse = client.batchCreatePartitions(parent);
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
  public void batchCreatePartitionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TableName parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");
      client.batchCreatePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreatePartitionsTest2() throws Exception {
    BatchCreatePartitionsResponse expectedResponse =
        BatchCreatePartitionsResponse.newBuilder()
            .addAllPartitions(new ArrayList<Partition>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-3670/catalogs/catalog-3670/databases/database-3670/tables/table-3670";

    BatchCreatePartitionsResponse actualResponse = client.batchCreatePartitions(parent);
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
  public void batchCreatePartitionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-3670/catalogs/catalog-3670/databases/database-3670/tables/table-3670";
      client.batchCreatePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeletePartitionsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    TableName parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");

    client.batchDeletePartitions(parent);

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
  public void batchDeletePartitionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TableName parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");
      client.batchDeletePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeletePartitionsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-3670/catalogs/catalog-3670/databases/database-3670/tables/table-3670";

    client.batchDeletePartitions(parent);

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
  public void batchDeletePartitionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-3670/catalogs/catalog-3670/databases/database-3670/tables/table-3670";
      client.batchDeletePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdatePartitionsTest() throws Exception {
    BatchUpdatePartitionsResponse expectedResponse =
        BatchUpdatePartitionsResponse.newBuilder()
            .addAllPartitions(new ArrayList<Partition>())
            .build();
    mockService.addResponse(expectedResponse);

    TableName parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");

    BatchUpdatePartitionsResponse actualResponse = client.batchUpdatePartitions(parent);
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
  public void batchUpdatePartitionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TableName parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");
      client.batchUpdatePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdatePartitionsTest2() throws Exception {
    BatchUpdatePartitionsResponse expectedResponse =
        BatchUpdatePartitionsResponse.newBuilder()
            .addAllPartitions(new ArrayList<Partition>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-3670/catalogs/catalog-3670/databases/database-3670/tables/table-3670";

    BatchUpdatePartitionsResponse actualResponse = client.batchUpdatePartitions(parent);
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
  public void batchUpdatePartitionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-3670/catalogs/catalog-3670/databases/database-3670/tables/table-3670";
      client.batchUpdatePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPartitionsTest() throws Exception {}

  @Test
  public void listPartitionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);
  }
}
