/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.NoCredentials;
import com.google.cloud.storage.PostPolicyV4.PostConditionsV4;
import com.google.cloud.storage.PostPolicyV4.PostFieldsV4;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.common.collect.ImmutableList;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.junit.Test;

public final class TransportCompatibilityTest {

  @Test
  public void verifyUnsupportedMethodsGenerateMeaningfulException() {
    GrpcStorageOptions options =
        StorageOptions.grpc()
            .setProjectId("blank")
            .setCredentials(NoCredentials.getInstance())
            .build();
    @SuppressWarnings("resource")
    Storage s =
        new GrpcStorageImpl(
            options, null, null, ResponseContentLifecycleManager.noop(), null, null, Opts.empty());
    ImmutableList<String> messages =
        Stream.<Supplier<?>>of(
                s::batch,
                () -> s.writer(null),
                () -> s.signUrl(null, 0, null),
                () -> s.generateSignedPostPolicyV4(null, 0, null, null, null, null),
                () -> s.generateSignedPostPolicyV4(null, 0, null, (PostFieldsV4) null),
                () -> s.generateSignedPostPolicyV4(null, 0, null, (PostConditionsV4) null),
                () -> s.generateSignedPostPolicyV4(null, 0, null))
            .map(
                sup -> {
                  try {
                    sup.get();
                    return null;
                  } catch (UnsupportedOperationException e) {
                    return e.getMessage();
                  }
                })
            .collect(ImmutableList.toImmutableList());

    for (String message : messages) {
      assertThat(message).contains("only supported for " + Transport.HTTP);
      assertThat(message)
          .contains("Please use StorageOptions.http() to construct a compatible instance");
    }
  }
}
