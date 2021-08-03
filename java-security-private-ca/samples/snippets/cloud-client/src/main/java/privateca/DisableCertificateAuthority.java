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

// [START privateca_disable_ca]

import com.google.api.core.ApiFuture;
import com.google.cloud.security.privateca.v1.CertificateAuthority.State;
import com.google.cloud.security.privateca.v1.CertificateAuthorityName;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.DisableCertificateAuthorityRequest;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class DisableCertificateAuthority {

  public static void main(String[] args)
      throws InterruptedException, ExecutionException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    // location: For a list of locations, see:
    // https://cloud.google.com/certificate-authority-service/docs/locations
    // pool_Id: The id of the CA pool under which the CA is present.
    // certificateAuthorityName: The name of the CA to be disabled.
    String project = "your-project-id";
    String location = "ca-location";
    String pool_Id = "ca-pool-id";
    String certificateAuthorityName = "certificate-authority-name";
    disableCertificateAuthority(project, location, pool_Id, certificateAuthorityName);
  }

  // Disable a Certificate Authority which is present in the given CA pool.
  public static void disableCertificateAuthority(
      String project, String location, String pool_Id, String certificateAuthorityName)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `certificateAuthorityServiceClient.close()` method on the client to safely
    // clean up any remaining background resources.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {

      // Create the Certificate Authority Name.
      CertificateAuthorityName certificateAuthorityNameParent =
          CertificateAuthorityName.newBuilder()
              .setProject(project)
              .setLocation(location)
              .setCaPool(pool_Id)
              .setCertificateAuthority(certificateAuthorityName)
              .build();

      // Create the Disable Certificate Authority Request.
      DisableCertificateAuthorityRequest disableCertificateAuthorityRequest =
          DisableCertificateAuthorityRequest.newBuilder()
              .setName(certificateAuthorityNameParent.toString())
              .build();

      // Disable the Certificate Authority.
      ApiFuture<Operation> futureCall =
          certificateAuthorityServiceClient
              .disableCertificateAuthorityCallable()
              .futureCall(disableCertificateAuthorityRequest);
      Operation response = futureCall.get();

      if (response.hasError()) {
        System.out.println("Error while disabling Certificate Authority !" + response.getError());
        return;
      }

      // Get the current CA state.
      State caState =
          certificateAuthorityServiceClient
              .getCertificateAuthority(certificateAuthorityNameParent)
              .getState();

      // Check if the Certificate Authority is disabled.
      if (caState == State.DISABLED) {
        System.out.println("Disabled Certificate Authority : " + certificateAuthorityName);
      } else {
        System.out.println(
            "Cannot disable the Certificate Authority ! Current CA State: " + caState);
      }
    }
  }
}
// [END privateca_disable_ca]
