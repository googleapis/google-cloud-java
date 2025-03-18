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

package com.google.cloud.modelarmor.v1.stub;

import static com.google.cloud.modelarmor.v1.ModelArmorClient.ListLocationsPagedResponse;
import static com.google.cloud.modelarmor.v1.ModelArmorClient.ListTemplatesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.modelarmor.v1.CreateTemplateRequest;
import com.google.cloud.modelarmor.v1.DeleteTemplateRequest;
import com.google.cloud.modelarmor.v1.FloorSetting;
import com.google.cloud.modelarmor.v1.GetFloorSettingRequest;
import com.google.cloud.modelarmor.v1.GetTemplateRequest;
import com.google.cloud.modelarmor.v1.ListTemplatesRequest;
import com.google.cloud.modelarmor.v1.ListTemplatesResponse;
import com.google.cloud.modelarmor.v1.SanitizeModelResponseRequest;
import com.google.cloud.modelarmor.v1.SanitizeModelResponseResponse;
import com.google.cloud.modelarmor.v1.SanitizeUserPromptRequest;
import com.google.cloud.modelarmor.v1.SanitizeUserPromptResponse;
import com.google.cloud.modelarmor.v1.Template;
import com.google.cloud.modelarmor.v1.UpdateFloorSettingRequest;
import com.google.cloud.modelarmor.v1.UpdateTemplateRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ModelArmor service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ModelArmorStub implements BackgroundResource {

  public UnaryCallable<ListTemplatesRequest, ListTemplatesPagedResponse>
      listTemplatesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTemplatesPagedCallable()");
  }

  public UnaryCallable<ListTemplatesRequest, ListTemplatesResponse> listTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTemplatesCallable()");
  }

  public UnaryCallable<GetTemplateRequest, Template> getTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getTemplateCallable()");
  }

  public UnaryCallable<CreateTemplateRequest, Template> createTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: createTemplateCallable()");
  }

  public UnaryCallable<UpdateTemplateRequest, Template> updateTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTemplateCallable()");
  }

  public UnaryCallable<DeleteTemplateRequest, Empty> deleteTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTemplateCallable()");
  }

  public UnaryCallable<GetFloorSettingRequest, FloorSetting> getFloorSettingCallable() {
    throw new UnsupportedOperationException("Not implemented: getFloorSettingCallable()");
  }

  public UnaryCallable<UpdateFloorSettingRequest, FloorSetting> updateFloorSettingCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFloorSettingCallable()");
  }

  public UnaryCallable<SanitizeUserPromptRequest, SanitizeUserPromptResponse>
      sanitizeUserPromptCallable() {
    throw new UnsupportedOperationException("Not implemented: sanitizeUserPromptCallable()");
  }

  public UnaryCallable<SanitizeModelResponseRequest, SanitizeModelResponseResponse>
      sanitizeModelResponseCallable() {
    throw new UnsupportedOperationException("Not implemented: sanitizeModelResponseCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
