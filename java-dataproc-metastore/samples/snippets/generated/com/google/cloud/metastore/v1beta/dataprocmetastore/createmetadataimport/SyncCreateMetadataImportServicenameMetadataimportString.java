/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.metastore.v1beta.samples;

// [START metastore_v1beta_generated_DataprocMetastore_CreateMetadataImport_ServicenameMetadataimportString_sync]
import com.google.cloud.metastore.v1beta.DataprocMetastoreClient;
import com.google.cloud.metastore.v1beta.MetadataImport;
import com.google.cloud.metastore.v1beta.ServiceName;

public class SyncCreateMetadataImportServicenameMetadataimportString {

  public static void main(String[] args) throws Exception {
    syncCreateMetadataImportServicenameMetadataimportString();
  }

  public static void syncCreateMetadataImportServicenameMetadataimportString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
      ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
      MetadataImport metadataImport = MetadataImport.newBuilder().build();
      String metadataImportId = "metadataImportId1824548847";
      MetadataImport response =
          dataprocMetastoreClient
              .createMetadataImportAsync(parent, metadataImport, metadataImportId)
              .get();
    }
  }
}
// [END metastore_v1beta_generated_DataprocMetastore_CreateMetadataImport_ServicenameMetadataimportString_sync]
