/*
 * Copyright 2025 Google LLC
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
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/shopping/merchant/products/v1beta/productinputs.proto

// Protobuf Java Version: 3.25.8
package com.google.shopping.merchant.products.v1beta;

public final class ProductInputsProto {
  private ProductInputsProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_shopping_merchant_products_v1beta_ProductInput_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_shopping_merchant_products_v1beta_ProductInput_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_shopping_merchant_products_v1beta_InsertProductInputRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_shopping_merchant_products_v1beta_InsertProductInputRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_shopping_merchant_products_v1beta_UpdateProductInputRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_shopping_merchant_products_v1beta_UpdateProductInputRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_shopping_merchant_products_v1beta_DeleteProductInputRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_shopping_merchant_products_v1beta_DeleteProductInputRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n"
          + "<google/shopping/merchant/products/v1beta/productinputs.proto\022(google.shopping."
          + "merchant.products.v1beta\032\034google/api/ann"
          + "otations.proto\032\027google/api/client.proto\032"
          + "\037google/api/field_behavior.proto\032\031google"
          + "/api/resource.proto\032\033google/protobuf/empty.proto\032"
          + " google/protobuf/field_mask.pro"
          + "to\032>google/shopping/merchant/products/v1beta/products_common.proto\032"
          + " google/shopping/type/types.proto\"\232\004\n"
          + "\014ProductInput\022\021\n"
          + "\004name\030\001 \001(\tB\003\340A\010\022\024\n"
          + "\007product\030\002 \001(\tB\003\340A\003\022?\n"
          + "\007channel\030\003"
          + " \001(\0162).google.shopping.type.Channel.ChannelEnumB\003\340A\005\022\030\n"
          + "\010offer_id\030\004 \001(\tB\006\340A\002\340A\005\022 \n"
          + "\020content_language\030\005 \001(\tB\006\340A\002\340A\005\022\032\n\n"
          + "feed_label\030\006 \001(\tB\006\340A\002\340A\005\022#\n"
          + "\016version_number\030\007 \001(\003B\006\340A\001\340A\005H\000\210\001\001\022M\n\n"
          + "attributes\030\010"
          + " \001(\01324.google.shopping.merchant.products.v1beta.AttributesB\003\340A\001\022E\n"
          + "\021custom_attributes\030\t"
          + " \003(\0132%.google.shopping.type.CustomAttributeB\003\340A\001:z\352Aw\n"
          + "\'merchantapi.goo"
          + "gleapis.com/ProductInput\022/accounts/{account}/productInputs/{productinput}*\r"
          + "productInputs2\014productInputB\021\n"
          + "\017_version_number\"\305\001\n"
          + "\031InsertProductInputRequest\022:\n"
          + "\006parent\030\001 \001("
          + "\tB*\340A\002\372A$\022\"merchantapi.googleapis.com/Product\022R\n\r"
          + "product_input\030\002 \001(\01326.goo"
          + "gle.shopping.merchant.products.v1beta.ProductInputB\003\340A\002\022\030\n"
          + "\013data_source\030\003 \001(\tB\003\340A\002\"\277\001\n"
          + "\031UpdateProductInputRequest\022R\n\r"
          + "product_input\030\001"
          + " \001(\01326.google.shopping.merchant.products.v1beta.ProductInputB\003\340A\002\0224\n"
          + "\013update_mask\030\002"
          + " \001(\0132\032.google.protobuf.FieldMaskB\003\340A\001\022\030\n"
          + "\013data_source\030\003 \001(\tB\003\340A\002\"t\n"
          + "\031DeleteProductInputRequest\022=\n"
          + "\004name\030\001 \001(\tB/\340A\002\372A)\n"
          + "\'merchantapi.googleapis.com/ProductInput\022\030\n"
          + "\013data_source\030\002 \001(\tB\003\340A\0022\205\006\n"
          + "\024ProductInputsService\022\343\001\n"
          + "\022InsertProductInput\022C.google.shopping.merchant.products.v1"
          + "beta.InsertProductInputRequest\0326.google.shopping.merchant.products.v1beta.Produc"
          + "tInput\"P\202\323\344\223\002J\"9/products/v1beta/{parent=accounts/*}/productInputs:insert:\r"
          + "product_input\022\206\002\n"
          + "\022UpdateProductInput\022C.google.shopping.merchant.products.v1beta.Updat"
          + "eProductInputRequest\0326.google.shopping.m"
          + "erchant.products.v1beta.ProductInput\"s\332A"
          + "\031product_input,update_mask\202\323\344\223\002Q2@/produ"
          + "cts/v1beta/{product_input.name=accounts/*/productInputs/*}:\r"
          + "product_input\022\264\001\n"
          + "\022DeleteProductInput\022C.google.shopping.merch"
          + "ant.products.v1beta.DeleteProductInputRe"
          + "quest\032\026.google.protobuf.Empty\"A\332A\004name\202\323"
          + "\344\223\0024*2/products/v1beta/{name=accounts/*/"
          + "productInputs/*}\032G\312A\032merchantapi.googlea"
          + "pis.com\322A\'https://www.googleapis.com/auth/contentB\224\001\n"
          + ",com.google.shopping.merchant.products.v1betaB\022ProductInputsProtoP\001"
          + "ZNcloud.google.com/go/shopping/merchant/products/apiv1beta/productspb;productspb"
          + "b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.AnnotationsProto.getDescriptor(),
              com.google.api.ClientProto.getDescriptor(),
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
              com.google.protobuf.EmptyProto.getDescriptor(),
              com.google.protobuf.FieldMaskProto.getDescriptor(),
              com.google.shopping.merchant.products.v1beta.ProductsCommonProto.getDescriptor(),
              com.google.shopping.type.TypesProto.getDescriptor(),
            });
    internal_static_google_shopping_merchant_products_v1beta_ProductInput_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_shopping_merchant_products_v1beta_ProductInput_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_shopping_merchant_products_v1beta_ProductInput_descriptor,
            new java.lang.String[] {
              "Name",
              "Product",
              "Channel",
              "OfferId",
              "ContentLanguage",
              "FeedLabel",
              "VersionNumber",
              "Attributes",
              "CustomAttributes",
            });
    internal_static_google_shopping_merchant_products_v1beta_InsertProductInputRequest_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_shopping_merchant_products_v1beta_InsertProductInputRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_shopping_merchant_products_v1beta_InsertProductInputRequest_descriptor,
            new java.lang.String[] {
              "Parent", "ProductInput", "DataSource",
            });
    internal_static_google_shopping_merchant_products_v1beta_UpdateProductInputRequest_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_shopping_merchant_products_v1beta_UpdateProductInputRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_shopping_merchant_products_v1beta_UpdateProductInputRequest_descriptor,
            new java.lang.String[] {
              "ProductInput", "UpdateMask", "DataSource",
            });
    internal_static_google_shopping_merchant_products_v1beta_DeleteProductInputRequest_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_shopping_merchant_products_v1beta_DeleteProductInputRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_shopping_merchant_products_v1beta_DeleteProductInputRequest_descriptor,
            new java.lang.String[] {
              "Name", "DataSource",
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    registry.add(com.google.api.ClientProto.oauthScopes);
    registry.add(com.google.api.ResourceProto.resource);
    registry.add(com.google.api.ResourceProto.resourceReference);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.protobuf.EmptyProto.getDescriptor();
    com.google.protobuf.FieldMaskProto.getDescriptor();
    com.google.shopping.merchant.products.v1beta.ProductsCommonProto.getDescriptor();
    com.google.shopping.type.TypesProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
