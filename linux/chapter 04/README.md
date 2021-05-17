# chapter 04 서버를 구축하는 데 알아야 할 필수 개념과 명령
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

* arch
  - i386, i486, i856, i686 : 인텔/AMD 32bit CPU
  - x86_64 : 인텔/MAD 64 bit CPUT
  - noarch : 모든  CPU에 설치할 수 있다는 뜻

* command
  - which : PATH에 설정된 디렉토리만 검색, 절대 경로를 포함한 위치 검색
  - run-parts : 디렉토리 안의 내용을 모두 실행

* 네트워크
  - /etc/resolv.conf 파일은 수정 후 네트워크를 재 시작할 필요 없음

* grub
  - 부트 정보 변경 가능
  - 멀티 부팅 가능
  - 대화형 설정 제공

* grub2
  - shell script 사용 가능
  - /boot/grub2/grub.cfg 파일은 직접 변경하지 않고 grub2-mkconfig 명령어를 통해 변경해야 한다.

* 모듈
  - 하드웨어 관리 소스
  - 커널에 포함될 수도 있고 필요에 따라 사용될 수도 있음
