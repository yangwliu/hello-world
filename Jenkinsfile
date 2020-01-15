pipeline {
    agent any

    tools {
        gradle "gradle5.3"
    }

    stages {
        stage('clone') {
            steps {
                git credentialsId: '2ff0a5e3-a090-4615-a2b7-f86b6e4191a4', url: 'git@github.com:dingtongwang/hello-world.git'
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
                  def dockerPath = tool 'docker18.09.4'
                  env.PATH = "${dockerPath}/bin:${env.PATH}"
                  sh 'docker build -t hello-simple:test .'
                }
            }
        }

        stage('Deploy') {
            steps {
              sh 'docker run -p 8081:8080 hello-simple:test'
            }
        }
    }
}