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

// [START privateca_list_ca]

import com.google.cloud.security.privateca.v1.CaPoolName;
import com.google.cloud.security.privateca.v1.CertificateAuthority;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import java.io.IOException;

public class ListCertificateAuthorities {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // location: For a list of locations, see:
    // https://cloud.google.com/certificate-authority-service/docs/locations
    // pool_Id: The id of the CA pool under which the CAs to be listed are present.
    String project = "your-project-id";
    String location = "ca-location";
    String pool_Id = "ca-pool-id";
    listCertificateAuthority(project, location, pool_Id);
  }

  // List all Certificate authorities present in the given CA Pool.
  public static void listCertificateAuthority(String project, String location, String pool_Id)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `certificateAuthorityServiceClient.close()` method on the client to safely
    // clean up any remaining background resources.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {

      // Create CA pool name comprising of project, location and the pool name.
      CaPoolName parent =
          CaPoolName.newBuilder()
              .setProject(project)
              .setLocation(location)
              .setCaPool(pool_Id)
              .build();

      // List the CA name and its corresponding state.
      for (CertificateAuthority certificateAuthority :
          certificateAuthorityServiceClient.listCertificateAuthorities(parent).iterateAll()) {
        System.out.println(
            certificateAuthority.getName() + " is " + certificateAuthority.getState());
      }
    }
  }
}
// [END privateca_list_ca]
