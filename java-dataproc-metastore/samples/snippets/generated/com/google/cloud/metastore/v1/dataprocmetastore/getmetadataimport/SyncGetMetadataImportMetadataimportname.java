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

package com.google.cloud.metastore.v1.samples;

// [START metastore_v1_generated_DataprocMetastore_GetMetadataImport_Metadataimportname_sync]
import com.google.cloud.metastore.v1.DataprocMetastoreClient;
import com.google.cloud.metastore.v1.MetadataImport;
import com.google.cloud.metastore.v1.MetadataImportName;

public class SyncGetMetadataImportMetadataimportname {

  public static void main(String[] args) throws Exception {
    syncGetMetadataImportMetadataimportname();
  }

  public static void syncGetMetadataImportMetadataimportname() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
      MetadataImportName name =
          MetadataImportName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[METADATA_IMPORT]");
      MetadataImport response = dataprocMetastoreClient.getMetadataImport(name);
    }
  }
}
// [END metastore_v1_generated_DataprocMetastore_GetMetadataImport_Metadataimportname_sync]
