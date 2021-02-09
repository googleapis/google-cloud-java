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
 * <p>======================= TranslationServiceClient =======================
 *
 * <p>Service Description: Provides natural language translation operations.
 *
 * <p>Sample for TranslationServiceClient:
 *
 * <pre>{@code
 * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
 *   TranslateTextRequest request =
 *       TranslateTextRequest.newBuilder()
 *           .addAllContents(new ArrayList<String>())
 *           .setMimeType("mimeType-1392120434")
 *           .setSourceLanguageCode("sourceLanguageCode1645917472")
 *           .setTargetLanguageCode("targetLanguageCode-106414698")
 *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
 *           .setModel("model104069929")
 *           .setGlossaryConfig(TranslateTextGlossaryConfig.newBuilder().build())
 *           .putAllLabels(new HashMap<String, String>())
 *           .build();
 *   TranslateTextResponse response = translationServiceClient.translateText(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.translate.v3beta1;

import javax.annotation.Generated;
