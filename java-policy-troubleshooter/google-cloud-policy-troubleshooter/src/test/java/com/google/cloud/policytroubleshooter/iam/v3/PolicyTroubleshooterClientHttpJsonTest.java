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

package com.google.cloud.policytroubleshooter.iam.v3;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.policytroubleshooter.iam.v3.stub.HttpJsonPolicyTroubleshooterStub;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class PolicyTroubleshooterClientHttpJsonTest {
  private static MockHttpService mockService;
  private static PolicyTroubleshooterClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPolicyTroubleshooterStub.getMethodDescriptors(),
            PolicyTroubleshooterSettings.getDefaultEndpoint());
    PolicyTroubleshooterSettings settings =
        PolicyTroubleshooterSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                PolicyTroubleshooterSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PolicyTroubleshooterClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void troubleshootIamPolicyTest() throws Exception {
    TroubleshootIamPolicyResponse expectedResponse =
        TroubleshootIamPolicyResponse.newBuilder()
            .setAccessTuple(AccessTuple.newBuilder().build())
            .setAllowPolicyExplanation(AllowPolicyExplanation.newBuilder().build())
            .setDenyPolicyExplanation(DenyPolicyExplanation.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    TroubleshootIamPolicyRequest request =
        TroubleshootIamPolicyRequest.newBuilder()
            .setAccessTuple(AccessTuple.newBuilder().build())
            .build();

    TroubleshootIamPolicyResponse actualResponse = client.troubleshootIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void troubleshootIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TroubleshootIamPolicyRequest request =
          TroubleshootIamPolicyRequest.newBuilder()
              .setAccessTuple(AccessTuple.newBuilder().build())
              .build();
      client.troubleshootIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
