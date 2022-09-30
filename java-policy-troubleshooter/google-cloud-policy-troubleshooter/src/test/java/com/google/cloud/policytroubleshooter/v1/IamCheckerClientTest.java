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

package com.google.cloud.policytroubleshooter.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import google.cloud.policytroubleshooter.v1.Explanations;
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
public class IamCheckerClientTest {
  private static MockIamChecker mockIamChecker;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private IamCheckerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockIamChecker = new MockIamChecker();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockIamChecker));
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
    IamCheckerSettings settings =
        IamCheckerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IamCheckerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void troubleshootIamPolicyTest() throws Exception {
    TroubleshootIamPolicyResponse expectedResponse =
        TroubleshootIamPolicyResponse.newBuilder()
            .setAccess(Explanations.AccessState.forNumber(0))
            .addAllExplainedPolicies(new ArrayList<Explanations.ExplainedPolicy>())
            .build();
    mockIamChecker.addResponse(expectedResponse);

    TroubleshootIamPolicyRequest request =
        TroubleshootIamPolicyRequest.newBuilder()
            .setAccessTuple(Explanations.AccessTuple.newBuilder().build())
            .build();

    TroubleshootIamPolicyResponse actualResponse = client.troubleshootIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIamChecker.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TroubleshootIamPolicyRequest actualRequest =
        ((TroubleshootIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAccessTuple(), actualRequest.getAccessTuple());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void troubleshootIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIamChecker.addException(exception);

    try {
      TroubleshootIamPolicyRequest request =
          TroubleshootIamPolicyRequest.newBuilder()
              .setAccessTuple(Explanations.AccessTuple.newBuilder().build())
              .build();
      client.troubleshootIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
