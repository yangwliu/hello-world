pipeline {
    agent any

    tools {
        gradle "gradle-local"
    }

    stages {
        stage('clone') {
            steps {
                git url: 'https://github.com/sunming93/hello-world.git'
            }
        }

        stage('Unit test') {
            steps {
                sh 'gradle test -i'
            }
        }

        stage('Build') {
            steps {
                sh 'gradle build -i'
            }
        }

        stage('Build Image') {
            steps {
                script{
                  def dockerPath = tool 'docker-local'
                  env.PATH = "${dockerPath}/bin:${env.PATH}"
                  sh 'docker build -t hello-simple:test .'
                }
            }
        }

        stage('Deploy') {
            steps {
              sh 'docker run -p 8081:8080 hello-simple:test &'
            }
        }
    }
}
