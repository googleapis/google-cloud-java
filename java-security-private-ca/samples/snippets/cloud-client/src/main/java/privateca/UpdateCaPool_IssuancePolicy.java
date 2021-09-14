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

// [START privateca_set_issuance_policy]

import com.google.api.core.ApiFuture;
import com.google.cloud.security.privateca.v1.CaPool;
import com.google.cloud.security.privateca.v1.CaPool.IssuancePolicy;
import com.google.cloud.security.privateca.v1.CaPoolName;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.CertificateIdentityConstraints;
import com.google.cloud.security.privateca.v1.UpdateCaPoolRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import com.google.type.Expr;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UpdateCaPool_IssuancePolicy {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    // location: For a list of locations, see:
    // https://cloud.google.com/certificate-authority-service/docs/locations
    // pool_Id: The CA pool for which the issuance policy is to be updated.
    String project = "your-project-id";
    String location = "ca-location";
    String pool_Id = "ca-pool-id";

    updateCaPoolIssuancePolicy(project, location, pool_Id);
  }

  /* Update the Issuance policy for a CA Pool. All certificates issued from this CA Pool should
  meet the issuance policy. */
  public static void updateCaPoolIssuancePolicy(String project, String location, String pool_Id)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    /* Initialize client that will be used to send requests. This client only needs to be created
    once, and can be reused for multiple requests. After completing all of your requests, call
    the `certificateAuthorityServiceClient.close()` method on the client to safely
    clean up any remaining background resources. */
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {

      /* Set the updated issuance policy for the CA Pool.
      This particular issuance policy allows only SANs that
      have DNS Names as "us.google.org" or ending in ".google.com". */
      String expr =
          "subject_alt_names.all(san, san.type == DNS && (san.value == \"us.google.org\""
              + " || san.value.endsWith(\".google.com\")) )";

      CaPool.IssuancePolicy issuancePolicy =
          IssuancePolicy.newBuilder()
              .setIdentityConstraints(
                  CertificateIdentityConstraints.newBuilder()
                      .setAllowSubjectPassthrough(true)
                      .setAllowSubjectAltNamesPassthrough(true)
                      .setCelExpression(Expr.newBuilder().setExpression(expr).build())
                      .build())
              .build();

      CaPool caPool =
          CaPool.newBuilder()
              .setName(CaPoolName.of(project, location, pool_Id).toString())
              .setIssuancePolicy(issuancePolicy)
              .build();

      /* 1. Set the CA pool with updated values.
      2. Set the update mask to specify which properties of the CA Pool should be updated.
      Only the properties specified in the mask will be updated. Make sure that the mask fields
      match the updated issuance policy.
      For more info on constructing path for update mask, see:
      https://cloud.google.com/certificate-authority-service/docs/reference/rest/v1/projects.locations.caPools#issuancepolicy */
      UpdateCaPoolRequest updateCaPoolRequest =
          UpdateCaPoolRequest.newBuilder()
              .setCaPool(caPool)
              .setUpdateMask(
                  FieldMask.newBuilder(
                      FieldMask.newBuilder()
                          .addPaths(
                              "issuance_policy.identity_constraints.allow_subject_passthrough")
                          .addPaths(
                              "issuance_policy.identity_constraints.allow_subject_alt_names_passthrough")
                          .addPaths("issuance_policy.identity_constraints.cel_expression")
                          .build()))
              .build();

      // Update CA Pool request.
      ApiFuture<Operation> futureCall =
          certificateAuthorityServiceClient.updateCaPoolCallable().futureCall(updateCaPoolRequest);

      Operation operation = futureCall.get(60, TimeUnit.SECONDS);

      // Check for errors.
      if (operation.hasError()) {
        System.out.println("Error in updating CA Pool Issuance policy ! " + operation.getError());
        return;
      }

      // Get the CA Pool's issuance policy and verify if the fields have been successfully updated.
      IssuancePolicy response =
          certificateAuthorityServiceClient
              .getCaPool(CaPoolName.of(project, location, pool_Id).toString())
              .getIssuancePolicy();

      // Similarly, you can check for other modified fields as well.
      if (response.getIdentityConstraints().getAllowSubjectPassthrough()
          && response.getIdentityConstraints().getAllowSubjectAltNamesPassthrough()) {
        System.out.println("CA Pool Issuance policy has been updated successfully ! ");
        return;
      }

      System.out.println(
          "Error in updating CA Pool Issuance policy ! Please try again ! " + response);
    }
  }
}
// [END privateca_set_issuance_policy]
