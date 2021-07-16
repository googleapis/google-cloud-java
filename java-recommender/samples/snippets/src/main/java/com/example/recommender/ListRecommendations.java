/*
 * Copyright 2019 Google LLC
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

package com.example.recommender;

// [START recommender_list_recommendations]

import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.cloud.recommender.v1beta1.ListRecommendationsRequest;
import com.google.cloud.recommender.v1beta1.Recommendation;
import com.google.cloud.recommender.v1beta1.RecommenderClient;
import com.google.cloud.recommender.v1beta1.RecommenderClient.ListRecommendationsPagedResponse;
import java.io.IOException;

public class ListRecommendations {

  // List IAM recommendations for GOOGLE_CLOUD_PROJECT environment variable
  public static void listRecommendations() throws IOException {
    // TODO(developer): Replace the projectId variable before running the sample.
    String projectId = "my-project-id";

    // Google Cloud location where resources associated with the recommendations are located (for
    // example, "global" or "us-central1-a"). For a full list of supported regions, visit
    // https://cloud.google.com/compute/docs/regions-zones/
    String location = "global";

    // Fully-qualified recommender ID (for example, "google.iam.policy.Recommender" or
    // "google.compute.instance.MachineTypeRecommender"). For a full list of supported recommenders
    // visit https://cloud.google.com/recommender/docs/recommenders#recommenders
    String recommender = "google.iam.policy.Recommender";

    listRecommendations(projectId, location, recommender);
  }

  // List recommendations for a specified project, location, and recommender
  public static void listRecommendations(String projectId, String location, String recommender)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (RecommenderClient recommenderClient = RecommenderClient.create()) {
      /// Build the request
      String parent =
          String.format(
              "projects/%s/locations/%s/recommenders/%s", projectId, location, recommender);
      ListRecommendationsRequest request =
          ListRecommendationsRequest.newBuilder().setParent(parent).build();

      try {
        // Send the request
        ListRecommendationsPagedResponse response = recommenderClient.listRecommendations(request);

        // Print out each recommendation
        for (Recommendation responseItem : response.iterateAll()) {
          Recommendation recommendation = responseItem;
          System.out.println("Recommendation name: " + recommendation.getName());
          System.out.println("- description: " + recommendation.getDescription());
          System.out.println(
              "- primary_impact.category: " + recommendation.getPrimaryImpact().getCategory());
          System.out.println("- state_info.state: " + recommendation.getStateInfo().getState());
          System.out.println();
        }

        // Indicate the request was successful
        System.out.println("List recommendations successful");
      } catch (PermissionDeniedException e) {
        System.out.println(
            "Permission denied for project '"
                + projectId
                + "'. Ensure you have the appropriate permissions to list recommendations: \n"
                + e.toString());
      } catch (InvalidArgumentException e) {
        System.out.println(
            ("Invalid argument for projectId. Ensure you have 'GOOGLE_CLOUD_PROJECT' set: \n"
                + e.toString()));
      }
    }
  }
}
// [END recommender_list_recommendations]
