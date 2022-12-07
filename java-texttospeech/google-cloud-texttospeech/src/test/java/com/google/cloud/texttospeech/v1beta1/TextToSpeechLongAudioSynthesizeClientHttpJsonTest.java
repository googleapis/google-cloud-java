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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.texttospeech.v1beta1.stub.HttpJsonTextToSpeechLongAudioSynthesizeStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class TextToSpeechLongAudioSynthesizeClientHttpJsonTest {
  private static MockHttpService mockService;
  private static TextToSpeechLongAudioSynthesizeClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonTextToSpeechLongAudioSynthesizeStub.getMethodDescriptors(),
            TextToSpeechLongAudioSynthesizeSettings.getDefaultEndpoint());
    TextToSpeechLongAudioSynthesizeSettings settings =
        TextToSpeechLongAudioSynthesizeSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                TextToSpeechLongAudioSynthesizeSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TextToSpeechLongAudioSynthesizeClient.create(settings);
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
  public void synthesizeLongAudioTest() throws Exception {
    SynthesizeLongAudioResponse expectedResponse = SynthesizeLongAudioResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("synthesizeLongAudioTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SynthesizeLongAudioRequest request =
        SynthesizeLongAudioRequest.newBuilder()
            .setParent("projects/project-5698/locations/location-5698/voices/voice-5698")
            .setInput(SynthesisInput.newBuilder().build())
            .setAudioConfig(AudioConfig.newBuilder().build())
            .setOutputGcsUri("outputGcsUri-489598154")
            .setVoice(VoiceSelectionParams.newBuilder().build())
            .build();

    SynthesizeLongAudioResponse actualResponse = client.synthesizeLongAudioAsync(request).get();
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
  public void synthesizeLongAudioExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SynthesizeLongAudioRequest request =
          SynthesizeLongAudioRequest.newBuilder()
              .setParent("projects/project-5698/locations/location-5698/voices/voice-5698")
              .setInput(SynthesisInput.newBuilder().build())
              .setAudioConfig(AudioConfig.newBuilder().build())
              .setOutputGcsUri("outputGcsUri-489598154")
              .setVoice(VoiceSelectionParams.newBuilder().build())
              .build();
      client.synthesizeLongAudioAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
