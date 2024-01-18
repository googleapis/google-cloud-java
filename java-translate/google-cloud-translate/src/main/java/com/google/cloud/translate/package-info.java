/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A client for Cloud Translation - Fast, dynamic translation.
 *
 * <p>Here's a simple usage example for Google Cloud Translation. This example shows how to detect
 * the language of some text and how to translate some text. The example assumes that either
 * Application Default Credentials are available or that the {@code GOOGLE_API_KEY} environment
 * variable is set and contains a valid API key. Alternatively, you can use {@link
 * com.google.cloud.ServiceOptions.Builder#setCredentials setCredentials} to set credentials, or
 * {@link com.google.cloud.translate.TranslateOptions.Builder#setApiKey(java.lang.String)} to set an
 * API key. For the complete source code see <a
 * href="https://github.com/googleapis/google-cloud-java/tree/master/google-cloud-examples/src/main/java/com/google/cloud/examples/translate/snippets/DetectLanguageAndTranslate.java">
 * DetectLanguageAndTranslate.java</a>.
 *
 * <pre>
 * {@code Translate translate = TranslateOptions.getDefaultInstance().getService();
 *
 * Detection detection = translate.detect("Hola");
 * String detectedLanguage = detection.getLanguage();
 *
 * Translation translation = translate.translate(
 *     "World",
 *     TranslateOption.sourceLanguage("en"),
 *     TranslateOption.targetLanguage(detectedLanguage));
 *
 * System.out.printf("Hola %s%n", translation.getTranslatedText());
 * }</pre>
 */
package com.google.cloud.translate;
