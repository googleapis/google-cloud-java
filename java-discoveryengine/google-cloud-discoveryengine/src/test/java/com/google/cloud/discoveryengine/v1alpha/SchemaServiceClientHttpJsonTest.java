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

package com.google.cloud.discoveryengine.v1alpha;

import static com.google.cloud.discoveryengine.v1alpha.SchemaServiceClient.ListSchemasPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1alpha.stub.HttpJsonSchemaServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class SchemaServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SchemaServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSchemaServiceStub.getMethodDescriptors(),
            SchemaServiceSettings.getDefaultEndpoint());
    SchemaServiceSettings settings =
        SchemaServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SchemaServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SchemaServiceClient.create(settings);
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
  public void getSchemaTest() throws Exception {
    Schema expectedResponse =
        Schema.newBuilder()
            .setName(
                SchemaName.ofProjectLocationDataStoreSchemaName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
                    .toString())
            .addAllFieldConfigs(new ArrayList<FieldConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    SchemaName name =
        SchemaName.ofProjectLocationDataStoreSchemaName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]");

    Schema actualResponse = client.getSchema(name);
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
  public void getSchemaExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SchemaName name =
          SchemaName.ofProjectLocationDataStoreSchemaName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]");
      client.getSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSchemaTest2() throws Exception {
    Schema expectedResponse =
        Schema.newBuilder()
            .setName(
                SchemaName.ofProjectLocationDataStoreSchemaName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
                    .toString())
            .addAllFieldConfigs(new ArrayList<FieldConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3094/locations/location-3094/dataStores/dataStore-3094/schemas/schema-3094";

    Schema actualResponse = client.getSchema(name);
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
  public void getSchemaExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3094/locations/location-3094/dataStores/dataStore-3094/schemas/schema-3094";
      client.getSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSchemasTest() throws Exception {
    Schema responsesElement = Schema.newBuilder().build();
    ListSchemasResponse expectedResponse =
        ListSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllSchemas(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");

    ListSchemasPagedResponse pagedListResponse = client.listSchemas(parent);

    List<Schema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSchemasList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSchemasExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStoreName parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      client.listSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSchemasTest2() throws Exception {
    Schema responsesElement = Schema.newBuilder().build();
    ListSchemasResponse expectedResponse =
        ListSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllSchemas(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";

    ListSchemasPagedResponse pagedListResponse = client.listSchemas(parent);

    List<Schema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSchemasList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSchemasExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
      client.listSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSchemaTest() throws Exception {
    Schema expectedResponse =
        Schema.newBuilder()
            .setName(
                SchemaName.ofProjectLocationDataStoreSchemaName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
                    .toString())
            .addAllFieldConfigs(new ArrayList<FieldConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSchemaTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
    Schema schema = Schema.newBuilder().build();
    String schemaId = "schemaId-697673060";

    Schema actualResponse = client.createSchemaAsync(parent, schema, schemaId).get();
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
  public void createSchemaExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStoreName parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      Schema schema = Schema.newBuilder().build();
      String schemaId = "schemaId-697673060";
      client.createSchemaAsync(parent, schema, schemaId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createSchemaTest2() throws Exception {
    Schema expectedResponse =
        Schema.newBuilder()
            .setName(
                SchemaName.ofProjectLocationDataStoreSchemaName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
                    .toString())
            .addAllFieldConfigs(new ArrayList<FieldConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSchemaTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
    Schema schema = Schema.newBuilder().build();
    String schemaId = "schemaId-697673060";

    Schema actualResponse = client.createSchemaAsync(parent, schema, schemaId).get();
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
  public void createSchemaExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
      Schema schema = Schema.newBuilder().build();
      String schemaId = "schemaId-697673060";
      client.createSchemaAsync(parent, schema, schemaId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateSchemaTest() throws Exception {
    Schema expectedResponse =
        Schema.newBuilder()
            .setName(
                SchemaName.ofProjectLocationDataStoreSchemaName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
                    .toString())
            .addAllFieldConfigs(new ArrayList<FieldConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSchemaTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    UpdateSchemaRequest request =
        UpdateSchemaRequest.newBuilder()
            .setSchema(
                Schema.newBuilder()
                    .setName(
                        SchemaName.ofProjectLocationDataStoreSchemaName(
                                "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
                            .toString())
                    .addAllFieldConfigs(new ArrayList<FieldConfig>())
                    .build())
            .setAllowMissing(true)
            .build();

    Schema actualResponse = client.updateSchemaAsync(request).get();
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
  public void updateSchemaExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateSchemaRequest request =
          UpdateSchemaRequest.newBuilder()
              .setSchema(
                  Schema.newBuilder()
                      .setName(
                          SchemaName.ofProjectLocationDataStoreSchemaName(
                                  "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
                              .toString())
                      .addAllFieldConfigs(new ArrayList<FieldConfig>())
                      .build())
              .setAllowMissing(true)
              .build();
      client.updateSchemaAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSchemaTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSchemaTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SchemaName name =
        SchemaName.ofProjectLocationDataStoreSchemaName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]");

    client.deleteSchemaAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSchemaExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SchemaName name =
          SchemaName.ofProjectLocationDataStoreSchemaName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]");
      client.deleteSchemaAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSchemaTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSchemaTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-3094/locations/location-3094/dataStores/dataStore-3094/schemas/schema-3094";

    client.deleteSchemaAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSchemaExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3094/locations/location-3094/dataStores/dataStore-3094/schemas/schema-3094";
      client.deleteSchemaAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
