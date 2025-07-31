pipeline {
    agent any

    environment {
        dockerHome = tool 'myDocker'
        mavenHome = tool 'myMaven'
        // Name of Jenkins credentials for Docker Hub (Username/Password)
        DOCKERHUB_CREDS = 'Dockerhub'
    }

    stages {
        stage('Debug and Setup Path') {
            steps {
                script {
                    def newPath = "${env.dockerHome}/bin:${env.mavenHome}/bin:${env.PATH}"
                    withEnv(["PATH=$newPath"]) {
                        echo "=== Debug Info ==="
                        sh 'echo PATH=$PATH'
                        sh 'mvn --version'
                        sh 'docker --version'
                        sh 'which mvn || echo "mvn not found"'
                        sh 'which docker || echo "docker not found"'
                    }
                }
            }
        }
        stage('Checkout') {
            steps {
                script {
                    def newPath = "${env.dockerHome}/bin:${env.mavenHome}/bin:${env.PATH}"
                    withEnv(["PATH=$newPath"]) {
                        echo "=== Checkout Source Code ==="
                        echo "BUILD_TAG - ${env.BUILD_TAG}"
                        checkout scm
                        sh 'git rev-parse HEAD'
                    }
                }
            }
        }
        stage('Compile') {
            steps {
                script {
                    def newPath = "${env.dockerHome}/bin:${env.mavenHome}/bin:${env.PATH}"
                    withEnv(["PATH=$newPath"]) {
                        sh 'mvn clean compile'
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    def newPath = "${env.dockerHome}/bin:${env.mavenHome}/bin:${env.PATH}"
                    withEnv(["PATH=$newPath"]) {
                        sh 'mvn test'
                    }
                }
            }
        }
        stage('Integration Test') {
            steps {
                script {
                    def newPath = "${env.dockerHome}/bin:${env.mavenHome}/bin:${env.PATH}"
                    withEnv(["PATH=$newPath"]) {
                        sh 'mvn failsafe:integration-test failsafe:verify'
                    }
                }
            }
        }
        stage('Package') {
            steps {
                script {
                    def newPath = "${env.dockerHome}/bin:${env.mavenHome}/bin:${env.PATH}"
                    withEnv(["PATH=$newPath"]) {
                        sh 'mvn package -DskipTests'
                    }
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    // Use build tag for image versioning
                    dockerImage = docker.build("mohan3/curreny-exchnage-devops:${env.BUILD_TAG}")
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    // Log in and push both the tagged and 'latest' images
                    docker.withRegistry('', env.DOCKERHUB_CREDS) {
                        dockerImage.push()
                        dockerImage.push('latest')
                    }
                }
            }
        }
    }

    post {
        success {
            echo "✅ Pipeline completed successfully!"
        }
        failure {
            echo "❌ Pipeline failed. Please check logs."
        }
        always {
            echo "🔁 Pipeline finished."
        }
    }
}
