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

/**
 * A client to Cloud Translation API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================== TranslationServiceClient ========================
 *
 * <p>Service Description: Provides natural language translation operations.
 *
 * <p>Sample for TranslationServiceClient:
 *
 * <pre>
 * <code>
 * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
 *   String formattedParent = TranslationServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
 *   String model = "";
 *   String mimeType = "";
 *   DetectLanguageResponse response = translationServiceClient.detectLanguage(formattedParent, model, mimeType);
 * }
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
package com.google.cloud.translate.v3beta1;

import javax.annotation.Generated;
