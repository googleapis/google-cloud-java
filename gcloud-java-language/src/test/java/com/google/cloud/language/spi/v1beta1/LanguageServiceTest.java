/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.language.spi.v1beta1;

import com.google.api.gax.core.PageAccessor;
import com.google.api.gax.testing.MockGrpcService;
import com.google.api.gax.testing.MockServiceHelper;
import com.google.cloud.language.v1beta1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1beta1.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1beta1.AnalyzeSentimentRequest;
import com.google.cloud.language.v1beta1.AnalyzeSentimentResponse;
import com.google.cloud.language.v1beta1.AnnotateTextRequest;
import com.google.cloud.language.v1beta1.AnnotateTextRequest.Features;
import com.google.cloud.language.v1beta1.AnnotateTextResponse;
import com.google.cloud.language.v1beta1.Document;
import com.google.cloud.language.v1beta1.EncodingType;
import com.google.common.collect.Lists;
import com.google.protobuf.GeneratedMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class LanguageServiceTest {
  private static MockServiceHelper serviceHelper;
  private LanguageServiceApi api;

  @BeforeClass
  public static void startStaticServer() {
    MockLanguageService mockService = new MockLanguageService();
    serviceHelper = new MockServiceHelper("in-process-1", mockService);
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
            .provideChannelWith(serviceHelper.createChannel(), true)
            .build();
    api = LanguageServiceApi.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    api.close();
  }

  @Test
  @SuppressWarnings("all")
  public void analyzeSentimentTest() {
    AnalyzeSentimentResponse expectedResponse = AnalyzeSentimentResponse.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    Document document = Document.newBuilder().build();
    AnalyzeSentimentResponse actualResponse = api.analyzeSentiment(document);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnalyzeSentimentRequest actualRequest = (AnalyzeSentimentRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getDocument(), document);
  }

  @Test
  @SuppressWarnings("all")
  public void analyzeEntitiesTest() {
    AnalyzeEntitiesResponse expectedResponse = AnalyzeEntitiesResponse.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    Document document = Document.newBuilder().build();
    EncodingType encodingType = EncodingType.forNumber(0);
    AnalyzeEntitiesResponse actualResponse = api.analyzeEntities(document, encodingType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnalyzeEntitiesRequest actualRequest = (AnalyzeEntitiesRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getDocument(), document);
    Assert.assertEquals(actualRequest.getEncodingType(), encodingType);
  }

  @Test
  @SuppressWarnings("all")
  public void annotateTextTest() {
    AnnotateTextResponse expectedResponse = AnnotateTextResponse.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    Document document = Document.newBuilder().build();
    AnnotateTextRequest.Features features = AnnotateTextRequest.Features.newBuilder().build();
    EncodingType encodingType = EncodingType.forNumber(0);
    AnnotateTextResponse actualResponse = api.annotateText(document, features, encodingType);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnnotateTextRequest actualRequest = (AnnotateTextRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getDocument(), document);
    Assert.assertEquals(actualRequest.getFeatures(), features);
    Assert.assertEquals(actualRequest.getEncodingType(), encodingType);
  }
}
