/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataAttributeBindingsPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataAttributesPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataTaxonomiesPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dataplex.v1.stub.HttpJsonDataTaxonomyServiceStub;
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
public class DataTaxonomyServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DataTaxonomyServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDataTaxonomyServiceStub.getMethodDescriptors(),
            DataTaxonomyServiceSettings.getDefaultEndpoint());
    DataTaxonomyServiceSettings settings =
        DataTaxonomyServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DataTaxonomyServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataTaxonomyServiceClient.create(settings);
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
  public void createDataTaxonomyTest() throws Exception {
    DataTaxonomy expectedResponse =
        DataTaxonomy.newBuilder()
            .setName(
                DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setClassCount(-424516728)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataTaxonomyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DataTaxonomy dataTaxonomy = DataTaxonomy.newBuilder().build();
    String dataTaxonomyId = "dataTaxonomyId987458454";

    DataTaxonomy actualResponse =
        client.createDataTaxonomyAsync(parent, dataTaxonomy, dataTaxonomyId).get();
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
  public void createDataTaxonomyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DataTaxonomy dataTaxonomy = DataTaxonomy.newBuilder().build();
      String dataTaxonomyId = "dataTaxonomyId987458454";
      client.createDataTaxonomyAsync(parent, dataTaxonomy, dataTaxonomyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createDataTaxonomyTest2() throws Exception {
    DataTaxonomy expectedResponse =
        DataTaxonomy.newBuilder()
            .setName(
                DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setClassCount(-424516728)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataTaxonomyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    DataTaxonomy dataTaxonomy = DataTaxonomy.newBuilder().build();
    String dataTaxonomyId = "dataTaxonomyId987458454";

    DataTaxonomy actualResponse =
        client.createDataTaxonomyAsync(parent, dataTaxonomy, dataTaxonomyId).get();
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
  public void createDataTaxonomyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      DataTaxonomy dataTaxonomy = DataTaxonomy.newBuilder().build();
      String dataTaxonomyId = "dataTaxonomyId987458454";
      client.createDataTaxonomyAsync(parent, dataTaxonomy, dataTaxonomyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateDataTaxonomyTest() throws Exception {
    DataTaxonomy expectedResponse =
        DataTaxonomy.newBuilder()
            .setName(
                DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setClassCount(-424516728)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDataTaxonomyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DataTaxonomy dataTaxonomy =
        DataTaxonomy.newBuilder()
            .setName(
                DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setClassCount(-424516728)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataTaxonomy actualResponse = client.updateDataTaxonomyAsync(dataTaxonomy, updateMask).get();
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
  public void updateDataTaxonomyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataTaxonomy dataTaxonomy =
          DataTaxonomy.newBuilder()
              .setName(
                  DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
              .setUid("uid115792")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDescription("description-1724546052")
              .setDisplayName("displayName1714148973")
              .putAllLabels(new HashMap<String, String>())
              .setAttributeCount(-688916052)
              .setEtag("etag3123477")
              .setClassCount(-424516728)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataTaxonomyAsync(dataTaxonomy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDataTaxonomyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataTaxonomyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DataTaxonomyName name = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");

    client.deleteDataTaxonomyAsync(name).get();

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
  public void deleteDataTaxonomyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataTaxonomyName name = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
      client.deleteDataTaxonomyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDataTaxonomyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataTaxonomyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-743/locations/location-743/dataTaxonomies/dataTaxonomie-743";

    client.deleteDataTaxonomyAsync(name).get();

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
  public void deleteDataTaxonomyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-743/locations/location-743/dataTaxonomies/dataTaxonomie-743";
      client.deleteDataTaxonomyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listDataTaxonomiesTest() throws Exception {
    DataTaxonomy responsesElement = DataTaxonomy.newBuilder().build();
    ListDataTaxonomiesResponse expectedResponse =
        ListDataTaxonomiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataTaxonomies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDataTaxonomiesPagedResponse pagedListResponse = client.listDataTaxonomies(parent);

    List<DataTaxonomy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataTaxonomiesList().get(0), resources.get(0));

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
  public void listDataTaxonomiesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDataTaxonomies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataTaxonomiesTest2() throws Exception {
    DataTaxonomy responsesElement = DataTaxonomy.newBuilder().build();
    ListDataTaxonomiesResponse expectedResponse =
        ListDataTaxonomiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataTaxonomies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListDataTaxonomiesPagedResponse pagedListResponse = client.listDataTaxonomies(parent);

    List<DataTaxonomy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataTaxonomiesList().get(0), resources.get(0));

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
  public void listDataTaxonomiesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listDataTaxonomies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataTaxonomyTest() throws Exception {
    DataTaxonomy expectedResponse =
        DataTaxonomy.newBuilder()
            .setName(
                DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setClassCount(-424516728)
            .build();
    mockService.addResponse(expectedResponse);

    DataTaxonomyName name = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");

    DataTaxonomy actualResponse = client.getDataTaxonomy(name);
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
  public void getDataTaxonomyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataTaxonomyName name = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
      client.getDataTaxonomy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataTaxonomyTest2() throws Exception {
    DataTaxonomy expectedResponse =
        DataTaxonomy.newBuilder()
            .setName(
                DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setClassCount(-424516728)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-743/locations/location-743/dataTaxonomies/dataTaxonomie-743";

    DataTaxonomy actualResponse = client.getDataTaxonomy(name);
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
  public void getDataTaxonomyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-743/locations/location-743/dataTaxonomies/dataTaxonomie-743";
      client.getDataTaxonomy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataAttributeBindingTest() throws Exception {
    DataAttributeBinding expectedResponse =
        DataAttributeBinding.newBuilder()
            .setName(
                DataAttributeBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllAttributes(new ArrayList<String>())
            .addAllPaths(new ArrayList<DataAttributeBinding.Path>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataAttributeBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DataAttributeBinding dataAttributeBinding = DataAttributeBinding.newBuilder().build();
    String dataAttributeBindingId = "dataAttributeBindingId1952425102";

    DataAttributeBinding actualResponse =
        client
            .createDataAttributeBindingAsync(parent, dataAttributeBinding, dataAttributeBindingId)
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
  public void createDataAttributeBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DataAttributeBinding dataAttributeBinding = DataAttributeBinding.newBuilder().build();
      String dataAttributeBindingId = "dataAttributeBindingId1952425102";
      client
          .createDataAttributeBindingAsync(parent, dataAttributeBinding, dataAttributeBindingId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createDataAttributeBindingTest2() throws Exception {
    DataAttributeBinding expectedResponse =
        DataAttributeBinding.newBuilder()
            .setName(
                DataAttributeBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllAttributes(new ArrayList<String>())
            .addAllPaths(new ArrayList<DataAttributeBinding.Path>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataAttributeBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    DataAttributeBinding dataAttributeBinding = DataAttributeBinding.newBuilder().build();
    String dataAttributeBindingId = "dataAttributeBindingId1952425102";

    DataAttributeBinding actualResponse =
        client
            .createDataAttributeBindingAsync(parent, dataAttributeBinding, dataAttributeBindingId)
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
  public void createDataAttributeBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      DataAttributeBinding dataAttributeBinding = DataAttributeBinding.newBuilder().build();
      String dataAttributeBindingId = "dataAttributeBindingId1952425102";
      client
          .createDataAttributeBindingAsync(parent, dataAttributeBinding, dataAttributeBindingId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateDataAttributeBindingTest() throws Exception {
    DataAttributeBinding expectedResponse =
        DataAttributeBinding.newBuilder()
            .setName(
                DataAttributeBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllAttributes(new ArrayList<String>())
            .addAllPaths(new ArrayList<DataAttributeBinding.Path>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDataAttributeBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DataAttributeBinding dataAttributeBinding =
        DataAttributeBinding.newBuilder()
            .setName(
                DataAttributeBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllAttributes(new ArrayList<String>())
            .addAllPaths(new ArrayList<DataAttributeBinding.Path>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataAttributeBinding actualResponse =
        client.updateDataAttributeBindingAsync(dataAttributeBinding, updateMask).get();
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
  public void updateDataAttributeBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataAttributeBinding dataAttributeBinding =
          DataAttributeBinding.newBuilder()
              .setName(
                  DataAttributeBindingName.of(
                          "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
                      .toString())
              .setUid("uid115792")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDescription("description-1724546052")
              .setDisplayName("displayName1714148973")
              .putAllLabels(new HashMap<String, String>())
              .setEtag("etag3123477")
              .addAllAttributes(new ArrayList<String>())
              .addAllPaths(new ArrayList<DataAttributeBinding.Path>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataAttributeBindingAsync(dataAttributeBinding, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDataAttributeBindingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataAttributeBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DataAttributeBindingName name =
        DataAttributeBindingName.of("[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]");

    client.deleteDataAttributeBindingAsync(name).get();

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
  public void deleteDataAttributeBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataAttributeBindingName name =
          DataAttributeBindingName.of("[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]");
      client.deleteDataAttributeBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDataAttributeBindingTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataAttributeBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-3418/locations/location-3418/dataAttributeBindings/dataAttributeBinding-3418";

    client.deleteDataAttributeBindingAsync(name).get();

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
  public void deleteDataAttributeBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3418/locations/location-3418/dataAttributeBindings/dataAttributeBinding-3418";
      client.deleteDataAttributeBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listDataAttributeBindingsTest() throws Exception {
    DataAttributeBinding responsesElement = DataAttributeBinding.newBuilder().build();
    ListDataAttributeBindingsResponse expectedResponse =
        ListDataAttributeBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAttributeBindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDataAttributeBindingsPagedResponse pagedListResponse =
        client.listDataAttributeBindings(parent);

    List<DataAttributeBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAttributeBindingsList().get(0), resources.get(0));

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
  public void listDataAttributeBindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDataAttributeBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataAttributeBindingsTest2() throws Exception {
    DataAttributeBinding responsesElement = DataAttributeBinding.newBuilder().build();
    ListDataAttributeBindingsResponse expectedResponse =
        ListDataAttributeBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAttributeBindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListDataAttributeBindingsPagedResponse pagedListResponse =
        client.listDataAttributeBindings(parent);

    List<DataAttributeBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAttributeBindingsList().get(0), resources.get(0));

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
  public void listDataAttributeBindingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listDataAttributeBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAttributeBindingTest() throws Exception {
    DataAttributeBinding expectedResponse =
        DataAttributeBinding.newBuilder()
            .setName(
                DataAttributeBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllAttributes(new ArrayList<String>())
            .addAllPaths(new ArrayList<DataAttributeBinding.Path>())
            .build();
    mockService.addResponse(expectedResponse);

    DataAttributeBindingName name =
        DataAttributeBindingName.of("[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]");

    DataAttributeBinding actualResponse = client.getDataAttributeBinding(name);
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
  public void getDataAttributeBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataAttributeBindingName name =
          DataAttributeBindingName.of("[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]");
      client.getDataAttributeBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAttributeBindingTest2() throws Exception {
    DataAttributeBinding expectedResponse =
        DataAttributeBinding.newBuilder()
            .setName(
                DataAttributeBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllAttributes(new ArrayList<String>())
            .addAllPaths(new ArrayList<DataAttributeBinding.Path>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3418/locations/location-3418/dataAttributeBindings/dataAttributeBinding-3418";

    DataAttributeBinding actualResponse = client.getDataAttributeBinding(name);
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
  public void getDataAttributeBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3418/locations/location-3418/dataAttributeBindings/dataAttributeBinding-3418";
      client.getDataAttributeBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataAttributeTest() throws Exception {
    DataAttribute expectedResponse =
        DataAttribute.newBuilder()
            .setName(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setParentId(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setResourceAccessSpec(ResourceAccessSpec.newBuilder().build())
            .setDataAccessSpec(DataAccessSpec.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataAttributeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DataTaxonomyName parent = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
    DataAttribute dataAttribute = DataAttribute.newBuilder().build();
    String dataAttributeId = "dataAttributeId-44128563";

    DataAttribute actualResponse =
        client.createDataAttributeAsync(parent, dataAttribute, dataAttributeId).get();
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
  public void createDataAttributeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataTaxonomyName parent =
          DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
      DataAttribute dataAttribute = DataAttribute.newBuilder().build();
      String dataAttributeId = "dataAttributeId-44128563";
      client.createDataAttributeAsync(parent, dataAttribute, dataAttributeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createDataAttributeTest2() throws Exception {
    DataAttribute expectedResponse =
        DataAttribute.newBuilder()
            .setName(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setParentId(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setResourceAccessSpec(ResourceAccessSpec.newBuilder().build())
            .setDataAccessSpec(DataAccessSpec.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataAttributeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-8950/locations/location-8950/dataTaxonomies/dataTaxonomie-8950";
    DataAttribute dataAttribute = DataAttribute.newBuilder().build();
    String dataAttributeId = "dataAttributeId-44128563";

    DataAttribute actualResponse =
        client.createDataAttributeAsync(parent, dataAttribute, dataAttributeId).get();
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
  public void createDataAttributeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-8950/locations/location-8950/dataTaxonomies/dataTaxonomie-8950";
      DataAttribute dataAttribute = DataAttribute.newBuilder().build();
      String dataAttributeId = "dataAttributeId-44128563";
      client.createDataAttributeAsync(parent, dataAttribute, dataAttributeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateDataAttributeTest() throws Exception {
    DataAttribute expectedResponse =
        DataAttribute.newBuilder()
            .setName(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setParentId(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setResourceAccessSpec(ResourceAccessSpec.newBuilder().build())
            .setDataAccessSpec(DataAccessSpec.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDataAttributeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DataAttribute dataAttribute =
        DataAttribute.newBuilder()
            .setName(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setParentId(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setResourceAccessSpec(ResourceAccessSpec.newBuilder().build())
            .setDataAccessSpec(DataAccessSpec.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataAttribute actualResponse = client.updateDataAttributeAsync(dataAttribute, updateMask).get();
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
  public void updateDataAttributeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataAttribute dataAttribute =
          DataAttribute.newBuilder()
              .setName(
                  DataAttributeName.of(
                          "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                      .toString())
              .setUid("uid115792")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDescription("description-1724546052")
              .setDisplayName("displayName1714148973")
              .putAllLabels(new HashMap<String, String>())
              .setParentId(
                  DataAttributeName.of(
                          "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                      .toString())
              .setAttributeCount(-688916052)
              .setEtag("etag3123477")
              .setResourceAccessSpec(ResourceAccessSpec.newBuilder().build())
              .setDataAccessSpec(DataAccessSpec.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataAttributeAsync(dataAttribute, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDataAttributeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataAttributeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DataAttributeName name =
        DataAttributeName.of("[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]");

    client.deleteDataAttributeAsync(name).get();

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
  public void deleteDataAttributeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataAttributeName name =
          DataAttributeName.of("[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]");
      client.deleteDataAttributeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDataAttributeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataAttributeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-7880/locations/location-7880/dataTaxonomies/dataTaxonomie-7880/attributes/attribute-7880";

    client.deleteDataAttributeAsync(name).get();

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
  public void deleteDataAttributeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7880/locations/location-7880/dataTaxonomies/dataTaxonomie-7880/attributes/attribute-7880";
      client.deleteDataAttributeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listDataAttributesTest() throws Exception {
    DataAttribute responsesElement = DataAttribute.newBuilder().build();
    ListDataAttributesResponse expectedResponse =
        ListDataAttributesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAttributes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    DataTaxonomyName parent = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");

    ListDataAttributesPagedResponse pagedListResponse = client.listDataAttributes(parent);

    List<DataAttribute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAttributesList().get(0), resources.get(0));

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
  public void listDataAttributesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataTaxonomyName parent =
          DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
      client.listDataAttributes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataAttributesTest2() throws Exception {
    DataAttribute responsesElement = DataAttribute.newBuilder().build();
    ListDataAttributesResponse expectedResponse =
        ListDataAttributesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAttributes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-8950/locations/location-8950/dataTaxonomies/dataTaxonomie-8950";

    ListDataAttributesPagedResponse pagedListResponse = client.listDataAttributes(parent);

    List<DataAttribute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAttributesList().get(0), resources.get(0));

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
  public void listDataAttributesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-8950/locations/location-8950/dataTaxonomies/dataTaxonomie-8950";
      client.listDataAttributes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAttributeTest() throws Exception {
    DataAttribute expectedResponse =
        DataAttribute.newBuilder()
            .setName(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setParentId(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setResourceAccessSpec(ResourceAccessSpec.newBuilder().build())
            .setDataAccessSpec(DataAccessSpec.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DataAttributeName name =
        DataAttributeName.of("[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]");

    DataAttribute actualResponse = client.getDataAttribute(name);
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
  public void getDataAttributeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataAttributeName name =
          DataAttributeName.of("[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]");
      client.getDataAttribute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAttributeTest2() throws Exception {
    DataAttribute expectedResponse =
        DataAttribute.newBuilder()
            .setName(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setParentId(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setResourceAccessSpec(ResourceAccessSpec.newBuilder().build())
            .setDataAccessSpec(DataAccessSpec.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7880/locations/location-7880/dataTaxonomies/dataTaxonomie-7880/attributes/attribute-7880";

    DataAttribute actualResponse = client.getDataAttribute(name);
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
  public void getDataAttributeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7880/locations/location-7880/dataTaxonomies/dataTaxonomie-7880/attributes/attribute-7880";
      client.getDataAttribute(name);
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
