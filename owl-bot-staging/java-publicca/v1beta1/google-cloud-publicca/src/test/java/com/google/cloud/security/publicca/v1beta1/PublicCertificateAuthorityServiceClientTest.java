/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.security.publicca.v1beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
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
public class PublicCertificateAuthorityServiceClientTest {
  private static MockPublicCertificateAuthorityService mockPublicCertificateAuthorityService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PublicCertificateAuthorityServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPublicCertificateAuthorityService = new MockPublicCertificateAuthorityService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockPublicCertificateAuthorityService));
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
    PublicCertificateAuthorityServiceSettings settings =
        PublicCertificateAuthorityServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PublicCertificateAuthorityServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createExternalAccountKeyTest() throws Exception {
    ExternalAccountKey expectedResponse =
        ExternalAccountKey.newBuilder()
            .setName(
                ExternalAccountKeyName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_ACCOUNT_KEY]")
                    .toString())
            .setKeyId("keyId101944282")
            .setB64MacKey(ByteString.EMPTY)
            .build();
    mockPublicCertificateAuthorityService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ExternalAccountKey externalAccountKey = ExternalAccountKey.newBuilder().build();

    ExternalAccountKey actualResponse = client.createExternalAccountKey(parent, externalAccountKey);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPublicCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExternalAccountKeyRequest actualRequest =
        ((CreateExternalAccountKeyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(externalAccountKey, actualRequest.getExternalAccountKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExternalAccountKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublicCertificateAuthorityService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ExternalAccountKey externalAccountKey = ExternalAccountKey.newBuilder().build();
      client.createExternalAccountKey(parent, externalAccountKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExternalAccountKeyTest2() throws Exception {
    ExternalAccountKey expectedResponse =
        ExternalAccountKey.newBuilder()
            .setName(
                ExternalAccountKeyName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_ACCOUNT_KEY]")
                    .toString())
            .setKeyId("keyId101944282")
            .setB64MacKey(ByteString.EMPTY)
            .build();
    mockPublicCertificateAuthorityService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ExternalAccountKey externalAccountKey = ExternalAccountKey.newBuilder().build();

    ExternalAccountKey actualResponse = client.createExternalAccountKey(parent, externalAccountKey);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPublicCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExternalAccountKeyRequest actualRequest =
        ((CreateExternalAccountKeyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(externalAccountKey, actualRequest.getExternalAccountKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExternalAccountKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPublicCertificateAuthorityService.addException(exception);

    try {
      String parent = "parent-995424086";
      ExternalAccountKey externalAccountKey = ExternalAccountKey.newBuilder().build();
      client.createExternalAccountKey(parent, externalAccountKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
