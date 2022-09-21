variable "project_prefix" {
  type        = string
  description = "Prefix to use when creating the GCP project"
}

variable "folder_id" {
  type        = string
  description = "GCP folder ID in which to create the project"
  sensitive   = true
}

variable "billing_account" {
  type        = string
  description = "GCP Billing Account ID for the test project"
  sensitive   = true
}

variable "region" {
  type        = string
  description = "GCP region to deploy resources to."
  default     = "us-central1"
}

variable "zone" {
  type        = string
  description = "GCP zone to deploy resources to. Must be a zone in the chosen region."
  default     = "us-central1-c"
}