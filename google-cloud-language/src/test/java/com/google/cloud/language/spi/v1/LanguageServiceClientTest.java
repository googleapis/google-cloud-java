/*
 * Copyright 2016, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.language.spi.v1;

import com.google.api.gax.grpc.ApiException;
import com.google.api.gax.testing.MockGrpcService;
import com.google.api.gax.testing.MockServiceHelper;
import com.google.cloud.language.v1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1.AnalyzeSentimentRequest;
import com.google.cloud.language.v1.AnalyzeSentimentResponse;
import com.google.cloud.language.v1.AnalyzeSyntaxRequest;
import com.google.cloud.language.v1.AnalyzeSyntaxResponse;
import com.google.cloud.language.v1.AnnotateTextRequest;
import com.google.cloud.language.v1.AnnotateTextRequest.Features;
import com.google.cloud.language.v1.AnnotateTextResponse;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.EncodingType;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class LanguageServiceClientTest {
  private static MockLanguageService mockLanguageService;
  private static MockServiceHelper serviceHelper;
  private LanguageServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLanguageService = new MockLanguageService();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockLanguageService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    LanguageServiceSettings settings =
        LanguageServiceSettings.defaultBuilder()
            .setChannelProvider(serviceHelper.createChannelProvider())
            .build();
    client = LanguageServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void analyzeSentimentTest() {
    String language = "language-1613589672";
    AnalyzeSentimentResponse expectedResponse =
        AnalyzeSentimentResponse.newBuilder().setLanguage(language).build();
    mockLanguageService.addResponse(expectedResponse);

    Document document = Document.newBuilder().build();

    AnalyzeSentimentResponse actualResponse = client.analyzeSentiment(document);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockLanguageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnalyzeSentimentRequest actualRequest = (AnalyzeSentimentRequest) actualRequests.get(0);

    Assert.assertEquals(document, actualRequest.getDocument());
  }

  @Test
  @SuppressWarnings("all")
  public void analyzeSentimentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockLanguageService.addException(exception);

    try {
      Document document = Document.newBuilder().build();

      client.analyzeSentiment(document);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void analyzeEntitiesTest() {
    String language = "language-1613589672";
    AnalyzeEntitiesResponse expectedResponse =
        AnalyzeEntitiesResponse.newBuilder().setLanguage(language).build();
    mockLanguageService.addResponse(expectedResponse);

    Document document = Document.newBuilder().build();
    EncodingType encodingType = EncodingType.NONE;

    AnalyzeEntitiesResponse actualResponse = client.analyzeEntities(document, encodingType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockLanguageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnalyzeEntitiesRequest actualRequest = (AnalyzeEntitiesRequest) actualRequests.get(0);

    Assert.assertEquals(document, actualRequest.getDocument());
    Assert.assertEquals(encodingType, actualRequest.getEncodingType());
  }

  @Test
  @SuppressWarnings("all")
  public void analyzeEntitiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockLanguageService.addException(exception);

    try {
      Document document = Document.newBuilder().build();
      EncodingType encodingType = EncodingType.NONE;

      client.analyzeEntities(document, encodingType);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void analyzeSyntaxTest() {
    String language = "language-1613589672";
    AnalyzeSyntaxResponse expectedResponse =
        AnalyzeSyntaxResponse.newBuilder().setLanguage(language).build();
    mockLanguageService.addResponse(expectedResponse);

    Document document = Document.newBuilder().build();
    EncodingType encodingType = EncodingType.NONE;

    AnalyzeSyntaxResponse actualResponse = client.analyzeSyntax(document, encodingType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockLanguageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnalyzeSyntaxRequest actualRequest = (AnalyzeSyntaxRequest) actualRequests.get(0);

    Assert.assertEquals(document, actualRequest.getDocument());
    Assert.assertEquals(encodingType, actualRequest.getEncodingType());
  }

  @Test
  @SuppressWarnings("all")
  public void analyzeSyntaxExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockLanguageService.addException(exception);

    try {
      Document document = Document.newBuilder().build();
      EncodingType encodingType = EncodingType.NONE;

      client.analyzeSyntax(document, encodingType);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void annotateTextTest() {
    String language = "language-1613589672";
    AnnotateTextResponse expectedResponse =
        AnnotateTextResponse.newBuilder().setLanguage(language).build();
    mockLanguageService.addResponse(expectedResponse);

    Document document = Document.newBuilder().build();
    AnnotateTextRequest.Features features = AnnotateTextRequest.Features.newBuilder().build();
    EncodingType encodingType = EncodingType.NONE;

    AnnotateTextResponse actualResponse = client.annotateText(document, features, encodingType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockLanguageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnnotateTextRequest actualRequest = (AnnotateTextRequest) actualRequests.get(0);

    Assert.assertEquals(document, actualRequest.getDocument());
    Assert.assertEquals(features, actualRequest.getFeatures());
    Assert.assertEquals(encodingType, actualRequest.getEncodingType());
  }

  @Test
  @SuppressWarnings("all")
  public void annotateTextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
    mockLanguageService.addException(exception);

    try {
      Document document = Document.newBuilder().build();
      AnnotateTextRequest.Features features = AnnotateTextRequest.Features.newBuilder().build();
      EncodingType encodingType = EncodingType.NONE;

      client.annotateText(document, features, encodingType);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INTERNAL.getCode(), e.getStatusCode());
    }
  }
}
