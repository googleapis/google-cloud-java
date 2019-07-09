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

// [START bigquery_list_datasets]

import com.google.api.gax.paging.Page;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;

public class ListDatasets {

    public static Page<Dataset> listDatasets() {

        // Get an instance of the BigQuery service.
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

        // List datasets in the default project.
        Page<Dataset> datasets = bigquery.listDatasets(BigQuery.DatasetListOption.pageSize(100));
        for (Dataset dataset : datasets.iterateAll()) {
            System.out.println("Dataset: " + dataset.getDatasetId().getDataset());
        }
        return datasets;
    }
}

// [END bigquery_list_datasets]
