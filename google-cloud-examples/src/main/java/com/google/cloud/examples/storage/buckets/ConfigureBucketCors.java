/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.examples.storage.buckets;

// [START storage_cors_configuration]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Cors;
import com.google.cloud.storage.HttpMethod;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.ImmutableList;

public class ConfigureBucketCors {
  public static void configureBucketCors(
      String projectId,
      String bucketName,
      String origin,
      String responseHeader,
      Integer maxAgeSeconds) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The origin for this CORS config to allow requests from
    // String origin = "http://example.appspot.com";

    // The response header to share across origins
    // String responseHeader = "Content-Type";

    // The maximum amount of time the browser can make requests before it must repeat preflighted
    // requests
    // Integer maxAgeSeconds = 3600;

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);

    // See the HttpMethod documentation for other HTTP methods available:
    // https://cloud.google.com/appengine/docs/standard/java/javadoc/com/google/appengine/api/urlfetch/HTTPMethod
    HttpMethod method = HttpMethod.GET;

    Cors cors =
        Cors.newBuilder()
            .setOrigins(ImmutableList.of(Cors.Origin.of(origin)))
            .setMethods(ImmutableList.of(method))
            .setResponseHeaders(ImmutableList.of(responseHeader))
            .setMaxAgeSeconds(maxAgeSeconds)
            .build();

    bucket.toBuilder().setCors(ImmutableList.of(cors)).build().update();

    System.out.println(
        "Bucket "
            + bucketName
            + " was updated with a CORS config to allow GET requests from "
            + origin
            + " sharing "
            + responseHeader
            + " responses across origins");
  }
}
// [END storage_cors_configuration]
