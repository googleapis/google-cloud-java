/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import static com.google.cloud.compute.v1.stub.HttpJsonLicenseStub.getLicenseMethodDescriptor;
import com.google.cloud.compute.v1.stub.LicenseStubSettings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class LicenseClientTest {

   private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS = ImmutableList.copyOf(
        Lists.<ApiMethodDescriptor>newArrayList(
          getLicenseMethodDescriptor
        ));
  private static final MockHttpService mockService
      = new MockHttpService(METHOD_DESCRIPTORS, LicenseStubSettings.getDefaultEndpoint());

  private static LicenseClient client;
  private static LicenseSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        LicenseSettings.newBuilder()
           .setTransportChannelProvider(
               LicenseSettings.defaultHttpJsonTransportProviderBuilder()
                   .setHttpTransport(mockService).build())
           .setCredentialsProvider(NoCredentialsProvider.create())
           .build();
    client =
       LicenseClient.create(clientSettings);
  }

  @After
  public void cleanUp() {
    mockService.reset();
  }

  @AfterClass
  public static void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getLicenseTest() {
    Boolean chargesUseFee = true;
    String kind = "kind3292052";
    String name = "name3373707";
    String selfLink = "selfLink-1691268851";
    License expectedResponse = License.newBuilder()
      .setChargesUseFee(chargesUseFee)
      .setKind(kind)
      .setName(name)
      .setSelfLink(selfLink)
      .build();
    mockService.addResponse(expectedResponse);

    ProjectLicenseName license = ProjectLicenseName.of("[PROJECT]", "[LICENSE]");

    License actualResponse =
        client.getLicense(license);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey = mockService.getRequestHeaders()
        .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey()).iterator().next();
    Assert.assertTrue(GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
        .matcher(apiClientHeaderKey).matches());
  }

  @Test
  @SuppressWarnings("all")
  public void getLicenseExceptionTest() throws Exception {
    ApiException exception = ApiExceptionFactory.createException(new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectLicenseName license = ProjectLicenseName.of("[PROJECT]", "[LICENSE]");

      client.getLicense(license);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

}