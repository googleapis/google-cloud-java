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

package com.google.cloud.documentai.v1beta3;

import static com.google.cloud.documentai.v1beta3.DocumentServiceClient.ListDocumentsPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
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
public class DocumentServiceClientTest {
  private static MockDocumentService mockDocumentService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DocumentServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDocumentService = new MockDocumentService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDocumentService, mockLocations));
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
    DocumentServiceSettings settings =
        DocumentServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DocumentServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void updateDatasetTest() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDatasetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentService.addResponse(resultOperation);

    Dataset dataset = Dataset.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Dataset actualResponse = client.updateDatasetAsync(dataset, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDatasetRequest actualRequest = ((UpdateDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(dataset, actualRequest.getDataset());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      Dataset dataset = Dataset.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDatasetAsync(dataset, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importDocumentsTest() throws Exception {
    ImportDocumentsResponse expectedResponse = ImportDocumentsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentService.addResponse(resultOperation);

    DatasetName dataset = DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

    ImportDocumentsResponse actualResponse = client.importDocumentsAsync(dataset).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportDocumentsRequest actualRequest = ((ImportDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(dataset.toString(), actualRequest.getDataset());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      DatasetName dataset = DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
      client.importDocumentsAsync(dataset).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importDocumentsTest2() throws Exception {
    ImportDocumentsResponse expectedResponse = ImportDocumentsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentService.addResponse(resultOperation);

    String dataset = "dataset1443214456";

    ImportDocumentsResponse actualResponse = client.importDocumentsAsync(dataset).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportDocumentsRequest actualRequest = ((ImportDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(dataset, actualRequest.getDataset());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importDocumentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      String dataset = "dataset1443214456";
      client.importDocumentsAsync(dataset).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getDocumentTest() throws Exception {
    GetDocumentResponse expectedResponse =
        GetDocumentResponse.newBuilder().setDocument(Document.newBuilder().build()).build();
    mockDocumentService.addResponse(expectedResponse);

    DatasetName dataset = DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

    GetDocumentResponse actualResponse = client.getDocument(dataset);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDocumentRequest actualRequest = ((GetDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(dataset.toString(), actualRequest.getDataset());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      DatasetName dataset = DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
      client.getDocument(dataset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDocumentTest2() throws Exception {
    GetDocumentResponse expectedResponse =
        GetDocumentResponse.newBuilder().setDocument(Document.newBuilder().build()).build();
    mockDocumentService.addResponse(expectedResponse);

    String dataset = "dataset1443214456";

    GetDocumentResponse actualResponse = client.getDocument(dataset);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDocumentRequest actualRequest = ((GetDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(dataset, actualRequest.getDataset());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDocumentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      String dataset = "dataset1443214456";
      client.getDocument(dataset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDocumentsTest() throws Exception {
    DocumentMetadata responsesElement = DocumentMetadata.newBuilder().build();
    ListDocumentsResponse expectedResponse =
        ListDocumentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDocumentMetadata(Arrays.asList(responsesElement))
            .build();
    mockDocumentService.addResponse(expectedResponse);

    DatasetName dataset = DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

    ListDocumentsPagedResponse pagedListResponse = client.listDocuments(dataset);

    List<DocumentMetadata> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDocumentMetadataList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDocumentsRequest actualRequest = ((ListDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(dataset.toString(), actualRequest.getDataset());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      DatasetName dataset = DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
      client.listDocuments(dataset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDocumentsTest2() throws Exception {
    DocumentMetadata responsesElement = DocumentMetadata.newBuilder().build();
    ListDocumentsResponse expectedResponse =
        ListDocumentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDocumentMetadata(Arrays.asList(responsesElement))
            .build();
    mockDocumentService.addResponse(expectedResponse);

    String dataset = "dataset1443214456";

    ListDocumentsPagedResponse pagedListResponse = client.listDocuments(dataset);

    List<DocumentMetadata> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDocumentMetadataList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDocumentsRequest actualRequest = ((ListDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(dataset, actualRequest.getDataset());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDocumentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      String dataset = "dataset1443214456";
      client.listDocuments(dataset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteDocumentsTest() throws Exception {
    BatchDeleteDocumentsResponse expectedResponse =
        BatchDeleteDocumentsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchDeleteDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentService.addResponse(resultOperation);

    String dataset = "dataset1443214456";

    BatchDeleteDocumentsResponse actualResponse = client.batchDeleteDocumentsAsync(dataset).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteDocumentsRequest actualRequest =
        ((BatchDeleteDocumentsRequest) actualRequests.get(0));

    Assert.assertEquals(dataset, actualRequest.getDataset());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      String dataset = "dataset1443214456";
      client.batchDeleteDocumentsAsync(dataset).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getDatasetSchemaTest() throws Exception {
    DatasetSchema expectedResponse =
        DatasetSchema.newBuilder()
            .setName(DatasetSchemaName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .setDocumentSchema(DocumentSchema.newBuilder().build())
            .build();
    mockDocumentService.addResponse(expectedResponse);

    DatasetSchemaName name = DatasetSchemaName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

    DatasetSchema actualResponse = client.getDatasetSchema(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatasetSchemaRequest actualRequest = ((GetDatasetSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatasetSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      DatasetSchemaName name = DatasetSchemaName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
      client.getDatasetSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatasetSchemaTest2() throws Exception {
    DatasetSchema expectedResponse =
        DatasetSchema.newBuilder()
            .setName(DatasetSchemaName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .setDocumentSchema(DocumentSchema.newBuilder().build())
            .build();
    mockDocumentService.addResponse(expectedResponse);

    String name = "name3373707";

    DatasetSchema actualResponse = client.getDatasetSchema(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatasetSchemaRequest actualRequest = ((GetDatasetSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatasetSchemaExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      String name = "name3373707";
      client.getDatasetSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDatasetSchemaTest() throws Exception {
    DatasetSchema expectedResponse =
        DatasetSchema.newBuilder()
            .setName(DatasetSchemaName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .setDocumentSchema(DocumentSchema.newBuilder().build())
            .build();
    mockDocumentService.addResponse(expectedResponse);

    DatasetSchema datasetSchema = DatasetSchema.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DatasetSchema actualResponse = client.updateDatasetSchema(datasetSchema, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDatasetSchemaRequest actualRequest = ((UpdateDatasetSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(datasetSchema, actualRequest.getDatasetSchema());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDatasetSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentService.addException(exception);

    try {
      DatasetSchema datasetSchema = DatasetSchema.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDatasetSchema(datasetSchema, updateMask);
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
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
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
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
