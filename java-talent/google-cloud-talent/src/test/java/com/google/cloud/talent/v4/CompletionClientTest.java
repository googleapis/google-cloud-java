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
package com.google.cloud.talent.v4;

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
public class CompletionClientTest {
  private static MockCompanyService mockCompanyService;
  private static MockCompletion mockCompletion;
  private static MockEventService mockEventService;
  private static MockJobService mockJobService;
  private static MockTenantService mockTenantService;
  private static MockServiceHelper serviceHelper;
  private CompletionClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCompanyService = new MockCompanyService();
    mockCompletion = new MockCompletion();
    mockEventService = new MockEventService();
    mockJobService = new MockJobService();
    mockTenantService = new MockTenantService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockCompanyService,
                mockCompletion,
                mockEventService,
                mockJobService,
                mockTenantService));
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
    CompletionSettings settings =
        CompletionSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CompletionClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void completeQueryTest() {
    CompleteQueryResponse expectedResponse = CompleteQueryResponse.newBuilder().build();
    mockCompletion.addResponse(expectedResponse);

    TenantName tenant = TenantName.of("[PROJECT]", "[TENANT]");
    String query = "query107944136";
    int pageSize = 883849137;
    CompleteQueryRequest request =
        CompleteQueryRequest.newBuilder()
            .setTenant(tenant.toString())
            .setQuery(query)
            .setPageSize(pageSize)
            .build();

    CompleteQueryResponse actualResponse = client.completeQuery(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompletion.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CompleteQueryRequest actualRequest = (CompleteQueryRequest) actualRequests.get(0);

    Assert.assertEquals(tenant, TenantName.parse(actualRequest.getTenant()));
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertEquals(pageSize, actualRequest.getPageSize());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void completeQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCompletion.addException(exception);

    try {
      TenantName tenant = TenantName.of("[PROJECT]", "[TENANT]");
      String query = "query107944136";
      int pageSize = 883849137;
      CompleteQueryRequest request =
          CompleteQueryRequest.newBuilder()
              .setTenant(tenant.toString())
              .setQuery(query)
              .setPageSize(pageSize)
              .build();

      client.completeQuery(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
