/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage.it;

import static org.junit.Assume.assumeTrue;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.TestUtils;
import com.google.cloud.storage.it.ITStorageOptionsTest.CredentialsParameters;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.Parameterized;
import com.google.cloud.storage.it.runner.annotations.Parameterized.Parameter;
import com.google.cloud.storage.it.runner.annotations.Parameterized.ParametersProvider;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@SingleBackend(Backend.PROD)
@Parameterized(CredentialsParameters.class)
public final class ITStorageOptionsTest {

  public static final class CredentialsParameters implements ParametersProvider {

    @Override
    public ImmutableList<?> parameters() {
      return ImmutableList.of(
          NoCredentials.getInstance(),
          GoogleCredentials.create(/* accessToken= */ null),
          OAuth2Credentials.create(null));
    }
  }

  @Parameter public Credentials credentials;

  @Test
  public void clientShouldConstructCleanly_http() throws Exception {
    StorageOptions options = StorageOptions.http().setCredentials(credentials).build();
    doTest(options);
  }

  @Test
  public void clientShouldConstructCleanly_grpc() throws Exception {
    StorageOptions options =
        StorageOptions.grpc()
            .setCredentials(credentials)
            .setAttemptDirectPath(false)
            .setEnableGrpcClientMetrics(false)
            .build();
    doTest(options);
  }

  @Test
  public void clientShouldConstructCleanly_directPath() throws Exception {
    assumeTrue(
        "Unable to determine environment can access directPath", TestUtils.isOnComputeEngine());
    StorageOptions options =
        StorageOptions.grpc()
            .setCredentials(credentials)
            .setAttemptDirectPath(true)
            .setEnableGrpcClientMetrics(false)
            .build();
    doTest(options);
  }

  @Test
  public void lackOfProjectIdDoesNotPreventConstruction_http() throws Exception {
    StorageOptions options = StorageOptions.http().setCredentials(credentials).build();
    doTest(options);
  }

  @Test
  public void lackOfProjectIdDoesNotPreventConstruction_grpc() throws Exception {
    StorageOptions options =
        StorageOptions.grpc()
            .setCredentials(credentials)
            .setAttemptDirectPath(false)
            .setEnableGrpcClientMetrics(false)
            .build();
    doTest(options);
  }

  private static void doTest(StorageOptions options) throws Exception {
    //noinspection EmptyTryBlock
    try (Storage ignore = options.getService()) {}
  }
}
