/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

/**
 * A client to Google Cloud Natural Language API.
 *
 * The interfaces provided are listed below, along with a usage sample
 *
 * ==================
 * LanguageServiceApi
 * ==================
 *
 * Service Description: Provides text analysis operations such as sentiment analysis and entity
 * recognition.
 *
 * Sample for LanguageServiceApi:
 * <pre>
 * <code>
 * try (LanguageServiceApi languageServiceApi = LanguageServiceApi.create()) {
 *   Document document = Document.newBuilder().build();
 *   AnalyzeSentimentResponse response = languageServiceApi.analyzeSentiment(document);
 * }
 * </code>
 * </pre>
 *
 */
package com.google.cloud.language.spi.v1beta1;
