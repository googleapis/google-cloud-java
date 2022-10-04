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
package com.google.cloud.recommender.v1beta1.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.ServiceOptions;
import com.google.cloud.recommender.v1beta1.GetRecommendationRequest;
import com.google.cloud.recommender.v1beta1.ListRecommendationsRequest;
import com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest;
import com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest;
import com.google.cloud.recommender.v1beta1.Recommendation;
import com.google.cloud.recommender.v1beta1.RecommendationName;
import com.google.cloud.recommender.v1beta1.RecommenderClient;
import com.google.cloud.recommender.v1beta1.RecommenderName;
import com.google.common.collect.Lists;
import io.grpc.StatusRuntimeException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ITSystemTest {

  private RecommenderClient client;
  private static final String PROJECT = ServiceOptions.getDefaultProjectId();
  private static final String DISABLE_IAM_RECOMMENDATION_COUNT_TEST_ENV_NAME =
      "DISABLE_IAM_RECOMMENDATION_COUNT_TEST";
  private static final String LOCATION = "global";
  private static final String RECOMMENDER = "google.iam.policy.Recommender";
  private static final String FORMATTED_PARENT =
      RecommenderName.of(PROJECT, LOCATION, RECOMMENDER).toString();
  private static final String RECOMMENDATION = "invalid-recommendation-name";
  private static final String ETAG = "invalid-etag";
  private static final String FORMATTED_RECOMMENDATION_NAME =
      RecommendationName.of(LOCATION, PROJECT, RECOMMENDER, RECOMMENDATION).toString();
  private static final String RESOURCE_MAY_NOT_EXISTS = "may not exist";

  @Before
  public void setUp() throws Exception {
    client = RecommenderClient.create();
  }

  @After
  public void tearDown() {
    client.close();
  }

  @Test
  public void listRecommendationsTest() {
    ListRecommendationsRequest request =
        ListRecommendationsRequest.newBuilder().setParent(FORMATTED_PARENT).setFilter("").build();
    List<Recommendation> recommendations =
        Lists.newArrayList(client.listRecommendations(request).iterateAll());

    assertThat(recommendations).doesNotContain(null);
    if (!shouldSkipIamRecommendationCountTest()) {
      assertThat(recommendations).isNotEmpty();
    }
  }

  @Test(expected = InvalidArgumentException.class)
  public void listRecommendationsExceptionTest() {
    String filter = "invalid-filter";
    ListRecommendationsRequest request =
        ListRecommendationsRequest.newBuilder()
            .setParent(FORMATTED_PARENT)
            .setFilter(filter)
            .build();
    client.listRecommendations(request);
  }

  @Test
  public void getRecommendationExceptionTest() {
    GetRecommendationRequest request =
        GetRecommendationRequest.newBuilder().setName(FORMATTED_RECOMMENDATION_NAME).build();
    try {
      client.getRecommendation(request);
    } catch (Exception e) {
      assertThat(StatusRuntimeException.class).isEqualTo(e.getCause().getClass());
      assertThat(e.getCause().getMessage()).contains(RESOURCE_MAY_NOT_EXISTS);
    }
  }

  @Test
  public void markRecommendationClaimedExceptionTest() {
    MarkRecommendationClaimedRequest request =
        MarkRecommendationClaimedRequest.newBuilder()
            .setName(FORMATTED_RECOMMENDATION_NAME)
            .setEtag(ETAG)
            .build();
    try {
      client.markRecommendationClaimed(request);
    } catch (Exception e) {
      assertThat(StatusRuntimeException.class).isEqualTo(e.getCause().getClass());
      assertThat(e.getCause().getMessage()).contains(RESOURCE_MAY_NOT_EXISTS);
    }
  }

  @Test
  public void markRecommendationSucceededExceptionTest() {
    MarkRecommendationSucceededRequest request =
        MarkRecommendationSucceededRequest.newBuilder()
            .setName(FORMATTED_RECOMMENDATION_NAME)
            .setEtag(ETAG)
            .build();
    try {
      client.markRecommendationSucceeded(request);
    } catch (Exception e) {
      assertThat(StatusRuntimeException.class).isEqualTo(e.getCause().getClass());
      assertThat(e.getCause().getMessage()).contains(RESOURCE_MAY_NOT_EXISTS);
    }
  }

  public static boolean shouldSkipIamRecommendationCountTest() {
    String value =
        System.getProperty(
            DISABLE_IAM_RECOMMENDATION_COUNT_TEST_ENV_NAME,
            System.getenv(DISABLE_IAM_RECOMMENDATION_COUNT_TEST_ENV_NAME));

    if (value == null) {
      return false;
    }
    return Boolean.parseBoolean(value);
  }
}
