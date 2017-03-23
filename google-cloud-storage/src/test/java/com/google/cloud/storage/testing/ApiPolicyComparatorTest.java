/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.storage.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.api.services.storage.model.Policy;
import com.google.api.services.storage.model.Policy.Bindings;
import com.google.common.collect.ImmutableList;

public class ApiPolicyComparatorTest {

  private static final String ETAG = "CAE=";

  @Test
  public void testEquivalence() {
    // Intentionally create 2 API policies with different binding and member ordering.
    Policy apiPolicy1 =
        new Policy()
            .setBindings(ImmutableList.of(
                new Bindings()
                    .setMembers(ImmutableList.of("allUsers"))
                    .setRole("roles/storage.objectViewer"),
                new Bindings()
                    .setMembers(
                        ImmutableList.of(
                            "user:test1@gmail.com",
                            "user:test2@gmail.com"))
                    .setRole("roles/storage.objectAdmin"),
                new Bindings()
                    .setMembers(ImmutableList.of("group:test-group@gmail.com"))
                    .setRole("roles/storage.admin")))
            .setEtag(ETAG);
    Policy apiPolicy2 =
        new Policy()
            .setBindings(ImmutableList.of(
                new Bindings()
                    .setMembers(ImmutableList.of("group:test-group@gmail.com"))
                    .setRole("roles/storage.admin"),
                new Bindings()
                    .setMembers(ImmutableList.of("allUsers"))
                    .setRole("roles/storage.objectViewer"),
                new Bindings()
                    .setMembers(
                        ImmutableList.of(
                            "user:test2@gmail.com",
                            "user:test1@gmail.com"))
                    .setRole("roles/storage.objectAdmin")))
            .setEtag(ETAG);

    assertEquals(0, ApiPolicyComparator.INSTANCE.compare(apiPolicy1, apiPolicy2));
  }
}
