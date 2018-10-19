/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.emulator.v2;

import com.google.api.core.BetaApi;
import io.grpc.ManagedChannel;
import org.junit.rules.ExternalResource;

@BetaApi("Surface for Bigtable emulator is not yet stable")
public class BigtableEmulatorRule extends ExternalResource {
  private Emulator emulator;

  public static BigtableEmulatorRule create() {
    return new BigtableEmulatorRule();
  }

  BigtableEmulatorRule() { }

  @Override
  protected void before() throws Throwable {
    emulator = Emulator.createBundled();
    emulator.start();
  }

  @Override
  protected void after() {
    emulator.stop();
    emulator = null;
  }

  public ManagedChannel getDataChannel() {
    return emulator.getDataChannel();
  }

  public ManagedChannel getAdminChannel() {
    return emulator.getAdminChannel();
  }

  public int getPort() {
    return emulator.getPort();
  }
}
