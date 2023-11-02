/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SiteSearchEngineServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockSiteSearchEngineService mockSiteSearchEngineService;
  private LocalChannelProvider channelProvider;
  private SiteSearchEngineServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSiteSearchEngineService = new MockSiteSearchEngineService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSiteSearchEngineService, mockLocations));
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
    SiteSearchEngineServiceSettings settings =
        SiteSearchEngineServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SiteSearchEngineServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void recrawlUrisTest() throws Exception {
    RecrawlUrisResponse expectedResponse =
        RecrawlUrisResponse.newBuilder()
            .addAllFailureSamples(new ArrayList<RecrawlUrisResponse.FailureInfo>())
            .addAllFailedUris(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("recrawlUrisTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSiteSearchEngineService.addResponse(resultOperation);

    RecrawlUrisRequest request =
        RecrawlUrisRequest.newBuilder()
            .setSiteSearchEngine(
                SiteSearchEngineName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .addAllUris(new ArrayList<String>())
            .build();

    RecrawlUrisResponse actualResponse = client.recrawlUrisAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSiteSearchEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RecrawlUrisRequest actualRequest = ((RecrawlUrisRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSiteSearchEngine(), actualRequest.getSiteSearchEngine());
    Assert.assertEquals(request.getUrisList(), actualRequest.getUrisList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void recrawlUrisExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSiteSearchEngineService.addException(exception);

    try {
      RecrawlUrisRequest request =
          RecrawlUrisRequest.newBuilder()
              .setSiteSearchEngine(
                  SiteSearchEngineName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .addAllUris(new ArrayList<String>())
              .build();
      client.recrawlUrisAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
