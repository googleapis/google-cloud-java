/*
 * Copyright 2023 Google LLC
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

package com.google.shopping.css.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.css.v1.CssProductInput;
import com.google.shopping.css.v1.DeleteCssProductInputRequest;
import com.google.shopping.css.v1.InsertCssProductInputRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CssProductInputsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CssProductInputsServiceStub implements BackgroundResource {

  public UnaryCallable<InsertCssProductInputRequest, CssProductInput>
      insertCssProductInputCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCssProductInputCallable()");
  }

  public UnaryCallable<DeleteCssProductInputRequest, Empty> deleteCssProductInputCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCssProductInputCallable()");
  }

  @Override
  public abstract void close();
}
