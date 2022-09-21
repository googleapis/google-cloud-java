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
}


resource "google_project_service" "sqladmin_api" {
  project            = module.project.project_id
  service            = "sqladmin.googleapis.com"
  depends_on         = [module.project]
  disable_on_destroy = false
}
resource "google_project_service" "bigquery_connection_api" {
  project            = module.project.project_id
  service            = "bigqueryconnection.googleapis.com"
  depends_on         = [module.project]
  disable_on_destroy = false
}
resource "google_project_service" "bigquery_api" {
  project            = module.project.project_id
  service            = "bigquery.googleapis.com"
  depends_on         = [module.project]
  disable_on_destroy = false
}

locals {
  db_name = "mysql-db"
}

module "mysql-db" {
  source              = "GoogleCloudPlatform/sql-db/google//modules/mysql"
  version             = "12.0.0"
  name                = local.db_name
  database_version    = "MYSQL_8_0"
  deletion_protection = false

  zone       = var.zone
  project_id = module.project.project_id
  depends_on = [module.project]
}
