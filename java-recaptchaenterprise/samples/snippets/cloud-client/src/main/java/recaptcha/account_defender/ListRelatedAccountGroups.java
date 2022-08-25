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

// [START recaptcha_enterprise_list_related_account_group]

import com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest;
import com.google.recaptchaenterprise.v1.RelatedAccountGroup;
import java.io.IOException;

public class ListRelatedAccountGroups {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // projectId : Google Cloud Project Id.
    String projectId = "project-id";

    listRelatedAccountGroups(projectId);
  }

  // List related account groups in the project.
  public static void listRelatedAccountGroups(String projectId) throws IOException {
    try (RecaptchaEnterpriseServiceClient client = RecaptchaEnterpriseServiceClient.create()) {

      ListRelatedAccountGroupsRequest request =
          ListRelatedAccountGroupsRequest.newBuilder().setParent("projects/" + projectId).build();

      System.out.println("Listing related account groups..");
      for (RelatedAccountGroup group : client.listRelatedAccountGroups(request).iterateAll()) {
        System.out.println(group.getName());
      }
    }
  }
}
// [END recaptcha_enterprise_list_related_account_group]
