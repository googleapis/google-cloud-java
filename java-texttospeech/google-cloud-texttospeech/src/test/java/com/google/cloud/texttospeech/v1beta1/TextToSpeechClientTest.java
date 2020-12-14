/*
 * Copyright 2020 Google LLC
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
public class TextToSpeechClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockTextToSpeech mockTextToSpeech;
  private TextToSpeechClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockTextToSpeech = new MockTextToSpeech();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTextToSpeech));
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
  public void listVoicesTest() throws Exception {
    ListVoicesResponse expectedResponse =
        ListVoicesResponse.newBuilder().addAllVoices(new ArrayList<Voice>()).build();
    mockTextToSpeech.addResponse(expectedResponse);

    String languageCode = "languageCode-2092349083";

    ListVoicesResponse actualResponse = client.listVoices(languageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTextToSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVoicesRequest actualRequest = ((ListVoicesRequest) actualRequests.get(0));

    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVoicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTextToSpeech.addException(exception);

    try {
      String languageCode = "languageCode-2092349083";
      client.listVoices(languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void synthesizeSpeechTest() throws Exception {
    SynthesizeSpeechResponse expectedResponse =
        SynthesizeSpeechResponse.newBuilder()
            .setAudioContent(ByteString.EMPTY)
            .addAllTimepoints(new ArrayList<Timepoint>())
            .setAudioConfig(AudioConfig.newBuilder().build())
            .build();
    mockTextToSpeech.addResponse(expectedResponse);

    SynthesisInput input = SynthesisInput.newBuilder().build();
    VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().build();
    AudioConfig audioConfig = AudioConfig.newBuilder().build();

    SynthesizeSpeechResponse actualResponse = client.synthesizeSpeech(input, voice, audioConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTextToSpeech.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SynthesizeSpeechRequest actualRequest = ((SynthesizeSpeechRequest) actualRequests.get(0));

    Assert.assertEquals(input, actualRequest.getInput());
    Assert.assertEquals(voice, actualRequest.getVoice());
    Assert.assertEquals(audioConfig, actualRequest.getAudioConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void synthesizeSpeechExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTextToSpeech.addException(exception);

    try {
      SynthesisInput input = SynthesisInput.newBuilder().build();
      VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().build();
      AudioConfig audioConfig = AudioConfig.newBuilder().build();
      client.synthesizeSpeech(input, voice, audioConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
