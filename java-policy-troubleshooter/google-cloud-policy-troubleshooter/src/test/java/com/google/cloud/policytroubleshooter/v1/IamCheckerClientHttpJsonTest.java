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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.policytroubleshooter.v1.stub.HttpJsonIamCheckerStub;
import google.cloud.policytroubleshooter.v1.Explanations;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class IamCheckerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static IamCheckerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonIamCheckerStub.getMethodDescriptors(), IamCheckerSettings.getDefaultEndpoint());
    IamCheckerSettings settings =
        IamCheckerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                IamCheckerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IamCheckerClient.create(settings);
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
            .setAccess(Explanations.AccessState.forNumber(0))
            .addAllExplainedPolicies(new ArrayList<Explanations.ExplainedPolicy>())
            .build();
    mockService.addResponse(expectedResponse);

    TroubleshootIamPolicyRequest request =
        TroubleshootIamPolicyRequest.newBuilder()
            .setAccessTuple(Explanations.AccessTuple.newBuilder().build())
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
              .setAccessTuple(Explanations.AccessTuple.newBuilder().build())
              .build();
      client.troubleshootIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
