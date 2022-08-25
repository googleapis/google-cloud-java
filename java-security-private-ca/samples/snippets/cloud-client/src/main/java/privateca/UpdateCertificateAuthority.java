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

// [START privateca_update_ca_label]

import com.google.api.core.ApiFuture;
import com.google.cloud.security.privateca.v1.CertificateAuthority;
import com.google.cloud.security.privateca.v1.CertificateAuthorityName;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.UpdateCertificateAuthorityRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UpdateCertificateAuthority {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    // location: For a list of locations, see:
    // https://cloud.google.com/certificate-authority-service/docs/locations
    // pool_Id: Set it to the CA Pool under which the CA should be created.
    // certificateAuthorityName: Unique name for the CA.
    String project = "your-project-id";
    String location = "ca-location";
    String pool_Id = "ca-pool-id";
    String certificateAuthorityName = "certificate-authority-name";

    updateCaLabel(project, location, pool_Id, certificateAuthorityName);
  }

  // Updates the labels in a certificate authority.
  public static void updateCaLabel(
      String project, String location, String pool_Id, String certificateAuthorityName)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    /* Initialize client that will be used to send requests. This client only needs to be created
    once, and can be reused for multiple requests. After completing all of your requests, call
    the `certificateAuthorityServiceClient.close()` method on the client to safely
    clean up any remaining background resources. */
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {

      // Set the parent path and the new labels.
      String certificateAuthorityParent =
          CertificateAuthorityName.of(project, location, pool_Id, certificateAuthorityName)
              .toString();
      CertificateAuthority certificateAuthority =
          CertificateAuthority.newBuilder()
              .setName(certificateAuthorityParent)
              .putLabels("env", "test")
              .build();

      // Create a request to update the CA.
      UpdateCertificateAuthorityRequest request =
          UpdateCertificateAuthorityRequest.newBuilder()
              .setCertificateAuthority(certificateAuthority)
              .setUpdateMask(FieldMask.newBuilder().addPaths("labels").build())
              .build();

      // Update the CA and wait for the operation to complete.
      ApiFuture<Operation> futureCall =
          certificateAuthorityServiceClient
              .updateCertificateAuthorityCallable()
              .futureCall(request);
      Operation operation = futureCall.get(60, TimeUnit.SECONDS);

      // Check for errors.
      if (operation.hasError()) {
        System.out.println("Error in updating labels ! " + operation.getError());
      }

      // Get the updated CA and check if it contains the new label.
      CertificateAuthority response =
          certificateAuthorityServiceClient.getCertificateAuthority(certificateAuthorityParent);
      if (response.getLabelsMap().containsKey("env")
          && response.getLabelsMap().get("env").equalsIgnoreCase("test")) {
        System.out.println("Successfully updated the labels ! ");
      }
    }
  }
}
// [END privateca_update_ca_label]
