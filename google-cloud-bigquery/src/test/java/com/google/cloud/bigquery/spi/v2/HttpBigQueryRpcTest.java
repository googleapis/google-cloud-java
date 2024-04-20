/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigquery.spi.v2;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.services.bigquery.model.Dataset;
import com.google.api.services.bigquery.model.DatasetList;
import com.google.api.services.bigquery.model.DatasetReference;
import java.util.Collections;
import org.junit.Test;

public class HttpBigQueryRpcTest {
  @Test
  public void testListToDataset() {
    DatasetReference datasetRef =
        new DatasetReference().setDatasetId("dataset-id").setProjectId("project-id");

    DatasetList.Datasets listDataSet =
        new DatasetList.Datasets()
            .setDatasetReference(datasetRef)
            .setId("project-id:dataset-id")
            .setFriendlyName("friendly")
            .setKind("bigquery#dataset")
            .setLabels(Collections.singletonMap("foo", "bar"))
            .setLocation("test-region-1");
    Dataset dataset = HttpBigQueryRpc.LIST_TO_DATASET.apply(listDataSet);

    assertThat(dataset.getKind()).isEqualTo("bigquery#dataset");
    assertThat(dataset.getId()).isEqualTo("project-id:dataset-id");
    assertThat(dataset.getFriendlyName()).isEqualTo("friendly");
    assertThat(dataset.getDatasetReference()).isEqualTo(datasetRef);
    assertThat(dataset.getLabels()).containsExactly("foo", "bar");
    assertThat(dataset.getLocation()).isEqualTo("test-region-1");
  }
}
