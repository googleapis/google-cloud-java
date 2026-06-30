/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storage.it.runner.registry;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.common.base.Suppliers;
import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.function.Supplier;

final class MetadataService {

  private static final Supplier<HttpRequestFactory> requestFactory =
      Suppliers.memoize(
          () ->
              new NetHttpTransport.Builder()
                  .build()
                  .createRequestFactory(
                      request -> {
                        request.setCurlLoggingEnabled(false);
                        request.getHeaders().set("Metadata-Flavor", "Google");
                      }));
  private static final String baseUri = "http://metadata.google.internal";

  public static void main(String[] args) throws IOException {
    System.out.println("zone() = " + zone());
  }

  public static Optional<Zone> zone() throws IOException {
    return get("/computeMetadata/v1/instance/zone").map(Zone::parse);
  }

  public static Optional<String> get(String path) throws IOException {
    GenericUrl url = new GenericUrl(baseUri + path);
    try {
      HttpRequest req = requestFactory.get().buildGetRequest(url);
      HttpResponse resp = req.execute();
      try (InputStream content = resp.getContent();
          Reader r = new InputStreamReader(content)) {
        return CharStreams.readLines(r).stream().findFirst();
      }
    } catch (HttpResponseException | UnknownHostException e) {
      return Optional.empty();
    }
  }
}
