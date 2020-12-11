/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.examples.securitycenter.snippets;

import com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest;
import com.google.cloud.securitycenter.v1.OrganizationName;
import com.google.cloud.securitycenter.v1.OrganizationSettings;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest;
import com.google.protobuf.FieldMask;
import java.io.IOException;

/** Snippets for how to work with Organizations in Cloud Security Command Center. */
public class OrganizationSnippets {

  private OrganizationSnippets() {}

  /**
   * Gets current settings for an organization.
   *
   * @param organizationName The organization to get settings for.
   */
  // [START securitycenter_get_organization_settings]
  // [START get_organization_settings]
  static OrganizationSettings getOrganizationSettings(OrganizationName organizationName) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request to get OrganizationSettings for.
      // OrganizationName organizationName = OrganizationName.of(/*organizationId=*/"123234324");
      GetOrganizationSettingsRequest.Builder request =
          GetOrganizationSettingsRequest.newBuilder()
              .setName(organizationName.toString() + "/organizationSettings");

      // Call the API.
      OrganizationSettings response = client.getOrganizationSettings(request.build());

      System.out.println("Organization Settings:");
      System.out.println(response);
      return response;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END get_organization_settings]
  // [END securitycenter_get_organization_settings]

  /**
   * Update Asset Discovery OrganizationSettings for an organization
   *
   * @param organizationName The organization to update settings for.
   */
  // [START securitycenter_update_organization_settings]
  // [START update_organization_settings]
  static OrganizationSettings updateOrganizationSettings(OrganizationName organizationName) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request to update OrganizationSettings for.
      // OrganizationName organizationName = OrganizationName.of(/*organizationId=*/"123234324");
      OrganizationSettings organizationSettings =
          OrganizationSettings.newBuilder()
              .setName(organizationName.toString() + "/organizationSettings")
              .setEnableAssetDiscovery(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().addPaths("enable_asset_discovery").build();

      UpdateOrganizationSettingsRequest.Builder request =
          UpdateOrganizationSettingsRequest.newBuilder()
              .setOrganizationSettings(organizationSettings)
              .setUpdateMask(updateMask);

      // Call the API.
      OrganizationSettings response = client.updateOrganizationSettings(request.build());

      System.out.println("Organization Settings have been updated:");
      System.out.println(response);
      return response;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END update_organization_settings]
  // [END securitycenter_update_organization_settings]

}
