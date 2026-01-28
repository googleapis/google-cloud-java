/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bigquery;

// [START bigquery_authorized_dataset]
import com.google.cloud.bigquery.Acl;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public class AuthorizeDataset {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "PROJECT_ID";
    String sourceDatasetName = "BIGQUERY_SOURCE_DATASET_NAME";
    String userDatasetName = "BIGQUERY_USER_DATASET_NAME";
    authorizeDataset(
        DatasetId.of(projectId, sourceDatasetName), DatasetId.of(projectId, userDatasetName));
  }

  // This method will update sourceDataset's ACL with userDataset's ACL
  public static void authorizeDataset(DatasetId sourceDatasetId, DatasetId userDatasetId) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // Get both source and user dataset's references
      Dataset sourceDataset = bigquery.getDataset(sourceDatasetId);
      Dataset userDataset = bigquery.getDataset(userDatasetId);

      // Get the source dataset's ACL
      List<Acl> sourceDatasetAcl = new ArrayList<>(sourceDataset.getAcl());

      // Add the user dataset's DatasetAccessEntry object to the existing sourceDatasetAcl
      List<String> targetTypes = ImmutableList.of("VIEWS");
      Acl.DatasetAclEntity userDatasetAclEntity =
          new Acl.DatasetAclEntity(userDatasetId, targetTypes);
      sourceDatasetAcl.add(Acl.of(userDatasetAclEntity));

      // update the source dataset with user dataset's ACL
      Dataset updatedSourceDataset =
          sourceDataset.toBuilder().setAcl(sourceDatasetAcl).build().update();

      System.out.printf(
          "Dataset %s updated with the added authorization\n", updatedSourceDataset.getDatasetId());

    } catch (BigQueryException e) {
      System.out.println("Dataset Authorization failed due to error: \n" + e);
    }
  }
}
// [END bigquery_authorized_dataset]
