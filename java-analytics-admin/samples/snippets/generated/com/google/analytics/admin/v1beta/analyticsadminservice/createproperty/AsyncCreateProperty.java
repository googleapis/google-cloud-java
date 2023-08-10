/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.analytics.admin.v1beta.samples;

// [START analyticsadmin_v1beta_generated_AnalyticsAdminService_CreateProperty_async]
import com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient;
import com.google.analytics.admin.v1beta.CreatePropertyRequest;
import com.google.analytics.admin.v1beta.Property;
import com.google.api.core.ApiFuture;

public class AsyncCreateProperty {

  public static void main(String[] args) throws Exception {
    asyncCreateProperty();
  }

  public static void asyncCreateProperty() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
        AnalyticsAdminServiceClient.create()) {
      CreatePropertyRequest request =
          CreatePropertyRequest.newBuilder().setProperty(Property.newBuilder().build()).build();
      ApiFuture<Property> future =
          analyticsAdminServiceClient.createPropertyCallable().futureCall(request);
      // Do something.
      Property response = future.get();
    }
  }
}
// [END analyticsadmin_v1beta_generated_AnalyticsAdminService_CreateProperty_async]
