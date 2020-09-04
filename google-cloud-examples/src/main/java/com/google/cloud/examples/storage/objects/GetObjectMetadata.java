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

// [START storage_get_metadata]
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import java.util.Date;
import java.util.Map;

public class GetObjectMetadata {
  public static void getObjectMetadata(String projectId, String bucketName, String blobName)
      throws StorageException {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    // Select all fields
    // Fields can be selected individually e.g. Storage.BlobField.CACHE_CONTROL
    Blob blob =
        storage.get(bucketName, blobName, Storage.BlobGetOption.fields(Storage.BlobField.values()));

    // Print blob metadata
    System.out.println("Bucket: " + blob.getBucket());
    System.out.println("CacheControl: " + blob.getCacheControl());
    System.out.println("ComponentCount: " + blob.getComponentCount());
    System.out.println("ContentDisposition: " + blob.getContentDisposition());
    System.out.println("ContentEncoding: " + blob.getContentEncoding());
    System.out.println("ContentLanguage: " + blob.getContentLanguage());
    System.out.println("ContentType: " + blob.getContentType());
    System.out.println("CustomTime: " + blob.getCustomTime());
    System.out.println("Crc32c: " + blob.getCrc32c());
    System.out.println("Crc32cHexString: " + blob.getCrc32cToHexString());
    System.out.println("ETag: " + blob.getEtag());
    System.out.println("Generation: " + blob.getGeneration());
    System.out.println("Id: " + blob.getBlobId());
    System.out.println("KmsKeyName: " + blob.getKmsKeyName());
    System.out.println("Md5Hash: " + blob.getMd5());
    System.out.println("Md5HexString: " + blob.getMd5ToHexString());
    System.out.println("MediaLink: " + blob.getMediaLink());
    System.out.println("Metageneration: " + blob.getMetageneration());
    System.out.println("Name: " + blob.getName());
    System.out.println("Size: " + blob.getSize());
    System.out.println("StorageClass: " + blob.getStorageClass());
    System.out.println("TimeCreated: " + new Date(blob.getCreateTime()));
    System.out.println("Last Metadata Update: " + new Date(blob.getUpdateTime()));
    Boolean temporaryHoldIsEnabled = (blob.getTemporaryHold() != null && blob.getTemporaryHold());
    System.out.println("temporaryHold: " + (temporaryHoldIsEnabled ? "enabled" : "disabled"));
    Boolean eventBasedHoldIsEnabled =
        (blob.getEventBasedHold() != null && blob.getEventBasedHold());
    System.out.println("eventBasedHold: " + (eventBasedHoldIsEnabled ? "enabled" : "disabled"));
    if (blob.getRetentionExpirationTime() != null) {
      System.out.println("retentionExpirationTime: " + new Date(blob.getRetentionExpirationTime()));
    }
    if (blob.getMetadata() != null) {
      System.out.println("\n\n\nUser metadata:");
      for (Map.Entry<String, String> userMetadata : blob.getMetadata().entrySet()) {
        System.out.println(userMetadata.getKey() + "=" + userMetadata.getValue());
      }
    }
  }
}
// [END storage_get_metadata]
