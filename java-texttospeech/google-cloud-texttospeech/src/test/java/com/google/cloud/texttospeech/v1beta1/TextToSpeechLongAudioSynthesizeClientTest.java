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

package com.google.cloud.texttospeech.v1beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class TextToSpeechLongAudioSynthesizeClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockTextToSpeechLongAudioSynthesize mockTextToSpeechLongAudioSynthesize;
  private LocalChannelProvider channelProvider;
  private TextToSpeechLongAudioSynthesizeClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockTextToSpeechLongAudioSynthesize = new MockTextToSpeechLongAudioSynthesize();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockTextToSpeechLongAudioSynthesize));
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
    TextToSpeechLongAudioSynthesizeSettings settings =
        TextToSpeechLongAudioSynthesizeSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TextToSpeechLongAudioSynthesizeClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void synthesizeLongAudioTest() throws Exception {
    SynthesizeLongAudioResponse expectedResponse = SynthesizeLongAudioResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("synthesizeLongAudioTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTextToSpeechLongAudioSynthesize.addResponse(resultOperation);

    SynthesizeLongAudioRequest request =
        SynthesizeLongAudioRequest.newBuilder()
            .setParent("parent-995424086")
            .setInput(SynthesisInput.newBuilder().build())
            .setAudioConfig(AudioConfig.newBuilder().build())
            .setOutputGcsUri("outputGcsUri-489598154")
            .setVoice(VoiceSelectionParams.newBuilder().build())
            .build();

    SynthesizeLongAudioResponse actualResponse = client.synthesizeLongAudioAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTextToSpeechLongAudioSynthesize.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SynthesizeLongAudioRequest actualRequest = ((SynthesizeLongAudioRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getInput(), actualRequest.getInput());
    Assert.assertEquals(request.getAudioConfig(), actualRequest.getAudioConfig());
    Assert.assertEquals(request.getOutputGcsUri(), actualRequest.getOutputGcsUri());
    Assert.assertEquals(request.getVoice(), actualRequest.getVoice());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void synthesizeLongAudioExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTextToSpeechLongAudioSynthesize.addException(exception);

    try {
      SynthesizeLongAudioRequest request =
          SynthesizeLongAudioRequest.newBuilder()
              .setParent("parent-995424086")
              .setInput(SynthesisInput.newBuilder().build())
              .setAudioConfig(AudioConfig.newBuilder().build())
              .setOutputGcsUri("outputGcsUri-489598154")
              .setVoice(VoiceSelectionParams.newBuilder().build())
              .build();
      client.synthesizeLongAudioAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
