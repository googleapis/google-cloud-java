/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;

import com.google.cloud.datastore.testing.LocalDatastoreHelper;
import com.google.cloud.grpc.GrpcTransportOptions;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DatastoreTestHttp extends AbstractDatastoreTest {

  private static final LocalDatastoreHelper helper = LocalDatastoreHelper.create(1.0, 9090);

  private static DatastoreOptions options = helper.getOptions();
  private static Datastore datastore = options.getService();

  public DatastoreTestHttp(DatastoreOptions options, Datastore datastore) {
    super(options, datastore);
  }

  @Parameterized.Parameters(name = "data options: {0}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][] {{options, datastore}});
  }

  @BeforeClass
  public static void beforeClass() throws IOException, InterruptedException {
    helper.start();
    options = helper.getGrpcTransportOptions(GrpcTransportOptions.newBuilder().build());
    datastore = options.getService();
  }

  @AfterClass
  public static void afterClass() throws Exception {
    helper.stopDuration(Duration.ofMinutes(1));
  }
}
