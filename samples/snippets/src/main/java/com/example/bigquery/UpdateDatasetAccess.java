/*
 * Copyright 2019 Google LLC
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

// [START bigquery_update_dataset_access]
import com.google.cloud.bigquery.Acl;
import com.google.cloud.bigquery.Acl.Role;
import com.google.cloud.bigquery.Acl.User;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import java.util.ArrayList;

public class UpdateDatasetAccess {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    // Create a new ACL granting the READER role to "sample.bigquery.dev@gmail.com"
    // For more information on the types of ACLs available see:
    // https://cloud.google.com/storage/docs/access-control/lists
    Acl newEntry = Acl.of(new User("sample.bigquery.dev@gmail.com"), Role.READER);

    updateDatasetAccess(datasetName, newEntry);
  }

  public static void updateDatasetAccess(String datasetName, Acl newEntry) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      Dataset dataset = bigquery.getDataset(datasetName);

      // Get a copy of the ACLs list from the dataset and append the new entry
      ArrayList<Acl> acls = new ArrayList<>(dataset.getAcl());
      acls.add(newEntry);

      bigquery.update(dataset.toBuilder().setAcl(acls).build());
      System.out.println("Dataset Access Control updated successfully");
    } catch (BigQueryException e) {
      System.out.println("Dataset Access control was not updated \n" + e.toString());
    }
  }
}
// [END bigquery_update_dataset_access]
