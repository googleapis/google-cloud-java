/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.datalabeling.v1beta1;

import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListAnnotatedDatasetsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListAnnotationSpecSetsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListDataItemsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListDatasetsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListEvaluationJobsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListExamplesPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListInstructionsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.SearchEvaluationsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.SearchExampleComparisonsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class DataLabelingServiceClientTest {
  private static MockDataLabelingService mockDataLabelingService;
  private static MockServiceHelper serviceHelper;
  private DataLabelingServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDataLabelingService = new MockDataLabelingService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDataLabelingService));
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
    DataLabelingServiceSettings settings =
        DataLabelingServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataLabelingServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createDatasetTest() {
    DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    long dataItemCount = 2014260376L;
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .setDataItemCount(dataItemCount)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Dataset dataset = Dataset.newBuilder().build();

    Dataset actualResponse = client.createDataset(parent, dataset);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDatasetRequest actualRequest = (CreateDatasetRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(dataset, actualRequest.getDataset());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Dataset dataset = Dataset.newBuilder().build();

      client.createDataset(parent, dataset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getDatasetTest() {
    DatasetName name2 = DatasetName.of("[PROJECT]", "[DATASET]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    long dataItemCount = 2014260376L;
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .setDataItemCount(dataItemCount)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");

    Dataset actualResponse = client.getDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatasetRequest actualRequest = (GetDatasetRequest) actualRequests.get(0);

    Assert.assertEquals(name, DatasetName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");

      client.getDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listDatasetsTest() {
    String nextPageToken = "";
    Dataset datasetsElement = Dataset.newBuilder().build();
    List<Dataset> datasets = Arrays.asList(datasetsElement);
    ListDatasetsResponse expectedResponse =
        ListDatasetsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllDatasets(datasets)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String filter = "filter-1274492040";

    ListDatasetsPagedResponse pagedListResponse = client.listDatasets(parent, filter);

    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatasetsRequest actualRequest = (ListDatasetsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listDatasetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";

      client.listDatasets(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDatasetTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");

    client.deleteDataset(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDatasetRequest actualRequest = (DeleteDatasetRequest) actualRequests.get(0);

    Assert.assertEquals(name, DatasetName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");

      client.deleteDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void importDataTest() throws Exception {
    String dataset = "dataset1443214456";
    int totalCount = 407761836;
    int importCount = 1721296907;
    ImportDataOperationResponse expectedResponse =
        ImportDataOperationResponse.newBuilder()
            .setDataset(dataset)
            .setTotalCount(totalCount)
            .setImportCount(importCount)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataLabelingService.addResponse(resultOperation);

    DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
    InputConfig inputConfig = InputConfig.newBuilder().build();

    ImportDataOperationResponse actualResponse = client.importDataAsync(name, inputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportDataRequest actualRequest = (ImportDataRequest) actualRequests.get(0);

    Assert.assertEquals(name, DatasetName.parse(actualRequest.getName()));
    Assert.assertEquals(inputConfig, actualRequest.getInputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void importDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
      InputConfig inputConfig = InputConfig.newBuilder().build();

      client.importDataAsync(name, inputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void exportDataTest() throws Exception {
    String dataset = "dataset1443214456";
    int totalCount = 407761836;
    int exportCount = 529256252;
    ExportDataOperationResponse expectedResponse =
        ExportDataOperationResponse.newBuilder()
            .setDataset(dataset)
            .setTotalCount(totalCount)
            .setExportCount(exportCount)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataLabelingService.addResponse(resultOperation);

    DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
    AnnotatedDatasetName annotatedDataset =
        AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
    String filter = "filter-1274492040";
    OutputConfig outputConfig = OutputConfig.newBuilder().build();

    ExportDataOperationResponse actualResponse =
        client.exportDataAsync(name, annotatedDataset, filter, outputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportDataRequest actualRequest = (ExportDataRequest) actualRequests.get(0);

    Assert.assertEquals(name, DatasetName.parse(actualRequest.getName()));
    Assert.assertEquals(
        annotatedDataset, AnnotatedDatasetName.parse(actualRequest.getAnnotatedDataset()));
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertEquals(outputConfig, actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void exportDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
      AnnotatedDatasetName annotatedDataset =
          AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
      String filter = "filter-1274492040";
      OutputConfig outputConfig = OutputConfig.newBuilder().build();

      client.exportDataAsync(name, annotatedDataset, filter, outputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getDataItemTest() {
    DataItemName name2 = DataItemName.of("[PROJECT]", "[DATASET]", "[DATA_ITEM]");
    DataItem expectedResponse = DataItem.newBuilder().setName(name2.toString()).build();
    mockDataLabelingService.addResponse(expectedResponse);

    DataItemName name = DataItemName.of("[PROJECT]", "[DATASET]", "[DATA_ITEM]");

    DataItem actualResponse = client.getDataItem(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataItemRequest actualRequest = (GetDataItemRequest) actualRequests.get(0);

    Assert.assertEquals(name, DataItemName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getDataItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DataItemName name = DataItemName.of("[PROJECT]", "[DATASET]", "[DATA_ITEM]");

      client.getDataItem(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listDataItemsTest() {
    String nextPageToken = "";
    DataItem dataItemsElement = DataItem.newBuilder().build();
    List<DataItem> dataItems = Arrays.asList(dataItemsElement);
    ListDataItemsResponse expectedResponse =
        ListDataItemsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllDataItems(dataItems)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    DatasetName parent = DatasetName.of("[PROJECT]", "[DATASET]");
    String filter = "filter-1274492040";

    ListDataItemsPagedResponse pagedListResponse = client.listDataItems(parent, filter);

    List<DataItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataItemsRequest actualRequest = (ListDataItemsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, DatasetName.parse(actualRequest.getParent()));
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listDataItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName parent = DatasetName.of("[PROJECT]", "[DATASET]");
      String filter = "filter-1274492040";

      client.listDataItems(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getAnnotatedDatasetTest() {
    AnnotatedDatasetName name2 =
        AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    long exampleCount = 1517063674L;
    long completedExampleCount = 612567290L;
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .setExampleCount(exampleCount)
            .setCompletedExampleCount(completedExampleCount)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    AnnotatedDatasetName name =
        AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");

    AnnotatedDataset actualResponse = client.getAnnotatedDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnnotatedDatasetRequest actualRequest = (GetAnnotatedDatasetRequest) actualRequests.get(0);

    Assert.assertEquals(name, AnnotatedDatasetName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getAnnotatedDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      AnnotatedDatasetName name =
          AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");

      client.getAnnotatedDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listAnnotatedDatasetsTest() {
    String nextPageToken = "";
    AnnotatedDataset annotatedDatasetsElement = AnnotatedDataset.newBuilder().build();
    List<AnnotatedDataset> annotatedDatasets = Arrays.asList(annotatedDatasetsElement);
    ListAnnotatedDatasetsResponse expectedResponse =
        ListAnnotatedDatasetsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllAnnotatedDatasets(annotatedDatasets)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    DatasetName parent = DatasetName.of("[PROJECT]", "[DATASET]");
    String filter = "filter-1274492040";

    ListAnnotatedDatasetsPagedResponse pagedListResponse =
        client.listAnnotatedDatasets(parent, filter);

    List<AnnotatedDataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnnotatedDatasetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnnotatedDatasetsRequest actualRequest =
        (ListAnnotatedDatasetsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, DatasetName.parse(actualRequest.getParent()));
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listAnnotatedDatasetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName parent = DatasetName.of("[PROJECT]", "[DATASET]");
      String filter = "filter-1274492040";

      client.listAnnotatedDatasets(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAnnotatedDatasetTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    AnnotatedDatasetName name =
        AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
    DeleteAnnotatedDatasetRequest request =
        DeleteAnnotatedDatasetRequest.newBuilder().setName(name.toString()).build();

    client.deleteAnnotatedDataset(request);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnnotatedDatasetRequest actualRequest =
        (DeleteAnnotatedDatasetRequest) actualRequests.get(0);

    Assert.assertEquals(name, AnnotatedDatasetName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAnnotatedDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      AnnotatedDatasetName name =
          AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
      DeleteAnnotatedDatasetRequest request =
          DeleteAnnotatedDatasetRequest.newBuilder().setName(name.toString()).build();

      client.deleteAnnotatedDataset(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void labelImageTest() throws Exception {
    AnnotatedDatasetName name =
        AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    long exampleCount = 1517063674L;
    long completedExampleCount = 612567290L;
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .setExampleCount(exampleCount)
            .setCompletedExampleCount(completedExampleCount)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("labelImageTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataLabelingService.addResponse(resultOperation);

    DatasetName parent = DatasetName.of("[PROJECT]", "[DATASET]");
    HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
    LabelImageRequest.Feature feature = LabelImageRequest.Feature.FEATURE_UNSPECIFIED;

    AnnotatedDataset actualResponse = client.labelImageAsync(parent, basicConfig, feature).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LabelImageRequest actualRequest = (LabelImageRequest) actualRequests.get(0);

    Assert.assertEquals(parent, DatasetName.parse(actualRequest.getParent()));
    Assert.assertEquals(basicConfig, actualRequest.getBasicConfig());
    Assert.assertEquals(feature, actualRequest.getFeature());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void labelImageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName parent = DatasetName.of("[PROJECT]", "[DATASET]");
      HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
      LabelImageRequest.Feature feature = LabelImageRequest.Feature.FEATURE_UNSPECIFIED;

      client.labelImageAsync(parent, basicConfig, feature).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void labelVideoTest() throws Exception {
    AnnotatedDatasetName name =
        AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    long exampleCount = 1517063674L;
    long completedExampleCount = 612567290L;
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .setExampleCount(exampleCount)
            .setCompletedExampleCount(completedExampleCount)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("labelVideoTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataLabelingService.addResponse(resultOperation);

    DatasetName parent = DatasetName.of("[PROJECT]", "[DATASET]");
    HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
    LabelVideoRequest.Feature feature = LabelVideoRequest.Feature.FEATURE_UNSPECIFIED;

    AnnotatedDataset actualResponse = client.labelVideoAsync(parent, basicConfig, feature).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LabelVideoRequest actualRequest = (LabelVideoRequest) actualRequests.get(0);

    Assert.assertEquals(parent, DatasetName.parse(actualRequest.getParent()));
    Assert.assertEquals(basicConfig, actualRequest.getBasicConfig());
    Assert.assertEquals(feature, actualRequest.getFeature());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void labelVideoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName parent = DatasetName.of("[PROJECT]", "[DATASET]");
      HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
      LabelVideoRequest.Feature feature = LabelVideoRequest.Feature.FEATURE_UNSPECIFIED;

      client.labelVideoAsync(parent, basicConfig, feature).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void labelTextTest() throws Exception {
    AnnotatedDatasetName name =
        AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    long exampleCount = 1517063674L;
    long completedExampleCount = 612567290L;
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .setExampleCount(exampleCount)
            .setCompletedExampleCount(completedExampleCount)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("labelTextTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataLabelingService.addResponse(resultOperation);

    DatasetName parent = DatasetName.of("[PROJECT]", "[DATASET]");
    HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
    LabelTextRequest.Feature feature = LabelTextRequest.Feature.FEATURE_UNSPECIFIED;

    AnnotatedDataset actualResponse = client.labelTextAsync(parent, basicConfig, feature).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LabelTextRequest actualRequest = (LabelTextRequest) actualRequests.get(0);

    Assert.assertEquals(parent, DatasetName.parse(actualRequest.getParent()));
    Assert.assertEquals(basicConfig, actualRequest.getBasicConfig());
    Assert.assertEquals(feature, actualRequest.getFeature());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void labelTextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName parent = DatasetName.of("[PROJECT]", "[DATASET]");
      HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
      LabelTextRequest.Feature feature = LabelTextRequest.Feature.FEATURE_UNSPECIFIED;

      client.labelTextAsync(parent, basicConfig, feature).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getExampleTest() {
    ExampleName name2 =
        ExampleName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]", "[EXAMPLE]");
    Example expectedResponse = Example.newBuilder().setName(name2.toString()).build();
    mockDataLabelingService.addResponse(expectedResponse);

    ExampleName name = ExampleName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]", "[EXAMPLE]");
    String filter = "filter-1274492040";

    Example actualResponse = client.getExample(name, filter);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExampleRequest actualRequest = (GetExampleRequest) actualRequests.get(0);

    Assert.assertEquals(name, ExampleName.parse(actualRequest.getName()));
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getExampleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ExampleName name =
          ExampleName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]", "[EXAMPLE]");
      String filter = "filter-1274492040";

      client.getExample(name, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listExamplesTest() {
    String nextPageToken = "";
    Example examplesElement = Example.newBuilder().build();
    List<Example> examples = Arrays.asList(examplesElement);
    ListExamplesResponse expectedResponse =
        ListExamplesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllExamples(examples)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    AnnotatedDatasetName parent =
        AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
    String filter = "filter-1274492040";

    ListExamplesPagedResponse pagedListResponse = client.listExamples(parent, filter);

    List<Example> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExamplesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExamplesRequest actualRequest = (ListExamplesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, AnnotatedDatasetName.parse(actualRequest.getParent()));
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listExamplesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      AnnotatedDatasetName parent =
          AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
      String filter = "filter-1274492040";

      client.listExamples(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createAnnotationSpecSetTest() {
    AnnotationSpecSetName name = AnnotationSpecSetName.of("[PROJECT]", "[ANNOTATION_SPEC_SET]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    AnnotationSpecSet expectedResponse =
        AnnotationSpecSet.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    AnnotationSpecSet annotationSpecSet = AnnotationSpecSet.newBuilder().build();

    AnnotationSpecSet actualResponse = client.createAnnotationSpecSet(parent, annotationSpecSet);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnnotationSpecSetRequest actualRequest =
        (CreateAnnotationSpecSetRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(annotationSpecSet, actualRequest.getAnnotationSpecSet());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createAnnotationSpecSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      AnnotationSpecSet annotationSpecSet = AnnotationSpecSet.newBuilder().build();

      client.createAnnotationSpecSet(parent, annotationSpecSet);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getAnnotationSpecSetTest() {
    AnnotationSpecSetName name2 = AnnotationSpecSetName.of("[PROJECT]", "[ANNOTATION_SPEC_SET]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    AnnotationSpecSet expectedResponse =
        AnnotationSpecSet.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    AnnotationSpecSetName name = AnnotationSpecSetName.of("[PROJECT]", "[ANNOTATION_SPEC_SET]");

    AnnotationSpecSet actualResponse = client.getAnnotationSpecSet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnnotationSpecSetRequest actualRequest = (GetAnnotationSpecSetRequest) actualRequests.get(0);

    Assert.assertEquals(name, AnnotationSpecSetName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getAnnotationSpecSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      AnnotationSpecSetName name = AnnotationSpecSetName.of("[PROJECT]", "[ANNOTATION_SPEC_SET]");

      client.getAnnotationSpecSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listAnnotationSpecSetsTest() {
    String nextPageToken = "";
    AnnotationSpecSet annotationSpecSetsElement = AnnotationSpecSet.newBuilder().build();
    List<AnnotationSpecSet> annotationSpecSets = Arrays.asList(annotationSpecSetsElement);
    ListAnnotationSpecSetsResponse expectedResponse =
        ListAnnotationSpecSetsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllAnnotationSpecSets(annotationSpecSets)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String filter = "filter-1274492040";

    ListAnnotationSpecSetsPagedResponse pagedListResponse =
        client.listAnnotationSpecSets(parent, filter);

    List<AnnotationSpecSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnnotationSpecSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnnotationSpecSetsRequest actualRequest =
        (ListAnnotationSpecSetsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listAnnotationSpecSetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";

      client.listAnnotationSpecSets(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAnnotationSpecSetTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    AnnotationSpecSetName name = AnnotationSpecSetName.of("[PROJECT]", "[ANNOTATION_SPEC_SET]");

    client.deleteAnnotationSpecSet(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnnotationSpecSetRequest actualRequest =
        (DeleteAnnotationSpecSetRequest) actualRequests.get(0);

    Assert.assertEquals(name, AnnotationSpecSetName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAnnotationSpecSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      AnnotationSpecSetName name = AnnotationSpecSetName.of("[PROJECT]", "[ANNOTATION_SPEC_SET]");

      client.deleteAnnotationSpecSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createInstructionTest() throws Exception {
    InstructionName name = InstructionName.of("[PROJECT]", "[INSTRUCTION]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    Instruction expectedResponse =
        Instruction.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstructionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataLabelingService.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Instruction instruction = Instruction.newBuilder().build();

    Instruction actualResponse = client.createInstructionAsync(parent, instruction).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstructionRequest actualRequest = (CreateInstructionRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(instruction, actualRequest.getInstruction());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createInstructionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Instruction instruction = Instruction.newBuilder().build();

      client.createInstructionAsync(parent, instruction).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getInstructionTest() {
    InstructionName name2 = InstructionName.of("[PROJECT]", "[INSTRUCTION]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    Instruction expectedResponse =
        Instruction.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    InstructionName name = InstructionName.of("[PROJECT]", "[INSTRUCTION]");

    Instruction actualResponse = client.getInstruction(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstructionRequest actualRequest = (GetInstructionRequest) actualRequests.get(0);

    Assert.assertEquals(name, InstructionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getInstructionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      InstructionName name = InstructionName.of("[PROJECT]", "[INSTRUCTION]");

      client.getInstruction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listInstructionsTest() {
    String nextPageToken = "";
    Instruction instructionsElement = Instruction.newBuilder().build();
    List<Instruction> instructions = Arrays.asList(instructionsElement);
    ListInstructionsResponse expectedResponse =
        ListInstructionsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllInstructions(instructions)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String filter = "filter-1274492040";

    ListInstructionsPagedResponse pagedListResponse = client.listInstructions(parent, filter);

    List<Instruction> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstructionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstructionsRequest actualRequest = (ListInstructionsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listInstructionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";

      client.listInstructions(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteInstructionTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    InstructionName name = InstructionName.of("[PROJECT]", "[INSTRUCTION]");

    client.deleteInstruction(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstructionRequest actualRequest = (DeleteInstructionRequest) actualRequests.get(0);

    Assert.assertEquals(name, InstructionName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteInstructionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      InstructionName name = InstructionName.of("[PROJECT]", "[INSTRUCTION]");

      client.deleteInstruction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getEvaluationTest() {
    EvaluationName name2 = EvaluationName.of("[PROJECT]", "[DATASET]", "[EVALUATION]");
    long evaluatedItemCount = 358077111L;
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(name2.toString())
            .setEvaluatedItemCount(evaluatedItemCount)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    EvaluationName name = EvaluationName.of("[PROJECT]", "[DATASET]", "[EVALUATION]");

    Evaluation actualResponse = client.getEvaluation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationRequest actualRequest = (GetEvaluationRequest) actualRequests.get(0);

    Assert.assertEquals(name, EvaluationName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationName name = EvaluationName.of("[PROJECT]", "[DATASET]", "[EVALUATION]");

      client.getEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void searchEvaluationsTest() {
    String nextPageToken = "";
    Evaluation evaluationsElement = Evaluation.newBuilder().build();
    List<Evaluation> evaluations = Arrays.asList(evaluationsElement);
    SearchEvaluationsResponse expectedResponse =
        SearchEvaluationsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllEvaluations(evaluations)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    EvaluationName parent = EvaluationName.of("[PROJECT]", "[DATASET]", "[EVALUATION]");
    String filter = "filter-1274492040";

    SearchEvaluationsPagedResponse pagedListResponse = client.searchEvaluations(parent, filter);

    List<Evaluation> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchEvaluationsRequest actualRequest = (SearchEvaluationsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, EvaluationName.parse(actualRequest.getParent()));
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void searchEvaluationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationName parent = EvaluationName.of("[PROJECT]", "[DATASET]", "[EVALUATION]");
      String filter = "filter-1274492040";

      client.searchEvaluations(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void searchExampleComparisonsTest() {
    String nextPageToken = "";
    SearchExampleComparisonsResponse.ExampleComparison exampleComparisonsElement =
        SearchExampleComparisonsResponse.ExampleComparison.newBuilder().build();
    List<SearchExampleComparisonsResponse.ExampleComparison> exampleComparisons =
        Arrays.asList(exampleComparisonsElement);
    SearchExampleComparisonsResponse expectedResponse =
        SearchExampleComparisonsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllExampleComparisons(exampleComparisons)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    EvaluationName parent = EvaluationName.of("[PROJECT]", "[DATASET]", "[EVALUATION]");

    SearchExampleComparisonsPagedResponse pagedListResponse =
        client.searchExampleComparisons(parent);

    List<SearchExampleComparisonsResponse.ExampleComparison> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExampleComparisonsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchExampleComparisonsRequest actualRequest =
        (SearchExampleComparisonsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, EvaluationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void searchExampleComparisonsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationName parent = EvaluationName.of("[PROJECT]", "[DATASET]", "[EVALUATION]");

      client.searchExampleComparisons(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createEvaluationJobTest() {
    EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");
    String description = "description-1724546052";
    String schedule = "schedule-697920873";
    String modelVersion = "modelVersion-1669102142";
    String annotationSpecSet = "annotationSpecSet1881405678";
    boolean labelMissingGroundTruth = false;
    EvaluationJob expectedResponse =
        EvaluationJob.newBuilder()
            .setName(name.toString())
            .setDescription(description)
            .setSchedule(schedule)
            .setModelVersion(modelVersion)
            .setAnnotationSpecSet(annotationSpecSet)
            .setLabelMissingGroundTruth(labelMissingGroundTruth)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    EvaluationJob job = EvaluationJob.newBuilder().build();

    EvaluationJob actualResponse = client.createEvaluationJob(parent, job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationJobRequest actualRequest = (CreateEvaluationJobRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createEvaluationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      EvaluationJob job = EvaluationJob.newBuilder().build();

      client.createEvaluationJob(parent, job);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateEvaluationJobTest() {
    EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");
    String description = "description-1724546052";
    String schedule = "schedule-697920873";
    String modelVersion = "modelVersion-1669102142";
    String annotationSpecSet = "annotationSpecSet1881405678";
    boolean labelMissingGroundTruth = false;
    EvaluationJob expectedResponse =
        EvaluationJob.newBuilder()
            .setName(name.toString())
            .setDescription(description)
            .setSchedule(schedule)
            .setModelVersion(modelVersion)
            .setAnnotationSpecSet(annotationSpecSet)
            .setLabelMissingGroundTruth(labelMissingGroundTruth)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    EvaluationJob evaluationJob = EvaluationJob.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EvaluationJob actualResponse = client.updateEvaluationJob(evaluationJob, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEvaluationJobRequest actualRequest = (UpdateEvaluationJobRequest) actualRequests.get(0);

    Assert.assertEquals(evaluationJob, actualRequest.getEvaluationJob());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateEvaluationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationJob evaluationJob = EvaluationJob.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateEvaluationJob(evaluationJob, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getEvaluationJobTest() {
    EvaluationJobName name2 = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");
    String description = "description-1724546052";
    String schedule = "schedule-697920873";
    String modelVersion = "modelVersion-1669102142";
    String annotationSpecSet = "annotationSpecSet1881405678";
    boolean labelMissingGroundTruth = false;
    EvaluationJob expectedResponse =
        EvaluationJob.newBuilder()
            .setName(name2.toString())
            .setDescription(description)
            .setSchedule(schedule)
            .setModelVersion(modelVersion)
            .setAnnotationSpecSet(annotationSpecSet)
            .setLabelMissingGroundTruth(labelMissingGroundTruth)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");

    EvaluationJob actualResponse = client.getEvaluationJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationJobRequest actualRequest = (GetEvaluationJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, EvaluationJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getEvaluationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");

      client.getEvaluationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void pauseEvaluationJobTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");

    client.pauseEvaluationJob(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PauseEvaluationJobRequest actualRequest = (PauseEvaluationJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, EvaluationJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void pauseEvaluationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");

      client.pauseEvaluationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void resumeEvaluationJobTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");

    client.resumeEvaluationJob(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeEvaluationJobRequest actualRequest = (ResumeEvaluationJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, EvaluationJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void resumeEvaluationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");

      client.resumeEvaluationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteEvaluationJobTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");

    client.deleteEvaluationJob(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEvaluationJobRequest actualRequest = (DeleteEvaluationJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, EvaluationJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteEvaluationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");

      client.deleteEvaluationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listEvaluationJobsTest() {
    String nextPageToken = "";
    EvaluationJob evaluationJobsElement = EvaluationJob.newBuilder().build();
    List<EvaluationJob> evaluationJobs = Arrays.asList(evaluationJobsElement);
    ListEvaluationJobsResponse expectedResponse =
        ListEvaluationJobsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllEvaluationJobs(evaluationJobs)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String filter = "filter-1274492040";

    ListEvaluationJobsPagedResponse pagedListResponse = client.listEvaluationJobs(parent, filter);

    List<EvaluationJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEvaluationJobsRequest actualRequest = (ListEvaluationJobsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listEvaluationJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";

      client.listEvaluationJobs(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
