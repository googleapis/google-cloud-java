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
import com.google.cloud.sql.v1.stub.HttpJsonSqlSslCertsServiceStub;
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
public class SqlSslCertsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SqlSslCertsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSqlSslCertsServiceStub.getMethodDescriptors(),
            SqlSslCertsServiceSettings.getDefaultEndpoint());
    SqlSslCertsServiceSettings settings =
        SqlSslCertsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SqlSslCertsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SqlSslCertsServiceClient.create(settings);
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

    SqlSslCertsDeleteRequest request =
        SqlSslCertsDeleteRequest.newBuilder()
            .setInstance("instance-7525")
            .setProject("project-6911")
            .setSha1Fingerprint("sha1Fingerprint-7419")
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
      SqlSslCertsDeleteRequest request =
          SqlSslCertsDeleteRequest.newBuilder()
              .setInstance("instance-7525")
              .setProject("project-6911")
              .setSha1Fingerprint("sha1Fingerprint-7419")
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
    mockService.addResponse(expectedResponse);

    SqlSslCertsGetRequest request =
        SqlSslCertsGetRequest.newBuilder()
            .setInstance("instance-7525")
            .setProject("project-6911")
            .setSha1Fingerprint("sha1Fingerprint-7419")
            .build();

    SslCert actualResponse = client.get(request);
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
      SqlSslCertsGetRequest request =
          SqlSslCertsGetRequest.newBuilder()
              .setInstance("instance-7525")
              .setProject("project-6911")
              .setSha1Fingerprint("sha1Fingerprint-7419")
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
    mockService.addResponse(expectedResponse);

    SqlSslCertsInsertRequest request =
        SqlSslCertsInsertRequest.newBuilder()
            .setInstance("instance-7525")
            .setProject("project-6911")
            .setBody(SslCertsInsertRequest.newBuilder().build())
            .build();

    SslCertsInsertResponse actualResponse = client.insert(request);
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
      SqlSslCertsInsertRequest request =
          SqlSslCertsInsertRequest.newBuilder()
              .setInstance("instance-7525")
              .setProject("project-6911")
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
    mockService.addResponse(expectedResponse);

    SqlSslCertsListRequest request =
        SqlSslCertsListRequest.newBuilder()
            .setInstance("instance-7525")
            .setProject("project-6911")
            .build();

    SslCertsListResponse actualResponse = client.list(request);
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
      SqlSslCertsListRequest request =
          SqlSslCertsListRequest.newBuilder()
              .setInstance("instance-7525")
              .setProject("project-6911")
              .build();
      client.list(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
