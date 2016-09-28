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

package com.google.cloud.speech.spi.v1beta1;

import com.google.api.gax.core.PagedListResponse;
import com.google.api.gax.testing.MockGrpcService;
import com.google.api.gax.testing.MockServiceHelper;
import com.google.cloud.speech.v1beta1.AsyncRecognizeRequest;
import com.google.cloud.speech.v1beta1.RecognitionAudio;
import com.google.cloud.speech.v1beta1.RecognitionConfig;
import com.google.cloud.speech.v1beta1.SyncRecognizeRequest;
import com.google.cloud.speech.v1beta1.SyncRecognizeResponse;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.GeneratedMessageV3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class SpeechTest {
  private static MockSpeech mockSpeech;
  private static MockServiceHelper serviceHelper;
  private SpeechApi api;

  @BeforeClass
  public static void startStaticServer() {
    mockSpeech = new MockSpeech();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockSpeech));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    SpeechSettings settings =
        SpeechSettings.defaultBuilder()
            .provideChannelWith(serviceHelper.createChannel(), true)
            .build();
    api = SpeechApi.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    api.close();
  }

  @Test
  @SuppressWarnings("all")
  public void syncRecognizeTest() {
    SyncRecognizeResponse expectedResponse = SyncRecognizeResponse.newBuilder().build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockSpeech.setResponses(expectedResponses);

    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    RecognitionAudio audio = RecognitionAudio.newBuilder().build();

    SyncRecognizeResponse actualResponse = api.syncRecognize(config, audio);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SyncRecognizeRequest actualRequest = (SyncRecognizeRequest) actualRequests.get(0);

    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertEquals(audio, actualRequest.getAudio());
  }

  @Test
  @SuppressWarnings("all")
  public void asyncRecognizeTest() {
    String name = "name3373707";
    boolean done = true;
    Operation expectedResponse = Operation.newBuilder().setName(name).setDone(done).build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockSpeech.setResponses(expectedResponses);

    RecognitionConfig config = RecognitionConfig.newBuilder().build();
    RecognitionAudio audio = RecognitionAudio.newBuilder().build();

    Operation actualResponse = api.asyncRecognize(config, audio);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AsyncRecognizeRequest actualRequest = (AsyncRecognizeRequest) actualRequests.get(0);

    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertEquals(audio, actualRequest.getAudio());
  }
}
