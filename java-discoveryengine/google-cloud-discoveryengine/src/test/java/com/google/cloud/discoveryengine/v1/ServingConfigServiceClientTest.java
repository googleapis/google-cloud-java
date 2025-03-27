/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.discoveryengine.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
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
public class ServingConfigServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockServingConfigService mockServingConfigService;
  private LocalChannelProvider channelProvider;
  private ServingConfigServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockServingConfigService = new MockServingConfigService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockServingConfigService, mockLocations));
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
    ServingConfigServiceSettings settings =
        ServingConfigServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ServingConfigServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void updateServingConfigTest() throws Exception {
    ServingConfig expectedResponse =
        ServingConfig.newBuilder()
            .setName(
                ServingConfigName.ofProjectLocationDataStoreServingConfigName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setSolutionType(SolutionType.forNumber(0))
            .setModelId("modelId1226956324")
            .setDiversityLevel("diversityLevel578206123")
            .setRankingExpression("rankingExpression2110320494")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllFilterControlIds(new ArrayList<String>())
            .addAllBoostControlIds(new ArrayList<String>())
            .addAllRedirectControlIds(new ArrayList<String>())
            .addAllSynonymsControlIds(new ArrayList<String>())
            .addAllOnewaySynonymsControlIds(new ArrayList<String>())
            .addAllDissociateControlIds(new ArrayList<String>())
            .addAllReplacementControlIds(new ArrayList<String>())
            .addAllIgnoreControlIds(new ArrayList<String>())
            .addAllPromoteControlIds(new ArrayList<String>())
            .build();
    mockServingConfigService.addResponse(expectedResponse);

    ServingConfig servingConfig = ServingConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ServingConfig actualResponse = client.updateServingConfig(servingConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServingConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateServingConfigRequest actualRequest = ((UpdateServingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(servingConfig, actualRequest.getServingConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateServingConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServingConfigService.addException(exception);

    try {
      ServingConfig servingConfig = ServingConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateServingConfig(servingConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
