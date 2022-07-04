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

// [START privateca_list_certificate]

import com.google.cloud.security.privateca.v1.CaPoolName;
import com.google.cloud.security.privateca.v1.Certificate;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import java.io.IOException;

public class ListCertificates {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // location: For a list of locations, see:
    // https://cloud.google.com/certificate-authority-service/docs/locations
    // pool_Id: Id of the CA pool which contains the certificates to be listed.
    String project = "your-project-id";
    String location = "ca-location";
    String pool_Id = "ca-pool-id";
    listCertificates(project, location, pool_Id);
  }

  // List Certificates present in the given CA pool.
  public static void listCertificates(String project, String location, String pool_Id)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `certificateAuthorityServiceClient.close()` method on the client to safely
    // clean up any remaining background resources.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {

      CaPoolName caPool =
          CaPoolName.newBuilder()
              .setProject(project)
              .setLocation(location)
              .setCaPool(pool_Id)
              .build();

      // Retrieve and print the certificate names.
      System.out.println("Available certificates: ");
      for (Certificate certificate :
          certificateAuthorityServiceClient.listCertificates(caPool).iterateAll()) {
        System.out.println(certificate.getName());
      }
    }
  }
}
// [END privateca_list_certificate]
