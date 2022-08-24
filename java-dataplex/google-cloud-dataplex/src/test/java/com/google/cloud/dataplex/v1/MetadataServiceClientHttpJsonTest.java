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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListEntitiesPagedResponse;
import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListPartitionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dataplex.v1.stub.HttpJsonMetadataServiceStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
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
public class MetadataServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static MetadataServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonMetadataServiceStub.getMethodDescriptors(),
            MetadataServiceSettings.getDefaultEndpoint());
    MetadataServiceSettings settings =
        MetadataServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                MetadataServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MetadataServiceClient.create(settings);
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
  public void createEntityTest() throws Exception {
    Entity expectedResponse =
        Entity.newBuilder()
            .setName(
                EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setId("id3355")
            .setEtag("etag3123477")
            .setAsset("asset93121264")
            .setDataPath("dataPath1788928751")
            .setDataPathPattern("dataPathPattern1514620321")
            .setCatalogEntry("catalogEntry-1171922983")
            .setSystem(StorageSystem.forNumber(0))
            .setFormat(StorageFormat.newBuilder().build())
            .setCompatibility(Entity.CompatibilityStatus.newBuilder().build())
            .setSchema(Schema.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
    Entity entity = Entity.newBuilder().build();

    Entity actualResponse = client.createEntity(parent, entity);
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
  public void createEntityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
      Entity entity = Entity.newBuilder().build();
      client.createEntity(parent, entity);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntityTest2() throws Exception {
    Entity expectedResponse =
        Entity.newBuilder()
            .setName(
                EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setId("id3355")
            .setEtag("etag3123477")
            .setAsset("asset93121264")
            .setDataPath("dataPath1788928751")
            .setDataPathPattern("dataPathPattern1514620321")
            .setCatalogEntry("catalogEntry-1171922983")
            .setSystem(StorageSystem.forNumber(0))
            .setFormat(StorageFormat.newBuilder().build())
            .setCompatibility(Entity.CompatibilityStatus.newBuilder().build())
            .setSchema(Schema.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4052/locations/location-4052/lakes/lake-4052/zones/zone-4052";
    Entity entity = Entity.newBuilder().build();

    Entity actualResponse = client.createEntity(parent, entity);
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
  public void createEntityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4052/locations/location-4052/lakes/lake-4052/zones/zone-4052";
      Entity entity = Entity.newBuilder().build();
      client.createEntity(parent, entity);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEntityTest() throws Exception {
    Entity expectedResponse =
        Entity.newBuilder()
            .setName(
                EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setId("id3355")
            .setEtag("etag3123477")
            .setAsset("asset93121264")
            .setDataPath("dataPath1788928751")
            .setDataPathPattern("dataPathPattern1514620321")
            .setCatalogEntry("catalogEntry-1171922983")
            .setSystem(StorageSystem.forNumber(0))
            .setFormat(StorageFormat.newBuilder().build())
            .setCompatibility(Entity.CompatibilityStatus.newBuilder().build())
            .setSchema(Schema.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    UpdateEntityRequest request =
        UpdateEntityRequest.newBuilder()
            .setEntity(
                Entity.newBuilder()
                    .setName(
                        EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]")
                            .toString())
                    .setDisplayName("displayName1714148973")
                    .setDescription("description-1724546052")
                    .setCreateTime(Timestamp.newBuilder().build())
                    .setUpdateTime(Timestamp.newBuilder().build())
                    .setId("id3355")
                    .setEtag("etag3123477")
                    .setAsset("asset93121264")
                    .setDataPath("dataPath1788928751")
                    .setDataPathPattern("dataPathPattern1514620321")
                    .setCatalogEntry("catalogEntry-1171922983")
                    .setSystem(StorageSystem.forNumber(0))
                    .setFormat(StorageFormat.newBuilder().build())
                    .setCompatibility(Entity.CompatibilityStatus.newBuilder().build())
                    .setSchema(Schema.newBuilder().build())
                    .build())
            .setValidateOnly(true)
            .build();

    Entity actualResponse = client.updateEntity(request);
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
  public void updateEntityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateEntityRequest request =
          UpdateEntityRequest.newBuilder()
              .setEntity(
                  Entity.newBuilder()
                      .setName(
                          EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]")
                              .toString())
                      .setDisplayName("displayName1714148973")
                      .setDescription("description-1724546052")
                      .setCreateTime(Timestamp.newBuilder().build())
                      .setUpdateTime(Timestamp.newBuilder().build())
                      .setId("id3355")
                      .setEtag("etag3123477")
                      .setAsset("asset93121264")
                      .setDataPath("dataPath1788928751")
                      .setDataPathPattern("dataPathPattern1514620321")
                      .setCatalogEntry("catalogEntry-1171922983")
                      .setSystem(StorageSystem.forNumber(0))
                      .setFormat(StorageFormat.newBuilder().build())
                      .setCompatibility(Entity.CompatibilityStatus.newBuilder().build())
                      .setSchema(Schema.newBuilder().build())
                      .build())
              .setValidateOnly(true)
              .build();
      client.updateEntity(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEntityTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    EntityName name = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");

    client.deleteEntity(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEntityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntityName name = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");
      client.deleteEntity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEntityTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7294/locations/location-7294/lakes/lake-7294/zones/zone-7294/entities/entitie-7294";

    client.deleteEntity(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEntityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7294/locations/location-7294/lakes/lake-7294/zones/zone-7294/entities/entitie-7294";
      client.deleteEntity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntityTest() throws Exception {
    Entity expectedResponse =
        Entity.newBuilder()
            .setName(
                EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setId("id3355")
            .setEtag("etag3123477")
            .setAsset("asset93121264")
            .setDataPath("dataPath1788928751")
            .setDataPathPattern("dataPathPattern1514620321")
            .setCatalogEntry("catalogEntry-1171922983")
            .setSystem(StorageSystem.forNumber(0))
            .setFormat(StorageFormat.newBuilder().build())
            .setCompatibility(Entity.CompatibilityStatus.newBuilder().build())
            .setSchema(Schema.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    EntityName name = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");

    Entity actualResponse = client.getEntity(name);
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
  public void getEntityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntityName name = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");
      client.getEntity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntityTest2() throws Exception {
    Entity expectedResponse =
        Entity.newBuilder()
            .setName(
                EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setId("id3355")
            .setEtag("etag3123477")
            .setAsset("asset93121264")
            .setDataPath("dataPath1788928751")
            .setDataPathPattern("dataPathPattern1514620321")
            .setCatalogEntry("catalogEntry-1171922983")
            .setSystem(StorageSystem.forNumber(0))
            .setFormat(StorageFormat.newBuilder().build())
            .setCompatibility(Entity.CompatibilityStatus.newBuilder().build())
            .setSchema(Schema.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7294/locations/location-7294/lakes/lake-7294/zones/zone-7294/entities/entitie-7294";

    Entity actualResponse = client.getEntity(name);
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
  public void getEntityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7294/locations/location-7294/lakes/lake-7294/zones/zone-7294/entities/entitie-7294";
      client.getEntity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitiesTest() throws Exception {
    Entity responsesElement = Entity.newBuilder().build();
    ListEntitiesResponse expectedResponse =
        ListEntitiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntities(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");

    ListEntitiesPagedResponse pagedListResponse = client.listEntities(parent);

    List<Entity> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitiesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEntitiesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
      client.listEntities(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitiesTest2() throws Exception {
    Entity responsesElement = Entity.newBuilder().build();
    ListEntitiesResponse expectedResponse =
        ListEntitiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntities(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4052/locations/location-4052/lakes/lake-4052/zones/zone-4052";

    ListEntitiesPagedResponse pagedListResponse = client.listEntities(parent);

    List<Entity> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitiesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEntitiesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4052/locations/location-4052/lakes/lake-4052/zones/zone-4052";
      client.listEntities(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPartitionTest() throws Exception {
    Partition expectedResponse =
        Partition.newBuilder()
            .setName(
                PartitionName.of(
                        "[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]")
                    .toString())
            .addAllValues(new ArrayList<String>())
            .setLocation("location1901043637")
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    EntityName parent = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");
    Partition partition = Partition.newBuilder().build();

    Partition actualResponse = client.createPartition(parent, partition);
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
  public void createPartitionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntityName parent = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");
      Partition partition = Partition.newBuilder().build();
      client.createPartition(parent, partition);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPartitionTest2() throws Exception {
    Partition expectedResponse =
        Partition.newBuilder()
            .setName(
                PartitionName.of(
                        "[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]")
                    .toString())
            .addAllValues(new ArrayList<String>())
            .setLocation("location1901043637")
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-9473/locations/location-9473/lakes/lake-9473/zones/zone-9473/entities/entitie-9473";
    Partition partition = Partition.newBuilder().build();

    Partition actualResponse = client.createPartition(parent, partition);
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
  public void createPartitionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9473/locations/location-9473/lakes/lake-9473/zones/zone-9473/entities/entitie-9473";
      Partition partition = Partition.newBuilder().build();
      client.createPartition(parent, partition);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePartitionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    PartitionName name =
        PartitionName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]");

    client.deletePartition(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deletePartitionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PartitionName name =
          PartitionName.of(
              "[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]");
      client.deletePartition(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePartitionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6283/locations/location-6283/lakes/lake-6283/zones/zone-6283/entities/entitie-6283/partitions/partition-6283";

    client.deletePartition(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deletePartitionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6283/locations/location-6283/lakes/lake-6283/zones/zone-6283/entities/entitie-6283/partitions/partition-6283";
      client.deletePartition(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPartitionTest() throws Exception {
    Partition expectedResponse =
        Partition.newBuilder()
            .setName(
                PartitionName.of(
                        "[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]")
                    .toString())
            .addAllValues(new ArrayList<String>())
            .setLocation("location1901043637")
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    PartitionName name =
        PartitionName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]");

    Partition actualResponse = client.getPartition(name);
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
  public void getPartitionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PartitionName name =
          PartitionName.of(
              "[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]");
      client.getPartition(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPartitionTest2() throws Exception {
    Partition expectedResponse =
        Partition.newBuilder()
            .setName(
                PartitionName.of(
                        "[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]")
                    .toString())
            .addAllValues(new ArrayList<String>())
            .setLocation("location1901043637")
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6283/locations/location-6283/lakes/lake-6283/zones/zone-6283/entities/entitie-6283/partitions/partition-6283";

    Partition actualResponse = client.getPartition(name);
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
  public void getPartitionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6283/locations/location-6283/lakes/lake-6283/zones/zone-6283/entities/entitie-6283/partitions/partition-6283";
      client.getPartition(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPartitionsTest() throws Exception {
    Partition responsesElement = Partition.newBuilder().build();
    ListPartitionsResponse expectedResponse =
        ListPartitionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPartitions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    EntityName parent = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");

    ListPartitionsPagedResponse pagedListResponse = client.listPartitions(parent);

    List<Partition> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPartitionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listPartitionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntityName parent = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");
      client.listPartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPartitionsTest2() throws Exception {
    Partition responsesElement = Partition.newBuilder().build();
    ListPartitionsResponse expectedResponse =
        ListPartitionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPartitions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-9473/locations/location-9473/lakes/lake-9473/zones/zone-9473/entities/entitie-9473";

    ListPartitionsPagedResponse pagedListResponse = client.listPartitions(parent);

    List<Partition> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPartitionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listPartitionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9473/locations/location-9473/lakes/lake-9473/zones/zone-9473/entities/entitie-9473";
      client.listPartitions(parent);
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
