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

package com.example.bigquerydatatransfer;

// [START bigquerydatatransfer_create_redshift_transfer]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest;
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient;
import com.google.cloud.bigquery.datatransfer.v1.ProjectName;
import com.google.cloud.bigquery.datatransfer.v1.TransferConfig;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Sample to create redshift transfer config
public class CreateRedshiftTransfer {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "MY_PROJECT_ID";
    String datasetId = "MY_DATASET_ID";
    String datasetRegion = "US";
    String jdbcUrl = "MY_JDBC_URL_CONNECTION_REDSHIFT";
    String dbUserName = "MY_USERNAME";
    String dbPassword = "MY_PASSWORD";
    String accessKeyId = "MY_AWS_ACCESS_KEY_ID";
    String secretAccessId = "MY_AWS_SECRET_ACCESS_ID";
    String s3Bucket = "MY_S3_BUCKET_URI";
    String redShiftSchema = "MY_REDSHIFT_SCHEMA";
    String tableNamePatterns = "*";
    String vpcAndReserveIpRange = "MY_VPC_AND_IP_RANGE";
    Map<String, Value> params = new HashMap<>();
    params.put("jdbc_url", Value.newBuilder().setStringValue(jdbcUrl).build());
    params.put("database_username", Value.newBuilder().setStringValue(dbUserName).build());
    params.put("database_password", Value.newBuilder().setStringValue(dbPassword).build());
    params.put("access_key_id", Value.newBuilder().setStringValue(accessKeyId).build());
    params.put("secret_access_key", Value.newBuilder().setStringValue(secretAccessId).build());
    params.put("s3_bucket", Value.newBuilder().setStringValue(s3Bucket).build());
    params.put("redshift_schema", Value.newBuilder().setStringValue(redShiftSchema).build());
    params.put("table_name_patterns", Value.newBuilder().setStringValue(tableNamePatterns).build());
    params.put(
        "migration_infra_cidr", Value.newBuilder().setStringValue(vpcAndReserveIpRange).build());
    TransferConfig transferConfig =
        TransferConfig.newBuilder()
            .setDestinationDatasetId(datasetId)
            .setDatasetRegion(datasetRegion)
            .setDisplayName("Your Redshift Config Name")
            .setDataSourceId("redshift")
            .setParams(Struct.newBuilder().putAllFields(params).build())
            .setSchedule("every 24 hours")
            .build();
    createRedshiftTransfer(projectId, transferConfig);
  }

  public static void createRedshiftTransfer(String projectId, TransferConfig transferConfig)
      throws IOException {
    try (DataTransferServiceClient client = DataTransferServiceClient.create()) {
      ProjectName parent = ProjectName.of(projectId);
      CreateTransferConfigRequest request =
          CreateTransferConfigRequest.newBuilder()
              .setParent(parent.toString())
              .setTransferConfig(transferConfig)
              .build();
      TransferConfig config = client.createTransferConfig(request);
      System.out.println("Cloud redshift transfer created successfully :" + config.getName());
    } catch (ApiException ex) {
      System.out.print("Cloud redshift transfer was not created." + ex.toString());
    }
  }
}
// [END bigquerydatatransfer_create_redshift_transfer]
