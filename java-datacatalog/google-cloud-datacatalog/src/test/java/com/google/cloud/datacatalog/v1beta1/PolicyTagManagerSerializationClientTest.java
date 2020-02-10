/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.datacatalog.v1beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class PolicyTagManagerSerializationClientTest {
  private static MockDataCatalog mockDataCatalog;
  private static MockPolicyTagManager mockPolicyTagManager;
  private static MockPolicyTagManagerSerialization mockPolicyTagManagerSerialization;
  private static MockServiceHelper serviceHelper;
  private PolicyTagManagerSerializationClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDataCatalog = new MockDataCatalog();
    mockPolicyTagManager = new MockPolicyTagManager();
    mockPolicyTagManagerSerialization = new MockPolicyTagManagerSerialization();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockDataCatalog, mockPolicyTagManager, mockPolicyTagManagerSerialization));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    PolicyTagManagerSerializationSettings settings =
        PolicyTagManagerSerializationSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PolicyTagManagerSerializationClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void importTaxonomiesTest() {
    ImportTaxonomiesResponse expectedResponse = ImportTaxonomiesResponse.newBuilder().build();
    mockPolicyTagManagerSerialization.addResponse(expectedResponse);

    ImportTaxonomiesRequest request = ImportTaxonomiesRequest.newBuilder().build();

    ImportTaxonomiesResponse actualResponse = client.importTaxonomies(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManagerSerialization.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportTaxonomiesRequest actualRequest = (ImportTaxonomiesRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void importTaxonomiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPolicyTagManagerSerialization.addException(exception);

    try {
      ImportTaxonomiesRequest request = ImportTaxonomiesRequest.newBuilder().build();

      client.importTaxonomies(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void exportTaxonomiesTest() {
    ExportTaxonomiesResponse expectedResponse = ExportTaxonomiesResponse.newBuilder().build();
    mockPolicyTagManagerSerialization.addResponse(expectedResponse);

    ExportTaxonomiesRequest request = ExportTaxonomiesRequest.newBuilder().build();

    ExportTaxonomiesResponse actualResponse = client.exportTaxonomies(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyTagManagerSerialization.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportTaxonomiesRequest actualRequest = (ExportTaxonomiesRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void exportTaxonomiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPolicyTagManagerSerialization.addException(exception);

    try {
      ExportTaxonomiesRequest request = ExportTaxonomiesRequest.newBuilder().build();

      client.exportTaxonomies(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
