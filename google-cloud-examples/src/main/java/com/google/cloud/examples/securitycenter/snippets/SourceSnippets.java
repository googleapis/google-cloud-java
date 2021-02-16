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

import com.google.cloud.securitycenter.v1.CreateSourceRequest;
import com.google.cloud.securitycenter.v1.GetSourceRequest;
import com.google.cloud.securitycenter.v1.ListSourcesRequest;
import com.google.cloud.securitycenter.v1.OrganizationName;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import com.google.cloud.securitycenter.v1.SecurityCenterClient.ListSourcesPagedResponse;
import com.google.cloud.securitycenter.v1.Source;
import com.google.cloud.securitycenter.v1.SourceName;
import com.google.cloud.securitycenter.v1.UpdateSourceRequest;
import com.google.common.collect.ImmutableList;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.protobuf.FieldMask;
import java.io.IOException;

/** Snippets for how to work with Sources in Cloud Security Command Center. */
public class SourceSnippets {
  private SourceSnippets() {}

  /**
   * Create a source under an organization.
   *
   * @param organizationName The organization for the source.
   */
  // [START securitycenter_create_source]
  // [START create_source]
  static Source createSource(OrganizationName organizationName) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request to create a source in an organization.
      // OrganizationName organizationName = OrganizationName.of(/*organizationId=*/"123234324");
      Source source =
          Source.newBuilder()
              .setDisplayName("Customized Display Name")
              .setDescription("A new custom source that does X")
              .build();

      CreateSourceRequest.Builder request =
          CreateSourceRequest.newBuilder().setParent(organizationName.toString()).setSource(source);

      // Call the API.
      Source response = client.createSource(request.build());

      System.out.println("Created Source: " + response);
      return response;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END create_source]
  // [END securitycenter_create_source]

  /**
   * List sources under an organization.
   *
   * @param organizationName The organization for the source.
   */
  // [START securitycenter_list_sources]
  // [START list_source]
  static ImmutableList<Source> listSources(OrganizationName organizationName) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request to list sources in an organization.
      // OrganizationName organizationName = OrganizationName.of(/*organizationId=*/"123234324");
      ListSourcesRequest.Builder request =
          ListSourcesRequest.newBuilder().setParent(organizationName.toString());

      // Call the API.
      ListSourcesPagedResponse response = client.listSources(request.build());

      // This creates one list for all sources.  If your organization has a large number of sources
      // this can cause out of memory issues.  You can process them batches by returning
      // the Iterable returned response.iterateAll() directly.
      ImmutableList<Source> results = ImmutableList.copyOf(response.iterateAll());
      System.out.println("Sources:");
      System.out.println(results);
      return results;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END list_source]
  // [END securitycenter_list_sources]

  /**
   * Update a source under an organization.
   *
   * @param sourceName The source to update.
   */
  // [START securitycenter_update_source]
  // [START update_source]
  static Source updateSource(SourceName sourceName) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request to update a source.
      // SourceName sourceName = SourceName.of(/*organization=*/"123234324",/*source=*/
      // "423432321");
      Source source =
          Source.newBuilder()
              .setDisplayName("Updated Display Name")
              .setName(sourceName.toString())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().addPaths("display_name").build();

      UpdateSourceRequest.Builder request =
          UpdateSourceRequest.newBuilder().setSource(source).setUpdateMask(updateMask);

      // Call the API.
      Source response = client.updateSource(request.build());

      System.out.println("Updated Source: " + response);
      return response;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END update_source]
  // [END securitycenter_update_source]

  /**
   * Get a source under an organization.
   *
   * @param sourceName The source to get.
   */
  // [START securitycenter_get_source]
  // [START get_source]
  static Source getSource(SourceName sourceName) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request to get a source.
      // SourceName sourceName = SourceName.of(/*organization=*/"123234324",/*source=*/
      // "423432321");
      GetSourceRequest.Builder request =
          GetSourceRequest.newBuilder().setName(sourceName.toString());

      // Call the API.
      Source response = client.getSource(request.build());

      System.out.println("Source: " + response);
      return response;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END get_source]
  // [END securitycenter_get_source]

  /**
   * Set IAM policy for a source.
   *
   * @param sourceName The source to set IAM Policy for.
   */
  // [START securitycenter_set_source_iam]
  // [START set_source_iam_policy]
  static Policy setIamPolicySource(SourceName sourceName, String userEmail) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // userEmail = "someuser@domain.com"
      // Set up IAM Policy for the user userMail to use the role findingsEditor.
      // The user must be a valid google account.
      Policy oldPolicy = client.getIamPolicy(sourceName.toString());
      Binding bindings =
          Binding.newBuilder()
              .setRole("roles/securitycenter.findingsEditor")
              .addMembers("user:" + userEmail)
              .build();
      Policy policy = oldPolicy.toBuilder().addBindings(bindings).build();

      // Start setting up a request to set IAM policy for a source.
      // SourceName sourceName = SourceName.of("123234324", "423432321");
      SetIamPolicyRequest.Builder request =
          SetIamPolicyRequest.newBuilder().setPolicy(policy).setResource(sourceName.toString());

      // Call the API.
      Policy response = client.setIamPolicy(request.build());

      System.out.println("Policy: " + response);
      return response;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END set_source_iam_policy]
  // [END securitycenter_set_source_iam]

  /**
   * Get IAM policy for a source.
   *
   * @param sourceName The source to set IAM Policy for.
   */
  // [START securitycenter_get_source_iam]
  // [START get_source_iam_policy]
  static Policy getIamPolicySource(SourceName sourceName) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request to get IAM policy for a source.
      // SourceName sourceName = SourceName.of(/*organization=*/"123234324",/*source=*/
      // "423432321");
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder().setResource(sourceName.toString()).build();

      // Call the API.
      Policy response = client.getIamPolicy(request);

      System.out.println("Policy: " + response);
      return response;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END get_source_iam_policy]
  // [END securitycenter_get_source_iam]

}
