/*
 * Copyright 2020 Google LLC
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

import com.google.cloud.bigquery.Acl;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.ViewDefinition;
import java.util.ArrayList;
import java.util.List;

// Sample of authorized view tutorial.
public class AuthorizedViewTutorial {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String sourceDatasetId = "MY_SOURCE_DATASET";
    String sourceTableId = "MY_SOURCE_TABLE";
    String sharedDatasetId = "SHARED_VIEWS";
    String sharedViewId = "MY_VIEW";
    authorizedViewTutorial(
        projectId, sourceDatasetId, sourceTableId, sharedDatasetId, sharedViewId);
  }

  public static void authorizedViewTutorial(
      String projectId,
      String sourceDatasetId,
      String sourceTableId,
      String sharedDatasetId,
      String sharedViewId) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
      // [START bigquery_authorized_view_tutorial]
      // [START bigquery_avt_create_source_dataset]
      // Create a source dataset to store your table.
      final Dataset sourceDataset = bigquery.create(DatasetInfo.of(sourceDatasetId));
      // [END bigquery_avt_create_source_dataset]
      // [START bigquery_avt_create_source_table]
      // Populate a source table
      String tableQuery =
          "SELECT commit, author, committer, repo_name"
              + " FROM `bigquery-public-data.github_repos.commits`"
              + " LIMIT 1000";
      QueryJobConfiguration queryConfig =
          QueryJobConfiguration.newBuilder(tableQuery)
              .setDestinationTable(TableId.of(sourceDatasetId, sourceTableId))
              .build();
      bigquery.query(queryConfig);
      // [END bigquery_avt_create_source_table]
      // [START bigquery_avt_create_shared_dataset]
      // Create a separate dataset to store your view
      Dataset sharedDataset = bigquery.create(DatasetInfo.of(sharedDatasetId));
      // [END bigquery_avt_create_shared_dataset]
      // [START bigquery_avt_create_view]
      // Create the view in the new dataset
      String viewQuery =
          String.format(
              "SELECT commit, author.name as author, "
                  + "committer.name as committer, repo_name FROM %s.%s.%s",
              projectId, sourceDatasetId, sourceTableId);
      ViewDefinition viewDefinition = ViewDefinition.of(viewQuery);
      Table view =
          bigquery.create(TableInfo.of(TableId.of(sharedDatasetId, sharedViewId), viewDefinition));
      // [END bigquery_avt_create_view]
      // [START bigquery_avt_shared_dataset_access]
      // Assign access controls to the dataset containing the view
      List<Acl> viewAcl = new ArrayList<>(sharedDataset.getAcl());
      viewAcl.add(Acl.of(new Acl.Group("example-analyst-group@google.com"), Acl.Role.READER));
      sharedDataset.toBuilder().setAcl(viewAcl).build().update();
      // [END bigquery_avt_shared_dataset_access]
      // [START bigquery_avt_source_dataset_access]
      // Authorize the view to access the source dataset
      List<Acl> srcAcl = new ArrayList<>(sourceDataset.getAcl());
      srcAcl.add(Acl.of(new Acl.View(view.getTableId())));
      sourceDataset.toBuilder().setAcl(srcAcl).build().update();
      // [END bigquery_avt_source_dataset_access]
      // [END bigquery_authorized_view_tutorial]
      System.out.println("Authorized view tutorial successfully");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Authorized view tutorial was not success. \n" + e.toString());
    }
  }
}
