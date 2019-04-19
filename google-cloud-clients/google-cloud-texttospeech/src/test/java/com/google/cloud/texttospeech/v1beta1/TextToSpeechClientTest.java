/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.texttospeech.v1beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
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
public class TextToSpeechClientTest {
  private static MockTextToSpeech mockTextToSpeech;
  private static MockServiceHelper serviceHelper;
  private TextToSpeechClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockTextToSpeech = new MockTextToSpeech();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockTextToSpeech));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    TextToSpeechSettings settings =
        TextToSpeechSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TextToSpeechClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listVoicesTest() {
    ListVoicesResponse expectedResponse = ListVoicesResponse.newBuilder().build();
    mockTextToSpeech.addResponse(expectedResponse);

    String languageCode = "languageCode-412800396";

    ListVoicesResponse actualResponse = client.listVoices(languageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTextToSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVoicesRequest actualRequest = (ListVoicesRequest) actualRequests.get(0);

    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listVoicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTextToSpeech.addException(exception);

    try {
      String languageCode = "languageCode-412800396";

      client.listVoices(languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void synthesizeSpeechTest() {
    ByteString audioContent = ByteString.copyFromUtf8("16");
    SynthesizeSpeechResponse expectedResponse =
        SynthesizeSpeechResponse.newBuilder().setAudioContent(audioContent).build();
    mockTextToSpeech.addResponse(expectedResponse);

    SynthesisInput input = SynthesisInput.newBuilder().build();
    VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().build();
    AudioConfig audioConfig = AudioConfig.newBuilder().build();

    SynthesizeSpeechResponse actualResponse = client.synthesizeSpeech(input, voice, audioConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTextToSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SynthesizeSpeechRequest actualRequest = (SynthesizeSpeechRequest) actualRequests.get(0);

    Assert.assertEquals(input, actualRequest.getInput());
    Assert.assertEquals(voice, actualRequest.getVoice());
    Assert.assertEquals(audioConfig, actualRequest.getAudioConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void synthesizeSpeechExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTextToSpeech.addException(exception);

    try {
      SynthesisInput input = SynthesisInput.newBuilder().build();
      VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().build();
      AudioConfig audioConfig = AudioConfig.newBuilder().build();

      client.synthesizeSpeech(input, voice, audioConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
