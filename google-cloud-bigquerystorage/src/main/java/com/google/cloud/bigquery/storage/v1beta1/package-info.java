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
 * <p>======================= BaseBigQueryStorageClient =======================
 *
 * <p>Service Description: BigQuery storage API.
 *
 * <p>The BigQuery storage API can be used to read data stored in BigQuery.
 *
 * <p>Sample for BaseBigQueryStorageClient:
 *
 * <pre>{@code
 * try (BaseBigQueryStorageClient baseBigQueryStorageClient = BaseBigQueryStorageClient.create()) {
 *   TableReferenceProto.TableReference tableReference =
 *       TableReferenceProto.TableReference.newBuilder().build();
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   int requestedStreams = 1017221410;
 *   Storage.ReadSession response =
 *       baseBigQueryStorageClient.createReadSession(tableReference, parent, requestedStreams);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.bigquery.storage.v1beta1;

import javax.annotation.Generated;
