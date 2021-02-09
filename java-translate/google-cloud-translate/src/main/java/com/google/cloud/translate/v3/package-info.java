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
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   String targetLanguageCode = "targetLanguageCode-106414698";
 *   List<String> contents = new ArrayList<>();
 *   TranslateTextResponse response =
 *       translationServiceClient.translateText(parent, targetLanguageCode, contents);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.translate.v3;

import javax.annotation.Generated;
