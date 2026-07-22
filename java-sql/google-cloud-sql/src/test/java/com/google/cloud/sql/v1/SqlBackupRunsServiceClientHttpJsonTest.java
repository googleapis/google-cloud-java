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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.sql.v1.stub.HttpJsonSqlBackupRunsServiceStub;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SqlBackupRunsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SqlBackupRunsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSqlBackupRunsServiceStub.getMethodDescriptors(),
            SqlBackupRunsServiceSettings.getDefaultEndpoint());
    SqlBackupRunsServiceSettings settings =
        SqlBackupRunsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SqlBackupRunsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SqlBackupRunsServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
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
    mockService.addResponse(expectedResponse);

    SqlBackupRunsDeleteRequest request =
        SqlBackupRunsDeleteRequest.newBuilder()
            .setId(3355)
            .setInstance("instance-7525")
            .setProject("project-6911")
            .build();

    Operation actualResponse = client.delete(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SqlBackupRunsDeleteRequest request =
          SqlBackupRunsDeleteRequest.newBuilder()
              .setId(3355)
              .setInstance("instance-7525")
              .setProject("project-6911")
              .build();
      client.delete(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTest() throws Exception {
    BackupRun expectedResponse =
        BackupRun.newBuilder()
            .setKind("kind3292052")
            .setStatus(SqlBackupRunStatus.forNumber(0))
            .setEnqueuedTime(Timestamp.newBuilder().build())
            .setId(3355)
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setError(OperationError.newBuilder().build())
            .setType(SqlBackupRunType.forNumber(0))
            .setDescription("description-1724546052")
            .setWindowStartTime(Timestamp.newBuilder().build())
            .setInstance("instance555127957")
            .setSelfLink("selfLink1191800166")
            .setLocation("location1901043637")
            .setDatabaseVersion(SqlDatabaseVersion.forNumber(0))
            .setDiskEncryptionConfiguration(DiskEncryptionConfiguration.newBuilder().build())
            .setDiskEncryptionStatus(DiskEncryptionStatus.newBuilder().build())
            .setBackupKind(SqlBackupKind.forNumber(0))
            .setTimeZone("timeZone-2077180903")
            .setMaxChargeableBytes(-1424371595)
            .build();
    mockService.addResponse(expectedResponse);

    SqlBackupRunsGetRequest request =
        SqlBackupRunsGetRequest.newBuilder()
            .setId(3355)
            .setInstance("instance-7525")
            .setProject("project-6911")
            .build();

    BackupRun actualResponse = client.get(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SqlBackupRunsGetRequest request =
          SqlBackupRunsGetRequest.newBuilder()
              .setId(3355)
              .setInstance("instance-7525")
              .setProject("project-6911")
              .build();
      client.get(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void insertTest() throws Exception {
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
    mockService.addResponse(expectedResponse);

    SqlBackupRunsInsertRequest request =
        SqlBackupRunsInsertRequest.newBuilder()
            .setInstance("instance-7525")
            .setProject("project-6911")
            .setBody(BackupRun.newBuilder().build())
            .build();

    Operation actualResponse = client.insert(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void insertExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SqlBackupRunsInsertRequest request =
          SqlBackupRunsInsertRequest.newBuilder()
              .setInstance("instance-7525")
              .setProject("project-6911")
              .setBody(BackupRun.newBuilder().build())
              .build();
      client.insert(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTest() throws Exception {
    BackupRunsListResponse expectedResponse =
        BackupRunsListResponse.newBuilder()
            .setKind("kind3292052")
            .addAllItems(new ArrayList<BackupRun>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    mockService.addResponse(expectedResponse);

    SqlBackupRunsListRequest request =
        SqlBackupRunsListRequest.newBuilder()
            .setInstance("instance-7525")
            .setMaxResults(1128457243)
            .setPageToken("pageToken873572522")
            .setProject("project-6911")
            .build();

    BackupRunsListResponse actualResponse = client.list(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SqlBackupRunsListRequest request =
          SqlBackupRunsListRequest.newBuilder()
              .setInstance("instance-7525")
              .setMaxResults(1128457243)
              .setPageToken("pageToken873572522")
              .setProject("project-6911")
              .build();
      client.list(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
