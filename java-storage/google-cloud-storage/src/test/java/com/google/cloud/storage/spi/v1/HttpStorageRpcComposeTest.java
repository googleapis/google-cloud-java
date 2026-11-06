/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.storage.spi.v1;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.NoCredentials;
import com.google.cloud.TransportOptions;
import com.google.cloud.Tuple;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.spi.v1.StorageRpc.Option;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public final class HttpStorageRpcComposeTest {

  private static final String BUCKET = "test-bucket";

  @Test
  public void compose_forwardsPredefinedAcl() throws Exception {
    String url = composeAndCaptureUrl(ImmutableMap.of(Option.PREDEFINED_ACL, "publicRead"));

    assertThat(url).contains("destinationPredefinedAcl=publicRead");
  }

  @Test
  public void compose_withoutPredefinedAclSendsNone() throws Exception {
    String url = composeAndCaptureUrl(ImmutableMap.of());

    assertThat(url).doesNotContain("destinationPredefinedAcl");
  }

  private String composeAndCaptureUrl(Map<Option, ?> targetOptions) throws Exception {
    MockLowLevelHttpResponse response =
        new MockLowLevelHttpResponse()
            .setContentType("application/json")
            .setContent("{\"bucket\":\"" + BUCKET + "\",\"name\":\"destination\"}")
            .setStatusCode(200);
    AuditingHttpTransport transport = new AuditingHttpTransport(response);
    TransportOptions transportOptions =
        HttpTransportOptions.newBuilder().setHttpTransportFactory(() -> transport).build();
    StorageOptions options =
        StorageOptions.getDefaultInstance().toBuilder()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setTransportOptions(transportOptions)
            .build();

    StorageObject source = new StorageObject().setBucket(BUCKET).setName("source");
    StorageObject target = new StorageObject().setBucket(BUCKET).setName("destination");
    new HttpStorageRpc(options).compose(ImmutableList.of(source), target, targetOptions);

    List<Tuple<String, String>> calls = transport.getBuildRequestCalls();
    assertThat(calls).hasSize(1);
    return calls.get(0).y();
  }
}
