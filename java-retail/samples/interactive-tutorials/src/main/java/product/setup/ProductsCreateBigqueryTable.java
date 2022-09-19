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

import static setup.SetupCleanup.createBqDataset;
import static setup.SetupCleanup.createBqTable;
import static setup.SetupCleanup.getGson;
import static setup.SetupCleanup.uploadDataToBqTable;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class ProductsCreateBigqueryTable {

  public static void main(String[] args) throws IOException {
    String dataset = "products";
    String validProductsTable = "products";
    String invalidProductsTable = "products_some_invalid";
    String productSchemaFilePath = "src/main/resources/product_schema.json";
    String validProductsSourceFile =
        ProductsCreateBigqueryTable.class.getResource("/products.json").getPath();
    String invalidProductsSourceFile =
        ProductsCreateBigqueryTable.class.getResource("products_some_invalid.json").getPath();

    BufferedReader bufferedReader = new BufferedReader(new FileReader(productSchemaFilePath));
    String jsonToString = bufferedReader.lines().collect(Collectors.joining());
    jsonToString = jsonToString.replace("\"fields\"", "\"subFields\"");
    Field[] fields = getGson().fromJson(jsonToString, Field[].class);
    Schema productSchema = Schema.of(fields);

    createBqDataset(dataset);
    createBqTable(dataset, validProductsTable, productSchema);
    uploadDataToBqTable(dataset, validProductsTable, validProductsSourceFile);
    createBqTable(dataset, invalidProductsTable, productSchema);
    uploadDataToBqTable(dataset, invalidProductsTable, invalidProductsSourceFile);
  }
}
