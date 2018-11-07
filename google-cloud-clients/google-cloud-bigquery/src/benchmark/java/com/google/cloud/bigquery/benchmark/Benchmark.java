/*
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.benchmark;

import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;
import java.io.FileInputStream;
import java.util.List;
import org.threeten.bp.Clock;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;

public class Benchmark {

  private static final double NS_PER_SECOND = 1000 * 1000 * 1000;

  private Benchmark() {}

  public static void main(String[] args) throws Exception {
    if (args.length < 1) {
      System.out.println("need path to queries.json");
      return;
    }
    String[] requests =
        new JacksonFactory()
            .createJsonParser(new FileInputStream(args[0]))
            .parseAndClose(String[].class);

    Clock clock = Clock.systemUTC();
    BigQuery bq = BigQueryOptions.getDefaultInstance().getService();

    for (String request : requests) {
      if (request.isEmpty()) {
        continue;
      }

      Instant start = clock.instant();
      TableResult result =
          bq.query(QueryJobConfiguration.newBuilder(request).setUseLegacySql(false).build());

      int rows = 0;
      int cols = 0;
      Duration firstByte = null;
      for (List<FieldValue> row : result.iterateAll()) {
        rows++;
        if (cols == 0) {
          cols = row.size();
          firstByte = Duration.between(start, clock.instant());
        } else if (cols != row.size()) {
          throw new IllegalStateException(
              String.format("expected %d cols, found %d", cols, row.size()));
        }
      }
      Duration total = Duration.between(start, clock.instant());

      assert firstByte != null;
      double firstByteSec = (double) (firstByte.getNano()) / NS_PER_SECOND + firstByte.getSeconds();
      double totalSec = (double) (total.getNano()) / NS_PER_SECOND + total.getSeconds();

      System.out.println(
          String.format(
              "query \"%s\": read %d rows, %d cols, first byte %f sec, total %f sec",
              request, rows, cols, firstByteSec, totalSec));
    }
  }
}
