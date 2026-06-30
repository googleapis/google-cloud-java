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

// [START bigquery_update_iam_policy]
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.TableId;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Sample to update iam policy in table
public class UpdateIamPolicy {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    updateIamPolicy(datasetName, tableName);
  }

  public static void updateIamPolicy(String datasetName, String tableName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(datasetName, tableName);

      Policy policy = bigquery.getIamPolicy(tableId);
      Map<Role, Set<Identity>> binding = new HashMap<>(policy.getBindings());
      binding.remove(Role.of("roles/bigquery.dataViewer"));

      policy.toBuilder().setBindings(binding).build();
      bigquery.setIamPolicy(tableId, policy);

      System.out.println("Iam policy updated successfully");
    } catch (BigQueryException e) {
      System.out.println("Iam policy was not updated. \n" + e.toString());
    }
  }
}
// [END bigquery_update_iam_policy]
