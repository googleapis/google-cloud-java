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

// [START bigquery_create_dataset]

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;

public class CreateDataset {

  public static Dataset createDataset(String projectId, String datasetName) {

    // Get an instance of the BigQuery service.
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

    Dataset dataset = null;

    DatasetInfo datasetInfo = DatasetInfo.newBuilder(DatasetId.of(projectId, datasetName)).build();
    try {
      // the dataset was created
      dataset = bigquery.create(datasetInfo);
    } catch (BigQueryException e) {
      // the dataset was not created
    }
    return dataset;
  }
}

// [END bigquery_create_dataset]
