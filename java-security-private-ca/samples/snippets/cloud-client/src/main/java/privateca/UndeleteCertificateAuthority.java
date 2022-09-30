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

// [START privateca_undelete_ca]

import com.google.api.core.ApiFuture;
import com.google.cloud.security.privateca.v1.CertificateAuthority.State;
import com.google.cloud.security.privateca.v1.CertificateAuthorityName;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.UndeleteCertificateAuthorityRequest;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UndeleteCertificateAuthority {

  public static void main(String[] args)
      throws InterruptedException, ExecutionException, TimeoutException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    // location: For a list of locations, see:
    // https://cloud.google.com/certificate-authority-service/docs/locations
    // pool_Id: The id of the CA pool under which the deleted CA is present.
    // certificateAuthorityName: The name of the CA to be restored (undeleted).
    String project = "your-project-id";
    String location = "ca-location";
    String pool_Id = "ca-pool-id";
    String certificateAuthorityName = "certificate-authority-name";

    undeleteCertificateAuthority(project, location, pool_Id, certificateAuthorityName);
  }

  // Restore a deleted CA, if still within the grace period of 30 days.
  public static void undeleteCertificateAuthority(
      String project, String location, String pool_Id, String certificateAuthorityName)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `certificateAuthorityServiceClient.close()` method on the client to safely
    // clean up any remaining background resources.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {

      String certificateAuthorityParent =
          CertificateAuthorityName.of(project, location, pool_Id, certificateAuthorityName)
              .toString();

      // Confirm if the CA is in DELETED stage.
      if (getCurrentState(certificateAuthorityServiceClient, certificateAuthorityParent)
          != State.DELETED) {
        System.out.println("CA is not deleted !");
        return;
      }

      // Create the Request.
      UndeleteCertificateAuthorityRequest undeleteCertificateAuthorityRequest =
          UndeleteCertificateAuthorityRequest.newBuilder()
              .setName(certificateAuthorityParent)
              .build();

      // Undelete the CA.
      ApiFuture<Operation> futureCall =
          certificateAuthorityServiceClient
              .undeleteCertificateAuthorityCallable()
              .futureCall(undeleteCertificateAuthorityRequest);

      Operation response = futureCall.get(5, TimeUnit.SECONDS);

      // CA state changes from DELETED to DISABLED if successfully restored.
      // Confirm if the CA is DISABLED.
      if (response.hasError()
          || getCurrentState(certificateAuthorityServiceClient, certificateAuthorityParent)
              != State.DISABLED) {
        System.out.println(
            "Unable to restore the Certificate Authority! Please try again !"
                + response.getError());
        return;
      }

      // The CA will be in the DISABLED state. Enable before use.
      System.out.println(
          "Successfully restored the Certificate Authority ! " + certificateAuthorityName);
    }
  }

  // Get the current state of CA.
  private static State getCurrentState(
      CertificateAuthorityServiceClient client, String certificateAuthorityParent) {
    return client.getCertificateAuthority(certificateAuthorityParent).getState();
  }
}
// [END privateca_undelete_ca]
