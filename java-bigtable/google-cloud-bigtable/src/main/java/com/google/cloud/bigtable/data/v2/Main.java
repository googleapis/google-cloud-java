/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2;

import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.TableId;

public class Main {

  public static void main(String[] args) throws Exception {
    try (BigtableDataClient client =
        BigtableDataClient.create("google.com:cloud-bigtable-dev", "mattiefu-test")) {

      for (int i = 0; i < 100; i++) {
        Row row = client.readRow(TableId.of("benchmark"), "key-0");

        System.out.println(row.getKey());

        Thread.sleep(10000);
      }
    }
  }
}
