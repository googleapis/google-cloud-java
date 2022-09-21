/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// [START iam_update_deny_policy]

import com.google.iam.v2.DenyRule;
import com.google.iam.v2.PoliciesClient;
import com.google.iam.v2.Policy;
import com.google.iam.v2.PolicyRule;
import com.google.iam.v2.UpdatePolicyRequest;
import com.google.longrunning.Operation;
import com.google.type.Expr;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UpdateDenyPolicy {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.

    // ID or number of the Google Cloud project you want to use.
    String projectId = "your-google-cloud-project-id";

    // Specify the ID of the Deny policy you want to retrieve.
    String policyId = "deny-policy-id";

    // Etag field that identifies the policy version. The etag changes each time
    // you update the policy. Get the etag of an existing policy by performing a GetPolicy request.
    String etag = "policy_etag";

    updateDenyPolicy(projectId, policyId, etag);
  }

  // Update the deny rules and/ or its display name after policy creation.
  public static void updateDenyPolicy(String projectId, String policyId, String etag)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {

    try (PoliciesClient policiesClient = PoliciesClient.create()) {

      // Each deny policy is attached to an organization, folder, or project.
      // To work with deny policies, specify the attachment point.
      //
      // Its format can be one of the following:
      // 1. cloudresourcemanager.googleapis.com/organizations/ORG_ID
      // 2. cloudresourcemanager.googleapis.com/folders/FOLDER_ID
      // 3. cloudresourcemanager.googleapis.com/projects/PROJECT_ID
      //
      // The attachment point is identified by its URL-encoded resource name.
      String urlEncodedResource =
          URLEncoder.encode(
              "cloudresourcemanager.googleapis.com/projects/", StandardCharsets.UTF_8);
      String attachmentPoint = String.format("%s%s", urlEncodedResource, projectId);

      // Construct the full path of the resource to which the policy is attached to.
      // Its format is: "policies/{attachmentPoint}/denypolicies/{policyId}"
      String policyParent = String.format("policies/%s/denypolicies/%s", attachmentPoint, policyId);

      DenyRule denyRule =
          DenyRule.newBuilder()
              // Add one or more principals who should be denied the permissions specified in this
              // rule.
              // For more information on allowed values, see:
              // https://cloud.google.com/iam/docs/principal-identifiers
              .addDeniedPrincipals("principalSet://goog/public:all")

              // Optionally, set the principals who should be exempted from the list of principals
              // added in "DeniedPrincipals".
              // Example, if you want to deny certain permissions to a group but exempt a few
              // principals, then add those here.
              // .addExceptionPrincipals(
              //     "principalSet://goog/group/project-admins@example.com")

              // Set the permissions to deny.
              // The permission value is of the format: service_fqdn/resource.action
              // For the list of supported permissions, see:
              // https://cloud.google.com/iam/help/deny/supported-permissions
              .addDeniedPermissions("cloudresourcemanager.googleapis.com/projects.delete")

              // Add the permissions to be exempted from this rule.
              // Meaning, the deny rule will not be applicable to these permissions.
              // .addExceptionPermissions("cloudresourcemanager.googleapis.com/projects.get")

              // Set the condition which will enforce the deny rule.
              // If this condition is true, the deny rule will be applicable. Else, the rule will
              // not be enforced.
              .setDenialCondition(
                  Expr.newBuilder()
                      // The expression uses Common Expression Language syntax (CEL). Here we block
                      // access based on tags.
                      //
                      // A tag is a key-value pair that can be attached to an organization, folder,
                      // or project. You can use deny policies to deny permissions based on tags
                      // without adding an IAM Condition to every role grant.
                      // For example, imagine that you tag all of your projects as dev, test, or
                      // prod. You want only members of project-admins@example.com to be able to
                      // perform operations on projects that are tagged prod.
                      // To solve this problem, you create a deny rule that denies the
                      // cloudresourcemanager.googleapis.com/projects.delete permission to everyone
                      // except project-admins@example.com for resources that are tagged prod.
                      .setExpression("!resource.matchTag('12345678/env', 'prod')")
                      .setTitle("Only for prod projects")
                      .build())
              .build();

      // Set the policy resource path, version (etag) and the updated deny rules.
      Policy policy =
          Policy.newBuilder()
              .setName(policyParent)
              .setEtag(etag)
              .addRules(
                  PolicyRule.newBuilder()
                      // Set the rule description to update.
                      .setDescription(
                          "Block all principals from deleting projects, unless the principal is a member of project-admins@example.com and the project being deleted has a tag with the value prod")
                      // Set the deny rule to update.
                      .setDenyRule(denyRule)
                      .build())
              .build();

      // Create the update policy request.
      UpdatePolicyRequest updatePolicyRequest =
          UpdatePolicyRequest.newBuilder().setPolicy(policy).build();

      // Wait for the operation to complete.
      Operation operation =
          policiesClient
              .updatePolicyCallable()
              .futureCall(updatePolicyRequest)
              .get(3, TimeUnit.MINUTES);

      if (!operation.getDone() || operation.hasError()) {
        System.out.println("Error in updating the policy " + operation.getError());
        return;
      }

      System.out.println("Updated the deny policy: " + policyId);
    }
  }
}
// [END iam_update_deny_policy]
