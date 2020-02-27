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

// [START storage_define_bucket_website_configuration]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class SetBucketWebsiteInfo {
  public static void setBucketWesbiteInfo(
      String projectId, String bucketName, String indexPage, String notFoundPage) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your static website bucket
    // String bucketName = "www.example.com";

    // The index page for a static website bucket
    // String indexPage = "index.html";

    // The 404 page for a static website bucket
    // String notFoundPage = "404.html";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);
    bucket.toBuilder().setIndexPage(indexPage).setNotFoundPage(notFoundPage).build().update();

    System.out.println(
        "Static website bucket "
            + bucketName
            + " is set up to use "
            + indexPage
            + " as the index page and "
            + notFoundPage
            + " as the 404 page");
  }
}
// [END storage_define_bucket_website_configuration]
