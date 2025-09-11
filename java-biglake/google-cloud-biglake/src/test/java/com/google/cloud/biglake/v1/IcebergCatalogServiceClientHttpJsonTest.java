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

package com.google.cloud.biglake.v1;

import static com.google.cloud.biglake.v1.IcebergCatalogServiceClient.ListIcebergCatalogsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.biglake.v1.stub.HttpJsonIcebergCatalogServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class IcebergCatalogServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static IcebergCatalogServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonIcebergCatalogServiceStub.getMethodDescriptors(),
            IcebergCatalogServiceSettings.getDefaultEndpoint());
    IcebergCatalogServiceSettings settings =
        IcebergCatalogServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                IcebergCatalogServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IcebergCatalogServiceClient.create(settings);
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
  public void getIcebergCatalogTest() throws Exception {
    IcebergCatalog expectedResponse =
        IcebergCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setBiglakeServiceAccount("biglakeServiceAccount-779711961")
            .setDefaultLocation("defaultLocation-395835114")
            .addAllCatalogRegions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");

    IcebergCatalog actualResponse = client.getIcebergCatalog(name);
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
  public void getIcebergCatalogExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");
      client.getIcebergCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIcebergCatalogTest2() throws Exception {
    IcebergCatalog expectedResponse =
        IcebergCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setBiglakeServiceAccount("biglakeServiceAccount-779711961")
            .setDefaultLocation("defaultLocation-395835114")
            .addAllCatalogRegions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9652/catalogs/catalog-9652";

    IcebergCatalog actualResponse = client.getIcebergCatalog(name);
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
  public void getIcebergCatalogExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9652/catalogs/catalog-9652";
      client.getIcebergCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIcebergCatalogsTest() throws Exception {
    IcebergCatalog responsesElement = IcebergCatalog.newBuilder().build();
    ListIcebergCatalogsResponse expectedResponse =
        ListIcebergCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIcebergCatalogs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListIcebergCatalogsPagedResponse pagedListResponse = client.listIcebergCatalogs(parent);

    List<IcebergCatalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIcebergCatalogsList().get(0), resources.get(0));

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
  public void listIcebergCatalogsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listIcebergCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIcebergCatalogsTest2() throws Exception {
    IcebergCatalog responsesElement = IcebergCatalog.newBuilder().build();
    ListIcebergCatalogsResponse expectedResponse =
        ListIcebergCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIcebergCatalogs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListIcebergCatalogsPagedResponse pagedListResponse = client.listIcebergCatalogs(parent);

    List<IcebergCatalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIcebergCatalogsList().get(0), resources.get(0));

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
  public void listIcebergCatalogsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      client.listIcebergCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateIcebergCatalogTest() throws Exception {
    IcebergCatalog expectedResponse =
        IcebergCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setBiglakeServiceAccount("biglakeServiceAccount-779711961")
            .setDefaultLocation("defaultLocation-395835114")
            .addAllCatalogRegions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    IcebergCatalog icebergCatalog =
        IcebergCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setBiglakeServiceAccount("biglakeServiceAccount-779711961")
            .setDefaultLocation("defaultLocation-395835114")
            .addAllCatalogRegions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    IcebergCatalog actualResponse = client.updateIcebergCatalog(icebergCatalog, updateMask);
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
  public void updateIcebergCatalogExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IcebergCatalog icebergCatalog =
          IcebergCatalog.newBuilder()
              .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
              .setBiglakeServiceAccount("biglakeServiceAccount-779711961")
              .setDefaultLocation("defaultLocation-395835114")
              .addAllCatalogRegions(new ArrayList<String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIcebergCatalog(icebergCatalog, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIcebergCatalogTest() throws Exception {
    IcebergCatalog expectedResponse =
        IcebergCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setBiglakeServiceAccount("biglakeServiceAccount-779711961")
            .setDefaultLocation("defaultLocation-395835114")
            .addAllCatalogRegions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    IcebergCatalog icebergCatalog = IcebergCatalog.newBuilder().build();
    String icebergCatalogId = "icebergCatalogId504062865";

    IcebergCatalog actualResponse =
        client.createIcebergCatalog(parent, icebergCatalog, icebergCatalogId);
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
  public void createIcebergCatalogExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      IcebergCatalog icebergCatalog = IcebergCatalog.newBuilder().build();
      String icebergCatalogId = "icebergCatalogId504062865";
      client.createIcebergCatalog(parent, icebergCatalog, icebergCatalogId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIcebergCatalogTest2() throws Exception {
    IcebergCatalog expectedResponse =
        IcebergCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setBiglakeServiceAccount("biglakeServiceAccount-779711961")
            .setDefaultLocation("defaultLocation-395835114")
            .addAllCatalogRegions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";
    IcebergCatalog icebergCatalog = IcebergCatalog.newBuilder().build();
    String icebergCatalogId = "icebergCatalogId504062865";

    IcebergCatalog actualResponse =
        client.createIcebergCatalog(parent, icebergCatalog, icebergCatalogId);
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
  public void createIcebergCatalogExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      IcebergCatalog icebergCatalog = IcebergCatalog.newBuilder().build();
      String icebergCatalogId = "icebergCatalogId504062865";
      client.createIcebergCatalog(parent, icebergCatalog, icebergCatalogId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void failoverIcebergCatalogTest() throws Exception {
    FailoverIcebergCatalogResponse expectedResponse =
        FailoverIcebergCatalogResponse.newBuilder()
            .setReplicationTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9652/catalogs/catalog-9652";
    String primaryReplica = "primaryReplica-389090218";

    FailoverIcebergCatalogResponse actualResponse =
        client.failoverIcebergCatalog(name, primaryReplica);
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
  public void failoverIcebergCatalogExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9652/catalogs/catalog-9652";
      String primaryReplica = "primaryReplica-389090218";
      client.failoverIcebergCatalog(name, primaryReplica);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
