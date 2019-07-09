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

// [START bigquery_label_dataset]

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;

import java.util.Map;

public class LabelDataset {

    public Dataset labelDataset(String projectId, String datasetName, Map<String, String> labels) {
        // Get an instance of the BigQuery service.
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

        Dataset oldDataset = bigquery.getDataset(DatasetId.of(projectId, datasetName));
        DatasetInfo datasetInfo = oldDataset.toBuilder().setLabels(labels).build();
        Dataset newDataset = bigquery.update(datasetInfo);
        return newDataset;
    }
}

// [END bigquery_label_dataset]

