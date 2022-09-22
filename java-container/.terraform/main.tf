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

module "project" {
  source          = "./../../.terraform/modules/project"
  folder_id       = var.folder_id
  billing_account = var.billing_account
  region          = var.region
  zone            = var.zone
  project_prefix  = var.project_prefix
}

resource "google_project_service" "container_api" {
  project            = module.project.project_id
  service            = "container.googleapis.com"
  depends_on         = [module.project]
  disable_on_destroy = false
}
resource "google_project_service" "compute_api" {
  project            = module.project.project_id
  service            = "compute.googleapis.com"
  depends_on         = [module.project]
  disable_on_destroy = false
}
resource "google_compute_network" "java_container_network" {
  name                    = "java-container-network"
  project                 = module.project.project_id
  auto_create_subnetworks = true
  depends_on              = [
    module.project,
    google_project_service.compute_api,
    google_project_service.container_api
  ]
}