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

package com.google.cloud.discoveryengine.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest;
import com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest;
import com.google.cloud.discoveryengine.v1.WidgetConfig;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the WidgetConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class WidgetConfigServiceStub implements BackgroundResource {

  public UnaryCallable<GetWidgetConfigRequest, WidgetConfig> getWidgetConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getWidgetConfigCallable()");
  }

  public UnaryCallable<UpdateWidgetConfigRequest, WidgetConfig> updateWidgetConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWidgetConfigCallable()");
  }

  @Override
  public abstract void close();
}
