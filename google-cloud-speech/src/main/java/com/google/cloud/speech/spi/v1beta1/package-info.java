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

/**
 * A client to Google Cloud Speech API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>========= SpeechApi =========
 *
 * <p>Service Description: Service that implements Google Cloud Speech API.
 *
 * <p>Sample for SpeechApi:
 *
 * <pre>
 * <code>
 * try (SpeechApi speechApi = SpeechApi.create()) {
 *   RecognitionConfig config = RecognitionConfig.newBuilder().build();
 *   RecognitionAudio audio = RecognitionAudio.newBuilder().build();
 *   SyncRecognizeResponse response = speechApi.syncRecognize(config, audio);
 * }
 * </code>
 * </pre>
 */
package com.google.cloud.speech.spi.v1beta1;
