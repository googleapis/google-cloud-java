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

package com.google.cloud.recommendationengine.v1beta1;

import static com.google.cloud.recommendationengine.v1beta1.PredictionServiceClient.PredictPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.recommendationengine.v1beta1.stub.HttpJsonPredictionServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Value;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
    Value responsesElement = Value.newBuilder().setBoolValue(true).build();
    PredictResponse expectedResponse =
        PredictResponse.newBuilder()
            .setNextPageToken("")
            .putAllMetadata(Collections.singletonMap("metadata", responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PlacementName name =
        PlacementName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]", "[PLACEMENT]");
    UserEvent userEvent = UserEvent.newBuilder().build();

    PredictPagedResponse pagedListResponse = client.predict(name, userEvent);

    List<Map.Entry<String, Value>> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getMetadataMap().entrySet().iterator().next(), resources.get(0));

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
      PlacementName name =
          PlacementName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]", "[PLACEMENT]");
      UserEvent userEvent = UserEvent.newBuilder().build();
      client.predict(name, userEvent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void predictTest2() throws Exception {
    Value responsesElement = Value.newBuilder().setBoolValue(true).build();
    PredictResponse expectedResponse =
        PredictResponse.newBuilder()
            .setNextPageToken("")
            .putAllMetadata(Collections.singletonMap("metadata", responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9174/locations/location-9174/catalogs/catalog-9174/eventStores/eventStore-9174/placements/placement-9174";
    UserEvent userEvent = UserEvent.newBuilder().build();

    PredictPagedResponse pagedListResponse = client.predict(name, userEvent);

    List<Map.Entry<String, Value>> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getMetadataMap().entrySet().iterator().next(), resources.get(0));

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
  public void predictExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9174/locations/location-9174/catalogs/catalog-9174/eventStores/eventStore-9174/placements/placement-9174";
      UserEvent userEvent = UserEvent.newBuilder().build();
      client.predict(name, userEvent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
