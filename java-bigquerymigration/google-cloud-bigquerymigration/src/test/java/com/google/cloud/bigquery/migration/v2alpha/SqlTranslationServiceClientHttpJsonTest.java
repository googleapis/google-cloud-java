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

package com.google.cloud.bigquery.migration.v2alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.bigquery.migration.v2alpha.stub.HttpJsonSqlTranslationServiceStub;
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
public class SqlTranslationServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SqlTranslationServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSqlTranslationServiceStub.getMethodDescriptors(),
            SqlTranslationServiceSettings.getDefaultEndpoint());
    SqlTranslationServiceSettings settings =
        SqlTranslationServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SqlTranslationServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SqlTranslationServiceClient.create(settings);
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
  public void translateQueryTest() throws Exception {
    TranslateQueryResponse expectedResponse =
        TranslateQueryResponse.newBuilder()
            .setTranslationJob("translationJob-882219188")
            .setTranslatedQuery("translatedQuery-1174469230")
            .addAllErrors(new ArrayList<SqlTranslationError>())
            .addAllWarnings(new ArrayList<SqlTranslationWarning>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TranslateQueryRequest.SqlTranslationSourceDialect sourceDialect =
        TranslateQueryRequest.SqlTranslationSourceDialect.forNumber(0);
    String query = "query107944136";

    TranslateQueryResponse actualResponse = client.translateQuery(parent, sourceDialect, query);
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
  public void translateQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      TranslateQueryRequest.SqlTranslationSourceDialect sourceDialect =
          TranslateQueryRequest.SqlTranslationSourceDialect.forNumber(0);
      String query = "query107944136";
      client.translateQuery(parent, sourceDialect, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void translateQueryTest2() throws Exception {
    TranslateQueryResponse expectedResponse =
        TranslateQueryResponse.newBuilder()
            .setTranslationJob("translationJob-882219188")
            .setTranslatedQuery("translatedQuery-1174469230")
            .addAllErrors(new ArrayList<SqlTranslationError>())
            .addAllWarnings(new ArrayList<SqlTranslationWarning>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    TranslateQueryRequest.SqlTranslationSourceDialect sourceDialect =
        TranslateQueryRequest.SqlTranslationSourceDialect.forNumber(0);
    String query = "query107944136";

    TranslateQueryResponse actualResponse = client.translateQuery(parent, sourceDialect, query);
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
  public void translateQueryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      TranslateQueryRequest.SqlTranslationSourceDialect sourceDialect =
          TranslateQueryRequest.SqlTranslationSourceDialect.forNumber(0);
      String query = "query107944136";
      client.translateQuery(parent, sourceDialect, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
