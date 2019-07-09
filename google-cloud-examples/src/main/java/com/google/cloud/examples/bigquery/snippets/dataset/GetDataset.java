/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.examples.bigquery.snippets.dataset;

// [START bigquery_get_dataset]

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;

public class GetDataset {

  public static Dataset getDataset(String projectId, String datasetName) {
    // Get an instance of the BigQuery service.
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

    DatasetId datasetId = DatasetId.of(projectId, datasetName);
    Dataset dataset = bigquery.getDataset(datasetId);
    return dataset;
  }
}

// [END bigquery_get_dataset]
