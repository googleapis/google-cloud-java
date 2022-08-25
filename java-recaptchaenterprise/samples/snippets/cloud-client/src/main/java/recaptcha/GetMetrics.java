/*
 * Copyright 2021 Google LLC
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

package recaptcha;

// [START recaptcha_enterprise_get_metrics_site_key]

import com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient;
import com.google.recaptchaenterprise.v1.GetMetricsRequest;
import com.google.recaptchaenterprise.v1.Metrics;
import com.google.recaptchaenterprise.v1.MetricsName;
import com.google.recaptchaenterprise.v1.ScoreMetrics;
import java.io.IOException;

public class GetMetrics {

  public static void main(String[] args) throws IOException {
    String projectId = "project-id";
    String recaptchaSiteKey = "recaptcha-site-key";

    getMetrics(projectId, recaptchaSiteKey);
  }

  /**
   * Get metrics specific to a recaptcha site key. E.g: score bucket count for a key or number of
   * times the checkbox key failed/ passed etc.,
   *
   * @param projectId: Google Cloud Project Id.
   * @param recaptchaSiteKey: Specify the site key to get metrics.
   */
  public static void getMetrics(String projectId, String recaptchaSiteKey) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the `client.close()` method on the client to safely
    // clean up any remaining background resources.
    try (RecaptchaEnterpriseServiceClient client = RecaptchaEnterpriseServiceClient.create()) {

      GetMetricsRequest getMetricsRequest =
          GetMetricsRequest.newBuilder()
              .setName(MetricsName.of(projectId, recaptchaSiteKey).toString())
              .build();

      Metrics response = client.getMetrics(getMetricsRequest);

      // Retrieve the metrics you want from the key.
      // If the site key is checkbox type: then use response.getChallengeMetricsList() instead of
      // response.getScoreMetricsList()
      for (ScoreMetrics scoreMetrics : response.getScoreMetricsList()) {
        // Each ScoreMetrics is in the granularity of one day.
        int scoreBucketCount = scoreMetrics.getOverallMetrics().getScoreBucketsCount();
        System.out.println(scoreBucketCount);
      }
      System.out.printf("Retrieved the bucket count for score based key: %s", recaptchaSiteKey);
    }
  }
}
// [END recaptcha_enterprise_get_metrics_site_key]
