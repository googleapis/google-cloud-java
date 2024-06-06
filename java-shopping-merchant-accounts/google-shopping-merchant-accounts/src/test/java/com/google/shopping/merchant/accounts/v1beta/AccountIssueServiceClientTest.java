/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.accounts.v1beta;

import static com.google.shopping.merchant.accounts.v1beta.AccountIssueServiceClient.ListAccountIssuesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
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
public class AccountIssueServiceClientTest {
  private static MockAccountIssueService mockAccountIssueService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AccountIssueServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAccountIssueService = new MockAccountIssueService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAccountIssueService));
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
    AccountIssueServiceSettings settings =
        AccountIssueServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccountIssueServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAccountIssuesTest() throws Exception {
    AccountIssue responsesElement = AccountIssue.newBuilder().build();
    ListAccountIssuesResponse expectedResponse =
        ListAccountIssuesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountIssues(Arrays.asList(responsesElement))
            .build();
    mockAccountIssueService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListAccountIssuesPagedResponse pagedListResponse = client.listAccountIssues(parent);

    List<AccountIssue> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountIssuesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountIssueService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountIssuesRequest actualRequest = ((ListAccountIssuesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccountIssuesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountIssueService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listAccountIssues(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountIssuesTest2() throws Exception {
    AccountIssue responsesElement = AccountIssue.newBuilder().build();
    ListAccountIssuesResponse expectedResponse =
        ListAccountIssuesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountIssues(Arrays.asList(responsesElement))
            .build();
    mockAccountIssueService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAccountIssuesPagedResponse pagedListResponse = client.listAccountIssues(parent);

    List<AccountIssue> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountIssuesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountIssueService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountIssuesRequest actualRequest = ((ListAccountIssuesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccountIssuesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountIssueService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAccountIssues(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
