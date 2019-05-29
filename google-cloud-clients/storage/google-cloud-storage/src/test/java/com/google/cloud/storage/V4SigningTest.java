/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.storage;

import static org.junit.Assert.assertEquals;

import com.google.api.core.ApiClock;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.Test;

public class V4SigningTest {

  private static class FakeClock implements ApiClock {
    private final AtomicLong currentNanoTime;

    public FakeClock(long initialNanoTime) {
      this.currentNanoTime = new AtomicLong(initialNanoTime);
    }

    public long nanoTime() {
      return this.currentNanoTime.get();
    }

    public long millisTime() {
      return TimeUnit.MILLISECONDS.convert(this.nanoTime(), TimeUnit.NANOSECONDS);
    }
  }

  public class TestCase {
    String description;
    String bucket;
    String object;
    String method;
    String expiration;
    String timestamp;
    String expectedUrl;
    JsonObject headers;

    public String toString() {
      return description;
    }
  }

  @Test
  public void testV4UrlSigning() throws Exception {
    Storage storage =
        RemoteStorageHelper.create()
            .getOptions()
            .toBuilder()
            .setCredentials(
                ServiceAccountCredentials.fromStream(
                    getClass().getResourceAsStream("/UrlSignerV4TestAccount.json")))
            .build()
            .getService();
    Gson gson = new GsonBuilder().create();

    String testCaseJson =
        CharStreams.toString(
            new InputStreamReader(getClass().getResourceAsStream("/UrlSignerV4TestData.json")));

    JsonArray testCases = gson.fromJson(testCaseJson, JsonArray.class);

    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd'T'hhmmss'Z'");
    format.setTimeZone(TimeZone.getTimeZone("UTC"));

    for (JsonElement testCaseElement : testCases) {
      TestCase testCase = gson.fromJson(testCaseElement, TestCase.class);

      storage =
          storage
              .getOptions()
              .toBuilder()
              .setClock(
                  new FakeClock(
                      TimeUnit.NANOSECONDS.convert(
                          format.parse(testCase.timestamp).getTime(), TimeUnit.MILLISECONDS)))
              .build()
              .getService();

      BlobInfo blob = BlobInfo.newBuilder(testCase.bucket, testCase.object).build();

      Map<String, String> headers = new HashMap<>();
      if (testCase.headers != null) {
        for (Map.Entry<String, JsonElement> entry : testCase.headers.entrySet()) {
          headers.put(entry.getKey(), entry.getValue().getAsString());
        }
      }

      assertEquals(
          testCase.expectedUrl,
          storage
              .signUrl(
                  blob,
                  Long.valueOf(testCase.expiration),
                  TimeUnit.SECONDS,
                  Storage.SignUrlOption.httpMethod(HttpMethod.valueOf(testCase.method)),
                  Storage.SignUrlOption.withExtHeaders(headers),
                  Storage.SignUrlOption.withV4Signature())
              .toString());
    }
  }
}
