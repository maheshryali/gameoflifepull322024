node {
    stage('buildanapplication') {
        git https://github.com/maheshryali/game-of-life.git 
        branch : 'master'
    }
}