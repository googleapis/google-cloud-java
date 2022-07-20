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

// [START privateca_update_certificate_template]

import com.google.api.core.ApiFuture;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.CertificateIdentityConstraints;
import com.google.cloud.security.privateca.v1.CertificateTemplate;
import com.google.cloud.security.privateca.v1.CertificateTemplateName;
import com.google.cloud.security.privateca.v1.UpdateCertificateTemplateRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UpdateCertificateTemplate {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    // location: For a list of locations, see:
    // https://cloud.google.com/certificate-authority-service/docs/locations
    // certificateTemplateId: Id of the certificate template to update.
    String project = "your-project-id";
    String location = "ca-location";
    String certificateTemplateId = "certificate-template-id";

    updateCertificateTemplate(project, location, certificateTemplateId);
  }

  // Updates an existing certificate template.
  public static void updateCertificateTemplate(
      String project, String location, String certificateTemplateId)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    /* Initialize client that will be used to send requests. This client only needs to be created
    once, and can be reused for multiple requests. After completing all of your requests, call
    the `certificateAuthorityServiceClient.close()` method on the client to safely
    clean up any remaining background resources. */
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {

      String certificateTemplateName =
          CertificateTemplateName.of(project, location, certificateTemplateId).toString();

      // Set the parent name and the properties to be updated.
      CertificateTemplate certificateTemplate =
          CertificateTemplate.newBuilder()
              .setName(certificateTemplateName)
              .setIdentityConstraints(
                  CertificateIdentityConstraints.newBuilder()
                      .setAllowSubjectPassthrough(false)
                      .setAllowSubjectAltNamesPassthrough(true)
                      .build())
              .build();

      // Set the mask corresponding to the properties updated above.
      FieldMask fieldMask =
          FieldMask.newBuilder()
              .addPaths("identity_constraints.allow_subject_alt_names_passthrough")
              .addPaths("identity_constraints.allow_subject_passthrough")
              .build();

      /* Set the new template.
      Set the mask to specify which properties of the template should be updated. */
      UpdateCertificateTemplateRequest request =
          UpdateCertificateTemplateRequest.newBuilder()
              .setCertificateTemplate(certificateTemplate)
              .setUpdateMask(fieldMask)
              .build();

      // Create the update certificate template request.
      ApiFuture<Operation> futureCall =
          certificateAuthorityServiceClient.updateCertificateTemplateCallable().futureCall(request);

      Operation response = futureCall.get(60, TimeUnit.SECONDS);

      // Check for errors.
      if (response.hasError()) {
        System.out.println("Error in updating certificate template ! " + response.getError());
        return;
      }

      // Get the updated certificate template and check if the properties have been updated.
      CertificateIdentityConstraints updatedCertificateIdentityConstraints =
          certificateAuthorityServiceClient
              .getCertificateTemplate(certificateTemplateName)
              .getIdentityConstraints();

      if (!updatedCertificateIdentityConstraints.getAllowSubjectPassthrough()
          && updatedCertificateIdentityConstraints.getAllowSubjectAltNamesPassthrough()) {
        System.out.println("Successfully updated the certificate template ! " + response.getName());
        return;
      }

      System.out.println("Error in updating certificate template ! ");
    }
  }
}
// [END privateca_update_certificate_template]
