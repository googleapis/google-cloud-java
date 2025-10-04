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

package com.google.shopping.merchant.accounts.v1;

import static com.google.shopping.merchant.accounts.v1.AccountRelationshipsServiceClient.ListAccountRelationshipsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
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
public class AccountRelationshipsServiceClientTest {
  private static MockAccountRelationshipsService mockAccountRelationshipsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AccountRelationshipsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAccountRelationshipsService = new MockAccountRelationshipsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAccountRelationshipsService));
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
    AccountRelationshipsServiceSettings settings =
        AccountRelationshipsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccountRelationshipsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getAccountRelationshipTest() throws Exception {
    AccountRelationship expectedResponse =
        AccountRelationship.newBuilder()
            .setName(AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setAccountIdAlias("accountIdAlias-1952169208")
            .build();
    mockAccountRelationshipsService.addResponse(expectedResponse);

    AccountRelationshipName name = AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]");

    AccountRelationship actualResponse = client.getAccountRelationship(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountRelationshipsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccountRelationshipRequest actualRequest =
        ((GetAccountRelationshipRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccountRelationshipExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountRelationshipsService.addException(exception);

    try {
      AccountRelationshipName name = AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]");
      client.getAccountRelationship(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccountRelationshipTest2() throws Exception {
    AccountRelationship expectedResponse =
        AccountRelationship.newBuilder()
            .setName(AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setAccountIdAlias("accountIdAlias-1952169208")
            .build();
    mockAccountRelationshipsService.addResponse(expectedResponse);

    String name = "name3373707";

    AccountRelationship actualResponse = client.getAccountRelationship(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountRelationshipsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccountRelationshipRequest actualRequest =
        ((GetAccountRelationshipRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccountRelationshipExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountRelationshipsService.addException(exception);

    try {
      String name = "name3373707";
      client.getAccountRelationship(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAccountRelationshipTest() throws Exception {
    AccountRelationship expectedResponse =
        AccountRelationship.newBuilder()
            .setName(AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setAccountIdAlias("accountIdAlias-1952169208")
            .build();
    mockAccountRelationshipsService.addResponse(expectedResponse);

    AccountRelationship accountRelationship = AccountRelationship.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AccountRelationship actualResponse =
        client.updateAccountRelationship(accountRelationship, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountRelationshipsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAccountRelationshipRequest actualRequest =
        ((UpdateAccountRelationshipRequest) actualRequests.get(0));

    Assert.assertEquals(accountRelationship, actualRequest.getAccountRelationship());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAccountRelationshipExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountRelationshipsService.addException(exception);

    try {
      AccountRelationship accountRelationship = AccountRelationship.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAccountRelationship(accountRelationship, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountRelationshipsTest() throws Exception {
    AccountRelationship responsesElement = AccountRelationship.newBuilder().build();
    ListAccountRelationshipsResponse expectedResponse =
        ListAccountRelationshipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountRelationships(Arrays.asList(responsesElement))
            .build();
    mockAccountRelationshipsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListAccountRelationshipsPagedResponse pagedListResponse =
        client.listAccountRelationships(parent);

    List<AccountRelationship> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountRelationshipsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountRelationshipsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountRelationshipsRequest actualRequest =
        ((ListAccountRelationshipsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccountRelationshipsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountRelationshipsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listAccountRelationships(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountRelationshipsTest2() throws Exception {
    AccountRelationship responsesElement = AccountRelationship.newBuilder().build();
    ListAccountRelationshipsResponse expectedResponse =
        ListAccountRelationshipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountRelationships(Arrays.asList(responsesElement))
            .build();
    mockAccountRelationshipsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAccountRelationshipsPagedResponse pagedListResponse =
        client.listAccountRelationships(parent);

    List<AccountRelationship> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountRelationshipsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountRelationshipsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountRelationshipsRequest actualRequest =
        ((ListAccountRelationshipsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccountRelationshipsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountRelationshipsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAccountRelationships(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
