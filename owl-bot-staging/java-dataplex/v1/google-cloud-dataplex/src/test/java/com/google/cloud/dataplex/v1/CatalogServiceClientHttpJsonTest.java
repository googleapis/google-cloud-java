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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListAspectTypesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntriesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntryGroupsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntryTypesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.SearchEntriesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dataplex.v1.stub.HttpJsonCatalogServiceStub;
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
public class CatalogServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CatalogServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCatalogServiceStub.getMethodDescriptors(),
            CatalogServiceSettings.getDefaultEndpoint());
    CatalogServiceSettings settings =
        CatalogServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CatalogServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CatalogServiceClient.create(settings);
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
  public void createEntryTypeTest() throws Exception {
    EntryType expectedResponse =
        EntryType.newBuilder()
            .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllTypeAliases(new ArrayList<String>())
            .setPlatform("platform1874684019")
            .setSystem("system-887328209")
            .addAllRequiredAspects(new ArrayList<EntryType.AspectInfo>())
            .setAuthorization(EntryType.Authorization.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntryTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    EntryType entryType = EntryType.newBuilder().build();
    String entryTypeId = "entryTypeId-1105721081";

    EntryType actualResponse = client.createEntryTypeAsync(parent, entryType, entryTypeId).get();
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
  public void createEntryTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      EntryType entryType = EntryType.newBuilder().build();
      String entryTypeId = "entryTypeId-1105721081";
      client.createEntryTypeAsync(parent, entryType, entryTypeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createEntryTypeTest2() throws Exception {
    EntryType expectedResponse =
        EntryType.newBuilder()
            .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllTypeAliases(new ArrayList<String>())
            .setPlatform("platform1874684019")
            .setSystem("system-887328209")
            .addAllRequiredAspects(new ArrayList<EntryType.AspectInfo>())
            .setAuthorization(EntryType.Authorization.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntryTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    EntryType entryType = EntryType.newBuilder().build();
    String entryTypeId = "entryTypeId-1105721081";

    EntryType actualResponse = client.createEntryTypeAsync(parent, entryType, entryTypeId).get();
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
  public void createEntryTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      EntryType entryType = EntryType.newBuilder().build();
      String entryTypeId = "entryTypeId-1105721081";
      client.createEntryTypeAsync(parent, entryType, entryTypeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateEntryTypeTest() throws Exception {
    EntryType expectedResponse =
        EntryType.newBuilder()
            .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllTypeAliases(new ArrayList<String>())
            .setPlatform("platform1874684019")
            .setSystem("system-887328209")
            .addAllRequiredAspects(new ArrayList<EntryType.AspectInfo>())
            .setAuthorization(EntryType.Authorization.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEntryTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EntryType entryType =
        EntryType.newBuilder()
            .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllTypeAliases(new ArrayList<String>())
            .setPlatform("platform1874684019")
            .setSystem("system-887328209")
            .addAllRequiredAspects(new ArrayList<EntryType.AspectInfo>())
            .setAuthorization(EntryType.Authorization.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EntryType actualResponse = client.updateEntryTypeAsync(entryType, updateMask).get();
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
  public void updateEntryTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntryType entryType =
          EntryType.newBuilder()
              .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
              .setUid("uid115792")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDescription("description-1724546052")
              .setDisplayName("displayName1714148973")
              .putAllLabels(new HashMap<String, String>())
              .setEtag("etag3123477")
              .addAllTypeAliases(new ArrayList<String>())
              .setPlatform("platform1874684019")
              .setSystem("system-887328209")
              .addAllRequiredAspects(new ArrayList<EntryType.AspectInfo>())
              .setAuthorization(EntryType.Authorization.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEntryTypeAsync(entryType, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEntryTypeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEntryTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EntryTypeName name = EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]");

    client.deleteEntryTypeAsync(name).get();

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
  public void deleteEntryTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntryTypeName name = EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]");
      client.deleteEntryTypeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEntryTypeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEntryTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-8807/locations/location-8807/entryTypes/entryType-8807";

    client.deleteEntryTypeAsync(name).get();

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
  public void deleteEntryTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-8807/locations/location-8807/entryTypes/entryType-8807";
      client.deleteEntryTypeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listEntryTypesTest() throws Exception {
    EntryType responsesElement = EntryType.newBuilder().build();
    ListEntryTypesResponse expectedResponse =
        ListEntryTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntryTypes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEntryTypesPagedResponse pagedListResponse = client.listEntryTypes(parent);

    List<EntryType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntryTypesList().get(0), resources.get(0));

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
  public void listEntryTypesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEntryTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntryTypesTest2() throws Exception {
    EntryType responsesElement = EntryType.newBuilder().build();
    ListEntryTypesResponse expectedResponse =
        ListEntryTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntryTypes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListEntryTypesPagedResponse pagedListResponse = client.listEntryTypes(parent);

    List<EntryType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntryTypesList().get(0), resources.get(0));

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
  public void listEntryTypesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listEntryTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryTypeTest() throws Exception {
    EntryType expectedResponse =
        EntryType.newBuilder()
            .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllTypeAliases(new ArrayList<String>())
            .setPlatform("platform1874684019")
            .setSystem("system-887328209")
            .addAllRequiredAspects(new ArrayList<EntryType.AspectInfo>())
            .setAuthorization(EntryType.Authorization.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    EntryTypeName name = EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]");

    EntryType actualResponse = client.getEntryType(name);
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
  public void getEntryTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntryTypeName name = EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]");
      client.getEntryType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryTypeTest2() throws Exception {
    EntryType expectedResponse =
        EntryType.newBuilder()
            .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllTypeAliases(new ArrayList<String>())
            .setPlatform("platform1874684019")
            .setSystem("system-887328209")
            .addAllRequiredAspects(new ArrayList<EntryType.AspectInfo>())
            .setAuthorization(EntryType.Authorization.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-8807/locations/location-8807/entryTypes/entryType-8807";

    EntryType actualResponse = client.getEntryType(name);
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
  public void getEntryTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-8807/locations/location-8807/entryTypes/entryType-8807";
      client.getEntryType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAspectTypeTest() throws Exception {
    AspectType expectedResponse =
        AspectType.newBuilder()
            .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setAuthorization(AspectType.Authorization.newBuilder().build())
            .setMetadataTemplate(AspectType.MetadataTemplate.newBuilder().build())
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAspectTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AspectType aspectType = AspectType.newBuilder().build();
    String aspectTypeId = "aspectTypeId-423030675";

    AspectType actualResponse =
        client.createAspectTypeAsync(parent, aspectType, aspectTypeId).get();
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
  public void createAspectTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AspectType aspectType = AspectType.newBuilder().build();
      String aspectTypeId = "aspectTypeId-423030675";
      client.createAspectTypeAsync(parent, aspectType, aspectTypeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAspectTypeTest2() throws Exception {
    AspectType expectedResponse =
        AspectType.newBuilder()
            .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setAuthorization(AspectType.Authorization.newBuilder().build())
            .setMetadataTemplate(AspectType.MetadataTemplate.newBuilder().build())
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAspectTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    AspectType aspectType = AspectType.newBuilder().build();
    String aspectTypeId = "aspectTypeId-423030675";

    AspectType actualResponse =
        client.createAspectTypeAsync(parent, aspectType, aspectTypeId).get();
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
  public void createAspectTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      AspectType aspectType = AspectType.newBuilder().build();
      String aspectTypeId = "aspectTypeId-423030675";
      client.createAspectTypeAsync(parent, aspectType, aspectTypeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateAspectTypeTest() throws Exception {
    AspectType expectedResponse =
        AspectType.newBuilder()
            .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setAuthorization(AspectType.Authorization.newBuilder().build())
            .setMetadataTemplate(AspectType.MetadataTemplate.newBuilder().build())
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAspectTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AspectType aspectType =
        AspectType.newBuilder()
            .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setAuthorization(AspectType.Authorization.newBuilder().build())
            .setMetadataTemplate(AspectType.MetadataTemplate.newBuilder().build())
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AspectType actualResponse = client.updateAspectTypeAsync(aspectType, updateMask).get();
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
  public void updateAspectTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AspectType aspectType =
          AspectType.newBuilder()
              .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
              .setUid("uid115792")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDescription("description-1724546052")
              .setDisplayName("displayName1714148973")
              .putAllLabels(new HashMap<String, String>())
              .setEtag("etag3123477")
              .setAuthorization(AspectType.Authorization.newBuilder().build())
              .setMetadataTemplate(AspectType.MetadataTemplate.newBuilder().build())
              .setTransferStatus(TransferStatus.forNumber(0))
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAspectTypeAsync(aspectType, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAspectTypeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAspectTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AspectTypeName name = AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]");

    client.deleteAspectTypeAsync(name).get();

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
  public void deleteAspectTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AspectTypeName name = AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]");
      client.deleteAspectTypeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAspectTypeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAspectTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-2377/locations/location-2377/aspectTypes/aspectType-2377";

    client.deleteAspectTypeAsync(name).get();

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
  public void deleteAspectTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2377/locations/location-2377/aspectTypes/aspectType-2377";
      client.deleteAspectTypeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listAspectTypesTest() throws Exception {
    AspectType responsesElement = AspectType.newBuilder().build();
    ListAspectTypesResponse expectedResponse =
        ListAspectTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAspectTypes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAspectTypesPagedResponse pagedListResponse = client.listAspectTypes(parent);

    List<AspectType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAspectTypesList().get(0), resources.get(0));

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
  public void listAspectTypesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAspectTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAspectTypesTest2() throws Exception {
    AspectType responsesElement = AspectType.newBuilder().build();
    ListAspectTypesResponse expectedResponse =
        ListAspectTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAspectTypes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAspectTypesPagedResponse pagedListResponse = client.listAspectTypes(parent);

    List<AspectType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAspectTypesList().get(0), resources.get(0));

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
  public void listAspectTypesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAspectTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAspectTypeTest() throws Exception {
    AspectType expectedResponse =
        AspectType.newBuilder()
            .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setAuthorization(AspectType.Authorization.newBuilder().build())
            .setMetadataTemplate(AspectType.MetadataTemplate.newBuilder().build())
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    AspectTypeName name = AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]");

    AspectType actualResponse = client.getAspectType(name);
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
  public void getAspectTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AspectTypeName name = AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]");
      client.getAspectType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAspectTypeTest2() throws Exception {
    AspectType expectedResponse =
        AspectType.newBuilder()
            .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setAuthorization(AspectType.Authorization.newBuilder().build())
            .setMetadataTemplate(AspectType.MetadataTemplate.newBuilder().build())
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2377/locations/location-2377/aspectTypes/aspectType-2377";

    AspectType actualResponse = client.getAspectType(name);
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
  public void getAspectTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2377/locations/location-2377/aspectTypes/aspectType-2377";
      client.getAspectType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntryGroupTest() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntryGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    EntryGroup entryGroup = EntryGroup.newBuilder().build();
    String entryGroupId = "entryGroupId1228924712";

    EntryGroup actualResponse =
        client.createEntryGroupAsync(parent, entryGroup, entryGroupId).get();
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
  public void createEntryGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      EntryGroup entryGroup = EntryGroup.newBuilder().build();
      String entryGroupId = "entryGroupId1228924712";
      client.createEntryGroupAsync(parent, entryGroup, entryGroupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createEntryGroupTest2() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntryGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    EntryGroup entryGroup = EntryGroup.newBuilder().build();
    String entryGroupId = "entryGroupId1228924712";

    EntryGroup actualResponse =
        client.createEntryGroupAsync(parent, entryGroup, entryGroupId).get();
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
  public void createEntryGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      EntryGroup entryGroup = EntryGroup.newBuilder().build();
      String entryGroupId = "entryGroupId1228924712";
      client.createEntryGroupAsync(parent, entryGroup, entryGroupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateEntryGroupTest() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEntryGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EntryGroup entryGroup =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EntryGroup actualResponse = client.updateEntryGroupAsync(entryGroup, updateMask).get();
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
  public void updateEntryGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntryGroup entryGroup =
          EntryGroup.newBuilder()
              .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
              .setUid("uid115792")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDescription("description-1724546052")
              .setDisplayName("displayName1714148973")
              .putAllLabels(new HashMap<String, String>())
              .setEtag("etag3123477")
              .setTransferStatus(TransferStatus.forNumber(0))
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEntryGroupAsync(entryGroup, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEntryGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEntryGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");

    client.deleteEntryGroupAsync(name).get();

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
  public void deleteEntryGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
      client.deleteEntryGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEntryGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEntryGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-4364/locations/location-4364/entryGroups/entryGroup-4364";

    client.deleteEntryGroupAsync(name).get();

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
  public void deleteEntryGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4364/locations/location-4364/entryGroups/entryGroup-4364";
      client.deleteEntryGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listEntryGroupsTest() throws Exception {
    EntryGroup responsesElement = EntryGroup.newBuilder().build();
    ListEntryGroupsResponse expectedResponse =
        ListEntryGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntryGroups(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEntryGroupsPagedResponse pagedListResponse = client.listEntryGroups(parent);

    List<EntryGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntryGroupsList().get(0), resources.get(0));

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
  public void listEntryGroupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEntryGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntryGroupsTest2() throws Exception {
    EntryGroup responsesElement = EntryGroup.newBuilder().build();
    ListEntryGroupsResponse expectedResponse =
        ListEntryGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntryGroups(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListEntryGroupsPagedResponse pagedListResponse = client.listEntryGroups(parent);

    List<EntryGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntryGroupsList().get(0), resources.get(0));

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
  public void listEntryGroupsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listEntryGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryGroupTest() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");

    EntryGroup actualResponse = client.getEntryGroup(name);
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
  public void getEntryGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
      client.getEntryGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryGroupTest2() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4364/locations/location-4364/entryGroups/entryGroup-4364";

    EntryGroup actualResponse = client.getEntryGroup(name);
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
  public void getEntryGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4364/locations/location-4364/entryGroups/entryGroup-4364";
      client.getEntryGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntryTest() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
    Entry entry = Entry.newBuilder().build();
    String entryId = "entryId-1591558867";

    Entry actualResponse = client.createEntry(parent, entry, entryId);
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
  public void createEntryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
      Entry entry = Entry.newBuilder().build();
      String entryId = "entryId-1591558867";
      client.createEntry(parent, entry, entryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntryTest2() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-3515/locations/location-3515/entryGroups/entryGroup-3515";
    Entry entry = Entry.newBuilder().build();
    String entryId = "entryId-1591558867";

    Entry actualResponse = client.createEntry(parent, entry, entryId);
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
  public void createEntryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3515/locations/location-3515/entryGroups/entryGroup-3515";
      Entry entry = Entry.newBuilder().build();
      String entryId = "entryId-1591558867";
      client.createEntry(parent, entry, entryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEntryTest() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Entry entry =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Entry actualResponse = client.updateEntry(entry, updateMask);
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
  public void updateEntryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Entry entry =
          Entry.newBuilder()
              .setName(
                  EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
              .setEntryType("entryType-479362356")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllAspects(new HashMap<String, Aspect>())
              .setParentEntry("parentEntry991029736")
              .setFullyQualifiedName("fullyQualifiedName288467357")
              .setEntrySource(EntrySource.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEntry(entry, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEntryTest() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");

    Entry actualResponse = client.deleteEntry(name);
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
  public void deleteEntryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      client.deleteEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEntryTest2() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6814/locations/location-6814/entryGroups/entryGroup-6814/entries/entrie-6814";

    Entry actualResponse = client.deleteEntry(name);
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
  public void deleteEntryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6814/locations/location-6814/entryGroups/entryGroup-6814/entries/entrie-6814";
      client.deleteEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntriesTest() throws Exception {
    Entry responsesElement = Entry.newBuilder().build();
    ListEntriesResponse expectedResponse =
        ListEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");

    ListEntriesPagedResponse pagedListResponse = client.listEntries(parent);

    List<Entry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntriesList().get(0), resources.get(0));

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
  public void listEntriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
      client.listEntries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntriesTest2() throws Exception {
    Entry responsesElement = Entry.newBuilder().build();
    ListEntriesResponse expectedResponse =
        ListEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-3515/locations/location-3515/entryGroups/entryGroup-3515";

    ListEntriesPagedResponse pagedListResponse = client.listEntries(parent);

    List<Entry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntriesList().get(0), resources.get(0));

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
  public void listEntriesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3515/locations/location-3515/entryGroups/entryGroup-3515";
      client.listEntries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryTest() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");

    Entry actualResponse = client.getEntry(name);
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
  public void getEntryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      client.getEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryTest2() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6814/locations/location-6814/entryGroups/entryGroup-6814/entries/entrie-6814";

    Entry actualResponse = client.getEntry(name);
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
  public void getEntryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6814/locations/location-6814/entryGroups/entryGroup-6814/entries/entrie-6814";
      client.getEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupEntryTest() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LookupEntryRequest request =
        LookupEntryRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .setView(EntryView.forNumber(0))
            .addAllAspectTypes(new ArrayList<String>())
            .addAllPaths(new ArrayList<String>())
            .setEntry(
                EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .build();

    Entry actualResponse = client.lookupEntry(request);
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
  public void lookupEntryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LookupEntryRequest request =
          LookupEntryRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .setView(EntryView.forNumber(0))
              .addAllAspectTypes(new ArrayList<String>())
              .addAllPaths(new ArrayList<String>())
              .setEntry(
                  EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
              .build();
      client.lookupEntry(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchEntriesTest() throws Exception {
    SearchEntriesResult responsesElement = SearchEntriesResult.newBuilder().build();
    SearchEntriesResponse expectedResponse =
        SearchEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9062/locations/location-9062";
    String query = "query107944136";

    SearchEntriesPagedResponse pagedListResponse = client.searchEntries(name, query);

    List<SearchEntriesResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResultsList().get(0), resources.get(0));

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
  public void searchEntriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9062/locations/location-9062";
      String query = "query107944136";
      client.searchEntries(name, query);
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
