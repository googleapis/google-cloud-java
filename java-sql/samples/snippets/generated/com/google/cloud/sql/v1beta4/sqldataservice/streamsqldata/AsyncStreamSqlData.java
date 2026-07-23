/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.sql.v1beta4.samples;

// [START sqladmin_v1beta4_generated_SqlDataService_StreamSqlData_async]
import com.google.api.gax.rpc.BidiStream;
import com.google.cloud.sql.v1beta4.Ack;
import com.google.cloud.sql.v1beta4.InstanceName;
import com.google.cloud.sql.v1beta4.SqlDataServiceClient;
import com.google.cloud.sql.v1beta4.StreamSqlDataRequest;
import com.google.cloud.sql.v1beta4.StreamSqlDataResponse;

public class AsyncStreamSqlData {

  public static void main(String[] args) throws Exception {
    asyncStreamSqlData();
  }

  public static void asyncStreamSqlData() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SqlDataServiceClient sqlDataServiceClient = SqlDataServiceClient.create()) {
      BidiStream<StreamSqlDataRequest, StreamSqlDataResponse> bidiStream =
          sqlDataServiceClient.streamSqlDataCallable().call();
      StreamSqlDataRequest request =
          StreamSqlDataRequest.newBuilder()
              .setAck(Ack.newBuilder().build())
              .setInstanceId(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
              .build();
      bidiStream.send(request);
      for (StreamSqlDataResponse response : bidiStream) {
        // Do something when a response is received.
      }
    }
  }
}
// [END sqladmin_v1beta4_generated_SqlDataService_StreamSqlData_async]
