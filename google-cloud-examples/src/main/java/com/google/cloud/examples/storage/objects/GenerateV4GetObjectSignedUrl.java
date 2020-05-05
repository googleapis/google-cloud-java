/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.examples.storage.objects;

// [START storage_generate_signed_url_v4]
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GenerateV4GetObjectSignedUrl {
  /**
   * Signing a URL requires Credentials which implement ServiceAccountSigner. These can be set
   * explicitly using the Storage.SignUrlOption.signWith(ServiceAccountSigner) option. If you don't,
   * you could also pass a service account signer to StorageOptions, i.e.
   * StorageOptions().newBuilder().setCredentials(ServiceAccountSignerCredentials). In this example,
   * neither of these options are used, which means the following code only works when the
   * credentials are defined via the environment variable GOOGLE_APPLICATION_CREDENTIALS, and those
   * credentials are authorized to sign a URL. See the documentation for Storage.signUrl for more
   * details.
   */
  public static void generateV4GetObjectSignedUrl(
      String projectId, String bucketName, String objectName) throws StorageException {
    // String projectId = "my-project-id";
    // String bucketName = "my-bucket";
    // String objectName = "my-object";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    // Define resource
    BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(bucketName, objectName)).build();

    URL url =
        storage.signUrl(blobInfo, 15, TimeUnit.MINUTES, Storage.SignUrlOption.withV4Signature());

    System.out.println("Generated GET signed URL:");
    System.out.println(url);
    System.out.println("You can use this URL with any user agent, for example:");
    System.out.println("curl '" + url + "'");
  }
}
// [END storage_generate_signed_url_v4]
