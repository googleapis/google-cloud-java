/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.accounts.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.CheckoutSettings;
import com.google.shopping.merchant.accounts.v1.CreateCheckoutSettingsRequest;
import com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest;
import com.google.shopping.merchant.accounts.v1.GetCheckoutSettingsRequest;
import com.google.shopping.merchant.accounts.v1.UpdateCheckoutSettingsRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CheckoutSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CheckoutSettingsServiceStub implements BackgroundResource {

  public UnaryCallable<GetCheckoutSettingsRequest, CheckoutSettings> getCheckoutSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getCheckoutSettingsCallable()");
  }

  public UnaryCallable<CreateCheckoutSettingsRequest, CheckoutSettings>
      createCheckoutSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: createCheckoutSettingsCallable()");
  }

  public UnaryCallable<UpdateCheckoutSettingsRequest, CheckoutSettings>
      updateCheckoutSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCheckoutSettingsCallable()");
  }

  public UnaryCallable<DeleteCheckoutSettingsRequest, Empty> deleteCheckoutSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCheckoutSettingsCallable()");
  }

  @Override
  public abstract void close();
}
