/*
 * Copyright 2020 Google LLC
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
public class DataLabelingServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private DataLabelingServiceClient client;
  private static MockDataLabelingService mockDataLabelingService;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDataLabelingService = new MockDataLabelingService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDataLabelingService));
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
  public void createDatasetTest() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllInputConfigs(new ArrayList<InputConfig>())
            .addAllBlockingResources(new ArrayList<String>())
            .setDataItemCount(2014260376)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Dataset dataset = Dataset.newBuilder().build();

    Dataset actualResponse = client.createDataset(parent, dataset);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDatasetRequest actualRequest = ((CreateDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataset, actualRequest.getDataset());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Dataset dataset = Dataset.newBuilder().build();
      client.createDataset(parent, dataset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDatasetTest2() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllInputConfigs(new ArrayList<InputConfig>())
            .addAllBlockingResources(new ArrayList<String>())
            .setDataItemCount(2014260376)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Dataset dataset = Dataset.newBuilder().build();

    Dataset actualResponse = client.createDataset(parent, dataset);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDatasetRequest actualRequest = ((CreateDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataset, actualRequest.getDataset());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDatasetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      Dataset dataset = Dataset.newBuilder().build();
      client.createDataset(parent, dataset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatasetTest() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllInputConfigs(new ArrayList<InputConfig>())
            .addAllBlockingResources(new ArrayList<String>())
            .setDataItemCount(2014260376)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");

    Dataset actualResponse = client.getDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatasetRequest actualRequest = ((GetDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
      client.getDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatasetTest2() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllInputConfigs(new ArrayList<InputConfig>())
            .addAllBlockingResources(new ArrayList<String>())
            .setDataItemCount(2014260376)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String name = "name3373707";

    Dataset actualResponse = client.getDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatasetRequest actualRequest = ((GetDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatasetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatasetsTest() throws Exception {
    Dataset responsesElement = Dataset.newBuilder().build();
    ListDatasetsResponse expectedResponse =
        ListDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatasets(Arrays.asList(responsesElement))
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
    ListDatasetsRequest actualRequest = ((ListDatasetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatasetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";
      client.listDatasets(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatasetsTest2() throws Exception {
    Dataset responsesElement = Dataset.newBuilder().build();
    ListDatasetsResponse expectedResponse =
        ListDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatasets(Arrays.asList(responsesElement))
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    ListDatasetsPagedResponse pagedListResponse = client.listDatasets(parent, filter);

    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatasetsRequest actualRequest = ((ListDatasetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatasetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.listDatasets(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDatasetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");

    client.deleteDataset(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDatasetRequest actualRequest = ((DeleteDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
      client.deleteDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDatasetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDataset(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDatasetRequest actualRequest = ((DeleteDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDatasetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importDataTest() throws Exception {
    ImportDataOperationResponse expectedResponse =
        ImportDataOperationResponse.newBuilder()
            .setDataset("dataset1443214456")
            .setTotalCount(-407761836)
            .setImportCount(-1721296907)
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
    ImportDataRequest actualRequest = ((ImportDataRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(inputConfig, actualRequest.getInputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
      InputConfig inputConfig = InputConfig.newBuilder().build();
      client.importDataAsync(name, inputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importDataTest2() throws Exception {
    ImportDataOperationResponse expectedResponse =
        ImportDataOperationResponse.newBuilder()
            .setDataset("dataset1443214456")
            .setTotalCount(-407761836)
            .setImportCount(-1721296907)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataLabelingService.addResponse(resultOperation);

    String name = "name3373707";
    InputConfig inputConfig = InputConfig.newBuilder().build();

    ImportDataOperationResponse actualResponse = client.importDataAsync(name, inputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportDataRequest actualRequest = ((ImportDataRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(inputConfig, actualRequest.getInputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importDataExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      InputConfig inputConfig = InputConfig.newBuilder().build();
      client.importDataAsync(name, inputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportDataTest() throws Exception {
    ExportDataOperationResponse expectedResponse =
        ExportDataOperationResponse.newBuilder()
            .setDataset("dataset1443214456")
            .setTotalCount(-407761836)
            .setExportCount(-529256252)
            .setLabelStats(LabelStats.newBuilder().build())
            .setOutputConfig(OutputConfig.newBuilder().build())
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
    ExportDataRequest actualRequest = ((ExportDataRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(annotatedDataset.toString(), actualRequest.getAnnotatedDataset());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertEquals(outputConfig, actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
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
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportDataTest2() throws Exception {
    ExportDataOperationResponse expectedResponse =
        ExportDataOperationResponse.newBuilder()
            .setDataset("dataset1443214456")
            .setTotalCount(-407761836)
            .setExportCount(-529256252)
            .setLabelStats(LabelStats.newBuilder().build())
            .setOutputConfig(OutputConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataLabelingService.addResponse(resultOperation);

    DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
    String annotatedDataset = "annotatedDataset-246761280";
    String filter = "filter-1274492040";
    OutputConfig outputConfig = OutputConfig.newBuilder().build();

    ExportDataOperationResponse actualResponse =
        client.exportDataAsync(name, annotatedDataset, filter, outputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportDataRequest actualRequest = ((ExportDataRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(annotatedDataset, actualRequest.getAnnotatedDataset());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertEquals(outputConfig, actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportDataExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");
      String annotatedDataset = "annotatedDataset-246761280";
      String filter = "filter-1274492040";
      OutputConfig outputConfig = OutputConfig.newBuilder().build();
      client.exportDataAsync(name, annotatedDataset, filter, outputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportDataTest3() throws Exception {
    ExportDataOperationResponse expectedResponse =
        ExportDataOperationResponse.newBuilder()
            .setDataset("dataset1443214456")
            .setTotalCount(-407761836)
            .setExportCount(-529256252)
            .setLabelStats(LabelStats.newBuilder().build())
            .setOutputConfig(OutputConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataLabelingService.addResponse(resultOperation);

    String name = "name3373707";
    AnnotatedDatasetName annotatedDataset =
        AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
    String filter = "filter-1274492040";
    OutputConfig outputConfig = OutputConfig.newBuilder().build();

    ExportDataOperationResponse actualResponse =
        client.exportDataAsync(name, annotatedDataset, filter, outputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportDataRequest actualRequest = ((ExportDataRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(annotatedDataset.toString(), actualRequest.getAnnotatedDataset());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertEquals(outputConfig, actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportDataExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      AnnotatedDatasetName annotatedDataset =
          AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
      String filter = "filter-1274492040";
      OutputConfig outputConfig = OutputConfig.newBuilder().build();
      client.exportDataAsync(name, annotatedDataset, filter, outputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportDataTest4() throws Exception {
    ExportDataOperationResponse expectedResponse =
        ExportDataOperationResponse.newBuilder()
            .setDataset("dataset1443214456")
            .setTotalCount(-407761836)
            .setExportCount(-529256252)
            .setLabelStats(LabelStats.newBuilder().build())
            .setOutputConfig(OutputConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataLabelingService.addResponse(resultOperation);

    String name = "name3373707";
    String annotatedDataset = "annotatedDataset-246761280";
    String filter = "filter-1274492040";
    OutputConfig outputConfig = OutputConfig.newBuilder().build();

    ExportDataOperationResponse actualResponse =
        client.exportDataAsync(name, annotatedDataset, filter, outputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportDataRequest actualRequest = ((ExportDataRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(annotatedDataset, actualRequest.getAnnotatedDataset());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertEquals(outputConfig, actualRequest.getOutputConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportDataExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      String annotatedDataset = "annotatedDataset-246761280";
      String filter = "filter-1274492040";
      OutputConfig outputConfig = OutputConfig.newBuilder().build();
      client.exportDataAsync(name, annotatedDataset, filter, outputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getDataItemTest() throws Exception {
    DataItem expectedResponse =
        DataItem.newBuilder()
            .setName(DataItemName.of("[PROJECT]", "[DATASET]", "[DATA_ITEM]").toString())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    DataItemName name = DataItemName.of("[PROJECT]", "[DATASET]", "[DATA_ITEM]");

    DataItem actualResponse = client.getDataItem(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataItemRequest actualRequest = ((GetDataItemRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DataItemName name = DataItemName.of("[PROJECT]", "[DATASET]", "[DATA_ITEM]");
      client.getDataItem(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataItemTest2() throws Exception {
    DataItem expectedResponse =
        DataItem.newBuilder()
            .setName(DataItemName.of("[PROJECT]", "[DATASET]", "[DATA_ITEM]").toString())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String name = "name3373707";

    DataItem actualResponse = client.getDataItem(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataItemRequest actualRequest = ((GetDataItemRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataItemExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataItem(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataItemsTest() throws Exception {
    DataItem responsesElement = DataItem.newBuilder().build();
    ListDataItemsResponse expectedResponse =
        ListDataItemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataItems(Arrays.asList(responsesElement))
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
    ListDataItemsRequest actualRequest = ((ListDataItemsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName parent = DatasetName.of("[PROJECT]", "[DATASET]");
      String filter = "filter-1274492040";
      client.listDataItems(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataItemsTest2() throws Exception {
    DataItem responsesElement = DataItem.newBuilder().build();
    ListDataItemsResponse expectedResponse =
        ListDataItemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataItems(Arrays.asList(responsesElement))
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    ListDataItemsPagedResponse pagedListResponse = client.listDataItems(parent, filter);

    List<DataItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataItemsRequest actualRequest = ((ListDataItemsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataItemsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.listDataItems(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnnotatedDatasetTest() throws Exception {
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(
                AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setExampleCount(1517063674)
            .setCompletedExampleCount(-612567290)
            .setLabelStats(LabelStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setMetadata(AnnotatedDatasetMetadata.newBuilder().build())
            .addAllBlockingResources(new ArrayList<String>())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    AnnotatedDatasetName name =
        AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");

    AnnotatedDataset actualResponse = client.getAnnotatedDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnnotatedDatasetRequest actualRequest = ((GetAnnotatedDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnnotatedDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      AnnotatedDatasetName name =
          AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
      client.getAnnotatedDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnnotatedDatasetTest2() throws Exception {
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(
                AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setExampleCount(1517063674)
            .setCompletedExampleCount(-612567290)
            .setLabelStats(LabelStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setMetadata(AnnotatedDatasetMetadata.newBuilder().build())
            .addAllBlockingResources(new ArrayList<String>())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String name = "name3373707";

    AnnotatedDataset actualResponse = client.getAnnotatedDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnnotatedDatasetRequest actualRequest = ((GetAnnotatedDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnnotatedDatasetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      client.getAnnotatedDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnnotatedDatasetsTest() throws Exception {
    AnnotatedDataset responsesElement = AnnotatedDataset.newBuilder().build();
    ListAnnotatedDatasetsResponse expectedResponse =
        ListAnnotatedDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnnotatedDatasets(Arrays.asList(responsesElement))
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
        ((ListAnnotatedDatasetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnnotatedDatasetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName parent = DatasetName.of("[PROJECT]", "[DATASET]");
      String filter = "filter-1274492040";
      client.listAnnotatedDatasets(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnnotatedDatasetsTest2() throws Exception {
    AnnotatedDataset responsesElement = AnnotatedDataset.newBuilder().build();
    ListAnnotatedDatasetsResponse expectedResponse =
        ListAnnotatedDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnnotatedDatasets(Arrays.asList(responsesElement))
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    ListAnnotatedDatasetsPagedResponse pagedListResponse =
        client.listAnnotatedDatasets(parent, filter);

    List<AnnotatedDataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnnotatedDatasetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnnotatedDatasetsRequest actualRequest =
        ((ListAnnotatedDatasetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnnotatedDatasetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.listAnnotatedDatasets(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAnnotatedDatasetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    DeleteAnnotatedDatasetRequest request =
        DeleteAnnotatedDatasetRequest.newBuilder()
            .setName(
                AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]").toString())
            .build();

    client.deleteAnnotatedDataset(request);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnnotatedDatasetRequest actualRequest =
        ((DeleteAnnotatedDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAnnotatedDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DeleteAnnotatedDatasetRequest request =
          DeleteAnnotatedDatasetRequest.newBuilder()
              .setName(
                  AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]")
                      .toString())
              .build();
      client.deleteAnnotatedDataset(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void labelImageTest() throws Exception {
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(
                AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setExampleCount(1517063674)
            .setCompletedExampleCount(-612567290)
            .setLabelStats(LabelStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setMetadata(AnnotatedDatasetMetadata.newBuilder().build())
            .addAllBlockingResources(new ArrayList<String>())
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
    LabelImageRequest.Feature feature = LabelImageRequest.Feature.forNumber(0);

    AnnotatedDataset actualResponse = client.labelImageAsync(parent, basicConfig, feature).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LabelImageRequest actualRequest = ((LabelImageRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(basicConfig, actualRequest.getBasicConfig());
    Assert.assertEquals(feature, actualRequest.getFeature());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void labelImageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName parent = DatasetName.of("[PROJECT]", "[DATASET]");
      HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
      LabelImageRequest.Feature feature = LabelImageRequest.Feature.forNumber(0);
      client.labelImageAsync(parent, basicConfig, feature).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void labelImageTest2() throws Exception {
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(
                AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setExampleCount(1517063674)
            .setCompletedExampleCount(-612567290)
            .setLabelStats(LabelStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setMetadata(AnnotatedDatasetMetadata.newBuilder().build())
            .addAllBlockingResources(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("labelImageTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataLabelingService.addResponse(resultOperation);

    String parent = "parent-995424086";
    HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
    LabelImageRequest.Feature feature = LabelImageRequest.Feature.forNumber(0);

    AnnotatedDataset actualResponse = client.labelImageAsync(parent, basicConfig, feature).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LabelImageRequest actualRequest = ((LabelImageRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(basicConfig, actualRequest.getBasicConfig());
    Assert.assertEquals(feature, actualRequest.getFeature());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void labelImageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
      LabelImageRequest.Feature feature = LabelImageRequest.Feature.forNumber(0);
      client.labelImageAsync(parent, basicConfig, feature).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void labelVideoTest() throws Exception {
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(
                AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setExampleCount(1517063674)
            .setCompletedExampleCount(-612567290)
            .setLabelStats(LabelStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setMetadata(AnnotatedDatasetMetadata.newBuilder().build())
            .addAllBlockingResources(new ArrayList<String>())
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
    LabelVideoRequest.Feature feature = LabelVideoRequest.Feature.forNumber(0);

    AnnotatedDataset actualResponse = client.labelVideoAsync(parent, basicConfig, feature).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LabelVideoRequest actualRequest = ((LabelVideoRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(basicConfig, actualRequest.getBasicConfig());
    Assert.assertEquals(feature, actualRequest.getFeature());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void labelVideoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName parent = DatasetName.of("[PROJECT]", "[DATASET]");
      HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
      LabelVideoRequest.Feature feature = LabelVideoRequest.Feature.forNumber(0);
      client.labelVideoAsync(parent, basicConfig, feature).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void labelVideoTest2() throws Exception {
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(
                AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setExampleCount(1517063674)
            .setCompletedExampleCount(-612567290)
            .setLabelStats(LabelStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setMetadata(AnnotatedDatasetMetadata.newBuilder().build())
            .addAllBlockingResources(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("labelVideoTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataLabelingService.addResponse(resultOperation);

    String parent = "parent-995424086";
    HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
    LabelVideoRequest.Feature feature = LabelVideoRequest.Feature.forNumber(0);

    AnnotatedDataset actualResponse = client.labelVideoAsync(parent, basicConfig, feature).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LabelVideoRequest actualRequest = ((LabelVideoRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(basicConfig, actualRequest.getBasicConfig());
    Assert.assertEquals(feature, actualRequest.getFeature());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void labelVideoExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
      LabelVideoRequest.Feature feature = LabelVideoRequest.Feature.forNumber(0);
      client.labelVideoAsync(parent, basicConfig, feature).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void labelTextTest() throws Exception {
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(
                AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setExampleCount(1517063674)
            .setCompletedExampleCount(-612567290)
            .setLabelStats(LabelStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setMetadata(AnnotatedDatasetMetadata.newBuilder().build())
            .addAllBlockingResources(new ArrayList<String>())
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
    LabelTextRequest.Feature feature = LabelTextRequest.Feature.forNumber(0);

    AnnotatedDataset actualResponse = client.labelTextAsync(parent, basicConfig, feature).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LabelTextRequest actualRequest = ((LabelTextRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(basicConfig, actualRequest.getBasicConfig());
    Assert.assertEquals(feature, actualRequest.getFeature());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void labelTextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      DatasetName parent = DatasetName.of("[PROJECT]", "[DATASET]");
      HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
      LabelTextRequest.Feature feature = LabelTextRequest.Feature.forNumber(0);
      client.labelTextAsync(parent, basicConfig, feature).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void labelTextTest2() throws Exception {
    AnnotatedDataset expectedResponse =
        AnnotatedDataset.newBuilder()
            .setName(
                AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setExampleCount(1517063674)
            .setCompletedExampleCount(-612567290)
            .setLabelStats(LabelStats.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setMetadata(AnnotatedDatasetMetadata.newBuilder().build())
            .addAllBlockingResources(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("labelTextTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataLabelingService.addResponse(resultOperation);

    String parent = "parent-995424086";
    HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
    LabelTextRequest.Feature feature = LabelTextRequest.Feature.forNumber(0);

    AnnotatedDataset actualResponse = client.labelTextAsync(parent, basicConfig, feature).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LabelTextRequest actualRequest = ((LabelTextRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(basicConfig, actualRequest.getBasicConfig());
    Assert.assertEquals(feature, actualRequest.getFeature());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void labelTextExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      HumanAnnotationConfig basicConfig = HumanAnnotationConfig.newBuilder().build();
      LabelTextRequest.Feature feature = LabelTextRequest.Feature.forNumber(0);
      client.labelTextAsync(parent, basicConfig, feature).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getExampleTest() throws Exception {
    Example expectedResponse =
        Example.newBuilder()
            .setName(
                ExampleName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]", "[EXAMPLE]")
                    .toString())
            .addAllAnnotations(new ArrayList<Annotation>())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    ExampleName name = ExampleName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]", "[EXAMPLE]");
    String filter = "filter-1274492040";

    Example actualResponse = client.getExample(name, filter);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExampleRequest actualRequest = ((GetExampleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExampleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ExampleName name =
          ExampleName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]", "[EXAMPLE]");
      String filter = "filter-1274492040";
      client.getExample(name, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExampleTest2() throws Exception {
    Example expectedResponse =
        Example.newBuilder()
            .setName(
                ExampleName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]", "[EXAMPLE]")
                    .toString())
            .addAllAnnotations(new ArrayList<Annotation>())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String name = "name3373707";
    String filter = "filter-1274492040";

    Example actualResponse = client.getExample(name, filter);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExampleRequest actualRequest = ((GetExampleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExampleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      String filter = "filter-1274492040";
      client.getExample(name, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExamplesTest() throws Exception {
    Example responsesElement = Example.newBuilder().build();
    ListExamplesResponse expectedResponse =
        ListExamplesResponse.newBuilder()
            .setNextPageToken("")
            .addAllExamples(Arrays.asList(responsesElement))
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
    ListExamplesRequest actualRequest = ((ListExamplesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExamplesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      AnnotatedDatasetName parent =
          AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]");
      String filter = "filter-1274492040";
      client.listExamples(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExamplesTest2() throws Exception {
    Example responsesElement = Example.newBuilder().build();
    ListExamplesResponse expectedResponse =
        ListExamplesResponse.newBuilder()
            .setNextPageToken("")
            .addAllExamples(Arrays.asList(responsesElement))
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    ListExamplesPagedResponse pagedListResponse = client.listExamples(parent, filter);

    List<Example> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExamplesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExamplesRequest actualRequest = ((ListExamplesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExamplesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.listExamples(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAnnotationSpecSetTest() throws Exception {
    AnnotationSpecSet expectedResponse =
        AnnotationSpecSet.newBuilder()
            .setName(AnnotationSpecSetName.of("[PROJECT]", "[ANNOTATION_SPEC_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllAnnotationSpecs(new ArrayList<AnnotationSpec>())
            .addAllBlockingResources(new ArrayList<String>())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    AnnotationSpecSet annotationSpecSet = AnnotationSpecSet.newBuilder().build();

    AnnotationSpecSet actualResponse = client.createAnnotationSpecSet(parent, annotationSpecSet);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnnotationSpecSetRequest actualRequest =
        ((CreateAnnotationSpecSetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(annotationSpecSet, actualRequest.getAnnotationSpecSet());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAnnotationSpecSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      AnnotationSpecSet annotationSpecSet = AnnotationSpecSet.newBuilder().build();
      client.createAnnotationSpecSet(parent, annotationSpecSet);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAnnotationSpecSetTest2() throws Exception {
    AnnotationSpecSet expectedResponse =
        AnnotationSpecSet.newBuilder()
            .setName(AnnotationSpecSetName.of("[PROJECT]", "[ANNOTATION_SPEC_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllAnnotationSpecs(new ArrayList<AnnotationSpec>())
            .addAllBlockingResources(new ArrayList<String>())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    AnnotationSpecSet annotationSpecSet = AnnotationSpecSet.newBuilder().build();

    AnnotationSpecSet actualResponse = client.createAnnotationSpecSet(parent, annotationSpecSet);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnnotationSpecSetRequest actualRequest =
        ((CreateAnnotationSpecSetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(annotationSpecSet, actualRequest.getAnnotationSpecSet());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAnnotationSpecSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      AnnotationSpecSet annotationSpecSet = AnnotationSpecSet.newBuilder().build();
      client.createAnnotationSpecSet(parent, annotationSpecSet);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnnotationSpecSetTest() throws Exception {
    AnnotationSpecSet expectedResponse =
        AnnotationSpecSet.newBuilder()
            .setName(AnnotationSpecSetName.of("[PROJECT]", "[ANNOTATION_SPEC_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllAnnotationSpecs(new ArrayList<AnnotationSpec>())
            .addAllBlockingResources(new ArrayList<String>())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    AnnotationSpecSetName name = AnnotationSpecSetName.of("[PROJECT]", "[ANNOTATION_SPEC_SET]");

    AnnotationSpecSet actualResponse = client.getAnnotationSpecSet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnnotationSpecSetRequest actualRequest =
        ((GetAnnotationSpecSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnnotationSpecSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      AnnotationSpecSetName name = AnnotationSpecSetName.of("[PROJECT]", "[ANNOTATION_SPEC_SET]");
      client.getAnnotationSpecSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnnotationSpecSetTest2() throws Exception {
    AnnotationSpecSet expectedResponse =
        AnnotationSpecSet.newBuilder()
            .setName(AnnotationSpecSetName.of("[PROJECT]", "[ANNOTATION_SPEC_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllAnnotationSpecs(new ArrayList<AnnotationSpec>())
            .addAllBlockingResources(new ArrayList<String>())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String name = "name3373707";

    AnnotationSpecSet actualResponse = client.getAnnotationSpecSet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnnotationSpecSetRequest actualRequest =
        ((GetAnnotationSpecSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnnotationSpecSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      client.getAnnotationSpecSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnnotationSpecSetsTest() throws Exception {
    AnnotationSpecSet responsesElement = AnnotationSpecSet.newBuilder().build();
    ListAnnotationSpecSetsResponse expectedResponse =
        ListAnnotationSpecSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnnotationSpecSets(Arrays.asList(responsesElement))
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
        ((ListAnnotationSpecSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnnotationSpecSetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";
      client.listAnnotationSpecSets(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnnotationSpecSetsTest2() throws Exception {
    AnnotationSpecSet responsesElement = AnnotationSpecSet.newBuilder().build();
    ListAnnotationSpecSetsResponse expectedResponse =
        ListAnnotationSpecSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnnotationSpecSets(Arrays.asList(responsesElement))
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    ListAnnotationSpecSetsPagedResponse pagedListResponse =
        client.listAnnotationSpecSets(parent, filter);

    List<AnnotationSpecSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnnotationSpecSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnnotationSpecSetsRequest actualRequest =
        ((ListAnnotationSpecSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnnotationSpecSetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.listAnnotationSpecSets(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAnnotationSpecSetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    AnnotationSpecSetName name = AnnotationSpecSetName.of("[PROJECT]", "[ANNOTATION_SPEC_SET]");

    client.deleteAnnotationSpecSet(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnnotationSpecSetRequest actualRequest =
        ((DeleteAnnotationSpecSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAnnotationSpecSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      AnnotationSpecSetName name = AnnotationSpecSetName.of("[PROJECT]", "[ANNOTATION_SPEC_SET]");
      client.deleteAnnotationSpecSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAnnotationSpecSetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAnnotationSpecSet(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnnotationSpecSetRequest actualRequest =
        ((DeleteAnnotationSpecSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAnnotationSpecSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAnnotationSpecSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInstructionTest() throws Exception {
    Instruction expectedResponse =
        Instruction.newBuilder()
            .setName(InstructionName.of("[PROJECT]", "[INSTRUCTION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCsvInstruction(CsvInstruction.newBuilder().build())
            .setPdfInstruction(PdfInstruction.newBuilder().build())
            .addAllBlockingResources(new ArrayList<String>())
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
    CreateInstructionRequest actualRequest = ((CreateInstructionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(instruction, actualRequest.getInstruction());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstructionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Instruction instruction = Instruction.newBuilder().build();
      client.createInstructionAsync(parent, instruction).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createInstructionTest2() throws Exception {
    Instruction expectedResponse =
        Instruction.newBuilder()
            .setName(InstructionName.of("[PROJECT]", "[INSTRUCTION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCsvInstruction(CsvInstruction.newBuilder().build())
            .setPdfInstruction(PdfInstruction.newBuilder().build())
            .addAllBlockingResources(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstructionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataLabelingService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Instruction instruction = Instruction.newBuilder().build();

    Instruction actualResponse = client.createInstructionAsync(parent, instruction).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstructionRequest actualRequest = ((CreateInstructionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(instruction, actualRequest.getInstruction());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstructionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      Instruction instruction = Instruction.newBuilder().build();
      client.createInstructionAsync(parent, instruction).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getInstructionTest() throws Exception {
    Instruction expectedResponse =
        Instruction.newBuilder()
            .setName(InstructionName.of("[PROJECT]", "[INSTRUCTION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCsvInstruction(CsvInstruction.newBuilder().build())
            .setPdfInstruction(PdfInstruction.newBuilder().build())
            .addAllBlockingResources(new ArrayList<String>())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    InstructionName name = InstructionName.of("[PROJECT]", "[INSTRUCTION]");

    Instruction actualResponse = client.getInstruction(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstructionRequest actualRequest = ((GetInstructionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstructionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      InstructionName name = InstructionName.of("[PROJECT]", "[INSTRUCTION]");
      client.getInstruction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstructionTest2() throws Exception {
    Instruction expectedResponse =
        Instruction.newBuilder()
            .setName(InstructionName.of("[PROJECT]", "[INSTRUCTION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCsvInstruction(CsvInstruction.newBuilder().build())
            .setPdfInstruction(PdfInstruction.newBuilder().build())
            .addAllBlockingResources(new ArrayList<String>())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String name = "name3373707";

    Instruction actualResponse = client.getInstruction(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstructionRequest actualRequest = ((GetInstructionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstructionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      client.getInstruction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstructionsTest() throws Exception {
    Instruction responsesElement = Instruction.newBuilder().build();
    ListInstructionsResponse expectedResponse =
        ListInstructionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstructions(Arrays.asList(responsesElement))
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
    ListInstructionsRequest actualRequest = ((ListInstructionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstructionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";
      client.listInstructions(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstructionsTest2() throws Exception {
    Instruction responsesElement = Instruction.newBuilder().build();
    ListInstructionsResponse expectedResponse =
        ListInstructionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstructions(Arrays.asList(responsesElement))
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    ListInstructionsPagedResponse pagedListResponse = client.listInstructions(parent, filter);

    List<Instruction> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstructionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstructionsRequest actualRequest = ((ListInstructionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstructionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.listInstructions(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteInstructionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    InstructionName name = InstructionName.of("[PROJECT]", "[INSTRUCTION]");

    client.deleteInstruction(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstructionRequest actualRequest = ((DeleteInstructionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInstructionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      InstructionName name = InstructionName.of("[PROJECT]", "[INSTRUCTION]");
      client.deleteInstruction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteInstructionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteInstruction(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstructionRequest actualRequest = ((DeleteInstructionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInstructionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteInstruction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEvaluationTest() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(EvaluationName.of("[PROJECT]", "[DATASET]", "[EVALUATION]").toString())
            .setConfig(EvaluationConfig.newBuilder().build())
            .setEvaluationJobRunTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEvaluationMetrics(EvaluationMetrics.newBuilder().build())
            .setEvaluatedItemCount(358077111)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    EvaluationName name = EvaluationName.of("[PROJECT]", "[DATASET]", "[EVALUATION]");

    Evaluation actualResponse = client.getEvaluation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationRequest actualRequest = ((GetEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEvaluationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationName name = EvaluationName.of("[PROJECT]", "[DATASET]", "[EVALUATION]");
      client.getEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEvaluationTest2() throws Exception {
    Evaluation expectedResponse =
        Evaluation.newBuilder()
            .setName(EvaluationName.of("[PROJECT]", "[DATASET]", "[EVALUATION]").toString())
            .setConfig(EvaluationConfig.newBuilder().build())
            .setEvaluationJobRunTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEvaluationMetrics(EvaluationMetrics.newBuilder().build())
            .setEvaluatedItemCount(358077111)
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String name = "name3373707";

    Evaluation actualResponse = client.getEvaluation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationRequest actualRequest = ((GetEvaluationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEvaluationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      client.getEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchEvaluationsTest() throws Exception {
    Evaluation responsesElement = Evaluation.newBuilder().build();
    SearchEvaluationsResponse expectedResponse =
        SearchEvaluationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluations(Arrays.asList(responsesElement))
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
    SearchEvaluationsRequest actualRequest = ((SearchEvaluationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchEvaluationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationName parent = EvaluationName.of("[PROJECT]", "[DATASET]", "[EVALUATION]");
      String filter = "filter-1274492040";
      client.searchEvaluations(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchEvaluationsTest2() throws Exception {
    Evaluation responsesElement = Evaluation.newBuilder().build();
    SearchEvaluationsResponse expectedResponse =
        SearchEvaluationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluations(Arrays.asList(responsesElement))
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    SearchEvaluationsPagedResponse pagedListResponse = client.searchEvaluations(parent, filter);

    List<Evaluation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchEvaluationsRequest actualRequest = ((SearchEvaluationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchEvaluationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.searchEvaluations(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchExampleComparisonsTest() throws Exception {
    SearchExampleComparisonsResponse.ExampleComparison responsesElement =
        SearchExampleComparisonsResponse.ExampleComparison.newBuilder().build();
    SearchExampleComparisonsResponse expectedResponse =
        SearchExampleComparisonsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExampleComparisons(Arrays.asList(responsesElement))
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
        ((SearchExampleComparisonsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchExampleComparisonsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationName parent = EvaluationName.of("[PROJECT]", "[DATASET]", "[EVALUATION]");
      client.searchExampleComparisons(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchExampleComparisonsTest2() throws Exception {
    SearchExampleComparisonsResponse.ExampleComparison responsesElement =
        SearchExampleComparisonsResponse.ExampleComparison.newBuilder().build();
    SearchExampleComparisonsResponse expectedResponse =
        SearchExampleComparisonsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExampleComparisons(Arrays.asList(responsesElement))
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    SearchExampleComparisonsPagedResponse pagedListResponse =
        client.searchExampleComparisons(parent);

    List<SearchExampleComparisonsResponse.ExampleComparison> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExampleComparisonsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchExampleComparisonsRequest actualRequest =
        ((SearchExampleComparisonsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchExampleComparisonsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.searchExampleComparisons(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEvaluationJobTest() throws Exception {
    EvaluationJob expectedResponse =
        EvaluationJob.newBuilder()
            .setName(EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setModelVersion("modelVersion212437359")
            .setEvaluationJobConfig(EvaluationJobConfig.newBuilder().build())
            .setAnnotationSpecSet("annotationSpecSet-2015725448")
            .setLabelMissingGroundTruth(true)
            .addAllAttempts(new ArrayList<Attempt>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    EvaluationJob job = EvaluationJob.newBuilder().build();

    EvaluationJob actualResponse = client.createEvaluationJob(parent, job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationJobRequest actualRequest = ((CreateEvaluationJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEvaluationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      EvaluationJob job = EvaluationJob.newBuilder().build();
      client.createEvaluationJob(parent, job);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEvaluationJobTest2() throws Exception {
    EvaluationJob expectedResponse =
        EvaluationJob.newBuilder()
            .setName(EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setModelVersion("modelVersion212437359")
            .setEvaluationJobConfig(EvaluationJobConfig.newBuilder().build())
            .setAnnotationSpecSet("annotationSpecSet-2015725448")
            .setLabelMissingGroundTruth(true)
            .addAllAttempts(new ArrayList<Attempt>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    EvaluationJob job = EvaluationJob.newBuilder().build();

    EvaluationJob actualResponse = client.createEvaluationJob(parent, job);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEvaluationJobRequest actualRequest = ((CreateEvaluationJobRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(job, actualRequest.getJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEvaluationJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      EvaluationJob job = EvaluationJob.newBuilder().build();
      client.createEvaluationJob(parent, job);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEvaluationJobTest() throws Exception {
    EvaluationJob expectedResponse =
        EvaluationJob.newBuilder()
            .setName(EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setModelVersion("modelVersion212437359")
            .setEvaluationJobConfig(EvaluationJobConfig.newBuilder().build())
            .setAnnotationSpecSet("annotationSpecSet-2015725448")
            .setLabelMissingGroundTruth(true)
            .addAllAttempts(new ArrayList<Attempt>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    EvaluationJob evaluationJob = EvaluationJob.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EvaluationJob actualResponse = client.updateEvaluationJob(evaluationJob, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEvaluationJobRequest actualRequest = ((UpdateEvaluationJobRequest) actualRequests.get(0));

    Assert.assertEquals(evaluationJob, actualRequest.getEvaluationJob());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEvaluationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationJob evaluationJob = EvaluationJob.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEvaluationJob(evaluationJob, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEvaluationJobTest() throws Exception {
    EvaluationJob expectedResponse =
        EvaluationJob.newBuilder()
            .setName(EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setModelVersion("modelVersion212437359")
            .setEvaluationJobConfig(EvaluationJobConfig.newBuilder().build())
            .setAnnotationSpecSet("annotationSpecSet-2015725448")
            .setLabelMissingGroundTruth(true)
            .addAllAttempts(new ArrayList<Attempt>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");

    EvaluationJob actualResponse = client.getEvaluationJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationJobRequest actualRequest = ((GetEvaluationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEvaluationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");
      client.getEvaluationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEvaluationJobTest2() throws Exception {
    EvaluationJob expectedResponse =
        EvaluationJob.newBuilder()
            .setName(EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]").toString())
            .setDescription("description-1724546052")
            .setSchedule("schedule-697920873")
            .setModelVersion("modelVersion212437359")
            .setEvaluationJobConfig(EvaluationJobConfig.newBuilder().build())
            .setAnnotationSpecSet("annotationSpecSet-2015725448")
            .setLabelMissingGroundTruth(true)
            .addAllAttempts(new ArrayList<Attempt>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String name = "name3373707";

    EvaluationJob actualResponse = client.getEvaluationJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEvaluationJobRequest actualRequest = ((GetEvaluationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEvaluationJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      client.getEvaluationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseEvaluationJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");

    client.pauseEvaluationJob(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PauseEvaluationJobRequest actualRequest = ((PauseEvaluationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pauseEvaluationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");
      client.pauseEvaluationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseEvaluationJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    String name = "name3373707";

    client.pauseEvaluationJob(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PauseEvaluationJobRequest actualRequest = ((PauseEvaluationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pauseEvaluationJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      client.pauseEvaluationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeEvaluationJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");

    client.resumeEvaluationJob(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeEvaluationJobRequest actualRequest = ((ResumeEvaluationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeEvaluationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");
      client.resumeEvaluationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeEvaluationJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    String name = "name3373707";

    client.resumeEvaluationJob(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeEvaluationJobRequest actualRequest = ((ResumeEvaluationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeEvaluationJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      client.resumeEvaluationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEvaluationJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");

    client.deleteEvaluationJob(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEvaluationJobRequest actualRequest = ((DeleteEvaluationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEvaluationJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      EvaluationJobName name = EvaluationJobName.of("[PROJECT]", "[EVALUATION_JOB]");
      client.deleteEvaluationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEvaluationJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataLabelingService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteEvaluationJob(name);

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEvaluationJobRequest actualRequest = ((DeleteEvaluationJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEvaluationJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEvaluationJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEvaluationJobsTest() throws Exception {
    EvaluationJob responsesElement = EvaluationJob.newBuilder().build();
    ListEvaluationJobsResponse expectedResponse =
        ListEvaluationJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluationJobs(Arrays.asList(responsesElement))
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
    ListEvaluationJobsRequest actualRequest = ((ListEvaluationJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEvaluationJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";
      client.listEvaluationJobs(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEvaluationJobsTest2() throws Exception {
    EvaluationJob responsesElement = EvaluationJob.newBuilder().build();
    ListEvaluationJobsResponse expectedResponse =
        ListEvaluationJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEvaluationJobs(Arrays.asList(responsesElement))
            .build();
    mockDataLabelingService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    ListEvaluationJobsPagedResponse pagedListResponse = client.listEvaluationJobs(parent, filter);

    List<EvaluationJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEvaluationJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataLabelingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEvaluationJobsRequest actualRequest = ((ListEvaluationJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEvaluationJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataLabelingService.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.listEvaluationJobs(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
