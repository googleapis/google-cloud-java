/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2;

import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import java.io.IOException;

/**
 * Modern Cloud Bigtable Instance Admin Client.
 *
 * <p>This client extends the {@link BaseBigtableInstanceAdminClient} to provide a simplified and
 * enhanced API surface for managing Cloud Bigtable instances and clusters.
 */
public class BigtableInstanceAdminClientV2 extends BaseBigtableInstanceAdminClient {

  protected BigtableInstanceAdminClientV2(BaseBigtableInstanceAdminSettings settings)
      throws IOException {
    super(settings);
  }

  protected BigtableInstanceAdminClientV2(BigtableInstanceAdminStub stub) {
    super(stub);
  }

  /** Constructs an instance of BigtableInstanceAdminClientV2 with the given settings. */
  public static final BigtableInstanceAdminClientV2 create(
      BaseBigtableInstanceAdminSettings settings) throws IOException {
    return new BigtableInstanceAdminClientV2(settings);
  }

  /** Constructs an instance of BigtableInstanceAdminClientV2 with the given stub. */
  public static final BigtableInstanceAdminClientV2 create(BigtableInstanceAdminStub stub) {
    return new BigtableInstanceAdminClientV2(stub);
  }
}
