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

package com.example.analytics;

/* This application demonstrates the usage of the Analytics Admin API using
 service account credentials. For more information on service accounts, see
 https://cloud.google.com/iam/docs/understanding-service-accounts

 The following document provides instructions on setting service account
 credentials for your application:
 https://cloud.google.com/docs/authentication/production

 In a nutshell, you need to:

 1. Create a service account and download the key JSON file.
 https://cloud.google.com/docs/authentication/production#creating_a_service_account

 2. Provide service account credentials using one of the following options:
 - set the GOOGLE_APPLICATION_CREDENTIALS environment variable, the API
 client will use the value of this variable to find the service account key
 JSON file.

 https://cloud.google.com/docs/authentication/production#setting_the_environment_variable

 OR

 - manually pass the path to the service account key JSON file to the API client
 by specifying the keyFilename parameter in the constructor.
 https://cloud.google.com/docs/authentication/production#passing_the_path_to_the_service_account_key_in_code

 To run this sample using Maven:
   cd java-analytics-admin/samples/snippets
   mvn exec:java -Dexec.mainClass="com.example.analytics.QuickstartSample"
 */

// [START analytics_admin_quickstart]

import com.google.analytics.admin.v1alpha.Account;
import com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient;
import com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccountsPage;
import com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccountsPagedResponse;
import com.google.analytics.admin.v1alpha.ListAccountsRequest;

public class QuickstartSample {

  public static void main(String... args) throws Exception {
    listAccounts();
  }


  // This is an example snippet that calls the Google Analytics Admin API and lists all Google
  // Analytics accounts available to the authenticated user.
  static void listAccounts() throws Exception {
    // Instantiates a client using default credentials.
    // See https://cloud.google.com/docs/authentication/production for more information
    // about managing credentials.
    try (AnalyticsAdminServiceClient analyticsAdmin = AnalyticsAdminServiceClient.create()) {
      // Calls listAccounts() method of the Google Analytics Admin API and prints
      // the response for each account.
      ListAccountsPagedResponse response = analyticsAdmin
          .listAccounts(ListAccountsRequest.newBuilder().build());
      for (ListAccountsPage page : response.iteratePages()) {
        for (Account account : page.iterateAll()) {
          System.out.printf("Account name: %s%n", account.getName());
          System.out.printf("Display name: %s%n", account.getDisplayName());
          System.out.printf("Country code: %s%n", account.getRegionCode());
          System.out.printf("Create time: %s%n", account.getCreateTime().getSeconds());
          System.out.printf("Update time: %s%n", account.getUpdateTime().getSeconds());
          System.out.println();
        }
      }
    }
  }
}

// [END analytics_admin_quickstart]
