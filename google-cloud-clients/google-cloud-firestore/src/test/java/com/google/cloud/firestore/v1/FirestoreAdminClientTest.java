/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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
import com.google.common.collect.Lists;
import com.google.firestore.admin.v1.CreateIndexRequest;
import com.google.firestore.admin.v1.DeleteIndexRequest;
import com.google.firestore.admin.v1.ExportDocumentsRequest;
import com.google.firestore.admin.v1.Field;
import com.google.firestore.admin.v1.GetFieldRequest;
import com.google.firestore.admin.v1.GetIndexRequest;
import com.google.firestore.admin.v1.ImportDocumentsRequest;
import com.google.firestore.admin.v1.Index;
import com.google.firestore.admin.v1.ListFieldsRequest;
import com.google.firestore.admin.v1.ListFieldsResponse;
import com.google.firestore.admin.v1.ListIndexesRequest;
import com.google.firestore.admin.v1.ListIndexesResponse;
import com.google.firestore.admin.v1.UpdateFieldRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class FirestoreAdminClientTest {
  private static MockFirestoreAdmin mockFirestoreAdmin;
  private static MockServiceHelper serviceHelper;
  private FirestoreAdminClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockFirestoreAdmin = new MockFirestoreAdmin();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockFirestoreAdmin));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
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
  @SuppressWarnings("all")
  public void createIndexTest() {
    String name = "name3373707";
    boolean done = true;
    Operation expectedResponse = Operation.newBuilder().setName(name).setDone(done).build();
    mockFirestoreAdmin.addResponse(expectedResponse);

    String formattedParent =
        FirestoreAdminClient.formatParentName("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
    Index index = Index.newBuilder().build();

    Operation actualResponse = client.createIndex(formattedParent, index);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIndexRequest actualRequest = (CreateIndexRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(index, actualRequest.getIndex());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String formattedParent =
          FirestoreAdminClient.formatParentName("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
      Index index = Index.newBuilder().build();

      client.createIndex(formattedParent, index);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listIndexesTest() {
    String nextPageToken = "";
    Index indexesElement = Index.newBuilder().build();
    List<Index> indexes = Arrays.asList(indexesElement);
    ListIndexesResponse expectedResponse =
        ListIndexesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllIndexes(indexes)
            .build();
    mockFirestoreAdmin.addResponse(expectedResponse);

    String formattedParent =
        FirestoreAdminClient.formatParentName("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");

    ListIndexesPagedResponse pagedListResponse = client.listIndexes(formattedParent);

    List<Index> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIndexesRequest actualRequest = (ListIndexesRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listIndexesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String formattedParent =
          FirestoreAdminClient.formatParentName("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");

      client.listIndexes(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIndexTest() {
    String name2 = "name2-1052831874";
    Index expectedResponse = Index.newBuilder().setName(name2).build();
    mockFirestoreAdmin.addResponse(expectedResponse);

    String formattedName =
        FirestoreAdminClient.formatIndexName(
            "[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[INDEX_ID]");

    Index actualResponse = client.getIndex(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIndexRequest actualRequest = (GetIndexRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String formattedName =
          FirestoreAdminClient.formatIndexName(
              "[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[INDEX_ID]");

      client.getIndex(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteIndexTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockFirestoreAdmin.addResponse(expectedResponse);

    String formattedName =
        FirestoreAdminClient.formatIndexName(
            "[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[INDEX_ID]");

    client.deleteIndex(formattedName);

    List<GeneratedMessageV3> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIndexRequest actualRequest = (DeleteIndexRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String formattedName =
          FirestoreAdminClient.formatIndexName(
              "[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[INDEX_ID]");

      client.deleteIndex(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void importDocumentsTest() {
    String name2 = "name2-1052831874";
    boolean done = true;
    Operation expectedResponse = Operation.newBuilder().setName(name2).setDone(done).build();
    mockFirestoreAdmin.addResponse(expectedResponse);

    String formattedName = FirestoreAdminClient.formatDatabaseName("[PROJECT]", "[DATABASE]");

    Operation actualResponse = client.importDocuments(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportDocumentsRequest actualRequest = (ImportDocumentsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void importDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String formattedName = FirestoreAdminClient.formatDatabaseName("[PROJECT]", "[DATABASE]");

      client.importDocuments(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void exportDocumentsTest() {
    String name2 = "name2-1052831874";
    boolean done = true;
    Operation expectedResponse = Operation.newBuilder().setName(name2).setDone(done).build();
    mockFirestoreAdmin.addResponse(expectedResponse);

    String formattedName = FirestoreAdminClient.formatDatabaseName("[PROJECT]", "[DATABASE]");

    Operation actualResponse = client.exportDocuments(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportDocumentsRequest actualRequest = (ExportDocumentsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void exportDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String formattedName = FirestoreAdminClient.formatDatabaseName("[PROJECT]", "[DATABASE]");

      client.exportDocuments(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getFieldTest() {
    String name2 = "name2-1052831874";
    Field expectedResponse = Field.newBuilder().setName(name2).build();
    mockFirestoreAdmin.addResponse(expectedResponse);

    String formattedName =
        FirestoreAdminClient.formatFieldName(
            "[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[FIELD_ID]");

    Field actualResponse = client.getField(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFieldRequest actualRequest = (GetFieldRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getFieldExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String formattedName =
          FirestoreAdminClient.formatFieldName(
              "[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[FIELD_ID]");

      client.getField(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listFieldsTest() {
    String nextPageToken = "";
    Field fieldsElement = Field.newBuilder().build();
    List<Field> fields = Arrays.asList(fieldsElement);
    ListFieldsResponse expectedResponse =
        ListFieldsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllFields(fields)
            .build();
    mockFirestoreAdmin.addResponse(expectedResponse);

    String formattedParent =
        FirestoreAdminClient.formatParentName("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");

    ListFieldsPagedResponse pagedListResponse = client.listFields(formattedParent);

    List<Field> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFieldsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFieldsRequest actualRequest = (ListFieldsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listFieldsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      String formattedParent =
          FirestoreAdminClient.formatParentName("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");

      client.listFields(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateFieldTest() {
    String name = "name3373707";
    boolean done = true;
    Operation expectedResponse = Operation.newBuilder().setName(name).setDone(done).build();
    mockFirestoreAdmin.addResponse(expectedResponse);

    Field field = Field.newBuilder().build();

    Operation actualResponse = client.updateField(field);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockFirestoreAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFieldRequest actualRequest = (UpdateFieldRequest) actualRequests.get(0);

    Assert.assertEquals(field, actualRequest.getField());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateFieldExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFirestoreAdmin.addException(exception);

    try {
      Field field = Field.newBuilder().build();

      client.updateField(field);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
