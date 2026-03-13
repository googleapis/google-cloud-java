// Copyright 2021 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.composer.common;

import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.gapic.composer.utils.ClassNames;
import com.google.api.generator.gapic.model.Transport;
import com.google.auto.value.AutoValue;
import java.util.List;
import javax.annotation.Nullable;

@AutoValue
public abstract class TransportContext {

  public abstract ClassNames classNames();

  // For AbstractServiceStubClassComposer
  public abstract Transport transport();

  public abstract List<String> transportNames();

  @Nullable
  public abstract Class<?> callSettingsClass();

  @Nullable
  public abstract TypeNode stubCallableFactoryType();

  @Nullable
  public abstract Class<?> methodDescriptorClass();

  public abstract List<TypeNode> transportOperationsStubTypes();

  public abstract List<String> transportOperationsStubNames();

  // For AbstractServiceSettingsClassComposer
  public abstract List<Class<?>> instantiatingChannelProviderClasses();

  public abstract List<Class<?>> instantiatingChannelProviderBuilderClasses();

  public abstract List<String> defaultTransportProviderBuilderNames();

  public abstract List<String> transportApiClientHeaderProviderBuilderNames();

  // For AbstractServiceStubSettingsClassComposer
  public abstract List<TypeNode> transportChannelTypes();

  public abstract List<String> transportGetterNames();

  // For AbstractServiceCallableFactoryClassComposer
  @Nullable
  public abstract TypeNode transportCallSettingsType();

  @Nullable
  public abstract TypeNode transportCallableFactoryType();

  public abstract List<TypeNode> operationsStubTypes();

  @Nullable
  public abstract String transportCallSettingsName();

  // For RetrySettingsComposer
  public abstract TypeNode operationResponseTransformerType();

  public abstract TypeNode operationMetadataTransformerType();

  public abstract List<TypeNode> operationsClientTypes();

  public abstract List<String> operationsClientNames();

  public abstract boolean useValuePatterns();

  protected static TypeNode classToType(Class<?> clazz) {
    return TypeNode.withReference(ConcreteReference.withClazz(clazz));
  }

  public static TransportContext.Builder builder() {
    return new AutoValue_TransportContext.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder setClassNames(ClassNames value);

    public abstract Builder setTransport(Transport transport);

    public abstract Builder setTransportNames(List<String> values);

    public abstract Builder setCallSettingsClass(Class<?> callSettingsClass);

    public abstract Builder setStubCallableFactoryType(TypeNode stubCallableFactoryType);

    public abstract Builder setMethodDescriptorClass(Class<?> methodDescriptorClass);

    public abstract Builder setInstantiatingChannelProviderClasses(
        List<Class<?>> instantiatingChannelProviderClasses);

    public abstract Builder setInstantiatingChannelProviderBuilderClasses(
        List<Class<?>> instantiatingChannelProviderBuilderClasses);

    public abstract Builder setDefaultTransportProviderBuilderNames(
        List<String> defaultTransportProviderBuilderNames);

    public abstract Builder setTransportApiClientHeaderProviderBuilderNames(
        List<String> transportApiClientHeaderProviderBuilderNames);

    public abstract Builder setTransportChannelTypes(List<TypeNode> transportChannelTypes);

    public abstract Builder setTransportGetterNames(List<String> transportGetterNames);

    public abstract Builder setTransportCallSettingsType(TypeNode transportCallSettingsType);

    public abstract Builder setTransportCallableFactoryType(TypeNode transportCallableFactoryType);

    public abstract Builder setTransportCallSettingsName(String transportCallSettingsName);

    public abstract Builder setTransportOperationsStubTypes(
        List<TypeNode> transportOperationsStubTypes);

    public abstract Builder setTransportOperationsStubNames(
        List<String> transportOperationsStubNames);

    public abstract Builder setOperationsStubTypes(List<TypeNode> operationsStubType);

    public abstract Builder setOperationResponseTransformerType(
        TypeNode operationResponseTransformerType);

    public abstract Builder setOperationMetadataTransformerType(
        TypeNode operationMetadataTransformerType);

    public abstract Builder setOperationsClientTypes(List<TypeNode> operationsClientTypes);

    public abstract Builder setOperationsClientNames(List<String> operationsClientNames);

    public abstract Builder setUseValuePatterns(boolean useValuePatterns);

    public abstract TransportContext build();
  }
}
