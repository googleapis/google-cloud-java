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

package com.google.cloud.vmmigration.v1;

import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListCloneJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListCutoverJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListDatacenterConnectorsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListGroupsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListMigratingVmsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListSourcesPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListTargetProjectsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListUtilizationReportsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.vmmigration.v1.stub.HttpJsonVmMigrationStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
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
public class VmMigrationClientHttpJsonTest {
  private static MockHttpService mockService;
  private static VmMigrationClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonVmMigrationStub.getMethodDescriptors(),
            VmMigrationSettings.getDefaultEndpoint());
    VmMigrationSettings settings =
        VmMigrationSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                VmMigrationSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = VmMigrationClient.create(settings);
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
  public void listSourcesTest() throws Exception {
    Source responsesElement = Source.newBuilder().build();
    ListSourcesResponse expectedResponse =
        ListSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSourcesPagedResponse pagedListResponse = client.listSources(parent);

    List<Source> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSourcesList().get(0), resources.get(0));

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
  public void listSourcesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSourcesTest2() throws Exception {
    Source responsesElement = Source.newBuilder().build();
    ListSourcesResponse expectedResponse =
        ListSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListSourcesPagedResponse pagedListResponse = client.listSources(parent);

    List<Source> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSourcesList().get(0), resources.get(0));

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
  public void listSourcesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSourceTest() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");

    Source actualResponse = client.getSource(name);
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
  public void getSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
      client.getSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSourceTest2() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2226/locations/location-2226/sources/source-2226";

    Source actualResponse = client.getSource(name);
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
  public void getSourceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2226/locations/location-2226/sources/source-2226";
      client.getSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSourceTest() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Source source = Source.newBuilder().build();
    String sourceId = "sourceId1746327190";

    Source actualResponse = client.createSourceAsync(parent, source, sourceId).get();
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
  public void createSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Source source = Source.newBuilder().build();
      String sourceId = "sourceId1746327190";
      client.createSourceAsync(parent, source, sourceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createSourceTest2() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Source source = Source.newBuilder().build();
    String sourceId = "sourceId1746327190";

    Source actualResponse = client.createSourceAsync(parent, source, sourceId).get();
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
  public void createSourceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Source source = Source.newBuilder().build();
      String sourceId = "sourceId1746327190";
      client.createSourceAsync(parent, source, sourceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateSourceTest() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Source source =
        Source.newBuilder()
            .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Source actualResponse = client.updateSourceAsync(source, updateMask).get();
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
  public void updateSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Source source =
          Source.newBuilder()
              .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setDescription("description-1724546052")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSourceAsync(source, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSourceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");

    client.deleteSourceAsync(name).get();

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
  public void deleteSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
      client.deleteSourceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSourceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-2226/locations/location-2226/sources/source-2226";

    client.deleteSourceAsync(name).get();

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
  public void deleteSourceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2226/locations/location-2226/sources/source-2226";
      client.deleteSourceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void fetchInventoryTest() throws Exception {
    FetchInventoryResponse expectedResponse =
        FetchInventoryResponse.newBuilder().setUpdateTime(Timestamp.newBuilder().build()).build();
    mockService.addResponse(expectedResponse);

    SourceName source = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");

    FetchInventoryResponse actualResponse = client.fetchInventory(source);
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
  public void fetchInventoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SourceName source = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
      client.fetchInventory(source);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchInventoryTest2() throws Exception {
    FetchInventoryResponse expectedResponse =
        FetchInventoryResponse.newBuilder().setUpdateTime(Timestamp.newBuilder().build()).build();
    mockService.addResponse(expectedResponse);

    String source = "projects/project-3586/locations/location-3586/sources/source-3586";

    FetchInventoryResponse actualResponse = client.fetchInventory(source);
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
  public void fetchInventoryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String source = "projects/project-3586/locations/location-3586/sources/source-3586";
      client.fetchInventory(source);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUtilizationReportsTest() throws Exception {
    UtilizationReport responsesElement = UtilizationReport.newBuilder().build();
    ListUtilizationReportsResponse expectedResponse =
        ListUtilizationReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUtilizationReports(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");

    ListUtilizationReportsPagedResponse pagedListResponse = client.listUtilizationReports(parent);

    List<UtilizationReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUtilizationReportsList().get(0), resources.get(0));

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
  public void listUtilizationReportsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
      client.listUtilizationReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUtilizationReportsTest2() throws Exception {
    UtilizationReport responsesElement = UtilizationReport.newBuilder().build();
    ListUtilizationReportsResponse expectedResponse =
        ListUtilizationReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUtilizationReports(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8435/locations/location-8435/sources/source-8435";

    ListUtilizationReportsPagedResponse pagedListResponse = client.listUtilizationReports(parent);

    List<UtilizationReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUtilizationReportsList().get(0), resources.get(0));

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
  public void listUtilizationReportsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8435/locations/location-8435/sources/source-8435";
      client.listUtilizationReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUtilizationReportTest() throws Exception {
    UtilizationReport expectedResponse =
        UtilizationReport.newBuilder()
            .setName(
                UtilizationReportName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setStateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setFrameEndTime(Timestamp.newBuilder().build())
            .setVmCount(261463431)
            .addAllVms(new ArrayList<VmUtilizationInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    UtilizationReportName name =
        UtilizationReportName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]");

    UtilizationReport actualResponse = client.getUtilizationReport(name);
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
  public void getUtilizationReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UtilizationReportName name =
          UtilizationReportName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]");
      client.getUtilizationReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUtilizationReportTest2() throws Exception {
    UtilizationReport expectedResponse =
        UtilizationReport.newBuilder()
            .setName(
                UtilizationReportName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setStateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setFrameEndTime(Timestamp.newBuilder().build())
            .setVmCount(261463431)
            .addAllVms(new ArrayList<VmUtilizationInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8681/locations/location-8681/sources/source-8681/utilizationReports/utilizationReport-8681";

    UtilizationReport actualResponse = client.getUtilizationReport(name);
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
  public void getUtilizationReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8681/locations/location-8681/sources/source-8681/utilizationReports/utilizationReport-8681";
      client.getUtilizationReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUtilizationReportTest() throws Exception {
    UtilizationReport expectedResponse =
        UtilizationReport.newBuilder()
            .setName(
                UtilizationReportName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setStateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setFrameEndTime(Timestamp.newBuilder().build())
            .setVmCount(261463431)
            .addAllVms(new ArrayList<VmUtilizationInfo>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createUtilizationReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
    UtilizationReport utilizationReport = UtilizationReport.newBuilder().build();
    String utilizationReportId = "utilizationReportId1215771057";

    UtilizationReport actualResponse =
        client.createUtilizationReportAsync(parent, utilizationReport, utilizationReportId).get();
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
  public void createUtilizationReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
      UtilizationReport utilizationReport = UtilizationReport.newBuilder().build();
      String utilizationReportId = "utilizationReportId1215771057";
      client.createUtilizationReportAsync(parent, utilizationReport, utilizationReportId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createUtilizationReportTest2() throws Exception {
    UtilizationReport expectedResponse =
        UtilizationReport.newBuilder()
            .setName(
                UtilizationReportName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setStateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setFrameEndTime(Timestamp.newBuilder().build())
            .setVmCount(261463431)
            .addAllVms(new ArrayList<VmUtilizationInfo>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createUtilizationReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-8435/locations/location-8435/sources/source-8435";
    UtilizationReport utilizationReport = UtilizationReport.newBuilder().build();
    String utilizationReportId = "utilizationReportId1215771057";

    UtilizationReport actualResponse =
        client.createUtilizationReportAsync(parent, utilizationReport, utilizationReportId).get();
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
  public void createUtilizationReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8435/locations/location-8435/sources/source-8435";
      UtilizationReport utilizationReport = UtilizationReport.newBuilder().build();
      String utilizationReportId = "utilizationReportId1215771057";
      client.createUtilizationReportAsync(parent, utilizationReport, utilizationReportId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteUtilizationReportTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteUtilizationReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    UtilizationReportName name =
        UtilizationReportName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]");

    client.deleteUtilizationReportAsync(name).get();

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
  public void deleteUtilizationReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UtilizationReportName name =
          UtilizationReportName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]");
      client.deleteUtilizationReportAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteUtilizationReportTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteUtilizationReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8681/locations/location-8681/sources/source-8681/utilizationReports/utilizationReport-8681";

    client.deleteUtilizationReportAsync(name).get();

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
  public void deleteUtilizationReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8681/locations/location-8681/sources/source-8681/utilizationReports/utilizationReport-8681";
      client.deleteUtilizationReportAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listDatacenterConnectorsTest() throws Exception {
    DatacenterConnector responsesElement = DatacenterConnector.newBuilder().build();
    ListDatacenterConnectorsResponse expectedResponse =
        ListDatacenterConnectorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatacenterConnectors(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");

    ListDatacenterConnectorsPagedResponse pagedListResponse =
        client.listDatacenterConnectors(parent);

    List<DatacenterConnector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatacenterConnectorsList().get(0), resources.get(0));

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
  public void listDatacenterConnectorsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
      client.listDatacenterConnectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatacenterConnectorsTest2() throws Exception {
    DatacenterConnector responsesElement = DatacenterConnector.newBuilder().build();
    ListDatacenterConnectorsResponse expectedResponse =
        ListDatacenterConnectorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatacenterConnectors(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8435/locations/location-8435/sources/source-8435";

    ListDatacenterConnectorsPagedResponse pagedListResponse =
        client.listDatacenterConnectors(parent);

    List<DatacenterConnector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatacenterConnectorsList().get(0), resources.get(0));

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
  public void listDatacenterConnectorsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8435/locations/location-8435/sources/source-8435";
      client.listDatacenterConnectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatacenterConnectorTest() throws Exception {
    DatacenterConnector expectedResponse =
        DatacenterConnector.newBuilder()
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setName(
                DatacenterConnectorName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
                    .toString())
            .setRegistrationId("registrationId-567498828")
            .setServiceAccount("serviceAccount1079137720")
            .setVersion("version351608024")
            .setBucket("bucket-1378203158")
            .setStateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setApplianceInfrastructureVersion("applianceInfrastructureVersion560843272")
            .setApplianceSoftwareVersion("applianceSoftwareVersion-1982719036")
            .setAvailableVersions(AvailableUpdates.newBuilder().build())
            .setUpgradeStatus(UpgradeStatus.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DatacenterConnectorName name =
        DatacenterConnectorName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]");

    DatacenterConnector actualResponse = client.getDatacenterConnector(name);
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
  public void getDatacenterConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatacenterConnectorName name =
          DatacenterConnectorName.of(
              "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]");
      client.getDatacenterConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatacenterConnectorTest2() throws Exception {
    DatacenterConnector expectedResponse =
        DatacenterConnector.newBuilder()
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setName(
                DatacenterConnectorName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
                    .toString())
            .setRegistrationId("registrationId-567498828")
            .setServiceAccount("serviceAccount1079137720")
            .setVersion("version351608024")
            .setBucket("bucket-1378203158")
            .setStateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setApplianceInfrastructureVersion("applianceInfrastructureVersion560843272")
            .setApplianceSoftwareVersion("applianceSoftwareVersion-1982719036")
            .setAvailableVersions(AvailableUpdates.newBuilder().build())
            .setUpgradeStatus(UpgradeStatus.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9617/locations/location-9617/sources/source-9617/datacenterConnectors/datacenterConnector-9617";

    DatacenterConnector actualResponse = client.getDatacenterConnector(name);
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
  public void getDatacenterConnectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9617/locations/location-9617/sources/source-9617/datacenterConnectors/datacenterConnector-9617";
      client.getDatacenterConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDatacenterConnectorTest() throws Exception {
    DatacenterConnector expectedResponse =
        DatacenterConnector.newBuilder()
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setName(
                DatacenterConnectorName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
                    .toString())
            .setRegistrationId("registrationId-567498828")
            .setServiceAccount("serviceAccount1079137720")
            .setVersion("version351608024")
            .setBucket("bucket-1378203158")
            .setStateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setApplianceInfrastructureVersion("applianceInfrastructureVersion560843272")
            .setApplianceSoftwareVersion("applianceSoftwareVersion-1982719036")
            .setAvailableVersions(AvailableUpdates.newBuilder().build())
            .setUpgradeStatus(UpgradeStatus.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatacenterConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
    DatacenterConnector datacenterConnector = DatacenterConnector.newBuilder().build();
    String datacenterConnectorId = "datacenterConnectorId-761889719";

    DatacenterConnector actualResponse =
        client
            .createDatacenterConnectorAsync(parent, datacenterConnector, datacenterConnectorId)
            .get();
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
  public void createDatacenterConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
      DatacenterConnector datacenterConnector = DatacenterConnector.newBuilder().build();
      String datacenterConnectorId = "datacenterConnectorId-761889719";
      client
          .createDatacenterConnectorAsync(parent, datacenterConnector, datacenterConnectorId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createDatacenterConnectorTest2() throws Exception {
    DatacenterConnector expectedResponse =
        DatacenterConnector.newBuilder()
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setName(
                DatacenterConnectorName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
                    .toString())
            .setRegistrationId("registrationId-567498828")
            .setServiceAccount("serviceAccount1079137720")
            .setVersion("version351608024")
            .setBucket("bucket-1378203158")
            .setStateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .setApplianceInfrastructureVersion("applianceInfrastructureVersion560843272")
            .setApplianceSoftwareVersion("applianceSoftwareVersion-1982719036")
            .setAvailableVersions(AvailableUpdates.newBuilder().build())
            .setUpgradeStatus(UpgradeStatus.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatacenterConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-8435/locations/location-8435/sources/source-8435";
    DatacenterConnector datacenterConnector = DatacenterConnector.newBuilder().build();
    String datacenterConnectorId = "datacenterConnectorId-761889719";

    DatacenterConnector actualResponse =
        client
            .createDatacenterConnectorAsync(parent, datacenterConnector, datacenterConnectorId)
            .get();
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
  public void createDatacenterConnectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8435/locations/location-8435/sources/source-8435";
      DatacenterConnector datacenterConnector = DatacenterConnector.newBuilder().build();
      String datacenterConnectorId = "datacenterConnectorId-761889719";
      client
          .createDatacenterConnectorAsync(parent, datacenterConnector, datacenterConnectorId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDatacenterConnectorTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDatacenterConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DatacenterConnectorName name =
        DatacenterConnectorName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]");

    client.deleteDatacenterConnectorAsync(name).get();

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
  public void deleteDatacenterConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatacenterConnectorName name =
          DatacenterConnectorName.of(
              "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]");
      client.deleteDatacenterConnectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDatacenterConnectorTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDatacenterConnectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-9617/locations/location-9617/sources/source-9617/datacenterConnectors/datacenterConnector-9617";

    client.deleteDatacenterConnectorAsync(name).get();

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
  public void deleteDatacenterConnectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9617/locations/location-9617/sources/source-9617/datacenterConnectors/datacenterConnector-9617";
      client.deleteDatacenterConnectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void upgradeApplianceTest() throws Exception {
    UpgradeApplianceResponse expectedResponse = UpgradeApplianceResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("upgradeApplianceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    UpgradeApplianceRequest request =
        UpgradeApplianceRequest.newBuilder()
            .setDatacenterConnector(
                DatacenterConnectorName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
                    .toString())
            .setRequestId("requestId693933066")
            .build();

    UpgradeApplianceResponse actualResponse = client.upgradeApplianceAsync(request).get();
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
  public void upgradeApplianceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpgradeApplianceRequest request =
          UpgradeApplianceRequest.newBuilder()
              .setDatacenterConnector(
                  DatacenterConnectorName.of(
                          "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
                      .toString())
              .setRequestId("requestId693933066")
              .build();
      client.upgradeApplianceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createMigratingVmTest() throws Exception {
    MigratingVm expectedResponse =
        MigratingVm.newBuilder()
            .setName(
                MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
                    .toString())
            .setSourceVmId("sourceVmId-1111384851")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicy(SchedulePolicy.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastSync(ReplicationSync.newBuilder().build())
            .setStateTime(Timestamp.newBuilder().build())
            .setCurrentSyncInfo(ReplicationCycle.newBuilder().build())
            .setGroup(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllRecentCloneJobs(new ArrayList<CloneJob>())
            .setError(Status.newBuilder().build())
            .addAllRecentCutoverJobs(new ArrayList<CutoverJob>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMigratingVmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
    MigratingVm migratingVm = MigratingVm.newBuilder().build();
    String migratingVmId = "migratingVmId441244154";

    MigratingVm actualResponse =
        client.createMigratingVmAsync(parent, migratingVm, migratingVmId).get();
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
  public void createMigratingVmExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
      MigratingVm migratingVm = MigratingVm.newBuilder().build();
      String migratingVmId = "migratingVmId441244154";
      client.createMigratingVmAsync(parent, migratingVm, migratingVmId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createMigratingVmTest2() throws Exception {
    MigratingVm expectedResponse =
        MigratingVm.newBuilder()
            .setName(
                MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
                    .toString())
            .setSourceVmId("sourceVmId-1111384851")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicy(SchedulePolicy.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastSync(ReplicationSync.newBuilder().build())
            .setStateTime(Timestamp.newBuilder().build())
            .setCurrentSyncInfo(ReplicationCycle.newBuilder().build())
            .setGroup(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllRecentCloneJobs(new ArrayList<CloneJob>())
            .setError(Status.newBuilder().build())
            .addAllRecentCutoverJobs(new ArrayList<CutoverJob>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMigratingVmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-8435/locations/location-8435/sources/source-8435";
    MigratingVm migratingVm = MigratingVm.newBuilder().build();
    String migratingVmId = "migratingVmId441244154";

    MigratingVm actualResponse =
        client.createMigratingVmAsync(parent, migratingVm, migratingVmId).get();
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
  public void createMigratingVmExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8435/locations/location-8435/sources/source-8435";
      MigratingVm migratingVm = MigratingVm.newBuilder().build();
      String migratingVmId = "migratingVmId441244154";
      client.createMigratingVmAsync(parent, migratingVm, migratingVmId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listMigratingVmsTest() throws Exception {
    MigratingVm responsesElement = MigratingVm.newBuilder().build();
    ListMigratingVmsResponse expectedResponse =
        ListMigratingVmsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMigratingVms(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");

    ListMigratingVmsPagedResponse pagedListResponse = client.listMigratingVms(parent);

    List<MigratingVm> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMigratingVmsList().get(0), resources.get(0));

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
  public void listMigratingVmsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
      client.listMigratingVms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMigratingVmsTest2() throws Exception {
    MigratingVm responsesElement = MigratingVm.newBuilder().build();
    ListMigratingVmsResponse expectedResponse =
        ListMigratingVmsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMigratingVms(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8435/locations/location-8435/sources/source-8435";

    ListMigratingVmsPagedResponse pagedListResponse = client.listMigratingVms(parent);

    List<MigratingVm> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMigratingVmsList().get(0), resources.get(0));

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
  public void listMigratingVmsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8435/locations/location-8435/sources/source-8435";
      client.listMigratingVms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMigratingVmTest() throws Exception {
    MigratingVm expectedResponse =
        MigratingVm.newBuilder()
            .setName(
                MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
                    .toString())
            .setSourceVmId("sourceVmId-1111384851")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicy(SchedulePolicy.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastSync(ReplicationSync.newBuilder().build())
            .setStateTime(Timestamp.newBuilder().build())
            .setCurrentSyncInfo(ReplicationCycle.newBuilder().build())
            .setGroup(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllRecentCloneJobs(new ArrayList<CloneJob>())
            .setError(Status.newBuilder().build())
            .addAllRecentCutoverJobs(new ArrayList<CutoverJob>())
            .build();
    mockService.addResponse(expectedResponse);

    MigratingVmName name =
        MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");

    MigratingVm actualResponse = client.getMigratingVm(name);
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
  public void getMigratingVmExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MigratingVmName name =
          MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
      client.getMigratingVm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMigratingVmTest2() throws Exception {
    MigratingVm expectedResponse =
        MigratingVm.newBuilder()
            .setName(
                MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
                    .toString())
            .setSourceVmId("sourceVmId-1111384851")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicy(SchedulePolicy.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastSync(ReplicationSync.newBuilder().build())
            .setStateTime(Timestamp.newBuilder().build())
            .setCurrentSyncInfo(ReplicationCycle.newBuilder().build())
            .setGroup(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllRecentCloneJobs(new ArrayList<CloneJob>())
            .setError(Status.newBuilder().build())
            .addAllRecentCutoverJobs(new ArrayList<CutoverJob>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7504/locations/location-7504/sources/source-7504/migratingVms/migratingVm-7504";

    MigratingVm actualResponse = client.getMigratingVm(name);
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
  public void getMigratingVmExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7504/locations/location-7504/sources/source-7504/migratingVms/migratingVm-7504";
      client.getMigratingVm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateMigratingVmTest() throws Exception {
    MigratingVm expectedResponse =
        MigratingVm.newBuilder()
            .setName(
                MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
                    .toString())
            .setSourceVmId("sourceVmId-1111384851")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicy(SchedulePolicy.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastSync(ReplicationSync.newBuilder().build())
            .setStateTime(Timestamp.newBuilder().build())
            .setCurrentSyncInfo(ReplicationCycle.newBuilder().build())
            .setGroup(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllRecentCloneJobs(new ArrayList<CloneJob>())
            .setError(Status.newBuilder().build())
            .addAllRecentCutoverJobs(new ArrayList<CutoverJob>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMigratingVmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    MigratingVm migratingVm =
        MigratingVm.newBuilder()
            .setName(
                MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
                    .toString())
            .setSourceVmId("sourceVmId-1111384851")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicy(SchedulePolicy.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastSync(ReplicationSync.newBuilder().build())
            .setStateTime(Timestamp.newBuilder().build())
            .setCurrentSyncInfo(ReplicationCycle.newBuilder().build())
            .setGroup(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .putAllLabels(new HashMap<String, String>())
            .addAllRecentCloneJobs(new ArrayList<CloneJob>())
            .setError(Status.newBuilder().build())
            .addAllRecentCutoverJobs(new ArrayList<CutoverJob>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MigratingVm actualResponse = client.updateMigratingVmAsync(migratingVm, updateMask).get();
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
  public void updateMigratingVmExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MigratingVm migratingVm =
          MigratingVm.newBuilder()
              .setName(
                  MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
                      .toString())
              .setSourceVmId("sourceVmId-1111384851")
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setPolicy(SchedulePolicy.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setLastSync(ReplicationSync.newBuilder().build())
              .setStateTime(Timestamp.newBuilder().build())
              .setCurrentSyncInfo(ReplicationCycle.newBuilder().build())
              .setGroup(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .putAllLabels(new HashMap<String, String>())
              .addAllRecentCloneJobs(new ArrayList<CloneJob>())
              .setError(Status.newBuilder().build())
              .addAllRecentCutoverJobs(new ArrayList<CutoverJob>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMigratingVmAsync(migratingVm, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteMigratingVmTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMigratingVmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    MigratingVmName name =
        MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");

    client.deleteMigratingVmAsync(name).get();

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
  public void deleteMigratingVmExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MigratingVmName name =
          MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
      client.deleteMigratingVmAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteMigratingVmTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMigratingVmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-7504/locations/location-7504/sources/source-7504/migratingVms/migratingVm-7504";

    client.deleteMigratingVmAsync(name).get();

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
  public void deleteMigratingVmExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7504/locations/location-7504/sources/source-7504/migratingVms/migratingVm-7504";
      client.deleteMigratingVmAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void startMigrationTest() throws Exception {
    StartMigrationResponse expectedResponse = StartMigrationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startMigrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    MigratingVmName migratingVm =
        MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");

    StartMigrationResponse actualResponse = client.startMigrationAsync(migratingVm).get();
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
  public void startMigrationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MigratingVmName migratingVm =
          MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
      client.startMigrationAsync(migratingVm).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void startMigrationTest2() throws Exception {
    StartMigrationResponse expectedResponse = StartMigrationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startMigrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String migratingVm =
        "projects/project-6708/locations/location-6708/sources/source-6708/migratingVms/migratingVm-6708";

    StartMigrationResponse actualResponse = client.startMigrationAsync(migratingVm).get();
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
  public void startMigrationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String migratingVm =
          "projects/project-6708/locations/location-6708/sources/source-6708/migratingVms/migratingVm-6708";
      client.startMigrationAsync(migratingVm).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void resumeMigrationTest() throws Exception {
    ResumeMigrationResponse expectedResponse = ResumeMigrationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resumeMigrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ResumeMigrationRequest request =
        ResumeMigrationRequest.newBuilder()
            .setMigratingVm(
                MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
                    .toString())
            .build();

    ResumeMigrationResponse actualResponse = client.resumeMigrationAsync(request).get();
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
  public void resumeMigrationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResumeMigrationRequest request =
          ResumeMigrationRequest.newBuilder()
              .setMigratingVm(
                  MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
                      .toString())
              .build();
      client.resumeMigrationAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void pauseMigrationTest() throws Exception {
    PauseMigrationResponse expectedResponse = PauseMigrationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("pauseMigrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PauseMigrationRequest request =
        PauseMigrationRequest.newBuilder()
            .setMigratingVm(
                MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
                    .toString())
            .build();

    PauseMigrationResponse actualResponse = client.pauseMigrationAsync(request).get();
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
  public void pauseMigrationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PauseMigrationRequest request =
          PauseMigrationRequest.newBuilder()
              .setMigratingVm(
                  MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
                      .toString())
              .build();
      client.pauseMigrationAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void finalizeMigrationTest() throws Exception {
    FinalizeMigrationResponse expectedResponse = FinalizeMigrationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("finalizeMigrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    MigratingVmName migratingVm =
        MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");

    FinalizeMigrationResponse actualResponse = client.finalizeMigrationAsync(migratingVm).get();
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
  public void finalizeMigrationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MigratingVmName migratingVm =
          MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
      client.finalizeMigrationAsync(migratingVm).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void finalizeMigrationTest2() throws Exception {
    FinalizeMigrationResponse expectedResponse = FinalizeMigrationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("finalizeMigrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String migratingVm =
        "projects/project-6708/locations/location-6708/sources/source-6708/migratingVms/migratingVm-6708";

    FinalizeMigrationResponse actualResponse = client.finalizeMigrationAsync(migratingVm).get();
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
  public void finalizeMigrationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String migratingVm =
          "projects/project-6708/locations/location-6708/sources/source-6708/migratingVms/migratingVm-6708";
      client.finalizeMigrationAsync(migratingVm).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCloneJobTest() throws Exception {
    CloneJob expectedResponse =
        CloneJob.newBuilder()
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setName(
                CloneJobName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
                    .toString())
            .setStateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCloneJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    MigratingVmName parent =
        MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
    CloneJob cloneJob = CloneJob.newBuilder().build();
    String cloneJobId = "cloneJobId2071309915";

    CloneJob actualResponse = client.createCloneJobAsync(parent, cloneJob, cloneJobId).get();
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
  public void createCloneJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MigratingVmName parent =
          MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
      CloneJob cloneJob = CloneJob.newBuilder().build();
      String cloneJobId = "cloneJobId2071309915";
      client.createCloneJobAsync(parent, cloneJob, cloneJobId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCloneJobTest2() throws Exception {
    CloneJob expectedResponse =
        CloneJob.newBuilder()
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setName(
                CloneJobName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
                    .toString())
            .setStateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCloneJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-9743/locations/location-9743/sources/source-9743/migratingVms/migratingVm-9743";
    CloneJob cloneJob = CloneJob.newBuilder().build();
    String cloneJobId = "cloneJobId2071309915";

    CloneJob actualResponse = client.createCloneJobAsync(parent, cloneJob, cloneJobId).get();
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
  public void createCloneJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9743/locations/location-9743/sources/source-9743/migratingVms/migratingVm-9743";
      CloneJob cloneJob = CloneJob.newBuilder().build();
      String cloneJobId = "cloneJobId2071309915";
      client.createCloneJobAsync(parent, cloneJob, cloneJobId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void cancelCloneJobTest() throws Exception {
    CancelCloneJobResponse expectedResponse = CancelCloneJobResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("cancelCloneJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CloneJobName name =
        CloneJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]");

    CancelCloneJobResponse actualResponse = client.cancelCloneJobAsync(name).get();
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
  public void cancelCloneJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloneJobName name =
          CloneJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]");
      client.cancelCloneJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void cancelCloneJobTest2() throws Exception {
    CancelCloneJobResponse expectedResponse = CancelCloneJobResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("cancelCloneJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-7919/locations/location-7919/sources/source-7919/migratingVms/migratingVm-7919/cloneJobs/cloneJob-7919";

    CancelCloneJobResponse actualResponse = client.cancelCloneJobAsync(name).get();
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
  public void cancelCloneJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7919/locations/location-7919/sources/source-7919/migratingVms/migratingVm-7919/cloneJobs/cloneJob-7919";
      client.cancelCloneJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listCloneJobsTest() throws Exception {
    CloneJob responsesElement = CloneJob.newBuilder().build();
    ListCloneJobsResponse expectedResponse =
        ListCloneJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloneJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    MigratingVmName parent =
        MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");

    ListCloneJobsPagedResponse pagedListResponse = client.listCloneJobs(parent);

    List<CloneJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloneJobsList().get(0), resources.get(0));

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
  public void listCloneJobsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MigratingVmName parent =
          MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
      client.listCloneJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCloneJobsTest2() throws Exception {
    CloneJob responsesElement = CloneJob.newBuilder().build();
    ListCloneJobsResponse expectedResponse =
        ListCloneJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloneJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-9743/locations/location-9743/sources/source-9743/migratingVms/migratingVm-9743";

    ListCloneJobsPagedResponse pagedListResponse = client.listCloneJobs(parent);

    List<CloneJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloneJobsList().get(0), resources.get(0));

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
  public void listCloneJobsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9743/locations/location-9743/sources/source-9743/migratingVms/migratingVm-9743";
      client.listCloneJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloneJobTest() throws Exception {
    CloneJob expectedResponse =
        CloneJob.newBuilder()
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setName(
                CloneJobName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
                    .toString())
            .setStateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CloneJobName name =
        CloneJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]");

    CloneJob actualResponse = client.getCloneJob(name);
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
  public void getCloneJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloneJobName name =
          CloneJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]");
      client.getCloneJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloneJobTest2() throws Exception {
    CloneJob expectedResponse =
        CloneJob.newBuilder()
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setName(
                CloneJobName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
                    .toString())
            .setStateTime(Timestamp.newBuilder().build())
            .setError(Status.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7919/locations/location-7919/sources/source-7919/migratingVms/migratingVm-7919/cloneJobs/cloneJob-7919";

    CloneJob actualResponse = client.getCloneJob(name);
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
  public void getCloneJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7919/locations/location-7919/sources/source-7919/migratingVms/migratingVm-7919/cloneJobs/cloneJob-7919";
      client.getCloneJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCutoverJobTest() throws Exception {
    CutoverJob expectedResponse =
        CutoverJob.newBuilder()
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setName(
                CutoverJobName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
                    .toString())
            .setStateTime(Timestamp.newBuilder().build())
            .setProgressPercent(-2137894861)
            .setError(Status.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCutoverJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    MigratingVmName parent =
        MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
    CutoverJob cutoverJob = CutoverJob.newBuilder().build();
    String cutoverJobId = "cutoverJobId-2003089086";

    CutoverJob actualResponse =
        client.createCutoverJobAsync(parent, cutoverJob, cutoverJobId).get();
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
  public void createCutoverJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MigratingVmName parent =
          MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
      CutoverJob cutoverJob = CutoverJob.newBuilder().build();
      String cutoverJobId = "cutoverJobId-2003089086";
      client.createCutoverJobAsync(parent, cutoverJob, cutoverJobId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCutoverJobTest2() throws Exception {
    CutoverJob expectedResponse =
        CutoverJob.newBuilder()
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setName(
                CutoverJobName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
                    .toString())
            .setStateTime(Timestamp.newBuilder().build())
            .setProgressPercent(-2137894861)
            .setError(Status.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCutoverJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-9743/locations/location-9743/sources/source-9743/migratingVms/migratingVm-9743";
    CutoverJob cutoverJob = CutoverJob.newBuilder().build();
    String cutoverJobId = "cutoverJobId-2003089086";

    CutoverJob actualResponse =
        client.createCutoverJobAsync(parent, cutoverJob, cutoverJobId).get();
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
  public void createCutoverJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9743/locations/location-9743/sources/source-9743/migratingVms/migratingVm-9743";
      CutoverJob cutoverJob = CutoverJob.newBuilder().build();
      String cutoverJobId = "cutoverJobId-2003089086";
      client.createCutoverJobAsync(parent, cutoverJob, cutoverJobId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void cancelCutoverJobTest() throws Exception {
    CancelCutoverJobResponse expectedResponse = CancelCutoverJobResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("cancelCutoverJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CutoverJobName name =
        CutoverJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]");

    CancelCutoverJobResponse actualResponse = client.cancelCutoverJobAsync(name).get();
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
  public void cancelCutoverJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CutoverJobName name =
          CutoverJobName.of(
              "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]");
      client.cancelCutoverJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void cancelCutoverJobTest2() throws Exception {
    CancelCutoverJobResponse expectedResponse = CancelCutoverJobResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("cancelCutoverJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-7848/locations/location-7848/sources/source-7848/migratingVms/migratingVm-7848/cutoverJobs/cutoverJob-7848";

    CancelCutoverJobResponse actualResponse = client.cancelCutoverJobAsync(name).get();
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
  public void cancelCutoverJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7848/locations/location-7848/sources/source-7848/migratingVms/migratingVm-7848/cutoverJobs/cutoverJob-7848";
      client.cancelCutoverJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listCutoverJobsTest() throws Exception {
    CutoverJob responsesElement = CutoverJob.newBuilder().build();
    ListCutoverJobsResponse expectedResponse =
        ListCutoverJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCutoverJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    MigratingVmName parent =
        MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");

    ListCutoverJobsPagedResponse pagedListResponse = client.listCutoverJobs(parent);

    List<CutoverJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCutoverJobsList().get(0), resources.get(0));

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
  public void listCutoverJobsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MigratingVmName parent =
          MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
      client.listCutoverJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCutoverJobsTest2() throws Exception {
    CutoverJob responsesElement = CutoverJob.newBuilder().build();
    ListCutoverJobsResponse expectedResponse =
        ListCutoverJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCutoverJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-9743/locations/location-9743/sources/source-9743/migratingVms/migratingVm-9743";

    ListCutoverJobsPagedResponse pagedListResponse = client.listCutoverJobs(parent);

    List<CutoverJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCutoverJobsList().get(0), resources.get(0));

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
  public void listCutoverJobsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9743/locations/location-9743/sources/source-9743/migratingVms/migratingVm-9743";
      client.listCutoverJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCutoverJobTest() throws Exception {
    CutoverJob expectedResponse =
        CutoverJob.newBuilder()
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setName(
                CutoverJobName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
                    .toString())
            .setStateTime(Timestamp.newBuilder().build())
            .setProgressPercent(-2137894861)
            .setError(Status.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .build();
    mockService.addResponse(expectedResponse);

    CutoverJobName name =
        CutoverJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]");

    CutoverJob actualResponse = client.getCutoverJob(name);
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
  public void getCutoverJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CutoverJobName name =
          CutoverJobName.of(
              "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]");
      client.getCutoverJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCutoverJobTest2() throws Exception {
    CutoverJob expectedResponse =
        CutoverJob.newBuilder()
            .setCreateTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setName(
                CutoverJobName.of(
                        "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
                    .toString())
            .setStateTime(Timestamp.newBuilder().build())
            .setProgressPercent(-2137894861)
            .setError(Status.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7848/locations/location-7848/sources/source-7848/migratingVms/migratingVm-7848/cutoverJobs/cutoverJob-7848";

    CutoverJob actualResponse = client.getCutoverJob(name);
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
  public void getCutoverJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7848/locations/location-7848/sources/source-7848/migratingVms/migratingVm-7848/cutoverJobs/cutoverJob-7848";
      client.getCutoverJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGroupsTest() throws Exception {
    Group responsesElement = Group.newBuilder().build();
    ListGroupsResponse expectedResponse =
        ListGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGroups(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGroupsPagedResponse pagedListResponse = client.listGroups(parent);

    List<Group> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupsList().get(0), resources.get(0));

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
  public void listGroupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGroupsTest2() throws Exception {
    Group responsesElement = Group.newBuilder().build();
    ListGroupsResponse expectedResponse =
        ListGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGroups(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListGroupsPagedResponse pagedListResponse = client.listGroups(parent);

    List<Group> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupsList().get(0), resources.get(0));

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
  public void listGroupsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGroupTest() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    GroupName name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");

    Group actualResponse = client.getGroup(name);
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
  public void getGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GroupName name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
      client.getGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGroupTest2() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7380/locations/location-7380/groups/group-7380";

    Group actualResponse = client.getGroup(name);
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
  public void getGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7380/locations/location-7380/groups/group-7380";
      client.getGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGroupTest() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Group group = Group.newBuilder().build();
    String groupId = "groupId293428218";

    Group actualResponse = client.createGroupAsync(parent, group, groupId).get();
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
  public void createGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Group group = Group.newBuilder().build();
      String groupId = "groupId293428218";
      client.createGroupAsync(parent, group, groupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createGroupTest2() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Group group = Group.newBuilder().build();
    String groupId = "groupId293428218";

    Group actualResponse = client.createGroupAsync(parent, group, groupId).get();
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
  public void createGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Group group = Group.newBuilder().build();
      String groupId = "groupId293428218";
      client.createGroupAsync(parent, group, groupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateGroupTest() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Group group =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Group actualResponse = client.updateGroupAsync(group, updateMask).get();
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
  public void updateGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Group group =
          Group.newBuilder()
              .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDescription("description-1724546052")
              .setDisplayName("displayName1714148973")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGroupAsync(group, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    GroupName name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");

    client.deleteGroupAsync(name).get();

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
  public void deleteGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GroupName name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
      client.deleteGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-7380/locations/location-7380/groups/group-7380";

    client.deleteGroupAsync(name).get();

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
  public void deleteGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7380/locations/location-7380/groups/group-7380";
      client.deleteGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void addGroupMigrationTest() throws Exception {
    AddGroupMigrationResponse expectedResponse = AddGroupMigrationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addGroupMigrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    GroupName group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");

    AddGroupMigrationResponse actualResponse = client.addGroupMigrationAsync(group).get();
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
  public void addGroupMigrationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GroupName group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
      client.addGroupMigrationAsync(group).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void addGroupMigrationTest2() throws Exception {
    AddGroupMigrationResponse expectedResponse = AddGroupMigrationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addGroupMigrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String group = "projects/project-6176/locations/location-6176/groups/group-6176";

    AddGroupMigrationResponse actualResponse = client.addGroupMigrationAsync(group).get();
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
  public void addGroupMigrationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String group = "projects/project-6176/locations/location-6176/groups/group-6176";
      client.addGroupMigrationAsync(group).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void removeGroupMigrationTest() throws Exception {
    RemoveGroupMigrationResponse expectedResponse =
        RemoveGroupMigrationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removeGroupMigrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    GroupName group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");

    RemoveGroupMigrationResponse actualResponse = client.removeGroupMigrationAsync(group).get();
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
  public void removeGroupMigrationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GroupName group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
      client.removeGroupMigrationAsync(group).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void removeGroupMigrationTest2() throws Exception {
    RemoveGroupMigrationResponse expectedResponse =
        RemoveGroupMigrationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removeGroupMigrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String group = "projects/project-6176/locations/location-6176/groups/group-6176";

    RemoveGroupMigrationResponse actualResponse = client.removeGroupMigrationAsync(group).get();
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
  public void removeGroupMigrationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String group = "projects/project-6176/locations/location-6176/groups/group-6176";
      client.removeGroupMigrationAsync(group).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listTargetProjectsTest() throws Exception {
    TargetProject responsesElement = TargetProject.newBuilder().build();
    ListTargetProjectsResponse expectedResponse =
        ListTargetProjectsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTargetProjects(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTargetProjectsPagedResponse pagedListResponse = client.listTargetProjects(parent);

    List<TargetProject> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTargetProjectsList().get(0), resources.get(0));

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
  public void listTargetProjectsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTargetProjects(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTargetProjectsTest2() throws Exception {
    TargetProject responsesElement = TargetProject.newBuilder().build();
    ListTargetProjectsResponse expectedResponse =
        ListTargetProjectsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTargetProjects(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListTargetProjectsPagedResponse pagedListResponse = client.listTargetProjects(parent);

    List<TargetProject> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTargetProjectsList().get(0), resources.get(0));

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
  public void listTargetProjectsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listTargetProjects(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTargetProjectTest() throws Exception {
    TargetProject expectedResponse =
        TargetProject.newBuilder()
            .setName(TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
            .setProject("project-309310695")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    TargetProjectName name = TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]");

    TargetProject actualResponse = client.getTargetProject(name);
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
  public void getTargetProjectExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TargetProjectName name = TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]");
      client.getTargetProject(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTargetProjectTest2() throws Exception {
    TargetProject expectedResponse =
        TargetProject.newBuilder()
            .setName(TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
            .setProject("project-309310695")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6267/locations/location-6267/targetProjects/targetProject-6267";

    TargetProject actualResponse = client.getTargetProject(name);
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
  public void getTargetProjectExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6267/locations/location-6267/targetProjects/targetProject-6267";
      client.getTargetProject(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTargetProjectTest() throws Exception {
    TargetProject expectedResponse =
        TargetProject.newBuilder()
            .setName(TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
            .setProject("project-309310695")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTargetProjectTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TargetProject targetProject = TargetProject.newBuilder().build();
    String targetProjectId = "targetProjectId1290130307";

    TargetProject actualResponse =
        client.createTargetProjectAsync(parent, targetProject, targetProjectId).get();
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
  public void createTargetProjectExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      TargetProject targetProject = TargetProject.newBuilder().build();
      String targetProjectId = "targetProjectId1290130307";
      client.createTargetProjectAsync(parent, targetProject, targetProjectId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createTargetProjectTest2() throws Exception {
    TargetProject expectedResponse =
        TargetProject.newBuilder()
            .setName(TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
            .setProject("project-309310695")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTargetProjectTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    TargetProject targetProject = TargetProject.newBuilder().build();
    String targetProjectId = "targetProjectId1290130307";

    TargetProject actualResponse =
        client.createTargetProjectAsync(parent, targetProject, targetProjectId).get();
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
  public void createTargetProjectExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      TargetProject targetProject = TargetProject.newBuilder().build();
      String targetProjectId = "targetProjectId1290130307";
      client.createTargetProjectAsync(parent, targetProject, targetProjectId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateTargetProjectTest() throws Exception {
    TargetProject expectedResponse =
        TargetProject.newBuilder()
            .setName(TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
            .setProject("project-309310695")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateTargetProjectTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    TargetProject targetProject =
        TargetProject.newBuilder()
            .setName(TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
            .setProject("project-309310695")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TargetProject actualResponse = client.updateTargetProjectAsync(targetProject, updateMask).get();
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
  public void updateTargetProjectExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TargetProject targetProject =
          TargetProject.newBuilder()
              .setName(
                  TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
              .setProject("project-309310695")
              .setDescription("description-1724546052")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTargetProjectAsync(targetProject, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteTargetProjectTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTargetProjectTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    TargetProjectName name = TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]");

    client.deleteTargetProjectAsync(name).get();

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
  public void deleteTargetProjectExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TargetProjectName name = TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]");
      client.deleteTargetProjectAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteTargetProjectTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTargetProjectTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-6267/locations/location-6267/targetProjects/targetProject-6267";

    client.deleteTargetProjectAsync(name).get();

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
  public void deleteTargetProjectExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6267/locations/location-6267/targetProjects/targetProject-6267";
      client.deleteTargetProjectAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
