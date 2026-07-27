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
public class SqlFlagsServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockSqlFlagsService mockSqlFlagsService;
  private LocalChannelProvider channelProvider;
  private SqlFlagsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSqlFlagsService = new MockSqlFlagsService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSqlFlagsService, mockLocations));
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
    SqlFlagsServiceSettings settings =
        SqlFlagsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SqlFlagsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listTest() throws Exception {
    FlagsListResponse expectedResponse =
        FlagsListResponse.newBuilder()
            .setKind("kind3292052")
            .addAllItems(new ArrayList<Flag>())
            .build();
    mockSqlFlagsService.addResponse(expectedResponse);

    SqlFlagsListRequest request =
        SqlFlagsListRequest.newBuilder()
            .setDatabaseVersion("databaseVersion1250955997")
            .setFlagScope(SqlFlagScope.forNumber(0))
            .build();

    FlagsListResponse actualResponse = client.list(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlFlagsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlFlagsListRequest actualRequest = ((SqlFlagsListRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDatabaseVersion(), actualRequest.getDatabaseVersion());
    Assert.assertEquals(request.getFlagScope(), actualRequest.getFlagScope());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlFlagsService.addException(exception);

    try {
      SqlFlagsListRequest request =
          SqlFlagsListRequest.newBuilder()
              .setDatabaseVersion("databaseVersion1250955997")
              .setFlagScope(SqlFlagScope.forNumber(0))
              .build();
      client.list(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
