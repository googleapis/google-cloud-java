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

package com.google.cloud.sql.v1beta4;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
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
public class SqlConnectServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockSqlConnectService mockSqlConnectService;
  private LocalChannelProvider channelProvider;
  private SqlConnectServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSqlConnectService = new MockSqlConnectService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSqlConnectService, mockLocations));
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
    SqlConnectServiceSettings settings =
        SqlConnectServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SqlConnectServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockSqlConnectService.addResponse(expectedResponse);

    GetConnectSettingsRequest request =
        GetConnectSettingsRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setReadTime(Timestamp.newBuilder().build())
            .build();

    ConnectSettings actualResponse = client.getConnectSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlConnectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConnectSettingsRequest actualRequest = ((GetConnectSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getReadTime(), actualRequest.getReadTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConnectSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlConnectService.addException(exception);

    try {
      GetConnectSettingsRequest request =
          GetConnectSettingsRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
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
    mockSqlConnectService.addResponse(expectedResponse);

    ResolveConnectSettingsRequest request =
        ResolveConnectSettingsRequest.newBuilder()
            .setDnsName("dnsName1813886804")
            .setLocation("location1901043637")
            .build();

    ConnectSettings actualResponse = client.resolveConnectSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlConnectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResolveConnectSettingsRequest actualRequest =
        ((ResolveConnectSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDnsName(), actualRequest.getDnsName());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resolveConnectSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlConnectService.addException(exception);

    try {
      ResolveConnectSettingsRequest request =
          ResolveConnectSettingsRequest.newBuilder()
              .setDnsName("dnsName1813886804")
              .setLocation("location1901043637")
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
    mockSqlConnectService.addResponse(expectedResponse);

    GenerateEphemeralCertRequest request =
        GenerateEphemeralCertRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setPublicKey("publicKey1446899510")
            .setAccessToken("accessToken-1042689291")
            .setReadTime(Timestamp.newBuilder().build())
            .setValidDuration(Duration.newBuilder().build())
            .build();

    GenerateEphemeralCertResponse actualResponse = client.generateEphemeralCert(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlConnectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateEphemeralCertRequest actualRequest =
        ((GenerateEphemeralCertRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getPublicKey(), actualRequest.getPublicKey());
    Assert.assertEquals(request.getAccessToken(), actualRequest.getAccessToken());
    Assert.assertEquals(request.getReadTime(), actualRequest.getReadTime());
    Assert.assertEquals(request.getValidDuration(), actualRequest.getValidDuration());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateEphemeralCertExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlConnectService.addException(exception);

    try {
      GenerateEphemeralCertRequest request =
          GenerateEphemeralCertRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
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
