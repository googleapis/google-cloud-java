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

package account_defender;

// [START recaptcha_enterprise_list_related_account_group_membership]

import com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest;
import com.google.recaptchaenterprise.v1.RelatedAccountGroupMembership;
import java.io.IOException;

public class ListRelatedAccountGroupMemberships {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // projectId: Google Cloud Project Id.
    String projectId = "project-id";

    // relatedAccountGroup: Name of the account group.
    String relatedAccountGroup = "related-account-group-name";

    listRelatedAccountGroupMemberships(projectId, relatedAccountGroup);
  }

  /** Given a group name, list memberships in the group. */
  public static void listRelatedAccountGroupMemberships(
      String projectId, String relatedAccountGroup) throws IOException {
    try (RecaptchaEnterpriseServiceClient client = RecaptchaEnterpriseServiceClient.create()) {

      // Construct the request.
      ListRelatedAccountGroupMembershipsRequest request =
          ListRelatedAccountGroupMembershipsRequest.newBuilder()
              .setParent(
                  String.format(
                      "projects/%s/relatedaccountgroups/%s", projectId, relatedAccountGroup))
              .build();

      for (RelatedAccountGroupMembership relatedAccountGroupMembership :
          client.listRelatedAccountGroupMemberships(request).iterateAll()) {
        System.out.println(relatedAccountGroupMembership.getName());
      }
      System.out.println("Finished listing related account group memberships.");
    }
  }
}
// [END recaptcha_enterprise_list_related_account_group_membership]
