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

package com.google.cloud.datacatalog.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.datacatalog.v1.stub.HttpJsonPolicyTagManagerSerializationStub;
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
public class PolicyTagManagerSerializationClientHttpJsonTest {
  private static MockHttpService mockService;
  private static PolicyTagManagerSerializationClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPolicyTagManagerSerializationStub.getMethodDescriptors(),
            PolicyTagManagerSerializationSettings.getDefaultEndpoint());
    PolicyTagManagerSerializationSettings settings =
        PolicyTagManagerSerializationSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                PolicyTagManagerSerializationSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PolicyTagManagerSerializationClient.create(settings);
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
  public void replaceTaxonomyTest() throws Exception {
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicyTagCount(1074340189)
            .setTaxonomyTimestamps(SystemTimestamps.newBuilder().build())
            .addAllActivatedPolicyTypes(new ArrayList<Taxonomy.PolicyType>())
            .build();
    mockService.addResponse(expectedResponse);

    ReplaceTaxonomyRequest request =
        ReplaceTaxonomyRequest.newBuilder()
            .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
            .setSerializedTaxonomy(SerializedTaxonomy.newBuilder().build())
            .build();

    Taxonomy actualResponse = client.replaceTaxonomy(request);
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
  public void replaceTaxonomyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReplaceTaxonomyRequest request =
          ReplaceTaxonomyRequest.newBuilder()
              .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
              .setSerializedTaxonomy(SerializedTaxonomy.newBuilder().build())
              .build();
      client.replaceTaxonomy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importTaxonomiesTest() throws Exception {
    ImportTaxonomiesResponse expectedResponse =
        ImportTaxonomiesResponse.newBuilder().addAllTaxonomies(new ArrayList<Taxonomy>()).build();
    mockService.addResponse(expectedResponse);

    ImportTaxonomiesRequest request =
        ImportTaxonomiesRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .build();

    ImportTaxonomiesResponse actualResponse = client.importTaxonomies(request);
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
  public void importTaxonomiesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportTaxonomiesRequest request =
          ImportTaxonomiesRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .build();
      client.importTaxonomies(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportTaxonomiesTest() throws Exception {
    ExportTaxonomiesResponse expectedResponse =
        ExportTaxonomiesResponse.newBuilder()
            .addAllTaxonomies(new ArrayList<SerializedTaxonomy>())
            .build();
    mockService.addResponse(expectedResponse);

    ExportTaxonomiesRequest request =
        ExportTaxonomiesRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllTaxonomies(new ArrayList<String>())
            .build();

    ExportTaxonomiesResponse actualResponse = client.exportTaxonomies(request);
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
  public void exportTaxonomiesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExportTaxonomiesRequest request =
          ExportTaxonomiesRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .addAllTaxonomies(new ArrayList<String>())
              .build();
      client.exportTaxonomies(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
