terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}
resource "google_project_service" "iam" {
  service            = "iam.googleapis.com"
  project            = var.inputs.project_id
  count              = var.inputs.should_enable_apis_on_apply ? 1 : 0
  disable_on_destroy = var.inputs.should_disable_apis_on_destroy
}
resource "random_id" "id" {
  byte_length = 3
}
locals {
  service_account_id = lower("service-account-id-${random_id.id.hex}")
}
resource "google_service_account" "service_account" {
  account_id   = local.service_account_id
  display_name = "Service Account"
  depends_on   = [google_project_service.iam]
}
