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

package com.google.shopping.css.v1;

import static com.google.shopping.css.v1.AccountLabelsServiceClient.ListAccountLabelsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
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
public class AccountLabelsServiceClientTest {
  private static MockAccountLabelsService mockAccountLabelsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AccountLabelsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAccountLabelsService = new MockAccountLabelsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAccountLabelsService));
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
    AccountLabelsServiceSettings settings =
        AccountLabelsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccountLabelsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAccountLabelsTest() throws Exception {
    AccountLabel responsesElement = AccountLabel.newBuilder().build();
    ListAccountLabelsResponse expectedResponse =
        ListAccountLabelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountLabels(Arrays.asList(responsesElement))
            .build();
    mockAccountLabelsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListAccountLabelsPagedResponse pagedListResponse = client.listAccountLabels(parent);

    List<AccountLabel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountLabelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountLabelsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountLabelsRequest actualRequest = ((ListAccountLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccountLabelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountLabelsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listAccountLabels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountLabelsTest2() throws Exception {
    AccountLabel responsesElement = AccountLabel.newBuilder().build();
    ListAccountLabelsResponse expectedResponse =
        ListAccountLabelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountLabels(Arrays.asList(responsesElement))
            .build();
    mockAccountLabelsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAccountLabelsPagedResponse pagedListResponse = client.listAccountLabels(parent);

    List<AccountLabel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountLabelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountLabelsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountLabelsRequest actualRequest = ((ListAccountLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccountLabelsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountLabelsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAccountLabels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAccountLabelTest() throws Exception {
    AccountLabel expectedResponse =
        AccountLabel.newBuilder()
            .setName(AccountLabelName.of("[ACCOUNT]", "[LABEL]").toString())
            .setLabelId(-1959256506)
            .setAccountId(-803333011)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockAccountLabelsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    AccountLabel accountLabel = AccountLabel.newBuilder().build();

    AccountLabel actualResponse = client.createAccountLabel(parent, accountLabel);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountLabelsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAccountLabelRequest actualRequest = ((CreateAccountLabelRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(accountLabel, actualRequest.getAccountLabel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAccountLabelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountLabelsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      AccountLabel accountLabel = AccountLabel.newBuilder().build();
      client.createAccountLabel(parent, accountLabel);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAccountLabelTest2() throws Exception {
    AccountLabel expectedResponse =
        AccountLabel.newBuilder()
            .setName(AccountLabelName.of("[ACCOUNT]", "[LABEL]").toString())
            .setLabelId(-1959256506)
            .setAccountId(-803333011)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockAccountLabelsService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    AccountLabel accountLabel = AccountLabel.newBuilder().build();

    AccountLabel actualResponse = client.createAccountLabel(parent, accountLabel);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountLabelsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAccountLabelRequest actualRequest = ((CreateAccountLabelRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(accountLabel, actualRequest.getAccountLabel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAccountLabelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountLabelsService.addException(exception);

    try {
      String parent = "parent-995424086";
      AccountLabel accountLabel = AccountLabel.newBuilder().build();
      client.createAccountLabel(parent, accountLabel);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAccountLabelTest() throws Exception {
    AccountLabel expectedResponse =
        AccountLabel.newBuilder()
            .setName(AccountLabelName.of("[ACCOUNT]", "[LABEL]").toString())
            .setLabelId(-1959256506)
            .setAccountId(-803333011)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockAccountLabelsService.addResponse(expectedResponse);

    AccountLabel accountLabel = AccountLabel.newBuilder().build();

    AccountLabel actualResponse = client.updateAccountLabel(accountLabel);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountLabelsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAccountLabelRequest actualRequest = ((UpdateAccountLabelRequest) actualRequests.get(0));

    Assert.assertEquals(accountLabel, actualRequest.getAccountLabel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAccountLabelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountLabelsService.addException(exception);

    try {
      AccountLabel accountLabel = AccountLabel.newBuilder().build();
      client.updateAccountLabel(accountLabel);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAccountLabelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAccountLabelsService.addResponse(expectedResponse);

    AccountLabelName name = AccountLabelName.of("[ACCOUNT]", "[LABEL]");

    client.deleteAccountLabel(name);

    List<AbstractMessage> actualRequests = mockAccountLabelsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAccountLabelRequest actualRequest = ((DeleteAccountLabelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAccountLabelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountLabelsService.addException(exception);

    try {
      AccountLabelName name = AccountLabelName.of("[ACCOUNT]", "[LABEL]");
      client.deleteAccountLabel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAccountLabelTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAccountLabelsService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAccountLabel(name);

    List<AbstractMessage> actualRequests = mockAccountLabelsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAccountLabelRequest actualRequest = ((DeleteAccountLabelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAccountLabelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountLabelsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAccountLabel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
