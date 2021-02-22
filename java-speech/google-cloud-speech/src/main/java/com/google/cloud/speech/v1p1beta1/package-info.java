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

/**
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= SpeechClient =======================
 *
 * <p>Service Description: Service that implements Google Cloud Speech API.
 *
 * <p>Sample for SpeechClient:
 *
 * <pre>{@code
 * try (SpeechClient speechClient = SpeechClient.create()) {
 *   RecognitionConfig config = RecognitionConfig.newBuilder().build();
 *   RecognitionAudio audio = RecognitionAudio.newBuilder().build();
 *   RecognizeResponse response = speechClient.recognize(config, audio);
 * }
 * }</pre>
 *
 * <p>======================= AdaptationClient =======================
 *
 * <p>Service Description: Service that implements Google Cloud Speech Adaptation API.
 *
 * <p>Sample for AdaptationClient:
 *
 * <pre>{@code
 * try (AdaptationClient adaptationClient = AdaptationClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   PhraseSet phraseSet = PhraseSet.newBuilder().build();
 *   String phraseSetId = "phraseSetId959902180";
 *   PhraseSet response = adaptationClient.createPhraseSet(parent, phraseSet, phraseSetId);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.speech.v1p1beta1;

import javax.annotation.Generated;
