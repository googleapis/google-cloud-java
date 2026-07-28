/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.chronicle.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
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
public class BigQueryExportServiceClientTest {
  private static MockBigQueryExportService mockBigQueryExportService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private BigQueryExportServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBigQueryExportService = new MockBigQueryExportService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockBigQueryExportService));
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
    BigQueryExportServiceSettings settings =
        BigQueryExportServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BigQueryExportServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getBigQueryExportTest() throws Exception {
    BigQueryExport expectedResponse =
        BigQueryExport.newBuilder()
            .setName(BigQueryExportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setProvisioned(true)
            .setBigQueryExportPackage(BigQueryExportPackage.forNumber(0))
            .setEntityGraphSettings(DataSourceExportSettings.newBuilder().build())
            .setIocMatchesSettings(DataSourceExportSettings.newBuilder().build())
            .setRuleDetectionsSettings(DataSourceExportSettings.newBuilder().build())
            .setUdmEventsAggregatesSettings(DataSourceExportSettings.newBuilder().build())
            .setUdmEventsSettings(DataSourceExportSettings.newBuilder().build())
            .build();
    mockBigQueryExportService.addResponse(expectedResponse);

    BigQueryExportName name = BigQueryExportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    BigQueryExport actualResponse = client.getBigQueryExport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryExportService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBigQueryExportRequest actualRequest = ((GetBigQueryExportRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBigQueryExportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryExportService.addException(exception);

    try {
      BigQueryExportName name = BigQueryExportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.getBigQueryExport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBigQueryExportTest2() throws Exception {
    BigQueryExport expectedResponse =
        BigQueryExport.newBuilder()
            .setName(BigQueryExportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setProvisioned(true)
            .setBigQueryExportPackage(BigQueryExportPackage.forNumber(0))
            .setEntityGraphSettings(DataSourceExportSettings.newBuilder().build())
            .setIocMatchesSettings(DataSourceExportSettings.newBuilder().build())
            .setRuleDetectionsSettings(DataSourceExportSettings.newBuilder().build())
            .setUdmEventsAggregatesSettings(DataSourceExportSettings.newBuilder().build())
            .setUdmEventsSettings(DataSourceExportSettings.newBuilder().build())
            .build();
    mockBigQueryExportService.addResponse(expectedResponse);

    String name = "name3373707";

    BigQueryExport actualResponse = client.getBigQueryExport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryExportService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBigQueryExportRequest actualRequest = ((GetBigQueryExportRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBigQueryExportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryExportService.addException(exception);

    try {
      String name = "name3373707";
      client.getBigQueryExport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBigQueryExportTest() throws Exception {
    BigQueryExport expectedResponse =
        BigQueryExport.newBuilder()
            .setName(BigQueryExportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setProvisioned(true)
            .setBigQueryExportPackage(BigQueryExportPackage.forNumber(0))
            .setEntityGraphSettings(DataSourceExportSettings.newBuilder().build())
            .setIocMatchesSettings(DataSourceExportSettings.newBuilder().build())
            .setRuleDetectionsSettings(DataSourceExportSettings.newBuilder().build())
            .setUdmEventsAggregatesSettings(DataSourceExportSettings.newBuilder().build())
            .setUdmEventsSettings(DataSourceExportSettings.newBuilder().build())
            .build();
    mockBigQueryExportService.addResponse(expectedResponse);

    BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BigQueryExport actualResponse = client.updateBigQueryExport(bigQueryExport, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryExportService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBigQueryExportRequest actualRequest =
        ((UpdateBigQueryExportRequest) actualRequests.get(0));

    Assert.assertEquals(bigQueryExport, actualRequest.getBigQueryExport());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBigQueryExportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryExportService.addException(exception);

    try {
      BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBigQueryExport(bigQueryExport, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void provisionBigQueryExportTest() throws Exception {
    BigQueryExport expectedResponse =
        BigQueryExport.newBuilder()
            .setName(BigQueryExportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setProvisioned(true)
            .setBigQueryExportPackage(BigQueryExportPackage.forNumber(0))
            .setEntityGraphSettings(DataSourceExportSettings.newBuilder().build())
            .setIocMatchesSettings(DataSourceExportSettings.newBuilder().build())
            .setRuleDetectionsSettings(DataSourceExportSettings.newBuilder().build())
            .setUdmEventsAggregatesSettings(DataSourceExportSettings.newBuilder().build())
            .setUdmEventsSettings(DataSourceExportSettings.newBuilder().build())
            .build();
    mockBigQueryExportService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    BigQueryExport actualResponse = client.provisionBigQueryExport(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryExportService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ProvisionBigQueryExportRequest actualRequest =
        ((ProvisionBigQueryExportRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void provisionBigQueryExportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryExportService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.provisionBigQueryExport(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void provisionBigQueryExportTest2() throws Exception {
    BigQueryExport expectedResponse =
        BigQueryExport.newBuilder()
            .setName(BigQueryExportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setProvisioned(true)
            .setBigQueryExportPackage(BigQueryExportPackage.forNumber(0))
            .setEntityGraphSettings(DataSourceExportSettings.newBuilder().build())
            .setIocMatchesSettings(DataSourceExportSettings.newBuilder().build())
            .setRuleDetectionsSettings(DataSourceExportSettings.newBuilder().build())
            .setUdmEventsAggregatesSettings(DataSourceExportSettings.newBuilder().build())
            .setUdmEventsSettings(DataSourceExportSettings.newBuilder().build())
            .build();
    mockBigQueryExportService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    BigQueryExport actualResponse = client.provisionBigQueryExport(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryExportService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ProvisionBigQueryExportRequest actualRequest =
        ((ProvisionBigQueryExportRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void provisionBigQueryExportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryExportService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.provisionBigQueryExport(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
