pipeline {
    agent any

    environment {
        dockerHome = tool 'myDocker'
        mavenHome = tool 'myMaven'
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
                        sh "mvn clean compile"
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    def newPath = "${env.dockerHome}/bin:${env.mavenHome}/bin:${env.PATH}"
                    withEnv(["PATH=$newPath"]) {
                        sh "mvn test"
                    }
                }
            }
        }
        stage('Integration Test') {
            steps {
                script {
                    def newPath = "${env.dockerHome}/bin:${env.mavenHome}/bin:${env.PATH}"
                    withEnv(["PATH=$newPath"]) {
                        sh "mvn failsafe:integration-test failsafe:verify"
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
