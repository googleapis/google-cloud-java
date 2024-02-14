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

package com.google.maps.mapsplatformdatasets.v1;

import static com.google.maps.mapsplatformdatasets.v1.MapsPlatformDatasetsClient.ListDatasetsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class MapsPlatformDatasetsClientTest {
  private static MockMapsPlatformDatasets mockMapsPlatformDatasets;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MapsPlatformDatasetsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMapsPlatformDatasets = new MockMapsPlatformDatasets();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockMapsPlatformDatasets));
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
    MapsPlatformDatasetsSettings settings =
        MapsPlatformDatasetsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MapsPlatformDatasetsClient.create(settings);
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
            .setVersionId("versionId-1407102957")
            .addAllUsage(new ArrayList<Usage>())
            .setStatus(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionCreateTime(Timestamp.newBuilder().build())
            .setVersionDescription("versionDescription-1736173564")
            .build();
    mockMapsPlatformDatasets.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Dataset dataset = Dataset.newBuilder().build();

    Dataset actualResponse = client.createDataset(parent, dataset);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapsPlatformDatasets.getRequests();
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
    mockMapsPlatformDatasets.addException(exception);

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
            .setVersionId("versionId-1407102957")
            .addAllUsage(new ArrayList<Usage>())
            .setStatus(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionCreateTime(Timestamp.newBuilder().build())
            .setVersionDescription("versionDescription-1736173564")
            .build();
    mockMapsPlatformDatasets.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Dataset dataset = Dataset.newBuilder().build();

    Dataset actualResponse = client.createDataset(parent, dataset);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapsPlatformDatasets.getRequests();
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
    mockMapsPlatformDatasets.addException(exception);

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
  public void updateDatasetMetadataTest() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setVersionId("versionId-1407102957")
            .addAllUsage(new ArrayList<Usage>())
            .setStatus(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionCreateTime(Timestamp.newBuilder().build())
            .setVersionDescription("versionDescription-1736173564")
            .build();
    mockMapsPlatformDatasets.addResponse(expectedResponse);

    Dataset dataset = Dataset.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Dataset actualResponse = client.updateDatasetMetadata(dataset, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapsPlatformDatasets.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDatasetMetadataRequest actualRequest =
        ((UpdateDatasetMetadataRequest) actualRequests.get(0));

    Assert.assertEquals(dataset, actualRequest.getDataset());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDatasetMetadataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapsPlatformDatasets.addException(exception);

    try {
      Dataset dataset = Dataset.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDatasetMetadata(dataset, updateMask);
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
            .setVersionId("versionId-1407102957")
            .addAllUsage(new ArrayList<Usage>())
            .setStatus(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionCreateTime(Timestamp.newBuilder().build())
            .setVersionDescription("versionDescription-1736173564")
            .build();
    mockMapsPlatformDatasets.addResponse(expectedResponse);

    DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");

    Dataset actualResponse = client.getDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapsPlatformDatasets.getRequests();
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
    mockMapsPlatformDatasets.addException(exception);

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
            .setVersionId("versionId-1407102957")
            .addAllUsage(new ArrayList<Usage>())
            .setStatus(Status.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVersionCreateTime(Timestamp.newBuilder().build())
            .setVersionDescription("versionDescription-1736173564")
            .build();
    mockMapsPlatformDatasets.addResponse(expectedResponse);

    String name = "name3373707";

    Dataset actualResponse = client.getDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapsPlatformDatasets.getRequests();
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
    mockMapsPlatformDatasets.addException(exception);

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
    mockMapsPlatformDatasets.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListDatasetsPagedResponse pagedListResponse = client.listDatasets(parent);

    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMapsPlatformDatasets.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatasetsRequest actualRequest = ((ListDatasetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatasetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapsPlatformDatasets.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listDatasets(parent);
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
    mockMapsPlatformDatasets.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDatasetsPagedResponse pagedListResponse = client.listDatasets(parent);

    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMapsPlatformDatasets.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatasetsRequest actualRequest = ((ListDatasetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatasetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapsPlatformDatasets.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDatasets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDatasetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMapsPlatformDatasets.addResponse(expectedResponse);

    DatasetName name = DatasetName.of("[PROJECT]", "[DATASET]");

    client.deleteDataset(name);

    List<AbstractMessage> actualRequests = mockMapsPlatformDatasets.getRequests();
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
    mockMapsPlatformDatasets.addException(exception);

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
    mockMapsPlatformDatasets.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDataset(name);

    List<AbstractMessage> actualRequests = mockMapsPlatformDatasets.getRequests();
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
    mockMapsPlatformDatasets.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
