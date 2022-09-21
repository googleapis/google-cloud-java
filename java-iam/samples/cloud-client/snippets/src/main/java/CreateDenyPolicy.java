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

// [START iam_create_deny_policy]

import com.google.iam.v2.CreatePolicyRequest;
import com.google.iam.v2.DenyRule;
import com.google.iam.v2.PoliciesClient;
import com.google.iam.v2.Policy;
import com.google.iam.v2.PolicyRule;
import com.google.longrunning.Operation;
import com.google.type.Expr;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CreateDenyPolicy {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    // ID or number of the Google Cloud project you want to use.
    String projectId = "your-google-cloud-project-id";

    // Specify the id of the Deny policy you want to create.
    String policyId = "deny-policy-id";

    createDenyPolicy(projectId, policyId);
  }

  // Create a deny policy.
  // You can add deny policies to organizations, folders, and projects.
  // Each of these resources can have up to 5 deny policies.
  //
  // Deny policies contain deny rules, which specify the following:
  // 1. The permissions to deny and/or exempt.
  // 2. The principals that are denied, or exempted from denial.
  // 3. An optional condition on when to enforce the deny rules.
  public static void createDenyPolicy(String projectId, String policyId)
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

      // Construct the full path of the resource to which the policy is attached.
      // Its format is: "policies/{attachmentPoint}/denypolicies/{policyId}"
      String policyParent = String.format("policies/%s/denypolicies", attachmentPoint);

      DenyRule denyRule =
          DenyRule.newBuilder()
              // Add one or more principals who should be denied the permissions specified in this
              // rule.
              // For more information on allowed values, see:
              // https://cloud.google.com/iam/docs/principal-identifiers
              .addDeniedPrincipals("principalSet://goog/public:all")

              // Optionally, set the principals who should be exempted from the
              // list of denied principals. For example, if you want to deny certain permissions
              // to a group but exempt a few principals, then add those here.
              // .addExceptionPrincipals(
              //     "principalSet://goog/group/project-admins@example.com")

              // Set the permissions to deny.
              // The permission value is of the format: service_fqdn/resource.action
              // For the list of supported permissions, see:
              // https://cloud.google.com/iam/help/deny/supported-permissions
              .addDeniedPermissions("cloudresourcemanager.googleapis.com/projects.delete")

              // Optionally, add the permissions to be exempted from this rule.
              // Meaning, the deny rule will not be applicable to these permissions.
              // .addExceptionPermissions("cloudresourcemanager.googleapis.com/projects.create")

              // Set the condition which will enforce the deny rule. If this condition is true,
              // the deny rule will be applicable. Else, the rule will not be enforced.
              .setDenialCondition(
                  Expr.newBuilder()
                      // The expression uses Common Expression Language syntax (CEL).
                      // Here we block access based on tags.
                      //
                      // A tag is a key-value pair that can be attached to an organization, folder,
                      // or project. You can use deny policies to deny permissions based on tags
                      // without adding an IAM Condition to every role grant.
                      // For example, imagine that you tag all of your projects as dev, test, or
                      // prod. You want only members of project-admins@example.com to be able to
                      // perform operations on projects that are tagged prod.
                      // To solve this problem, you create a deny rule that denies the
                      // cloudresourcemanager.googleapis.com/projects.delete permission to everyone
                      // except project-admins@example.com for resources that are tagged test.
                      .setExpression("!resource.matchTag('12345678/env', 'test')")
                      .setTitle("Only for test projects")
                      .build())
              .build();

      // Add the deny rule and a description for it.
      Policy policy =
          Policy.newBuilder()
              // Set the deny rule.
              .addRules(
                  PolicyRule.newBuilder()
                      // Set a description for the rule.
                      .setDescription(
                          "block all principals from deleting projects, unless the principal is a member of project-admins@example.com and the project being deleted has a tag with the value test")
                      .setDenyRule(denyRule)
                      .build())
              .build();

      // Set the policy resource path, policy rules and a unique ID for the policy.
      CreatePolicyRequest createPolicyRequest =
          CreatePolicyRequest.newBuilder()
              .setParent(policyParent)
              .setPolicy(policy)
              .setPolicyId(policyId)
              .build();

      // Build the create policy request.
      Operation operation =
          policiesClient
              .createPolicyCallable()
              .futureCall(createPolicyRequest)
              .get(3, TimeUnit.MINUTES);

      // Wait for the operation to complete.
      if (!operation.getDone() || operation.hasError()) {
        System.out.println("Error in creating the policy " + operation.getError());
        return;
      }

      // Retrieve the policy name.
      Policy response = policiesClient.getPolicy(String.format("%s/%s", policyParent, policyId));
      String policyName = response.getName();
      System.out.println(
          "Created the deny policy: " + policyName.substring(policyName.lastIndexOf("/") + 1));
    }
  }
}
// [END iam_create_deny_policy]
