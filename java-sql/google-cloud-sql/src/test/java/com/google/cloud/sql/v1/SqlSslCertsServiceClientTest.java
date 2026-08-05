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

package com.google.cloud.sql.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
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
public class SqlSslCertsServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockSqlSslCertsService mockSqlSslCertsService;
  private LocalChannelProvider channelProvider;
  private SqlSslCertsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSqlSslCertsService = new MockSqlSslCertsService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSqlSslCertsService, mockLocations));
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
    SqlSslCertsServiceSettings settings =
        SqlSslCertsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SqlSslCertsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void deleteTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setKind("kind3292052")
            .setTargetLink("targetLink486368555")
            .setUser("user3599307")
            .setInsertTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setError(OperationErrors.newBuilder().build())
            .setApiWarning(ApiWarning.newBuilder().build())
            .setImportContext(ImportContext.newBuilder().build())
            .setExportContext(ExportContext.newBuilder().build())
            .setBackupContext(BackupContext.newBuilder().build())
            .setPreCheckMajorVersionUpgradeContext(
                PreCheckMajorVersionUpgradeContext.newBuilder().build())
            .setName("name3373707")
            .setTargetId("targetId-441951604")
            .setSelfLink("selfLink1191800166")
            .setTargetProject("targetProject1994636360")
            .setAcquireSsrsLeaseContext(AcquireSsrsLeaseContext.newBuilder().build())
            .setSubOperationType(SqlSubOperationType.newBuilder().build())
            .build();
    mockSqlSslCertsService.addResponse(expectedResponse);

    SqlSslCertsDeleteRequest request =
        SqlSslCertsDeleteRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setSha1Fingerprint("sha1Fingerprint163009183")
            .build();

    Operation actualResponse = client.delete(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlSslCertsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlSslCertsDeleteRequest actualRequest = ((SqlSslCertsDeleteRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getSha1Fingerprint(), actualRequest.getSha1Fingerprint());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlSslCertsService.addException(exception);

    try {
      SqlSslCertsDeleteRequest request =
          SqlSslCertsDeleteRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setSha1Fingerprint("sha1Fingerprint163009183")
              .build();
      client.delete(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTest() throws Exception {
    SslCert expectedResponse =
        SslCert.newBuilder()
            .setKind("kind3292052")
            .setCertSerialNumber("certSerialNumber1709590177")
            .setCert("cert3050020")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCommonName("commonName1184312086")
            .setExpirationTime(Timestamp.newBuilder().build())
            .setSha1Fingerprint("sha1Fingerprint163009183")
            .setInstance("instance555127957")
            .setSelfLink("selfLink1191800166")
            .build();
    mockSqlSslCertsService.addResponse(expectedResponse);

    SqlSslCertsGetRequest request =
        SqlSslCertsGetRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setSha1Fingerprint("sha1Fingerprint163009183")
            .build();

    SslCert actualResponse = client.get(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlSslCertsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlSslCertsGetRequest actualRequest = ((SqlSslCertsGetRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getSha1Fingerprint(), actualRequest.getSha1Fingerprint());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlSslCertsService.addException(exception);

    try {
      SqlSslCertsGetRequest request =
          SqlSslCertsGetRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setSha1Fingerprint("sha1Fingerprint163009183")
              .build();
      client.get(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void insertTest() throws Exception {
    SslCertsInsertResponse expectedResponse =
        SslCertsInsertResponse.newBuilder()
            .setKind("kind3292052")
            .setOperation(Operation.newBuilder().build())
            .setServerCaCert(SslCert.newBuilder().build())
            .setClientCert(SslCertDetail.newBuilder().build())
            .build();
    mockSqlSslCertsService.addResponse(expectedResponse);

    SqlSslCertsInsertRequest request =
        SqlSslCertsInsertRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(SslCertsInsertRequest.newBuilder().build())
            .build();

    SslCertsInsertResponse actualResponse = client.insert(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlSslCertsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlSslCertsInsertRequest actualRequest = ((SqlSslCertsInsertRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void insertExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlSslCertsService.addException(exception);

    try {
      SqlSslCertsInsertRequest request =
          SqlSslCertsInsertRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(SslCertsInsertRequest.newBuilder().build())
              .build();
      client.insert(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTest() throws Exception {
    SslCertsListResponse expectedResponse =
        SslCertsListResponse.newBuilder()
            .setKind("kind3292052")
            .addAllItems(new ArrayList<SslCert>())
            .build();
    mockSqlSslCertsService.addResponse(expectedResponse);

    SqlSslCertsListRequest request =
        SqlSslCertsListRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    SslCertsListResponse actualResponse = client.list(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlSslCertsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlSslCertsListRequest actualRequest = ((SqlSslCertsListRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlSslCertsService.addException(exception);

    try {
      SqlSslCertsListRequest request =
          SqlSslCertsListRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      client.list(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
