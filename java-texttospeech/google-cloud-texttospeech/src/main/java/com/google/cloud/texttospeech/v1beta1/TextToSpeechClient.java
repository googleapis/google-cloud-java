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

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.texttospeech.v1beta1.stub.TextToSpeechStub;
import com.google.cloud.texttospeech.v1beta1.stub.TextToSpeechStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service that implements Google Cloud Text-to-Speech API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
 *   String languageCode = "languageCode-2092349083";
 *   ListVoicesResponse response = textToSpeechClient.listVoices(languageCode);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TextToSpeechClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of TextToSpeechSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TextToSpeechSettings textToSpeechSettings =
 *     TextToSpeechSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TextToSpeechClient textToSpeechClient = TextToSpeechClient.create(textToSpeechSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TextToSpeechSettings textToSpeechSettings =
 *     TextToSpeechSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TextToSpeechClient textToSpeechClient = TextToSpeechClient.create(textToSpeechSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TextToSpeechSettings textToSpeechSettings =
 *     TextToSpeechSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             TextToSpeechSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * TextToSpeechClient textToSpeechClient = TextToSpeechClient.create(textToSpeechSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TextToSpeechClient implements BackgroundResource {
  private final TextToSpeechSettings settings;
  private final TextToSpeechStub stub;

  /** Constructs an instance of TextToSpeechClient with default settings. */
  public static final TextToSpeechClient create() throws IOException {
    return create(TextToSpeechSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TextToSpeechClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TextToSpeechClient create(TextToSpeechSettings settings) throws IOException {
    return new TextToSpeechClient(settings);
  }

  /**
   * Constructs an instance of TextToSpeechClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(TextToSpeechSettings).
   */
  public static final TextToSpeechClient create(TextToSpeechStub stub) {
    return new TextToSpeechClient(stub);
  }

  /**
   * Constructs an instance of TextToSpeechClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TextToSpeechClient(TextToSpeechSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TextToSpeechStubSettings) settings.getStubSettings()).createStub();
  }

  protected TextToSpeechClient(TextToSpeechStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TextToSpeechSettings getSettings() {
    return settings;
  }

  public TextToSpeechStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of Voice supported for synthesis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
   *   String languageCode = "languageCode-2092349083";
   *   ListVoicesResponse response = textToSpeechClient.listVoices(languageCode);
   * }
   * }</pre>
   *
   * @param languageCode Optional. Recommended.
   *     [BCP-47](https://www.rfc-editor.org/rfc/bcp/bcp47.txt) language tag. If not specified, the
   *     API will return all supported voices. If specified, the ListVoices call will only return
   *     voices that can be used to synthesize this language_code. For example, if you specify
   *     `"en-NZ"`, all `"en-NZ"` voices will be returned. If you specify `"no"`, both
   *     `"no-\\&#42;"` (Norwegian) and `"nb-\\&#42;"` (Norwegian Bokmal) voices will be returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVoicesResponse listVoices(String languageCode) {
    ListVoicesRequest request =
        ListVoicesRequest.newBuilder().setLanguageCode(languageCode).build();
    return listVoices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of Voice supported for synthesis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
   *   ListVoicesRequest request =
   *       ListVoicesRequest.newBuilder().setLanguageCode("languageCode-2092349083").build();
   *   ListVoicesResponse response = textToSpeechClient.listVoices(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVoicesResponse listVoices(ListVoicesRequest request) {
    return listVoicesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of Voice supported for synthesis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
   *   ListVoicesRequest request =
   *       ListVoicesRequest.newBuilder().setLanguageCode("languageCode-2092349083").build();
   *   ApiFuture<ListVoicesResponse> future =
   *       textToSpeechClient.listVoicesCallable().futureCall(request);
   *   // Do something.
   *   ListVoicesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVoicesRequest, ListVoicesResponse> listVoicesCallable() {
    return stub.listVoicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Synthesizes speech synchronously: receive results after all text input has been processed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
   *   SynthesisInput input = SynthesisInput.newBuilder().build();
   *   VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().build();
   *   AudioConfig audioConfig = AudioConfig.newBuilder().build();
   *   SynthesizeSpeechResponse response =
   *       textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);
   * }
   * }</pre>
   *
   * @param input Required. The Synthesizer requires either plain text or SSML as input.
   * @param voice Required. The desired voice of the synthesized audio.
   * @param audioConfig Required. The configuration of the synthesized audio.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SynthesizeSpeechResponse synthesizeSpeech(
      SynthesisInput input, VoiceSelectionParams voice, AudioConfig audioConfig) {
    SynthesizeSpeechRequest request =
        SynthesizeSpeechRequest.newBuilder()
            .setInput(input)
            .setVoice(voice)
            .setAudioConfig(audioConfig)
            .build();
    return synthesizeSpeech(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Synthesizes speech synchronously: receive results after all text input has been processed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
   *   SynthesizeSpeechRequest request =
   *       SynthesizeSpeechRequest.newBuilder()
   *           .setInput(SynthesisInput.newBuilder().build())
   *           .setVoice(VoiceSelectionParams.newBuilder().build())
   *           .setAudioConfig(AudioConfig.newBuilder().build())
   *           .addAllEnableTimePointing(new ArrayList<SynthesizeSpeechRequest.TimepointType>())
   *           .build();
   *   SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SynthesizeSpeechResponse synthesizeSpeech(SynthesizeSpeechRequest request) {
    return synthesizeSpeechCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Synthesizes speech synchronously: receive results after all text input has been processed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
   *   SynthesizeSpeechRequest request =
   *       SynthesizeSpeechRequest.newBuilder()
   *           .setInput(SynthesisInput.newBuilder().build())
   *           .setVoice(VoiceSelectionParams.newBuilder().build())
   *           .setAudioConfig(AudioConfig.newBuilder().build())
   *           .addAllEnableTimePointing(new ArrayList<SynthesizeSpeechRequest.TimepointType>())
   *           .build();
   *   ApiFuture<SynthesizeSpeechResponse> future =
   *       textToSpeechClient.synthesizeSpeechCallable().futureCall(request);
   *   // Do something.
   *   SynthesizeSpeechResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SynthesizeSpeechRequest, SynthesizeSpeechResponse>
      synthesizeSpeechCallable() {
    return stub.synthesizeSpeechCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }
}
