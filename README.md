# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 기능 요구사항
* [x] 하나의 야구공 생성
  * [x] 각 야구공은 하나의 숫자를 갖는다.
    * [x] 야구공의 숫자는 1 이상 9 이하의 숫자여야 한다.
    * [x] 숫자가 해당 범위를 벗어난 값이라면 예외가 발생한다.
  * [x] 각 야구공은 하나의 위치 값을 갖는다.
    * [x] 야구공의 위치 값은 1이상 3 이하의 숫자여야 한다.
    * [x] 위치 값이 해당 범위를 벗어난 값이라면 예외가 발생한다.


* [x] 하나의 야구공 묶음 생성
  * [x] 하나의 묶음은 3개의 야구공을 갖는다.
  * [x] 묶음 생성 시 야구공의 숫자가 3개가 아니라면 예외가 발생한다.


* [x] 야구공의 상태 판별 (1:1, 야구공 대 야구공)
  * [x] 같은 숫자가 같은 위치에 있으면 스트라이크
  * [x] 같은 숫자지만 다른 위치에 있으면 볼
  * [x] 같은 숫자가 없으면 포볼 또는 낫싱


* [x] 야구공의 상태 판별 (1:3, 야구공 대 야구공 묶음)
  * [x] 야구공 묶음 중 전달한 야구공의 숫자와 위치가 같은 야구공이 존재하면 스트라이크
  * [x] 야구공 묶음 중 전달한 야구공의 숫자와 일치하지만 위치가 다른 야구공이 존재하면 볼
  * [x] 야구공 묶음 중 전달한 야구공과 숫자가 일치한 야구공이 존재하지 않으면 낫싱


* [ ] 야구 게임 결과 생성
  * [x] 야구공을 비교한 결과에 따라 스트라이크, 볼의 개수를 계산한다. 
  * [ ] 야구 게임의 결과로 다음과 같은 경우들이 발생할 수 있다.
    * [x] 1스트라이크
    * [ ] 1스트라이크 1볼
    * [ ] 1스트라이크 2볼
    * [ ] 2스트라이크
    * [ ] 3스트라이크
    * [ ] 1볼
    * [ ] 2볼
    * [ ] 3볼
    * [ ] 낫싱


* [ ] 게임 진행
  * [ ] 컴퓨터는 새로운 게임을 시작할 때마다 3개의 숫자를 선택한다.
  * [ ] 사용자는 컴퓨터가 선택한 숫자를 예상하여 3개의 숫자를 입력한다.
    * [ ] 사용자가 입력한 값이 유효하지 않으면 예외가 발생한다.
  * [ ] 컴퓨터의 숫자와 사용자가 입력한 숫자를 비교하여 결과를 출력한다.
    * [ ] 사용자가 정답을 입력한 경우, 게임이 종료된다.
    * [ ] 컴퓨터는 사용자에게 선택을 입력받는다.
      * [ ] 사용자가 1을 입력하면 새로운 게임을 시작한다.
      * [ ] 사용자가 2를 입력하면 게임을 완전히 종료한다.
      * [ ] 사용자가 1 또는 2가 아닌 값을 입력하면 예외가 발생한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
