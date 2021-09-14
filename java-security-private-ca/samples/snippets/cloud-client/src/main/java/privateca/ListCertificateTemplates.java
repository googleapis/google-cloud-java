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

// [START privateca_list_certificate_template]

import com.google.api.core.ApiFuture;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.CertificateTemplate;
import com.google.cloud.security.privateca.v1.ListCertificateTemplatesRequest;
import com.google.cloud.security.privateca.v1.ListCertificateTemplatesResponse;
import com.google.cloud.security.privateca.v1.LocationName;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ListCertificateTemplates {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    /* TODO(developer): Replace these variables before running the sample.
    location: For a list of locations, see:
    https://cloud.google.com/certificate-authority-service/docs/locations */
    String project = "your-project-id";
    String location = "ca-location";

    listCertificateTemplates(project, location);
  }

  // Lists the certificate templates present in the given project and location.
  public static void listCertificateTemplates(String project, String location)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    /* Initialize client that will be used to send requests. This client only needs to be created
    once, and can be reused for multiple requests. After completing all of your requests, call
    the `certificateAuthorityServiceClient.close()` method on the client to safely
    clean up any remaining background resources. */
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {

      // Set the parent name to list the certificate templates.
      ListCertificateTemplatesRequest request =
          ListCertificateTemplatesRequest.newBuilder()
              .setParent(LocationName.of(project, location).toString())
              .build();

      ApiFuture<ListCertificateTemplatesResponse> futureCall =
          certificateAuthorityServiceClient.listCertificateTemplatesCallable().futureCall(request);

      // Get the response.
      ListCertificateTemplatesResponse response = futureCall.get(60, TimeUnit.SECONDS);

      // List all templates.
      for (CertificateTemplate template : response.getCertificateTemplatesList()) {
        System.out.println(template.getName());
      }
    }
  }
}
// [END privateca_list_certificate_template]
