/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.datastore.it;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.testing.RemoteDatastoreHelper;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.common.truth.Truth;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ITDatastoreTestGrpc extends AbstractITDatastoreTest {
  // setup for default db, grpc transport
  protected static final RemoteDatastoreHelper HELPER_DEFAULT_GRPC =
      RemoteDatastoreHelper.create(GrpcTransportOptions.newBuilder().build());
  private static final DatastoreOptions OPTIONS_DEFAULT_GRPC = HELPER_DEFAULT_GRPC.getOptions();
  private static final Datastore DATASTORE_DEFAULT_GRPC = OPTIONS_DEFAULT_GRPC.getService();

  // setup for custom db, grpc transport
  private static final RemoteDatastoreHelper HELPER_CUSTOM_DB_GRPC =
      RemoteDatastoreHelper.create(CUSTOM_DB_ID, GrpcTransportOptions.newBuilder().build());
  private static final DatastoreOptions OPTIONS_CUSTOM_DB_GRPC = HELPER_CUSTOM_DB_GRPC.getOptions();
  private static final Datastore DATASTORE_CUSTOM_DB_GRPC = OPTIONS_CUSTOM_DB_GRPC.getService();

  public ITDatastoreTestGrpc(DatastoreOptions options, Datastore datastore, String databaseType) {
    super(options, datastore, databaseType);
  }

  @Parameterized.Parameters(name = "database: {2}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {OPTIONS_DEFAULT_GRPC, DATASTORE_DEFAULT_GRPC, "default"},
          {OPTIONS_CUSTOM_DB_GRPC, DATASTORE_CUSTOM_DB_GRPC, CUSTOM_DB_ID},
        });
  }

  @AfterClass
  public static void afterClass() throws Exception {
    HELPER_DEFAULT_GRPC.deleteNamespace();
    HELPER_CUSTOM_DB_GRPC.deleteNamespace();
    DATASTORE_DEFAULT_GRPC.close();
    DATASTORE_CUSTOM_DB_GRPC.close();
    Truth.assertThat(DATASTORE_DEFAULT_GRPC.isClosed()).isTrue();
    Truth.assertThat(DATASTORE_CUSTOM_DB_GRPC.isClosed()).isTrue();
  }
}
