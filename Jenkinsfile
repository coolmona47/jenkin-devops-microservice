pipeline {
    agent {
        docker {
            image 'maven:3.6.3'
     
        }
    }

    stages {
        stage('Build') {
            steps {
         
                sh 'mvn --version'
                echo "build"
         
            }
        }

        stage('Test') {
            steps {
                echo "Tests"
        
            }
        }

        stage('Integration Test') {
            steps {
                echo "🔗 Running Integration Tests..."
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
