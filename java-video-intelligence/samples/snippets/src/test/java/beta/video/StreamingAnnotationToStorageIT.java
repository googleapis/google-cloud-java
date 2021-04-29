/*
 * Copyright 2019 Google LLC
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

package beta.video;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.StorageOptions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link StreamingAnnotationToStorage}. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class StreamingAnnotationToStorageIT {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String OUTPUT_PREFIX = "VIDEO_STREAMING_TEST_OUTPUT";

  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testStreamingAnnotationToStorage() throws IOException, TimeoutException {
    String gcsUri = String.format("gs://%s/%s", PROJECT_ID, OUTPUT_PREFIX);
    StreamingAnnotationToStorage.streamingAnnotationToStorage("resources/cat.mp4", gcsUri);
    String got = bout.toString();

    assertThat(got).contains(String.format("Storage Uri: %s", gcsUri));

    Storage storage = StorageOptions.getDefaultInstance().getService();

    Page<Blob> blobs =
        storage.list(
            PROJECT_ID,
            BlobListOption.currentDirectory(),
            BlobListOption.prefix(OUTPUT_PREFIX + "/"));

    deleteDirectory(storage, blobs);
  }

  private void deleteDirectory(Storage storage, Page<Blob> blobs) {
    for (Blob blob : blobs.iterateAll()) {
      System.out.println(blob.getName());
      if (!blob.delete()) {
        Page<Blob> subBlobs =
            storage.list(
                PROJECT_ID,
                BlobListOption.currentDirectory(),
                BlobListOption.prefix(blob.getName()));

        deleteDirectory(storage, subBlobs);
      }
    }
  }
}
