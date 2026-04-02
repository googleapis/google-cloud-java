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

// [START bigquery_grant_view_access]
import com.google.cloud.bigquery.Acl;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.Table;
import java.util.ArrayList;
import java.util.List;

// Sample to grant view access on dataset
public class GrantViewAccess {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String srcDatasetId = "MY_DATASET_ID";
    String viewDatasetId = "MY_VIEW_DATASET_ID";
    String viewId = "MY_VIEW_ID";
    grantViewAccess(srcDatasetId, viewDatasetId, viewId);
  }

  public static void grantViewAccess(String srcDatasetId, String viewDatasetId, String viewId) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      Dataset srcDataset = bigquery.getDataset(srcDatasetId);
      Dataset viewDataset = bigquery.getDataset(viewDatasetId);
      Table view = viewDataset.get(viewId);
      // First, we'll add a group to the ACL for the dataset containing the view. This will allow
      // users within that group to query the view, but they must have direct access to any tables
      // referenced by the view.
      List<Acl> viewAcl = new ArrayList<>(viewDataset.getAcl());
      viewAcl.add(Acl.of(new Acl.Group("example-analyst-group@google.com"), Acl.Role.READER));
      viewDataset.toBuilder().setAcl(viewAcl).build().update();
      // Now, we'll authorize a specific view against a source dataset, delegating access
      // enforcement. Once this has been completed, members of the group previously added to the
      // view dataset's ACL no longer require access to the source dataset to successfully query the
      // view
      List<Acl> srcAcl = new ArrayList<>(srcDataset.getAcl());
      srcAcl.add(Acl.of(new Acl.View(view.getTableId())));
      srcDataset.toBuilder().setAcl(srcAcl).build().update();
      System.out.println("Grant view access successfully");
    } catch (BigQueryException e) {
      System.out.println("Grant view access was not success. \n" + e.toString());
    }
  }
}
// [END bigquery_grant_view_access]
