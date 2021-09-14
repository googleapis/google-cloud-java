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

// [START privateca_create_certificate_template]

import com.google.api.core.ApiFuture;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.CertificateIdentityConstraints;
import com.google.cloud.security.privateca.v1.CertificateTemplate;
import com.google.cloud.security.privateca.v1.CreateCertificateTemplateRequest;
import com.google.cloud.security.privateca.v1.KeyUsage;
import com.google.cloud.security.privateca.v1.KeyUsage.ExtendedKeyUsageOptions;
import com.google.cloud.security.privateca.v1.KeyUsage.KeyUsageOptions;
import com.google.cloud.security.privateca.v1.LocationName;
import com.google.cloud.security.privateca.v1.X509Parameters;
import com.google.cloud.security.privateca.v1.X509Parameters.CaOptions;
import com.google.longrunning.Operation;
import com.google.type.Expr;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CreateCertificateTemplate {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    /* TODO(developer): Replace these variables before running the sample.
    location: For a list of locations, see:
    https://cloud.google.com/certificate-authority-service/docs/locations */
    String project = "your-project-id";
    String location = "ca-location";
    String certificateTemplateId = "certificate-template-id";

    createCertificateTemplate(project, location, certificateTemplateId);
  }

  /* Creates a Certificate template. These templates can be reused for common
  certificate issuance scenarios. */
  public static void createCertificateTemplate(
      String project, String location, String certificateTemplateId)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    /* Initialize client that will be used to send requests. This client only needs to be created
    once, and can be reused for multiple requests. After completing all of your requests, call
    the `certificateAuthorityServiceClient.close()` method on the client to safely
    clean up any remaining background resources. */
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {

      /* Describes any predefined X.509 values set by this template.
      The provided extensions are copied over to certificate requests that use this template.*/
      KeyUsage keyUsage =
          KeyUsage.newBuilder()
              .setBaseKeyUsage(
                  KeyUsageOptions.newBuilder()
                      .setDigitalSignature(true)
                      .setKeyEncipherment(true)
                      .build())
              .setExtendedKeyUsage(ExtendedKeyUsageOptions.newBuilder().setServerAuth(true).build())
              .build();

      CaOptions caOptions = CaOptions.newBuilder().setIsCa(false).build();

      /* CEL expression that is evaluated against the Subject and
      Subject Alternative Name of the certificate before it is issued. */
      Expr expr =
          Expr.newBuilder().setExpression("subject_alt_names.all(san, san.type == DNS)").build();

      // Set the certificate issuance schema.
      CertificateTemplate certificateTemplate =
          CertificateTemplate.newBuilder()
              .setPredefinedValues(
                  X509Parameters.newBuilder().setKeyUsage(keyUsage).setCaOptions(caOptions).build())
              .setIdentityConstraints(
                  CertificateIdentityConstraints.newBuilder()
                      .setCelExpression(expr)
                      .setAllowSubjectPassthrough(false)
                      .setAllowSubjectAltNamesPassthrough(false)
                      .build())
              .build();

      // Set the parent and certificate template properties.
      CreateCertificateTemplateRequest certificateTemplateRequest =
          CreateCertificateTemplateRequest.newBuilder()
              .setParent(LocationName.of(project, location).toString())
              .setCertificateTemplate(certificateTemplate)
              .setCertificateTemplateId(certificateTemplateId)
              .build();

      // Create Template request.
      ApiFuture<Operation> futureCall =
          certificateAuthorityServiceClient
              .createCertificateTemplateCallable()
              .futureCall(certificateTemplateRequest);

      Operation response = futureCall.get(60, TimeUnit.SECONDS);

      if (response.hasError()) {
        System.out.println("Error creating certificate template ! " + response.getError());
        return;
      }

      System.out.println("Successfully created certificate template ! " + response.getName());
    }
  }
}
// [END privateca_create_certificate_template]
