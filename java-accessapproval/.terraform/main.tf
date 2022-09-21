terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
    time = {
      source = "hashicorp/time"
    }
  }
}

provider "google" {
  region = var.region
  zone   = var.zone
}

module "project" {
  source          = "./../../.terraform/modules/project"
  folder_id       = var.folder_id
  billing_account = var.billing_account
  region          = var.region
  zone            = var.zone
  project_prefix  = var.project_prefix
}

resource "google_project_service" "accessapproval_api" {
  project            = module.project.project_id
  service            = "accessapproval.googleapis.com"
  disable_on_destroy = false
  depends_on         = [module.project]
}
