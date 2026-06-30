/*
 * Copyright 2025 Google LLC
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

package com.example.storage.object;

// [START storage_pause_and_resume_appendable_object_upload]

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobAppendableUpload;
import com.google.cloud.storage.BlobAppendableUpload.AppendableUploadWriteableByteChannel;
import com.google.cloud.storage.BlobAppendableUploadConfig;
import com.google.cloud.storage.BlobAppendableUploadConfig.CloseAction;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageChannelUtils;
import com.google.cloud.storage.StorageOptions;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Locale;

public class PauseAndResumeAppendableObjectUpload {
  public static void pauseAndResumeAppendableObjectUpload(
      String bucketName, String objectName, String filePath) throws Exception {
    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    // The path to the file to upload
    // String filePath = "path/to/your/file";

    try (Storage storage = StorageOptions.grpc().build().getService()) {
      BlobId blobId = BlobId.of(bucketName, objectName);
      BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

      // --- Step 1: Initial string write (PAUSE) ---
      // Default close action will be CLOSE_WITHOUT_FINALIZING
      BlobAppendableUploadConfig initialConfig = BlobAppendableUploadConfig.of();
      BlobAppendableUpload initialUploadSession =
          storage.blobAppendableUpload(blobInfo, initialConfig);

      try (AppendableUploadWriteableByteChannel channel = initialUploadSession.open()) {
        String initialData = "Initial data segment.\n";
        ByteBuffer buffer = ByteBuffer.wrap(initialData.getBytes(StandardCharsets.UTF_8));
        long totalBytesWritten = StorageChannelUtils.blockingEmptyTo(buffer, channel);
        channel.flush();

        System.out.printf(
            Locale.US, "Wrote %d bytes (initial string) in first segment.\n", totalBytesWritten);
      } catch (IOException ex) {
        throw new IOException("Failed initial upload to object " + blobId.toGsUtilUri(), ex);
      }

      Blob existingBlob = storage.get(blobId);
      long currentObjectSize = existingBlob.getSize();
      System.out.printf(
          Locale.US,
          "Initial upload paused. Currently uploaded size: %d bytes\n",
          currentObjectSize);

      // --- Step 2: Resume upload with file content and finalize ---
      // Use FINALIZE_WHEN_CLOSING to ensure the object is finalized on channel closure.
      BlobAppendableUploadConfig resumeConfig =
          BlobAppendableUploadConfig.of().withCloseAction(CloseAction.FINALIZE_WHEN_CLOSING);
      BlobAppendableUpload resumeUploadSession =
          storage.blobAppendableUpload(existingBlob.toBuilder().build(), resumeConfig);

      try (FileChannel fileChannel = FileChannel.open(Paths.get(filePath));
          AppendableUploadWriteableByteChannel channel = resumeUploadSession.open()) {
        long bytesToAppend = fileChannel.size();
        System.out.printf(
            Locale.US,
            "Appending the entire file (%d bytes) after the initial string.\n",
            bytesToAppend);

        ByteStreams.copy(fileChannel, channel);
      }

      BlobInfo result = storage.get(blobId);
      System.out.printf(
          Locale.US,
          "\nObject %s successfully resumed and finalized. Total size: %d bytes\n",
          result.getBlobId().toGsUtilUriWithGeneration(),
          result.getSize());
    }
  }
}
// [END storage_pause_and_resume_appendable_object_upload]
