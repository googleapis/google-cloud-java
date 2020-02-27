package com.google.cloud.examples.storage.objects;

import com.google.cloud.WriteChannel;
import com.google.cloud.storage.BlobInfo;

import java.io.IOException;
import java.nio.ByteBuffer;

import static java.nio.charset.StandardCharsets.UTF_8;

public class StreamUploads {
    public static void streamUploads(String bucketName, String blobName) throws IOException {
        // [START storage_stream_upload]
        BlobInfo blobInfo = BlobInfo.newBuilder("bucket-name", "object-name").build();

        byte[] content = "newline!".getBytes(UTF_8);
        try (WriteChannel writer = storage.writer(blobInfo)) {
            try {
                for (int i = 0; i < 10; ++i) {
                    writer.write(ByteBuffer.wrap(content, 0, content.length));
                }
            } catch (Exception ex) {
                // handle exception
            }
        }
        // [END storage_stream_upload]
    }
}
