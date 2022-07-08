/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.examples.securitycenter.snippets.bigqueryexport;

// [START securitycenter_list_bigquery_export]

import com.google.cloud.securitycenter.v1.BigQueryExport;
import com.google.cloud.securitycenter.v1.ListBigQueryExportsRequest;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import com.google.cloud.securitycenter.v1.SecurityCenterClient.ListBigQueryExportsPagedResponse;
import java.io.IOException;

public class ListBigQueryExports {

  public static void main(String[] args) throws IOException {
    // TODO(Developer): Modify the following variable values.

    // parent: The parent, which owns the collection of BigQuery exports.
    //         Use any one of the following resource paths:
    //              - organizations/{organization_id}
    //              - folders/{folder_id}
    //              - projects/{project_id}
    String parent = String.format("projects/%s", "your-google-cloud-project-id");

    listBigQueryExports(parent);
  }

  // List BigQuery exports in the given parent.
  public static void listBigQueryExports(String parent) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SecurityCenterClient client = SecurityCenterClient.create()) {

      ListBigQueryExportsRequest request =
          ListBigQueryExportsRequest.newBuilder().setParent(parent).build();

      ListBigQueryExportsPagedResponse response = client.listBigQueryExports(request);

      System.out.println("Listing BigQuery exports:");
      for (BigQueryExport bigQueryExport : response.iterateAll()) {
        System.out.println(bigQueryExport.getName());
      }
    }
  }
}
// [END securitycenter_list_bigquery_export]
