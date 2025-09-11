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

package com.google.cloud.firestore.v1;

import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListFieldsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListIndexesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.firestore.v1.stub.HttpJsonFirestoreAdminStub;
import com.google.common.collect.Lists;
import com.google.firestore.admin.v1.Backup;
import com.google.firestore.admin.v1.BackupName;
import com.google.firestore.admin.v1.BackupSchedule;
import com.google.firestore.admin.v1.BackupScheduleName;
import com.google.firestore.admin.v1.BulkDeleteDocumentsResponse;
import com.google.firestore.admin.v1.CloneDatabaseRequest;
import com.google.firestore.admin.v1.CollectionGroupName;
import com.google.firestore.admin.v1.Database;
import com.google.firestore.admin.v1.DatabaseName;
import com.google.firestore.admin.v1.ExportDocumentsResponse;
import com.google.firestore.admin.v1.Field;
import com.google.firestore.admin.v1.FieldName;
import com.google.firestore.admin.v1.Index;
import com.google.firestore.admin.v1.IndexName;
import com.google.firestore.admin.v1.ListBackupSchedulesResponse;
import com.google.firestore.admin.v1.ListBackupsResponse;
import com.google.firestore.admin.v1.ListDatabasesResponse;
import com.google.firestore.admin.v1.ListFieldsResponse;
import com.google.firestore.admin.v1.ListIndexesResponse;
import com.google.firestore.admin.v1.ListUserCredsResponse;
import com.google.firestore.admin.v1.LocationName;
import com.google.firestore.admin.v1.PitrSnapshot;
import com.google.firestore.admin.v1.ProjectName;
import com.google.firestore.admin.v1.RestoreDatabaseRequest;
import com.google.firestore.admin.v1.UserCreds;
import com.google.firestore.admin.v1.UserCredsName;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
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
public class FirestoreAdminClientHttpJsonTest {
  private static MockHttpService mockService;
  private static FirestoreAdminClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonFirestoreAdminStub.getMethodDescriptors(),
            FirestoreAdminSettings.getDefaultEndpoint());
    FirestoreAdminSettings settings =
        FirestoreAdminSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                FirestoreAdminSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FirestoreAdminClient.create(settings);
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
  public void createIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]").toString())
            .addAllFields(new ArrayList<Index.IndexField>())
            .setMultikey(true)
            .setShardCount(-495377042)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CollectionGroupName parent = CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]");
    Index index = Index.newBuilder().build();

    Index actualResponse = client.createIndexAsync(parent, index).get();
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
  public void createIndexExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectionGroupName parent =
          CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]");
      Index index = Index.newBuilder().build();
      client.createIndexAsync(parent, index).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createIndexTest2() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]").toString())
            .addAllFields(new ArrayList<Index.IndexField>())
            .setMultikey(true)
            .setShardCount(-495377042)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-1737/databases/database-1737/collectionGroups/collectionGroup-1737";
    Index index = Index.newBuilder().build();

    Index actualResponse = client.createIndexAsync(parent, index).get();
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
  public void createIndexExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1737/databases/database-1737/collectionGroups/collectionGroup-1737";
      Index index = Index.newBuilder().build();
      client.createIndexAsync(parent, index).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listIndexesTest() throws Exception {
    Index responsesElement = Index.newBuilder().build();
    ListIndexesResponse expectedResponse =
        ListIndexesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIndexes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CollectionGroupName parent = CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]");

    ListIndexesPagedResponse pagedListResponse = client.listIndexes(parent);

    List<Index> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listIndexesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectionGroupName parent =
          CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]");
      client.listIndexes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIndexesTest2() throws Exception {
    Index responsesElement = Index.newBuilder().build();
    ListIndexesResponse expectedResponse =
        ListIndexesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIndexes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1737/databases/database-1737/collectionGroups/collectionGroup-1737";

    ListIndexesPagedResponse pagedListResponse = client.listIndexes(parent);

    List<Index> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listIndexesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1737/databases/database-1737/collectionGroups/collectionGroup-1737";
      client.listIndexes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]").toString())
            .addAllFields(new ArrayList<Index.IndexField>())
            .setMultikey(true)
            .setShardCount(-495377042)
            .build();
    mockService.addResponse(expectedResponse);

    IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]");

    Index actualResponse = client.getIndex(name);
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
  public void getIndexExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]");
      client.getIndex(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIndexTest2() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]").toString())
            .addAllFields(new ArrayList<Index.IndexField>())
            .setMultikey(true)
            .setShardCount(-495377042)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5884/databases/database-5884/collectionGroups/collectionGroup-5884/indexes/indexe-5884";

    Index actualResponse = client.getIndex(name);
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
  public void getIndexExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5884/databases/database-5884/collectionGroups/collectionGroup-5884/indexes/indexe-5884";
      client.getIndex(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIndexTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]");

    client.deleteIndex(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteIndexExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]");
      client.deleteIndex(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIndexTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5884/databases/database-5884/collectionGroups/collectionGroup-5884/indexes/indexe-5884";

    client.deleteIndex(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteIndexExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5884/databases/database-5884/collectionGroups/collectionGroup-5884/indexes/indexe-5884";
      client.deleteIndex(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFieldTest() throws Exception {
    Field expectedResponse =
        Field.newBuilder()
            .setName(FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[FIELD]").toString())
            .setIndexConfig(Field.IndexConfig.newBuilder().build())
            .setTtlConfig(Field.TtlConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    FieldName name = FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[FIELD]");

    Field actualResponse = client.getField(name);
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
  public void getFieldExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FieldName name = FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[FIELD]");
      client.getField(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFieldTest2() throws Exception {
    Field expectedResponse =
        Field.newBuilder()
            .setName(FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[FIELD]").toString())
            .setIndexConfig(Field.IndexConfig.newBuilder().build())
            .setTtlConfig(Field.TtlConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1275/databases/database-1275/collectionGroups/collectionGroup-1275/fields/field-1275";

    Field actualResponse = client.getField(name);
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
  public void getFieldExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1275/databases/database-1275/collectionGroups/collectionGroup-1275/fields/field-1275";
      client.getField(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFieldTest() throws Exception {
    Field expectedResponse =
        Field.newBuilder()
            .setName(FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[FIELD]").toString())
            .setIndexConfig(Field.IndexConfig.newBuilder().build())
            .setTtlConfig(Field.TtlConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFieldTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Field field =
        Field.newBuilder()
            .setName(FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[FIELD]").toString())
            .setIndexConfig(Field.IndexConfig.newBuilder().build())
            .setTtlConfig(Field.TtlConfig.newBuilder().build())
            .build();

    Field actualResponse = client.updateFieldAsync(field).get();
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
  public void updateFieldExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Field field =
          Field.newBuilder()
              .setName(
                  FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[FIELD]").toString())
              .setIndexConfig(Field.IndexConfig.newBuilder().build())
              .setTtlConfig(Field.TtlConfig.newBuilder().build())
              .build();
      client.updateFieldAsync(field).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listFieldsTest() throws Exception {
    Field responsesElement = Field.newBuilder().build();
    ListFieldsResponse expectedResponse =
        ListFieldsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFields(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CollectionGroupName parent = CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]");

    ListFieldsPagedResponse pagedListResponse = client.listFields(parent);

    List<Field> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFieldsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listFieldsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectionGroupName parent =
          CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]");
      client.listFields(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFieldsTest2() throws Exception {
    Field responsesElement = Field.newBuilder().build();
    ListFieldsResponse expectedResponse =
        ListFieldsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFields(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1737/databases/database-1737/collectionGroups/collectionGroup-1737";

    ListFieldsPagedResponse pagedListResponse = client.listFields(parent);

    List<Field> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFieldsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listFieldsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1737/databases/database-1737/collectionGroups/collectionGroup-1737";
      client.listFields(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportDocumentsTest() throws Exception {
    ExportDocumentsResponse expectedResponse =
        ExportDocumentsResponse.newBuilder().setOutputUriPrefix("outputUriPrefix499858205").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");

    ExportDocumentsResponse actualResponse = client.exportDocumentsAsync(name).get();
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
  public void exportDocumentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
      client.exportDocumentsAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportDocumentsTest2() throws Exception {
    ExportDocumentsResponse expectedResponse =
        ExportDocumentsResponse.newBuilder().setOutputUriPrefix("outputUriPrefix499858205").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-2580/databases/database-2580";

    ExportDocumentsResponse actualResponse = client.exportDocumentsAsync(name).get();
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
  public void exportDocumentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2580/databases/database-2580";
      client.exportDocumentsAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void importDocumentsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");

    client.importDocumentsAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void importDocumentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
      client.importDocumentsAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void importDocumentsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-2580/databases/database-2580";

    client.importDocumentsAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void importDocumentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2580/databases/database-2580";
      client.importDocumentsAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void bulkDeleteDocumentsTest() throws Exception {
    BulkDeleteDocumentsResponse expectedResponse = BulkDeleteDocumentsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("bulkDeleteDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");

    BulkDeleteDocumentsResponse actualResponse = client.bulkDeleteDocumentsAsync(name).get();
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
  public void bulkDeleteDocumentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
      client.bulkDeleteDocumentsAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void bulkDeleteDocumentsTest2() throws Exception {
    BulkDeleteDocumentsResponse expectedResponse = BulkDeleteDocumentsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("bulkDeleteDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-2580/databases/database-2580";

    BulkDeleteDocumentsResponse actualResponse = client.bulkDeleteDocumentsAsync(name).get();
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
  public void bulkDeleteDocumentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2580/databases/database-2580";
      client.bulkDeleteDocumentsAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createDatabaseTest() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setLocationId("locationId1541836720")
            .setVersionRetentionPeriod(Duration.newBuilder().build())
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setKeyPrefix("keyPrefix-2076395055")
            .setCmekConfig(Database.CmekConfig.newBuilder().build())
            .setPreviousId("previousId-32447886")
            .setSourceInfo(Database.SourceInfo.newBuilder().build())
            .putAllTags(new HashMap<String, String>())
            .setFreeTier(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Database database = Database.newBuilder().build();
    String databaseId = "databaseId1688905718";

    Database actualResponse = client.createDatabaseAsync(parent, database, databaseId).get();
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
  public void createDatabaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Database database = Database.newBuilder().build();
      String databaseId = "databaseId1688905718";
      client.createDatabaseAsync(parent, database, databaseId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createDatabaseTest2() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setLocationId("locationId1541836720")
            .setVersionRetentionPeriod(Duration.newBuilder().build())
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setKeyPrefix("keyPrefix-2076395055")
            .setCmekConfig(Database.CmekConfig.newBuilder().build())
            .setPreviousId("previousId-32447886")
            .setSourceInfo(Database.SourceInfo.newBuilder().build())
            .putAllTags(new HashMap<String, String>())
            .setFreeTier(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-2353";
    Database database = Database.newBuilder().build();
    String databaseId = "databaseId1688905718";

    Database actualResponse = client.createDatabaseAsync(parent, database, databaseId).get();
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
  public void createDatabaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      Database database = Database.newBuilder().build();
      String databaseId = "databaseId1688905718";
      client.createDatabaseAsync(parent, database, databaseId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getDatabaseTest() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setLocationId("locationId1541836720")
            .setVersionRetentionPeriod(Duration.newBuilder().build())
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setKeyPrefix("keyPrefix-2076395055")
            .setCmekConfig(Database.CmekConfig.newBuilder().build())
            .setPreviousId("previousId-32447886")
            .setSourceInfo(Database.SourceInfo.newBuilder().build())
            .putAllTags(new HashMap<String, String>())
            .setFreeTier(true)
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");

    Database actualResponse = client.getDatabase(name);
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
  public void getDatabaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
      client.getDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatabaseTest2() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setLocationId("locationId1541836720")
            .setVersionRetentionPeriod(Duration.newBuilder().build())
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setKeyPrefix("keyPrefix-2076395055")
            .setCmekConfig(Database.CmekConfig.newBuilder().build())
            .setPreviousId("previousId-32447886")
            .setSourceInfo(Database.SourceInfo.newBuilder().build())
            .putAllTags(new HashMap<String, String>())
            .setFreeTier(true)
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2580/databases/database-2580";

    Database actualResponse = client.getDatabase(name);
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
  public void getDatabaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2580/databases/database-2580";
      client.getDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatabasesTest() throws Exception {
    ListDatabasesResponse expectedResponse =
        ListDatabasesResponse.newBuilder()
            .addAllDatabases(new ArrayList<Database>())
            .addAllUnreachable(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListDatabasesResponse actualResponse = client.listDatabases(parent);
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
  public void listDatabasesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatabasesTest2() throws Exception {
    ListDatabasesResponse expectedResponse =
        ListDatabasesResponse.newBuilder()
            .addAllDatabases(new ArrayList<Database>())
            .addAllUnreachable(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListDatabasesResponse actualResponse = client.listDatabases(parent);
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
  public void listDatabasesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      client.listDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDatabaseTest() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setLocationId("locationId1541836720")
            .setVersionRetentionPeriod(Duration.newBuilder().build())
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setKeyPrefix("keyPrefix-2076395055")
            .setCmekConfig(Database.CmekConfig.newBuilder().build())
            .setPreviousId("previousId-32447886")
            .setSourceInfo(Database.SourceInfo.newBuilder().build())
            .putAllTags(new HashMap<String, String>())
            .setFreeTier(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Database database =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setLocationId("locationId1541836720")
            .setVersionRetentionPeriod(Duration.newBuilder().build())
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setKeyPrefix("keyPrefix-2076395055")
            .setCmekConfig(Database.CmekConfig.newBuilder().build())
            .setPreviousId("previousId-32447886")
            .setSourceInfo(Database.SourceInfo.newBuilder().build())
            .putAllTags(new HashMap<String, String>())
            .setFreeTier(true)
            .setEtag("etag3123477")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Database actualResponse = client.updateDatabaseAsync(database, updateMask).get();
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
  public void updateDatabaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Database database =
          Database.newBuilder()
              .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
              .setUid("uid115792")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setLocationId("locationId1541836720")
              .setVersionRetentionPeriod(Duration.newBuilder().build())
              .setEarliestVersionTime(Timestamp.newBuilder().build())
              .setKeyPrefix("keyPrefix-2076395055")
              .setCmekConfig(Database.CmekConfig.newBuilder().build())
              .setPreviousId("previousId-32447886")
              .setSourceInfo(Database.SourceInfo.newBuilder().build())
              .putAllTags(new HashMap<String, String>())
              .setFreeTier(true)
              .setEtag("etag3123477")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDatabaseAsync(database, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDatabaseTest() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setLocationId("locationId1541836720")
            .setVersionRetentionPeriod(Duration.newBuilder().build())
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setKeyPrefix("keyPrefix-2076395055")
            .setCmekConfig(Database.CmekConfig.newBuilder().build())
            .setPreviousId("previousId-32447886")
            .setSourceInfo(Database.SourceInfo.newBuilder().build())
            .putAllTags(new HashMap<String, String>())
            .setFreeTier(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");

    Database actualResponse = client.deleteDatabaseAsync(name).get();
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
  public void deleteDatabaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
      client.deleteDatabaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDatabaseTest2() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setLocationId("locationId1541836720")
            .setVersionRetentionPeriod(Duration.newBuilder().build())
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setKeyPrefix("keyPrefix-2076395055")
            .setCmekConfig(Database.CmekConfig.newBuilder().build())
            .setPreviousId("previousId-32447886")
            .setSourceInfo(Database.SourceInfo.newBuilder().build())
            .putAllTags(new HashMap<String, String>())
            .setFreeTier(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-2580/databases/database-2580";

    Database actualResponse = client.deleteDatabaseAsync(name).get();
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
  public void deleteDatabaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2580/databases/database-2580";
      client.deleteDatabaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createUserCredsTest() throws Exception {
    UserCreds expectedResponse =
        UserCreds.newBuilder()
            .setName(UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSecurePassword("securePassword715395890")
            .build();
    mockService.addResponse(expectedResponse);

    DatabaseName parent = DatabaseName.of("[PROJECT]", "[DATABASE]");
    UserCreds userCreds = UserCreds.newBuilder().build();
    String userCredsId = "userCredsId726775445";

    UserCreds actualResponse = client.createUserCreds(parent, userCreds, userCredsId);
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
  public void createUserCredsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatabaseName parent = DatabaseName.of("[PROJECT]", "[DATABASE]");
      UserCreds userCreds = UserCreds.newBuilder().build();
      String userCredsId = "userCredsId726775445";
      client.createUserCreds(parent, userCreds, userCredsId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserCredsTest2() throws Exception {
    UserCreds expectedResponse =
        UserCreds.newBuilder()
            .setName(UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSecurePassword("securePassword715395890")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9821/databases/database-9821";
    UserCreds userCreds = UserCreds.newBuilder().build();
    String userCredsId = "userCredsId726775445";

    UserCreds actualResponse = client.createUserCreds(parent, userCreds, userCredsId);
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
  public void createUserCredsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9821/databases/database-9821";
      UserCreds userCreds = UserCreds.newBuilder().build();
      String userCredsId = "userCredsId726775445";
      client.createUserCreds(parent, userCreds, userCredsId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserCredsTest() throws Exception {
    UserCreds expectedResponse =
        UserCreds.newBuilder()
            .setName(UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSecurePassword("securePassword715395890")
            .build();
    mockService.addResponse(expectedResponse);

    UserCredsName name = UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]");

    UserCreds actualResponse = client.getUserCreds(name);
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
  public void getUserCredsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserCredsName name = UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]");
      client.getUserCreds(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserCredsTest2() throws Exception {
    UserCreds expectedResponse =
        UserCreds.newBuilder()
            .setName(UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSecurePassword("securePassword715395890")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3654/databases/database-3654/userCreds/userCred-3654";

    UserCreds actualResponse = client.getUserCreds(name);
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
  public void getUserCredsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3654/databases/database-3654/userCreds/userCred-3654";
      client.getUserCreds(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserCredsTest() throws Exception {
    ListUserCredsResponse expectedResponse =
        ListUserCredsResponse.newBuilder().addAllUserCreds(new ArrayList<UserCreds>()).build();
    mockService.addResponse(expectedResponse);

    DatabaseName parent = DatabaseName.of("[PROJECT]", "[DATABASE]");

    ListUserCredsResponse actualResponse = client.listUserCreds(parent);
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
  public void listUserCredsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatabaseName parent = DatabaseName.of("[PROJECT]", "[DATABASE]");
      client.listUserCreds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserCredsTest2() throws Exception {
    ListUserCredsResponse expectedResponse =
        ListUserCredsResponse.newBuilder().addAllUserCreds(new ArrayList<UserCreds>()).build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9821/databases/database-9821";

    ListUserCredsResponse actualResponse = client.listUserCreds(parent);
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
  public void listUserCredsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9821/databases/database-9821";
      client.listUserCreds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableUserCredsTest() throws Exception {
    UserCreds expectedResponse =
        UserCreds.newBuilder()
            .setName(UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSecurePassword("securePassword715395890")
            .build();
    mockService.addResponse(expectedResponse);

    UserCredsName name = UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]");

    UserCreds actualResponse = client.enableUserCreds(name);
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
  public void enableUserCredsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserCredsName name = UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]");
      client.enableUserCreds(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableUserCredsTest2() throws Exception {
    UserCreds expectedResponse =
        UserCreds.newBuilder()
            .setName(UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSecurePassword("securePassword715395890")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3654/databases/database-3654/userCreds/userCred-3654";

    UserCreds actualResponse = client.enableUserCreds(name);
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
  public void enableUserCredsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3654/databases/database-3654/userCreds/userCred-3654";
      client.enableUserCreds(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disableUserCredsTest() throws Exception {
    UserCreds expectedResponse =
        UserCreds.newBuilder()
            .setName(UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSecurePassword("securePassword715395890")
            .build();
    mockService.addResponse(expectedResponse);

    UserCredsName name = UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]");

    UserCreds actualResponse = client.disableUserCreds(name);
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
  public void disableUserCredsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserCredsName name = UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]");
      client.disableUserCreds(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disableUserCredsTest2() throws Exception {
    UserCreds expectedResponse =
        UserCreds.newBuilder()
            .setName(UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSecurePassword("securePassword715395890")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3654/databases/database-3654/userCreds/userCred-3654";

    UserCreds actualResponse = client.disableUserCreds(name);
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
  public void disableUserCredsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3654/databases/database-3654/userCreds/userCred-3654";
      client.disableUserCreds(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetUserPasswordTest() throws Exception {
    UserCreds expectedResponse =
        UserCreds.newBuilder()
            .setName(UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSecurePassword("securePassword715395890")
            .build();
    mockService.addResponse(expectedResponse);

    UserCredsName name = UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]");

    UserCreds actualResponse = client.resetUserPassword(name);
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
  public void resetUserPasswordExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserCredsName name = UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]");
      client.resetUserPassword(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetUserPasswordTest2() throws Exception {
    UserCreds expectedResponse =
        UserCreds.newBuilder()
            .setName(UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSecurePassword("securePassword715395890")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3654/databases/database-3654/userCreds/userCred-3654";

    UserCreds actualResponse = client.resetUserPassword(name);
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
  public void resetUserPasswordExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3654/databases/database-3654/userCreds/userCred-3654";
      client.resetUserPassword(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserCredsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    UserCredsName name = UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]");

    client.deleteUserCreds(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteUserCredsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UserCredsName name = UserCredsName.of("[PROJECT]", "[DATABASE]", "[USER_CREDS]");
      client.deleteUserCreds(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserCredsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3654/databases/database-3654/userCreds/userCred-3654";

    client.deleteUserCreds(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteUserCredsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3654/databases/database-3654/userCreds/userCred-3654";
      client.deleteUserCreds(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupTest() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
            .setDatabase(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
            .setDatabaseUid("databaseUid816481493")
            .setSnapshotTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setStats(Backup.Stats.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]");

    Backup actualResponse = client.getBackup(name);
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
  public void getBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]");
      client.getBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupTest2() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
            .setDatabase(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
            .setDatabaseUid("databaseUid816481493")
            .setSnapshotTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setStats(Backup.Stats.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1607/locations/location-1607/backups/backup-1607";

    Backup actualResponse = client.getBackup(name);
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
  public void getBackupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1607/locations/location-1607/backups/backup-1607";
      client.getBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupsTest() throws Exception {
    ListBackupsResponse expectedResponse =
        ListBackupsResponse.newBuilder()
            .addAllBackups(new ArrayList<Backup>())
            .addAllUnreachable(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBackupsResponse actualResponse = client.listBackups(parent);
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
  public void listBackupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupsTest2() throws Exception {
    ListBackupsResponse expectedResponse =
        ListBackupsResponse.newBuilder()
            .addAllBackups(new ArrayList<Backup>())
            .addAllUnreachable(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListBackupsResponse actualResponse = client.listBackups(parent);
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
  public void listBackupsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBackupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]");

    client.deleteBackup(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]");
      client.deleteBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBackupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1607/locations/location-1607/backups/backup-1607";

    client.deleteBackup(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1607/locations/location-1607/backups/backup-1607";
      client.deleteBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void restoreDatabaseTest() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setLocationId("locationId1541836720")
            .setVersionRetentionPeriod(Duration.newBuilder().build())
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setKeyPrefix("keyPrefix-2076395055")
            .setCmekConfig(Database.CmekConfig.newBuilder().build())
            .setPreviousId("previousId-32447886")
            .setSourceInfo(Database.SourceInfo.newBuilder().build())
            .putAllTags(new HashMap<String, String>())
            .setFreeTier(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RestoreDatabaseRequest request =
        RestoreDatabaseRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setDatabaseId("databaseId1688905718")
            .setBackup(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
            .setEncryptionConfig(Database.EncryptionConfig.newBuilder().build())
            .putAllTags(new HashMap<String, String>())
            .build();

    Database actualResponse = client.restoreDatabaseAsync(request).get();
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
  public void restoreDatabaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RestoreDatabaseRequest request =
          RestoreDatabaseRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setDatabaseId("databaseId1688905718")
              .setBackup(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
              .setEncryptionConfig(Database.EncryptionConfig.newBuilder().build())
              .putAllTags(new HashMap<String, String>())
              .build();
      client.restoreDatabaseAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createBackupScheduleTest() throws Exception {
    BackupSchedule expectedResponse =
        BackupSchedule.newBuilder()
            .setName(
                BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRetention(Duration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DatabaseName parent = DatabaseName.of("[PROJECT]", "[DATABASE]");
    BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();

    BackupSchedule actualResponse = client.createBackupSchedule(parent, backupSchedule);
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
  public void createBackupScheduleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatabaseName parent = DatabaseName.of("[PROJECT]", "[DATABASE]");
      BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
      client.createBackupSchedule(parent, backupSchedule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBackupScheduleTest2() throws Exception {
    BackupSchedule expectedResponse =
        BackupSchedule.newBuilder()
            .setName(
                BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRetention(Duration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9821/databases/database-9821";
    BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();

    BackupSchedule actualResponse = client.createBackupSchedule(parent, backupSchedule);
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
  public void createBackupScheduleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9821/databases/database-9821";
      BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
      client.createBackupSchedule(parent, backupSchedule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupScheduleTest() throws Exception {
    BackupSchedule expectedResponse =
        BackupSchedule.newBuilder()
            .setName(
                BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRetention(Duration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    BackupScheduleName name = BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]");

    BackupSchedule actualResponse = client.getBackupSchedule(name);
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
  public void getBackupScheduleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupScheduleName name =
          BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]");
      client.getBackupSchedule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupScheduleTest2() throws Exception {
    BackupSchedule expectedResponse =
        BackupSchedule.newBuilder()
            .setName(
                BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRetention(Duration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3270/databases/database-3270/backupSchedules/backupSchedule-3270";

    BackupSchedule actualResponse = client.getBackupSchedule(name);
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
  public void getBackupScheduleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3270/databases/database-3270/backupSchedules/backupSchedule-3270";
      client.getBackupSchedule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupSchedulesTest() throws Exception {
    ListBackupSchedulesResponse expectedResponse =
        ListBackupSchedulesResponse.newBuilder()
            .addAllBackupSchedules(new ArrayList<BackupSchedule>())
            .build();
    mockService.addResponse(expectedResponse);

    DatabaseName parent = DatabaseName.of("[PROJECT]", "[DATABASE]");

    ListBackupSchedulesResponse actualResponse = client.listBackupSchedules(parent);
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
  public void listBackupSchedulesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatabaseName parent = DatabaseName.of("[PROJECT]", "[DATABASE]");
      client.listBackupSchedules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupSchedulesTest2() throws Exception {
    ListBackupSchedulesResponse expectedResponse =
        ListBackupSchedulesResponse.newBuilder()
            .addAllBackupSchedules(new ArrayList<BackupSchedule>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9821/databases/database-9821";

    ListBackupSchedulesResponse actualResponse = client.listBackupSchedules(parent);
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
  public void listBackupSchedulesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9821/databases/database-9821";
      client.listBackupSchedules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBackupScheduleTest() throws Exception {
    BackupSchedule expectedResponse =
        BackupSchedule.newBuilder()
            .setName(
                BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRetention(Duration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    BackupSchedule backupSchedule =
        BackupSchedule.newBuilder()
            .setName(
                BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRetention(Duration.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BackupSchedule actualResponse = client.updateBackupSchedule(backupSchedule, updateMask);
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
  public void updateBackupScheduleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupSchedule backupSchedule =
          BackupSchedule.newBuilder()
              .setName(
                  BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setRetention(Duration.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackupSchedule(backupSchedule, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBackupScheduleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    BackupScheduleName name = BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]");

    client.deleteBackupSchedule(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupScheduleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupScheduleName name =
          BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]");
      client.deleteBackupSchedule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBackupScheduleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3270/databases/database-3270/backupSchedules/backupSchedule-3270";

    client.deleteBackupSchedule(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupScheduleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3270/databases/database-3270/backupSchedules/backupSchedule-3270";
      client.deleteBackupSchedule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cloneDatabaseTest() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setLocationId("locationId1541836720")
            .setVersionRetentionPeriod(Duration.newBuilder().build())
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setKeyPrefix("keyPrefix-2076395055")
            .setCmekConfig(Database.CmekConfig.newBuilder().build())
            .setPreviousId("previousId-32447886")
            .setSourceInfo(Database.SourceInfo.newBuilder().build())
            .putAllTags(new HashMap<String, String>())
            .setFreeTier(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("cloneDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CloneDatabaseRequest request =
        CloneDatabaseRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setDatabaseId("databaseId1688905718")
            .setPitrSnapshot(PitrSnapshot.newBuilder().build())
            .setEncryptionConfig(Database.EncryptionConfig.newBuilder().build())
            .putAllTags(new HashMap<String, String>())
            .build();

    Database actualResponse = client.cloneDatabaseAsync(request).get();
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
  public void cloneDatabaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloneDatabaseRequest request =
          CloneDatabaseRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setDatabaseId("databaseId1688905718")
              .setPitrSnapshot(PitrSnapshot.newBuilder().build())
              .setEncryptionConfig(Database.EncryptionConfig.newBuilder().build())
              .putAllTags(new HashMap<String, String>())
              .build();
      client.cloneDatabaseAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
