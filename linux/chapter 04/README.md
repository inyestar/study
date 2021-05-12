# chapter 03 서버를 구축하는 데 알아야 할 필수 개념과 명령
* runlevel
  - init 0 : 시스템 레벨을 0(종료)으로 전환
    init 6 : 시스템 레벨을 6(재부팅)으로 전환
  - $ cd /lib/systemd/system
    $ ll runlevel?.target
  - $ ll /etc/systemd/system/default.target

* 마운트
  - 물리적 장치를 시스템 내부의 특정한 위치(디렉토리/파일)에 연결 시키는 것
  - umount : 마운트 해제 명령어

* 사용자
  - /etc/skel의 파일은 사용자가 새로 추가되면 사용자의 홈 디렉토리에 자동으로 복사된다
  
