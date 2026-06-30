/*
 * Copyright 2017 Google LLC
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

import static org.junit.Assert.assertEquals;

import com.google.api.services.storage.model.Policy.Bindings;
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class PolicyHelperTest {

  private static final String ETAG = "CAE=";

  @Test
  public void testEquivalence() {
    Policy libPolicy =
        Policy.newBuilder()
            .addIdentity(StorageRoles.objectViewer(), Identity.allUsers())
            .addIdentity(
                StorageRoles.objectAdmin(),
                Identity.user("test1@gmail.com"),
                Identity.user("test2@gmail.com"))
            .setEtag(ETAG)
            .setVersion(1)
            .build();
    com.google.api.services.storage.model.Policy apiPolicy =
        new com.google.api.services.storage.model.Policy()
            .setBindings(
                ImmutableList.of(
                    new Bindings()
                        .setMembers(ImmutableList.of("allUsers"))
                        .setRole("roles/storage.objectViewer"),
                    new Bindings()
                        .setMembers(
                            ImmutableList.of("user:test1@gmail.com", "user:test2@gmail.com"))
                        .setRole("roles/storage.objectAdmin")))
            .setEtag(ETAG)
            .setVersion(1);

    Policy actualLibPolicy = Conversions.json().policyCodec().decode(apiPolicy);

    assertEquals(libPolicy, actualLibPolicy);
  }

  @Test
  public void testApiPolicyWithoutBinding() {
    List<Bindings> bindings = null;
    com.google.api.services.storage.model.Policy apiPolicy =
        new com.google.api.services.storage.model.Policy()
            .setBindings(bindings)
            .setEtag(ETAG)
            .setVersion(1);
    Policy policy = Conversions.json().policyCodec().decode(apiPolicy);
    assertEquals(policy.getBindings().size(), 0);
  }
}
