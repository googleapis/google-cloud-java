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

package com.google.cloud.clouddms.v1.samples;

// [START datamigration_v1_generated_DataMigrationService_CreateMappingRule_StringMappingruleString_sync]
import com.google.cloud.clouddms.v1.ConversionWorkspaceName;
import com.google.cloud.clouddms.v1.DataMigrationServiceClient;
import com.google.cloud.clouddms.v1.MappingRule;

public class SyncCreateMappingRuleStringMappingruleString {

  public static void main(String[] args) throws Exception {
    syncCreateMappingRuleStringMappingruleString();
  }

  public static void syncCreateMappingRuleStringMappingruleString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataMigrationServiceClient dataMigrationServiceClient =
        DataMigrationServiceClient.create()) {
      String parent =
          ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
              .toString();
      MappingRule mappingRule = MappingRule.newBuilder().build();
      String mappingRuleId = "mappingRuleId-900824155";
      MappingRule response =
          dataMigrationServiceClient.createMappingRule(parent, mappingRule, mappingRuleId);
    }
  }
}
// [END datamigration_v1_generated_DataMigrationService_CreateMappingRule_StringMappingruleString_sync]
