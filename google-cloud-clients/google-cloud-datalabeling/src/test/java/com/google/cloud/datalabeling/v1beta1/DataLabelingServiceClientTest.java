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
            "in-process-1", Arrays.<MockGrpcService>asList(mockDataLabelingService));
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
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    long dataItemCount = 2014260376L;
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .setDataItemCount(dataItemCount)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
    Dataset dataset = Dataset.newBuilder().build();

    Dataset actualResponse = client.createDataset(formattedParent, dataset);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDatasetRequest actualRequest = (CreateDatasetRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
      Dataset dataset = Dataset.newBuilder().build();

      client.createDataset(formattedParent, dataset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getDatasetTest() {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    long dataItemCount = 2014260376L;
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(name2)
            .setDisplayName(displayName)
            .setDescription(description)
            .setDataItemCount(dataItemCount)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String formattedName = DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");

    Dataset actualResponse = client.getDataset(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatasetRequest actualRequest = (GetDatasetRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName = DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");

      client.getDataset(formattedName);
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

    String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
    String filter = "filter-1274492040";

    ListDatasetsPagedResponse pagedListResponse = client.listDatasets(formattedParent, filter);

    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatasetsRequest actualRequest = (ListDatasetsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
      String filter = "filter-1274492040";

      client.listDatasets(formattedParent, filter);
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

    String formattedName = DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");

    client.deleteDataset(formattedName);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDatasetRequest actualRequest = (DeleteDatasetRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName = DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");

      client.deleteDataset(formattedName);
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

    String formattedName = DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");
    InputConfig inputConfig = InputConfig.newBuilder().build();

    ImportDataOperationResponse actualResponse =
        client.importDataAsync(formattedName, inputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportDataRequest actualRequest = (ImportDataRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName = DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");
      InputConfig inputConfig = InputConfig.newBuilder().build();

      client.importDataAsync(formattedName, inputConfig).get();
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

    String formattedName = DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");
    String annotatedDataset = "annotatedDataset-1407812655";
    String filter = "filter-1274492040";
    OutputConfig outputConfig = OutputConfig.newBuilder().build();

    ExportDataOperationResponse actualResponse =
        client.exportDataAsync(formattedName, annotatedDataset, filter, outputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportDataRequest actualRequest = (ExportDataRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(annotatedDataset, actualRequest.getAnnotatedDataset());
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
      String formattedName = DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");
      String annotatedDataset = "annotatedDataset-1407812655";
      String filter = "filter-1274492040";
      OutputConfig outputConfig = OutputConfig.newBuilder().build();

      client.exportDataAsync(formattedName, annotatedDataset, filter, outputConfig).get();
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
    String name2 = "name2-1052831874";
    DataItem expectedResponse = DataItem.newBuilder().setName(name2).build();
    mockDataLabelingService.addResponse(expectedResponse);

    String formattedName =
        DataLabelingServiceClient.formatDataItemName("[PROJECT]", "[DATASET]", "[DATA_ITEM]");

    DataItem actualResponse = client.getDataItem(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataItemRequest actualRequest = (GetDataItemRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName =
          DataLabelingServiceClient.formatDataItemName("[PROJECT]", "[DATASET]", "[DATA_ITEM]");

      client.getDataItem(formattedName);
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

    String formattedParent = DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");
    String filter = "filter-1274492040";

    ListDataItemsPagedResponse pagedListResponse = client.listDataItems(formattedParent, filter);

    List<DataItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataItemsRequest actualRequest = (ListDataItemsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent =
          DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");
      String filter = "filter-1274492040";

      client.listDataItems(formattedParent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getAnnotatedDatasetTest() {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    long exampleCount = 1517063674L;
    long completedExampleCount = 612567290L;
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(name2)
            .setDisplayName(displayName)
            .setDescription(description)
            .setExampleCount(exampleCount)
            .setCompletedExampleCount(completedExampleCount)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String formattedName =
        DataLabelingServiceClient.formatAnnotatedDatasetName(
            "[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");

    AnnotatedDataset actualResponse = client.getAnnotatedDataset(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnnotatedDatasetRequest actualRequest = (GetAnnotatedDatasetRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName =
          DataLabelingServiceClient.formatAnnotatedDatasetName(
              "[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");

      client.getAnnotatedDataset(formattedName);
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

    String formattedParent = DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");
    String filter = "filter-1274492040";

    ListAnnotatedDatasetsPagedResponse pagedListResponse =
        client.listAnnotatedDatasets(formattedParent, filter);

    List<AnnotatedDataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnnotatedDatasetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnnotatedDatasetsRequest actualRequest =
        (ListAnnotatedDatasetsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent =
          DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");
      String filter = "filter-1274492040";

      client.listAnnotatedDatasets(formattedParent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void labelImageTest() throws Exception {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    long exampleCount = 1517063674L;
    long completedExampleCount = 612567290L;
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(name)
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

    String formattedParent = DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");
    HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
    LabelImageRequest.Feature feature = LabelImageRequest.Feature.FEATURE_UNSPECIFIED;

    AnnotatedDataset actualResponse =
        client.labelImageAsync(formattedParent, basicConfig, feature).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LabelImageRequest actualRequest = (LabelImageRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent =
          DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");
      HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
      LabelImageRequest.Feature feature = LabelImageRequest.Feature.FEATURE_UNSPECIFIED;

      client.labelImageAsync(formattedParent, basicConfig, feature).get();
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
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    long exampleCount = 1517063674L;
    long completedExampleCount = 612567290L;
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(name)
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

    String formattedParent = DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");
    HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
    LabelVideoRequest.Feature feature = LabelVideoRequest.Feature.FEATURE_UNSPECIFIED;

    AnnotatedDataset actualResponse =
        client.labelVideoAsync(formattedParent, basicConfig, feature).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LabelVideoRequest actualRequest = (LabelVideoRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent =
          DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");
      HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
      LabelVideoRequest.Feature feature = LabelVideoRequest.Feature.FEATURE_UNSPECIFIED;

      client.labelVideoAsync(formattedParent, basicConfig, feature).get();
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
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    long exampleCount = 1517063674L;
    long completedExampleCount = 612567290L;
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(name)
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

    String formattedParent = DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");
    HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
    LabelTextRequest.Feature feature = LabelTextRequest.Feature.FEATURE_UNSPECIFIED;

    AnnotatedDataset actualResponse =
        client.labelTextAsync(formattedParent, basicConfig, feature).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LabelTextRequest actualRequest = (LabelTextRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent =
          DataLabelingServiceClient.formatDatasetName("[PROJECT]", "[DATASET]");
      HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
      LabelTextRequest.Feature feature = LabelTextRequest.Feature.FEATURE_UNSPECIFIED;

      client.labelTextAsync(formattedParent, basicConfig, feature).get();
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
    String name2 = "name2-1052831874";
    Example expectedResponse = Example.newBuilder().setName(name2).build();
    mockDataLabelingService.addResponse(expectedResponse);

    String formattedName =
        DataLabelingServiceClient.formatExampleName(
            "[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]", "[EXAMPLE]");
    String filter = "filter-1274492040";

    Example actualResponse = client.getExample(formattedName, filter);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExampleRequest actualRequest = (GetExampleRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName =
          DataLabelingServiceClient.formatExampleName(
              "[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]", "[EXAMPLE]");
      String filter = "filter-1274492040";

      client.getExample(formattedName, filter);
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

    String formattedParent =
        DataLabelingServiceClient.formatAnnotatedDatasetName(
            "[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
    String filter = "filter-1274492040";

    ListExamplesPagedResponse pagedListResponse = client.listExamples(formattedParent, filter);

    List<Example> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExamplesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExamplesRequest actualRequest = (ListExamplesRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent =
          DataLabelingServiceClient.formatAnnotatedDatasetName(
              "[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
      String filter = "filter-1274492040";

      client.listExamples(formattedParent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createAnnotationSpecSetTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    AnnotationSpecSet expectedResponse =
        AnnotationSpecSet.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
    AnnotationSpecSet annotationSpecSet = AnnotationSpecSet.newBuilder().build();

    AnnotationSpecSet actualResponse =
        client.createAnnotationSpecSet(formattedParent, annotationSpecSet);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnnotationSpecSetRequest actualRequest =
        (CreateAnnotationSpecSetRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
      AnnotationSpecSet annotationSpecSet = AnnotationSpecSet.newBuilder().build();

      client.createAnnotationSpecSet(formattedParent, annotationSpecSet);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getAnnotationSpecSetTest() {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    AnnotationSpecSet expectedResponse =
        AnnotationSpecSet.newBuilder()
            .setName(name2)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String formattedName =
        DataLabelingServiceClient.formatAnnotationSpecSetName("[PROJECT]", "[ANNOTATION_SPEC_SET]");

    AnnotationSpecSet actualResponse = client.getAnnotationSpecSet(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnnotationSpecSetRequest actualRequest = (GetAnnotationSpecSetRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName =
          DataLabelingServiceClient.formatAnnotationSpecSetName(
              "[PROJECT]", "[ANNOTATION_SPEC_SET]");

      client.getAnnotationSpecSet(formattedName);
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

    String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
    String filter = "filter-1274492040";

    ListAnnotationSpecSetsPagedResponse pagedListResponse =
        client.listAnnotationSpecSets(formattedParent, filter);

    List<AnnotationSpecSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnnotationSpecSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnnotationSpecSetsRequest actualRequest =
        (ListAnnotationSpecSetsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
      String filter = "filter-1274492040";

      client.listAnnotationSpecSets(formattedParent, filter);
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

    String formattedName =
        DataLabelingServiceClient.formatAnnotationSpecSetName("[PROJECT]", "[ANNOTATION_SPEC_SET]");

    client.deleteAnnotationSpecSet(formattedName);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnnotationSpecSetRequest actualRequest =
        (DeleteAnnotationSpecSetRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName =
          DataLabelingServiceClient.formatAnnotationSpecSetName(
              "[PROJECT]", "[ANNOTATION_SPEC_SET]");

      client.deleteAnnotationSpecSet(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createInstructionTest() throws Exception {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    Instruction expectedResponse =
        Instruction.newBuilder()
            .setName(name)
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

    String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
    Instruction instruction = Instruction.newBuilder().build();

    Instruction actualResponse = client.createInstructionAsync(formattedParent, instruction).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstructionRequest actualRequest = (CreateInstructionRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
      Instruction instruction = Instruction.newBuilder().build();

      client.createInstructionAsync(formattedParent, instruction).get();
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
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    Instruction expectedResponse =
        Instruction.newBuilder()
            .setName(name2)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String formattedName =
        DataLabelingServiceClient.formatInstructionName("[PROJECT]", "[INSTRUCTION]");

    Instruction actualResponse = client.getInstruction(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstructionRequest actualRequest = (GetInstructionRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName =
          DataLabelingServiceClient.formatInstructionName("[PROJECT]", "[INSTRUCTION]");

      client.getInstruction(formattedName);
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

    String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
    String filter = "filter-1274492040";

    ListInstructionsPagedResponse pagedListResponse =
        client.listInstructions(formattedParent, filter);

    List<Instruction> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstructionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstructionsRequest actualRequest = (ListInstructionsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
      String filter = "filter-1274492040";

      client.listInstructions(formattedParent, filter);
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

    String formattedName =
        DataLabelingServiceClient.formatInstructionName("[PROJECT]", "[INSTRUCTION]");

    client.deleteInstruction(formattedName);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstructionRequest actualRequest = (DeleteInstructionRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName =
          DataLabelingServiceClient.formatInstructionName("[PROJECT]", "[INSTRUCTION]");

      client.deleteInstruction(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getEvaluationTest() {
    String name2 = "name2-1052831874";
    long evaluatedItemCount = 358077111L;
    Evaluation expectedResponse =
        Evaluation.newBuilder().setName(name2).setEvaluatedItemCount(evaluatedItemCount).build();
    mockDataLabelingService.addResponse(expectedResponse);

    String formattedName =
        DataLabelingServiceClient.formatEvaluationName("[PROJECT]", "[DATASET]", "[EVALUATION]");

    Evaluation actualResponse = client.getEvaluation(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationRequest actualRequest = (GetEvaluationRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName =
          DataLabelingServiceClient.formatEvaluationName("[PROJECT]", "[DATASET]", "[EVALUATION]");

      client.getEvaluation(formattedName);
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

    String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
    String filter = "filter-1274492040";

    SearchEvaluationsPagedResponse pagedListResponse =
        client.searchEvaluations(formattedParent, filter);

    List<Evaluation> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchEvaluationsRequest actualRequest = (SearchEvaluationsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
      String filter = "filter-1274492040";

      client.searchEvaluations(formattedParent, filter);
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

    String formattedParent =
        DataLabelingServiceClient.formatEvaluationName("[PROJECT]", "[DATASET]", "[EVALUATION]");

    SearchExampleComparisonsPagedResponse pagedListResponse =
        client.searchExampleComparisons(formattedParent);

    List<SearchExampleComparisonsResponse.ExampleComparison> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExampleComparisonsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchExampleComparisonsRequest actualRequest =
        (SearchExampleComparisonsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent =
          DataLabelingServiceClient.formatEvaluationName("[PROJECT]", "[DATASET]", "[EVALUATION]");

      client.searchExampleComparisons(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createEvaluationJobTest() {
    String name = "name3373707";
    String description = "description-1724546052";
    String schedule = "schedule-697920873";
    String modelVersion = "modelVersion-1669102142";
    String annotationSpecSet = "annotationSpecSet1881405678";
    boolean labelMissingGroundTruth = false;
    EvaluationJob expectedResponse =
        EvaluationJob.newBuilder()
            .setName(name)
            .setDescription(description)
            .setSchedule(schedule)
            .setModelVersion(modelVersion)
            .setAnnotationSpecSet(annotationSpecSet)
            .setLabelMissingGroundTruth(labelMissingGroundTruth)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
    EvaluationJob job = EvaluationJob.newBuilder().build();

    EvaluationJob actualResponse = client.createEvaluationJob(formattedParent, job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationJobRequest actualRequest = (CreateEvaluationJobRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
      EvaluationJob job = EvaluationJob.newBuilder().build();

      client.createEvaluationJob(formattedParent, job);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateEvaluationJobTest() {
    String name = "name3373707";
    String description = "description-1724546052";
    String schedule = "schedule-697920873";
    String modelVersion = "modelVersion-1669102142";
    String annotationSpecSet = "annotationSpecSet1881405678";
    boolean labelMissingGroundTruth = false;
    EvaluationJob expectedResponse =
        EvaluationJob.newBuilder()
            .setName(name)
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
    String name2 = "name2-1052831874";
    String description = "description-1724546052";
    String schedule = "schedule-697920873";
    String modelVersion = "modelVersion-1669102142";
    String annotationSpecSet = "annotationSpecSet1881405678";
    boolean labelMissingGroundTruth = false;
    EvaluationJob expectedResponse =
        EvaluationJob.newBuilder()
            .setName(name2)
            .setDescription(description)
            .setSchedule(schedule)
            .setModelVersion(modelVersion)
            .setAnnotationSpecSet(annotationSpecSet)
            .setLabelMissingGroundTruth(labelMissingGroundTruth)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String formattedName =
        DataLabelingServiceClient.formatEvaluationJobName("[PROJECT]", "[EVALUATION_JOB]");

    EvaluationJob actualResponse = client.getEvaluationJob(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationJobRequest actualRequest = (GetEvaluationJobRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName =
          DataLabelingServiceClient.formatEvaluationJobName("[PROJECT]", "[EVALUATION_JOB]");

      client.getEvaluationJob(formattedName);
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

    String formattedName =
        DataLabelingServiceClient.formatEvaluationJobName("[PROJECT]", "[EVALUATION_JOB]");

    client.pauseEvaluationJob(formattedName);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PauseEvaluationJobRequest actualRequest = (PauseEvaluationJobRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName =
          DataLabelingServiceClient.formatEvaluationJobName("[PROJECT]", "[EVALUATION_JOB]");

      client.pauseEvaluationJob(formattedName);
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

    String formattedName =
        DataLabelingServiceClient.formatEvaluationJobName("[PROJECT]", "[EVALUATION_JOB]");

    client.resumeEvaluationJob(formattedName);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeEvaluationJobRequest actualRequest = (ResumeEvaluationJobRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName =
          DataLabelingServiceClient.formatEvaluationJobName("[PROJECT]", "[EVALUATION_JOB]");

      client.resumeEvaluationJob(formattedName);
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

    String formattedName =
        DataLabelingServiceClient.formatEvaluationJobName("[PROJECT]", "[EVALUATION_JOB]");

    client.deleteEvaluationJob(formattedName);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEvaluationJobRequest actualRequest = (DeleteEvaluationJobRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName =
          DataLabelingServiceClient.formatEvaluationJobName("[PROJECT]", "[EVALUATION_JOB]");

      client.deleteEvaluationJob(formattedName);
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

    String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
    String filter = "filter-1274492040";

    ListEvaluationJobsPagedResponse pagedListResponse =
        client.listEvaluationJobs(formattedParent, filter);

    List<EvaluationJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEvaluationJobsRequest actualRequest = (ListEvaluationJobsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent = DataLabelingServiceClient.formatProjectName("[PROJECT]");
      String filter = "filter-1274492040";

      client.listEvaluationJobs(formattedParent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
