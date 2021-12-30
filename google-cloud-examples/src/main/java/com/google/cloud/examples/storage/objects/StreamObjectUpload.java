package com.google.cloud.examples.storage.objects;

import com.google.cloud.WriteChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class StreamObjectUpload {
  public static void streamObjectUpload(
      String projectId, String bucketName, String objectName, String contents) throws IOException {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    // The string of contents you wish to upload
    // String contents = "Hello world!";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    BlobId blobId = BlobId.of(bucketName, objectName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
    byte[] content = contents.getBytes(StandardCharsets.UTF_8);
    try (WriteChannel writer = storage.writer(blobInfo)) {
      writer.write(ByteBuffer.wrap(content));
      System.out.println(
          "Wrote to " + objectName + " in bucket " + bucketName + " using a WriteChannel.");
    }
  }
}
