/*
 * Copyright 2015 Google LLC
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
 * A testing helper for Google BigQuery.
 *
 * <p>A simple usage example:
 *
 * <p>Before the test:
 *
 * <pre>{@code
 * RemoteBigQueryHelper bigqueryHelper = RemoteBigQueryHelper.create();
 * BigQuery bigquery = bigqueryHelper.getOptions().getService();
 * String dataset = RemoteBigQueryHelper.generateDatasetName();
 * bigquery.create(DatasetInfo.newBuilder(dataset).build());
 * }</pre>
 *
 * <p>After the test:
 *
 * <pre>{@code
 * RemoteBigQueryHelper.forceDelete(bigquery, DATASET);
 * }</pre>
 *
 * @see <a
 *     href="https://github.com/googleapis/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-bigquery">
 *     Google Cloud Java tools for testing</a>
 */
package com.google.cloud.bigquery.testing;
