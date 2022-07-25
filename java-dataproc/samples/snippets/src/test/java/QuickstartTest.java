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

import static java.nio.charset.StandardCharsets.UTF_8;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.dataproc.v1.Cluster;
import com.google.cloud.dataproc.v1.ClusterControllerClient;
import com.google.cloud.dataproc.v1.ClusterControllerSettings;
import com.google.cloud.dataproc.v1.ClusterOperationMetadata;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.testing.junit4.StdOutCaptureRule;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class QuickstartTest {

  private static final String MY_UUID = UUID.randomUUID().toString();
  private static final String REGION = "us-central1";
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String ENDPOINT = String.format("%s-dataproc.googleapis.com:443", REGION);
  private static final String CLUSTER_NAME = String.format("java-qs-test-%s", MY_UUID);
  private static final String BUCKET_NAME = String.format("java-dataproc-qs-test-%s", MY_UUID);
  private static final String JOB_FILE_NAME = "sum.py";
  private static final String JOB_FILE_PATH =
      String.format("gs://%s/%s", BUCKET_NAME, JOB_FILE_NAME);
  private static final String SORT_CODE =
      "import pyspark\n"
          + "sc = pyspark.SparkContext()\n"
          + "rdd = sc.parallelize((1,2,3,4,5))\n"
          + "sum = rdd.reduce(lambda x, y: x + y)\n";

  @Rule public StdOutCaptureRule stdOutCapture = new StdOutCaptureRule();
  private Bucket bucket;
  private Blob blob;

  private static void requireEnv(String varName) {
    assertNotNull(
        String.format("Environment variable '%s' is required to perform these tests.", varName),
        System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnv("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnv("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() {
    Storage storage = StorageOptions.getDefaultInstance().getService();
    bucket = storage.create(BucketInfo.of(BUCKET_NAME));
    blob = bucket.create(JOB_FILE_NAME, SORT_CODE.getBytes(UTF_8), "text/plain");
  }

  @Test
  public void quickstartTest() throws IOException, InterruptedException {
    Quickstart.main(PROJECT_ID, REGION, CLUSTER_NAME, JOB_FILE_PATH);
    String output = stdOutCapture.getCapturedOutputAsUtf8String();

    assertThat(output, CoreMatchers.containsString("Cluster created successfully"));
    assertThat(output, CoreMatchers.containsString("Job finished successfully:"));
    assertThat(output, CoreMatchers.containsString("successfully deleted"));
  }

  @After
  public void teardown() throws IOException, InterruptedException, ExecutionException {
    blob.delete();
    bucket.delete();

    ClusterControllerSettings clusterControllerSettings =
        ClusterControllerSettings.newBuilder().setEndpoint(ENDPOINT).build();

    try (ClusterControllerClient clusterControllerClient =
        ClusterControllerClient.create(clusterControllerSettings)) {
      for (Cluster element :
          clusterControllerClient.listClusters(PROJECT_ID, REGION).iterateAll()) {
        if (element.getClusterName() == CLUSTER_NAME) {
          OperationFuture<Empty, ClusterOperationMetadata> deleteClusterAsyncRequest =
              clusterControllerClient.deleteClusterAsync(PROJECT_ID, REGION, CLUSTER_NAME);
          deleteClusterAsyncRequest.get();
          break;
        }
      }
    }
  }
}
