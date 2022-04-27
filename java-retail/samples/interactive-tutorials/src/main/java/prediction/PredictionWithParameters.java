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

/*
 * [START retail_prediction_get_prediction_with_params]
 * Call Retail API to get predictions from Recommendation AI using parameters.
 */

package prediction;

import com.google.cloud.retail.v2.PredictRequest;
import com.google.cloud.retail.v2.PredictResponse;
import com.google.cloud.retail.v2.PredictionServiceClient;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.ProductDetail;
import com.google.cloud.retail.v2.UserEvent;
import com.google.protobuf.Value;
import java.io.IOException;

public class PredictionWithParameters {

  public static void main(String[] args) {
    String projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
    String placementId = System.getenv("GOOGLE_CLOUD_PLACEMENT");
    String predictPlacement =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/placements/%s",
            projectId, placementId);

    predict(predictPlacement);
  }

  public static void predict(String predictPlacement) {
    try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
      PredictResponse predictResponse =
          predictionServiceClient.predict(getPredictRequest(predictPlacement));
      System.out.printf("Predict response: %n%s", predictResponse);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static PredictRequest getPredictRequest(String predictPlacement) {
    // create product object
    Product product =
        Product.newBuilder()
            .setId("55106") // Id of real product
            .build();

    // create product detail object
    ProductDetail productDetail = ProductDetail.newBuilder().setProduct(product).build();

    // create user event object
    UserEvent userEvent =
        UserEvent.newBuilder()
            .setEventType("detail-page-view")
            .setVisitorId("281790") // Unique identifier to track visitors
            .addProductDetails(productDetail)
            .build();

    PredictRequest predictRequest =
        PredictRequest.newBuilder()
            .setPlacement(predictPlacement) // Placement is used to identify the Serving Config name
            .setUserEvent(userEvent) // Context about the user is required for event logging
            // TRY TO ADD/UPDATE PARAMETERS `priceRerankLevel` OR `diversityLevel` HERE:
            .putParams(
                "priceRerankLevel",
                Value.newBuilder().setStringValue("low-price-reranking").build())
            .build();
    System.out.printf("Predict request: %n%s", predictRequest);

    return predictRequest;
  }
}

// [END retail_prediction_get_prediction_with_params]
