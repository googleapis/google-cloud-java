/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.DaiAuthenticationKeyServiceClient.ListDaiAuthenticationKeysPagedResponse;

import com.google.ads.admanager.v1.BatchActivateDaiAuthenticationKeysRequest;
import com.google.ads.admanager.v1.BatchActivateDaiAuthenticationKeysResponse;
import com.google.ads.admanager.v1.BatchCreateDaiAuthenticationKeysRequest;
import com.google.ads.admanager.v1.BatchCreateDaiAuthenticationKeysResponse;
import com.google.ads.admanager.v1.BatchDeactivateDaiAuthenticationKeysRequest;
import com.google.ads.admanager.v1.BatchDeactivateDaiAuthenticationKeysResponse;
import com.google.ads.admanager.v1.BatchUpdateDaiAuthenticationKeysRequest;
import com.google.ads.admanager.v1.BatchUpdateDaiAuthenticationKeysResponse;
import com.google.ads.admanager.v1.CreateDaiAuthenticationKeyRequest;
import com.google.ads.admanager.v1.DaiAuthenticationKey;
import com.google.ads.admanager.v1.GetDaiAuthenticationKeyRequest;
import com.google.ads.admanager.v1.ListDaiAuthenticationKeysRequest;
import com.google.ads.admanager.v1.ListDaiAuthenticationKeysResponse;
import com.google.ads.admanager.v1.UpdateDaiAuthenticationKeyRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DaiAuthenticationKeyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class DaiAuthenticationKeyServiceStub implements BackgroundResource {

  public UnaryCallable<GetDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      getDaiAuthenticationKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: getDaiAuthenticationKeyCallable()");
  }

  public UnaryCallable<ListDaiAuthenticationKeysRequest, ListDaiAuthenticationKeysPagedResponse>
      listDaiAuthenticationKeysPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDaiAuthenticationKeysPagedCallable()");
  }

  public UnaryCallable<ListDaiAuthenticationKeysRequest, ListDaiAuthenticationKeysResponse>
      listDaiAuthenticationKeysCallable() {
    throw new UnsupportedOperationException("Not implemented: listDaiAuthenticationKeysCallable()");
  }

  public UnaryCallable<CreateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      createDaiAuthenticationKeyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDaiAuthenticationKeyCallable()");
  }

  public UnaryCallable<
          BatchCreateDaiAuthenticationKeysRequest, BatchCreateDaiAuthenticationKeysResponse>
      batchCreateDaiAuthenticationKeysCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateDaiAuthenticationKeysCallable()");
  }

  public UnaryCallable<UpdateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      updateDaiAuthenticationKeyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateDaiAuthenticationKeyCallable()");
  }

  public UnaryCallable<
          BatchUpdateDaiAuthenticationKeysRequest, BatchUpdateDaiAuthenticationKeysResponse>
      batchUpdateDaiAuthenticationKeysCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateDaiAuthenticationKeysCallable()");
  }

  public UnaryCallable<
          BatchActivateDaiAuthenticationKeysRequest, BatchActivateDaiAuthenticationKeysResponse>
      batchActivateDaiAuthenticationKeysCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchActivateDaiAuthenticationKeysCallable()");
  }

  public UnaryCallable<
          BatchDeactivateDaiAuthenticationKeysRequest, BatchDeactivateDaiAuthenticationKeysResponse>
      batchDeactivateDaiAuthenticationKeysCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeactivateDaiAuthenticationKeysCallable()");
  }

  @Override
  public abstract void close();
}
