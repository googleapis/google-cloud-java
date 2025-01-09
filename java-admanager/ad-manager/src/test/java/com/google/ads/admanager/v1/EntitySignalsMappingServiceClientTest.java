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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.EntitySignalsMappingServiceClient.ListEntitySignalsMappingsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonEntitySignalsMappingServiceStub;
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
public class EntitySignalsMappingServiceClientTest {
  private static MockHttpService mockService;
  private static EntitySignalsMappingServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonEntitySignalsMappingServiceStub.getMethodDescriptors(),
            EntitySignalsMappingServiceSettings.getDefaultEndpoint());
    EntitySignalsMappingServiceSettings settings =
        EntitySignalsMappingServiceSettings.newBuilder()
            .setTransportChannelProvider(
                EntitySignalsMappingServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EntitySignalsMappingServiceClient.create(settings);
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
  public void getEntitySignalsMappingTest() throws Exception {
    EntitySignalsMapping expectedResponse =
        EntitySignalsMapping.newBuilder()
            .setName(
                EntitySignalsMappingName.of("[NETWORK_CODE]", "[ENTITY_SIGNALS_MAPPING]")
                    .toString())
            .setEntitySignalsMappingId(-350688772)
            .addAllTaxonomyCategoryIds(new ArrayList<Long>())
            .build();
    mockService.addResponse(expectedResponse);

    EntitySignalsMappingName name =
        EntitySignalsMappingName.of("[NETWORK_CODE]", "[ENTITY_SIGNALS_MAPPING]");

    EntitySignalsMapping actualResponse = client.getEntitySignalsMapping(name);
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
  public void getEntitySignalsMappingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntitySignalsMappingName name =
          EntitySignalsMappingName.of("[NETWORK_CODE]", "[ENTITY_SIGNALS_MAPPING]");
      client.getEntitySignalsMapping(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntitySignalsMappingTest2() throws Exception {
    EntitySignalsMapping expectedResponse =
        EntitySignalsMapping.newBuilder()
            .setName(
                EntitySignalsMappingName.of("[NETWORK_CODE]", "[ENTITY_SIGNALS_MAPPING]")
                    .toString())
            .setEntitySignalsMappingId(-350688772)
            .addAllTaxonomyCategoryIds(new ArrayList<Long>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-8516/entitySignalsMappings/entitySignalsMapping-8516";

    EntitySignalsMapping actualResponse = client.getEntitySignalsMapping(name);
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
  public void getEntitySignalsMappingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-8516/entitySignalsMappings/entitySignalsMapping-8516";
      client.getEntitySignalsMapping(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitySignalsMappingsTest() throws Exception {
    EntitySignalsMapping responsesElement = EntitySignalsMapping.newBuilder().build();
    ListEntitySignalsMappingsResponse expectedResponse =
        ListEntitySignalsMappingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitySignalsMappings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListEntitySignalsMappingsPagedResponse pagedListResponse =
        client.listEntitySignalsMappings(parent);

    List<EntitySignalsMapping> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitySignalsMappingsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEntitySignalsMappingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listEntitySignalsMappings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitySignalsMappingsTest2() throws Exception {
    EntitySignalsMapping responsesElement = EntitySignalsMapping.newBuilder().build();
    ListEntitySignalsMappingsResponse expectedResponse =
        ListEntitySignalsMappingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitySignalsMappings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListEntitySignalsMappingsPagedResponse pagedListResponse =
        client.listEntitySignalsMappings(parent);

    List<EntitySignalsMapping> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitySignalsMappingsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEntitySignalsMappingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listEntitySignalsMappings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntitySignalsMappingTest() throws Exception {
    EntitySignalsMapping expectedResponse =
        EntitySignalsMapping.newBuilder()
            .setName(
                EntitySignalsMappingName.of("[NETWORK_CODE]", "[ENTITY_SIGNALS_MAPPING]")
                    .toString())
            .setEntitySignalsMappingId(-350688772)
            .addAllTaxonomyCategoryIds(new ArrayList<Long>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    EntitySignalsMapping entitySignalsMapping = EntitySignalsMapping.newBuilder().build();

    EntitySignalsMapping actualResponse =
        client.createEntitySignalsMapping(parent, entitySignalsMapping);
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
  public void createEntitySignalsMappingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      EntitySignalsMapping entitySignalsMapping = EntitySignalsMapping.newBuilder().build();
      client.createEntitySignalsMapping(parent, entitySignalsMapping);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntitySignalsMappingTest2() throws Exception {
    EntitySignalsMapping expectedResponse =
        EntitySignalsMapping.newBuilder()
            .setName(
                EntitySignalsMappingName.of("[NETWORK_CODE]", "[ENTITY_SIGNALS_MAPPING]")
                    .toString())
            .setEntitySignalsMappingId(-350688772)
            .addAllTaxonomyCategoryIds(new ArrayList<Long>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    EntitySignalsMapping entitySignalsMapping = EntitySignalsMapping.newBuilder().build();

    EntitySignalsMapping actualResponse =
        client.createEntitySignalsMapping(parent, entitySignalsMapping);
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
  public void createEntitySignalsMappingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      EntitySignalsMapping entitySignalsMapping = EntitySignalsMapping.newBuilder().build();
      client.createEntitySignalsMapping(parent, entitySignalsMapping);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEntitySignalsMappingTest() throws Exception {
    EntitySignalsMapping expectedResponse =
        EntitySignalsMapping.newBuilder()
            .setName(
                EntitySignalsMappingName.of("[NETWORK_CODE]", "[ENTITY_SIGNALS_MAPPING]")
                    .toString())
            .setEntitySignalsMappingId(-350688772)
            .addAllTaxonomyCategoryIds(new ArrayList<Long>())
            .build();
    mockService.addResponse(expectedResponse);

    EntitySignalsMapping entitySignalsMapping =
        EntitySignalsMapping.newBuilder()
            .setName(
                EntitySignalsMappingName.of("[NETWORK_CODE]", "[ENTITY_SIGNALS_MAPPING]")
                    .toString())
            .setEntitySignalsMappingId(-350688772)
            .addAllTaxonomyCategoryIds(new ArrayList<Long>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EntitySignalsMapping actualResponse =
        client.updateEntitySignalsMapping(entitySignalsMapping, updateMask);
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
  public void updateEntitySignalsMappingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntitySignalsMapping entitySignalsMapping =
          EntitySignalsMapping.newBuilder()
              .setName(
                  EntitySignalsMappingName.of("[NETWORK_CODE]", "[ENTITY_SIGNALS_MAPPING]")
                      .toString())
              .setEntitySignalsMappingId(-350688772)
              .addAllTaxonomyCategoryIds(new ArrayList<Long>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEntitySignalsMapping(entitySignalsMapping, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateEntitySignalsMappingsTest() throws Exception {
    BatchCreateEntitySignalsMappingsResponse expectedResponse =
        BatchCreateEntitySignalsMappingsResponse.newBuilder()
            .addAllEntitySignalsMappings(new ArrayList<EntitySignalsMapping>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateEntitySignalsMappingRequest> requests = new ArrayList<>();

    BatchCreateEntitySignalsMappingsResponse actualResponse =
        client.batchCreateEntitySignalsMappings(parent, requests);
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
  public void batchCreateEntitySignalsMappingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateEntitySignalsMappingRequest> requests = new ArrayList<>();
      client.batchCreateEntitySignalsMappings(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateEntitySignalsMappingsTest2() throws Exception {
    BatchCreateEntitySignalsMappingsResponse expectedResponse =
        BatchCreateEntitySignalsMappingsResponse.newBuilder()
            .addAllEntitySignalsMappings(new ArrayList<EntitySignalsMapping>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateEntitySignalsMappingRequest> requests = new ArrayList<>();

    BatchCreateEntitySignalsMappingsResponse actualResponse =
        client.batchCreateEntitySignalsMappings(parent, requests);
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
  public void batchCreateEntitySignalsMappingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateEntitySignalsMappingRequest> requests = new ArrayList<>();
      client.batchCreateEntitySignalsMappings(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateEntitySignalsMappingsTest() throws Exception {
    BatchUpdateEntitySignalsMappingsResponse expectedResponse =
        BatchUpdateEntitySignalsMappingsResponse.newBuilder()
            .addAllEntitySignalsMappings(new ArrayList<EntitySignalsMapping>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdateEntitySignalsMappingRequest> requests = new ArrayList<>();

    BatchUpdateEntitySignalsMappingsResponse actualResponse =
        client.batchUpdateEntitySignalsMappings(parent, requests);
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
  public void batchUpdateEntitySignalsMappingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdateEntitySignalsMappingRequest> requests = new ArrayList<>();
      client.batchUpdateEntitySignalsMappings(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateEntitySignalsMappingsTest2() throws Exception {
    BatchUpdateEntitySignalsMappingsResponse expectedResponse =
        BatchUpdateEntitySignalsMappingsResponse.newBuilder()
            .addAllEntitySignalsMappings(new ArrayList<EntitySignalsMapping>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdateEntitySignalsMappingRequest> requests = new ArrayList<>();

    BatchUpdateEntitySignalsMappingsResponse actualResponse =
        client.batchUpdateEntitySignalsMappings(parent, requests);
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
  public void batchUpdateEntitySignalsMappingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdateEntitySignalsMappingRequest> requests = new ArrayList<>();
      client.batchUpdateEntitySignalsMappings(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
