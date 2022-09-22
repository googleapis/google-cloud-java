terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

provider "google" {
  region = var.region
  zone   = var.zone
}

resource "random_id" "id" {
  byte_length = 3
  keepers     = {
    folder_id       = var.folder_id
    billing_account = var.billing_account
  }
}

locals {
  project_id = lower("${var.project_prefix}-${random_id.id.hex}")
}

resource "google_project" "project" {
  name            = local.project_id
  project_id      = local.project_id
  folder_id       = random_id.id.keepers.folder_id
  billing_account = random_id.id.keepers.billing_account
}
