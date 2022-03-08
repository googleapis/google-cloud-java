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

package product.setup;

import static setup.SetupCleanup.createBucket;
import static setup.SetupCleanup.uploadObject;

import java.io.IOException;

public class ProductsCreateGcsBucket {

  private static final String BUCKET_NAME = System.getenv("BUCKET_NAME");

  public static String getBucketName() {
    return BUCKET_NAME;
  }

  public static void productsCreateGcsBucketAndUploadJsonFiles() throws IOException {
    createBucket(BUCKET_NAME);
    uploadObject(BUCKET_NAME, "products.json", "src/main/resources/products.json");
    uploadObject(
        BUCKET_NAME, "products_some_invalid.json", "src/main/resources/products_some_invalid.json");
  }
}
