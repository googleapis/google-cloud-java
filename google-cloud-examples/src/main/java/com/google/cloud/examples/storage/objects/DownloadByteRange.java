/*
 * Copyright 2021 Google LLC
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

// [START storage_download_byte_range]
import com.google.cloud.ReadChannel;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class DownloadByteRange {
  public static void downloadByteRange(
      String projectId,
      String bucketName,
      String objectName,
      int firstByte,
      int lastByte,
      String destFilePath)
      throws IOException {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    // The byte at which to begin download
    // int firstByte = 0;

    // The byte at which to end the download
    // int lastByte = 20;

    // The path to which the file should be downloaded
    // String destFilePath = "/local/path/to/file.txt";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    ReadChannel reader = storage.reader(bucketName, objectName);
    reader.seek(firstByte);
    ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
    File file = new File(destFilePath);
    FileChannel channel = new FileOutputStream(file, true).getChannel();
    int bytesRead;
    int totalBytesRead = 0;
    int totalBytesWritten = 0;
    final int length = lastByte - firstByte;
    while ((bytesRead = reader.read(bytes)) > 0) {
      bytes.flip();
      totalBytesRead += bytesRead;
      if (totalBytesRead < length) {
        channel.write(bytes);
        totalBytesWritten = totalBytesRead;
      } else {
        byte[] slice = Arrays.copyOfRange(bytes.array(), 0, length - totalBytesWritten);
        channel.write(ByteBuffer.wrap(slice));
      }
      bytes.clear();
    }

    System.out.println(
        "Downloaded bytes "
            + firstByte
            + " to "
            + lastByte
            + " of object "
            + objectName
            + " from bucket name "
            + bucketName
            + " to "
            + destFilePath);
  }
}
// [END storage_download_byte_range]
