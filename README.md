# Spring Boot DevOps Application

A minimal, production-ready Spring Boot application demonstrating modern CI/CD practices and cloud infrastructure as code.

## Overview

This project showcases a complete DevOps pipeline for a Java-based REST API, from local development to automated cloud deployment. It implements industry-standard tools and practices for containerization, continuous integration, and infrastructure provisioning.

## Technologies

**Backend & Framework:**
- Spring Boot 3.5.7 (Java 21)
- REST API with Spring Web

**DevOps & Cloud:**
- Docker containerization
- Jenkins CI/CD pipeline
- Terraform Infrastructure as Code (IaC)
- AWS EC2 deployment

**Build & Dependency Management:**
- Gradle with Kotlin DSL
- Automated testing with JUnit 5

## Architecture

```
Application Code (Spring Boot)
         ↓
  Docker Container
         ↓
  Docker Registry
         ↓
 Jenkins Pipeline → Terraform
         ↓
  AWS EC2 Instance
```

## Features

- **REST API**: Simple data retrieval endpoint (`GET /` returns item list)
- **Containerized**: Docker image runs on Alpine Linux with OpenJDK 21
- **Automated Builds**: Gradle-based build system with JAR packaging
- **CI/CD Pipeline**: Jenkins orchestrates build, containerization, and deployment
- **IaC**: Terraform automates EC2 instance provisioning with security group configuration
- **AWS Integration**: Auto-configures Docker on EC2 instances via user data scripts

## Getting Started

### Build Locally
```bash
./gradlew build
./gradlew bootJar
```

### Docker Build
```bash
docker build -t spring-backend .
docker run -d -p 9090:9090 spring-backend
```

### Access the Application
- Application runs on port **9090**
- Test endpoint: `http://localhost:9090/`

## Project Structure

```
├── src/main/java/com/example/Application/
│   ├── ApplicationNameApplication.java    # Spring Boot entry point
│   └── Controller.java                    # REST controller
├── jenkins/
│   └── Jenkinsfile                       # CI/CD pipeline configuration
├── terraform/
│   ├── main.tf                           # AWS resources (EC2, IAM, Security Groups)
│   ├── variables.tf                      # Configuration variables
│   ├── outputs.tf                        # Output values
│   └── data.tf                           # Data sources
├── Dockerfile                            # Container image definition
└── build.gradle.kts                      # Build configuration
```

## CI/CD Pipeline

The Jenkins pipeline (`Jenkinsfile`) automates:
1. **Checkout**: Clone latest code from repository
2. **Build**: Compile Spring Boot application using Gradle
3. **Containerize**: Build and push Docker image to registry
4. **Deploy**: Provision AWS infrastructure and deploy containerized app

## Infrastructure

Terraform provisions:
- **EC2 Instance** (t3.micro, configurable AMI)
- **IAM Role & Policy** for ECR access
- **Security Groups** with SSH and application port access
- **Key Pair** for secure SSH access
- **Auto-startup** script to pull and run latest Docker image

## Environment Setup

### Prerequisites
- Java 21
- Docker
- Jenkins (for CI/CD)
- Terraform (for IaC)
- AWS credentials configured
