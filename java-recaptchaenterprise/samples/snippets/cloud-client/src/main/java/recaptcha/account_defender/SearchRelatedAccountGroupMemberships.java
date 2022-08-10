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

// [START recaptcha_enterprise_search_related_account_group_membership]

import com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient;
import com.google.protobuf.ByteString;
import com.google.recaptchaenterprise.v1.RelatedAccountGroupMembership;
import com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsRequest;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SearchRelatedAccountGroupMemberships {

  public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
    // TODO(developer): Replace these variables before running the sample.
    // projectId: Google Cloud Project Id.
    String projectId = "project-id";

    // HMAC SHA-256 hashed unique id of the customer.
    ByteString hashedAccountId = ByteString.copyFrom(new byte[] {});

    searchRelatedAccountGroupMemberships(projectId, hashedAccountId);
  }

  // List group memberships for the hashed account id.
  public static void searchRelatedAccountGroupMemberships(
      String projectId, ByteString hashedAccountId) throws IOException {
    try (RecaptchaEnterpriseServiceClient client = RecaptchaEnterpriseServiceClient.create()) {

      SearchRelatedAccountGroupMembershipsRequest request =
          SearchRelatedAccountGroupMembershipsRequest.newBuilder()
              .setParent("projects/" + projectId)
              .setHashedAccountId(hashedAccountId)
              .build();

      for (RelatedAccountGroupMembership groupMembership :
          client.searchRelatedAccountGroupMemberships(request).iterateAll()) {
        System.out.println(groupMembership.getName());
      }
      System.out.printf(
          "Finished searching related account group memberships for %s!", hashedAccountId);
    }
  }
}
// [END recaptcha_enterprise_search_related_account_group_membership]
