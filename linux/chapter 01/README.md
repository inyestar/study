# chapter 01 실습 환경 구축
* 가상 머신
  - 멀티 부팅 : 한 대의 물리적 컴퓨터에 하나 이상의 OS가 설치되어 있으나 한 번에 하나의 OS만 구동할 수 있다.
  - 가상 머신 : OS를 구동하는 데 필요한 하드웨어적 기능을 제공하며 한 대의 물리적 컴퓨터에 여러 개의 가상 머신을 구동할 수 있다.
  - 가상화 : 가상의 무언가를 만드는 것으로 hypervisor(SW)가 하드웨어의 리소스를 각 가상 머신에 분배하여 사용할 수 있도록 만들어주는 기술이다.

* 네트워크 타입
  - NAT : 라우팅 장치를 통과할 때 IP 헤더에 있는 네트워크 주소를 변경하여 IP 주소를 다른 IP에 맵핑하는 방법이다.
  - HOST ONLY : 호스트 컴퓨터와 가상 머신 간에 네트워크 연결을 제공한다.
  - Bridged : 여러 개의 네트워크나 세그먼트로부터 단일 통합 네트워크를 생성한다. 여러 개의 네트워크가 분리된 상태에서 독립적으로 커뮤니케이션 하도록 만들어주는 라우팅과는 다르게 브릿징은 두 개의 분리된 네트워크를 하나의 네트워크 인것처럼 연결한다.

* 네트워크 설정
  - IP 주소 : (인터넷 프로토콜을 사용하기 위한) 네트워크에 연결된 장치에 부여된 숫자 라벨이다.
  - 서브넷 마스크 : 서브넷은 하나의 네트워크를 두 개 혹은 그 이상의 네트워크로 나누는 방법으로, 서브넷 마스크는 IP 주소에 AND 비트연산자를 적용할 때 라우팅 접두사를 생성하는 비트 마스크이다.
  - 게이트웨이 : 네트워크와 장치간에 상호 운용성을 제공한다. 프로토콜 전송 게이트웨이나 맵핑 게이트웨이를 의미하는 네트워크 게이트웨이의 경우 다른 프로토콜을 가진 네트워크와 연결할 수 있도록 프로토콜 변환을 수행할 수도 있다. IP 네트워크에서 지정된 서브넷 마스크 밖으로 향하는 패킷은 네트워크로 게이트 웨이로 보내진다. 

* 출처
  - [Multi Booting](https://en.wikipedia.org/wiki/Multi-booting)
  - [Virtual Machine](https://en.wikipedia.org/wiki/Virtual_machine)
  - [Virtualization](https://www.redhat.com/en/topics/virtualization/what-is-virtualization)
  - [Network Address Translation](https://en.wikipedia.org/wiki/Network_address_translation)
  - [Host Only Networking](https://www.vmware.com/support/ws5/doc/ws_net_configurations_hostonly.html)
  - [Network Bridge](https://en.wikipedia.org/wiki/Bridging_(networking))
  - [IP Address](https://en.wikipedia.org/wiki/IP_address)
  - [Subnetwork](https://en.wikipedia.org/wiki/Subnetwork)
  - [Gateway](https://en.wikipedia.org/wiki/Gateway_(telecommunications))
