/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package privateca;

// [START privateca_create_ca_pool]

import com.google.api.core.ApiFuture;
import com.google.cloud.security.privateca.v1.CaPool;
import com.google.cloud.security.privateca.v1.CaPool.Tier;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.CreateCaPoolRequest;
import com.google.cloud.security.privateca.v1.LocationName;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class CreateCaPool {

  public static void main(String[] args)
      throws InterruptedException, ExecutionException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    // location: For a list of locations, see:
    // https://cloud.google.com/certificate-authority-service/docs/locations
    // pool_Id: Set a unique pool_Id for the CA pool.
    String project = "your-project-id";
    String location = "ca-location";
    String pool_Id = "ca-pool-id";
    createCaPool(project, location, pool_Id);
  }

  // Create a Certificate Authority Pool. All certificates created under this CA pool will
  // follow the same issuance policy, IAM policies,etc.,
  public static void createCaPool(String project, String location, String pool_Id)
      throws InterruptedException, ExecutionException, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `certificateAuthorityServiceClient.close()` method on the client to safely
    // clean up any remaining background resources.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {

      /* Create the pool request
        Set Parent which denotes the project id and location.
        Set the Tier (see: https://cloud.google.com/certificate-authority-service/docs/tiers).
      */
      CreateCaPoolRequest caPoolRequest =
          CreateCaPoolRequest.newBuilder()
              .setParent(LocationName.of(project, location).toString())
              .setCaPoolId(pool_Id)
              .setCaPool(CaPool.newBuilder().setTier(Tier.ENTERPRISE).build())
              .build();

      // Create the CA pool.
      ApiFuture<Operation> futureCall =
          certificateAuthorityServiceClient.createCaPoolCallable().futureCall(caPoolRequest);
      Operation response = futureCall.get();

      if (response.hasError()) {
        System.out.println("Error while creating CA pool !" + response.getError());
        return;
      }

      System.out.println("CA pool created successfully: " + pool_Id);
    }
  }
}
// [END privateca_create_ca_pool]
