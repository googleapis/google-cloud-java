/*
 * Copyright 2022 Google Inc.
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

package com.example.spanner.admin.archived;

// [START spanner_enable_fine_grained_access]
import com.google.cloud.Binding;
import com.google.cloud.Condition;
import com.google.cloud.Policy;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.collect.ImmutableList;

public class EnableFineGrainedAccess {

  static void enableFineGrainedAccess() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    String iamMember = "user:alice@example.com";
    String role = "my-role";
    String title = "my-condition-title";
    enableFineGrainedAccess(projectId, instanceId, databaseId, iamMember, title, role);
  }

  static void enableFineGrainedAccess(
      String projectId,
      String instanceId,
      String databaseId,
      String iamMember,
      String title,
      String role) {
    try (Spanner spanner =
                 SpannerOptions.newBuilder()
                         .setProjectId(projectId)
                         .build()
                         .getService()) {
      final DatabaseAdminClient adminClient = spanner.getDatabaseAdminClient();
      Policy policy = adminClient.getDatabaseIAMPolicy(instanceId, databaseId, 3);
      int policyVersion = policy.getVersion();
      // The policy in the response from getDatabaseIAMPolicy might use the policy version
      // that you specified, or it might use a lower policy version. For example, if you
      // specify version 3, but the policy has no conditional role bindings, the response
      // uses version 1. Valid values are 0, 1, and 3.
      if (policy.getVersion() < 3) {
        // conditional role bindings work with policy version 3
        policyVersion = 3;
      }

      Binding binding1 =
          Binding.newBuilder()
              .setRole("roles/spanner.fineGrainedAccessUser")
              .setMembers(ImmutableList.of(iamMember))
              .build();

      Binding binding2 =
          Binding.newBuilder()
              .setRole("roles/spanner.databaseRoleUser")
              .setCondition(
                  Condition.newBuilder()
                      .setDescription(title)
                      .setExpression(
                          String.format("resource.name.endsWith(\"/databaseRoles/%s\")", role))
                      .setTitle(title)
                      .build())
              .setMembers(ImmutableList.of(iamMember))
              .build();
      ImmutableList<Binding> bindings =
          ImmutableList.<Binding>builder()
              .addAll(policy.getBindingsList())
              .add(binding1)
              .add(binding2)
              .build();
      Policy policyWithConditions =
          Policy.newBuilder()
              .setVersion(policyVersion)
              .setEtag(policy.getEtag())
              .setBindings(bindings)
              .build();
      Policy response =
          adminClient.setDatabaseIAMPolicy(instanceId, databaseId, policyWithConditions);
      System.out.printf(
          "Enabled fine-grained access in IAM with version %d%n", response.getVersion());
    }
  }
}
// [END spanner_enable_fine_grained_access]
