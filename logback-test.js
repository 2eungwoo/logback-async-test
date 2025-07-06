import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
  vus: 100,           // 동시에 실행할 가상 사용자 수
  duration: '10s',    // 테스트 지속 시간
};

export default function () {
  let res = http.get('http://localhost:8080');

  check(res, {
    'status is 200': (r) => r.status === 200,
  });

  sleep(1);
}