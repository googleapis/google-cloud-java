/*
 * Copyright 2020 Google LLC
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

/**
 * A client to Cloud Speech-to-Text API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>============ SpeechClient ============
 *
 * <p>Service Description: Service that implements Google Cloud Speech API.
 *
 * <p>Sample for SpeechClient:
 *
 * <pre>
 * <code>
 * try (SpeechClient speechClient = SpeechClient.create()) {
 *   RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
 *   int sampleRateHertz = 44100;
 *   String languageCode = "en-US";
 *   RecognitionConfig config = RecognitionConfig.newBuilder()
 *     .setEncoding(encoding)
 *     .setSampleRateHertz(sampleRateHertz)
 *     .setLanguageCode(languageCode)
 *     .build();
 *   String uri = "gs://bucket_name/file_name.flac";
 *   RecognitionAudio audio = RecognitionAudio.newBuilder()
 *     .setUri(uri)
 *     .build();
 *   RecognizeResponse response = speechClient.recognize(config, audio);
 * }
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
package com.google.cloud.speech.v1p1beta1;

import javax.annotation.Generated;
