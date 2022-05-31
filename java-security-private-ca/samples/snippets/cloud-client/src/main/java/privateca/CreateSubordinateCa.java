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

// [START privateca_create_subordinateca]

import com.google.api.core.ApiFuture;
import com.google.cloud.security.privateca.v1.CaPoolName;
import com.google.cloud.security.privateca.v1.CertificateAuthority;
import com.google.cloud.security.privateca.v1.CertificateAuthority.KeyVersionSpec;
import com.google.cloud.security.privateca.v1.CertificateAuthority.SignHashAlgorithm;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.CertificateConfig;
import com.google.cloud.security.privateca.v1.CertificateConfig.SubjectConfig;
import com.google.cloud.security.privateca.v1.CreateCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.KeyUsage;
import com.google.cloud.security.privateca.v1.KeyUsage.KeyUsageOptions;
import com.google.cloud.security.privateca.v1.Subject;
import com.google.cloud.security.privateca.v1.SubjectAltNames;
import com.google.cloud.security.privateca.v1.X509Parameters;
import com.google.cloud.security.privateca.v1.X509Parameters.CaOptions;
import com.google.longrunning.Operation;
import com.google.protobuf.Duration;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class CreateSubordinateCa {

  public static void main(String[] args)
      throws InterruptedException, ExecutionException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    // location: For a list of locations, see:
    // https://cloud.google.com/certificate-authority-service/docs/locations
    // pool_Id: Set it to the CA Pool under which the CA should be created.
    // subordinateCaName: Unique name for the Subordinate CA.
    String project = "your-project-id";
    String location = "ca-location";
    String pool_Id = "ca-pool-id";
    String subordinateCaName = "subordinate-certificate-authority-name";

    createSubordinateCertificateAuthority(project, location, pool_Id, subordinateCaName);
  }

  public static void createSubordinateCertificateAuthority(
      String project, String location, String pool_Id, String subordinateCaName)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `certificateAuthorityServiceClient.close()` method on the client to safely
    // clean up any remaining background resources.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {

      String commonName = "common-name";
      String orgName = "csr-org-name";
      String domainName = "dns.your-domain.com";
      int caDuration = 100000; // Validity of this CA in seconds.

      // Set the type of Algorithm.
      KeyVersionSpec keyVersionSpec =
          KeyVersionSpec.newBuilder().setAlgorithm(SignHashAlgorithm.RSA_PKCS1_4096_SHA256).build();

      // Set CA subject config.
      SubjectConfig subjectConfig =
          SubjectConfig.newBuilder()
              .setSubject(
                  Subject.newBuilder().setCommonName(commonName).setOrganization(orgName).build())
              // Set the fully qualified domain name.
              .setSubjectAltName(SubjectAltNames.newBuilder().addDnsNames(domainName).build())
              .build();

      //  Set the key usage options for X.509 fields.
      X509Parameters x509Parameters =
          X509Parameters.newBuilder()
              .setKeyUsage(
                  KeyUsage.newBuilder()
                      .setBaseKeyUsage(
                          KeyUsageOptions.newBuilder().setCrlSign(true).setCertSign(true).build())
                      .build())
              .setCaOptions(CaOptions.newBuilder().setIsCa(true).build())
              .build();

      // Set certificate authority settings.
      CertificateAuthority subCertificateAuthority =
          CertificateAuthority.newBuilder()
              .setType(CertificateAuthority.Type.SUBORDINATE)
              .setKeySpec(keyVersionSpec)
              .setConfig(
                  CertificateConfig.newBuilder()
                      .setSubjectConfig(subjectConfig)
                      .setX509Config(x509Parameters)
                      .build())
              // Set the CA validity duration.
              .setLifetime(Duration.newBuilder().setSeconds(caDuration).build())
              .build();

      // Create the CertificateAuthorityRequest.
      CreateCertificateAuthorityRequest subCertificateAuthorityRequest =
          CreateCertificateAuthorityRequest.newBuilder()
              .setParent(CaPoolName.of(project, location, pool_Id).toString())
              .setCertificateAuthorityId(subordinateCaName)
              .setCertificateAuthority(subCertificateAuthority)
              .build();

      // Create Subordinate CA.
      ApiFuture<Operation> futureCall =
          certificateAuthorityServiceClient
              .createCertificateAuthorityCallable()
              .futureCall(subCertificateAuthorityRequest);

      Operation response = futureCall.get();

      if (response.hasError()) {
        System.out.println("Error while creating Subordinate CA !" + response.getError());
        return;
      }

      System.out.println(
          "Subordinate Certificate Authority created successfully : " + subordinateCaName);
    }
  }
}
// [END privateca_create_subordinateca]
