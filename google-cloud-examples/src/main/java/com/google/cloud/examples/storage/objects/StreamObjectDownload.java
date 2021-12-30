package com.google.cloud.examples.storage.objects;

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class StreamObjectDownload {
  public static void streamObjectDownload(
      String projectId, String bucketName, String objectName, String targetFile)
      throws IOException {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    // The path to the file to download the object to
    // String targetFile = "path/to/your/file";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    try (ReadChannel reader = storage.reader(BlobId.of(bucketName, objectName))) {
      ByteBuffer buffer = ByteBuffer.allocate(64 * 1024);
      while (reader.read(buffer) > 0) {
        buffer.flip();
        output.write(buffer.array(), 0, buffer.limit());
        buffer.clear();
      }
      output.writeTo(new FileOutputStream(targetFile));

      System.out.println(
          "Downloaded object "
              + objectName
              + " from bucket "
              + bucketName
              + " to "
              + targetFile
              + " using a ReadChannel.");
    }
  }
}
