/*
 * Copyright 2023 Google LLC
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

package com.example.bigquery;

// [START bigquery_query_array_structs_params_named]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.TableResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryWithArrayOfStructsNamedParameters {

  public static void main(String[] args) {
    queryWithArrayOfStructsNamedParameters();
  }

  public static void queryWithArrayOfStructsNamedParameters() {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      Map<String, QueryParameterValue> structMap = new HashMap<>();
      structMap.put("stringField", QueryParameterValue.string("test-stringField"));
      QueryParameterValue structQueryParam = QueryParameterValue.struct(structMap);
      List<QueryParameterValue> arrayOfStructs = new ArrayList<>();
      arrayOfStructs.add(structQueryParam);

      String query = "SELECT (@arrayOfStructField) AS record";
      QueryJobConfiguration queryConfig =
          QueryJobConfiguration.newBuilder(query)
              .setUseLegacySql(false)
              .addNamedParameter(
                  "arrayOfStructField",
                  QueryParameterValue.array(arrayOfStructs.toArray(), StandardSQLTypeName.STRING))
              .build();
      TableResult results = bigquery.query(queryConfig);
      results
          .iterateAll()
          .forEach(row -> row.forEach(val -> System.out.printf("%s", val.toString())));
      System.out.println("Query with Array of struct parameters performed successfully.");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Query not performed \n" + e.toString());
    }
  }
}
// [END bigquery_query_array_structs_params_named]
