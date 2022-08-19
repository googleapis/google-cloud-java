/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.binaryauthorization.v1beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class SystemPolicyV1Beta1ClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockSystemPolicyV1Beta1 mockSystemPolicyV1Beta1;
  private LocalChannelProvider channelProvider;
  private SystemPolicyV1Beta1Client client;

  @BeforeClass
  public static void startStaticServer() {
    mockSystemPolicyV1Beta1 = new MockSystemPolicyV1Beta1();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSystemPolicyV1Beta1));
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
    SystemPolicyV1Beta1Settings settings =
        SystemPolicyV1Beta1Settings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SystemPolicyV1Beta1Client.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getSystemPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofLocationName("[LOCATION]").toString())
            .setDescription("description-1724546052")
            .addAllAdmissionWhitelistPatterns(new ArrayList<AdmissionWhitelistPattern>())
            .putAllClusterAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesNamespaceAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesServiceAccountAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllIstioServiceIdentityAdmissionRules(new HashMap<String, AdmissionRule>())
            .setDefaultAdmissionRule(AdmissionRule.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSystemPolicyV1Beta1.addResponse(expectedResponse);

    PolicyName name = PolicyName.ofLocationName("[LOCATION]");

    Policy actualResponse = client.getSystemPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSystemPolicyV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSystemPolicyRequest actualRequest = ((GetSystemPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSystemPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSystemPolicyV1Beta1.addException(exception);

    try {
      PolicyName name = PolicyName.ofLocationName("[LOCATION]");
      client.getSystemPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSystemPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofLocationName("[LOCATION]").toString())
            .setDescription("description-1724546052")
            .addAllAdmissionWhitelistPatterns(new ArrayList<AdmissionWhitelistPattern>())
            .putAllClusterAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesNamespaceAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesServiceAccountAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllIstioServiceIdentityAdmissionRules(new HashMap<String, AdmissionRule>())
            .setDefaultAdmissionRule(AdmissionRule.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSystemPolicyV1Beta1.addResponse(expectedResponse);

    String name = "name3373707";

    Policy actualResponse = client.getSystemPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSystemPolicyV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSystemPolicyRequest actualRequest = ((GetSystemPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSystemPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSystemPolicyV1Beta1.addException(exception);

    try {
      String name = "name3373707";
      client.getSystemPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
