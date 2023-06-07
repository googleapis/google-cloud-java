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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
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
public class SqlTranslationServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockSqlTranslationService mockSqlTranslationService;
  private LocalChannelProvider channelProvider;
  private SqlTranslationServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSqlTranslationService = new MockSqlTranslationService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSqlTranslationService));
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
    SqlTranslationServiceSettings settings =
        SqlTranslationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SqlTranslationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockSqlTranslationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TranslateQueryRequest.SqlTranslationSourceDialect sourceDialect =
        TranslateQueryRequest.SqlTranslationSourceDialect.forNumber(0);
    String query = "query107944136";

    TranslateQueryResponse actualResponse = client.translateQuery(parent, sourceDialect, query);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TranslateQueryRequest actualRequest = ((TranslateQueryRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sourceDialect, actualRequest.getSourceDialect());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void translateQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlTranslationService.addException(exception);

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
    mockSqlTranslationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    TranslateQueryRequest.SqlTranslationSourceDialect sourceDialect =
        TranslateQueryRequest.SqlTranslationSourceDialect.forNumber(0);
    String query = "query107944136";

    TranslateQueryResponse actualResponse = client.translateQuery(parent, sourceDialect, query);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlTranslationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TranslateQueryRequest actualRequest = ((TranslateQueryRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(sourceDialect, actualRequest.getSourceDialect());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void translateQueryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlTranslationService.addException(exception);

    try {
      String parent = "parent-995424086";
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
