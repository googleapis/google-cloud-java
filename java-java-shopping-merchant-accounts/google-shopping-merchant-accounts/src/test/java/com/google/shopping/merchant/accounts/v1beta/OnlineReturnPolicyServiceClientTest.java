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

import static com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicyServiceClient.ListOnlineReturnPoliciesPagedResponse;

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
public class OnlineReturnPolicyServiceClientTest {
  private static MockOnlineReturnPolicyService mockOnlineReturnPolicyService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private OnlineReturnPolicyServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockOnlineReturnPolicyService = new MockOnlineReturnPolicyService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockOnlineReturnPolicyService));
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
    OnlineReturnPolicyServiceSettings settings =
        OnlineReturnPolicyServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OnlineReturnPolicyServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getOnlineReturnPolicyTest() throws Exception {
    OnlineReturnPolicy expectedResponse =
        OnlineReturnPolicy.newBuilder()
            .setName(OnlineReturnPolicyName.of("[ACCOUNT]", "[RETURN_POLICY]").toString())
            .setReturnPolicyId("returnPolicyId-636904643")
            .setLabel("label102727412")
            .addAllCountries(new ArrayList<String>())
            .setPolicy(OnlineReturnPolicy.Policy.newBuilder().build())
            .setRestockingFee(OnlineReturnPolicy.RestockingFee.newBuilder().build())
            .addAllReturnMethods(new ArrayList<OnlineReturnPolicy.ReturnMethod>())
            .addAllItemConditions(new ArrayList<OnlineReturnPolicy.ItemCondition>())
            .setReturnShippingFee(OnlineReturnPolicy.ReturnShippingFee.newBuilder().build())
            .setReturnPolicyUri("returnPolicyUri1730804618")
            .setAcceptDefectiveOnly(true)
            .setProcessRefundDays(1233584878)
            .setAcceptExchange(true)
            .build();
    mockOnlineReturnPolicyService.addResponse(expectedResponse);

    OnlineReturnPolicyName name = OnlineReturnPolicyName.of("[ACCOUNT]", "[RETURN_POLICY]");

    OnlineReturnPolicy actualResponse = client.getOnlineReturnPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOnlineReturnPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOnlineReturnPolicyRequest actualRequest =
        ((GetOnlineReturnPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOnlineReturnPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOnlineReturnPolicyService.addException(exception);

    try {
      OnlineReturnPolicyName name = OnlineReturnPolicyName.of("[ACCOUNT]", "[RETURN_POLICY]");
      client.getOnlineReturnPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOnlineReturnPolicyTest2() throws Exception {
    OnlineReturnPolicy expectedResponse =
        OnlineReturnPolicy.newBuilder()
            .setName(OnlineReturnPolicyName.of("[ACCOUNT]", "[RETURN_POLICY]").toString())
            .setReturnPolicyId("returnPolicyId-636904643")
            .setLabel("label102727412")
            .addAllCountries(new ArrayList<String>())
            .setPolicy(OnlineReturnPolicy.Policy.newBuilder().build())
            .setRestockingFee(OnlineReturnPolicy.RestockingFee.newBuilder().build())
            .addAllReturnMethods(new ArrayList<OnlineReturnPolicy.ReturnMethod>())
            .addAllItemConditions(new ArrayList<OnlineReturnPolicy.ItemCondition>())
            .setReturnShippingFee(OnlineReturnPolicy.ReturnShippingFee.newBuilder().build())
            .setReturnPolicyUri("returnPolicyUri1730804618")
            .setAcceptDefectiveOnly(true)
            .setProcessRefundDays(1233584878)
            .setAcceptExchange(true)
            .build();
    mockOnlineReturnPolicyService.addResponse(expectedResponse);

    String name = "name3373707";

    OnlineReturnPolicy actualResponse = client.getOnlineReturnPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOnlineReturnPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOnlineReturnPolicyRequest actualRequest =
        ((GetOnlineReturnPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOnlineReturnPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOnlineReturnPolicyService.addException(exception);

    try {
      String name = "name3373707";
      client.getOnlineReturnPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOnlineReturnPoliciesTest() throws Exception {
    OnlineReturnPolicy responsesElement = OnlineReturnPolicy.newBuilder().build();
    ListOnlineReturnPoliciesResponse expectedResponse =
        ListOnlineReturnPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllOnlineReturnPolicies(Arrays.asList(responsesElement))
            .build();
    mockOnlineReturnPolicyService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListOnlineReturnPoliciesPagedResponse pagedListResponse =
        client.listOnlineReturnPolicies(parent);

    List<OnlineReturnPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOnlineReturnPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOnlineReturnPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOnlineReturnPoliciesRequest actualRequest =
        ((ListOnlineReturnPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOnlineReturnPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOnlineReturnPolicyService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listOnlineReturnPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOnlineReturnPoliciesTest2() throws Exception {
    OnlineReturnPolicy responsesElement = OnlineReturnPolicy.newBuilder().build();
    ListOnlineReturnPoliciesResponse expectedResponse =
        ListOnlineReturnPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllOnlineReturnPolicies(Arrays.asList(responsesElement))
            .build();
    mockOnlineReturnPolicyService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListOnlineReturnPoliciesPagedResponse pagedListResponse =
        client.listOnlineReturnPolicies(parent);

    List<OnlineReturnPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOnlineReturnPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOnlineReturnPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOnlineReturnPoliciesRequest actualRequest =
        ((ListOnlineReturnPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOnlineReturnPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOnlineReturnPolicyService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listOnlineReturnPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
