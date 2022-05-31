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

// [START privateca_create_certificate]

import com.google.api.core.ApiFuture;
import com.google.cloud.security.privateca.v1.CaPoolName;
import com.google.cloud.security.privateca.v1.Certificate;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.CertificateConfig;
import com.google.cloud.security.privateca.v1.CertificateConfig.SubjectConfig;
import com.google.cloud.security.privateca.v1.CreateCertificateRequest;
import com.google.cloud.security.privateca.v1.KeyUsage;
import com.google.cloud.security.privateca.v1.KeyUsage.ExtendedKeyUsageOptions;
import com.google.cloud.security.privateca.v1.KeyUsage.KeyUsageOptions;
import com.google.cloud.security.privateca.v1.PublicKey;
import com.google.cloud.security.privateca.v1.PublicKey.KeyFormat;
import com.google.cloud.security.privateca.v1.Subject;
import com.google.cloud.security.privateca.v1.SubjectAltNames;
import com.google.cloud.security.privateca.v1.X509Parameters;
import com.google.cloud.security.privateca.v1.X509Parameters.CaOptions;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class CreateCertificate {

  public static void main(String[] args)
      throws InterruptedException, ExecutionException, IOException {
    // TODO(developer): Replace these variables before running the sample.

    // publicKeyBytes: Public key used in signing the certificates.
    // location: For a list of locations, see:
    // https://cloud.google.com/certificate-authority-service/docs/locations
    // pool_Id: Set a unique id for the CA pool.
    // certificateAuthorityName: The name of the certificate authority which issues the certificate.
    // certificateName: Set a unique name for the certificate.
    String project = "your-project-id";
    ByteString publicKeyBytes = ByteString.copyFrom(new byte[] {});
    String location = "ca-location";
    String pool_Id = "ca-pool_Id";
    String certificateAuthorityName = "certificate-authority-name";
    String certificateName = "certificate-name";

    createCertificate(
        project, location, pool_Id, certificateAuthorityName, certificateName, publicKeyBytes);
  }

  // Create a Certificate which is issued by the Certificate Authority present in the CA Pool.
  // The public key used to sign the certificate can be generated using any crypto
  // library/framework.
  public static void createCertificate(
      String project,
      String location,
      String pool_Id,
      String certificateAuthorityName,
      String certificateName,
      ByteString publicKeyBytes)
      throws InterruptedException, ExecutionException, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `certificateAuthorityServiceClient.close()` method on the client to safely
    // clean up any remaining background resources.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {

      // commonName: Enter a title for your certificate.
      // orgName: Provide the name of your company.
      // domainName: List the fully qualified domain name.
      // certificateLifetime: The validity of the certificate in seconds.
      String commonName = "common-name";
      String orgName = "org-name";
      String domainName = "dns.your-domain.com";
      long certificateLifetime = 1000L;

      // Set the Public Key and its format.
      PublicKey publicKey =
          PublicKey.newBuilder().setKey(publicKeyBytes).setFormat(KeyFormat.PEM).build();

      SubjectConfig subjectConfig =
          SubjectConfig.newBuilder()
              // Set the common name and org name.
              .setSubject(
                  Subject.newBuilder().setCommonName(commonName).setOrganization(orgName).build())
              // Set the fully qualified domain name.
              .setSubjectAltName(SubjectAltNames.newBuilder().addDnsNames(domainName).build())
              .build();

      // Set the X.509 fields required for the certificate.
      X509Parameters x509Parameters =
          X509Parameters.newBuilder()
              .setKeyUsage(
                  KeyUsage.newBuilder()
                      .setBaseKeyUsage(
                          KeyUsageOptions.newBuilder()
                              .setDigitalSignature(true)
                              .setKeyEncipherment(true)
                              .setCertSign(true)
                              .build())
                      .setExtendedKeyUsage(
                          ExtendedKeyUsageOptions.newBuilder().setServerAuth(true).build())
                      .build())
              .setCaOptions(CaOptions.newBuilder().setIsCa(true).buildPartial())
              .build();

      // Create certificate.
      Certificate certificate =
          Certificate.newBuilder()
              .setConfig(
                  CertificateConfig.newBuilder()
                      .setPublicKey(publicKey)
                      .setSubjectConfig(subjectConfig)
                      .setX509Config(x509Parameters)
                      .build())
              .setLifetime(Duration.newBuilder().setSeconds(certificateLifetime).build())
              .build();

      // Create the Certificate Request.
      CreateCertificateRequest certificateRequest =
          CreateCertificateRequest.newBuilder()
              .setParent(CaPoolName.of(project, location, pool_Id).toString())
              .setCertificateId(certificateName)
              .setCertificate(certificate)
              .setIssuingCertificateAuthorityId(certificateAuthorityName)
              .build();

      // Get the Certificate response.
      ApiFuture<Certificate> future =
          certificateAuthorityServiceClient
              .createCertificateCallable()
              .futureCall(certificateRequest);

      Certificate response = future.get();
      // Get the PEM encoded, signed X.509 certificate.
      System.out.println(response.getPemCertificate());
      // To verify the obtained certificate, use this intermediate chain list.
      System.out.println(response.getPemCertificateChainList());
    }
  }
}
// [END privateca_create_certificate]
