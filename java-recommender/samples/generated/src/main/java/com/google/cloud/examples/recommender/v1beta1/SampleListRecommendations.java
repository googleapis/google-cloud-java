/*
 * Copyright 2020 Google LLC
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
// DO NOT EDIT! This is a generated sample ("RequestPaged",  "sample_list_recommendations")
// sample-metadata:
//   title: List Recommendations
//   description: List recommendations for a specified project, location, and recommender.
//   usage: gradle run -PmainClass=com.google.cloud.examples.recommender.v1beta1.SampleListRecommendations

package com.google.cloud.examples.recommender.v1beta1;

import com.google.cloud.recommender.v1beta1.ListRecommendationsRequest;
import com.google.cloud.recommender.v1beta1.Recommendation;
import com.google.cloud.recommender.v1beta1.RecommenderClient;
import com.google.cloud.recommender.v1beta1.RecommenderName;

public class SampleListRecommendations {
  // [START ]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.recommender.v1beta1.ListRecommendationsRequest;
   * import com.google.cloud.recommender.v1beta1.Recommendation;
   * import com.google.cloud.recommender.v1beta1.RecommenderClient;
   * import com.google.cloud.recommender.v1beta1.RecommenderName;
   */

  /** List recommendations for a specified project, location, and recommender. */
  public static void sampleListRecommendations() {
    try (RecommenderClient recommenderClient = RecommenderClient.create()) {
      RecommenderName parent = RecommenderName.of("[PROJECT]", "[LOCATION]", "[RECOMMENDER]");
      ListRecommendationsRequest request =
          ListRecommendationsRequest.newBuilder().setParent(parent.toString()).build();
      for (Recommendation responseItem :
          recommenderClient.listRecommendations(request).iterateAll()) {
        Recommendation recommendation = responseItem;
        System.out.printf("Recommendation name: %s\n", recommendation.getName());
        System.out.printf("- description: %s\n", recommendation.getDescription());
        System.out.printf(
            "- primary_impact.category: %s\n", recommendation.getPrimaryImpact().getCategory());
        System.out.printf("- state_info.state: %s\n", recommendation.getStateInfo().getState());
        System.out.printf("- last_refresh_time: %s\n", recommendation.getLastRefreshTime());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END ]

  public static void main(String[] args) {
    sampleListRecommendations();
  }
}
