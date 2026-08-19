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
import com.google.cloud.sql.v1.stub.HttpJsonSqlConnectServiceStub;
import com.google.protobuf.Duration;
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
public class SqlConnectServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SqlConnectServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSqlConnectServiceStub.getMethodDescriptors(),
            SqlConnectServiceSettings.getDefaultEndpoint());
    SqlConnectServiceSettings settings =
        SqlConnectServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SqlConnectServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SqlConnectServiceClient.create(settings);
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
  public void getConnectSettingsTest() throws Exception {
    ConnectSettings expectedResponse =
        ConnectSettings.newBuilder()
            .setKind("kind3292052")
            .setServerCaCert(SslCert.newBuilder().build())
            .addAllIpAddresses(new ArrayList<IpMapping>())
            .setRegion("region-934795532")
            .setDatabaseVersion(SqlDatabaseVersion.forNumber(0))
            .setBackendType(SqlBackendType.forNumber(0))
            .setPscEnabled(true)
            .setDnsName("dnsName1813886804")
            .addAllCustomSubjectAlternativeNames(new ArrayList<String>())
            .addAllDnsNames(new ArrayList<DnsNameMapping>())
            .setNodeCount(1539922066)
            .addAllNodes(new ArrayList<ConnectSettings.ConnectPoolNodeConfig>())
            .addAllMdxProtocolSupport(new ArrayList<ConnectSettings.MdxProtocolSupport>())
            .setConnectionName("connectionName1270009481")
            .build();
    mockService.addResponse(expectedResponse);

    GetConnectSettingsRequest request =
        GetConnectSettingsRequest.newBuilder()
            .setInstance("instance-7525")
            .setProject("project-6911")
            .setReadTime(Timestamp.newBuilder().build())
            .build();

    ConnectSettings actualResponse = client.getConnectSettings(request);
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
  public void getConnectSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetConnectSettingsRequest request =
          GetConnectSettingsRequest.newBuilder()
              .setInstance("instance-7525")
              .setProject("project-6911")
              .setReadTime(Timestamp.newBuilder().build())
              .build();
      client.getConnectSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resolveConnectSettingsTest() throws Exception {
    ConnectSettings expectedResponse =
        ConnectSettings.newBuilder()
            .setKind("kind3292052")
            .setServerCaCert(SslCert.newBuilder().build())
            .addAllIpAddresses(new ArrayList<IpMapping>())
            .setRegion("region-934795532")
            .setDatabaseVersion(SqlDatabaseVersion.forNumber(0))
            .setBackendType(SqlBackendType.forNumber(0))
            .setPscEnabled(true)
            .setDnsName("dnsName1813886804")
            .addAllCustomSubjectAlternativeNames(new ArrayList<String>())
            .addAllDnsNames(new ArrayList<DnsNameMapping>())
            .setNodeCount(1539922066)
            .addAllNodes(new ArrayList<ConnectSettings.ConnectPoolNodeConfig>())
            .addAllMdxProtocolSupport(new ArrayList<ConnectSettings.MdxProtocolSupport>())
            .setConnectionName("connectionName1270009481")
            .build();
    mockService.addResponse(expectedResponse);

    ResolveConnectSettingsRequest request =
        ResolveConnectSettingsRequest.newBuilder()
            .setDnsName("dnsName-6118")
            .setLocation("location-9355")
            .build();

    ConnectSettings actualResponse = client.resolveConnectSettings(request);
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
  public void resolveConnectSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResolveConnectSettingsRequest request =
          ResolveConnectSettingsRequest.newBuilder()
              .setDnsName("dnsName-6118")
              .setLocation("location-9355")
              .build();
      client.resolveConnectSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateEphemeralCertTest() throws Exception {
    GenerateEphemeralCertResponse expectedResponse =
        GenerateEphemeralCertResponse.newBuilder()
            .setEphemeralCert(SslCert.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GenerateEphemeralCertRequest request =
        GenerateEphemeralCertRequest.newBuilder()
            .setInstance("instance-7525")
            .setProject("project-6911")
            .setPublicKey("publicKey1446899510")
            .setAccessToken("accessToken-1042689291")
            .setReadTime(Timestamp.newBuilder().build())
            .setValidDuration(Duration.newBuilder().build())
            .build();

    GenerateEphemeralCertResponse actualResponse = client.generateEphemeralCert(request);
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
  public void generateEphemeralCertExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerateEphemeralCertRequest request =
          GenerateEphemeralCertRequest.newBuilder()
              .setInstance("instance-7525")
              .setProject("project-6911")
              .setPublicKey("publicKey1446899510")
              .setAccessToken("accessToken-1042689291")
              .setReadTime(Timestamp.newBuilder().build())
              .setValidDuration(Duration.newBuilder().build())
              .build();
      client.generateEphemeralCert(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
