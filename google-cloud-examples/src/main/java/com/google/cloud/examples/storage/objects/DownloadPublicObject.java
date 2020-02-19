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
package com.google.cloud.examples.storage.objects;

// [START storage_download_public_file]
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.nio.file.Path;

public class DownloadPublicObject {
  public static void downloadPublicObject(
      String bucketName, String publicObjectName, Path destFilePath) {
    // The name of the bucket to access
    // String bucketName = "my-bucket";

    // The name of the remote public file to download
    // String publicObjectName = "publicfile.txt";

    // The path to which the file should be downloaded
    // Path destFilePath = Paths.get("/local/path/to/file.txt");

    // Instantiate an anonymous Google Cloud Storage client, which can only access public files
    Storage storage = StorageOptions.getUnauthenticatedInstance().getService();

    Blob blob = storage.get(BlobId.of(bucketName, publicObjectName));
    blob.downloadTo(destFilePath);

    System.out.println(
        "Downloaded public object "
            + publicObjectName
            + " from bucket name "
            + bucketName
            + " to "
            + destFilePath);
  }
}
// [END storage_download_public_file]
