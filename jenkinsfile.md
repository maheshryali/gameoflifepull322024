node {
    stage('buildanapplication') {
        branch: 'master'
        git https://github.com/maheshryali/game-of-life.git 
        }
}
#
