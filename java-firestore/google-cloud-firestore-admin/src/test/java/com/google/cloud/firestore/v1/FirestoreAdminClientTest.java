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

package com.google.cloud.firestore.v1;

import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListFieldsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListIndexesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.firestore.admin.v1.Backup;
import com.google.firestore.admin.v1.BackupName;
import com.google.firestore.admin.v1.BackupSchedule;
import com.google.firestore.admin.v1.BackupScheduleName;
import com.google.firestore.admin.v1.BulkDeleteDocumentsRequest;
import com.google.firestore.admin.v1.BulkDeleteDocumentsResponse;
import com.google.firestore.admin.v1.CollectionGroupName;
import com.google.firestore.admin.v1.CreateBackupScheduleRequest;
import com.google.firestore.admin.v1.CreateDatabaseRequest;
import com.google.firestore.admin.v1.CreateIndexRequest;
import com.google.firestore.admin.v1.Database;
import com.google.firestore.admin.v1.DatabaseName;
import com.google.firestore.admin.v1.DeleteBackupRequest;
import com.google.firestore.admin.v1.DeleteBackupScheduleRequest;
import com.google.firestore.admin.v1.DeleteDatabaseRequest;
import com.google.firestore.admin.v1.DeleteIndexRequest;
import com.google.firestore.admin.v1.ExportDocumentsRequest;
import com.google.firestore.admin.v1.ExportDocumentsResponse;
import com.google.firestore.admin.v1.Field;
import com.google.firestore.admin.v1.FieldName;
import com.google.firestore.admin.v1.GetBackupRequest;
import com.google.firestore.admin.v1.GetBackupScheduleRequest;
import com.google.firestore.admin.v1.GetDatabaseRequest;
import com.google.firestore.admin.v1.GetFieldRequest;
import com.google.firestore.admin.v1.GetIndexRequest;
import com.google.firestore.admin.v1.ImportDocumentsRequest;
import com.google.firestore.admin.v1.Index;
import com.google.firestore.admin.v1.IndexName;
import com.google.firestore.admin.v1.ListBackupSchedulesRequest;
import com.google.firestore.admin.v1.ListBackupSchedulesResponse;
import com.google.firestore.admin.v1.ListBackupsRequest;
import com.google.firestore.admin.v1.ListBackupsResponse;
import com.google.firestore.admin.v1.ListDatabasesRequest;
import com.google.firestore.admin.v1.ListDatabasesResponse;
import com.google.firestore.admin.v1.ListFieldsRequest;
import com.google.firestore.admin.v1.ListFieldsResponse;
import com.google.firestore.admin.v1.ListIndexesRequest;
import com.google.firestore.admin.v1.ListIndexesResponse;
import com.google.firestore.admin.v1.LocationName;
import com.google.firestore.admin.v1.ProjectName;
import com.google.firestore.admin.v1.RestoreDatabaseRequest;
import com.google.firestore.admin.v1.UpdateBackupScheduleRequest;
import com.google.firestore.admin.v1.UpdateDatabaseRequest;
import com.google.firestore.admin.v1.UpdateFieldRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class FirestoreAdminClientTest {
  private static MockFirestoreAdmin mockFirestoreAdmin;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private FirestoreAdminClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockFirestoreAdmin = new MockFirestoreAdmin();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockFirestoreAdmin, mockLocations));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    FirestoreAdminSettings settings =
        FirestoreAdminSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FirestoreAdminClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]").toString())
            .addAllFields(new ArrayList<Index.IndexField>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirestoreAdmin.addResponse(resultOperation);

    CollectionGroupName parent = CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]");
    Index index = Index.newBuilder().build();

    Index actualResponse = client.createIndexAsync(parent, index).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIndexRequest actualRequest = ((CreateIndexRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(index, actualRequest.getIndex());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      CollectionGroupName parent =
          CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]");
      Index index = Index.newBuilder().build();
      client.createIndexAsync(parent, index).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createIndexTest2() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]").toString())
            .addAllFields(new ArrayList<Index.IndexField>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirestoreAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    Index index = Index.newBuilder().build();

    Index actualResponse = client.createIndexAsync(parent, index).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIndexRequest actualRequest = ((CreateIndexRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(index, actualRequest.getIndex());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIndexExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      Index index = Index.newBuilder().build();
      client.createIndexAsync(parent, index).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockFirestoreAdmin.addResponse(expectedResponse);

    CollectionGroupName parent = CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]");

    ListIndexesPagedResponse pagedListResponse = client.listIndexes(parent);

    List<Index> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIndexesRequest actualRequest = ((ListIndexesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIndexesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

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
    mockFirestoreAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListIndexesPagedResponse pagedListResponse = client.listIndexes(parent);

    List<Index> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIndexesRequest actualRequest = ((ListIndexesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIndexesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
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
            .build();
    mockFirestoreAdmin.addResponse(expectedResponse);

    IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]");

    Index actualResponse = client.getIndex(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIndexRequest actualRequest = ((GetIndexRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

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
            .build();
    mockFirestoreAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    Index actualResponse = client.getIndex(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIndexRequest actualRequest = ((GetIndexRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIndexExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.getIndex(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIndexTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockFirestoreAdmin.addResponse(expectedResponse);

    IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]");

    client.deleteIndex(name);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIndexRequest actualRequest = ((DeleteIndexRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

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
    mockFirestoreAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteIndex(name);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIndexRequest actualRequest = ((DeleteIndexRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIndexExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String name = "name3373707";
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
    mockFirestoreAdmin.addResponse(expectedResponse);

    FieldName name = FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[FIELD]");

    Field actualResponse = client.getField(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFieldRequest actualRequest = ((GetFieldRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFieldExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

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
    mockFirestoreAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    Field actualResponse = client.getField(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFieldRequest actualRequest = ((GetFieldRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFieldExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String name = "name3373707";
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
    mockFirestoreAdmin.addResponse(resultOperation);

    Field field = Field.newBuilder().build();

    Field actualResponse = client.updateFieldAsync(field).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFieldRequest actualRequest = ((UpdateFieldRequest) actualRequests.get(0));

    Assert.assertEquals(field, actualRequest.getField());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFieldExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      Field field = Field.newBuilder().build();
      client.updateFieldAsync(field).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockFirestoreAdmin.addResponse(expectedResponse);

    CollectionGroupName parent = CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]");

    ListFieldsPagedResponse pagedListResponse = client.listFields(parent);

    List<Field> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFieldsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFieldsRequest actualRequest = ((ListFieldsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFieldsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

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
    mockFirestoreAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFieldsPagedResponse pagedListResponse = client.listFields(parent);

    List<Field> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFieldsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFieldsRequest actualRequest = ((ListFieldsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFieldsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockFirestoreAdmin.addResponse(resultOperation);

    DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");

    ExportDocumentsResponse actualResponse = client.exportDocumentsAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportDocumentsRequest actualRequest = ((ExportDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
      client.exportDocumentsAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockFirestoreAdmin.addResponse(resultOperation);

    String name = "name3373707";

    ExportDocumentsResponse actualResponse = client.exportDocumentsAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportDocumentsRequest actualRequest = ((ExportDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportDocumentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.exportDocumentsAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockFirestoreAdmin.addResponse(resultOperation);

    DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");

    client.importDocumentsAsync(name).get();

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportDocumentsRequest actualRequest = ((ImportDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
      client.importDocumentsAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockFirestoreAdmin.addResponse(resultOperation);

    String name = "name3373707";

    client.importDocumentsAsync(name).get();

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportDocumentsRequest actualRequest = ((ImportDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importDocumentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.importDocumentsAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockFirestoreAdmin.addResponse(resultOperation);

    DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");

    BulkDeleteDocumentsResponse actualResponse = client.bulkDeleteDocumentsAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkDeleteDocumentsRequest actualRequest = ((BulkDeleteDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkDeleteDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
      client.bulkDeleteDocumentsAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockFirestoreAdmin.addResponse(resultOperation);

    String name = "name3373707";

    BulkDeleteDocumentsResponse actualResponse = client.bulkDeleteDocumentsAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkDeleteDocumentsRequest actualRequest = ((BulkDeleteDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkDeleteDocumentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.bulkDeleteDocumentsAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirestoreAdmin.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Database database = Database.newBuilder().build();
    String databaseId = "databaseId1688905718";

    Database actualResponse = client.createDatabaseAsync(parent, database, databaseId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDatabaseRequest actualRequest = ((CreateDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertEquals(databaseId, actualRequest.getDatabaseId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Database database = Database.newBuilder().build();
      String databaseId = "databaseId1688905718";
      client.createDatabaseAsync(parent, database, databaseId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirestoreAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    Database database = Database.newBuilder().build();
    String databaseId = "databaseId1688905718";

    Database actualResponse = client.createDatabaseAsync(parent, database, databaseId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDatabaseRequest actualRequest = ((CreateDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertEquals(databaseId, actualRequest.getDatabaseId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      Database database = Database.newBuilder().build();
      String databaseId = "databaseId1688905718";
      client.createDatabaseAsync(parent, database, databaseId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .setEtag("etag3123477")
            .build();
    mockFirestoreAdmin.addResponse(expectedResponse);

    DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");

    Database actualResponse = client.getDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatabaseRequest actualRequest = ((GetDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

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
            .setEtag("etag3123477")
            .build();
    mockFirestoreAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    Database actualResponse = client.getDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatabaseRequest actualRequest = ((GetDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String name = "name3373707";
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
    mockFirestoreAdmin.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListDatabasesResponse actualResponse = client.listDatabases(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatabasesRequest actualRequest = ((ListDatabasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatabasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

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
    mockFirestoreAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDatabasesResponse actualResponse = client.listDatabases(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatabasesRequest actualRequest = ((ListDatabasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatabasesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
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
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirestoreAdmin.addResponse(resultOperation);

    Database database = Database.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Database actualResponse = client.updateDatabaseAsync(database, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDatabaseRequest actualRequest = ((UpdateDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      Database database = Database.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDatabaseAsync(database, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirestoreAdmin.addResponse(resultOperation);

    DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");

    Database actualResponse = client.deleteDatabaseAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDatabaseRequest actualRequest = ((DeleteDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
      client.deleteDatabaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirestoreAdmin.addResponse(resultOperation);

    String name = "name3373707";

    Database actualResponse = client.deleteDatabaseAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDatabaseRequest actualRequest = ((DeleteDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDatabaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockFirestoreAdmin.addResponse(expectedResponse);

    BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]");

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupRequest actualRequest = ((GetBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

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
    mockFirestoreAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupRequest actualRequest = ((GetBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String name = "name3373707";
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
    mockFirestoreAdmin.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBackupsResponse actualResponse = client.listBackups(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupsRequest actualRequest = ((ListBackupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

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
    mockFirestoreAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackupsResponse actualResponse = client.listBackups(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupsRequest actualRequest = ((ListBackupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBackupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockFirestoreAdmin.addResponse(expectedResponse);

    BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]");

    client.deleteBackup(name);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupRequest actualRequest = ((DeleteBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

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
    mockFirestoreAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteBackup(name);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupRequest actualRequest = ((DeleteBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String name = "name3373707";
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
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFirestoreAdmin.addResponse(resultOperation);

    RestoreDatabaseRequest request =
        RestoreDatabaseRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setDatabaseId("databaseId1688905718")
            .setBackup(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
            .setEncryptionConfig(Database.EncryptionConfig.newBuilder().build())
            .build();

    Database actualResponse = client.restoreDatabaseAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreDatabaseRequest actualRequest = ((RestoreDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getDatabaseId(), actualRequest.getDatabaseId());
    Assert.assertEquals(request.getBackup(), actualRequest.getBackup());
    Assert.assertEquals(request.getEncryptionConfig(), actualRequest.getEncryptionConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      RestoreDatabaseRequest request =
          RestoreDatabaseRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setDatabaseId("databaseId1688905718")
              .setBackup(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
              .setEncryptionConfig(Database.EncryptionConfig.newBuilder().build())
              .build();
      client.restoreDatabaseAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockFirestoreAdmin.addResponse(expectedResponse);

    DatabaseName parent = DatabaseName.of("[PROJECT]", "[DATABASE]");
    BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();

    BackupSchedule actualResponse = client.createBackupSchedule(parent, backupSchedule);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupScheduleRequest actualRequest =
        ((CreateBackupScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(backupSchedule, actualRequest.getBackupSchedule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupScheduleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

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
    mockFirestoreAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";
    BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();

    BackupSchedule actualResponse = client.createBackupSchedule(parent, backupSchedule);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupScheduleRequest actualRequest =
        ((CreateBackupScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(backupSchedule, actualRequest.getBackupSchedule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupScheduleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockFirestoreAdmin.addResponse(expectedResponse);

    BackupScheduleName name = BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]");

    BackupSchedule actualResponse = client.getBackupSchedule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupScheduleRequest actualRequest = ((GetBackupScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupScheduleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

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
    mockFirestoreAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    BackupSchedule actualResponse = client.getBackupSchedule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupScheduleRequest actualRequest = ((GetBackupScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupScheduleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String name = "name3373707";
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
    mockFirestoreAdmin.addResponse(expectedResponse);

    DatabaseName parent = DatabaseName.of("[PROJECT]", "[DATABASE]");

    ListBackupSchedulesResponse actualResponse = client.listBackupSchedules(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupSchedulesRequest actualRequest = ((ListBackupSchedulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupSchedulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

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
    mockFirestoreAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackupSchedulesResponse actualResponse = client.listBackupSchedules(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupSchedulesRequest actualRequest = ((ListBackupSchedulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupSchedulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockFirestoreAdmin.addResponse(expectedResponse);

    BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BackupSchedule actualResponse = client.updateBackupSchedule(backupSchedule, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBackupScheduleRequest actualRequest =
        ((UpdateBackupScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(backupSchedule, actualRequest.getBackupSchedule());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBackupScheduleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
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
    mockFirestoreAdmin.addResponse(expectedResponse);

    BackupScheduleName name = BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]");

    client.deleteBackupSchedule(name);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupScheduleRequest actualRequest =
        ((DeleteBackupScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupScheduleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

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
    mockFirestoreAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteBackupSchedule(name);

    List<AbstractMessage> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupScheduleRequest actualRequest =
        ((DeleteBackupScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupScheduleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBackupSchedule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
