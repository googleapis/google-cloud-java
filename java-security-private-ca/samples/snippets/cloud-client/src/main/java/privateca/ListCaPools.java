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

// [START privateca_list_ca_pool]

import com.google.cloud.security.privateca.v1.CaPool;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.LocationName;
import java.io.IOException;

public class ListCaPools {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // location: For a list of locations, see:
    // https://cloud.google.com/certificate-authority-service/docs/locations
    String project = "your-project-id";
    String location = "ca-location";
    listCaPools(project, location);
  }

  // List all CA pools present in the given project and location.
  public static void listCaPools(String project, String location) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `certificateAuthorityServiceClient.close()` method on the client to safely
    // clean up any remaining background resources.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {

      // Set the Location Name which contains project and location of the pool.
      LocationName locationName =
          LocationName.newBuilder().setProject(project).setLocation(location).build();

      String caPoolName = "";
      System.out.println("Available CA pools: ");

      // List the CA pools.
      for (CaPool caPool :
          certificateAuthorityServiceClient.listCaPools(locationName).iterateAll()) {
        caPoolName = caPool.getName();
        // caPoolName represents the full resource name of the
        // format 'projects/{project-id}/locations/{location}/ca-pools/{ca-pool-id}'.
        // Hence stripping it down to just CA pool id.
        System.out.println(
            caPoolName.substring(caPoolName.lastIndexOf("/") + 1) + " " + caPool.isInitialized());
      }
    }
  }
}
// [END privateca_list_ca_pool]
