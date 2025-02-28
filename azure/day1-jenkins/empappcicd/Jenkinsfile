pipeline {
    agent any

    tools{
        maven "localmvn"
    }

    environment{
           APP_NAME = "empappcicd"
           RELEASE_NO= "1.0.0"
           DOCKER_USER= "rahul471"
           IMAGE_NAME= "${DOCKER_USER}"+"/"+"${APP_NAME}"
           IMAGE_TAG= "${RELEASE_NO}-${BUILD_NUMBER}"
    }

    stages {
          stage("SCM checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/RahulKalekar/empappcicd.git']])
            }
        }

        stage("Build Process"){
            steps{
                script{
                    bat 'mvn clean install'
                }
            }
        }

        stage("Build Image"){
            steps{
                script{
                    bat 'docker build -t rahul471/empappcicd:1.1 .'
                }
            }
        }
        stage("Deploy Image to Hub"){
            steps{
                withCredentials([string(credentialsId: 'dockerHubPassword', variable: 'docker')]) {
                                    bat "echo ${docker} | docker login -u ${DOCKER_USER} --password-stdin"
                                    bat 'docker push rahul471/empappcicd:1.1'
                }
            }
        }
    }
}

