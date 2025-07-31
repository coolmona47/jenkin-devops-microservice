pipeline {
    agent any

    stages {
        stage('Check Docker Version') {
            steps {
                echo "Checking Docker version..."
                sh 'docker --version'
            }
        }

        stage('List Running Containers') {
            steps {
                echo "Listing running Docker containers..."
                sh 'docker ps'
            }
        }
    }

    post {
        success {
            echo "✅ Docker is working inside Jenkins!"
        }
        failure {
            echo "❌ Docker is NOT working inside Jenkins. Check error logs above."
        }
        always {
            echo "🔁 Docker check completed."
        }
    }
}
