/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package aiplatform;

// [START aiplatform_delete_export_model_sample]

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class DeleteExportModelSample {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String bucketName = "YOUR_BUCKET_NAME";
    String folderName = "YOUR_FOLDER_NAME";
    deleteExportModelSample(project, bucketName, folderName);
  }

  static void deleteExportModelSample(String project, String bucketName, String folderName) {
    Storage storage = StorageOptions.newBuilder().setProjectId(project).build().getService();
    Iterable<Blob> blobs =
        storage.list(bucketName, Storage.BlobListOption.prefix(folderName)).iterateAll();
    for (Blob blob : blobs) {
      blob.delete(Blob.BlobSourceOption.generationMatch());
    }
    System.out.println("Export Model Deleted");
  }
}
// [END aiplatform_delete_export_model_sample]
