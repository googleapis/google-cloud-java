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

// [START privateca_create_certificate_csr]

import com.google.api.core.ApiFuture;
import com.google.cloud.security.privateca.v1.CaPoolName;
import com.google.cloud.security.privateca.v1.Certificate;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.CreateCertificateRequest;
import com.google.protobuf.Duration;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class CreateCertificate_CSR {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.

    // location: For a list of locations, see:
    // https://cloud.google.com/certificate-authority-service/docs/locations
    // pool_Id: Set a unique id for the CA pool.
    // certificateAuthorityName: The name of the certificate authority to sign the CSR.
    // certificateName: Set a unique name for the certificate.
    // pemCSR: Set the Certificate Issuing Request in the pem encoded format.
    String project = "your-project-id";
    String location = "ca-location";
    String pool_Id = "ca-pool-id";
    String certificateAuthorityName = "certificate-authority-name";
    String certificateName = "certificate-name";
    String pemCSR =
        "-----BEGIN CERTIFICATE REQUEST-----\n"
            + "sample-pem-csr-format\n"
            + "-----END CERTIFICATE REQUEST-----";

    createCertificateWithCSR(
        project, location, pool_Id, certificateAuthorityName, certificateName, pemCSR);
  }

  // Create a Certificate which is issued by the specified Certificate Authority.
  // The certificate details and the public key is provided as a CSR (Certificate Signing Request).
  public static void createCertificateWithCSR(
      String project,
      String location,
      String pool_Id,
      String certificateAuthorityName,
      String certificateName,
      String pemCSR)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `certificateAuthorityServiceClient.close()` method on the client to safely
    // clean up any remaining background resources.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      // certificateLifetime: The validity of the certificate in seconds.
      long certificateLifetime = 1000L;

      // Create certificate with CSR.
      // The pemCSR contains the public key and the domain details required.
      Certificate certificate =
          Certificate.newBuilder()
              .setPemCsr(pemCSR)
              .setLifetime(Duration.newBuilder().setSeconds(certificateLifetime).build())
              .build();

      // Create the Certificate Request.
      // Set the CA which is responsible for creating the certificate with the provided CSR.
      CreateCertificateRequest certificateRequest =
          CreateCertificateRequest.newBuilder()
              .setParent(CaPoolName.of(project, location, pool_Id).toString())
              .setIssuingCertificateAuthorityId(certificateAuthorityName)
              .setCertificateId(certificateName)
              .setCertificate(certificate)
              .build();

      // Get the certificate response.
      ApiFuture<Certificate> future =
          certificateAuthorityServiceClient
              .createCertificateCallable()
              .futureCall(certificateRequest);

      Certificate certificateResponse = future.get();

      System.out.println("Certificate created successfully : " + certificateResponse.getName());

      // Get the signed certificate and the issuer chain list.
      System.out.println("Signed certificate:\n " + certificateResponse.getPemCertificate());
      System.out.println("Issuer chain list:\n" + certificateResponse.getPemCertificateChainList());
    }
  }
}
// [END privateca_create_certificate_csr]
