terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "random_id" "id" {
  byte_length = 3
}

locals {
  service_account_id = lower("service-account-id-${random_id.id.hex}")
}
resource "google_project_service" "iam_api" {
  service            = "iam.googleapis.com"
  disable_on_destroy = false
}
resource "google_service_account" "service_account" {
  account_id   = local.service_account_id
  display_name = "Service Account"
  depends_on   = [google_project_service.iam_api]
}
