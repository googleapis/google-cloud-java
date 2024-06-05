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

package com.google.shopping.merchant.datasources.v1beta;

import static com.google.shopping.merchant.datasources.v1beta.DataSourcesServiceClient.ListDataSourcesPagedResponse;

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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class DataSourcesServiceClientTest {
  private static MockDataSourcesService mockDataSourcesService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataSourcesServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataSourcesService = new MockDataSourcesService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDataSourcesService));
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
    DataSourcesServiceSettings settings =
        DataSourcesServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataSourcesServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getDataSourceTest() throws Exception {
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
            .setDataSourceId(-1015796374)
            .setDisplayName("displayName1714148973")
            .setFileInput(FileInput.newBuilder().build())
            .build();
    mockDataSourcesService.addResponse(expectedResponse);

    DataSourceName name = DataSourceName.of("[ACCOUNT]", "[DATASOURCE]");

    DataSource actualResponse = client.getDataSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataSourceRequest actualRequest = ((GetDataSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSourcesService.addException(exception);

    try {
      DataSourceName name = DataSourceName.of("[ACCOUNT]", "[DATASOURCE]");
      client.getDataSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataSourceTest2() throws Exception {
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
            .setDataSourceId(-1015796374)
            .setDisplayName("displayName1714148973")
            .setFileInput(FileInput.newBuilder().build())
            .build();
    mockDataSourcesService.addResponse(expectedResponse);

    String name = "name3373707";

    DataSource actualResponse = client.getDataSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataSourceRequest actualRequest = ((GetDataSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataSourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSourcesService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataSourcesTest() throws Exception {
    DataSource responsesElement = DataSource.newBuilder().build();
    ListDataSourcesResponse expectedResponse =
        ListDataSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataSources(Arrays.asList(responsesElement))
            .build();
    mockDataSourcesService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListDataSourcesPagedResponse pagedListResponse = client.listDataSources(parent);

    List<DataSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataSourcesRequest actualRequest = ((ListDataSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataSourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSourcesService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listDataSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataSourcesTest2() throws Exception {
    DataSource responsesElement = DataSource.newBuilder().build();
    ListDataSourcesResponse expectedResponse =
        ListDataSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataSources(Arrays.asList(responsesElement))
            .build();
    mockDataSourcesService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataSourcesPagedResponse pagedListResponse = client.listDataSources(parent);

    List<DataSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataSourcesRequest actualRequest = ((ListDataSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataSourcesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSourcesService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataSourceTest() throws Exception {
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
            .setDataSourceId(-1015796374)
            .setDisplayName("displayName1714148973")
            .setFileInput(FileInput.newBuilder().build())
            .build();
    mockDataSourcesService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    DataSource dataSource = DataSource.newBuilder().build();

    DataSource actualResponse = client.createDataSource(parent, dataSource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataSourceRequest actualRequest = ((CreateDataSourceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataSource, actualRequest.getDataSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSourcesService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      DataSource dataSource = DataSource.newBuilder().build();
      client.createDataSource(parent, dataSource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataSourceTest2() throws Exception {
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
            .setDataSourceId(-1015796374)
            .setDisplayName("displayName1714148973")
            .setFileInput(FileInput.newBuilder().build())
            .build();
    mockDataSourcesService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DataSource dataSource = DataSource.newBuilder().build();

    DataSource actualResponse = client.createDataSource(parent, dataSource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataSourceRequest actualRequest = ((CreateDataSourceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataSource, actualRequest.getDataSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataSourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSourcesService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataSource dataSource = DataSource.newBuilder().build();
      client.createDataSource(parent, dataSource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataSourceTest() throws Exception {
    DataSource expectedResponse =
        DataSource.newBuilder()
            .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
            .setDataSourceId(-1015796374)
            .setDisplayName("displayName1714148973")
            .setFileInput(FileInput.newBuilder().build())
            .build();
    mockDataSourcesService.addResponse(expectedResponse);

    DataSource dataSource = DataSource.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataSource actualResponse = client.updateDataSource(dataSource, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataSourceRequest actualRequest = ((UpdateDataSourceRequest) actualRequests.get(0));

    Assert.assertEquals(dataSource, actualRequest.getDataSource());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSourcesService.addException(exception);

    try {
      DataSource dataSource = DataSource.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataSource(dataSource, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataSourceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataSourcesService.addResponse(expectedResponse);

    DataSourceName name = DataSourceName.of("[ACCOUNT]", "[DATASOURCE]");

    client.deleteDataSource(name);

    List<AbstractMessage> actualRequests = mockDataSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataSourceRequest actualRequest = ((DeleteDataSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSourcesService.addException(exception);

    try {
      DataSourceName name = DataSourceName.of("[ACCOUNT]", "[DATASOURCE]");
      client.deleteDataSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataSourceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataSourcesService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDataSource(name);

    List<AbstractMessage> actualRequests = mockDataSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataSourceRequest actualRequest = ((DeleteDataSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataSourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSourcesService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchDataSourceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataSourcesService.addResponse(expectedResponse);

    FetchDataSourceRequest request =
        FetchDataSourceRequest.newBuilder()
            .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
            .build();

    client.fetchDataSource(request);

    List<AbstractMessage> actualRequests = mockDataSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchDataSourceRequest actualRequest = ((FetchDataSourceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchDataSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataSourcesService.addException(exception);

    try {
      FetchDataSourceRequest request =
          FetchDataSourceRequest.newBuilder()
              .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
              .build();
      client.fetchDataSource(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
