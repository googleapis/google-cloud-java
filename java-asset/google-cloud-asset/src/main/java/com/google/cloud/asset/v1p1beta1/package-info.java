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
 * <p>======================= AssetServiceClient =======================
 *
 * <p>Service Description: Asset service definition.
 *
 * <p>Sample for AssetServiceClient:
 *
 * <pre>{@code
 * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
 *   String scope = "scope109264468";
 *   String query = "query107944136";
 *   List<String> assetTypes = new ArrayList<>();
 *   for (StandardResourceMetadata element :
 *       assetServiceClient.searchAllResources(scope, query, assetTypes).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.asset.v1p1beta1;

import javax.annotation.Generated;
