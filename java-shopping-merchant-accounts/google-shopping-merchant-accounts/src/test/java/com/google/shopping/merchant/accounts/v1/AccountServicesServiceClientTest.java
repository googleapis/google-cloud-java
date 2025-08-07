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

import static com.google.shopping.merchant.accounts.v1.AccountServicesServiceClient.ListAccountServicesPagedResponse;

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
public class AccountServicesServiceClientTest {
  private static MockAccountServicesService mockAccountServicesService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AccountServicesServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAccountServicesService = new MockAccountServicesService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAccountServicesService));
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
    AccountServicesServiceSettings settings =
        AccountServicesServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccountServicesServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getAccountServiceTest() throws Exception {
    AccountService expectedResponse =
        AccountService.newBuilder()
            .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setHandshake(Handshake.newBuilder().build())
            .setExternalAccountId("externalAccountId1814989981")
            .build();
    mockAccountServicesService.addResponse(expectedResponse);

    AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");

    AccountService actualResponse = client.getAccountService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountServicesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccountServiceRequest actualRequest = ((GetAccountServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccountServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountServicesService.addException(exception);

    try {
      AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");
      client.getAccountService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccountServiceTest2() throws Exception {
    AccountService expectedResponse =
        AccountService.newBuilder()
            .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setHandshake(Handshake.newBuilder().build())
            .setExternalAccountId("externalAccountId1814989981")
            .build();
    mockAccountServicesService.addResponse(expectedResponse);

    String name = "name3373707";

    AccountService actualResponse = client.getAccountService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountServicesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccountServiceRequest actualRequest = ((GetAccountServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccountServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountServicesService.addException(exception);

    try {
      String name = "name3373707";
      client.getAccountService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountServicesTest() throws Exception {
    AccountService responsesElement = AccountService.newBuilder().build();
    ListAccountServicesResponse expectedResponse =
        ListAccountServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountServices(Arrays.asList(responsesElement))
            .build();
    mockAccountServicesService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListAccountServicesPagedResponse pagedListResponse = client.listAccountServices(parent);

    List<AccountService> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountServicesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountServicesRequest actualRequest = ((ListAccountServicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccountServicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountServicesService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listAccountServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccountServicesTest2() throws Exception {
    AccountService responsesElement = AccountService.newBuilder().build();
    ListAccountServicesResponse expectedResponse =
        ListAccountServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccountServices(Arrays.asList(responsesElement))
            .build();
    mockAccountServicesService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAccountServicesPagedResponse pagedListResponse = client.listAccountServices(parent);

    List<AccountService> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccountServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccountServicesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccountServicesRequest actualRequest = ((ListAccountServicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccountServicesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountServicesService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAccountServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void proposeAccountServiceTest() throws Exception {
    AccountService expectedResponse =
        AccountService.newBuilder()
            .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setHandshake(Handshake.newBuilder().build())
            .setExternalAccountId("externalAccountId1814989981")
            .build();
    mockAccountServicesService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    String provider = "provider-987494927";
    AccountService accountService = AccountService.newBuilder().build();

    AccountService actualResponse = client.proposeAccountService(parent, provider, accountService);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountServicesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ProposeAccountServiceRequest actualRequest =
        ((ProposeAccountServiceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(provider, actualRequest.getProvider());
    Assert.assertEquals(accountService, actualRequest.getAccountService());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void proposeAccountServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountServicesService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      String provider = "provider-987494927";
      AccountService accountService = AccountService.newBuilder().build();
      client.proposeAccountService(parent, provider, accountService);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void proposeAccountServiceTest2() throws Exception {
    AccountService expectedResponse =
        AccountService.newBuilder()
            .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setHandshake(Handshake.newBuilder().build())
            .setExternalAccountId("externalAccountId1814989981")
            .build();
    mockAccountServicesService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String provider = "provider-987494927";
    AccountService accountService = AccountService.newBuilder().build();

    AccountService actualResponse = client.proposeAccountService(parent, provider, accountService);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountServicesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ProposeAccountServiceRequest actualRequest =
        ((ProposeAccountServiceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(provider, actualRequest.getProvider());
    Assert.assertEquals(accountService, actualRequest.getAccountService());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void proposeAccountServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountServicesService.addException(exception);

    try {
      String parent = "parent-995424086";
      String provider = "provider-987494927";
      AccountService accountService = AccountService.newBuilder().build();
      client.proposeAccountService(parent, provider, accountService);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void approveAccountServiceTest() throws Exception {
    AccountService expectedResponse =
        AccountService.newBuilder()
            .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setHandshake(Handshake.newBuilder().build())
            .setExternalAccountId("externalAccountId1814989981")
            .build();
    mockAccountServicesService.addResponse(expectedResponse);

    AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");

    AccountService actualResponse = client.approveAccountService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountServicesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ApproveAccountServiceRequest actualRequest =
        ((ApproveAccountServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void approveAccountServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountServicesService.addException(exception);

    try {
      AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");
      client.approveAccountService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void approveAccountServiceTest2() throws Exception {
    AccountService expectedResponse =
        AccountService.newBuilder()
            .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
            .setProvider("provider-987494927")
            .setProviderDisplayName("providerDisplayName-597096516")
            .setHandshake(Handshake.newBuilder().build())
            .setExternalAccountId("externalAccountId1814989981")
            .build();
    mockAccountServicesService.addResponse(expectedResponse);

    String name = "name3373707";

    AccountService actualResponse = client.approveAccountService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccountServicesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ApproveAccountServiceRequest actualRequest =
        ((ApproveAccountServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void approveAccountServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountServicesService.addException(exception);

    try {
      String name = "name3373707";
      client.approveAccountService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rejectAccountServiceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAccountServicesService.addResponse(expectedResponse);

    AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");

    client.rejectAccountService(name);

    List<AbstractMessage> actualRequests = mockAccountServicesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RejectAccountServiceRequest actualRequest =
        ((RejectAccountServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rejectAccountServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountServicesService.addException(exception);

    try {
      AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");
      client.rejectAccountService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rejectAccountServiceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAccountServicesService.addResponse(expectedResponse);

    String name = "name3373707";

    client.rejectAccountService(name);

    List<AbstractMessage> actualRequests = mockAccountServicesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RejectAccountServiceRequest actualRequest =
        ((RejectAccountServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rejectAccountServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccountServicesService.addException(exception);

    try {
      String name = "name3373707";
      client.rejectAccountService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
