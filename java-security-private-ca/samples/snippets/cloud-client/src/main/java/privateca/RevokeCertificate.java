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

// [START privateca_revoke_certificate]

import com.google.api.core.ApiFuture;
import com.google.cloud.security.privateca.v1.Certificate;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.CertificateName;
import com.google.cloud.security.privateca.v1.RevocationReason;
import com.google.cloud.security.privateca.v1.RevokeCertificateRequest;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class RevokeCertificate {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    // location: For a list of locations, see:
    // https://cloud.google.com/certificate-authority-service/docs/locations
    // pool_Id: Id for the CA pool which contains the certificate.
    // certificateName: Name of the certificate to be revoked.
    String project = "your-project-id";
    String location = "ca-location";
    String pool_Id = "ca-pool-id";
    String certificateName = "certificate-name";
    revokeCertificate(project, location, pool_Id, certificateName);
  }

  // Revoke an issued certificate. Once revoked, the certificate will become invalid and will expire
  // post its lifetime.
  public static void revokeCertificate(
      String project, String location, String pool_Id, String certificateName)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `certificateAuthorityServiceClient.close()` method on the client to safely
    // clean up any remaining background resources.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {

      // Create Certificate Name.
      CertificateName certificateNameParent =
          CertificateName.newBuilder()
              .setProject(project)
              .setLocation(location)
              .setCaPool(pool_Id)
              .setCertificate(certificateName)
              .build();

      // Create Revoke Certificate Request and specify the appropriate revocation reason.
      RevokeCertificateRequest revokeCertificateRequest =
          RevokeCertificateRequest.newBuilder()
              .setName(certificateNameParent.toString())
              .setReason(RevocationReason.PRIVILEGE_WITHDRAWN)
              .build();

      // Revoke certificate.
      ApiFuture<Certificate> response =
          certificateAuthorityServiceClient
              .revokeCertificateCallable()
              .futureCall(revokeCertificateRequest);
      Certificate certificateResponse = response.get();

      System.out.println("Certificate Revoked: " + certificateResponse.getName());
    }
  }
}
// [END privateca_revoke_certificate]
