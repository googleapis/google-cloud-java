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

package com.google.cloud.retail.v2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.retail.v2.stub.HttpJsonPredictionServiceStub;
import com.google.protobuf.Value;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class PredictionServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static PredictionServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPredictionServiceStub.getMethodDescriptors(),
            PredictionServiceSettings.getDefaultEndpoint());
    PredictionServiceSettings settings =
        PredictionServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                PredictionServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PredictionServiceClient.create(settings);
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
  public void predictTest() throws Exception {
    PredictResponse expectedResponse =
        PredictResponse.newBuilder()
            .addAllResults(new ArrayList<PredictResponse.PredictionResult>())
            .setAttributionToken("attributionToken104706234")
            .addAllMissingIds(new ArrayList<String>())
            .setValidateOnly(true)
            .build();
    mockService.addResponse(expectedResponse);

    PredictRequest request =
        PredictRequest.newBuilder()
            .setPlacement(
                "projects/project-9512/locations/location-9512/catalogs/catalog-9512/placements/placement-9512")
            .setUserEvent(UserEvent.newBuilder().build())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .setValidateOnly(true)
            .putAllParams(new HashMap<String, Value>())
            .putAllLabels(new HashMap<String, String>())
            .build();

    PredictResponse actualResponse = client.predict(request);
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
  public void predictExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PredictRequest request =
          PredictRequest.newBuilder()
              .setPlacement(
                  "projects/project-9512/locations/location-9512/catalogs/catalog-9512/placements/placement-9512")
              .setUserEvent(UserEvent.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setValidateOnly(true)
              .putAllParams(new HashMap<String, Value>())
              .putAllLabels(new HashMap<String, String>())
              .build();
      client.predict(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
